package daos;

import beans.Presupuesto;
import config.ConexionFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author CARLOS SANTANDER
 */
public class PresupuestoDao {

    private final SqlSessionFactory ssfWeb;

    public PresupuestoDao() {
        ssfWeb = ConexionFactory.getSqlSessionFactory();
    }

    public List<Presupuesto> getCentroCosto(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getCentroCosto", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public void insertCentroCosto(Presupuesto bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.insert("Presupuesto.insertCentroCosto", bean);
            session.commit();
        }
    }

    public Integer getNroRegCeco(String query) {
        SqlSession session = ssfWeb.openSession();
        Integer reg = 0;
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            reg = session.selectOne("Presupuesto.getNroRegCeco", hm);
        } finally {
            session.close();
        }
        return reg;
    }

    public void updateCentroCosto(Presupuesto bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("Presupuesto.updateCentroCosto", bean);
            session.commit();
        }
    }

    public void deleteCentroCosto(Presupuesto bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.delete("Presupuesto.deleteCentroCosto", bean);
            session.commit();
        }
    }

    public List<Presupuesto> getMetaCentroCosto(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getMetaCentroCosto", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public Integer getNroRegMetaCeco(String query) {
        SqlSession session = ssfWeb.openSession();
        Integer reg = 0;
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            reg = session.selectOne("Presupuesto.getNroRegMetaCeco", hm);
        } finally {
            session.close();
        }
        return reg;
    }

    public void insertMetaCentroCosto(Presupuesto bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.insert("Presupuesto.insertMetaCentroCosto", bean);
            session.commit();
        }
    }

    public void updateMetaCentroCosto(Presupuesto bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("Presupuesto.updateMetaCentroCosto", bean);
            session.commit();
        }
    }

    public void deleteMetaCentroCosto(Presupuesto bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.delete("Presupuesto.deleteMetaCentroCosto", bean);
            session.commit();
        }
    }

    public List<Presupuesto> getListEjecutoras(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListEjecutoras", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public Presupuesto getEjecutora(String query) {
        SqlSession session = ssfWeb.openSession();
        Presupuesto datos = new Presupuesto();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            datos = session.selectOne("Presupuesto.getEjecutora", hm);
        } finally {
            session.close();
        }
        return datos;
    }

    public List<Presupuesto> getListAños(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListAños", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListMetaAños(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListMetaAños", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListNotasAños(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListNotasAños", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListMeses(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListMeses", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListAñosIngreso(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListAñosIngreso", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getHistorico(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getHistorico", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getRecaudacionHistorico(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getRecaudacionHistorico", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getEjecutoraHistorico(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getEjecutoraHistorico", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getEjecutoraRecaudacionHistorico(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getEjecutoraRecaudacionHistorico", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getMensualizado(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getMensualizado", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getMensualizadoHistorico(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getMensualizadoHistorico", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getEjecucionPorCategoria(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getEjecucionPorCategoria", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getEjecucionPorGenerica(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getEjecucionPorGenerica", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getEjecucionPorFuente(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getEjecucionPorFuente", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getEjecucionPorActProy(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getEjecucionPorActProy", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getEjecucionPorActProyTotal(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getEjecucionPorActProyTotal", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListCategoriaPresupuestal(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListCategoriaPresupuestal", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListProductoProyecto(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListProductoProyecto", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListActividadAccionInvObra(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListActividadAccionInvObra", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListFuncion(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListFuncion", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListDivFuncion(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListDivFuncion", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListGrupFuncion(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListGrupFuncion", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListMeta(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListMeta", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListFuente(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListFuente", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListFuenteIngreso(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListFuenteIngreso", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListRubro(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListRubro", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListRubroIngreso(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListRubroIngreso", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListCategoriaGasto(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListCategoriaGasto", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListCategoriaIngreso(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListCategoriaIngreso", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListGenerica(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListGenerica", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListGenericaIngreso(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListGenericaIngreso", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListSubGenerica(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListSubGenerica", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListSubGenericaIngreso(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListSubGenericaIngreso", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListSubGenericaDet(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListSubGenericaDet", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListSubGenericaDetIngreso(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListSubGenericaDetIngreso", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListEspecifica(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListEspecifica", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListEspecificaIngreso(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListEspecificaIngreso", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListEspecificaDet(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListEspecificaDet", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListEspecificaDetIngreso(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListEspecificaDetIngreso", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListTipoRecurso(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListTipoRecurso", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListDistrito(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListDistrito", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListProvincia(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListProvincia", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListCentroCosto(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListCentroCosto", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListBanco(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListBanco", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListCuentaCorriente(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListCuentaCorriente", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getEjecucionAnual(String select, String query, String tipo) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("b", select);
        hm.put("c", query);
        hm.put("d", tipo);
        try {
            list = session.selectList("Presupuesto.getEjecucionAnual", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getEjecucionAnualTipoRec(String select, String query, String tipo) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("b", select);
        hm.put("c", query);
        hm.put("d", tipo);
        try {
            list = session.selectList("Presupuesto.getEjecucionAnualTipoRec", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getEjecucionMensualizada(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getEjecucionMensualizada", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getCertificaciones(String select, String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("b", select);
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getCertificaciones", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListSemaforoEjecucion(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListSemaforoEjecucion", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListSemaforoEjecucionMeta(String query1, String query2) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query1);
        hm.put("d", query2);
        try {
            list = session.selectList("Presupuesto.getListSemaforoEjecucionMeta", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListDocuCerti(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListDocuCerti", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getCertificacionDetallada(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getCertificacionDetallada", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getCertificacionExpedientes(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getCertificacionExpedientes", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getCertificacionHistorial(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getCertificacionHistorial", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getCertificacionEstado(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getCertificacionEstado", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getRecaudacionAnual(String select1, String select2, String query1, String query2) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("a", select1);
        hm.put("b", select2);
        hm.put("c", query1);
        hm.put("d", query2);
        try {
            list = session.selectList("Presupuesto.getRecaudacionAnual", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getRecaudacionMensualizada(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getRecaudacionMensualizada", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListNotasTipo(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListNotasTipo", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListNotasRubroGasto(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListNotasRubroGasto", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListNotasRubroIngreso(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListNotasRubroIngreso", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListNotasTipoRubroGasto(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListNotasTipoRubroGasto", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListNotasTipoRubroIngreso(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListNotasTipoRubroIngreso", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListNotasGenericas(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListNotasGenericas", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListResumModifPresuGastoxDoc(String query1, String query2) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query1);
        hm.put("d", query2);
        try {
            list = session.selectList("Presupuesto.getListResumModifPresuGastoxDoc", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListResumModifPresuIngresoxDoc(String query1, String query2) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query1);
        hm.put("d", query2);
        try {
            list = session.selectList("Presupuesto.getListResumModifPresuIngresoxDoc", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListResumModifPresuGastoxNota(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListResumModifPresuGastoxNota", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListResumModifPresuIngresoxNota(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getListResumModifPresuIngresoxNota", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getListNotasNumero(String query1, String query2) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query1);
        hm.put("d", query2);
        try {
            list = session.selectList("Presupuesto.getListNotasNumero", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getNotaDetalleGeneral(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getNotaDetalleGeneral", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getNotaDetalleGasto(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getNotaDetalleGasto", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getNotaDetalleIngreso(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getNotaDetalleIngreso", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getNotaDetalleEjecutoras(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getNotaDetalleEjecutoras", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getExpedientesSIAF(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getExpedientesSIAF", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getDetalleExpeSIAFFase(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getDetalleExpeSIAFFase", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getDetalleExpeSIAFFaseGasto(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getDetalleExpeSIAFFaseGasto", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Presupuesto> getDetalleExpeSIAFFaseIngreso(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Presupuesto> list = (List<Presupuesto>) new ArrayList<Presupuesto>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Presupuesto.getDetalleExpeSIAFFaseIngreso", hm);
        } finally {
            session.close();
        }
        return list;
    }

}
