package presupuesto.bean;

import java.math.BigDecimal;

/**
 * @author CARLOS SANTANDER
 */
public class MetaTrimestral {

    private String ano_eje;
    private String sec_ejec;
    private String sec_func;
    private String trimestre;
    private BigDecimal programacion;
    private BigDecimal avance;
    private String estado;
    private String estado_envio;

    public MetaTrimestral() {
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

    public String getSec_func() {
        return sec_func;
    }

    public void setSec_func(String sec_func) {
        this.sec_func = sec_func;
    }

    public String getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(String trimestre) {
        this.trimestre = trimestre;
    }

    public BigDecimal getProgramacion() {
        return programacion;
    }

    public void setProgramacion(BigDecimal programacion) {
        this.programacion = programacion;
    }

    public BigDecimal getAvance() {
        return avance;
    }

    public void setAvance(BigDecimal avance) {
        this.avance = avance;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado_envio() {
        return estado_envio;
    }

    public void setEstado_envio(String estado_envio) {
        this.estado_envio = estado_envio;
    }

}
