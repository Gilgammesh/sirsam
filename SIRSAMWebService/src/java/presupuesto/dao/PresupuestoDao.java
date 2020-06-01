package presupuesto.dao;

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
import presupuesto.bean.LogsSincronizar;
import presupuesto.bean.MaestroDocumento;
import presupuesto.bean.Meta;
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
import config.SIRSAMConexion;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import presupuesto.bean.MetaTrimestral;
import presupuesto.bean.UnidadMedida;

/*
 ** @author CARLOS SANTANDER
 */
public class PresupuestoDao {

    private final SqlSessionFactory ssfWeb;

    public PresupuestoDao() throws IOException {
        ssfWeb = SIRSAMConexion.getSqlSessionFactory();
    }

    //ACT PROY NOMBRE......................................................................
    public void upsertActProyNombre(List<ActProyNombre> dataActProyNombre, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataActProyNombre.stream().map((item) -> {
                ActProyNombre bean = new ActProyNombre();
                bean.setAno_eje(item.getAno_eje());
                bean.setAct_proy(item.getAct_proy());
                bean.setTipo_act_proy(item.getTipo_act_proy());
                bean.setNombre(item.getNombre());
                bean.setEstado(item.getEstado());
                bean.setProyecto_snip(item.getProyecto_snip());
                bean.setEs_foniprel(item.getEs_foniprel());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertActProyNombre", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //BANCO......................................................................
    public void upsertBanco(List<Banco> dataBanco, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataBanco.stream().map((item) -> {
                Banco bean = new Banco();
                bean.setBanco(item.getBanco());
                bean.setNombre(item.getNombre());
                bean.setEstado(item.getEstado());
                bean.setEs_financiera(item.getEs_financiera());
                bean.setSec_ejec_ruc(item.getSec_ejec_ruc());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertBanco", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    // CATEGORIA DE GASTO  ....................................................................       
    public void upsertCategoriaGasto(List<CategoriaGasto> dataCategoriaGasto, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataCategoriaGasto.stream().map((item) -> {
                CategoriaGasto bean = new CategoriaGasto();
                bean.setAno_eje(item.getAno_eje());
                bean.setCateg_gasto(item.getCateg_gasto());
                bean.setNombre(item.getNombre());
                bean.setEstado(item.getEstado());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertCategoriaGasto", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    // CATEGORIA DE INGRESO  ....................................................................       
    public void upsertCategoriaIngreso(List<CategoriaIngreso> dataCategoriaIngreso, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataCategoriaIngreso.stream().map((item) -> {
                CategoriaIngreso bean = new CategoriaIngreso();
                bean.setAno_eje(item.getAno_eje());
                bean.setCategoria_ingreso(item.getCategoria_ingreso());
                bean.setDescripcion(item.getDescripcion());
                bean.setEstado(item.getEstado());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertCategoriaIngreso", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //CERTIFICADO......................................................................
    public void upsertCertificado(List<Certificado> dataCertificado, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataCertificado.stream().map((item) -> {
                Certificado bean = new Certificado();
                bean.setAno_eje(item.getAno_eje());
                bean.setSec_ejec(item.getSec_ejec());
                bean.setCertificado(item.getCertificado());
                bean.setEstado_registro(item.getEstado_registro());
                bean.setEstado_envio(item.getEstado_envio());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertCertificado", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //CERTIFICADO  -  FASE ....................................................................
    public void upsertCertificadoFase(List<CertificadoFase> dataCertificadoFase, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataCertificadoFase.stream().map((item) -> {
                CertificadoFase bean = new CertificadoFase();
                bean.setAno_eje(item.getAno_eje());
                bean.setSec_ejec(item.getSec_ejec());
                bean.setCertificado(item.getCertificado());
                bean.setSecuencia(item.getSecuencia());
                bean.setSecuencia_padre(item.getSecuencia_padre());
                bean.setFuente_financ(item.getFuente_financ());
                bean.setEtapa(item.getEtapa());
                bean.setMonto(item.getMonto());
                bean.setMonto_comprometido(item.getMonto_comprometido());
                bean.setMonto_nacional(item.getMonto_nacional());
                bean.setGlosa(item.getGlosa());
                bean.setEstado_registro(item.getEstado_registro());
                bean.setEstado_envio(item.getEstado_envio());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertCertificadoFase", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //CERTIFICADO  -  META ....................................................................
    public void upsertCertificadoMeta(List<CertificadoMeta> dataCertificadoMeta, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataCertificadoMeta.stream().map((item) -> {
                CertificadoMeta bean = new CertificadoMeta();
                bean.setAno_eje(item.getAno_eje());
                bean.setSec_ejec(item.getSec_ejec());
                bean.setCertificado(item.getCertificado());
                bean.setSecuencia(item.getSecuencia());
                bean.setCorrelativo(item.getCorrelativo());
                bean.setId_clasificador(item.getId_clasificador());
                bean.setSec_func(item.getSec_func());
                bean.setMonto(item.getMonto());
                bean.setMonto_comprometido(item.getMonto_comprometido());
                bean.setMonto_nacional(item.getMonto_nacional());
                bean.setEstado_registro(item.getEstado_registro());
                bean.setEstado_envio(item.getEstado_envio());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertCertificadoMeta", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //CERTIFICADO  -  SECUENCIA ....................................................................
    public void upsertCertificadoSecuencia(List<CertificadoSecuencia> dataCertificadoSecuencia, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataCertificadoSecuencia.stream().map((item) -> {
                CertificadoSecuencia bean = new CertificadoSecuencia();
                bean.setAno_eje(item.getAno_eje());
                bean.setSec_ejec(item.getSec_ejec());
                bean.setCertificado(item.getCertificado());
                bean.setSecuencia(item.getSecuencia());
                bean.setCorrelativo(item.getCorrelativo());
                bean.setCod_doc(item.getCod_doc());
                bean.setNum_doc(item.getNum_doc());
                bean.setFecha_doc(item.getFecha_doc_xml().toGregorianCalendar().getTime());
                bean.setEstado_registro(item.getEstado_registro());
                bean.setEstado_envio(item.getEstado_envio());
                bean.setMonto(item.getMonto());
                bean.setMonto_comprometido(item.getMonto_comprometido());
                bean.setMonto_nacional(item.getMonto_nacional());
                bean.setTipo_registro(item.getTipo_registro());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertCertificadoSecuencia", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //CICLO......................................................................
    public void upsertCiclo(List<Ciclo> dataCiclo, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataCiclo.stream().map((item) -> {
                Ciclo bean = new Ciclo();
                bean.setCiclo(item.getCiclo());
                bean.setNombre(item.getNombre());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertCiclo", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //COMPONENTE NOMBRE......................................................................
    public void upsertComponenteNombre(List<ComponenteNombre> dataComponenteNombre, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataComponenteNombre.stream().map((item) -> {
                ComponenteNombre bean = new ComponenteNombre();
                bean.setAno_eje(item.getAno_eje());
                bean.setComponente(item.getComponente());
                bean.setTipo_componente(item.getTipo_componente());
                bean.setNombre(item.getNombre());
                bean.setEstado(item.getEstado());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertComponenteNombre", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //CUENTA CORRIENTE......................................................................
    public void upsertCtaCte(List<CtaCte> dataCtaCte, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataCtaCte.stream().map((item) -> {
                CtaCte bean = new CtaCte();
                bean.setAno_eje(item.getAno_eje());
                bean.setSec_ejec(item.getSec_ejec());
                bean.setBanco(item.getBanco());
                bean.setCta_cte(item.getCta_cte());
                bean.setNombre(item.getNombre());
                bean.setEstado(item.getEstado());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertCtaCte", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    // DEPARTAMENTO ....................................................................       
    public void upsertDepartamento(List<Departamento> dataDepartamento, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataDepartamento.stream().map((item) -> {
                Departamento bean = new Departamento();
                bean.setDepartamento(item.getDepartamento());
                bean.setNombre(item.getNombre());
                bean.setEstado(item.getEstado());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertDepartamento", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    // DISTRITO ....................................................................       
    public void upsertDistrito(List<Distrito> dataDistrito, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataDistrito.stream().map((item) -> {
                Distrito bean = new Distrito();
                bean.setDepartamento(item.getDepartamento());
                bean.setProvincia(item.getProvincia());
                bean.setDistrito(item.getDistrito());
                bean.setNombre(item.getNombre());
                bean.setRegion(item.getRegion());
                bean.setEstado(item.getEstado());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertDistrito", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    // EJECUCION HISTORICA  .................................................................... 
    public List<EjecucionHistorica> getEjecucionHistoricaTotal() {
        SqlSession session = ssfWeb.openSession();
        List<EjecucionHistorica> list = new ArrayList();
        try {
            list = session.selectList("Presupuesto.getEjecucionHistoricaTotal");
        } finally {
            session.close();
        }
        return list;
    }

    public List<EjecucionHistorica> getEjecucionHistoricaActual(String query) {
        SqlSession session = ssfWeb.openSession();
        List<EjecucionHistorica> list = new ArrayList();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getEjecucionHistoricaActual", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public void upsertEjecucionHistorica(List<EjecucionHistorica> dataEjecucionHistorica, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataEjecucionHistorica.stream().map((item) -> {
                EjecucionHistorica bean = new EjecucionHistorica();
                bean.setAno_eje(item.getAno_eje());
                bean.setSec_ejec(item.getSec_ejec());
                bean.setPia(item.getPia());
                bean.setModificacion(item.getModificacion());
                bean.setPim(item.getPim());
                bean.setCertificado(item.getCertificado());
                bean.setCompromiso_anual(item.getCompromiso_anual());
                bean.setCompromiso(item.getCompromiso());
                bean.setEjecucion(item.getEjecucion());
                bean.setDevengado(item.getDevengado());
                bean.setGirado(item.getGirado());
                bean.setPagado(item.getPagado());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertEjecucionHistorica", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    // EJECUTORA  ....................................................................       
    public void upsertEjecutora(List<Ejecutora> dataEjecutora, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataEjecutora.stream().map((item) -> {
                Ejecutora bean = new Ejecutora();
                bean.setAno_eje(item.getAno_eje());
                bean.setSec_ejec(item.getSec_ejec());
                bean.setPliego(item.getPliego());
                bean.setEjecutora(item.getEjecutora());
                bean.setNombre(item.getNombre());
                bean.setEstado(item.getEstado());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertEjecutora", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //ESPECIFICA......................................................................
    public void upsertEspecifica(List<Especifica> dataEspecifica, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataEspecifica.stream().map((item) -> {
                Especifica bean = new Especifica();
                bean.setAno_eje(item.getAno_eje());
                bean.setTipo_transaccion(item.getTipo_transaccion());
                bean.setGenerica(item.getGenerica());
                bean.setSubgenerica(item.getSubgenerica());
                bean.setSubgenerica_det(item.getSubgenerica_det());
                bean.setEspecifica(item.getEspecifica());
                bean.setDescripcion(item.getDescripcion());
                bean.setEstado(item.getEstado());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertEspecifica", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //ESPECIFICA DET......................................................................
    public void upsertEspecificaDet(List<EspecificaDet> dataEspecificaDet, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataEspecificaDet.stream().map((item) -> {
                EspecificaDet bean = new EspecificaDet();
                bean.setAno_eje(item.getAno_eje());
                bean.setTipo_transaccion(item.getTipo_transaccion());
                bean.setGenerica(item.getGenerica());
                bean.setSubgenerica(item.getSubgenerica());
                bean.setSubgenerica_det(item.getSubgenerica_det());
                bean.setEspecifica(item.getEspecifica());
                bean.setEspecifica_det(item.getEspecifica_det());
                bean.setId_clasificador(item.getId_clasificador());
                bean.setDescripcion(item.getDescripcion());
                bean.setEstado(item.getEstado());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertEspecificaDet", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //EXPEDIENTE......................................................................
    public void upsertExpediente(List<Expediente> dataExpediente, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataExpediente.stream().map((item) -> {
                Expediente bean = new Expediente();
                bean.setAno_eje(item.getAno_eje());
                bean.setSec_ejec(item.getSec_ejec());
                bean.setExpediente(item.getExpediente());
                bean.setEstado_envio(item.getEstado_envio());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertExpediente", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //EXPEDIENTE  ADJUNTO ...............................................................
    public void upsertExpedienteAdjunto(List<ExpedienteAdjunto> dataExpedienteAdjunto, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataExpedienteAdjunto.stream().map((item) -> {
                ExpedienteAdjunto bean = new ExpedienteAdjunto();
                bean.setAno_eje(item.getAno_eje());
                bean.setSec_ejec(item.getSec_ejec());
                bean.setExpediente(item.getExpediente());
                bean.setCiclo(item.getCiclo());
                bean.setFase(item.getFase());
                bean.setSecuencia(item.getSecuencia());
                bean.setCorrelativo(item.getCorrelativo());
                bean.setCta_bancaria(item.getCta_bancaria());
                bean.setTipo_doc(item.getTipo_doc());
                bean.setNum_doc(item.getNum_doc());
                bean.setMonto(item.getMonto());
                bean.setEstado_envio(item.getEstado_envio());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertExpedienteAdjunto", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //EXPEDIENTE  DOCUMENTO ...............................................................
    public void upsertExpedienteDocumento(List<ExpedienteDocumento> dataExpedienteDocumento, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataExpedienteDocumento.stream().map((item) -> {
                ExpedienteDocumento bean = new ExpedienteDocumento();
                bean.setAno_eje(item.getAno_eje());
                bean.setSec_ejec(item.getSec_ejec());
                bean.setExpediente(item.getExpediente());
                bean.setCiclo(item.getCiclo());
                bean.setFase(item.getFase());
                bean.setSecuencia(item.getSecuencia());
                bean.setCorrelativo(item.getCorrelativo());
                bean.setCod_doc(item.getCod_doc());
                bean.setNum_doc(item.getNum_doc());
                bean.setFecha_doc(item.getFecha_doc_xml().toGregorianCalendar().getTime());
                bean.setNombre(item.getNombre());
                bean.setEstado_envio(item.getEstado_envio());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertExpedienteDocumento", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //EXPEDIENTE  FASE ...............................................................
    public void upsertExpedienteFase(List<ExpedienteFase> dataExpedienteFase, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataExpedienteFase.stream().map((item) -> {
                ExpedienteFase bean = new ExpedienteFase();
                bean.setAno_eje(item.getAno_eje());
                bean.setSec_ejec(item.getSec_ejec());
                bean.setExpediente(item.getExpediente());
                bean.setCiclo(item.getCiclo());
                bean.setFase(item.getFase());
                bean.setSecuencia(item.getSecuencia());
                bean.setSecuencia_padre(item.getSecuencia_padre());
                bean.setMonto_nacional(item.getMonto_nacional());
                bean.setFuente_financ(item.getFuente_financ());
                bean.setTipo_id(item.getTipo_id());
                bean.setRuc(item.getRuc());
                bean.setTipo_pago(item.getTipo_pago());
                bean.setTipo_recurso(item.getTipo_recurso());
                bean.setEstado_envio(item.getEstado_envio());
                bean.setCertificado(item.getCertificado());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertExpedienteFase", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //EXPEDIENTE  INGRESO ...............................................................
    public void upsertExpedienteIngreso(List<ExpedienteIngreso> dataExpedienteIngreso, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataExpedienteIngreso.stream().map((item) -> {
                ExpedienteIngreso bean = new ExpedienteIngreso();
                bean.setAno_eje(item.getAno_eje());
                bean.setSec_ejec(item.getSec_ejec());
                bean.setExpediente(item.getExpediente());
                bean.setCiclo(item.getCiclo());
                bean.setFase(item.getFase());
                bean.setSecuencia(item.getSecuencia());
                bean.setCorrelativo(item.getCorrelativo());
                bean.setMonto(item.getMonto());
                bean.setMonto_nacional(item.getMonto_nacional());
                bean.setEstado_envio(item.getEstado_envio());
                bean.setId_clasificador(item.getId_clasificador());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertExpedienteIngreso", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //EXPEDIENTE META ...............................................................
    public void upsertExpedienteMeta(List<ExpedienteMeta> dataExpedienteMeta, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataExpedienteMeta.stream().map((item) -> {
                ExpedienteMeta bean = new ExpedienteMeta();
                bean.setAno_eje(item.getAno_eje());
                bean.setSec_ejec(item.getSec_ejec());
                bean.setExpediente(item.getExpediente());
                bean.setCiclo(item.getCiclo());
                bean.setFase(item.getFase());
                bean.setSecuencia(item.getSecuencia());
                bean.setCorrelativo(item.getCorrelativo());
                bean.setSec_func(item.getSec_func());
                bean.setMonto(item.getMonto());
                bean.setMonto_nacional(item.getMonto_nacional());
                bean.setEstado_envio(item.getEstado_envio());
                bean.setId_clasificador(item.getId_clasificador());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertExpedienteMeta", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //EXPEDIENTE NOTA ...............................................................
    public void upsertExpedienteNota(List<ExpedienteNota> dataExpedienteNota, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataExpedienteNota.stream().map((item) -> {
                ExpedienteNota bean = new ExpedienteNota();
                bean.setAno_eje(item.getAno_eje());
                bean.setSec_ejec(item.getSec_ejec());
                bean.setExpediente(item.getExpediente());
                bean.setCiclo(item.getCiclo());
                bean.setFase(item.getFase());
                bean.setSecuencia(item.getSecuencia());
                bean.setSecuencia_nota(item.getSecuencia_nota());
                bean.setNotas(item.getNotas());
                bean.setEstado_envio(item.getEstado_envio());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertExpedienteNota", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //EXPEDIENTE SECUENCIA ...............................................................
    public void upsertExpedienteSecuencia(List<ExpedienteSecuencia> dataExpedienteSecuencia, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataExpedienteSecuencia.stream().map((item) -> {
                ExpedienteSecuencia bean = new ExpedienteSecuencia();
                bean.setAno_eje(item.getAno_eje());
                bean.setSec_ejec(item.getSec_ejec());
                bean.setExpediente(item.getExpediente());
                bean.setCiclo(item.getCiclo());
                bean.setFase(item.getFase());
                bean.setSecuencia(item.getSecuencia());
                bean.setCorrelativo(item.getCorrelativo());
                bean.setCod_doc(item.getCod_doc());
                bean.setNum_doc(item.getNum_doc());
                bean.setFecha_doc(item.getFecha_doc_xml().toGregorianCalendar().getTime());
                bean.setMonto(item.getMonto());
                bean.setMonto_nacional(item.getMonto_nacional());
                bean.setAno_cta_cte(item.getAno_cta_cte());
                bean.setBanco(item.getBanco());
                bean.setCta_cte(item.getCta_cte());
                bean.setFecha_autorizacion(item.getFecha_autorizacion_xml().toGregorianCalendar().getTime());
                bean.setEstado_envio(item.getEstado_envio());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertExpedienteSecuencia", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //FASE......................................................................
    public void upsertFase(List<Fase> dataFase, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataFase.stream().map((item) -> {
                Fase bean = new Fase();
                bean.setCiclo(item.getCiclo());
                bean.setFase(item.getFase());
                bean.setNombre(item.getNombre());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertFase", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //FINALIDAD......................................................................
    public void upsertFinalidad(List<Finalidad> dataFinalidad, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataFinalidad.stream().map((item) -> {
                Finalidad bean = new Finalidad();
                bean.setAno_eje(item.getAno_eje());
                bean.setFinalidad(item.getFinalidad());
                bean.setNombre(item.getNombre());
                bean.setEstado(item.getEstado());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertFinalidad", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //FUENTE FINANCIAMIENTO......................................................................
    public void upsertFuenteFinanc(List<FuenteFinanc> dataFuenteFinanc, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataFuenteFinanc.stream().map((item) -> {
                FuenteFinanc bean = new FuenteFinanc();
                bean.setAno_eje(item.getAno_eje());
                bean.setFuente_financ(item.getFuente_financ());
                bean.setNombre(item.getNombre());
                bean.setEstado(item.getEstado());
                bean.setFuente_financ_agregada(item.getFuente_financ_agregada());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertFuenteFinanc", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //FUENTE FINANCIAMIENTO AGREGADA......................................................................
    public void upsertFuenteFinancAgregada(List<FuenteFinancAgregada> dataFuenteFinancAgregada, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataFuenteFinancAgregada.stream().map((item) -> {
                FuenteFinancAgregada bean = new FuenteFinancAgregada();
                bean.setAno_eje(item.getAno_eje());
                bean.setFuente_financ_agregada(item.getFuente_financ_agregada());
                bean.setNombre(item.getNombre());
                bean.setEstado(item.getEstado());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertFuenteFinancAgregada", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //FUNCION......................................................................
    public void upsertFuncion(List<Funcion> dataFuncion, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataFuncion.stream().map((item) -> {
                Funcion bean = new Funcion();
                bean.setAno_eje(item.getAno_eje());
                bean.setFuncion(item.getFuncion());
                bean.setNombre(item.getNombre());
                bean.setEstado(item.getEstado());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertFuncion", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //GASTO......................................................................
    public void upsertGasto(List<Gasto> dataGasto, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataGasto.stream().map((item) -> {
                Gasto bean = new Gasto();
                bean.setAno_eje(item.getAno_eje());
                bean.setSec_ejec(item.getSec_ejec());
                bean.setOrigen(item.getOrigen());
                bean.setFuente_financ(item.getFuente_financ());
                bean.setTipo_recurso(item.getTipo_recurso());
                bean.setSec_func(item.getSec_func());
                bean.setPresupuesto(item.getPresupuesto());
                bean.setModificacion(item.getModificacion());
                bean.setEjecucion(item.getEjecucion());
                bean.setId_clasificador(item.getId_clasificador());
                bean.setCompromiso(item.getCompromiso());
                bean.setDevengado(item.getDevengado());
                bean.setGirado(item.getGirado());
                bean.setPagado(item.getPagado());
                bean.setMonto_certificado(item.getMonto_certificado());
                bean.setMonto_comprometido_anual(item.getMonto_comprometido_anual());
                bean.setMonto_precertificado(item.getMonto_precertificado());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertGasto", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //GENERICA......................................................................
    public void upsertGenerica(List<Generica> dataGenerica, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataGenerica.stream().map((item) -> {
                Generica bean = new Generica();
                bean.setAno_eje(item.getAno_eje());
                bean.setTipo_transaccion(item.getTipo_transaccion());
                bean.setGenerica(item.getGenerica());
                bean.setDescripcion(item.getDescripcion());
                bean.setEstado(item.getEstado());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertGenerica", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //INGRESO......................................................................
    public void upsertIngreso(List<Ingreso> dataIngreso, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataIngreso.stream().map((item) -> {
                Ingreso bean = new Ingreso();
                bean.setAno_eje(item.getAno_eje());
                bean.setSec_ejec(item.getSec_ejec());
                bean.setOrigen(item.getOrigen());
                bean.setFuente_financ(item.getFuente_financ());
                bean.setTipo_recurso(item.getTipo_recurso());
                bean.setPresupuesto(item.getPresupuesto());
                bean.setModificacion(item.getModificacion());
                bean.setEjecucion(item.getEjecucion());
                bean.setId_clasificador(item.getId_clasificador());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertIngreso", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    // LOGS SINCRONIZACION  .................................................................... 
    public void insertLogsSincronizar(long time, String ejec, String tabla, String host, String ip, String sync, String log_cliente, String log_servidor) {
        try (SqlSession session = ssfWeb.openSession()) {
            LogsSincronizar logs = new LogsSincronizar();
            logs.setFecha_hora(new Timestamp(time));
            logs.setSec_ejec(ejec);
            logs.setTabla(tabla);
            logs.setHostname(host);
            logs.setIp_local(ip);
            logs.setSincronizo(sync);
            logs.setLog_cliente(log_cliente);
            logs.setLog_servidor(log_servidor);
            session.insert("Presupuesto.insertLogsSincronizar", logs);
            session.commit();
        } catch (Exception ex) {

        }
    }

    //MAESTRO  -  DOCUMENTO ....................................................................
    public void upsertMaestroDocumento(List<MaestroDocumento> dataMaestroDocumento, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataMaestroDocumento.stream().map((item) -> {
                MaestroDocumento bean = new MaestroDocumento();
                bean.setCod_doc(item.getCod_doc());
                bean.setNombre(item.getNombre());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertMaestroDocumento", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //META...................................................................... 
    public void upsertMeta(List<Meta> dataMeta, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataMeta.stream().map((item) -> {
                Meta bean = new Meta();
                bean.setAno_eje(item.getAno_eje());
                bean.setSec_ejec(item.getSec_ejec());
                bean.setSec_func(item.getSec_func());
                bean.setFuncion(item.getFuncion());
                bean.setPrograma(item.getPrograma());
                bean.setSub_programa(item.getSub_programa());
                bean.setAct_proy(item.getAct_proy());
                bean.setComponente(item.getComponente());
                bean.setMeta(item.getMeta());
                bean.setFinalidad(item.getFinalidad());
                bean.setDepartamento(item.getDepartamento());
                bean.setProvincia(item.getProvincia());
                bean.setEstado(item.getEstado());
                bean.setDistrito(item.getDistrito());
                bean.setPrograma_ppto(item.getPrograma_ppto());
                bean.setUnidad_medida(item.getUnidad_medida());
                bean.setCantidad(item.getCantidad());
                bean.setCantidad_semestral(item.getCantidad_semestral());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertMeta", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //META TRIMESTRAL...................................................................... 
    public void upsertMetaTrimestral(List<MetaTrimestral> dataMetaTrimestral, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataMetaTrimestral.stream().map((item) -> {
                MetaTrimestral bean = new MetaTrimestral();
                bean.setAno_eje(item.getAno_eje());
                bean.setSec_ejec(item.getSec_ejec());
                bean.setSec_func(item.getSec_func());
                bean.setTrimestre(item.getTrimestre());
                bean.setProgramacion(item.getProgramacion());
                bean.setAvance(item.getAvance());
                bean.setEstado(item.getEstado());
                bean.setEstado_envio(item.getEstado_envio());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertMetaTrimestral", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    // NOTA MODIFICATORIA CAB ....................................................................
    public void upsertNotaModificatoriaCab(List<NotaModificatoriaCab> dataNotaModificatoriaCab, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataNotaModificatoriaCab.stream().map((item) -> {
                NotaModificatoriaCab bean = new NotaModificatoriaCab();
                bean.setAno_eje(item.getAno_eje());
                bean.setSec_ejec(item.getSec_ejec());
                bean.setSec_ejec2(item.getSec_ejec2());
                bean.setSec_nota(item.getSec_nota());
                bean.setInd_habilita(item.getInd_habilita());
                bean.setTipo_modificacion(item.getTipo_modificacion());
                bean.setMes_eje(item.getMes_eje());
                bean.setMonto(item.getMonto());
                bean.setSec_ejec_procedencia(item.getSec_ejec_procedencia());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertNotaModificatoriaCab", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    // NOTA MODIFICATORIA DETALLADA ....................................................................
    public void upsertNotaModificatoriaDet(List<NotaModificatoriaDet> dataNotaModificatoriaDet, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataNotaModificatoriaDet.stream().map((item) -> {
                NotaModificatoriaDet bean = new NotaModificatoriaDet();
                bean.setAno_eje(item.getAno_eje());
                bean.setSec_ejec(item.getSec_ejec());
                bean.setSec_ejec2(item.getSec_ejec2());
                bean.setSec_nota(item.getSec_nota());
                bean.setOrigen(item.getOrigen());
                bean.setFuente_financ(item.getFuente_financ());
                bean.setTipo_recurso(item.getTipo_recurso());
                bean.setSec_func(item.getSec_func());
                bean.setMonto_a(item.getMonto_a());
                bean.setMonto_de(item.getMonto_de());
                bean.setId_clasificador(item.getId_clasificador());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertNotaModificatoriaDet", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    // NOTA MODIFICATORIA DOCUMENTO ....................................................................
    public void upsertNotaModificatoriaDoc(List<NotaModificatoriaDoc> dataNotaModificatoriaDoc, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataNotaModificatoriaDoc.stream().map((item) -> {
                NotaModificatoriaDoc bean = new NotaModificatoriaDoc();
                bean.setAno_eje(item.getAno_eje());
                bean.setSec_ejec(item.getSec_ejec());
                bean.setSec_doc(item.getSec_doc());
                bean.setCod_doc(item.getCod_doc());
                bean.setNum_doc(item.getNum_doc());
                bean.setFecha_doc(item.getFecha_doc_xml().toGregorianCalendar().getTime());
                bean.setObservacion(item.getObservacion());
                bean.setEstado(item.getEstado());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertNotaModificatoriaDoc", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    // NOTA MODIFICATORIA INGRESO ....................................................................
    public void upsertNotaModificatoriaIng(List<NotaModificatoriaIng> dataNotaModificatoriaIng, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataNotaModificatoriaIng.stream().map((item) -> {
                NotaModificatoriaIng bean = new NotaModificatoriaIng();
                bean.setAno_eje(item.getAno_eje());
                bean.setSec_ejec(item.getSec_ejec());
                bean.setSec_ejec2(item.getSec_ejec2());
                bean.setSec_nota(item.getSec_nota());
                bean.setOrigen(item.getOrigen());
                bean.setFuente_financ(item.getFuente_financ());
                bean.setTipo_recurso(item.getTipo_recurso());
                bean.setMonto_a(item.getMonto_a());
                bean.setMonto_de(item.getMonto_de());
                bean.setId_clasificador(item.getId_clasificador());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertNotaModificatoriaIng", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    // NOTA MODIFICATORIA SECUENCIA ....................................................................
    public void upsertNotaModificatoriaSec(List<NotaModificatoriaSec> dataNotaModificatoriaSec, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataNotaModificatoriaSec.stream().map((item) -> {
                NotaModificatoriaSec bean = new NotaModificatoriaSec();
                bean.setAno_eje(item.getAno_eje());
                bean.setSec_ejec(item.getSec_ejec());
                bean.setSec_ejec2(item.getSec_ejec2());
                bean.setSec_nota(item.getSec_nota());
                bean.setSecuencia(item.getSecuencia());
                bean.setFecha(item.getFecha_xml().toGregorianCalendar().getTime());
                bean.setNotas(item.getNotas());
                bean.setEstado(item.getEstado());
                bean.setEstado2(item.getEstado2());
                bean.setSec_doc(item.getSec_doc());
                bean.setSec_doc_r(item.getSec_doc_r());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertNotaModificatoriaSec", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    // PADRON PERSONA (Trabajadores CAS, 276, Nombrados, Cargos de confianza)....................................................................
    public void upsertPadronPersona(List<PadronPersona> dataPadronPersona, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataPadronPersona.stream().map((item) -> {
                PadronPersona bean = new PadronPersona();
                bean.setTipo_documento(item.getTipo_documento());
                bean.setNumero_documento(item.getNumero_documento());
                bean.setApellido_paterno(item.getApellido_paterno());
                bean.setApellido_materno(item.getApellido_materno());
                bean.setNombre(item.getNombre());
                bean.setSexo(item.getSexo());
                bean.setFecha_nacimiento(item.getFecha_nacimiento_xml().toGregorianCalendar().getTime());
                bean.setEstado(item.getEstado());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertPadronPersona", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    // PERSONA ....................................................................
    public void upsertPersona(List<Persona> dataPersona, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataPersona.stream().map((item) -> {
                Persona bean = new Persona();
                bean.setTipo_id(item.getTipo_id());
                bean.setRuc(item.getRuc());
                bean.setNombre(item.getNombre());
                bean.setEstado(item.getEstado());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertPersona", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    // PERSONA - CCI - EJEC....................................................................       
    public void upsertPersonaCciEjec(List<PersonaCciEjec> dataPersonaCciEjec, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataPersonaCciEjec.stream().map((item) -> {
                PersonaCciEjec bean = new PersonaCciEjec();
                bean.setTipo_id(item.getTipo_id());
                bean.setRuc(item.getRuc());
                bean.setSec_ejec(item.getSec_ejec());
                bean.setSecuencia(item.getSecuencia());
                bean.setCci(item.getCci());
                bean.setAno_eje(item.getAno_eje());
                bean.setObservaciones(item.getObservaciones());
                bean.setEstado(item.getEstado());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertPersonaCciEjec", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    // PLIEGO  ....................................................................       
    public void upsertPliego(List<Pliego> dataPliego, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataPliego.stream().map((item) -> {
                Pliego bean = new Pliego();
                bean.setAno_eje(item.getAno_eje());
                bean.setPliego(item.getPliego());
                bean.setNombre(item.getNombre());
                bean.setEstado(item.getEstado());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertPliego", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //PROGRAMA NOMBRE......................................................................
    public void upsertProgramaNombre(List<ProgramaNombre> dataProgramaNombre, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataProgramaNombre.stream().map((item) -> {
                ProgramaNombre bean = new ProgramaNombre();
                bean.setAno_eje(item.getAno_eje());
                bean.setPrograma(item.getPrograma());
                bean.setNombre(item.getNombre());
                bean.setEstado(item.getEstado());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertProgramaNombre", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //PROGRAMA PRESUPUESTO NOMBRE......................................................................
    public void upsertProgramaPptoNombre(List<ProgramaPptoNombre> dataProgramaPptoNombre, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataProgramaPptoNombre.stream().map((item) -> {
                ProgramaPptoNombre bean = new ProgramaPptoNombre();
                bean.setAno_eje(item.getAno_eje());
                bean.setPrograma_ppto(item.getPrograma_ppto());
                bean.setNombre(item.getNombre());
                bean.setEstado(item.getEstado());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertProgramaPptoNombre", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    // PROVINCIA ....................................................................       
    public void upsertProvincia(List<Provincia> dataProvincia, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataProvincia.stream().map((item) -> {
                Provincia bean = new Provincia();
                bean.setDepartamento(item.getDepartamento());
                bean.setProvincia(item.getProvincia());
                bean.setNombre(item.getNombre());
                bean.setEstado(item.getEstado());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertProvincia", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    // RECAUDACION HISTORICA  .................................................................... 
    public List<RecaudacionHistorica> getRecaudacionHistoricaTotal() {
        SqlSession session = ssfWeb.openSession();
        List<RecaudacionHistorica> list = new ArrayList();
        try {
            list = session.selectList("Presupuesto.getRecaudacionHistoricaTotal");
        } finally {
            session.close();
        }
        return list;
    }

    public List<RecaudacionHistorica> getRecaudacionHistoricaActual(String query) {
        SqlSession session = ssfWeb.openSession();
        List<RecaudacionHistorica> list = new ArrayList();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getRecaudacionHistoricaActual", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public void upsertRecaudacionHistorica(List<RecaudacionHistorica> dataRecaudacionHistorica, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataRecaudacionHistorica.stream().map((item) -> {
                RecaudacionHistorica bean = new RecaudacionHistorica();
                bean.setAno_eje(item.getAno_eje());
                bean.setSec_ejec(item.getSec_ejec());
                bean.setPia(item.getPia());
                bean.setModificacion(item.getModificacion());
                bean.setPim(item.getPim());
                bean.setRecaudado(item.getRecaudado());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertRecaudacionHistorica", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //SUB GENERICA......................................................................
    public void upsertSubGenerica(List<SubGenerica> dataSubGenerica, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataSubGenerica.stream().map((item) -> {
                SubGenerica bean = new SubGenerica();
                bean.setAno_eje(item.getAno_eje());
                bean.setTipo_transaccion(item.getTipo_transaccion());
                bean.setGenerica(item.getGenerica());
                bean.setSubgenerica(item.getSubgenerica());
                bean.setDescripcion(item.getDescripcion());
                bean.setEstado(item.getEstado());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertSubGenerica", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //SUB GENERICA DETERMINADA......................................................................
    public void upsertSubGenericaDet(List<SubGenericaDet> dataSubGenericaDet, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataSubGenericaDet.stream().map((item) -> {
                SubGenericaDet bean = new SubGenericaDet();
                bean.setAno_eje(item.getAno_eje());
                bean.setTipo_transaccion(item.getTipo_transaccion());
                bean.setGenerica(item.getGenerica());
                bean.setSubgenerica(item.getSubgenerica());
                bean.setSubgenerica_det(item.getSubgenerica_det());
                bean.setDescripcion(item.getDescripcion());
                bean.setCategoria_gasto(item.getCategoria_gasto());
                bean.setEstado(item.getEstado());
                bean.setCategoria_ingreso(item.getCategoria_ingreso());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertSubGenericaDet", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //SUB PROGRAMA NOMBRE......................................................................
    public void upsertSubProgramaNombre(List<SubProgramaNombre> dataSubProgramaNombre, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataSubProgramaNombre.stream().map((item) -> {
                SubProgramaNombre bean = new SubProgramaNombre();
                bean.setAno_eje(item.getAno_eje());
                bean.setSub_programa(item.getSub_programa());
                bean.setNombre(item.getNombre());
                bean.setEstado(item.getEstado());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertSubProgramaNombre", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //TIPO DE DOCUMENTO ....................................................................
    public void upsertTipoDocumento(List<TipoDocumento> dataTipoDocumento, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataTipoDocumento.stream().map((item) -> {
                TipoDocumento bean = new TipoDocumento();
                bean.setTipo_documento(item.getTipo_documento());
                bean.setNombre(item.getNombre());
                bean.setEstado(item.getEstado());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertTipoDocumento", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //TIPO DE OPERACION ....................................................................
    public void upsertTipoOperacion(List<TipoOperacion> dataTipoOperacion, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataTipoOperacion.stream().map((item) -> {
                TipoOperacion bean = new TipoOperacion();
                bean.setAno_eje(item.getAno_eje());
                bean.setTipo_operacion(item.getTipo_operacion());
                bean.setNombre(item.getNombre());
                bean.setEstado(item.getEstado());
                bean.setCiclo(item.getCiclo());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertTipoOperacion", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //TIPO PROGRAMA PRESUPUESTO.................................................................
    public void upsertTipoProgramaPpto(List<TipoProgramaPpto> dataTipoProgramaPpto, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataTipoProgramaPpto.stream().map((item) -> {
                TipoProgramaPpto bean = new TipoProgramaPpto();
                bean.setAno_eje(item.getAno_eje());
                bean.setTipo_programa_ppto(item.getTipo_programa_ppto());
                bean.setNombre(item.getNombre());
                bean.setDescripcion(item.getDescripcion());
                bean.setEstado(item.getEstado());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertTipoProgramaPpto", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //TIPO DE RECURSO.................................................................
    public void upsertTipoRecurso(List<TipoRecurso> dataTipoRecurso, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataTipoRecurso.stream().map((item) -> {
                TipoRecurso bean = new TipoRecurso();
                bean.setAno_eje(item.getAno_eje());
                bean.setOrigen(item.getOrigen());
                bean.setFuente_financ(item.getFuente_financ());
                bean.setTipo_recurso(item.getTipo_recurso());
                bean.setNombre(item.getNombre());
                bean.setEstado(item.getEstado());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertTipoRecurso", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //TIPO TRANSACCION......................................................................
    public void upsertTipoTransaccion(List<TipoTransaccion> dataTipoTransaccion, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataTipoTransaccion.stream().map((item) -> {
                TipoTransaccion bean = new TipoTransaccion();
                bean.setAno_eje(item.getAno_eje());
                bean.setTipo_transaccion(item.getTipo_transaccion());
                bean.setDescripcion(item.getDescripcion());
                bean.setEstado(item.getEstado());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertTipoTransaccion", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

    //UNIDAD DE MEDIDA......................................................................
    public void upsertUnidadMedida(List<UnidadMedida> dataUnidadMedida, long time, String ejec, String tabla, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataUnidadMedida.stream().map((item) -> {
                UnidadMedida bean = new UnidadMedida();
                bean.setUnidad_medida(item.getUnidad_medida());
                bean.setNombre(item.getNombre());
                bean.setEstado(item.getEstado());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Presupuesto.upsertUnidadMedida", bean);
            });
            session.commit();
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new PresupuestoDao().insertLogsSincronizar(time, ejec, tabla, host, ip, "NO", null, ex.toString());
        }
    }

}
