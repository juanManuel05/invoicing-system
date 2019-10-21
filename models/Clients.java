package models;

/**
 * Clients
 */
public class Clients {

    private int nroCliente;
    private String domicilio;
    private int condicionImpositiva;
    private String tipoId;
    private int id;

    public int getCondicionImpositiva() {
        return condicionImpositiva;
    }

    public int getNroCliente() {
        return nroCliente;
    }

    public void setNroCliente(int nroCliente) {
        this.nroCliente = nroCliente;
    }

    public void setCondicionImpositiva(int condicionImpositiva) {
        this.condicionImpositiva = condicionImpositiva;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}