package src.controllers;

import java.util.ArrayList;
import java.util.List;

import src.models.Clients;
import src.models.Factura;
import src.models.IvaDetails;
import src.models.Pedido;
import src.repository.Repository;
import src.repository.RepositoryPedido;
import src.utils.Iva;
import src.view.PrintResults;

public class Invoicing {

    final Repository<Pedido> pedidosRepo= RepositoryPedido.getInstance();

    public void processPedidos()  {

        final List<Pedido> pedidos = pedidosRepo.getAll();
        final List<Factura> facturasList= new ArrayList<Factura>();

        pedidos.forEach(pedido->{
            final Clients cliente = pedido.getCliente();      
            final IvaDetails ivaDetails =  Iva.getIvaDetails(cliente.getCondicionImpositiva());            
            facturasList.add(Factura.createFactura(cliente,pedido,ivaDetails));
            pedido.setEstado("facturado");
        });
        PrintResults.printFacturas(facturasList);
    }

    
}

