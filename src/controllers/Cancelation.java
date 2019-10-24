package src.controllers;

import java.util.ArrayList;
import java.util.List;

import src.models.Factura;
import src.models.NotaCredito;
import src.repository.Repository;
import src.repository.RepositoryFactura;
import src.view.PrintResults;


public class Cancelation {

    final Repository<Factura> facturasRepo= RepositoryFactura.getInstance();

    public void cancelInvoices(){
        
        final List<Factura> facturasList = facturasRepo.getAll();
        final List<NotaCredito> notaCreditoList = new ArrayList<NotaCredito>();

        facturasList.forEach(factura->{
            final NotaCredito notaCredito = createNotaDeCredito(factura);
            notaCreditoList.add(notaCredito);
        });
        PrintResults.notasCredito(notaCreditoList);
    }

    private NotaCredito createNotaDeCredito (final Factura factura){

        final NotaCredito notaCredito = new NotaCredito.Builder()
            .setCliente(factura.getCabecera().getCliente())
            .setFechaEmision(factura.getCabecera().getFechaEmision())
            .setLetra(factura.getCabecera().getLetra())
            .setNroTalonario(factura.getCabecera().getNroTalonario())
            .setTotal(factura.getPie().getTotal())
            .build();    
        return notaCredito;
    }
    
}

