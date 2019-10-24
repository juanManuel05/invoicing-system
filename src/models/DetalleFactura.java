package src.models;

import java.math.BigDecimal;


public class DetalleFactura {

    private String producto;
    private BigDecimal precioUnitario;
    private BigDecimal porcentajeIva; 
    private int cantidad;
    private BigDecimal precioVenta;
    private BigDecimal precioNeto;
    private BigDecimal montoIva;

    private DetalleFactura(String producto,BigDecimal precioUnitario,BigDecimal porcentajeIva,
    int cantidad,BigDecimal precioVenta,BigDecimal precioNeto, BigDecimal montoIva){
        this.producto = producto;
        this.precioUnitario = precioUnitario;
        this.porcentajeIva = porcentajeIva;
        this.cantidad = cantidad;
        this.precioVenta =precioVenta;
        this.precioNeto =precioNeto;
        this.montoIva= montoIva;
    }

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

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal previoVenta) {
        this.precioVenta = previoVenta;
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

    public static class Builder {

        private String producto = "";
        private BigDecimal precioUnitario = new BigDecimal("0");
        private BigDecimal porcentajeIva = new BigDecimal("0"); 
        private int cantidad =0;
        private BigDecimal precioVenta = new BigDecimal("0");
        private BigDecimal precioNeto = new BigDecimal("0");
        private BigDecimal montoIva = new BigDecimal("0");

        

        public Builder setProducto(String producto) {
            this.producto = producto;
            return this;
        }

        public Builder setPrecioUnitario(BigDecimal precioUnitario) {
            this.precioUnitario = precioUnitario;
            return this;
        }

        public Builder setPorcentajeIva(BigDecimal porcentajeIva) {
            this.porcentajeIva = porcentajeIva;
            return this;
        }

        public Builder setCantidad(int cantidad) {
            this.cantidad = cantidad;
            return this;
        }

        public Builder setPrecioVenta(BigDecimal previoVenta) {
            this.precioVenta = previoVenta;
            return this;
        }

        public Builder setPrecioNeto(BigDecimal precioNeto) {
            this.precioNeto = precioNeto;
            return this;
        }

        public Builder setMontoIva(BigDecimal montoIva) {
            this.montoIva = montoIva;
            return this;
        }

        public DetalleFactura build(){
            return new DetalleFactura(this.producto, this.precioUnitario, this.porcentajeIva, this.cantidad, 
            this.precioVenta, this.precioNeto, this.montoIva);
        }
    }
}