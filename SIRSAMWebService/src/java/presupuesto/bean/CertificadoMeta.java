package presupuesto.bean;

import java.math.BigDecimal;

/**
 * @author CARLOS SANTANDER
 */
public class CertificadoMeta {

    private String ano_eje;
    private String sec_ejec;
    private String certificado;
    private String secuencia;
    private String correlativo;
    private String id_clasificador;
    private String sec_func;
    private BigDecimal monto;
    private BigDecimal monto_comprometido;
    private BigDecimal monto_nacional;
    private String estado_registro;
    private String estado_envio;

    public CertificadoMeta() {
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

    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    public String getId_clasificador() {
        return id_clasificador;
    }

    public void setId_clasificador(String id_clasificador) {
        this.id_clasificador = id_clasificador;
    }

    public String getSec_func() {
        return sec_func;
    }

    public void setSec_func(String sec_func) {
        this.sec_func = sec_func;
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
