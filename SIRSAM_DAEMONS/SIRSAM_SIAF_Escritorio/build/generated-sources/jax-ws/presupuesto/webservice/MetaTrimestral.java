
package presupuesto.webservice;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para metaTrimestral complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="metaTrimestral">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ano_eje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="avance" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estado_envio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="programacion" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="sec_ejec" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sec_func" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trimestre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "metaTrimestral", propOrder = {
    "anoEje",
    "avance",
    "estado",
    "estadoEnvio",
    "programacion",
    "secEjec",
    "secFunc",
    "trimestre"
})
public class MetaTrimestral {

    @XmlElement(name = "ano_eje")
    protected String anoEje;
    protected BigDecimal avance;
    protected String estado;
    @XmlElement(name = "estado_envio")
    protected String estadoEnvio;
    protected BigDecimal programacion;
    @XmlElement(name = "sec_ejec")
    protected String secEjec;
    @XmlElement(name = "sec_func")
    protected String secFunc;
    protected String trimestre;

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
     * Obtiene el valor de la propiedad avance.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAvance() {
        return avance;
    }

    /**
     * Define el valor de la propiedad avance.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAvance(BigDecimal value) {
        this.avance = value;
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
     * Obtiene el valor de la propiedad programacion.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getProgramacion() {
        return programacion;
    }

    /**
     * Define el valor de la propiedad programacion.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setProgramacion(BigDecimal value) {
        this.programacion = value;
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
     * Obtiene el valor de la propiedad secFunc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecFunc() {
        return secFunc;
    }

    /**
     * Define el valor de la propiedad secFunc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecFunc(String value) {
        this.secFunc = value;
    }

    /**
     * Obtiene el valor de la propiedad trimestre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrimestre() {
        return trimestre;
    }

    /**
     * Define el valor de la propiedad trimestre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrimestre(String value) {
        this.trimestre = value;
    }

}
