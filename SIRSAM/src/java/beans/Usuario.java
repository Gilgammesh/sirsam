package beans;

/**
 * @author CARLOS SANTANDER
 */
public class Usuario {

    private Integer usuaId;
    private String usuaLogin;
    private String usuaClave;
    private String usuaNombres;
    private String usuaApellidoPaterno;
    private String usuaApellidoMaterno;
    private String usuaSexo;
    private Integer perfId;
    private String perfNombre;
    private String perfDescripcion;
    private Boolean usuaEstado;
    private String sec_ejec;
    private String ejecutora;
    private String nombre;
    private Boolean registra;
    private Boolean activo;
    private Integer menuId;
    private String menuNombre;
    private String menuDescripcion;

    public Usuario() {
    }

    public Integer getUsuaId() {
        return usuaId;
    }

    public void setUsuaId(Integer usuaId) {
        this.usuaId = usuaId;
    }

    public String getUsuaLogin() {
        return usuaLogin;
    }

    public void setUsuaLogin(String usuaLogin) {
        this.usuaLogin = usuaLogin;
    }

    public String getUsuaClave() {
        return usuaClave;
    }

    public void setUsuaClave(String usuaClave) {
        this.usuaClave = usuaClave;
    }

    public String getUsuaNombres() {
        return usuaNombres;
    }

    public void setUsuaNombres(String usuaNombres) {
        this.usuaNombres = usuaNombres;
    }

    public String getUsuaApellidoPaterno() {
        return usuaApellidoPaterno;
    }

    public void setUsuaApellidoPaterno(String usuaApellidoPaterno) {
        this.usuaApellidoPaterno = usuaApellidoPaterno;
    }

    public String getUsuaApellidoMaterno() {
        return usuaApellidoMaterno;
    }

    public void setUsuaApellidoMaterno(String usuaApellidoMaterno) {
        this.usuaApellidoMaterno = usuaApellidoMaterno;
    }

    public String getUsuaSexo() {
        return usuaSexo;
    }

    public void setUsuaSexo(String usuaSexo) {
        this.usuaSexo = usuaSexo;
    }

    public Integer getPerfId() {
        return perfId;
    }

    public void setPerfId(Integer perfId) {
        this.perfId = perfId;
    }

    public String getPerfNombre() {
        return perfNombre;
    }

    public void setPerfNombre(String perfNombre) {
        this.perfNombre = perfNombre;
    }

    public String getPerfDescripcion() {
        return perfDescripcion;
    }

    public void setPerfDescripcion(String perfDescripcion) {
        this.perfDescripcion = perfDescripcion;
    }

    public Boolean getUsuaEstado() {
        return usuaEstado;
    }

    public void setUsuaEstado(Boolean usuaEstado) {
        this.usuaEstado = usuaEstado;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuNombre() {
        return menuNombre;
    }

    public void setMenuNombre(String menuNombre) {
        this.menuNombre = menuNombre;
    }

    public String getSec_ejec() {
        return sec_ejec;
    }

    public void setSec_ejec(String sec_ejec) {
        this.sec_ejec = sec_ejec;
    }

    public Boolean getRegistra() {
        return registra;
    }

    public void setRegistra(Boolean registra) {
        this.registra = registra;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getEjecutora() {
        return ejecutora;
    }

    public void setEjecutora(String ejecutora) {
        this.ejecutora = ejecutora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMenuDescripcion() {
        return menuDescripcion;
    }

    public void setMenuDescripcion(String menuDescripcion) {
        this.menuDescripcion = menuDescripcion;
    }

}
