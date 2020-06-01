package beans;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author CARLOS SANTANDER
 */
public class Presupuesto {

    private Integer ceco_id;
    private String ceco_codigo;
    private String ceco_nombre;
    private Boolean ceco_estado;
    private String ano_eje;
    private String sec_ejec;
    private String ejecutora;
    private String nombre;
    private BigDecimal pia;
    private BigDecimal modificacion;
    private BigDecimal pim;
    private BigDecimal certificado;
    private BigDecimal compromiso_anual;
    private BigDecimal compromiso;
    private BigDecimal ejecucion;
    private BigDecimal devengado;
    private BigDecimal girado;
    private BigDecimal pagado;
    private BigDecimal recaudado;
    private int mes;
    private String nombre_mes;
    private String categoria_gasto;
    private String tipo_transaccion;
    private String generica;
    private String clasificador;
    private String descripcion;
    private String tipo_act_proy;
    private String codigo;
    private String programa_ppto;
    private String nombre_programa_ppto;
    private String act_proy;
    private String nombre_act_proy;
    private String componente;
    private String nombre_componente;
    private String funcion;
    private String nombre_funcion;
    private String programa;
    private String nombre_programa;
    private String sub_programa;
    private String nombre_sub_programa;
    private String sec_func;
    private String nombre_sec_func;
    private String fuente_financ_agregada;
    private String nombre_fuente_financ_agregada;
    private String fuente_financ;
    private String nombre_fuente_financ;
    private String categ_gasto;
    private String nombre_categ_gasto;
    private String generica_clasif;
    private String nombre_generica_clasif;
    private String subgenerica_clasif;
    private String nombre_subgenerica_clasif;
    private String subgenerica_det_clasif;
    private String nombre_subgenerica_det_clasif;
    private String especifica_clasif;
    private String nombre_especifica_clasif;
    private String especifica_det_clasif;
    private String nombre_especifica_det_clasif;
    private String categoria_ingreso;
    private String nombre_categoria_ingreso;
    private String tipo_recurso;
    private String nombre_tipo_recurso;
    private String banco;
    private String nombre_banco;
    private String cta_cte;
    private String nombre_cta_cte;
    private String distrito;
    private String nombre_distrito;
    private String provincia;
    private String nombre_provincia;
    private String proyecto_snip;
    private String nombre_ejecutora;
    private String glosa;
    private String certificacion;
    private String cod_doc;
    private String secuencia;
    private String correlativo;
    private Date fecha_doc;
    private String sec_nota;
    private BigDecimal monto;
    private BigDecimal monto0;
    private BigDecimal monto1;
    private BigDecimal monto2;
    private BigDecimal monto3;
    private BigDecimal monto4;
    private BigDecimal monto5;
    private BigDecimal monto6;
    private BigDecimal monto7;
    private BigDecimal monto8;
    private BigDecimal monto9;
    private String nombre_documento;
    private String num_doc;
    private String tipo_registro;
    private String etapa;
    private String estado_registro;
    private String estado_envio;
    private String expediente;
    private String ciclo;
    private String fase;
    private String ruc;

    public Presupuesto() {
    }

    public Integer getCeco_id() {
        return ceco_id;
    }

    public void setCeco_id(Integer ceco_id) {
        this.ceco_id = ceco_id;
    }

    public String getCeco_codigo() {
        return ceco_codigo;
    }

    public void setCeco_codigo(String ceco_codigo) {
        this.ceco_codigo = ceco_codigo;
    }

    public String getCeco_nombre() {
        return ceco_nombre;
    }

    public void setCeco_nombre(String ceco_nombre) {
        this.ceco_nombre = ceco_nombre;
    }

    public Boolean getCeco_estado() {
        return ceco_estado;
    }

    public void setCeco_estado(Boolean ceco_estado) {
        this.ceco_estado = ceco_estado;
    }

    public String getAno_eje() {
        return ano_eje;
    }

    public void setAno_eje(String ano_eje) {
        this.ano_eje = ano_eje;
    }

    public String getSec_ejec() {
        return sec_ejec;
    }

    public void setSec_ejec(String sec_ejec) {
        this.sec_ejec = sec_ejec;
    }

    public String getEjecutora() {
        return ejecutora;
    }

