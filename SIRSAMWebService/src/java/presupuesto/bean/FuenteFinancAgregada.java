package presupuesto.bean;

/**
 * @author CARLOS SANTANDER
 */
public class FuenteFinancAgregada {

    private String ano_eje;
    private String fuente_financ_agregada;
    private String nombre;
    private String estado;

    public FuenteFinancAgregada() {
    }

    public String getAno_eje() {
        return ano_eje;
    }

    public void setAno_eje(String ano_eje) {
        this.ano_eje = ano_eje;
    }

    public String getFuente_financ_agregada() {
        return fuente_financ_agregada;
    }

    public void setFuente_financ_agregada(String fuente_financ_agregada) {
        this.fuente_financ_agregada = fuente_financ_agregada;
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
