package presupuesto.bean;

/**
 * @author CARLOS SANTANDER
 */
public class TipoDocumento {

    private String tipo_documento;
    private String nombre;
    private String estado;

    public TipoDocumento() {
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
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
