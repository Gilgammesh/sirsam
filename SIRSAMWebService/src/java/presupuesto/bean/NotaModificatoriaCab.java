package presupuesto.bean;

import java.math.BigDecimal;

/**
 * @author CARLOS SANTANDER
 */
public class NotaModificatoriaCab {

    private String ano_eje;
    private String sec_ejec;
    private String sec_ejec2;
    private String sec_nota;
    private String ind_habilita;
    private String tipo_modificacion;
    private String mes_eje;
    private BigDecimal monto;
    private String sec_ejec_procedencia;

    public NotaModificatoriaCab() {
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

    public String getInd_habilita() {
        return ind_habilita;
    }

    public void setInd_habilita(String ind_habilita) {
        this.ind_habilita = ind_habilita;
    }

    public String getTipo_modificacion() {
        return tipo_modificacion;
    }

    public void setTipo_modificacion(String tipo_modificacion) {
        this.tipo_modificacion = tipo_modificacion;
    }

    public String getMes_eje() {
        return mes_eje;
    }

    public void setMes_eje(String mes_eje) {
        this.mes_eje = mes_eje;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getSec_ejec_procedencia() {
        return sec_ejec_procedencia;
    }

    public void setSec_ejec_procedencia(String sec_ejec_procedencia) {
        this.sec_ejec_procedencia = sec_ejec_procedencia;
    }

}
