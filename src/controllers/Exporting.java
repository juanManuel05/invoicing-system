package src.controllers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import src.models.Factura;
import src.repository.Repository;
import src.repository.RepositoryFactura;

public class Exporting {
    
    final Repository<Factura> facturasRepo= RepositoryFactura.getInstance();

    public void generateTxtFile(){ 

        try {
            fillFile("fileName.txt");   
        }catch (IOException e) {
            e.printStackTrace(); 
        }
                
    }

    private void fillFile(final String filename) throws IOException {
        final String title = "Cliente-Tipo de Documento-Letra-Nro-Fecha de emisión-Monto";
        final BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(title);
        final List<Factura> facturasList = facturasRepo.getAll();  
        facturasList.forEach(factura->{
            addFactura(writer,factura);
        }); 
        writer.close();    
    }

    private void addFactura(final BufferedWriter writer,final Factura factura) {
        try {
        writer.write(factura.getCabecera().getCliente()+" ");
        writer.write(factura.getCabecera().getTipoId()+" ");
        writer.write(factura.getCabecera().getLetra()+" ");
        writer.write(Long.toString(factura.getCabecera().getNroFactura())+" ");
        writer.write(factura.getCabecera().getFechaEmision()+" ");
        writer.write(factura.getPie().getTotal().toString());
        writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }                    
    }

    
}