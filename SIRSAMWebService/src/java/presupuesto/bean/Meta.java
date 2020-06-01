package presupuesto.bean;

import java.math.BigDecimal;

/**
 * @author CARLOS SANTANDER
 */
public class Meta {

    private String ano_eje;
    private String sec_ejec;
    private String sec_func;
    private String funcion;
    private String programa;
    private String sub_programa;
    private String act_proy;
    private String componente;
    private String meta;
    private String finalidad;
    private String departamento;
    private String provincia;
    private String estado;
    private String distrito;
    private String programa_ppto;
    private String unidad_medida;
    private BigDecimal cantidad;
    private BigDecimal cantidad_semestral;

    public Meta() {
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

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getSub_programa() {
        return sub_programa;
    }

    public void setSub_programa(String sub_programa) {
        this.sub_programa = sub_programa;
    }

    public String getAct_proy() {
        return act_proy;
    }

    public void setAct_proy(String act_proy) {
        this.act_proy = act_proy;
    }

    public String getComponente() {
        return componente;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getFinalidad() {
        return finalidad;
    }

    public void setFinalidad(String finalidad) {
        this.finalidad = finalidad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getPrograma_ppto() {
        return programa_ppto;
    }

    public void setPrograma_ppto(String programa_ppto) {
        this.programa_ppto = programa_ppto;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getCantidad_semestral() {
        return cantidad_semestral;
    }

    public void setCantidad_semestral(BigDecimal cantidad_semestral) {
        this.cantidad_semestral = cantidad_semestral;
    }

}
