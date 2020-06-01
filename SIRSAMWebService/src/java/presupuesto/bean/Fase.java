package presupuesto.bean;

/**
 * @author CARLOS SANTANDER
 */
public class Fase {

    private String ciclo;
    private String fase;
    private String nombre;

    public Fase() {
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
