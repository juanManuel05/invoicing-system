package models;
import java.time.LocalDate;;

/**
 * CabeceraFactura
 */
public class CabeceraFactura {
    private LocalDate fechaEmision;
    private int nroFactura;
    private int nroTalonario;
    private String Letra;
    private String Cliente;
    private String tipoId;

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public int getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(int nroFactura) {
        this.nroFactura = nroFactura;
    }

    public int getNroTalonario() {
        return nroTalonario;
    }

    public void setNroTalonario(int nroTalonario) {
        this.nroTalonario = nroTalonario;
    }

    public String getLetra() {
        return Letra;
    }

    public void setLetra(String letra) {
        Letra = letra;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String cliente) {
        Cliente = cliente;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }
    
}