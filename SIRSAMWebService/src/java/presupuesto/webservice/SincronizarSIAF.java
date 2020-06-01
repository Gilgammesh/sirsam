package presupuesto.webservice;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import presupuesto.bean.ActProyNombre;
import presupuesto.bean.Banco;
import presupuesto.bean.CategoriaGasto;
import presupuesto.bean.CategoriaIngreso;
import presupuesto.bean.Certificado;
import presupuesto.bean.CertificadoFase;
import presupuesto.bean.CertificadoMeta;
import presupuesto.bean.CertificadoSecuencia;
import presupuesto.bean.Ciclo;
import presupuesto.bean.ComponenteNombre;
import presupuesto.bean.CtaCte;
import presupuesto.bean.Departamento;
import presupuesto.bean.Distrito;
import presupuesto.bean.EjecucionHistorica;
import presupuesto.bean.Ejecutora;
import presupuesto.bean.Especifica;
import presupuesto.bean.EspecificaDet;
import presupuesto.bean.Expediente;
import presupuesto.bean.ExpedienteAdjunto;
import presupuesto.bean.ExpedienteDocumento;
import presupuesto.bean.ExpedienteFase;
import presupuesto.bean.ExpedienteIngreso;
import presupuesto.bean.ExpedienteMeta;
import presupuesto.bean.ExpedienteNota;
import presupuesto.bean.ExpedienteSecuencia;
import presupuesto.bean.Fase;
import presupuesto.bean.Finalidad;
import presupuesto.bean.FuenteFinanc;
import presupuesto.bean.FuenteFinancAgregada;
import presupuesto.bean.Funcion;
import presupuesto.bean.Gasto;
import presupuesto.bean.Generica;
import presupuesto.bean.Ingreso;
import presupuesto.bean.MaestroDocumento;
import presupuesto.bean.Meta;
import presupuesto.bean.MetaTrimestral;
import presupuesto.bean.NotaModificatoriaCab;
import presupuesto.bean.NotaModificatoriaDet;
import presupuesto.bean.NotaModificatoriaDoc;
import presupuesto.bean.NotaModificatoriaIng;
import presupuesto.bean.NotaModificatoriaSec;
import presupuesto.bean.PadronPersona;
import presupuesto.bean.Persona;
import presupuesto.bean.PersonaCciEjec;
import presupuesto.bean.Pliego;
import presupuesto.bean.ProgramaNombre;
import presupuesto.bean.ProgramaPptoNombre;
import presupuesto.bean.Provincia;
import presupuesto.bean.RecaudacionHistorica;
import presupuesto.bean.SubGenerica;
import presupuesto.bean.SubGenericaDet;
import presupuesto.bean.SubProgramaNombre;
import presupuesto.bean.TipoDocumento;
import presupuesto.bean.TipoOperacion;
import presupuesto.bean.TipoProgramaPpto;
import presupuesto.bean.TipoRecurso;
import presupuesto.bean.TipoTransaccion;
import presupuesto.bean.UnidadMedida;
import presupuesto.dao.PresupuestoDao;

/*
 ** @author CARLOS SANTANDER
 */
@WebService(serviceName = "SincronizarSIAF")
public class SincronizarSIAF {