    public void setEjecutora(String ejecutora) {
        this.ejecutora = ejecutora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSec_nota() {
        return sec_nota;
    }

    public void setSec_nota(String sec_nota) {
        this.sec_nota = sec_nota;
    }

    public BigDecimal getPia() {
        return pia;
    }

    public void setPia(BigDecimal pia) {
        this.pia = pia;
    }

    public BigDecimal getModificacion() {
        return modificacion;
    }

    public void setModificacion(BigDecimal modificacion) {
        this.modificacion = modificacion;
    }

    public BigDecimal getPim() {
        return pim;
    }

    public void setPim(BigDecimal pim) {
        this.pim = pim;
    }

    public BigDecimal getCertificado() {
        return certificado;
    }

    public void setCertificado(BigDecimal certificado) {
        this.certificado = certificado;
    }

    public BigDecimal getCompromiso_anual() {
        return compromiso_anual;
    }

    public void setCompromiso_anual(BigDecimal compromiso_anual) {
        this.compromiso_anual = compromiso_anual;
    }

    public BigDecimal getCompromiso() {
        return compromiso;
    }

    public void setCompromiso(BigDecimal compromiso) {
        this.compromiso = compromiso;
    }

    public BigDecimal getEjecucion() {
        return ejecucion;
    }

    public void setEjecucion(BigDecimal ejecucion) {
        this.ejecucion = ejecucion;
    }

    public BigDecimal getDevengado() {
        return devengado;
    }

    public void setDevengado(BigDecimal devengado) {
        this.devengado = devengado;
    }

    public BigDecimal getGirado() {
        return girado;
    }

    public void setGirado(BigDecimal girado) {
        this.girado = girado;
    }

    public BigDecimal getPagado() {
        return pagado;
    }

    public void setPagado(BigDecimal pagado) {
        this.pagado = pagado;
    }

    public BigDecimal getRecaudado() {
        return recaudado;
    }

    public void setRecaudado(BigDecimal recaudado) {
        this.recaudado = recaudado;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getNombre_mes() {
        return nombre_mes;
    }

    public void setNombre_mes(String nombre_mes) {
        this.nombre_mes = nombre_mes;
    }

    public String getCategoria_gasto() {
        return categoria_gasto;
    }

    public void setCategoria_gasto(String categoria_gasto) {
        this.categoria_gasto = categoria_gasto;
    }

    public String getTipo_transaccion() {
        return tipo_transaccion;
    }

    public void setTipo_transaccion(String tipo_transaccion) {
        this.tipo_transaccion = tipo_transaccion;
    }

    public String getGenerica() {
        return generica;
    }

    public void setGenerica(String generica) {
        this.generica = generica;
    }

    public String getClasificador() {
        return clasificador;
    }

    public void setClasificador(String clasificador) {
        this.clasificador = clasificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo_act_proy() {
        return tipo_act_proy;
    }

    public void setTipo_act_proy(String tipo_act_proy) {
        this.tipo_act_proy = tipo_act_proy;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPrograma_ppto() {
        return programa_ppto;
    }

    public void setPrograma_ppto(String programa_ppto) {
        this.programa_ppto = programa_ppto;
    }

    public String getNombre_programa_ppto() {
        return nombre_programa_ppto;
    }

    public void setNombre_programa_ppto(String nombre_programa_ppto) {
        this.nombre_programa_ppto = nombre_programa_ppto;
    }

    public String getAct_proy() {
        return act_proy;
    }

    public void setAct_proy(String act_proy) {
        this.act_proy = act_proy;
    }

    public String getNombre_act_proy() {
        return nombre_act_proy;
    }

    public void setNombre_act_proy(String nombre_act_proy) {
        this.nombre_act_proy = nombre_act_proy;
    }

    public String getComponente() {
        return componente;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }

    public String getNombre_componente() {
        return nombre_componente;
    }

    public void setNombre_componente(String nombre_componente) {
        this.nombre_componente = nombre_componente;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getNombre_funcion() {
        return nombre_funcion;
    }

    public void setNombre_funcion(String nombre_funcion) {
        this.nombre_funcion = nombre_funcion;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getNombre_programa() {
        return nombre_programa;
    }

    public void setNombre_programa(String nombre_programa) {
        this.nombre_programa = nombre_programa;
    }

    public String getSub_programa() {
        return sub_programa;
    }

    public void setSub_programa(String sub_programa) {
        this.sub_programa = sub_programa;
    }

    public String getNombre_sub_programa() {
        return nombre_sub_programa;
    }

    public void setNombre_sub_programa(String nombre_sub_programa) {
        this.nombre_sub_programa = nombre_sub_programa;
    }

    public String getSec_func() {
        return sec_func;
    }

    public void setSec_func(String sec_func) {
        this.sec_func = sec_func;
    }

    public String getNombre_sec_func() {
        return nombre_sec_func;
    }

    public void setNombre_sec_func(String nombre_sec_func) {
        this.nombre_sec_func = nombre_sec_func;
    }

    public String getFuente_financ_agregada() {
        return fuente_financ_agregada;
    }

    public void setFuente_financ_agregada(String fuente_financ_agregada) {
        this.fuente_financ_agregada = fuente_financ_agregada;
    }

    public String getNombre_fuente_financ_agregada() {
        return nombre_fuente_financ_agregada;
    }

    public void setNombre_fuente_financ_agregada(String nombre_fuente_financ_agregada) {
        this.nombre_fuente_financ_agregada = nombre_fuente_financ_agregada;
    }

    public String getFuente_financ() {
        return fuente_financ;
    }

    public void setFuente_financ(String fuente_financ) {
        this.fuente_financ = fuente_financ;
    }

    public String getNombre_fuente_financ() {
        return nombre_fuente_financ;
    }

    public void setNombre_fuente_financ(String nombre_fuente_financ) {
        this.nombre_fuente_financ = nombre_fuente_financ;
    }

    public String getCateg_gasto() {
        return categ_gasto;
    }

    public void setCateg_gasto(String categ_gasto) {
        this.categ_gasto = categ_gasto;
    }

    public String getNombre_categ_gasto() {
        return nombre_categ_gasto;
    }

    public void setNombre_categ_gasto(String nombre_categ_gasto) {
        this.nombre_categ_gasto = nombre_categ_gasto;
    }

    public String getGenerica_clasif() {
        return generica_clasif;
    }

    public void setGenerica_clasif(String generica_clasif) {
        this.generica_clasif = generica_clasif;
    }

    public String getNombre_generica_clasif() {
        return nombre_generica_clasif;
    }

    public void setNombre_generica_clasif(String nombre_generica_clasif) {
        this.nombre_generica_clasif = nombre_generica_clasif;
    }

    public String getSubgenerica_clasif() {
        return subgenerica_clasif;
    }

    public void setSubgenerica_clasif(String subgenerica_clasif) {
        this.subgenerica_clasif = subgenerica_clasif;
    }

    public String getNombre_subgenerica_clasif() {
        return nombre_subgenerica_clasif;
    }

    public void setNombre_subgenerica_clasif(String nombre_subgenerica_clasif) {
        this.nombre_subgenerica_clasif = nombre_subgenerica_clasif;
    }

    public String getSubgenerica_det_clasif() {
        return subgenerica_det_clasif;
    }

    public void setSubgenerica_det_clasif(String subgenerica_det_clasif) {
        this.subgenerica_det_clasif = subgenerica_det_clasif;
    }

    public String getNombre_subgenerica_det_clasif() {
        return nombre_subgenerica_det_clasif;
    }

    public void setNombre_subgenerica_det_clasif(String nombre_subgenerica_det_clasif) {
        this.nombre_subgenerica_det_clasif = nombre_subgenerica_det_clasif;
    }

    public String getEspecifica_clasif() {
        return especifica_clasif;
    }

    public void setEspecifica_clasif(String especifica_clasif) {
        this.especifica_clasif = especifica_clasif;
    }

    public String getNombre_especifica_clasif() {
        return nombre_especifica_clasif;
    }

    public void setNombre_especifica_clasif(String nombre_especifica_clasif) {
        this.nombre_especifica_clasif = nombre_especifica_clasif;
    }

    public String getEspecifica_det_clasif() {
        return especifica_det_clasif;
    }

    public void setEspecifica_det_clasif(String especifica_det_clasif) {
        this.especifica_det_clasif = especifica_det_clasif;
    }

    public String getNombre_especifica_det_clasif() {
        return nombre_especifica_det_clasif;
    }

    public void setNombre_especifica_det_clasif(String nombre_especifica_det_clasif) {
        this.nombre_especifica_det_clasif = nombre_especifica_det_clasif;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getNombre_distrito() {
        return nombre_distrito;
    }

    public void setNombre_distrito(String nombre_distrito) {
        this.nombre_distrito = nombre_distrito;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getNombre_provincia() {
        return nombre_provincia;
    }

    public void setNombre_provincia(String nombre_provincia) {
        this.nombre_provincia = nombre_provincia;
    }

    public String getProyecto_snip() {
        return proyecto_snip;
    }

    public void setProyecto_snip(String proyecto_snip) {
        this.proyecto_snip = proyecto_snip;
    }

    public String getNombre_ejecutora() {
        return nombre_ejecutora;
    }

    public void setNombre_ejecutora(String nombre_ejecutora) {
        this.nombre_ejecutora = nombre_ejecutora;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public String getCertificacion() {
        return certificacion;
    }

    public void setCertificacion(String certificacion) {
        this.certificacion = certificacion;
    }

    public String getCod_doc() {
        return cod_doc;
    }

    public void setCod_doc(String cod_doc) {
        this.cod_doc = cod_doc;
    }

    public String getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(String secuencia) {
        this.secuencia = secuencia;
    }

    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    public Date getFecha_doc() {
        return fecha_doc;
    }

    public void setFecha_doc(Date fecha_doc) {
        this.fecha_doc = fecha_doc;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getNombre_documento() {
        return nombre_documento;
    }

    public void setNombre_documento(String nombre_documento) {
        this.nombre_documento = nombre_documento;
    }

    public String getNum_doc() {
        return num_doc;
    }

    public void setNum_doc(String num_doc) {
        this.num_doc = num_doc;
    }

    public String getTipo_registro() {
        return tipo_registro;
    }

    public void setTipo_registro(String tipo_registro) {
        this.tipo_registro = tipo_registro;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public String getEstado_registro() {
        return estado_registro;
    }

    public void setEstado_registro(String estado_registro) {
        this.estado_registro = estado_registro;
    }

    public String getEstado_envio() {
        return estado_envio;
    }

    public void setEstado_envio(String estado_envio) {
        this.estado_envio = estado_envio;
    }

    public String getCategoria_ingreso() {
        return categoria_ingreso;
    }

    public void setCategoria_ingreso(String categoria_ingreso) {
        this.categoria_ingreso = categoria_ingreso;
    }

    public String getNombre_categoria_ingreso() {
        return nombre_categoria_ingreso;
    }

    public void setNombre_categoria_ingreso(String nombre_categoria_ingreso) {
        this.nombre_categoria_ingreso = nombre_categoria_ingreso;
    }

    public String getTipo_recurso() {
        return tipo_recurso;
    }

    public void setTipo_recurso(String tipo_recurso) {
        this.tipo_recurso = tipo_recurso;
    }

    public String getNombre_tipo_recurso() {
        return nombre_tipo_recurso;
    }

    public void setNombre_tipo_recurso(String nombre_tipo_recurso) {
        this.nombre_tipo_recurso = nombre_tipo_recurso;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getNombre_banco() {
        return nombre_banco;
    }

    public void setNombre_banco(String nombre_banco) {
        this.nombre_banco = nombre_banco;
    }

    public String getCta_cte() {
        return cta_cte;
    }

    public void setCta_cte(String cta_cte) {
        this.cta_cte = cta_cte;
    }

    public String getNombre_cta_cte() {
        return nombre_cta_cte;
    }

    public void setNombre_cta_cte(String nombre_cta_cte) {
        this.nombre_cta_cte = nombre_cta_cte;
    }

    public BigDecimal getMonto0() {
        return monto0;
    }

    public void setMonto0(BigDecimal monto0) {
        this.monto0 = monto0;
    }

    public BigDecimal getMonto1() {
        return monto1;
    }

    public void setMonto1(BigDecimal monto1) {
        this.monto1 = monto1;
    }

    public BigDecimal getMonto2() {
        return monto2;
    }

    public void setMonto2(BigDecimal monto2) {
        this.monto2 = monto2;
    }

    public BigDecimal getMonto3() {
        return monto3;
    }

    public void setMonto3(BigDecimal monto3) {
        this.monto3 = monto3;
    }

    public BigDecimal getMonto4() {
        return monto4;
    }

    public void setMonto4(BigDecimal monto4) {
        this.monto4 = monto4;
    }

    public BigDecimal getMonto5() {
        return monto5;
    }

    public void setMonto5(BigDecimal monto5) {
        this.monto5 = monto5;
    }

    public BigDecimal getMonto6() {
        return monto6;
    }

    public void setMonto6(BigDecimal monto6) {
        this.monto6 = monto6;
    }

    public BigDecimal getMonto7() {
        return monto7;
    }

    public void setMonto7(BigDecimal monto7) {
        this.monto7 = monto7;
    }

    public BigDecimal getMonto8() {
        return monto8;
    }

    public void setMonto8(BigDecimal monto8) {
        this.monto8 = monto8;
    }

    public BigDecimal getMonto9() {
        return monto9;
    }

    public void setMonto9(BigDecimal monto9) {
        this.monto9 = monto9;
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

}
