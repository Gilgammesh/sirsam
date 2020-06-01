package presupuesto.bean;

import java.math.BigDecimal;

/**
 * @author CARLOS SANTANDER
 */
public class RecaudacionHistorica {

    private String ano_eje;
    private String sec_ejec;
    private BigDecimal pia;
    private BigDecimal modificacion;
    private BigDecimal pim;
    private BigDecimal recaudado;

    public RecaudacionHistorica() {
    }

    public String getAno_eje() {
        return ano_eje;
    }

    public void setAno_eje(String ano_eje) {
        this.ano_eje = ano_eje;
    }

    public String getSec_ejec() {
        return sec_ejec;
    }

    public void setSec_ejec(String sec_ejec) {
        this.sec_ejec = sec_ejec;
    }

    public BigDecimal getPia() {
        return pia;
    }

    public void setPia(BigDecimal pia) {
        this.pia = pia;
    }

    public BigDecimal getModificacion() {
        return modificacion;
    }

    public void setModificacion(BigDecimal modificacion) {
        this.modificacion = modificacion;
    }

    public BigDecimal getPim() {
        return pim;
    }

    public void setPim(BigDecimal pim) {
        this.pim = pim;
    }

    public BigDecimal getRecaudado() {
        return recaudado;
    }

    public void setRecaudado(BigDecimal recaudado) {
        this.recaudado = recaudado;
    }

}
