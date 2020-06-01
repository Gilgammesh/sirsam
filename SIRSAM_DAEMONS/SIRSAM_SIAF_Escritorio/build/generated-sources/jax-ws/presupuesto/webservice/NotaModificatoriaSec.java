
package presupuesto.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para notaModificatoriaSec complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="notaModificatoriaSec">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ano_eje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estado2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fecha_xml" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" minOccurs="0"/>
 *         &lt;element name="notas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sec_doc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sec_doc_r" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sec_ejec" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sec_ejec2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sec_nota" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="secuencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "notaModificatoriaSec", propOrder = {
    "anoEje",
    "estado",
    "estado2",
    "fecha",
    "fechaXml",
    "notas",
    "secDoc",
    "secDocR",
    "secEjec",
    "secEjec2",
    "secNota",
    "secuencia"
})
public class NotaModificatoriaSec {

    @XmlElement(name = "ano_eje")
    protected String anoEje;
    protected String estado;
    protected String estado2;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecha;
    @XmlElement(name = "fecha_xml")
    @XmlSchemaType(name = "anySimpleType")
    protected Object fechaXml;
    protected String notas;
    @XmlElement(name = "sec_doc")
    protected String secDoc;
    @XmlElement(name = "sec_doc_r")
    protected String secDocR;
    @XmlElement(name = "sec_ejec")
    protected String secEjec;
    @XmlElement(name = "sec_ejec2")
    protected String secEjec2;
    @XmlElement(name = "sec_nota")
    protected String secNota;
    protected String secuencia;

    /**
     * Obtiene el valor de la propiedad anoEje.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnoEje() {
        return anoEje;
    }

    /**
     * Define el valor de la propiedad anoEje.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnoEje(String value) {
        this.anoEje = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad estado2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado2() {
        return estado2;
    }

    /**
     * Define el valor de la propiedad estado2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado2(String value) {
        this.estado2 = value;
    }

    /**
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecha(XMLGregorianCalendar value) {
        this.fecha = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaXml.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getFechaXml() {
        return fechaXml;
    }

    /**
     * Define el valor de la propiedad fechaXml.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setFechaXml(Object value) {
        this.fechaXml = value;
    }

    /**
     * Obtiene el valor de la propiedad notas.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotas() {
        return notas;
    }

    /**
     * Define el valor de la propiedad notas.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotas(String value) {
        this.notas = value;
    }

    /**
     * Obtiene el valor de la propiedad secDoc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecDoc() {
        return secDoc;
    }

    /**
     * Define el valor de la propiedad secDoc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecDoc(String value) {
        this.secDoc = value;
    }

    /**
     * Obtiene el valor de la propiedad secDocR.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecDocR() {
        return secDocR;
    }

    /**
     * Define el valor de la propiedad secDocR.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecDocR(String value) {
        this.secDocR = value;
    }

    /**
     * Obtiene el valor de la propiedad secEjec.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecEjec() {
        return secEjec;
    }

    /**
     * Define el valor de la propiedad secEjec.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecEjec(String value) {
        this.secEjec = value;
    }

    /**
     * Obtiene el valor de la propiedad secEjec2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecEjec2() {
        return secEjec2;
    }

    /**
     * Define el valor de la propiedad secEjec2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecEjec2(String value) {
        this.secEjec2 = value;
    }

    /**
     * Obtiene el valor de la propiedad secNota.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecNota() {
        return secNota;
    }

    /**
     * Define el valor de la propiedad secNota.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecNota(String value) {
        this.secNota = value;
    }

    /**
     * Obtiene el valor de la propiedad secuencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecuencia() {
        return secuencia;
    }

    /**
     * Define el valor de la propiedad secuencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecuencia(String value) {
        this.secuencia = value;
    }

}
