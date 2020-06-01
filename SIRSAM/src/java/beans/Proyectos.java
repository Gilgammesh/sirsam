package beans;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author CARLOS SANTANDER
 */
public class Proyectos {

    private String proyCodigoSiaf;
    private String proyCodigoInversion;
    private String proyNombre;
    private Date proyFechaRegistro;
    private String proyCadenaFuncional;
    private String proyUnidadFormuladora;
    private String proyUnidadEjecutora;
    private String proyUnidadEjecutoraInversion;
    private String proyUnidadEjecutoraPresupuestal;
    private String proyUnidadEvaluadora;
    private BigDecimal proyBeneficiarios;
    private String proyFuenteFinanciamiento;
    private String proyResponsableViabilidad;
    private Date proyFechaViabilidad;
    private String proySituacion;
    private String proyNivelViabilidad;
    private String proyUltimoEstudio;
    private String proyEstado;
    private BigDecimal proyMontoViable;
    private BigDecimal proyMontoLaudo;
    private BigDecimal proyMontoEstudioDefinitivo;
    private BigDecimal proyMontoCartaFianza;
    private BigDecimal proyMontoActualizado;
    private String proyPorEtapas;
    private String proyTieneExpedienteTecnico;
    private String proyTieneInformeCierre;
    private String proyObjetivo;
    private String proyTipo;
    private Boolean proySupervision;
    private Integer pramNro;
    private Integer pramDias;
    private String pramDocumento;
    private Date pramFecha;
    private Boolean pramProcedente;
    private String prcpComponente;
    private Integer prcpOrden;
    private String prcpUnidadMedida;
    private BigDecimal prcpMontoViable;
    private BigDecimal prcpMontoEstudio;
    private BigDecimal prcpMontoContratado;
    private BigDecimal prcpMontoActualizado;
    private String prcpComentarios;
    private Integer prcoOrden;
    private String prcoContratista;
    private String prcoTipoProceso;
    private String prcoContrato;
    private Date prcoFechaSuscripcion;
    private BigDecimal prcoMontoSuscripcion;
    private String prcoUrlWindows;
    private String prcoUrlLinux;
    private String prejProceso;
    private String prejContrato;
    private BigDecimal prejMontoContrato;
    private String prejProveedor;
    private String prejModalidadContrato;
    private String prejResidenteNombre;
    private String prejResidenteCelular;
    private Integer prejPlazo;
    private Date prejFechaInicio;
    private Date presFechaAproba;
    private String presDocAproba;
    private String presContrato;
    private String presResponsable;
    private String prmoFechaModificacion;
    private BigDecimal prmoMontoActualizado;
    private String prmoComentarios;
    private String prmoUsuario;
    private String prmoTipoDocumento;
    private String prpeAno;
    private Integer prpeMes;
    private String nombreMes;
    private String prsuProceso;
    private String prsuContrato;
    private BigDecimal prsuMontoContrato;
    private String prsuProveedor;
    private String prsuModalidadContrato;
    private String prsuSupervisorNombre;
    private String prsuSupervisorCelular;
    private String prsuCoordinadorNombre;
    private String prsuCoordinadorCelular;
    private String prsuAdminContNombre;
    private String prsuAdminContCelular;
    private Date prsuFechaInicio;
    private Date prsuFechaFin;
    private Boolean prsuTieneAdelanto;
    private String prubDepartamento;
    private String prubProvincia;
    private String prubDistrito;
    private String prubLocalidad;
    private BigDecimal prubLatitud;
    private BigDecimal prubLongitud;
    private BigDecimal prvaMontoProgramado;
    private BigDecimal prvaMontoEjecutado;
    private BigDecimal prvaMontoPagado;
    private Date prsuFechaFirmaContrato;
    private Boolean prejTieneAdelantoMaterial;
    private Date prejFechaFirmaContra;
    private Date prejFechaEntregaTerre;
    private Boolean prejTieneAdelantoDirecto;
    private Integer prfoOrden;
    private String prfoTitulo;
    private String prfoDescripcion;
    private String prfoUrlWindows;
    private String prfoUrlLinux;
    private Boolean prfoPrincipal;
    private String prfoTipo;
    private Integer presetEtapa;
    private Date presetFechaAproba;
    private String presetDocAproba;
    private String presetContrato;
    private String presetResponsable;
    private Integer prejadNro;
    private BigDecimal prejadMonto;
    private String prejadTipo;
    private Date prejadFecha;
    private String prejadComentario;
    private Integer prsuadNro;
    private BigDecimal prsuadMonto;
    private Date prsuadFecha;
    private String prsuadComentario;
    private Integer prpsNro;
    private Integer prpsDias;
    private String prpsDocumento;
    private Date prpsFecha;
    private String prpsTipo;
    private String ano_eje;
    private String sec_ejec;
    private String ejecutora;
    private String nombre_ejecutora;
    private String act_proy;
    private BigDecimal pia;
    private BigDecimal pim;
    private BigDecimal devengado;
    private BigDecimal devengado_acumulado;
    private Date fecha_doc;
    private String expediente;
    private String sec_func;
    private String fuente_financ;
    private String nombre_fuente_financ;
    private String clasificador;
    private String ruc;
    private String razon_social;
    private String certificacion;
    private String funcion;
    private String nombre_funcion;

