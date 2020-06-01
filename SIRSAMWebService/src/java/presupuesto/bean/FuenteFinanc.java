package presupuesto.bean;

/**
 * @author CARLOS SANTANDER
 */
public class FuenteFinanc {

    private String ano_eje;
    private String fuente_financ;
    private String nombre;
    private String estado;
    private String fuente_financ_agregada;

    public FuenteFinanc() {
    }

    public String getAno_eje() {
        return ano_eje;
    }

    public void setAno_eje(String ano_eje) {
        this.ano_eje = ano_eje;
    }

    public String getFuente_financ() {
        return fuente_financ;
    }

    public void setFuente_financ(String fuente_financ) {
        this.fuente_financ = fuente_financ;
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

    public String getFuente_financ_agregada() {
        return fuente_financ_agregada;
    }

    public void setFuente_financ_agregada(String fuente_financ_agregada) {
        this.fuente_financ_agregada = fuente_financ_agregada;
    }
 
}
