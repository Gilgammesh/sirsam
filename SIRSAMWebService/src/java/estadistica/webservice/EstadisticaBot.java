package estadistica.webservice;

import estadistica.bean.InstitucionEducativa;
import estadistica.dao.EstadisticaDao;
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
@WebService(serviceName = "EstadisticaBot")
public class EstadisticaBot {

    @WebMethod(operationName = "insertLogsEstadisticaBot")
    public void insertLogsEstadisticaBot(
            @WebParam(name = "time") long time,
            @WebParam(name = "fuente") String fuente,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip,
            @WebParam(name = "sync") String sync,
            @WebParam(name = "log_cliente") String log_cliente,
            @WebParam(name = "log_servidor") String log_servidor
    ) {
        try {
            new EstadisticaDao().insertLogsEstadisticaBot(time, fuente, host, ip, sync, log_cliente, log_servidor);
        } catch (IOException ex) {
            Logger.getLogger(EstadisticaBot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "upsertInstitucionEducativa")
    public void upsertInstitucionEducativa(
            @WebParam(name = "data") List<InstitucionEducativa> data,
            @WebParam(name = "time") long time,
            @WebParam(name = "fuente") String fuente,
            @WebParam(name = "host") String host,
            @WebParam(name = "ip") String ip
    ) {
        try {
            new EstadisticaDao().upsertInstitucionEducativa(data, time, fuente, host, ip);
        } catch (IOException ex) {
            Logger.getLogger(EstadisticaBot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
