package src.models;

import java.math.BigDecimal;

public class NotaCredito {
    private String fechaEmision;
    private long nroNotaCredito;
    private long nroTalonario;
    private String letra;
    private String cliente;
    private BigDecimal total;

    private NotaCredito(String fechaEmision, long nroNotaCredito,long nroTalonario, String letra,String cliente,
    BigDecimal total){
        this.fechaEmision= fechaEmision;
        this.nroNotaCredito=nroNotaCredito;
        this.nroTalonario=nroTalonario;
        this.letra=letra;
        this.cliente=cliente;
        this.total=total;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public long getNroNotaCredito() {
        return nroNotaCredito;
    }

    public void setNroNotaCredito(int nroNotaCredito) {
        this.nroNotaCredito = nroNotaCredito;
    }

    public long getNroTalonario() {
        return nroTalonario;
    }

    public void setNroTalonario(long nroTalonario) {
        this.nroTalonario = nroTalonario;
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

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public static class Builder {
        private String fechaEmision="";
        private long nroNotaCredito=0;
        private long nroTalonario=0;
        private String letra="";
        private String cliente="";
        private BigDecimal total= new BigDecimal("0");

        public Builder setFechaEmision (String fechaEmision){
            this.fechaEmision=fechaEmision;
            return this;
        }

        public Builder setNroNotaCredito (long nroNotaCredito){
            this.nroNotaCredito=nroNotaCredito;
            return this;
        }

        public Builder setNroTalonario (long nroTalonario){
            this.nroTalonario=nroTalonario;
            return this;
        }

        public Builder setLetra (String letra){
            this.letra=letra;
            return this;
        }

        public Builder setCliente(String cliente){
            this.cliente=cliente;
            return this;
        }

        public Builder setTotal(BigDecimal total){
            this.total=total;
            return this;
        }

        public NotaCredito build(){
            return new NotaCredito(this.fechaEmision, this.nroNotaCredito, this.nroTalonario, 
            this.letra, this.cliente, this.total);
        }
    }
    
}