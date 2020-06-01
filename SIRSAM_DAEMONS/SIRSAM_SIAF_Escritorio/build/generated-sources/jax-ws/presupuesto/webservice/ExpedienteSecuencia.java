
package presupuesto.webservice;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para expedienteSecuencia complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="expedienteSecuencia">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ano_cta_cte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ano_eje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="banco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ciclo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cod_doc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="correlativo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cta_cte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estado_envio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="expediente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fase" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecha_autorizacion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fecha_autorizacion_xml" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" minOccurs="0"/>
 *         &lt;element name="fecha_doc" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fecha_doc_xml" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" minOccurs="0"/>
 *         &lt;element name="monto" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="monto_nacional" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="num_doc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sec_ejec" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "expedienteSecuencia", propOrder = {
    "anoCtaCte",
    "anoEje",
    "banco",
    "ciclo",
    "codDoc",
    "correlativo",
    "ctaCte",
    "estadoEnvio",
    "expediente",
    "fase",
    "fechaAutorizacion",
    "fechaAutorizacionXml",
    "fechaDoc",
    "fechaDocXml",
    "monto",
    "montoNacional",
    "numDoc",
    "secEjec",
    "secuencia"
})
public class ExpedienteSecuencia {

    @XmlElement(name = "ano_cta_cte")
    protected String anoCtaCte;
    @XmlElement(name = "ano_eje")
    protected String anoEje;
    protected String banco;
    protected String ciclo;
    @XmlElement(name = "cod_doc")
    protected String codDoc;
    protected String correlativo;
    @XmlElement(name = "cta_cte")
    protected String ctaCte;
    @XmlElement(name = "estado_envio")
    protected String estadoEnvio;
    protected String expediente;
    protected String fase;
    @XmlElement(name = "fecha_autorizacion")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaAutorizacion;
    @XmlElement(name = "fecha_autorizacion_xml")
    @XmlSchemaType(name = "anySimpleType")
    protected Object fechaAutorizacionXml;
    @XmlElement(name = "fecha_doc")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaDoc;
    @XmlElement(name = "fecha_doc_xml")
    @XmlSchemaType(name = "anySimpleType")
    protected Object fechaDocXml;
    protected BigDecimal monto;
    @XmlElement(name = "monto_nacional")
    protected BigDecimal montoNacional;
    @XmlElement(name = "num_doc")
    protected String numDoc;
    @XmlElement(name = "sec_ejec")
    protected String secEjec;
    protected String secuencia;

    /**
     * Obtiene el valor de la propiedad anoCtaCte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnoCtaCte() {
        return anoCtaCte;
    }

    /**
     * Define el valor de la propiedad anoCtaCte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnoCtaCte(String value) {
        this.anoCtaCte = value;
    }

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
     * Obtiene el valor de la propiedad banco.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBanco() {
        return banco;
    }

    /**
     * Define el valor de la propiedad banco.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBanco(String value) {
        this.banco = value;
    }

    /**
     * Obtiene el valor de la propiedad ciclo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCiclo() {
        return ciclo;
    }

    /**
     * Define el valor de la propiedad ciclo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCiclo(String value) {
        this.ciclo = value;
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
     * Obtiene el valor de la propiedad correlativo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorrelativo() {
        return correlativo;
    }

    /**
     * Define el valor de la propiedad correlativo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorrelativo(String value) {
        this.correlativo = value;
    }

    /**
     * Obtiene el valor de la propiedad ctaCte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCtaCte() {
        return ctaCte;
    }

    /**
     * Define el valor de la propiedad ctaCte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCtaCte(String value) {
        this.ctaCte = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoEnvio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoEnvio() {
        return estadoEnvio;
    }

    /**
     * Define el valor de la propiedad estadoEnvio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoEnvio(String value) {
        this.estadoEnvio = value;
    }

    /**
     * Obtiene el valor de la propiedad expediente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpediente() {
        return expediente;
    }

    /**
     * Define el valor de la propiedad expediente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpediente(String value) {
        this.expediente = value;
    }

    /**
     * Obtiene el valor de la propiedad fase.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFase() {
        return fase;
    }

    /**
     * Define el valor de la propiedad fase.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFase(String value) {
        this.fase = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaAutorizacion.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaAutorizacion() {
        return fechaAutorizacion;
    }

    /**
     * Define el valor de la propiedad fechaAutorizacion.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaAutorizacion(XMLGregorianCalendar value) {
        this.fechaAutorizacion = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaAutorizacionXml.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getFechaAutorizacionXml() {
        return fechaAutorizacionXml;
    }

    /**
     * Define el valor de la propiedad fechaAutorizacionXml.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setFechaAutorizacionXml(Object value) {
        this.fechaAutorizacionXml = value;
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
     * Obtiene el valor de la propiedad monto.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMonto() {
        return monto;
    }

    /**
     * Define el valor de la propiedad monto.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMonto(BigDecimal value) {
        this.monto = value;
    }

    /**
     * Obtiene el valor de la propiedad montoNacional.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoNacional() {
        return montoNacional;
    }

    /**
     * Define el valor de la propiedad montoNacional.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoNacional(BigDecimal value) {
        this.montoNacional = value;
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
