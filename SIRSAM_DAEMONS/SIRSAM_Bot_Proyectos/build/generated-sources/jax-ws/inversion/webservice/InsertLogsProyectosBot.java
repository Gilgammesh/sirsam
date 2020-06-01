
package inversion.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para insertLogsProyectosBot complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="insertLogsProyectosBot">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="tabla" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="host" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="actualizo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "insertLogsProyectosBot", propOrder = {
    "time",
    "tabla",
    "codigo",
    "host",
    "ip",
    "actualizo",
    "logCliente",
    "logServidor"
})
public class InsertLogsProyectosBot {

    protected long time;
    protected String tabla;
    protected String codigo;
    protected String host;
    protected String ip;
    protected String actualizo;
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
     * Obtiene el valor de la propiedad codigo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Define el valor de la propiedad codigo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigo(String value) {
        this.codigo = value;
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
     * Obtiene el valor de la propiedad actualizo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActualizo() {
        return actualizo;
    }

    /**
     * Define el valor de la propiedad actualizo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActualizo(String value) {
        this.actualizo = value;
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
