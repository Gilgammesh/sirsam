package servlets;

import beans.Proyectos;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import config.ConexionReporte;
import daos.ProyectosDao;
import java.awt.Color;
import java.awt.Paint;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * @author CARLOS SANTANDER
 */
@WebServlet(name = "ProyectosServlet", urlPatterns = {"/Proyectos"})
@MultipartConfig
public class ProyectosServlet extends HttpServlet {

    JFreeChartServlet chart = new JFreeChartServlet();

    Paint blanco = Color.WHITE;
    Paint negro = Color.BLACK;
    Paint semi_negro = new Color(51, 51, 51);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String tipo = request.getParameter("tipo") == null ? "" : request.getParameter("tipo");

        switch (tipo) {
            case "00":
                busqueda_proyecto_registro(request, response);
                break;
            case "00_1_1":
                registrar_info_estudio(request, response);
                break;
            case "00_1_2":
                registrar_info_estudio_etapa(request, response);
                break;
            case "00_1_3":
                borrar_info_estudio_etapa(request, response);
                break;
            case "00_2":
                registrar_info_supervision(request, response);
                break;
            case "00_2_1":
                registrar_info_supervision_adelanto(request, response);
                break;
            case "00_2_2":
                borrar_info_supervision_adelanto(request, response);
                break;
            case "00_3":
                registrar_info_ejecucion(request, response);
                break;
            case "00_3_1":
                registrar_info_ejecucion_adelanto(request, response);
                break;
            case "00_3_2":
                borrar_info_ejecucion_adelanto(request, response);
                break;
            case "00_4_1":
                registrar_info_ampliacion(request, response);
                break;
            case "00_4_2":
                borrar_info_ampliacion(request, response);
                break;
            case "00_5_1":
                registrar_info_paraliz_suspen(request, response);
                break;
            case "00_5_2":
                borrar_info_paraliz_suspen(request, response);
                break;
            case "00_6":
                actualizar_info_contratos(request, response);
                break;
            case "00_6_1":
                archivos_info_contratos(request, response);
                break;
            case "00_7":
                registrar_info_componente(request, response);
                break;
            case "00_8":
                list_info_calendario(request, response);
                break;
            case "00_8_1":
                registrar_info_periodo(request, response);
                break;
            case "00_8_2":
                borrar_info_periodo(request, response);
                break;
            case "00_8_3":
                registrar_info_calendario_componente(request, response);
                break;
            case "00_9":
                actualizar_info_ubigeo(request, response);
                break;
            case "00_10_1":
                registrar_info_fotos(request, response);
                break;
            case "00_10_2":
                borrar_info_fotos(request, response);
                break;
            case "00_10_3":
                actualizar_info_fotos(request, response);
                break;
            case "ejecutoras":
                lista_ejecutoras(request, response);
                break;
            case "funcion":
                lista_funcion(request, response);
                break;
            case "semaforo":
                lista_semaforo(request, response);
                break;
            case "informa_general":
                informa_general(request, response);
                break;
            case "estudio_def":
                estudio_definitivo(request, response);
                break;
            case "supervision":
                supervision_obra(request, response);
                break;
            case "ejecucion":
                ejecucion_obra(request, response);
                break;
            case "avance_fisico":
                avance_fisico(request, response);
                break;
            case "curva_control":
                curva_control(request, response);
                break;
            case "ejec_financiera":
                ejec_financiera(request, response);
                break;
            case "detalle_pagos":
                detalle_pagos(request, response);
                break;
            case "contrataciones":
                contrataciones(request, response);
                break;
            case "ubigeo":
                ubicacion_geografica(request, response);
                break;
            case "galeria_fotos":
                galeria_fotos(request, response);
                break;
            case "busqueda_avanzada":
                lista_busqueda(request, response);
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

    private Date anadirFecha(Date entrada, int cantidad, String tipo) {
        Instant instant = entrada.toInstant();
        LocalDate fechaI = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        TemporalUnit unidad = null;
        if (tipo.equals("dias")) {
            unidad = ChronoUnit.DAYS;
        }
        if (tipo.equals("meses")) {
            unidad = ChronoUnit.MONTHS;
        }
        if (tipo.equals("años")) {
            unidad = ChronoUnit.YEARS;
        }
        LocalDate fechaS = fechaI.plus(cantidad, unidad);
        Date salida = Date.from(fechaS.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return salida;
    }

    private Date quitarFecha(Date entrada, int cantidad, String tipo) {
        Instant instant = entrada.toInstant();
        LocalDate fechaI = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        TemporalUnit unidad = null;
        if (tipo.equals("dias")) {
            unidad = ChronoUnit.DAYS;
        }
        if (tipo.equals("meses")) {
            unidad = ChronoUnit.MONTHS;
        }
        if (tipo.equals("años")) {
            unidad = ChronoUnit.YEARS;
        }
        LocalDate fechaS = fechaI.minus(cantidad, unidad);
        Date salida = Date.from(fechaS.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return salida;
    }

    private String encodingUTF8(String text) throws UnsupportedEncodingException {
        byte ptext[] = text.getBytes("ISO-8859-1");
        String value = new String(ptext, "UTF-8");
        return value;
    }

    private void busqueda_proyecto_registro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String tipo_cod = request.getParameter("radCod");
        String cod_siaf = "";

        if (tipo_cod.equals("siaf")) {
            cod_siaf = request.getParameter("codigo_siaf");
        }
        if (tipo_cod.equals("snip")) {
            String cod_snip = request.getParameter("codigo_snip");
            String query = " WHERE proy_codigo_inversion = '" + cod_snip + "' ";
            List<Proyectos> list = new ProyectosDao().getListProyectos(query);
            if (list.isEmpty()) {
                cod_siaf = "";
            } else {
                cod_siaf = list.get(0).getProyCodigoSiaf();
            }
        }

        String dataBase = ConexionReporte.obtenerPropiedad("dataBase");

        HashMap outHash = new HashMap();

        String query = " WHERE proy_codigo_siaf = '" + cod_siaf + "' ";
        List<Proyectos> listProyec = new ProyectosDao().getListProyectos(query);
        if (listProyec.isEmpty()) {
            outHash.put("proyecEstado", false);
        } else {
            outHash.put("proyecEstado", true);
            outHash.put("proyecCodSiaf", cod_siaf);
            outHash.put("proyecCodInv", listProyec.get(0).getProyCodigoInversion());
            outHash.put("proyecNombre", listProyec.get(0).getProyNombre().trim());

            List<Proyectos> listEstudio = new ProyectosDao().getListProyEstudio(query);
            if (listEstudio.isEmpty()) {
                outHash.put("estudioEstado", false);
            } else {
                outHash.put("estudioEstado", true);
                outHash.put("estudioFecha", listEstudio.get(0).getPresFechaAproba());
                outHash.put("estudioDocumento", listEstudio.get(0).getPresDocAproba());
                outHash.put("estudioContrato", listEstudio.get(0).getPresContrato());
                outHash.put("estudioResponsable", listEstudio.get(0).getPresResponsable());
            }
            String queryEst = " WHERE proy_codigo_siaf = '" + cod_siaf + "' ORDER BY preset_etapa ASC ";
            List<Proyectos> listEstudioEtapa = new ProyectosDao().getListProyEstudioEtapas(queryEst);
            if (listEstudioEtapa.isEmpty()) {
                outHash.put("etapaEst", 1);
            } else {
                String queryEtaEst = " WHERE proy_codigo_siaf = '" + cod_siaf + "' ORDER BY preset_etapa DESC ";
                List<Proyectos> listEtapaEst = new ProyectosDao().getListProyEstudioEtapas(queryEtaEst);
                outHash.put("etapaEst", listEtapaEst.get(0).getPresetEtapa() + 1);
            }
            outHash.put("listEstudioEtapa", listEstudioEtapa);
            outHash.put("proyecSupervision", listProyec.get(0).getProySupervision());
            List<Proyectos> listSuperv = new ProyectosDao().getListProySupervision(query);
            if (listSuperv.isEmpty()) {
                outHash.put("supervEstado", false);
            } else {
                outHash.put("supervEstado", true);
                outHash.put("supervProceso", listSuperv.get(0).getPrsuProceso());
                outHash.put("supervContrato", listSuperv.get(0).getPrsuContrato());
                outHash.put("supervMontoCont", listSuperv.get(0).getPrsuMontoContrato());
                outHash.put("supervProveedor", listSuperv.get(0).getPrsuProveedor());
                outHash.put("supervModalidad", listSuperv.get(0).getPrsuModalidadContrato());
                outHash.put("supervSuperNombre", listSuperv.get(0).getPrsuSupervisorNombre());
                outHash.put("supervSuperCelular", listSuperv.get(0).getPrsuSupervisorCelular());
                outHash.put("supervCoordNombre", listSuperv.get(0).getPrsuCoordinadorNombre());
                outHash.put("supervCoordCelular", listSuperv.get(0).getPrsuCoordinadorCelular());
                outHash.put("supervAdminNombre", listSuperv.get(0).getPrsuAdminContNombre());
                outHash.put("supervAdminCelular", listSuperv.get(0).getPrsuAdminContCelular());
                outHash.put("supervFechaInicio", listSuperv.get(0).getPrsuFechaInicio());
                outHash.put("supervFechaFin", listSuperv.get(0).getPrsuFechaFin());
                outHash.put("supervTieneAdelanto", listSuperv.get(0).getPrsuTieneAdelanto());
                outHash.put("supervFechaCont", listSuperv.get(0).getPrsuFechaFirmaContrato());
            }
            String querySupAd = " WHERE proy_codigo_siaf = '" + cod_siaf + "' ORDER BY prsuad_nro ASC ";
            List<Proyectos> listSuperAdela = new ProyectosDao().getListProySupervisionAdelanto(querySupAd);
            if (listSuperAdela.isEmpty()) {
                outHash.put("supervAdela", 1);
            } else {
                String querySupAdNro = " WHERE proy_codigo_siaf = '" + cod_siaf + "' ORDER BY prsuad_nro DESC ";
                List<Proyectos> listSuperAdelaNro = new ProyectosDao().getListProySupervisionAdelanto(querySupAdNro);
                outHash.put("supervAdela", listSuperAdelaNro.get(0).getPrsuadNro() + 1);
            }
            outHash.put("listSuperAdela", listSuperAdela);
            List<Proyectos> listEjecu = new ProyectosDao().getListProyEjecucion(query);
            if (listEjecu.isEmpty()) {
                outHash.put("ejecuEstado", false);
            } else {
                outHash.put("ejecuEstado", true);
                outHash.put("ejecuProceso", listEjecu.get(0).getPrejProceso());
                outHash.put("ejecuContrato", listEjecu.get(0).getPrejContrato());
                outHash.put("ejecuMontoCont", listEjecu.get(0).getPrejMontoContrato());
                outHash.put("ejecuProveedor", listEjecu.get(0).getPrejProveedor());
                outHash.put("ejecuModalidad", listEjecu.get(0).getPrejModalidadContrato());
                outHash.put("ejecuResidNombre", listEjecu.get(0).getPrejResidenteNombre());
                outHash.put("ejecuResidCelular", listEjecu.get(0).getPrejResidenteCelular());
                outHash.put("ejecuPlazo", listEjecu.get(0).getPrejPlazo());
                outHash.put("ejecuFechaInicio", listEjecu.get(0).getPrejFechaInicio());
                outHash.put("ejecuTieneAdelantoMater", listEjecu.get(0).getPrejTieneAdelantoMaterial());
                outHash.put("ejecuFechaCont", listEjecu.get(0).getPrejFechaFirmaContra());
                outHash.put("ejecuFechaTerreno", listEjecu.get(0).getPrejFechaEntregaTerre());
                outHash.put("ejecuTieneAdelantoDirec", listEjecu.get(0).getPrejTieneAdelantoDirecto());
            }
            String queryEjecAdDir = " WHERE proy_codigo_siaf = '" + cod_siaf + "' AND prejad_tipo = 'directo' ORDER BY prejad_nro ASC ";
            List<Proyectos> listEjecAdDir = new ProyectosDao().getListProyEjecucionAdelanto(queryEjecAdDir);
            if (listEjecAdDir.isEmpty()) {
                outHash.put("ejecuAdelaDirNro", 1);
            } else {
                String queryEjecAdDirNro = " WHERE proy_codigo_siaf = '" + cod_siaf + "' AND prejad_tipo = 'directo' ORDER BY prejad_nro DESC ";
                List<Proyectos> listEjecAdDirNro = new ProyectosDao().getListProyEjecucionAdelanto(queryEjecAdDirNro);
                outHash.put("ejecuAdelaDirNro", listEjecAdDirNro.get(0).getPrejadNro() + 1);
            }
            outHash.put("listEjecAdDir", listEjecAdDir);
            String queryEjecAdMat = " WHERE proy_codigo_siaf = '" + cod_siaf + "' AND prejad_tipo = 'material' ORDER BY prejad_nro ASC ";
            List<Proyectos> listEjecAdMat = new ProyectosDao().getListProyEjecucionAdelanto(queryEjecAdMat);
            if (listEjecAdMat.isEmpty()) {
                outHash.put("ejecuAdelaMatNro", 1);
            } else {
                String queryEjecAdMatNro = " WHERE proy_codigo_siaf = '" + cod_siaf + "' AND prejad_tipo = 'material' ORDER BY prejad_nro DESC ";
                List<Proyectos> listEjecAdMatNro = new ProyectosDao().getListProyEjecucionAdelanto(queryEjecAdMatNro);
                outHash.put("ejecuAdelaMatNro", listEjecAdMatNro.get(0).getPrejadNro() + 1);
            }
            outHash.put("listEjecAdMat", listEjecAdMat);
            String queryAmp = " WHERE proy_codigo_siaf = '" + cod_siaf + "' ORDER BY pram_nro ASC ";
            List<Proyectos> listAmplia = new ProyectosDao().getListProyAmpliaciones(queryAmp);
            if (listAmplia.isEmpty()) {
                outHash.put("ampReg", 1);
            } else {
                String queryAmpReg = " WHERE proy_codigo_siaf = '" + cod_siaf + "' ORDER BY pram_nro DESC ";
                List<Proyectos> listAmpliaReg = new ProyectosDao().getListProyAmpliaciones(queryAmpReg);
                outHash.put("ampReg", listAmpliaReg.get(0).getPramNro() + 1);
            }
            outHash.put("listAmplia", listAmplia);
            String queryPasu = " WHERE proy_codigo_siaf = '" + cod_siaf + "' ORDER BY prps_nro ASC ";
            List<Proyectos> listParaSusp = new ProyectosDao().getListProyParalizaSuspen(queryPasu);
            if (listParaSusp.isEmpty()) {
                outHash.put("pasuReg", 1);
            } else {
                String queryPasuReg = " WHERE proy_codigo_siaf = '" + cod_siaf + "' ORDER BY prps_nro DESC ";
                List<Proyectos> listParaSuspReg = new ProyectosDao().getListProyParalizaSuspen(queryPasuReg);
                outHash.put("pasuReg", listParaSuspReg.get(0).getPrpsNro() + 1);
            }
            outHash.put("listParaSusp", listParaSusp);
            outHash.put("dataBase", dataBase);
            String queryCont = " WHERE proy_codigo_siaf = '" + cod_siaf + "' ORDER BY prco_fecha_suscripcion ASC ";
            List<Proyectos> listContratos = new ProyectosDao().getListProyContrataciones(queryCont);
            outHash.put("listContratos", listContratos);
            String queryComp = " WHERE proy_codigo_siaf = '" + cod_siaf + "' ORDER BY prcp_orden ASC ";
            List<Proyectos> listCompon = new ProyectosDao().getListProyComponentes(queryComp);
            outHash.put("listCompon", listCompon);
            String queryCalendar = " WHERE a.proy_codigo_siaf = '" + cod_siaf + "' GROUP BY a.proy_codigo_siaf, a.prpe_ano, a.prpe_mes, b.nombre ORDER BY a.prpe_ano, a.prpe_mes ASC ";
            List<Proyectos> listCalendar = new ProyectosDao().getListProyCalendario(queryCalendar);
            outHash.put("listCalendar", listCalendar);
            String queryUbigeo = " WHERE proy_codigo_siaf = '" + cod_siaf + "' ORDER BY prub_departamento, prub_provincia, prub_distrito, prub_localidad ASC ";
            List<Proyectos> listUbigeo = new ProyectosDao().getListProyUbicacion(queryUbigeo);
            outHash.put("listUbigeo", listUbigeo);
            String queryFoto = " WHERE proy_codigo_siaf = '" + cod_siaf + "' ORDER BY prfo_orden ASC ";
            List<Proyectos> listFotos = new ProyectosDao().getListProyFotos(queryFoto);
            outHash.put("listFotos", listFotos);

        }

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void registrar_info_estudio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String codSiaf = request.getParameter("cod_siaf");
        String fecha = request.getParameter("estudFecha") == null ? "" : request.getParameter("estudFecha");
        String documento = request.getParameter("estudDoc");
        String contrato = request.getParameter("estudCont");
        String responsable = request.getParameter("estudResp");

        HashMap outHash = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Proyectos bean = new Proyectos();
            bean.setProyCodigoSiaf(codSiaf);
            if (fecha.equals("")) {
                bean.setPresFechaAproba(null);
            } else {
                Date fechaF = formatter.parse(fecha);
                bean.setPresFechaAproba(fechaF);
            }
            bean.setPresDocAproba(documento.toUpperCase().trim());
            bean.setPresContrato(contrato.toUpperCase().trim());
            bean.setPresResponsable(responsable.toUpperCase().trim());
            new ProyectosDao().upsertProyEstudio(bean);
            outHash.put("estado", true);
            outHash.put("msg", "Se actualizaron los datos correctamente!!");
        } catch (ParseException e) {
            outHash.put("estado", false);
            outHash.put("msg", "No se pudo actualizar los datos. Intente nuevamente!!");
        }

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void registrar_info_estudio_etapa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String codSiaf = request.getParameter("cod_siaf");
        String etapa = request.getParameter("etapa_est");
        String fecha = request.getParameter("etapaEstFecha") == null ? "" : request.getParameter("etapaEstFecha");
        String documento = request.getParameter("etapaEstDocu");
        String contrato = request.getParameter("etapaEstCont");
        String responsable = request.getParameter("etapaEstResp");

        HashMap outHash = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Proyectos bean = new Proyectos();
            bean.setProyCodigoSiaf(codSiaf);
            bean.setPresetEtapa(Integer.parseInt(etapa));
            if (fecha.equals("")) {
                bean.setPresetFechaAproba(null);
            } else {
                Date fechaF = formatter.parse(fecha);
                bean.setPresetFechaAproba(fechaF);
            }
            bean.setPresetDocAproba(documento.toUpperCase().trim());
            bean.setPresetContrato(contrato.toUpperCase().trim());
            bean.setPresetResponsable(responsable.toUpperCase().trim());
            new ProyectosDao().upsertProyEstudioEtapas(bean);
            outHash.put("estado", true);
            outHash.put("msg", "Se actualizaron los datos correctamente!!");
            String queryEst = " WHERE proy_codigo_siaf = '" + codSiaf + "' ORDER BY preset_etapa ASC ";
            List<Proyectos> listEstudioEtapa = new ProyectosDao().getListProyEstudioEtapas(queryEst);
            if (listEstudioEtapa.isEmpty()) {
                outHash.put("etapaEst", 1);
            } else {
                String queryEtaEst = " WHERE proy_codigo_siaf = '" + codSiaf + "' ORDER BY preset_etapa DESC ";
                List<Proyectos> listEtapaEst = new ProyectosDao().getListProyEstudioEtapas(queryEtaEst);
                outHash.put("etapaEst", listEtapaEst.get(0).getPresetEtapa() + 1);
            }
            outHash.put("listEstudioEtapa", listEstudioEtapa);
            outHash.put("proyecCodSiaf", codSiaf);
        } catch (ParseException e) {
            outHash.put("estado", false);
            outHash.put("msg", "No se pudo actualizar los datos. Intente nuevamente!!");
        }

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void borrar_info_estudio_etapa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String codSiaf = request.getParameter("cod_siaf");
        String etapa = request.getParameter("etapa_est");

        HashMap outHash = new HashMap();

        Proyectos bean = new Proyectos();
        bean.setProyCodigoSiaf(codSiaf);
        bean.setPresetEtapa(Integer.parseInt(etapa));
        new ProyectosDao().deleteProyEstudioEtapas(bean);
        String queryEst = " WHERE proy_codigo_siaf = '" + codSiaf + "' ORDER BY preset_etapa ASC ";
        List<Proyectos> listEstudioEtapa = new ProyectosDao().getListProyEstudioEtapas(queryEst);
        if (listEstudioEtapa.isEmpty()) {
            outHash.put("etapaEst", 1);
        } else {
            String queryEtaEst = " WHERE proy_codigo_siaf = '" + codSiaf + "' ORDER BY preset_etapa DESC ";
            List<Proyectos> listEtapaEst = new ProyectosDao().getListProyEstudioEtapas(queryEtaEst);
            outHash.put("etapaEst", listEtapaEst.get(0).getPresetEtapa() + 1);
        }
        outHash.put("listEstudioEtapa", listEstudioEtapa);
        outHash.put("proyecCodSiaf", codSiaf);

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void registrar_info_supervision(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String codSiaf = request.getParameter("cod_siaf");
        boolean tieneSupervision = request.getParameter("tieneSuper") != null;
        String proceso = request.getParameter("superProc");
        String contrato = request.getParameter("superCont");
        String fechaContrato = request.getParameter("superFechaCont") == null ? "" : request.getParameter("superFechaCont");
        String montoContrato = request.getParameter("superMontoCont") == null ? "" : request.getParameter("superMontoCont");
        String proveedor = request.getParameter("superProv");
        String modalidad = request.getParameter("superModa");
        String supervisorNombre = request.getParameter("superSupNom");
        String supervisorCelular = request.getParameter("superSupCel");
        String coordinadorNombre = request.getParameter("superCoorNom");
        String coordinadorCelular = request.getParameter("superCoorCel");
        String administradorNombre = request.getParameter("superAdmNom");
        String administradorCelular = request.getParameter("superAdmCel");
        String fechaInicio = request.getParameter("superFechaIni") == null ? "" : request.getParameter("superFechaIni");
        String fechaFin = request.getParameter("superFechaFin") == null ? "" : request.getParameter("superFechaFin");
        boolean tieneAdelanto = request.getParameter("superTieneAdela") != null;

        HashMap outHash = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Proyectos proy = new Proyectos();
            proy.setProyCodigoSiaf(codSiaf);
            proy.setProySupervision(tieneSupervision);
            new ProyectosDao().updateProyecto(proy);
            if (tieneSupervision) {
                Proyectos bean = new Proyectos();
                bean.setProyCodigoSiaf(codSiaf);
                bean.setPrsuProceso(proceso.toUpperCase().trim());
                bean.setPrsuContrato(contrato.toUpperCase().trim());
                if (fechaContrato.equals("")) {
                    bean.setPrsuFechaFirmaContrato(null);
                } else {
                    Date fechaContF = formatter.parse(fechaContrato);
                    bean.setPrsuFechaFirmaContrato(fechaContF);
                }
                if (montoContrato.equals("")) {
                    bean.setPrsuMontoContrato(null);
                } else {
                    bean.setPrsuMontoContrato(new BigDecimal(montoContrato.replaceAll("\\s", "").trim()));
                }
                bean.setPrsuProveedor(proveedor.toUpperCase().trim());
                bean.setPrsuModalidadContrato(modalidad.toUpperCase().trim());
                bean.setPrsuSupervisorNombre(supervisorNombre.toUpperCase().trim());
                bean.setPrsuSupervisorCelular(supervisorCelular);
                bean.setPrsuCoordinadorNombre(coordinadorNombre.toUpperCase().trim());
                bean.setPrsuCoordinadorCelular(coordinadorCelular);
                bean.setPrsuAdminContNombre(administradorNombre.toUpperCase().trim());
                bean.setPrsuAdminContCelular(administradorCelular);
                if (fechaInicio.equals("")) {
                    bean.setPrsuFechaInicio(null);
                } else {
                    Date fechaInicioF = formatter.parse(fechaInicio);
                    bean.setPrsuFechaInicio(fechaInicioF);
                }
                if (fechaFin.equals("")) {
                    bean.setPrsuFechaFin(null);
                } else {
                    Date fechaFinF = formatter.parse(fechaFin);
                    bean.setPrsuFechaFin(fechaFinF);
                }
                bean.setPrsuTieneAdelanto(tieneAdelanto);
                new ProyectosDao().upsertProySupervision(bean);
            }
            outHash.put("estado", true);
            outHash.put("msg", "Se actualizaron los datos correctamente!!");
        } catch (ParseException e) {
            outHash.put("estado", false);
            outHash.put("msg", "No se pudo actualizar los datos. Intente nuevamente!!");
        }

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void registrar_info_supervision_adelanto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String codSiaf = request.getParameter("cod_siaf");
        String numero = request.getParameter("super_adela");
        String adelanto = request.getParameter("superMontoAdela") == null ? "" : request.getParameter("superMontoAdela");
        String fecha = request.getParameter("superFechaAdela") == null ? "" : request.getParameter("superFechaAdela");
        String comentario = request.getParameter("superComentAdela") == null ? "" : request.getParameter("superComentAdela");

        HashMap outHash = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Proyectos bean = new Proyectos();
        bean.setProyCodigoSiaf(codSiaf);
        bean.setPrsuadNro(Integer.parseInt(numero));
        if (adelanto.equals("")) {
            bean.setPrsuadMonto(null);
        } else {
            bean.setPrsuadMonto(new BigDecimal(adelanto.replaceAll("\\s", "").trim()));
        }
        if (fecha.equals("")) {
            bean.setPrsuadFecha(null);
        } else {
            try {
                Date fechaF = formatter.parse(fecha);
                bean.setPrsuadFecha(fechaF);
            } catch (ParseException ex) {
                Logger.getLogger(ProyectosServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        bean.setPrsuadComentario(comentario);
        new ProyectosDao().upsertProySupervisionAdelanto(bean);
        String querySupAd = " WHERE proy_codigo_siaf = '" + codSiaf + "' ORDER BY prsuad_nro ASC ";
        List<Proyectos> listSuperAdela = new ProyectosDao().getListProySupervisionAdelanto(querySupAd);
        if (listSuperAdela.isEmpty()) {
            outHash.put("supervAdela", 1);
        } else {
            String querySupAdNro = " WHERE proy_codigo_siaf = '" + codSiaf + "' ORDER BY prsuad_nro DESC ";
            List<Proyectos> listSuperAdelaNro = new ProyectosDao().getListProySupervisionAdelanto(querySupAdNro);
            outHash.put("supervAdela", listSuperAdelaNro.get(0).getPrsuadNro() + 1);
        }
        outHash.put("listSuperAdela", listSuperAdela);
        outHash.put("proyecCodSiaf", codSiaf);

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void borrar_info_supervision_adelanto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String codSiaf = request.getParameter("cod_siaf");
        String numero = request.getParameter("super_adela");

        HashMap outHash = new HashMap();

        Proyectos bean = new Proyectos();
        bean.setProyCodigoSiaf(codSiaf);
        bean.setPrsuadNro(Integer.parseInt(numero));
        new ProyectosDao().deleteProySupervisionAdelanto(bean);
        String querySupAd = " WHERE proy_codigo_siaf = '" + codSiaf + "' ORDER BY prsuad_nro ASC ";
        List<Proyectos> listSuperAdela = new ProyectosDao().getListProySupervisionAdelanto(querySupAd);
        if (listSuperAdela.isEmpty()) {
            outHash.put("supervAdela", 1);
        } else {
            String querySupAdNro = " WHERE proy_codigo_siaf = '" + codSiaf + "' ORDER BY prsuad_nro DESC ";
            List<Proyectos> listSuperAdelaNro = new ProyectosDao().getListProySupervisionAdelanto(querySupAdNro);
            outHash.put("supervAdela", listSuperAdelaNro.get(0).getPrsuadNro() + 1);
        }
        outHash.put("listSuperAdela", listSuperAdela);
        outHash.put("proyecCodSiaf", codSiaf);

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void registrar_info_ejecucion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String codSiaf = request.getParameter("cod_siaf");
        String proceso = request.getParameter("ejecProc");
        String contrato = request.getParameter("ejecCont");
        String fechaContrato = request.getParameter("ejecFechaCont") == null ? "" : request.getParameter("ejecFechaCont");
        String montoContrato = request.getParameter("ejecMontoCont") == null ? "" : request.getParameter("ejecMontoCont");
        String proveedor = request.getParameter("ejecProv");
        String modalidad = request.getParameter("ejecModa");
        String residenteNombre = request.getParameter("ejecResiNom");
        String residenteCelular = request.getParameter("ejecResiCel");
        String fechaTerreno = request.getParameter("ejecFechaTerre") == null ? "" : request.getParameter("ejecFechaTerre");
        String fechaInicio = request.getParameter("ejecFechaIni") == null ? "" : request.getParameter("ejecFechaIni");
        String plazoEjec = request.getParameter("ejecPlazo") == null ? "" : request.getParameter("ejecPlazo");
        boolean tieneAdelantoDirecto = Boolean.parseBoolean(request.getParameter("ejecTieneAdelaDirec"));
        boolean tieneAdelantoMateriales = Boolean.parseBoolean(request.getParameter("ejecTieneAdelaMater"));
        HashMap outHash = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Proyectos bean = new Proyectos();
            bean.setProyCodigoSiaf(codSiaf);
            bean.setPrejProceso(proceso.toUpperCase().trim());
            bean.setPrejContrato(contrato.toUpperCase().trim());
            if (fechaContrato.equals("")) {
                bean.setPrejFechaFirmaContra(null);
            } else {
                Date fechaContF = formatter.parse(fechaContrato);
                bean.setPrejFechaFirmaContra(fechaContF);
            }
            if (montoContrato.equals("")) {
                bean.setPrejMontoContrato(null);
            } else {
                bean.setPrejMontoContrato(new BigDecimal(montoContrato.replaceAll("\\s", "").trim()));
            }
            bean.setPrejProveedor(proveedor.toUpperCase().trim());
            bean.setPrejModalidadContrato(modalidad.toUpperCase().trim());
            bean.setPrejResidenteNombre(residenteNombre.toUpperCase().trim());
            bean.setPrejResidenteCelular(residenteCelular);
            if (fechaTerreno.equals("")) {
                bean.setPrejFechaEntregaTerre(null);
            } else {
                Date fechaTerreF = formatter.parse(fechaTerreno);
                bean.setPrejFechaEntregaTerre(fechaTerreF);
            }
            if (fechaInicio.equals("")) {
                bean.setPrejFechaInicio(null);
            } else {
                Date fechaInicioF = formatter.parse(fechaInicio);
                bean.setPrejFechaInicio(fechaInicioF);
            }
            if (plazoEjec.equals("")) {
                bean.setPrejPlazo(null);
            } else {
                bean.setPrejPlazo(Integer.parseInt(plazoEjec.replaceAll("\\s", "").trim()));
            }
            bean.setPrejTieneAdelantoDirecto(tieneAdelantoDirecto);
            bean.setPrejTieneAdelantoMaterial(tieneAdelantoMateriales);
            new ProyectosDao().upsertProyEjecucion(bean);
            outHash.put("estado", true);
            outHash.put("msg", "Se actualizaron los datos correctamente!!");
        } catch (ParseException e) {
            outHash.put("estado", false);
            outHash.put("msg", e.toString());
        }

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void registrar_info_ejecucion_adelanto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String codSiaf = request.getParameter("cod_siaf");
        String numero = request.getParameter("ejecAdelaNro");
        String ejec_tipo = request.getParameter("ejec_tipo");

        HashMap outHash = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Proyectos bean = new Proyectos();
        bean.setProyCodigoSiaf(codSiaf);
        bean.setPrejadNro(Integer.parseInt(numero));
        if (ejec_tipo.equals("d")) {
            String adelanto = request.getParameter("ejecMontoAdelaDirec") == null ? "" : request.getParameter("ejecMontoAdelaDirec");
            String fecha = request.getParameter("ejecFechaAdelaDirec") == null ? "" : request.getParameter("ejecFechaAdelaDirec");
            String comentario = request.getParameter("ejecComentAdelaDirec") == null ? "" : request.getParameter("ejecComentAdelaDirec");
            if (adelanto.equals("")) {
                bean.setPrejadMonto(null);
            } else {
                bean.setPrejadMonto(new BigDecimal(adelanto.replaceAll("\\s", "").trim()));
            }
            bean.setPrejadTipo("directo");
            if (fecha.equals("")) {
                bean.setPrejadFecha(null);
            } else {
                try {
                    Date fechaF = formatter.parse(fecha);
                    bean.setPrejadFecha(fechaF);
                } catch (ParseException ex) {
                    Logger.getLogger(ProyectosServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            bean.setPrejadComentario(comentario);
        }
        if (ejec_tipo.equals("m")) {
            String adelanto = request.getParameter("ejecMontoAdelaMateria") == null ? "" : request.getParameter("ejecMontoAdelaMateria");
            String fecha = request.getParameter("ejecFechaAdelaMateria") == null ? "" : request.getParameter("ejecFechaAdelaMateria");
            String comentario = request.getParameter("ejecComentAdelaMateria") == null ? "" : request.getParameter("ejecComentAdelaMateria");
            if (adelanto.equals("")) {
                bean.setPrejadMonto(null);
            } else {
                bean.setPrejadMonto(new BigDecimal(adelanto.replaceAll("\\s", "").trim()));
            }
            bean.setPrejadTipo("material");
            if (fecha.equals("")) {
                bean.setPrejadFecha(null);
            } else {
                try {
                    Date fechaF = formatter.parse(fecha);
                    bean.setPrejadFecha(fechaF);
                } catch (ParseException ex) {
                    Logger.getLogger(ProyectosServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            bean.setPrejadComentario(comentario);
        }
        new ProyectosDao().upsertProyEjecucionAdelanto(bean);
        String queryEjecAdDir = " WHERE proy_codigo_siaf = '" + codSiaf + "' AND prejad_tipo = 'directo' ORDER BY prejad_nro ASC ";
        List<Proyectos> listEjecAdDir = new ProyectosDao().getListProyEjecucionAdelanto(queryEjecAdDir);
        if (listEjecAdDir.isEmpty()) {
            outHash.put("ejecuAdelaDirNro", 1);
        } else {
            String queryEjecAdDirNro = " WHERE proy_codigo_siaf = '" + codSiaf + "' AND prejad_tipo = 'directo' ORDER BY prejad_nro DESC ";
            List<Proyectos> listEjecAdDirNro = new ProyectosDao().getListProyEjecucionAdelanto(queryEjecAdDirNro);
            outHash.put("ejecuAdelaDirNro", listEjecAdDirNro.get(0).getPrejadNro() + 1);
        }
        outHash.put("listEjecAdDir", listEjecAdDir);
        String queryEjecAdMat = " WHERE proy_codigo_siaf = '" + codSiaf + "' AND prejad_tipo = 'material' ORDER BY prejad_nro ASC ";
        List<Proyectos> listEjecAdMat = new ProyectosDao().getListProyEjecucionAdelanto(queryEjecAdMat);
        if (listEjecAdMat.isEmpty()) {
            outHash.put("ejecuAdelaMatNro", 1);
        } else {
            String queryEjecAdMatNro = " WHERE proy_codigo_siaf = '" + codSiaf + "' AND prejad_tipo = 'material' ORDER BY prejad_nro DESC ";
            List<Proyectos> listEjecAdMatNro = new ProyectosDao().getListProyEjecucionAdelanto(queryEjecAdMatNro);
            outHash.put("ejecuAdelaMatNro", listEjecAdMatNro.get(0).getPrejadNro() + 1);
        }
        outHash.put("listEjecAdMat", listEjecAdMat);
        outHash.put("proyecCodSiaf", codSiaf);

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void borrar_info_ejecucion_adelanto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String codSiaf = request.getParameter("cod_siaf");
        String numero = request.getParameter("ejecAdelaNro");
        String ejec_tipo = request.getParameter("ejec_tipo");

        HashMap outHash = new HashMap();

        Proyectos bean = new Proyectos();
        bean.setProyCodigoSiaf(codSiaf);
        bean.setPrejadNro(Integer.parseInt(numero));
        if (ejec_tipo.equals("d")) {
            bean.setPrejadTipo("directo");
        }
        if (ejec_tipo.equals("m")) {
            bean.setPrejadTipo("material");
        }
        new ProyectosDao().deleteProyEjecucionAdelanto(bean);
        String queryEjecAdDir = " WHERE proy_codigo_siaf = '" + codSiaf + "' AND prejad_tipo = 'directo' ORDER BY prejad_nro ASC ";
        List<Proyectos> listEjecAdDir = new ProyectosDao().getListProyEjecucionAdelanto(queryEjecAdDir);
        if (listEjecAdDir.isEmpty()) {
            outHash.put("ejecuAdelaDirNro", 1);
        } else {
            String queryEjecAdDirNro = " WHERE proy_codigo_siaf = '" + codSiaf + "' AND prejad_tipo = 'directo' ORDER BY prejad_nro DESC ";
            List<Proyectos> listEjecAdDirNro = new ProyectosDao().getListProyEjecucionAdelanto(queryEjecAdDirNro);
            outHash.put("ejecuAdelaDirNro", listEjecAdDirNro.get(0).getPrejadNro() + 1);
        }
        outHash.put("listEjecAdDir", listEjecAdDir);
        String queryEjecAdMat = " WHERE proy_codigo_siaf = '" + codSiaf + "' AND prejad_tipo = 'material' ORDER BY prejad_nro ASC ";
        List<Proyectos> listEjecAdMat = new ProyectosDao().getListProyEjecucionAdelanto(queryEjecAdMat);
        if (listEjecAdMat.isEmpty()) {
            outHash.put("ejecuAdelaMatNro", 1);
        } else {
            String queryEjecAdMatNro = " WHERE proy_codigo_siaf = '" + codSiaf + "' AND prejad_tipo = 'material' ORDER BY prejad_nro DESC ";
            List<Proyectos> listEjecAdMatNro = new ProyectosDao().getListProyEjecucionAdelanto(queryEjecAdMatNro);
            outHash.put("ejecuAdelaMatNro", listEjecAdMatNro.get(0).getPrejadNro() + 1);
        }
        outHash.put("listEjecAdMat", listEjecAdMat);
        outHash.put("proyecCodSiaf", codSiaf);

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void registrar_info_ampliacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String codSiaf = request.getParameter("cod_siaf");
        String numero = request.getParameter("num_amp");
        String fecha = request.getParameter("ampliaFecha") == null ? "" : request.getParameter("ampliaFecha");
        String dias = request.getParameter("ampliaDias") == null ? "" : request.getParameter("ampliaDias");
        String documento = request.getParameter("ampliaDocu");
        boolean estado = request.getParameter("ampliaEstado") != null;

        HashMap outHash = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Proyectos bean = new Proyectos();
            bean.setProyCodigoSiaf(codSiaf);
            bean.setPramNro(Integer.parseInt(numero));
            if (fecha.equals("")) {
                bean.setPramFecha(null);
            } else {
                Date fechaF = formatter.parse(fecha);
                bean.setPramFecha(fechaF);
            }
            if (dias.equals("")) {
                bean.setPramDias(null);
            } else {
                bean.setPramDias(Integer.parseInt(dias.replaceAll("\\s", "").trim()));
            }
            bean.setPramDocumento(documento.toUpperCase().trim());
            bean.setPramProcedente(estado);
            new ProyectosDao().upsertProyAmpliaciones(bean);
            String queryAmp = " WHERE proy_codigo_siaf = '" + codSiaf + "' ORDER BY pram_nro ASC ";
            List<Proyectos> listAmplia = new ProyectosDao().getListProyAmpliaciones(queryAmp);
            if (listAmplia.isEmpty()) {
                outHash.put("ampReg", 1);
            } else {
                String queryAmpReg = " WHERE proy_codigo_siaf = '" + codSiaf + "' ORDER BY pram_nro DESC ";
                List<Proyectos> listAmpliaReg = new ProyectosDao().getListProyAmpliaciones(queryAmpReg);
                outHash.put("ampReg", listAmpliaReg.get(0).getPramNro() + 1);
            }
            outHash.put("estado", true);
            outHash.put("msg", "Se actualizaron los datos correctamente!!");
            outHash.put("proyecCodSiaf", codSiaf);
            outHash.put("listAmplia", listAmplia);
        } catch (ParseException e) {
            outHash.put("estado", false);
            outHash.put("msg", "No se pudo añadir los datos. Intente nuevamente!!");
        }

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void borrar_info_ampliacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String codSiaf = request.getParameter("cod_siaf");
        String numero = request.getParameter("num_amp");

        HashMap outHash = new HashMap();

        Proyectos bean = new Proyectos();
        bean.setProyCodigoSiaf(codSiaf);
        bean.setPramNro(Integer.parseInt(numero));
        new ProyectosDao().deleteProyAmpliaciones(bean);
        String queryAmp = " WHERE proy_codigo_siaf = '" + codSiaf + "' ORDER BY pram_nro ASC ";
        List<Proyectos> listAmplia = new ProyectosDao().getListProyAmpliaciones(queryAmp);
        if (listAmplia.isEmpty()) {
            outHash.put("ampReg", 1);
        } else {
            String queryAmpReg = " WHERE proy_codigo_siaf = '" + codSiaf + "' ORDER BY pram_nro DESC ";
            List<Proyectos> listAmpliaReg = new ProyectosDao().getListProyAmpliaciones(queryAmpReg);
            outHash.put("ampReg", listAmpliaReg.get(0).getPramNro() + 1);
        }
        outHash.put("proyecCodSiaf", codSiaf);
        outHash.put("listAmplia", listAmplia);

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void registrar_info_paraliz_suspen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String codSiaf = request.getParameter("cod_siaf");
        String numero = request.getParameter("num_pasu");
        String fecha = request.getParameter("parasusFecha") == null ? "" : request.getParameter("parasusFecha");
        String dias = request.getParameter("parasusDias") == null ? "" : request.getParameter("parasusDias");
        String documento = request.getParameter("parasusDocu");
        String pasu_tipo = request.getParameter("parasusTipo");

        HashMap outHash = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Proyectos bean = new Proyectos();
            bean.setProyCodigoSiaf(codSiaf);
            bean.setPrpsNro(Integer.parseInt(numero));
            if (fecha.equals("")) {
                bean.setPrpsFecha(null);
            } else {
                Date fechaF = formatter.parse(fecha);
                bean.setPrpsFecha(fechaF);
            }
            if (dias.equals("")) {
                bean.setPrpsDias(null);
            } else {
                bean.setPrpsDias(Integer.parseInt(dias.replaceAll("\\s", "").trim()));
            }
            bean.setPrpsDocumento(documento.toUpperCase().trim());
            bean.setPrpsTipo(pasu_tipo);
            new ProyectosDao().upsertProyParalizaSuspen(bean);
            String queryPasu = " WHERE proy_codigo_siaf = '" + codSiaf + "' ORDER BY prps_nro ASC ";
            List<Proyectos> listParaSusp = new ProyectosDao().getListProyParalizaSuspen(queryPasu);
            if (listParaSusp.isEmpty()) {
                outHash.put("pasuReg", 1);
            } else {
                String queryPasuReg = " WHERE proy_codigo_siaf = '" + codSiaf + "' ORDER BY prps_nro DESC ";
                List<Proyectos> listParaSuspReg = new ProyectosDao().getListProyParalizaSuspen(queryPasuReg);
                outHash.put("pasuReg", listParaSuspReg.get(0).getPrpsNro() + 1);
            }
            outHash.put("estado", true);
            outHash.put("msg", "Se actualizaron los datos correctamente!!");
            outHash.put("proyecCodSiaf", codSiaf);
            outHash.put("listParaSusp", listParaSusp);
        } catch (ParseException e) {
            outHash.put("estado", false);
            outHash.put("msg", "No se pudo añadir los datos. Intente nuevamente!!");
        }

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void borrar_info_paraliz_suspen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String codSiaf = request.getParameter("cod_siaf");
        String numero = request.getParameter("num_pasu");

        HashMap outHash = new HashMap();

        Proyectos bean = new Proyectos();
        bean.setProyCodigoSiaf(codSiaf);
        bean.setPrpsNro(Integer.parseInt(numero));
        new ProyectosDao().deleteProyParalizaSuspen(bean);
        String queryPasu = " WHERE proy_codigo_siaf = '" + codSiaf + "' ORDER BY prps_nro ASC ";
        List<Proyectos> listParaSusp = new ProyectosDao().getListProyParalizaSuspen(queryPasu);
        if (listParaSusp.isEmpty()) {
            outHash.put("pasuReg", 1);
        } else {
            String queryPasuReg = " WHERE proy_codigo_siaf = '" + codSiaf + "' ORDER BY prps_nro DESC ";
            List<Proyectos> listParaSuspReg = new ProyectosDao().getListProyParalizaSuspen(queryPasuReg);
            outHash.put("pasuReg", listParaSuspReg.get(0).getPrpsNro() + 1);
        }
        outHash.put("proyecCodSiaf", codSiaf);
        outHash.put("listParaSusp", listParaSusp);

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void actualizar_info_contratos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String codSiaf = request.getParameter("cod_siaf");
        Part filePart = request.getPart("archivoCont");
        String orden = request.getParameter("orden");
        String archivo = request.getParameter("archivo");

        String dataBase = ConexionReporte.obtenerPropiedad("dataBase");
        String rutaLinux = ConexionReporte.obtenerPropiedad("rutaLinux");
        String rutaWindows = ConexionReporte.obtenerPropiedad("rutaWindows");

        HashMap outHash = new HashMap();

        String queryCon = " WHERE proy_codigo_siaf = '" + codSiaf + "' AND prco_orden = " + orden;
        Proyectos dataContrato = new ProyectosDao().getProyContratacion(queryCon);

        String fileName = orden.trim() + ".pdf";

        Proyectos bean = new Proyectos();
        bean.setProyCodigoSiaf(codSiaf);
        bean.setPrcoOrden(Integer.parseInt(orden));
        if (filePart != null) {
            String fileType = filePart.getContentType();
            if (fileType.equals("application/octet-stream")) {
                if (archivo.equals("si")) {

                }
                if (archivo.equals("no")) {
                    bean.setPrcoUrlWindows(null);
                    bean.setPrcoUrlLinux(null);
                    new ProyectosDao().updateProyContrataciones(bean);
                    if (dataBase.equals("servidor")) {
                        if (dataContrato.getPrcoUrlLinux() != null && !dataContrato.getPrcoUrlLinux().equals("")) {
                            Path rutaDestinoInit = Paths.get(dataContrato.getPrcoUrlLinux());
                            Files.deleteIfExists(rutaDestinoInit);
                        }
                    }
                    if (dataBase.equals("local")) {
                        if (dataContrato.getPrcoUrlWindows() != null && !dataContrato.getPrcoUrlWindows().equals("")) {
                            Path rutaDestinoInit = Paths.get(dataContrato.getPrcoUrlWindows());
                            Files.deleteIfExists(rutaDestinoInit);
                        }
                    }
                }
            } else {
                InputStream fileContenido = filePart.getInputStream();
                Path rutaDestino = null;
                String rutaLinuxDestino = rutaLinux + "/inversion publica/contratos/" + codSiaf;
                String rutaWindowsDestino = rutaWindows + "\\inversion publica\\contratos\\" + codSiaf;
                if (dataBase.equals("servidor")) {
                    rutaDestino = Paths.get(rutaLinuxDestino + "/" + fileName);
                    Path carpeta = Paths.get(rutaLinuxDestino);
                    if (!Files.exists(carpeta)) {
                        Files.createDirectory(carpeta);
                    }
                    if (dataContrato.getPrcoUrlLinux() != null && !dataContrato.getPrcoUrlLinux().equals("")) {
                        Path rutaDestinoInit = Paths.get(dataContrato.getPrcoUrlLinux());
                        Files.deleteIfExists(rutaDestinoInit);
                    }
                }
                if (dataBase.equals("local")) {
                    rutaDestino = Paths.get(rutaWindowsDestino + "\\" + fileName);
                    Path carpeta = Paths.get(rutaWindowsDestino);
                    if (!Files.exists(carpeta)) {
                        Files.createDirectory(carpeta);
                    }
                    if (dataContrato.getPrcoUrlWindows() != null && !dataContrato.getPrcoUrlWindows().equals("")) {
                        Path rutaDestinoInit = Paths.get(dataContrato.getPrcoUrlWindows());
                        Files.deleteIfExists(rutaDestinoInit);
                    }
                }
                bean.setPrcoUrlWindows(rutaWindowsDestino + "\\" + fileName);
                bean.setPrcoUrlLinux(rutaLinuxDestino + "/" + fileName);
                new ProyectosDao().updateProyContrataciones(bean);
                Files.copy(fileContenido, rutaDestino, StandardCopyOption.REPLACE_EXISTING);
            }
        }

        String queryCont = " WHERE proy_codigo_siaf = '" + codSiaf + "' ORDER BY prco_fecha_suscripcion ASC ";
        List<Proyectos> listContratos = new ProyectosDao().getListProyContrataciones(queryCont);
        outHash.put("listContratos", listContratos);
        outHash.put("dataBase", dataBase);
        outHash.put("proyecCodSiaf", codSiaf);

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void archivos_info_contratos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String codSiaf = request.getParameter("cod_siaf");
        String orden = request.getParameter("contrato_orden");

        String dataBase = ConexionReporte.obtenerPropiedad("dataBase");

        String queryCont = " WHERE proy_codigo_siaf = '" + codSiaf + "' AND prco_orden = " + orden;
        List<Proyectos> listContratos = new ProyectosDao().getListProyContrataciones(queryCont);

        String fileURL = "";
        if (dataBase.equals("servidor")) {
            fileURL = listContratos.get(0).getPrcoUrlLinux();
        }
        if (dataBase.equals("local")) {
            fileURL = listContratos.get(0).getPrcoUrlWindows();
        }

        Path path = Paths.get(fileURL);
        String fileName = path.getFileName().toString();
        String contentType = Files.probeContentType(path);

        ArchivosServlet archivos = new ArchivosServlet();
        String[] methodName = archivos.getMetodo(request, response, contentType);

        try {
            String chartClassName = "servlets.ArchivosServlet"; // Paquete y ubicación de la Clase
            Class<?> chartClass = Class.forName(chartClassName); // Convertimos el string className a Clase
            Object chartI = chartClass.newInstance(); // Invocamos un constructor vacio

            Class<?>[] paramTypes = {
                javax.servlet.http.HttpServletRequest.class,
                javax.servlet.http.HttpServletResponse.class,
                String.class,
                String.class,
                String.class
            };
            Method chartMethod = chartI.getClass().getMethod(methodName[0], paramTypes); // Obtenemos el Método con el nombre y tipo de parámetros
            chartMethod.invoke(chartI, request, response, fileURL, contentType, fileName + "." + methodName[1]); // Pasamos los argumentos al Método

        } catch (ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | NoSuchMethodException
                | SecurityException
                | IllegalArgumentException
                | InvocationTargetException ex) {
        }

    }

    private void registrar_info_componente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String codSiaf = request.getParameter("cod_siaf");
        String orden = request.getParameter("comp_ord");
        String montoEstudio = request.getParameter("compMontoEstudio") == null ? "" : request.getParameter("compMontoEstudio");
        String montoContrato = request.getParameter("compMontoContrato") == null ? "" : request.getParameter("compMontoContrato");
        String montoActualizado = request.getParameter("compMontoActualizado") == null ? "" : request.getParameter("compMontoActualizado");
        String comentario = request.getParameter("compComentario");

        HashMap outHash = new HashMap();

        Proyectos bean = new Proyectos();
        bean.setProyCodigoSiaf(codSiaf);
        bean.setPrcpOrden(Integer.parseInt(orden));
        if (montoEstudio.equals("")) {
            bean.setPrcpMontoEstudio(null);
        } else {
            bean.setPrcpMontoEstudio(new BigDecimal(montoEstudio.replaceAll("\\s", "").trim()));
        }
        if (montoContrato.equals("")) {
            bean.setPrcpMontoContratado(null);
        } else {
            bean.setPrcpMontoContratado(new BigDecimal(montoContrato.replaceAll("\\s", "").trim()));
        }
        if (montoActualizado.equals("")) {
            bean.setPrcpMontoActualizado(null);
        } else {
            bean.setPrcpMontoActualizado(new BigDecimal(montoActualizado.replaceAll("\\s", "").trim()));
        }
        bean.setPrcpComentarios(comentario.toUpperCase().trim());
        new ProyectosDao().updateProyComponentes(bean);
        String queryComp = " WHERE proy_codigo_siaf = '" + codSiaf + "' ORDER BY prcp_orden ASC ";
        List<Proyectos> listCompon = new ProyectosDao().getListProyComponentes(queryComp);
        outHash.put("proyecCodSiaf", codSiaf);
        outHash.put("listCompon", listCompon);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void list_info_calendario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String codSiaf = request.getParameter("cod_siaf");
        String ano = request.getParameter("calendarAno");
        String mes = request.getParameter("calendarMes");

        HashMap outHash = new HashMap();

        String query1 = " WHERE prpe_ano = '" + ano + "' AND prpe_mes = " + mes + " ";
        String query2 = " WHERE a.proy_codigo_siaf = '" + codSiaf + "' ORDER BY a.prcp_orden ASC ";
        List<Proyectos> listCalendarComp = new ProyectosDao().getListProyCalendarioComponente(query1, query2);

        outHash.put("codSiaf", codSiaf);
        outHash.put("listCalendarComp", listCalendarComp);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void registrar_info_periodo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String codSiaf = request.getParameter("cod_siaf");
        String ano = request.getParameter("calendarAno");
        String mes = request.getParameter("calendarMes");

        HashMap outHash = new HashMap();

        Proyectos bean = new Proyectos();
        bean.setProyCodigoSiaf(codSiaf);
        bean.setPrpeAno(ano);
        bean.setPrpeMes(Integer.parseInt(mes));
        Boolean estado = new ProyectosDao().insertProyPeriodo(bean);
        String queryCalendar = " WHERE a.proy_codigo_siaf = '" + codSiaf + "' GROUP BY a.proy_codigo_siaf, a.prpe_ano, a.prpe_mes, b.nombre ORDER BY a.prpe_ano, a.prpe_mes ASC ";
        List<Proyectos> listCalendar = new ProyectosDao().getListProyCalendario(queryCalendar);
        outHash.put("proyecCodSiaf", codSiaf);
        outHash.put("estado", estado);
        outHash.put("listCalendar", listCalendar);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void borrar_info_periodo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String codSiaf = request.getParameter("cod_siaf");
        String ano = request.getParameter("calendarAno");
        String mes = request.getParameter("calendarMes");

        HashMap outHash = new HashMap();

        Proyectos bean = new Proyectos();
        bean.setProyCodigoSiaf(codSiaf);
        bean.setPrpeAno(ano);
        bean.setPrpeMes(Integer.parseInt(mes));
        new ProyectosDao().deleteProyPeriodo(bean);
        new ProyectosDao().deleteProyValorizaciones(bean);
        String queryCalendar = " WHERE a.proy_codigo_siaf = '" + codSiaf + "' GROUP BY a.proy_codigo_siaf, a.prpe_ano, a.prpe_mes, b.nombre ORDER BY a.prpe_ano, a.prpe_mes ASC ";
        List<Proyectos> listCalendar = new ProyectosDao().getListProyCalendario(queryCalendar);
        outHash.put("proyecCodSiaf", codSiaf);
        outHash.put("listCalendar", listCalendar);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void registrar_info_calendario_componente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String codSiaf = request.getParameter("cod_siaf");
        String ano = request.getParameter("calendarAno");
        String mes = request.getParameter("calendarMes");
        String idxTr = request.getParameter("idxTr");
        String orden = request.getParameter("comp_ord");
        String montoProgramado = request.getParameter("calCompMontoProgramado") == null ? "" : request.getParameter("calCompMontoProgramado");
        String montoEjecutado = request.getParameter("calCompMontoEjecutado") == null ? "" : request.getParameter("calCompMontoEjecutado");
        String valorizaPagado = request.getParameter("calCompValorPagado") == null ? "" : request.getParameter("calCompValorPagado");
        HashMap outHash = new HashMap();

        String query = " WHERE proy_codigo_siaf = '" + codSiaf + "' AND prcp_orden = " + orden;
        Proyectos data = new ProyectosDao().getProyComponente(query);
        Proyectos bean = new Proyectos();
        bean.setProyCodigoSiaf(codSiaf);
        bean.setPrcpComponente(data.getPrcpComponente());
        bean.setPrcpOrden(Integer.parseInt(orden));
        bean.setPrpeAno(ano);
        bean.setPrpeMes(Integer.parseInt(mes));
        if (montoProgramado.equals("")) {
            bean.setPrvaMontoProgramado(null);
        } else {
            bean.setPrvaMontoProgramado(new BigDecimal(montoProgramado.replaceAll("\\s", "").trim()));
        }
        if (montoEjecutado.equals("")) {
            bean.setPrvaMontoEjecutado(null);
        } else {
            bean.setPrvaMontoEjecutado(new BigDecimal(montoEjecutado.replaceAll("\\s", "").trim()));
        }
        if (valorizaPagado.equals("")) {
            bean.setPrvaMontoPagado(null);
        } else {
            bean.setPrvaMontoPagado(new BigDecimal(valorizaPagado.replaceAll("\\s", "").trim()));
        }
        new ProyectosDao().upsertProyValorizaciones(bean);
        String queryCalendar = " WHERE a.proy_codigo_siaf = '" + codSiaf + "' GROUP BY a.proy_codigo_siaf, a.prpe_ano, a.prpe_mes, b.nombre ORDER BY a.prpe_ano, a.prpe_mes ASC ";
        List<Proyectos> listCalendar = new ProyectosDao().getListProyCalendario(queryCalendar);
        outHash.put("proyecCodSiaf", codSiaf);
        outHash.put("listCalendar", listCalendar);
        outHash.put("ano", ano);
        outHash.put("mes", mes);
        outHash.put("idxTr", idxTr);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void actualizar_info_ubigeo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String codSiaf = request.getParameter("cod_siaf");
        Integer index = Integer.parseInt(request.getParameter("index"));
        String latitud = request.getParameter("ubigLatitud") == null ? "" : request.getParameter("ubigLatitud");
        String longitud = request.getParameter("ubigLongitud") == null ? "" : request.getParameter("ubigLongitud");

        HashMap outHash = new HashMap();

        String queryUbigeoAntes = " WHERE proy_codigo_siaf = '" + codSiaf + "' ORDER BY prub_departamento, prub_provincia, prub_distrito, prub_localidad ASC ";
        List<Proyectos> listUbigeoAntes = new ProyectosDao().getListProyUbicacion(queryUbigeoAntes);

        Proyectos bean = new Proyectos();
        bean.setProyCodigoSiaf(codSiaf);
        bean.setPrubDepartamento(listUbigeoAntes.get(index).getPrubDepartamento());
        bean.setPrubProvincia(listUbigeoAntes.get(index).getPrubProvincia());
        bean.setPrubDistrito(listUbigeoAntes.get(index).getPrubDistrito());
        bean.setPrubLocalidad(listUbigeoAntes.get(index).getPrubLocalidad());
        if (latitud.equals("")) {
            bean.setPrubLatitud(null);
        } else {
            bean.setPrubLatitud(new BigDecimal(latitud.replaceAll("\\s", "").trim()));
        }
        if (longitud.equals("")) {
            bean.setPrubLongitud(null);
        } else {
            bean.setPrubLongitud(new BigDecimal(longitud.replaceAll("\\s", "").trim()));
        }
        new ProyectosDao().updateProyUbicacion(bean);

        String queryUbigeo = " WHERE proy_codigo_siaf = '" + codSiaf + "' ORDER BY prub_departamento, prub_provincia, prub_distrito, prub_localidad ASC ";
        List<Proyectos> listUbigeo = new ProyectosDao().getListProyUbicacion(queryUbigeo);
        outHash.put("listUbigeo", listUbigeo);
        outHash.put("proyecCodSiaf", codSiaf);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    String[] typesImgs = {
        "bmp",
        "dib",
        "jpe",
        "jpg",
        "jpeg",
        "jfif",
        "tif",
        "tiff",
        "gif",
        "png"
    };

    private void registrar_info_fotos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String codSiaf = request.getParameter("cod_siaf");
        Part filePart = request.getPart("fotoArchivo");
        String titulo = encodingUTF8(request.getParameter("fotoTitulo"));
        String descripcion = encodingUTF8(request.getParameter("fotoDescripcion"));
        boolean principal = request.getParameter("fotoEsPrincipal") != null;

        String dataBase = ConexionReporte.obtenerPropiedad("dataBase");
        String rutaLinux = ConexionReporte.obtenerPropiedad("rutaLinux");
        String rutaWindows = ConexionReporte.obtenerPropiedad("rutaWindows");

        HashMap outHash = new HashMap();

        if (filePart == null) {
            outHash.put("estado", false);
            outHash.put("msg", "No se pudo agregar la foto. Intente nuevamente!!");
        } else {
            String fileName = filePart.getSubmittedFileName();
            String fileType = filePart.getContentType();
            String[] fileNamePart = fileName.split("\\.");
            int size = fileNamePart.length;
            InputStream fileContenido = filePart.getInputStream();
            Path rutaDestino = null;
            Proyectos bean = new Proyectos();
            bean.setProyCodigoSiaf(codSiaf);
            bean.setPrfoTipo(fileType);
            int numero;
            String queryNum = " WHERE proy_codigo_siaf = '" + codSiaf + "' ORDER BY prfo_orden DESC LIMIT 1 ";
            List<Proyectos> listNum = new ProyectosDao().getListProyFotos(queryNum);
            if (listNum.isEmpty()) {
                numero = 1;
            } else {
                numero = listNum.get(0).getPrfoOrden() + 1;
            }
            bean.setPrfoOrden(numero);
            bean.setPrfoTitulo(titulo.trim().toUpperCase());
            bean.setPrfoDescripcion(descripcion.trim());
            String rutaLinuxDestino = rutaLinux + "/inversion publica/fotos/" + codSiaf;
            String rutaWindowsDestino = rutaWindows + "\\inversion publica\\fotos\\" + codSiaf;
            String fileNameDestino = numero + "." + fileNamePart[size - 1];
            if (dataBase.equals("servidor")) {
                rutaDestino = Paths.get(rutaLinuxDestino + "/" + fileNameDestino);
                Path carpeta = Paths.get(rutaLinuxDestino);
                if (!Files.exists(carpeta)) {
                    Files.createDirectory(carpeta);
                }
                for (String typesImg : typesImgs) {
                    Path ruta = Paths.get(rutaLinuxDestino + "/" + numero + "." + typesImg);
                    Files.deleteIfExists(ruta);
                }
            }
            if (dataBase.equals("local")) {
                rutaDestino = Paths.get(rutaWindowsDestino + "\\" + fileNameDestino);
                Path carpeta = Paths.get(rutaWindowsDestino);
                if (!Files.exists(carpeta)) {
                    Files.createDirectory(carpeta);
                }
                for (String typesImg : typesImgs) {
                    Path ruta = Paths.get(rutaWindowsDestino + "\\" + numero + "." + typesImg);
                    Files.deleteIfExists(ruta);
                }
            }
            bean.setPrfoUrlWindows(rutaWindowsDestino + "\\" + fileNameDestino);
            bean.setPrfoUrlLinux(rutaLinuxDestino + "/" + fileNameDestino);
            if (principal) {
                Proyectos princ = new Proyectos();
                princ.setProyCodigoSiaf(codSiaf);
                princ.setPrfoPrincipal(false);
                new ProyectosDao().updateProyFotosPrinc(princ);
            }
            bean.setPrfoPrincipal(principal);
            new ProyectosDao().upsertProyFotos(bean);
            Files.copy(fileContenido, rutaDestino, StandardCopyOption.REPLACE_EXISTING);
            String queryFoto = " WHERE proy_codigo_siaf = '" + codSiaf + "' ORDER BY prfo_orden ASC ";
            List<Proyectos> listFotos = new ProyectosDao().getListProyFotos(queryFoto);
            outHash.put("listFotos", listFotos);
            outHash.put("dataBase", dataBase);
            outHash.put("proyecCodSiaf", codSiaf);
            outHash.put("estado", true);
        }

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void borrar_info_fotos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String codSiaf = request.getParameter("cod_siaf");
        String orden = request.getParameter("fotoOrden");
        String url = request.getParameter("fotoUrl");

        String dataBase = ConexionReporte.obtenerPropiedad("dataBase");

        HashMap outHash = new HashMap();

        Proyectos bean = new Proyectos();
        bean.setProyCodigoSiaf(codSiaf);
        bean.setPrfoOrden(Integer.parseInt(orden));
        new ProyectosDao().deleteProyFotos(bean);
        int sizeUrl = url.length();
        String[] urlPart = url.split("\\.");
        int sizePart = urlPart.length;
        String extension = urlPart[sizePart - 1];
        int sizeExt = extension.length();
        String urlPath = url.substring(0, sizeUrl - sizeExt);
        for (String typesImg : typesImgs) {
            Path ruta = Paths.get(urlPath + typesImg);
            Files.deleteIfExists(ruta);
        }
        String queryFoto = " WHERE proy_codigo_siaf = '" + codSiaf + "' ORDER BY prfo_orden ASC ";
        List<Proyectos> listFotos = new ProyectosDao().getListProyFotos(queryFoto);
        outHash.put("listFotos", listFotos);
        outHash.put("dataBase", dataBase);
        outHash.put("proyecCodSiaf", codSiaf);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void actualizar_info_fotos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String codSiaf = request.getParameter("cod_siaf");
        Part filePart = request.getPart("fotoArchivo");
        String orden = request.getParameter("fotoOrden");
        String titulo = encodingUTF8(request.getParameter("fotoTitulo"));
        String descripcion = encodingUTF8(request.getParameter("fotoDescripcion"));
        boolean principal = request.getParameter("fotoEsPrincipal") != null;

        String dataBase = ConexionReporte.obtenerPropiedad("dataBase");
        String rutaLinux = ConexionReporte.obtenerPropiedad("rutaLinux");
        String rutaWindows = ConexionReporte.obtenerPropiedad("rutaWindows");

        HashMap outHash = new HashMap();

        Proyectos bean = new Proyectos();
        bean.setProyCodigoSiaf(codSiaf);
        bean.setPrfoOrden(Integer.parseInt(orden));
        bean.setPrfoTitulo(titulo.trim().toUpperCase());
        bean.setPrfoDescripcion(descripcion.trim());
        if (principal) {
            Proyectos princ = new Proyectos();
            princ.setProyCodigoSiaf(codSiaf);
            princ.setPrfoPrincipal(false);
            new ProyectosDao().updateProyFotosPrinc(princ);
        }
        bean.setPrfoPrincipal(principal);

        if (filePart == null) {

        } else {
            String fileType = filePart.getContentType();
            if (fileType.equals("application/octet-stream")) {
                new ProyectosDao().updateProyFotosFileNull(bean);
            } else {
                String fileName = filePart.getSubmittedFileName();
                String[] fileNamePart = fileName.split("\\.");
                int size = fileNamePart.length;
                InputStream fileContenido = filePart.getInputStream();
                Path rutaDestino = null;
                bean.setPrfoTipo(fileType);
                String rutaLinuxDestino = rutaLinux + "/inversion publica/fotos/" + codSiaf;
                String rutaWindowsDestino = rutaWindows + "\\inversion publica\\fotos\\" + codSiaf;
                String fileNameDestino = orden + "." + fileNamePart[size - 1];
                if (dataBase.equals("servidor")) {
                    rutaDestino = Paths.get(rutaLinuxDestino + "/" + fileNameDestino);
                    Path carpeta = Paths.get(rutaLinuxDestino);
                    if (!Files.exists(carpeta)) {
                        Files.createDirectory(carpeta);
                    }
                    for (String typesImg : typesImgs) {
                        Path ruta = Paths.get(rutaLinuxDestino + "/" + orden + "." + typesImg);
                        Files.deleteIfExists(ruta);
                    }
                }
                if (dataBase.equals("local")) {
                    rutaDestino = Paths.get(rutaWindowsDestino + "\\" + fileNameDestino);
                    Path carpeta = Paths.get(rutaWindowsDestino);
                    if (!Files.exists(carpeta)) {
                        Files.createDirectory(carpeta);
                    }
                    for (String typesImg : typesImgs) {
                        Path ruta = Paths.get(rutaWindowsDestino + "\\" + orden + "." + typesImg);
                        Files.deleteIfExists(ruta);
                    }
                }
                bean.setPrfoUrlWindows(rutaWindowsDestino + "\\" + fileNameDestino);
                bean.setPrfoUrlLinux(rutaLinuxDestino + "/" + fileNameDestino);
                new ProyectosDao().upsertProyFotos(bean);
                Files.copy(fileContenido, rutaDestino, StandardCopyOption.REPLACE_EXISTING);
            }
        }
        String queryFoto = " WHERE proy_codigo_siaf = '" + codSiaf + "' ORDER BY prfo_orden ASC ";
        List<Proyectos> listFotos = new ProyectosDao().getListProyFotos(queryFoto);
        outHash.put("listFotos", listFotos);
        outHash.put("dataBase", dataBase);
        outHash.put("proyecCodSiaf", codSiaf);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void lista_ejecutoras(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String ano = request.getParameter("ano") == null ? "" : request.getParameter("ano");

        HashMap outHash = new HashMap();

        String pliego = ConexionReporte.obtenerPropiedad("pliego");

        String query;
        switch (ano) {
            case "":
                LocalDate ld = LocalDate.now();
                int año_actual = ld.getYear();
                query = " WHERE a.ano_eje = '" + año_actual + "' AND a.act_proy ilike '2%' AND b.pliego = '" + pliego + "' AND a.estado = 'A' "
                        + "GROUP BY a.sec_ejec, b.ejecutora, b.nombre ORDER BY b.ejecutora ASC ";
                break;
            case "todos":
                query = " WHERE a.act_proy ilike '2%' AND a.act_proy != '2000270' AND a.act_proy != '2001621' AND b.pliego = '" + pliego + "' AND a.estado = 'A' "
                        + "GROUP BY a.sec_ejec, b.ejecutora, b.nombre ORDER BY b.ejecutora ASC ";
                break;
            default:
                query = " WHERE a.ano_eje = '" + ano + "' AND a.act_proy ilike '2%' AND b.pliego = '" + pliego + "' AND a.estado = 'A' "
                        + "GROUP BY a.sec_ejec, b.ejecutora, b.nombre ORDER BY b.ejecutora ASC ";
                break;
        }
        List<Proyectos> listEjecutoras = new ProyectosDao().getListaEjecutoras(query);
        outHash.put("listEjecutoras", listEjecutoras);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void lista_funcion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        HashMap outHash = new HashMap();
        String query = " WHERE a.act_proy ilike '2%' AND a.act_proy != '2000270' AND a.act_proy != '2001621' AND a.estado = 'A' "
                + "GROUP BY a.funcion, b.nombre ORDER BY trim(b.nombre) ASC ";

        List<Proyectos> listFuncion = new ProyectosDao().getListaFuncion(query);
        outHash.put("listFuncion", listFuncion);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void lista_semaforo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String ejec = request.getParameter("ejec");
        String tipo = request.getParameter("tipo_proy");
        String estado = request.getParameter("estado");

        HashMap outHash = new HashMap();

        String pliego = ConexionReporte.obtenerPropiedad("pliego");

        String verde = " Avance Físico = 100 % ";
        String naranja = " 80 % <= Avance Físico < 100 % ";
        String rojo = " Avance Físico < 80 % ";

        LocalDate ld = LocalDate.now();
        int año_actual = ld.getYear();

        String query1_1;
        String query1_2;
        if (ejec.equals("00")) {
            query1_1 = "";
            query1_2 = " WHERE a.ano_eje = '" + año_actual + "' AND a.estado = 'A' AND a.act_proy ilike '2%' AND (a.act_proy = '2000270' OR a.act_proy = '2001621') "
                    + "GROUP BY a.act_proy, d.nombre ";
        } else {
            query1_1 = " a.sec_ejec, e.ejecutora, ";
            query1_2 = " WHERE a.ano_eje = '" + año_actual + "' AND a.sec_ejec = '" + ejec + "' AND a.estado = 'A' AND a.act_proy ilike '2%' "
                    + "AND (a.act_proy = '2000270' OR a.act_proy = '2001621') AND e.pliego = '" + pliego + "' GROUP BY a.act_proy, d.nombre, a.sec_ejec, e.ejecutora ";
        }
        List<Proyectos> listSemaforo1 = new ProyectosDao().getListaSemaforo1(query1_1, query1_2);

        String query2_1 = " WHERE a.ano_eje = '" + año_actual + "' AND a.estado = 'A' AND a.act_proy ilike '2%' AND a.act_proy != '2000270' AND a.act_proy != '2001621' GROUP BY a.act_proy ";
        String query2_2 = " WHERE ano_eje < '" + año_actual + "' GROUP BY proy_codigo_siaf ";

        Boolean estadoSemaf = null;
        String query2_3 = "";
        if (estado.equals("00")) {
            query2_3 += " ORDER BY a.act_proy ASC ";
            estadoSemaf = true;
        }
        if (estado.equals("01")) {
            query2_3 += " WHERE (CASE WHEN c.prcp_monto_contratado is null THEN 0 WHEN c.prcp_monto_contratado = 0.00 THEN 0 ELSE (d.prva_monto_ejecutado/c.prcp_monto_contratado)*100 END) = 100 "
                    + " ORDER BY a.act_proy ASC ";
            estadoSemaf = false;
        }
        if (estado.equals("02")) {
            query2_3 += " WHERE (CASE WHEN c.prcp_monto_contratado is null THEN 0 WHEN c.prcp_monto_contratado = 0.00 THEN 0 ELSE (d.prva_monto_ejecutado/c.prcp_monto_contratado)*100 END) >= 80 "
                    + "AND (CASE WHEN c.prcp_monto_contratado is null THEN 0 WHEN c.prcp_monto_contratado = 0.00 THEN 0 ELSE (d.prva_monto_ejecutado/c.prcp_monto_contratado)*100 END) < 100 "
                    + " ORDER BY a.act_proy ASC ";
            estadoSemaf = false;
        }
        if (estado.equals("03")) {
            query2_3 += " WHERE (CASE WHEN c.prcp_monto_contratado is null THEN 0 WHEN c.prcp_monto_contratado = 0.00 THEN 0 ELSE (d.prva_monto_ejecutado/c.prcp_monto_contratado)*100 END) < 80 "
                    + " ORDER BY a.act_proy ASC ";
            estadoSemaf = false;
        }

        List<Proyectos> listSemaforo2 = new ProyectosDao().getListaSemaforo2(query2_1, query2_2, query2_3);
        int size = listSemaforo2.size();

        String[] arraySecEjec = new String[size];
        String[] arrayEjecutora = new String[size];

        IntStream.range(0, size)
                .forEach(t -> {
                    String codigoSiaf = listSemaforo2.get(t).getAct_proy();
                    String queryEjec = " WHERE a.act_proy = '" + codigoSiaf + "' AND c.pliego = '" + pliego + "' GROUP BY a.act_proy, a.sec_ejec, c.ejecutora, c.nombre "
                            + "ORDER BY SUM(b.presupuesto) + SUM(b.modificacion) DESC LIMIT 1 ";
                    List<Proyectos> listEjec2 = new ProyectosDao().getListaActProyEjec(queryEjec);
                    arraySecEjec[t] = listEjec2.get(0).getSec_ejec();
                    arrayEjecutora[t] = listEjec2.get(0).getEjecutora();
                });

        outHash.put("verde", verde);
        outHash.put("naranja", naranja);
        outHash.put("rojo", rojo);
        outHash.put("listSemaforo1", listSemaforo1);
        outHash.put("listSemaforo2", listSemaforo2);
        outHash.put("ejec", ejec);
        outHash.put("tipo", tipo);
        outHash.put("estado", estado);
        outHash.put("estadoSemaf", estadoSemaf);
        outHash.put("arraySecEjec", arraySecEjec);
        outHash.put("arrayEjecutora", arrayEjecutora);
        outHash.put("año_actual", año_actual);
        outHash.put("año_anterior", año_actual - 1);
        outHash.put("pliego", pliego);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void informa_general(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String siaf = request.getParameter("codSiaf");

        HashMap outHash = new HashMap();

        String query = " WHERE proy_codigo_siaf = '" + siaf + "' ";
        Proyectos bean = new ProyectosDao().getProyecto(query);
        outHash.put("siaf", siaf);        
        outHash.put("snip", bean.getProyCodigoInversion());
        outHash.put("fechaReg", bean.getProyFechaRegistro());
        outHash.put("nombre", bean.getProyNombre());
        outHash.put("cadena", bean.getProyCadenaFuncional());
        outHash.put("formuladora", bean.getProyUnidadFormuladora());
        outHash.put("tipo", bean.getProyTipo());
        if (bean.getProyTipo().equals("snip")) {
            outHash.put("ejecutora", bean.getProyUnidadEjecutora());
        }
        if (bean.getProyTipo().equals("invierte.pe")) {
            outHash.put("ejecutoraInv", bean.getProyUnidadEjecutoraInversion());
            outHash.put("ejecutoraPre", bean.getProyUnidadEjecutoraPresupuestal());
        }
        outHash.put("evaluadora", bean.getProyUnidadEvaluadora());
        outHash.put("beneficiarios", bean.getProyBeneficiarios());
        outHash.put("fuente", bean.getProyFuenteFinanciamiento());
        outHash.put("fechaVia", bean.getProyFechaViabilidad());
        outHash.put("responsableVia", bean.getProyResponsableViabilidad());
        outHash.put("situacion", bean.getProySituacion());
        outHash.put("estado", bean.getProyEstado());
        outHash.put("montoViable", bean.getProyMontoViable());
        outHash.put("montoEstudio", bean.getProyMontoEstudioDefinitivo());
        outHash.put("montoActual", bean.getProyMontoActualizado());
        
       List<Proyectos> listModifica = new ProyectosDao().getListProyModificaciones(query);        
       outHash.put("listModifica", listModifica);
        

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void estudio_definitivo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String siaf = request.getParameter("codSiaf");

        HashMap outHash = new HashMap();

        String query = " WHERE proy_codigo_siaf = '" + siaf + "' ";

        Proyectos bean = new ProyectosDao().getProyecto(query);

        outHash.put("siaf", siaf);
        outHash.put("snip", bean.getProyCodigoInversion());
        outHash.put("nombre", bean.getProyNombre());

        List<Proyectos> listEstudio = new ProyectosDao().getListProyEstudio(query);
        if (listEstudio.isEmpty()) {
            outHash.put("estado", false);
        } else {
            outHash.put("estado", true);
            outHash.put("fecha", listEstudio.get(0).getPresFechaAproba());
            outHash.put("documento", listEstudio.get(0).getPresDocAproba());
            outHash.put("contrato", listEstudio.get(0).getPresContrato());
            outHash.put("responsable", listEstudio.get(0).getPresResponsable());
            String queryEst = " WHERE proy_codigo_siaf = '" + siaf + "' ORDER BY preset_etapa ASC ";
            List<Proyectos> listEstudioEtapa = new ProyectosDao().getListProyEstudioEtapas(queryEst);
            if (listEstudioEtapa.isEmpty()) {
                outHash.put("estadoEtapa", false);
            } else {
                outHash.put("estadoEtapa", true);
                outHash.put("listEstudioEtapa", listEstudioEtapa);
            }
        }

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void supervision_obra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String siaf = request.getParameter("codSiaf");

        HashMap outHash = new HashMap();

        String query = " WHERE proy_codigo_siaf = '" + siaf + "' ";

        Proyectos bean = new ProyectosDao().getProyecto(query);

        outHash.put("siaf", siaf);
        outHash.put("snip", bean.getProyCodigoInversion());
        outHash.put("nombre", bean.getProyNombre());

        List<Proyectos> listProyec = new ProyectosDao().getListProyectos(query);

        outHash.put("supervision", listProyec.get(0).getProySupervision());
        List<Proyectos> listSuperv = new ProyectosDao().getListProySupervision(query);
        if (listSuperv.isEmpty()) {
            outHash.put("estado", false);
        } else {
            outHash.put("estado", true);
            outHash.put("proceso", listSuperv.get(0).getPrsuProceso());
            outHash.put("contrato", listSuperv.get(0).getPrsuContrato());
            outHash.put("montoCont", listSuperv.get(0).getPrsuMontoContrato());
            outHash.put("proveedor", listSuperv.get(0).getPrsuProveedor());
            outHash.put("modalidad", listSuperv.get(0).getPrsuModalidadContrato());
            outHash.put("supervNombre", listSuperv.get(0).getPrsuSupervisorNombre());
            outHash.put("supervCelular", listSuperv.get(0).getPrsuSupervisorCelular());
            outHash.put("coordNombre", listSuperv.get(0).getPrsuCoordinadorNombre());
            outHash.put("coordCelular", listSuperv.get(0).getPrsuCoordinadorCelular());
            outHash.put("adminNombre", listSuperv.get(0).getPrsuAdminContNombre());
            outHash.put("adminCelular", listSuperv.get(0).getPrsuAdminContCelular());
            outHash.put("fechaInicio", listSuperv.get(0).getPrsuFechaInicio());
            outHash.put("fechaFin", listSuperv.get(0).getPrsuFechaFin());
            outHash.put("tieneAdelanto", listSuperv.get(0).getPrsuTieneAdelanto());
            outHash.put("fechaCont", listSuperv.get(0).getPrsuFechaFirmaContrato());
        }
        String querySupAd = " WHERE proy_codigo_siaf = '" + siaf + "' ORDER BY prsuad_nro ASC ";
        List<Proyectos> listSuperAdela = new ProyectosDao().getListProySupervisionAdelanto(querySupAd);
        outHash.put("listSuperAdela", listSuperAdela);

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void ejecucion_obra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String siaf = request.getParameter("codSiaf");

        HashMap outHash = new HashMap();

        String query = " WHERE proy_codigo_siaf = '" + siaf + "' ";

        Proyectos bean = new ProyectosDao().getProyecto(query);

        outHash.put("siaf", siaf);
        outHash.put("snip", bean.getProyCodigoInversion());
        outHash.put("nombre", bean.getProyNombre());

        List<Proyectos> listEjecu = new ProyectosDao().getListProyEjecucion(query);
        if (listEjecu.isEmpty()) {
            outHash.put("estado", false);
        } else {
            outHash.put("estado", true);
            outHash.put("proceso", listEjecu.get(0).getPrejProceso());
            outHash.put("contrato", listEjecu.get(0).getPrejContrato());
            outHash.put("montoCont", listEjecu.get(0).getPrejMontoContrato());
            outHash.put("proveedor", listEjecu.get(0).getPrejProveedor());
            outHash.put("modalidad", listEjecu.get(0).getPrejModalidadContrato());
            outHash.put("residNombre", listEjecu.get(0).getPrejResidenteNombre());
            outHash.put("residCelular", listEjecu.get(0).getPrejResidenteCelular());
            Date fechaInicio = listEjecu.get(0).getPrejFechaInicio();
            int plazo = listEjecu.get(0).getPrejPlazo();
            outHash.put("plazo", plazo);
            outHash.put("fechaInicio", fechaInicio);
            outHash.put("tieneAdelaMater", listEjecu.get(0).getPrejTieneAdelantoMaterial());
            outHash.put("fechaCont", listEjecu.get(0).getPrejFechaFirmaContra());
            outHash.put("fechaTerreno", listEjecu.get(0).getPrejFechaEntregaTerre());
            outHash.put("tieneAdelaDirec", listEjecu.get(0).getPrejTieneAdelantoDirecto());

            Date fechaFin = anadirFecha(fechaInicio, plazo, "dias");
            outHash.put("fechaFin", fechaFin);

            int numAmplia;
            String queryAmp = " WHERE proy_codigo_siaf = '" + siaf + "' ORDER BY pram_nro ASC ";
            List<Proyectos> listAmplia = new ProyectosDao().getListProyAmpliaciones(queryAmp);
            if (listAmplia.isEmpty()) {
                numAmplia = 0;
                outHash.put("tieneAmplia", false);
            } else {
                String queryAmpReg = " WHERE proy_codigo_siaf = '" + siaf + "' AND pram_procedente = true GROUP BY proy_codigo_siaf ";
                List<Proyectos> listAmpliaReg = new ProyectosDao().getProyAmpliacionesReg(queryAmpReg);
                numAmplia = listAmpliaReg.get(0).getPramDias();
                outHash.put("listAmplia", listAmplia);
                outHash.put("tieneAmplia", true);
            }
            int numParaSusp;
            String queryPasu = " WHERE proy_codigo_siaf = '" + siaf + "' ORDER BY prps_nro ASC ";
            List<Proyectos> listParaSusp = new ProyectosDao().getListProyParalizaSuspen(queryPasu);
            if (listParaSusp.isEmpty()) {
                numParaSusp = 0;
                outHash.put("tieneParaSusp", false);
            } else {
                String queryPasuReg = " WHERE proy_codigo_siaf = '" + siaf + "' GROUP BY proy_codigo_siaf ";
                List<Proyectos> listParaSuspReg = new ProyectosDao().getProyParalizaSuspenReg(queryPasuReg);
                numParaSusp = listParaSuspReg.get(0).getPrpsDias();
                outHash.put("listParaSusp", listParaSusp);
                outHash.put("tieneParaSusp", true);
            }
            int adicional = numAmplia + numParaSusp;
            Date fechaFinNueva = anadirFecha(fechaInicio, plazo + adicional, "dias");
            outHash.put("fechaFinNueva", fechaFinNueva);

            String queryEjecAdDir = " WHERE proy_codigo_siaf = '" + siaf + "' AND prejad_tipo = 'directo' ORDER BY prejad_nro ASC ";
            List<Proyectos> listEjecAdDir = new ProyectosDao().getListProyEjecucionAdelanto(queryEjecAdDir);
            outHash.put("listEjecAdDir", listEjecAdDir);

            String queryEjecAdMat = " WHERE proy_codigo_siaf = '" + siaf + "' AND prejad_tipo = 'material' ORDER BY prejad_nro ASC ";
            List<Proyectos> listEjecAdMat = new ProyectosDao().getListProyEjecucionAdelanto(queryEjecAdMat);
            outHash.put("listEjecAdMat", listEjecAdMat);

        }

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void avance_fisico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String siaf = request.getParameter("codSiaf");

        HashMap outHash = new HashMap();

        String query = " WHERE proy_codigo_siaf = '" + siaf + "' ";

        Proyectos bean = new ProyectosDao().getProyecto(query);

        outHash.put("siaf", siaf);
        outHash.put("snip", bean.getProyCodigoInversion());
        outHash.put("nombre", bean.getProyNombre());

        String queryCompAvan = " WHERE a.proy_codigo_siaf = '" + siaf + "' ORDER BY a.prcp_orden ASC ";
        List<Proyectos> listComponAvan = new ProyectosDao().getListProyComponentesAvance(queryCompAvan);
        outHash.put("listComponAvan", listComponAvan);

        String queryCalendar = " WHERE a.proy_codigo_siaf = '" + siaf + "' GROUP BY a.proy_codigo_siaf, a.prpe_ano, a.prpe_mes, b.nombre ORDER BY a.prpe_ano, a.prpe_mes ASC ";
        List<Proyectos> listCalendar = new ProyectosDao().getListProyCalendario(queryCalendar);
        if (listCalendar.isEmpty()) {
            outHash.put("estado", false);
        } else {
            outHash.put("estado", true);
            outHash.put("listCalendar", listCalendar);
        }

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void curva_control(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String siaf = request.getParameter("codSiaf");

        String titulo = "CURVA DE CONTROL DE AVANCE FÍSICO";
        String tituloX = "Periodo de Control";
        String tituloY = "Avance Físico (%)";
        String formato = "png";
        int ancho = Integer.parseInt(request.getParameter("ancho"));
        int alto = Integer.parseInt(request.getParameter("alto"));
        DefaultCategoryDataset objDatasetP = new DefaultCategoryDataset();
        DefaultCategoryDataset objDatasetE = new DefaultCategoryDataset();

        String queryCompAvan = " WHERE a.proy_codigo_siaf = '" + siaf + "' ORDER BY a.prcp_orden ASC ";
        List<Proyectos> listComponAvan = new ProyectosDao().getListProyComponentesAvance(queryCompAvan);

        BigDecimal monto_contratado = BigDecimal.ZERO;
        for (Proyectos data : listComponAvan) {
            monto_contratado = monto_contratado.add(data.getPrcpMontoContratado());
        }

        String queryCalendar = " WHERE a.proy_codigo_siaf = '" + siaf + "' GROUP BY a.proy_codigo_siaf, a.prpe_ano, a.prpe_mes, b.nombre ORDER BY a.prpe_ano, a.prpe_mes ASC ";
        List<Proyectos> listCalendar = new ProyectosDao().getListProyCalendario(queryCalendar);

        BigDecimal monto_programado = BigDecimal.ZERO;
        BigDecimal monto_ejecutado = BigDecimal.ZERO;
        for (Proyectos data : listCalendar) {
            BigDecimal avanP, avanE;
            String periodo = data.getNombreMes().toLowerCase().substring(0, 3) + "-" + data.getPrpeAno();
            if (monto_contratado == null || monto_contratado.compareTo(BigDecimal.ZERO) == 0) {
                avanP = BigDecimal.ZERO;
                avanE = BigDecimal.ZERO;
            } else {
                if (data.getPrvaMontoProgramado() == null || data.getPrvaMontoProgramado().compareTo(BigDecimal.ZERO) == 0) {
                    monto_programado = monto_programado.add(BigDecimal.ZERO);
                } else {
                    monto_programado = monto_programado.add(data.getPrvaMontoProgramado());
                }
                avanP = porcentaje(monto_programado, monto_contratado);
                if (data.getPrvaMontoEjecutado() == null || data.getPrvaMontoEjecutado().compareTo(BigDecimal.ZERO) == 0) {
                    monto_ejecutado = monto_ejecutado.add(BigDecimal.ZERO);
                } else {
                    monto_ejecutado = monto_ejecutado.add(data.getPrvaMontoEjecutado());
                }
                avanE = porcentaje(monto_ejecutado, monto_contratado);
            }
            objDatasetP.setValue(avanP, "Programado", periodo);
            objDatasetE.setValue(avanE, "Real Ejecutado", periodo);
        }

        chart.lineChartX2_2D(request, response, objDatasetE, objDatasetP, titulo, tituloX, tituloY, ancho, alto, formato, blanco, negro);

    }

    private void ejec_financiera(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String siaf = request.getParameter("codSiaf");

        LocalDate ld = LocalDate.now();
        int año_actual = ld.getYear();

        HashMap outHash = new HashMap();
        String pliego = ConexionReporte.obtenerPropiedad("pliego");

        outHash.put("siaf", siaf);

        String query = " WHERE proy_codigo_siaf = '" + siaf + "' ";
        Proyectos bean = new ProyectosDao().getProyecto(query);

        outHash.put("siaf", siaf);
        outHash.put("snip", bean.getProyCodigoInversion());
        outHash.put("nombre", bean.getProyNombre());
        outHash.put("montoActual", bean.getProyMontoActualizado());

        String queryHisto = " WHERE proy_codigo_siaf = '" + siaf + "' ORDER BY ano_eje ASC ";
        List<Proyectos> listHisto = new ProyectosDao().getListaHistoricoFinanciero(queryHisto);
        outHash.put("listHisto", listHisto);

        String queryHistoAcum = " WHERE proy_codigo_siaf = '" + siaf + "' AND ano_eje < '" + año_actual + "' GROUP BY proy_codigo_siaf ";
        List<Proyectos> listHistoAcum = new ProyectosDao().getListaHistoricoFinancieroAcum(queryHistoAcum);
        outHash.put("deven_acumulado", listHistoAcum.get(0).getDevengado());

        String queryActual = " WHERE a.act_proy = '" + siaf + "' AND a.ano_eje = '" + año_actual + "' GROUP BY a.act_proy, a.ano_eje ";
        List<Proyectos> listActual = new ProyectosDao().getListaActualFinanciero(queryActual);
        if (listActual.isEmpty()) {
            outHash.put("estadoActual", false);
        } else {
            outHash.put("estadoActual", true);
            outHash.put("listActual", listActual);
            outHash.put("pim_actual", listActual.get(0).getPim());
            outHash.put("deven_actual", listActual.get(0).getDevengado());
        }

        String queryDetallado = " WHERE d.act_proy = '" + siaf + "' AND a.ano_eje = '" + año_actual + "' AND e.pliego = '" + pliego + "' "
                + "        ORDER BY a.ano_eje, a.sec_ejec, a.fuente_financ, a.sec_func, f.clasificador ASC ";
        List<Proyectos> listDetallado = new ProyectosDao().getListaActualDetallado(queryDetallado);
        if (listDetallado.isEmpty()) {
            outHash.put("estadoDetallado", false);
        } else {
            outHash.put("estadoDetallado", true);
            outHash.put("listDetallado", listDetallado);
        }

        outHash.put("año_actual", año_actual);
        outHash.put("año_anterior", año_actual - 1);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void detalle_pagos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String siaf = request.getParameter("codSiaf");

        HashMap outHash = new HashMap();

        String query = " WHERE proy_codigo_siaf = '" + siaf + "' ";
        Proyectos bean = new ProyectosDao().getProyecto(query);

        outHash.put("siaf", siaf);
        outHash.put("snip", bean.getProyCodigoInversion());
        outHash.put("nombre", bean.getProyNombre());

        String pliego = ConexionReporte.obtenerPropiedad("pliego");
        String queryPagos = " WHERE d.act_proy = '" + siaf + "' AND a.ciclo = 'G' AND a.fase = 'D' AND a.estado_envio = 'A' AND e.pliego = '" + pliego + "' "
                + "ORDER BY a.ano_eje, a.expediente, c.fecha_doc ASC ";
        List<Proyectos> listPagos = new ProyectosDao().getListaHistoricoPagos(queryPagos);
        outHash.put("listPagos", listPagos);

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void contrataciones(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String siaf = request.getParameter("codSiaf");

        HashMap outHash = new HashMap();

        String query = " WHERE proy_codigo_siaf = '" + siaf + "' ";
        Proyectos bean = new ProyectosDao().getProyecto(query);

        outHash.put("siaf", siaf);
        outHash.put("snip", bean.getProyCodigoInversion());
        outHash.put("nombre", bean.getProyNombre());

        String dataBase = ConexionReporte.obtenerPropiedad("dataBase");

        String queryCont = " WHERE proy_codigo_siaf = '" + siaf + "' ORDER BY prco_fecha_suscripcion ASC ";
        List<Proyectos> listContratos = new ProyectosDao().getListProyContrataciones(queryCont);
        outHash.put("listContratos", listContratos);
        outHash.put("dataBase", dataBase);

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);

    }

    private void ubicacion_geografica(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String siaf = request.getParameter("codSiaf");

        HashMap outHash = new HashMap();

        String query = " WHERE proy_codigo_siaf = '" + siaf + "' ";
        Proyectos bean = new ProyectosDao().getProyecto(query);

        outHash.put("siaf", siaf);
        outHash.put("snip", bean.getProyCodigoInversion());
        outHash.put("nombre", bean.getProyNombre());

        String queryUbigeo = " WHERE proy_codigo_siaf = '" + siaf + "' ORDER BY prub_departamento, prub_provincia, prub_distrito, prub_localidad ASC ";
        List<Proyectos> listUbigeo = new ProyectosDao().getListProyUbicacion(queryUbigeo);
        outHash.put("listUbigeo", listUbigeo);

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void galeria_fotos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String siaf = request.getParameter("codSiaf");

        HashMap outHash = new HashMap();

        String query = " WHERE proy_codigo_siaf = '" + siaf + "' ";
        Proyectos bean = new ProyectosDao().getProyecto(query);

        outHash.put("siaf", siaf);
        outHash.put("snip", bean.getProyCodigoInversion());
        outHash.put("nombre", bean.getProyNombre());

        String dataBase = ConexionReporte.obtenerPropiedad("dataBase");

        String queryFotos = " WHERE proy_codigo_siaf = '" + siaf + "' ORDER BY prfo_orden ASC ";
        List<Proyectos> listFotos = new ProyectosDao().getListProyFotos(queryFotos);
        if (listFotos.isEmpty()) {
            outHash.put("estado", false);
        } else {
            outHash.put("estado", true);
            outHash.put("listFotos", listFotos);
            outHash.put("dataBase", dataBase);
        }

        Gson gson = new Gson();
        String arg = gson.toJson(outHash);
        response.getWriter().print(arg);
    }

    private void lista_busqueda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String siaf = request.getParameter("codigo_siaf") == null ? "" : request.getParameter("codigo_siaf");
        String snip = request.getParameter("codigo_snip") == null ? "" : request.getParameter("codigo_snip");
        String situacion = request.getParameter("situacion");
        String nombre = request.getParameter("nombre_proyecto") == null ? "" : request.getParameter("nombre_proyecto");
        String ejec = request.getParameter("sec_ejec");
        String tipo_proy = request.getParameter("tipo_proyecto");
        String funcion = request.getParameter("funcion");
        String estado = request.getParameter("estado");

        HashMap outHash = new HashMap();

        String pliego = ConexionReporte.obtenerPropiedad("pliego");

        LocalDate ld = LocalDate.now();
        int año_actual = ld.getYear();

        if (situacion.equals("01")) {

            String query1_1 = " WHERE a.ano_eje = '" + año_actual + "' AND a.estado = 'A' AND a.act_proy ilike '2%' ";
            String query1_2 = " WHERE ano_eje < '" + año_actual + "' GROUP BY proy_codigo_siaf ";

            String query1_3 = " WHERE a.act_proy != '2000270' AND a.act_proy != '2001621' ";
            if (siaf.equals("")) {
                query1_3 += "";
            } else {
                query1_3 += " AND a.act_proy = '" + siaf + "' ";
            }
            if (snip.equals("")) {
                query1_3 += "";
            } else {
                query1_3 += " AND b.proy_codigo_inversion = '" + snip + "' ";
            }
            if (nombre.equals("")) {
                query1_3 += "";
            } else {
                query1_3 += " AND lower(b.proy_nombre) ilike '%" + nombre.toLowerCase().trim() + "%' ";
            }
            if (tipo_proy.equals("00")) {
                query1_3 += "";
            }
            if (tipo_proy.equals("01")) {
                query1_3 += " AND lower(b.proy_tipo) = 'invierte.pe' ";
            }
            if (tipo_proy.equals("02")) {
                query1_3 += " AND lower(b.proy_tipo) = 'snip' ";
            }
            if (funcion.equals("00")) {
                query1_1 += "";
            } else {
                query1_1 += " AND a.funcion = '" + funcion + "' ";
            }
            if (estado.equals("00")) {
                query1_3 += "";
            }
            if (estado.equals("01")) {
                query1_3 += " AND lower(b.proy_estado) = 'activo' ";
            }
            if (estado.equals("02")) {
                query1_3 += " AND lower(b.proy_estado) = 'desactivado' ";
            }
            query1_1 += " GROUP BY a.act_proy ";
            query1_3 += " ORDER BY a.act_proy ASC ";

            List<Proyectos> listBusqueda = new ProyectosDao().getListaSemaforo2(query1_1, query1_2, query1_3);
            int size = listBusqueda.size();

            String[] arraySecEjec = new String[size];
            String[] arrayEjecutora = new String[size];

            IntStream.range(0, size)
                    .forEach(t -> {
                        String codigoSiaf = listBusqueda.get(t).getAct_proy();
                        String queryEjec = " WHERE a.act_proy = '" + codigoSiaf + "' AND c.pliego = '" + pliego + "' GROUP BY a.act_proy, a.sec_ejec, c.ejecutora, c.nombre "
                                + "ORDER BY SUM(b.presupuesto) + SUM(b.modificacion) DESC LIMIT 1 ";
                        List<Proyectos> listEjec = new ProyectosDao().getListaActProyEjec(queryEjec);
                        arraySecEjec[t] = listEjec.get(0).getSec_ejec();
                        arrayEjecutora[t] = listEjec.get(0).getEjecutora();
                    });

            outHash.put("listBusqueda", listBusqueda);
            outHash.put("arraySecEjec", arraySecEjec);
            outHash.put("arrayEjecutora", arrayEjecutora);

        }

        if (situacion.equals("02")) {

            String query2_1 = " WHERE act_proy ilike '2%' AND ano_eje = '" + año_actual + "' AND estado = 'A' ";
            String query2_2;
            if (funcion.equals("00")) {
                query2_2 = "";
            } else {
                query2_2 = " EXCEPT SELECT act_proy FROM presupuesto.meta WHERE act_proy ilike '2%' AND estado = 'A' AND funcion != '" + funcion + "' GROUP BY act_proy ";
            }
            String query2_3 = " WHERE ano_eje < '" + año_actual + "' GROUP BY proy_codigo_siaf ";

            String query2_4 = " WHERE a.proy_codigo_siaf != '2000270' AND a.proy_codigo_siaf!= '2001621' ";
            if (siaf.equals("")) {
                query2_4 += "";
            } else {
                query2_4 += " AND a.proy_codigo_siaf = '" + siaf + "' ";
            }
            if (snip.equals("")) {
                query2_4 += "";
            } else {
                query2_4 += " AND b.proy_codigo_inversion = '" + snip + "' ";
            }
            if (nombre.equals("")) {
                query2_4 += "";
            } else {
                query2_4 += " AND lower(b.proy_nombre) ilike '%" + nombre.toLowerCase().trim() + "%' ";
            }
            if (tipo_proy.equals("00")) {
                query2_4 += "";
            }
            if (tipo_proy.equals("01")) {
                query2_4 += " AND lower(b.proy_tipo) = 'invierte.pe' ";
            }
            if (tipo_proy.equals("02")) {
                query2_4 += " AND lower(b.proy_tipo) = 'snip' ";
            }
            if (estado.equals("00")) {
                query2_4 += "";
            }
            if (estado.equals("01")) {
                query2_4 += " AND lower(b.proy_estado) = 'activo' ";
            }
            if (estado.equals("02")) {
                query2_4 += " AND lower(b.proy_estado) = 'desactivado' ";
            }
            query2_4 += " ORDER BY a.proy_codigo_siaf ASC ";

            List<Proyectos> listBusqueda = new ProyectosDao().getListaSemaforo3(query2_1, query2_2, query2_3, query2_4);
            int size = listBusqueda.size();

            String[] arraySecEjec = new String[size];
            String[] arrayEjecutora = new String[size];

            IntStream.range(0, size)
                    .forEach(t -> {
                        String codigoSiaf = listBusqueda.get(t).getProyCodigoSiaf();
                        String queryEjec = " WHERE a.act_proy = '" + codigoSiaf + "' AND c.pliego = '" + pliego + "' GROUP BY a.act_proy, a.sec_ejec, c.ejecutora, c.nombre "
                                + "ORDER BY SUM(b.presupuesto) + SUM(b.modificacion) DESC LIMIT 1 ";
                        List<Proyectos> listEjec = new ProyectosDao().getListaActProyEjec(queryEjec);
                        arraySecEjec[t] = listEjec.get(0).getSec_ejec();
                        arrayEjecutora[t] = listEjec.get(0).getEjecutora();
                    });

            outHash.put("listBusqueda", listBusqueda);
            outHash.put("arraySecEjec", arraySecEjec);
            outHash.put("arrayEjecutora", arrayEjecutora);

        }

        outHash.put("situacion", situacion);
        outHash.put("año_actual", año_actual);
        outHash.put("año_anterior", año_actual - 1);
        outHash.put("ejec", ejec);
        outHash.put("pliego", pliego);

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
