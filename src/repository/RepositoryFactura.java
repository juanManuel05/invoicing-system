package src.repository;

import java.util.ArrayList;
import java.util.List;

import src.models.Factura;

public class RepositoryFactura implements Repository<Factura> {

    private static RepositoryFactura SINGLE_INSTANCE = null;
    
    private RepositoryFactura() {}
    
    public static RepositoryFactura getInstance() {
        if (SINGLE_INSTANCE == null) {  
          synchronized(RepositoryFactura.class) {
            if (SINGLE_INSTANCE == null) {    
                SINGLE_INSTANCE = new RepositoryFactura();
            }
          }
        }
        return SINGLE_INSTANCE;
    }

    @Override
    public List<Factura> getAll() {
        return mockData();
    }

    private List<Factura> mockData(){
        
        List<Factura> facturas = new ArrayList<Factura>();
        return facturas;
    }

    
}