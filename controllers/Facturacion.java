package controllers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import models.Clients;
import models.Factura;
import models.Pedido;
import models.Producto;
import models.IvaDetails;
import models.NotaCredito;
import utils.*;

/**
 * Facturacion
 */
public class Facturacion {

    private void checkInPedidos (List<Pedido> pedidos){

        Iterator<Pedido> pedidoIterator = pedidos.iterator();
        //Iterate through Pedidos
        while(pedidoIterator.hasNext()){
            BigDecimal totalBrutoPedido = new BigDecimal("0");
            Pedido pedido = pedidoIterator.next();

            //Itarete through list of pedidos in order to obtain total bruto pedido for each pedido
            for (Producto producto : pedido.getDetalles()) {
                totalBrutoPedido= totalBrutoPedido.add(producto.getPrecio());                
            }

            //Once obtained show it on screen and ask for confirmation
            Scanner input = new Scanner(System.in);
            String confirmation;            

            System.out.println("El monto total bruto para el actual pedido es de " + totalBrutoPedido);
            System.out.print("El monto total bruto es correcto? Y/N");
            confirmation = input.nextLine();
            if(confirmation.equalsIgnoreCase("Y")){
                pedido.setEstado("Pendiente");
            }
            
        }//While End
        
    }//Facturacion method end

    private void invoicing (List<Pedido> pedidos) throws IOException {

        List<Factura> facturasList= new ArrayList<Factura>();

        Iterator<Pedido> pedidoIterator = pedidos.iterator();
        //Iterate through Pedidos
        while(pedidoIterator.hasNext()){

            Pedido pedido = pedidoIterator.next();
            Clients cliente = pedido.getCliente();
            Factura factura = new Factura();

            //Work out porcentage of IVA should be applied according to condicion impositiva
            IvaDetails ivaDetails =  Utils.getIvaDetails(cliente.getCondicionImpositiva());            
            facturasList.add(factura.createFactura(cliente,pedido,ivaDetails));
            pedido.setEstado("facturado");
        }//while end

        //Once all of the invoices are processed, I proceed with the txt file going through the list of invoices
        generateFile(facturasList);
    }

    private void generateFile(List<Factura> facturasList)  throws IOException { 

                try {
                        String title = "Cliente-Tipo de Documento-Letra-Nro-Fecha de emisión-Monto";
                        BufferedWriter writer = new BufferedWriter(new FileWriter("fileName.txt"));
                        writer.write(title);
                        //DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        Iterator<Factura> facturaIterator = facturasList.iterator();
                        //Iterate through Pedidos
                        while(facturaIterator.hasNext()){
                            Factura factura = facturaIterator.next();

                            writer.write(factura.getCabecera().getCliente()+" ");
                            writer.write(factura.getCabecera().getTipoId()+" ");
                            writer.write(factura.getCabecera().getLetra()+" ");
                            writer.write(Integer.toString(factura.getCabecera().getNroFactura())+" ");
                            writer.write(factura.getCabecera().getFechaEmision()+" ");
                            writer.write(factura.getPie().getTotal().toString());
                            writer.newLine();
                        }
                           
                        writer.close();       
                } catch (IOException e) {
                        e.printStackTrace(); 
                }
                
    }

    /**Since that I recieve a list of invoices, I assume all of the status are 'facturados' therefore 
     * proceed to iterate over the list without taking the status into consideration
    */
    private void cancelInvoices(List<Factura> facturasList){
        
        List<NotaCredito> notaCreditoList = new ArrayList<NotaCredito>();
        Iterator<Factura> facturasIetartor = facturasList.iterator();
        while(facturasIetartor.hasNext()){
            //Create a nota de credito for each invoice cancelled
            Factura factura = facturasIetartor.next();
            NotaCredito notaCredito = factura.createNotaDeCredito(factura);
            notaCreditoList.add(notaCredito);
        }
    }


    public static void main(String[] args) {
        Facturacion facturacion = new Facturacion();
    }
}