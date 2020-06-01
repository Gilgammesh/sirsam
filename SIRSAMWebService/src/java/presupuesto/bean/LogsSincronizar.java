package presupuesto.bean;

import java.sql.Timestamp;

/**
 * @author CARLOS SANTANDER
 */
public class LogsSincronizar {

    private Timestamp fecha_hora;
    private String sec_ejec;
    private String tabla;
    private String hostname;
    private String ip_local;
    private String sincronizo;
    private String log_cliente;
    private String log_servidor;

    public LogsSincronizar() {
    }

    public Timestamp getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Timestamp fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getSec_ejec() {
        return sec_ejec;
    }

    public void setSec_ejec(String sec_ejec) {
        this.sec_ejec = sec_ejec;
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

    public String getIp_local() {
        return ip_local;
    }

    public void setIp_local(String ip_local) {
        this.ip_local = ip_local;
    }

    public String getSincronizo() {
        return sincronizo;
    }

    public void setSincronizo(String sincronizo) {
        this.sincronizo = sincronizo;
    }

    public String getLog_cliente() {
        return log_cliente;
    }

    public void setLog_cliente(String log_cliente) {
        this.log_cliente = log_cliente;
    }

    public String getLog_servidor() {
        return log_servidor;
    }

    public void setLog_servidor(String log_servidor) {
        this.log_servidor = log_servidor;
    }

}
