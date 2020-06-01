package daos;

import beans.EstadisticaGraficas;
import config.ConexionFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author CARLOS SANTANDER
 */
public class EstadisticaGraficasDao {

    private final SqlSessionFactory ssfWeb;

    public EstadisticaGraficasDao() {
        ssfWeb = ConexionFactory.getSqlSessionFactory();
    }

    public List<EstadisticaGraficas> getListaGraficaBarv2d(String query) {
        SqlSession session = ssfWeb.openSession();
        List<EstadisticaGraficas> list = (List<EstadisticaGraficas>) new ArrayList<EstadisticaGraficas>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("EstadisticaGraficas.getGraficaBarv2d", hm);
        } finally {
            session.close();
        }
        return list;
    }
    
     public EstadisticaGraficas getGraficaBarv2d(String query) {
        SqlSession session = ssfWeb.openSession();
        EstadisticaGraficas bean = new EstadisticaGraficas();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            bean = session.selectOne("EstadisticaGraficas.getGraficaBarv2d", hm);
        } finally {
            session.close();
        }
        return bean;
    }

    public void insertGraficaBarv2d(EstadisticaGraficas bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.insert("EstadisticaGraficas.insertGraficaBarv2d", bean);
            session.commit();
        }
    }

    public void updateGraficaBarv2d(EstadisticaGraficas bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("EstadisticaGraficas.updateGraficaBarv2d", bean);
            session.commit();
        }
    }

    public void deleteGraficaBarv2d(EstadisticaGraficas bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("EstadisticaGraficas.deleteGraficaBarv2d", bean);
            session.commit();
        }
    }

}
