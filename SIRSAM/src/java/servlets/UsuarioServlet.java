package servlets;

import com.google.gson.Gson;
import beans.User;
import beans.Usuario;
import daos.UsuarioDao;
import utils.Encriptar;
import java.io.IOException;
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
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/Usuario"})
public class UsuarioServlet extends HttpServlet {

    private static final long serialVersionUID = 1816755134720281712L;

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
        if (request.getParameter("action") == null) {
            index(request, response);
        }
        if (request.getParameter("action").equals("connect")) {
            login(request, response);
        }
        if (request.getParameter("action").equals("disconnect")) {
            logout(request, response);
        }
        if (request.getParameter("action").equals("password")) {
            password(request, response);
        }
        if (request.getParameter("action").equals("nuevo")) {
            nuevo(request, response);
        }
        if (request.getParameter("action").equals("editar")) {
            editar(request, response);
        }
        if (request.getParameter("action").equals("delete")) {
            delete(request, response);
        }
        if (request.getParameter("action").equals("nuevo_perfil")) {
            nuevo_perfil(request, response);
        }
        if (request.getParameter("action").equals("editar_perfil")) {
            editar_perfil(request, response);
        }
        if (request.getParameter("action").equals("delete_perfil")) {
            delete_perfil(request, response);
        }
        if (request.getParameter("action").equals("update_permisos")) {
            update_permisos(request, response);
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

    //@SuppressWarnings({"unchecked", "rawtypes"})
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");

        String login = request.getParameter("login") == null ? "" : request.getParameter("login");
        String password = request.getParameter("password") == null ? "" : request.getParameter("password");
        String captcha = request.getParameter("captcha") == null ? "" : request.getParameter("captcha");

        HashMap hm = new HashMap();

        String query = " WHERE usua_login = '" + login + "' ";
        Usuario dataU = new UsuarioDao().getDatos(query);
        Integer reg = new UsuarioDao().getNroReg(query);

        if (reg == 0) {
            hm.put("success", false);
            hm.put("msg", "El usuario no existe");
        }
        if (reg == 1) {
            if (dataU.getUsuaEstado() == true) {
                try {
                    if (dataU.getUsuaClave().equals(Encriptar.md5(Encriptar.md5(Encriptar.md5(password.trim()))))) {

                        if (request.getSession().getAttribute("captcha").equals(captcha)) {

                            request.getSession().setAttribute("id_usuario", dataU.getUsuaId());
                            request.getSession().setAttribute("dni", dataU.getUsuaLogin());
                            request.getSession().setAttribute("nombres", dataU.getUsuaNombres());
                            request.getSession().setAttribute("apellido_paterno", dataU.getUsuaApellidoPaterno());
                            request.getSession().setAttribute("apellido_materno", dataU.getUsuaApellidoMaterno());
                            request.getSession().setAttribute("sexo", dataU.getUsuaSexo());
                            request.getSession().setAttribute("perfil", dataU.getPerfId());

                            request.getSession().setAttribute("user", new User());

                            hm.put("success", true);
                            hm.put("msg", "./sistema");

                        } else {
                            hm.put("success", false);
                            hm.put("msg", "Ingrese Correctamente el Captcha");
                        }
                    } else {
                        hm.put("success", false);
                        hm.put("msg", "La contraseña ingresada es incorrecta");
                    }
                } catch (Exception ex) {
                    hm.put("msg", "Excepción");
                }
            }
            if (dataU.getUsuaEstado() == false) {
                hm.put("success", false);
                hm.put("msg", "El usuario está desactivado");
            }
        }

        if (reg >= 2) {
            hm.put("success", false);
            hm.put("msg", "Existe más de un usuario registrado con este DNI");
        }
        Gson gson = new Gson();
        String arg = gson.toJson(hm);
        response.getWriter().print(arg);
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");

        request.getSession().removeAttribute("id_usuario");
        request.getSession().removeAttribute("perfil");
        request.getSession().invalidate();

        HashMap hm = new HashMap();
        hm.put("window", "./sistema");
        Gson gson = new Gson();
        String arg = gson.toJson(hm);
        response.getWriter().print(arg);

    }

