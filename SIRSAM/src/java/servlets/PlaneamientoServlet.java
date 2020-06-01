package servlets;

import beans.Planeamiento;
import beans.PlaneamientoGraficas;
import beans.PlaneamientoMetaData;
import com.google.gson.Gson;
import config.ConexionReporte;
import daos.PlaneamientoDao;
import daos.PlaneamientoGraficasDao;
import daos.PlaneamientoMetaDataDao;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author CARLOS SANTANDER
 */
@WebServlet(name = "PlaneamientoServlet", urlPatterns = {"/Planeamiento"})
public class PlaneamientoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String url = request.getParameter("url") == null ? "" : request.getParameter("url");

        switch (url) {
            case "categorias":
                categorias(request, response);
                break;
            case "jerarquia_padre":
                jerarquia_padre(request, response);
                break;
            case "niveles_jerarquia":
                niveles_jerarquia(request, response);
                break;
            case "contenido_niveles":
                contenido_niveles(request, response);
                break;
            case "nivel_indicadores":
                nivel_indicadores(request, response);
                break;
            case "indicador_detalle":
                indicador_detalle(request, response);
                break;
            case "indicador_tablero":
                indicador_tablero(request, response);
                break;
            case "indicador_medicion":
                indicador_medicion(request, response);
                break;
            case "grafica":
                grafica(request, response);
                break;
            case "grafica_ficha":
                grafica_ficha(request, response);
                break;
            case "nivel_detalle":
                nivel_detalle(request, response);
                break;
            default:
                index(request, response);
                break;
        }

    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

    }

    private String fileSize(double size) {
        String formateado = "";
        if (size >= 0 && size < 1000) {
            BigDecimal sizeB = new BigDecimal(size);
            formateado = formatNumero(sizeB.setScale(2, RoundingMode.HALF_EVEN)) + " Bytes";
        }
        if (size >= 1000 && size < 1000000) {
            BigDecimal sizeB = new BigDecimal(size * 0.000977);
            formateado = formatNumero(sizeB.setScale(2, RoundingMode.HALF_EVEN)) + " KB";
        }
        if (size >= 1000000 && size < 1000000000) {
            BigDecimal sizeB = new BigDecimal((size * 0.000954) / 1000);
            formateado = formatNumero(sizeB.setScale(2, RoundingMode.HALF_EVEN)) + " MB";
        }
        if (size >= 1000000000) {
            BigDecimal sizeB = new BigDecimal((size * 0.000931) / 1000000);
            formateado = formatNumero(sizeB.setScale(2, RoundingMode.HALF_EVEN)) + " GB";
        }
        return formateado;
    }

    private String formatNumero(BigDecimal bd) {
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        simbolos.setGroupingSeparator(',');
        DecimalFormat formateador = new DecimalFormat("#,###,###,##0.00", simbolos);
        return formateador.format(bd);
    }

    private String formatEntero(BigDecimal bd) {
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        simbolos.setGroupingSeparator(',');
        DecimalFormat formateador = new DecimalFormat("#,###,###,##0", simbolos);
        return formateador.format(bd);
    }

    private void categorias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String query = " WHERE cate_estado = 'A' ORDER BY cate_id ASC ";
        List<Planeamiento> listCateg = new PlaneamientoDao().getCategorias(query);

        HashMap hm = new HashMap();

        hm.put("listCateg", listCateg);

        Gson gson = new Gson();
        String arg = gson.toJson(hm);
        response.getWriter().print(arg);
    }

    private void jerarquia_padre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String cate_id = request.getParameter("cate_id");

        String query = "WHERE cate_id=" + cate_id + " AND cate_estado = 'A'";
        Planeamiento bean = new PlaneamientoDao().getCategoria(query);

        String queryP = "WHERE cate_id=" + cate_id + " AND nive_jerarquia = 0 AND nive_estado = 'A' ORDER BY nive_id ASC";
        List<Planeamiento> listPadre = new PlaneamientoDao().getNiveles(queryP);

        HashMap hm = new HashMap();

        hm.put("nombre_padre", bean.getCateSubNivel());
        hm.put("cate_nombre", bean.getCateNombre());
        hm.put("cate_icon", bean.getCateIcon());
        hm.put("listPadre", listPadre);

        Gson gson = new Gson();
        String arg = gson.toJson(hm);
        response.getWriter().print(arg);
    }

    private void niveles_jerarquia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String nive_padre = request.getParameter("nive_id");
        String[] datos = request.getParameter("nive_id").split("_");
        String nive_id = datos[0];
        String jerarquia = request.getParameter("jerarquia") == null ? "" : request.getParameter("jerarquia");

        HashMap hm = new HashMap();

        if (jerarquia.equals("")) {
            String query = "WHERE nive_id=" + nive_id + " AND nive_estado = 'A' ORDER BY nive_jerarquia ASC";
            List<Planeamiento> listNiveles = new PlaneamientoDao().getNivelesJerarquia(query);
            hm.put("listNiveles", listNiveles);
        } else {
            String query = "WHERE nive_id=" + nive_id + " AND nive_jerarquia=" + jerarquia + " AND nive_estado = 'A'";
            Planeamiento data = new PlaneamientoDao().getNivelJerarquia(query);
            hm.put("jerarquia_nombre", data.getNiveJerarquiaNombre());
            hm.put("jerarquia", jerarquia);
        }
        hm.put("nive_padre", nive_padre);
        hm.put("nivel_id", nive_id);

        Gson gson = new Gson();
        String arg = gson.toJson(hm);
        response.getWriter().print(arg);
    }

    private void contenido_niveles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String nive_padre = request.getParameter("nive_padre_id");
        String[] datos = request.getParameter("nive_padre_id").split("_");
        String nive_jera = request.getParameter("nive_jera");
        String nive_id = request.getParameter("nive_id");

        String nive_padre_id = datos[0];
        Boolean nive_sub = Boolean.valueOf(datos[1]);
        Boolean nive_detalle = Boolean.valueOf(datos[3]);
        String nivel_tipo = datos[4];

        String dataBase = ConexionReporte.obtenerPropiedad("dataBase");

        String queryC = "WHERE nive_id=" + nive_id + " AND nive_jerarquia=" + nive_jera + " AND nive_estado = 'A'";
        Planeamiento data = new PlaneamientoDao().getNivelJerarquia(queryC);
        String jerarquia_nombre = data.getNiveJerarquiaNombre();

        HashMap hm = new HashMap();

        if (nive_sub) {
            String query = "WHERE nive_id=" + nive_padre_id + " AND nive_jerarquia=" + nive_jera + " AND nisu_estado = 'A' ORDER BY nisu_id ASC";
            List<Planeamiento> list = new PlaneamientoDao().getNivelesSub(query);
            hm.put("list", list);
            hm.put("tipo", "nisu");
        } else {
            String query = "WHERE nive_padre_id=" + nive_padre_id + " AND nive_jerarquia=" + nive_jera + " AND nive_estado = 'A' ORDER BY nive_id ASC";
            List<Planeamiento> list = new PlaneamientoDao().getNiveles(query);
            hm.put("list", list);
            hm.put("tipo", "nive");
        }

        if (nive_detalle) {
            Integer nide_id = 0;
            if (nivel_tipo.equals("nive")) {
                String queryN = " WHERE nive_id = " + nive_padre_id + " AND nive_estado = 'A' ";
                Planeamiento dataN = new PlaneamientoDao().getNivel(queryN);
                nide_id = dataN.getNideId();
            }
            if (nivel_tipo.equals("nisu")) {
                String queryN = " WHERE a.nisu_id = " + nive_padre_id + " AND a.nisu_estado = 'A' ";
                Planeamiento dataN = new PlaneamientoDao().getNivelSub(queryN);
                nide_id = dataN.getNideId();
            }

            String queryD = " WHERE a.nide_id = " + nide_id + " AND a.nide_estado = 'A' ";
            Planeamiento dataD = new PlaneamientoDao().getNivelDetalle(queryD);

            String detalle = "<div class='form-group row'>"
                    + "<label class='col-sm-2 col-form-label'></label>"
                    + "<div class='col-sm-10'>";
            if (dataD.getNideDocLegalActivo()) {
                Path path = null;
                if (dataBase.equals("servidor")) {
                    path = Paths.get(dataD.getNideDocLegalUrlLinux());
                }
                if (dataBase.equals("local")) {
                    path = Paths.get(dataD.getNideDocLegalUrlWindows());
                }
                detalle += "<div>"
                        + "<a href='./Archivos?tipo=planeamiento&url=nivel_detalle&nide_id=" + nide_id + "&doc=legal' target='_blank'>"
                        + "<img src='./resources/images/files/pdf.png' style='margin-right: 5px;'>"
                        + "" + dataD.getTidoNombre().toUpperCase() + " Nº " + dataD.getNideDocLegalNum().toUpperCase() + " (" + fileSize(Files.size(path)) + ")"
                        + "</a>"
                        + "</div>";
            }
            if (dataD.getNideDocContenidoActivo()) {
                Path path = null;
                if (dataBase.equals("servidor")) {
                    path = Paths.get(dataD.getNideDocContenidoUrlLinux());
                }
                if (dataBase.equals("local")) {
                    path = Paths.get(dataD.getNideDocContenidoUrlWindows());
                }
                detalle += "<div>"
                        + "<a href='./Archivos?tipo=planeamiento&url=nivel_detalle&nide_id=" + nide_id + "&doc=conte' target='_blank'>"
                        + "<img src='./resources/images/files/pdf.png' style='margin-right: 5px;'>"
                        + "" + dataD.getNideDocContenidoNombre().toUpperCase() + " (" + fileSize(Files.size(path)) + ")"
                        + "</a>"
                        + "</div>";
            }
            detalle += "</div></div>";
            hm.put("detalle", detalle);
        }

        hm.put("nive_padre", nive_padre);
        hm.put("nivel", nive_padre_id);
        hm.put("nivel_tipo", nivel_tipo);
        hm.put("nive_jera", nive_jera);
        hm.put("nive_sub", nive_sub);
        hm.put("nive_detalle", nive_detalle);
        hm.put("jerarquia_nombre", jerarquia_nombre);

        Gson gson = new Gson();
        String arg = gson.toJson(hm);
        response.getWriter().print(arg);
    }

    private void nivel_indicadores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String[] datos = request.getParameter("nive_id").split("_");

        String indice = datos[0];
        String nive_id;
        Boolean nive_sub;
        Boolean nive_indicador;
        if (indice.equals("0")) {
            nive_id = datos[1];
            nive_sub = Boolean.valueOf(datos[2]);
            nive_indicador = Boolean.valueOf(datos[3]);
        } else {
            nive_id = datos[0];
            nive_sub = Boolean.valueOf(datos[1]);
            nive_indicador = Boolean.valueOf(datos[2]);
        }

        HashMap hm = new HashMap();

        if (nive_indicador) {
            String query;
            if (nive_sub) {
                query = "WHERE nisu_id=" + nive_id + " AND nive_sub=" + nive_sub + " AND indi_estado = 'A' ORDER BY indi_id ASC";
            } else {
                query = "WHERE nive_id=" + nive_id + " AND nive_sub=" + nive_sub + " AND indi_estado = 'A' ORDER BY indi_id ASC";
            }
            List<Planeamiento> listIndi = new PlaneamientoDao().getIndicadores(query);
            hm.put("listIndi", listIndi);
        }
        hm.put("nive_indicador", nive_indicador);

        Gson gson = new Gson();
        String arg = gson.toJson(hm);
        response.getWriter().print(arg);
    }

    private void indicador_detalle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String indi_id = request.getParameter("indi_id");

        String query = " WHERE a.indi_id = " + indi_id + " AND a.indi_estado = 'A' ";
        Planeamiento indi = new PlaneamientoDao().getIndicador(query);

        String queryV = " WHERE a.indi_id = " + indi_id + " AND a.inva_estado = 'A' AND a.inva_columna = TRUE ORDER BY a.inva_id ASC ";
        List<Planeamiento> listV = new PlaneamientoDao().getIndicadoresVariables(queryV);

        String queryP = " WHERE a.indi_id = " + indi_id + " AND a.inva_principal = TRUE AND a.inva_estado = 'A' ";
        Planeamiento varP = new PlaneamientoDao().getIndicadorVariables(queryP);
        String var_principal = varP.getInvaEtiqueta();

        HashMap hm = new HashMap();

        hm.put("indi_nombre", indi.getIndiNombre());
        hm.put("tipo_indicador", indi.getTiinNombre());
        hm.put("unidad_medida", indi.getUnmeNombre());

        if (indi.getIndiFicha()) {

            String queryB = "SELECT "
                    + "(xpath('/data/" + var_principal + "/text()', meta_data))[1]::text as varP "
                    + "FROM planeamiento.indicadores_data_xml "
                    + "WHERE indi_id = " + indi_id + " AND es_meta = FALSE AND es_base = TRUE";
            List<PlaneamientoMetaData> listB = new PlaneamientoMetaDataDao().getListaDatos(queryB);

            String queryA = "SELECT "
                    + "(xpath('/data/" + var_principal + "/text()', meta_data))[1]::text as varP "
                    + "FROM planeamiento.indicadores_data_xml "
                    + "WHERE indi_id = " + indi_id + " AND es_meta = FALSE "
                    + "ORDER BY (xpath('/data/" + var_principal + "/text()', meta_data))[1]::text DESC";
            List<PlaneamientoMetaData> listA = new PlaneamientoMetaDataDao().getListaDatos(queryA);

            String queryF = " WHERE indi_id = " + indi_id + " AND info_principal = TRUE AND info_estado = 'A' ";
            Planeamiento varF = new PlaneamientoDao().getIndicadorFormula(queryF);
            String formula = varF.getInfoQuery();
            String query1 = formula.replace("{value}", listB.get(0).getVarP());
            String query1_1 = query1.replace("{indi}", indi_id);
            List<PlaneamientoMetaData> list1 = new PlaneamientoMetaDataDao().getListaDatos(query1_1);
            String query2 = formula.replace("{value}", listA.get(0).getVarP());
            String query2_1 = query2.replace("{indi}", indi_id);
            List<PlaneamientoMetaData> list2 = new PlaneamientoMetaDataDao().getListaDatos(query2_1);

            hm.put("indi_ficha", indi.getIndiFicha());
            hm.put("nombre", indi.getIndiNombre());
            hm.put("definicion", indi.getIndiDefinicion());
            hm.put("tipo", indi.getTiinNombre());
            hm.put("desagrega", indi.getIndiDesagregaGeografica());
            hm.put("unidad", indi.getUnmeNombre());
            if (list1.get(0).getMedicion() == null) {
                hm.put("base", "S.I. (" + listB.get(0).getVarP() + ")");
            } else {
                switch (indi.getUnmeNombre()) {
                    case "Porcentaje":
                        hm.put("base", formatNumero(list1.get(0).getMedicion()) + " % (" + listB.get(0).getVarP() + ")");
                        break;
                    case "Número":
                        hm.put("base", formatEntero(list1.get(0).getMedicion()) + " (" + listB.get(0).getVarP() + ")");
                        break;
                    default:
                        hm.put("base", formatNumero(list1.get(0).getMedicion()) + " (" + listB.get(0).getVarP() + ")");
                        break;
                }
            }
            if (list2.get(0).getMedicion() == null) {
                hm.put("base", "S.I. (" + listA.get(0).getVarP() + ")");
            } else {
                switch (indi.getUnmeNombre()) {
                    case "Porcentaje":
                        hm.put("actual", formatNumero(list2.get(0).getMedicion()) + " % (" + listA.get(0).getVarP() + ")");
                        break;
                    case "Número":
                        hm.put("actual", formatEntero(list2.get(0).getMedicion()) + " (" + listA.get(0).getVarP() + ")");
                        break;
                    default:
                        hm.put("actual", formatNumero(list2.get(0).getMedicion()) + " (" + listA.get(0).getVarP() + ")");
                        break;
                }
            }

            String queryGraph = " WHERE graf_id = 121 AND graf_estado = 'A' ";
            PlaneamientoGraficas graph = new PlaneamientoGraficasDao().getGraficaBarv2d(queryGraph);
            String queryG = graph.getGrafQuery().replace("{indi}", indi_id);
            List<PlaneamientoMetaData> listDatos = new PlaneamientoMetaDataDao().getListaDatos(queryG);

            hm.put("justificacion", indi.getIndiJustificacion());
            hm.put("limitaciones", indi.getIndiLimitaciones());
            hm.put("formula", indi.getIndiFormula());
            hm.put("periodicidad", indi.getPeriNombre());
            hm.put("fuente", indi.getIndiFuenteDatos());
            hm.put("verificacion", indi.getIndiFuenteVerificacion());
            hm.put("responsable", indi.getIndiOrganoResponsable());
            hm.put("sentido", indi.getIndiSentido());
            hm.put("frecuencia", indi.getIndiFrecuencia());
            hm.put("listDatos", listDatos);

        }

        if (!listV.isEmpty()) {
            hm.put("listV", listV);
            int sizeV = listV.size();
            String queryF = "SELECT ";
            for (int i = 1; i <= sizeV; i++) {
                if (i < sizeV) {
                    queryF += "(xpath('/data/var" + i + "/text()', meta_data))[1]::text as var" + i + ", ";
                } else {
                    queryF += "(xpath('/data/var" + i + "/text()', meta_data))[1]::text as var" + i + " ";
                }
            }
            queryF += "FROM planeamiento.indicadores_data_xml "
                    + "WHERE indi_id = " + indi_id + " AND es_meta = false "
                    + "ORDER BY (xpath('/data/var1/text()', meta_data))[1]::text ASC";
            List<PlaneamientoMetaData> listF = new PlaneamientoMetaDataDao().getListaDatos(queryF);
            hm.put("sizeV", sizeV);
            hm.put("listF", listF);
        }

        Gson gson = new Gson();
        String arg = gson.toJson(hm);
        response.getWriter().print(arg);
    }

    private void indicador_tablero(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String indi_id = request.getParameter("indi_id");

        String query = " WHERE a.indi_id = " + indi_id + " AND a.indi_estado = 'A' ";
        Planeamiento indi = new PlaneamientoDao().getIndicador(query);

        String queryP = " WHERE a.indi_id = " + indi_id + " AND a.inva_principal = TRUE AND a.inva_estado = 'A' ";
        Planeamiento varP = new PlaneamientoDao().getIndicadorVariables(queryP);

        String var_principal = varP.getInvaEtiqueta();
        String queryVP = "SELECT "
                + "(xpath('/data/" + var_principal + "/text()', meta_data))[1]::text as varP "
                + "FROM planeamiento.indicadores_data_xml "
                + "WHERE indi_id = " + indi_id + " AND es_meta = false "
                + "GROUP BY (xpath('/data/" + var_principal + "/text()', meta_data))[1]::text "
                + "ORDER BY (xpath('/data/" + var_principal + "/text()', meta_data))[1]::text DESC";
        List<PlaneamientoMetaData> listP = new PlaneamientoMetaDataDao().getListaDatos(queryVP);

        String queryT = " WHERE indi_id = " + indi_id + "  AND inta_estado = 'A' ORDER BY inta_orden ASC ";
        List<Planeamiento> listT = new PlaneamientoDao().getIndicadoresTablero(queryT);

        HashMap hm = new HashMap();

        hm.put("variable_principal", varP.getInvaNombre());
        hm.put("indi_nombre", indi.getIndiNombre());
        hm.put("tipo_indicador", indi.getTiinNombre());
        hm.put("unidad_medida", indi.getUnmeNombre());
        hm.put("listP", listP);
        hm.put("listT", listT);

        Gson gson = new Gson();
        String arg = gson.toJson(hm);
        response.getWriter().print(arg);
    }

    private void indicador_medicion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String valueP = request.getParameter("valueP");
        String indi_id = request.getParameter("indi_id");

        String queryF = " WHERE indi_id = " + indi_id + " AND info_principal = TRUE AND info_estado = 'A' ";
        Planeamiento varF = new PlaneamientoDao().getIndicadorFormula(queryF);

        String formula = varF.getInfoQuery();

        String queryVP = formula.replace("{value}", valueP);
        String queryVP_1 = queryVP.replace("{indi}", indi_id);
        List<PlaneamientoMetaData> list = new PlaneamientoMetaDataDao().getListaDatos(queryVP_1);

        HashMap hm = new HashMap();

        hm.put("medicion", list.get(0).getMedicion());
        hm.put("queryVP", queryVP);

        Gson gson = new Gson();
        String arg = gson.toJson(hm);
        response.getWriter().print(arg);
    }

    private void grafica(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String indi_id = request.getParameter("indi_id");
        String graf_id = request.getParameter("graf_id");
        String tiga_id = request.getParameter("tiga_id");

        String query = " WHERE tiga_id = " + tiga_id + " AND tiga_estado = 'A' ";
        List<Planeamiento> list = new PlaneamientoDao().getTipoGrafico(query);

        String methodName = list.get(0).getTigaAbreviatura();

        try {
            String chartClassName = "servlets.PlaneamientoChartServlet"; // Paquete y ubicación de la Clase "PlaneamientoChartServlet"
            Class<?> chartClass = Class.forName(chartClassName); // Convertimos el string className a Clase
            Object chart = chartClass.newInstance(); // Invocamos un constructor vacio

            Class<?>[] paramTypes = {
                javax.servlet.http.HttpServletRequest.class,
                javax.servlet.http.HttpServletResponse.class,
                String.class,
                String.class
            };
            Method chartMethod = chart.getClass().getMethod(methodName, paramTypes); // Obtenemos el Método con el nombre y tipo de parámetros
            chartMethod.invoke(chart, request, response, indi_id, graf_id); // Pasamos los argumentos al Método

        } catch (ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | NoSuchMethodException
                | SecurityException
                | IllegalArgumentException
                | InvocationTargetException ex) {
        }

    }

    private void grafica_ficha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String indi_id = request.getParameter("indi_id");
        String graf_id = "121";

        PlaneamientoChartServlet chart = new PlaneamientoChartServlet();
        chart.barV2DFicha(request, response, indi_id, graf_id);
    }

    private void nivel_detalle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nide_id = request.getParameter("nide_id");
        String doc = request.getParameter("doc");

        String dataBase = ConexionReporte.obtenerPropiedad("dataBase");

        String query = " WHERE a.nide_id = " + nide_id + " AND a.nide_estado = 'A' ";
        Planeamiento data = new PlaneamientoDao().getNivelDetalle(query);

        String fileURL = "";
        String fileName = "";
        if (doc.equals("legal")) {
            if (dataBase.equals("servidor")) {
                fileURL = data.getNideDocLegalUrlLinux();
            }
            if (dataBase.equals("local")) {
                fileURL = data.getNideDocLegalUrlWindows();
            }
            fileName = data.getTidoNombre().toUpperCase() + " Nº " + data.getNideDocLegalNum().toUpperCase();
        }
        if (doc.equals("conte")) {
            if (dataBase.equals("servidor")) {
                fileURL = data.getNideDocContenidoUrlLinux();
            }
            if (dataBase.equals("local")) {
                fileURL = data.getNideDocContenidoUrlWindows();
            }
            fileName = data.getNideDocContenidoNombre().toUpperCase();
        }
        Path path = Paths.get(fileURL);
        String contentType = Files.probeContentType(path);

        ArchivosServlet archivos = new ArchivosServlet();
        String[] methodName = archivos.getMetodo(request, response, contentType);

        try {
            String chartClassName = "servlets.ArchivosServlet"; // Paquete y ubicación de la Clase "PlaneamientoChartServlet"
            Class<?> chartClass = Class.forName(chartClassName); // Convertimos el string className a Clase
            Object chart = chartClass.newInstance(); // Invocamos un constructor vacio

            Class<?>[] paramTypes = {
                javax.servlet.http.HttpServletRequest.class,
                javax.servlet.http.HttpServletResponse.class,
                String.class,
                String.class,
                String.class
            };
            Method chartMethod = chart.getClass().getMethod(methodName[0], paramTypes); // Obtenemos el Método con el nombre y tipo de parámetros
            chartMethod.invoke(chart, request, response, fileURL, contentType, fileName + "." + methodName[1]); // Pasamos los argumentos al Método

        } catch (ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | NoSuchMethodException
                | SecurityException
                | IllegalArgumentException
                | InvocationTargetException ex) {
        }

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
