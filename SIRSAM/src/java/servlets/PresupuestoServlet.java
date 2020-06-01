package servlets;

import beans.Presupuesto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import daos.PresupuestoDao;
import java.awt.Color;
import java.awt.Paint;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * @author CARLOS SANTANDER
 */
@WebServlet(name = "PresupuestoServlet", urlPatterns = {"/Presupuesto"})
public class PresupuestoServlet extends HttpServlet {

    String pliego = "459";

    JFreeChartServlet chart = new JFreeChartServlet();

    Paint blanco = Color.WHITE;
    Paint negro = Color.BLACK;
    Paint semi_negro = new Color(51, 51, 51);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String tipo = request.getParameter("tipo") == null ? "" : request.getParameter("tipo");

        OUTER:
        switch (tipo) {
            case "01":
                gasto_historico(request, response);
                break;
            case "02":
                String graphG = request.getParameter("graph") == null ? "" : request.getParameter("graph");
                if (graphG.equals("true")) {
                    gasto_mensualizado_grafica(request, response);
                    break;
                } else {
                    gasto_anual(request, response);
                    break;
                }
            case "03":
                String filtC = request.getParameter("filtro_princ");
                switch (filtC) {
                    case "00":
                        certificaciones_consolidado(request, response);
                        break OUTER;
                    case "01":
                        certificacion_detallada(request, response);
                        break OUTER;
                    case "02":
                        certificacion_historial(request, response);
                        break OUTER;
                    case "03":
                        certificacion_estado(request, response);
                        break OUTER;
                    case "04":
                        certificacion_por_documento(request, response);
                        break OUTER;
                    default:
                        certificaciones(request, response);
                        break OUTER;
                }
            case "04":
                expedientes_lista(request, response);
                break;
            case "05":
                notas_modificatorias(request, response);
                break;
            case "06":
                ingreso_historico(request, response);
                break;
            case "07":
                String graphI = request.getParameter("graph") == null ? "" : request.getParameter("graph");
                if (graphI.equals("true")) {
                    ingreso_mensualizado_grafica(request, response);
                    break;
                } else {
                    ingreso_anual(request, response);
                    break;
                }
            case "10":
                String model = request.getParameter("model");
                if (model.equals("grafica1")) {
                    resumen_ejecucion_grafica1(request, response);
                    break;
                }
                if (model.equals("grafica2")) {
                    resumen_ejecucion_grafica2(request, response);
                    break;
                }
                if (model.equals("grafica3")) {
                    resumen_ejecucion_grafica3(request, response);
                    break;
                }
                if (model.equals("grafica4")) {
                    resumen_ejecucion_grafica4(request, response);
                    break;
                }
                if (model.equals("grafica5")) {
                    resumen_ejecucion_grafica5(request, response);
                    break;
                }
                if (model.equals("grafica6")) {
                    resumen_ejecucion_grafica6(request, response);
                    break;
                }
                if (model.equals("tablas")) {
                    resumen_ejecucion_tablas(request, response);
                    break;
                }
            case "11_1":
                semaforo_tabla(request, response);
                break;
            case "11_2":
                semaforo_grafica(request, response);
                break;
            case "nuevo_centro":
                nuevo_centro(request, response);
                break;
            case "editar_centro":
                editar_centro(request, response);
                break;
            case "eliminar_centro":
                eliminar_centro(request, response);
                break;
            case "editar_meta_centro":
                editar_meta_centro(request, response);
                break;
        }

    }

    private BigDecimal porcentaje(BigDecimal numerador, BigDecimal denominador) {
        if (denominador == BigDecimal.ZERO) {
            return new BigDecimal(0).setScale(2);
        } else {
            BigDecimal div = numerador.divide(denominador, 4, BigDecimal.ROUND_HALF_EVEN);
            return div.multiply(new BigDecimal(100)).setScale(2);
        }
    }

    private BigDecimal millones(BigDecimal bd) {
        bd = bd.divide(new BigDecimal(1000000), 2, BigDecimal.ROUND_HALF_EVEN);
        return bd;
    }

    private BigDecimal miles(BigDecimal bd) {
        bd = bd.divide(new BigDecimal(1000), 2, BigDecimal.ROUND_HALF_EVEN);
        return bd;
    }

    private void gasto_historico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String graph = request.getParameter("graph") == null ? "" : request.getParameter("graph");
        String sec_ejec = request.getParameter("ejec");
        String año_desde = request.getParameter("desde");
        String año_hasta = request.getParameter("hasta");
        String pdf = request.getParameter("pdf") == null ? "" : request.getParameter("pdf");

        String query;
        String titulo, tituloPDF;
        List<Presupuesto> list;
        if (sec_ejec.equals("00")) {
            query = "WHERE (ano_eje >= '" + año_desde + "' AND ano_eje <= '" + año_hasta + "') GROUP BY ano_eje ORDER BY ano_eje ASC";
            list = new PresupuestoDao().getHistorico(query);
            titulo = " Pliego " + pliego + " - Gobierno Regional San Martin - Ejecución Histórica";
            tituloPDF = "Pliego " + pliego + " - Gobierno Regional San Martin";
        } else {
            query = " WHERE a.sec_ejec = '" + sec_ejec + "' AND (a.ano_eje >= '" + año_desde + "' AND a.ano_eje <= '" + año_hasta + "') ORDER BY a.ano_eje ASC ";
            list = new PresupuestoDao().getEjecutoraHistorico(query);
            String[] nombre_ejec = list.get(0).getNombre().split("-");
            titulo = "UE " + list.get(0).getEjecutora().trim() + " - "
                    + nombre_ejec[1].trim() + " (" + list.get(0).getSec_ejec().trim() + ") - Ejecución Histórica";
            tituloPDF = "UE " + list.get(0).getEjecutora().trim() + " - " + nombre_ejec[1].trim() + " (" + list.get(0).getSec_ejec().trim() + ")";
        }

        if (graph.equals("true")) {
            String tituloX = "Año de Ejecución";
            String tituloY = "Ejecución de Gasto (En millones de S/)";
            String formato = "png";
            int ancho = Integer.parseInt(request.getParameter("ancho"));
            int alto = Integer.parseInt(request.getParameter("alto"));
            int font_size = Integer.parseInt(request.getParameter("font"));
            double bar_width = Double.parseDouble(request.getParameter("bar"));
            String posicion = request.getParameter("pos");
            String pia = request.getParameter("pia");
            String pim = request.getParameter("pim");
            String fase = request.getParameter("fase").equals("CompromisoAnual") ? "Compromiso Anual" : request.getParameter("fase");
            DefaultCategoryDataset objDataset = new DefaultCategoryDataset();
            DefaultCategoryDataset objDataset2 = new DefaultCategoryDataset();
            DefaultCategoryDataset dataLine = new DefaultCategoryDataset();
            BigDecimal numeric = BigDecimal.ZERO;
            for (Presupuesto datos : list) {
                if (fase.equals("Certificado")) {
                    numeric = datos.getCertificado();
                }
                if (fase.equals("Compromiso Anual")) {
                    numeric = datos.getCompromiso_anual();
                }
                if (fase.equals("Compromiso")) {
                    numeric = datos.getCompromiso();
                }
                if (fase.equals("Devengado")) {
                    numeric = datos.getEjecucion();
                }
                if (fase.equals("Girado")) {
                    numeric = datos.getGirado();
                }
                if (fase.equals("Pagado")) {
                    numeric = datos.getPagado();
                }
                String año = datos.getAno_eje();
                if (pia.equals("si")) {
                    objDataset.setValue(millones(datos.getPia()), "PIA", año);
                }
                if (pim.equals("si")) {
                    objDataset.setValue(millones(datos.getPim()), "PIM", año);
                }
                String op = porcentaje(numeric, datos.getPim()) + "";
                objDataset.setValue(millones(numeric), fase, año);
                objDataset2.setValue(millones(numeric), op, año);
                dataLine.setValue(millones(numeric), "Tendencia", año);
            }
            if (pia.equals("no") && pim.equals("no")) {
                String[] Leyenda = new String[1];
                if (pdf.equals("si")) {
                    chart.barraLineV_2D_pdf(request, response, objDataset, dataLine, Leyenda, "", tituloX, "Ejecución (millones S/)", 950, 400, 9, 0.10, formato, blanco, blanco, "in");
                } else {
                    chart.barraLineV_2D(request, response, objDataset, dataLine, Leyenda, titulo, tituloX, tituloY, ancho, alto, font_size, bar_width, formato, blanco, blanco, posicion);
                }
            } else {
                String[] Leyenda = new String[2];
                if (pia.equals("si") && pim.equals("si")) {
                    Leyenda = new String[3];
                }
                if (pdf.equals("si")) {
                    chart.barraSimpleV_2D_pdf(request, response, objDataset, Leyenda, "", tituloX, "Ejecución (millones S/)", 950, 400, 8, 0.10, formato, blanco, blanco, "in");
                } else {
                    chart.barraSimpleV_2D(request, response, objDataset, Leyenda, titulo, tituloX, tituloY, ancho, alto, font_size, bar_width, formato, blanco, blanco, posicion);
                }
            }
        } else {
            HashMap outHash = new HashMap();
            outHash.put("list", list);
            outHash.put("ejec", sec_ejec);
            outHash.put("desde", año_desde);
            outHash.put("hasta", año_hasta);
            outHash.put("titulo", titulo.toUpperCase());
            outHash.put("tituloPDF", tituloPDF);

            Gson gson = new Gson();
            String arg = gson.toJson(outHash);
            response.getWriter().print(arg);
        }

    }

    private String concatenado(String filtro, String valor, String[] array) {
        String concatenado;
        int n = array.length;
        if (filtro.equals("algunos")) {
            concatenado = "AND (";
            for (int i = 0; i < n; i++) {
                if (i != (n - 1)) {
                    concatenado += valor + " = '" + array[i] + "' OR ";
                } else {
                    concatenado += valor + " = '" + array[i] + "') ";
                }
            }
        } else {
            concatenado = "";
        }
        return concatenado;
    }

    private String concatenado2(String filtro, String valor1, String valor2, String[] array) {
        String concatenado;
        int n = array.length;
        if (filtro.equals("algunos")) {
            concatenado = "AND ( ";
            for (int i = 0; i < n; i++) {
                String[] valor = array[i].split("-");
                if (i != (n - 1)) {
                    concatenado += "(" + valor1 + " = '" + valor[0] + "' AND " + valor2 + " = '" + valor[1] + "') OR ";
                } else {
                    concatenado += "(" + valor1 + " = '" + valor[0] + "' AND " + valor2 + " = '" + valor[1] + "') ) ";
                }
            }
        } else {
            concatenado = "";
        }
        return concatenado;
    }

    private void gasto_anual(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String ejec = request.getParameter("ejec");
        String año = request.getParameter("anho");
        String filtP = request.getParameter("filtro_princ");

        if (filtP.equals("15")) { // Ejecución de Gasto Mensualizada

            String tituloPDF;
            String query = "";
            String tipo = "";

            if (ejec.equals("00")) {
                query += " a.ano_eje = '" + año + "' ";
                tituloPDF = "Pliego " + pliego + " - Gobierno Regional San Martin";
            } else {
                query += " a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' ";
                String queryE = " WHERE ano_eje = '" + año + "' AND sec_ejec = '" + ejec + "' AND pliego = '" + pliego + "' ";
                Presupuesto data = new PresupuestoDao().getEjecutora(queryE);
                String[] nombre_ejec = data.getNombre().split("-");
                tituloPDF = "UE " + data.getEjecutora().trim() + " - " + nombre_ejec[1].trim() + " (" + ejec + ")";
            }

            List<Presupuesto> list = null;

            if (request.getParameter("filtroMensual_ninguno") != null) {
                query += "";
                list = new PresupuestoDao().getEjecucionMensualizada(query);
                tipo = "00";
            }
            if (request.getParameter("filtroMensual_catppto") != null) { // Categoría Presupuestal
                String[] filtroM = request.getParameterValues("filtro_01");
                query += " AND cp.programa_ppto = '" + filtroM[0] + "' ";
                list = new PresupuestoDao().getEjecucionMensualizada(query);
                tipo = "01";
            }
            if (request.getParameter("filtroMensual_proyecto") != null) { // Proyecto
                String[] filtroM = request.getParameterValues("filtro_02");
                query += " AND ap.act_proy = '" + filtroM[0] + "' ";
                list = new PresupuestoDao().getEjecucionMensualizada(query);
                tipo = "02";
            }
            if (request.getParameter("filtroMensual_producto") != null) { // Producto
                String[] filtroM = request.getParameterValues("filtro_03");
                query += " AND ap.act_proy = '" + filtroM[0] + "' ";
                list = new PresupuestoDao().getEjecucionMensualizada(query);
                tipo = "03";
            }
            if (request.getParameter("filtroMensual_actividad") != null) { // Actividad             
                String[] filtroM = request.getParameterValues("filtro_04");
                query += " AND co.componente = '" + filtroM[0] + "' ";
                list = new PresupuestoDao().getEjecucionMensualizada(query);
                tipo = "04";
            }
            if (request.getParameter("filtroMensual_accion") != null) { // Acción dee Inversión               
                String[] filtroM = request.getParameterValues("filtro_05");
                query += " AND co.componente = '" + filtroM[0] + "' ";
                list = new PresupuestoDao().getEjecucionMensualizada(query);
                tipo = "05";
            }
            if (request.getParameter("filtroMensual_obra") != null) { // Obra               
                String[] filtroM = request.getParameterValues("filtro_06");
                query += " AND co.componente = '" + filtroM[0] + "' ";
                list = new PresupuestoDao().getEjecucionMensualizada(query);
                tipo = "06";
            }
            if (request.getParameter("filtroMensual_funcion") != null) { // Función
                String[] filtroM = request.getParameterValues("filtro_07");
                query += " AND fn.funcion = '" + filtroM[0] + "' ";
                list = new PresupuestoDao().getEjecucionMensualizada(query);
                tipo = "07";
            }
            if (request.getParameter("filtroMensual_meta") != null) { // Meta Presupuestaria
                String[] filtroM = request.getParameterValues("filtro_08");
                query += " AND m.sec_func = '" + filtroM[0] + "' ";
                list = new PresupuestoDao().getEjecucionMensualizada(query);
                tipo = "08";
            }
            if (request.getParameter("filtroMensual_fuente") != null) { // Fuente de Financiamiento
                String[] filtroM = request.getParameterValues("filtro_09");
                query += " AND fu.fuente_financ_agregada = '" + filtroM[0] + "' ";
                list = new PresupuestoDao().getEjecucionMensualizada(query);
                tipo = "09";
            }
            if (request.getParameter("filtroMensual_rubro") != null) { // Rubro de Financiamiento
                String[] filtroM = request.getParameterValues("filtro_10");
                query += " AND ru.fuente_financ = '" + filtroM[0] + "' ";
                list = new PresupuestoDao().getEjecucionMensualizada(query);
                tipo = "10";
            }
            if (request.getParameter("filtroMensual_catgasto") != null) {  // Categoría de Gasto
                String[] filtroM = request.getParameterValues("filtro_11");
                query += " AND cg.categ_gasto = '" + filtroM[0] + "' ";
                list = new PresupuestoDao().getEjecucionMensualizada(query);
                tipo = "11";
            }
            if (request.getParameter("filtroMensual_generica") != null) { // Genérica de Gasto
                String[] filtroM = request.getParameterValues("filtro_12");
                query += " AND ge.clasificador = '" + filtroM[0] + "' ";
                list = new PresupuestoDao().getEjecucionMensualizada(query);
                tipo = "12";
            }
            if (request.getParameter("filtroMensual_subgenerica") != null) { // Sub Genérica de Gasto
                String[] filtroM = request.getParameterValues("filtro_13");
                query += " AND sg.clasificador = '" + filtroM[0] + "' ";
                list = new PresupuestoDao().getEjecucionMensualizada(query);
                tipo = "13";
            }
            if (request.getParameter("filtroMensual_subgenericadet") != null) { // Sub Genérica Detallada de Gasto
                String[] filtroM = request.getParameterValues("filtro_14");
                query += " AND sgd.clasificador = '" + filtroM[0] + "' ";
                list = new PresupuestoDao().getEjecucionMensualizada(query);
                tipo = "14";
            }
            if (request.getParameter("filtroMensual_especifica") != null) { // Especifica de Gasto
                String[] filtroM = request.getParameterValues("filtro_15");
                query += " AND es.clasificador = '" + filtroM[0] + "' ";
                list = new PresupuestoDao().getEjecucionMensualizada(query);
                tipo = "15";
            }
            if (request.getParameter("filtroMensual_especificadet") != null) { // Especifica Detallada de Gasto
                String[] filtroM = request.getParameterValues("filtro_16");
                query += " AND ed.clasificador = '" + filtroM[0] + "' ";
                list = new PresupuestoDao().getEjecucionMensualizada(query);
                tipo = "16";
            }
            if (request.getParameter("filtroMensual_provincia") != null) { // Provincia
                String[] filtroM = request.getParameterValues("filtro_17");
                query += " AND pr.provincia = '" + filtroM[0] + "' ";
                list = new PresupuestoDao().getEjecucionMensualizada(query);
                tipo = "17";
            }
            if (request.getParameter("filtroMensual_divfuncion") != null) { // División Funcional
                String[] filtroM = request.getParameterValues("filtro_18");
                query += " AND pn.programa = '" + filtroM[0] + "' ";
                list = new PresupuestoDao().getEjecucionMensualizada(query);
                tipo = "18";
            }
            if (request.getParameter("filtroMensual_grupfuncion") != null) { // Grupo Funcional
                String[] filtroM = request.getParameterValues("filtro_19");
                query += " AND spn.sub_programa = '" + filtroM[0] + "' ";
                list = new PresupuestoDao().getEjecucionMensualizada(query);
                tipo = "19";
            }
            if (request.getParameter("filtroMensual_centro") != null) { // Centro de Costo
                String[] filtroM = request.getParameterValues("filtro_22");
                query += " AND mcc.ceco_id = '" + filtroM[0] + "' ";
                list = new PresupuestoDao().getEjecucionMensualizada(query);
                tipo = "22";
            }

            HashMap outHash = new HashMap();
            outHash.put("list", list);
            outHash.put("ejec", ejec);
            outHash.put("año", año);
            outHash.put("query", query);
            outHash.put("tipoM", tipo);
            outHash.put("tituloPDF", tituloPDF);

            Gson gson = new Gson();
            String arg = gson.toJson(outHash);
            response.getWriter().print(arg);

        } else {

            String filtro_todo = request.getParameter("filtro_todo") == null ? "algunos" : "todos";
            String[] filtro = request.getParameterValues("filtro");

            String tituloPDF;
            String select = "";
            String query_where;
            String query_group = "";
            String query_order = "";
            String query;
            Boolean total = false;
            String descripcion = "";

            List<String> listArray = new ArrayList<>();

            if (ejec.equals("00")) {
                query_where = " WHERE g.ano_eje = '" + año + "' AND g.sec_func != '0000' ";
                tituloPDF = "Pliego " + pliego + " - Gobierno Regional San Martin";
            } else {
                query_where = " WHERE g.ano_eje = '" + año + "' AND g.sec_ejec = '" + ejec + "' AND g.sec_func != '0000' ";
                String queryE = " WHERE ano_eje = '" + año + "' AND sec_ejec = '" + ejec + "' AND pliego = '" + pliego + "' ";
                Presupuesto data = new PresupuestoDao().getEjecutora(queryE);
                String[] nombre_ejec = data.getNombre().split("-");
                tituloPDF = "UE " + data.getEjecutora().trim() + " - " + nombre_ejec[1].trim() + " (" + ejec + ")";
            }

            if (filtP.equals("01")) { // Categoría Presupuestal
                select += "cp.programa_ppto as codigo, trim(cp.nombre) as nombre,";
                query_where += concatenado(filtro_todo, "cp.programa_ppto", filtro);
                query_group += " GROUP BY cp.programa_ppto, cp.nombre";
                query_order += " ORDER BY cp.programa_ppto";
            }
            if (filtP.equals("02")) { // Producto/Proyecto
                String total_todo = request.getParameter("total_todo") == null ? "" : "todo";
                String total_proy = request.getParameter("total_proy") == null ? "" : "todo";
                String total_prod = request.getParameter("total_prod") == null ? "" : "todo";
                if (total_todo.equals("todo")) {
                    select += "g.ano_eje,";
                    query_where += " AND (ap.act_proy ilike '2%' OR ap.act_proy ilike '3%') ";
                    query_group += " GROUP BY g.ano_eje";
                    query_order += " ORDER BY g.ano_eje";
                    total = true;
                    descripcion = "Totalizado";
                } else if (total_proy.equals("todo")) {
                    select += "g.ano_eje,";
                    query_where += " AND ap.act_proy ilike '2%' ";
                    query_group += " GROUP BY g.ano_eje";
                    query_order += " ORDER BY g.ano_eje";
                    total = true;
                    descripcion = "Proyectos";
                } else if (total_prod.equals("todo")) {
                    select += "g.ano_eje,";
                    query_where += " AND ap.act_proy ilike '3%' ";
                    query_group += " GROUP BY g.ano_eje";
                    query_order += " ORDER BY g.ano_eje";
                    total = true;
                    descripcion = "Productos";
                } else {
                    select += "ap.act_proy as codigo, trim(ap.nombre) as nombre, ap.proyecto_snip,";
                    query_where += concatenado(filtro_todo, "ap.act_proy", filtro);
                    query_group += " GROUP BY ap.act_proy, ap.nombre, ap.proyecto_snip";
                    query_order += " ORDER BY ap.act_proy";
                }
            }
            if (filtP.equals("03")) { // Actividad/Accion Inv./Obra
                String total_todo = request.getParameter("total_todo") == null ? "" : "todo";
                String total_act = request.getParameter("total_act") == null ? "" : "todo";
                String total_inv = request.getParameter("total_inv") == null ? "" : "todo";
                String total_obra = request.getParameter("total_obra") == null ? "" : "todo";
                if (total_todo.equals("todo")) {
                    select += "g.ano_eje,";
                    query_where += " AND (co.componente ilike '4%' OR co.componente ilike '5%' OR co.componente ilike '6%') ";
                    query_group += " GROUP BY g.ano_eje";
                    query_order += " ORDER BY g.ano_eje";
                    total = true;
                    descripcion = "Totalizado";
                } else if (total_act.equals("todo")) {
                    select += "g.ano_eje,";
                    query_where += " AND co.componente ilike '4%' ";
                    query_group += " GROUP BY g.ano_eje";
                    query_order += " ORDER BY g.ano_eje";
                    total = true;
                    descripcion = "Actividades";
                } else if (total_inv.equals("todo")) {
                    select += "g.ano_eje,";
                    query_where += " AND co.componente ilike '5%' ";
                    query_group += " GROUP BY g.ano_eje";
                    query_order += " ORDER BY g.ano_eje";
                    total = true;
                    descripcion = "Acciones Inversión";
                } else if (total_obra.equals("todo")) {
                    select += "g.ano_eje,";
                    query_where += " AND co.componente ilike '6%' ";
                    query_group += " GROUP BY g.ano_eje";
                    query_order += " ORDER BY g.ano_eje";
                    total = true;
                    descripcion = "Obras";
                } else {
                    select += "co.componente as codigo, trim(co.nombre) as nombre,";
                    query_where += concatenado(filtro_todo, "co.componente", filtro);
                    query_group += " GROUP BY co.componente, co.nombre";
                    query_order += " ORDER BY co.componente";
                }
            }
            if (filtP.equals("04")) { // Función
                select += "fn.funcion as codigo, trim(fn.nombre) as nombre,";
                query_where += concatenado(filtro_todo, "fn.funcion", filtro);
                query_group += " GROUP BY fn.funcion, fn.nombre";
                query_order += " ORDER BY fn.funcion";
            }
            if (filtP.equals("18")) { // División Funcional
                select += "pn.programa as codigo, trim(pn.nombre) as nombre,";
                query_where += concatenado(filtro_todo, "pn.programa", filtro);
                query_group += " GROUP BY pn.programa, pn.nombre";
                query_order += " ORDER BY pn.programa";
            }
            if (filtP.equals("19")) { // Grupo Funcional
                select += "spn.sub_programa as codigo, trim(spn.nombre) as nombre,";
                query_where += concatenado(filtro_todo, "spn.sub_programa", filtro);
                query_group += " GROUP BY spn.sub_programa, spn.nombre";
                query_order += " ORDER BY spn.sub_programa";
            }
            if (filtP.equals("05")) { // Meta Presupuestaria
                select += "m.sec_func as codigo, trim(fi.nombre) as nombre,";
                query_where += concatenado(filtro_todo, "m.sec_func", filtro);
                query_group += " GROUP BY m.sec_func, fi.nombre";
                query_order += " ORDER BY m.sec_func";
            }
            if (filtP.equals("06")) { // Fuente de Financiamiento
                select += "fu.fuente_financ_agregada as codigo, trim(fu.nombre) as nombre,";
                query_where += concatenado(filtro_todo, "fu.fuente_financ_agregada", filtro);
                query_group += " GROUP BY fu.fuente_financ_agregada, fu.nombre";
                query_order += " ORDER BY fu.fuente_financ_agregada";
                String tipo_recurso_ninguno = request.getParameter("tipo_recurso_ninguno") == null ? "" : request.getParameter("tipo_recurso_ninguno");
                String tipo_recurso_todo = request.getParameter("tipo_recurso_todo") == null ? "algunos" : "todos";
                String[] tipo_recurso = request.getParameterValues("tipo_recurso");
                if (tipo_recurso_ninguno.equals("")) { // Tipo de Recurso
                    select += " tr.tipo_recurso as tipo_recurso, trim(tr.nombre) as nombre_tipo_recurso,";
                    query_where += concatenado(tipo_recurso_todo, "tr.tipo_recurso", tipo_recurso);
                    query_group += ", tr.tipo_recurso, tr.nombre";
                    query_order += ", tr.tipo_recurso";
                    listArray.add("tipo_recurso");
                }
            }
            if (filtP.equals("07")) { // Rubro de Financiamiento
                select += "ru.fuente_financ as codigo, trim(ru.nombre) as nombre,";
                query_where += concatenado(filtro_todo, "ru.fuente_financ", filtro);
                query_group += " GROUP BY ru.fuente_financ, ru.nombre";
                query_order += " ORDER BY ru.fuente_financ";
            }
            if (filtP.equals("08")) { // Categoría de Gasto
                select += "cg.categ_gasto as codigo, trim(cg.nombre) as nombre,";
                query_where += concatenado(filtro_todo, "cg.categ_gasto", filtro);
                query_group += " GROUP BY cg.categ_gasto, cg.nombre";
                query_order += " ORDER BY cg.categ_gasto";
            }
            if (filtP.equals("09")) { // Genérica de Gasto
                select += "ge.clasificador as codigo, trim(ge.descripcion) as nombre, ge.tipo_transaccion, ge.generica,";
                query_where += concatenado(filtro_todo, "ge.clasificador", filtro);
                query_group += " GROUP BY ge.clasificador, ge.descripcion, ge.tipo_transaccion, ge.generica";
                query_order += " ORDER BY trim(ge.tipo_transaccion)::int, trim(ge.generica)::int";
            }
            if (filtP.equals("10")) { // Sub Genérica de Gasto
                select += "sg.clasificador as codigo, trim(sg.descripcion) as nombre, sg.tipo_transaccion, sg.generica, sg.subgenerica,";
                query_where += concatenado(filtro_todo, "sg.clasificador", filtro);
                query_group += " GROUP BY sg.clasificador, sg.descripcion, sg.tipo_transaccion, sg.generica, sg.subgenerica";
                query_order += " ORDER BY trim(sg.tipo_transaccion)::int, trim(sg.generica)::int, trim(sg.subgenerica)::int";
            }
            if (filtP.equals("11")) { // Sub Genérica Detallada de Gasto
                select += "sgd.clasificador as codigo, trim(sgd.descripcion) as nombre, sgd.tipo_transaccion, sgd.generica, "
                        + "sgd.subgenerica, sgd.subgenerica_det,";
                query_where += concatenado(filtro_todo, "sgd.clasificador", filtro);
                query_group += " GROUP BY sgd.clasificador, sgd.descripcion, sgd.tipo_transaccion, sgd.generica, sgd.subgenerica, sgd.subgenerica_det";
                query_order += " ORDER BY trim(sgd.tipo_transaccion)::int, trim(sgd.generica)::int, trim(sgd.subgenerica)::int, trim(sgd.subgenerica_det)::int";
            }
            if (filtP.equals("12")) { // Especifica de Gasto
                select += "es.clasificador as codigo, trim(es.descripcion) as nombre, es.tipo_transaccion, "
                        + "es.generica, es.subgenerica, es.subgenerica_det, es.especifica,";
                query_where += concatenado(filtro_todo, "es.clasificador", filtro);
                query_group += " GROUP BY es.clasificador, es.descripcion, es.tipo_transaccion, es.generica, es.subgenerica, es.subgenerica_det, es.especifica";
                query_order += " ORDER BY trim(es.tipo_transaccion)::int, trim(es.generica)::int, trim(es.subgenerica)::int, trim(es.subgenerica_det)::int, trim(es.especifica)::int";
            }
            if (filtP.equals("13")) { // Especifica Detallada de Gasto
                select += "ed.clasificador as codigo, trim(ed.descripcion) as nombre, ed.tipo_transaccion, ed.generica, ed.subgenerica, "
                        + "ed.subgenerica_det, ed.especifica, ed.especifica_det,";
                query_where += concatenado(filtro_todo, "ed.clasificador", filtro);
                query_group += " GROUP BY ed.clasificador, ed.descripcion, ed.tipo_transaccion, ed.generica, ed.subgenerica, ed.subgenerica_det, ed.especifica, ed.especifica_det";
                query_order += " ORDER BY trim(ed.tipo_transaccion)::int, trim(ed.generica)::int, trim(ed.subgenerica)::int, trim(ed.subgenerica_det)::int, trim(ed.especifica)::int, trim(ed.especifica_det)::int";
            }
            if (filtP.equals("14")) { // Provincia
                select += "pr.provincia as codigo, trim(pr.nombre) as nombre,";
                query_where += concatenado(filtro_todo, "pr.provincia", filtro);
                query_group += " GROUP BY pr.provincia, pr.nombre";
                query_order += " ORDER BY pr.provincia";
                String distrito_ninguno = request.getParameter("distrito_ninguno") == null ? "" : request.getParameter("distrito_ninguno");
                String distrito_todo = request.getParameter("distrito_todo") == null ? "algunos" : "todos";
                String[] distrito = request.getParameterValues("distrito");
                if (distrito_ninguno.equals("")) { // Distrito
                    select += " di.distrito as distrito, trim(di.nombre) as nombre_distrito,";
                    query_where += concatenado(distrito_todo, "di.distrito", distrito);
                    query_group += ", di.distrito, di.nombre";
                    query_order += ", di.distrito";
                    listArray.add("distrito");
                }
            }
            if (filtP.equals("22")) { // Centro de Costo
                select += "cc.ceco_codigo as codigo, trim(cc.ceco_nombre) as nombre,";
                query_where += concatenado(filtro_todo, "mcc.ceco_id", filtro);
                query_group += " GROUP BY cc.ceco_codigo, cc.ceco_nombre";
                query_order += " ORDER BY cc.ceco_codigo";
            }

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            if (request.getParameter("filtroS_ninguno") != null) {
                select += "";
                query_where += "";
            }
            if (request.getParameter("filtroS_catppto") != null) { // Categoría Presupuestal
                String filtro_todoS = request.getParameter("filtro_todo_01") == null ? "algunos" : "todos";
                String[] filtroS = request.getParameterValues("filtro_01");
                select += " cp.programa_ppto, trim(cp.nombre) as nombre_programa_ppto,";
                query_where += concatenado(filtro_todoS, "cp.programa_ppto", filtroS);
                query_group += ", cp.programa_ppto, cp.nombre";
                query_order += ", cp.programa_ppto";
                listArray.add("programa_ppto");
            }
            if (request.getParameter("filtroS_proyecto") != null) { // Producto/Proyecto
                String filtro_todoS = request.getParameter("filtro_todo_02") == null ? "algunos" : "todos";
                String[] filtroS = request.getParameterValues("filtro_02");
                select += " ap.act_proy, trim(ap.nombre) as nombre_act_proy,";
                query_where += concatenado(filtro_todoS, "ap.act_proy", filtroS);
                query_group += ", ap.act_proy, ap.nombre";
                query_order += ", ap.act_proy";
                listArray.add("act_proy");
            }
            if (request.getParameter("filtroS_actividad") != null) { // Actividad/Accion Inv./Obra
                String filtro_todoS = request.getParameter("filtro_todo_03") == null ? "algunos" : "todos";
                String[] filtroS = request.getParameterValues("filtro_03");
                select += " co.componente, trim(co.nombre) as nombre_componente,";
                query_where += concatenado(filtro_todoS, "co.componente", filtroS);
                query_group += ", co.componente, co.nombre";
                query_order += ", co.componente";
                listArray.add("componente");
            }
            if (request.getParameter("filtroS_funcion") != null) { // Función
                String filtro_todoS = request.getParameter("filtro_todo_04") == null ? "algunos" : "todos";
                String[] filtroS = request.getParameterValues("filtro_04");
                select += " fn.funcion, trim(fn.nombre) as nombre_funcion,";
                query_where += concatenado(filtro_todoS, "fn.funcion", filtroS);
                query_group += ", fn.funcion, fn.nombre";
                query_order += ", fn.funcion";
                listArray.add("funcion");
            }
            if (request.getParameter("filtroS_divfuncion") != null) { // División Funcional
                String filtro_todoS = request.getParameter("filtro_todo_18") == null ? "algunos" : "todos";
                String[] filtroS = request.getParameterValues("filtro_18");
                select += " pn.programa, trim(pn.nombre) as nombre_programa,";
                query_where += concatenado(filtro_todoS, "pn.programa", filtroS);
                query_group += ", pn.programa, pn.nombre";
                query_order += ", pn.programa";
                listArray.add("programa");
            }
            if (request.getParameter("filtroS_grupfuncion") != null) { // Grupo Funcional
                String filtro_todoS = request.getParameter("filtro_todo_19") == null ? "algunos" : "todos";
                String[] filtroS = request.getParameterValues("filtro_19");
                select += " spn.sub_programa, trim(spn.nombre) as nombre_sub_programa,";
                query_where += concatenado(filtro_todoS, "spn.sub_programa", filtroS);
                query_group += ", spn.sub_programa, spn.nombre";
                query_order += ", spn.sub_programa";
                listArray.add("sub_programa");
            }
            if (request.getParameter("filtroS_meta") != null) { // Meta Presupuestaria
                String filtro_todoS = request.getParameter("filtro_todo_05") == null ? "algunos" : "todos";
                String[] filtroS = request.getParameterValues("filtro_05");
                select += " m.sec_func, trim(fi.nombre) as nombre_sec_func,";
                query_where += concatenado(filtro_todoS, "m.sec_func", filtroS);
                query_group += ", m.sec_func, fi.nombre";
                query_order += ", m.sec_func";
                listArray.add("sec_func");
            }
            if (request.getParameter("filtroS_fuente") != null) { // Fuente de Financiamiento
                String filtro_todoS = request.getParameter("filtro_todo_06") == null ? "algunos" : "todos";
                String[] filtroS = request.getParameterValues("filtro_06");
                select += " fu.fuente_financ_agregada, trim(fu.nombre) as nombre_fuente_financ_agregada,";
                query_where += concatenado(filtro_todoS, "fu.fuente_financ_agregada", filtroS);
                query_group += ", fu.fuente_financ_agregada, fu.nombre";
                query_order += ", fu.fuente_financ_agregada";
                listArray.add("fuente_financ_agregada");
                String tipo_recurso_ninguno = request.getParameter("tipo_recurso_ninguno") == null ? "" : request.getParameter("tipo_recurso_ninguno");
                String tipo_recurso_todo = request.getParameter("tipo_recurso_todo") == null ? "algunos" : "todos";
                String[] tipo_recurso = request.getParameterValues("tipo_recurso");
                if (tipo_recurso_ninguno.equals("")) { // Tipo de Recurso
                    select += " tr.tipo_recurso as tipo_recurso, trim(tr.nombre) as nombre_tipo_recurso,";
                    query_where += concatenado(tipo_recurso_todo, "tr.tipo_recurso", tipo_recurso);
                    query_group += ", tr.tipo_recurso, tr.nombre";
                    query_order += ", tr.tipo_recurso";
                    listArray.add("tipo_recurso");
                }
            }
            if (request.getParameter("filtroS_rubro") != null) { // Rubro de Financiamiento
                String filtro_todoS = request.getParameter("filtro_todo_07") == null ? "algunos" : "todos";
                String[] filtroS = request.getParameterValues("filtro_07");
                select += " ru.fuente_financ, trim(ru.nombre) as nombre_fuente_financ,";
                query_where += concatenado(filtro_todoS, "ru.fuente_financ", filtroS);
                query_group += ", ru.fuente_financ, ru.nombre";
                query_order += ", ru.fuente_financ";
                listArray.add("fuente_financ");
            }
            if (request.getParameter("filtroS_catgasto") != null) {  // Categoría de Gasto
                String filtro_todoS = request.getParameter("filtro_todo_08") == null ? "algunos" : "todos";
                String[] filtroS = request.getParameterValues("filtro_08");
                select += " cg.categ_gasto, trim(cg.nombre) as nombre_categ_gasto,";
                query_where += concatenado(filtro_todoS, "cg.categ_gasto", filtroS);
                query_group += ", cg.categ_gasto, cg.nombre";
                query_order += ", cg.categ_gasto";
                listArray.add("categ_gasto");
            }
            if (request.getParameter("filtroS_generica") != null) { // Genérica de Gasto
                String filtro_todoS = request.getParameter("filtro_todo_09") == null ? "algunos" : "todos";
                String[] filtroS = request.getParameterValues("filtro_09");
                select += " ge.clasificador as generica_clasif, trim(ge.descripcion) as nombre_generica_clasif, ge.tipo_transaccion, ge.generica,";
                query_where += concatenado(filtro_todoS, "ge.clasificador", filtroS);
                query_group += ", ge.clasificador, ge.descripcion, ge.tipo_transaccion, ge.generica";
                query_order += ", trim(ge.tipo_transaccion)::int, trim(ge.generica)::int";
                listArray.add("generica_clasif");
            }
            if (request.getParameter("filtroS_subgenerica") != null) { // Sub Genérica de Gasto
                String filtro_todoS = request.getParameter("filtro_todo_10") == null ? "algunos" : "todos";
                String[] filtroS = request.getParameterValues("filtro_10");
                select += " sg.clasificador as subgenerica_clasif, trim(sg.descripcion) as nombre_subgenerica_clasif, sg.tipo_transaccion, sg.generica, sg.subgenerica,";
                query_where += concatenado(filtro_todoS, "sg.clasificador", filtroS);
                query_group += ", sg.clasificador, sg.descripcion, sg.tipo_transaccion, sg.generica, sg.subgenerica";
                query_order += ", trim(sg.tipo_transaccion)::int, trim(sg.generica)::int, trim(sg.subgenerica)::int";
                listArray.add("subgenerica_clasif");
            }
            if (request.getParameter("filtroS_subgenericadet") != null) { // Sub Genérica Detallada de Gasto
                String filtro_todoS = request.getParameter("filtro_todo_11") == null ? "algunos" : "todos";
                String[] filtroS = request.getParameterValues("filtro_11");
                select += " sgd.clasificador as subgenerica_det_clasif, trim(sgd.descripcion) as nombre_subgenerica_det_clasif, sgd.tipo_transaccion, sgd.generica, "
                        + "sgd.subgenerica, sgd.subgenerica_det,";
                query_where += concatenado(filtro_todoS, "sgd.clasificador", filtroS);
                query_group += ", sgd.clasificador, sgd.descripcion, sgd.tipo_transaccion, sgd.generica, sgd.subgenerica, sgd.subgenerica_det";
                query_order += ", trim(sgd.tipo_transaccion)::int, trim(sgd.generica)::int, trim(sgd.subgenerica)::int, trim(sgd.subgenerica_det)::int";
                listArray.add("subgenerica_det_clasif");
            }
            if (request.getParameter("filtroS_especifica") != null) { // Especifica de Gasto
                String filtro_todoS = request.getParameter("filtro_todo_12") == null ? "algunos" : "todos";
                String[] filtroS = request.getParameterValues("filtro_12");
                select += " es.clasificador as especifica_clasif, trim(es.descripcion) as nombre_especifica_clasif, es.tipo_transaccion, "
                        + "es.generica, es.subgenerica, es.subgenerica_det, es.especifica,";
                query_where += concatenado(filtro_todoS, "es.clasificador", filtroS);
                query_group += ", es.clasificador, es.descripcion, es.tipo_transaccion, es.generica, es.subgenerica, es.subgenerica_det, es.especifica";
                query_order += ", trim(es.tipo_transaccion)::int, trim(es.generica)::int, trim(es.subgenerica)::int, trim(es.subgenerica_det)::int, trim(es.especifica)::int";
                listArray.add("especifica_clasif");
            }
            if (request.getParameter("filtroS_especificadet") != null) { // Especifica Detallada de Gasto
                String filtro_todoS = request.getParameter("filtro_todo_13") == null ? "algunos" : "todos";
                String[] filtroS = request.getParameterValues("filtro_13");
                select += " ed.clasificador as especifica_det_clasif, trim(ed.descripcion) as nombre_especifica_det_clasif, ed.tipo_transaccion, ed.generica, ed.subgenerica, "
                        + "ed.subgenerica_det, ed.especifica, ed.especifica_det,";
                query_where += concatenado(filtro_todoS, "ed.clasificador", filtroS);
                query_group += ", ed.clasificador, ed.descripcion, ed.tipo_transaccion, ed.generica, ed.subgenerica, ed.subgenerica_det, ed.especifica, ed.especifica_det";
                query_order += ", trim(ed.tipo_transaccion)::int, trim(ed.generica)::int, trim(ed.subgenerica)::int, trim(ed.subgenerica_det)::int, trim(ed.especifica)::int, trim(ed.especifica_det)::int";
                listArray.add("especifica_det_clasif");
            }
            if (request.getParameter("filtroS_provincia") != null) { // Provincia
                String filtro_todoS = request.getParameter("filtro_todo_14") == null ? "algunos" : "todos";
                String[] filtroS = request.getParameterValues("filtro_14");
                select += " pr.provincia as provincia, trim(pr.nombre) as nombre_provincia,";
                query_where += concatenado(filtro_todoS, "pr.provincia", filtroS);
                query_group += ", pr.provincia, pr.nombre";
                query_order += ", pr.provincia";
                listArray.add("provincia");
                String distrito_ninguno = request.getParameter("distrito_ninguno") == null ? "" : request.getParameter("distrito_ninguno");
                String distrito_todo = request.getParameter("distrito_todo") == null ? "algunos" : "todos";
                String[] distrito = request.getParameterValues("distrito");
                if (distrito_ninguno.equals("")) { // Distrito
                    select += " di.distrito as distrito, trim(di.nombre) as nombre_distrito,";
                    query_where += concatenado(distrito_todo, "di.distrito", distrito);
                    query_group += ", di.distrito, di.nombre";
                    query_order += ", di.distrito";
                    listArray.add("distrito");
                }
            }
            if (request.getParameter("filtroS_ejecutora") != null) { // Unidades Ejecutoras
                String filtro_todoS = request.getParameter("filtro_todo_16") == null ? "algunos" : "todos";
                String[] filtroS = request.getParameterValues("filtro_16");
                select += " g.sec_ejec, ej.ejecutora, ej.nombre as nombre_ejecutora,";
                query_where += concatenado(filtro_todoS, "g.sec_ejec", filtroS);
                query_group += ", g.sec_ejec, ej.ejecutora, ej.nombre";
                query_order += ", ej.ejecutora";
                listArray.add("ejecutora");
            }
            if (request.getParameter("filtroS_centro") != null) { // Centro de Costo
                String filtro_todoS = request.getParameter("filtro_todo_22") == null ? "algunos" : "todos";
                String[] filtroS = request.getParameterValues("filtro_22");
                select += " cc.ceco_codigo, trim(cc.ceco_nombre) as ceco_nombre,";
                query_where += concatenado(filtro_todoS, "mcc.ceco_id", filtroS);
                query_group += ", cc.ceco_codigo, cc.ceco_nombre";
                query_order += ", cc.ceco_codigo";
                listArray.add("centro_costo");
            }

            String[] array = new String[listArray.size()];
            listArray.toArray(array);

            query = query_where + query_group + query_order + " ASC";

            List<Presupuesto> list;
            if (filtP.equals("00")) {
                String queryE;
                if (ejec.equals("00")) {
                    queryE = " WHERE a.ano_eje = '" + año + "' ORDER BY b.ejecutora ASC ";
                } else {
                    queryE = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' ORDER BY b.ejecutora ASC ";
                }
                list = new PresupuestoDao().getListSemaforoEjecucion(queryE);
                query = queryE;
            } else {
                String tipoRec = request.getParameter("tipo_recurso_ninguno") == null ? "" : request.getParameter("tipo_recurso_ninguno");
                switch (filtP) {
                    case "06":
                        if (tipoRec.equals("")) {
                            list = new PresupuestoDao().getEjecucionAnualTipoRec(select, query, "LEFT");
                        } else {
                            list = new PresupuestoDao().getEjecucionAnual(select, query, "LEFT");
                        }
                        break;
                    case "22":
                        if (request.getParameter("filtroS_fuente") != null) {
                            if (tipoRec.equals("")) {
                                list = new PresupuestoDao().getEjecucionAnualTipoRec(select, query, "INNER");
                            } else {
                                list = new PresupuestoDao().getEjecucionAnual(select, query, "INNER");
                            }
                        } else {
                            list = new PresupuestoDao().getEjecucionAnual(select, query, "INNER");
                        }
                        break;
                    default:
                        if (request.getParameter("filtroS_fuente") != null) {
                            if (tipoRec.equals("")) {
                                list = new PresupuestoDao().getEjecucionAnualTipoRec(select, query, "LEFT");
                            } else {
                                list = new PresupuestoDao().getEjecucionAnual(select, query, "LEFT");
                            }
                        } else {
                            list = new PresupuestoDao().getEjecucionAnual(select, query, "LEFT");
                        }
                        break;
                }
            }

            HashMap outHash = new HashMap();
            outHash.put("list", list);
            outHash.put("ejec", ejec);
            outHash.put("año", año);
            outHash.put("select", select);
            outHash.put("query", query);
            outHash.put("filtro", filtP);
            outHash.put("tituloPDF", tituloPDF);
            outHash.put("array", array);
            outHash.put("total", total);
            outHash.put("descripcion", descripcion);

            Gson gson = new Gson();
            String arg = gson.toJson(outHash);
            response.getWriter().print(arg);

        }

    }

    private void gasto_mensualizado_grafica(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String[] meses = request.getParameterValues("mes");
        String[] array = request.getParameterValues("array");
        String fase = request.getParameter("fase");
        String pdf = request.getParameter("pdf") == null ? "" : request.getParameter("pdf");

        String nombre_fase = "";
        if (fase.equals("C")) {
            nombre_fase = "Certificado";
        }
        if (fase.equals("CoA")) {
            nombre_fase = "Compromiso Anual";
        }
        if (fase.equals("Co")) {
            nombre_fase = "Compromiso";
        }
        if (fase.equals("D")) {
            nombre_fase = "Devengado";
        }
        if (fase.equals("G")) {
            nombre_fase = "Girado";
        }
        if (fase.equals("P")) {
            nombre_fase = "Pagado";
        }

        String titulo = request.getParameter("titu");
        String subtitulo = request.getParameter("subtitu");
        String tituloX = "Mes de Ejecución";
        String tituloY = "Ejecución de Gasto (En millones de S/)";
        String formato = "png";
        int ancho = Integer.parseInt(request.getParameter("ancho"));
        int alto = Integer.parseInt(request.getParameter("alto"));
        int font_size = Integer.parseInt(request.getParameter("font"));
        double bar_width = Double.parseDouble(request.getParameter("bar"));
        String pos = request.getParameter("pos");
        Paint color_letra = null;
        if (pos.equals("in")) {
            color_letra = blanco;
        }
        if (pos.equals("out")) {
            color_letra = negro;
        }

        DefaultCategoryDataset objDataset = new DefaultCategoryDataset();
        DefaultCategoryDataset dataLine = new DefaultCategoryDataset();

        for (int i = 0; i < meses.length; i++) {
            BigDecimal numeric = new BigDecimal(array[i]);
            String mes = meses[i];
            objDataset.setValue(millones(numeric), nombre_fase, mes);
            dataLine.setValue(millones(numeric), "Tendencia", mes);
        }
        String[] Leyenda = new String[1];
        if (pdf.equals("si")) {
            chart.barraLineV_2D_Sub_pdf(request, response, objDataset, dataLine, Leyenda, "", "", nombre_fase, tituloX, "Ejecución (millones S/)", 950, 500, 9, 0.05, formato, blanco, color_letra, pos);
        } else {
            chart.barraLineV_2D_Sub(request, response, objDataset, dataLine, Leyenda, titulo, subtitulo, nombre_fase, tituloX, tituloY, ancho, alto, font_size, bar_width, formato, blanco, color_letra, pos);
        }

    }

    private void certificaciones_consolidado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String ejec = request.getParameter("ejec");
        String año = request.getParameter("anho");
        String filtP = request.getParameter("filtro_princ");

        String select = "";
        String query_group = " GROUP BY f1.certificacion, fu.fuente_financ_agregada, fu.nombre, f1.glosa ";
        String query_order = " ORDER BY f1.certificacion ";
        String query;

        String query_where = " WHERE f1.ano_eje = '" + año + "' AND f1.sec_ejec = '" + ejec + "' ";
        String queryE = " WHERE ano_eje = '" + año + "' AND sec_ejec = '" + ejec + "' AND pliego = '" + pliego + "' ";
        Presupuesto data = new PresupuestoDao().getEjecutora(queryE);
        String[] nombre_ejec = data.getNombre().split("-");
        String tituloPDF = "UE " + data.getEjecutora().trim() + " - " + nombre_ejec[1].trim() + " (" + ejec + ")";

        List<String> listArray = new ArrayList<>();
        String[] array = new String[listArray.size()];
        listArray.toArray(array);
        query = query_where + query_group + query_order + " ASC";

        List<Presupuesto> list = new PresupuestoDao().getCertificaciones(select, query);
        HashMap outHash = new HashMap();
        outHash.put("list", list);
        outHash.put("ejec", ejec);
        outHash.put("año", año);
        outHash.put("select", select);
        outHash.put("query", query);
        outHash.put("tituloPDF", tituloPDF);
        outHash.put("array", array);
        outHash.put("filtro", filtP);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void certificaciones(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String ejec = request.getParameter("ejec");
        String año = request.getParameter("anho");
        String filtP = request.getParameter("filtro_princ");
        String filtro_todo = request.getParameter("filtro_todo") == null ? "algunos" : "todos";
        String[] filtro = request.getParameterValues("filtro");

        String select = "";
        String query_group = " GROUP BY f1.certificacion, fu.fuente_financ_agregada, fu.nombre, f1.glosa ";
        String query_order = " ORDER BY f1.certificacion ";
        String query;

        String query_where = " WHERE f1.ano_eje = '" + año + "' AND f1.sec_ejec = '" + ejec + "' ";
        String queryE = " WHERE ano_eje = '" + año + "' AND sec_ejec = '" + ejec + "' AND pliego = '" + pliego + "' ";
        Presupuesto data = new PresupuestoDao().getEjecutora(queryE);
        String[] nombre_ejec = data.getNombre().split("-");
        String tituloPDF = "UE " + data.getEjecutora().trim() + " - " + nombre_ejec[1].trim() + " (" + ejec + ")";

        List<String> listArray = new ArrayList<>();

        if (filtP.equals("05")) { // Meta Presupuestaria
            select += "m.sec_func as codigo, trim(fi.nombre) as nombre,";
            query_where += concatenado(filtro_todo, "m.sec_func", filtro);
            query_group += " , m.sec_func, fi.nombre";
            query_order += " , m.sec_func";
        }
        if (filtP.equals("06")) { // Fuente de Financiamiento
            query_where += concatenado(filtro_todo, "fu.fuente_financ_agregada", filtro);
        }
        if (filtP.equals("07")) { // Rubro de Financiamiento
            select += "ru.fuente_financ as codigo, trim(ru.nombre) as nombre,";
            query_where += concatenado(filtro_todo, "ru.fuente_financ", filtro);
            query_group += " , ru.fuente_financ, ru.nombre";
            query_order += " , ru.fuente_financ";
        }
        if (filtP.equals("08")) { // Categoría de Gasto
            select += "cg.categ_gasto as codigo, trim(cg.nombre) as nombre,";
            query_where += concatenado(filtro_todo, "cg.categ_gasto", filtro);
            query_group += " , cg.categ_gasto, cg.nombre";
            query_order += " , cg.categ_gasto";
        }
        if (filtP.equals("09")) { // Genérica de Gasto
            select += "ge.clasificador as codigo, trim(ge.descripcion) as nombre, ge.tipo_transaccion, ge.generica,";
            query_where += concatenado(filtro_todo, "ge.clasificador", filtro);
            query_group += " , ge.clasificador, ge.descripcion, ge.tipo_transaccion, ge.generica";
            query_order += " , trim(ge.tipo_transaccion)::int, trim(ge.generica)::int";
        }
        if (filtP.equals("10")) { // Sub Genérica de Gasto
            select += "sg.clasificador as codigo, trim(sg.descripcion) as nombre, sg.tipo_transaccion, sg.generica, sg.subgenerica,";
            query_where += concatenado(filtro_todo, "sg.clasificador", filtro);
            query_group += " , sg.clasificador, sg.descripcion, sg.tipo_transaccion, sg.generica, sg.subgenerica";
            query_order += " , trim(sg.tipo_transaccion)::int, trim(sg.generica)::int, trim(sg.subgenerica)::int";
        }
        if (filtP.equals("11")) { // Sub Genérica Detallada de Gasto
            select += "sgd.clasificador as codigo, trim(sgd.descripcion) as nombre, sgd.tipo_transaccion, sgd.generica, "
                    + "sgd.subgenerica, sgd.subgenerica_det,";
            query_where += concatenado(filtro_todo, "sgd.clasificador", filtro);
            query_group += " , sgd.clasificador, sgd.descripcion, sgd.tipo_transaccion, sgd.generica, sgd.subgenerica, sgd.subgenerica_det";
            query_order += " , trim(sgd.tipo_transaccion)::int, trim(sgd.generica)::int, trim(sgd.subgenerica)::int, trim(sgd.subgenerica_det)::int";
        }
        if (filtP.equals("12")) { // Especifica de Gasto
            select += "es.clasificador as codigo, trim(es.descripcion) as nombre, es.tipo_transaccion, "
                    + "es.generica, es.subgenerica, es.subgenerica_det, es.especifica,";
            query_where += concatenado(filtro_todo, "es.clasificador", filtro);
            query_group += " , es.clasificador, es.descripcion, es.tipo_transaccion, es.generica, es.subgenerica, es.subgenerica_det, es.especifica";
            query_order += " , trim(es.tipo_transaccion)::int, trim(es.generica)::int, trim(es.subgenerica)::int, trim(es.subgenerica_det)::int, trim(es.especifica)::int";
        }
        if (filtP.equals("13")) { // Especifica Detallada de Gasto
            select += "ed.clasificador as codigo, trim(ed.descripcion) as nombre, ed.tipo_transaccion, ed.generica, ed.subgenerica, "
                    + "ed.subgenerica_det, ed.especifica, ed.especifica_det,";
            query_where += concatenado(filtro_todo, "ed.clasificador", filtro);
            query_group += " , ed.clasificador, ed.descripcion, ed.tipo_transaccion, ed.generica, ed.subgenerica, ed.subgenerica_det, ed.especifica, ed.especifica_det";
            query_order += " , trim(ed.tipo_transaccion)::int, trim(ed.generica)::int, trim(ed.subgenerica)::int, trim(ed.subgenerica_det)::int, trim(ed.especifica)::int, trim(ed.especifica_det)::int";
        }
        if (filtP.equals("14")) { // Provincia
            select += "pr.provincia as codigo, trim(pr.nombre) as nombre,";
            query_where += concatenado(filtro_todo, "pr.provincia", filtro);
            query_group += " , pr.provincia, pr.nombre";
            query_order += " , pr.provincia";
            String distrito_ninguno = request.getParameter("distrito_ninguno") == null ? "" : request.getParameter("distrito_ninguno");
            String distrito_todo = request.getParameter("distrito_todo") == null ? "algunos" : "todos";
            String[] distrito = request.getParameterValues("distrito");
            if (distrito_ninguno.equals("")) { // Distrito
                select += "di.distrito as distrito, trim(di.nombre) as nombre_distrito,";
                query_where += concatenado(distrito_todo, "di.distrito", distrito);
                query_group += " , di.distrito, di.nombre";
                query_order += " , di.distrito";
                listArray.add("distrito");
            }
        }

        if (request.getParameter("filtroS_ninguno") != null) {
            select += "";
            query_where += "";
        }
        if (request.getParameter("filtroS_meta") != null) { // Meta Presupuestaria
            String filtro_todoS = request.getParameter("filtro_todo_05") == null ? "algunos" : "todos";
            String[] filtroS = request.getParameterValues("filtro_05");
            select += " m.sec_func, trim(fi.nombre) as nombre_sec_func,";
            query_where += concatenado(filtro_todoS, "m.sec_func", filtroS);
            query_group += ", m.sec_func, fi.nombre";
            query_order += ", m.sec_func";
            listArray.add("sec_func");
        }
        if (request.getParameter("filtroS_fuente") != null) { // Fuente de Financiamiento
            String filtro_todoS = request.getParameter("filtro_todo_06") == null ? "algunos" : "todos";
            String[] filtroS = request.getParameterValues("filtro_06");
            query_where += concatenado(filtro_todoS, "fu.fuente_financ_agregada", filtroS);
        }
        if (request.getParameter("filtroS_rubro") != null) { // Rubro de Financiamiento
            String filtro_todoS = request.getParameter("filtro_todo_07") == null ? "algunos" : "todos";
            String[] filtroS = request.getParameterValues("filtro_07");
            select += " ru.fuente_financ, trim(ru.nombre) as nombre_fuente_financ,";
            query_where += concatenado(filtro_todoS, "ru.fuente_financ", filtroS);
            query_group += ", ru.fuente_financ, ru.nombre";
            query_order += ", ru.fuente_financ";
            listArray.add("fuente_financ");
        }
        if (request.getParameter("filtroS_catgasto") != null) {  // Categoría de Gasto
            String filtro_todoS = request.getParameter("filtro_todo_08") == null ? "algunos" : "todos";
            String[] filtroS = request.getParameterValues("filtro_08");
            select += " cg.categ_gasto, trim(cg.nombre) as nombre_categ_gasto,";
            query_where += concatenado(filtro_todoS, "cg.categ_gasto", filtroS);
            query_group += ", cg.categ_gasto, cg.nombre";
            query_order += ", cg.categ_gasto";
            listArray.add("categ_gasto");
        }
        if (request.getParameter("filtroS_generica") != null) { // Genérica de Gasto
            String filtro_todoS = request.getParameter("filtro_todo_09") == null ? "algunos" : "todos";
            String[] filtroS = request.getParameterValues("filtro_09");
            select += " ge.clasificador as generica_clasif, trim(ge.descripcion) as nombre_generica_clasif, ge.tipo_transaccion, ge.generica,";
            query_where += concatenado(filtro_todoS, "ge.clasificador", filtroS);
            query_group += ", ge.clasificador, ge.descripcion, ge.tipo_transaccion, ge.generica";
            query_order += ", trim(ge.tipo_transaccion)::int, trim(ge.generica)::int";
            listArray.add("generica_clasif");
        }
        if (request.getParameter("filtroS_subgenerica") != null) { // Sub Genérica de Gasto
            String filtro_todoS = request.getParameter("filtro_todo_10") == null ? "algunos" : "todos";
            String[] filtroS = request.getParameterValues("filtro_10");
            select += " sg.clasificador as subgenerica_clasif, trim(sg.descripcion) as nombre_subgenerica_clasif, sg.tipo_transaccion, sg.generica, sg.subgenerica,";
            query_where += concatenado(filtro_todoS, "sg.clasificador", filtroS);
            query_group += ", sg.clasificador, sg.descripcion, sg.tipo_transaccion, sg.generica, sg.subgenerica";
            query_order += ", trim(sg.tipo_transaccion)::int, trim(sg.generica)::int, trim(sg.subgenerica)::int";
            listArray.add("subgenerica_clasif");
        }
        if (request.getParameter("filtroS_subgenericadet") != null) { // Sub Genérica Detallada de Gasto
            String filtro_todoS = request.getParameter("filtro_todo_11") == null ? "algunos" : "todos";
            String[] filtroS = request.getParameterValues("filtro_11");
            select += " sgd.clasificador as subgenerica_det_clasif, trim(sgd.descripcion) as nombre_subgenerica_det_clasif, sgd.tipo_transaccion, sgd.generica, "
                    + "sgd.subgenerica, sgd.subgenerica_det,";
            query_where += concatenado(filtro_todoS, "sgd.clasificador", filtroS);
            query_group += ", sgd.clasificador, sgd.descripcion, sgd.tipo_transaccion, sgd.generica, sgd.subgenerica, sgd.subgenerica_det";
            query_order += ", trim(sgd.tipo_transaccion)::int, trim(sgd.generica)::int, trim(sgd.subgenerica)::int, trim(sgd.subgenerica_det)::int";
            listArray.add("subgenerica_det_clasif");
        }
        if (request.getParameter("filtroS_especifica") != null) { // Especifica de Gasto
            String filtro_todoS = request.getParameter("filtro_todo_12") == null ? "algunos" : "todos";
            String[] filtroS = request.getParameterValues("filtro_12");
            select += " es.clasificador as especifica_clasif, trim(es.descripcion) as nombre_especifica_clasif, es.tipo_transaccion, "
                    + "es.generica, es.subgenerica, es.subgenerica_det, es.especifica,";
            query_where += concatenado(filtro_todoS, "es.clasificador", filtroS);
            query_group += ", es.clasificador, es.descripcion, es.tipo_transaccion, es.generica, es.subgenerica, es.subgenerica_det, es.especifica";
            query_order += ", trim(es.tipo_transaccion)::int, trim(es.generica)::int, trim(es.subgenerica)::int, trim(es.subgenerica_det)::int, trim(es.especifica)::int";
            listArray.add("especifica_clasif");
        }
        if (request.getParameter("filtroS_especificadet") != null) { // Especifica Detallada de Gasto
            String filtro_todoS = request.getParameter("filtro_todo_13") == null ? "algunos" : "todos";
            String[] filtroS = request.getParameterValues("filtro_13");
            select += " ed.clasificador as especifica_det_clasif, trim(ed.descripcion) as nombre_especifica_det_clasif, ed.tipo_transaccion, ed.generica, ed.subgenerica, "
                    + "ed.subgenerica_det, ed.especifica, ed.especifica_det,";
            query_where += concatenado(filtro_todoS, "ed.clasificador", filtroS);
            query_group += ", ed.clasificador, ed.descripcion, ed.tipo_transaccion, ed.generica, ed.subgenerica, ed.subgenerica_det, ed.especifica, ed.especifica_det";
            query_order += ", trim(ed.tipo_transaccion)::int, trim(ed.generica)::int, trim(ed.subgenerica)::int, trim(ed.subgenerica_det)::int, trim(ed.especifica)::int, trim(ed.especifica_det)::int";
            listArray.add("especifica_det_clasif");
        }
        if (request.getParameter("filtroS_provincia") != null) { // Provincia
            String filtro_todoS = request.getParameter("filtro_todo_14") == null ? "algunos" : "todos";
            String[] filtroS = request.getParameterValues("filtro_14");
            select += " pr.provincia as provincia, trim(pr.nombre) as nombre_provincia,";
            query_where += concatenado(filtro_todoS, "pr.provincia", filtroS);
            query_group += ", pr.provincia, pr.nombre";
            query_order += ", pr.provincia";
            listArray.add("provincia");
            String distrito_ninguno = request.getParameter("distrito_ninguno") == null ? "" : request.getParameter("distrito_ninguno");
            String distrito_todo = request.getParameter("distrito_todo") == null ? "algunos" : "todos";
            String[] distrito = request.getParameterValues("distrito");
            if (distrito_ninguno.equals("")) { // Distrito
                select += " di.distrito as distrito, trim(di.nombre) as nombre_distrito,";
                query_where += concatenado(distrito_todo, "di.distrito", distrito);
                query_group += ", di.distrito, di.nombre";
                query_order += ", di.distrito";
                listArray.add("distrito");
            }
        }

        String[] array = new String[listArray.size()];
        listArray.toArray(array);

        query = query_where + query_group + query_order + " ASC";

        List<Presupuesto> list = new PresupuestoDao().getCertificaciones(select, query);

        HashMap outHash = new HashMap();
        outHash.put("list", list);
        outHash.put("ejec", ejec);
        outHash.put("año", año);
        outHash.put("select", select);
        outHash.put("query", query);
        outHash.put("tituloPDF", tituloPDF);
        outHash.put("array", array);
        outHash.put("filtro", filtP);
        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void certificacion_detallada(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String ejec = request.getParameter("ejec");
        String año = request.getParameter("anho");
        String num_certi = request.getParameter("num_certi");

        String queryE = " WHERE ano_eje = '" + año + "' AND sec_ejec = '" + ejec + "' AND pliego = '" + pliego + "' ";
        Presupuesto data = new PresupuestoDao().getEjecutora(queryE);
        String[] nombre_ejec = data.getNombre().split("-");
        String tituloPDF = "UE " + data.getEjecutora().trim() + " - " + nombre_ejec[1].trim() + " (" + ejec + ")";

        String ceros = "";
        for (int i = 0; i < 10 - num_certi.length(); i++) {
            ceros += "0";
        }
        String certificacion = ceros + num_certi;

        String query = " WHERE f1.ano_eje = '" + año + "' AND f1.sec_ejec = '" + ejec + "' AND f1.certificacion = '" + certificacion + "' "
                + "GROUP BY f1.certificacion, fu.fuente_financ_agregada, fu.nombre, f1.glosa, m.sec_func, fi.nombre, ed.clasificador, ed.descripcion, "
                + "ed.tipo_transaccion, ed.generica, ed.subgenerica, ed.subgenerica_det, ed.especifica, ed.especifica_det "
                + "ORDER BY f1.certificacion, m.sec_func, ed.tipo_transaccion, ed.generica, ed.subgenerica, ed.subgenerica_det, ed.especifica, ed.especifica_det ASC ";
        List<Presupuesto> datos = new PresupuestoDao().getCertificacionDetallada(query + " LIMIT 1");
        List<Presupuesto> list = new PresupuestoDao().getCertificacionDetallada(query);

        String queryExp = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND a.ciclo = 'G' AND b.certificado = '" + certificacion + "' "
                + "ORDER BY a.expediente, a.fase, a.secuencia, a.correlativo, a.sec_func, ed.clasificador ASC ";
        List<Presupuesto> listExp = new PresupuestoDao().getCertificacionExpedientes(queryExp);

        HashMap outHash = new HashMap();
        if (datos.isEmpty()) {
            outHash.put("certificacion", "");
            outHash.put("fuente", "");
            outHash.put("nombre", "");
            outHash.put("glosa", "");
        } else {
            outHash.put("certificacion", datos.get(0).getCertificacion());
            outHash.put("fuente", datos.get(0).getFuente_financ_agregada());
            outHash.put("nombre", datos.get(0).getNombre_fuente_financ_agregada());
            outHash.put("glosa", datos.get(0).getGlosa());
        }
        outHash.put("año", año);
        outHash.put("listD", list);
        outHash.put("tituloPDF", tituloPDF);
        outHash.put("listExp", listExp);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void certificacion_historial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String ejec = request.getParameter("ejec");
        String año = request.getParameter("anho");
        String num_certi = request.getParameter("num_certi");
        String[] etapa = request.getParameterValues("etapa");

        String queryE = " WHERE ano_eje = '" + año + "' AND sec_ejec = '" + ejec + "' AND pliego = '" + pliego + "' ";
        Presupuesto data = new PresupuestoDao().getEjecutora(queryE);
        String[] nombre_ejec = data.getNombre().split("-");
        String tituloPDF = "UE " + data.getEjecutora().trim() + " - " + nombre_ejec[1].trim() + " (" + ejec + ")";

        String ceros = "";
        for (int i = 0; i < 10 - num_certi.length(); i++) {
            ceros += "0";
        }
        String certificacion = ceros + num_certi;

        String query = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND a.certificado = '" + certificacion + "' AND c.etapa = '" + etapa[0] + "' "
                + "AND a.estado_registro = 'A' ORDER BY a.secuencia, a.correlativo ASC ";
        List<Presupuesto> datos = new PresupuestoDao().getCertificacionHistorial(query + " LIMIT 1");
        List<Presupuesto> list = new PresupuestoDao().getCertificacionHistorial(query);

        HashMap outHash = new HashMap();
        if (datos.isEmpty()) {
            outHash.put("certificacion", "");
            outHash.put("fuente", "");
            outHash.put("nombre", "");
            outHash.put("glosa", "");
        } else {
            outHash.put("certificacion", datos.get(0).getCertificacion());
            outHash.put("fuente", datos.get(0).getFuente_financ_agregada());
            outHash.put("nombre", datos.get(0).getNombre_fuente_financ_agregada());
            outHash.put("glosa", datos.get(0).getGlosa());
        }
        outHash.put("año", año);
        outHash.put("etapa", etapa[0]);
        outHash.put("listH", list);
        outHash.put("tituloPDF", tituloPDF);

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void certificacion_estado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String ejec = request.getParameter("ejec");
        String año = request.getParameter("anho");
        String[] etapa = request.getParameterValues("etapa");
        String[] estado = request.getParameterValues("estado");

        String queryE = " WHERE ano_eje = '" + año + "' AND sec_ejec = '" + ejec + "' AND pliego = '" + pliego + "' ";
        Presupuesto data = new PresupuestoDao().getEjecutora(queryE);
        String[] nombre_ejec = data.getNombre().split("-");
        String tituloPDF = "UE " + data.getEjecutora().trim() + " - " + nombre_ejec[1].trim() + " (" + ejec + ")";

        String query = "";
        if (estado[0].equals("A")) {
            query = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND b.etapa = '" + etapa[0] + "' AND a.estado_envio = 'T' AND a.estado_registro = 'A'"
                    + " ORDER BY a.secuencia, a.correlativo ASC ";
        }
        if (estado[0].equals("R")) {
            query = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND b.etapa = '" + etapa[0] + "' AND a.estado_envio = 'T' AND a.estado_registro = 'R'"
                    + " ORDER BY a.secuencia, a.correlativo ASC ";
        }
        if (estado[0].equals("P")) {
            query = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND b.etapa = '" + etapa[0] + "' AND a.estado_envio = 'T' AND a.estado_registro = 'V'"
                    + " ORDER BY a.secuencia, a.correlativo ASC ";
        }
        if (estado[0].equals("E")) {
            query = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND b.etapa = '" + etapa[0] + "' AND a.estado_envio = 'P' AND a.estado_registro = 'V'"
                    + " ORDER BY a.secuencia, a.correlativo ASC ";
        }
        List<Presupuesto> list = new PresupuestoDao().getCertificacionEstado(query);

        HashMap outHash = new HashMap();
        outHash.put("año", año);
        outHash.put("etapa", etapa[0]);
        outHash.put("listE", list);
        outHash.put("tituloPDF", tituloPDF);

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void certificacion_por_documento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String ejec = request.getParameter("ejec");
        String año = request.getParameter("anho");
        String[] etapa = request.getParameterValues("etapa");
        String cod_doc = request.getParameter("cod_doc");
        String num_doc = request.getParameter("num_doc");

        String queryE = " WHERE ano_eje = '" + año + "' AND sec_ejec = '" + ejec + "' AND pliego = '" + pliego + "' ";
        Presupuesto data = new PresupuestoDao().getEjecutora(queryE);
        String[] nombre_ejec = data.getNombre().split("-");
        String tituloPDF = "UE " + data.getEjecutora().trim() + " - " + nombre_ejec[1].trim() + " (" + ejec + ")";

        String query;
        if (num_doc.equals("")) {
            query = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND b.etapa = '" + etapa[0] + "' AND a.cod_doc = '" + cod_doc + "' "
                    + "ORDER BY a.secuencia, a.correlativo ASC ";
        } else {
            query = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND b.etapa = '" + etapa[0] + "' AND a.cod_doc = '" + cod_doc + "' "
                    + "AND a.num_doc ilike '%" + num_doc + "%' ORDER BY a.secuencia, a.correlativo ASC ";
        }
        List<Presupuesto> list = new PresupuestoDao().getCertificacionEstado(query);

        HashMap outHash = new HashMap();
        outHash.put("año", año);
        outHash.put("etapa", etapa[0]);
        outHash.put("listD", list);
        outHash.put("tituloPDF", tituloPDF);

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void expedientes_lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String ejec = request.getParameter("ejec");
        String año = request.getParameter("anho");

        String num_expe = request.getParameter("num_exped");
        String cerosE = "";
        for (int j = 0; j < 10 - num_expe.length(); j++) {
            cerosE += "0";
        }
        String expe = cerosE + num_expe;

        String queryE = " WHERE ano_eje = '" + año + "' AND sec_ejec = '" + ejec + "' AND pliego = '" + pliego + "' ";
        Presupuesto data = new PresupuestoDao().getEjecutora(queryE);
        String[] nombre_ejec = data.getNombre().split("-");
        String tituloPDF = "UE " + data.getEjecutora().trim() + " - " + nombre_ejec[1].trim() + " (" + ejec + ")";

        String prove = request.getParameter("provee");

        String query = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' ";

        if (num_expe.equals("")) {
            query += " ";
        } else {
            query += " AND a.expediente = '" + expe + "' ";
        }

        if (prove.equals("R")) {
            String ruc = request.getParameter("provee_ruc");
            if (ruc.equals("")) {
                query += " ";
            } else {
                query += " AND a.ruc = '" + ruc + "' ";
            }
        }
        if (prove.equals("N")) {
            String nombre = request.getParameter("provee_nombre").toUpperCase().trim();
            if (nombre.equals("")) {
                query += " ";
            } else {
                String name = nombre.replaceAll(" ", "\\%");
                query += " AND (p.nombre ilike '%" + name + "%' OR b.nombre ilike '%" + name + "%') ";
            }
        }
        query += " GROUP BY a.ano_eje, a.sec_ejec, a.expediente, fu.fuente_financ, fu.nombre, tr.tipo_recurso, tr.nombre ORDER BY a.ano_eje, a.sec_ejec, a.expediente ASC ";
        List<Presupuesto> listEX = new PresupuestoDao().getExpedientesSIAF(query);

        HashMap outHash = new HashMap();
        outHash.put("listEX", listEX);
        outHash.put("query", query);
        outHash.put("ejec", ejec);
        outHash.put("año", año);
        outHash.put("tituloPDF", tituloPDF);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void notas_modificatorias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String filtP = request.getParameter("filtro_princ");
        String ejec = request.getParameter("ejec");
        String año = request.getParameter("anho");

        HashMap outHash = new HashMap();

        if (filtP.equals("00") // Resumen de Modificaciones por Documento
                || filtP.equals("01")) { // Resumen de Modificaciones por Nota

            String desde = request.getParameter("desde");
            String hasta = request.getParameter("hasta");
            String[] ciclo = request.getParameterValues("ciclo");
            String rubro_todo = request.getParameter("rubro_todo") == null ? "algunos" : "todos";
            String[] rubro = request.getParameterValues("rubro");
            String tipo_todo = request.getParameter("tipo_todo") == null ? "algunos" : "todos";
            String[] tipo = request.getParameterValues("tipo");

            List<Presupuesto> listMes1 = new PresupuestoDao().getListMeses(" WHERE mes = " + desde);
            List<Presupuesto> listMes2 = new PresupuestoDao().getListMeses(" WHERE mes = " + hasta);
            String mes1 = listMes1.get(0).getNombre();
            String mes2 = listMes2.get(0).getNombre();

            String meses = "MES DE " + mes1.toUpperCase() + " A " + mes2.toUpperCase();

            String query1 = "";
            String query2 = "";
            String titulo = "";
            if (ejec.equals("00")) {
                query2 += " WHERE a.ano_eje = '" + año + "' ";
                titulo += "Pliego " + pliego + " - Gobierno Regional San Martin";
            } else {
                query2 += " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' ";
                String queryE = " WHERE ano_eje = '" + año + "' AND sec_ejec = '" + ejec + "' AND pliego = '" + pliego + "' ";
                Presupuesto data = new PresupuestoDao().getEjecutora(queryE);
                String[] nombre_ejec = data.getNombre().split("-");
                titulo += "UE " + data.getEjecutora().trim() + " - " + nombre_ejec[1].trim() + " (" + ejec + ")";
            }
            query1 += " WHERE t.mes >= " + desde + " AND t.mes <= " + hasta + " ORDER BY t.mes, trim(t.num_doc) ASC ";

            if (ciclo[0].equals("G")) {
                String queryR = " WHERE a.ano_eje = '" + año + "' " + concatenado(rubro_todo, "a.fuente_financ", rubro)
                        + " GROUP BY a.fuente_financ, b.nombre ORDER BY a.fuente_financ ASC";
                List<Presupuesto> listRubro = new PresupuestoDao().getListNotasRubroGasto(queryR);
                for (Presupuesto data : listRubro) {
                    String query = query2 + concatenado(tipo_todo, "b.tipo_modificacion", tipo) + " AND a.fuente_financ = '" + data.getCodigo() + "' "
                            + "GROUP BY b.tipo_modificacion, c.timo_nombre ORDER BY b.tipo_modificacion ASC ";
                    List<Presupuesto> list = new PresupuestoDao().getListNotasTipoRubroGasto(query);
                    outHash.put("listTipoRubro" + data.getCodigo(), list);
                    for (Presupuesto dataT : list) {
                        String query2T = query2 + " AND a.fuente_financ = '" + data.getCodigo() + "' AND b.tipo_modificacion = '" + dataT.getCodigo() + "' ";
                        List<Presupuesto> listT = null;
                        if (filtP.equals("00")) {
                            listT = new PresupuestoDao().getListResumModifPresuGastoxDoc(query1, query2T);
                        }
                        if (filtP.equals("01")) {
                            listT = new PresupuestoDao().getListResumModifPresuGastoxNota(query2T);
                        }
                        outHash.put("listT_" + data.getCodigo() + "_" + dataT.getCodigo(), listT);
                    }
                }
                String queryG = " WHERE ano_eje = '" + año + "' AND tipo_transaccion = '2' AND estado = 'A' ORDER BY tipo_transaccion, generica ASC ";
                List<Presupuesto> listGenerica = new PresupuestoDao().getListNotasGenericas(queryG);
                outHash.put("listRubro", listRubro);
                outHash.put("listGenerica", listGenerica);
                outHash.put("ciclo", "gasto");
            }
            if (ciclo[0].equals("I")) {
                String queryR = " WHERE a.ano_eje = '" + año + "' " + concatenado(rubro_todo, "a.fuente_financ", rubro)
                        + " GROUP BY a.fuente_financ, b.nombre ORDER BY a.fuente_financ ASC";
                List<Presupuesto> listRubro = new PresupuestoDao().getListNotasRubroIngreso(queryR);
                for (Presupuesto data : listRubro) {
                    String query = query2 + concatenado(tipo_todo, "b.tipo_modificacion", tipo) + " AND a.fuente_financ = '" + data.getCodigo() + "' "
                            + "GROUP BY b.tipo_modificacion, c.timo_nombre ORDER BY b.tipo_modificacion ASC ";
                    List<Presupuesto> list = new PresupuestoDao().getListNotasTipoRubroIngreso(query);
                    outHash.put("listTipoRubro" + data.getCodigo(), list);
                    for (Presupuesto dataT : list) {
                        String query2T = query2 + " AND a.fuente_financ = '" + data.getCodigo() + "' AND b.tipo_modificacion = '" + dataT.getCodigo() + "' ";
                        List<Presupuesto> listT = null;
                        if (filtP.equals("00")) {
                            listT = new PresupuestoDao().getListResumModifPresuIngresoxDoc(query1, query2T);
                        }
                        if (filtP.equals("01")) {
                            listT = new PresupuestoDao().getListResumModifPresuIngresoxNota(query2T);
                        }
                        outHash.put("listT_" + data.getCodigo() + "_" + dataT.getCodigo(), listT);
                    }
                }
                String queryG = " WHERE ano_eje = '" + año + "' AND tipo_transaccion = '1' AND estado = 'A' ORDER BY tipo_transaccion, generica ASC ";
                List<Presupuesto> listGenerica = new PresupuestoDao().getListNotasGenericas(queryG);
                outHash.put("listRubro", listRubro);
                outHash.put("listGenerica", listGenerica);
                outHash.put("ciclo", "ingreso");
            }
            outHash.put("año", año);
            outHash.put("titulo", titulo);
            outHash.put("meses", meses);
        }

        if (filtP.equals("02")) { // Lista Resumen de Notas

            String queryE = " WHERE ano_eje = '" + año + "' AND sec_ejec = '" + ejec + "' AND pliego = '" + pliego + "' ";
            Presupuesto data = new PresupuestoDao().getEjecutora(queryE);
            String[] nombre_ejec = data.getNombre().split("-");
            String titulo = "UE " + data.getEjecutora().trim() + " - " + nombre_ejec[1].trim() + " (" + ejec + ")";

            String desde = request.getParameter("desde");
            String hasta = request.getParameter("hasta");
            String estado = request.getParameter("estado");
            String rubro_todo = request.getParameter("rubro_todo") == null ? "algunos" : "todos";
            String[] rubro = request.getParameterValues("rubro");
            String tipo_todo = request.getParameter("tipo_todo") == null ? "algunos" : "todos";
            String[] tipo = request.getParameterValues("tipo");

            String query1 = "";
            if (estado.equals("1")) {  // Aprobado
                query1 = " SELECT ano_eje, sec_ejec, sec_ejec2, sec_nota, secuencia, fecha, notas, estado, estado2, sec_doc, sec_doc_r "
                        + "FROM presupuesto.nota_modificatoria_sec EXCEPT SELECT a.ano_eje, a.sec_ejec, a.sec_ejec2, a.sec_nota, a.secuencia, "
                        + "a.fecha, a.notas, a.estado, a.estado2, a.sec_doc, a.sec_doc_r FROM presupuesto.nota_modificatoria_sec as a "
                        + "INNER JOIN presupuesto.nota_modificatoria_sec as b ON (a.ano_eje = b.ano_eje AND a.sec_ejec = b.sec_ejec "
                        + "AND a.sec_ejec2 = b.sec_ejec2 AND a.sec_nota = b.sec_nota AND b.secuencia = '0002') ";
            }
            if (estado.equals("2")) {  // Anulado
                query1 = " SELECT a.ano_eje, a.sec_ejec, a.sec_ejec2, a.sec_nota, a.secuencia, a.fecha, a.notas, a.estado, a.estado2, a.sec_doc, a.sec_doc_r "
                        + "FROM presupuesto.nota_modificatoria_sec as a INNER JOIN presupuesto.nota_modificatoria_sec as b ON (a.ano_eje = b.ano_eje AND "
                        + "a.sec_ejec = b.sec_ejec AND a.sec_ejec2 = b.sec_ejec2 AND a.sec_nota = b.sec_nota AND b.secuencia = '0002') ";
            }

            String query2 = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND a.mes_eje::int >= " + desde + " AND a.mes_eje::int <= " + hasta;
            query2 += " " + concatenado(rubro_todo, "f.fuente_financ", rubro);
            query2 += " " + concatenado(tipo_todo, "a.tipo_modificacion", tipo);
            query2 += " ORDER BY a.sec_nota, a.secuencia ASC ";

            List<Presupuesto> list = new PresupuestoDao().getListNotasNumero(query1, query2);

            outHash.put("list", list);
            outHash.put("query1", query1);
            outHash.put("query2", query2);
            outHash.put("ejec", ejec);
            outHash.put("año", año);
            outHash.put("titulo", titulo);

        }

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void ingreso_historico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String graph = request.getParameter("graph") == null ? "" : request.getParameter("graph");
        String sec_ejec = request.getParameter("ejec");
        String año_desde = request.getParameter("desde");
        String año_hasta = request.getParameter("hasta");
        String pdf = request.getParameter("pdf") == null ? "" : request.getParameter("pdf");

        String query;
        String titulo, tituloPDF;
        List<Presupuesto> list;
        if (sec_ejec.equals("00")) {
            query = "WHERE (ano_eje >= '" + año_desde + "' AND ano_eje <= '" + año_hasta + "') GROUP BY ano_eje ORDER BY ano_eje ASC";
            list = new PresupuestoDao().getRecaudacionHistorico(query);
            titulo = " Pliego " + pliego + " - Gobierno Regional San Martin - Recaudación Histórica";
            tituloPDF = "Pliego " + pliego + " - Gobierno Regional San Martin";
        } else {
            query = " WHERE a.sec_ejec = '" + sec_ejec + "' AND (a.ano_eje >= '" + año_desde + "' AND a.ano_eje <= '" + año_hasta + "') ORDER BY a.ano_eje ASC ";
            list = new PresupuestoDao().getEjecutoraRecaudacionHistorico(query);
            String[] nombre_ejec = list.get(0).getNombre().split("-");
            titulo = "UE " + list.get(0).getEjecutora().trim() + " - "
                    + nombre_ejec[1].trim() + " (" + list.get(0).getSec_ejec().trim() + ") - Recaudación Histórica";
            tituloPDF = "UE " + list.get(0).getEjecutora().trim() + " - " + nombre_ejec[1].trim() + " (" + list.get(0).getSec_ejec().trim() + ")";
        }

        if (graph.equals("true")) {
            String tituloX = "Año de Recaudación";
            String tituloY = "Recaudación de Ingreso (En millones de S/)";
            String formato = "png";
            int ancho = Integer.parseInt(request.getParameter("ancho"));
            int alto = Integer.parseInt(request.getParameter("alto"));
            int font_size = Integer.parseInt(request.getParameter("font"));
            double bar_width = Double.parseDouble(request.getParameter("bar"));
            String posicion = request.getParameter("pos");
            String pia = request.getParameter("pia");
            String pim = request.getParameter("pim");
            DefaultCategoryDataset objDataset = new DefaultCategoryDataset();
            DefaultCategoryDataset dataLine = new DefaultCategoryDataset();
            for (Presupuesto datos : list) {
                BigDecimal numeric = datos.getRecaudado();
                String año = datos.getAno_eje();
                if (pia.equals("si")) {
                    objDataset.setValue(millones(datos.getPia()), "PIA", año);
                }
                if (pim.equals("si")) {
                    objDataset.setValue(millones(datos.getPim()), "PIM", año);
                }
                objDataset.setValue(millones(numeric), "Recaudado", año);
                dataLine.setValue(millones(numeric), "Tendencia", año);
            }
            if (pia.equals("no") && pim.equals("no")) {
                String[] Leyenda = new String[1];
                if (pdf.equals("si")) {
                    chart.barraLineV_2D_pdf(request, response, objDataset, dataLine, Leyenda, "", tituloX, "Recaudación (millones S/)", 950, 400, 9, 0.10, formato, blanco, blanco, "in");
                } else {
                    chart.barraLineV_2D(request, response, objDataset, dataLine, Leyenda, titulo, tituloX, tituloY, ancho, alto, font_size, bar_width, formato, blanco, blanco, posicion);
                }
            } else {
                String[] Leyenda = new String[2];
                if (pia.equals("si") && pim.equals("si")) {
                    Leyenda = new String[3];
                }
                if (pdf.equals("si")) {
                    chart.barraSimpleV_2D_pdf(request, response, objDataset, Leyenda, "", tituloX, "Recaudación (millones S/)", 950, 400, 8, 0.10, formato, blanco, blanco, "in");
                } else {
                    chart.barraSimpleV_2D(request, response, objDataset, Leyenda, titulo, tituloX, tituloY, ancho, alto, font_size, bar_width, formato, blanco, blanco, posicion);
                }
            }
        } else {
            HashMap outHash = new HashMap();
            outHash.put("list", list);
            outHash.put("ejec", sec_ejec);
            outHash.put("desde", año_desde);
            outHash.put("hasta", año_hasta);
            outHash.put("titulo", titulo.toUpperCase());
            outHash.put("tituloPDF", tituloPDF);

            Gson gson = new Gson();
            String arg = gson.toJson(outHash);
            response.getWriter().print(arg);
        }

    }

    private void ingreso_anual(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String ejec = request.getParameter("ejec");
        String año = request.getParameter("anho");
        String filtP = request.getParameter("filtro_princ");

        if (filtP.equals("01")) { // Ejecucion Mensualizada

            String tituloPDF;
            String query = "";
            String tipo = "";

            if (ejec.equals("00")) {
                query += " WHERE a.ano_eje = '" + año + "' AND a.ciclo = 'I' AND a.fase = 'R' AND a.estado_envio = 'A' AND a.id_clasificador != 'AAAAAAA' ";
                tituloPDF = "Pliego " + pliego + " - Gobierno Regional San Martin";
            } else {
                query += " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND a.ciclo = 'I' AND a.fase = 'R' "
                        + "AND a.estado_envio = 'A' AND a.id_clasificador != 'AAAAAAA' ";
                String queryE = " WHERE ano_eje = '" + año + "' AND sec_ejec = '" + ejec + "' AND pliego = '" + pliego + "' ";
                Presupuesto data = new PresupuestoDao().getEjecutora(queryE);
                String[] nombre_ejec = data.getNombre().split("-");
                tituloPDF = "UE " + data.getEjecutora().trim() + " - " + nombre_ejec[1].trim() + " (" + ejec + ")";
            }

            List<Presupuesto> list = null;

            if (request.getParameter("filtroMensual_ninguno") != null) {
                query += "";
                list = new PresupuestoDao().getRecaudacionMensualizada(query);
                tipo = "00";
            }
            if (request.getParameter("filtroMensual_fuente") != null) { // Fuente de Financiamiento
                String[] filtroM = request.getParameterValues("filtro_01");
                query += " AND fu.fuente_financ_agregada = '" + filtroM[0] + "' ";
                list = new PresupuestoDao().getRecaudacionMensualizada(query);
                tipo = "01";
            }
            if (request.getParameter("filtroMensual_rubro") != null) { // Rubro de Financiamiento
                String[] filtroM = request.getParameterValues("filtro_02");
                query += " AND ru.fuente_financ = '" + filtroM[0] + "' ";
                list = new PresupuestoDao().getRecaudacionMensualizada(query);
                tipo = "02";
            }
            if (request.getParameter("filtroMensual_catingre") != null) {  // Categoría de Ingreso
                String[] filtroM = request.getParameterValues("filtro_03");
                query += " AND ci.categoria_ingreso = '" + filtroM[0] + "' ";
                list = new PresupuestoDao().getRecaudacionMensualizada(query);
                tipo = "03";
            }
            if (request.getParameter("filtroMensual_generica") != null) { // Genérica de Ingreso
                String[] filtroM = request.getParameterValues("filtro_04");
                query += " AND ge.clasificador = '" + filtroM[0] + "' ";
                list = new PresupuestoDao().getRecaudacionMensualizada(query);
                tipo = "04";
            }
            if (request.getParameter("filtroMensual_subgenerica") != null) { // Sub Genérica de Ingreso
                String[] filtroM = request.getParameterValues("filtro_05");
                query += " AND sg.clasificador = '" + filtroM[0] + "' ";
                list = new PresupuestoDao().getRecaudacionMensualizada(query);
                tipo = "05";
            }
            if (request.getParameter("filtroMensual_subgenericadet") != null) { // Sub Genérica Detallada de Ingreso
                String[] filtroM = request.getParameterValues("filtro_06");
                query += " AND sgd.clasificador = '" + filtroM[0] + "' ";
                list = new PresupuestoDao().getRecaudacionMensualizada(query);
                tipo = "06";
            }
            if (request.getParameter("filtroMensual_especifica") != null) { // Especifica de Ingreso
                String[] filtroM = request.getParameterValues("filtro_07");
                query += " AND es.clasificador = '" + filtroM[0] + "' ";
                list = new PresupuestoDao().getRecaudacionMensualizada(query);
                tipo = "07";
            }
            if (request.getParameter("filtroMensual_especificadet") != null) { // Especifica Detallada de Ingreso
                String[] filtroM = request.getParameterValues("filtro_08");
                query += " AND ed.clasificador = '" + filtroM[0] + "' ";
                list = new PresupuestoDao().getRecaudacionMensualizada(query);
                tipo = "08";
            }
            if (request.getParameter("filtroMensual_banco") != null) { // Banco
                String[] filtroM = request.getParameterValues("filtro_09");
                query += " AND ba.banco = '" + filtroM[0] + "' ";
                list = new PresupuestoDao().getRecaudacionMensualizada(query);
                tipo = "09";
            }
            if (request.getParameter("filtroMensual_tiporecur") != null) { // Tipo de Recurso
                String[] filtroM = request.getParameterValues("filtro_10");
                String[] tipo_recurso = filtroM[0].split("-");
                query += " AND (tr.tipo_recurso = '" + tipo_recurso[0] + "' AND fu.fuente_financ_agregada = '" + tipo_recurso[1] + "') ";
                list = new PresupuestoDao().getRecaudacionMensualizada(query);
                tipo = "10";
            }
            if (request.getParameter("filtroMensual_ctacte") != null) { // Cuenta Corriente
                String[] filtroM = request.getParameterValues("filtro_11");
                String[] cta_cte = filtroM[0].split("-");
                query += " AND (cc.cta_cte = '" + cta_cte[0] + "' AND cc.banco = '" + cta_cte[1] + "' AND cc.ano_eje = '" + cta_cte[2] + "') ";
                list = new PresupuestoDao().getRecaudacionMensualizada(query);
                tipo = "11";
            }

            HashMap outHash = new HashMap();
            outHash.put("list", list);
            outHash.put("ejec", ejec);
            outHash.put("año", año);
            outHash.put("query", query);
            outHash.put("tipoM", tipo);
            outHash.put("tituloPDF", tituloPDF);

            Gson gson = new Gson();
            String arg = gson.toJson(outHash);
            response.getWriter().print(arg);

        } else {

            String filtro_todo = request.getParameter("filtro_todo") == null ? "algunos" : "todos";
            String[] filtro = request.getParameterValues("filtro");

            String tituloPDF;
            String select1 = "";
            String select2 = "";
            String query_where;
            String query_group1 = "";
            String query_group2 = "";
            String query_order = "";
            String query1;
            String query2;
            String subtipo = "";

            HashMap outHash = new HashMap();

            if (ejec.equals("00")) {
                query_where = " WHERE f1.ano_eje = '" + año + "' AND f1.id_clasificador != 'AAAAAAA' ";
                tituloPDF = "Pliego " + pliego + " - Gobierno Regional de San Martín";
            } else {
                query_where = " WHERE f1.ano_eje = '" + año + "' AND f1.sec_ejec = '" + ejec + "' AND f1.id_clasificador != 'AAAAAAA' ";
                String queryE = " WHERE ano_eje = '" + año + "' AND sec_ejec = '" + ejec + "' AND pliego = '" + pliego + "' ";
                Presupuesto data = new PresupuestoDao().getEjecutora(queryE);
                String[] nombre_ejec = data.getNombre().split("-");
                tituloPDF = "UE " + data.getEjecutora().trim() + " - " + nombre_ejec[1].trim() + " (" + ejec + ")";
                outHash.put("ejecutora", data.getEjecutora().trim());
                outHash.put("nombre_ejec", nombre_ejec[1].trim());
            }

            if (filtP.equals("00")) { // Total
                select1 += "";
                select2 += "";
                query_where += "";
                query_group1 += " GROUP BY ";
                query_group2 += "";
                query_order += "";
            }
            if (filtP.equals("02")) { // Fuente de Financiamiento                
                String tipo_recurso_ninguno = request.getParameter("tipo_recurso_ninguno") == null ? "" : request.getParameter("tipo_recurso_ninguno");
                String tipo_recurso_todo = request.getParameter("tipo_recurso_todo") == null ? "algunos" : "todos";
                String[] tipo_recurso = request.getParameterValues("tipo_recurso");
                select1 += "f1.codigo, f1.nombre,";
                select2 += "fu.fuente_financ_agregada as codigo, trim(fu.nombre) as nombre,";
                query_where += concatenado(filtro_todo, "fu.fuente_financ_agregada", filtro);
                query_group1 += " GROUP BY fu.fuente_financ_agregada, fu.nombre,";
                query_group2 += " GROUP BY f1.codigo, f1.nombre";
                query_order += " ORDER BY f1.codigo";
                if (tipo_recurso_ninguno.equals("")) {
                    select1 += " f1.tipo_recurso, f1.nombre_tipo_recurso,";
                    select2 += " tr.tipo_recurso, trim(tr.nombre) as nombre_tipo_recurso,";
                    query_where += concatenado(tipo_recurso_todo, "tr.tipo_recurso", tipo_recurso);
                    query_group1 += " tr.tipo_recurso, tr.nombre,";
                    query_group2 += ", f1.tipo_recurso, f1.nombre_tipo_recurso";
                    query_order += ", f1.tipo_recurso";
                    subtipo = "tipo_rec";
                }
            }
            if (filtP.equals("03")) { // Rubro de Financiamiento
                select1 += "f1.codigo, f1.nombre,";
                select2 += "ru.fuente_financ as codigo, trim(ru.nombre) as nombre,";
                query_where += concatenado(filtro_todo, "ru.fuente_financ", filtro);
                query_group1 += " GROUP BY ru.fuente_financ, ru.nombre,";
                query_group2 += " GROUP BY f1.codigo, f1.nombre";
                query_order += " ORDER BY f1.codigo";
            }
            if (filtP.equals("04")) { // Categoría de Ingreso
                select1 += "f1.codigo, f1.nombre,";
                select2 += "ci.categoria_ingreso as codigo, trim(ci.descripcion) as nombre,";
                query_where += concatenado(filtro_todo, "ci.categoria_ingreso", filtro);
                query_group1 += " GROUP BY ci.categoria_ingreso, ci.descripcion,";
                query_group2 += " GROUP BY f1.codigo, f1.nombre";
                query_order += " ORDER BY f1.codigo";
            }
            if (filtP.equals("05")) { // Genérica de Ingreso
                select1 += "f1.codigo, f1.nombre, f1.tipo_transaccion, f1.generica,";
                select2 += "ge.clasificador as codigo, trim(ge.descripcion) as nombre, ge.tipo_transaccion, ge.generica,";
                query_where += concatenado(filtro_todo, "ge.clasificador", filtro);
                query_group1 += " GROUP BY ge.clasificador, ge.descripcion, ge.tipo_transaccion, ge.generica,";
                query_group2 += " GROUP BY f1.codigo, f1.nombre, f1.tipo_transaccion, f1.generica";
                query_order += " ORDER BY trim(f1.tipo_transaccion)::int, trim(f1.generica)::int";
            }
            if (filtP.equals("06")) { // Sub Genérica de Ingreso
                select1 += "f1.codigo, f1.nombre, f1.tipo_transaccion, f1.generica, f1.subgenerica,";
                select2 += "sg.clasificador as codigo, trim(sg.descripcion) as nombre, sg.tipo_transaccion, sg.generica, sg.subgenerica,";
                query_where += concatenado(filtro_todo, "sg.clasificador", filtro);
                query_group1 += " GROUP BY sg.clasificador, sg.descripcion, sg.tipo_transaccion, sg.generica, sg.subgenerica,";
                query_group2 += " GROUP BY f1.codigo, f1.nombre, f1.tipo_transaccion, f1.generica, f1.subgenerica";
                query_order += " ORDER BY trim(f1.tipo_transaccion)::int, trim(f1.generica)::int, trim(f1.subgenerica)::int";
            }
            if (filtP.equals("07")) { // Sub Genérica Detallada de Ingreso
                select1 += "f1.codigo, f1.nombre, f1.tipo_transaccion, f1.generica, f1.subgenerica, f1.subgenerica_det,";
                select2 += "sgd.clasificador as codigo, trim(sgd.descripcion) as nombre, sgd.tipo_transaccion, sgd.generica, "
                        + "sgd.subgenerica, sgd.subgenerica_det,";
                query_where += concatenado(filtro_todo, "sgd.clasificador", filtro);
                query_group1 += " GROUP BY sgd.clasificador, sgd.descripcion, sgd.tipo_transaccion, sgd.generica, sgd.subgenerica, sgd.subgenerica_det,";
                query_group2 += " GROUP BY f1.codigo, f1.nombre, f1.tipo_transaccion, f1.generica, f1.subgenerica, f1.subgenerica_det";
                query_order += " ORDER BY trim(f1.tipo_transaccion)::int, trim(f1.generica)::int, trim(f1.subgenerica)::int, trim(f1.subgenerica_det)::int";
            }
            if (filtP.equals("08")) { // Especifica de Ingreso
                select1 += "f1.codigo, f1.nombre, f1.tipo_transaccion, f1.generica, f1.subgenerica, f1.subgenerica_det, f1.especifica,";
                select2 += "es.clasificador as codigo, trim(es.descripcion) as nombre, es.tipo_transaccion, "
                        + "es.generica, es.subgenerica, es.subgenerica_det, es.especifica,";
                query_where += concatenado(filtro_todo, "es.clasificador", filtro);
                query_group1 += " GROUP BY es.clasificador, es.descripcion, es.tipo_transaccion, es.generica, es.subgenerica, es.subgenerica_det, es.especifica,";
                query_group2 += " GROUP BY f1.codigo, f1.nombre, f1.tipo_transaccion, f1.generica, f1.subgenerica, f1.subgenerica_det, f1.especifica";
                query_order += " ORDER BY trim(f1.tipo_transaccion)::int, trim(f1.generica)::int, trim(f1.subgenerica)::int, trim(f1.subgenerica_det)::int, "
                        + "trim(f1.especifica)::int";
            }
            if (filtP.equals("09")) { // Especifica Detallada de Gasto
                select1 += "f1.codigo, f1.nombre, f1.tipo_transaccion, f1.generica, f1.subgenerica, f1.subgenerica_det, f1.especifica, f1.especifica_det,";
                select2 += "ed.clasificador as codigo, trim(ed.descripcion) as nombre, ed.tipo_transaccion, ed.generica, ed.subgenerica, "
                        + "ed.subgenerica_det, ed.especifica, ed.especifica_det,";
                query_where += concatenado(filtro_todo, "ed.clasificador", filtro);
                query_group1 += " GROUP BY ed.clasificador, ed.descripcion, ed.tipo_transaccion, ed.generica, ed.subgenerica, ed.subgenerica_det, ed.especifica, ed.especifica_det,";
                query_group2 += " GROUP BY f1.codigo, f1.nombre, f1.tipo_transaccion, f1.generica, f1.subgenerica, f1.subgenerica_det, f1.especifica, f1.especifica_det";
                query_order += " ORDER BY trim(f1.tipo_transaccion)::int, trim(f1.generica)::int, trim(f1.subgenerica)::int, trim(f1.subgenerica_det)::int, "
                        + "trim(f1.especifica)::int, trim(f1.especifica_det)::int";
            }
            if (filtP.equals("10")) { // Banco
                String cta_cte_ninguno = request.getParameter("cta_cte_ninguno") == null ? "" : request.getParameter("cta_cte_ninguno");
                String cta_cte_todo = request.getParameter("cta_cte_todo") == null ? "algunos" : "todos";
                String[] cta_cte = request.getParameterValues("cta_cte");
                select1 += "f1.codigo, f1.nombre,";
                select2 += "b.banco as codigo, trim(b.nombre) as nombre,";
                query_where += concatenado(filtro_todo, "b.banco", filtro);
                query_group1 += " GROUP BY b.banco, b.nombre,";
                query_group2 += " GROUP BY f1.codigo, f1.nombre";
                query_order += " ORDER BY f1.codigo";
                if (cta_cte_ninguno.equals("")) {
                    select1 += " f1.cta_cte, f1.nombre_cta_cte, f1.ano_eje,";
                    select2 += " cc.cta_cte, trim(cc.nombre) as nombre_cta_cte, cc.ano_eje,";
                    query_where += concatenado2(cta_cte_todo, "cc.cta_cte", "cc.ano_eje", cta_cte);
                    query_group1 += " cc.cta_cte, cc.nombre, cc.ano_eje,";
                    query_group2 += ", f1.cta_cte, f1.nombre_cta_cte, f1.ano_eje";
                    query_order += ", f1.cta_cte, f1.ano_eje";
                    subtipo = "cta_cte";
                }
            }

            List<String> listArray = new ArrayList<>();

            if (request.getParameter("filtroS_ninguno") != null) {
                select1 += "";
                select2 += "";
                query_where += "";
                query_group1 += "";
                query_group2 += "";
                query_order += "";
            }
            if (request.getParameter("filtroS_ejecutora") != null) { // Unidades Ejecutoras
                String filtro_todoS = request.getParameter("filtro_todo_01") == null ? "algunos" : "todos";
                String[] filtroS = request.getParameterValues("filtro_01");
                select1 += " f1.sec_ejec, f1.ejecutora, f1.nombre_ejecutora,";
                select2 += " ej.sec_ejec, ej.ejecutora, trim(ej.nombre) as nombre_ejecutora,";
                query_where += concatenado(filtro_todoS, "ej.sec_ejec", filtroS);
                query_group1 += " ej.sec_ejec, ej.ejecutora, ej.nombre,";
                query_group2 += ", f1.sec_ejec, f1.ejecutora, f1.nombre_ejecutora";
                query_order += ", f1.ejecutora";
                listArray.add("ejecutora");
            }
            if (request.getParameter("filtroS_fuente") != null) { // Fuente de Financiamiento
                String filtro_todoS = request.getParameter("filtro_todo_02") == null ? "algunos" : "todos";
                String[] filtroS = request.getParameterValues("filtro_02");
                select1 += " f1.fuente_financ_agregada, f1.nombre_fuente_financ_agregada,";
                select2 += " fu.fuente_financ_agregada, trim(fu.nombre) as nombre_fuente_financ_agregada,";
                query_where += concatenado(filtro_todoS, "fu.fuente_financ_agregada", filtroS);
                query_group1 += " fu.fuente_financ_agregada, fu.nombre,";
                query_group2 += ", f1.fuente_financ_agregada, f1.nombre_fuente_financ_agregada";
                query_order += ", f1.fuente_financ_agregada";
                listArray.add("fuente_financ_agregada");
            }
            if (request.getParameter("filtroS_rubro") != null) { // Rubro de Financiamiento
                String filtro_todoS = request.getParameter("filtro_todo_03") == null ? "algunos" : "todos";
                String[] filtroS = request.getParameterValues("filtro_03");
                select1 += " f1.fuente_financ, f1.nombre_fuente_financ,";
                select2 += " ru.fuente_financ, trim(ru.nombre) as nombre_fuente_financ,";
                query_where += concatenado(filtro_todoS, "ru.fuente_financ", filtroS);
                query_group1 += " ru.fuente_financ, ru.nombre,";
                query_group2 += ", f1.fuente_financ, f1.nombre_fuente_financ";
                query_order += ", f1.fuente_financ";
                listArray.add("fuente_financ");
            }
            if (request.getParameter("filtroS_catingre") != null) {  // Categoría de Ingreso
                String filtro_todoS = request.getParameter("filtro_todo_04") == null ? "algunos" : "todos";
                String[] filtroS = request.getParameterValues("filtro_04");
                select1 += " f1.categoria_ingreso, f1.nombre_categoria_ingreso,";
                select2 += " ci.categoria_ingreso, trim(ci.descripcion) as nombre_categoria_ingreso,";
                query_where += concatenado(filtro_todoS, "ci.categoria_ingreso", filtroS);
                query_group1 += " ci.categoria_ingreso, ci.descripcion,";
                query_group2 += ", f1.categoria_ingreso, f1.nombre_categoria_ingreso";
                query_order += ", f1.categoria_ingreso";
                listArray.add("categoria_ingreso");
            }
            if (request.getParameter("filtroS_generica") != null) { // Genérica de Gasto
                String filtro_todoS = request.getParameter("filtro_todo_05") == null ? "algunos" : "todos";
                String[] filtroS = request.getParameterValues("filtro_05");
                select1 += " f1.generica_clasif, f1.nombre_generica_clasif, f1.tipo_transaccion, f1.generica,";
                select2 += " ge.clasificador as generica_clasif, trim(ge.descripcion) as nombre_generica_clasif, ge.tipo_transaccion, ge.generica,";
                query_where += concatenado(filtro_todoS, "ge.clasificador", filtroS);
                query_group1 += " ge.clasificador, ge.descripcion, ge.tipo_transaccion, ge.generica,";
                query_group2 += ", f1.generica_clasif, f1.nombre_generica_clasif, f1.tipo_transaccion, f1.generica";
                query_order += ", trim(f1.tipo_transaccion)::int, trim(f1.generica)::int";
                listArray.add("generica_clasif");
            }
            if (request.getParameter("filtroS_subgenerica") != null) { // Sub Genérica de Gasto
                String filtro_todoS = request.getParameter("filtro_todo_06") == null ? "algunos" : "todos";
                String[] filtroS = request.getParameterValues("filtro_06");
                select1 += " f1.subgenerica_clasif, f1.nombre_subgenerica_clasif, f1.tipo_transaccion, f1.generica, f1.subgenerica,";
                select2 += " sg.clasificador as subgenerica_clasif, trim(sg.descripcion) as nombre_subgenerica_clasif, sg.tipo_transaccion, sg.generica, sg.subgenerica,";
                query_where += concatenado(filtro_todoS, "sg.clasificador", filtroS);
                query_group1 += " sg.clasificador, sg.descripcion, sg.tipo_transaccion, sg.generica, sg.subgenerica,";
                query_group2 += ", f1.subgenerica_clasif, f1.nombre_subgenerica_clasif, f1.tipo_transaccion, f1.generica, f1.subgenerica";
                query_order += ", trim(f1.tipo_transaccion)::int, trim(f1.generica)::int, trim(f1.subgenerica)::int";
                listArray.add("subgenerica_clasif");
            }
            if (request.getParameter("filtroS_subgenericadet") != null) { // Sub Genérica Detallada de Gasto
                String filtro_todoS = request.getParameter("filtro_todo_07") == null ? "algunos" : "todos";
                String[] filtroS = request.getParameterValues("filtro_07");
                select1 += " f1.subgenerica_det_clasif, f1.nombre_subgenerica_det_clasif, f1.tipo_transaccion, f1.generica, "
                        + "f1.subgenerica, f1.subgenerica_det,";
                select2 += " sgd.clasificador as subgenerica_det_clasif, trim(sgd.descripcion) as nombre_subgenerica_det_clasif, sgd.tipo_transaccion, sgd.generica, "
                        + "sgd.subgenerica, sgd.subgenerica_det,";
                query_where += concatenado(filtro_todoS, "sgd.clasificador", filtroS);
                query_group1 += " sgd.clasificador, sgd.descripcion, sgd.tipo_transaccion, sgd.generica, sgd.subgenerica, sgd.subgenerica_det,";
                query_group2 += ", f1.subgenerica_det_clasif, f1.nombre_subgenerica_det_clasif, f1.tipo_transaccion, f1.generica, "
                        + "f1.subgenerica, f1.subgenerica_det";
                query_order += ", trim(f1.tipo_transaccion)::int, trim(f1.generica)::int, trim(f1.subgenerica)::int, trim(f1.subgenerica_det)::int";
                listArray.add("subgenerica_det_clasif");
            }
            if (request.getParameter("filtroS_especifica") != null) { // Especifica de Gasto
                String filtro_todoS = request.getParameter("filtro_todo_08") == null ? "algunos" : "todos";
                String[] filtroS = request.getParameterValues("filtro_08");
                select1 += " f1.especifica_clasif, f1.nombre_especifica_clasif, f1.tipo_transaccion, "
                        + "f1.generica, f1.subgenerica, f1.subgenerica_det, f1.especifica,";
                select2 += " es.clasificador as especifica_clasif, trim(es.descripcion) as nombre_especifica_clasif, es.tipo_transaccion, "
                        + "es.generica, es.subgenerica, es.subgenerica_det, es.especifica,";
                query_where += concatenado(filtro_todoS, "es.clasificador", filtroS);
                query_group1 += " es.clasificador, es.descripcion, es.tipo_transaccion, es.generica, es.subgenerica, es.subgenerica_det, es.especifica,";
                query_group2 += ", f1.especifica_clasif, f1.nombre_especifica_clasif, f1.tipo_transaccion, "
                        + "f1.generica, f1.subgenerica, f1.subgenerica_det, f1.especifica";
                query_order += ", trim(f1.tipo_transaccion)::int, trim(f1.generica)::int, trim(f1.subgenerica)::int, trim(f1.subgenerica_det)::int, trim(f1.especifica)::int";
                listArray.add("especifica_clasif");
            }
            if (request.getParameter("filtroS_especificadet") != null) { // Especifica Detallada de Gasto
                String filtro_todoS = request.getParameter("filtro_todo_09") == null ? "algunos" : "todos";
                String[] filtroS = request.getParameterValues("filtro_09");
                select1 += " f1.especifica_det_clasif, f1.nombre_especifica_det_clasif, f1.tipo_transaccion, f1.generica, f1.subgenerica, "
                        + "f1.subgenerica_det, f1.especifica, f1.especifica_det,";
                select2 += " ed.clasificador as especifica_det_clasif, trim(ed.descripcion) as nombre_especifica_det_clasif, ed.tipo_transaccion, ed.generica, ed.subgenerica, "
                        + "ed.subgenerica_det, ed.especifica, ed.especifica_det,";
                query_where += concatenado(filtro_todoS, "ed.clasificador", filtroS);
                query_group1 += " ed.clasificador, ed.descripcion, ed.tipo_transaccion, ed.generica, ed.subgenerica, ed.subgenerica_det, ed.especifica, ed.especifica_det,";
                query_group2 += ", f1.especifica_det_clasif, f1.nombre_especifica_det_clasif, f1.tipo_transaccion, f1.generica, f1.subgenerica, "
                        + "f1.subgenerica_det, f1.especifica, f1.especifica_det";
                query_order += ", trim(f1.tipo_transaccion)::int, trim(f1.generica)::int, trim(f1.subgenerica)::int, trim(f1.subgenerica_det)::int, "
                        + "trim(f1.especifica)::int, trim(f1.especifica_det)::int";
                listArray.add("especifica_det_clasif");
            }
            if (request.getParameter("filtroS_banco") != null) { // Banco
                String filtro_todoS = request.getParameter("filtro_todo_10") == null ? "algunos" : "todos";
                String[] filtroS = request.getParameterValues("filtro_10");
                select1 += " f1.banco, f1.nombre_banco,";
                select2 += " b.banco, trim(b.nombre) as nombre_banco,";
                query_where += concatenado(filtro_todoS, "b.banco", filtroS);
                query_group1 += " b.banco, b.nombre,";
                query_group2 += ", f1.banco, f1.nombre_banco";
                query_order += ", f1.banco";
                listArray.add("banco");
            }

            String[] array = new String[listArray.size()];
            listArray.toArray(array);

            query_group1 += " i.pia, i.modificacion, i.pim";

            query1 = query_where + query_group1;
            if (filtP.equals("00")) {
                query2 = query_group2 + query_order;
            } else {
                query2 = query_group2 + query_order + " ASC";
            }

            List<Presupuesto> list = new PresupuestoDao().getRecaudacionAnual(select1, select2, query1, query2);

            outHash.put("list", list);
            outHash.put("ejec", ejec);
            outHash.put("año", año);
            outHash.put("select1", select1);
            outHash.put("select2", select2);
            outHash.put("query1", query1);
            outHash.put("query2", query2);
            outHash.put("filtro", filtP);
            outHash.put("tituloPDF", tituloPDF);
            outHash.put("array", array);
            outHash.put("subtipo", subtipo);

            Gson gson = new Gson();
            String arg = gson.toJson(outHash);
            response.getWriter().print(arg);

        }

    }

    private void ingreso_mensualizado_grafica(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String[] meses = request.getParameterValues("mes");
        String[] array = request.getParameterValues("array");
        String pdf = request.getParameter("pdf") == null ? "" : request.getParameter("pdf");

        String titulo = request.getParameter("titu");
        String subtitulo = request.getParameter("subtitu");
        String tituloX = "Mes de Recaudación";
        String tituloY = "Recaudación de Ingreso (En miles de S/)";
        String formato = "png";
        int ancho = Integer.parseInt(request.getParameter("ancho"));
        int alto = Integer.parseInt(request.getParameter("alto"));
        int font_size = Integer.parseInt(request.getParameter("font"));
        double bar_width = Double.parseDouble(request.getParameter("bar"));
        String pos = request.getParameter("pos");
        Paint color_letra = null;
        if (pos.equals("in")) {
            color_letra = blanco;
        }
        if (pos.equals("out")) {
            color_letra = negro;
        }

        DefaultCategoryDataset objDataset = new DefaultCategoryDataset();
        DefaultCategoryDataset dataLine = new DefaultCategoryDataset();

        for (int i = 0; i < meses.length; i++) {
            BigDecimal numeric = new BigDecimal(array[i]);
            String mes = meses[i];
            objDataset.setValue(miles(numeric), "Recaudado", mes);
            dataLine.setValue(miles(numeric), "Tendencia", mes);
        }
        String[] Leyenda = new String[1];
        if (pdf.equals("si")) {
            chart.barraLineV_2D_Sub_pdf(request, response, objDataset, dataLine, Leyenda, "", "", "Recaudado", tituloX, "Recaudación (miles S/)", 950, 500, 9, 0.05, formato, blanco, color_letra, pos);
        } else {
            chart.barraLineV_2D_Sub(request, response, objDataset, dataLine, Leyenda, titulo, subtitulo, "Recaudado", tituloX, tituloY, ancho, alto, font_size, bar_width, formato, blanco, color_letra, pos);
        }

    }

    private void resumen_ejecucion_grafica1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        Integer año = Integer.parseInt(request.getParameter("año"));
        String ejec = request.getParameter("ejec");

        LocalDate ld = LocalDate.now();
        int mes_actual = ld.getMonthValue();
        int año_actual = ld.getYear();

        String query1, query2;
        List<Presupuesto> list1, list2;
        if (ejec.equals("00")) {
            if (año_actual == año) {
                query1 = " WHERE a.ano_eje = '" + (año - 1) + "' AND date_part('month', b.fecha_doc)::int <= " + mes_actual + " "
                        + "AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' "
                        + "GROUP BY a.ano_eje, d.pim ";
                query2 = " WHERE a.ano_eje = '" + año + "' AND date_part('month', b.fecha_doc)::int <= " + mes_actual + " "
                        + "AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' "
                        + "GROUP BY a.ano_eje, d.pim ";
            } else {
                query1 = " WHERE a.ano_eje = '" + (año - 1) + "' AND date_part('month', b.fecha_doc)::int <= 12 "
                        + "AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' "
                        + "GROUP BY a.ano_eje, d.pim ";
                query2 = " WHERE a.ano_eje = '" + año + "' AND date_part('month', b.fecha_doc)::int <= 12 "
                        + "AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' "
                        + "GROUP BY a.ano_eje, d.pim ";
            }
            list1 = new PresupuestoDao().getMensualizadoHistorico(query1);
            list2 = new PresupuestoDao().getMensualizadoHistorico(query2);
        } else {
            if (año_actual == año) {
                query1 = " WHERE a.ano_eje = '" + (año - 1) + "' AND a.sec_ejec = '" + ejec + "' AND "
                        + "date_part('month', b.fecha_doc)::int <= " + mes_actual + " AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' "
                        + "GROUP BY a.ano_eje, d.pim ";
                query2 = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND "
                        + "date_part('month', b.fecha_doc)::int <= " + mes_actual + " AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' "
                        + "GROUP BY a.ano_eje, d.pim ";
            } else {
                query1 = " WHERE a.ano_eje = '" + (año - 1) + "' AND a.sec_ejec = '" + ejec + "' AND "
                        + "date_part('month', b.fecha_doc)::int <= 12 AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' "
                        + "GROUP BY a.ano_eje, d.pim ";
                query2 = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND "
                        + "date_part('month', b.fecha_doc)::int <= 12 AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' "
                        + "GROUP BY a.ano_eje, d.pim ";
            }
            list1 = new PresupuestoDao().getMensualizadoHistorico(query1);
            list2 = new PresupuestoDao().getMensualizadoHistorico(query2);
        }
        String tituloY = "Ejecución (millones S/)";
        String formato = "png";
        int ancho = Integer.parseInt(request.getParameter("ancho"));
        int alto = Integer.parseInt(request.getParameter("alto"));
        int font_size = Integer.parseInt(request.getParameter("font"));
        double bar_width = Double.parseDouble(request.getParameter("bar"));
        DefaultCategoryDataset objDataset = new DefaultCategoryDataset();
        DefaultCategoryDataset objDataset2 = new DefaultCategoryDataset();
        if (list1.isEmpty()) {
            objDataset.setValue(0.00, (año - 1) + "", "Comparativo Anual");
        } else {
            list1.forEach((datos) -> {
                BigDecimal numeric, pim, porc;
                if (datos.getDevengado() == null) {
                    numeric = BigDecimal.ZERO;
                } else {
                    numeric = datos.getDevengado();
                }
                if (datos.getPim() == null || datos.getPim().compareTo(BigDecimal.ZERO) == 0) {
                    porc = BigDecimal.ZERO;
                } else {
                    pim = datos.getPim();
                    porc = porcentaje(numeric, pim);
                }
                objDataset.setValue(millones(numeric), (año - 1) + "", "Comparativo Anual");
                objDataset2.setValue(millones(numeric), porc + " %", "Comparativo Anual");
            });
        }
        if (list2.isEmpty()) {
            objDataset.setValue(0.00, año + "", "Comparativo Anual");
        } else {
            list2.forEach((datos) -> {
                BigDecimal numeric, pim, porc;
                if (datos.getDevengado() == null) {
                    numeric = BigDecimal.ZERO;
                } else {
                    numeric = datos.getDevengado();
                }
                if (datos.getPim() == null || datos.getPim().compareTo(BigDecimal.ZERO) == 0) {
                    porc = BigDecimal.ZERO;
                } else {
                    pim = datos.getPim();
                    porc = porcentaje(numeric, pim);
                }
                objDataset.setValue(millones(numeric), año + "", "Comparativo Anual");
                objDataset2.setValue(millones(numeric), porc + " %", "Comparativo Anual");
            });
        }
        String[] Leyenda = new String[10];
        if (request.getParameter("pdf").equals("si")) {
            chart.barraSimpleV_X2_2D_pdf(request, response, objDataset, objDataset2, Leyenda, "", "", tituloY, ancho, alto, font_size, bar_width, formato, blanco, semi_negro);
        }
        if (request.getParameter("pdf").equals("no")) {
            chart.barraSimpleV_X2_2D(request, response, objDataset, objDataset2, Leyenda, "", "", tituloY, ancho, alto, font_size, bar_width, formato, blanco, blanco, semi_negro);
        }

    }

    private void resumen_ejecucion_grafica2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        Integer año = Integer.parseInt(request.getParameter("año"));
        String ejec = request.getParameter("ejec");

        LocalDate ld = LocalDate.now();
        int mes_actual = ld.getMonthValue();
        int año_actual = ld.getYear();

        String queryP1, queryP2, query1, query2;
        List<Presupuesto> listP1, listP2, list1, list2;
        if (ejec.equals("00")) {
            if (año_actual == año) {
                query1 = " WHERE a.ano_eje = '" + (año - 1) + "' AND date_part('month', b.fecha_doc)::int <= " + mes_actual + " "
                        + "AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' AND c.act_proy ilike '2%' "
                        + "GROUP BY a.ano_eje, d.pim ";
                query2 = " WHERE a.ano_eje = '" + año + "' AND date_part('month', b.fecha_doc)::int <= " + mes_actual + " "
                        + "AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' AND c.act_proy ilike '2%' "
                        + "GROUP BY a.ano_eje, d.pim ";
            } else {
                query1 = " WHERE a.ano_eje = '" + (año - 1) + "' AND date_part('month', b.fecha_doc)::int <= 12 "
                        + "AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' AND c.act_proy ilike '2%' "
                        + "GROUP BY a.ano_eje, d.pim ";
                query2 = " WHERE a.ano_eje = '" + año + "' AND date_part('month', b.fecha_doc)::int <= 12 "
                        + "AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' AND c.act_proy ilike '2%' "
                        + "GROUP BY a.ano_eje, d.pim ";
            }
            queryP1 = " WHERE a.ano_eje = '" + (año - 1) + "' AND a.sec_func != '0000' AND f.act_proy ilike '2%' "
                    + "GROUP BY a.ano_eje, substring(f.act_proy from 1 for 1) ORDER BY a.ano_eje, substring(f.act_proy from 1 for 1) ASC ";
            queryP2 = " WHERE a.ano_eje = '" + año + "' AND a.sec_func != '0000' AND f.act_proy ilike '2%' "
                    + "GROUP BY a.ano_eje, substring(f.act_proy from 1 for 1) ORDER BY a.ano_eje, substring(f.act_proy from 1 for 1) ASC ";
            listP1 = new PresupuestoDao().getEjecucionPorActProyTotal(queryP1);
            listP2 = new PresupuestoDao().getEjecucionPorActProyTotal(queryP2);
            list1 = new PresupuestoDao().getMensualizadoHistorico(query1);
            list2 = new PresupuestoDao().getMensualizadoHistorico(query2);
        } else {
            if (año_actual == año) {
                query1 = " WHERE a.ano_eje = '" + (año - 1) + "' AND a.sec_ejec = '" + ejec + "' AND c.act_proy ilike '2%' AND "
                        + "date_part('month', b.fecha_doc)::int <= " + mes_actual + " AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' "
                        + "GROUP BY a.ano_eje, d.pim ";
                query2 = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND c.act_proy ilike '2%' AND "
                        + "date_part('month', b.fecha_doc)::int <= " + mes_actual + " AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' "
                        + "GROUP BY a.ano_eje, d.pim ";
            } else {
                query1 = " WHERE a.ano_eje = '" + (año - 1) + "' AND a.sec_ejec = '" + ejec + "' AND c.act_proy ilike '2%' AND "
                        + "date_part('month', b.fecha_doc)::int <= 12 AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' "
                        + "GROUP BY a.ano_eje, d.pim ";
                query2 = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND c.act_proy ilike '2%' AND "
                        + "date_part('month', b.fecha_doc)::int <= 12 AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' "
                        + "GROUP BY a.ano_eje, d.pim ";
            }
            queryP1 = " WHERE a.ano_eje = '" + (año - 1) + "' AND a.sec_ejec = '" + ejec + "' AND a.sec_func != '0000' AND f.act_proy ilike '2%' "
                    + "GROUP BY a.ano_eje, substring(f.act_proy from 1 for 1) ORDER BY a.ano_eje, substring(f.act_proy from 1 for 1) ASC ";
            queryP2 = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND a.sec_func != '0000' AND f.act_proy ilike '2%' "
                    + "GROUP BY a.ano_eje, substring(f.act_proy from 1 for 1) ORDER BY a.ano_eje, substring(f.act_proy from 1 for 1) ASC ";
            listP1 = new PresupuestoDao().getEjecucionPorActProyTotal(queryP1);
            listP2 = new PresupuestoDao().getEjecucionPorActProyTotal(queryP2);
            list1 = new PresupuestoDao().getMensualizadoHistorico(query1);
            list2 = new PresupuestoDao().getMensualizadoHistorico(query2);
        }
        String tituloY = "Ejecución (millones S/)";
        String formato = "png";
        int ancho = Integer.parseInt(request.getParameter("ancho"));
        int alto = Integer.parseInt(request.getParameter("alto"));
        int font_size = Integer.parseInt(request.getParameter("font"));
        double bar_width = Double.parseDouble(request.getParameter("bar"));
        DefaultCategoryDataset objDataset = new DefaultCategoryDataset();
        DefaultCategoryDataset objDataset2 = new DefaultCategoryDataset();
        if (list1.isEmpty()) {
            objDataset.setValue(0.00, (año - 1) + "", "Comparativo Anual");
        } else {
            BigDecimal numeric, pim, porc;
            if (list1.get(0).getDevengado() == null) {
                numeric = BigDecimal.ZERO;
            } else {
                numeric = list1.get(0).getDevengado();
            }
            if (listP1.get(0).getPim() == null || listP1.get(0).getPim().compareTo(BigDecimal.ZERO) == 0) {
                porc = BigDecimal.ZERO;
            } else {
                pim = listP1.get(0).getPim();
                porc = porcentaje(numeric, pim);
            }
            objDataset.setValue(millones(numeric), (año - 1) + "", "Comparativo Anual");
            objDataset2.setValue(millones(numeric), porc + " %", "Comparativo Anual");

        }
        if (list2.isEmpty()) {
            objDataset.setValue(0.00, año + "", "Comparativo Anual");
        } else {
            BigDecimal numeric, pim, porc;
            if (list2.get(0).getDevengado() == null) {
                numeric = BigDecimal.ZERO;
            } else {
                numeric = list2.get(0).getDevengado();
            }
            if (listP2.get(0).getPim() == null || listP2.get(0).getPim().compareTo(BigDecimal.ZERO) == 0) {
                porc = BigDecimal.ZERO;
            } else {
                pim = listP2.get(0).getPim();
                porc = porcentaje(numeric, pim);
            }
            objDataset.setValue(millones(numeric), año + "", "Comparativo Anual");
            objDataset2.setValue(millones(numeric), porc + " %", "Comparativo Anual");

        }
        String[] Leyenda = new String[10];
        if (request.getParameter("pdf").equals("si")) {
            chart.barraSimpleV_X2_2D_pdf(request, response, objDataset, objDataset2, Leyenda, "", "", tituloY, ancho, alto, font_size, bar_width, formato, blanco, semi_negro);
        }
        if (request.getParameter("pdf").equals("no")) {
            chart.barraSimpleV_X2_2D(request, response, objDataset, objDataset2, Leyenda, "", "", tituloY, ancho, alto, font_size, bar_width, formato, blanco, blanco, semi_negro);
        }

    }

    private void resumen_ejecucion_grafica3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        Integer año = Integer.parseInt(request.getParameter("año"));
        String ejec = request.getParameter("ejec");

        LocalDate ld = LocalDate.now();
        int mes_actual = ld.getMonthValue();
        int año_actual = ld.getYear();

        String queryP1, queryP2, query1, query2;
        List<Presupuesto> listP1, listP2, list1, list2;
        if (ejec.equals("00")) {
            if (año_actual == año) {
                query1 = " WHERE a.ano_eje = '" + (año - 1) + "' AND date_part('month', b.fecha_doc)::int <= " + mes_actual + " "
                        + "AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' AND c.act_proy ilike '3%' "
                        + "GROUP BY a.ano_eje, d.pim ";
                query2 = " WHERE a.ano_eje = '" + año + "' AND date_part('month', b.fecha_doc)::int <= " + mes_actual + " "
                        + "AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' AND c.act_proy ilike '3%' "
                        + "GROUP BY a.ano_eje, d.pim ";
            } else {
                query1 = " WHERE a.ano_eje = '" + (año - 1) + "' AND date_part('month', b.fecha_doc)::int <= 12 "
                        + "AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' AND c.act_proy ilike '3%' "
                        + "GROUP BY a.ano_eje, d.pim ";
                query2 = " WHERE a.ano_eje = '" + año + "' AND date_part('month', b.fecha_doc)::int <= 12 "
                        + "AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' AND c.act_proy ilike '3%' "
                        + "GROUP BY a.ano_eje, d.pim ";
            }
            queryP1 = " WHERE a.ano_eje = '" + (año - 1) + "' AND a.sec_func != '0000' AND f.act_proy ilike '3%' "
                    + "GROUP BY a.ano_eje, substring(f.act_proy from 1 for 1) ORDER BY a.ano_eje, substring(f.act_proy from 1 for 1) ASC ";
            queryP2 = " WHERE a.ano_eje = '" + año + "' AND a.sec_func != '0000' AND f.act_proy ilike '3%' "
                    + "GROUP BY a.ano_eje, substring(f.act_proy from 1 for 1) ORDER BY a.ano_eje, substring(f.act_proy from 1 for 1) ASC ";
            listP1 = new PresupuestoDao().getEjecucionPorActProyTotal(queryP1);
            listP2 = new PresupuestoDao().getEjecucionPorActProyTotal(queryP2);
            list1 = new PresupuestoDao().getMensualizadoHistorico(query1);
            list2 = new PresupuestoDao().getMensualizadoHistorico(query2);
        } else {
            if (año_actual == año) {
                query1 = " WHERE a.ano_eje = '" + (año - 1) + "' AND a.sec_ejec = '" + ejec + "' AND c.act_proy ilike '3%' AND "
                        + "date_part('month', b.fecha_doc)::int <= " + mes_actual + " AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' "
                        + "GROUP BY a.ano_eje, d.pim ";
                query2 = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND c.act_proy ilike '3%' AND "
                        + "date_part('month', b.fecha_doc)::int <= " + mes_actual + " AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' "
                        + "GROUP BY a.ano_eje, d.pim ";
            } else {
                query1 = " WHERE a.ano_eje = '" + (año - 1) + "' AND a.sec_ejec = '" + ejec + "' AND c.act_proy ilike '3%' AND "
                        + "date_part('month', b.fecha_doc)::int <= 12 AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' "
                        + "GROUP BY a.ano_eje, d.pim ";
                query2 = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND c.act_proy ilike '3%' AND "
                        + "date_part('month', b.fecha_doc)::int <= 12 AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' "
                        + "GROUP BY a.ano_eje, d.pim ";
            }
            queryP1 = " WHERE a.ano_eje = '" + (año - 1) + "' AND a.sec_ejec = '" + ejec + "' AND a.sec_func != '0000' AND f.act_proy ilike '3%' "
                    + "GROUP BY a.ano_eje, substring(f.act_proy from 1 for 1) ORDER BY a.ano_eje, substring(f.act_proy from 1 for 1) ASC ";
            queryP2 = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND a.sec_func != '0000' AND f.act_proy ilike '3%' "
                    + "GROUP BY a.ano_eje, substring(f.act_proy from 1 for 1) ORDER BY a.ano_eje, substring(f.act_proy from 1 for 1) ASC ";
            listP1 = new PresupuestoDao().getEjecucionPorActProyTotal(queryP1);
            listP2 = new PresupuestoDao().getEjecucionPorActProyTotal(queryP2);
            list1 = new PresupuestoDao().getMensualizadoHistorico(query1);
            list2 = new PresupuestoDao().getMensualizadoHistorico(query2);
        }
        String tituloY = "Ejecución (millones S/)";
        String formato = "png";
        int ancho = Integer.parseInt(request.getParameter("ancho"));
        int alto = Integer.parseInt(request.getParameter("alto"));
        int font_size = Integer.parseInt(request.getParameter("font"));
        double bar_width = Double.parseDouble(request.getParameter("bar"));
        DefaultCategoryDataset objDataset = new DefaultCategoryDataset();
        DefaultCategoryDataset objDataset2 = new DefaultCategoryDataset();
        if (list1.isEmpty()) {
            objDataset.setValue(0.00, (año - 1) + "", "Comparativo Anual");
        } else {
            BigDecimal numeric, pim, porc;
            if (list1.get(0).getDevengado() == null) {
                numeric = BigDecimal.ZERO;
            } else {
                numeric = list1.get(0).getDevengado();
            }
            if (listP1.get(0).getPim() == null || listP1.get(0).getPim().compareTo(BigDecimal.ZERO) == 0) {
                porc = BigDecimal.ZERO;
            } else {
                pim = listP1.get(0).getPim();
                porc = porcentaje(numeric, pim);
            }
            objDataset.setValue(millones(numeric), (año - 1) + "", "Comparativo Anual");
            objDataset2.setValue(millones(numeric), porc + " %", "Comparativo Anual");
        }
        if (list2.isEmpty()) {
            objDataset.setValue(0.00, año + "", "Comparativo Anual");
        } else {
            BigDecimal numeric, pim, porc;
            if (list2.get(0).getDevengado() == null) {
                numeric = BigDecimal.ZERO;
            } else {
                numeric = list2.get(0).getDevengado();
            }
            if (listP2.get(0).getPim() == null || listP2.get(0).getPim().compareTo(BigDecimal.ZERO) == 0) {
                porc = BigDecimal.ZERO;
            } else {
                pim = listP2.get(0).getPim();
                porc = porcentaje(numeric, pim);
            }
            objDataset.setValue(millones(numeric), año + "", "Comparativo Anual");
            objDataset2.setValue(millones(numeric), porc + " %", "Comparativo Anual");
        }
        String[] Leyenda = new String[10];
        if (request.getParameter("pdf").equals("si")) {
            chart.barraSimpleV_X2_2D_pdf(request, response, objDataset, objDataset2, Leyenda, "", "", tituloY, ancho, alto, font_size, bar_width, formato, blanco, semi_negro);
        }
        if (request.getParameter("pdf").equals("no")) {
            chart.barraSimpleV_X2_2D(request, response, objDataset, objDataset2, Leyenda, "", "", tituloY, ancho, alto, font_size, bar_width, formato, blanco, blanco, semi_negro);
        }

    }

    private void resumen_ejecucion_grafica4(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        Integer año = Integer.parseInt(request.getParameter("año"));
        String ejec = request.getParameter("ejec");

        LocalDate ld = LocalDate.now();
        int mes_actual = ld.getMonthValue();
        int año_actual = ld.getYear();

        String query1, query2;
        List<Presupuesto> list1, list2;
        if (ejec.equals("00")) {
            if (año_actual == año) {
                query1 = " WHERE a.ano_eje = '" + (año - 1) + "' AND date_part('month', b.fecha_doc)::int <= " + mes_actual + " "
                        + "AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' "
                        + "GROUP BY a.ano_eje, date_part('month', b.fecha_doc)::int ORDER BY a.ano_eje, date_part('month', b.fecha_doc)::int ASC";
                query2 = " WHERE a.ano_eje = '" + año + "' AND date_part('month', b.fecha_doc)::int <= " + mes_actual + " "
                        + "AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' "
                        + "GROUP BY a.ano_eje, date_part('month', b.fecha_doc)::int ORDER BY a.ano_eje, date_part('month', b.fecha_doc)::int ASC";
            } else {
                query1 = " WHERE a.ano_eje = '" + (año - 1) + "' AND date_part('month', b.fecha_doc)::int <= 12 "
                        + "AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' "
                        + "GROUP BY a.ano_eje, date_part('month', b.fecha_doc)::int ORDER BY a.ano_eje, date_part('month', b.fecha_doc)::int ASC";
                query2 = " WHERE a.ano_eje = '" + año + "' AND date_part('month', b.fecha_doc)::int <= 12 "
                        + "AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' "
                        + "GROUP BY a.ano_eje, date_part('month', b.fecha_doc)::int ORDER BY a.ano_eje, date_part('month', b.fecha_doc)::int ASC";
            }
            list1 = new PresupuestoDao().getMensualizado(query1);
            list2 = new PresupuestoDao().getMensualizado(query2);
        } else {
            if (año_actual == año) {
                query1 = " WHERE a.ano_eje = '" + (año - 1) + "' AND a.sec_ejec = '" + ejec + "' AND "
                        + "date_part('month', b.fecha_doc)::int <= " + mes_actual + " AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' "
                        + "GROUP BY a.ano_eje, date_part('month', b.fecha_doc)::int ORDER BY a.ano_eje, date_part('month', b.fecha_doc)::int ASC";
                query2 = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND "
                        + "date_part('month', b.fecha_doc)::int <= " + mes_actual + " AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' "
                        + "GROUP BY a.ano_eje, date_part('month', b.fecha_doc)::int ORDER BY a.ano_eje, date_part('month', b.fecha_doc)::int ASC";
            } else {
                query1 = " WHERE a.ano_eje = '" + (año - 1) + "' AND a.sec_ejec = '" + ejec + "' AND "
                        + "date_part('month', b.fecha_doc)::int <= 12 AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' "
                        + "GROUP BY a.ano_eje, date_part('month', b.fecha_doc)::int ORDER BY a.ano_eje, date_part('month', b.fecha_doc)::int ASC";
                query2 = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND "
                        + "date_part('month', b.fecha_doc)::int <= 12 AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' "
                        + "GROUP BY a.ano_eje, date_part('month', b.fecha_doc)::int ORDER BY a.ano_eje, date_part('month', b.fecha_doc)::int ASC";
            }
            list1 = new PresupuestoDao().getMensualizado(query1);
            list2 = new PresupuestoDao().getMensualizado(query2);
        }

        String tituloX = "Comparativo Mensual";
        String tituloY = "Ejecución (millones S/)";
        String formato = "png";
        int ancho = Integer.parseInt(request.getParameter("ancho"));
        int alto = Integer.parseInt(request.getParameter("alto"));
        int font_size = Integer.parseInt(request.getParameter("font"));
        double bar_width = Double.parseDouble(request.getParameter("bar"));
        String posicion = request.getParameter("pos");
        DefaultCategoryDataset objDataset = new DefaultCategoryDataset();
        for (Presupuesto datos : list1) {
            BigDecimal numeric;
            if (datos.getDevengado() == null) {
                numeric = BigDecimal.ZERO;
            } else {
                numeric = datos.getDevengado();
            }
            objDataset.setValue(millones(numeric), (año - 1) + "", datos.getNombre());
        }
        for (Presupuesto datos : list2) {
            BigDecimal numeric;
            if (datos.getDevengado() == null) {
                numeric = BigDecimal.ZERO;
            } else {
                numeric = datos.getDevengado();
            }
            objDataset.setValue(millones(numeric), año + "", datos.getNombre());
        }
        String[] Leyenda = new String[2];

        if (request.getParameter("pdf").equals("si")) {
            chart.barraSimpleV_2D_pdf(request, response, objDataset, Leyenda, "", "", tituloY, ancho, alto, font_size, bar_width, formato, blanco, semi_negro, posicion);
        }
        if (request.getParameter("pdf").equals("no")) {
            chart.barraSimpleV_2D(request, response, objDataset, Leyenda, "", tituloX, tituloY, ancho, alto, font_size, bar_width, formato, blanco, semi_negro, posicion);
        }

    }

    private void resumen_ejecucion_grafica5(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        Integer año = Integer.parseInt(request.getParameter("año"));
        String ejec = request.getParameter("ejec");

        LocalDate ld = LocalDate.now();
        int mes_actual = ld.getMonthValue();
        int año_actual = ld.getYear();

        String query1, query2;
        List<Presupuesto> list1, list2;
        if (ejec.equals("00")) {
            if (año_actual == año) {
                query1 = " WHERE a.ano_eje = '" + (año - 1) + "' AND date_part('month', b.fecha_doc)::int <= " + mes_actual + " "
                        + "AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' AND c.act_proy ilike '2%' "
                        + "GROUP BY a.ano_eje, date_part('month', b.fecha_doc)::int ORDER BY a.ano_eje, date_part('month', b.fecha_doc)::int ASC";
                query2 = " WHERE a.ano_eje = '" + año + "' AND date_part('month', b.fecha_doc)::int <= " + mes_actual + " "
                        + "AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' AND c.act_proy ilike '2%' "
                        + "GROUP BY a.ano_eje, date_part('month', b.fecha_doc)::int ORDER BY a.ano_eje, date_part('month', b.fecha_doc)::int ASC";
            } else {
                query1 = " WHERE a.ano_eje = '" + (año - 1) + "' AND date_part('month', b.fecha_doc)::int <= 12 "
                        + "AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' AND c.act_proy ilike '2%' "
                        + "GROUP BY a.ano_eje, date_part('month', b.fecha_doc)::int ORDER BY a.ano_eje, date_part('month', b.fecha_doc)::int ASC";
                query2 = " WHERE a.ano_eje = '" + año + "' AND date_part('month', b.fecha_doc)::int <= 12 "
                        + "AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' AND c.act_proy ilike '2%' "
                        + "GROUP BY a.ano_eje, date_part('month', b.fecha_doc)::int ORDER BY a.ano_eje, date_part('month', b.fecha_doc)::int ASC";
            }
            list1 = new PresupuestoDao().getMensualizado(query1);
            list2 = new PresupuestoDao().getMensualizado(query2);
        } else {
            if (año_actual == año) {
                query1 = " WHERE a.ano_eje = '" + (año - 1) + "' AND a.sec_ejec = '" + ejec + "' AND date_part('month', b.fecha_doc)::int <= " + mes_actual + " "
                        + "AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' AND c.act_proy ilike '2%' "
                        + "GROUP BY a.ano_eje, date_part('month', b.fecha_doc)::int ORDER BY a.ano_eje, date_part('month', b.fecha_doc)::int ASC";
                query2 = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND date_part('month', b.fecha_doc)::int <= " + mes_actual + " "
                        + "AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' AND c.act_proy ilike '2%' "
                        + "GROUP BY a.ano_eje, date_part('month', b.fecha_doc)::int ORDER BY a.ano_eje, date_part('month', b.fecha_doc)::int ASC";
            } else {
                query1 = " WHERE a.ano_eje = '" + (año - 1) + "' AND a.sec_ejec = '" + ejec + "' AND date_part('month', b.fecha_doc)::int <= 12 "
                        + "AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' AND c.act_proy ilike '2%' "
                        + "GROUP BY a.ano_eje, date_part('month', b.fecha_doc)::int ORDER BY a.ano_eje, date_part('month', b.fecha_doc)::int ASC";
                query2 = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND date_part('month', b.fecha_doc)::int <= 12 "
                        + "AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' AND c.act_proy ilike '2%' "
                        + "GROUP BY a.ano_eje, date_part('month', b.fecha_doc)::int ORDER BY a.ano_eje, date_part('month', b.fecha_doc)::int ASC";
            }
            list1 = new PresupuestoDao().getMensualizado(query1);
            list2 = new PresupuestoDao().getMensualizado(query2);
        }

        String tituloX = "Comparativo Mensual";
        String tituloY = "Ejecución (millones S/)";
        String formato = "png";
        int ancho = Integer.parseInt(request.getParameter("ancho"));
        int alto = Integer.parseInt(request.getParameter("alto"));
        int font_size = Integer.parseInt(request.getParameter("font"));
        double bar_width = Double.parseDouble(request.getParameter("bar"));
        String posicion = request.getParameter("pos");
        DefaultCategoryDataset objDataset = new DefaultCategoryDataset();
        for (Presupuesto datos : list1) {
            BigDecimal numeric;
            if (datos.getDevengado() == null) {
                numeric = BigDecimal.ZERO;
            } else {
                numeric = datos.getDevengado();
            }
            objDataset.setValue(millones(numeric), (año - 1) + "", datos.getNombre());
        }
        for (Presupuesto datos : list2) {
            BigDecimal numeric;
            if (datos.getDevengado() == null) {
                numeric = BigDecimal.ZERO;
            } else {
                numeric = datos.getDevengado();
            }
            objDataset.setValue(millones(numeric), año + "", datos.getNombre());
        }
        String[] Leyenda = new String[2];

        if (request.getParameter("pdf").equals("si")) {
            chart.barraSimpleV_2D_pdf(request, response, objDataset, Leyenda, "", "", tituloY, ancho, alto, font_size, bar_width, formato, blanco, semi_negro, posicion);
        }
        if (request.getParameter("pdf").equals("no")) {
            chart.barraSimpleV_2D(request, response, objDataset, Leyenda, "", tituloX, tituloY, ancho, alto, font_size, bar_width, formato, blanco, semi_negro, posicion);
        }

    }

    private void resumen_ejecucion_grafica6(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        Integer año = Integer.parseInt(request.getParameter("año"));
        String ejec = request.getParameter("ejec");

        LocalDate ld = LocalDate.now();
        int mes_actual = ld.getMonthValue();
        int año_actual = ld.getYear();

        String query1, query2;
        List<Presupuesto> list1, list2;
        if (ejec.equals("00")) {
            if (año_actual == año) {
                query1 = " WHERE a.ano_eje = '" + (año - 1) + "' AND date_part('month', b.fecha_doc)::int <= " + mes_actual + " "
                        + "AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' AND c.act_proy ilike '3%' "
                        + "GROUP BY a.ano_eje, date_part('month', b.fecha_doc)::int ORDER BY a.ano_eje, date_part('month', b.fecha_doc)::int ASC";
                query2 = " WHERE a.ano_eje = '" + año + "' AND date_part('month', b.fecha_doc)::int <= " + mes_actual + " "
                        + "AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' AND c.act_proy ilike '3%' "
                        + "GROUP BY a.ano_eje, date_part('month', b.fecha_doc)::int ORDER BY a.ano_eje, date_part('month', b.fecha_doc)::int ASC";
            } else {
                query1 = " WHERE a.ano_eje = '" + (año - 1) + "' AND date_part('month', b.fecha_doc)::int <= 12 "
                        + "AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' AND c.act_proy ilike '3%' "
                        + "GROUP BY a.ano_eje, date_part('month', b.fecha_doc)::int ORDER BY a.ano_eje, date_part('month', b.fecha_doc)::int ASC";
                query2 = " WHERE a.ano_eje = '" + año + "' AND date_part('month', b.fecha_doc)::int <= 12 "
                        + "AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' AND c.act_proy ilike '3%' "
                        + "GROUP BY a.ano_eje, date_part('month', b.fecha_doc)::int ORDER BY a.ano_eje, date_part('month', b.fecha_doc)::int ASC";
            }
            list1 = new PresupuestoDao().getMensualizado(query1);
            list2 = new PresupuestoDao().getMensualizado(query2);
        } else {
            if (año_actual == año) {
                query1 = " WHERE a.ano_eje = '" + (año - 1) + "' AND a.sec_ejec = '" + ejec + "' AND date_part('month', b.fecha_doc)::int <= " + mes_actual + " "
                        + "AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' AND c.act_proy ilike '3%' "
                        + "GROUP BY a.ano_eje, date_part('month', b.fecha_doc)::int ORDER BY a.ano_eje, date_part('month', b.fecha_doc)::int ASC";
                query2 = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND date_part('month', b.fecha_doc)::int <= " + mes_actual + " "
                        + "AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' AND c.act_proy ilike '3%' "
                        + "GROUP BY a.ano_eje, date_part('month', b.fecha_doc)::int ORDER BY a.ano_eje, date_part('month', b.fecha_doc)::int ASC";
            } else {
                query1 = " WHERE a.ano_eje = '" + (año - 1) + "' AND a.sec_ejec = '" + ejec + "' AND date_part('month', b.fecha_doc)::int <= 12 "
                        + "AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' AND c.act_proy ilike '3%' "
                        + "GROUP BY a.ano_eje, date_part('month', b.fecha_doc)::int ORDER BY a.ano_eje, date_part('month', b.fecha_doc)::int ASC";
                query2 = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND date_part('month', b.fecha_doc)::int <= 12 "
                        + "AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND a.sec_func != '0000' AND c.act_proy ilike '3%' "
                        + "GROUP BY a.ano_eje, date_part('month', b.fecha_doc)::int ORDER BY a.ano_eje, date_part('month', b.fecha_doc)::int ASC";
            }
            list1 = new PresupuestoDao().getMensualizado(query1);
            list2 = new PresupuestoDao().getMensualizado(query2);
        }

        String tituloX = "Comparativo Mensual";
        String tituloY = "Ejecución (millones S/)";
        String formato = "png";
        int ancho = Integer.parseInt(request.getParameter("ancho"));
        int alto = Integer.parseInt(request.getParameter("alto"));
        int font_size = Integer.parseInt(request.getParameter("font"));
        double bar_width = Double.parseDouble(request.getParameter("bar"));
        String posicion = request.getParameter("pos");
        DefaultCategoryDataset objDataset = new DefaultCategoryDataset();
        for (Presupuesto datos : list1) {
            BigDecimal numeric;
            if (datos.getDevengado() == null) {
                numeric = BigDecimal.ZERO;
            } else {
                numeric = datos.getDevengado();
            }
            objDataset.setValue(millones(numeric), (año - 1) + "", datos.getNombre());
        }
        for (Presupuesto datos : list2) {
            BigDecimal numeric;
            if (datos.getDevengado() == null) {
                numeric = BigDecimal.ZERO;
            } else {
                numeric = datos.getDevengado();
            }
            objDataset.setValue(millones(numeric), año + "", datos.getNombre());
        }
        String[] Leyenda = new String[2];

        if (request.getParameter("pdf").equals("si")) {
            chart.barraSimpleV_2D_pdf(request, response, objDataset, Leyenda, "", "", tituloY, ancho, alto, font_size, bar_width, formato, blanco, semi_negro, posicion);
        }
        if (request.getParameter("pdf").equals("no")) {
            chart.barraSimpleV_2D(request, response, objDataset, Leyenda, "", tituloX, tituloY, ancho, alto, font_size, bar_width, formato, blanco, semi_negro, posicion);
        }

    }

    private void resumen_ejecucion_tablas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        Integer año = Integer.parseInt(request.getParameter("año"));
        String ejec = request.getParameter("ejec");

        String query, query1, query2, query3, query4;
        List<Presupuesto> list, list1, list2, list3, list4;
        if (ejec.equals("00")) {
            query = " WHERE ano_eje = '" + año + "' ";
            query1 = " WHERE a.ano_eje = '" + año + "' AND a.sec_func != '0000' AND (f.act_proy ilike '2%' OR f.act_proy ilike '3%') "
                    + "GROUP BY a.ano_eje, substring(f.act_proy from 1 for 1) ORDER BY a.ano_eje, substring(f.act_proy from 1 for 1) ASC ";
            query2 = " WHERE a.ano_eje = '" + año + "' AND a.sec_func != '0000' GROUP BY a.ano_eje, f.clasificador, f.descripcion "
                    + "ORDER BY a.ano_eje, f.clasificador ASC ";
            query3 = " WHERE a.ano_eje = '" + año + "' AND a.sec_func != '0000' GROUP BY a.ano_eje, f.fuente_financ_agregada, g.nombre "
                    + "ORDER BY a.ano_eje, f.fuente_financ_agregada ASC ";
            query4 = " WHERE a.ano_eje = '" + año + "' AND a.sec_func != '0000' GROUP BY a.ano_eje, c.categoria_gasto, f.nombre "
                    + "ORDER BY a.ano_eje, c.categoria_gasto ASC ";
            list = new PresupuestoDao().getHistorico(query);
            list1 = new PresupuestoDao().getEjecucionPorActProyTotal(query1);
            list2 = new PresupuestoDao().getEjecucionPorGenerica(query2);
            list3 = new PresupuestoDao().getEjecucionPorFuente(query3);
            list4 = new PresupuestoDao().getEjecucionPorCategoria(query4);
        } else {
            query = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' ";
            query1 = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND a.sec_func != '0000' AND (f.act_proy ilike '2%' OR f.act_proy ilike '3%') "
                    + "GROUP BY a.ano_eje, substring(f.act_proy from 1 for 1) ORDER BY a.ano_eje, substring(f.act_proy from 1 for 1) ASC ";
            query2 = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND a.sec_func != '0000' "
                    + "GROUP BY a.ano_eje, f.clasificador, f.descripcion ORDER BY a.ano_eje, f.clasificador ASC ";
            query3 = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND a.sec_func != '0000' "
                    + "GROUP BY a.ano_eje, f.fuente_financ_agregada, g.nombre ORDER BY a.ano_eje, f.fuente_financ_agregada ASC ";
            query4 = " WHERE a.ano_eje = '" + año + "' AND a.sec_ejec = '" + ejec + "' AND a.sec_func != '0000' "
                    + "GROUP BY a.ano_eje, c.categoria_gasto, f.nombre ORDER BY a.ano_eje, c.categoria_gasto ASC ";
            list = new PresupuestoDao().getListSemaforoEjecucion(query);
            list1 = new PresupuestoDao().getEjecucionPorActProyTotal(query1);
            list2 = new PresupuestoDao().getEjecucionPorGenerica(query2);
            list3 = new PresupuestoDao().getEjecucionPorFuente(query3);
            list4 = new PresupuestoDao().getEjecucionPorCategoria(query4);
        }

        HashMap outHash = new HashMap();
        outHash.put("listTotal", list);
        outHash.put("listPorActProy", list1);
        outHash.put("listPorGeneric", list2);
        outHash.put("listPorFuente", list3);
        outHash.put("listPorCateg", list4);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void semaforo_tabla(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        LocalDate ld = LocalDate.now();
        int mes_actual = ld.getMonthValue();
        int año_actual = ld.getYear();

        String ejec = request.getParameter("ejec");
        String año = request.getParameter("año");
        String estado = request.getParameter("estado");

        int mes;

        if (año_actual == Integer.parseInt(año)) {
            mes = mes_actual;
        } else {
            mes = 12;
        }

        HashMap outHash = new HashMap();

        List<Presupuesto> list;
        String titulo;
        String titulo1;

        String queryEstado = "";
        String verde = "Avance Financiero >= " + (8 * mes) + " % ";
        String naranja = (5 * mes) + " % <= Avance Financiero < " + (8 * mes) + " % ";
        String rojo = "Avance Financiero < " + (5 * mes) + " % ";

        if (estado.equals("00")) {
            queryEstado += "";
        }
        if (estado.equals("01")) {
            queryEstado += " AND (a.ejecucion/a.pim)*100 >= " + (8 * mes) + " ";
        }
        if (estado.equals("02")) {
            queryEstado += " AND (a.ejecucion/a.pim)*100 >= " + (5 * mes) + " AND (a.ejecucion/a.pim)*100 < " + (8 * mes) + " ";
        }
        if (estado.equals("03")) {
            queryEstado += " AND (a.ejecucion/a.pim)*100 < " + (5 * mes) + " ";
        }

        if (ejec.equals("00")) {
            String query = " WHERE a.ano_eje = '" + año + "' " + queryEstado + " AND b.estado = 'A' ORDER BY (a.ejecucion/a.pim)*100 DESC ";
            list = new PresupuestoDao().getListSemaforoEjecucion(query);
            titulo = " Pliego " + pliego + " - Gobierno Regional San Martin";
            titulo1 = " pliego_" + pliego;
        } else {
            String query1 = " WHERE g.ano_eje = '" + año + "' AND g.sec_ejec = '" + ejec + "' GROUP BY m.sec_func, fi.nombre, cc.ceco_nombre ";
            String query2 = " WHERE a.sec_func != '0000' " + queryEstado + " ORDER BY (CASE WHEN a.pim = 0.00 THEN 0.00 ELSE (a.ejecucion/a.pim)*100 END, a.pim) DESC ";
            list = new PresupuestoDao().getListSemaforoEjecucionMeta(query1, query2);
            String queryE = " WHERE ano_eje = '" + año + "' AND sec_ejec = '" + ejec + "' AND pliego = '" + pliego + "' ";
            Presupuesto data = new PresupuestoDao().getEjecutora(queryE);
            String[] nombre_ejec = data.getNombre().split("-");
            titulo = "UE " + data.getEjecutora().trim() + " - " + nombre_ejec[1].trim() + " (" + ejec + ")";
            titulo1 = "ue_" + data.getEjecutora().trim() + "_" + ejec;
        }

        outHash.put("list", list);
        outHash.put("ejec", ejec);
        outHash.put("titulo", titulo);
        outHash.put("titulo1", titulo1);
        outHash.put("mes", mes);
        outHash.put("verde", verde);
        outHash.put("naranja", naranja);
        outHash.put("rojo", rojo);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void semaforo_grafica(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        Integer año = Integer.parseInt(request.getParameter("año"));
        String ejec = request.getParameter("ejec");

        String query = " WHERE a.ano_eje = '" + año + "' AND a.sec_func != '0000' AND (f.act_proy ilike '2%' OR f.act_proy ilike '3%') ";
        List<Presupuesto> list = new PresupuestoDao().getEjecucionPorActProyTotal(query);

        HashMap outHash = new HashMap();
        outHash.put("list", list);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void nuevo_centro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre").toUpperCase();
        String ejec = request.getParameter("ejec");
        Boolean estado = request.getParameter("activo") != null;

        Presupuesto bean = new Presupuesto();
        bean.setCeco_codigo(codigo);
        bean.setCeco_nombre(nombre);
        bean.setSec_ejec(ejec);
        bean.setCeco_estado(estado);

        HashMap outHash = new HashMap();

        String query = " WHERE ceco_codigo = '" + codigo + "' AND sec_ejec = '" + ejec + "' ";
        Integer reg = new PresupuestoDao().getNroRegCeco(query);

        if (reg == 0) {
            try {
                new PresupuestoDao().insertCentroCosto(bean);
                outHash.put("success", true);
                outHash.put("msg", "Se añadió nuevo Centro de Costo");
            } catch (Exception ex) {
                outHash.put("success", false);
                outHash.put("msg", "No se pudo añadir el Centro de Costo, intente nuevamente");
            }
        }
        if (reg > 0) {
            outHash.put("success", false);
            outHash.put("msg", "El código ingresado ya existe");
        }

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void editar_centro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        Integer id = Integer.parseInt(request.getParameter("id"));
        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre").toUpperCase();
        String ejec = request.getParameter("ejec");
        Boolean estado = request.getParameter("activo") != null;

        Presupuesto bean = new Presupuesto();
        bean.setCeco_id(id);
        bean.setCeco_codigo(codigo);
        bean.setCeco_nombre(nombre);
        bean.setSec_ejec(ejec);
        bean.setCeco_estado(estado);

        HashMap outHash = new HashMap();

        String query = " WHERE ceco_id != " + id + " AND ceco_codigo = '" + codigo + "' AND sec_ejec = '" + ejec + "' ";
        Integer reg = new PresupuestoDao().getNroRegCeco(query);

        if (reg == 0) {
            try {
                new PresupuestoDao().updateCentroCosto(bean);
                outHash.put("success", true);
                outHash.put("msg", "Se actualizo correctamente el Centro de Costo");
            } catch (Exception ex) {
                outHash.put("success", false);
                outHash.put("msg", "No se pudo actualizar el Centro de Costo, intente nuevamente");
            }
        }
        if (reg > 0) {
            outHash.put("success", false);
            outHash.put("msg", "El código ingresado ya existe");
        }

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void eliminar_centro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        Integer ceco_id = Integer.parseInt(request.getParameter("ceco_id"));

        HashMap hm = new HashMap();

        try {
            Presupuesto bean = new Presupuesto();
            bean.setCeco_id(ceco_id);
            new PresupuestoDao().deleteCentroCosto(bean);
            new PresupuestoDao().deleteMetaCentroCosto(bean);
            hm.put("msg", "Se elimino correctamente el Centro de Costo");

        } catch (Exception e) {
            hm.put("msg", "No se pudo eliminar el Centro de Costo");
        }

        Gson gson = new Gson();
        String arg = gson.toJson(hm);
        response.getWriter().print(arg);
    }

    private void editar_meta_centro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String ano_eje = request.getParameter("ano");
        String sec_ejec = request.getParameter("ejec");
        String sec_func = request.getParameter("sec_func");
        Integer ceco_id = Integer.parseInt(request.getParameter("ceco_id"));

        HashMap outHash = new HashMap();

        outHash.put("ejec", sec_ejec);
        outHash.put("ano", ano_eje);

        if (ceco_id == 0) {
            outHash.put("success", true);
            outHash.put("msg", "Se actualizo correctamente la Meta");
        } else {
            String query = " WHERE ano_eje = '" + ano_eje + "' AND sec_ejec = '" + sec_ejec + "' AND sec_func = '" + sec_func + "' AND ceco_id = " + ceco_id;
            Integer reg = new PresupuestoDao().getNroRegMetaCeco(query);
            if (reg == 0) {
                try {
                    Presupuesto bean = new Presupuesto();
                    bean.setAno_eje(ano_eje);
                    bean.setSec_ejec(sec_ejec);
                    bean.setSec_func(sec_func);
                    bean.setCeco_id(ceco_id);
                    new PresupuestoDao().insertMetaCentroCosto(bean);
                    outHash.put("success", true);
                    outHash.put("msg", "Se actualizo correctamente la Meta");
                } catch (Exception ex) {
                    outHash.put("success", false);
                    outHash.put("msg", "No se pudo actualizar la Meta, intente nuevamente");
                }
            }
            if (reg > 0) {
                try {
                    Presupuesto bean = new Presupuesto();
                    bean.setAno_eje(ano_eje);
                    bean.setSec_ejec(sec_ejec);
                    bean.setSec_func(sec_func);
                    bean.setCeco_id(ceco_id);
                    new PresupuestoDao().updateMetaCentroCosto(bean);
                    outHash.put("success", true);
                    outHash.put("msg", "Se actualizo correctamente la Meta");
                } catch (Exception ex) {
                    outHash.put("success", false);
                    outHash.put("msg", "No se pudo actualizar la Meta, intente nuevamente");
                }
            }
        }

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