    public Proyectos() {
    }

    public String getProyCodigoSiaf() {
        return proyCodigoSiaf;
    }

    public void setProyCodigoSiaf(String proyCodigoSiaf) {
        this.proyCodigoSiaf = proyCodigoSiaf;
    }

    public String getProyCodigoInversion() {
        return proyCodigoInversion;
    }

    public void setProyCodigoInversion(String proyCodigoInversion) {
        this.proyCodigoInversion = proyCodigoInversion;
    }

    public String getProyNombre() {
        return proyNombre;
    }

    public void setProyNombre(String proyNombre) {
        this.proyNombre = proyNombre;
    }

    public Date getProyFechaRegistro() {
        return proyFechaRegistro;
    }

    public void setProyFechaRegistro(Date proyFechaRegistro) {
        this.proyFechaRegistro = proyFechaRegistro;
    }

    public String getProyCadenaFuncional() {
        return proyCadenaFuncional;
    }

    public void setProyCadenaFuncional(String proyCadenaFuncional) {
        this.proyCadenaFuncional = proyCadenaFuncional;
    }

    public String getProyUnidadFormuladora() {
        return proyUnidadFormuladora;
    }

    public void setProyUnidadFormuladora(String proyUnidadFormuladora) {
        this.proyUnidadFormuladora = proyUnidadFormuladora;
    }

    public String getProyUnidadEjecutora() {
        return proyUnidadEjecutora;
    }

    public void setProyUnidadEjecutora(String proyUnidadEjecutora) {
        this.proyUnidadEjecutora = proyUnidadEjecutora;
    }

    public String getProyUnidadEjecutoraInversion() {
        return proyUnidadEjecutoraInversion;
    }

    public void setProyUnidadEjecutoraInversion(String proyUnidadEjecutoraInversion) {
        this.proyUnidadEjecutoraInversion = proyUnidadEjecutoraInversion;
    }

    public String getProyUnidadEjecutoraPresupuestal() {
        return proyUnidadEjecutoraPresupuestal;
    }

    public void setProyUnidadEjecutoraPresupuestal(String proyUnidadEjecutoraPresupuestal) {
        this.proyUnidadEjecutoraPresupuestal = proyUnidadEjecutoraPresupuestal;
    }

    public String getProyUnidadEvaluadora() {
        return proyUnidadEvaluadora;
    }

    public void setProyUnidadEvaluadora(String proyUnidadEvaluadora) {
        this.proyUnidadEvaluadora = proyUnidadEvaluadora;
    }

    public BigDecimal getProyBeneficiarios() {
        return proyBeneficiarios;
    }

    public void setProyBeneficiarios(BigDecimal proyBeneficiarios) {
        this.proyBeneficiarios = proyBeneficiarios;
    }

    public String getProyFuenteFinanciamiento() {
        return proyFuenteFinanciamiento;
    }

    public void setProyFuenteFinanciamiento(String proyFuenteFinanciamiento) {
        this.proyFuenteFinanciamiento = proyFuenteFinanciamiento;
    }

    public String getProyResponsableViabilidad() {
        return proyResponsableViabilidad;
    }

    public void setProyResponsableViabilidad(String proyResponsableViabilidad) {
        this.proyResponsableViabilidad = proyResponsableViabilidad;
    }

    public Date getProyFechaViabilidad() {
        return proyFechaViabilidad;
    }

