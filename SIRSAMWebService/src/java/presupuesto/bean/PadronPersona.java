package presupuesto.bean;

import java.util.Date;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * @author CARLOS SANTANDER
 */
public class PadronPersona {

    private String tipo_documento;
    private String numero_documento;
    private String apellido_paterno;
    private String apellido_materno;
    private String nombre;
    private String sexo;
    private Date fecha_nacimiento;
    private XMLGregorianCalendar fecha_nacimiento_xml;
    private String estado;

    public PadronPersona() {
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public XMLGregorianCalendar getFecha_nacimiento_xml() {
        return fecha_nacimiento_xml;
    }

    public void setFecha_nacimiento_xml(XMLGregorianCalendar fecha_nacimiento_xml) {
        this.fecha_nacimiento_xml = fecha_nacimiento_xml;
    }

}
