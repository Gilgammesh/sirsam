package run;

import dao.SiafDao;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.List;
import presupuesto.webservice.ActProyNombre;
import presupuesto.webservice.Banco;
import presupuesto.webservice.CategoriaGasto;
import presupuesto.webservice.CategoriaIngreso;
import presupuesto.webservice.Certificado;
import presupuesto.webservice.CertificadoFase;
import presupuesto.webservice.CertificadoMeta;
import presupuesto.webservice.CertificadoSecuencia;
import presupuesto.webservice.Ciclo;
import presupuesto.webservice.ComponenteNombre;
import presupuesto.webservice.CtaCte;
import presupuesto.webservice.Departamento;
import presupuesto.webservice.Distrito;
import presupuesto.webservice.Ejecutora;
import presupuesto.webservice.Especifica;
import presupuesto.webservice.EspecificaDet;
import presupuesto.webservice.Expediente;
import presupuesto.webservice.ExpedienteAdjunto;
import presupuesto.webservice.ExpedienteDocumento;
import presupuesto.webservice.ExpedienteFase;
import presupuesto.webservice.ExpedienteIngreso;
import presupuesto.webservice.ExpedienteMeta;
import presupuesto.webservice.ExpedienteNota;
import presupuesto.webservice.ExpedienteSecuencia;
import presupuesto.webservice.Fase;
import presupuesto.webservice.Finalidad;
import presupuesto.webservice.FuenteFinanc;
import presupuesto.webservice.FuenteFinancAgregada;
import presupuesto.webservice.Funcion;
import presupuesto.webservice.Gasto;
import presupuesto.webservice.Generica;
import presupuesto.webservice.Ingreso;
import presupuesto.webservice.MaestroDocumento;
import presupuesto.webservice.Meta;
import presupuesto.webservice.MetaTrimestral;
import presupuesto.webservice.NotaModificatoriaCab;
import presupuesto.webservice.NotaModificatoriaDet;
import presupuesto.webservice.NotaModificatoriaDoc;
import presupuesto.webservice.NotaModificatoriaIng;
import presupuesto.webservice.NotaModificatoriaSec;
import presupuesto.webservice.PadronPersona;
import presupuesto.webservice.Persona;
import presupuesto.webservice.PersonaCciEjec;
import presupuesto.webservice.Pliego;
import presupuesto.webservice.ProgramaNombre;
import presupuesto.webservice.ProgramaPptoNombre;
import presupuesto.webservice.Provincia;
import presupuesto.webservice.SincronizarSIAF;
import presupuesto.webservice.SincronizarSIAF_Service;
import presupuesto.webservice.SubGenerica;
import presupuesto.webservice.SubGenericaDet;
import presupuesto.webservice.SubProgramaNombre;
import presupuesto.webservice.TipoDocumento;
import presupuesto.webservice.TipoOperacion;
import presupuesto.webservice.TipoProgramaPpto;
import presupuesto.webservice.TipoRecurso;
import presupuesto.webservice.TipoTransaccion;
import presupuesto.webservice.UnidadMedida;

/*
 // @author CARLOS SANTANDER
 */
public class SIRSAM_SIAF {