    public void setProyFechaViabilidad(Date proyFechaViabilidad) {
        this.proyFechaViabilidad = proyFechaViabilidad;
    }

    public String getProySituacion() {
        return proySituacion;
    }

    public void setProySituacion(String proySituacion) {
        this.proySituacion = proySituacion;
    }

    public String getProyNivelViabilidad() {
        return proyNivelViabilidad;
    }

    public void setProyNivelViabilidad(String proyNivelViabilidad) {
        this.proyNivelViabilidad = proyNivelViabilidad;
    }

    public String getProyUltimoEstudio() {
        return proyUltimoEstudio;
    }

    public void setProyUltimoEstudio(String proyUltimoEstudio) {
        this.proyUltimoEstudio = proyUltimoEstudio;
    }

    public String getProyEstado() {
        return proyEstado;
    }

    public void setProyEstado(String proyEstado) {
        this.proyEstado = proyEstado;
    }

    public BigDecimal getProyMontoViable() {
        return proyMontoViable;
    }

    public void setProyMontoViable(BigDecimal proyMontoViable) {
        this.proyMontoViable = proyMontoViable;
    }

    public BigDecimal getProyMontoLaudo() {
        return proyMontoLaudo;
    }

    public void setProyMontoLaudo(BigDecimal proyMontoLaudo) {
        this.proyMontoLaudo = proyMontoLaudo;
    }

    public BigDecimal getProyMontoEstudioDefinitivo() {
        return proyMontoEstudioDefinitivo;
    }

    public void setProyMontoEstudioDefinitivo(BigDecimal proyMontoEstudioDefinitivo) {
        this.proyMontoEstudioDefinitivo = proyMontoEstudioDefinitivo;
    }

    public BigDecimal getProyMontoCartaFianza() {
        return proyMontoCartaFianza;
    }

    public void setProyMontoCartaFianza(BigDecimal proyMontoCartaFianza) {
        this.proyMontoCartaFianza = proyMontoCartaFianza;
    }

    public BigDecimal getProyMontoActualizado() {
        return proyMontoActualizado;
    }

    public void setProyMontoActualizado(BigDecimal proyMontoActualizado) {
        this.proyMontoActualizado = proyMontoActualizado;
    }

    public String getProyPorEtapas() {
        return proyPorEtapas;
    }

    public void setProyPorEtapas(String proyPorEtapas) {
        this.proyPorEtapas = proyPorEtapas;
    }

    public String getProyTieneExpedienteTecnico() {
        return proyTieneExpedienteTecnico;
    }

    public void setProyTieneExpedienteTecnico(String proyTieneExpedienteTecnico) {
        this.proyTieneExpedienteTecnico = proyTieneExpedienteTecnico;
    }

    public String getProyTieneInformeCierre() {
        return proyTieneInformeCierre;
    }

    public void setProyTieneInformeCierre(String proyTieneInformeCierre) {
        this.proyTieneInformeCierre = proyTieneInformeCierre;
    }

    public String getProyObjetivo() {
        return proyObjetivo;
    }

    public void setProyObjetivo(String proyObjetivo) {
        this.proyObjetivo = proyObjetivo;
    }

    public String getProyTipo() {
        return proyTipo;
    }

    public void setProyTipo(String proyTipo) {
        this.proyTipo = proyTipo;
    }

    public Boolean getProySupervision() {
        return proySupervision;
    }

    public void setProySupervision(Boolean proySupervision) {
        this.proySupervision = proySupervision;
    }

    public Integer getPramNro() {
        return pramNro;
    }

    public void setPramNro(Integer pramNro) {
        this.pramNro = pramNro;
    }

    public Integer getPramDias() {
        return pramDias;
    }

    public void setPramDias(Integer pramDias) {
        this.pramDias = pramDias;
    }

    public String getPramDocumento() {
        return pramDocumento;
    }

    public void setPramDocumento(String pramDocumento) {
        this.pramDocumento = pramDocumento;
    }

    public Date getPramFecha() {
        return pramFecha;
    }

    public void setPramFecha(Date pramFecha) {
        this.pramFecha = pramFecha;
    }

    public Boolean getPramProcedente() {
        return pramProcedente;
    }

    public void setPramProcedente(Boolean pramProcedente) {
        this.pramProcedente = pramProcedente;
    }

    public String getPrcpComponente() {
        return prcpComponente;
    }