    private void password(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");

        Integer usua_id = Integer.parseInt(request.getParameter("usua_id"));
        String passwordA = request.getParameter("passwordA");
        String passwordN = request.getParameter("passwordN");
        String passwordR = request.getParameter("passwordR");

        String query = " WHERE usua_id = " + usua_id + " ";
        Usuario dataU = new UsuarioDao().getDatos(query);

        HashMap hm = new HashMap();

        try {

            String passEncryptedA = Encriptar.md5(Encriptar.md5(Encriptar.md5(passwordA.trim())));
            String passEncryptedN = Encriptar.md5(Encriptar.md5(Encriptar.md5(passwordN.trim())));

            if (dataU.getUsuaClave().equals(passEncryptedA)) {

                if (passwordN.equals(passwordR)) {

                    if (passwordN.length() >= 6) {

                        Usuario bean = new Usuario();
                        bean.setUsuaId(usua_id);
                        bean.setUsuaClave(passEncryptedN);
                        new UsuarioDao().updatePass(bean);

                        request.getSession().removeAttribute("id_usuario");
                        request.getSession().removeAttribute("perfil");
                        request.getSession().invalidate();

                        hm.put("success", true);
                        hm.put("msg", "La contraseña se cambió correctamente");
                        hm.put("window", "./sistema");

                    } else {
                        hm.put("success", false);
                        hm.put("msg", "La contraseña debe contener como mínimo 06 caracteres");
                    }

                } else {
                    hm.put("success", false);
                    hm.put("msg", "La confirmación de contraseña no coincide con la contraseña nueva");
                }

            } else {
                hm.put("success", false);
                hm.put("msg", "La contraseña actual es incorrecta");
            }
        } catch (Exception ex) {
            hm.put("success", false);
            hm.put("msg", "Excepción");
        }

        Gson gson = new Gson();
        String arg = gson.toJson(hm);
        response.getWriter().print(arg);

    }

    private void nuevo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");

        String nombres = request.getParameter("nombres") == null ? "" : request.getParameter("nombres").toUpperCase().trim();
        String paterno = request.getParameter("paterno") == null ? "" : request.getParameter("paterno").toUpperCase().trim();
        String materno = request.getParameter("materno") == null ? "" : request.getParameter("materno").toUpperCase().trim();
        String dni = request.getParameter("dni") == null ? "" : request.getParameter("dni").trim();
        String password = request.getParameter("password") == null ? "" : request.getParameter("password").trim();
        String estado = request.getParameter("estado") == null ? "false" : request.getParameter("estado");
        String sexo = request.getParameter("sexo");
        String perf_id = request.getParameter("perf_id");
        String sec_ejec = request.getParameter("sec_ejec");

        HashMap hm = new HashMap();

        try {
            String passEncrypted = Encriptar.md5(Encriptar.md5(Encriptar.md5(password)));

            Usuario bean = new Usuario();
            bean.setUsuaNombres(nombres);
            bean.setUsuaApellidoPaterno(paterno);
            bean.setUsuaApellidoMaterno(materno);
            bean.setUsuaLogin(dni);
            bean.setUsuaClave(passEncrypted);
            bean.setUsuaEstado(Boolean.valueOf(estado));
            bean.setUsuaSexo(sexo);
            bean.setPerfId(Integer.parseInt(perf_id));
            bean.setSec_ejec(sec_ejec);
            new UsuarioDao().insert(bean);

            hm.put("success", true);
            hm.put("msg", "Se añadió nuevo usuario.");

        } catch (Exception e) {
            hm.put("success", false);
            hm.put("msg", "No se pudo añadir al usuario. Intente nuevamente!!");
        }

        hm.put("success", true);
        hm.put("msg", nombres);