    public static void main(String[] args) throws UnknownHostException {

        Runtime rt = Runtime.getRuntime();
        long memoTotal = rt.totalMemory();
        long memoMaxim = rt.maxMemory();
        long memoLibre = rt.freeMemory();
        double megas = 1048576.0;

        System.out.println("Memoria Total: " + memoTotal + " (" + (memoTotal / megas) + " MB)");
        System.out.println("Memoria Máxima:   " + memoMaxim + " (" + (memoMaxim / megas) + " MB)");
        System.out.println("Memoria Libre:  " + memoLibre + " (" + (memoLibre / megas) + " MB)\n");

        SincronizarSIAF_Service service = new SincronizarSIAF_Service();
        SincronizarSIAF port = service.getSincronizarSIAFPort();

        Calendar calIni = Calendar.getInstance();
        int year = calIni.get(Calendar.YEAR);
        String ano = year + "";
        String ejec = "000921";
        InetAddress inet = InetAddress.getLocalHost();
        String host = inet.getHostName();
        String ip = inet.getHostAddress();

        String query1 = " WHERE ano_eje = '" + ano + "' AND sec_ejec = '" + ejec + "' ";
        String query2 = " WHERE ano_eje = '" + ano + "' ";
        String query3 = " WHERE sec_ejec = '" + ejec + "' ";

        String tipo_sincronizacion = "general"; //=====>  Una vez al día: tablas generales 
        //String tipo_sincronizacion = "diario"; //=====>  Varias veces al día: tablas transaccionales

        if (tipo_sincronizacion.equals("diario")) {
            System.out.println("Sincronizando tablas transaccionales del SIAF\n");
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "certificado";
                List<Certificado> data = new SiafDao().getCertificado(query1, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertCertificado(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: certificado ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: certificado ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "certificado_fase";
                List<CertificadoFase> data = new SiafDao().getCertificadoFase(query1, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertCertificadoFase(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: certificado_fase ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: certificado_fase ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "certificado_meta";
                List<CertificadoMeta> data = new SiafDao().getCertificadoMeta(query1, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertCertificadoMeta(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: certificado_meta ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: certificado_meta ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "certificado_secuencia";
                List<CertificadoSecuencia> data = new SiafDao().getCertificadoSecuencia(query1, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertCertificadoSecuencia(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: certificado_secuencia ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: certificado_secuencia ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "expediente";
                List<Expediente> data = new SiafDao().getExpediente(query1, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertExpediente(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: expediente ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: expediente ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "expediente_adjunto";
                List<ExpedienteAdjunto> data = new SiafDao().getExpedienteAdjunto(query1, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertExpedienteAdjunto(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: expediente_adjunto ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: expediente_adjunto ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "expediente_documento";
                List<ExpedienteDocumento> data = new SiafDao().getExpedienteDocumento(query1, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertExpedienteDocumento(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: expediente_documento ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: expediente_documento ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "expediente_fase";
                List<ExpedienteFase> data = new SiafDao().getExpedienteFase(query1, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertExpedienteFase(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: expediente_fase ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: expediente_fase ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "expediente_ingreso";
                List<ExpedienteIngreso> data = new SiafDao().getExpedienteIngreso(query1, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertExpedienteIngreso(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: expediente_ingreso ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: expediente_ingreso ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "expediente_meta";
                List<ExpedienteMeta> data = new SiafDao().getExpedienteMeta(query1, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertExpedienteMeta(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: expediente_meta ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: expediente_meta ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "expediente_nota";
                List<ExpedienteNota> data = new SiafDao().getExpedienteNota(query1, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertExpedienteNota(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: expediente_nota ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: expediente_nota ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "expediente_secuencia";
                List<ExpedienteSecuencia> data = new SiafDao().getExpedienteSecuencia(query1, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertExpedienteSecuencia(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: expediente_secuencia ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: expediente_secuencia ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "gasto";
                List<Gasto> data = new SiafDao().getGasto(query1, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertGasto(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: gasto ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: gasto ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "ingreso";
                List<Ingreso> data = new SiafDao().getIngreso(query1, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertIngreso(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: ingreso ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: ingreso ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "meta";
                List<Meta> data = new SiafDao().getMeta(query1, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertMeta(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: meta ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: meta ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "meta_trimestral";
                List<MetaTrimestral> data = new SiafDao().getMetaTrimestral(query1, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertMetaTrimestral(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: meta_trimestral ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: meta_trimestral ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "nota_modificatoria_cab";
                List<NotaModificatoriaCab> data = new SiafDao().getNotaModificatoriaCab(query1, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertNotaModificatoriaCab(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: nota_modificatoria_cab ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: nota_modificatoria_cab ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "nota_modificatoria_det";
                List<NotaModificatoriaDet> data = new SiafDao().getNotaModificatoriaDet(query1, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertNotaModificatoriaDet(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: nota_modificatoria_det ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: nota_modificatoria_det ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "nota_modificatoria_doc";
                List<NotaModificatoriaDoc> data = new SiafDao().getNotaModificatoriaDoc(query1, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertNotaModificatoriaDoc(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: nota_modificatoria_doc ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: nota_modificatoria_doc ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "nota_modificatoria_ing";
                List<NotaModificatoriaIng> data = new SiafDao().getNotaModificatoriaIng(query1, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertNotaModificatoriaIng(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: nota_modificatoria_ing ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: nota_modificatoria_ing ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "nota_modificatoria_sec";
                List<NotaModificatoriaSec> data = new SiafDao().getNotaModificatoriaSec(query1, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertNotaModificatoriaSec(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: nota_modificatoria_sec ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: nota_modificatoria_sec ==> (falló)");
            }
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "ejecucion_historica_total";
                port.upsertEjecucionHistoricaTotal(time, ejec, tabla, host, ip);
                System.out.println("Tabla: ejecucion_historica_total ==> (sincronizado)");
            } catch (Exception ex) {
                System.out.println("Tabla: ejecucion_historica_total ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "ejecucion_historica_anterior";
                port.upsertEjecucionHistoricaActual(year - 1, time, ejec, tabla, host, ip);
                System.out.println("Tabla: ejecucion_historica_anterior ==> (sincronizado)");
            } catch (Exception ex) {
                System.out.println("Tabla: ejecucion_historica_anterior ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "ejecucion_historica_actual";
                port.upsertEjecucionHistoricaActual(year, time, ejec, tabla, host, ip);
                System.out.println("Tabla: ejecucion_historica_actual ==> (sincronizado)");
            } catch (Exception ex) {
                System.out.println("Tabla: ejecucion_historica_actual ==> (falló)");
            }
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "recaudacion_historica_total";
                port.upsertRecaudacionHistoricaTotal(time, ejec, tabla, host, ip);
                System.out.println("Tabla: recaudacion_historica_total ==> (sincronizado)");
            } catch (Exception ex) {
                System.out.println("Tabla: recaudacion_historica_total ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "recaudacion_historica_anterior";
                port.upsertRecaudacionHistoricaActual(year - 1, time, ejec, tabla, host, ip);
                System.out.println("Tabla: recaudacion_historica_anterior ==> (sincronizado)");
            } catch (Exception ex) {
                System.out.println("Tabla: recaudacion_historica_anterior ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "recaudacion_historica_actual";
                port.upsertRecaudacionHistoricaActual(year, time, ejec, tabla, host, ip);
                System.out.println("Tabla: recaudacion_historica_actual ==> (sincronizado)");
            } catch (Exception ex) {
                System.out.println("Tabla: recaudacion_historica_actual ==> (falló)");
            }
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            System.out.println("\n...TAREA LISTA....");
        }

        if (tipo_sincronizacion.equals("general")) {
            System.out.println("Sincronizando tablas generales del SIAF\n");
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "banco";
                List<Banco> data = new SiafDao().getBanco("", time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertBanco(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: banco ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: banco ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "ciclo";
                List<Ciclo> data = new SiafDao().getCiclo("", time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertCiclo(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: ciclo ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: ciclo ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "departamento";
                List<Departamento> data = new SiafDao().getDepartamento("", time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertDepartamento(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: departamento ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: departamento ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "distrito";
                List<Distrito> data = new SiafDao().getDistrito("", time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertDistrito(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: distrito ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: distrito ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "fase";
                List<Fase> data = new SiafDao().getFase("", time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertFase(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: fase ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: fase ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "maestro_documento";
                List<MaestroDocumento> data = new SiafDao().getMaestroDocumento("", time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertMaestroDocumento(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: maestro_documento ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: maestro_documento ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "padron_persona";
                List<PadronPersona> data = new SiafDao().getPadronPersona("", time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertPadronPersona(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: padron_persona ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: padron_persona ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "persona";
                List<Persona> data = new SiafDao().getPersona("", time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertPersona(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: persona ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: persona ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "provincia";
                List<Provincia> data = new SiafDao().getProvincia("", time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertProvincia(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: provincia ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: provincia ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "tipo_documento";
                List<TipoDocumento> data = new SiafDao().getTipoDocumento("", time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertTipoDocumento(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: tipo_documento ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: tipo_documento ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "unidad_medida";
                List<UnidadMedida> data = new SiafDao().getUnidadMedida("", time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertUnidadMedida(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: unidad_medida ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: unidad_medida ==> (falló)");
            }
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "cta_cte";
                List<CtaCte> data = new SiafDao().getCtaCte(query3, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertCtaCte(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: cta_cte ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: cta_cte ==> (falló)");
            }
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "act_proy_nombre";
                List<ActProyNombre> data = new SiafDao().getActProyNombre(query2, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertActProyNombre(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: " + tabla + " ==> (sincronizado)");
            } catch (IOException ex) {
                String tabla = "act_proy_nombre";
                System.out.println("Tabla: " + tabla + " ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "categoria_gasto";
                List<CategoriaGasto> data = new SiafDao().getCategoriaGasto(query2, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertCategoriaGasto(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: categoria_gasto ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: categoria_gasto ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "categoria_ingreso";
                List<CategoriaIngreso> data = new SiafDao().getCategoriaIngreso(query2, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertCategoriaIngreso(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: categoria_ingreso ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: categoria_ingreso ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "componente_nombre";
                List<ComponenteNombre> data = new SiafDao().getComponenteNombre(query2, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertComponenteNombre(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: componente_nombre ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: componente_nombre ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "ejecutora";
                List<Ejecutora> data = new SiafDao().getEjecutora(query2, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertEjecutora(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: ejecutora ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: ejecutora ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "especifica";
                List<Especifica> data = new SiafDao().getEspecifica(query2, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertEspecifica(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: especifica ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: especifica ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "especifica_det";
                List<EspecificaDet> data = new SiafDao().getEspecificaDet(query2, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertEspecificaDet(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: especifica_det ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: especifica_det ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "finalidad";
                List<Finalidad> data = new SiafDao().getFinalidad(query2, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertFinalidad(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: finalidad ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: finalidad ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "fuente_financ";
                List<FuenteFinanc> data = new SiafDao().getFuenteFinanc(query2, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertFuenteFinanc(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: fuente_financ ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: fuente_financ ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "fuente_financ_agregada";
                List<FuenteFinancAgregada> data = new SiafDao().getFuenteFinancAgregada(query2, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertFuenteFinancAgregada(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: fuente_financ_agregada ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: fuente_financ_agregada ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "funcion";
                List<Funcion> data = new SiafDao().getFuncion(query2, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertFuncion(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: funcion ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: funcion ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "generica";
                List<Generica> data = new SiafDao().getGenerica(query2, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertGenerica(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: generica ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: generica ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "pliego";
                List<Pliego> data = new SiafDao().getPliego(query2, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertPliego(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: pliego ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: pliego ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "programa_nombre";
                List<ProgramaNombre> data = new SiafDao().getProgramaNombre(query2, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertProgramaNombre(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: programa_nombre ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: programa_nombre ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "programa_ppto_nombre";
                List<ProgramaPptoNombre> data = new SiafDao().getProgramaPptoNombre(query2, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertProgramaPptoNombre(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: programa_ppto_nombre ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: programa_ppto_nombre ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "sub_generica";
                List<SubGenerica> data = new SiafDao().getSubGenerica(query2, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertSubGenerica(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: sub_generica ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: sub_generica ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "sub_generica_det";
                List<SubGenericaDet> data = new SiafDao().getSubGenericaDet(query2, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertSubGenericaDet(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: sub_generica_det ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: sub_generica_det ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "sub_programa_nombre";
                List<SubProgramaNombre> data = new SiafDao().getSubProgramaNombre(query2, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertSubProgramaNombre(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: sub_programa_nombre ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: sub_programa_nombre ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "tipo_operacion";
                List<TipoOperacion> data = new SiafDao().getTipoOperacion(query2, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertTipoOperacion(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: tipo_operacion ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: tipo_operacion ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "tipo_programa_ppto";
                List<TipoProgramaPpto> data = new SiafDao().getTipoProgramaPpto(query2, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertTipoProgramaPpto(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: tipo_programa_ppto ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: tipo_programa_ppto ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "tipo_recurso";
                List<TipoRecurso> data = new SiafDao().getTipoRecurso(query2, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertTipoRecurso(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: tipo_recurso ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: tipo_recurso ==> (falló)");
            }
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "tipo_transaccion";
                List<TipoTransaccion> data = new SiafDao().getTipoTransaccion(query2, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertTipoTransaccion(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: tipo_transaccion ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: tipo_transaccion ==> (falló)");
            }
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            try {
                Calendar cal = Calendar.getInstance();
                long time = cal.getTimeInMillis();
                String tabla = "persona_cci_ejec";
                List<PersonaCciEjec> data = new SiafDao().getPersonaCciEjec(query1, time, ejec, tabla, host, ip);
                if (!data.isEmpty()) {
                    port.upsertPersonaCciEjec(data, time, ejec, tabla, host, ip);
                }
                System.out.println("Tabla: persona_cci_ejec ==> (sincronizado)");
            } catch (IOException ex) {
                System.out.println("Tabla: persona_cci_ejec ==> (falló)");
            }
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            System.out.println("\n...TAREA LISTA....");
        }

    }

}