    public void setPrcpComponente(String prcpComponente) {
        this.prcpComponente = prcpComponente;
    }

    public Integer getPrcpOrden() {
        return prcpOrden;
    }

    public void setPrcpOrden(Integer prcpOrden) {
        this.prcpOrden = prcpOrden;
    }

    public String getPrcpUnidadMedida() {
        return prcpUnidadMedida;
    }

    public void setPrcpUnidadMedida(String prcpUnidadMedida) {
        this.prcpUnidadMedida = prcpUnidadMedida;
    }

    public BigDecimal getPrcpMontoViable() {
        return prcpMontoViable;
    }

    public void setPrcpMontoViable(BigDecimal prcpMontoViable) {
        this.prcpMontoViable = prcpMontoViable;
    }

    public BigDecimal getPrcpMontoEstudio() {
        return prcpMontoEstudio;
    }

    public void setPrcpMontoEstudio(BigDecimal prcpMontoEstudio) {
        this.prcpMontoEstudio = prcpMontoEstudio;
    }

    public BigDecimal getPrcpMontoContratado() {
        return prcpMontoContratado;
    }

    public void setPrcpMontoContratado(BigDecimal prcpMontoContratado) {
        this.prcpMontoContratado = prcpMontoContratado;
    }

    public BigDecimal getPrcpMontoActualizado() {
        return prcpMontoActualizado;
    }

    public void setPrcpMontoActualizado(BigDecimal prcpMontoActualizado) {
        this.prcpMontoActualizado = prcpMontoActualizado;
    }

    public String getPrcpComentarios() {
        return prcpComentarios;
    }

    public void setPrcpComentarios(String prcpComentarios) {
        this.prcpComentarios = prcpComentarios;
    }

    public Integer getPrcoOrden() {
        return prcoOrden;
    }

    public void setPrcoOrden(Integer prcoOrden) {
        this.prcoOrden = prcoOrden;
    }

    public String getPrcoContratista() {
        return prcoContratista;
    }

    public void setPrcoContratista(String prcoContratista) {
        this.prcoContratista = prcoContratista;
    }

    public String getPrcoTipoProceso() {
        return prcoTipoProceso;
    }

    public void setPrcoTipoProceso(String prcoTipoProceso) {
        this.prcoTipoProceso = prcoTipoProceso;
    }

    public String getPrcoContrato() {
        return prcoContrato;
    }

    public void setPrcoContrato(String prcoContrato) {
        this.prcoContrato = prcoContrato;
    }

    public Date getPrcoFechaSuscripcion() {
        return prcoFechaSuscripcion;
    }

    public void setPrcoFechaSuscripcion(Date prcoFechaSuscripcion) {
        this.prcoFechaSuscripcion = prcoFechaSuscripcion;
    }

    public BigDecimal getPrcoMontoSuscripcion() {
        return prcoMontoSuscripcion;
    }

    public void setPrcoMontoSuscripcion(BigDecimal prcoMontoSuscripcion) {
        this.prcoMontoSuscripcion = prcoMontoSuscripcion;
    }

    public String getPrcoUrlWindows() {
        return prcoUrlWindows;
    }

    public void setPrcoUrlWindows(String prcoUrlWindows) {
        this.prcoUrlWindows = prcoUrlWindows;
    }

    public String getPrcoUrlLinux() {
        return prcoUrlLinux;
    }

    public void setPrcoUrlLinux(String prcoUrlLinux) {
        this.prcoUrlLinux = prcoUrlLinux;
    }

    public String getPrejProceso() {
        return prejProceso;
    }

    public void setPrejProceso(String prejProceso) {
        this.prejProceso = prejProceso;
    }

    public String getPrejContrato() {
        return prejContrato;
    }

    public void setPrejContrato(String prejContrato) {
        this.prejContrato = prejContrato;
    }

    public BigDecimal getPrejMontoContrato() {
        return prejMontoContrato;
    }

    public void setPrejMontoContrato(BigDecimal prejMontoContrato) {
        this.prejMontoContrato = prejMontoContrato;
    }

    public String getPrejProveedor() {
        return prejProveedor;
    }

    public void setPrejProveedor(String prejProveedor) {
        this.prejProveedor = prejProveedor;
    }

    public String getPrejModalidadContrato() {
        return prejModalidadContrato;
    }