    @WebMethod(operationName = "upsertActProyNombre")
    public void upsertActProyNombre(
            @WebParam(name = "dataActProyNombre") List<ActProyNombre> dataActProyNombre,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertActProyNombre(dataActProyNombre, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertBanco")
    public void upsertBanco(
            @WebParam(name = "dataBanco") List<Banco> dataBanco,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertBanco(dataBanco, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertCategoriaGasto")
    public void upsertCategoriaGasto(
            @WebParam(name = "dataCategoriaGasto") List<CategoriaGasto> dataCategoriaGasto,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertCategoriaGasto(dataCategoriaGasto, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertCategoriaIngreso")
    public void upsertCategoriaIngreso(
            @WebParam(name = "dataCategoriaIngreso") List<CategoriaIngreso> dataCategoriaIngreso,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertCategoriaIngreso(dataCategoriaIngreso, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertCertificado")
    public void upsertCertificado(
            @WebParam(name = "dataCertificado") List<Certificado> dataCertificado,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertCertificado(dataCertificado, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertCertificadoFase")
    public void upsertCertificadoFase(
            @WebParam(name = "dataCertificadoFase") List<CertificadoFase> dataCertificadoFase,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertCertificadoFase(dataCertificadoFase, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertCertificadoMeta")
    public void upsertCertificadoMeta(
            @WebParam(name = "dataCertificadoMeta") List<CertificadoMeta> dataCertificadoMeta,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertCertificadoMeta(dataCertificadoMeta, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertCertificadoSecuencia")
    public void upsertCertificadoSecuencia(
            @WebParam(name = "dataCertificadoSecuencia") List<CertificadoSecuencia> dataCertificadoSecuencia,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertCertificadoSecuencia(dataCertificadoSecuencia, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertCiclo")
    public void upsertCiclo(
            @WebParam(name = "dataCiclo") List<Ciclo> dataCiclo,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertCiclo(dataCiclo, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertComponenteNombre")
    public void upsertComponenteNombre(
            @WebParam(name = "dataComponenteNombre") List<ComponenteNombre> dataComponenteNombre,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertComponenteNombre(dataComponenteNombre, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertCtaCte")
    public void upsertCtaCte(
            @WebParam(name = "dataCtaCte") List<CtaCte> dataCtaCte,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertCtaCte(dataCtaCte, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertDepartamento")
    public void upsertDepartamento(
            @WebParam(name = "dataDepartamento") List<Departamento> dataDepartamento,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertDepartamento(dataDepartamento, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertDistrito")
    public void upsertDistrito(
            @WebParam(name = "dataDistrito") List<Distrito> dataDistrito,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertDistrito(dataDistrito, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertEjecucionHistoricaTotal")
    public void upsertEjecucionHistoricaTotal(
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            List<EjecucionHistorica> data = new PresupuestoDao().getEjecucionHistoricaTotal();
            new PresupuestoDao().upsertEjecucionHistorica(data, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertEjecucionHistoricaActual")
    public void upsertEjecucionHistoricaActual(
            @WebParam(name = "ano") int ano,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            String query = " WHERE a.ano_eje = '" + ano + "' AND d.ciclo = 'G' ";
            List<EjecucionHistorica> data = new PresupuestoDao().getEjecucionHistoricaActual(query);
            new PresupuestoDao().upsertEjecucionHistorica(data, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertEjecutora")
    public void upsertEjecutora(
            @WebParam(name = "dataEjecutora") List<Ejecutora> dataEjecutora,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertEjecutora(dataEjecutora, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertEspecifica")
    public void upsertEspecifica(
            @WebParam(name = "dataEspecifica") List<Especifica> dataEspecifica,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertEspecifica(dataEspecifica, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertEspecificaDet")
    public void upsertEspecificaDet(
            @WebParam(name = "dataEspecificaDet") List<EspecificaDet> dataEspecificaDet,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertEspecificaDet(dataEspecificaDet, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertExpediente")
    public void upsertExpediente(
            @WebParam(name = "dataExpediente") List<Expediente> dataExpediente,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertExpediente(dataExpediente, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertExpedienteAdjunto")
    public void upsertExpedienteAdjunto(
            @WebParam(name = "dataExpedienteAdjunto") List<ExpedienteAdjunto> dataExpedienteAdjunto,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertExpedienteAdjunto(dataExpedienteAdjunto, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertExpedienteDocumento")
    public void upsertExpedienteDocumento(
            @WebParam(name = "dataExpedienteDocumento") List<ExpedienteDocumento> dataExpedienteDocumento,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertExpedienteDocumento(dataExpedienteDocumento, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertExpedienteFase")
    public void upsertExpedienteFase(
            @WebParam(name = "dataExpedienteFase") List<ExpedienteFase> dataExpedienteFase,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertExpedienteFase(dataExpedienteFase, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertExpedienteIngreso")
    public void upsertExpedienteIngreso(
            @WebParam(name = "dataExpedienteIngreso") List<ExpedienteIngreso> dataExpedienteIngreso,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertExpedienteIngreso(dataExpedienteIngreso, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertExpedienteMeta")
    public void upsertExpedienteMeta(
            @WebParam(name = "dataExpedienteMeta") List<ExpedienteMeta> dataExpedienteMeta,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertExpedienteMeta(dataExpedienteMeta, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertExpedienteNota")
    public void upsertExpedienteNota(
            @WebParam(name = "dataExpedienteNota") List<ExpedienteNota> dataExpedienteNota,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertExpedienteNota(dataExpedienteNota, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertExpedienteSecuencia")
    public void upsertExpedienteSecuencia(
            @WebParam(name = "dataExpedienteSecuencia") List<ExpedienteSecuencia> dataExpedienteSecuencia,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertExpedienteSecuencia(dataExpedienteSecuencia, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertFase")
    public void upsertFase(
            @WebParam(name = "dataFase") List<Fase> dataFase,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertFase(dataFase, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertFinalidad")
    public void upsertFinalidad(
            @WebParam(name = "dataFinalidad") List<Finalidad> dataFinalidad,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertFinalidad(dataFinalidad, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertFuenteFinanc")
    public void upsertFuenteFinanc(
            @WebParam(name = "dataFuenteFinanc") List<FuenteFinanc> dataFuenteFinanc,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertFuenteFinanc(dataFuenteFinanc, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertFuenteFinancAgregada")
    public void upsertFuenteFinancAgregada(
            @WebParam(name = "dataFuenteFinancAgregada") List<FuenteFinancAgregada> dataFuenteFinancAgregada,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertFuenteFinancAgregada(dataFuenteFinancAgregada, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertFuncion")
    public void upsertFuncion(
            @WebParam(name = "dataFuncion") List<Funcion> dataFuncion,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertFuncion(dataFuncion, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertGasto")
    public void upsertGasto(
            @WebParam(name = "dataGasto") List<Gasto> dataGasto,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertGasto(dataGasto, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertGenerica")
    public void upsertGenerica(
            @WebParam(name = "dataGenerica") List<Generica> dataGenerica,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertGenerica(dataGenerica, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertIngreso")
    public void upsertIngreso(
            @WebParam(name = "dataIngreso") List<Ingreso> dataIngreso,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertIngreso(dataIngreso, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "insertLogsSincronizar")
    public void insertLogsSincronizar(
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip,
            @WebParam(name = "sync") String sync,
            @WebParam(name = "log_cliente") String log_cliente,
            @WebParam(name = "log_servidor") String log_servidor
    ) {
        try {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, sync, log_cliente, log_servidor);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertMaestroDocumento")
    public void upsertMaestroDocumento(
            @WebParam(name = "dataMaestroDocumento") List<MaestroDocumento> dataMaestroDocumento,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertMaestroDocumento(dataMaestroDocumento, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertMeta")
    public void upsertMeta(
            @WebParam(name = "dataMeta") List<Meta> dataMeta,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertMeta(dataMeta, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertMetaTrimestral")
    public void upsertMetaTrimestral(
            @WebParam(name = "dataMetaTrimestral") List<MetaTrimestral> dataMetaTrimestral,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertMetaTrimestral(dataMetaTrimestral, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertNotaModificatoriaCab")
    public void upsertNotaModificatoriaCab(
            @WebParam(name = "dataNotaModificatoriaCab") List<NotaModificatoriaCab> dataNotaModificatoriaCab,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertNotaModificatoriaCab(dataNotaModificatoriaCab, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertNotaModificatoriaDet")
    public void upsertNotaModificatoriaDet(
            @WebParam(name = "dataNotaModificatoriaDet") List<NotaModificatoriaDet> dataNotaModificatoriaDet,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertNotaModificatoriaDet(dataNotaModificatoriaDet, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertNotaModificatoriaDoc")
    public void upsertNotaModificatoriaDoc(
            @WebParam(name = "dataNotaModificatoriaDoc") List<NotaModificatoriaDoc> dataNotaModificatoriaDoc,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertNotaModificatoriaDoc(dataNotaModificatoriaDoc, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertNotaModificatoriaIng")
    public void upsertNotaModificatoriaIng(
            @WebParam(name = "dataNotaModificatoriaIng") List<NotaModificatoriaIng> dataNotaModificatoriaIng,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertNotaModificatoriaIng(dataNotaModificatoriaIng, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertNotaModificatoriaSec")
    public void upsertNotaModificatoriaSec(
            @WebParam(name = "dataNotaModificatoriaSec") List<NotaModificatoriaSec> dataNotaModificatoriaSec,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertNotaModificatoriaSec(dataNotaModificatoriaSec, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertPadronPersona")
    public void upsertPadronPersona(
            @WebParam(name = "dataPadronPersona") List<PadronPersona> dataPadronPersona,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertPadronPersona(dataPadronPersona, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertPersona")
    public void upsertPersona(
            @WebParam(name = "dataPersona") List<Persona> dataPersona,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertPersona(dataPersona, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertPersonaCciEjec")
    public void upsertPersonaCciEjec(
            @WebParam(name = "dataPersonaCciEjec") List<PersonaCciEjec> dataPersonaCciEjec,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertPersonaCciEjec(dataPersonaCciEjec, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertPliego")
    public void upsertPliego(
            @WebParam(name = "dataPliego") List<Pliego> dataPliego,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertPliego(dataPliego, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertProgramaNombre")
    public void upsertProgramaNombre(
            @WebParam(name = "dataProgramaNombre") List<ProgramaNombre> dataProgramaNombre,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertProgramaNombre(dataProgramaNombre, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertProgramaPptoNombre")
    public void upsertProgramaPptoNombre(
            @WebParam(name = "dataProgramaPptoNombre") List<ProgramaPptoNombre> dataProgramaPptoNombre,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertProgramaPptoNombre(dataProgramaPptoNombre, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertProvincia")
    public void upsertProvincia(
            @WebParam(name = "dataProvincia") List<Provincia> dataProvincia,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertProvincia(dataProvincia, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertRecaudacionHistoricaTotal")
    public void upsertRecaudacionHistoricaTotal(
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            List<RecaudacionHistorica> data = new PresupuestoDao().getRecaudacionHistoricaTotal();
            new PresupuestoDao().upsertRecaudacionHistorica(data, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertRecaudacionHistoricaActual")
    public void upsertRecaudacionHistoricaActual(
            @WebParam(name = "ano") int ano,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            String query = " WHERE a.ano_eje = '" + ano + "' AND b.ciclo = 'I' ";
            List<RecaudacionHistorica> data = new PresupuestoDao().getRecaudacionHistoricaActual(query);
            new PresupuestoDao().upsertRecaudacionHistorica(data, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertSubGenerica")
    public void upsertSubGenerica(
            @WebParam(name = "dataSubGenerica") List<SubGenerica> dataSubGenerica,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertSubGenerica(dataSubGenerica, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertSubGenericaDet")
    public void upsertSubGenericaDet(
            @WebParam(name = "dataSubGenericaDet") List<SubGenericaDet> dataSubGenericaDet,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertSubGenericaDet(dataSubGenericaDet, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertSubProgramaNombre")
    public void upsertSubProgramaNombre(
            @WebParam(name = "dataSubProgramaNombre") List<SubProgramaNombre> dataSubProgramaNombre,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertSubProgramaNombre(dataSubProgramaNombre, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertTipoDocumento")
    public void upsertTipoDocumento(
            @WebParam(name = "dataTipoDocumento") List<TipoDocumento> dataTipoDocumento,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertTipoDocumento(dataTipoDocumento, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertTipoOperacion")
    public void upsertTipoOperacion(
            @WebParam(name = "dataTipoOperacion") List<TipoOperacion> dataTipoOperacion,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertTipoOperacion(dataTipoOperacion, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertTipoProgramaPpto")
    public void upsertTipoProgramaPpto(
            @WebParam(name = "dataTipoProgramaPpto") List<TipoProgramaPpto> dataTipoProgramaPpto,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertTipoProgramaPpto(dataTipoProgramaPpto, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertTipoRecurso")
    public void upsertTipoRecurso(
            @WebParam(name = "dataTipoRecurso") List<TipoRecurso> dataTipoRecurso,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertTipoRecurso(dataTipoRecurso, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertTipoTransaccion")
    public void upsertTipoTransaccion(
            @WebParam(name = "dataTipoTransaccion") List<TipoTransaccion> dataTipoTransaccion,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertTipoTransaccion(dataTipoTransaccion, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertUnidadMedida")
    public void upsertUnidadMedida(
            @WebParam(name = "dataUnidadMedida") List<UnidadMedida> dataUnidadMedida,
            @WebParam(name = "time") long time,
            @WebParam(name = "ejec") String ejec,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new PresupuestoDao().upsertUnidadMedida(dataUnidadMedida, time, ejec, tabla, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(SincronizarSIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
