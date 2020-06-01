package daos;

import beans.PlaneamientoGraficas;
import config.ConexionFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author CARLOS SANTANDER
 */
public class PlaneamientoGraficasDao {

    private final SqlSessionFactory ssfWeb;

    public PlaneamientoGraficasDao() {
        ssfWeb = ConexionFactory.getSqlSessionFactory();
    }

    public List<PlaneamientoGraficas> getListaGraficaBarv2d(String query) {
        SqlSession session = ssfWeb.openSession();
        List<PlaneamientoGraficas> list = (List<PlaneamientoGraficas>) new ArrayList<PlaneamientoGraficas>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("PlaneamientoGraficas.getGraficaBarv2d", hm);
        } finally {
            session.close();
        }
        return list;
    }
    
     public PlaneamientoGraficas getGraficaBarv2d(String query) {
        SqlSession session = ssfWeb.openSession();
        PlaneamientoGraficas bean = new PlaneamientoGraficas();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            bean = session.selectOne("PlaneamientoGraficas.getGraficaBarv2d", hm);
        } finally {
            session.close();
        }
        return bean;
    }

    public void insertGraficaBarv2d(PlaneamientoGraficas bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.insert("PlaneamientoGraficas.insertGraficaBarv2d", bean);
            session.commit();
        }
    }

    public void updateGraficaBarv2d(PlaneamientoGraficas bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("PlaneamientoGraficas.updateGraficaBarv2d", bean);
            session.commit();
        }
    }

    public void deleteGraficaBarv2d(PlaneamientoGraficas bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("PlaneamientoGraficas.deleteGraficaBarv2d", bean);
            session.commit();
        }
    }

}