    public void setPrejModalidadContrato(String prejModalidadContrato) {
        this.prejModalidadContrato = prejModalidadContrato;
    }

    public String getPrejResidenteNombre() {
        return prejResidenteNombre;
    }

    public void setPrejResidenteNombre(String prejResidenteNombre) {
        this.prejResidenteNombre = prejResidenteNombre;
    }

    public String getPrejResidenteCelular() {
        return prejResidenteCelular;
    }

    public void setPrejResidenteCelular(String prejResidenteCelular) {
        this.prejResidenteCelular = prejResidenteCelular;
    }

    public Integer getPrejPlazo() {
        return prejPlazo;
    }

    public void setPrejPlazo(Integer prejPlazo) {
        this.prejPlazo = prejPlazo;
    }

    public Date getPrejFechaInicio() {
        return prejFechaInicio;
    }

    public void setPrejFechaInicio(Date prejFechaInicio) {
        this.prejFechaInicio = prejFechaInicio;
    }

    public Date getPresFechaAproba() {
        return presFechaAproba;
    }

    public void setPresFechaAproba(Date presFechaAproba) {
        this.presFechaAproba = presFechaAproba;
    }

    public String getPresDocAproba() {
        return presDocAproba;
    }

    public void setPresDocAproba(String presDocAproba) {
        this.presDocAproba = presDocAproba;
    }

    public String getPresContrato() {
        return presContrato;
    }

    public void setPresContrato(String presContrato) {
        this.presContrato = presContrato;
    }

    public String getPresResponsable() {
        return presResponsable;
    }

    public void setPresResponsable(String presResponsable) {
        this.presResponsable = presResponsable;
    }

    public String getPrmoFechaModificacion() {
        return prmoFechaModificacion;
    }

    public void setPrmoFechaModificacion(String prmoFechaModificacion) {
        this.prmoFechaModificacion = prmoFechaModificacion;
    }

    public BigDecimal getPrmoMontoActualizado() {
        return prmoMontoActualizado;
    }

    public void setPrmoMontoActualizado(BigDecimal prmoMontoActualizado) {
        this.prmoMontoActualizado = prmoMontoActualizado;
    }

    public String getPrmoComentarios() {
        return prmoComentarios;
    }

    public void setPrmoComentarios(String prmoComentarios) {
        this.prmoComentarios = prmoComentarios;
    }

    public String getPrmoUsuario() {
        return prmoUsuario;
    }

    public void setPrmoUsuario(String prmoUsuario) {
        this.prmoUsuario = prmoUsuario;
    }

    public String getPrmoTipoDocumento() {
        return prmoTipoDocumento;
    }

    public void setPrmoTipoDocumento(String prmoTipoDocumento) {
        this.prmoTipoDocumento = prmoTipoDocumento;
    }

    public String getPrpeAno() {
        return prpeAno;
    }

    public void setPrpeAno(String prpeAno) {
        this.prpeAno = prpeAno;
    }

    public Integer getPrpeMes() {
        return prpeMes;
    }

    public void setPrpeMes(Integer prpeMes) {
        this.prpeMes = prpeMes;
    }

    public String getNombreMes() {
        return nombreMes;
    }

    public void setNombreMes(String nombreMes) {
        this.nombreMes = nombreMes;
    }

    public String getPrsuProceso() {
        return prsuProceso;
    }

    public void setPrsuProceso(String prsuProceso) {
        this.prsuProceso = prsuProceso;
    }

    public String getPrsuContrato() {
        return prsuContrato;
    }

    public void setPrsuContrato(String prsuContrato) {
        this.prsuContrato = prsuContrato;
    }

    public BigDecimal getPrsuMontoContrato() {
        return prsuMontoContrato;
    }

    public void setPrsuMontoContrato(BigDecimal prsuMontoContrato) {
        this.prsuMontoContrato = prsuMontoContrato;
    }

    public String getPrsuProveedor() {
        return prsuProveedor;
    }

    public void setPrsuProveedor(String prsuProveedor) {
        this.prsuProveedor = prsuProveedor;
    }

    public String getPrsuModalidadContrato() {
        return prsuModalidadContrato;
    }

    public void setPrsuModalidadContrato(String prsuModalidadContrato) {
        this.prsuModalidadContrato = prsuModalidadContrato;
    }

    public String getPrsuSupervisorNombre() {
        return prsuSupervisorNombre;
    }

