package daos;

import config.ConexionFactory;
import beans.EstadisticaMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author CARLOS SANTANDER
 */
public class EstadisticaMetaDataDao {

    private final SqlSessionFactory ssfWeb;

    public EstadisticaMetaDataDao() {
        ssfWeb = ConexionFactory.getSqlSessionFactory();
    }

    public List<EstadisticaMetaData> getListaMediciones(String consulta) {
        SqlSession session = ssfWeb.openSession();
        List<EstadisticaMetaData> list = (List<EstadisticaMetaData>) new ArrayList<EstadisticaMetaData>();
        HashMap hm = new HashMap();
        hm.put("consulta", consulta);
        try {
            list = session.selectList("EstadisticaMetaData.getListaMediciones", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<EstadisticaMetaData> getListaDatos(String consulta) {
        SqlSession session = ssfWeb.openSession();
        List<EstadisticaMetaData> list = (List<EstadisticaMetaData>) new ArrayList<EstadisticaMetaData>();
        HashMap hm = new HashMap();
        hm.put("consulta", consulta);
        try {
            list = session.selectList("EstadisticaMetaData.getListaDatos", hm);
        } finally {
            session.close();
        }
        return list;
    }

}
