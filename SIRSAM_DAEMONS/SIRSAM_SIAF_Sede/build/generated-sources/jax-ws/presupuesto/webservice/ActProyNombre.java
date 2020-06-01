
package presupuesto.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para actProyNombre complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="actProyNombre">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="act_proy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ano_eje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="es_foniprel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proyecto_snip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipo_act_proy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actProyNombre", propOrder = {
    "actProy",
    "anoEje",
    "esFoniprel",
    "estado",
    "nombre",
    "proyectoSnip",
    "tipoActProy"
})
public class ActProyNombre {

    @XmlElement(name = "act_proy")
    protected String actProy;
    @XmlElement(name = "ano_eje")
    protected String anoEje;
    @XmlElement(name = "es_foniprel")
    protected String esFoniprel;
    protected String estado;
    protected String nombre;
    @XmlElement(name = "proyecto_snip")
    protected String proyectoSnip;
    @XmlElement(name = "tipo_act_proy")
    protected String tipoActProy;

    /**
     * Obtiene el valor de la propiedad actProy.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActProy() {
        return actProy;
    }

    /**
     * Define el valor de la propiedad actProy.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActProy(String value) {
        this.actProy = value;
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
     * Obtiene el valor de la propiedad esFoniprel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEsFoniprel() {
        return esFoniprel;
    }

    /**
     * Define el valor de la propiedad esFoniprel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEsFoniprel(String value) {
        this.esFoniprel = value;
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
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad proyectoSnip.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProyectoSnip() {
        return proyectoSnip;
    }

    /**
     * Define el valor de la propiedad proyectoSnip.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProyectoSnip(String value) {
        this.proyectoSnip = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoActProy.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoActProy() {
        return tipoActProy;
    }

    /**
     * Define el valor de la propiedad tipoActProy.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoActProy(String value) {
        this.tipoActProy = value;
    }

}
