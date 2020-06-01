package servlets;

import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * @author CARLOS SANTANDER
 */
@WebServlet(name = "UploadServlet", urlPatterns = {"/Upload"})
@MultipartConfig
public class UploadServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String tipo = request.getParameter("tipo") == null ? "" : request.getParameter("tipo");

        switch (tipo) {
            case "01":
                subir_Archivo(request, response);
                break;
        }

    }

    private void subir_Archivo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        Part filePart = request.getPart("fileUp");
        String codSiaf = "2234505";
        //String texto = request.getParameter("texto");

        HashMap outHash = new HashMap();

        if (filePart == null) {
            outHash.put("estado", false);
        } else {
            String fileName = filePart.getSubmittedFileName();
            String name = filePart.getName();
            String[] fileNamePart = fileName.split("\\.");
            int size = fileNamePart.length;
            InputStream fileContenido = filePart.getInputStream();
            Path rutaDestino = Paths.get("\\\\172.16.100.52\\sirsam\\inversion publica\\" + codSiaf + "\\" + name + "." + fileNamePart[size - 1]);
            Path carpeta = Paths.get("\\\\172.16.100.52\\sirsam\\inversion publica\\" + codSiaf);
            if (!Files.exists(carpeta)) {
                Files.createDirectory(carpeta);
            }
            Files.copy(fileContenido, rutaDestino, StandardCopyOption.REPLACE_EXISTING);
            outHash.put("estado", true);
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
