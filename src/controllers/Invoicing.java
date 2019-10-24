package src.controllers;

import java.util.ArrayList;
import java.util.List;

import src.models.Clients;
import src.models.Factura;
import src.models.IvaDetails;
import src.models.Pedido;
import src.repository.Repository;
import src.repository.RepositoryPedido;
import src.utils.Utils;

public class Invoicing {

    final Repository<Pedido> pedidosRepo= RepositoryPedido.getInstance();

    public void processPedidos()  {

        List<Pedido> pedidos = pedidosRepo.getAll();
        List<Factura> facturasList= new ArrayList<Factura>();

            pedidos.forEach(pedido->{
                Clients cliente = pedido.getCliente();      
                IvaDetails ivaDetails =  Utils.getIvaDetails(cliente.getCondicionImpositiva());            
                facturasList.add(Factura.createFactura(cliente,pedido,ivaDetails));
                pedido.setEstado("facturado");
        });
    }

    
}

