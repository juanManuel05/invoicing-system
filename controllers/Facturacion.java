package controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import models.Clients;
import models.Factura;
import models.Pedido;
import models.Producto;
import models.IvaDetails;
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

    private void invoicing (List<Pedido> pedidos){

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
        



    }


    public static void main(String[] args) {
        
    }
}