    public void setPrsuSupervisorNombre(String prsuSupervisorNombre) {
        this.prsuSupervisorNombre = prsuSupervisorNombre;
    }

    public String getPrsuSupervisorCelular() {
        return prsuSupervisorCelular;
    }

    public void setPrsuSupervisorCelular(String prsuSupervisorCelular) {
        this.prsuSupervisorCelular = prsuSupervisorCelular;
    }

    public String getPrsuCoordinadorNombre() {
        return prsuCoordinadorNombre;
    }

    public void setPrsuCoordinadorNombre(String prsuCoordinadorNombre) {
        this.prsuCoordinadorNombre = prsuCoordinadorNombre;
    }

    public String getPrsuCoordinadorCelular() {
        return prsuCoordinadorCelular;
    }

    public void setPrsuCoordinadorCelular(String prsuCoordinadorCelular) {
        this.prsuCoordinadorCelular = prsuCoordinadorCelular;
    }

    public String getPrsuAdminContNombre() {
        return prsuAdminContNombre;
    }

    public void setPrsuAdminContNombre(String prsuAdminContNombre) {
        this.prsuAdminContNombre = prsuAdminContNombre;
    }

    public String getPrsuAdminContCelular() {
        return prsuAdminContCelular;
    }

    public void setPrsuAdminContCelular(String prsuAdminContCelular) {
        this.prsuAdminContCelular = prsuAdminContCelular;
    }

    public Date getPrsuFechaInicio() {
        return prsuFechaInicio;
    }

    public void setPrsuFechaInicio(Date prsuFechaInicio) {
        this.prsuFechaInicio = prsuFechaInicio;
    }

    public Date getPrsuFechaFin() {
        return prsuFechaFin;
    }

    public void setPrsuFechaFin(Date prsuFechaFin) {
        this.prsuFechaFin = prsuFechaFin;
    }

    public Boolean getPrsuTieneAdelanto() {
        return prsuTieneAdelanto;
    }

    public void setPrsuTieneAdelanto(Boolean prsuTieneAdelanto) {
        this.prsuTieneAdelanto = prsuTieneAdelanto;
    }

    public String getPrubDepartamento() {
        return prubDepartamento;
    }

    public void setPrubDepartamento(String prubDepartamento) {
        this.prubDepartamento = prubDepartamento;
    }

    public String getPrubProvincia() {
        return prubProvincia;
    }

    public void setPrubProvincia(String prubProvincia) {
        this.prubProvincia = prubProvincia;
    }

    public String getPrubDistrito() {
        return prubDistrito;
    }

    public void setPrubDistrito(String prubDistrito) {
        this.prubDistrito = prubDistrito;
    }

    public String getPrubLocalidad() {
        return prubLocalidad;
    }

    public void setPrubLocalidad(String prubLocalidad) {
        this.prubLocalidad = prubLocalidad;
    }

    public BigDecimal getPrubLatitud() {
        return prubLatitud;
    }

    public void setPrubLatitud(BigDecimal prubLatitud) {
        this.prubLatitud = prubLatitud;
    }

    public BigDecimal getPrubLongitud() {
        return prubLongitud;
    }

    public void setPrubLongitud(BigDecimal prubLongitud) {
        this.prubLongitud = prubLongitud;
    }

    public BigDecimal getPrvaMontoProgramado() {
        return prvaMontoProgramado;
    }

    public void setPrvaMontoProgramado(BigDecimal prvaMontoProgramado) {
        this.prvaMontoProgramado = prvaMontoProgramado;
    }

    public BigDecimal getPrvaMontoEjecutado() {
        return prvaMontoEjecutado;
    }

    public void setPrvaMontoEjecutado(BigDecimal prvaMontoEjecutado) {
        this.prvaMontoEjecutado = prvaMontoEjecutado;
    }

    public BigDecimal getPrvaMontoPagado() {
        return prvaMontoPagado;
    }

    public void setPrvaMontoPagado(BigDecimal prvaMontoPagado) {
        this.prvaMontoPagado = prvaMontoPagado;
    }

    public Date getPrsuFechaFirmaContrato() {
        return prsuFechaFirmaContrato;
    }

    public void setPrsuFechaFirmaContrato(Date prsuFechaFirmaContrato) {
        this.prsuFechaFirmaContrato = prsuFechaFirmaContrato;
    }

