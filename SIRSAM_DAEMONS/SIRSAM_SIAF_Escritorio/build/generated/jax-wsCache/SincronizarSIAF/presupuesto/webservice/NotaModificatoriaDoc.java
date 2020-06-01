
package presupuesto.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para notaModificatoriaDoc complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="notaModificatoriaDoc">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ano_eje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cod_doc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecha_doc" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fecha_doc_xml" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" minOccurs="0"/>
 *         &lt;element name="num_doc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="observacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sec_doc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sec_ejec" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "notaModificatoriaDoc", propOrder = {
    "anoEje",
    "codDoc",
    "estado",
    "fechaDoc",
    "fechaDocXml",
    "numDoc",
    "observacion",
    "secDoc",
    "secEjec"
})
public class NotaModificatoriaDoc {

    @XmlElement(name = "ano_eje")
    protected String anoEje;
    @XmlElement(name = "cod_doc")
    protected String codDoc;
    protected String estado;
    @XmlElement(name = "fecha_doc")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaDoc;
    @XmlElement(name = "fecha_doc_xml")
    @XmlSchemaType(name = "anySimpleType")
    protected Object fechaDocXml;
    @XmlElement(name = "num_doc")
    protected String numDoc;
    protected String observacion;
    @XmlElement(name = "sec_doc")
    protected String secDoc;
    @XmlElement(name = "sec_ejec")
    protected String secEjec;

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
     * Obtiene el valor de la propiedad codDoc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodDoc() {
        return codDoc;
    }

    /**
     * Define el valor de la propiedad codDoc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodDoc(String value) {
        this.codDoc = value;
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
     * Obtiene el valor de la propiedad fechaDoc.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaDoc() {
        return fechaDoc;
    }

    /**
     * Define el valor de la propiedad fechaDoc.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaDoc(XMLGregorianCalendar value) {
        this.fechaDoc = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaDocXml.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getFechaDocXml() {
        return fechaDocXml;
    }

    /**
     * Define el valor de la propiedad fechaDocXml.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setFechaDocXml(Object value) {
        this.fechaDocXml = value;
    }

    /**
     * Obtiene el valor de la propiedad numDoc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumDoc() {
        return numDoc;
    }

    /**
     * Define el valor de la propiedad numDoc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumDoc(String value) {
        this.numDoc = value;
    }

    /**
     * Obtiene el valor de la propiedad observacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * Define el valor de la propiedad observacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservacion(String value) {
        this.observacion = value;
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

}
