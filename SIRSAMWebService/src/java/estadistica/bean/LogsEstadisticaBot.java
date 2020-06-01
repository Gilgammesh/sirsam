package estadistica.bean;

import java.sql.Timestamp;

/**
 * @author CARLOS SANTANDER
 */
public class LogsEstadisticaBot {

    private Timestamp fecha_hora;
    private String fuente;
    private String hostname;
    private String ip_local;
    private String actualizo;
    private String error_fuente;
    private String error_postgresql;

    public LogsEstadisticaBot() {
    }

    public Timestamp getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Timestamp fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getIp_local() {
        return ip_local;
    }

    public void setIp_local(String ip_local) {
        this.ip_local = ip_local;
    }

    public String getActualizo() {
        return actualizo;
    }

    public void setActualizo(String actualizo) {
        this.actualizo = actualizo;
    }

    public String getError_fuente() {
        return error_fuente;
    }

    public void setError_fuente(String error_fuente) {
        this.error_fuente = error_fuente;
    }

    public String getError_postgresql() {
        return error_postgresql;
    }

    public void setError_postgresql(String error_postgresql) {
        this.error_postgresql = error_postgresql;
    }

}