    public Boolean getPrejTieneAdelantoMaterial() {
        return prejTieneAdelantoMaterial;
    }

    public void setPrejTieneAdelantoMaterial(Boolean prejTieneAdelantoMaterial) {
        this.prejTieneAdelantoMaterial = prejTieneAdelantoMaterial;
    }

    public Date getPrejFechaFirmaContra() {
        return prejFechaFirmaContra;
    }

    public void setPrejFechaFirmaContra(Date prejFechaFirmaContra) {
        this.prejFechaFirmaContra = prejFechaFirmaContra;
    }

    public Date getPrejFechaEntregaTerre() {
        return prejFechaEntregaTerre;
    }

    public void setPrejFechaEntregaTerre(Date prejFechaEntregaTerre) {
        this.prejFechaEntregaTerre = prejFechaEntregaTerre;
    }

    public Boolean getPrejTieneAdelantoDirecto() {
        return prejTieneAdelantoDirecto;
    }

    public void setPrejTieneAdelantoDirecto(Boolean prejTieneAdelantoDirecto) {
        this.prejTieneAdelantoDirecto = prejTieneAdelantoDirecto;
    }

    public Integer getPrfoOrden() {
        return prfoOrden;
    }

    public void setPrfoOrden(Integer prfoOrden) {
        this.prfoOrden = prfoOrden;
    }

    public String getPrfoTitulo() {
        return prfoTitulo;
    }

    public void setPrfoTitulo(String prfoTitulo) {
        this.prfoTitulo = prfoTitulo;
    }

    public String getPrfoDescripcion() {
        return prfoDescripcion;
    }

    public void setPrfoDescripcion(String prfoDescripcion) {
        this.prfoDescripcion = prfoDescripcion;
    }

    public String getPrfoUrlWindows() {
        return prfoUrlWindows;
    }

    public void setPrfoUrlWindows(String prfoUrlWindows) {
        this.prfoUrlWindows = prfoUrlWindows;
    }

    public String getPrfoUrlLinux() {
        return prfoUrlLinux;
    }

    public void setPrfoUrlLinux(String prfoUrlLinux) {
        this.prfoUrlLinux = prfoUrlLinux;
    }

    public Boolean getPrfoPrincipal() {
        return prfoPrincipal;
    }

    public void setPrfoPrincipal(Boolean prfoPrincipal) {
        this.prfoPrincipal = prfoPrincipal;
    }

    public String getPrfoTipo() {
        return prfoTipo;
    }

    public void setPrfoTipo(String prfoTipo) {
        this.prfoTipo = prfoTipo;
    }

    public Integer getPresetEtapa() {
        return presetEtapa;
    }

    public void setPresetEtapa(Integer presetEtapa) {
        this.presetEtapa = presetEtapa;
    }

    public Date getPresetFechaAproba() {
        return presetFechaAproba;
    }

    public void setPresetFechaAproba(Date presetFechaAproba) {
        this.presetFechaAproba = presetFechaAproba;
    }

    public String getPresetDocAproba() {
        return presetDocAproba;
    }

    public void setPresetDocAproba(String presetDocAproba) {
        this.presetDocAproba = presetDocAproba;
    }

    public String getPresetContrato() {
        return presetContrato;
    }

    public void setPresetContrato(String presetContrato) {
        this.presetContrato = presetContrato;
    }

    public String getPresetResponsable() {
        return presetResponsable;
    }

    public void setPresetResponsable(String presetResponsable) {
        this.presetResponsable = presetResponsable;
    }

    public Integer getPrejadNro() {
        return prejadNro;
    }

    public void setPrejadNro(Integer prejadNro) {
        this.prejadNro = prejadNro;
    }

    public BigDecimal getPrejadMonto() {
        return prejadMonto;
    }

    public void setPrejadMonto(BigDecimal prejadMonto) {
        this.prejadMonto = prejadMonto;
    }

    public String getPrejadTipo() {
        return prejadTipo;
    }

    public void setPrejadTipo(String prejadTipo) {
        this.prejadTipo = prejadTipo;
    }

    public Date getPrejadFecha() {
        return prejadFecha;
    }

    public void setPrejadFecha(Date prejadFecha) {
        this.prejadFecha = prejadFecha;
    }

    public String getPrejadComentario() {
        return prejadComentario;
    }

    public void setPrejadComentario(String prejadComentario) {
        this.prejadComentario = prejadComentario;
    }

