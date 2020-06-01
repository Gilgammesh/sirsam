package inversion.dao;

import config.SIRSAMConexion;
import inversion.bean.Inversion;
import inversion.bean.LogsProyectosBot;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author CARLOS SANTANDER
 */
public class InversionDao {

    private final SqlSessionFactory ssfWeb;

    public InversionDao() throws IOException {
        ssfWeb = SIRSAMConexion.getSqlSessionFactory();
    }

    // LOGS ACTUALIZACION DE PROYECTOS  ......................................................................... 
    public void insertLogsProyectosBot(long time, String tabla, String codigo, String host, String ip, String actualizo, String log_cliente, String log_servidor) {
        try (SqlSession session = ssfWeb.openSession()) {
            LogsProyectosBot logs = new LogsProyectosBot();
            logs.setFecha_hora(new Timestamp(time));
            logs.setTabla(tabla);
            logs.setCodigo_siaf(codigo);
            logs.setHostname(host);
            logs.setIp_local(ip);
            logs.setActualizo(actualizo);
            logs.setError_selenium(log_cliente);
            logs.setError_postgresql(log_servidor);
            session.insert("Inversion.insertLogsProyectosBot", logs);
            session.commit();
        }
    }

    // LISTA DE CODIGOS SIAF DE LOS PROYECTOS
    public List<Inversion> getCodigosSIAF(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Inversion> list = (List<Inversion>) new ArrayList<Inversion>();
        HashMap hm = new HashMap();
        hm.put("q", query);
        try {
            list = session.selectList("Inversion.getCodigosSIAF", hm);
        } finally {
            session.close();
        }
        return list;
    }

    // CODIGO SIAF DE UN PROYECTO
    public Inversion getCodigoSIAF(String query) {
        SqlSession session = ssfWeb.openSession();
        Inversion datos = new Inversion();
        HashMap hm = new HashMap();
        hm.put("q", query);
        try {
            datos = session.selectOne("Inversion.getCodigosSIAF", hm);
        } finally {
            session.close();
        }
        return datos;
    }

    // ULTIMO CODIGO SIAF DE PROYECTOS ACTUALIZADO EN EL ROBOT
    public Inversion getLogsBotCod(String query) {
        SqlSession session = ssfWeb.openSession();
        Inversion datos = new Inversion();
        HashMap hm = new HashMap();
        hm.put("q", query);
        try {
            datos = session.selectOne("Inversion.getLogsBotCod", hm);
        } finally {
            session.close();
        }
        return datos;
    }

    // ACTUALIZACION DEL ULTIMO CODIGO SIAF DE PROYECTOS EN EL ROBOT
    public void updateLogsBotCod(String codigo, int yearCod, int monthCod, int dayCod) {
        try (SqlSession session = ssfWeb.openSession()) {
            Inversion logs = new Inversion();
            logs.setLogs_id(1);
            logs.setProy_codigo_siaf(codigo);
            LocalDate localDate = LocalDate.of(yearCod, monthCod, dayCod);
            Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            logs.setFecha(fecha);
            session.update("Inversion.updateLogsBotCod", logs);
            session.commit();
        }
    }

    // DATOS GENERALES DEL PROYECTO
    public void upsertProyecto(Inversion bean, long time, String tabla, String codigo, String host, String ip) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.insert("Inversion.upsertProyecto", bean);
            session.commit();
            insertLogsProyectosBot(time, tabla, codigo, host, ip, "SI", null, null);
        } catch (Exception ex) {
            insertLogsProyectosBot(time, tabla, codigo, host, ip, "NO", null, ex.toString());
        }
    }

    // CONTRATOS DE UN PROYECTO
    public void upsertProyectoContrataciones(Inversion bean, long time, String tabla, String codigo, String host, String ip) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.insert("Inversion.upsertProyectoContrataciones", bean);
            session.commit();
            insertLogsProyectosBot(time, tabla, codigo, host, ip, "SI", null, null);
        } catch (Exception ex) {
            insertLogsProyectosBot(time, tabla, codigo, host, ip, "NO", null, ex.toString());
        }
    }

    // MODIFICACIONES DEL MONTO DE INVERSIÓN DE UN PROYECTO
    public void upsertProyectoModificaciones(Inversion bean, long time, String tabla, String codigo, String host, String ip) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.insert("Inversion.upsertProyectoModificaciones", bean);
            session.commit();
            insertLogsProyectosBot(time, tabla, codigo, host, ip, "SI", null, null);
        } catch (Exception ex) {
            insertLogsProyectosBot(time, tabla, codigo, host, ip, "NO", null, ex.toString());
        }
    }

    // UBICACIÓN GEOGRÁFICA DE UN PROYECTO
    public void upsertProyectoUbicacion(Inversion bean, long time, String tabla, String codigo, String host, String ip) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.insert("Inversion.upsertProyectoUbicacion", bean);
            session.commit();
            insertLogsProyectosBot(time, tabla, codigo, host, ip, "SI", null, null);
        } catch (Exception ex) {
            insertLogsProyectosBot(time, tabla, codigo, host, ip, "NO", null, ex.toString());
        }
    }

    // COMPONENTES DE UN PROYECTO
    public void upsertProyectoComponentes(Inversion bean, long time, String tabla, String codigo, String host, String ip) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.insert("Inversion.upsertProyectoComponentes", bean);
            session.commit();
            insertLogsProyectosBot(time, tabla, codigo, host, ip, "SI", null, null);
        } catch (Exception ex) {
            insertLogsProyectosBot(time, tabla, codigo, host, ip, "NO", null, ex.toString());
        }
    }

}
