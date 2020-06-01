package inversion.bean;

import java.sql.Timestamp;

/**
 * @author CARLOS SANTANDER
 */
public class LogsProyectosBot {

    private Timestamp fecha_hora;
    private String tabla;
    private String codigo_siaf;
    private String hostname;
    private String ip_local;
    private String actualizo;
    private String error_selenium;
    private String error_postgresql;

    public LogsProyectosBot() {
    }

    public Timestamp getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Timestamp fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getCodigo_siaf() {
        return codigo_siaf;
    }

    public void setCodigo_siaf(String codigo_siaf) {
        this.codigo_siaf = codigo_siaf;
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

    public String getError_selenium() {
        return error_selenium;
    }

    public void setError_selenium(String error_selenium) {
        this.error_selenium = error_selenium;
    }

    public String getError_postgresql() {
        return error_postgresql;
    }

    public void setError_postgresql(String error_postgresql) {
        this.error_postgresql = error_postgresql;
    }

}
