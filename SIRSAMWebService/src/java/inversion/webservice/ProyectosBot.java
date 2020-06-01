package inversion.webservice;

import inversion.bean.Inversion;
import inversion.dao.InversionDao;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/*
 ** @author CARLOS SANTANDER
 */
@WebService(serviceName = "ProyectosBot")
public class ProyectosBot {

    @WebMethod(operationName = "insertLogsProyectosBot")
    public void insertLogsProyectosBot(
            @WebParam(name = "time") long time,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "codigo") String codigo,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip,
            @WebParam(name = "actualizo") String actualizo,
            @WebParam(name = "log_cliente") String log_cliente,
            @WebParam(name = "log_servidor") String log_servidor
    ) {
        try {
            new InversionDao().insertLogsProyectosBot(time, tabla, codigo, host, ip, actualizo, log_cliente, log_servidor);
        } catch (IOException ex) {
            Logger.getLogger(ProyectosBot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "getCodigosSIAF")
    public List<Inversion> getCodigosSIAF(
            @WebParam(name = "query") String query
    ) {
        try {
            List<Inversion> list = new InversionDao().getCodigosSIAF(query);
            return list;
        } catch (IOException ex) {
            Logger.getLogger(ProyectosBot.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @WebMethod(operationName = "getCodigoSIAF")
    public Inversion getCodigoSIAF(
            @WebParam(name = "query") String query
    ) {
        try {
            Inversion bean = new InversionDao().getCodigoSIAF(query);
            return bean;
        } catch (IOException ex) {
            Logger.getLogger(ProyectosBot.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @WebMethod(operationName = "getLogsBotCod")
    public Inversion getLogsBotCod(
            @WebParam(name = "query") String query
    ) {
        try {
            Inversion data = new InversionDao().getLogsBotCod(query);
            return data;
        } catch (IOException ex) {
            Logger.getLogger(ProyectosBot.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @WebMethod(operationName = "updateLogsBotCod")
    public void updateLogsBotCod(
            @WebParam(name = "codigo") String codigo,
            @WebParam(name = "year") int year,
            @WebParam(name = "month") int month,
            @WebParam(name = "day") int day
    ) {
        try {
            new InversionDao().updateLogsBotCod(codigo, year, month, day);
        } catch (IOException ex) {
            Logger.getLogger(ProyectosBot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertProyecto")
    public void upsertProyecto(
            @WebParam(name = "data") Inversion data,
            @WebParam(name = "time") long time,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "codigo") String codigo,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new InversionDao().upsertProyecto(data, time, tabla, codigo, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(ProyectosBot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertProyectoContrataciones")
    public void upsertProyectoContrataciones(
            @WebParam(name = "data") Inversion data,
            @WebParam(name = "time") long time,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "codigo") String codigo,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new InversionDao().upsertProyectoContrataciones(data, time, tabla, codigo, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(ProyectosBot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertProyectoModificaciones")
    public void upsertProyectoModificaciones(
            @WebParam(name = "data") Inversion data,
            @WebParam(name = "time") long time,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "codigo") String codigo,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new InversionDao().upsertProyectoModificaciones(data, time, tabla, codigo, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(ProyectosBot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertProyectoUbicacion")
    public void upsertProyectoUbicacion(
            @WebParam(name = "data") Inversion data,
            @WebParam(name = "time") long time,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "codigo") String codigo,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new InversionDao().upsertProyectoUbicacion(data, time, tabla, codigo, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(ProyectosBot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertProyectoComponentes")
    public void upsertProyectoComponentes(
            @WebParam(name = "data") Inversion data,
            @WebParam(name = "time") long time,
            @WebParam(name = "tabla") String tabla,
            @WebParam(name = "codigo") String codigo,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new InversionDao().upsertProyectoComponentes(data, time, tabla, codigo, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(ProyectosBot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
