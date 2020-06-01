package presupuesto.bean;

/**
 * @author CARLOS SANTANDER
 */
public class TipoProgramaPpto {

    private String ano_eje;
    private String tipo_programa_ppto;
    private String nombre;
    private String descripcion;
    private String estado;

    public TipoProgramaPpto() {
    }

    public String getAno_eje() {
        return ano_eje;
    }

    public void setAno_eje(String ano_eje) {
        this.ano_eje = ano_eje;
    }

    public String getTipo_programa_ppto() {
        return tipo_programa_ppto;
    }

    public void setTipo_programa_ppto(String tipo_programa_ppto) {
        this.tipo_programa_ppto = tipo_programa_ppto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
