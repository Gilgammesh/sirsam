package daos;

import config.ConexionFactory;
import beans.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author CARLOS SANTANDER
 */
public class UsuarioDao {

    private final SqlSessionFactory ssfWeb;

    public UsuarioDao() {
        ssfWeb = ConexionFactory.getSqlSessionFactory();
    }

    public List<Usuario> getListaDatos(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Usuario> list = (List<Usuario>) new ArrayList<Usuario>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Usuario.getListaDatos", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Usuario> getListaUsuarios(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Usuario> list = (List<Usuario>) new ArrayList<Usuario>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Usuario.getListaUsuarios", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Usuario> getListaPerfiles(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Usuario> list = (List<Usuario>) new ArrayList<Usuario>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Usuario.getListaPerfiles", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public List<Usuario> getListaPermisos(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Usuario> list = (List<Usuario>) new ArrayList<Usuario>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Usuario.getListaPermisos", hm);
        } finally {
            session.close();
        }
        return list;
    }

    public Usuario getDatos(String query) {
        SqlSession session = ssfWeb.openSession();
        Usuario datos = new Usuario();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            datos = session.selectOne("Usuario.getDatos", hm);
        } finally {
            session.close();
        }
        return datos;
    }

    public Integer getNroReg(String query) {
        SqlSession session = ssfWeb.openSession();
        Integer reg = 0;
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            reg = session.selectOne("Usuario.getNroReg", hm);
        } finally {
            session.close();
        }
        return reg;
    }

    public void insert(Usuario bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.insert("Usuario.insert", bean);
            session.commit();
        }
    }

    public void update(Usuario bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("Usuario.update", bean);
            session.commit();
        }
    }

    public void updatePass(Usuario bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("Usuario.updatePass", bean);
            session.commit();
        }
    }

    public void deleteUsuario(Usuario bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.delete("Usuario.deleteUsuario", bean);
            session.commit();
        }
    }

    public void deleteSesion(Usuario bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.delete("Usuario.deleteSesion", bean);
            session.commit();
        }
    }

    public void insertPerfil(Usuario bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.insert("Usuario.insertPerfil", bean);
            session.commit();
        }
    }

    public void updatePerfil(Usuario bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.update("Usuario.updatePerfil", bean);
            session.commit();
        }
    }

    public void deletePerfil(Usuario bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.delete("Usuario.deletePerfil", bean);
            session.commit();
        }
    }

    public void upsertPermisos(Usuario bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.insert("Usuario.upsertPermisos", bean);
            session.commit();
        }
    }

    public void deletePermisos(Usuario bean) {
        try (SqlSession session = ssfWeb.openSession()) {
            session.delete("Usuario.deletePermisos", bean);
            session.commit();
        }
    }

    public List<Usuario> getListMenu(String query) {
        SqlSession session = ssfWeb.openSession();
        List<Usuario> list = (List<Usuario>) new ArrayList<Usuario>();
        HashMap hm = new HashMap();
        hm.put("c", query);
        try {
            list = session.selectList("Usuario.getListMenu", hm);
        } finally {
            session.close();
        }
        return list;
    }

}
