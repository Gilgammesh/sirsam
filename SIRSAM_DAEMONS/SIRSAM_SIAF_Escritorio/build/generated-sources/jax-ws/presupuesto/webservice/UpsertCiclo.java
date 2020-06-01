
package presupuesto.webservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para upsertCiclo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="upsertCiclo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dataCiclo" type="{http://webservice.presupuesto/}ciclo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ejec" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tabla" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "upsertCiclo", propOrder = {
    "dataCiclo",
    "time",
    "ejec",
    "tabla",
    "host",
    "ip"
})
public class UpsertCiclo {

    protected List<Ciclo> dataCiclo;
    protected long time;
    protected String ejec;
    protected String tabla;
    protected String host;
    protected String ip;

    /**
     * Gets the value of the dataCiclo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dataCiclo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDataCiclo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Ciclo }
     * 
     * 
     */
    public List<Ciclo> getDataCiclo() {
        if (dataCiclo == null) {
            dataCiclo = new ArrayList<Ciclo>();
        }
        return this.dataCiclo;
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
     * Obtiene el valor de la propiedad ejec.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEjec() {
        return ejec;
    }

    /**
     * Define el valor de la propiedad ejec.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEjec(String value) {
        this.ejec = value;
    }

    /**
     * Obtiene el valor de la propiedad tabla.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTabla() {
        return tabla;
    }

    /**
     * Define el valor de la propiedad tabla.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTabla(String value) {
        this.tabla = value;
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
