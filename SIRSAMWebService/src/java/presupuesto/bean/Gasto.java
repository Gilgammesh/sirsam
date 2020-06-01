package presupuesto.bean;

import java.math.BigDecimal;

/**
 * @author CARLOS SANTANDER
 */
public class Gasto {

    private String ano_eje;
    private String sec_ejec;
    private String origen;
    private String fuente_financ;
    private String tipo_recurso;
    private String sec_func;
    private BigDecimal presupuesto;
    private BigDecimal modificacion;
    private BigDecimal ejecucion;
    private String id_clasificador;
    private BigDecimal compromiso;
    private BigDecimal devengado;
    private BigDecimal girado;
    private BigDecimal pagado;
    private BigDecimal monto_certificado;
    private BigDecimal monto_comprometido_anual;
    private BigDecimal monto_precertificado;

    public Gasto() {
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

    public String getFuente_financ() {
        return fuente_financ;
    }

    public void setFuente_financ(String fuente_financ) {
        this.fuente_financ = fuente_financ;
    }

    public String getSec_func() {
        return sec_func;
    }

    public void setSec_func(String sec_func) {
        this.sec_func = sec_func;
    }

    public BigDecimal getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(BigDecimal presupuesto) {
        this.presupuesto = presupuesto;
    }

    public BigDecimal getModificacion() {
        return modificacion;
    }

    public void setModificacion(BigDecimal modificacion) {
        this.modificacion = modificacion;
    }

    public BigDecimal getEjecucion() {
        return ejecucion;
    }

    public void setEjecucion(BigDecimal ejecucion) {
        this.ejecucion = ejecucion;
    }

    public String getId_clasificador() {
        return id_clasificador;
    }

    public void setId_clasificador(String id_clasificador) {
        this.id_clasificador = id_clasificador;
    }

    public BigDecimal getCompromiso() {
        return compromiso;
    }

    public void setCompromiso(BigDecimal compromiso) {
        this.compromiso = compromiso;
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

    public BigDecimal getMonto_certificado() {
        return monto_certificado;
    }

    public void setMonto_certificado(BigDecimal monto_certificado) {
        this.monto_certificado = monto_certificado;
    }

    public BigDecimal getMonto_comprometido_anual() {
        return monto_comprometido_anual;
    }

    public void setMonto_comprometido_anual(BigDecimal monto_comprometido_anual) {
        this.monto_comprometido_anual = monto_comprometido_anual;
    }

    public BigDecimal getMonto_precertificado() {
        return monto_precertificado;
    }

    public void setMonto_precertificado(BigDecimal monto_precertificado) {
        this.monto_precertificado = monto_precertificado;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getTipo_recurso() {
        return tipo_recurso;
    }

    public void setTipo_recurso(String tipo_recurso) {
        this.tipo_recurso = tipo_recurso;
    }

}