        Gson gson = new Gson();
        String arg = gson.toJson(hm);
        response.getWriter().print(arg);
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");

        String usua_id = request.getParameter("usua_id");
        String nombres = request.getParameter("nombres") == null ? "" : request.getParameter("nombres").toUpperCase().trim();
        String paterno = request.getParameter("paterno") == null ? "" : request.getParameter("paterno").toUpperCase().trim();
        String materno = request.getParameter("materno") == null ? "" : request.getParameter("materno").toUpperCase().trim();
        String dni = request.getParameter("dni") == null ? "" : request.getParameter("dni").trim();
        String password = request.getParameter("password") == null ? "" : request.getParameter("password").trim();
        String estado = request.getParameter("estado") == null ? "false" : request.getParameter("estado");
        String sexo = request.getParameter("sexo");
        String perf_id = request.getParameter("perf_id");
        String sec_ejec = request.getParameter("sec_ejec");
        HashMap hm = new HashMap();

        try {
            String passEncrypted = Encriptar.md5(Encriptar.md5(Encriptar.md5(password)));
            String query = " WHERE usua_id =" + usua_id + " ";
            Usuario dataU = new UsuarioDao().getDatos(query);

            Usuario bean = new Usuario();
            bean.setUsuaId(Integer.parseInt(usua_id));
            bean.setUsuaNombres(nombres);
            bean.setUsuaApellidoPaterno(paterno);
            bean.setUsuaApellidoMaterno(materno);
            bean.setUsuaLogin(dni);
            if (dataU.getUsuaClave().equals(password)) {
                bean.setUsuaClave(password);
            } else {
                bean.setUsuaClave(passEncrypted);
            }
            bean.setUsuaEstado(Boolean.valueOf(estado));
            bean.setUsuaSexo(sexo);
            bean.setPerfId(Integer.parseInt(perf_id));
            bean.setSec_ejec(sec_ejec);
            new UsuarioDao().update(bean);

            hm.put("success", true);
            hm.put("msg", "Se actualizaron los datos correctamente.");

        } catch (Exception e) {
            hm.put("success", false);
            hm.put("msg", "No se pudo actualizar los datos del Usuario. Intente nuevamente!!");
        }

        Gson gson = new Gson();
        String arg = gson.toJson(hm);
        response.getWriter().print(arg);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");

        String usua_id = request.getParameter("usua_id");

        HashMap hm = new HashMap();

        try {

            Usuario bean = new Usuario();
            bean.setUsuaId(Integer.parseInt(usua_id));
            new UsuarioDao().deleteUsuario(bean);
            new UsuarioDao().deleteSesion(bean);

            hm.put("msg", "Se eliminó el usuario correctamente.");

        } catch (NumberFormatException ex) {
            hm.put("msg", "No se pudo eliminar el Usuario. Intente nuevamente!!");
        }

