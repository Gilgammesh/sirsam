package daos;

import beans.Estadistica;
import config.ConexionFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author CARLOS SANTANDER
 */
public class EstadisticaDao {

    private final SqlSessionFactory ssfWeb;

    public EstadisticaDao() {
        ssfWeb = ConexionFactory.getSqlSessionFactory();
    }

    public List<Estadistica> getSectores(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Estadistica> list = (List<Estadistica>) new ArrayList<Estadistica>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Estadistica.getSectores", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public Estadistica getSector(String query) {
        SqlSession session = ssfWeb.openSession();
        Estadistica bean = new Estadistica();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            bean = session.selectOne("Estadistica.getSectores", hm);
        } finally {
            session.close();
        }
        return bean;
    }

    public List<Estadistica> getInstrumentos(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Estadistica> list = (List<Estadistica>) new ArrayList<Estadistica>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Estadistica.getInstrumentos", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public Estadistica getInstrumento(String query) {
        SqlSession session = ssfWeb.openSession();
        Estadistica bean = new Estadistica();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            bean = session.selectOne("Estadistica.getInstrumentos", hm);
        } finally {
            session.close();
        }
        return bean;
    }

    public List<Estadistica> getIndicadores(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Estadistica> list = (List<Estadistica>) new ArrayList<Estadistica>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Estadistica.getIndicadores", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public Estadistica getIndicador(String query) {
        SqlSession session = ssfWeb.openSession();
        Estadistica bean = new Estadistica();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            bean = session.selectOne("Estadistica.getIndicadores", hm);
        } finally {
            session.close();
        }
        return bean;
    }

}
