package dao;

import config.SiafConexion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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
public class SiafDao {

    private final SqlSessionFactory ssfWeb;

    public SiafDao() throws IOException {
        ssfWeb = SiafConexion.getSqlSessionFactory();
    }

    SincronizarSIAF_Service service = new SincronizarSIAF_Service();
    SincronizarSIAF port = service.getSincronizarSIAFPort();

    public List<ActProyNombre> getActProyNombre(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<ActProyNombre> list = (List<ActProyNombre>) new ArrayList<ActProyNombre>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getActProyNombre", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Banco> getBanco(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<Banco> list = (List<Banco>) new ArrayList<Banco>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getBanco", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<CategoriaGasto> getCategoriaGasto(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<CategoriaGasto> list = (List<CategoriaGasto>) new ArrayList<CategoriaGasto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getCategoriaGasto", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<CategoriaIngreso> getCategoriaIngreso(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<CategoriaIngreso> list = (List<CategoriaIngreso>) new ArrayList<CategoriaIngreso>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getCategoriaIngreso", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Certificado> getCertificado(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<Certificado> list = (List<Certificado>) new ArrayList<Certificado>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getCertificado", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<CertificadoFase> getCertificadoFase(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<CertificadoFase> list = (List<CertificadoFase>) new ArrayList<CertificadoFase>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getCertificadoFase", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<CertificadoMeta> getCertificadoMeta(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<CertificadoMeta> list = (List<CertificadoMeta>) new ArrayList<CertificadoMeta>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getCertificadoMeta", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<CertificadoSecuencia> getCertificadoSecuencia(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<CertificadoSecuencia> list = (List<CertificadoSecuencia>) new ArrayList<CertificadoSecuencia>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getCertificadoSecuencia", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Ciclo> getCiclo(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<Ciclo> list = (List<Ciclo>) new ArrayList<Ciclo>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getCiclo", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<ComponenteNombre> getComponenteNombre(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<ComponenteNombre> list = (List<ComponenteNombre>) new ArrayList<ComponenteNombre>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getComponenteNombre", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<CtaCte> getCtaCte(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<CtaCte> list = (List<CtaCte>) new ArrayList<CtaCte>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getCtaCte", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Departamento> getDepartamento(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<Departamento> list = (List<Departamento>) new ArrayList<Departamento>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getDepartamento", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Distrito> getDistrito(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<Distrito> list = (List<Distrito>) new ArrayList<Distrito>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getDistrito", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Ejecutora> getEjecutora(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<Ejecutora> list = (List<Ejecutora>) new ArrayList<Ejecutora>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getEjecutora", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Especifica> getEspecifica(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<Especifica> list = (List<Especifica>) new ArrayList<Especifica>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getEspecifica", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<EspecificaDet> getEspecificaDet(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<EspecificaDet> list = (List<EspecificaDet>) new ArrayList<EspecificaDet>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getEspecificaDet", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Expediente> getExpediente(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<Expediente> list = (List<Expediente>) new ArrayList<Expediente>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getExpediente", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<ExpedienteAdjunto> getExpedienteAdjunto(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<ExpedienteAdjunto> list = (List<ExpedienteAdjunto>) new ArrayList<ExpedienteAdjunto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getExpedienteAdjunto", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<ExpedienteDocumento> getExpedienteDocumento(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<ExpedienteDocumento> list = (List<ExpedienteDocumento>) new ArrayList<ExpedienteDocumento>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getExpedienteDocumento", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<ExpedienteFase> getExpedienteFase(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<ExpedienteFase> list = (List<ExpedienteFase>) new ArrayList<ExpedienteFase>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getExpedienteFase", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<ExpedienteIngreso> getExpedienteIngreso(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<ExpedienteIngreso> list = (List<ExpedienteIngreso>) new ArrayList<ExpedienteIngreso>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getExpedienteIngreso", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<ExpedienteMeta> getExpedienteMeta(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<ExpedienteMeta> list = (List<ExpedienteMeta>) new ArrayList<ExpedienteMeta>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getExpedienteMeta", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<ExpedienteNota> getExpedienteNota(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<ExpedienteNota> list = (List<ExpedienteNota>) new ArrayList<ExpedienteNota>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getExpedienteNota", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<ExpedienteSecuencia> getExpedienteSecuencia(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<ExpedienteSecuencia> list = (List<ExpedienteSecuencia>) new ArrayList<ExpedienteSecuencia>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getExpedienteSecuencia", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Fase> getFase(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<Fase> list = (List<Fase>) new ArrayList<Fase>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getFase", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Finalidad> getFinalidad(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<Finalidad> list = (List<Finalidad>) new ArrayList<Finalidad>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getFinalidad", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<FuenteFinanc> getFuenteFinanc(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<FuenteFinanc> list = (List<FuenteFinanc>) new ArrayList<FuenteFinanc>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getFuenteFinanc", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<FuenteFinancAgregada> getFuenteFinancAgregada(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<FuenteFinancAgregada> list = (List<FuenteFinancAgregada>) new ArrayList<FuenteFinancAgregada>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getFuenteFinancAgregada", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Funcion> getFuncion(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<Funcion> list = (List<Funcion>) new ArrayList<Funcion>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getFuncion", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Gasto> getGasto(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<Gasto> list = (List<Gasto>) new ArrayList<Gasto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getGasto", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Generica> getGenerica(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<Generica> list = (List<Generica>) new ArrayList<Generica>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getGenerica", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Ingreso> getIngreso(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<Ingreso> list = (List<Ingreso>) new ArrayList<Ingreso>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getIngreso", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<MaestroDocumento> getMaestroDocumento(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<MaestroDocumento> list = (List<MaestroDocumento>) new ArrayList<MaestroDocumento>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getMaestroDocumento", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Meta> getMeta(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<Meta> list = (List<Meta>) new ArrayList<Meta>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getMeta", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<MetaTrimestral> getMetaTrimestral(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<MetaTrimestral> list = (List<MetaTrimestral>) new ArrayList<MetaTrimestral>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getMetaTrimestral", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<NotaModificatoriaCab> getNotaModificatoriaCab(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<NotaModificatoriaCab> list = (List<NotaModificatoriaCab>) new ArrayList<NotaModificatoriaCab>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getNotaModificatoriaCab", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<NotaModificatoriaDet> getNotaModificatoriaDet(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<NotaModificatoriaDet> list = (List<NotaModificatoriaDet>) new ArrayList<NotaModificatoriaDet>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getNotaModificatoriaDet", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<NotaModificatoriaDoc> getNotaModificatoriaDoc(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<NotaModificatoriaDoc> list = (List<NotaModificatoriaDoc>) new ArrayList<NotaModificatoriaDoc>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getNotaModificatoriaDoc", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<NotaModificatoriaIng> getNotaModificatoriaIng(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<NotaModificatoriaIng> list = (List<NotaModificatoriaIng>) new ArrayList<NotaModificatoriaIng>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getNotaModificatoriaIng", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<NotaModificatoriaSec> getNotaModificatoriaSec(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<NotaModificatoriaSec> list = (List<NotaModificatoriaSec>) new ArrayList<NotaModificatoriaSec>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getNotaModificatoriaSec", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<PadronPersona> getPadronPersona(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<PadronPersona> list = (List<PadronPersona>) new ArrayList<PadronPersona>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getPadronPersona", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Persona> getPersona(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<Persona> list = (List<Persona>) new ArrayList<Persona>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getPersona", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<PersonaCciEjec> getPersonaCciEjec(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<PersonaCciEjec> list = (List<PersonaCciEjec>) new ArrayList<PersonaCciEjec>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getPersonaCciEjec", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Pliego> getPliego(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<Pliego> list = (List<Pliego>) new ArrayList<Pliego>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getPliego", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<ProgramaNombre> getProgramaNombre(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<ProgramaNombre> list = (List<ProgramaNombre>) new ArrayList<ProgramaNombre>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getProgramaNombre", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<ProgramaPptoNombre> getProgramaPptoNombre(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<ProgramaPptoNombre> list = (List<ProgramaPptoNombre>) new ArrayList<ProgramaPptoNombre>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getProgramaPptoNombre", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Provincia> getProvincia(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<Provincia> list = (List<Provincia>) new ArrayList<Provincia>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getProvincia", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<SubGenerica> getSubGenerica(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<SubGenerica> list = (List<SubGenerica>) new ArrayList<SubGenerica>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getSubGenerica", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<SubGenericaDet> getSubGenericaDet(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<SubGenericaDet> list = (List<SubGenericaDet>) new ArrayList<SubGenericaDet>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getSubGenericaDet", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<SubProgramaNombre> getSubProgramaNombre(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<SubProgramaNombre> list = (List<SubProgramaNombre>) new ArrayList<SubProgramaNombre>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getSubProgramaNombre", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<TipoDocumento> getTipoDocumento(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<TipoDocumento> list = (List<TipoDocumento>) new ArrayList<TipoDocumento>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getTipoDocumento", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<TipoOperacion> getTipoOperacion(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<TipoOperacion> list = (List<TipoOperacion>) new ArrayList<TipoOperacion>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getTipoOperacion", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<TipoProgramaPpto> getTipoProgramaPpto(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<TipoProgramaPpto> list = (List<TipoProgramaPpto>) new ArrayList<TipoProgramaPpto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getTipoProgramaPpto", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<TipoRecurso> getTipoRecurso(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<TipoRecurso> list = (List<TipoRecurso>) new ArrayList<TipoRecurso>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getTipoRecurso", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<TipoTransaccion> getTipoTransaccion(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<TipoTransaccion> list = (List<TipoTransaccion>) new ArrayList<TipoTransaccion>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getTipoTransaccion", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

    public List<UnidadMedida> getUnidadMedida(String query, long time, String ejec, String tabla, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<UnidadMedida> list = (List<UnidadMedida>) new ArrayList<UnidadMedida>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Siaf.getUnidadMedida", hm);
        } catch (Exception ex) {
            port.insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

}
