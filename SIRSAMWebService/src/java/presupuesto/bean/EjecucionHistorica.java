package presupuesto.bean;

import java.math.BigDecimal;

/**
 * @author CARLOS SANTANDER
 */
public class EjecucionHistorica {

    private String ano_eje;
    private String sec_ejec;
    private BigDecimal pia;
    private BigDecimal modificacion;
    private BigDecimal pim;
    private BigDecimal certificado;
    private BigDecimal compromiso_anual;
    private BigDecimal compromiso;
    private BigDecimal ejecucion;
    private BigDecimal devengado;
    private BigDecimal girado;
    private BigDecimal pagado;

    public EjecucionHistorica() {
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

    public BigDecimal getCertificado() {
        return certificado;
    }

    public void setCertificado(BigDecimal certificado) {
        this.certificado = certificado;
    }

    public BigDecimal getCompromiso_anual() {
        return compromiso_anual;
    }

    public void setCompromiso_anual(BigDecimal compromiso_anual) {
        this.compromiso_anual = compromiso_anual;
    }

    public BigDecimal getCompromiso() {
        return compromiso;
    }

    public void setCompromiso(BigDecimal compromiso) {
        this.compromiso = compromiso;
    }

    public BigDecimal getEjecucion() {
        return ejecucion;
    }

    public void setEjecucion(BigDecimal ejecucion) {
        this.ejecucion = ejecucion;
    }

    public BigDecimal getDevengado() {
        return devengado;
    }

    public void setDevengado(BigDecimal devengado) {
        this.devengado = devengado;
    }

    public BigDecimal getGirado() {
        return girado;
    }

    public void setGirado(BigDecimal girado) {
        this.girado = girado;
    }

    public BigDecimal getPagado() {
        return pagado;
    }

    public void setPagado(BigDecimal pagado) {
        this.pagado = pagado;
    }

}
