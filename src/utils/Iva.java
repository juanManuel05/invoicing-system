package src.utils;

import java.math.BigDecimal;

import src.models.IvaDetails;


public class Iva {

    public static IvaDetails getIvaDetails (final int category ){
        final IvaDetails details = new IvaDetails();

        switch (category) {
            case 1: details.setPorcentaje(new BigDecimal("10.05")); 
                    details.setLetra("A");
                    break;

            case 2: details.setPorcentaje(new BigDecimal("21")); 
                    details.setLetra("B");
                    break;

            case 3: details.setPorcentaje(new BigDecimal("70"));
                    details.setLetra("X");
                    break;

        }
        return details;
    
    }

    public static BigDecimal getMontoIva (final BigDecimal porcentajeIva,final BigDecimal precio){
        return (porcentajeIva.multiply(precio).divide(new BigDecimal(100)));
    }

}