package presupuesto.bean;

/**
 * @author CARLOS SANTANDER
 */
public class Ejecutora {

    private String ano_eje;
    private String sec_ejec;
    private String pliego;
    private String ejecutora;
    private String nombre;
    private String estado;

    public Ejecutora() {
    }

    public String getAno_eje() {
        return ano_eje;
    }

    public void setAno_eje(String ano_eje) {
        this.ano_eje = ano_eje;
    }

    public String getSec_ejec() {
        return sec_ejec;
    }

    public void setSec_ejec(String sec_ejec) {
        this.sec_ejec = sec_ejec;
    }

    public String getPliego() {
        return pliego;
    }

    public void setPliego(String pliego) {
        this.pliego = pliego;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
