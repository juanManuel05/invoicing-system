package src.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import src.models.CabeceraFactura;
import src.models.DetalleFactura;
import src.models.PieFactura;
import src.utils.Utils;


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
    
    public static Factura createFactura(Clients cliente,Pedido pedido,IvaDetails ivaDetails){
        
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");   
        final CabeceraFactura cabecera = new CabeceraFactura.Builder()
            .setFechaEmision(LocalDate.now().format(formatter))
            .setLetra(ivaDetails.getLetra())
            .setCliente(Integer.toString(cliente.getNroCliente()))
            .setTipoId(cliente.getTipoId())
            .build();

        Factura factura = new Factura();
        factura.setCabecera(cabecera);
        
        
        BigDecimal total = new BigDecimal("0");
        BigDecimal totalIva = new BigDecimal("0");
        ArrayList<DetalleFactura> listaDetalles = new ArrayList<DetalleFactura>();
        for (Producto producto : pedido.getDetalles()) {
            DetalleFactura detalle = new DetalleFactura();
            detalle.setProducto(producto.getNombre());
            detalle.setPrecioUnitario(producto.getPrecio());
            detalle.setPorcentajeIva(ivaDetails.getPorcentaje());
            detalle.setMontoIva(Utils.getMontoIva(detalle.getPorcentajeIva(),detalle.getPrecioUnitario()));
            detalle.setCantidad(producto.getCantidad());
            detalle.setPrecioNeto(producto.getPrecio().multiply(BigDecimal.valueOf(producto.getCantidad())));
            detalle.setPrevioVenta(detalle.getPrecioNeto().multiply(ivaDetails.getPorcentaje()));
            
            total.add(detalle.getPrecioNeto());
            totalIva.add(detalle.getMontoIva());

            listaDetalles.add(detalle);            
        }
        factura.setDetalle(listaDetalles);

        
        PieFactura pie = new PieFactura();
        pie.setTotal(total);
        pie.setTotalIva(totalIva);
        factura.setPie(pie);

        return factura;        
    }

    public NotaCredito createNotaDeCredito (Factura factura){
        NotaCredito notaCredito = new NotaCredito();
        notaCredito.setCliente(factura.getCabecera().getCliente());
        notaCredito.setFechaEmision(factura.getCabecera().getFechaEmision());
        notaCredito.setLetra(factura.getCabecera().getLetra());
        notaCredito.setNroTalonario(factura.getCabecera().getNroTalonario());
        notaCredito.setTotal(factura.getPie().getTotal());

        return notaCredito;
    }
}
    