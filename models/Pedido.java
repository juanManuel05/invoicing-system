package models;
import models.Producto;

/**
 * Pedido
 */
public class Pedido {
    private int nroPedido;
    private Clients cliente;
    private Producto[] detalles;
    private String estado;

    public int getNroPedido() {
        return nroPedido;
    }

    public void setNroPedido(int nroPedido) {
        this.nroPedido = nroPedido;
    }

    public Clients getCliente() {
        return cliente;
    }

    public void setCliente(Clients cliente) {
        this.cliente = cliente;
    }

    public Producto[] getDetalles() {
        return detalles;
    }

    public void setDetalles(Producto[] detalles) {
        this.detalles = detalles;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}