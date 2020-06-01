package presupuesto.bean;

/**
 * @author CARLOS SANTANDER
 */
public class UnidadMedida {

    private String unidad_medida;
    private String nombre;
    private String estado;

    public UnidadMedida() {
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
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
