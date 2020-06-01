package beans;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author CARLOS SANTANDER
 */
public class Sincronizacion {

    private String sec_ejec;
    private String ejecutora;
    private String nombre;
    private Date fecha;
    private Timestamp fechaHora;
    private String tabla;
    private String hostname;
    private String ipLocal;
    private String sincronizo;
    private String logCliente;
    private String logServidor;

    public Sincronizacion() {
    }

    public String getSec_ejec() {
        return sec_ejec;
    }

    public void setSec_ejec(String sec_ejec) {
        this.sec_ejec = sec_ejec;
    }

    public String getEjecutora() {
        return ejecutora;
    }

    public void setEjecutora(String ejecutora) {
        this.ejecutora = ejecutora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getIpLocal() {
        return ipLocal;
    }

    public void setIpLocal(String ipLocal) {
        this.ipLocal = ipLocal;
    }

    public String getSincronizo() {
        return sincronizo;
    }

    public void setSincronizo(String sincronizo) {
        this.sincronizo = sincronizo;
    }

    public String getLogCliente() {
        return logCliente;
    }

    public void setLogCliente(String logCliente) {
        this.logCliente = logCliente;
    }

    public String getLogServidor() {
        return logServidor;
    }

    public void setLogServidor(String logServidor) {
        this.logServidor = logServidor;
    }

}
