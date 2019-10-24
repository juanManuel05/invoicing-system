package src.models;

import java.util.concurrent.atomic.AtomicLong;

public class CabeceraFactura {
     private static AtomicLong uniqueFacturaId = new AtomicLong(0);
    private static AtomicLong uniqueTalonarioId = new AtomicLong(0); 
    

    private String fechaEmision;
    private long nroFactura; 
    private long nroTalonario;
    private String letra;
    private String cliente;
    private String tipoId;

    private CabeceraFactura(String fechaEmision, String letra, String cliente, String tipoId) {
         this.fechaEmision = fechaEmision;
            this.nroFactura = uniqueFacturaId.incrementAndGet();
        this.nroTalonario = uniqueTalonarioId.incrementAndGet();
    this.letra = letra;
    this.cliente = cliente;
    this.tipoId = tipoId;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public long getNroFactura() {
        return nroFactura;
    }

    public long getNroTalonario() {
        return nroTalonario;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }
    
    public static class Builder {
        private String fechaEmision = "";
        private String letra = "";
        private String cliente = "";
        private String tipoId = "";

        public Builder setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
        return this;
    }

    public Builder setLetra(String letra) {
        this.letra = letra;
        return this;
    }

    public Builder setCliente(String cliente) {
        this.cliente = cliente;
        return this;
    }

    public Builder setTipoId(String tipoId) {
        this.tipoId = tipoId;
        return this;
    }
    
    public CabeceraFactura build() {
        return new CabeceraFactura(this.fechaEmision, this.letra, this.cliente, this.tipoId);
    }
    }

	
}