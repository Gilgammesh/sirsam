
package presupuesto.webservice;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para notaModificatoriaDet complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="notaModificatoriaDet">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ano_eje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fuente_financ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id_clasificador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="monto_a" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="monto_de" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="origen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sec_ejec" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sec_ejec2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sec_func" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sec_nota" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "notaModificatoriaDet", propOrder = {
    "anoEje",
    "fuenteFinanc",
    "idClasificador",
    "montoA",
    "montoDe",
    "origen",
    "secEjec",
    "secEjec2",
    "secFunc",
    "secNota",
    "tipoRecurso"
})
public class NotaModificatoriaDet {

    @XmlElement(name = "ano_eje")
    protected String anoEje;
    @XmlElement(name = "fuente_financ")
    protected String fuenteFinanc;
    @XmlElement(name = "id_clasificador")
    protected String idClasificador;
    @XmlElement(name = "monto_a")
    protected BigDecimal montoA;
    @XmlElement(name = "monto_de")
    protected BigDecimal montoDe;
    protected String origen;
    @XmlElement(name = "sec_ejec")
    protected String secEjec;
    @XmlElement(name = "sec_ejec2")
    protected String secEjec2;
    @XmlElement(name = "sec_func")
    protected String secFunc;
    @XmlElement(name = "sec_nota")
    protected String secNota;
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
     * Obtiene el valor de la propiedad montoA.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoA() {
        return montoA;
    }

    /**
     * Define el valor de la propiedad montoA.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoA(BigDecimal value) {
        this.montoA = value;
    }

    /**
     * Obtiene el valor de la propiedad montoDe.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoDe() {
        return montoDe;
    }

    /**
     * Define el valor de la propiedad montoDe.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoDe(BigDecimal value) {
        this.montoDe = value;
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
