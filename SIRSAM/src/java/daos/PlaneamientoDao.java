package daos;

import beans.Planeamiento;
import config.ConexionFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author CARLOS SANTANDER
 */
public class PlaneamientoDao {

    private final SqlSessionFactory ssfWeb;

    public PlaneamientoDao() {
        ssfWeb = ConexionFactory.getSqlSessionFactory();
    }

    public List<Planeamiento> getCategorias(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Planeamiento> list = (List<Planeamiento>) new ArrayList<Planeamiento>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Planeamiento.getCategorias", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public Planeamiento getCategoria(String query) {
        SqlSession session = ssfWeb.openSession();
        Planeamiento bean = new Planeamiento();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            bean = session.selectOne("Planeamiento.getCategorias", hm);
        } finally {
            session.close();
        }
        return bean;
    }

    public void insertCategorias(Planeamiento bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.insert("Planeamiento.insertCategorias", bean);
            session.commit();
        }
    }

    public void updateCategorias(Planeamiento bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("Planeamiento.updateCategorias", bean);
            session.commit();
        }
    }

    public void deleteCategorias(Planeamiento bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("Planeamiento.deleteCategorias", bean);
            session.commit();
        }
    }

    public List<Planeamiento> getNiveles(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Planeamiento> list = (List<Planeamiento>) new ArrayList<Planeamiento>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Planeamiento.getNiveles", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public Planeamiento getNivel(String query) {
        SqlSession session = ssfWeb.openSession();
        Planeamiento bean = new Planeamiento();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            bean = session.selectOne("Planeamiento.getNiveles", hm);
        } finally {
            session.close();
        }
        return bean;
    }

    public void insertNiveles(Planeamiento bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.insert("Planeamiento.insertNiveles", bean);
            session.commit();
        }
    }

    public void updateNiveles(Planeamiento bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("Planeamiento.updateNiveles", bean);
            session.commit();
        }
    }

    public void deleteNiveles(Planeamiento bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("Planeamiento.deleteNiveles", bean);
            session.commit();
        }
    }

    public List<Planeamiento> getNivelesJerarquia(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Planeamiento> list = (List<Planeamiento>) new ArrayList<Planeamiento>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Planeamiento.getNivelesJerarquia", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public Planeamiento getNivelJerarquia(String query) {
        SqlSession session = ssfWeb.openSession();
        Planeamiento bean = new Planeamiento();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            bean = session.selectOne("Planeamiento.getNivelesJerarquia", hm);
        } finally {
            session.close();
        }
        return bean;
    }

    public void insertNivelesJerarquia(Planeamiento bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.insert("Planeamiento.insertNivelesJerarquia", bean);
            session.commit();
        }
    }

    public void updateNivelesJerarquia(Planeamiento bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("Planeamiento.updateNivelesJerarquia", bean);
            session.commit();
        }
    }

    public void deleteNivelesJerarquia(Planeamiento bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("Planeamiento.deleteNivelesJerarquia", bean);
            session.commit();
        }
    }

    public List<Planeamiento> getNivelesSub(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Planeamiento> list = (List<Planeamiento>) new ArrayList<Planeamiento>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Planeamiento.getNivelesSub", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public Planeamiento getNivelSub(String query) {
        SqlSession session = ssfWeb.openSession();
        Planeamiento bean = new Planeamiento();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            bean = session.selectOne("Planeamiento.getNivelesSub", hm);
        } finally {
            session.close();
        }
        return bean;
    }

    public void insertNivelesSub(Planeamiento bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.insert("Planeamiento.insertNivelesSub", bean);
            session.commit();
        }
    }

    public void updateNivelesSub(Planeamiento bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("Planeamiento.updateNivelesSub", bean);
            session.commit();
        }
    }

    public void deleteNivelesSub(Planeamiento bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("Planeamiento.deleteNivelesSub", bean);
            session.commit();
        }
    }

    public List<Planeamiento> getNivelesDetalle(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Planeamiento> list = (List<Planeamiento>) new ArrayList<Planeamiento>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Planeamiento.getNivelesDetalle", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public Planeamiento getNivelDetalle(String query) {
        SqlSession session = ssfWeb.openSession();
        Planeamiento bean = new Planeamiento();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            bean = session.selectOne("Planeamiento.getNivelesDetalle", hm);
        } finally {
            session.close();
        }
        return bean;
    }

    public void insertNivelesDetalle(Planeamiento bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.insert("Planeamiento.insertNivelesDetalle", bean);
            session.commit();
        }
    }

    public void updateNivelesDetalle(Planeamiento bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("Planeamiento.updateNivelesDetalle", bean);
            session.commit();
        }
    }

    public void deleteNivelesDetalle(Planeamiento bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("Planeamiento.deleteNivelesDetalle", bean);
            session.commit();
        }
    }

    public List<Planeamiento> getIndicadores(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Planeamiento> list = (List<Planeamiento>) new ArrayList<Planeamiento>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Planeamiento.getIndicadores", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public Planeamiento getIndicador(String query) {
        SqlSession session = ssfWeb.openSession();
        Planeamiento bean = new Planeamiento();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            bean = session.selectOne("Planeamiento.getIndicadores", hm);
        } finally {
            session.close();
        }
        return bean;
    }

    public void insertIndicadores(Planeamiento bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.insert("Planeamiento.insertIndicadores", bean);
            session.commit();
        }
    }

    public void updateIndicadores(Planeamiento bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("Planeamiento.updateIndicadores", bean);
            session.commit();
        }
    }

    public void deleteIndicadores(Planeamiento bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("Planeamiento.deleteIndicadores", bean);
            session.commit();
        }
    }

    public List<Planeamiento> getTipoIndicador(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Planeamiento> list = (List<Planeamiento>) new ArrayList<Planeamiento>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Planeamiento.getTipoIndicador", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Planeamiento> getIndicadoresFormula(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Planeamiento> list = (List<Planeamiento>) new ArrayList<Planeamiento>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Planeamiento.getIndicadoresFormula", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public Planeamiento getIndicadorFormula(String query) {
        SqlSession session = ssfWeb.openSession();
        Planeamiento bean = new Planeamiento();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            bean = session.selectOne("Planeamiento.getIndicadoresFormula", hm);
        } finally {
            session.close();
        }
        return bean;
    }

    public void insertIndicadoresFormula(Planeamiento bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.insert("Planeamiento.insertIndicadoresFormula", bean);
            session.commit();
        }
    }

    public void updateIndicadoresFormula(Planeamiento bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("Planeamiento.updateIndicadoresFormula", bean);
            session.commit();
        }
    }

    public void deleteIndicadoresFormula(Planeamiento bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("Planeamiento.deleteIndicadoresFormula", bean);
            session.commit();
        }
    }

    public List<Planeamiento> getIndicadoresVariables(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Planeamiento> list = (List<Planeamiento>) new ArrayList<Planeamiento>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Planeamiento.getIndicadoresVariables", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public Planeamiento getIndicadorVariables(String query) {
        SqlSession session = ssfWeb.openSession();
        Planeamiento bean = new Planeamiento();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            bean = session.selectOne("Planeamiento.getIndicadoresVariables", hm);
        } finally {
            session.close();
        }
        return bean;
    }

    public void insertIndicadoresVariables(Planeamiento bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.insert("Planeamiento.insertIndicadoresVariables", bean);
            session.commit();
        }
    }

    public void updateIndicadoresVariables(Planeamiento bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("Planeamiento.updateIndicadoresVariables", bean);
            session.commit();
        }
    }

    public void deleteIndicadoresVariables(Planeamiento bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("Planeamiento.deleteIndicadoresVariables", bean);
            session.commit();
        }
    }

    public List<Planeamiento> getTipoDocumento(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Planeamiento> list = (List<Planeamiento>) new ArrayList<Planeamiento>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Planeamiento.getTipoDocumento", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public void insertTipoDocumento(Planeamiento bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.insert("Planeamiento.insertTipoDocumento", bean);
            session.commit();
        }
    }

    public void updateTipoDocumento(Planeamiento bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("Planeamiento.updateTipoDocumento", bean);
            session.commit();
        }
    }

    public void deleteTipoDocumento(Planeamiento bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("Planeamiento.deleteTipoDocumento", bean);
            session.commit();
        }
    }

    public List<Planeamiento> getDepartamentos(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Planeamiento> list = (List<Planeamiento>) new ArrayList<Planeamiento>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Planeamiento.getDepartamentos", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Planeamiento> getProvincias(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Planeamiento> list = (List<Planeamiento>) new ArrayList<Planeamiento>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Planeamiento.getProvincias", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Planeamiento> getDistritos(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Planeamiento> list = (List<Planeamiento>) new ArrayList<Planeamiento>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Planeamiento.getDistritos", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Planeamiento> getIndicadoresTablero(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Planeamiento> list = (List<Planeamiento>) new ArrayList<Planeamiento>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Planeamiento.getIndicadoresTablero", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public Planeamiento getIndicadorTablero(String query) {
        SqlSession session = ssfWeb.openSession();
        Planeamiento bean = new Planeamiento();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            bean = session.selectOne("Planeamiento.getIndicadoresTablero", hm);
        } finally {
            session.close();
        }
        return bean;
    }

    public void insertIndicadoresTablero(Planeamiento bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.insert("Planeamiento.insertIndicadoresTablero", bean);
            session.commit();
        }
    }

    public void updateIndicadoresTablero(Planeamiento bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("Planeamiento.updateIndicadoresTablero", bean);
            session.commit();
        }
    }

    public void deleteIndicadoresTablero(Planeamiento bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("Planeamiento.deleteIndicadoresTablero", bean);
            session.commit();
        }
    }

    public List<Planeamiento> getArchivosTemp(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Planeamiento> list = (List<Planeamiento>) new ArrayList<Planeamiento>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Planeamiento.getArchivosTemp", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public void insertArchivosTemp(Planeamiento bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.insert("Planeamiento.insertArchivosTemp", bean);
            session.commit();
        }
    }

    public List<Planeamiento> getTipoGrafico(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Planeamiento> list = (List<Planeamiento>) new ArrayList<Planeamiento>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Planeamiento.getTipoGrafico", hm);
        } finally {
            session.close();
        }
        return list;
    }

}
