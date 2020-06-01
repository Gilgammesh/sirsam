
package presupuesto.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para insertLogsSincronizar complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="insertLogsSincronizar">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ejec" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tabla" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="host" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sync" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="log_cliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="log_servidor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertLogsSincronizar", propOrder = {
    "time",
    "ejec",
    "tabla",
    "host",
    "ip",
    "sync",
    "logCliente",
    "logServidor"
})
public class InsertLogsSincronizar {

    protected long time;
    protected String ejec;
    protected String tabla;
    protected String host;
    protected String ip;
    protected String sync;
    @XmlElement(name = "log_cliente")
    protected String logCliente;
    @XmlElement(name = "log_servidor")
    protected String logServidor;

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

    /**
     * Obtiene el valor de la propiedad sync.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSync() {
        return sync;
    }

    /**
     * Define el valor de la propiedad sync.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSync(String value) {
        this.sync = value;
    }

    /**
     * Obtiene el valor de la propiedad logCliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogCliente() {
        return logCliente;
    }

    /**
     * Define el valor de la propiedad logCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogCliente(String value) {
        this.logCliente = value;
    }

    /**
     * Obtiene el valor de la propiedad logServidor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogServidor() {
        return logServidor;
    }

    /**
     * Define el valor de la propiedad logServidor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogServidor(String value) {
        this.logServidor = value;
    }

}
