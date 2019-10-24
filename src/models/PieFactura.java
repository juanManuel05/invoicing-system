package src.models;

import java.math.BigDecimal;


public class PieFactura {

    private BigDecimal total;
    private BigDecimal totalIva;

    private PieFactura (BigDecimal total, BigDecimal totalIva){
        this.total = total;
        this.totalIva = totalIva;
    }

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

    public static class Builder{
        private BigDecimal total = new BigDecimal("0");
        private BigDecimal totalIva = new BigDecimal("0");

        public Builder setTotal (BigDecimal total){
            this.total = total;
            return this;
        }

        public Builder setTotalIva (BigDecimal totalIva){
            this.totalIva = totalIva;
            return this;
        }

        public PieFactura build (){
            return new PieFactura(this.total, this.totalIva);
        }
    } 
}