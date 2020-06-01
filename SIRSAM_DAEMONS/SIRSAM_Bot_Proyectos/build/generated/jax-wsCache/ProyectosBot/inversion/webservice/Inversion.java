
package inversion.webservice;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para inversion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="inversion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="logs_id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="prco_contratista" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prco_contrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prco_fecha_suscripcion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="prco_monto_suscripcion" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="prco_orden" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="prco_tipo_proceso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prcp_componente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prcp_monto_viable" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="prcp_orden" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="prcp_unidad_medida" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prmo_comentarios" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prmo_fecha_modificacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prmo_monto_actualizado" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="prmo_tipo_documento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prmo_usuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proy_beneficiarios" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="proy_cadena_funcional" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proy_codigo_inversion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proy_codigo_siaf" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proy_estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proy_fecha_registro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="proy_fecha_viabilidad" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="proy_fuente_financiamiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proy_monto_actualizado" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="proy_monto_carta_fianza" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="proy_monto_estudio_definitivo" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="proy_monto_laudo" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="proy_monto_viable" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="proy_nivel_viabilidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proy_nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proy_objetivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proy_por_etapas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proy_responsable_viabilidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proy_situacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proy_tiene_expediente_tecnico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proy_tiene_informe_cierre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proy_tipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proy_ultimo_estudio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proy_unidad_ejecutora" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proy_unidad_ejecutora_inversion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proy_unidad_ejecutora_presupuestal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proy_unidad_evaluadora" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proy_unidad_formuladora" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prub_departamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prub_distrito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prub_localidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prub_provincia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inversion", propOrder = {
    "fecha",
    "logsId",
    "prcoContratista",
    "prcoContrato",
    "prcoFechaSuscripcion",
    "prcoMontoSuscripcion",
    "prcoOrden",
    "prcoTipoProceso",
    "prcpComponente",
    "prcpMontoViable",
    "prcpOrden",
    "prcpUnidadMedida",
    "prmoComentarios",
    "prmoFechaModificacion",
    "prmoMontoActualizado",
    "prmoTipoDocumento",
    "prmoUsuario",
    "proyBeneficiarios",
    "proyCadenaFuncional",
    "proyCodigoInversion",
    "proyCodigoSiaf",
    "proyEstado",
    "proyFechaRegistro",
    "proyFechaViabilidad",
    "proyFuenteFinanciamiento",
    "proyMontoActualizado",
    "proyMontoCartaFianza",
    "proyMontoEstudioDefinitivo",
    "proyMontoLaudo",
    "proyMontoViable",
    "proyNivelViabilidad",
    "proyNombre",
    "proyObjetivo",
    "proyPorEtapas",
    "proyResponsableViabilidad",
    "proySituacion",
    "proyTieneExpedienteTecnico",
    "proyTieneInformeCierre",
    "proyTipo",
    "proyUltimoEstudio",
    "proyUnidadEjecutora",
    "proyUnidadEjecutoraInversion",
    "proyUnidadEjecutoraPresupuestal",
    "proyUnidadEvaluadora",
    "proyUnidadFormuladora",
    "prubDepartamento",
    "prubDistrito",
    "prubLocalidad",
    "prubProvincia"
})
public class Inversion {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecha;
    @XmlElement(name = "logs_id")
    protected Integer logsId;
    @XmlElement(name = "prco_contratista")
    protected String prcoContratista;
    @XmlElement(name = "prco_contrato")
    protected String prcoContrato;
    @XmlElement(name = "prco_fecha_suscripcion")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar prcoFechaSuscripcion;
    @XmlElement(name = "prco_monto_suscripcion")
    protected BigDecimal prcoMontoSuscripcion;
    @XmlElement(name = "prco_orden")
    protected Integer prcoOrden;
    @XmlElement(name = "prco_tipo_proceso")
    protected String prcoTipoProceso;
    @XmlElement(name = "prcp_componente")
    protected String prcpComponente;
    @XmlElement(name = "prcp_monto_viable")
    protected BigDecimal prcpMontoViable;
    @XmlElement(name = "prcp_orden")
    protected Integer prcpOrden;
    @XmlElement(name = "prcp_unidad_medida")
    protected String prcpUnidadMedida;
    @XmlElement(name = "prmo_comentarios")
    protected String prmoComentarios;
    @XmlElement(name = "prmo_fecha_modificacion")
    protected String prmoFechaModificacion;
    @XmlElement(name = "prmo_monto_actualizado")
    protected BigDecimal prmoMontoActualizado;
    @XmlElement(name = "prmo_tipo_documento")
    protected String prmoTipoDocumento;
    @XmlElement(name = "prmo_usuario")
    protected String prmoUsuario;
    @XmlElement(name = "proy_beneficiarios")
    protected BigDecimal proyBeneficiarios;
    @XmlElement(name = "proy_cadena_funcional")
    protected String proyCadenaFuncional;
    @XmlElement(name = "proy_codigo_inversion")
    protected String proyCodigoInversion;
    @XmlElement(name = "proy_codigo_siaf")
    protected String proyCodigoSiaf;
    @XmlElement(name = "proy_estado")
    protected String proyEstado;
    @XmlElement(name = "proy_fecha_registro")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar proyFechaRegistro;
    @XmlElement(name = "proy_fecha_viabilidad")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar proyFechaViabilidad;
    @XmlElement(name = "proy_fuente_financiamiento")
    protected String proyFuenteFinanciamiento;
    @XmlElement(name = "proy_monto_actualizado")
    protected BigDecimal proyMontoActualizado;
    @XmlElement(name = "proy_monto_carta_fianza")
    protected BigDecimal proyMontoCartaFianza;
    @XmlElement(name = "proy_monto_estudio_definitivo")
    protected BigDecimal proyMontoEstudioDefinitivo;
    @XmlElement(name = "proy_monto_laudo")
    protected BigDecimal proyMontoLaudo;
    @XmlElement(name = "proy_monto_viable")
    protected BigDecimal proyMontoViable;
    @XmlElement(name = "proy_nivel_viabilidad")
    protected String proyNivelViabilidad;
    @XmlElement(name = "proy_nombre")
    protected String proyNombre;
    @XmlElement(name = "proy_objetivo")
    protected String proyObjetivo;
    @XmlElement(name = "proy_por_etapas")
    protected String proyPorEtapas;
    @XmlElement(name = "proy_responsable_viabilidad")
    protected String proyResponsableViabilidad;
    @XmlElement(name = "proy_situacion")
    protected String proySituacion;
    @XmlElement(name = "proy_tiene_expediente_tecnico")
    protected String proyTieneExpedienteTecnico;
    @XmlElement(name = "proy_tiene_informe_cierre")
    protected String proyTieneInformeCierre;
    @XmlElement(name = "proy_tipo")
    protected String proyTipo;
    @XmlElement(name = "proy_ultimo_estudio")
    protected String proyUltimoEstudio;
    @XmlElement(name = "proy_unidad_ejecutora")
    protected String proyUnidadEjecutora;
    @XmlElement(name = "proy_unidad_ejecutora_inversion")
    protected String proyUnidadEjecutoraInversion;
    @XmlElement(name = "proy_unidad_ejecutora_presupuestal")
    protected String proyUnidadEjecutoraPresupuestal;
    @XmlElement(name = "proy_unidad_evaluadora")
    protected String proyUnidadEvaluadora;
    @XmlElement(name = "proy_unidad_formuladora")
    protected String proyUnidadFormuladora;
    @XmlElement(name = "prub_departamento")
    protected String prubDepartamento;
    @XmlElement(name = "prub_distrito")
    protected String prubDistrito;
    @XmlElement(name = "prub_localidad")
    protected String prubLocalidad;
    @XmlElement(name = "prub_provincia")
    protected String prubProvincia;

