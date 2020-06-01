
package presupuesto.webservice;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para gasto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="gasto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ano_eje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="compromiso" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="devengado" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ejecucion" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="fuente_financ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="girado" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="id_clasificador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="modificacion" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="monto_certificado" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="monto_comprometido_anual" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="monto_precertificado" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="origen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pagado" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="presupuesto" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="sec_ejec" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sec_func" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "gasto", propOrder = {
    "anoEje",
    "compromiso",
    "devengado",
    "ejecucion",
    "fuenteFinanc",
    "girado",
    "idClasificador",
    "modificacion",
    "montoCertificado",
    "montoComprometidoAnual",
    "montoPrecertificado",
    "origen",
    "pagado",
    "presupuesto",
    "secEjec",
    "secFunc",
    "tipoRecurso"
})
public class Gasto {

    @XmlElement(name = "ano_eje")
    protected String anoEje;
    protected BigDecimal compromiso;
    protected BigDecimal devengado;
    protected BigDecimal ejecucion;
    @XmlElement(name = "fuente_financ")
    protected String fuenteFinanc;
    protected BigDecimal girado;
    @XmlElement(name = "id_clasificador")
    protected String idClasificador;
    protected BigDecimal modificacion;
    @XmlElement(name = "monto_certificado")
    protected BigDecimal montoCertificado;
    @XmlElement(name = "monto_comprometido_anual")
    protected BigDecimal montoComprometidoAnual;
    @XmlElement(name = "monto_precertificado")
    protected BigDecimal montoPrecertificado;
    protected String origen;
    protected BigDecimal pagado;
    protected BigDecimal presupuesto;
    @XmlElement(name = "sec_ejec")
    protected String secEjec;
    @XmlElement(name = "sec_func")
    protected String secFunc;
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
     * Obtiene el valor de la propiedad compromiso.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCompromiso() {
        return compromiso;
    }

    /**
     * Define el valor de la propiedad compromiso.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCompromiso(BigDecimal value) {
        this.compromiso = value;
    }

    /**
     * Obtiene el valor de la propiedad devengado.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDevengado() {
        return devengado;
    }

    /**
     * Define el valor de la propiedad devengado.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDevengado(BigDecimal value) {
        this.devengado = value;
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
     * Obtiene el valor de la propiedad girado.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getGirado() {
        return girado;
    }

    /**
     * Define el valor de la propiedad girado.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setGirado(BigDecimal value) {
        this.girado = value;
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
     * Obtiene el valor de la propiedad montoCertificado.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoCertificado() {
        return montoCertificado;
    }

    /**
     * Define el valor de la propiedad montoCertificado.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoCertificado(BigDecimal value) {
        this.montoCertificado = value;
    }

    /**
     * Obtiene el valor de la propiedad montoComprometidoAnual.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoComprometidoAnual() {
        return montoComprometidoAnual;
    }

    /**
     * Define el valor de la propiedad montoComprometidoAnual.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoComprometidoAnual(BigDecimal value) {
        this.montoComprometidoAnual = value;
    }

    /**
     * Obtiene el valor de la propiedad montoPrecertificado.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoPrecertificado() {
        return montoPrecertificado;
    }

    /**
     * Define el valor de la propiedad montoPrecertificado.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoPrecertificado(BigDecimal value) {
        this.montoPrecertificado = value;
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
     * Obtiene el valor de la propiedad pagado.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPagado() {
        return pagado;
    }

    /**
     * Define el valor de la propiedad pagado.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPagado(BigDecimal value) {
        this.pagado = value;
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
