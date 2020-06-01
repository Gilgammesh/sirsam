package servlets;

import beans.Estadistica;
import com.google.gson.Gson;
import daos.EstadisticaDao;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
@WebServlet(name = "EstadisticaServlet", urlPatterns = {"/Estadistica"})
public class EstadisticaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String url = request.getParameter("url") == null ? "" : request.getParameter("url");

        switch (url) {
            case "sectores":
                lista_sectores(request, response);
                break;
            case "instrumentos":
                lista_instrumentos(request, response);
                break;
            case "indicadores":
                lista_indicadores(request, response);
                break;
            case "indicador":
                contenido_indicador(request, response);
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

    private void lista_sectores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String query = " WHERE sect_estado = 'A' ORDER BY sect_nombre ASC ";
        List<Estadistica> listSectores = new EstadisticaDao().getSectores(query);

        HashMap hm = new HashMap();

        hm.put("listSectores", listSectores);

        Gson gson = new Gson();
        String arg = gson.toJson(hm);
        response.getWriter().print(arg);

    }

    private void lista_instrumentos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String sector = request.getParameter("sector");

        HashMap hm = new HashMap();

        String query = " WHERE inst_estado = 'A' ORDER BY inst_nombre ASC ";
        List<Estadistica> listInstrumentos = new EstadisticaDao().getInstrumentos(query);

        hm.put("listInstrumentos", listInstrumentos);
        hm.put("sector", sector);

        Gson gson = new Gson();
        String arg = gson.toJson(hm);
        response.getWriter().print(arg);

    }

    private void lista_indicadores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String sector = request.getParameter("sector");
        String instrumento = request.getParameter("instrumento");

        HashMap hm = new HashMap();

        String query;

        if (instrumento.equals("00")) {
            query = " WHERE sect_id = " + sector + " AND indi_estado = 'A' ORDER BY indi_nombre ASC ";
        } else {
            query = " WHERE sect_id = " + sector + " AND inst_id = " + instrumento + " AND indi_estado = 'A' ORDER BY indi_nombre ASC ";
        }

        List<Estadistica> listIndicadores = new EstadisticaDao().getIndicadores(query);

        hm.put("listIndicadores", listIndicadores);

        Gson gson = new Gson();
        String arg = gson.toJson(hm);
        response.getWriter().print(arg);

    }

    private void contenido_indicador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String indi_id = request.getParameter("indi");

        HashMap hm = new HashMap();

        String query = " WHERE indi_id = " + indi_id + " AND indi_estado = 'A' ";

        Estadistica data = new EstadisticaDao().getIndicador(query);

        hm.put("id", data.getIndiId());
        hm.put("nombre", data.getIndiNombre());
        hm.put("tipo", data.getTiinId());
        hm.put("unidad", data.getUnmeId());

        Gson gson = new Gson();
        String arg = gson.toJson(hm);
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
