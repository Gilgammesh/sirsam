package daos;

import config.ConexionFactory;
import beans.PlaneamientoMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author CARLOS SANTANDER
 */
public class PlaneamientoMetaDataDao {

    private final SqlSessionFactory ssfWeb;

    public PlaneamientoMetaDataDao() {
        ssfWeb = ConexionFactory.getSqlSessionFactory();
    }

    public List<PlaneamientoMetaData> getListaMediciones(String consulta) {
        SqlSession session = ssfWeb.openSession();
        List<PlaneamientoMetaData> list = (List<PlaneamientoMetaData>) new ArrayList<PlaneamientoMetaData>();
        HashMap hm = new HashMap();
        hm.put("consulta", consulta);
        try {
            list = session.selectList("PlaneamientoMetaData.getListaMediciones", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<PlaneamientoMetaData> getListaDatos(String consulta) {
        SqlSession session = ssfWeb.openSession();
        List<PlaneamientoMetaData> list = (List<PlaneamientoMetaData>) new ArrayList<PlaneamientoMetaData>();
        HashMap hm = new HashMap();
        hm.put("consulta", consulta);
        try {
            list = session.selectList("PlaneamientoMetaData.getListaDatos", hm);
        } finally {
            session.close();
        }
        return list;
    }

}
