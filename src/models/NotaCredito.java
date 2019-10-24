package src.models;

import java.math.BigDecimal;

public class NotaCredito {
    private String fechaEmision;
    private long nroNotaCredito;
    private long nroTalonario;
    private String letra;
    private String cliente;
    private BigDecimal total;

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
    
}