    /**
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecha(XMLGregorianCalendar value) {
        this.fecha = value;
    }

    /**
     * Obtiene el valor de la propiedad logsId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLogsId() {
        return logsId;
    }

    /**
     * Define el valor de la propiedad logsId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLogsId(Integer value) {
        this.logsId = value;
    }

    /**
     * Obtiene el valor de la propiedad prcoContratista.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrcoContratista() {
        return prcoContratista;
    }

    /**
     * Define el valor de la propiedad prcoContratista.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrcoContratista(String value) {
        this.prcoContratista = value;
    }

    /**
     * Obtiene el valor de la propiedad prcoContrato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrcoContrato() {
        return prcoContrato;
    }

    /**
     * Define el valor de la propiedad prcoContrato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrcoContrato(String value) {
        this.prcoContrato = value;
    }

    /**
     * Obtiene el valor de la propiedad prcoFechaSuscripcion.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPrcoFechaSuscripcion() {
        return prcoFechaSuscripcion;
    }

    /**
     * Define el valor de la propiedad prcoFechaSuscripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPrcoFechaSuscripcion(XMLGregorianCalendar value) {
        this.prcoFechaSuscripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad prcoMontoSuscripcion.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrcoMontoSuscripcion() {
        return prcoMontoSuscripcion;
    }

    /**
     * Define el valor de la propiedad prcoMontoSuscripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrcoMontoSuscripcion(BigDecimal value) {
        this.prcoMontoSuscripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad prcoOrden.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPrcoOrden() {
        return prcoOrden;
    }

    /**
     * Define el valor de la propiedad prcoOrden.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPrcoOrden(Integer value) {
        this.prcoOrden = value;
    }

    /**
     * Obtiene el valor de la propiedad prcoTipoProceso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrcoTipoProceso() {
        return prcoTipoProceso;
    }

    /**
     * Define el valor de la propiedad prcoTipoProceso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrcoTipoProceso(String value) {
        this.prcoTipoProceso = value;
    }

    /**
     * Obtiene el valor de la propiedad prcpComponente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrcpComponente() {
        return prcpComponente;
    }

    /**
     * Define el valor de la propiedad prcpComponente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrcpComponente(String value) {
        this.prcpComponente = value;
    }

    /**
     * Obtiene el valor de la propiedad prcpMontoViable.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrcpMontoViable() {
        return prcpMontoViable;
    }

    /**
     * Define el valor de la propiedad prcpMontoViable.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrcpMontoViable(BigDecimal value) {
        this.prcpMontoViable = value;
    }

    /**
     * Obtiene el valor de la propiedad prcpOrden.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPrcpOrden() {
        return prcpOrden;
    }

    /**
     * Define el valor de la propiedad prcpOrden.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPrcpOrden(Integer value) {
        this.prcpOrden = value;
    }

    /**
     * Obtiene el valor de la propiedad prcpUnidadMedida.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrcpUnidadMedida() {
        return prcpUnidadMedida;
    }

    /**
     * Define el valor de la propiedad prcpUnidadMedida.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrcpUnidadMedida(String value) {
        this.prcpUnidadMedida = value;
    }

    /**
     * Obtiene el valor de la propiedad prmoComentarios.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrmoComentarios() {
        return prmoComentarios;
    }

    /**
     * Define el valor de la propiedad prmoComentarios.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrmoComentarios(String value) {
        this.prmoComentarios = value;
    }

    /**
     * Obtiene el valor de la propiedad prmoFechaModificacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrmoFechaModificacion() {
        return prmoFechaModificacion;
    }

    /**
     * Define el valor de la propiedad prmoFechaModificacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrmoFechaModificacion(String value) {
        this.prmoFechaModificacion = value;
    }

    /**
     * Obtiene el valor de la propiedad prmoMontoActualizado.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrmoMontoActualizado() {
        return prmoMontoActualizado;
    }

    /**
     * Define el valor de la propiedad prmoMontoActualizado.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrmoMontoActualizado(BigDecimal value) {
        this.prmoMontoActualizado = value;
    }

    /**
     * Obtiene el valor de la propiedad prmoTipoDocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrmoTipoDocumento() {
        return prmoTipoDocumento;
    }

    /**
     * Define el valor de la propiedad prmoTipoDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrmoTipoDocumento(String value) {
        this.prmoTipoDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad prmoUsuario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrmoUsuario() {
        return prmoUsuario;
    }

    /**
     * Define el valor de la propiedad prmoUsuario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrmoUsuario(String value) {
        this.prmoUsuario = value;
    }

    /**
     * Obtiene el valor de la propiedad proyBeneficiarios.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getProyBeneficiarios() {
        return proyBeneficiarios;
    }

    /**
     * Define el valor de la propiedad proyBeneficiarios.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setProyBeneficiarios(BigDecimal value) {
        this.proyBeneficiarios = value;
    }

    /**
     * Obtiene el valor de la propiedad proyCadenaFuncional.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProyCadenaFuncional() {
        return proyCadenaFuncional;
    }

    /**
     * Define el valor de la propiedad proyCadenaFuncional.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProyCadenaFuncional(String value) {
        this.proyCadenaFuncional = value;
    }

    /**
     * Obtiene el valor de la propiedad proyCodigoInversion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProyCodigoInversion() {
        return proyCodigoInversion;
    }

    /**
     * Define el valor de la propiedad proyCodigoInversion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProyCodigoInversion(String value) {
        this.proyCodigoInversion = value;
    }

    /**
     * Obtiene el valor de la propiedad proyCodigoSiaf.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProyCodigoSiaf() {
        return proyCodigoSiaf;
    }

    /**
     * Define el valor de la propiedad proyCodigoSiaf.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProyCodigoSiaf(String value) {
        this.proyCodigoSiaf = value;
    }

    /**
     * Obtiene el valor de la propiedad proyEstado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProyEstado() {
        return proyEstado;
    }

    /**
     * Define el valor de la propiedad proyEstado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProyEstado(String value) {
        this.proyEstado = value;
    }

    /**
     * Obtiene el valor de la propiedad proyFechaRegistro.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getProyFechaRegistro() {
        return proyFechaRegistro;
    }

    /**
     * Define el valor de la propiedad proyFechaRegistro.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setProyFechaRegistro(XMLGregorianCalendar value) {
        this.proyFechaRegistro = value;
    }

    /**
     * Obtiene el valor de la propiedad proyFechaViabilidad.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getProyFechaViabilidad() {
        return proyFechaViabilidad;
    }

    /**
     * Define el valor de la propiedad proyFechaViabilidad.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setProyFechaViabilidad(XMLGregorianCalendar value) {
        this.proyFechaViabilidad = value;
    }

    /**
     * Obtiene el valor de la propiedad proyFuenteFinanciamiento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProyFuenteFinanciamiento() {
        return proyFuenteFinanciamiento;
    }

    /**
     * Define el valor de la propiedad proyFuenteFinanciamiento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProyFuenteFinanciamiento(String value) {
        this.proyFuenteFinanciamiento = value;
    }

    /**
     * Obtiene el valor de la propiedad proyMontoActualizado.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getProyMontoActualizado() {
        return proyMontoActualizado;
    }

    /**
     * Define el valor de la propiedad proyMontoActualizado.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setProyMontoActualizado(BigDecimal value) {
        this.proyMontoActualizado = value;
    }

    /**
     * Obtiene el valor de la propiedad proyMontoCartaFianza.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getProyMontoCartaFianza() {
        return proyMontoCartaFianza;
    }

    /**
     * Define el valor de la propiedad proyMontoCartaFianza.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setProyMontoCartaFianza(BigDecimal value) {
        this.proyMontoCartaFianza = value;
    }

    /**
     * Obtiene el valor de la propiedad proyMontoEstudioDefinitivo.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getProyMontoEstudioDefinitivo() {
        return proyMontoEstudioDefinitivo;
    }

    /**
     * Define el valor de la propiedad proyMontoEstudioDefinitivo.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setProyMontoEstudioDefinitivo(BigDecimal value) {
        this.proyMontoEstudioDefinitivo = value;
    }

    /**
     * Obtiene el valor de la propiedad proyMontoLaudo.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getProyMontoLaudo() {
        return proyMontoLaudo;
    }

    /**
     * Define el valor de la propiedad proyMontoLaudo.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setProyMontoLaudo(BigDecimal value) {
        this.proyMontoLaudo = value;
    }

    /**
     * Obtiene el valor de la propiedad proyMontoViable.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getProyMontoViable() {
        return proyMontoViable;
    }

    /**
     * Define el valor de la propiedad proyMontoViable.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setProyMontoViable(BigDecimal value) {
        this.proyMontoViable = value;
    }

    /**
     * Obtiene el valor de la propiedad proyNivelViabilidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProyNivelViabilidad() {
        return proyNivelViabilidad;
    }

    /**
     * Define el valor de la propiedad proyNivelViabilidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProyNivelViabilidad(String value) {
        this.proyNivelViabilidad = value;
    }

    /**
     * Obtiene el valor de la propiedad proyNombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProyNombre() {
        return proyNombre;
    }

    /**
     * Define el valor de la propiedad proyNombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProyNombre(String value) {
        this.proyNombre = value;
    }

    /**
     * Obtiene el valor de la propiedad proyObjetivo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProyObjetivo() {
        return proyObjetivo;
    }

    /**
     * Define el valor de la propiedad proyObjetivo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProyObjetivo(String value) {
        this.proyObjetivo = value;
    }

    /**
     * Obtiene el valor de la propiedad proyPorEtapas.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProyPorEtapas() {
        return proyPorEtapas;
    }

    /**
     * Define el valor de la propiedad proyPorEtapas.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProyPorEtapas(String value) {
        this.proyPorEtapas = value;
    }

    /**
     * Obtiene el valor de la propiedad proyResponsableViabilidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProyResponsableViabilidad() {
        return proyResponsableViabilidad;
    }

    /**
     * Define el valor de la propiedad proyResponsableViabilidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProyResponsableViabilidad(String value) {
        this.proyResponsableViabilidad = value;
    }

    /**
     * Obtiene el valor de la propiedad proySituacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProySituacion() {
        return proySituacion;
    }

    /**
     * Define el valor de la propiedad proySituacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProySituacion(String value) {
        this.proySituacion = value;
    }

    /**
     * Obtiene el valor de la propiedad proyTieneExpedienteTecnico.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProyTieneExpedienteTecnico() {
        return proyTieneExpedienteTecnico;
    }

    /**
     * Define el valor de la propiedad proyTieneExpedienteTecnico.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProyTieneExpedienteTecnico(String value) {
        this.proyTieneExpedienteTecnico = value;
    }

    /**
     * Obtiene el valor de la propiedad proyTieneInformeCierre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProyTieneInformeCierre() {
        return proyTieneInformeCierre;
    }

    /**
     * Define el valor de la propiedad proyTieneInformeCierre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProyTieneInformeCierre(String value) {
        this.proyTieneInformeCierre = value;
    }

    /**
     * Obtiene el valor de la propiedad proyTipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProyTipo() {
        return proyTipo;
    }

    /**
     * Define el valor de la propiedad proyTipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProyTipo(String value) {
        this.proyTipo = value;
    }

    /**
     * Obtiene el valor de la propiedad proyUltimoEstudio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProyUltimoEstudio() {
        return proyUltimoEstudio;
    }

    /**
     * Define el valor de la propiedad proyUltimoEstudio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProyUltimoEstudio(String value) {
        this.proyUltimoEstudio = value;
    }

    /**
     * Obtiene el valor de la propiedad proyUnidadEjecutora.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProyUnidadEjecutora() {
        return proyUnidadEjecutora;
    }

    /**
     * Define el valor de la propiedad proyUnidadEjecutora.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProyUnidadEjecutora(String value) {
        this.proyUnidadEjecutora = value;
    }

    /**
     * Obtiene el valor de la propiedad proyUnidadEjecutoraInversion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProyUnidadEjecutoraInversion() {
        return proyUnidadEjecutoraInversion;
    }

    /**
     * Define el valor de la propiedad proyUnidadEjecutoraInversion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProyUnidadEjecutoraInversion(String value) {
        this.proyUnidadEjecutoraInversion = value;
    }

    /**
     * Obtiene el valor de la propiedad proyUnidadEjecutoraPresupuestal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProyUnidadEjecutoraPresupuestal() {
        return proyUnidadEjecutoraPresupuestal;
    }

    /**
     * Define el valor de la propiedad proyUnidadEjecutoraPresupuestal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProyUnidadEjecutoraPresupuestal(String value) {
        this.proyUnidadEjecutoraPresupuestal = value;
    }

    /**
     * Obtiene el valor de la propiedad proyUnidadEvaluadora.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProyUnidadEvaluadora() {
        return proyUnidadEvaluadora;
    }

    /**
     * Define el valor de la propiedad proyUnidadEvaluadora.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProyUnidadEvaluadora(String value) {
        this.proyUnidadEvaluadora = value;
    }

    /**
     * Obtiene el valor de la propiedad proyUnidadFormuladora.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProyUnidadFormuladora() {
        return proyUnidadFormuladora;
    }

    /**
     * Define el valor de la propiedad proyUnidadFormuladora.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProyUnidadFormuladora(String value) {
        this.proyUnidadFormuladora = value;
    }

    /**
     * Obtiene el valor de la propiedad prubDepartamento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrubDepartamento() {
        return prubDepartamento;
    }

    /**
     * Define el valor de la propiedad prubDepartamento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrubDepartamento(String value) {
        this.prubDepartamento = value;
    }

    /**
     * Obtiene el valor de la propiedad prubDistrito.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrubDistrito() {
        return prubDistrito;
    }

    /**
     * Define el valor de la propiedad prubDistrito.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrubDistrito(String value) {
        this.prubDistrito = value;
    }

    /**
     * Obtiene el valor de la propiedad prubLocalidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrubLocalidad() {
        return prubLocalidad;
    }

    /**
     * Define el valor de la propiedad prubLocalidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrubLocalidad(String value) {
        this.prubLocalidad = value;
    }

    /**
     * Obtiene el valor de la propiedad prubProvincia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrubProvincia() {
        return prubProvincia;
    }

    /**
     * Define el valor de la propiedad prubProvincia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrubProvincia(String value) {
        this.prubProvincia = value;
    }

}
