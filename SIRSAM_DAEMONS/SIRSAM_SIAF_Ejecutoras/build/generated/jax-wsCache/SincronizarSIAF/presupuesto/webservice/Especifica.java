
package presupuesto.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para especifica complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="especifica">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ano_eje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="clasificador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="especifica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="generica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subgenerica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subgenerica_det" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipo_transaccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "especifica", propOrder = {
    "anoEje",
    "clasificador",
    "descripcion",
    "especifica",
    "estado",
    "generica",
    "subgenerica",
    "subgenericaDet",
    "tipoTransaccion"
})
public class Especifica {

    @XmlElement(name = "ano_eje")
    protected String anoEje;
    protected String clasificador;
    protected String descripcion;
    protected String especifica;
    protected String estado;
    protected String generica;
    protected String subgenerica;
    @XmlElement(name = "subgenerica_det")
    protected String subgenericaDet;
    @XmlElement(name = "tipo_transaccion")
    protected String tipoTransaccion;

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
     * Obtiene el valor de la propiedad clasificador.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClasificador() {
        return clasificador;
    }

    /**
     * Define el valor de la propiedad clasificador.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClasificador(String value) {
        this.clasificador = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad especifica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEspecifica() {
        return especifica;
    }

    /**
     * Define el valor de la propiedad especifica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEspecifica(String value) {
        this.especifica = value;
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
     * Obtiene el valor de la propiedad generica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenerica() {
        return generica;
    }

    /**
     * Define el valor de la propiedad generica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenerica(String value) {
        this.generica = value;
    }

    /**
     * Obtiene el valor de la propiedad subgenerica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubgenerica() {
        return subgenerica;
    }

    /**
     * Define el valor de la propiedad subgenerica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubgenerica(String value) {
        this.subgenerica = value;
    }

    /**
     * Obtiene el valor de la propiedad subgenericaDet.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubgenericaDet() {
        return subgenericaDet;
    }

    /**
     * Define el valor de la propiedad subgenericaDet.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubgenericaDet(String value) {
        this.subgenericaDet = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoTransaccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    /**
     * Define el valor de la propiedad tipoTransaccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoTransaccion(String value) {
        this.tipoTransaccion = value;
    }

}
