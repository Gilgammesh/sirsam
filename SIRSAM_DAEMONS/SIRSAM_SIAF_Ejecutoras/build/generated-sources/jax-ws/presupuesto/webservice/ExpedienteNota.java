
package presupuesto.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para expedienteNota complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="expedienteNota">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ano_eje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ciclo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estado_envio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="expediente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fase" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="notas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sec_ejec" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="secuencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="secuencia_nota" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "expedienteNota", propOrder = {
    "anoEje",
    "ciclo",
    "estadoEnvio",
    "expediente",
    "fase",
    "notas",
    "secEjec",
    "secuencia",
    "secuenciaNota"
})
public class ExpedienteNota {

    @XmlElement(name = "ano_eje")
    protected String anoEje;
    protected String ciclo;
    @XmlElement(name = "estado_envio")
    protected String estadoEnvio;
    protected String expediente;
    protected String fase;
    protected String notas;
    @XmlElement(name = "sec_ejec")
    protected String secEjec;
    protected String secuencia;
    @XmlElement(name = "secuencia_nota")
    protected String secuenciaNota;

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

    /**
     * Obtiene el valor de la propiedad secuenciaNota.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecuenciaNota() {
        return secuenciaNota;
    }

    /**
     * Define el valor de la propiedad secuenciaNota.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecuenciaNota(String value) {
        this.secuenciaNota = value;
    }

}
