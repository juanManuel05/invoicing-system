package src.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import src.models.CabeceraFactura;
import src.models.DetalleFactura;
import src.models.PieFactura;
import src.utils.Iva;;


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
    
    public static Factura createFactura(final Clients cliente,final Pedido pedido,final IvaDetails ivaDetails){
        
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");   
        final CabeceraFactura cabecera = new CabeceraFactura.Builder()
            .setFechaEmision(LocalDate.now().format(formatter))
            .setLetra(ivaDetails.getLetra())
            .setCliente(Integer.toString(cliente.getNroCliente()))
            .setTipoId(cliente.getTipoId())
            .build();

        final Factura factura = new Factura();
        factura.setCabecera(cabecera);
        
        
        final BigDecimal total = new BigDecimal("0");
        final BigDecimal totalIva = new BigDecimal("0");
        final ArrayList<DetalleFactura> listaDetalles = new ArrayList<DetalleFactura>();
        for (Producto producto : pedido.getDetalles()) {
            final DetalleFactura detalle = new DetalleFactura.Builder()
            .setProducto(producto.getNombre())
            .setPrecioUnitario(producto.getPrecio())
            .setPorcentajeIva(ivaDetails.getPorcentaje())
            .setMontoIva(Iva.getMontoIva(ivaDetails.getPorcentaje(),producto.getPrecio()))
            .setCantidad(producto.getCantidad())
            .setPrecioNeto(producto.getPrecio().multiply(BigDecimal.valueOf(producto.getCantidad())))
            .setPrecioVenta(producto.getPrecio().multiply(ivaDetails.getPorcentaje()))
            .build();         
            
            total.add(detalle.getPrecioNeto());
            totalIva.add(detalle.getMontoIva());

            listaDetalles.add(detalle);            
        }
        factura.setDetalle(listaDetalles);

        
        final PieFactura pie = new PieFactura.Builder()
        .setTotal(total)
        .setTotalIva(totalIva)
        .build();

        factura.setPie(pie);

        return factura;        
    }

    
}
    