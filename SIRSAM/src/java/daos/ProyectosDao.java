package daos;

import beans.Proyectos;
import config.ConexionFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author CARLOS SANTANDER
 */
public class ProyectosDao {

    private final SqlSessionFactory ssfWeb;

    public ProyectosDao() {
        ssfWeb = ConexionFactory.getSqlSessionFactory();
    }

    public List<Proyectos> getListProyectos(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Proyectos> list = (List<Proyectos>) new ArrayList<Proyectos>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Proyectos.getListProyectos", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public Proyectos getProyecto(String query) {
        SqlSession session = ssfWeb.openSession();
        Proyectos bean = new Proyectos();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            bean = session.selectOne("Proyectos.getListProyectos", hm);
        } finally {
            session.close();
        }
        return bean;
    }

    public void updateProyecto(Proyectos bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("Proyectos.updateProyecto", bean);
            session.commit();
        }
    }

    public List<Proyectos> getListProyAmpliaciones(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Proyectos> list = (List<Proyectos>) new ArrayList<Proyectos>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Proyectos.getListProyAmpliaciones", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public void upsertProyAmpliaciones(Proyectos bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.insert("Proyectos.upsertProyAmpliaciones", bean);
            session.commit();
        }
    }

    public void deleteProyAmpliaciones(Proyectos bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.delete("Proyectos.deleteProyAmpliaciones", bean);
            session.commit();
        }
    }

    public List<Proyectos> getProyAmpliacionesReg(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Proyectos> list = (List<Proyectos>) new ArrayList<Proyectos>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Proyectos.getProyAmpliacionesReg", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Proyectos> getListProyCalendario(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Proyectos> list = (List<Proyectos>) new ArrayList<Proyectos>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Proyectos.getListProyCalendario", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Proyectos> getListProyCalendarioComponente(String query1, String query2) {
        SqlSession session = ssfWeb.openSession();
        List<Proyectos> list = (List<Proyectos>) new ArrayList<Proyectos>();
        HashMap hm = new HashMap();
        hm.put("c", query1);
        hm.put("d", query2);
        try {
            list = session.selectList("Proyectos.getListProyCalendarioComponente", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Proyectos> getListProyComponentes(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Proyectos> list = (List<Proyectos>) new ArrayList<Proyectos>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Proyectos.getListProyComponentes", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public Proyectos getProyComponente(String query) {
        SqlSession session = ssfWeb.openSession();
        Proyectos bean = new Proyectos();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            bean = session.selectOne("Proyectos.getListProyComponentes", hm);
        } finally {
            session.close();
        }
        return bean;
    }

    public void updateProyComponentes(Proyectos bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("Proyectos.updateProyComponentes", bean);
            session.commit();
        }
    }

    public List<Proyectos> getListProyComponentesAvance(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Proyectos> list = (List<Proyectos>) new ArrayList<Proyectos>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Proyectos.getListProyComponentesAvance", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Proyectos> getListProyContrataciones(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Proyectos> list = (List<Proyectos>) new ArrayList<Proyectos>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Proyectos.getListProyContrataciones", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public Proyectos getProyContratacion(String query) {
        SqlSession session = ssfWeb.openSession();
        Proyectos bean = new Proyectos();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            bean = session.selectOne("Proyectos.getListProyContrataciones", hm);
        } finally {
            session.close();
        }
        return bean;
    }

    public void updateProyContrataciones(Proyectos bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("Proyectos.updateProyContrataciones", bean);
            session.commit();
        }
    }

    public List<Proyectos> getListProyEjecucion(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Proyectos> list = (List<Proyectos>) new ArrayList<Proyectos>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Proyectos.getListProyEjecucion", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public Proyectos getProyEjecucion(String query) {
        SqlSession session = ssfWeb.openSession();
        Proyectos bean = new Proyectos();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            bean = session.selectOne("Proyectos.getListProyEjecucion", hm);
        } finally {
            session.close();
        }
        return bean;
    }

    public void upsertProyEjecucion(Proyectos bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.insert("Proyectos.upsertProyEjecucion", bean);
            session.commit();
        }
    }

    public List<Proyectos> getListProyEjecucionAdelanto(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Proyectos> list = (List<Proyectos>) new ArrayList<Proyectos>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Proyectos.getListProyEjecucionAdelanto", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public Proyectos getProyEjecucionAdelanto(String query) {
        SqlSession session = ssfWeb.openSession();
        Proyectos bean = new Proyectos();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            bean = session.selectOne("Proyectos.getListProyEjecucionAdelanto", hm);
        } finally {
            session.close();
        }
        return bean;
    }

    public void upsertProyEjecucionAdelanto(Proyectos bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.insert("Proyectos.upsertProyEjecucionAdelanto", bean);
            session.commit();
        }
    }

    public void deleteProyEjecucionAdelanto(Proyectos bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.delete("Proyectos.deleteProyEjecucionAdelanto", bean);
            session.commit();
        }
    }

    public List<Proyectos> getListProyEstudio(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Proyectos> list = (List<Proyectos>) new ArrayList<Proyectos>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Proyectos.getListProyEstudio", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public Proyectos getProyEstudio(String query) {
        SqlSession session = ssfWeb.openSession();
        Proyectos bean = new Proyectos();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            bean = session.selectOne("Proyectos.getListProyEstudio", hm);
        } finally {
            session.close();
        }
        return bean;
    }

    public void upsertProyEstudio(Proyectos bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.insert("Proyectos.upsertProyEstudio", bean);
            session.commit();
        }
    }

    public List<Proyectos> getListProyEstudioEtapas(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Proyectos> list = (List<Proyectos>) new ArrayList<Proyectos>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Proyectos.getListProyEstudioEtapas", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public Proyectos getProyEstudioEtapa(String query) {
        SqlSession session = ssfWeb.openSession();
        Proyectos bean = new Proyectos();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            bean = session.selectOne("Proyectos.getListProyEstudioEtapas", hm);
        } finally {
            session.close();
        }
        return bean;
    }

    public void upsertProyEstudioEtapas(Proyectos bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.insert("Proyectos.upsertProyEstudioEtapas", bean);
            session.commit();
        }
    }

    public void deleteProyEstudioEtapas(Proyectos bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.delete("Proyectos.deleteProyEstudioEtapas", bean);
            session.commit();
        }
    }

    public List<Proyectos> getListProyFotos(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Proyectos> list = (List<Proyectos>) new ArrayList<Proyectos>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Proyectos.getListProyFotos", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public Proyectos getProyFoto(String query) {
        SqlSession session = ssfWeb.openSession();
        Proyectos bean = new Proyectos();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            bean = session.selectOne("Proyectos.getListProyFotos", hm);
        } finally {
            session.close();
        }
        return bean;
    }

    public void upsertProyFotos(Proyectos bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.insert("Proyectos.upsertProyFotos", bean);
            session.commit();
        }
    }

    public void updateProyFotosPrinc(Proyectos bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("Proyectos.updateProyFotosPrinc", bean);
            session.commit();
        }
    }

    public void updateProyFotosFileNull(Proyectos bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("Proyectos.updateProyFotosFileNull", bean);
            session.commit();
        }
    }

    public void deleteProyFotos(Proyectos bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.delete("Proyectos.deleteProyFotos", bean);
            session.commit();
        }
    }

    public List<Proyectos> getListProyModificaciones(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Proyectos> list = (List<Proyectos>) new ArrayList<Proyectos>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Proyectos.getListProyModificaciones", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Proyectos> getListProyParalizaSuspen(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Proyectos> list = (List<Proyectos>) new ArrayList<Proyectos>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Proyectos.getListProyParalizaSuspen", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public void upsertProyParalizaSuspen(Proyectos bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.insert("Proyectos.upsertProyParalizaSuspen", bean);
            session.commit();
        }
    }

    public void deleteProyParalizaSuspen(Proyectos bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.delete("Proyectos.deleteProyParalizaSuspen", bean);
            session.commit();
        }
    }

    public List<Proyectos> getProyParalizaSuspenReg(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Proyectos> list = (List<Proyectos>) new ArrayList<Proyectos>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Proyectos.getProyParalizaSuspenReg", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Proyectos> getListProyPeriodo(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Proyectos> list = (List<Proyectos>) new ArrayList<Proyectos>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Proyectos.getListProyPeriodo", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public Proyectos getProyPeriodo(String query) {
        SqlSession session = ssfWeb.openSession();
        Proyectos bean = new Proyectos();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            bean = session.selectOne("Proyectos.getListProyPeriodo", hm);
        } finally {
            session.close();
        }
        return bean;
    }

    public Boolean insertProyPeriodo(Proyectos bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.insert("Proyectos.insertProyPeriodo", bean);
            session.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void deleteProyPeriodo(Proyectos bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.delete("Proyectos.deleteProyPeriodo", bean);
            session.commit();
        }
    }

    public List<Proyectos> getListProySupervision(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Proyectos> list = (List<Proyectos>) new ArrayList<Proyectos>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Proyectos.getListProySupervision", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public Proyectos getProySupervision(String query) {
        SqlSession session = ssfWeb.openSession();
        Proyectos bean = new Proyectos();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            bean = session.selectOne("Proyectos.getListProySupervision", hm);
        } finally {
            session.close();
        }
        return bean;
    }

    public void upsertProySupervision(Proyectos bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.insert("Proyectos.upsertProySupervision", bean);
            session.commit();
        }
    }

    public List<Proyectos> getListProySupervisionAdelanto(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Proyectos> list = (List<Proyectos>) new ArrayList<Proyectos>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Proyectos.getListProySupervisionAdelanto", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public Proyectos getProySupervisionAdelanto(String query) {
        SqlSession session = ssfWeb.openSession();
        Proyectos bean = new Proyectos();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            bean = session.selectOne("Proyectos.getListProySupervisionAdelanto", hm);
        } finally {
            session.close();
        }
        return bean;
    }

    public void upsertProySupervisionAdelanto(Proyectos bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.insert("Proyectos.upsertProySupervisionAdelanto", bean);
            session.commit();
        }
    }

    public void deleteProySupervisionAdelanto(Proyectos bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.delete("Proyectos.deleteProySupervisionAdelanto", bean);
            session.commit();
        }
    }

    public List<Proyectos> getListProyUbicacion(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Proyectos> list = (List<Proyectos>) new ArrayList<Proyectos>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Proyectos.getListProyUbicacion", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public Proyectos getProyUbicacion(String query) {
        SqlSession session = ssfWeb.openSession();
        Proyectos bean = new Proyectos();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            bean = session.selectOne("Proyectos.getListProyUbicacion", hm);
        } finally {
            session.close();
        }
        return bean;
    }

    public void updateProyUbicacion(Proyectos bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("Proyectos.updateProyUbicacion", bean);
            session.commit();
        }
    }

    public List<Proyectos> getListProyValorizaciones(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Proyectos> list = (List<Proyectos>) new ArrayList<Proyectos>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Proyectos.getListProyValorizaciones", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public Proyectos getProyValorizacion(String query) {
        SqlSession session = ssfWeb.openSession();
        Proyectos bean = new Proyectos();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            bean = session.selectOne("Proyectos.getListProyValorizaciones", hm);
        } finally {
            session.close();
        }
        return bean;
    }

    public void upsertProyValorizaciones(Proyectos bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.insert("Proyectos.upsertProyValorizaciones", bean);
            session.commit();
        }
    }

    public void deleteProyValorizaciones(Proyectos bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.delete("Proyectos.deleteProyValorizaciones", bean);
            session.commit();
        }
    }

    public List<Proyectos> getListaEjecutoras(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Proyectos> list = (List<Proyectos>) new ArrayList<Proyectos>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Proyectos.getListaEjecutoras", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public Proyectos getEjecutora(String query) {
        SqlSession session = ssfWeb.openSession();
        Proyectos bean = new Proyectos();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            bean = session.selectOne("Proyectos.getListaEjecutoras", hm);
        } finally {
            session.close();
        }
        return bean;
    }

    public List<Proyectos> getListaFuncion(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Proyectos> list = (List<Proyectos>) new ArrayList<Proyectos>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Proyectos.getListaFuncion", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Proyectos> getListaSemaforo1(String query1, String query2) {
        SqlSession session = ssfWeb.openSession();
        List<Proyectos> list = (List<Proyectos>) new ArrayList<Proyectos>();
        HashMap hm = new HashMap();
        hm.put("c", query1);
        hm.put("d", query2);
        try {
            list = session.selectList("Proyectos.getListaSemaforo1", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Proyectos> getListaSemaforo2(String query1, String query2, String query3) {
        SqlSession session = ssfWeb.openSession();
        List<Proyectos> list = (List<Proyectos>) new ArrayList<Proyectos>();
        HashMap hm = new HashMap();
        hm.put("c", query1);
        hm.put("d", query2);
        hm.put("e", query3);
        try {
            list = session.selectList("Proyectos.getListaSemaforo2", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Proyectos> getListaSemaforo3(String query1, String query2, String query3, String query4) {
        SqlSession session = ssfWeb.openSession();
        List<Proyectos> list = (List<Proyectos>) new ArrayList<Proyectos>();
        HashMap hm = new HashMap();
        hm.put("c", query1);
        hm.put("d", query2);
        hm.put("e", query3);
        hm.put("f", query4);
        try {
            list = session.selectList("Proyectos.getListaSemaforo3", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Proyectos> getListaActProyEjec(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Proyectos> list = (List<Proyectos>) new ArrayList<Proyectos>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Proyectos.getListaActProyEjec", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Proyectos> getListaHistoricoFinanciero(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Proyectos> list = (List<Proyectos>) new ArrayList<Proyectos>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Proyectos.getListaHistoricoFinanciero", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Proyectos> getListaActualFinanciero(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Proyectos> list = (List<Proyectos>) new ArrayList<Proyectos>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Proyectos.getListaActualFinanciero", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Proyectos> getListaHistoricoFinancieroAcum(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Proyectos> list = (List<Proyectos>) new ArrayList<Proyectos>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Proyectos.getListaHistoricoFinancieroAcum", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Proyectos> getListaActualDetallado(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Proyectos> list = (List<Proyectos>) new ArrayList<Proyectos>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Proyectos.getListaActualDetallado", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Proyectos> getListaHistoricoPagos(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Proyectos> list = (List<Proyectos>) new ArrayList<Proyectos>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Proyectos.getListaHistoricoPagos", hm);
        } finally {
            session.close();
        }
        return list;
    }

}
