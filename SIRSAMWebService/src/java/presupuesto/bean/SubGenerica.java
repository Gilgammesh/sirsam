package presupuesto.bean;

/**
 * @author CARLOS SANTANDER
 */
public class SubGenerica {

    private String ano_eje;
    private String tipo_transaccion;
    private String generica;
    private String subgenerica;
    private String clasificador;
    private String descripcion;
    private String estado;

    public SubGenerica() {
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

    public String getGenerica() {
        return generica;
    }

    public void setGenerica(String generica) {
        this.generica = generica;
    }

    public String getSubgenerica() {
        return subgenerica;
    }

    public void setSubgenerica(String subgenerica) {
        this.subgenerica = subgenerica;
    }

    public String getClasificador() {
        return clasificador;
    }

    public void setClasificador(String clasificador) {
        this.clasificador = clasificador;
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
