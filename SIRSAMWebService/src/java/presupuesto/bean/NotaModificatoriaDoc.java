package presupuesto.bean;

import java.util.Date;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * @author CARLOS SANTANDER
 */
public class NotaModificatoriaDoc {

    private String ano_eje;
    private String sec_ejec;
    private String sec_doc;
    private String cod_doc;
    private String num_doc;
    private Date fecha_doc;
    private XMLGregorianCalendar fecha_doc_xml;
    private String observacion;
    private String estado;

    public NotaModificatoriaDoc() {
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

    public String getSec_doc() {
        return sec_doc;
    }

    public void setSec_doc(String sec_doc) {
        this.sec_doc = sec_doc;
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

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public XMLGregorianCalendar getFecha_doc_xml() {
        return fecha_doc_xml;
    }

    public void setFecha_doc_xml(XMLGregorianCalendar fecha_doc_xml) {
        this.fecha_doc_xml = fecha_doc_xml;
    }

}
