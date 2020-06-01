package presupuesto.bean;

/**
 * @author CARLOS SANTANDER
 */
public class CategoriaIngreso {

    private String ano_eje;
    private String categoria_ingreso;
    private String descripcion;
    private String estado;

    public CategoriaIngreso() {
    }

    public String getAno_eje() {
        return ano_eje;
    }

    public void setAno_eje(String ano_eje) {
        this.ano_eje = ano_eje;
    }

    public String getCategoria_ingreso() {
        return categoria_ingreso;
    }

    public void setCategoria_ingreso(String categoria_ingreso) {
        this.categoria_ingreso = categoria_ingreso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
