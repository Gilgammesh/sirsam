
package presupuesto.webservice;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para notaModificatoriaCab complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="notaModificatoriaCab">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ano_eje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ind_habilita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mes_eje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="monto" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="sec_ejec" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sec_ejec2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sec_ejec_procedencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sec_nota" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipo_modificacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "notaModificatoriaCab", propOrder = {
    "anoEje",
    "indHabilita",
    "mesEje",
    "monto",
    "secEjec",
    "secEjec2",
    "secEjecProcedencia",
    "secNota",
    "tipoModificacion"
})
public class NotaModificatoriaCab {

    @XmlElement(name = "ano_eje")
    protected String anoEje;
    @XmlElement(name = "ind_habilita")
    protected String indHabilita;
    @XmlElement(name = "mes_eje")
    protected String mesEje;
    protected BigDecimal monto;
    @XmlElement(name = "sec_ejec")
    protected String secEjec;
    @XmlElement(name = "sec_ejec2")
    protected String secEjec2;
    @XmlElement(name = "sec_ejec_procedencia")
    protected String secEjecProcedencia;
    @XmlElement(name = "sec_nota")
    protected String secNota;
    @XmlElement(name = "tipo_modificacion")
    protected String tipoModificacion;

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
     * Obtiene el valor de la propiedad indHabilita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndHabilita() {
        return indHabilita;
    }

    /**
     * Define el valor de la propiedad indHabilita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndHabilita(String value) {
        this.indHabilita = value;
    }

    /**
     * Obtiene el valor de la propiedad mesEje.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMesEje() {
        return mesEje;
    }

    /**
     * Define el valor de la propiedad mesEje.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMesEje(String value) {
        this.mesEje = value;
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
     * Obtiene el valor de la propiedad secEjecProcedencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecEjecProcedencia() {
        return secEjecProcedencia;
    }

    /**
     * Define el valor de la propiedad secEjecProcedencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecEjecProcedencia(String value) {
        this.secEjecProcedencia = value;
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
     * Obtiene el valor de la propiedad tipoModificacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoModificacion() {
        return tipoModificacion;
    }

    /**
     * Define el valor de la propiedad tipoModificacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoModificacion(String value) {
        this.tipoModificacion = value;
    }

}
