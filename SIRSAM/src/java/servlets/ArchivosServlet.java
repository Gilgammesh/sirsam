package servlets;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author CARLOS SANTANDER
 */
@WebServlet(name = "ArchivosServlet", urlPatterns = {"/Archivos"})
public class ArchivosServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String tipo = request.getParameter("tipo") == null ? "" : request.getParameter("tipo");

        switch (tipo) {
            case "planeamiento":
                planeamiento(request, response);
                break;
            case "proyectos":
                proyectos(request, response);
                break;
        }
        request.getRequestDispatcher("./WEB-INF/archivos.jsp").forward(request, response);

    }

    private void planeamiento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String url = request.getParameter("url") == null ? "" : request.getParameter("url");

        switch (url) {
            case "nivel_detalle":
                String nide_id = request.getParameter("nide_id");
                String doc = request.getParameter("doc");
                request.setAttribute("hrefFrame", "./Planeamiento?url=" + url + "&nide_id=" + nide_id + "&doc=" + doc);
                break;
        }

        request.getRequestDispatcher("./WEB-INF/archivos.jsp").forward(request, response);

    }

    private void proyectos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String url = request.getParameter("url") == null ? "" : request.getParameter("url");

        switch (url) {
            case "contratos":
                String cod = request.getParameter("cod_siaf");
                String ord = request.getParameter("contrato_orden");
                request.setAttribute("hrefFrame", "./Proyectos?tipo=00_6_1&cod_siaf=" + cod + "&contrato_orden=" + ord);
                break;
        }

        request.getRequestDispatcher("./WEB-INF/archivos.jsp").forward(request, response);

    }

    public void pdf(
            HttpServletRequest request,
            HttpServletResponse response,
            String fileURL,
            String contentType,
            String fileName
    ) throws ServletException, IOException {

        ServletOutputStream out = null;
        FileInputStream ficheroInput = new FileInputStream(fileURL);
        int tamanoInput = ficheroInput.available();
        byte[] datos = new byte[tamanoInput];
        ficheroInput.read(datos, 0, tamanoInput);
        response.setContentType(contentType);
        response.setContentLength(datos.length);
        response.setHeader("Content-Disposition", "inline; filename=" + fileName + ""); // vista previa
        //response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ""); // descarga directa
        out = response.getOutputStream();
        out.write(datos, 0, datos.length);
        ficheroInput.close();
        out.close();

    }

    public void word(
            HttpServletRequest request,
            HttpServletResponse response,
            String fileURL,
            String contentType,
            String fileName
    ) throws ServletException, IOException {

        ServletOutputStream out = null;
        FileInputStream ficheroInput = new FileInputStream(fileURL);
        int tamanoInput = ficheroInput.available();
        byte[] datos = new byte[tamanoInput];
        ficheroInput.read(datos, 0, tamanoInput);
        response.setContentType(contentType);
        response.setContentLength(datos.length);
        //response.setHeader("Content-Disposition", "inline; filename=" + fileName + ""); // vista previa
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ""); // descarga directa
        out = response.getOutputStream();
        out.write(datos, 0, datos.length);
        ficheroInput.close();
        out.close();

    }

    public void excel(
            HttpServletRequest request,
            HttpServletResponse response,
            String fileURL,
            String contentType,
            String fileName
    ) throws ServletException, IOException {

        ServletOutputStream out = null;
        FileInputStream ficheroInput = new FileInputStream(fileURL);
        int tamanoInput = ficheroInput.available();
        byte[] datos = new byte[tamanoInput];
        ficheroInput.read(datos, 0, tamanoInput);
        response.setContentType(contentType);
        response.setContentLength(datos.length);
        //response.setHeader("Content-Disposition", "inline; filename=" + fileName + ""); // vista previa
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ""); // descarga directa
        out = response.getOutputStream();
        out.write(datos, 0, datos.length);
        ficheroInput.close();
        out.close();

    }

    public void powerpoint(
            HttpServletRequest request,
            HttpServletResponse response,
            String fileURL,
            String contentType,
            String fileName
    ) throws ServletException, IOException {

        ServletOutputStream out = null;
        FileInputStream ficheroInput = new FileInputStream(fileURL);
        int tamanoInput = ficheroInput.available();
        byte[] datos = new byte[tamanoInput];
        ficheroInput.read(datos, 0, tamanoInput);
        response.setContentType(contentType);
        response.setContentLength(datos.length);
        //response.setHeader("Content-Disposition", "inline; filename=" + fileName + ""); // vista previa
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ""); // descarga directa
        out = response.getOutputStream();
        out.write(datos, 0, datos.length);
        ficheroInput.close();
        out.close();

    }

    public String[] getMetodo(
            HttpServletRequest request,
            HttpServletResponse response,
            String contentType
    ) throws ServletException, IOException {
        String[] metodo = new String[2];
        if (contentType.equals("application/pdf")) {
            metodo[0] = "pdf";
            metodo[1] = "pdf";
        }
        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            metodo[0] = "excel";
            metodo[1] = "xlsx";
        }
        if (contentType.equals("application/vnd.ms-excel")) {
            metodo[0] = "excel";
            metodo[1] = "xls";
        }
        if (contentType.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")) {
            metodo[0] = "word";
            metodo[1] = "docx";
        }
        if (contentType.equals("application/msword")) {
            metodo[0] = "word";
            metodo[1] = "doc";
        }
        if (contentType.equals("application/vnd.openxmlformats-officedocument.presentationml.presentation")) {
            metodo[0] = "powerpoint";
            metodo[1] = "pptx";
        }
        if (contentType.equals("application/vnd.ms-powerpoint")) {
            metodo[0] = "powerpoint";
            metodo[1] = "ppt";
        }
        return metodo;
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
