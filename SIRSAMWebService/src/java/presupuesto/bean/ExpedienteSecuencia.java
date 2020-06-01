package presupuesto.bean;

import java.math.BigDecimal;
import java.util.Date;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * @author CARLOS SANTANDER
 */
public class ExpedienteSecuencia {

    private String ano_eje;
    private String sec_ejec;
    private String expediente;
    private String ciclo;
    private String fase;
    private String secuencia;
    private String correlativo;
    private String cod_doc;
    private String num_doc;
    private Date fecha_doc;
    private XMLGregorianCalendar fecha_doc_xml;
    private BigDecimal monto;
    private BigDecimal monto_nacional;
    private String ano_cta_cte;
    private String banco;
    private String cta_cte;
    private Date fecha_autorizacion;
    private XMLGregorianCalendar fecha_autorizacion_xml;
    private String estado_envio;

    public ExpedienteSecuencia() {
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

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
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

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getMonto_nacional() {
        return monto_nacional;
    }

    public void setMonto_nacional(BigDecimal monto_nacional) {
        this.monto_nacional = monto_nacional;
    }

    public String getAno_cta_cte() {
        return ano_cta_cte;
    }

    public void setAno_cta_cte(String ano_cta_cte) {
        this.ano_cta_cte = ano_cta_cte;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getCta_cte() {
        return cta_cte;
    }

    public void setCta_cte(String cta_cte) {
        this.cta_cte = cta_cte;
    }

    public Date getFecha_autorizacion() {
        return fecha_autorizacion;
    }

    public void setFecha_autorizacion(Date fecha_autorizacion) {
        this.fecha_autorizacion = fecha_autorizacion;
    }

    public String getEstado_envio() {
        return estado_envio;
    }

    public void setEstado_envio(String estado_envio) {
        this.estado_envio = estado_envio;
    }

    public XMLGregorianCalendar getFecha_doc_xml() {
        return fecha_doc_xml;
    }

    public void setFecha_doc_xml(XMLGregorianCalendar fecha_doc_xml) {
        this.fecha_doc_xml = fecha_doc_xml;
    }

    public XMLGregorianCalendar getFecha_autorizacion_xml() {
        return fecha_autorizacion_xml;
    }

    public void setFecha_autorizacion_xml(XMLGregorianCalendar fecha_autorizacion_xml) {
        this.fecha_autorizacion_xml = fecha_autorizacion_xml;
    }

}
