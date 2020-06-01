package presupuesto.bean;

import java.math.BigDecimal;

/**
 * @author CARLOS SANTANDER
 */
public class CertificadoFase {

    private String ano_eje;
    private String sec_ejec;
    private String certificado;
    private String secuencia;
    private String secuencia_padre;
    private String fuente_financ;
    private String etapa;
    private BigDecimal monto;
    private BigDecimal monto_comprometido;
    private BigDecimal monto_nacional;
    private String glosa;
    private String estado_registro;
    private String estado_envio;

    public CertificadoFase() {
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

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public String getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(String secuencia) {
        this.secuencia = secuencia;
    }

    public String getSecuencia_padre() {
        return secuencia_padre;
    }

    public void setSecuencia_padre(String secuencia_padre) {
        this.secuencia_padre = secuencia_padre;
    }

    public String getFuente_financ() {
        return fuente_financ;
    }

    public void setFuente_financ(String fuente_financ) {
        this.fuente_financ = fuente_financ;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getMonto_comprometido() {
        return monto_comprometido;
    }

    public void setMonto_comprometido(BigDecimal monto_comprometido) {
        this.monto_comprometido = monto_comprometido;
    }

    public BigDecimal getMonto_nacional() {
        return monto_nacional;
    }

    public void setMonto_nacional(BigDecimal monto_nacional) {
        this.monto_nacional = monto_nacional;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public String getEstado_registro() {
        return estado_registro;
    }

    public void setEstado_registro(String estado_registro) {
        this.estado_registro = estado_registro;
    }

    public String getEstado_envio() {
        return estado_envio;
    }

    public void setEstado_envio(String estado_envio) {
        this.estado_envio = estado_envio;
    }

}
