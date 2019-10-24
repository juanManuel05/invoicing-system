package src.controllers;

import java.util.ArrayList;
import java.util.List;

import src.models.Factura;
import src.models.NotaCredito;
import src.repository.Repository;
import src.repository.RepositoryFactura;


public class Cancelation {

    final Repository<Factura> facturasRepo= RepositoryFactura.getInstance();

    public void cancelInvoices(){
        
        List<Factura> facturasList = facturasRepo.getAll();
        List<NotaCredito> notaCreditoList = new ArrayList<NotaCredito>();

        facturasList.forEach(factura->{
            NotaCredito notaCredito = factura.createNotaDeCredito(factura);
            notaCreditoList.add(notaCredito);
        });
    }
    
}