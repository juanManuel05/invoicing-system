package models;

import java.math.BigDecimal;

/**
 * DetalleFactura
 */
public class DetalleFactura {

    private String producto;
    private BigDecimal precioUnitario;
    private BigDecimal porcentajeIva; //%iva según Categoría de IVA del cliente
    private int cantidad;
    private BigDecimal previoVenta;
    private BigDecimal precioNeto;
    private BigDecimal montoIva;

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

        public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrevioVenta() {
        return previoVenta;
    }

    public void setPrevioVenta(BigDecimal previoVenta) {
        this.previoVenta = previoVenta;
    }

    public BigDecimal getPrecioNeto() {
        return precioNeto;
    }

    public void setPrecioNeto(BigDecimal precioNeto) {
        this.precioNeto = precioNeto;
    }

    public BigDecimal getMontoIva() {
        return montoIva;
    }

    public void setMontoIva(BigDecimal montoIva) {
        this.montoIva = montoIva;
    }

    public BigDecimal getPorcentajeIva() {
        return porcentajeIva;
    }

    public void setPorcentajeIva(BigDecimal porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
    }
}