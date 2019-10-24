package src.repository;

import java.util.ArrayList;
import java.util.List;

import src.models.Pedido;

public class RepositoryPedido implements Repository<Pedido>{
    
    private static RepositoryPedido SINGLE_INSTANCE = null;
    
    private RepositoryPedido() {}
    
    public static RepositoryPedido getInstance() {
        if (SINGLE_INSTANCE == null) {  
          synchronized(RepositoryPedido.class) {
            if (SINGLE_INSTANCE == null) {    
                SINGLE_INSTANCE = new RepositoryPedido();
            }
          }
        }
        return SINGLE_INSTANCE;
    }

    @Override
    public List<Pedido> getAll() {
        return mockData();
    }

    private List<Pedido> mockData(){
        
        List<Pedido> pedidos = new ArrayList<Pedido>();
        return pedidos;
    }

   
    
   

    
}

