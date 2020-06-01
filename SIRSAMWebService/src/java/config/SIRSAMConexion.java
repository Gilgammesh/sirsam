package config;

import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author CARLOS SANTANDER
 */
public class SIRSAMConexion {

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        Reader reader = null;
        try {
            String resource = "config/Conexiones.xml";
            reader = Resources.getResourceAsReader(resource);

            if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "SIRSAM");
            }
        } catch (SqlSessionException ex) {
            sqlSessionFactory = null;
            Logger.getLogger(SIRSAMConexion.class.getName()).log(
                    Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(SIRSAMConexion.class.getName()).log(
                        Level.SEVERE, null, ex);
            }
        }
        return sqlSessionFactory;
    }
}
