package models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import models.CabeceraFactura;
import models.DetalleFactura;
import models.PieFactura;
import utils.Utils;

/**
 * Factura
 */
public class Factura {
    
    private CabeceraFactura cabecera;
    private ArrayList<DetalleFactura> detalle;
    private PieFactura pie;

    public CabeceraFactura getCabecera() {
        return cabecera;
    }

    public void setCabecera(CabeceraFactura cabecera) {
        this.cabecera = cabecera;
    }

    public ArrayList<DetalleFactura> getDetalle() {
        return detalle;
    }

    public void setDetalle(ArrayList<DetalleFactura> detalle) {
        this.detalle = detalle;
    }

    public PieFactura getPie() {
        return pie;
    }

    public void setPie(PieFactura pie) {
        this.pie = pie;
    }   
    
    public Factura createFactura(Clients cliente,Pedido pedido,IvaDetails ivaDetails){
        Factura factura = new Factura();
        BigDecimal total = new BigDecimal("0");
        BigDecimal totalIva = new BigDecimal("0");

        //Cabecera
        CabeceraFactura cabecera = new CabeceraFactura();
        cabecera.setFechaEmision(LocalDate.now());          
        cabecera.setNroFactura((int)Math.round(Math.random()*10000));
        cabecera.setNroTalonario((int)Math.round(Math.random()*10000));
        cabecera.setLetra(ivaDetails.getLetra());
        cabecera.setCliente(Integer.toString(cliente.getNroCliente()));
        factura.setCabecera(cabecera);
        
        //DetalleFactura

        ArrayList<DetalleFactura> listaDetalles = new ArrayList<DetalleFactura>();
        for (Producto producto : pedido.getDetalles()) {
            DetalleFactura detalle = new DetalleFactura();

            detalle.setProducto(producto.getNombre());
            detalle.setPrecioUnitario(producto.getPrecio());
            detalle.setPorcentajeIva(ivaDetails.getPorcentaje());//porcentaje
            detalle.setMontoIva(Utils.getMontoIva(detalle.getPorcentajeIva(),detalle.getPrecioUnitario()));
            detalle.setCantidad(producto.getCantidad());
            detalle.setPrecioNeto(producto.getPrecio().multiply(BigDecimal.valueOf(producto.getCantidad())));
            detalle.setPrevioVenta(detalle.getPrecioNeto().multiply(ivaDetails.getPorcentaje()));
            
            total.add(detalle.getPrecioNeto());
            totalIva.add(detalle.getMontoIva());

            listaDetalles.add(detalle);            
        }//While end
        factura.setDetalle(listaDetalles);

        //PieFactura
        PieFactura pie = new PieFactura();
        pie.setTotal(total);
        pie.setTotalIva(totalIva);
        factura.setPie(pie);

        return factura;

        
    }//CreateFactura end
}