package presupuesto.bean;

/**
 * @author CARLOS SANTANDER
 */
public class Banco {

    private String banco;
    private String nombre;
    private String estado;
    private String es_financiera;
    private String sec_ejec_ruc;

    public Banco() {
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
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

    public String getEs_financiera() {
        return es_financiera;
    }

    public void setEs_financiera(String es_financiera) {
        this.es_financiera = es_financiera;
    }

    public String getSec_ejec_ruc() {
        return sec_ejec_ruc;
    }

    public void setSec_ejec_ruc(String sec_ejec_ruc) {
        this.sec_ejec_ruc = sec_ejec_ruc;
    }

}
