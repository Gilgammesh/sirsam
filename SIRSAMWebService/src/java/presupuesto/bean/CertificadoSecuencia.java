package presupuesto.bean;

import java.math.BigDecimal;
import java.util.Date;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * @author CARLOS SANTANDER
 */
public class CertificadoSecuencia {

    private String ano_eje;
    private String sec_ejec;
    private String certificado;
    private String secuencia;
    private String correlativo;
    private String cod_doc;
    private String num_doc;
    private Date fecha_doc;
    private XMLGregorianCalendar fecha_doc_xml;
    private String estado_registro;
    private String estado_envio;
    private BigDecimal monto;
    private BigDecimal monto_comprometido;
    private BigDecimal monto_nacional;
    private String tipo_registro;

    public CertificadoSecuencia() {
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

    public String getCod_doc() {
        return cod_doc;
    }

    public void setCod_doc(String cod_doc) {
        this.cod_doc = cod_doc;
    }

    public String getNum_doc() {
        return num_doc;
    }

    public void setNum_doc(String num_doc) {
        this.num_doc = num_doc;
    }

    public Date getFecha_doc() {
        return fecha_doc;
    }

    public void setFecha_doc(Date fecha_doc) {
        this.fecha_doc = fecha_doc;
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

    public String getTipo_registro() {
        return tipo_registro;
    }

    public void setTipo_registro(String tipo_registro) {
        this.tipo_registro = tipo_registro;
    }

    public XMLGregorianCalendar getFecha_doc_xml() {
        return fecha_doc_xml;
    }

    public void setFecha_doc_xml(XMLGregorianCalendar fecha_doc_xml) {
        this.fecha_doc_xml = fecha_doc_xml;
    }

}
