package presupuesto.bean;

import java.math.BigDecimal;

/**
 * @author CARLOS SANTANDER
 */
public class NotaModificatoriaDet {

    private String ano_eje;
    private String sec_ejec;
    private String sec_ejec2;
    private String sec_nota;
    private String origen;
    private String fuente_financ;
    private String tipo_recurso;
    private String sec_func;
    private BigDecimal monto_a;
    private BigDecimal monto_de;
    private String id_clasificador;

    public NotaModificatoriaDet() {
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

    public String getSec_ejec2() {
        return sec_ejec2;
    }

    public void setSec_ejec2(String sec_ejec2) {
        this.sec_ejec2 = sec_ejec2;
    }

    public String getSec_nota() {
        return sec_nota;
    }

    public void setSec_nota(String sec_nota) {
        this.sec_nota = sec_nota;
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

    public String getSec_func() {
        return sec_func;
    }

    public void setSec_func(String sec_func) {
        this.sec_func = sec_func;
    }

    public BigDecimal getMonto_a() {
        return monto_a;
    }

    public void setMonto_a(BigDecimal monto_a) {
        this.monto_a = monto_a;
    }

    public BigDecimal getMonto_de() {
        return monto_de;
    }

    public void setMonto_de(BigDecimal monto_de) {
        this.monto_de = monto_de;
    }

    public String getId_clasificador() {
        return id_clasificador;
    }

    public void setId_clasificador(String id_clasificador) {
        this.id_clasificador = id_clasificador;
    }

}
