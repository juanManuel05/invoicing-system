package src.models;

import java.math.BigDecimal;


public class IvaDetails {

    private BigDecimal porcentaje;
    private String letra;

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }
    
    public void setPorcentaje(BigDecimal d) {
        this.porcentaje = d;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }


}