package estadistica.dao;

import config.SIRSAMConexion;
import estadistica.bean.InstitucionEducativa;
import estadistica.bean.LogsEstadisticaBot;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/*
 ** @author CARLOS SANTANDER
 */
public class EstadisticaDao {
    
    private final SqlSessionFactory ssfWeb;
    
    public EstadisticaDao() throws IOException {
        ssfWeb = SIRSAMConexion.getSqlSessionFactory();
    }

    // LOGS DE ACTUALIZACION DE FUENTES ESTADÍSTICAS ....................................................................................................... 
    public void insertLogsEstadisticaBot(long time, String fuente, String host, String ip, String actualizo, String log_cliente, String log_servidor) {
        try (SqlSession session = ssfWeb.openSession()) {
            LogsEstadisticaBot logs = new LogsEstadisticaBot();
            logs.setFecha_hora(new Timestamp(time));
            logs.setFuente(fuente);
            logs.setHostname(host);
            logs.setIp_local(ip);
            logs.setActualizo(actualizo);
            logs.setError_fuente(log_cliente);
            logs.setError_postgresql(log_servidor);
            session.insert("Estadistica.insertLogsEstadisticaBot", logs);
            session.commit();
        }
    }

    // FUENTE INSTITUCIONES EDUCATIVAS......................................................................
    public void upsertInstitucionEducativa(List<InstitucionEducativa> dataInstitucionEducativa, long time, String fuente, String host, String ip) throws IOException {
        try (SqlSession session = ssfWeb.openSession()) {
            dataInstitucionEducativa.stream().map((item) -> {
                InstitucionEducativa bean = new InstitucionEducativa();
                bean.setCod_mod(item.getCod_mod());
                bean.setAnexo(item.getAnexo());
                bean.setCodlocal(item.getCodlocal());
                bean.setCen_edu(item.getCen_edu());
                bean.setNiv_mod(item.getNiv_mod());
                bean.setD_niv_mod(item.getD_niv_mod());
                bean.setD_forma(item.getD_forma());
                bean.setCod_car(item.getCod_car());
                bean.setD_cod_car(item.getD_cod_car());
                bean.setTipssexo(item.getTipssexo());
                bean.setD_tipssexo(item.getD_tipssexo());
                bean.setGestion(item.getGestion());
                bean.setD_gestion(item.getD_gestion());
                bean.setGes_dep(item.getGes_dep());
                bean.setD_ges_dep(item.getD_ges_dep());
                bean.setDirector(item.getDirector());
                bean.setTelefono(item.getTelefono());
                bean.setEmail(item.getEmail());
                bean.setPagweb(item.getPagweb());
                bean.setDir_cen(item.getDir_cen());
                bean.setReferencia(item.getReferencia());
                bean.setLocalidad(item.getLocalidad());
                bean.setCodcp_inei(item.getCodcp_inei());
                bean.setCodccpp(item.getCodccpp());
                bean.setCen_pob(item.getCen_pob());
                bean.setArea_censo(item.getArea_censo());
                bean.setDareacenso(item.getDareacenso());
                bean.setCodgeo(item.getCodgeo());
                bean.setD_dpto(item.getD_dpto());
                bean.setD_prov(item.getD_prov());
                bean.setD_dist(item.getD_dist());
                bean.setD_region(item.getD_region());
                bean.setCodooii(item.getCodooii());
                bean.setD_dreugel(item.getD_dreugel());
                bean.setNlat_ie(item.getNlat_ie());
                bean.setNlong_ie(item.getNlong_ie());
                bean.setTipoprog(item.getTipoprog());
                bean.setD_tipoprog(item.getD_tipoprog());
                bean.setCod_tur(item.getCod_tur());
                bean.setD_cod_tur(item.getD_cod_tur());
                bean.setEstado(item.getEstado());
                bean.setD_estado(item.getD_estado());
                bean.setD_fte_dato(item.getD_fte_dato());
                bean.setTalum_hom(item.getTalum_hom());
                bean.setTalum_muj(item.getTalum_muj());
                bean.setTalumno(item.getTalumno());
                bean.setTdocente(item.getTdocente());
                bean.setTseccion(item.getTseccion());
                bean.setFechareg(item.getFechareg());
                bean.setFecha_act(item.getFecha_act());
                return bean;
            }).forEachOrdered((bean) -> {
                session.insert("Estadistica.upsertInstitucionEducativa", bean);
            });
            session.commit();
            new EstadisticaDao().insertLogsEstadisticaBot(time, fuente, host, ip, "SI", null, null);
        } catch (Exception ex) {
            new EstadisticaDao().insertLogsEstadisticaBot(time, fuente, host, ip, "NO", null, ex.toString());
        }
    }
    
}
