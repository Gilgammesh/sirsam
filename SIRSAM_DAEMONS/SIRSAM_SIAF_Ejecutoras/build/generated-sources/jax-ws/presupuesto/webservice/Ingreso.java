
package presupuesto.webservice;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ingreso complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ingreso">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ano_eje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ejecucion" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="fuente_financ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id_clasificador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="modificacion" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="origen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="presupuesto" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="sec_ejec" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipo_recurso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ingreso", propOrder = {
    "anoEje",
    "ejecucion",
    "fuenteFinanc",
    "idClasificador",
    "modificacion",
    "origen",
    "presupuesto",
    "secEjec",
    "tipoRecurso"
})
public class Ingreso {

    @XmlElement(name = "ano_eje")
    protected String anoEje;
    protected BigDecimal ejecucion;
    @XmlElement(name = "fuente_financ")
    protected String fuenteFinanc;
    @XmlElement(name = "id_clasificador")
    protected String idClasificador;
    protected BigDecimal modificacion;
    protected String origen;
    protected BigDecimal presupuesto;
    @XmlElement(name = "sec_ejec")
    protected String secEjec;
    @XmlElement(name = "tipo_recurso")
    protected String tipoRecurso;

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
     * Obtiene el valor de la propiedad ejecucion.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEjecucion() {
        return ejecucion;
    }

    /**
     * Define el valor de la propiedad ejecucion.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEjecucion(BigDecimal value) {
        this.ejecucion = value;
    }

    /**
     * Obtiene el valor de la propiedad fuenteFinanc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFuenteFinanc() {
        return fuenteFinanc;
    }

    /**
     * Define el valor de la propiedad fuenteFinanc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFuenteFinanc(String value) {
        this.fuenteFinanc = value;
    }

    /**
     * Obtiene el valor de la propiedad idClasificador.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdClasificador() {
        return idClasificador;
    }

    /**
     * Define el valor de la propiedad idClasificador.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdClasificador(String value) {
        this.idClasificador = value;
    }

    /**
     * Obtiene el valor de la propiedad modificacion.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getModificacion() {
        return modificacion;
    }

    /**
     * Define el valor de la propiedad modificacion.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setModificacion(BigDecimal value) {
        this.modificacion = value;
    }

    /**
     * Obtiene el valor de la propiedad origen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * Define el valor de la propiedad origen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigen(String value) {
        this.origen = value;
    }

    /**
     * Obtiene el valor de la propiedad presupuesto.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPresupuesto() {
        return presupuesto;
    }

    /**
     * Define el valor de la propiedad presupuesto.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPresupuesto(BigDecimal value) {
        this.presupuesto = value;
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
     * Obtiene el valor de la propiedad tipoRecurso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoRecurso() {
        return tipoRecurso;
    }

    /**
     * Define el valor de la propiedad tipoRecurso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoRecurso(String value) {
        this.tipoRecurso = value;
    }

}
