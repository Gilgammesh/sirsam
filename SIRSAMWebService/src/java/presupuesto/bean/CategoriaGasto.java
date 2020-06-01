package presupuesto.bean;

/**
 * @author CARLOS SANTANDER
 */
public class CategoriaGasto {

    private String ano_eje;
    private String categ_gasto;
    private String nombre;
    private String estado;

    public CategoriaGasto() {
    }

    public String getAno_eje() {
        return ano_eje;
    }

    public void setAno_eje(String ano_eje) {
        this.ano_eje = ano_eje;
    }

    public String getCateg_gasto() {
        return categ_gasto;
    }

    public void setCateg_gasto(String categ_gasto) {
        this.categ_gasto = categ_gasto;
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
