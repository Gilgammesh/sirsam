package beans;

import java.sql.Timestamp;

/**
 * @author CARLOS SANTANDER
 */
public class Sesion {

    private Timestamp inicioNavega;
    private String sesiId;
    private Integer usuaId;
    private String browser;
    private String device;
    private Timestamp finNavega;
    private Timestamp inicioLogin;
    private Timestamp finLogin;
    private Boolean sesiNavega;
    private Boolean sesiLogin;
    private Integer menuId;
    private String menuNombre;
    private String menuDescripcion;
    private String dni;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String sexo;

    public Sesion() {
    }

    public Timestamp getInicioNavega() {
        return inicioNavega;
    }

    public void setInicioNavega(Timestamp inicioNavega) {
        this.inicioNavega = inicioNavega;
    }

    public String getSesiId() {
        return sesiId;
    }

    public void setSesiId(String sesiId) {
        this.sesiId = sesiId;
    }

    public Integer getUsuaId() {
        return usuaId;
    }

    public void setUsuaId(Integer usuaId) {
        this.usuaId = usuaId;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public Timestamp getFinNavega() {
        return finNavega;
    }

    public void setFinNavega(Timestamp finNavega) {
        this.finNavega = finNavega;
    }

    public Timestamp getInicioLogin() {
        return inicioLogin;
    }

    public void setInicioLogin(Timestamp inicioLogin) {
        this.inicioLogin = inicioLogin;
    }

    public Timestamp getFinLogin() {
        return finLogin;
    }

    public void setFinLogin(Timestamp finLogin) {
        this.finLogin = finLogin;
    }

    public Boolean getSesiNavega() {
        return sesiNavega;
    }

    public void setSesiNavega(Boolean sesiNavega) {
        this.sesiNavega = sesiNavega;
    }

    public Boolean getSesiLogin() {
        return sesiLogin;
    }

    public void setSesiLogin(Boolean sesiLogin) {
        this.sesiLogin = sesiLogin;
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

    public String getMenuDescripcion() {
        return menuDescripcion;
    }

    public void setMenuDescripcion(String menuDescripcion) {
        this.menuDescripcion = menuDescripcion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

}
