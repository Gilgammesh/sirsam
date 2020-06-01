package dao;

import config.EstadisticaConexion;
import estadistica.webservice.EstadisticaBot;
import estadistica.webservice.EstadisticaBot_Service;
import estadistica.webservice.InstitucionEducativa;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/*
 // @author CARLOS SANTANDER
 */
public class EstadisticaDao {

    private final SqlSessionFactory ssfWeb;

    public EstadisticaDao() throws IOException {
        ssfWeb = EstadisticaConexion.getSqlSessionFactory();
    }

    EstadisticaBot_Service service = new EstadisticaBot_Service();
    EstadisticaBot port = service.getEstadisticaBotPort();

    public List<InstitucionEducativa> getInstitucionesEducativas(String query, long time, String fuente, String host, String ip) {
        SqlSession session = ssfWeb.openSession();
        List<InstitucionEducativa> list = (List<InstitucionEducativa>) new ArrayList<InstitucionEducativa>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Estadistica.getInstitucionesEducativas", hm);
        } catch (Exception ex) {
            port.insertLogsEstadisticaBot(time, fuente, host, ip, "NO", ex.toString(), null);
        } finally {
            session.close();
        }
        return list;
    }

}
