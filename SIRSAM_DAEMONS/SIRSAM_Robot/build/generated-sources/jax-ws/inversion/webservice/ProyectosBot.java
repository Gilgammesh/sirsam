
package inversion.webservice;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ProyectosBot", targetNamespace = "http://webservice.inversion/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ProyectosBot {


    /**
     * 
     * @param codigo
     * @param data
     * @param ip
     * @param host
     * @param tabla
     * @param time
     */
    @WebMethod
    @RequestWrapper(localName = "upsertProyectoComponentes", targetNamespace = "http://webservice.inversion/", className = "inversion.webservice.UpsertProyectoComponentes")
    @ResponseWrapper(localName = "upsertProyectoComponentesResponse", targetNamespace = "http://webservice.inversion/", className = "inversion.webservice.UpsertProyectoComponentesResponse")
    @Action(input = "http://webservice.inversion/ProyectosBot/upsertProyectoComponentesRequest", output = "http://webservice.inversion/ProyectosBot/upsertProyectoComponentesResponse")
    public void upsertProyectoComponentes(
        @WebParam(name = "data", targetNamespace = "")
        Inversion data,
        @WebParam(name = "time", targetNamespace = "")
        long time,
        @WebParam(name = "tabla", targetNamespace = "")
        String tabla,
        @WebParam(name = "codigo", targetNamespace = "")
        String codigo,
        @WebParam(name = "host", targetNamespace = "")
        String host,
        @WebParam(name = "ip", targetNamespace = "")
        String ip);

    /**
     * 
     * @param codigo
     * @param month
     * @param year
     * @param day
     */
    @WebMethod
    @RequestWrapper(localName = "updateLogsBotCod", targetNamespace = "http://webservice.inversion/", className = "inversion.webservice.UpdateLogsBotCod")
    @ResponseWrapper(localName = "updateLogsBotCodResponse", targetNamespace = "http://webservice.inversion/", className = "inversion.webservice.UpdateLogsBotCodResponse")
    @Action(input = "http://webservice.inversion/ProyectosBot/updateLogsBotCodRequest", output = "http://webservice.inversion/ProyectosBot/updateLogsBotCodResponse")
    public void updateLogsBotCod(
        @WebParam(name = "codigo", targetNamespace = "")
        String codigo,
        @WebParam(name = "year", targetNamespace = "")
        int year,
        @WebParam(name = "month", targetNamespace = "")
        int month,
        @WebParam(name = "day", targetNamespace = "")
        int day);

    /**
     * 
     * @param codigo
     * @param data
     * @param ip
     * @param host
     * @param tabla
     * @param time
     */
    @WebMethod
    @RequestWrapper(localName = "upsertProyectoContrataciones", targetNamespace = "http://webservice.inversion/", className = "inversion.webservice.UpsertProyectoContrataciones")
    @ResponseWrapper(localName = "upsertProyectoContratacionesResponse", targetNamespace = "http://webservice.inversion/", className = "inversion.webservice.UpsertProyectoContratacionesResponse")
    @Action(input = "http://webservice.inversion/ProyectosBot/upsertProyectoContratacionesRequest", output = "http://webservice.inversion/ProyectosBot/upsertProyectoContratacionesResponse")
    public void upsertProyectoContrataciones(
        @WebParam(name = "data", targetNamespace = "")
        Inversion data,
        @WebParam(name = "time", targetNamespace = "")
        long time,
        @WebParam(name = "tabla", targetNamespace = "")
        String tabla,
        @WebParam(name = "codigo", targetNamespace = "")
        String codigo,
        @WebParam(name = "host", targetNamespace = "")
        String host,
        @WebParam(name = "ip", targetNamespace = "")
        String ip);

    /**
     * 
     * @param codigo
     * @param logCliente
     * @param logServidor
     * @param actualizo
     * @param ip
     * @param host
     * @param tabla
     * @param time
     */
    @WebMethod
    @RequestWrapper(localName = "insertLogsProyectosBot", targetNamespace = "http://webservice.inversion/", className = "inversion.webservice.InsertLogsProyectosBot")
    @ResponseWrapper(localName = "insertLogsProyectosBotResponse", targetNamespace = "http://webservice.inversion/", className = "inversion.webservice.InsertLogsProyectosBotResponse")
    @Action(input = "http://webservice.inversion/ProyectosBot/insertLogsProyectosBotRequest", output = "http://webservice.inversion/ProyectosBot/insertLogsProyectosBotResponse")
    public void insertLogsProyectosBot(
        @WebParam(name = "time", targetNamespace = "")
        long time,
        @WebParam(name = "tabla", targetNamespace = "")
        String tabla,
        @WebParam(name = "codigo", targetNamespace = "")
        String codigo,
        @WebParam(name = "host", targetNamespace = "")
        String host,
        @WebParam(name = "ip", targetNamespace = "")
        String ip,
        @WebParam(name = "actualizo", targetNamespace = "")
        String actualizo,
        @WebParam(name = "log_cliente", targetNamespace = "")
        String logCliente,
        @WebParam(name = "log_servidor", targetNamespace = "")
        String logServidor);

    /**
     * 
     * @param codigo
     * @param data
     * @param ip
     * @param host
     * @param tabla
     * @param time
     */
    @WebMethod
    @RequestWrapper(localName = "upsertProyectoUbicacion", targetNamespace = "http://webservice.inversion/", className = "inversion.webservice.UpsertProyectoUbicacion")
    @ResponseWrapper(localName = "upsertProyectoUbicacionResponse", targetNamespace = "http://webservice.inversion/", className = "inversion.webservice.UpsertProyectoUbicacionResponse")
    @Action(input = "http://webservice.inversion/ProyectosBot/upsertProyectoUbicacionRequest", output = "http://webservice.inversion/ProyectosBot/upsertProyectoUbicacionResponse")
    public void upsertProyectoUbicacion(
        @WebParam(name = "data", targetNamespace = "")
        Inversion data,
        @WebParam(name = "time", targetNamespace = "")
        long time,
        @WebParam(name = "tabla", targetNamespace = "")
        String tabla,
        @WebParam(name = "codigo", targetNamespace = "")
        String codigo,
        @WebParam(name = "host", targetNamespace = "")
        String host,
        @WebParam(name = "ip", targetNamespace = "")
        String ip);

    /**
     * 
     * @param codigo
     * @param data
     * @param ip
     * @param host
     * @param tabla
     * @param time
     */
    @WebMethod
    @RequestWrapper(localName = "upsertProyecto", targetNamespace = "http://webservice.inversion/", className = "inversion.webservice.UpsertProyecto")
    @ResponseWrapper(localName = "upsertProyectoResponse", targetNamespace = "http://webservice.inversion/", className = "inversion.webservice.UpsertProyectoResponse")
    @Action(input = "http://webservice.inversion/ProyectosBot/upsertProyectoRequest", output = "http://webservice.inversion/ProyectosBot/upsertProyectoResponse")
    public void upsertProyecto(
        @WebParam(name = "data", targetNamespace = "")
        Inversion data,
        @WebParam(name = "time", targetNamespace = "")
        long time,
        @WebParam(name = "tabla", targetNamespace = "")
        String tabla,
        @WebParam(name = "codigo", targetNamespace = "")
        String codigo,
        @WebParam(name = "host", targetNamespace = "")
        String host,
        @WebParam(name = "ip", targetNamespace = "")
        String ip);

    /**
     * 
     * @param query
     * @return
     *     returns inversion.webservice.Inversion
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCodigoSIAF", targetNamespace = "http://webservice.inversion/", className = "inversion.webservice.GetCodigoSIAF")
    @ResponseWrapper(localName = "getCodigoSIAFResponse", targetNamespace = "http://webservice.inversion/", className = "inversion.webservice.GetCodigoSIAFResponse")
    @Action(input = "http://webservice.inversion/ProyectosBot/getCodigoSIAFRequest", output = "http://webservice.inversion/ProyectosBot/getCodigoSIAFResponse")
    public Inversion getCodigoSIAF(
        @WebParam(name = "query", targetNamespace = "")
        String query);

    /**
     * 
     * @param codigo
     * @param data
     * @param ip
     * @param host
     * @param tabla
     * @param time
     */
    @WebMethod
    @RequestWrapper(localName = "upsertProyectoModificaciones", targetNamespace = "http://webservice.inversion/", className = "inversion.webservice.UpsertProyectoModificaciones")
    @ResponseWrapper(localName = "upsertProyectoModificacionesResponse", targetNamespace = "http://webservice.inversion/", className = "inversion.webservice.UpsertProyectoModificacionesResponse")
    @Action(input = "http://webservice.inversion/ProyectosBot/upsertProyectoModificacionesRequest", output = "http://webservice.inversion/ProyectosBot/upsertProyectoModificacionesResponse")
    public void upsertProyectoModificaciones(
        @WebParam(name = "data", targetNamespace = "")
        Inversion data,
        @WebParam(name = "time", targetNamespace = "")
        long time,
        @WebParam(name = "tabla", targetNamespace = "")
        String tabla,
        @WebParam(name = "codigo", targetNamespace = "")
        String codigo,
        @WebParam(name = "host", targetNamespace = "")
        String host,
        @WebParam(name = "ip", targetNamespace = "")
        String ip);

    /**
     * 
     * @param query
     * @return
     *     returns java.util.List<inversion.webservice.Inversion>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCodigosSIAF", targetNamespace = "http://webservice.inversion/", className = "inversion.webservice.GetCodigosSIAF")
    @ResponseWrapper(localName = "getCodigosSIAFResponse", targetNamespace = "http://webservice.inversion/", className = "inversion.webservice.GetCodigosSIAFResponse")
    @Action(input = "http://webservice.inversion/ProyectosBot/getCodigosSIAFRequest", output = "http://webservice.inversion/ProyectosBot/getCodigosSIAFResponse")
    public List<Inversion> getCodigosSIAF(
        @WebParam(name = "query", targetNamespace = "")
        String query);

    /**
     * 
     * @param query
     * @return
     *     returns inversion.webservice.Inversion
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getLogsBotCod", targetNamespace = "http://webservice.inversion/", className = "inversion.webservice.GetLogsBotCod")
    @ResponseWrapper(localName = "getLogsBotCodResponse", targetNamespace = "http://webservice.inversion/", className = "inversion.webservice.GetLogsBotCodResponse")
    @Action(input = "http://webservice.inversion/ProyectosBot/getLogsBotCodRequest", output = "http://webservice.inversion/ProyectosBot/getLogsBotCodResponse")
    public Inversion getLogsBotCod(
        @WebParam(name = "query", targetNamespace = "")
        String query);

}
