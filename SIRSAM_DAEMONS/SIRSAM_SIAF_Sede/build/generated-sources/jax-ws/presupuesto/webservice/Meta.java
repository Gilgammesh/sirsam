
package presupuesto.webservice;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para meta complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="meta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="act_proy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ano_eje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cantidad" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="cantidad_semestral" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="componente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="departamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="distrito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="finalidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="funcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="meta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="programa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="programa_ppto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="provincia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sec_ejec" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sec_func" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sub_programa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="unidad_medida" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "meta", propOrder = {
    "actProy",
    "anoEje",
    "cantidad",
    "cantidadSemestral",
    "componente",
    "departamento",
    "distrito",
    "estado",
    "finalidad",
    "funcion",
    "meta",
    "programa",
    "programaPpto",
    "provincia",
    "secEjec",
    "secFunc",
    "subPrograma",
    "unidadMedida"
})
public class Meta {

    @XmlElement(name = "act_proy")
    protected String actProy;
    @XmlElement(name = "ano_eje")
    protected String anoEje;
    protected BigDecimal cantidad;
    @XmlElement(name = "cantidad_semestral")
    protected BigDecimal cantidadSemestral;
    protected String componente;
    protected String departamento;
    protected String distrito;
    protected String estado;
    protected String finalidad;
    protected String funcion;
    protected String meta;
    protected String programa;
    @XmlElement(name = "programa_ppto")
    protected String programaPpto;
    protected String provincia;
    @XmlElement(name = "sec_ejec")
    protected String secEjec;
    @XmlElement(name = "sec_func")
    protected String secFunc;
    @XmlElement(name = "sub_programa")
    protected String subPrograma;
    @XmlElement(name = "unidad_medida")
    protected String unidadMedida;

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
     * Obtiene el valor de la propiedad cantidad.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCantidad() {
        return cantidad;
    }

    /**
     * Define el valor de la propiedad cantidad.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCantidad(BigDecimal value) {
        this.cantidad = value;
    }

    /**
     * Obtiene el valor de la propiedad cantidadSemestral.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCantidadSemestral() {
        return cantidadSemestral;
    }

    /**
     * Define el valor de la propiedad cantidadSemestral.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCantidadSemestral(BigDecimal value) {
        this.cantidadSemestral = value;
    }

    /**
     * Obtiene el valor de la propiedad componente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComponente() {
        return componente;
    }

    /**
     * Define el valor de la propiedad componente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComponente(String value) {
        this.componente = value;
    }

    /**
     * Obtiene el valor de la propiedad departamento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Define el valor de la propiedad departamento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartamento(String value) {
        this.departamento = value;
    }

    /**
     * Obtiene el valor de la propiedad distrito.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistrito() {
        return distrito;
    }

    /**
     * Define el valor de la propiedad distrito.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistrito(String value) {
        this.distrito = value;
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
     * Obtiene el valor de la propiedad finalidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinalidad() {
        return finalidad;
    }

    /**
     * Define el valor de la propiedad finalidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinalidad(String value) {
        this.finalidad = value;
    }

    /**
     * Obtiene el valor de la propiedad funcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFuncion() {
        return funcion;
    }

    /**
     * Define el valor de la propiedad funcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFuncion(String value) {
        this.funcion = value;
    }

    /**
     * Obtiene el valor de la propiedad meta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeta() {
        return meta;
    }

    /**
     * Define el valor de la propiedad meta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeta(String value) {
        this.meta = value;
    }

    /**
     * Obtiene el valor de la propiedad programa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrograma() {
        return programa;
    }

    /**
     * Define el valor de la propiedad programa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrograma(String value) {
        this.programa = value;
    }

    /**
     * Obtiene el valor de la propiedad programaPpto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgramaPpto() {
        return programaPpto;
    }

    /**
     * Define el valor de la propiedad programaPpto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgramaPpto(String value) {
        this.programaPpto = value;
    }

    /**
     * Obtiene el valor de la propiedad provincia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Define el valor de la propiedad provincia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvincia(String value) {
        this.provincia = value;
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
     * Obtiene el valor de la propiedad subPrograma.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubPrograma() {
        return subPrograma;
    }

    /**
     * Define el valor de la propiedad subPrograma.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubPrograma(String value) {
        this.subPrograma = value;
    }

    /**
     * Obtiene el valor de la propiedad unidadMedida.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnidadMedida() {
        return unidadMedida;
    }

    /**
     * Define el valor de la propiedad unidadMedida.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnidadMedida(String value) {
        this.unidadMedida = value;
    }

}
