package models;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * NotaCredito
 */
public class NotaCredito {
    private LocalDate fechaEmision;
    private int nroNotaCredito;
    private int nroTalonario;
    private String letra;
    private String cliente;
    private BigDecimal total;

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public int getNroNotaCredito() {
        return nroNotaCredito;
    }

    public void setNroNotaCredito(int nroNotaCredito) {
        this.nroNotaCredito = nroNotaCredito;
    }

    public int getNroTalonario() {
        return nroTalonario;
    }

    public void setNroTalonario(int nroTalonario) {
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