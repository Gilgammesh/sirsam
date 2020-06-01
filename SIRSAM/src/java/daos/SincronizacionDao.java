package daos;

import config.ConexionFactory;
import beans.Sincronizacion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author CARLOS SANTANDER
 */
public class SincronizacionDao {

    private final SqlSessionFactory ssfWeb;

    public SincronizacionDao() {
        ssfWeb = ConexionFactory.getSqlSessionFactory();
    }

    public List<Sincronizacion> getMonitorEjecutoras(String queryA, String queryB, String queryC, String queryD) {
        SqlSession session = ssfWeb.openSession();
        List<Sincronizacion> list = (List<Sincronizacion>) new ArrayList<Sincronizacion>();
        HashMap hm = new HashMap();
        hm.put("a", queryA);
        hm.put("b", queryB);
        hm.put("c", queryC);
        hm.put("d", queryD);
        try {
            list = session.selectList("Sincronizacion.getMonitorEjecutoras", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Sincronizacion> getMonitorTablas(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Sincronizacion> list = (List<Sincronizacion>) new ArrayList<Sincronizacion>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Sincronizacion.getMonitorTablas", hm);
        } finally {
            session.close();
        }
        return list;
    }

}
