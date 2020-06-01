package presupuesto.bean;

/**
 * @author CARLOS SANTANDER
 */
public class TipoTransaccion {

    private String ano_eje;
    private String tipo_transaccion;
    private String descripcion;
    private String estado;

    public TipoTransaccion() {
    }

    public String getAno_eje() {
        return ano_eje;
    }

    public void setAno_eje(String ano_eje) {
        this.ano_eje = ano_eje;
    }

    public String getTipo_transaccion() {
        return tipo_transaccion;
    }

    public void setTipo_transaccion(String tipo_transaccion) {
        this.tipo_transaccion = tipo_transaccion;
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