        Gson gson = new Gson();
        String arg = gson.toJson(hm);
        response.getWriter().print(arg);
    }

    private void nuevo_perfil(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");

        String perfil = request.getParameter("perfil") == null ? "" : request.getParameter("perfil").toUpperCase().trim();
        String descripcion = request.getParameter("descripcion") == null ? "" : request.getParameter("descripcion").trim();
        HashMap hm = new HashMap();

        try {

            Usuario bean = new Usuario();
            bean.setPerfNombre(perfil);
            bean.setPerfDescripcion(descripcion);
            new UsuarioDao().insertPerfil(bean);

            String queryP1 = "ORDER BY perf_id DESC LIMIT 1";
            List<Usuario> listPerfiles = new UsuarioDao().getListaPerfiles(queryP1);
            Integer perf_id = listPerfiles.get(0).getPerfId();

            String queryP2 = "ORDER BY menu_id ASC";
            List<Usuario> listMenu = new UsuarioDao().getListMenu(queryP2);

            for (Usuario list : listMenu) {
                Usuario data = new Usuario();
                data.setPerfId(perf_id);
                data.setMenuId(list.getMenuId());
                data.setRegistra(Boolean.FALSE);
                if (list.getMenuId() == 1) {
                    data.setActivo(Boolean.TRUE);
                } else {
                    data.setActivo(Boolean.FALSE);
                }
                new UsuarioDao().upsertPermisos(data);
            }

            hm.put("success", true);
            hm.put("msg", "Se añadió nuevo perfil de usuario");

        } catch (Exception e) {
            hm.put("success", false);
            hm.put("msg", "No se pudo añadir el perfil de usuario. Intente nuevamente!!");
        }

        Gson gson = new Gson();
        String arg = gson.toJson(hm);
        response.getWriter().print(arg);
    }

    private void editar_perfil(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");

        String perf_id = request.getParameter("perf_id");
        String perfil = request.getParameter("perfil") == null ? "" : request.getParameter("perfil").toUpperCase().trim();
        String descripcion = request.getParameter("descripcion") == null ? "" : request.getParameter("descripcion").trim();
        HashMap hm = new HashMap();

        try {
            Usuario bean = new Usuario();
            bean.setPerfId(Integer.parseInt(perf_id));
            bean.setPerfNombre(perfil);
            bean.setPerfDescripcion(descripcion);
            new UsuarioDao().updatePerfil(bean);

            hm.put("success", true);
            hm.put("msg", "Se actualizó el perfil de usuario");

        } catch (NumberFormatException e) {
            hm.put("success", false);
            hm.put("msg", "No se pudo actualizar el perfil de usuario. Intente nuevamente!!");
        }

        Gson gson = new Gson();
        String arg = gson.toJson(hm);
        response.getWriter().print(arg);
    }

    private void delete_perfil(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");

        String perf_id = request.getParameter("perf_id");

        HashMap hm = new HashMap();

        try {

            Usuario bean = new Usuario();
            bean.setPerfId(Integer.parseInt(perf_id));
            new UsuarioDao().deletePerfil(bean);
            new UsuarioDao().deletePermisos(bean);

            hm.put("msg", "Se eliminó el perfil de usuario correctamente");

        } catch (NumberFormatException ex) {
            hm.put("msg", "No se pudo eliminar el Perfil de Usuario. Intente nuevamente!!");
        }

        Gson gson = new Gson();
        String arg = gson.toJson(hm);
        response.getWriter().print(arg);
    }

    private void update_permisos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");

        String perf_id = request.getParameter("perf_id");
        Integer count = Integer.parseInt(request.getParameter("count"));
        String perfil = request.getParameter("perfil") == null ? "" : request.getParameter("perfil").toUpperCase().trim();
        String descripcion = request.getParameter("descripcion") == null ? "" : request.getParameter("descripcion").trim();

        HashMap hm = new HashMap();

        try {
            for (int i = 1; i <= count; i++) {
                Usuario data = new Usuario();
                data.setPerfId(Integer.parseInt(perf_id));
                data.setMenuId(i);
                String registra = request.getParameter("registra_" + i) == null ? "" : request.getParameter("registra_" + i);
                if (registra.equals("")) {
                    data.setRegistra(Boolean.FALSE);
                } else {
                    data.setRegistra(Boolean.TRUE);
                }
                String activo = request.getParameter("activo_" + i) == null ? "" : request.getParameter("activo_" + i);
                if (activo.equals("")) {
                    data.setActivo(Boolean.FALSE);
                } else {
                    data.setActivo(Boolean.TRUE);
                }
                new UsuarioDao().upsertPermisos(data);
            }

            hm.put("success", true);
            hm.put("msg", "Se actualizaron los permisos correctamente");

        } catch (NumberFormatException e) {
            hm.put("success", false);
            hm.put("msg", "No se pudieron actualizar los permisos. Intente nuevamente!!");
        }

        Gson gson = new Gson();
        String arg = gson.toJson(hm);
        response.getWriter().print(arg);
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("./error.jsp").forward(request, response);
    }
}
