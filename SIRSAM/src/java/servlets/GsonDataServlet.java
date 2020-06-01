package servlets;

import beans.Presupuesto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import beans.Sesion;
import beans.Sincronizacion;
import beans.Usuario;
import config.ConexionReporte;
import daos.PresupuestoDao;
import daos.SesionDao;
import daos.SincronizacionDao;
import daos.UsuarioDao;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import useragentutils.Browser;
import useragentutils.OperatingSystem;
import useragentutils.UserAgent;

/**
 * @author CARLOS SANTANDER
 */
@WebServlet(name = "GsonDataServlet", urlPatterns = {"/GsonData"})
public class GsonDataServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("url") == null ? "" : request.getParameter("url");
        switch (action) {
            case "":
                index(request, response);
                break;
            case "Inicio":
                inicio(request, response);
                break;
            case "DataLogin":
                dataLogin(request, response);
                break;
            case "menuDinamico":
                menuDinamico(request, response);
                break;
            case "insertDinamico":
                insertDinamico(request, response);
                break;
            case "validaPermiso":
                validaPermiso(request, response);
                break;
            case "DataCentros":
                DataCentros(request, response);
                break;
            case "DataMetaCeco":
                DataMetaCeco(request, response);
                break;
            case "DataEjecutoras":
                DataEjecutoras(request, response);
                break;
            case "DataEjecutora":
                DataEjecutora(request, response);
                break;
            case "DataPresuAñosResumen":
                DataPresuAñosResumen(request, response);
                break;
            case "DataPresuAños":
                DataPresuAños(request, response);
                break;
            case "DataAñosMeta":
                DataAñosMeta(request, response);
                break;
            case "DataPresuAñosIngreso":
                DataPresuAñosIngreso(request, response);
                break;
            case "DataPresuAñosDesde":
                DataPresuAñosDesde(request, response);
                break;
            case "DataPresuAñosHasta":
                DataPresuAñosHasta(request, response);
                break;
            case "DataPresuAñosDesdeIngreso":
                DataPresuAñosDesdeIngreso(request, response);
                break;
            case "DataPresuAñosHastaIngreso":
                DataPresuAñosHastaIngreso(request, response);
                break;
            case "DataProyAños":
                DataProyAños(request, response);
                break;
            case "DataNotasAños":
                DataNotasAños(request, response);
                break;
            case "DataNotasMes":
                DataNotasMes(request, response);
                break;
            case "DataSemaforoEjecAños":
                DataSemaforoEjecAños(request, response);
                break;
            case "DataEjecDocuCerti":
                DataEjecDocuCerti(request, response);
                break;
            case "DataFiltros":
                DataFiltros(request, response);
                break;
            case "DataFiltrosMensual":
                DataFiltrosMensual(request, response);
                break;
            case "DataFiltrosIngreso":
                DataFiltrosIngreso(request, response);
                break;
            case "DataTipoRecurso":
                DataTipoRecurso(request, response);
                break;
            case "DataCuentaCorriente":
                DataCuentaCorriente(request, response);
                break;
            case "DataDistrito":
                DataDistrito(request, response);
                break;
            case "DataFiltrosMensualIngreso":
                DataFiltrosMensualIngreso(request, response);
                break;
            case "DataUsuarios":
                DataUsuarios(request, response);
                break;
            case "DataPerfiles":
                DataPerfiles(request, response);
                break;
            case "DataPermisos":
                DataPermisos(request, response);
                break;
            case "DataEditUsua":
                DataEditUsua(request, response);
                break;
            case "DataEditCeco":
                DataEditCeco(request, response);
                break;
            case "DataEditMetaCeco":
                DataEditMetaCeco(request, response);
                break;
            case "DataEditPerfil":
                DataEditPerfil(request, response);
                break;
            case "DataMonitor":
                DataMonitor(request, response);
                break;
            case "DataMonitorNavega":
                DataMonitorNavega(request, response);
                break;
            case "DataMonitorLogin":
                DataMonitorLogin(request, response);
                break;
            case "DataMonitorHistoLogin":
                DataMonitorHistoLogin(request, response);
                break;
            case "DataSincronizaEjecutoras":
                DataSincronizaEjecutoras(request, response);
                break;
            case "DataSincronizaUltimaFecha":
                DataSincronizaUltimaFecha(request, response);
                break;
            case "DataSincronizaTablas":
                DataSincronizaTablas(request, response);
                break;
            case "DataNotasTipo":
                DataNotasTipo(request, response);
                break;
            case "DataNotasRubro":
                DataNotasRubro(request, response);
                break;
            case "DataNotaDetalle":
                DataNotaDetalle(request, response);
                break;
            case "DetalleExpeSIAFFase":
                DetalleExpeSIAFFase(request, response);
                break;
            case "DataAnosRegProy":
                DataAnosRegProy(request, response);
                break;
            case "DataMeses":
                DataMeses(request, response);
                break;
            default:
                index(request, response);
                break;
        }
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    private void inicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        OperatingSystem agent = userAgent.getOperatingSystem();
        Browser browser = userAgent.getBrowser();

        try {
            Sesion bean = new Sesion();
            bean.setSesiId(request.getSession().getAttribute("sesion_id").toString());
            bean.setBrowser(browser.getName());
            bean.setDevice(agent.getDeviceType().getName());
            new SesionDao().update(bean);
        } catch (Exception ex) {
        }

        String perfil;
        String sexo;

        HashMap outHash = new HashMap();

        if (request.getSession().getAttribute("id_usuario") == null) {
            perfil = "";
            sexo = "";
        } else {
            perfil = request.getSession().getAttribute("perfil").toString();
            sexo = request.getSession().getAttribute("sexo").toString();
            String query = " WHERE a.perf_id = " + perfil + " AND a.activo = TRUE ORDER BY a.menu_id ASC";
            List<Usuario> listPermisos = new UsuarioDao().getListaPermisos(query);
            outHash.put("listPermisos", listPermisos);
        }

        outHash.put("perfil", perfil);
        outHash.put("sexo", sexo);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void dataLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        Integer id_usuario = Integer.parseInt(request.getSession().getAttribute("id_usuario").toString());
        String dni = request.getSession().getAttribute("dni").toString();
        String nombres = request.getSession().getAttribute("nombres").toString();
        String[] partes_nombre = nombres.split(" ");
        String nombre1 = partes_nombre[0];
        String apellido_paterno = request.getSession().getAttribute("apellido_paterno").toString();
        String apellido_materno = request.getSession().getAttribute("apellido_materno").toString();
        String sexo = request.getSession().getAttribute("sexo").toString();
        Integer perfil = Integer.parseInt(request.getSession().getAttribute("perfil").toString());

        HashMap outHash = new HashMap();

        outHash.put("id_usuario", id_usuario);
        outHash.put("dni", dni);
        outHash.put("nombres", nombres);
        outHash.put("nombre1", nombre1);
        outHash.put("apellido_paterno", apellido_paterno);
        outHash.put("apellido_materno", apellido_materno);
        outHash.put("sexo", sexo);
        outHash.put("perfil", perfil);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void menuDinamico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String query = " WHERE a.sesi_id = '" + request.getSession().getAttribute("sesion_id").toString() + "' ";
        Sesion sesion = new SesionDao().getDatos(query);

        HashMap outHash = new HashMap();
        outHash.put("menu", sesion.getMenuNombre());

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void insertDinamico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String query = " WHERE menu_nombre = '" + request.getParameter("menu") + "' ";
        Sesion menu = new SesionDao().getMenuId(query);

        Sesion bean = new Sesion();
        bean.setSesiId(request.getSession().getAttribute("sesion_id").toString());
        bean.setMenuId(menu.getMenuId());
        new SesionDao().updateMenu(bean);

        HashMap outHash = new HashMap();
        outHash.put("ok", "ok");

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void validaPermiso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String menu_id = request.getParameter("menu");
        String perf_id = request.getSession().getAttribute("perfil").toString();
        String usua_id = request.getSession().getAttribute("id_usuario").toString();

        String queryP = " WHERE a.perf_id = " + perf_id + " AND a.menu_id = " + menu_id;
        List<Usuario> listPermiso = new UsuarioDao().getListaPermisos(queryP);

        String queryU = " WHERE usua_id = " + usua_id;
        List<Usuario> listUsuario = new UsuarioDao().getListaDatos(queryU);

        HashMap outHash = new HashMap();
        outHash.put("perfil", perf_id);
        outHash.put("registra", listPermiso.get(0).getRegistra());
        outHash.put("ejec", listUsuario.get(0).getSec_ejec());

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void DataCentros(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String ejec = request.getParameter("ejec");

        String query = " WHERE sec_ejec = '" + ejec + "' ORDER BY ceco_codigo ASC ";
        List<Presupuesto> listCentros = new PresupuestoDao().getCentroCosto(query);

        HashMap outHash = new HashMap();
        outHash.put("listCentros", listCentros);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void DataMetaCeco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String ejec = request.getParameter("ejec");
        String ano = request.getParameter("ano");

        String query = " WHERE m.ano_eje = '" + ano + "' AND m.sec_ejec = '" + ejec + "' AND m.sec_func != '0000' AND m.estado = 'A' ORDER BY m.sec_func ASC ";
        List<Presupuesto> listMetaCeco = new PresupuestoDao().getMetaCentroCosto(query);

        HashMap outHash = new HashMap();
        outHash.put("listMetaCeco", listMetaCeco);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void DataEjecutoras(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        LocalDate date = LocalDate.now();

        String pliego = ConexionReporte.obtenerPropiedad("pliego");

        String query = " WHERE ano_eje = '" + date.getYear() + "' AND pliego = '" + pliego + "' AND estado = 'A' ORDER BY ejecutora ASC";
        List<Presupuesto> listEjecutoras = new PresupuestoDao().getListEjecutoras(query);

        HashMap outHash = new HashMap();
        outHash.put("listEjecutoras", listEjecutoras);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void DataEjecutora(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String año = request.getParameter("año");
        String ejec = request.getParameter("ejec");

        String pliego = ConexionReporte.obtenerPropiedad("pliego");

        String query = " WHERE ano_eje = '" + año + "' AND sec_ejec = '" + ejec + "' AND pliego = '" + pliego + "' AND estado = 'A' ORDER BY ejecutora ASC";
        Presupuesto data = new PresupuestoDao().getEjecutora(query);

        HashMap outHash = new HashMap();
        outHash.put("ejecutora", data.getEjecutora().trim());
        outHash.put("nombre", data.getNombre().trim());

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void DataPresuAñosResumen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        LocalDate ld = LocalDate.now();
        int año = ld.getYear();

        String query = " WHERE (ano_eje >= '2016' AND ano_eje <= '" + año + "') GROUP BY ano_eje ORDER BY ano_eje DESC ";
        List<Presupuesto> listAños = new PresupuestoDao().getListAños(query);

        HashMap outHash = new HashMap();
        outHash.put("listAños", listAños);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void DataPresuAños(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String sec_ejec = request.getParameter("sec_ejec");

        String query = "";
        if (sec_ejec.equals("00")) {
            query = "WHERE ano_eje >= '2010' GROUP BY ano_eje ORDER BY ano_eje DESC";
        } else {
            query = "WHERE ano_eje >= '2010' AND sec_ejec = '" + sec_ejec + "' GROUP BY ano_eje ORDER BY ano_eje DESC";
        }

        List<Presupuesto> listAños = new PresupuestoDao().getListAños(query);

        HashMap outHash = new HashMap();
        outHash.put("listAños", listAños);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void DataAñosMeta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String ejec = request.getParameter("ejec");

        String query = " WHERE sec_ejec = '" + ejec + "' GROUP BY ano_eje ORDER BY ano_eje DESC";
        List<Presupuesto> listAños = new PresupuestoDao().getListMetaAños(query);

        HashMap outHash = new HashMap();
        outHash.put("listAños", listAños);
        outHash.put("ejec", ejec);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void DataPresuAñosIngreso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String sec_ejec = request.getParameter("sec_ejec");

        String query = "";
        if (sec_ejec.equals("00")) {
            query = "WHERE ano_eje >= '2015' GROUP BY ano_eje ORDER BY ano_eje DESC";
        } else {
            query = "WHERE ano_eje >= '2015' AND sec_ejec = '" + sec_ejec + "' GROUP BY ano_eje ORDER BY ano_eje DESC";
        }

        List<Presupuesto> listAños = new PresupuestoDao().getListAñosIngreso(query);

        HashMap outHash = new HashMap();
        outHash.put("listAños", listAños);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void DataProyAños(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String query = "WHERE ano_eje >= '2015' GROUP BY ano_eje ORDER BY ano_eje DESC";
        List<Presupuesto> listAños = new PresupuestoDao().getListAños(query);

        HashMap outHash = new HashMap();
        outHash.put("listAños", listAños);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void DataNotasAños(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String query = " WHERE ano_eje >= '2015' GROUP BY ano_eje ORDER BY ano_eje DESC ";
        List<Presupuesto> listAños = new PresupuestoDao().getListNotasAños(query);

        HashMap outHash = new HashMap();
        outHash.put("listAños", listAños);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void DataNotasMes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String año = request.getParameter("año");
        String desde = request.getParameter("desde");
        String orden = request.getParameter("orden");

        LocalDate ld = LocalDate.now();
        String año_actual = ld.getYear() + "";
        int mes_actual = ld.getMonthValue();

        HashMap outHash = new HashMap();
        if (año.equals(año_actual)) {
            String query = " WHERE mes >= " + desde + " AND mes <= " + mes_actual + " ORDER BY mes " + orden + " ";
            List<Presupuesto> listMes = new PresupuestoDao().getListMeses(query);
            outHash.put("listMes", listMes);
        } else {
            String query = " WHERE mes >= " + desde + " ORDER BY mes " + orden + " ";
            List<Presupuesto> listMes = new PresupuestoDao().getListMeses(query);
            outHash.put("listMes", listMes);
        }

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void DataSemaforoEjecAños(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        LocalDate ld = LocalDate.now();
        int año = ld.getYear();

        String query = "WHERE ano_eje >= '" + (año - 1) + "' GROUP BY ano_eje ORDER BY ano_eje DESC";
        List<Presupuesto> listAños = new PresupuestoDao().getListAños(query);

        HashMap outHash = new HashMap();
        outHash.put("listAños", listAños);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void DataEjecDocuCerti(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String año = request.getParameter("año");
        String ejec = request.getParameter("ejec");
        String tipo = request.getParameter("tipo");

        String query = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND c.etapa = '" + tipo + "' GROUP BY a.cod_doc, b.nombre ORDER BY b.nombre ASC ";
        List<Presupuesto> listDoc = new PresupuestoDao().getListDocuCerti(query);

        HashMap outHash = new HashMap();
        outHash.put("listDoc", listDoc);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void DataPresuAñosDesde(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String sec_ejec = request.getParameter("sec_ejec");

        String query;
        if (sec_ejec.equals("00")) {
            query = "GROUP BY ano_eje ORDER BY ano_eje ASC";
        } else {
            query = "WHERE sec_ejec = '" + sec_ejec + "' GROUP BY ano_eje ORDER BY ano_eje ASC";
        }

        List<Presupuesto> listAñoDesde = new PresupuestoDao().getListAños(query);

        HashMap outHash = new HashMap();
        outHash.put("listAñoDesde", listAñoDesde);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void DataPresuAñosDesdeIngreso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String sec_ejec = request.getParameter("sec_ejec");

        String query;
        if (sec_ejec.equals("00")) {
            query = "GROUP BY ano_eje ORDER BY ano_eje ASC";
        } else {
            query = "WHERE sec_ejec = '" + sec_ejec + "' GROUP BY ano_eje ORDER BY ano_eje ASC";
        }

        List<Presupuesto> listAñoDesde = new PresupuestoDao().getListAñosIngreso(query);

        HashMap outHash = new HashMap();
        outHash.put("listAñoDesde", listAñoDesde);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void DataPresuAñosHasta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String año = request.getParameter("año");

        String query = "WHERE ano_eje >= '" + año + "' GROUP BY ano_eje ORDER BY ano_eje DESC";

        List<Presupuesto> listAñoHasta = new PresupuestoDao().getListAños(query);

        HashMap outHash = new HashMap();
        outHash.put("listAñoHasta", listAñoHasta);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void DataPresuAñosHastaIngreso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String año = request.getParameter("año");

        String query = "WHERE ano_eje >= '" + año + "' GROUP BY ano_eje ORDER BY ano_eje DESC";

        List<Presupuesto> listAñoHasta = new PresupuestoDao().getListAñosIngreso(query);

        HashMap outHash = new HashMap();
        outHash.put("listAñoHasta", listAñoHasta);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void DataFiltros(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String año = request.getParameter("año");
        String ejec = request.getParameter("ejec");
        String val = request.getParameter("val");

        String query;
        List<Presupuesto> list = null;

        if (ejec.equals("00")) {
            query = " WHERE a.ano_eje = '" + año + "' AND a.sec_func != '0000' ";
        } else {
            query = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND a.sec_func != '0000' ";
        }
        if (val.equals("16")) {
            String queryEjec = " WHERE ano_eje = '" + año + "' AND pliego = '459' AND estado = 'A' ORDER BY ejecutora ASC ";
            list = new PresupuestoDao().getListEjecutoras(queryEjec);
        }
        if (val.equals("01")) {
            query += "AND a.estado = 'A' GROUP BY b.programa_ppto, b.nombre ORDER BY b.programa_ppto ASC ";
            list = new PresupuestoDao().getListCategoriaPresupuestal(query);
        }
        if (val.equals("02")) {
            query += "AND a.estado = 'A' GROUP BY b.act_proy, b.nombre ORDER BY b.act_proy ASC ";
            list = new PresupuestoDao().getListProductoProyecto(query);
        }
        if (val.equals("03")) {
            query += "AND a.estado = 'A' GROUP BY b.componente, b.nombre ORDER BY b.componente ASC ";
            list = new PresupuestoDao().getListActividadAccionInvObra(query);
        }
        if (val.equals("04")) {
            query += "AND a.estado = 'A' GROUP BY b.funcion, b.nombre ORDER BY b.funcion ASC ";
            list = new PresupuestoDao().getListFuncion(query);
        }
        if (val.equals("05")) {
            query += "AND a.estado = 'A' ORDER BY a.sec_func ASC ";
            list = new PresupuestoDao().getListMeta(query);
        }
        if (val.equals("06")) {
            query += "AND b.estado = 'A' GROUP BY c.fuente_financ_agregada, c.nombre ORDER BY c.fuente_financ_agregada ASC ";
            list = new PresupuestoDao().getListFuente(query);
        }
        if (val.equals("07")) {
            query += "AND b.estado = 'A' GROUP BY b.fuente_financ, b.nombre ORDER BY b.fuente_financ ASC ";
            list = new PresupuestoDao().getListRubro(query);
        }
        if (val.equals("08")) {
            query += "AND b.estado = 'A' GROUP BY d.categ_gasto, d.nombre ORDER BY d.categ_gasto ASC ";
            list = new PresupuestoDao().getListCategoriaGasto(query);
        }
        if (val.equals("09")) {
            query += "AND b.estado = 'A' GROUP BY c.tipo_transaccion, c.generica, c.clasificador, c.descripcion "
                    + "ORDER BY trim(c.tipo_transaccion)::int, trim(c.generica)::int ASC ";
            list = new PresupuestoDao().getListGenerica(query);
        }
        if (val.equals("10")) {
            query += "AND b.estado = 'A' GROUP BY c.tipo_transaccion, c.generica, c.subgenerica, c.clasificador, c.descripcion "
                    + "ORDER BY trim(c.tipo_transaccion)::int, trim(c.generica)::int, trim(c.subgenerica)::int ASC ";
            list = new PresupuestoDao().getListSubGenerica(query);
        }
        if (val.equals("11")) {
            query += "AND b.estado = 'A' GROUP BY c.tipo_transaccion, c.generica, c.subgenerica, c.subgenerica_det, c.clasificador, c.descripcion "
                    + "ORDER BY trim(c.tipo_transaccion)::int, trim(c.generica)::int, trim(c.subgenerica)::int, trim(c.subgenerica_det)::int ASC ";
            list = new PresupuestoDao().getListSubGenericaDet(query);
        }
        if (val.equals("12")) {
            query += "AND b.estado = 'A' GROUP BY c.tipo_transaccion, c.generica, c.subgenerica, c.subgenerica_det, c.especifica, c.clasificador, c.descripcion "
                    + "ORDER BY trim(c.tipo_transaccion)::int, trim(c.generica)::int, trim(c.subgenerica)::int, trim(c.subgenerica_det)::int, "
                    + "trim(c.especifica)::int ASC ";
            list = new PresupuestoDao().getListEspecifica(query);
        }
        if (val.equals("13")) {
            query += "AND b.estado = 'A' GROUP BY b.tipo_transaccion, b.generica, b.subgenerica, b.subgenerica_det, b.especifica, b.especifica_det, b.clasificador, b.descripcion "
                    + "ORDER BY trim(b.tipo_transaccion)::int, trim(b.generica)::int, trim(b.subgenerica)::int, trim(b.subgenerica_det)::int, "
                    + "trim(b.especifica)::int, trim(b.especifica_det)::int ASC ";
            list = new PresupuestoDao().getListEspecificaDet(query);
        }
        if (val.equals("14")) {
            query += "AND a.estado = 'A' GROUP BY b.provincia, b.nombre ORDER BY b.provincia ASC ";
            list = new PresupuestoDao().getListProvincia(query);
        }
        if (val.equals("18")) {
            query += "AND a.estado = 'A' GROUP BY b.programa, b.nombre ORDER BY b.programa ASC ";
            list = new PresupuestoDao().getListDivFuncion(query);
        }
        if (val.equals("19")) {
            query += "AND a.estado = 'A' GROUP BY b.sub_programa, b.nombre ORDER BY b.sub_programa ASC ";
            list = new PresupuestoDao().getListGrupFuncion(query);
        }
        if (val.equals("22")) {
            query += "AND a.estado = 'A' GROUP BY cc.ceco_id, cc.ceco_codigo, cc.ceco_nombre ORDER BY cc.ceco_codigo ASC ";
            list = new PresupuestoDao().getListCentroCosto(query);
        }

        HashMap outHash = new HashMap();
        outHash.put("list", list);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void DataFiltrosMensual(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String año = request.getParameter("año");
        String ejec = request.getParameter("ejec");
        String val = request.getParameter("val");

        String query;
        List<Presupuesto> list = null;

        if (ejec.equals("00")) {
            query = " WHERE a.ano_eje = '" + año + "' AND a.sec_func != '0000' ";
        } else {
            query = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND a.sec_func != '0000' ";
        }

        if (val.equals("01")) {
            query += "AND a.estado = 'A' GROUP BY b.programa_ppto, b.nombre ORDER BY b.programa_ppto ASC ";
            list = new PresupuestoDao().getListCategoriaPresupuestal(query);
        }
        if (val.equals("02")) {
            query += "AND a.act_proy ilike '2%' AND a.estado = 'A' GROUP BY b.act_proy, b.nombre ORDER BY b.act_proy ASC ";
            list = new PresupuestoDao().getListProductoProyecto(query);
        }
        if (val.equals("03")) {
            query += "AND a.act_proy ilike '3%' AND a.estado = 'A' GROUP BY b.act_proy, b.nombre ORDER BY b.act_proy ASC ";
            list = new PresupuestoDao().getListProductoProyecto(query);
        }
        if (val.equals("04")) {
            query += "AND a.componente ilike '4%' AND a.estado = 'A' GROUP BY b.componente, b.nombre ORDER BY b.componente ASC ";
            list = new PresupuestoDao().getListActividadAccionInvObra(query);
        }
        if (val.equals("05")) {
            query += "AND a.componente ilike '5%' AND a.estado = 'A' GROUP BY b.componente, b.nombre ORDER BY b.componente ASC ";
            list = new PresupuestoDao().getListActividadAccionInvObra(query);
        }
        if (val.equals("06")) {
            query += "AND a.componente ilike '6%' AND a.estado = 'A' GROUP BY b.componente, b.nombre ORDER BY b.componente ASC ";
            list = new PresupuestoDao().getListActividadAccionInvObra(query);
        }
        if (val.equals("07")) {
            query += "AND a.estado = 'A' GROUP BY b.funcion, b.nombre ORDER BY b.funcion ASC ";
            list = new PresupuestoDao().getListFuncion(query);
        }
        if (val.equals("08")) {
            query += "AND a.estado = 'A' ORDER BY a.sec_func ASC ";
            list = new PresupuestoDao().getListMeta(query);
        }
        if (val.equals("09")) {
            query += "AND b.estado = 'A' GROUP BY c.fuente_financ_agregada, c.nombre ORDER BY c.fuente_financ_agregada ASC ";
            list = new PresupuestoDao().getListFuente(query);
        }
        if (val.equals("10")) {
            query += "AND b.estado = 'A' GROUP BY b.fuente_financ, b.nombre ORDER BY b.fuente_financ ASC ";
            list = new PresupuestoDao().getListRubro(query);
        }
        if (val.equals("11")) {
            query += "AND b.estado = 'A' GROUP BY d.categ_gasto, d.nombre ORDER BY d.categ_gasto ASC ";
            list = new PresupuestoDao().getListCategoriaGasto(query);
        }
        if (val.equals("12")) {
            query += "AND b.estado = 'A' GROUP BY c.tipo_transaccion, c.generica, c.clasificador, c.descripcion "
                    + "ORDER BY trim(c.tipo_transaccion)::int, trim(c.generica)::int ASC ";
            list = new PresupuestoDao().getListGenerica(query);
        }
        if (val.equals("13")) {
            query += "AND b.estado = 'A' GROUP BY c.tipo_transaccion, c.generica, c.subgenerica, c.clasificador, c.descripcion "
                    + "ORDER BY trim(c.tipo_transaccion)::int, trim(c.generica)::int, trim(c.subgenerica)::int ASC ";
            list = new PresupuestoDao().getListSubGenerica(query);
        }
        if (val.equals("14")) {
            query += "AND b.estado = 'A' GROUP BY c.tipo_transaccion, c.generica, c.subgenerica, c.subgenerica_det, c.clasificador, c.descripcion "
                    + "ORDER BY trim(c.tipo_transaccion)::int, trim(c.generica)::int, trim(c.subgenerica)::int, trim(c.subgenerica_det)::int ASC ";
            list = new PresupuestoDao().getListSubGenericaDet(query);
        }
        if (val.equals("15")) {
            query += "AND b.estado = 'A' GROUP BY c.tipo_transaccion, c.generica, c.subgenerica, c.subgenerica_det, c.especifica, c.clasificador, c.descripcion "
                    + "ORDER BY trim(c.tipo_transaccion)::int, trim(c.generica)::int, trim(c.subgenerica)::int, trim(c.subgenerica_det)::int, "
                    + "trim(c.especifica)::int ASC ";
            list = new PresupuestoDao().getListEspecifica(query);
        }
        if (val.equals("16")) {
            query += "AND b.estado = 'A' GROUP BY b.tipo_transaccion, b.generica, b.subgenerica, b.subgenerica_det, b.especifica, b.especifica_det, b.clasificador, b.descripcion "
                    + "ORDER BY trim(b.tipo_transaccion)::int, trim(b.generica)::int, trim(b.subgenerica)::int, trim(b.subgenerica_det)::int, "
                    + "trim(b.especifica)::int, trim(b.especifica_det)::int ASC ";
            list = new PresupuestoDao().getListEspecificaDet(query);
        }
        if (val.equals("17")) {
            query += "AND a.estado = 'A' GROUP BY b.provincia, b.nombre ORDER BY b.provincia ASC ";
            list = new PresupuestoDao().getListProvincia(query);
        }
        if (val.equals("18")) {
            query += "AND a.estado = 'A' GROUP BY b.programa, b.nombre ORDER BY b.programa ASC ";
            list = new PresupuestoDao().getListDivFuncion(query);
        }
        if (val.equals("19")) {
            query += "AND a.estado = 'A' GROUP BY b.sub_programa, b.nombre ORDER BY b.sub_programa ASC ";
            list = new PresupuestoDao().getListGrupFuncion(query);
        }
        if (val.equals("22")) {
            query += "AND a.estado = 'A' GROUP BY cc.ceco_id, cc.ceco_codigo, cc.ceco_nombre ORDER BY cc.ceco_codigo ASC ";
            list = new PresupuestoDao().getListCentroCosto(query);
        }

        HashMap outHash = new HashMap();
        outHash.put("list", list);
        outHash.put("val", val);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void DataFiltrosIngreso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String año = request.getParameter("año");
        String ejec = request.getParameter("ejec");
        String val = request.getParameter("val");

        String query;
        List<Presupuesto> list = null;

        if (ejec.equals("00")) {
            query = " WHERE a.ano_eje = '" + año + "' ";
        } else {
            query = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' ";
        }
        if (val.equals("01")) {
            String queryEjec = " WHERE ano_eje = '" + año + "' AND pliego = '459' AND estado = 'A' ORDER BY ejecutora ASC ";
            list = new PresupuestoDao().getListEjecutoras(queryEjec);
        }
        if (val.equals("02")) {
            query += "AND b.estado = 'A' GROUP BY c.fuente_financ_agregada, c.nombre ORDER BY c.fuente_financ_agregada ASC ";
            list = new PresupuestoDao().getListFuenteIngreso(query);
        }
        if (val.equals("03")) {
            query += "AND a.id_clasificador != 'AAAAAAA' AND b.estado = 'A' GROUP BY b.fuente_financ, b.nombre ORDER BY b.fuente_financ ASC ";
            list = new PresupuestoDao().getListRubroIngreso(query);
        }
        if (val.equals("04")) {
            query += "AND a.id_clasificador != 'AAAAAAA' AND b.estado = 'A' GROUP BY d.categoria_ingreso, d.descripcion ORDER BY d.categoria_ingreso ASC ";
            list = new PresupuestoDao().getListCategoriaIngreso(query);
        }
        if (val.equals("05")) {
            query += "AND a.id_clasificador != 'AAAAAAA' AND b.estado = 'A' GROUP BY c.tipo_transaccion, c.generica, c.clasificador, c.descripcion "
                    + "ORDER BY trim(c.tipo_transaccion)::int, trim(c.generica)::int ASC ";
            list = new PresupuestoDao().getListGenericaIngreso(query);
        }
        if (val.equals("06")) {
            query += "AND a.id_clasificador != 'AAAAAAA' AND b.estado = 'A' GROUP BY c.tipo_transaccion, c.generica, c.subgenerica, c.clasificador, c.descripcion "
                    + "ORDER BY trim(c.tipo_transaccion)::int, trim(c.generica)::int, trim(c.subgenerica)::int ASC ";
            list = new PresupuestoDao().getListSubGenericaIngreso(query);
        }
        if (val.equals("07")) {
            query += "AND a.id_clasificador != 'AAAAAAA' AND b.estado = 'A' GROUP BY c.tipo_transaccion, c.generica, c.subgenerica, c.subgenerica_det, c.clasificador, c.descripcion "
                    + "ORDER BY trim(c.tipo_transaccion)::int, trim(c.generica)::int, trim(c.subgenerica)::int, trim(c.subgenerica_det)::int ASC ";
            list = new PresupuestoDao().getListSubGenericaDetIngreso(query);
        }
        if (val.equals("08")) {
            query += "AND a.id_clasificador != 'AAAAAAA' AND b.estado = 'A' GROUP BY c.tipo_transaccion, c.generica, c.subgenerica, c.subgenerica_det, c.especifica, c.clasificador, c.descripcion "
                    + "ORDER BY trim(c.tipo_transaccion)::int, trim(c.generica)::int, trim(c.subgenerica)::int, trim(c.subgenerica_det)::int, "
                    + "trim(c.especifica)::int ASC ";
            list = new PresupuestoDao().getListEspecificaIngreso(query);
        }
        if (val.equals("09")) {
            query += "AND a.id_clasificador != 'AAAAAAA' AND b.estado = 'A' GROUP BY b.tipo_transaccion, b.generica, b.subgenerica, b.subgenerica_det, b.especifica, b.especifica_det, b.clasificador, b.descripcion "
                    + "ORDER BY trim(b.tipo_transaccion)::int, trim(b.generica)::int, trim(b.subgenerica)::int, trim(b.subgenerica_det)::int, "
                    + "trim(b.especifica)::int, trim(b.especifica_det)::int ASC ";
            list = new PresupuestoDao().getListEspecificaDetIngreso(query);
        }
        if (val.equals("10")) {
            query += "AND a.ciclo = 'I' AND a.estado_envio = 'A' GROUP BY b.banco, b.nombre ORDER BY b.banco ASC ";
            list = new PresupuestoDao().getListBanco(query);
        }

        HashMap outHash = new HashMap();
        outHash.put("list", list);
        outHash.put("val", val);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void DataTipoRecurso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String año = request.getParameter("año");
        String ejec = request.getParameter("ejec");
        String[] array = request.getParameterValues("array");
        String ciclo = request.getParameter("ciclo");

        String query;
        List<Presupuesto> list;

        if (ejec.equals("00")) {
            query = " WHERE a.ano_eje = '" + año + "' AND a.ciclo = '" + ciclo + "' AND a.estado_envio = 'A' ";
        } else {
            query = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND a.ciclo = '" + ciclo + "' AND a.estado_envio = 'A' ";
        }

        if (array == null) {
            query += "GROUP BY b.tipo_recurso, b.nombre, fu.fuente_financ_agregada, fu.nombre ORDER BY b.tipo_recurso ASC ";
            list = new PresupuestoDao().getListTipoRecurso(query);
        } else {
            String tipo = "(";
            for (int i = 0; i < array.length; i++) {
                if (i < array.length - 1) {
                    tipo += "fu.fuente_financ_agregada = '" + array[i] + "' OR ";
                } else {
                    tipo += "fu.fuente_financ_agregada = '" + array[i] + "'";
                }
            }
            tipo += ")";
            query += "AND " + tipo + " GROUP BY b.tipo_recurso, b.nombre, fu.fuente_financ_agregada, fu.nombre ORDER BY b.tipo_recurso ASC ";
            list = new PresupuestoDao().getListTipoRecurso(query);
        }

        HashMap outHash = new HashMap();
        outHash.put("list", list);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void DataCuentaCorriente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String año = request.getParameter("año");
        String ejec = request.getParameter("ejec");
        String[] array = request.getParameterValues("array");

        String query;
        List<Presupuesto> list;

        if (ejec.equals("00")) {
            query = " WHERE a.ano_eje = '" + año + "' AND a.ciclo = 'I' AND a.estado_envio = 'A' ";
        } else {
            query = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND a.ciclo = 'I' AND a.estado_envio = 'A' ";
        }

        if (array == null) {
            query += "GROUP BY b.cta_cte, b.nombre, c.banco, c.nombre, a.ano_cta_cte ORDER BY b.cta_cte, c.banco, a.ano_cta_cte ASC ";
            list = new PresupuestoDao().getListCuentaCorriente(query);
        } else {
            String tipo = "(";
            for (int i = 0; i < array.length; i++) {
                if (i < array.length - 1) {
                    tipo += "b.banco = '" + array[i] + "' OR ";
                } else {
                    tipo += "b.banco = '" + array[i] + "'";
                }
            }
            tipo += ")";
            query += "AND " + tipo + " GROUP BY b.cta_cte, b.nombre, c.banco, c.nombre, a.ano_cta_cte ORDER BY b.cta_cte, c.banco, a.ano_cta_cte ASC ";
            list = new PresupuestoDao().getListCuentaCorriente(query);
        }

        HashMap outHash = new HashMap();
        outHash.put("list", list);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void DataDistrito(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String año = request.getParameter("año");
        String ejec = request.getParameter("ejec");
        String[] array = request.getParameterValues("array");

        String query;
        List<Presupuesto> list;

        if (ejec.equals("00")) {
            query = " WHERE a.ano_eje = '" + año + "' AND a.sec_func != '0000' ";
        } else {
            query = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND a.sec_func != '0000' ";
        }

        if (array == null) {
            query += " AND a.estado = 'A' GROUP BY b.distrito, b.nombre ORDER BY b.distrito ASC ";
            list = new PresupuestoDao().getListDistrito(query);
        } else {
            String provincia = "(";
            for (int i = 0; i < array.length; i++) {
                if (i < array.length - 1) {
                    provincia += "b.provincia = '" + array[i] + "' OR ";
                } else {
                    provincia += "b.provincia = '" + array[i] + "'";
                }
            }
            provincia += ")";
            query += "AND " + provincia + " AND a.estado = 'A' GROUP BY b.distrito, b.nombre ORDER BY b.distrito ASC ";
            list = new PresupuestoDao().getListDistrito(query);
        }

        HashMap outHash = new HashMap();
        outHash.put("list", list);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void DataFiltrosMensualIngreso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String año = request.getParameter("año");
        String ejec = request.getParameter("ejec");
        String val = request.getParameter("val");

        String query;
        List<Presupuesto> list = null;

        if (ejec.equals("00")) {
            query = " WHERE a.ano_eje = '" + año + "' ";
        } else {
            query = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' ";
        }

        if (val.equals("01")) {
            query += "AND b.estado = 'A' GROUP BY c.fuente_financ_agregada, c.nombre ORDER BY c.fuente_financ_agregada ASC ";
            list = new PresupuestoDao().getListFuenteIngreso(query);
        }
        if (val.equals("02")) {
            query += "AND a.id_clasificador != 'AAAAAAA' AND b.estado = 'A' GROUP BY b.fuente_financ, b.nombre ORDER BY b.fuente_financ ASC ";
            list = new PresupuestoDao().getListRubroIngreso(query);
        }
        if (val.equals("03")) {
            query += "AND a.id_clasificador != 'AAAAAAA' AND b.estado = 'A' GROUP BY d.categoria_ingreso, d.descripcion ORDER BY d.categoria_ingreso ASC ";
            list = new PresupuestoDao().getListCategoriaIngreso(query);
        }
        if (val.equals("04")) {
            query += "AND a.id_clasificador != 'AAAAAAA' AND b.estado = 'A' GROUP BY c.tipo_transaccion, c.generica, c.clasificador, c.descripcion "
                    + "ORDER BY trim(c.tipo_transaccion)::int, trim(c.generica)::int ASC ";
            list = new PresupuestoDao().getListGenericaIngreso(query);
        }
        if (val.equals("05")) {
            query += "AND a.id_clasificador != 'AAAAAAA' AND b.estado = 'A' GROUP BY c.tipo_transaccion, c.generica, c.subgenerica, c.clasificador, c.descripcion "
                    + "ORDER BY trim(c.tipo_transaccion)::int, trim(c.generica)::int, trim(c.subgenerica)::int ASC ";
            list = new PresupuestoDao().getListSubGenericaIngreso(query);
        }
        if (val.equals("06")) {
            query += "AND a.id_clasificador != 'AAAAAAA' AND b.estado = 'A' GROUP BY c.tipo_transaccion, c.generica, c.subgenerica, c.subgenerica_det, c.clasificador, c.descripcion "
                    + "ORDER BY trim(c.tipo_transaccion)::int, trim(c.generica)::int, trim(c.subgenerica)::int, trim(c.subgenerica_det)::int ASC ";
            list = new PresupuestoDao().getListSubGenericaDetIngreso(query);
        }
        if (val.equals("07")) {
            query += "AND a.id_clasificador != 'AAAAAAA' AND b.estado = 'A' GROUP BY c.tipo_transaccion, c.generica, c.subgenerica, c.subgenerica_det, c.especifica, c.clasificador, c.descripcion "
                    + "ORDER BY trim(c.tipo_transaccion)::int, trim(c.generica)::int, trim(c.subgenerica)::int, trim(c.subgenerica_det)::int, "
                    + "trim(c.especifica)::int ASC ";
            list = new PresupuestoDao().getListEspecificaIngreso(query);
        }
        if (val.equals("08")) {
            query += "AND a.id_clasificador != 'AAAAAAA' AND b.estado = 'A' GROUP BY b.tipo_transaccion, b.generica, b.subgenerica, b.subgenerica_det, b.especifica, b.especifica_det, b.clasificador, b.descripcion "
                    + "ORDER BY trim(b.tipo_transaccion)::int, trim(b.generica)::int, trim(b.subgenerica)::int, trim(b.subgenerica_det)::int, "
                    + "trim(b.especifica)::int, trim(b.especifica_det)::int ASC ";
            list = new PresupuestoDao().getListEspecificaDetIngreso(query);
        }
        if (val.equals("09")) {
            query += "AND a.ciclo = 'I' AND a.estado_envio = 'A' GROUP BY b.banco, b.nombre ORDER BY b.banco ASC ";
            list = new PresupuestoDao().getListBanco(query);
        }
        if (val.equals("10")) {
            query += "AND a.ciclo = 'I' AND a.estado_envio = 'A' GROUP BY b.tipo_recurso, b.nombre, fu.fuente_financ_agregada, fu.nombre "
                    + "ORDER BY b.tipo_recurso ASC ";
            list = new PresupuestoDao().getListTipoRecurso(query);
        }
        if (val.equals("11")) {
            query += "AND a.ciclo = 'I' AND a.estado_envio = 'A' GROUP BY b.cta_cte, b.nombre, c.banco, c.nombre, a.ano_cta_cte "
                    + "ORDER BY b.cta_cte, c.banco, a.ano_cta_cte ASC ";
            list = new PresupuestoDao().getListCuentaCorriente(query);
        }

        HashMap outHash = new HashMap();
        outHash.put("list", list);
        outHash.put("val", val);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void DataUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        LocalDate ld = LocalDate.now();
        int ano_actual = ld.getYear();

        List<Usuario> listUsuarios = new UsuarioDao().getListaUsuarios("AND c.ano_eje='" + ano_actual + "' AND c.estado = 'A'");
        HashMap outHash = new HashMap();
        outHash.put("listUsuarios", listUsuarios);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void DataPerfiles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String queryP = "ORDER BY menu_id ASC";
        List<Usuario> listMenu = new UsuarioDao().getListMenu(queryP);

        String query = "ORDER BY perf_nombre ASC";
        List<Usuario> listPerfiles = new UsuarioDao().getListaPerfiles(query);

        HashMap outHash = new HashMap();
        outHash.put("listMenu", listMenu);
        outHash.put("listPerfiles", listPerfiles);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void DataPermisos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String perf_id = request.getParameter("perf_id");
        String menu_id = request.getParameter("menu_id") == null ? "" : request.getParameter("menu_id");

        HashMap outHash = new HashMap();

        if (menu_id.equals("")) {
            String query = " WHERE a.perf_id =" + perf_id + " ORDER BY a.menu_id ASC";
            List<Usuario> list = new UsuarioDao().getListaPermisos(query);

            outHash.put("listPermisos", list);
            outHash.put("id", perf_id);

        } else {
            String query = " WHERE a.perf_id =" + perf_id + " AND a.menu_id =" + menu_id;
            List<Usuario> list = new UsuarioDao().getListaPermisos(query);

            outHash.put("perf_id", perf_id);
            outHash.put("menu_id", menu_id);
            outHash.put("registra", list.get(0).getRegistra());
            outHash.put("activo", list.get(0).getActivo());
        }

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void DataEditUsua(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String query = " WHERE usua_id =" + request.getParameter("id");
        Usuario dataU = new UsuarioDao().getDatos(query);

        HashMap outHash = new HashMap();
        outHash.put("nombres", dataU.getUsuaNombres());
        outHash.put("paterno", dataU.getUsuaApellidoPaterno());
        outHash.put("materno", dataU.getUsuaApellidoMaterno());
        outHash.put("dni", dataU.getUsuaLogin());
        outHash.put("password", dataU.getUsuaClave());
        outHash.put("sexo", dataU.getUsuaSexo());
        outHash.put("perfil", dataU.getPerfId());
        outHash.put("estado", dataU.getUsuaEstado());
        outHash.put("ejec", dataU.getSec_ejec());

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void DataEditCeco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String ceco_id = request.getParameter("id");

        String query = " WHERE ceco_id = " + ceco_id;
        List<Presupuesto> list = new PresupuestoDao().getCentroCosto(query);

        HashMap outHash = new HashMap();
        outHash.put("ceco_codigo", list.get(0).getCeco_codigo());
        outHash.put("ceco_nombre", list.get(0).getCeco_nombre());
        outHash.put("sec_ejec", list.get(0).getSec_ejec());
        outHash.put("ceco_estado", list.get(0).getCeco_estado());

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void DataEditMetaCeco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String ejec = request.getParameter("ejec");
        String ano = request.getParameter("ano");
        String sec_func = request.getParameter("sec_func");

        String query = " WHERE m.ano_eje = '" + ano + "' AND m.sec_ejec = '" + ejec + "' AND m.sec_func = '" + sec_func + "' AND m.estado = 'A' ORDER BY m.sec_func ASC ";
        List<Presupuesto> list = new PresupuestoDao().getMetaCentroCosto(query);

        HashMap outHash = new HashMap();
        outHash.put("meta", list.get(0).getSec_func());
        outHash.put("finalidad", list.get(0).getDescripcion());
        outHash.put("ejec", ejec);
        outHash.put("id", list.get(0).getCeco_id());

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void DataEditPerfil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String perf_id = request.getParameter("id");

        String query = " WHERE perf_id = " + perf_id;
        List<Usuario> list = new UsuarioDao().getListaPerfiles(query);

        HashMap outHash = new HashMap();
        outHash.put("id", perf_id);
        outHash.put("perfil", list.get(0).getPerfNombre());
        outHash.put("descripcion", list.get(0).getPerfDescripcion());

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void DataMonitor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String queryN = " WHERE s.sesi_navega = true AND s.sesi_login = false ORDER BY s.sesi_inicio_navega DESC ";
        String queryL = " WHERE s.sesi_login = true ORDER BY s.sesi_inicio_login DESC ";
        List<Sesion> listSesionN = new SesionDao().getNavegaActivos(queryN);
        List<Sesion> listSesionL = new SesionDao().getLoginActivos(queryL);

        HashMap outHash = new HashMap();
        outHash.put("navegando", listSesionN.size());
        outHash.put("logueados", listSesionL.size());

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void DataMonitorNavega(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String query = " WHERE s.sesi_navega = true AND s.sesi_login = false ORDER BY s.sesi_inicio_navega DESC ";
        List<Sesion> listSesionN = new SesionDao().getNavegaActivos(query);

        HashMap outHash = new HashMap();
        outHash.put("listSesionN", listSesionN);

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm:sss").create();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void DataMonitorLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String query = " WHERE s.sesi_login = true ORDER BY s.sesi_inicio_login DESC ";
        List<Sesion> listSesionL = new SesionDao().getLoginActivos(query);

        HashMap outHash = new HashMap();
        outHash.put("listSesionL", listSesionL);

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm:ss").create();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void DataMonitorHistoLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String desde = request.getParameter("desde");
        String hasta = request.getParameter("hasta");

        String query = " WHERE s.sesi_inicio_login is not null AND "
                + "cast(s.sesi_inicio_login as date) >= cast('" + desde + "' as date) AND "
                + "cast(s.sesi_inicio_login as date) <= cast('" + hasta + "' as date) "
                + "ORDER BY s.sesi_inicio_login DESC ";
        List<Sesion> listSesionL = new SesionDao().getLoginActivos(query);

        HashMap outHash = new HashMap();
        outHash.put("listSesionL", listSesionL);

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm:ss").create();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void DataSincronizaEjecutoras(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String fecha = request.getParameter("fecha");
        HashMap outHash = new HashMap();

        String pliego = ConexionReporte.obtenerPropiedad("pliego");

        String queryA = "WHERE ano_eje = date_part('year', cast('" + fecha + "' as date))::text GROUP BY sec_ejec";
        String queryB = "WHERE ano_eje = date_part('year', cast('" + fecha + "' as date))::text AND pliego = '" + pliego + "' AND estado = 'A'";
        String queryC = "WHERE cast(fecha_hora as date) = cast('" + fecha + "' as date) GROUP BY cast(fecha_hora as date), sec_ejec";
        String queryD = "ORDER BY b.ejecutora ASC";
        List<Sincronizacion> list = new SincronizacionDao().getMonitorEjecutoras(queryA, queryB, queryC, queryD);
        outHash.put("list", list);

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void DataSincronizaUltimaFecha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String sec_ejec = request.getParameter("sec_ejec");

        String query = "WHERE sec_ejec = '" + sec_ejec + "' AND sincronizo = 'SI' ORDER BY fecha_hora DESC LIMIT 1";
        List<Sincronizacion> list = new SincronizacionDao().getMonitorTablas(query);

        HashMap outHash = new HashMap();
        outHash.put("fecha_hora", list.get(0).getFechaHora());
        outHash.put("ejec", sec_ejec);

        Gson gson = new GsonBuilder().setDateFormat("EEEE, dd/MM/yyyy HH:mm:ss").create();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void DataSincronizaTablas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String sec_ejec = request.getParameter("ejec");
        String fecha = request.getParameter("fecha");
        String ejecutora = request.getParameter("ejecutora");

        String query = "WHERE sec_ejec = '" + sec_ejec + "' AND cast(fecha_hora as date) = cast('" + fecha + "' as date) ORDER BY fecha_hora DESC";
        List<Sincronizacion> list = new SincronizacionDao().getMonitorTablas(query);

        HashMap outHash = new HashMap();
        outHash.put("list", list);
        outHash.put("ejecutora", ejecutora);
        outHash.put("sec_ejec", sec_ejec);

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm:ss").create();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void DataNotasTipo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String año = request.getParameter("año");

        String query = " WHERE a.ano_eje = '" + año + "' GROUP BY a.tipo_modificacion, b.timo_nombre ORDER BY a.tipo_modificacion ASC ";
        List<Presupuesto> list = new PresupuestoDao().getListNotasTipo(query);

        HashMap outHash = new HashMap();
        outHash.put("list", list);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void DataNotasRubro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String año = request.getParameter("año");
        String ciclo = request.getParameter("ciclo");

        HashMap outHash = new HashMap();

        String query = " WHERE a.ano_eje = '" + año + "' AND b.estado = 'A' GROUP BY a.fuente_financ, b.nombre ORDER BY a.fuente_financ ASC ";

        if (ciclo.equals("G")) {
            List<Presupuesto> list = new PresupuestoDao().getListNotasRubroGasto(query);
            outHash.put("list", list);
        }
        if (ciclo.equals("I")) {
            List<Presupuesto> list = new PresupuestoDao().getListNotasRubroIngreso(query);
            outHash.put("list", list);
        }

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void DataNotaDetalle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String ejec = request.getParameter("ejec");
        String año = request.getParameter("año");
        String nota = request.getParameter("nota");
        String num_doc = request.getParameter("num_doc");
        String cod_doc = request.getParameter("cod_doc");

        HashMap outHash = new HashMap();

        String queryG = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND a.sec_nota = '" + nota + "' "
                + "ORDER BY a.sec_func, a.fuente_financ, cg.categ_gasto, trim(ed.tipo_transaccion)::int, trim(ed.generica)::int, "
                + "trim(ed.subgenerica)::int, trim(ed.subgenerica_det)::int, trim(ed.especifica)::int, trim(ed.especifica_det)::int ASC";
        List<Presupuesto> listG = new PresupuestoDao().getNotaDetalleGasto(queryG);
        outHash.put("listG", listG);

        String queryI = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND a.sec_nota = '" + nota + "' "
                + "ORDER BY a.fuente_financ, ci.categoria_ingreso, trim(ed.tipo_transaccion)::int, trim(ed.generica)::int, trim(ed.subgenerica)::int, "
                + "trim(ed.subgenerica_det)::int, trim(ed.especifica)::int, trim(ed.especifica_det)::int ASC";
        List<Presupuesto> listI = new PresupuestoDao().getNotaDetalleIngreso(queryI);

        if (listI.isEmpty()) {
            outHash.put("ingreso", false);
        } else {
            outHash.put("ingreso", true);
            outHash.put("listI", listI);
        }

        String[] sinNumero = num_doc.split("-");
        if (sinNumero[0].trim().equals("S/N")) {
            outHash.put("connumero", false);
        } else {
            outHash.put("connumero", true);
        }

        String queryUE = " WHERE a.ano_eje = '" + año + "' AND b.cod_doc = '" + cod_doc + "' AND b.num_doc ilike '%" + num_doc + "%' "
                + "GROUP BY a.sec_ejec, ej.ejecutora, ej.nombre, a.sec_nota ORDER BY ej.ejecutora ASC ";
        List<Presupuesto> listUE = new PresupuestoDao().getNotaDetalleEjecutoras(queryUE);
        outHash.put("listUE", listUE);

        outHash.put("año", año);
        outHash.put("ejec", ejec);

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void DetalleExpeSIAFFase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String ejec = request.getParameter("ejec");
        String año = request.getParameter("año");
        String expe = request.getParameter("expe");

        HashMap outHash = new HashMap();

        String query = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND a.expediente = '" + expe + "' "
                + "ORDER BY a.ano_eje, a.sec_ejec, a.expediente, a.secuencia, a.correlativo ASC ";
        List<Presupuesto> listEXF = new PresupuestoDao().getDetalleExpeSIAFFase(query);

        String queryG = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND a.expediente = '" + expe + "' ORDER BY a.secuencia ASC ";
        String queryI = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND a.expediente = '" + expe + "' ORDER BY a.secuencia ASC ";
        List<Presupuesto> listEXFG = new PresupuestoDao().getDetalleExpeSIAFFaseGasto(queryG);
        List<Presupuesto> listEXFI = new PresupuestoDao().getDetalleExpeSIAFFaseIngreso(queryI);

        String gasto;
        if (listEXFG.isEmpty()) {
            gasto = "0";
        } else {
            gasto = "1";
            outHash.put("listEXFG", listEXFG);
        }
        String ingreso;
        if (listEXFI.isEmpty()) {
            ingreso = "0";
        } else {
            ingreso = "1";
            outHash.put("listEXFI", listEXFI);
        }
        outHash.put("listEXF", listEXF);
        outHash.put("gasto", gasto);
        outHash.put("ingreso", ingreso);
        outHash.put("expe", expe);

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void DataAnosRegProy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        LocalDate ld = LocalDate.now();
        int ano_actual = ld.getYear();
        int ano_inicial = 2003;
        int[] array = new int[(ano_actual - ano_inicial) + 1];

        for (int i = ano_actual; i >= ano_inicial; i--) {
            array[ano_actual - i] = i;
        }

        HashMap outHash = new HashMap();
        outHash.put("arrayAnos", array);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void DataMeses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        LocalDate ld = LocalDate.now();
        int mes_actual = ld.getMonthValue();

        String query = " ORDER BY mes ASC ";
        List<Presupuesto> list = new PresupuestoDao().getListMeses(query);

        HashMap outHash = new HashMap();
        outHash.put("index", mes_actual - 1);
        outHash.put("listMeses", list);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
