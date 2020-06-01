package presupuesto.bean;

import java.math.BigDecimal;

/**
 * @author CARLOS SANTANDER
 */
public class Ingreso {

    private String ano_eje;
    private String sec_ejec;
    private String origen;
    private String fuente_financ;
    private String tipo_recurso;
    private BigDecimal presupuesto;
    private BigDecimal modificacion;
    private BigDecimal ejecucion;
    private String id_clasificador;

    public Ingreso() {
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

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getFuente_financ() {
        return fuente_financ;
    }

    public void setFuente_financ(String fuente_financ) {
        this.fuente_financ = fuente_financ;
    }

    public String getTipo_recurso() {
        return tipo_recurso;
    }

    public void setTipo_recurso(String tipo_recurso) {
        this.tipo_recurso = tipo_recurso;
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

}
