package presupuesto.bean;

/**
 * @author CARLOS SANTANDER
 */
public class EspecificaDet {

    private String ano_eje;
    private String tipo_transaccion;
    private String generica;
    private String subgenerica;
    private String subgenerica_det;
    private String especifica;
    private String especifica_det;
    private String clasificador;
    private String id_clasificador;
    private String descripcion;
    private String estado;

    public EspecificaDet() {
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

    public String getSubgenerica_det() {
        return subgenerica_det;
    }

    public void setSubgenerica_det(String subgenerica_det) {
        this.subgenerica_det = subgenerica_det;
    }

    public String getEspecifica() {
        return especifica;
    }

    public void setEspecifica(String especifica) {
        this.especifica = especifica;
    }

    public String getEspecifica_det() {
        return especifica_det;
    }

    public void setEspecifica_det(String especifica_det) {
        this.especifica_det = especifica_det;
    }

    public String getClasificador() {
        return clasificador;
    }

    public void setClasificador(String clasificador) {
        this.clasificador = clasificador;
    }

    public String getId_clasificador() {
        return id_clasificador;
    }

    public void setId_clasificador(String id_clasificador) {
        this.id_clasificador = id_clasificador;
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
