package presupuesto.bean;

import java.util.Date;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * @author CARLOS SANTANDER
 */
public class NotaModificatoriaSec {

    private String ano_eje;
    private String sec_ejec;
    private String sec_ejec2;
    private String sec_nota;
    private String secuencia;
    private Date fecha;
    private XMLGregorianCalendar fecha_xml;
    private String notas;
    private String estado;
    private String estado2;
    private String sec_doc;
    private String sec_doc_r;

    public NotaModificatoriaSec() {
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

    public String getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(String secuencia) {
        this.secuencia = secuencia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado2() {
        return estado2;
    }

    public void setEstado2(String estado2) {
        this.estado2 = estado2;
    }

    public String getSec_doc() {
        return sec_doc;
    }

    public void setSec_doc(String sec_doc) {
        this.sec_doc = sec_doc;
    }

    public String getSec_doc_r() {
        return sec_doc_r;
    }

    public void setSec_doc_r(String sec_doc_r) {
        this.sec_doc_r = sec_doc_r;
    }

    public XMLGregorianCalendar getFecha_xml() {
        return fecha_xml;
    }

    public void setFecha_xml(XMLGregorianCalendar fecha_xml) {
        this.fecha_xml = fecha_xml;
    }

}
