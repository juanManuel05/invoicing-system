package src.models;

import java.math.BigDecimal;


public class PieFactura {

    private BigDecimal total;
    private BigDecimal totalIva;

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotalIva() {
        return totalIva;
    }

    public void setTotalIva(BigDecimal totalIva) {
        this.totalIva = totalIva;
    }
}