    public Integer getPrsuadNro() {
        return prsuadNro;
    }

    public void setPrsuadNro(Integer prsuadNro) {
        this.prsuadNro = prsuadNro;
    }

    public BigDecimal getPrsuadMonto() {
        return prsuadMonto;
    }

    public void setPrsuadMonto(BigDecimal prsuadMonto) {
        this.prsuadMonto = prsuadMonto;
    }

    public Date getPrsuadFecha() {
        return prsuadFecha;
    }

    public void setPrsuadFecha(Date prsuadFecha) {
        this.prsuadFecha = prsuadFecha;
    }

    public String getPrsuadComentario() {
        return prsuadComentario;
    }

    public void setPrsuadComentario(String prsuadComentario) {
        this.prsuadComentario = prsuadComentario;
    }

    public Integer getPrpsNro() {
        return prpsNro;
    }

    public void setPrpsNro(Integer prpsNro) {
        this.prpsNro = prpsNro;
    }

    public Integer getPrpsDias() {
        return prpsDias;
    }

    public void setPrpsDias(Integer prpsDias) {
        this.prpsDias = prpsDias;
    }

    public String getPrpsDocumento() {
        return prpsDocumento;
    }

    public void setPrpsDocumento(String prpsDocumento) {
        this.prpsDocumento = prpsDocumento;
    }

    public Date getPrpsFecha() {
        return prpsFecha;
    }

    public void setPrpsFecha(Date prpsFecha) {
        this.prpsFecha = prpsFecha;
    }

    public String getPrpsTipo() {
        return prpsTipo;
    }

    public void setPrpsTipo(String prpsTipo) {
        this.prpsTipo = prpsTipo;
    }

    public String getAno_eje() {
        return ano_eje;
    }

    public void setAno_eje(String ano_eje) {
        this.ano_eje = ano_eje;
    }

    public String getSec_ejec() {
        return sec_ejec;
    }

    public void setSec_ejec(String sec_ejec) {
        this.sec_ejec = sec_ejec;
    }

    public String getEjecutora() {
        return ejecutora;
    }

    public void setEjecutora(String ejecutora) {
        this.ejecutora = ejecutora;
    }

    public String getNombre_ejecutora() {
        return nombre_ejecutora;
    }

    public void setNombre_ejecutora(String nombre_ejecutora) {
        this.nombre_ejecutora = nombre_ejecutora;
    }

    public BigDecimal getPia() {
        return pia;
    }

    public void setPia(BigDecimal pia) {
        this.pia = pia;
    }

    public BigDecimal getPim() {
        return pim;
    }

    public void setPim(BigDecimal pim) {
        this.pim = pim;
    }

    public BigDecimal getDevengado() {
        return devengado;
    }

    public void setDevengado(BigDecimal devengado) {
        this.devengado = devengado;
    }

    public String getAct_proy() {
        return act_proy;
    }

    public void setAct_proy(String act_proy) {
        this.act_proy = act_proy;
    }

    public BigDecimal getDevengado_acumulado() {
        return devengado_acumulado;
    }

    public void setDevengado_acumulado(BigDecimal devengado_acumulado) {
        this.devengado_acumulado = devengado_acumulado;
    }

    public Date getFecha_doc() {
        return fecha_doc;
    }

    public void setFecha_doc(Date fecha_doc) {
        this.fecha_doc = fecha_doc;
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public String getSec_func() {
        return sec_func;
    }

    public void setSec_func(String sec_func) {
        this.sec_func = sec_func;
    }

    public String getFuente_financ() {
        return fuente_financ;
    }

    public void setFuente_financ(String fuente_financ) {
        this.fuente_financ = fuente_financ;
    }

    public String getNombre_fuente_financ() {
        return nombre_fuente_financ;
    }

    public void setNombre_fuente_financ(String nombre_fuente_financ) {
        this.nombre_fuente_financ = nombre_fuente_financ;
    }

    public String getClasificador() {
        return clasificador;
    }

    public void setClasificador(String clasificador) {
        this.clasificador = clasificador;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getCertificacion() {
        return certificacion;
    }

    public void setCertificacion(String certificacion) {
        this.certificacion = certificacion;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getNombre_funcion() {
        return nombre_funcion;
    }

    public void setNombre_funcion(String nombre_funcion) {
        this.nombre_funcion = nombre_funcion;
    }

}
