
package estadistica.webservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para upsertInstitucionEducativa complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="upsertInstitucionEducativa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="data" type="{http://webservice.estadistica/}institucionEducativa" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="fuente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="host" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "upsertInstitucionEducativa", propOrder = {
    "data",
    "time",
    "fuente",
    "host",
    "ip"
})
public class UpsertInstitucionEducativa {

    protected List<InstitucionEducativa> data;
    protected long time;
    protected String fuente;
    protected String host;
    protected String ip;

    /**
     * Gets the value of the data property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the data property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InstitucionEducativa }
     * 
     * 
     */
    public List<InstitucionEducativa> getData() {
        if (data == null) {
            data = new ArrayList<InstitucionEducativa>();
        }
        return this.data;
    }

    /**
     * Obtiene el valor de la propiedad time.
     * 
     */
    public long getTime() {
        return time;
    }

    /**
     * Define el valor de la propiedad time.
     * 
     */
    public void setTime(long value) {
        this.time = value;
    }

    /**
     * Obtiene el valor de la propiedad fuente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFuente() {
        return fuente;
    }

    /**
     * Define el valor de la propiedad fuente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFuente(String value) {
        this.fuente = value;
    }

    /**
     * Obtiene el valor de la propiedad host.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHost() {
        return host;
    }

    /**
     * Define el valor de la propiedad host.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHost(String value) {
        this.host = value;
    }

    /**
     * Obtiene el valor de la propiedad ip.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIp() {
        return ip;
    }

    /**
     * Define el valor de la propiedad ip.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIp(String value) {
        this.ip = value;
    }

}
