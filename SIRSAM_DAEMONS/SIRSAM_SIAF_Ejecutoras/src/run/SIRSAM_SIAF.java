package run;

import dao.SiafDao;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.List;
import presupuesto.webservice.ActProyNombre;
import presupuesto.webservice.Certificado;
import presupuesto.webservice.CertificadoFase;
import presupuesto.webservice.CertificadoMeta;
import presupuesto.webservice.CertificadoSecuencia;
import presupuesto.webservice.CtaCte;
import presupuesto.webservice.Expediente;
import presupuesto.webservice.ExpedienteAdjunto;
import presupuesto.webservice.ExpedienteDocumento;
import presupuesto.webservice.ExpedienteFase;
import presupuesto.webservice.ExpedienteIngreso;
import presupuesto.webservice.ExpedienteMeta;
import presupuesto.webservice.ExpedienteNota;
import presupuesto.webservice.ExpedienteSecuencia;
import presupuesto.webservice.Gasto;
import presupuesto.webservice.Ingreso;
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
import presupuesto.webservice.SincronizarSIAF;
import presupuesto.webservice.SincronizarSIAF_Service;

/*
 // @author CARLOS SANTANDER
 */
public class SIRSAM_SIAF {

    public static void main(String[] args) throws UnknownHostException {

        // PARA LAS REDES DE EJECUTORAS QUE MANEJAN PROXY (Casos Particulares)
        //System.setProperty("proxySet", "true");
        //System.setProperty("proxyPort", "3128"); // U.E. 300 Ugel Moyobamba (000926)
        //System.setProperty("proxyPort", "1194"); // U.E. 100 Agricultura (000924)
        //System.setProperty("proxyPort", "80"); // 
        //System.setProperty("proxyHost", "10.30.2.6"); // U.E. 300 - Educación Alto Mayo - Moyobamba (000926) ---- Proxy de UGEL
        //System.setProperty("proxyHost", "172.16.12.1"); // U.E. 301 - Educación Bajo Mayo - Tarapoto (000927) ---- Proxy de MINEDU
        //System.setProperty("proxyHost", "172.31.224.1"); // U.E. 305 - Educación Lamas (001517)
        //System.setProperty("proxyHost", "172.31.198.1"); // U.E. 307 - Educación Bellavista (001527)        
        //System.setProperty("proxyHost", "10.31.1.1"); // U.E. 100 Agricultura (000924)

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

        //String tipo_sincronizacion = "general"; //=====>  Una vez al día: tablas generales 
        String tipo_sincronizacion = "diario"; //=====>  Varias veces al día: tablas transaccionales

        //----------------------------------------------------------------------------------------------------------------------//
        //String ejec = "000921";  // U.E. 001 - Sede Central
        //String ejec = "000922";  // U.E. 002 - Sub Región Alto Huallaga - Tocache
        //String ejec = "000923";  // U.E. 003 - Dirección Regional de Producción
        //String ejec = "000989";  // U.E. 004 - Sub Región Bajo Mayo - Tarapoto
        //String ejec = "001057";  // U.E. 005 - Sub Región Huallaga Central - Juanjui
        //String ejec = "001140";  // U.E. 006 - Proyecto Especial Alto Mayo (PEAM)
        //String ejec = "001263";  // U.E. 018 - Proyecto Especial Huallaga Central y Bajo Mayo (PEHCBM)
        //String ejec = "000924";  // U.E. 100 - Agricultura
        //String ejec = "000925";  // U.E. 200 - Transportes
        //String ejec = "000926";  // U.E. 300 - Educación Alto Mayo - Moyobamba
        //String ejec = "000927";  // U.E. 301 - Educación Bajo Mayo - Tarapoto
        //String ejec = "000928";  // U.E. 302 - Educación Huallaga Central - Juanjui
        //String ejec = "000929";  // U.E. 303 - Educación Alto Huallaga - Tocache
        //String ejec = "001517";  // U.E. 305 - Educación Lamas
        //String ejec = "001523";  // U.E. 306 - Educación Rioja
        //String ejec = "001527";  // U.E. 307 - Educación Bellavista
        //String ejec = "000930";  // U.E. 400 - Salud Bajo Mayo - Tarapoto
        //String ejec = "001058";  // U.E. 401 - Salud Alto Mayo - Moyobamba
        //String ejec = "001059";  // U.E. 402 - Salud Huallaga Central - Juanjui
        //String ejec = "001060";  // U.E. 403 - Salud Alto Huallaga - Tocache
        String ejec = "001400";  // U.E. 404 - Hospital II - Tarapoto
        //----------------------------------------------------------------------------------------------------------------------//

        InetAddress inet = InetAddress.getLocalHost();
        String host = inet.getHostName();
        String ip = inet.getHostAddress();

        String query1 = " WHERE ano_eje = '" + ano + "' AND sec_ejec = '" + ejec + "' ";
        String query2 = " WHERE ano_eje = '" + ano + "' ";
        String query3 = " WHERE sec_ejec = '" + ejec + "' ";

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
            System.out.println("\n...TAREA LISTA....");
        }

        if (tipo_sincronizacion.equals("general")) {
            System.out.println("Sincronizando tablas generales del SIAF\n");
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////            
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
