package config;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.ibatis.io.Resources;
import org.xml.sax.SAXException;

/**
 * @author CARLOS SANTANDER
 */
public class ConexionReporte {

    static String driver = "", url = "", username = "", password = "";
    static Connection conn = null;

    public static Connection AbrirConexion() throws ClassNotFoundException, SQLException, ParserConfigurationException, SAXException, IOException {
        ParametrosConexionProperty();
        Class.forName(driver);
        conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    public static void CerrarConexion() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void ParametrosConexionProperty() throws IOException {
        driver = obtenerPropiedad("driver");
        url = obtenerPropiedad("url");
        username = obtenerPropiedad("user");
        password = obtenerPropiedad("password");
    }

    public static String obtenerPropiedad(String nombre) throws IOException {
        Reader reader = null;
        Properties propiedades = new Properties();
        reader = Resources.getResourceAsReader("config/ConexionReporte.properties");
        propiedades.load(reader);
        reader.close();
        return propiedades.getProperty(nombre);
    }

}
