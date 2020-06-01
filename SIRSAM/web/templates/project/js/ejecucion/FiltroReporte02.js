// Reporte de Ejecución de Gasto Anual

function FiltroReporte02() {
    alert("funciona filtro02");
}

function llenarFiltroReporte02() {
    $("#divPresuFiltReporte").empty();
    filtro = '<div class="form-group row">\
                    <label for="listPresuEjecutora" class="col-sm-2 col-form-label">Elija Ejecutora :</label>\
                    <div class="col-sm-6">\
                        <select class="select-form" id="listPresuEjecutora" name="ejec"></select>\
                    </div>\
                    <label class="col-sm-1"></label>\
                    <label for="listPresuAño" class="col-sm-1 col-form-label">Elija Año :</label>\
                    <div class="col-sm-2">\
                        <select class="select-form" id="listPresuAño" name="anho"></select>\
                    </div>\
                </div>';
    filtro += '<div class="form-group row">\
                    <label for="listPresuFiltroPrinc" class="col-sm-2 col-form-label">Filtro Principal :</label>\
                    <div class="col-sm-4">\
                        <select class="select-form" id="listPresuFiltroPrinc" name="filtro_princ">\
                            <option value="00" selected>--Total--</option>\
                            <option value="15">Mensualizado</option>\
                            <option value="01">Categoría Presupuestal</option>\
                            <option value="02">Proyecto/Producto</option>\
                            <option value="03">Actividad/Accion Inversión/Obra</option>\
                            <option value="04">Función</option>\
                            <option value="18">División Funcional</option>\
                            <option value="19">Grupo Funcional</option>\
                            <option value="05">Meta Presupuestaria</option>\
                            <option value="06">Fuente de Financiamiento</option>\
                            <option value="07">Rubro de Financiamiento</option>\
                            <option value="08">Categoría de Gasto</option>\
                            <option value="09">Genérica de Gasto</option>\
                            <option value="10">SubGenérica de Gasto</option>\
                            <option value="11">SubGenérica Detallada de Gasto</option>\
                            <option value="12">Específica de Gasto</option>\
                            <option value="13">Específica Detallada de Gasto</option>\
                            <option value="14">Provincia</option>\
                            <option value="22">Centro de Costo</option>\
                        </select>\
                    </div>\
                    <label id="lblFiltroSecundario" for="dlFiltSecun" class="col-sm-2 col-form-label oculto">Filtros Secundarios :</label>\
                    <div id="divFiltroSecundario" class="col-sm-4 oculto">\
                        <dl id="dlFiltSecun" class="dropdownF">\
                            <dt>\
                                <a>--Seleccione filtros--\
                                    <span class="hida">\
                                        <i class="fa fa-filter" aria-hidden="true"></i>\
                                    </span>\
                                </a>\
                            </dt>\
                            <dd>\
                                <div class="mutliSelect">\
                                    <ul>\
                                        <li id="lifiltS_00"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="00" name="filtroS_ninguno" checked>\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">--NINGUNO--</span>\
                                        </label></li>\
                                        <li id="lifiltS_16"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="16" name="filtroS_ejecutora">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Unidad Ejecutora</span>\
                                        </label></li>\
                                        <li id="lifiltS_01"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="01" name="filtroS_catppto">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Categoría Presupuestal</span>\
                                        </label></li>\
                                        <li id="lifiltS_02"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="02" name="filtroS_proyecto">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Proyecto/Producto</span>\
                                        </label></li>\
                                        <li id="lifiltS_03"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="03" name="filtroS_actividad">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Actividad/Accion Inversión/Obra</span>\
                                        </label></li>\
                                        <li id="lifiltS_04"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="04" name="filtroS_funcion">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Función</span>\
                                        </label></li>\
                                        <li id="lifiltS_18"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="18" name="filtroS_divfuncion">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">División Funcional</span>\
                                        </label></li>\
                                        <li id="lifiltS_19"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="19" name="filtroS_grupfuncion">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Grupo Funcional</span>\
                                        </label></li>\
                                        <li id="lifiltS_05"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="05" name="filtroS_meta">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Meta Presupuestaria</span>\
                                        </label></li>\
                                        <li id="lifiltS_06"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="06" name="filtroS_fuente">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Fuente de Financiamiento</span>\
                                        </label></li>\
                                        <li id="lifiltS_07"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="07" name="filtroS_rubro">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Rubro de Financiamiento</span>\
                                        </label></li>\
                                        <li id="lifiltS_08"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="08" name="filtroS_catgasto">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Categoría de Gasto</span>\
                                        </label></li>\
                                        <li id="lifiltS_09"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="09" name="filtroS_generica">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Genérica de Gasto</span>\
                                        </label></li>\
                                        <li id="lifiltS_10"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="10" name="filtroS_subgenerica">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">SubGenérica de Gasto</span>\
                                        </label></li>\
                                        <li id="lifiltS_11"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="11" name="filtroS_subgenericadet">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">SubGenérica Detallada de Gasto</span>\
                                        </label></li>\
                                        <li id="lifiltS_12"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="12" name="filtroS_especifica">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Específica de Gasto</span>\
                                        </label></li>\
                                        <li id="lifiltS_13"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="13" name="filtroS_especificadet">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Específica Detallada de Gasto</span>\
                                        </label></li>\
                                        <li id="lifiltS_14"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="14" name="filtroS_provincia">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Provincia</span>\
                                        </label></li>\
                                        <li id="lifiltS_22"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="22" name="filtroS_centro">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Centro de Costo</span>\
                                        </label></li>\
                                    </ul>\
                                </div>\
                            </dd>\
                        </dl>\
                    </div>\
                    <label id="lblFiltroSecundarioMensual" for="dlFiltSecunMensual" class="col-sm-2 col-form-label oculto">Filtro Secundario :</label>\
                    <div id="divFiltroSecundarioMensual" class="col-sm-4 oculto">\
                        <dl id="dlFiltSecunMensual" class="dropdownF">\
                            <dt>\
                                <a>--Seleccione un filtro--\
                                    <span class="hida">\
                                        <i class="fa fa-filter" aria-hidden="true"></i>\
                                    </span>\
                                </a>\
                            </dt>\
                            <dd>\
                                <div class="mutliSelect">\
                                    <ul>\
                                        <li id="lifiltMensual_00"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="00" name="filtroMensual_ninguno" checked>\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">--NINGUNO--</span>\
                                        </label></li>\
                                        <li id="lifiltMensual_01"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="01" name="filtroMensual_catppto">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Categoría Presupuestal</span>\
                                        </label></li>\
                                        <li id="lifiltMensual_02"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="02" name="filtroMensual_proyecto">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Proyecto</span>\
                                        </label></li>\
                                        <li id="lifiltMensual_03"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="03" name="filtroMensual_producto">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Producto</span>\
                                        </label></li>\
                                        <li id="lifiltMensual_04"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="04" name="filtroMensual_actividad">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Actividad</span>\
                                        </label></li>\
                                        <li id="lifiltMensual_05"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="05" name="filtroMensual_accion">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Acción de Inversión</span>\
                                        </label></li>\
                                        <li id="lifiltMensual_06"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="06" name="filtroMensual_obra">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Obra</span>\
                                        </label></li>\
                                        <li id="lifiltMensual_07"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="07" name="filtroMensual_funcion">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Función</span>\
                                        </label></li>\
                                        <li id="lifiltMensual_18"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="18" name="filtroMensual_divfuncion">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">División Funcional</span>\
                                        </label></li>\
                                        <li id="lifiltMensual_19"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="19" name="filtroMensual_grupfuncion">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Grupo Funcional</span>\
                                        </label></li>\
                                        <li id="lifiltMensual_08"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="08" name="filtroMensual_meta">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Meta Presupuestaria</span>\
                                        </label></li>\
                                        <li id="lifiltMensual_09"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="09" name="filtroMensual_fuente">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Fuente de Financiamiento</span>\
                                        </label></li>\
                                        <li id="lifiltMensual_10"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="10" name="filtroMensual_rubro">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Rubro de Financiamiento</span>\
                                        </label></li>\
                                        <li id="lifiltMensual_11"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="11" name="filtroMensual_catgasto">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Categoría de Gasto</span>\
                                        </label></li>\
                                        <li id="lifiltMensual_12"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="12" name="filtroMensual_generica">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Genérica de Gasto</span>\
                                        </label></li>\
                                        <li id="lifiltMensual_13"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="13" name="filtroMensual_subgenerica">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">SubGenérica de Gasto</span>\
                                        </label></li>\
                                        <li id="lifiltMensual_14"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="14" name="filtroMensual_subgenericadet">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">SubGenérica Detallada de Gasto</span>\
                                        </label></li>\
                                        <li id="lifiltMensual_15"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="15" name="filtroMensual_especifica">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Específica de Gasto</span>\
                                        </label></li>\
                                        <li id="lifiltMensual_16"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="16" name="filtroMensual_especificadet">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Específica Detallada de Gasto</span>\
                                        </label></li>\
                                        <li id="lifiltMensual_17"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="17" name="filtroMensual_provincia">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Provincia</span>\
                                        </label></li>\
                                        <li id="lifiltMensual_22"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="22" name="filtroMensual_centro">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Centro de Costo</span>\
                                        </label></li>\
                                    </ul>\
                                </div>\
                            </dd>\
                        </dl>\
                    </div>\
               </div>';
    filtro += '<div id="divFiltro" class="form-group row oculto">\
                    <label id="lblFiltPrinc" for="dlFiltPrinc" class="col-sm-2 col-form-label"></label>\
                    <div id="divFiltPrinc" class="col-sm-10 oculto">\
                        <dl id="dlFiltPrinc" class="dropdownF">\
                            <dt>\
                                <a><label id="lblSelectPrinc"></label>\
                                    <span class="hida">\
                                        <i class="fa fa-filter" aria-hidden="true"></i>\
                                    </span>\
                                </a>\
                            </dt>\
                            <dd>\
                                <div class="mutliSelect">\
                                    <ul id="ulFiltPrim"></ul>\
                                </div>\
                            </dd>\
                        </dl>\
                    </div>\
               </div>';
    filtro += '<div id="divFiltSecunMensual"></div>';
    filtro += '<div id="divFiltrosSecundarios"></div>';
    marco = '<div id="divPresuMarco">\
            <div class="form-group row line_top">\
            <label class="col-sm-2">Marco Presupuestal :</label>\
            <div class="col-sm-2 fontweight6">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="marco_todo">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Todos</span>\
            </label>\
            </div>\
            </div>';
    marco += '<div class="form-row fontweight3">\
              <label class="col-sm-2"></label>&nbsp;';
    marco += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="marco" value="2">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">PIA</span>\
            </label>\
            </div>';
    marco += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="marco" value="3">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Modificaciones</span>\
            </label>\
            </div>';
    marco += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="marco" value="4" checked>\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">PIM</span>\
            </label>\
            </div>';
    marco += '</div></div>';
    fase = '<div id="divPresuFase">\
            <div class="form-group row line_top">\
            <label class="col-sm-2">Fase :</label>\
            <div class="col-sm-2 fontweight6">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="fase_todo" checked>\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Todas</span>\
            </label>\
            </div>\
            </div>';
    fase += '<div class="form-row fontweight3">\
              <label class="col-sm-2"></label>&nbsp;';
    fase += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="fase" value="5" checked>\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Certificado</span>\
            </label>\
            </div>';
    fase += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="fase" value="6" checked>\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Compromiso Anual</span>\
            </label>\
            </div>';
    fase += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="fase" value="7" checked>\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Compromiso</span>\
            </label>\
            </div>';
    fase += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="fase" value="8" checked>\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Devengado</span>\
            </label>\
            </div>';
    fase += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="fase" value="9" checked>\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Girado</span>\
            </label>\
            </div>';
    fase += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="fase" value="10" checked>\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Pagado</span>\
            </label>\
            </div>';
    fase += '</div></div>';
    saldo = '<div id="divPresuSaldo">\
            <div class="form-group row line_top">\
            <label class="col-sm-2">Saldos y Porcentajes :</label>\
            <div class="col-sm-2 fontweight6">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="saldo_todo">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Todos</span>\
            </label>\
            </div>\
            </div>';
    saldo += '<div class="form-row fontweight3">\
              <label class="col-sm-2"></label>&nbsp;';
    saldo += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="saldo" value="11, 12">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Certificado</span>\
            </label>\
            </div>';
    saldo += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="saldo" value="13, 14">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Compromiso Anual</span>\
            </label>\
            </div>';
    saldo += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="saldo" value="15, 16">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Compromiso</span>\
            </label>\
            </div>';
    saldo += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="saldo" value="17, 18" checked>\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Devengado</span>\
            </label>\
            </div>';
    saldo += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="saldo" value="19, 20">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Girado</span>\
            </label>\
            </div>';
    saldo += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="saldo" value="21, 22">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Pagado</span>\
            </label>\
            </div>';
    saldo += '</div></div>';
    botones = '<div class="form-row line_top20">\
                <label class="col-sm-2"></label>\
                <div class="col-auto">\
                <button type="submit" class="btn btn3d btn-danger btn-m">\
                <span class="glyphicon glyphicon-play spanBtn"></span>Generar\
                </button>\
                </div>\
                <div class="col-auto">\
                <button id="btnRepoPresu02" type="reset" value="Reset" class="btn btn3d btn-white btn-m">\
                <span class="glyphicon glyphicon-erase spanBtn"></span>Limpiar\
                </button>\
                </div>\
               </div>';
    html = filtro + marco + fase + saldo + botones;
    $("#divPresuFiltReporte").append(html);
    var arraySecun = [];
    $("#dlFiltSecun input").each(function () {
        arraySecun.push(this.value);
    });
    var arraySecunMensual = [];
    $("#dlFiltSecunMensual input").each(function () {
        arraySecunMensual.push(this.value);
    });
    $("#dlFiltSecun.dropdownF dt a").on('click', function () {
        $("#dlFiltPrinc.dropdownF dd ul").hide();
        $("#dlFiltSecunMensual.dropdownF dd ul").hide();
        $("#dlFiltSecund_20.dropdownF dd ul").hide();
        $("#dlFiltSecund_21.dropdownF dd ul").hide();
        hidedlFiltSecund(arraySecun, "");
        hidedlFiltSecundMensual(arraySecunMensual, "");
        $("#dlFiltSecun.dropdownF dd ul").slideToggle('fast');
    });
    $("#dlFiltSecun.dropdownF dd ul li a").on('click', function () {
        $("#dlFiltSecun.dropdownF dd ul").hide();
    });
    $(document).bind('click', function (e) {
        var $clicked = $(e.target);
        if (!$clicked.parents().hasClass("dropdownF"))
            $("#dlFiltSecun.dropdownF dd ul").hide();
    });
    $("#dlFiltSecunMensual.dropdownF dt a").on('click', function () {
        $("#dlFiltPrinc.dropdownF dd ul").hide();
        $("#dlFiltSecun.dropdownF dd ul").hide();
        $("#dlFiltSecund_20.dropdownF dd ul").hide();
        $("#dlFiltSecund_21.dropdownF dd ul").hide();
        hidedlFiltSecund(arraySecun, "");
        hidedlFiltSecundMensual(arraySecunMensual, "");
        $("#dlFiltSecunMensual.dropdownF dd ul").slideToggle('fast');
    });
    $("#dlFiltSecunMensual.dropdownF dd ul li a").on('click', function () {
        $("#dlFiltSecunMensual.dropdownF dd ul").hide();
    });
    $(document).bind('click', function (e) {
        var $clicked = $(e.target);
        if (!$clicked.parents().hasClass("dropdownF"))
            $("#dlFiltSecunMensual.dropdownF dd ul").hide();
    });
    limpiar();
}

function limpiarCheckFiltroSecun02() {
    $("#dlFiltSecun input").prop("checked", false);
    $("#lifiltS_00 input").prop("checked", true);
    $("#dlFiltSecunMensual input").prop("checked", false);
    $("#lifiltMensual_00 input").prop("checked", true);
}

function controlFiltroReporte02() {
    var mensual_val = "00";
    var mensual_id = "";
    var mensual_nombre = "";
    $('#listPresuEjecutora').empty();
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataEjecutoras",
        success: function (response) {
            $("#listPresuEjecutora").append("<option value= '00'>Pliego 459 - Gobierno Regional de San Martin</option>");
            $.each(response.listEjecutoras, function (index, value) {
                var nombre_ejec = (value.nombre).split("-");
                obje = "<option value=" + value.sec_ejec + ">UE " + value.ejecutora + " - " + nombre_ejec[1].trim() + " (" + value.sec_ejec + ")</option>";
                $("#listPresuEjecutora").append(obje);
            });
            $('#listPresuEjecutora').prop('selectedIndex', 1);
            llenarAñoEjec($('#listPresuEjecutora').val(), mensual_val);
        }
    });
    $("#listPresuEjecutora").bind("change", function () {
        var ejec = $('#listPresuEjecutora').val();
        llenarAñoEjec(ejec, mensual_val);
        if (ejec === "00") {
            $("#lifiltS_16").removeClass("oculto");
        } else {
            $("#lifiltS_16").addClass("oculto");
        }
        $("#divFiltSecunMensual").empty();
        $("#divFiltrosSecundarios").empty();
        $("#divPresuMarco").removeClass("oculto");
        $("#divPresuFase").removeClass("oculto");
        $("#divPresuSaldo").removeClass("oculto");
        $("#divFiltro").addClass("oculto");
        $("#lblFiltPrinc").empty();
        $("#divFiltPrinc").addClass("oculto");
        $("#lblFiltroSecundario").addClass("oculto");
        $("#divFiltroSecundario").addClass("oculto");
        $("#lblFiltroSecundarioMensual").addClass("oculto");
        $("#divFiltroSecundarioMensual").addClass("oculto");
        limpiarCheckFiltroSecun02();
        $('#listPresuFiltroPrinc').prop('selectedIndex', 0);
    });
    $("#listPresuAño").bind("change", function () {
        var ejec = $('#listPresuEjecutora').val();
        var año = $("#listPresuAño").val();
        var valP = $("#listPresuFiltroPrinc").val();
        llenarFiltPrinc02(valP, año, ejec, mensual_val);
        if (ejec === "00") {
            $("#lifiltS_16").removeClass("oculto");
        } else {
            $("#lifiltS_16").addClass("oculto");
        }
    });
    $("#listPresuFiltroPrinc").bind("change", function () {
        var ejec = $('#listPresuEjecutora').val();
        var año = $("#listPresuAño").val();
        var valP = $("#listPresuFiltroPrinc").val();
        $("#lblSelectPrinc").empty();
        $("#lblSelectPrinc").append("<b style='color: orangered;'>--Ninguno--</b>");
        $("#divFiltSecunMensual").empty();
        $("#divFiltrosSecundarios").empty();
        if (valP === "00") {
            $("#divPresuMarco").removeClass("oculto");
            $("#divPresuFase").removeClass("oculto");
            $("#divPresuSaldo").removeClass("oculto");
            $("#divFiltro").addClass("oculto");
            $("#lblFiltPrinc").empty();
            $("#divFiltPrinc").addClass("oculto");
            $("#lblFiltroSecundario").addClass("oculto");
            $("#divFiltroSecundario").addClass("oculto");
            $("#lblFiltroSecundarioMensual").addClass("oculto");
            $("#divFiltroSecundarioMensual").addClass("oculto");
            limpiarCheckFiltroSecun02();
        } else if (valP === "15") {
            $("#divPresuMarco").addClass("oculto");
            $("#divPresuFase").removeClass("oculto");
            $("#divPresuSaldo").addClass("oculto");
            $("#divFiltro").addClass("oculto");
            $("#lblFiltPrinc").empty();
            $("#divFiltPrinc").addClass("oculto");
            $("#lblFiltroSecundario").addClass("oculto");
            $("#divFiltroSecundario").addClass("oculto");
            limpiarCheckFiltroSecun02();
            $("#lblFiltroSecundarioMensual").removeClass("oculto");
            $("#divFiltroSecundarioMensual").removeClass("oculto");
        } else {
            $("#divPresuMarco").removeClass("oculto");
            $("#divPresuFase").removeClass("oculto");
            $("#divPresuSaldo").removeClass("oculto");
            $("#divFiltro").removeClass("oculto");
            $("#lblFiltroSecundario").removeClass("oculto");
            $("#divFiltroSecundario").removeClass("oculto");
            $("#lblFiltroSecundarioMensual").addClass("oculto");
            $("#divFiltroSecundarioMensual").addClass("oculto");
            limpiarCheckFiltroSecun02();
            $("#lblFiltPrinc").empty();
            $("#dlFiltSecun li").removeClass("oculto");
            $("#lifiltS_" + valP).addClass("oculto");
            if (valP === "01") {
                $("#lblFiltPrinc").append("Categoría Presupuestal");
            }
            if (valP === "02") {
                $("#lblFiltPrinc").append("Proyecto/Producto");
            }
            if (valP === "03") {
                $("#lblFiltPrinc").append("Actividad/Accion Inv./Obra");
            }
            if (valP === "04") {
                $("#lblFiltPrinc").append("Función");
            }
            if (valP === "05") {
                $("#lblFiltPrinc").append("Meta");
            }
            if (valP === "06") {
                $("#lblFiltPrinc").append("Fuente Financiamiento");
            }
            if (valP === "07") {
                $("#lblFiltPrinc").append("Rubro Financiamiento");
            }
            if (valP === "08") {
                $("#lblFiltPrinc").append("Categoría de Gasto");
            }
            if (valP === "09") {
                $("#lblFiltPrinc").append("Genérica");
            }
            if (valP === "10") {
                $("#lblFiltPrinc").append("SubGenérica");
            }
            if (valP === "11") {
                $("#lblFiltPrinc").append("SubGenérica Detallada");
            }
            if (valP === "12") {
                $("#lblFiltPrinc").append("Específica");
            }
            if (valP === "13") {
                $("#lblFiltPrinc").append("Específica Detallada");
            }
            if (valP === "14") {
                $("#lblFiltPrinc").append("Provincia");
            }
            if (valP === "18") {
                $("#lblFiltPrinc").append("División Funcional");
            }
            if (valP === "19") {
                $("#lblFiltPrinc").append("Grupo Funcional");
            }
            if (valP === "22") {
                $("#lblFiltPrinc").append("Centro de Costo");
            }
            $("#divFiltPrinc").removeClass("oculto");
            llenarFiltPrinc02(valP, año, ejec, mensual_val);
        }
        if (ejec === "00") {
            $("#lifiltS_16").removeClass("oculto");
        } else {
            $("#lifiltS_16").addClass("oculto");
        }
    });

    var arraySecun = [];
    $("#dlFiltSecun input").each(function () {
        arraySecun.push(this.value);
    });
    var arraySecunMensual = [];
    $("#dlFiltSecunMensual input").each(function () {
        arraySecunMensual.push(this.value);
    });

    $("#dlFiltSecun input").change(function () {
        if (this.value === "00") {
            if (this.checked) {
                $("#dlFiltSecun input").prop("checked", false);
                $("#lifiltS_00 input").prop("checked", true);
                $("#divFiltrosSecundarios").empty();
            } else {
                var count1 = 0;
                $("#dlFiltSecun input").each(function () {
                    if (this.checked) {
                        count1++;
                    }
                });
                if (count1 === 0) {
                    $("#lifiltS_00 input").prop("checked", true);
                } else {
                    $("#lifiltS_00 input").prop("checked", false);
                }
            }
        } else {
            var ejecS = $('#listPresuEjecutora').val();
            var añoS = $("#listPresuAño").val();
            if (this.checked) {
                content2 = '<div id="divFiltSecund_' + this.value + '" class="form-group row">\
                                <label id="lblFiltSecund_' + this.value + '" for="dlFiltSecund_' + this.value + '" class="col-sm-2 col-form-label"></label>\
                                <div class="col-sm-10">\
                                    <dl id="dlFiltSecund_' + this.value + '" class="dropdownF">\
                                        <dt>\
                                            <a><label id="lblSelectSecund_' + this.value + '"><b style="color: orangered;">--Ninguno--</b></label>\
                                                <span class="hida">\
                                                    <i class="fa fa-filter" aria-hidden="true"></i>\
                                                </span>\
                                            </a>\
                                        </dt>\
                                        <dd>\
                                            <div class="mutliSelect">\
                                                <ul id="ulFiltSecund_' + this.value + '"></ul>\
                                            </div>\
                                        </dd>\
                                    </dl>\
                                </div>\
                            </div>';
                $("#divFiltrosSecundarios").append(content2);
                llenarFiltSecund02(this.value, añoS, ejecS);
                $("#lifiltS_00 input").prop("checked", false);
                var valdl = this.value;
                $("#dlFiltSecund_" + valdl + ".dropdownF dt a").on('click', function () {
                    $("#dlFiltPrinc.dropdownF dd ul").hide();
                    $("#dlFiltSecun.dropdownF dd ul").hide();
                    $("#dlFiltSecunMensual.dropdownF dd ul").hide();
                    $("#dlFiltSecund_20.dropdownF dd ul").hide();
                    $("#dlFiltSecund_21.dropdownF dd ul").hide();
                    hidedlFiltSecund(arraySecun, valdl);
                    hidedlFiltSecundMensual(arraySecunMensual, "");
                    $("#dlFiltSecund_" + valdl + ".dropdownF dd ul").slideToggle('fast');
                });
                $("#dlFiltSecund_" + valdl + ".dropdownF dd ul li a").on('click', function () {
                    $("#dlFiltSecund_" + valdl + ".dropdownF dd ul").hide();
                });
                $(document).bind('click', function (e) {
                    var $clicked = $(e.target);
                    if (!$clicked.parents().hasClass("dropdownF"))
                        $("#dlFiltSecund_" + valdl + ".dropdownF dd ul").hide();
                });
            } else {
                $("#divFiltSecund_" + this.value).remove();
                var count2 = 0;
                $("#dlFiltSecun input").each(function () {
                    if (this.checked) {
                        count2++;
                    }
                });
                if (count2 === 0) {
                    $("#lifiltS_00 input").prop("checked", true);
                }
            }
        }
    });

    $("#dlFiltSecunMensual input").change(function () {
        $("#dlFiltSecunMensual input").prop("checked", false);
        $("#lifiltMensual_" + this.value + " input").prop("checked", true);
        mensual_val = this.value;
        if (this.value === "00") {
            $("#divFiltSecunMensual").empty();
        } else {
            $("#divFiltSecunMensual").empty();
            var ejecM = $('#listPresuEjecutora').val();
            var añoM = $("#listPresuAño").val();
            contentM = '<div class="form-group row">\
                                <label id="lblFiltSecundMensual_' + this.value + '" for="dlFiltSecundMensual_' + this.value + '" class="col-sm-2 col-form-label"></label>\
                                <div class="col-sm-10">\
                                    <dl id="dlFiltSecundMensual_' + this.value + '" class="dropdownF">\
                                        <dt>\
                                            <a>\
                                                <label id="lblSelectSecundMens_' + this.value + '"><b style="color: orangered;">--Ninguno--</b></label>\
                                                <span class="hida">\
                                                    <i class="fa fa-filter" aria-hidden="true"></i>\
                                                </span>\
                                            </a>\
                                        </dt>\
                                        <dd>\
                                            <div class="mutliSelect">\
                                                <ul id="ulFiltSecundMensual_' + this.value + '"></ul>\
                                            </div>\
                                        </dd>\
                                    </dl>\
                                </div>\
                            </div>';
            $("#divFiltSecunMensual").append(contentM);
            llenarFiltSecundMensual02(this.value, añoM, ejecM);
            $("#lifiltS_00 input").prop("checked", false);
            var valdlM = this.value;
            $("#dlFiltSecundMensual_" + valdlM + ".dropdownF dt a").on('click', function () {
                $("#dlFiltPrinc.dropdownF dd ul").hide();
                $("#dlFiltSecun.dropdownF dd ul").hide();
                $("#dlFiltSecunMensual.dropdownF dd ul").hide();
                $("#dlFiltSecund_20.dropdownF dd ul").hide();
                $("#dlFiltSecund_21.dropdownF dd ul").hide();
                hidedlFiltSecund(arraySecun, "");
                hidedlFiltSecundMensual(arraySecunMensual, valdlM);
                $("#dlFiltSecundMensual_" + valdlM + ".dropdownF dd ul").slideToggle('fast');
            });
            $("#dlFiltSecundMensual_" + valdlM + ".dropdownF dd ul li a").on('click', function () {
                $("#dlFiltSecundMensual_" + valdlM + ".dropdownF dd ul").hide();
            });
            $(document).bind('click', function (e) {
                var $clicked = $(e.target);
                if (!$clicked.parents().hasClass("dropdownF"))
                    $("#dlFiltSecundMensual_" + valdlM + ".dropdownF dd ul").hide();
            });
        }
    });

    $("#dlFiltPrinc.dropdownF dt a").on('click', function () {
        $("#dlFiltSecun.dropdownF dd ul").hide();
        $("#dlFiltSecunMensual.dropdownF dd ul").hide();
        $("#dlFiltSecund_20.dropdownF dd ul").hide();
        $("#dlFiltSecund_21.dropdownF dd ul").hide();
        hidedlFiltSecund(arraySecun, "");
        hidedlFiltSecundMensual(arraySecunMensual, "");
        $("#dlFiltPrinc.dropdownF dd ul").slideToggle('fast');
    });
    $("#dlFiltPrinc.dropdownF dd ul li a").on('click', function () {
        $("#dlFiltPrinc.dropdownF dd ul").hide();
    });
    $(document).bind('click', function (e) {
        var $clicked = $(e.target);
        if (!$clicked.parents().hasClass("dropdownF"))
            $("#dlFiltPrinc.dropdownF dd ul").hide();
    });
    cambiaMarco();
    cambiaFase();
    cambiaSaldo();
    $("#btnRepoPresu02").click(function () {
        $("#divPresuTabla").empty();
        $("#divPresuTabla").addClass("oculto");
        $("#lblPresuFiltGrafico").addClass("oculto");
        $("#divPresuFiltGrafico").empty();
        $("#divPresuFiltGrafico").addClass("oculto");
        $("#divPresuGrafica").empty();
        $("#divPresuGrafica").addClass("oculto");
        $("#divPresuMarco").removeClass("oculto");
        $("#divPresuFase").removeClass("oculto");
        $("#divPresuSaldo").removeClass("oculto");
        $("#divFiltro").addClass("oculto");
        $("#lblFiltPrinc").empty();
        $("#divFiltPrinc").addClass("oculto");
        $("#lblFiltroSecundario").addClass("oculto");
        $("#divFiltroSecundario").addClass("oculto");
        $("#lblFiltroSecundarioMensual").addClass("oculto");
        $("#divFiltroSecundarioMensual").addClass("oculto");
        $("#divFiltSecunMensual").empty();
        $("#divFiltrosSecundarios").empty();
        limpiarCheckFiltroSecun02();
    });
}

function llenarFiltSecund02(val, año, ejec) {
    $("#lblFiltSecund_" + val).empty();
    if (val === "16") {
        $("#lblFiltSecund_" + val).append("Unidad Ejecutora");
    }
    if (val === "01") {
        $("#lblFiltSecund_" + val).append("Categoría Presupuestal");
    }
    if (val === "02") {
        $("#lblFiltSecund_" + val).append("Proyecto/Producto");
    }
    if (val === "03") {
        $("#lblFiltSecund_" + val).append("Actividad/Accion Inv./Obra");
    }
    if (val === "04") {
        $("#lblFiltSecund_" + val).append("Función");
    }
    if (val === "05") {
        $("#lblFiltSecund_" + val).append("Meta");
    }
    if (val === "06") {
        $("#lblFiltSecund_" + val).append("Fuente Financiamiento");
    }
    if (val === "07") {
        $("#lblFiltSecund_" + val).append("Rubro Financiamiento");
    }
    if (val === "08") {
        $("#lblFiltSecund_" + val).append("Categoría de Gasto");
    }
    if (val === "09") {
        $("#lblFiltSecund_" + val).append("Genérica");
    }
    if (val === "10") {
        $("#lblFiltSecund_" + val).append("SubGenérica");
    }
    if (val === "11") {
        $("#lblFiltSecund_" + val).append("SubGenérica Detallada");
    }
    if (val === "12") {
        $("#lblFiltSecund_" + val).append("Específica");
    }
    if (val === "13") {
        $("#lblFiltSecund_" + val).append("Específica Detallada");
    }
    if (val === "14") {
        $("#lblFiltSecund_" + val).append("Provincia");
    }
    if (val === "18") {
        $("#lblFiltSecund_" + val).append("División Funcional");
    }
    if (val === "19") {
        $("#lblFiltSecund_" + val).append("Grupo Funcional");
    }
    if (val === "22") {
        $("#lblFiltSecund_" + val).append("Centro de Costo");
    }
    $("#ulFiltSecund_" + val).empty();
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataFiltros&ejec=" + ejec + "&año=" + año + "&val=" + val,
        success: function (response) {
            var obje1 = '<li><label class="custom-control custom-checkbox">\
                            <input type="checkbox" class="custom-control-input" value="todo" name="filtro_todo_' + val + '">\
                            <span class="custom-control-indicator"></span>&nbsp;\
                            <span class="custom-control-description"><b>--Todas--</b></span>\
                         </label></li>';
            if (val === "02") {
                obje1 += '<li><label class="custom-control custom-checkbox">\
                            <input type="checkbox" class="custom-control-input" value="todo" name="filtro_proy_' + val + '">\
                            <span class="custom-control-indicator"></span>&nbsp;\
                            <span class="custom-control-description"><b>--Proyectos--</b></span>\
                          </label></li>\
                          <li><label class="custom-control custom-checkbox">\
                            <input type="checkbox" class="custom-control-input" value="todo" name="filtro_prod_' + val + '">\
                            <span class="custom-control-indicator"></span>&nbsp;\
                            <span class="custom-control-description"><b>--Productos--</b></span>\
                          </label></li>';
            }
            if (val === "03") {
                obje1 += '<li><label class="custom-control custom-checkbox">\
                            <input type="checkbox" class="custom-control-input" value="todo" name="filtro_act_' + val + '">\
                            <span class="custom-control-indicator"></span>&nbsp;\
                            <span class="custom-control-description"><b>--Actividades--</b></span>\
                          </label></li>\
                          <li><label class="custom-control custom-checkbox">\
                            <input type="checkbox" class="custom-control-input" value="todo" name="filtro_inv_' + val + '">\
                            <span class="custom-control-indicator"></span>&nbsp;\
                            <span class="custom-control-description"><b>--Acciones Inversión--</b></span>\
                          </label></li>\
                          <li><label class="custom-control custom-checkbox">\
                            <input type="checkbox" class="custom-control-input" value="todo" name="filtro_obra_' + val + '">\
                            <span class="custom-control-indicator"></span>&nbsp;\
                            <span class="custom-control-description"><b>--Obras--</b></span>\
                          </label></li>';
            }
            $("#ulFiltSecund_" + val).append(obje1);
            var size = 0;
            $.each(response.list, function (index, value) {
                size++;
                var obje2;
                if (val === "16") {
                    var nombre_ejec = (value.nombre).split("-");
                    obje2 = '<li><label class="custom-control custom-checkbox">\
                                <input type="checkbox" class="custom-control-input" value="' + value.sec_ejec + '" name="filtro_' + val + '">\
                                <span class="custom-control-indicator"></span>&nbsp;\
                                <span class="custom-control-description"><b>UE ' + value.ejecutora + "</b> - " + nombre_ejec[1].trim() + ' (' + value.sec_ejec + ')</span>\
                             </label></li>';
                } else if (val === "14") {
                    obje2 = '<li><label class="custom-control custom-checkbox">\
                                <input id="' + value.nombre + '" type="checkbox" class="custom-control-input" value="' + value.codigo + '" name="filtro_' + val + '">\
                                <span class="custom-control-indicator"></span>&nbsp;\
                                <span class="custom-control-description"><b>' + value.codigo + "</b> - " + value.nombre + '</span>\
                             </label></li>';
                } else if (val === "22") {
                    obje2 = '<li><label class="custom-control custom-checkbox">\
                                <input id="' + value.nombre + '" type="checkbox" class="custom-control-input" value="' + value.ceco_id + '" name="filtro_' + val + '">\
                                <span class="custom-control-indicator"></span>&nbsp;\
                                <span class="custom-control-description"><b>' + value.codigo + "</b> - " + value.nombre + '</span>\
                             </label></li>';
                } else {
                    obje2 = '<li><label class="custom-control custom-checkbox">\
                                <input type="checkbox" class="custom-control-input" value="' + value.codigo + '" name="filtro_' + val + '">\
                                <span class="custom-control-indicator"></span>&nbsp;\
                                <span class="custom-control-description"><b>' + value.codigo + "</b> - " + value.nombre + '</span>\
                             </label></li>';
                }
                $("#ulFiltSecund_" + val).append(obje2);
            });
            if (val === "02") {
                $("input[name=filtro_todo_02]").change(function () {
                    $("#lblSelectSecund_02").empty();
                    if (this.checked) {
                        $("#lblSelectSecund_02").append("<b>--Todos--</b>");
                        $("input[name=filtro_02]").prop("checked", true);
                        $("input[name=filtro_proy_02]").prop("checked", true);
                        $("input[name=filtro_prod_02]").prop("checked", true);
                    }
                    if (this.checked === false) {
                        $("#lblSelectSecund_02").append("<b style='color: orangered;'>--Ninguno--</b>");
                        $("input[name=filtro_02]").prop("checked", false);
                        $("input[name=filtro_proy_02]").prop("checked", false);
                        $("input[name=filtro_prod_02]").prop("checked", false);
                    }
                });
                var size_proy = 0;
                var size_prod = 0;
                $("input[name=filtro_02]").each(function () {
                    if (this.value.charAt(0) === "2") {
                        size_proy++;
                    }
                    if (this.value.charAt(0) === "3") {
                        size_prod++;
                    }
                });
                $("input[name=filtro_proy_02]").change(function () {
                    $("#lblSelectSecund_02").empty();
                    if (this.checked) {
                        $("input[name=filtro_02]").each(function () {
                            if (this.value.charAt(0) === "2") {
                                $("input[value=" + this.value + "]").prop("checked", true);
                            }
                        });
                        if ($("input[name=filtro_prod_02]").is(":checked")) {
                            $("#lblSelectSecund_02").append("<b>--Todos--</b>");
                            $("input[name=filtro_todo_02]").prop("checked", true);
                        } else {
                            var count_prod = 0;
                            var textProd = "<b>Productos: </b>";
                            $("input[name=filtro_02]").each(function () {
                                if (this.checked) {
                                    if (this.value.charAt(0) === "3") {
                                        count_prod++;
                                        textProd += this.value + ", ";
                                    }
                                }
                            });
                            textProd = textProd.substring(0, textProd.length - 2);
                            if (count_prod === 0) {
                                $("#lblSelectSecund_02").append("<b>--Todos los Proyectos--</b>");
                            } else {
                                $("#lblSelectSecund_02").append("<b>--Todos los Proyectos--</b> <b>|</b> " + textProd);
                            }
                        }
                    } else {
                        $("input[name=filtro_02]").each(function () {
                            if (this.value.charAt(0) === "2") {
                                $("input[value=" + this.value + "]").prop("checked", false);
                            }
                        });
                        $("input[name=filtro_todo_02]").prop("checked", false);
                        if ($("input[name=filtro_prod_02]").is(":checked")) {
                            $("#lblSelectSecund_02").append("<b>--Todos los Productos--</b>");
                        } else {
                            var count_prod = 0;
                            var textProd = "<b>Productos: </b>";
                            $("input[name=filtro_02]").each(function () {
                                if (this.checked) {
                                    if (this.value.charAt(0) === "3") {
                                        count_prod++;
                                        textProd += this.value + ", ";
                                    }
                                }
                            });
                            textProd = textProd.substring(0, textProd.length - 2);
                            if (count_prod === 0) {
                                $("#lblSelectSecund_02").append("<b style='color: orangered;'>--Ninguno--</b>");
                            } else {
                                $("#lblSelectSecund_02").append(textProd);
                            }
                        }
                    }
                });
                $("input[name=filtro_prod_02]").change(function () {
                    $("#lblSelectSecund_02").empty();
                    if (this.checked) {
                        $("input[name=filtro_02]").each(function () {
                            if (this.value.charAt(0) === "3") {
                                $("input[value=" + this.value + "]").prop("checked", true);
                            }
                        });
                        if ($("input[name=filtro_proy_02]").is(":checked")) {
                            $("#lblSelectSecund_02").append("<b>--Todos--</b>");
                            $("input[name=filtro_todo_02]").prop("checked", true);
                        } else {
                            var count_proy = 0;
                            var textProy = "<b>Proyectos: </b>";
                            $("input[name=filtro_02]").each(function () {
                                if (this.checked) {
                                    if (this.value.charAt(0) === "2") {
                                        count_proy++;
                                        textProy += this.value + ", ";
                                    }
                                }
                            });
                            textProy = textProy.substring(0, textProy.length - 2);
                            if (count_proy === 0) {
                                $("#lblSelectSecund_02").append("<b>--Todos los Productos--</b>");
                            } else {
                                $("#lblSelectSecund_02").append(textProy + " <b>|</b> <b>--Todos los Productos--</b>");
                            }
                        }
                    } else {
                        $("input[name=filtro_02]").each(function () {
                            if (this.value.charAt(0) === "3") {
                                $("input[value=" + this.value + "]").prop("checked", false);
                            }
                        });
                        $("input[name=filtro_todo_02]").prop("checked", false);
                        if ($("input[name=filtro_proy_02]").is(":checked")) {
                            $("#lblSelectSecund_02").append("<b>--Todos los Proyectos--</b>");
                        } else {
                            var count_proy = 0;
                            var textProy = "<b>Proyectos: </b>";
                            $("input[name=filtro_02]").each(function () {
                                if (this.checked) {
                                    if (this.value.charAt(0) === "2") {
                                        count_proy++;
                                        textProy += this.value + ", ";
                                    }
                                }
                            });
                            textProy = textProy.substring(0, textProy.length - 2);
                            if (count_proy === 0) {
                                $("#lblSelectSecund_02").append("<b style='color: orangered;'>--Ninguno--</b>");
                            } else {
                                $("#lblSelectSecund_02").append(textProy);
                            }
                        }
                    }
                });
                $("input[name=filtro_02]").change(function () {
                    $("#lblSelectSecund_02").empty();
                    if (this.checked === false) {
                        $("input[name=filtro_todo_02]").prop("checked", false);
                        if (this.value.charAt(0) === "2") {
                            $("input[name=filtro_proy_02]").prop("checked", false);
                        }
                        if (this.value.charAt(0) === "3") {
                            $("input[name=filtro_prod_02]").prop("checked", false);
                        }
                    }
                    var count = 0;
                    var count_proy = 0;
                    var count_prod = 0;
                    var text;
                    var textProy = "<b>Proyectos: </b>";
                    var textProd = "<b>Productos: </b>";
                    $("input[name=filtro_02]").each(function () {
                        if (this.checked) {
                            count++;
                            if (this.value.charAt(0) === "2") {
                                count_proy++;
                                textProy += this.value + ", ";
                            }
                            if (this.value.charAt(0) === "3") {
                                count_prod++;
                                textProd += this.value + ", ";
                            }
                        }
                    });
                    textProy = textProy.substring(0, textProy.length - 2);
                    textProd = textProd.substring(0, textProd.length - 2);
                    if (count_proy === size_proy) {
                        textProy = "<b>--Todos los Proyectos--</b>";
                        $("input[name=filtro_proy_02]").prop("checked", true);
                    }
                    if (count_prod === size_prod) {
                        textProd = "<b>--Todos los Productos--</b>";
                        $("input[name=filtro_prod_02]").prop("checked", true);
                    }
                    text = textProy + " <b>|</b> " + textProd;
                    if (count_proy === 0) {
                        text = textProd;
                    }
                    if (count_prod === 0) {
                        text = textProy;
                    }
                    if (count === size) {
                        text = "<b>--Todos--</b>";
                        $("input[name=filtro_todo_02]").prop("checked", true);
                        $("input[name=filtro_proy_02]").prop("checked", true);
                        $("input[name=filtro_prod_02]").prop("checked", true);
                    }
                    if (count === 0) {
                        text = "<b style='color: orangered;'>--Ninguno--</b>";
                    }
                    $("#lblSelectSecund_02").append(text);
                });
            } else if (val === "03") {
                $("input[name=filtro_todo_03]").change(function () {
                    $("#lblSelectSecund_03").empty();
                    if (this.checked) {
                        $("#lblSelectSecund_03").append("<b>--Todas--</b>");
                        $("input[name=filtro_03]").prop("checked", true);
                        $("input[name=filtro_act_03]").prop("checked", true);
                        $("input[name=filtro_inv_03]").prop("checked", true);
                        $("input[name=filtro_obra_03]").prop("checked", true);
                    }
                    if (this.checked === false) {
                        $("#lblSelectSecund_03").append("<b style='color: orangered;'>--Ninguno--</b>");
                        $("input[name=filtro_03]").prop("checked", false);
                        $("input[name=filtro_act_03]").prop("checked", false);
                        $("input[name=filtro_inv_03]").prop("checked", false);
                        $("input[name=filtro_obra_03]").prop("checked", false);
                    }
                });
                var size_act = 0;
                var size_inv = 0;
                var size_obra = 0;
                $("input[name=filtro_03]").each(function () {
                    if (this.value.charAt(0) === "4") {
                        size_act++;
                    }
                    if (this.value.charAt(0) === "5") {
                        size_inv++;
                    }
                    if (this.value.charAt(0) === "6") {
                        size_obra++;
                    }
                });
                $("input[name=filtro_act_03]").change(function () {
                    $("#lblSelectSecund_03").empty();
                    if (this.checked) {
                        $("input[name=filtro_03]").each(function () {
                            if (this.value.charAt(0) === "4") {
                                $("input[value=" + this.value + "]").prop("checked", true);
                            }
                        });
                        if ($("input[name=filtro_inv_03]").is(":checked") && $("input[name=filtro_obra_03]").is(":checked")) {
                            $("#lblSelectSecund_03").append("<b>--Todos--</b>");
                            $("input[name=filtro_todo_03]").prop("checked", true);
                        } else if ($("input[name=filtro_inv_03]").is(":checked") && $("input[name=filtro_obra_03]").not(":checked")) {
                            var count_obra = 0;
                            var textObra = "<b>Obras: </b>";
                            $("input[name=filtro_03]").each(function () {
                                if (this.checked) {
                                    if (this.value.charAt(0) === "6") {
                                        count_obra++;
                                        textObra += this.value + ", ";
                                    }
                                }
                            });
                            textObra = textObra.substring(0, textObra.length - 2);
                            if (count_obra === 0) {
                                $("#lblSelectSecund_03").append("<b>--Todas las Actividades--</b> <b>|</b> <b>--Todas las Acciones de Inversión--</b>");
                            } else {
                                $("#lblSelectSecund_03").append("<b>--Todas las Actividades--</b> <b>|</b> <b>--Todas las Acciones de Inversión--</b> <b>|</b> " + textObra);
                            }
                        } else if ($("input[name=filtro_inv_03]").not(":checked") && $("input[name=filtro_obra_03]").is(":checked")) {
                            var count_inv = 0;
                            var textInv = "<b>Acciones de Inversión: </b>";
                            $("input[name=filtro_03]").each(function () {
                                if (this.checked) {
                                    if (this.value.charAt(0) === "5") {
                                        count_inv++;
                                        textInv += this.value + ", ";
                                    }
                                }
                            });
                            textInv = textInv.substring(0, textInv.length - 2);
                            if (count_inv === 0) {
                                $("#lblSelectSecund_03").append("<b>--Todas las Actividades--</b> <b>|</b> <b>--Todas las Obras--</b>");
                            } else {
                                $("#lblSelectSecund_03").append("<b>--Todas las Actividades--</b> <b>|</b> " + textInv + " <b>|</b> <b>--Todas las Obras--</b>");
                            }
                        } else if ($("input[name=filtro_inv_03]").not(":checked") && $("input[name=filtro_obra_03]").not(":checked")) {
                            var count_inv = 0;
                            var count_obra = 0;
                            var textInv = "<b>Acciones de Inversión: </b>";
                            var textObra = "<b>Obras: </b>";
                            $("input[name=filtro_03]").each(function () {
                                if (this.checked) {
                                    if (this.value.charAt(0) === "5") {
                                        count_inv++;
                                        textInv += this.value + ", ";
                                    }
                                    if (this.value.charAt(0) === "6") {
                                        count_obra++;
                                        textObra += this.value + ", ";
                                    }
                                }
                            });
                            textInv = textInv.substring(0, textInv.length - 2);
                            textObra = textObra.substring(0, textObra.length - 2);
                            if (count_inv === 0 && count_obra !== 0) {
                                $("#lblSelectSecund_03").append("<b>--Todas las Actividades--</b> <b>|</b> " + textObra);
                            } else if (count_inv !== 0 && count_obra === 0) {
                                $("#lblSelectSecund_03").append("<b>--Todas las Actividades--</b> <b>|</b> " + textInv);
                            } else if (count_inv === 0 && count_obra === 0) {
                                $("#lblSelectSecund_03").append("<b>--Todas las Actividades--</b>");
                            }
                        }
                    } else {
                        $("input[name=filtro_03]").each(function () {
                            if (this.value.charAt(0) === "4") {
                                $("input[value=" + this.value + "]").prop("checked", false);
                            }
                        });
                        $("input[name=filtro_todo_03]").prop("checked", false);
                        if ($("input[name=filtro_inv_03]").is(":checked") && $("input[name=filtro_obra_03]").is(":checked")) {
                            $("#lblSelectSecund_03").append("<b>--Todas las Acciones de Inversión--</b> <b>|</b> <b>--Todas las Obras--</b>");
                        } else if ($("input[name=filtro_inv_03]").is(":checked") && $("input[name=filtro_obra_03]").not(":checked")) {
                            var count_obra = 0;
                            var textObra = "<b>Obras: </b>";
                            $("input[name=filtro_03]").each(function () {
                                if (this.checked) {
                                    if (this.value.charAt(0) === "6") {
                                        count_obra++;
                                        textObra += this.value + ", ";
                                    }
                                }
                            });
                            textObra = textObra.substring(0, textObra.length - 2);
                            if (count_obra === 0) {
                                $("#lblSelectSecund_03").append("<b>--Todas las Acciones de Inversión--</b>");
                            } else {
                                $("#lblSelectSecund_03").append("<b>--Todas las Acciones de Inversión--</b> <b>|</b> " + textObra);
                            }
                        } else if ($("input[name=filtro_inv_03]").not(":checked") && $("input[name=filtro_obra_03]").is(":checked")) {
                            var count_inv = 0;
                            var textInv = "<b>Acciones de Inversión: </b>";
                            $("input[name=filtro_03]").each(function () {
                                if (this.checked) {
                                    if (this.value.charAt(0) === "5") {
                                        count_inv++;
                                        textInv += this.value + ", ";
                                    }
                                }
                            });
                            textInv = textInv.substring(0, textInv.length - 2);
                            if (count_inv === 0) {
                                $("#lblSelectSecund_03").append("<b>--Todas las Obras--</b>");
                            } else {
                                $("#lblSelectSecund_03").append(textInv + " <b>|</b> <b>--Todas las Obras--</b>");
                            }
                        } else if ($("input[name=filtro_inv_03]").not(":checked") && $("input[name=filtro_obra_03]").not(":checked")) {
                            var count_inv = 0;
                            var count_obra = 0;
                            var textInv = "<b>Acciones de Inversión: </b>";
                            var textObra = "<b>Obras: </b>";
                            $("input[name=filtro_03]").each(function () {
                                if (this.checked) {
                                    if (this.value.charAt(0) === "5") {
                                        count_inv++;
                                        textInv += this.value + ", ";
                                    }
                                    if (this.value.charAt(0) === "6") {
                                        count_obra++;
                                        textObra += this.value + ", ";
                                    }
                                }
                            });
                            textInv = textInv.substring(0, textInv.length - 2);
                            textObra = textObra.substring(0, textObra.length - 2);
                            if (count_inv === 0 && count_obra !== 0) {
                                $("#lblSelectSecund_03").append(textObra);
                            } else if (count_inv !== 0 && count_obra === 0) {
                                $("#lblSelectSecund_03").append(textInv);
                            } else if (count_inv === 0 && count_obra === 0) {
                                $("#lblSelectSecund_03").append("<b style='color: orangered;'>--Ninguno--</b>");
                            }
                        }
                    }
                });
                $("input[name=filtro_inv_03]").change(function () {
                    $("#lblSelectSecund_03").empty();
                    if (this.checked) {
                        $("input[name=filtro_03]").each(function () {
                            if (this.value.charAt(0) === "5") {
                                $("input[value=" + this.value + "]").prop("checked", true);
                            }
                        });
                        if ($("input[name=filtro_act_03]").is(":checked") && $("input[name=filtro_obra_03]").is(":checked")) {
                            $("#lblSelectSecund_03").append("<b>--Todos--</b>");
                            $("input[name=filtro_todo_03]").prop("checked", true);
                        } else if ($("input[name=filtro_act_03]").is(":checked") && $("input[name=filtro_obra_03]").not(":checked")) {
                            var count_obra = 0;
                            var textObra = "<b>Obras: </b>";
                            $("input[name=filtro_03]").each(function () {
                                if (this.checked) {
                                    if (this.value.charAt(0) === "6") {
                                        count_obra++;
                                        textObra += this.value + ", ";
                                    }
                                }
                            });
                            textObra = textObra.substring(0, textObra.length - 2);
                            if (count_obra === 0) {
                                $("#lblSelectSecund_03").append("<b>--Todas las Actividades--</b> <b>|</b> <b>--Todas las Acciones de Inversión--</b>");
                            } else {
                                $("#lblSelectSecund_03").append("<b>--Todas las Actividades--</b> <b>|</b> <b>--Todas las Acciones de Inversión--</b> <b>|</b> " + textObra);
                            }
                        } else if ($("input[name=filtro_act_03]").not(":checked") && $("input[name=filtro_obra_03]").is(":checked")) {
                            var count_act = 0;
                            var textAct = "<b>Actividades: </b>";
                            $("input[name=filtro_03]").each(function () {
                                if (this.checked) {
                                    if (this.value.charAt(0) === "4") {
                                        count_act++;
                                        textAct += this.value + ", ";
                                    }
                                }
                            });
                            textAct = textAct.substring(0, textAct.length - 2);
                            if (count_act === 0) {
                                $("#lblSelectSecund_03").append("<b>--Todas las Acciones de Inversión--</b> <b>|</b> <b>--Todas las Obras--</b>");
                            } else {
                                $("#lblSelectSecund_03").append(textAct + " <b>|</b> <b>--Todas las Acciones de Inversión--</b> <b>|</b> <b>--Todas las Obras--</b>");
                            }
                        } else if ($("input[name=filtro_act_03]").not(":checked") && $("input[name=filtro_obra_03]").not(":checked")) {
                            var count_act = 0;
                            var count_obra = 0;
                            var textAct = "<b>Actividades: </b>";
                            var textObra = "<b>Obras: </b>";
                            $("input[name=filtro_03]").each(function () {
                                if (this.checked) {
                                    if (this.value.charAt(0) === "4") {
                                        count_act++;
                                        textAct += this.value + ", ";
                                    }
                                    if (this.value.charAt(0) === "6") {
                                        count_obra++;
                                        textObra += this.value + ", ";
                                    }
                                }
                            });
                            textAct = textAct.substring(0, textAct.length - 2);
                            textObra = textObra.substring(0, textObra.length - 2);
                            if (count_act === 0 && count_obra !== 0) {
                                $("#lblSelectSecund_03").append("<b>--Todas las Acciones de Inversión--</b> <b>|</b> " + textObra);
                            } else if (count_act !== 0 && count_obra === 0) {
                                $("#lblSelectSecund_03").append(textAct + " <b>|</b> <b>--Todas las Acciones de Inversión--</b>");
                            } else if (count_act === 0 && count_obra === 0) {
                                $("#lblSelectSecund_03").append("<b>--Todas las Acciones de Inversión--</b>");
                            }
                        }
                    } else {
                        $("input[name=filtro_03]").each(function () {
                            if (this.value.charAt(0) === "5") {
                                $("input[value=" + this.value + "]").prop("checked", false);
                            }
                        });
                        $("input[name=filtro_todo_03]").prop("checked", false);
                        if ($("input[name=filtro_act_03]").is(":checked") && $("input[name=filtro_obra_03]").is(":checked")) {
                            $("#lblSelectSecund_03").append("<b>--Todas las Actividades--</b> <b>|</b> <b>--Todas las Obras--</b>");
                        } else if ($("input[name=filtro_act_03]").is(":checked") && $("input[name=filtro_obra_03]").not(":checked")) {
                            var count_obra = 0;
                            var textObra = "<b>Obras: </b>";
                            $("input[name=filtro_03]").each(function () {
                                if (this.checked) {
                                    if (this.value.charAt(0) === "6") {
                                        count_obra++;
                                        textObra += this.value + ", ";
                                    }
                                }
                            });
                            textObra = textObra.substring(0, textObra.length - 2);
                            if (count_obra === 0) {
                                $("#lblSelectSecund_03").append("<b>--Todas las Actividades--</b>");
                            } else {
                                $("#lblSelectSecund_03").append("<b>--Todas las Actividades--</b> <b>|</b> " + textObra);
                            }
                        } else if ($("input[name=filtro_act_03]").not(":checked") && $("input[name=filtro_obra_03]").is(":checked")) {
                            var count_act = 0;
                            var textAct = "<b>Actividades: </b>";
                            $("input[name=filtro_03]").each(function () {
                                if (this.checked) {
                                    if (this.value.charAt(0) === "4") {
                                        count_act++;
                                        textAct += this.value + ", ";
                                    }
                                }
                            });
                            textAct = textAct.substring(0, textAct.length - 2);
                            if (count_act === 0) {
                                $("#lblSelectSecund_03").append("<b>--Todas las Obras--</b>");
                            } else {
                                $("#lblSelectSecund_03").append(textAct + " <b>|</b> <b>--Todas las Obras--</b>");
                            }
                        } else if ($("input[name=filtro_act_03]").not(":checked") && $("input[name=filtro_obra_03]").not(":checked")) {
                            var count_act = 0;
                            var count_obra = 0;
                            var textAct = "<b>Actividades: </b>";
                            var textObra = "<b>Obras: </b>";
                            $("input[name=filtro_03]").each(function () {
                                if (this.checked) {
                                    if (this.value.charAt(0) === "4") {
                                        count_act++;
                                        textAct += this.value + ", ";
                                    }
                                    if (this.value.charAt(0) === "6") {
                                        count_obra++;
                                        textObra += this.value + ", ";
                                    }
                                }
                            });
                            textAct = textAct.substring(0, textAct.length - 2);
                            textObra = textObra.substring(0, textObra.length - 2);
                            if (count_act === 0 && count_obra !== 0) {
                                $("#lblSelectSecund_03").append(textObra);
                            } else if (count_act !== 0 && count_obra === 0) {
                                $("#lblSelectSecund_03").append(textAct);
                            } else if (count_act === 0 && count_obra === 0) {
                                $("#lblSelectSecund_03").append("<b style='color: orangered;'>--Ninguno--</b>");
                            }
                        }
                    }
                });
                $("input[name=filtro_obra_03]").change(function () {
                    $("#lblSelectSecund_03").empty();
                    if (this.checked) {
                        $("input[name=filtro_03]").each(function () {
                            if (this.value.charAt(0) === "6") {
                                $("input[value=" + this.value + "]").prop("checked", true);
                            }
                        });
                        if ($("input[name=filtro_act_03]").is(":checked") && $("input[name=filtro_inv_03]").is(":checked")) {
                            $("#lblSelectSecund_03").append("<b>--Todos--</b>");
                            $("input[name=filtro_todo_03]").prop("checked", true);
                        } else if ($("input[name=filtro_act_03]").is(":checked") && $("input[name=filtro_inv_03]").not(":checked")) {
                            var count_inv = 0;
                            var textInv = "<b>Acciones de Inversión: </b>";
                            $("input[name=filtro_03]").each(function () {
                                if (this.checked) {
                                    if (this.value.charAt(0) === "5") {
                                        count_inv++;
                                        textInv += this.value + ", ";
                                    }
                                }
                            });
                            textInv = textInv.substring(0, textInv.length - 2);
                            if (count_inv === 0) {
                                $("#lblSelectSecund_03").append("<b>--Todas las Actividades--</b> <b>|</b> <b>--Todas las Obras--</b>");
                            } else {
                                $("#lblSelectSecund_03").append("<b>--Todas las Actividades--</b> <b>|</b> " + textInv + " <b>|</b> <b>--Todas las Obras--</b>");
                            }
                        } else if ($("input[name=filtro_act_03]").not(":checked") && $("input[name=filtro_inv_03]").is(":checked")) {
                            var count_act = 0;
                            var textAct = "<b>Actividades: </b>";
                            $("input[name=filtro_03]").each(function () {
                                if (this.checked) {
                                    if (this.value.charAt(0) === "4") {
                                        count_act++;
                                        textAct += this.value + ", ";
                                    }
                                }
                            });
                            textAct = textAct.substring(0, textAct.length - 2);
                            if (count_act === 0) {
                                $("#lblSelectSecund_03").append("<b>--Todas las Acciones de Inversión--</b> <b>|</b> <b>--Todas las Obras--</b>");
                            } else {
                                $("#lblSelectSecund_03").append(textAct + " <b>|</b> <b>--Todas las Acciones de Inversión--</b> <b>|</b> <b>--Todas las Obras--</b>");
                            }
                        } else if ($("input[name=filtro_act_03]").not(":checked") && $("input[name=filtro_inv_03]").not(":checked")) {
                            var count_act = 0;
                            var count_inv = 0;
                            var textAct = "<b>Actividades: </b>";
                            var textInv = "<b>Acciones de Inversión: </b>";
                            $("input[name=filtro_03]").each(function () {
                                if (this.checked) {
                                    if (this.value.charAt(0) === "4") {
                                        count_act++;
                                        textAct += this.value + ", ";
                                    }
                                    if (this.value.charAt(0) === "5") {
                                        count_inv++;
                                        textInv += this.value + ", ";
                                    }
                                }
                            });
                            textAct = textAct.substring(0, textAct.length - 2);
                            textInv = textInv.substring(0, textInv.length - 2);
                            if (count_act === 0 && count_inv !== 0) {
                                $("#lblSelectSecund_03").append(textInv + " <b>|</b> <b>--Todas las Obras--</b>");
                            } else if (count_act !== 0 && count_inv === 0) {
                                $("#lblSelectSecund_03").append(textAct + " <b>|</b> <b>--Todas las Obras--</b>");
                            } else if (count_act === 0 && count_inv === 0) {
                                $("#lblSelectSecund_03").append("<b>--Todas las Obras--</b>");
                            }
                        }
                    } else {
                        $("input[name=filtro_03]").each(function () {
                            if (this.value.charAt(0) === "6") {
                                $("input[value=" + this.value + "]").prop("checked", false);
                            }
                        });
                        $("input[name=filtro_todo_03]").prop("checked", false);
                        if ($("input[name=filtro_act_03]").is(":checked") && $("input[name=filtro_inv_03]").is(":checked")) {
                            $("#lblSelectSecund_03").append("<b>--Todas las Actividades--</b> <b>|</b> <b>--Todas las Acciones de Inversión--</b>");
                        } else if ($("input[name=filtro_act_03]").is(":checked") && $("input[name=filtro_inv_03]").not(":checked")) {
                            var count_inv = 0;
                            var textInv = "<b>Acciones de Inversión: </b>";
                            $("input[name=filtro_03]").each(function () {
                                if (this.checked) {
                                    if (this.value.charAt(0) === "5") {
                                        count_inv++;
                                        textInv += this.value + ", ";
                                    }
                                }
                            });
                            textInv = textInv.substring(0, textInv.length - 2);
                            if (count_inv === 0) {
                                $("#lblSelectSecund_03").append("<b>--Todas las Actividades--</b>");
                            } else {
                                $("#lblSelectSecund_03").append("<b>--Todas las Actividades--</b> <b>|</b> " + textInv);
                            }
                        } else if ($("input[name=filtro_act_03]").not(":checked") && $("input[name=filtro_inv_03]").is(":checked")) {
                            var count_act = 0;
                            var textAct = "<b>Actividades: </b>";
                            $("input[name=filtro_03]").each(function () {
                                if (this.checked) {
                                    if (this.value.charAt(0) === "4") {
                                        count_act++;
                                        textAct += this.value + ", ";
                                    }
                                }
                            });
                            textAct = textAct.substring(0, textAct.length - 2);
                            if (count_act === 0) {
                                $("#lblSelectSecund_03").append("<b>--Todas las Acciones de Inversión--</b>");
                            } else {
                                $("#lblSelectSecund_03").append(textAct + " <b>|</b> <b>--Todas las Acciones de Inversión--</b>");
                            }
                        } else if ($("input[name=filtro_act_03]").not(":checked") && $("input[name=filtro_inv_03]").not(":checked")) {
                            var count_act = 0;
                            var count_inv = 0;
                            var textAct = "<b>Actividades: </b>";
                            var textInv = "<b>Acciones de Inversión: </b>";
                            $("input[name=filtro_03]").each(function () {
                                if (this.checked) {
                                    if (this.value.charAt(0) === "4") {
                                        count_act++;
                                        textAct += this.value + ", ";
                                    }
                                    if (this.value.charAt(0) === "5") {
                                        count_inv++;
                                        textInv += this.value + ", ";
                                    }
                                }
                            });
                            textAct = textAct.substring(0, textAct.length - 2);
                            textInv = textInv.substring(0, textInv.length - 2);
                            if (count_act === 0 && count_inv !== 0) {
                                $("#lblSelectSecund_03").append(textInv);
                            } else if (count_act !== 0 && count_inv === 0) {
                                $("#lblSelectSecund_03").append(textAct);
                            } else if (count_act === 0 && count_inv === 0) {
                                $("#lblSelectSecund_03").append("<b style='color: orangered;'>--Ninguno--</b>");
                            }
                        }
                    }
                });
                $("input[name=filtro_03]").change(function () {
                    $("#lblSelectSecund_03").empty();
                    if (this.checked === false) {
                        $("input[name=filtro_todo_03]").prop("checked", false);
                        if (this.value.charAt(0) === "4") {
                            $("input[name=filtro_act_03]").prop("checked", false);
                        }
                        if (this.value.charAt(0) === "5") {
                            $("input[name=filtro_inv_03]").prop("checked", false);
                        }
                        if (this.value.charAt(0) === "6") {
                            $("input[name=filtro_obra_03]").prop("checked", false);
                        }
                    }
                    var count = 0;
                    var count_act = 0;
                    var count_inv = 0;
                    var count_obra = 0;
                    var text;
                    var textAct = "<b>Actividades: </b>";
                    var textInv = "<b>Acciones de Inversión: </b>";
                    var textObra = "<b>Obras: </b>";
                    $("input[name=filtro_03]").each(function () {
                        if (this.checked) {
                            count++;
                            if (this.value.charAt(0) === "4") {
                                count_act++;
                                textAct += this.value + ", ";
                            }
                            if (this.value.charAt(0) === "5") {
                                count_inv++;
                                textInv += this.value + ", ";
                            }
                            if (this.value.charAt(0) === "6") {
                                count_obra++;
                                textObra += this.value + ", ";
                            }
                        }
                    });
                    textAct = textAct.substring(0, textAct.length - 2);
                    textInv = textInv.substring(0, textInv.length - 2);
                    textObra = textObra.substring(0, textObra.length - 2);
                    if (count_act === size_act) {
                        textAct = "<b>--Todas las Actividades--</b>";
                        $("input[name=filtro_act_03]").prop("checked", true);
                    }
                    if (count_inv === size_inv) {
                        textInv = "<b>--Todas las Acciones de Inversión--</b>";
                        $("input[name=filtro_inv_03]").prop("checked", true);
                    }
                    if (count_obra === size_obra) {
                        textObra = "<b>--Todas las Obras--</b>";
                        $("input[name=filtro_obra_03]").prop("checked", true);
                    }
                    text = textAct + " <b>|</b> " + textInv + " <b>|</b> " + textObra;
                    if (count_act === 0 && count_inv !== 0 && count_obra !== 0) {
                        text = textInv + " <b>|</b> " + textObra;
                    }
                    if (count_act !== 0 && count_inv === 0 && count_obra !== 0) {
                        text = textAct + " <b>|</b> " + textObra;
                    }
                    if (count_act !== 0 && count_inv !== 0 && count_obra === 0) {
                        text = textAct + " <b>|</b> " + textInv;
                    }
                    if (count_act === 0 && count_inv === 0 && count_obra !== 0) {
                        text = textObra;
                    }
                    if (count_act !== 0 && count_inv === 0 && count_obra === 0) {
                        text = textAct;
                    }
                    if (count_act === 0 && count_inv !== 0 && count_obra === 0) {
                        text = textInv;
                    }
                    if (count === size) {
                        text = "<b>--Todos--</b>";
                        $("input[name=filtro_todo_03]").prop("checked", true);
                        $("input[name=filtro_act_03]").prop("checked", true);
                        $("input[name=filtro_inv_03]").prop("checked", true);
                        $("input[name=filtro_obra_03]").prop("checked", true);
                    }
                    if (count === 0) {
                        text = "<b style='color: orangered;'>--Ninguno--</b>";
                    }
                    $("#lblSelectSecund_03").append(text);
                });
            } else {
                $("input[name=filtro_todo_" + val + "]").change(function () {
                    $("#lblSelectSecund_" + val).empty();
                    if (this.checked) {
                        $("#lblSelectSecund_" + val).append("<b>--Todas--</b>");
                        $("input[name=filtro_" + val + "]").prop("checked", true);
                        if (val === "06") {
                            llenarTipoRecurso02(ejec, año, "");
                        }
                        if (val === "14") {
                            llenarDistrito02(ejec, año, "");
                        }
                    }
                    if (this.checked === false) {
                        $("#lblSelectSecund_" + val).append("<b style='color: orangered;'>--Ninguno--</b>");
                        $("input[name=filtro_" + val + "]").prop("checked", false);
                        if (val === "06") {
                            $("#divFiltSecund_21").remove();
                        }
                        if (val === "14") {
                            $("#divFiltSecund_20").remove();
                        }
                    }
                });
                $("input[name=filtro_" + val + "]").change(function () {
                    $("#lblSelectSecund_" + val).empty();
                    if (this.checked === false) {
                        $("input[name=filtro_todo_" + val + "]").prop("checked", false);
                    }
                    var count = 0;
                    var array = "";
                    var text = "";
                    $("input[name=filtro_" + val + "]").each(function () {
                        if (this.checked) {
                            count++;
                            array += "&array=" + this.value;
                            if (val === "14" || val === "22") {
                                text += this.id + ", ";
                            } else {
                                text += this.value + ", ";
                            }
                        }
                    });
                    text = "<b>" + text.substring(0, text.length - 2) + "</b>";
                    if (count === size) {
                        text = "<b>--Todas--</b>";
                        $("input[name=filtro_todo_" + val + "]").prop("checked", true);
                    }
                    if (count === 0) {
                        text = "<b style='color: orangered;'>--Ninguno--</b>";
                    }
                    if (val === "06") {
                        if (count === size) {
                            llenarTipoRecurso02(ejec, año, "");
                        } else {
                            llenarTipoRecurso02(ejec, año, array);
                        }
                    }
                    if (val === "14") {
                        if (count === size) {
                            llenarDistrito02(ejec, año, "");
                        } else {
                            llenarDistrito02(ejec, año, array);
                        }
                    }
                    $("#lblSelectSecund_" + val).append(text);
                });
            }
        }
    });
}

function llenarFiltPrinc02(val, año, ejec, valM) {
    if (val === "15") {
        if (valM === "00") {
            $("#divFiltSecunMensual").empty();
        } else {
            $("#ulFiltSecundMensual_" + valM).empty();
            $.ajax({
                dataType: 'json',
                url: "./GsonData?url=DataFiltrosMensual&ejec=" + ejec + "&año=" + año + "&val=" + valM,
                success: function (response) {
                    $.each(response.list, function (index, value) {
                        var objeM2 = '<li><label class="custom-control custom-checkbox">\
                                        <input id="' + value.nombre + '" type="checkbox" class="custom-control-input" value="' + value.codigo + '" name="filtro_' + response.val + '">\
                                        <span class="custom-control-indicator"></span>&nbsp;\
                                        <span id="spanMensual_' + value.codigo + '" class="custom-control-description"><b>' + value.codigo + "</b> - " + value.nombre + '</span>\
                                      </label></li>';
                        $("#ulFiltSecundMensual_" + response.val).append(objeM2);
                    });
                    $("#ulFiltSecundMensual_" + response.val + " input").change(function () {
                        $("#ulFiltSecundMensual_" + response.val + " input").prop("checked", false);
                        $("#ulFiltSecundMensual_" + response.val + " input[value='" + this.value + "']").prop("checked", true);
                        mensual_id = this.value;
                        mensual_nombre = this.id;
                    });
                }
            });
        }
    } else {
        $("#ulFiltPrim").empty();
        $.ajax({
            dataType: 'json',
            url: "./GsonData?url=DataFiltros&ejec=" + ejec + "&año=" + año + "&val=" + val,
            success: function (response) {
                var obje1 = '';
                if (val === "02") {
                    obje1 += '<li><label class="custom-control custom-checkbox">\
                                <input type="checkbox" class="custom-control-input" value="total_todo" name="total_todo">\
                                <span class="custom-control-indicator"></span>&nbsp;\
                                <span class="custom-control-description"><b>--Totalizado--</b></span>\
                              </label></li>\
                              <li><label class="custom-control custom-checkbox">\
                                <input type="checkbox" class="custom-control-input" value="total_proy" name="total_proy">\
                                <span class="custom-control-indicator"></span>&nbsp;\
                                <span class="custom-control-description"><b>--Totalizado de Proyectos--</b></span>\
                              </label></li>\
                              <li><label class="custom-control custom-checkbox">\
                                <input type="checkbox" class="custom-control-input" value="total_prod" name="total_prod">\
                                <span class="custom-control-indicator"></span>&nbsp;\
                                <span class="custom-control-description"><b>--Totalizado de Productos--</b></span>\
                              </label></li>\
                              <li style="padding-top: 6px; border-top: 1px solid #606060;"><label class="custom-control custom-checkbox">\
                                <input type="checkbox" class="custom-control-input" value="todo" name="filtro_todo">\
                                <span class="custom-control-indicator"></span>&nbsp;\
                                <span class="custom-control-description"><b>--Todos--</b></span>\
                              </label></li>\
                              <li><label class="custom-control custom-checkbox">\
                                <input type="checkbox" class="custom-control-input" value="todo" name="filtro_proy">\
                                <span class="custom-control-indicator"></span>&nbsp;\
                                <span class="custom-control-description"><b>--Proyectos--</b></span>\
                              </label></li>\
                              <li><label class="custom-control custom-checkbox">\
                                <input type="checkbox" class="custom-control-input" value="todo" name="filtro_prod">\
                                <span class="custom-control-indicator"></span>&nbsp;\
                                <span class="custom-control-description"><b>--Productos--</b></span>\
                              </label></li>';
                } else if (val === "03") {
                    obje1 += '<li><label class="custom-control custom-checkbox">\
                                <input type="checkbox" class="custom-control-input" value="total_todo" name="total_todo">\
                                <span class="custom-control-indicator"></span>&nbsp;\
                                <span class="custom-control-description"><b>--Totalizado--</b></span>\
                              </label></li>\
                              <li><label class="custom-control custom-checkbox">\
                                <input type="checkbox" class="custom-control-input" value="total_act" name="total_act">\
                                <span class="custom-control-indicator"></span>&nbsp;\
                                <span class="custom-control-description"><b>--Totalizado de Actividades--</b></span>\
                              </label></li>\
                              <li><label class="custom-control custom-checkbox">\
                                <input type="checkbox" class="custom-control-input" value="total_inv" name="total_inv">\
                                <span class="custom-control-indicator"></span>&nbsp;\
                                <span class="custom-control-description"><b>--Totalizado de Acciones Inversión--</b></span>\
                              </label></li>\
                              <li><label class="custom-control custom-checkbox">\
                                <input type="checkbox" class="custom-control-input" value="total_obra" name="total_obra">\
                                <span class="custom-control-indicator"></span>&nbsp;\
                                <span class="custom-control-description"><b>--Totalizado de Obras--</b></span>\
                              </label></li>\
                              <li style="padding-top: 6px; border-top: 1px solid #606060;"><label class="custom-control custom-checkbox">\
                                <input type="checkbox" class="custom-control-input" value="todo" name="filtro_todo">\
                                <span class="custom-control-indicator"></span>&nbsp;\
                                <span class="custom-control-description"><b>--Todas--</b></span>\
                              </label></li>\
                              <li><label class="custom-control custom-checkbox">\
                                <input type="checkbox" class="custom-control-input" value="todo" name="filtro_act">\
                                <span class="custom-control-indicator"></span>&nbsp;\
                                <span class="custom-control-description"><b>--Actividades--</b></span>\
                              </label></li>\
                              <li><label class="custom-control custom-checkbox">\
                                <input type="checkbox" class="custom-control-input" value="todo" name="filtro_inv">\
                                <span class="custom-control-indicator"></span>&nbsp;\
                                <span class="custom-control-description"><b>--Acciones Inversión--</b></span>\
                              </label></li>\
                              <li><label class="custom-control custom-checkbox">\
                                <input type="checkbox" class="custom-control-input" value="todo" name="filtro_obra">\
                                <span class="custom-control-indicator"></span>&nbsp;\
                                <span class="custom-control-description"><b>--Obras--</b></span>\
                              </label></li>';
                } else {
                    obje1 += '<li><label class="custom-control custom-checkbox">\
                                <input type="checkbox" class="custom-control-input" value="todo" name="filtro_todo">\
                                <span class="custom-control-indicator"></span>&nbsp;\
                                <span class="custom-control-description"><b>--Todas--</b></span>\
                              </label></li>';
                }
                $("#ulFiltPrim").append(obje1);
                var size = 0;
                if (val !== "00") {
                    $.each(response.list, function (index, value) {
                        size++;
                        var obje2 = '';
                        if (val === "14") {
                            obje2 = '<li><label class="custom-control custom-checkbox">\
                                        <input id="' + value.nombre + '" type="checkbox" class="custom-control-input" value="' + value.codigo + '" name="filtro">\
                                        <span class="custom-control-indicator"></span>&nbsp;\
                                        <span class="custom-control-description"><b>' + value.codigo + "</b> - " + value.nombre + '</span>\
                                     </label></li>';
                        } else if (val === "22") {
                            obje2 = '<li><label class="custom-control custom-checkbox">\
                                        <input id="' + value.nombre + '" type="checkbox" class="custom-control-input" value="' + value.ceco_id + '" name="filtro">\
                                        <span class="custom-control-indicator"></span>&nbsp;\
                                        <span class="custom-control-description"><b>' + value.codigo + "</b> - " + value.nombre + '</span>\
                                     </label></li>';
                        } else {
                            obje2 = '<li><label class="custom-control custom-checkbox">\
                                        <input type="checkbox" class="custom-control-input" value="' + value.codigo + '" name="filtro">\
                                        <span class="custom-control-indicator"></span>&nbsp;\
                                        <span class="custom-control-description"><b>' + value.codigo + "</b> - " + value.nombre + '</span>\
                                     </label></li>';
                        }
                        $("#ulFiltPrim").append(obje2);
                    });
                }
                if (val === "02") {
                    $("input[name=total_todo]").change(function () {
                        $("#lblSelectPrinc").empty();
                        $("input[name=filtro_todo]").prop("checked", false);
                        $("input[name=filtro_proy]").prop("checked", false);
                        $("input[name=filtro_prod]").prop("checked", false);
                        $("input[name=filtro]").prop("checked", false);
                        $("input[name=total_proy]").prop("checked", false);
                        $("input[name=total_prod]").prop("checked", false);
                        if (this.checked) {
                            $("#lblSelectPrinc").append("<b>--Totalizado--</b>");
                        } else {
                            $("#lblSelectPrinc").append("<b style='color: orangered;'>--Ninguno--</b>");
                        }
                    });
                    $("input[name=total_proy]").change(function () {
                        $("#lblSelectPrinc").empty();
                        $("input[name=filtro_todo]").prop("checked", false);
                        $("input[name=filtro_proy]").prop("checked", false);
                        $("input[name=filtro_prod]").prop("checked", false);
                        $("input[name=filtro]").prop("checked", false);
                        $("input[name=total_todo]").prop("checked", false);
                        $("input[name=total_prod]").prop("checked", false);
                        if (this.checked) {
                            $("#lblSelectPrinc").append("<b>--Totalizado de Proyectos--</b>");
                        } else {
                            $("#lblSelectPrinc").append("<b style='color: orangered;'>--Ninguno--</b>");
                        }
                    });
                    $("input[name=total_prod]").change(function () {
                        $("#lblSelectPrinc").empty();
                        $("input[name=filtro_todo]").prop("checked", false);
                        $("input[name=filtro_proy]").prop("checked", false);
                        $("input[name=filtro_prod]").prop("checked", false);
                        $("input[name=filtro]").prop("checked", false);
                        $("input[name=total_todo]").prop("checked", false);
                        $("input[name=total_proy]").prop("checked", false);
                        if (this.checked) {
                            $("#lblSelectPrinc").append("<b>--Totalizado de Productos--</b>");
                        } else {
                            $("#lblSelectPrinc").append("<b style='color: orangered;'>--Ninguno--</b>");
                        }
                    });
                    $("input[name=filtro_todo]").change(function () {
                        $("#lblSelectPrinc").empty();
                        $("input[name=total_todo]").prop("checked", false);
                        $("input[name=total_proy]").prop("checked", false);
                        $("input[name=total_prod]").prop("checked", false);
                        if (this.checked) {
                            $("#lblSelectPrinc").append("<b>--Todos--</b>");
                            $("input[name=filtro]").prop("checked", true);
                            $("input[name=filtro_proy]").prop("checked", true);
                            $("input[name=filtro_prod]").prop("checked", true);
                        }
                        if (this.checked === false) {
                            $("#lblSelectPrinc").append("<b style='color: orangered;'>--Ninguno--</b>");
                            $("input[name=filtro]").prop("checked", false);
                            $("input[name=filtro_proy]").prop("checked", false);
                            $("input[name=filtro_prod]").prop("checked", false);
                        }
                    });
                    var size_proy = 0;
                    var size_prod = 0;
                    $("input[name=filtro]").each(function () {
                        if (this.value.charAt(0) === "2") {
                            size_proy++;
                        }
                        if (this.value.charAt(0) === "3") {
                            size_prod++;
                        }
                    });
                    $("input[name=filtro_proy]").change(function () {
                        $("#lblSelectPrinc").empty();
                        $("input[name=total_todo]").prop("checked", false);
                        $("input[name=total_proy]").prop("checked", false);
                        $("input[name=total_prod]").prop("checked", false);
                        if (this.checked) {
                            $("input[name=filtro]").each(function () {
                                if (this.value.charAt(0) === "2") {
                                    $("input[value=" + this.value + "]").prop("checked", true);
                                }
                            });
                            if ($("input[name=filtro_prod]").is(":checked")) {
                                $("#lblSelectPrinc").append("<b>--Todos--</b>");
                                $("input[name=filtro_todo]").prop("checked", true);
                            } else {
                                var count_prod = 0;
                                var textProd = "<b>Productos: </b>";
                                $("input[name=filtro]").each(function () {
                                    if (this.checked) {
                                        if (this.value.charAt(0) === "3") {
                                            count_prod++;
                                            textProd += this.value + ", ";
                                        }
                                    }
                                });
                                textProd = textProd.substring(0, textProd.length - 2);
                                if (count_prod === 0) {
                                    $("#lblSelectPrinc").append("<b>--Todos los Proyectos--</b>");
                                } else {
                                    $("#lblSelectPrinc").append("<b>--Todos los Proyectos--</b> <b>|</b> " + textProd);
                                }
                            }
                        } else {
                            $("input[name=filtro]").each(function () {
                                if (this.value.charAt(0) === "2") {
                                    $("input[value=" + this.value + "]").prop("checked", false);
                                }
                            });
                            $("input[name=filtro_todo]").prop("checked", false);
                            if ($("input[name=filtro_prod]").is(":checked")) {
                                $("#lblSelectPrinc").append("<b>--Todos los Productos--</b>");
                            } else {
                                var count_prod = 0;
                                var textProd = "<b>Productos: </b>";
                                $("input[name=filtro]").each(function () {
                                    if (this.checked) {
                                        if (this.value.charAt(0) === "3") {
                                            count_prod++;
                                            textProd += this.value + ", ";
                                        }
                                    }
                                });
                                textProd = textProd.substring(0, textProd.length - 2);
                                if (count_prod === 0) {
                                    $("#lblSelectPrinc").append("<b style='color: orangered;'>--Ninguno--</b>");
                                } else {
                                    $("#lblSelectPrinc").append(textProd);
                                }
                            }
                        }
                    });
                    $("input[name=filtro_prod]").change(function () {
                        $("#lblSelectPrinc").empty();
                        $("input[name=total_todo]").prop("checked", false);
                        $("input[name=total_proy]").prop("checked", false);
                        $("input[name=total_prod]").prop("checked", false);
                        if (this.checked) {
                            $("input[name=filtro]").each(function () {
                                if (this.value.charAt(0) === "3") {
                                    $("input[value=" + this.value + "]").prop("checked", true);
                                }
                            });
                            if ($("input[name=filtro_proy]").is(":checked")) {
                                $("#lblSelectPrinc").append("<b>--Todos--</b>");
                                $("input[name=filtro_todo]").prop("checked", true);
                            } else {
                                var count_proy = 0;
                                var textProy = "<b>Proyectos: </b>";
                                $("input[name=filtro]").each(function () {
                                    if (this.checked) {
                                        if (this.value.charAt(0) === "2") {
                                            count_proy++;
                                            textProy += this.value + ", ";
                                        }
                                    }
                                });
                                textProy = textProy.substring(0, textProy.length - 2);
                                if (count_proy === 0) {
                                    $("#lblSelectPrinc").append("<b>--Todos los Productos--</b>");
                                } else {
                                    $("#lblSelectPrinc").append(textProy + " <b>|</b> <b>--Todos los Productos--</b>");
                                }
                            }
                        } else {
                            $("input[name=filtro]").each(function () {
                                if (this.value.charAt(0) === "3") {
                                    $("input[value=" + this.value + "]").prop("checked", false);
                                }
                            });
                            $("input[name=filtro_todo]").prop("checked", false);
                            if ($("input[name=filtro_proy]").is(":checked")) {
                                $("#lblSelectPrinc").append("<b>--Todos los Proyectos--</b>");
                            } else {
                                var count_proy = 0;
                                var textProy = "<b>Proyectos: </b>";
                                $("input[name=filtro]").each(function () {
                                    if (this.checked) {
                                        if (this.value.charAt(0) === "2") {
                                            count_proy++;
                                            textProy += this.value + ", ";
                                        }
                                    }
                                });
                                textProy = textProy.substring(0, textProy.length - 2);
                                if (count_proy === 0) {
                                    $("#lblSelectPrinc").append("<b style='color: orangered;'>--Ninguno--</b>");
                                } else {
                                    $("#lblSelectPrinc").append(textProy);
                                }
                            }
                        }
                    });
                    $("input[name=filtro]").change(function () {
                        $("#lblSelectPrinc").empty();
                        $("input[name=total_todo]").prop("checked", false);
                        $("input[name=total_proy]").prop("checked", false);
                        $("input[name=total_prod]").prop("checked", false);
                        if (this.checked === false) {
                            $("input[name=filtro_todo]").prop("checked", false);
                            if (this.value.charAt(0) === "2") {
                                $("input[name=filtro_proy]").prop("checked", false);
                            }
                            if (this.value.charAt(0) === "3") {
                                $("input[name=filtro_prod]").prop("checked", false);
                            }
                        }
                        var count = 0;
                        var count_proy = 0;
                        var count_prod = 0;
                        var text;
                        var textProy = "<b>Proyectos: </b>";
                        var textProd = "<b>Productos: </b>";
                        $("input[name=filtro]").each(function () {
                            if (this.checked) {
                                count++;
                                if (this.value.charAt(0) === "2") {
                                    count_proy++;
                                    textProy += this.value + ", ";
                                }
                                if (this.value.charAt(0) === "3") {
                                    count_prod++;
                                    textProd += this.value + ", ";
                                }
                            }
                        });
                        textProy = textProy.substring(0, textProy.length - 2);
                        textProd = textProd.substring(0, textProd.length - 2);
                        if (count_proy === size_proy) {
                            textProy = "<b>--Todos los Proyectos--</b>";
                            $("input[name=filtro_proy]").prop("checked", true);
                        }
                        if (count_prod === size_prod) {
                            textProd = "<b>--Todos los Productos--</b>";
                            $("input[name=filtro_prod]").prop("checked", true);
                        }
                        text = textProy + " <b>|</b> " + textProd;
                        if (count_proy === 0) {
                            text = textProd;
                        }
                        if (count_prod === 0) {
                            text = textProy;
                        }
                        if (count === size) {
                            text = "<b>--Todos--</b>";
                            $("input[name=filtro_todo]").prop("checked", true);
                            $("input[name=filtro_proy]").prop("checked", true);
                            $("input[name=filtro_prod]").prop("checked", true);
                        }
                        if (count === 0) {
                            text = "<b style='color: orangered;'>--Ninguno--</b>";
                        }
                        $("#lblSelectPrinc").append(text);
                    });
                } else if (val === "03") {
                    $("input[name=total_todo]").change(function () {
                        $("#lblSelectPrinc").empty();
                        $("input[name=filtro_todo]").prop("checked", false);
                        $("input[name=filtro_act]").prop("checked", false);
                        $("input[name=filtro_inv]").prop("checked", false);
                        $("input[name=filtro_obra]").prop("checked", false);
                        $("input[name=filtro]").prop("checked", false);
                        $("input[name=total_act]").prop("checked", false);
                        $("input[name=total_inv]").prop("checked", false);
                        $("input[name=total_obra]").prop("checked", false);
                        if (this.checked) {
                            $("#lblSelectPrinc").append("<b>--Totalizado--</b>");
                        } else {
                            $("#lblSelectPrinc").append("<b style='color: orangered;'>--Ninguno--</b>");
                        }
                    });
                    $("input[name=total_act]").change(function () {
                        $("#lblSelectPrinc").empty();
                        $("input[name=filtro_todo]").prop("checked", false);
                        $("input[name=filtro_act]").prop("checked", false);
                        $("input[name=filtro_inv]").prop("checked", false);
                        $("input[name=filtro_obra]").prop("checked", false);
                        $("input[name=filtro]").prop("checked", false);
                        $("input[name=total_todo]").prop("checked", false);
                        $("input[name=total_inv]").prop("checked", false);
                        $("input[name=total_obra]").prop("checked", false);
                        if (this.checked) {
                            $("#lblSelectPrinc").append("<b>--Totalizado de Actividades--</b>");
                        } else {
                            $("#lblSelectPrinc").append("<b style='color: orangered;'>--Ninguno--</b>");
                        }
                    });
                    $("input[name=total_inv]").change(function () {
                        $("#lblSelectPrinc").empty();
                        $("input[name=filtro_todo]").prop("checked", false);
                        $("input[name=filtro_act]").prop("checked", false);
                        $("input[name=filtro_inv]").prop("checked", false);
                        $("input[name=filtro_obra]").prop("checked", false);
                        $("input[name=filtro]").prop("checked", false);
                        $("input[name=total_todo]").prop("checked", false);
                        $("input[name=total_act]").prop("checked", false);
                        $("input[name=total_obra]").prop("checked", false);
                        if (this.checked) {
                            $("#lblSelectPrinc").append("<b>--Totalizado de Acciones de Inversión--</b>");
                        } else {
                            $("#lblSelectPrinc").append("<b style='color: orangered;'>--Ninguno--</b>");
                        }
                    });
                    $("input[name=total_obra]").change(function () {
                        $("#lblSelectPrinc").empty();
                        $("input[name=filtro_todo]").prop("checked", false);
                        $("input[name=filtro_act]").prop("checked", false);
                        $("input[name=filtro_inv]").prop("checked", false);
                        $("input[name=filtro_obra]").prop("checked", false);
                        $("input[name=filtro]").prop("checked", false);
                        $("input[name=total_todo]").prop("checked", false);
                        $("input[name=total_act]").prop("checked", false);
                        $("input[name=total_inv]").prop("checked", false);
                        if (this.checked) {
                            $("#lblSelectPrinc").append("<b>--Totalizado de Obras--</b>");
                        } else {
                            $("#lblSelectPrinc").append("<b style='color: orangered;'>--Ninguno--</b>");
                        }
                    });
                    $("input[name=filtro_todo]").change(function () {
                        $("#lblSelectPrinc").empty();
                        $("input[name=total_todo]").prop("checked", false);
                        $("input[name=total_act]").prop("checked", false);
                        $("input[name=total_inv]").prop("checked", false);
                        $("input[name=total_obra]").prop("checked", false);
                        if (this.checked) {
                            $("#lblSelectPrinc").append("<b>--Todas--</b>");
                            $("input[name=filtro]").prop("checked", true);
                            $("input[name=filtro_act]").prop("checked", true);
                            $("input[name=filtro_inv]").prop("checked", true);
                            $("input[name=filtro_obra]").prop("checked", true);
                        }
                        if (this.checked === false) {
                            $("#lblSelectPrinc").append("<b style='color: orangered;'>--Ninguno--</b>");
                            $("input[name=filtro]").prop("checked", false);
                            $("input[name=filtro_act]").prop("checked", false);
                            $("input[name=filtro_inv]").prop("checked", false);
                            $("input[name=filtro_obra]").prop("checked", false);
                        }
                    });
                    var size_act = 0;
                    var size_inv = 0;
                    var size_obra = 0;
                    $("input[name=filtro]").each(function () {
                        if (this.value.charAt(0) === "4") {
                            size_act++;
                        }
                        if (this.value.charAt(0) === "5") {
                            size_inv++;
                        }
                        if (this.value.charAt(0) === "6") {
                            size_obra++;
                        }
                    });
                    $("input[name=filtro_act]").change(function () {
                        $("#lblSelectPrinc").empty();
                        $("input[name=total_todo]").prop("checked", false);
                        $("input[name=total_act]").prop("checked", false);
                        $("input[name=total_inv]").prop("checked", false);
                        $("input[name=total_obra]").prop("checked", false);
                        if (this.checked) {
                            $("input[name=filtro]").each(function () {
                                if (this.value.charAt(0) === "4") {
                                    $("input[value=" + this.value + "]").prop("checked", true);
                                }
                            });
                            if ($("input[name=filtro_inv]").is(":checked") && $("input[name=filtro_obra]").is(":checked")) {
                                $("#lblSelectPrinc").append("<b>--Todos--</b>");
                                $("input[name=filtro_todo]").prop("checked", true);
                            } else if ($("input[name=filtro_inv]").is(":checked") && $("input[name=filtro_obra]").not(":checked")) {
                                var count_obra = 0;
                                var textObra = "<b>Obras: </b>";
                                $("input[name=filtro]").each(function () {
                                    if (this.checked) {
                                        if (this.value.charAt(0) === "6") {
                                            count_obra++;
                                            textObra += this.value + ", ";
                                        }
                                    }
                                });
                                textObra = textObra.substring(0, textObra.length - 2);
                                if (count_obra === 0) {
                                    $("#lblSelectPrinc").append("<b>--Todas las Actividades--</b> <b>|</b> <b>--Todas las Acciones de Inversión--</b>");
                                } else {
                                    $("#lblSelectPrinc").append("<b>--Todas las Actividades--</b> <b>|</b> <b>--Todas las Acciones de Inversión--</b> <b>|</b> " + textObra);
                                }
                            } else if ($("input[name=filtro_inv]").not(":checked") && $("input[name=filtro_obra]").is(":checked")) {
                                var count_inv = 0;
                                var textInv = "<b>Acciones de Inversión: </b>";
                                $("input[name=filtro]").each(function () {
                                    if (this.checked) {
                                        if (this.value.charAt(0) === "5") {
                                            count_inv++;
                                            textInv += this.value + ", ";
                                        }
                                    }
                                });
                                textInv = textInv.substring(0, textInv.length - 2);
                                if (count_inv === 0) {
                                    $("#lblSelectPrinc").append("<b>--Todas las Actividades--</b> <b>|</b> <b>--Todas las Obras--</b>");
                                } else {
                                    $("#lblSelectPrinc").append("<b>--Todas las Actividades--</b> <b>|</b> " + textInv + " <b>|</b> <b>--Todas las Obras--</b>");
                                }
                            } else if ($("input[name=filtro_inv]").not(":checked") && $("input[name=filtro_obra]").not(":checked")) {
                                var count_inv = 0;
                                var count_obra = 0;
                                var textInv = "<b>Acciones de Inversión: </b>";
                                var textObra = "<b>Obras: </b>";
                                $("input[name=filtro]").each(function () {
                                    if (this.checked) {
                                        if (this.value.charAt(0) === "5") {
                                            count_inv++;
                                            textInv += this.value + ", ";
                                        }
                                        if (this.value.charAt(0) === "6") {
                                            count_obra++;
                                            textObra += this.value + ", ";
                                        }
                                    }
                                });
                                textInv = textInv.substring(0, textInv.length - 2);
                                textObra = textObra.substring(0, textObra.length - 2);
                                if (count_inv === 0 && count_obra !== 0) {
                                    $("#lblSelectPrinc").append("<b>--Todas las Actividades--</b> <b>|</b> " + textObra);
                                } else if (count_inv !== 0 && count_obra === 0) {
                                    $("#lblSelectPrinc").append("<b>--Todas las Actividades--</b> <b>|</b> " + textInv);
                                } else if (count_inv === 0 && count_obra === 0) {
                                    $("#lblSelectPrinc").append("<b>--Todas las Actividades--</b>");
                                }
                            }
                        } else {
                            $("input[name=filtro]").each(function () {
                                if (this.value.charAt(0) === "4") {
                                    $("input[value=" + this.value + "]").prop("checked", false);
                                }
                            });
                            $("input[name=filtro_todo]").prop("checked", false);
                            if ($("input[name=filtro_inv]").is(":checked") && $("input[name=filtro_obra]").is(":checked")) {
                                $("#lblSelectPrinc").append("<b>--Todas las Acciones de Inversión--</b> <b>|</b> <b>--Todas las Obras--</b>");
                            } else if ($("input[name=filtro_inv]").is(":checked") && $("input[name=filtro_obra]").not(":checked")) {
                                var count_obra = 0;
                                var textObra = "<b>Obras: </b>";
                                $("input[name=filtro]").each(function () {
                                    if (this.checked) {
                                        if (this.value.charAt(0) === "6") {
                                            count_obra++;
                                            textObra += this.value + ", ";
                                        }
                                    }
                                });
                                textObra = textObra.substring(0, textObra.length - 2);
                                if (count_obra === 0) {
                                    $("#lblSelectPrinc").append("<b>--Todas las Acciones de Inversión--</b>");
                                } else {
                                    $("#lblSelectPrinc").append("<b>--Todas las Acciones de Inversión--</b> <b>|</b> " + textObra);
                                }
                            } else if ($("input[name=filtro_inv]").not(":checked") && $("input[name=filtro_obra]").is(":checked")) {
                                var count_inv = 0;
                                var textInv = "<b>Acciones de Inversión: </b>";
                                $("input[name=filtro]").each(function () {
                                    if (this.checked) {
                                        if (this.value.charAt(0) === "5") {
                                            count_inv++;
                                            textInv += this.value + ", ";
                                        }
                                    }
                                });
                                textInv = textInv.substring(0, textInv.length - 2);
                                if (count_inv === 0) {
                                    $("#lblSelectPrinc").append("<b>--Todas las Obras--</b>");
                                } else {
                                    $("#lblSelectPrinc").append(textInv + " <b>|</b> <b>--Todas las Obras--</b>");
                                }
                            } else if ($("input[name=filtro_inv]").not(":checked") && $("input[name=filtro_obra]").not(":checked")) {
                                var count_inv = 0;
                                var count_obra = 0;
                                var textInv = "<b>Acciones de Inversión: </b>";
                                var textObra = "<b>Obras: </b>";
                                $("input[name=filtro]").each(function () {
                                    if (this.checked) {
                                        if (this.value.charAt(0) === "5") {
                                            count_inv++;
                                            textInv += this.value + ", ";
                                        }
                                        if (this.value.charAt(0) === "6") {
                                            count_obra++;
                                            textObra += this.value + ", ";
                                        }
                                    }
                                });
                                textInv = textInv.substring(0, textInv.length - 2);
                                textObra = textObra.substring(0, textObra.length - 2);
                                if (count_inv === 0 && count_obra !== 0) {
                                    $("#lblSelectPrinc").append(textObra);
                                } else if (count_inv !== 0 && count_obra === 0) {
                                    $("#lblSelectPrinc").append(textInv);
                                } else if (count_inv === 0 && count_obra === 0) {
                                    $("#lblSelectPrinc").append("<b style='color: orangered;'>--Ninguno--</b>");
                                }
                            }
                        }
                    });
                    $("input[name=filtro_inv]").change(function () {
                        $("#lblSelectPrinc").empty();
                        $("input[name=total_todo]").prop("checked", false);
                        $("input[name=total_act]").prop("checked", false);
                        $("input[name=total_inv]").prop("checked", false);
                        $("input[name=total_obra]").prop("checked", false);
                        if (this.checked) {
                            $("input[name=filtro]").each(function () {
                                if (this.value.charAt(0) === "5") {
                                    $("input[value=" + this.value + "]").prop("checked", true);
                                }
                            });
                            if ($("input[name=filtro_act]").is(":checked") && $("input[name=filtro_obra]").is(":checked")) {
                                $("#lblSelectPrinc").append("<b>--Todos--</b>");
                                $("input[name=filtro_todo]").prop("checked", true);
                            } else if ($("input[name=filtro_act]").is(":checked") && $("input[name=filtro_obra]").not(":checked")) {
                                var count_obra = 0;
                                var textObra = "<b>Obras: </b>";
                                $("input[name=filtro]").each(function () {
                                    if (this.checked) {
                                        if (this.value.charAt(0) === "6") {
                                            count_obra++;
                                            textObra += this.value + ", ";
                                        }
                                    }
                                });
                                textObra = textObra.substring(0, textObra.length - 2);
                                if (count_obra === 0) {
                                    $("#lblSelectPrinc").append("<b>--Todas las Actividades--</b> <b>|</b> <b>--Todas las Acciones de Inversión--</b>");
                                } else {
                                    $("#lblSelectPrinc").append("<b>--Todas las Actividades--</b> <b>|</b> <b>--Todas las Acciones de Inversión--</b> <b>|</b> " + textObra);
                                }
                            } else if ($("input[name=filtro_act]").not(":checked") && $("input[name=filtro_obra]").is(":checked")) {
                                var count_act = 0;
                                var textAct = "<b>Actividades: </b>";
                                $("input[name=filtro]").each(function () {
                                    if (this.checked) {
                                        if (this.value.charAt(0) === "4") {
                                            count_act++;
                                            textAct += this.value + ", ";
                                        }
                                    }
                                });
                                textAct = textAct.substring(0, textAct.length - 2);
                                if (count_act === 0) {
                                    $("#lblSelectPrinc").append("<b>--Todas las Acciones de Inversión--</b> <b>|</b> <b>--Todas las Obras--</b>");
                                } else {
                                    $("#lblSelectPrinc").append(textAct + " <b>|</b> <b>--Todas las Acciones de Inversión--</b> <b>|</b> <b>--Todas las Obras--</b>");
                                }
                            } else if ($("input[name=filtro_act]").not(":checked") && $("input[name=filtro_obra]").not(":checked")) {
                                var count_act = 0;
                                var count_obra = 0;
                                var textAct = "<b>Actividades: </b>";
                                var textObra = "<b>Obras: </b>";
                                $("input[name=filtro]").each(function () {
                                    if (this.checked) {
                                        if (this.value.charAt(0) === "4") {
                                            count_act++;
                                            textAct += this.value + ", ";
                                        }
                                        if (this.value.charAt(0) === "6") {
                                            count_obra++;
                                            textObra += this.value + ", ";
                                        }
                                    }
                                });
                                textAct = textAct.substring(0, textAct.length - 2);
                                textObra = textObra.substring(0, textObra.length - 2);
                                if (count_act === 0 && count_obra !== 0) {
                                    $("#lblSelectPrinc").append("<b>--Todas las Acciones de Inversión--</b> <b>|</b> " + textObra);
                                } else if (count_act !== 0 && count_obra === 0) {
                                    $("#lblSelectPrinc").append(textAct + " <b>|</b> <b>--Todas las Acciones de Inversión--</b>");
                                } else if (count_act === 0 && count_obra === 0) {
                                    $("#lblSelectPrinc").append("<b>--Todas las Acciones de Inversión--</b>");
                                }
                            }
                        } else {
                            $("input[name=filtro]").each(function () {
                                if (this.value.charAt(0) === "5") {
                                    $("input[value=" + this.value + "]").prop("checked", false);
                                }
                            });
                            $("input[name=filtro_todo]").prop("checked", false);
                            if ($("input[name=filtro_act]").is(":checked") && $("input[name=filtro_obra]").is(":checked")) {
                                $("#lblSelectPrinc").append("<b>--Todas las Actividades--</b> <b>|</b> <b>--Todas las Obras--</b>");
                            } else if ($("input[name=filtro_act]").is(":checked") && $("input[name=filtro_obra]").not(":checked")) {
                                var count_obra = 0;
                                var textObra = "<b>Obras: </b>";
                                $("input[name=filtro]").each(function () {
                                    if (this.checked) {
                                        if (this.value.charAt(0) === "6") {
                                            count_obra++;
                                            textObra += this.value + ", ";
                                        }
                                    }
                                });
                                textObra = textObra.substring(0, textObra.length - 2);
                                if (count_obra === 0) {
                                    $("#lblSelectPrinc").append("<b>--Todas las Actividades--</b>");
                                } else {
                                    $("#lblSelectPrinc").append("<b>--Todas las Actividades--</b> <b>|</b> " + textObra);
                                }
                            } else if ($("input[name=filtro_act]").not(":checked") && $("input[name=filtro_obra]").is(":checked")) {
                                var count_act = 0;
                                var textAct = "<b>Actividades: </b>";
                                $("input[name=filtro]").each(function () {
                                    if (this.checked) {
                                        if (this.value.charAt(0) === "4") {
                                            count_act++;
                                            textAct += this.value + ", ";
                                        }
                                    }
                                });
                                textAct = textAct.substring(0, textAct.length - 2);
                                if (count_act === 0) {
                                    $("#lblSelectPrinc").append("<b>--Todas las Obras--</b>");
                                } else {
                                    $("#lblSelectPrinc").append(textAct + " <b>|</b> <b>--Todas las Obras--</b>");
                                }
                            } else if ($("input[name=filtro_act]").not(":checked") && $("input[name=filtro_obra]").not(":checked")) {
                                var count_act = 0;
                                var count_obra = 0;
                                var textAct = "<b>Actividades: </b>";
                                var textObra = "<b>Obras: </b>";
                                $("input[name=filtro]").each(function () {
                                    if (this.checked) {
                                        if (this.value.charAt(0) === "4") {
                                            count_act++;
                                            textAct += this.value + ", ";
                                        }
                                        if (this.value.charAt(0) === "6") {
                                            count_obra++;
                                            textObra += this.value + ", ";
                                        }
                                    }
                                });
                                textAct = textAct.substring(0, textAct.length - 2);
                                textObra = textObra.substring(0, textObra.length - 2);
                                if (count_act === 0 && count_obra !== 0) {
                                    $("#lblSelectPrinc").append(textObra);
                                } else if (count_act !== 0 && count_obra === 0) {
                                    $("#lblSelectPrinc").append(textAct);
                                } else if (count_act === 0 && count_obra === 0) {
                                    $("#lblSelectPrinc").append("<b style='color: orangered;'>--Ninguno--</b>");
                                }
                            }
                        }
                    });
                    $("input[name=filtro_obra]").change(function () {
                        $("#lblSelectPrinc").empty();
                        $("input[name=total_todo]").prop("checked", false);
                        $("input[name=total_act]").prop("checked", false);
                        $("input[name=total_inv]").prop("checked", false);
                        $("input[name=total_obra]").prop("checked", false);
                        if (this.checked) {
                            $("input[name=filtro]").each(function () {
                                if (this.value.charAt(0) === "6") {
                                    $("input[value=" + this.value + "]").prop("checked", true);
                                }
                            });
                            if ($("input[name=filtro_act]").is(":checked") && $("input[name=filtro_inv]").is(":checked")) {
                                $("#lblSelectPrinc").append("<b>--Todos--</b>");
                                $("input[name=filtro_todo]").prop("checked", true);
                            } else if ($("input[name=filtro_act]").is(":checked") && $("input[name=filtro_inv]").not(":checked")) {
                                var count_inv = 0;
                                var textInv = "<b>Acciones de Inversión: </b>";
                                $("input[name=filtro]").each(function () {
                                    if (this.checked) {
                                        if (this.value.charAt(0) === "5") {
                                            count_inv++;
                                            textInv += this.value + ", ";
                                        }
                                    }
                                });
                                textInv = textInv.substring(0, textInv.length - 2);
                                if (count_inv === 0) {
                                    $("#lblSelectPrinc").append("<b>--Todas las Actividades--</b> <b>|</b> <b>--Todas las Obras--</b>");
                                } else {
                                    $("#lblSelectPrinc").append("<b>--Todas las Actividades--</b> <b>|</b> " + textInv + " <b>|</b> <b>--Todas las Obras--</b>");
                                }
                            } else if ($("input[name=filtro_act]").not(":checked") && $("input[name=filtro_inv]").is(":checked")) {
                                var count_act = 0;
                                var textAct = "<b>Actividades: </b>";
                                $("input[name=filtro]").each(function () {
                                    if (this.checked) {
                                        if (this.value.charAt(0) === "4") {
                                            count_act++;
                                            textAct += this.value + ", ";
                                        }
                                    }
                                });
                                textAct = textAct.substring(0, textAct.length - 2);
                                if (count_act === 0) {
                                    $("#lblSelectPrinc").append("<b>--Todas las Acciones de Inversión--</b> <b>|</b> <b>--Todas las Obras--</b>");
                                } else {
                                    $("#lblSelectPrinc").append(textAct + " <b>|</b> <b>--Todas las Acciones de Inversión--</b> <b>|</b> <b>--Todas las Obras--</b>");
                                }
                            } else if ($("input[name=filtro_act]").not(":checked") && $("input[name=filtro_inv]").not(":checked")) {
                                var count_act = 0;
                                var count_inv = 0;
                                var textAct = "<b>Actividades: </b>";
                                var textInv = "<b>Acciones de Inversión: </b>";
                                $("input[name=filtro]").each(function () {
                                    if (this.checked) {
                                        if (this.value.charAt(0) === "4") {
                                            count_act++;
                                            textAct += this.value + ", ";
                                        }
                                        if (this.value.charAt(0) === "5") {
                                            count_inv++;
                                            textInv += this.value + ", ";
                                        }
                                    }
                                });
                                textAct = textAct.substring(0, textAct.length - 2);
                                textInv = textInv.substring(0, textInv.length - 2);
                                if (count_act === 0 && count_inv !== 0) {
                                    $("#lblSelectPrinc").append(textInv + " <b>|</b> <b>--Todas las Obras--</b>");
                                } else if (count_act !== 0 && count_inv === 0) {
                                    $("#lblSelectPrinc").append(textAct + " <b>|</b> <b>--Todas las Obras--</b>");
                                } else if (count_act === 0 && count_inv === 0) {
                                    $("#lblSelectPrinc").append("<b>--Todas las Obras--</b>");
                                }
                            }
                        } else {
                            $("input[name=filtro]").each(function () {
                                if (this.value.charAt(0) === "6") {
                                    $("input[value=" + this.value + "]").prop("checked", false);
                                }
                            });
                            $("input[name=filtro_todo]").prop("checked", false);
                            if ($("input[name=filtro_act]").is(":checked") && $("input[name=filtro_inv]").is(":checked")) {
                                $("#lblSelectPrinc").append("<b>--Todas las Actividades--</b> <b>|</b> <b>--Todas las Acciones de Inversión--</b>");
                            } else if ($("input[name=filtro_act]").is(":checked") && $("input[name=filtro_inv]").not(":checked")) {
                                var count_inv = 0;
                                var textInv = "<b>Acciones de Inversión: </b>";
                                $("input[name=filtro]").each(function () {
                                    if (this.checked) {
                                        if (this.value.charAt(0) === "5") {
                                            count_inv++;
                                            textInv += this.value + ", ";
                                        }
                                    }
                                });
                                textInv = textInv.substring(0, textInv.length - 2);
                                if (count_inv === 0) {
                                    $("#lblSelectPrinc").append("<b>--Todas las Actividades--</b>");
                                } else {
                                    $("#lblSelectPrinc").append("<b>--Todas las Actividades--</b> <b>|</b> " + textInv);
                                }
                            } else if ($("input[name=filtro_act]").not(":checked") && $("input[name=filtro_inv]").is(":checked")) {
                                var count_act = 0;
                                var textAct = "<b>Actividades: </b>";
                                $("input[name=filtro]").each(function () {
                                    if (this.checked) {
                                        if (this.value.charAt(0) === "4") {
                                            count_act++;
                                            textAct += this.value + ", ";
                                        }
                                    }
                                });
                                textAct = textAct.substring(0, textAct.length - 2);
                                if (count_act === 0) {
                                    $("#lblSelectPrinc").append("<b>--Todas las Acciones de Inversión--</b>");
                                } else {
                                    $("#lblSelectPrinc").append(textAct + " <b>|</b> <b>--Todas las Acciones de Inversión--</b>");
                                }
                            } else if ($("input[name=filtro_act]").not(":checked") && $("input[name=filtro_inv]").not(":checked")) {
                                var count_act = 0;
                                var count_inv = 0;
                                var textAct = "<b>Actividades: </b>";
                                var textInv = "<b>Acciones de Inversión: </b>";
                                $("input[name=filtro]").each(function () {
                                    if (this.checked) {
                                        if (this.value.charAt(0) === "4") {
                                            count_act++;
                                            textAct += this.value + ", ";
                                        }
                                        if (this.value.charAt(0) === "5") {
                                            count_inv++;
                                            textInv += this.value + ", ";
                                        }
                                    }
                                });
                                textAct = textAct.substring(0, textAct.length - 2);
                                textInv = textInv.substring(0, textInv.length - 2);
                                if (count_act === 0 && count_inv !== 0) {
                                    $("#lblSelectPrinc").append(textInv);
                                } else if (count_act !== 0 && count_inv === 0) {
                                    $("#lblSelectPrinc").append(textAct);
                                } else if (count_act === 0 && count_inv === 0) {
                                    $("#lblSelectPrinc").append("<b style='color: orangered;'>--Ninguno--</b>");
                                }
                            }
                        }
                    });
                    $("input[name=filtro]").change(function () {
                        $("#lblSelectPrinc").empty();
                        $("input[name=total_todo]").prop("checked", false);
                        $("input[name=total_act]").prop("checked", false);
                        $("input[name=total_inv]").prop("checked", false);
                        $("input[name=total_obra]").prop("checked", false);
                        if (this.checked === false) {
                            $("input[name=filtro_todo]").prop("checked", false);
                            if (this.value.charAt(0) === "4") {
                                $("input[name=filtro_act]").prop("checked", false);
                            }
                            if (this.value.charAt(0) === "5") {
                                $("input[name=filtro_inv]").prop("checked", false);
                            }
                            if (this.value.charAt(0) === "6") {
                                $("input[name=filtro_obra]").prop("checked", false);
                            }
                        }
                        var count = 0;
                        var count_act = 0;
                        var count_inv = 0;
                        var count_obra = 0;
                        var text;
                        var textAct = "<b>Actividades: </b>";
                        var textInv = "<b>Acciones de Inversión: </b>";
                        var textObra = "<b>Obras: </b>";
                        $("input[name=filtro]").each(function () {
                            if (this.checked) {
                                count++;
                                if (this.value.charAt(0) === "4") {
                                    count_act++;
                                    textAct += this.value + ", ";
                                }
                                if (this.value.charAt(0) === "5") {
                                    count_inv++;
                                    textInv += this.value + ", ";
                                }
                                if (this.value.charAt(0) === "6") {
                                    count_obra++;
                                    textObra += this.value + ", ";
                                }
                            }
                        });
                        textAct = textAct.substring(0, textAct.length - 2);
                        textInv = textInv.substring(0, textInv.length - 2);
                        textObra = textObra.substring(0, textObra.length - 2);
                        if (count_act === size_act) {
                            textAct = "<b>--Todas las Actividades--</b>";
                            $("input[name=filtro_act]").prop("checked", true);
                        }
                        if (count_inv === size_inv) {
                            textInv = "<b>--Todas las Acciones de Inversión--</b>";
                            $("input[name=filtro_inv]").prop("checked", true);
                        }
                        if (count_obra === size_obra) {
                            textObra = "<b>--Todas las Obras--</b>";
                            $("input[name=filtro_obra]").prop("checked", true);
                        }
                        text = textAct + " <b>|</b> " + textInv + " <b>|</b> " + textObra;
                        if (count_act === 0 && count_inv !== 0 && count_obra !== 0) {
                            text = textInv + " <b>|</b> " + textObra;
                        }
                        if (count_act !== 0 && count_inv === 0 && count_obra !== 0) {
                            text = textAct + " <b>|</b> " + textObra;
                        }
                        if (count_act !== 0 && count_inv !== 0 && count_obra === 0) {
                            text = textAct + " <b>|</b> " + textInv;
                        }
                        if (count_act === 0 && count_inv === 0 && count_obra !== 0) {
                            text = textObra;
                        }
                        if (count_act !== 0 && count_inv === 0 && count_obra === 0) {
                            text = textAct;
                        }
                        if (count_act === 0 && count_inv !== 0 && count_obra === 0) {
                            text = textInv;
                        }
                        if (count === size) {
                            text = "<b>--Todos--</b>";
                            $("input[name=filtro_todo]").prop("checked", true);
                            $("input[name=filtro_act]").prop("checked", true);
                            $("input[name=filtro_inv]").prop("checked", true);
                            $("input[name=filtro_obra]").prop("checked", true);
                        }
                        if (count === 0) {
                            text = "<b style='color: orangered;'>--Ninguno--</b>";
                        }
                        $("#lblSelectPrinc").append(text);
                    });
                } else {
                    $("input[name=filtro_todo]").change(function () {
                        $("#lblSelectPrinc").empty();
                        if (this.checked) {
                            $("#lblSelectPrinc").append("<b>--Todas--</b>");
                            $("input[name=filtro]").prop("checked", true);
                            if (val === "06") {
                                llenarTipoRecurso02(ejec, año, "");
                            }
                            if (val === "14") {
                                llenarDistrito02(ejec, año, "");
                            }
                        }
                        if (this.checked === false) {
                            $("#lblSelectPrinc").append("<b style='color: orangered;'>--Ninguno--</b>");
                            $("input[name=filtro]").prop("checked", false);
                            if (val === "06") {
                                $("#divFiltSecund_21").remove();
                            }
                            if (val === "14") {
                                $("#divFiltSecund_20").remove();
                            }
                        }
                    });
                    $("input[name=filtro]").change(function () {
                        $("#lblSelectPrinc").empty();
                        if (this.checked === false) {
                            $("input[name=filtro_todo]").prop("checked", false);
                        }
                        var count = 0;
                        var array = "";
                        var text = "";
                        $("input[name=filtro]").each(function () {
                            if (this.checked) {
                                count++;
                                array += "&array=" + this.value;
                                if (val === "14" || val === "22") {
                                    text += this.id + ", ";
                                } else {
                                    text += this.value + ", ";
                                }
                            }
                        });
                        text = "<b>" + text.substring(0, text.length - 2) + "</b>";
                        if (count === size) {
                            text = "<b>--Todas--</b>";
                            $("input[name=filtro_todo]").prop("checked", true);
                        }
                        if (count === 0) {
                            text = "<b style='color: orangered;'>--Ninguno--</b>";
                        }
                        if (val === "06") {
                            if (count === size) {
                                llenarTipoRecurso02(ejec, año, "");
                            } else {
                                llenarTipoRecurso02(ejec, año, array);
                            }
                        }
                        if (val === "14") {
                            if (count === size) {
                                llenarDistrito02(ejec, año, "");
                            } else {
                                llenarDistrito02(ejec, año, array);
                            }
                        }
                        $("#lblSelectPrinc").append(text);
                    });
                }
            }
        });
    }
}

function llenarTipoRecurso02(ejec, año, array) {
    $("#divFiltSecund_21").remove();
    tipoRecur = '<div id="divFiltSecund_21" class="form-group row">\
                                <label for="dlFiltSecund_21" class="col-sm-2 col-form-label">Tipo Recurso</label>\
                                <div class="col-sm-10">\
                                    <dl id="dlFiltSecund_21" class="dropdownF">\
                                        <dt>\
                                            <a style="font-weight: normal;">\
                                                <label id="lblSelectTipoRec"><b style="color: orangered;">--Ninguno--</b></label>\
                                                <span class="hida">\
                                                    <i class="fa fa-filter" aria-hidden="true"></i>\
                                                </span>\
                                            </a>\
                                        </dt>\
                                        <dd>\
                                            <div class="mutliSelect">\
                                                <ul id="ulFiltSecund_21"></ul>\
                                            </div>\
                                        </dd>\
                                    </dl>\
                                </div>\
                            </div>';
    $("#divFiltrosSecundarios").append(tipoRecur);
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataTipoRecurso&ejec=" + ejec + "&ciclo=G&año=" + año + array,
        success: function (response) {
            var obje1 = '<li><label class="custom-control custom-checkbox">\
                            <input type="checkbox" class="custom-control-input" value="ninguno" name="tipo_recurso_ninguno" checked>\
                            <span class="custom-control-indicator"></span>&nbsp;\
                            <span class="custom-control-description"><b>--NINGUNO--</b></span>\
                         </label></li>\
                         <li><label class="custom-control custom-checkbox">\
                            <input type="checkbox" class="custom-control-input" value="todo" name="tipo_recurso_todo">\
                            <span class="custom-control-indicator"></span>&nbsp;\
                            <span class="custom-control-description"><b>--TODOS--</b></span>\
                         </label></li>';
            $("#ulFiltSecund_21").append(obje1);
            var size = 0;
            $.each(response.list, function (index, value) {
                size++;
                var obje2 = '<li><label class="custom-control custom-checkbox">\
                                <input type="checkbox" class="custom-control-input" value="' + value.codigo + '" name="tipo_recurso">\
                                <span class="custom-control-indicator"></span>&nbsp;\
                                <span class="custom-control-description"><b>' + value.codigo + "</b> - " + value.nombre + ' <b></span>\
                             </label></li>';
                $("#ulFiltSecund_21").append(obje2);
            });
            $("input[name=tipo_recurso_ninguno]").change(function () {
                $("#lblSelectTipoRec").empty();
                $("#lblSelectTipoRec").append('<b style="color: orangered;">--Ninguno--</b>');
                $("input[name=tipo_recurso_ninguno]").prop("checked", true);
                $("input[name=tipo_recurso_todo]").prop("checked", false);
                $("input[name=tipo_recurso]").prop("checked", false);
            });
            $("input[name=tipo_recurso_todo]").change(function () {
                $("#lblSelectTipoRec").empty();
                if (this.checked) {
                    $("#lblSelectTipoRec").append('<b>--Todos--</b>');
                    $("input[name=tipo_recurso]").prop("checked", true);
                    $("input[name=tipo_recurso_ninguno]").prop("checked", false);
                }
                if (this.checked === false) {
                    $("#lblSelectTipoRec").append('<b style="color: orangered;">--Ninguno--</b>');
                    $("input[name=tipo_recurso]").prop("checked", false);
                    $("input[name=tipo_recurso_ninguno]").prop("checked", true);
                }
            });
            $("input[name=tipo_recurso]").change(function () {
                $("#lblSelectTipoRec").empty();
                $("input[name=tipo_recurso_ninguno]").prop("checked", false);
                if (this.checked === false) {
                    $("input[name=tipo_recurso_todo]").prop("checked", false);
                }
                var count = 0;
                var text = "";
                $("input[name=tipo_recurso]").each(function () {
                    if (this.checked) {
                        count++;
                        text += this.value + ", ";
                    }
                });
                text = "<b>" + text.substring(0, text.length - 2) + "</b>";
                if (count === size) {
                    $("input[name=tipo_recurso_todo]").prop("checked", true);
                    $("input[name=tipo_recurso_ninguno]").prop("checked", false);
                    text = "<b>--Todos--</b>";
                }
                if (count === 0) {
                    $("input[name=tipo_recurso_ninguno]").prop("checked", true);
                    text = '<b style="color: orangered;">--Ninguno--</b>';
                }
                $("#lblSelectTipoRec").append(text);
            });
        }
    });
    var arraySecun = [];
    $("#dlFiltSecun input").each(function () {
        arraySecun.push(this.value);
    });
    var arraySecunMensual = [];
    $("#dlFiltSecunMensual input").each(function () {
        arraySecunMensual.push(this.value);
    });
    $("#dlFiltSecund_21.dropdownF dt a").on('click', function () {
        $("#dlFiltPrinc.dropdownF dd ul").hide();
        $("#dlFiltSecun.dropdownF dd ul").hide();
        $("#dlFiltSecunMensual.dropdownF dd ul").hide();
        $("#dlFiltSecund_20.dropdownF dd ul").hide();
        hidedlFiltSecund(arraySecun, "");
        hidedlFiltSecundMensual(arraySecunMensual, "");
        $("#dlFiltSecund_21.dropdownF dd ul").slideToggle('fast');
    });
    $("#dlFiltSecund_21.dropdownF dd ul li a").on('click', function () {
        $("#dlFiltSecund_21.dropdownF dd ul").hide();
    });
    $(document).bind('click', function (e) {
        var $clicked = $(e.target);
        if (!$clicked.parents().hasClass("dropdownF"))
            $("#dlFiltSecund_21.dropdownF dd ul").hide();
    });
}

function llenarDistrito02(ejec, año, array) {
    $("#divFiltSecund_20").remove();
    distrito = '<div id="divFiltSecund_20" class="form-group row">\
                                <label for="dlFiltSecund_20" class="col-sm-2 col-form-label">Distrito</label>\
                                <div class="col-sm-10">\
                                    <dl id="dlFiltSecund_20" class="dropdownF">\
                                        <dt>\
                                            <a style="font-weight: normal;">\
                                                <label id="lblSelectDistrito"><b style="color: orangered;">--Ninguno--</b></label>\
                                                <span class="hida">\
                                                    <i class="fa fa-filter" aria-hidden="true"></i>\
                                                </span>\
                                            </a>\
                                        </dt>\
                                        <dd>\
                                            <div class="mutliSelect">\
                                                <ul id="ulFiltSecund_20"></ul>\
                                            </div>\
                                        </dd>\
                                    </dl>\
                                </div>\
                            </div>';
    $("#divFiltrosSecundarios").append(distrito);
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataDistrito&ejec=" + ejec + "&año=" + año + array,
        success: function (response) {
            var obje1 = '<li><label class="custom-control custom-checkbox">\
                            <input type="checkbox" class="custom-control-input" value="ninguno" name="distrito_ninguno" checked>\
                            <span class="custom-control-indicator"></span>&nbsp;\
                            <span class="custom-control-description"><b>--NINGUNO--</b></span>\
                         </label></li>\
                         <li><label class="custom-control custom-checkbox">\
                            <input type="checkbox" class="custom-control-input" value="todo" name="distrito_todo">\
                            <span class="custom-control-indicator"></span>&nbsp;\
                            <span class="custom-control-description"><b>--TODOS--</b></span>\
                         </label></li>';
            $("#ulFiltSecund_20").append(obje1);
            var size = 0;
            $.each(response.list, function (index, value) {
                size++;
                var obje2 = '<li><label class="custom-control custom-checkbox">\
                                <input id="' + value.nombre + '" type="checkbox" class="custom-control-input" value="' + value.codigo + '" name="distrito">\
                                <span class="custom-control-indicator"></span>&nbsp;\
                                <span class="custom-control-description"><b>' + value.codigo + "</b> - " + value.nombre + ' <b></span>\
                             </label></li>';
                $("#ulFiltSecund_20").append(obje2);
            });
            $("input[name=distrito_ninguno]").change(function () {
                $("#lblSelectDistrito").empty();
                $("#lblSelectDistrito").append('<b style="color: orangered;">--Ninguno--</b>');
                $("input[name=distrito_ninguno]").prop("checked", true);
                $("input[name=distrito_todo]").prop("checked", false);
                $("input[name=distrito]").prop("checked", false);
            });
            $("input[name=distrito_todo]").change(function () {
                $("#lblSelectDistrito").empty();
                if (this.checked) {
                    $("#lblSelectDistrito").append('<b>--Todos--</b>');
                    $("input[name=distrito]").prop("checked", true);
                    $("input[name=distrito_ninguno]").prop("checked", false);
                }
                if (this.checked === false) {
                    $("#lblSelectDistrito").append('<b style="color: orangered;">--Ninguno--</b>');
                    $("input[name=distrito]").prop("checked", false);
                    $("input[name=distrito_ninguno]").prop("checked", true);
                }
            });
            $("input[name=distrito]").change(function () {
                $("#lblSelectDistrito").empty();
                $("input[name=distrito_ninguno]").prop("checked", false);
                if (this.checked === false) {
                    $("input[name=distrito_todo]").prop("checked", false);
                }
                var count = 0;
                var text = "";
                $("input[name=distrito]").each(function () {
                    if (this.checked) {
                        count++;
                        text += this.id + ", ";
                    }
                });
                text = "<b>" + text.substring(0, text.length - 2) + "</b>";
                if (count === size) {
                    text = "<b>--Todos--</b>";
                    $("input[name=distrito_todo]").prop("checked", true);
                    $("input[name=distrito_ninguno]").prop("checked", false);
                }
                if (count === 0) {
                    text = '<b style="color: orangered;">--Ninguno--</b>';
                    $("input[name=distrito_ninguno]").prop("checked", true);
                }
                $("#lblSelectDistrito").append(text);
            });
        }
    });
    var arraySecun = [];
    $("#dlFiltSecun input").each(function () {
        arraySecun.push(this.value);
    });
    var arraySecunMensual = [];
    $("#dlFiltSecunMensual input").each(function () {
        arraySecunMensual.push(this.value);
    });
    $("#dlFiltSecund_20.dropdownF dt a").on('click', function () {
        $("#dlFiltPrinc.dropdownF dd ul").hide();
        $("#dlFiltSecun.dropdownF dd ul").hide();
        $("#dlFiltSecunMensual.dropdownF dd ul").hide();
        $("#dlFiltSecund_21.dropdownF dd ul").hide();
        hidedlFiltSecund(arraySecun, "");
        hidedlFiltSecundMensual(arraySecunMensual, "");
        $("#dlFiltSecund_20.dropdownF dd ul").slideToggle('fast');
    });
    $("#dlFiltSecund_20.dropdownF dd ul li a").on('click', function () {
        $("#dlFiltSecund_20.dropdownF dd ul").hide();
    });
    $(document).bind('click', function (e) {
        var $clicked = $(e.target);
        if (!$clicked.parents().hasClass("dropdownF"))
            $("#dlFiltSecund_20.dropdownF dd ul").hide();
    });
}

function llenarFiltSecundMensual02(val, año, ejec) {
    $("#lblFiltSecundMensual_" + val).empty();
    if (val === "01") {
        $("#lblFiltSecundMensual_" + val).append("Categoría Presupuestal");
    }
    if (val === "02") {
        $("#lblFiltSecundMensual_" + val).append("Proyecto");
    }
    if (val === "03") {
        $("#lblFiltSecundMensual_" + val).append("Producto");
    }
    if (val === "04") {
        $("#lblFiltSecundMensual_" + val).append("Actividad");
    }
    if (val === "05") {
        $("#lblFiltSecundMensual_" + val).append("Acción Inversión");
    }
    if (val === "06") {
        $("#lblFiltSecundMensual_" + val).append("Obra");
    }
    if (val === "07") {
        $("#lblFiltSecundMensual_" + val).append("Función");
    }
    if (val === "08") {
        $("#lblFiltSecundMensual_" + val).append("Meta");
    }
    if (val === "09") {
        $("#lblFiltSecundMensual_" + val).append("Fuente Financiamiento");
    }
    if (val === "10") {
        $("#lblFiltSecundMensual_" + val).append("Rubro Financiamiento");
    }
    if (val === "11") {
        $("#lblFiltSecundMensual_" + val).append("Categoría de Gasto");
    }
    if (val === "12") {
        $("#lblFiltSecundMensual_" + val).append("Genérica");
    }
    if (val === "13") {
        $("#lblFiltSecundMensual_" + val).append("SubGenérica");
    }
    if (val === "14") {
        $("#lblFiltSecundMensual_" + val).append("SubGenérica Detallada");
    }
    if (val === "15") {
        $("#lblFiltSecundMensual_" + val).append("Específica");
    }
    if (val === "16") {
        $("#lblFiltSecundMensual_" + val).append("Específica Detallada");
    }
    if (val === "17") {
        $("#lblFiltSecundMensual_" + val).append("Provincia");
    }
    if (val === "18") {
        $("#lblFiltSecundMensual_" + val).append("División Funcional");
    }
    if (val === "19") {
        $("#lblFiltSecundMensual_" + val).append("Grupo Funcional");
    }
    if (val === "22") {
        $("#lblFiltSecundMensual_" + val).append("Centro de Costo");
    }
    $("#ulFiltSecundMensual_" + val).empty();
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataFiltrosMensual&ejec=" + ejec + "&año=" + año + "&val=" + val,
        success: function (response) {
            $.each(response.list, function (index, value) {
                if (response.val === "22") {
                    var objeM2 = '<li><label class="custom-control custom-checkbox">\
                                    <input id="' + value.nombre + '" type="checkbox" class="custom-control-input" value="' + value.ceco_id + '" name="filtro_' + response.val + '">\
                                    <span class="custom-control-indicator"></span>&nbsp;\
                                    <span id="spanMensual_' + value.codigo + '" class="custom-control-description"><b>' + value.codigo + "</b> - " + value.nombre + '</span>\
                                  </label></li>';
                    $("#ulFiltSecundMensual_" + response.val).append(objeM2);
                } else {
                    var objeM2 = '<li><label class="custom-control custom-checkbox">\
                                    <input id="' + value.nombre + '" type="checkbox" class="custom-control-input" value="' + value.codigo + '" name="filtro_' + response.val + '">\
                                    <span class="custom-control-indicator"></span>&nbsp;\
                                    <span id="spanMensual_' + value.codigo + '" class="custom-control-description"><b>' + value.codigo + "</b> - " + value.nombre + '</span>\
                                  </label></li>';
                    $("#ulFiltSecundMensual_" + response.val).append(objeM2);
                }
            });
            $("#ulFiltSecundMensual_" + response.val + " input").change(function () {
                $("#lblSelectSecundMens_" + response.val).empty();
                $("#ulFiltSecundMensual_" + response.val + " input").prop("checked", false);
                $("#ulFiltSecundMensual_" + response.val + " input[value='" + this.value + "']").prop("checked", true);
                $("#lblSelectSecundMens_" + response.val).append("<b>" + this.value + "</b> - " + this.id);
                mensual_id = this.value;
                mensual_nombre = this.id;
            });
        }
    });
}

function validarFiltroReporte02() {
    var msg;
    var filtP = $("#listPresuFiltroPrinc").val();
    if (filtP === "15") {
        var countFase = 0;
        $("input[name=fase]").each(function () {
            if (this.checked) {
                countFase++;
            }
        });
        if (countFase === 0) {
            msg = "Debe seleccionar al menos una Fase";
            return(msg);
        }
        var countCatPpto = 0;
        if ($("input[name=filtroMensual_catppto]").is(":checked") === true) {
            $("input[name=filtro_01]").each(function () {
                if (this.checked) {
                    countCatPpto++;
                }
            });
            if (countCatPpto === 0) {
                msg = "Debe seleccionar al menos una Categoría Presupuestal";
                return(msg);
            }
        }
        var countProy = 0;
        if ($("input[name=filtroMensual_proyecto]").is(":checked") === true) {
            $("input[name=filtro_02]").each(function () {
                if (this.checked) {
                    countProy++;
                }
            });
            if (countProy === 0) {
                msg = "Debe seleccionar al menos un Proyecto";
                return(msg);
            }
        }
        var countProd = 0;
        if ($("input[name=filtroMensual_producto]").is(":checked") === true) {
            $("input[name=filtro_03]").each(function () {
                if (this.checked) {
                    countProd++;
                }
            });
            if (countProd === 0) {
                msg = "Debe seleccionar al menos un Producto";
                return(msg);
            }
        }
        var countAct = 0;
        if ($("input[name=filtroMensual_actividad]").is(":checked") === true) {
            $("input[name=filtro_04]").each(function () {
                if (this.checked) {
                    countAct++;
                }
            });
            if (countAct === 0) {
                msg = "Debe seleccionar al menos una Actividad";
                return(msg);
            }
        }
        var countAcc = 0;
        if ($("input[name=filtroMensual_accion]").is(":checked") === true) {
            $("input[name=filtro_05]").each(function () {
                if (this.checked) {
                    countAcc++;
                }
            });
            if (countAcc === 0) {
                msg = "Debe seleccionar al menos una Acción de Inversión";
                return(msg);
            }
        }
        var countObra = 0;
        if ($("input[name=filtroMensual_obra]").is(":checked") === true) {
            $("input[name=filtro_06]").each(function () {
                if (this.checked) {
                    countObra++;
                }
            });
            if (countObra === 0) {
                msg = "Debe seleccionar al menos una Obra";
                return(msg);
            }
        }
        var countFunc = 0;
        if ($("input[name=filtroMensual_funcion]").is(":checked") === true) {
            $("input[name=filtro_07]").each(function () {
                if (this.checked) {
                    countFunc++;
                }
            });
            if (countFunc === 0) {
                msg = "Debe seleccionar al menos una Función";
                return(msg);
            }
        }
        var countDivFunc = 0;
        if ($("input[name=filtroMensual_divfuncion]").is(":checked") === true) {
            $("input[name=filtro_18]").each(function () {
                if (this.checked) {
                    countDivFunc++;
                }
            });
            if (countDivFunc === 0) {
                msg = "Debe seleccionar al menos una División Funcional";
                return(msg);
            }
        }
        var countGrupFunc = 0;
        if ($("input[name=filtroMensual_grupfuncion]").is(":checked") === true) {
            $("input[name=filtro_19]").each(function () {
                if (this.checked) {
                    countGrupFunc++;
                }
            });
            if (countGrupFunc === 0) {
                msg = "Debe seleccionar al menos un Grupo Funcional";
                return(msg);
            }
        }
        var countMeta = 0;
        if ($("input[name=filtroMensual_meta]").is(":checked") === true) {
            $("input[name=filtro_08]").each(function () {
                if (this.checked) {
                    countMeta++;
                }
            });
            if (countMeta === 0) {
                msg = "Debe seleccionar al menos una Meta Presupuestaria";
                return(msg);
            }
        }
        var countFuente = 0;
        if ($("input[name=filtroMensual_fuente]").is(":checked") === true) {
            $("input[name=filtro_09]").each(function () {
                if (this.checked) {
                    countFuente++;
                }
            });
            if (countFuente === 0) {
                msg = "Debe seleccionar al menos una Fuente de Financiamiento";
                return(msg);
            }
        }
        var countRubro = 0;
        if ($("input[name=filtroMensual_rubro]").is(":checked") === true) {
            $("input[name=filtro_10]").each(function () {
                if (this.checked) {
                    countRubro++;
                }
            });
            if (countRubro === 0) {
                msg = "Debe seleccionar al menos un Rubro de Financiamiento";
                return(msg);
            }
        }
        var countCatGasto = 0;
        if ($("input[name=filtroMensual_catgasto]").is(":checked") === true) {
            $("input[name=filtro_11]").each(function () {
                if (this.checked) {
                    countCatGasto++;
                }
            });
            if (countCatGasto === 0) {
                msg = "Debe seleccionar al menos una Categoría de Gasto";
                return(msg);
            }
        }
        var countGen = 0;
        if ($("input[name=filtroMensual_generica]").is(":checked") === true) {
            $("input[name=filtro_12]").each(function () {
                if (this.checked) {
                    countGen++;
                }
            });
            if (countGen === 0) {
                msg = "Debe seleccionar al menos una Genérica de Gasto";
                return(msg);
            }
        }
        var countSubGen = 0;
        if ($("input[name=filtroMensual_subgenerica]").is(":checked") === true) {
            $("input[name=filtro_13]").each(function () {
                if (this.checked) {
                    countSubGen++;
                }
            });
            if (countSubGen === 0) {
                msg = "Debe seleccionar al menos una Sub Genérica de Gasto";
                return(msg);
            }
        }
        var countSubGenDet = 0;
        if ($("input[name=filtroMensual_subgenericadet]").is(":checked") === true) {
            $("input[name=filtro_14]").each(function () {
                if (this.checked) {
                    countSubGenDet++;
                }
            });
            if (countSubGenDet === 0) {
                msg = "Debe seleccionar al menos una Sub Genérica Detallada de Gasto";
                return(msg);
            }
        }
        var countEsp = 0;
        if ($("input[name=filtroMensual_especifica]").is(":checked") === true) {
            $("input[name=filtro_15]").each(function () {
                if (this.checked) {
                    countEsp++;
                }
            });
            if (countEsp === 0) {
                msg = "Debe seleccionar al menos una Específica de Gasto";
                return(msg);
            }
        }
        var countEspDet = 0;
        if ($("input[name=filtroMensual_especificadet]").is(":checked") === true) {
            $("input[name=filtro_16]").each(function () {
                if (this.checked) {
                    countEspDet++;
                }
            });
            if (countEspDet === 0) {
                msg = "Debe seleccionar al menos una Específica Detallada de Gasto";
                return(msg);
            }
        }
        var countProv = 0;
        if ($("input[name=filtroMensual_provincia]").is(":checked") === true) {
            $("input[name=filtro_17]").each(function () {
                if (this.checked) {
                    countProv++;
                }
            });
            if (countProv === 0) {
                msg = "Debe seleccionar al menos una Provincia";
                return(msg);
            }
        }
        var countCeco = 0;
        if ($("input[name=filtroMensual_centro]").is(":checked") === true) {
            $("input[name=filtro_22]").each(function () {
                if (this.checked) {
                    countCeco++;
                }
            });
            if (countCeco === 0) {
                msg = "Debe seleccionar al menos un Centro de Costo";
                return(msg);
            }
        }
        msg = "OK";
        return(msg);
    } else {
        var countFiltro = 0;
        //var countMarco = 0;
        var countFase = 0;
        $("input[name=filtro]").each(function () {
            if (this.checked) {
                countFiltro++;
            }
        });
        //$("input[name=marco]").each(function () {
        //    if (this.checked) {
        //        countMarco++;
        //    }
        //});
        $("input[name=fase]").each(function () {
            if (this.checked) {
                countFase++;
            }
        });
        //if (countMarco === 0) {
        //    msg = "Debe seleccionar al menos un Marco Presupuestal";
        //    return(msg);
        //}
        if (countFase === 0) {
            msg = "Debe seleccionar al menos una Fase";
            return(msg);
        }
        if (filtP === "00") {
            msg = "OK";
            return(msg);
        }
        if (filtP !== "00") {
            if (countFiltro === 0) {
                if (filtP === "01") {
                    msg = "Debe seleccionar al menos una Categoría Presupuestal";
                }
                if (filtP === "02") {
                    if ($("input[name=total_todo]").is(":checked") === true) {
                        msg = "OK";
                    } else if ($("input[name=total_proy]").is(":checked") === true) {
                        msg = "OK";
                    } else if ($("input[name=total_prod]").is(":checked") === true) {
                        msg = "OK";
                    } else {
                        msg = "Debe seleccionar al menos un Proyecto o Producto";
                    }
                }
                if (filtP === "03") {
                    if ($("input[name=total_todo]").is(":checked") === true) {
                        msg = "OK";
                    } else if ($("input[name=total_act]").is(":checked") === true) {
                        msg = "OK";
                    } else if ($("input[name=total_inv]").is(":checked") === true) {
                        msg = "OK";
                    } else if ($("input[name=total_obra]").is(":checked") === true) {
                        msg = "OK";
                    } else {
                        msg = "Debe seleccionar al menos una Actividad, Acción de Inversión u Obra";
                    }
                }
                if (filtP === "04") {
                    msg = "Debe seleccionar al menos una Función";
                }
                if (filtP === "05") {
                    msg = "Debe seleccionar al menos una Meta Presupuestaria";
                }
                if (filtP === "06") {
                    msg = "Debe seleccionar al menos una Fuente de Financiamiento";
                }
                if (filtP === "07") {
                    msg = "Debe seleccionar al menos un Rubro de Financiamiento";
                }
                if (filtP === "08") {
                    msg = "Debe seleccionar al menos una Categoría de Gasto";
                }
                if (filtP === "09") {
                    msg = "Debe seleccionar al menos una Genérica de Gasto";
                }
                if (filtP === "10") {
                    msg = "Debe seleccionar al menos una Sub Genérica de Gasto";
                }
                if (filtP === "11") {
                    msg = "Debe seleccionar al menos una Sub Genérica Detallada de Gasto";
                }
                if (filtP === "12") {
                    msg = "Debe seleccionar al menos una Específica de Gasto";
                }
                if (filtP === "13") {
                    msg = "Debe seleccionar al menos una Específica Detallada de Gasto";
                }
                if (filtP === "14") {
                    msg = "Debe seleccionar al menos una Provincia";
                }
                if (filtP === "18") {
                    msg = "Debe seleccionar al menos una División Funcional";
                }
                if (filtP === "19") {
                    msg = "Debe seleccionar al menos un Grupo Funcional";
                }
                if (filtP === "22") {
                    msg = "Debe seleccionar al menos un Centro de Costo";
                }
                return(msg);
            }
        }
        var countEjec = 0;
        if ($("input[name=filtroS_ejecutora]").is(":checked") === true) {
            $("input[name=filtro_16]").each(function () {
                if (this.checked) {
                    countEjec++;
                }
            });
            if (countEjec === 0) {
                msg = "Debe seleccionar al menos una Ejecutora";
                return(msg);
            }
        }
        var countCatPpto = 0;
        if ($("input[name=filtroS_catppto]").is(":checked") === true) {
            $("input[name=filtro_01]").each(function () {
                if (this.checked) {
                    countCatPpto++;
                }
            });
            if (countCatPpto === 0) {
                msg = "Debe seleccionar al menos una Categoría Presupuestal";
                return(msg);
            }
        }
        var countProy = 0;
        if ($("input[name=filtroS_proyecto]").is(":checked") === true) {
            $("input[name=filtro_02]").each(function () {
                if (this.checked) {
                    countProy++;
                }
            });
            if (countProy === 0) {
                msg = "Debe seleccionar al menos un Proyecto o Producto";
                return(msg);
            }
        }
        var countAct = 0;
        if ($("input[name=filtroS_actividad]").is(":checked") === true) {
            $("input[name=filtro_03]").each(function () {
                if (this.checked) {
                    countAct++;
                }
            });
            if (countAct === 0) {
                msg = "Debe seleccionar al menos una Actividad, Acción de Inversión u Obra";
                return(msg);
            }
        }
        var countFunc = 0;
        if ($("input[name=filtroS_funcion]").is(":checked") === true) {
            $("input[name=filtro_04]").each(function () {
                if (this.checked) {
                    countFunc++;
                }
            });
            if (countFunc === 0) {
                msg = "Debe seleccionar al menos una Función";
                return(msg);
            }
        }
        var countDivFunc = 0;
        if ($("input[name=filtroS_divfuncion]").is(":checked") === true) {
            $("input[name=filtro_18]").each(function () {
                if (this.checked) {
                    countDivFunc++;
                }
            });
            if (countDivFunc === 0) {
                msg = "Debe seleccionar al menos una División Funcional";
                return(msg);
            }
        }
        var countGrupFunc = 0;
        if ($("input[name=filtroS_grupfuncion]").is(":checked") === true) {
            $("input[name=filtro_19]").each(function () {
                if (this.checked) {
                    countGrupFunc++;
                }
            });
            if (countGrupFunc === 0) {
                msg = "Debe seleccionar al menos un Grupo Funcional";
                return(msg);
            }
        }
        var countMeta = 0;
        if ($("input[name=filtroS_meta]").is(":checked") === true) {
            $("input[name=filtro_05]").each(function () {
                if (this.checked) {
                    countMeta++;
                }
            });
            if (countMeta === 0) {
                msg = "Debe seleccionar al menos una Meta Presupuestaria";
                return(msg);
            }
        }
        var countFuente = 0;
        if ($("input[name=filtroS_fuente]").is(":checked") === true) {
            $("input[name=filtro_06]").each(function () {
                if (this.checked) {
                    countFuente++;
                }
            });
            if (countFuente === 0) {
                msg = "Debe seleccionar al menos una Fuente de Financiamiento";
                return(msg);
            }
        }
        var countRubro = 0;
        if ($("input[name=filtroS_rubro]").is(":checked") === true) {
            $("input[name=filtro_07]").each(function () {
                if (this.checked) {
                    countRubro++;
                }
            });
            if (countRubro === 0) {
                msg = "Debe seleccionar al menos un Rubro de Financiamiento";
                return(msg);
            }
        }
        var countCatGasto = 0;
        if ($("input[name=filtroS_catgasto]").is(":checked") === true) {
            $("input[name=filtro_08]").each(function () {
                if (this.checked) {
                    countCatGasto++;
                }
            });
            if (countCatGasto === 0) {
                msg = "Debe seleccionar al menos una Categoría de Gasto";
                return(msg);
            }
        }
        var countGen = 0;
        if ($("input[name=filtroS_generica]").is(":checked") === true) {
            $("input[name=filtro_09]").each(function () {
                if (this.checked) {
                    countGen++;
                }
            });
            if (countGen === 0) {
                msg = "Debe seleccionar al menos una Genérica de Gasto";
                return(msg);
            }
        }
        var countSubGen = 0;
        if ($("input[name=filtroS_subgenerica]").is(":checked") === true) {
            $("input[name=filtro_10]").each(function () {
                if (this.checked) {
                    countSubGen++;
                }
            });
            if (countSubGen === 0) {
                msg = "Debe seleccionar al menos una Sub Genérica de Gasto";
                return(msg);
            }
        }
        var countSubGenDet = 0;
        if ($("input[name=filtroS_subgenericadet]").is(":checked") === true) {
            $("input[name=filtro_11]").each(function () {
                if (this.checked) {
                    countSubGenDet++;
                }
            });
            if (countSubGenDet === 0) {
                msg = "Debe seleccionar al menos una Sub Genérica Detallada de Gasto";
                return(msg);
            }
        }
        var countEsp = 0;
        if ($("input[name=filtroS_especifica]").is(":checked") === true) {
            $("input[name=filtro_12]").each(function () {
                if (this.checked) {
                    countEsp++;
                }
            });
            if (countEsp === 0) {
                msg = "Debe seleccionar al menos una Específica de Gasto";
                return(msg);
            }
        }
        var countEspDet = 0;
        if ($("input[name=filtroS_especificadet]").is(":checked") === true) {
            $("input[name=filtro_13]").each(function () {
                if (this.checked) {
                    countEspDet++;
                }
            });
            if (countEspDet === 0) {
                msg = "Debe seleccionar al menos una Específica Detallada de Gasto";
                return(msg);
            }
        }
        var countProv = 0;
        if ($("input[name=filtroS_provincia]").is(":checked") === true) {
            $("input[name=filtro_14]").each(function () {
                if (this.checked) {
                    countProv++;
                }
            });
            if (countProv === 0) {
                msg = "Debe seleccionar al menos una Provincia";
                return(msg);
            }
        }
        var countCeco = 0;
        if ($("input[name=filtroS_centro]").is(":checked") === true) {
            $("input[name=filtro_22]").each(function () {
                if (this.checked) {
                    countCeco++;
                }
            });
            if (countCeco === 0) {
                msg = "Debe seleccionar al menos un Centro de Costo";
                return(msg);
            }
        }
        msg = "OK";
        return(msg);
    }
}

function hidedlFiltSecund(array, val) {
    for (var i = 0; i < array.length; i++) {
        if (array[i] !== val) {
            $("#dlFiltSecund_" + array[i] + ".dropdownF dd ul").hide();
        }
    }
}

function hidedlFiltSecundMensual(array, val) {
    for (var i = 0; i < array.length; i++) {
        if (array[i] !== val) {
            $("#dlFiltSecundMensual_" + array[i] + ".dropdownF dd ul").hide();
        }
    }
}

function nombresLargos02(tipo) {
    var titulo;
    if (tipo === "00") {
        titulo = "";
    }
    if (tipo === "01") {
        titulo = " - Filtrado por Categoría Presupuestal";
    }
    if (tipo === "02") {
        titulo = " - Filtrado por Proyecto/Producto";
    }
    if (tipo === "03") {
        titulo = " - Filtrado por Actividad/Acción Inversión/Obra";
    }
    if (tipo === "04") {
        titulo = " - Filtrado por Función";
    }
    if (tipo === "05") {
        titulo = " - Filtrado por Meta";
    }
    if (tipo === "06") {
        titulo = " - Filtrado por Fuente de Financiamiento";
    }
    if (tipo === "07") {
        titulo = " - Filtrado por Rubro de Financiamiento";
    }
    if (tipo === "08") {
        titulo = " - Filtrado por Categoría de Gasto";
    }
    if (tipo === "09") {
        titulo = " - Filtrado por Genérica";
    }
    if (tipo === "10") {
        titulo = " - Filtrado por SubGenérica";
    }
    if (tipo === "11") {
        titulo = " - Filtrado por SubGenérica Detallada";
    }
    if (tipo === "12") {
        titulo = " - Filtrado por Específica";
    }
    if (tipo === "13") {
        titulo = " - Filtrado por Específica Detallada";
    }
    if (tipo === "14") {
        titulo = " - Filtrado por Provincia";
    }
    if (tipo === "18") {
        titulo = " - Filtrado por División Funcional";
    }
    if (tipo === "19") {
        titulo = " - Filtrado por Grupo Funcional";
    }
    if (tipo === "22") {
        titulo = " - Filtrado por Centro de Costo";
    }
    return(titulo);
}

function nombresLargos02M(tipo, id) {
    var titulo = [];
    if (tipo === "00") {
        titulo[0] = "";
        titulo[1] = "";
        titulo[2] = "";
    }
    if (tipo === "01") {
        titulo[0] = " - Filtrado por Categoría Presupuestal (" + id + ")";
        titulo[1] = "_filtrado_por_categoria_presupuestal";
        titulo[2] = "Categoría Presupuestal";
    }
    if (tipo === "02") {
        titulo[0] = " - Filtrado por Proyecto (" + id + ")";
        titulo[1] = "_filtrado_por_proyecto";
        titulo[2] = "Proyecto";
    }
    if (tipo === "03") {
        titulo[0] = " - Filtrado por Producto (" + id + ")";
        titulo[1] = "_filtrado_por_producto";
        titulo[2] = "Producto";
    }
    if (tipo === "04") {
        titulo[0] = " - Filtrado por Actividad (" + id + ")";
        titulo[1] = "_filtrado_por_actividad";
        titulo[2] = "Actividad";
    }
    if (tipo === "05") {
        titulo[0] = " - Filtrado por Acción de Inversión (" + id + ")";
        titulo[1] = "_filtrado_por_accion_inversion";
        titulo[2] = "Acción de Inversión";
    }
    if (tipo === "06") {
        titulo[0] = " - Filtrado por Obra (" + id + ")";
        titulo[1] = "_filtrado_por_obra";
        titulo[2] = "Obra";
    }
    if (tipo === "07") {
        titulo[0] = " - Filtrado por Función (" + id + ")";
        titulo[1] = "_filtrado_por_funcion";
        titulo[2] = "Función";
    }
    if (tipo === "08") {
        titulo[0] = " - Filtrado por Meta (" + id + ")";
        titulo[1] = "_filtrado_por_meta";
        titulo[2] = "Meta";
    }
    if (tipo === "09") {
        titulo[0] = " - Filtrado por Fuente de Financiamiento (" + id + ")";
        titulo[1] = "_filtrado_por_fuente_financiamiento";
        titulo[2] = "Fuente de Financiamiento";
    }
    if (tipo === "10") {
        titulo[0] = " - Filtrado por Rubro de Financiamiento (" + id + ")";
        titulo[1] = "_filtrado_por_rubro_financiamiento";
        titulo[2] = "Rubro de Financiamiento";
    }
    if (tipo === "11") {
        titulo[0] = " - Filtrado por Categoría de Gasto (" + id + ")";
        titulo[1] = "_filtrado_por_categoria_gasto";
        titulo[2] = "Categoría de Gasto";
    }
    if (tipo === "12") {
        titulo[0] = " - Filtrado por Genérica de Gasto (" + id + ")";
        titulo[1] = "_filtrado_por_generica_gasto";
        titulo[2] = "Genérica";
    }
    if (tipo === "13") {
        titulo[0] = " - Filtrado por SubGenérica de Gasto (" + id + ")";
        titulo[1] = "_filtrado_por_subgenerica_gasto";
        titulo[2] = "SubGenérica";
    }
    if (tipo === "14") {
        titulo[0] = " - Filtrado por SubGenérica Detallada de Gasto (" + id + ")";
        titulo[1] = "_filtrado_por_subgenerica_detallada_gasto";
        titulo[2] = "SubGenérica Detallada";
    }
    if (tipo === "15") {
        titulo[0] = " - Filtrado por Específica de Gasto (" + id + ")";
        titulo[1] = "_filtrado_por_especifica_gasto";
        titulo[2] = "Específica";
    }
    if (tipo === "16") {
        titulo[0] = " - Filtrado por Específica Detallada de Gasto (" + id + ")";
        titulo[1] = "_filtrado_por_especifica_detallada_gasto";
        titulo[2] = "Específica Detallada";
    }
    if (tipo === "17") {
        titulo[0] = " - Filtrado por Provincia (" + id + ")";
        titulo[1] = "_filtrado_por_provincia";
        titulo[2] = "Provincia";
    }
    if (tipo === "18") {
        titulo[0] = " - Filtrado por División Funcional (" + id + ")";
        titulo[1] = "_filtrado_por_division_funcional";
        titulo[2] = "División Funcional";
    }
    if (tipo === "19") {
        titulo[0] = " - Filtrado por Grupo Funcional (" + id + ")";
        titulo[1] = "_filtrado_por_grupo_funcional";
        titulo[2] = "Grupo Funcional";
    }
    if (tipo === "22") {
        titulo[0] = " - Filtrado por Centro de Costo (" + id + ")";
        titulo[1] = "_filtrado_por_centro_costo";
        titulo[2] = "Centro de Costo";
    }
    return(titulo);
}

function nombresCortos02(tipo) {
    var array = [];
    if (tipo === "00") {
        array[0] = "Ejecutora";
        array[1] = "Nombre";
    }
    if (tipo === "01") {
        array[0] = "Categ. Pres";
        array[1] = "Nombre";
    }
    if (tipo === "02") {
        array[0] = "Proy/Prod";
        array[1] = "Nombre";
    }
    if (tipo === "03") {
        array[0] = "Act/AcInv/Obra";
        array[1] = "Nombre";
    }
    if (tipo === "04") {
        array[0] = "Función";
        array[1] = "Nombre";
    }
    if (tipo === "05") {
        array[0] = "Meta";
        array[1] = "Finalidad";
    }
    if (tipo === "06") {
        array[0] = "Fuente";
        array[1] = "Nombre";
    }
    if (tipo === "07") {
        array[0] = "Rubro";
        array[1] = "Nombre";
    }
    if (tipo === "08") {
        array[0] = "Cat. Gasto";
        array[1] = "Nombre";
    }
    if (tipo === "09") {
        array[0] = "Genérica";
        array[1] = "Descripción";
    }
    if (tipo === "10") {
        array[0] = "SubGenérica";
        array[1] = "Descripción";
    }
    if (tipo === "11") {
        array[0] = "SubGenéricaDet";
        array[1] = "Descripción";
    }
    if (tipo === "12") {
        array[0] = "Específica";
        array[1] = "Descripción";
    }
    if (tipo === "13") {
        array[0] = "EspecíficaDet";
        array[1] = "Descripción";
    }
    if (tipo === "14") {
        array[0] = "Provincia";
        array[1] = "Nombre";
    }
    if (tipo === "18") {
        array[0] = "Div. Func.";
        array[1] = "Nombre";
    }
    if (tipo === "19") {
        array[0] = "Grup. Func.";
        array[1] = "Nombre";
    }
    if (tipo === "22") {
        array[0] = "Código";
        array[1] = "Centro Costo";
    }
    return(array);
}

function nombresTitulo02(tipo) {
    var titulo = [];
    if (tipo === "ejecutora") {
        titulo[0] = "Ejecutora";
        titulo[1] = "Nombre";
    }
    if (tipo === "programa_ppto") {
        titulo[0] = "Categ. Pres";
        titulo[1] = "Nombre";
    }
    if (tipo === "act_proy") {
        titulo[0] = "Proy/Prod";
        titulo[1] = "Nombre";
    }
    if (tipo === "componente") {
        titulo[0] = "Act/AcInv/Obra";
        titulo[1] = "Nombre";
    }
    if (tipo === "funcion") {
        titulo[0] = "Función";
        titulo[1] = "Nombre";
    }
    if (tipo === "sec_func") {
        titulo[0] = "Meta";
        titulo[1] = "Finalidad";
    }
    if (tipo === "fuente_financ_agregada") {
        titulo[0] = "Fuente";
        titulo[1] = "Nombre";
    }
    if (tipo === "fuente_financ") {
        titulo[0] = "Rubro";
        titulo[1] = "Nombre";
    }
    if (tipo === "tipo_recurso") {
        titulo[0] = "Tipo Recurso";
        titulo[1] = "Nombre";
    }
    if (tipo === "categ_gasto") {
        titulo[0] = "Cat. Gasto";
        titulo[1] = "Nombre";
    }
    if (tipo === "generica_clasif") {
        titulo[0] = "Genérica";
        titulo[1] = "Descripción";
    }
    if (tipo === "subgenerica_clasif") {
        titulo[0] = "SubGenérica";
        titulo[1] = "Descripción";
    }
    if (tipo === "subgenerica_det_clasif") {
        titulo[0] = "SubGenéricaDet";
        titulo[1] = "Descripción";
    }
    if (tipo === "especifica_clasif") {
        titulo[0] = "Específica";
        titulo[1] = "Descripción";
    }
    if (tipo === "especifica_det_clasif") {
        titulo[0] = "EspecíficaDet";
        titulo[1] = "Descripción";
    }
    if (tipo === "provincia") {
        titulo[0] = "Provincia";
        titulo[1] = "Nombre";
    }
    if (tipo === "distrito") {
        titulo[0] = "Distrito";
        titulo[1] = "Nombre";
    }
    if (tipo === "programa") {
        titulo[0] = "Div. Func.";
        titulo[1] = "Nombre";
    }
    if (tipo === "sub_programa") {
        titulo[0] = "Grup. Func.";
        titulo[1] = "Nombre";
    }
    if (tipo === "centro_costo") {
        titulo[0] = "Código";
        titulo[1] = "Centro Costo";
    }
    return(titulo);
}

function nombresBody02(tipo, value) {
    var body = [];
    if (tipo === "ejecutora") {
        var nombre_ejec = (value.nombre_ejecutora).split("-");
        body[0] = "<td class='center'>UE " + value.ejecutora + "</td>\
                   <td class='left'>" + nombre_ejec[1].trim() + "(" + value.sec_ejec + ")</td>";
        body[1] = "UE " + value.ejecutora;
    }
    if (tipo === "programa_ppto") {
        body[0] = "<td class='center'>" + value.programa_ppto + "</td>\
                   <td class='left'>" + value.nombre_programa_ppto + "</td>";
        body[1] = value.programa_ppto;
    }
    if (tipo === "act_proy") {
        body[0] = "<td class='center'>" + value.act_proy + "</td>\
                   <td class='left'>" + value.nombre_act_proy + "</td>";
        body[1] = value.act_proy;
    }
    if (tipo === "componente") {
        body[0] = "<td class='center'>" + value.componente + "</td>\
                   <td class='left'>" + value.nombre_componente + "</td>";
        body[1] = value.componente;
    }
    if (tipo === "funcion") {
        body[0] = "<td class='center'>" + value.funcion + "</td>\
                   <td class='left'>" + value.nombre_funcion + "</td>";
        body[1] = value.funcion;
    }
    if (tipo === "sec_func") {
        body[0] = "<td class='center'>" + value.sec_func + "</td>\
                   <td class='left'>" + value.nombre_sec_func + "</td>";
        body[1] = value.sec_func;
    }
    if (tipo === "fuente_financ_agregada") {
        body[0] = "<td class='center'>" + value.fuente_financ_agregada + "</td>\
                   <td class='left'>" + value.nombre_fuente_financ_agregada + "</td>";
        body[1] = value.fuente_financ_agregada;
    }
    if (tipo === "fuente_financ") {
        body[0] = "<td class='center'>" + value.fuente_financ + "</td>\
                   <td class='left'>" + value.nombre_fuente_financ + "</td>";
        body[1] = value.fuente_financ;
    }
    if (tipo === "tipo_recurso") {
        body[0] = "<td class='center'>" + value.tipo_recurso + "</td>\
                   <td class='left'>" + value.nombre_tipo_recurso + "</td>";
        body[1] = value.tipo_recurso;
    }
    if (tipo === "categ_gasto") {
        body[0] = "<td class='center'>" + value.categ_gasto + "</td>\
                   <td class='left'>" + value.nombre_categ_gasto + "</td>";
        body[1] = value.categ_gasto;
    }
    if (tipo === "generica_clasif") {
        body[0] = "<td class='center'>" + value.generica_clasif + "</td>\
                   <td class='left'>" + value.nombre_generica_clasif + "</td>";
        body[1] = value.generica_clasif;
    }
    if (tipo === "subgenerica_clasif") {
        body[0] = "<td class='center'>" + value.subgenerica_clasif + "</td>\
                   <td class='left'>" + value.nombre_subgenerica_clasif + "</td>";
        body[1] = value.subgenerica_clasif;
    }
    if (tipo === "subgenerica_det_clasif") {
        body[0] = "<td class='center'>" + value.subgenerica_det_clasif + "</td>\
                   <td class='left'>" + value.nombre_subgenerica_det_clasif + "</td>";
        body[1] = value.subgenerica_det_clasif;
    }
    if (tipo === "especifica_clasif") {
        body[0] = "<td class='center'>" + value.especifica_clasif + "</td>\
                   <td class='left'>" + value.nombre_especifica_clasif + "</td>";
        body[1] = value.especifica_clasif;
    }
    if (tipo === "especifica_det_clasif") {
        body[0] = "<td class='center'>" + value.especifica_det_clasif + "</td>\
                   <td class='left'>" + value.nombre_especifica_det_clasif + "</td>";
        body[1] = value.especifica_det_clasif;
    }
    if (tipo === "provincia") {
        body[0] = "<td class='center'>" + value.provincia + "</td>\
                   <td class='left'>" + value.nombre_provincia + "</td>";
        body[1] = value.provincia;
    }
    if (tipo === "distrito") {
        body[0] = "<td class='center'>" + value.distrito + "</td>\
                   <td class='left'>" + value.nombre_distrito + "</td>";
        body[1] = value.distrito;
    }
    if (tipo === "programa") {
        body[0] = "<td class='center'>" + value.programa + "</td>\
                   <td class='left'>" + value.nombre_programa + "</td>";
        body[1] = value.programa;
    }
    if (tipo === "sub_programa") {
        body[0] = "<td class='center'>" + value.sub_programa + "</td>\
                   <td class='left'>" + value.nombre_sub_programa + "</td>";
        body[1] = value.sub_programa;
    }
    if (tipo === "centro_costo") {
        if (!$.trim(value.ceco_id)) {
            body[0] = "<td class='center'>000</td>\
                       <td class='left'>No Asignado</td>";
            body[1] = "000";
        } else {
            body[0] = "<td class='center'>" + value.ceco_codigo + "</td>\
                       <td class='left'>" + value.ceco_nombre + "</td>";
            body[1] = value.ceco_codigo;
        }
    }
    return(body);
}

function llenarTablaReporte02(response) {

    var tipo = $("#listPresuFiltroPrinc").val();

    if (tipo === "15") {
        $("#lblPresuFiltGrafico").removeClass("oculto");
        $("#divPresuFiltGrafico").removeClass("oculto");
        llenarFiltroGrafico02();
        $("#divPresuGrafica").removeClass("oculto");
        if (response.tipoM === "00") {
            var titleM = nombresLargos02M(response.tipoM, "");
            var muestra2 = [];
            var cuerpo2M = '<table id="tablaPresu2N" class="display" cellspacing="0" width="100%">\
                                <thead id="tablaPresu2Head"></thead>\
                                <tbody id="tablaPresu2Body"></tbody>\
                                <tfoot id="tablaPresu2Foot"></tfoot>\
                             </table>';
            $("#divPresuTabla").append(cuerpo2M);
            var muestra2Head = [];
            var head2M = "<tr>\
                            <th>Mes</th>\
                            <th>Nombre</th>\
                            <th>Certificado (C)</th>\
                            <th>Compromiso Anual (CoA)</th>\
                            <th>Compromiso (Co)</th>\
                            <th>Devengado (D)</th>\
                            <th>Girado (G)</th>\
                            <th>Pagado (Pa)</th>\
                          </tr>";
            $("#tablaPresu2Head").append(head2M);
            muestra2Head.push({text: 'Mes', style: 'tablaHead', alignment: 'center'});
            muestra2Head.push({text: 'Nombre', style: 'tablaHead', alignment: 'center'});
            muestra2Head.push({text: 'Certificado', style: 'tablaHead', alignment: 'center'});
            muestra2Head.push({text: 'Compromiso Anual', style: 'tablaHead', alignment: 'center'});
            muestra2Head.push({text: 'Compromiso', style: 'tablaHead', alignment: 'center'});
            muestra2Head.push({text: 'Devengado', style: 'tablaHead', alignment: 'center'});
            muestra2Head.push({text: 'Girado', style: 'tablaHead', alignment: 'center'});
            muestra2Head.push({text: 'Pagado', style: 'tablaHead', alignment: 'center'});
            muestra2.push(muestra2Head);

            var meses = "";
            var arrayC = "";
            var arrayCoA = "";
            var arrayCo = "";
            var arrayD = "";
            var arrayG = "";
            var arrayP = "";
            var certT, compAT, compT, devenT, giraT, pagaT;
            certT = compAT = compT = devenT = giraT = pagaT = 0.00;
            $.each(response.list, function (index, value) {
                var cert, compA, comp, deven, gira, paga;
                if (!$.trim(value.certificado)) {
                    cert = 0.00;
                } else {
                    cert = value.certificado;
                    certT += value.certificado;
                }
                if (!$.trim(value.compromiso_anual)) {
                    compA = 0.00;
                } else {
                    compA = value.compromiso_anual;
                    compAT += value.compromiso_anual;
                }
                if (!$.trim(value.compromiso)) {
                    comp = 0.00;
                } else {
                    comp = value.compromiso;
                    compT += value.compromiso;
                }
                if (!$.trim(value.devengado)) {
                    deven = 0.00;
                } else {
                    deven = value.devengado;
                    devenT += value.devengado;
                }
                if (!$.trim(value.girado)) {
                    gira = 0.00;
                } else {
                    gira = value.girado;
                    giraT += value.girado;
                }
                if (!$.trim(value.pagado)) {
                    paga = 0.00;
                } else {
                    paga = value.pagado;
                    pagaT += value.pagado;
                }
                var muestra2Body = [];
                var body2M = "<tr>\
                                <td class='center'>" + value.mes + "</td>\
                                <td class='left'>" + value.nombre + "</td>\
                                <td class='right'>" + formatNumero(cert) + "</td>\
                                <td class='right'>" + formatNumero(compA) + "</td>\
                                <td class='right'>" + formatNumero(comp) + "</td>\
                                <td class='right'>" + formatNumero(deven) + "</td>\
                                <td class='right'>" + formatNumero(gira) + "</td>\
                                <td class='right'>" + formatNumero(paga) + "</td>\
                              </tr>";
                $("#tablaPresu2Body").append(body2M);
                meses += "&mes=" + value.nombre;
                arrayC += "&array=" + cert;
                arrayCoA += "&array=" + compA;
                arrayCo += "&array=" + comp;
                arrayD += "&array=" + deven;
                arrayG += "&array=" + gira;
                arrayP += "&array=" + paga;
                muestra2Body.push({text: value.mes, style: 'tablaBody', alignment: 'center'});
                muestra2Body.push({text: value.nombre, style: 'tablaBody', alignment: 'left'});
                muestra2Body.push({text: formatNumero(cert), style: 'tablaBody', alignment: 'right'});
                muestra2Body.push({text: formatNumero(compA), style: 'tablaBody', alignment: 'right'});
                muestra2Body.push({text: formatNumero(comp), style: 'tablaBody', alignment: 'right'});
                muestra2Body.push({text: formatNumero(deven), style: 'tablaBody', alignment: 'right'});
                muestra2Body.push({text: formatNumero(gira), style: 'tablaBody', alignment: 'right'});
                muestra2Body.push({text: formatNumero(paga), style: 'tablaBody', alignment: 'right'});
                muestra2.push(muestra2Body);
            });
            var muestra2Foot = [];
            var foot2M = "<tr class='total'>\
                            <td colspan='2' class='center'><b>TOTAL</b></td>\
                            <td class='right'><b>" + formatNumero(certT) + "</b></td>\
                            <td class='right'><b>" + formatNumero(compAT) + "</b></td>\
                            <td class='right'><b>" + formatNumero(compT) + "</b></td>\
                            <td class='right'><b>" + formatNumero(devenT) + "</b></td>\
                            <td class='right'><b>" + formatNumero(giraT) + "</b></td>\
                            <td class='right'><b>" + formatNumero(pagaT) + "</b></td>\
                          </tr>";
            $("#tablaPresu2Foot").append(foot2M);
            muestra2Foot.push({text: 'TOTAL', style: 'tablaTotal', alignment: 'center', colSpan: 2});
            muestra2Foot.push("");
            muestra2Foot.push({text: formatNumero(certT), style: 'tablaTotal', alignment: 'right'});
            muestra2Foot.push({text: formatNumero(compAT), style: 'tablaTotal', alignment: 'right'});
            muestra2Foot.push({text: formatNumero(compT), style: 'tablaTotal', alignment: 'right'});
            muestra2Foot.push({text: formatNumero(devenT), style: 'tablaTotal', alignment: 'right'});
            muestra2Foot.push({text: formatNumero(giraT), style: 'tablaTotal', alignment: 'right'});
            muestra2Foot.push({text: formatNumero(pagaT), style: 'tablaTotal', alignment: 'right'});
            muestra2.push(muestra2Foot);

            var countIniT = 2;
            var columnasIni = "[";
            var countFase = 0;
            var countFaseT = 0;
            var columnasFase = "";
            $("input[name=fase]").each(function () {
                if (this.checked === false) {
                    countFase++;
                    columnasFase += (Number.parseInt(this.value, 10) - 3) + ", ";
                } else {
                    countFaseT++;
                }
            });
            if (countFase !== 0) {
                columnasFase = columnasFase.substring(0, columnasFase.length - 2);
            }
            var columnasFin = "]";
            var columnas = columnasIni + columnasFase + columnasFin;
            var countT = countIniT + countFaseT;
            var columnasObject = JSON.parse(columnas); // Aca se hace un parse de JS String a JS Object para que pueda ser reconocido

            $('#tablaPresu2N').dataTable({
                columnDefs: [
                    {targets: columnasObject, visible: false},
                    {targets: '_all', visible: true}
                ],
                ordering: true,
                dom: '<"centrar-div-tabla"lB>iprtip',
                buttons: [
                    {
                        extend: 'colvis',
                        columnText: function (dt, idx, titlex) {
                            return (idx + 1) + '.- ' + titlex;
                        },
                        postfixButtons: ['colvisRestore'],
                        collectionLayout: 'fixed two-column'
                    },
                    {
                        extend: 'excel',
                        footer: true,
                        filename: 'ejecucion_gasto_' + (response.ejec === "00" ? "pliego459" : response.ejec) + '_' + response.año + '_mensualizada' + titleM[1],
                        title: 'EJECUCIÓN DE GASTO ' + response.año + " - MENSUALIZADO" + titleM[0],
                        messageTop: response.tituloPDF,
                        exportOptions: {
                            orthogonal: 'sort',
                            columns: ':visible'
                        },
                        customize: function (xlsx) {
                            var sheet = xlsx.xl.worksheets['sheet1.xml'];
                            for (var k = countIniT; k < countT; k++) {
                                var total = $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).length;
                                $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).each(function (i) {
                                    if (i > 0 && i < total - 1) {
                                        $(this).attr('s', '72');
                                    }
                                    if (i === total - 1) {
                                        $(this).attr('s', '75');
                                    }
                                });
                            }
                        }
                    }
                ]
            });
            var btnPDFM = '<button id="exportPDF2N" class="dt-button buttons-html5">\
                                <span>\
                                    <img src="./templates/plugins/datatables/images/pdf.png" data-toggle="tooltip" data-placement="bottom" title="Exportar a PDF">\
                                </span>\
                           </button>';
            $("#tablaPresu2N_wrapper .dt-buttons").append(btnPDFM);
            var titulo = 'EJECUCIÓN DE GASTO ' + response.año + " - MENSUALIZADO" + titleM[0];
            var subtitulo = response.tituloPDF;
            llenarGrafico02("./Presupuesto?tipo=02&graph=true" + meses + arrayD + "&titu=" + titulo + "&subtitu=" + subtitulo + "&ancho=1000&alto=600&font=10&bar=0.06&pos=out&fase=D");
            cambiaFiltroGrafico02(meses, arrayC, arrayCoA, arrayCo, arrayD, arrayG, arrayP, titulo, subtitulo);

            ///////////////// Exportar a PDF ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   

            var imageUrl_grsm = './resources/images/logo_grsm.png';
            var imageUrl_system = './resources/images/logo_sirsm.png';
            var imgM, img_grsm, img_system;
            convertImgToDataURLviaCanvas(imageUrl_grsm, function (base64Img) {
                img_grsm = base64Img;
            });
            convertImgToDataURLviaCanvas(imageUrl_system, function (base64Img) {
                img_system = base64Img;
            });
            var newDate = new Date();
            var tiempo = newDate.getDate() + "/" + newDate.getMonth() + "/" + newDate.getFullYear() + "  " + newDate.getHours() + ":" + newDate.getMinutes();

            $("#exportPDF2N").hover(function () {
                var imageUrlM = document.getElementById("imgPresuGrafica02M").src + "&pdf=si";
                convertImgToDataURLviaCanvas(imageUrlM, function (base64Img) {
                    imgM = base64Img;
                });
            });

            $("#exportPDF2N").on('click', function () {
                var docDefinition1 = {
                    //pageOrientation: 'landscape',
                    info: {
                        title: 'ejecucion_gasto_' + (response.ejec === "00" ? "pliego459" : response.ejec) + '_' + response.año + '_mensualizada' + titleM[1]
                    },
                    pageMargins: [20, 60, 20, 40],
                    header: {
                        margin: 10,
                        table: {
                            widths: [15, '*', '*', 15],
                            body: [
                                [
                                    "",
                                    {image: img_system, width: 102, alignment: 'left'},
                                    {image: img_grsm, width: 70, alignment: 'right'},
                                    ""
                                ]
                            ]
                        },
                        layout: {
                            hLineColor: 'white',
                            vLineColor: 'white'
                        }
                    },
                    footer: {
                        margin: 10,
                        table: {
                            widths: ['*', 20],
                            body: [
                                [
                                    {text: 'Fecha y Hora : ' + tiempo, alignment: 'right', style: 'pie'},
                                    ""
                                ]
                            ]
                        },
                        layout: {
                            hLineColor: 'white',
                            vLineColor: 'white'
                        }
                    },
                    content: [
                        {
                            table: {
                                widths: ['*'],
                                body: [
                                    [
                                        {text: 'EJECUCIÓN DE GASTO ' + response.año + " - MENSUALIZADO" + titleM[0] + '\n' + response.tituloPDF + '\n', alignment: 'center', style: 'titulo'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            text: '\nTabla Resumen de Ejecución', alignment: 'left', style: 'subtitulo'
                        },
                        {
                            text: '\n'
                        },
                        {
                            table: {
                                widths: [30, 60, '*', '*', '*', '*', '*', '*'],
                                body: muestra2
                            },
                            layout: {
                                hLineColor: '#ECECEC',
                                vLineColor: '#ECECEC'
                            }
                        },
                        {
                            text: '\n\n'
                        },
                        {
                            table: {
                                widths: ['*'],
                                body: [
                                    [
                                        {text: 'Gráfica de Ejecución', alignment: 'left', style: 'subtitulo'}
                                    ],
                                    [
                                        {image: imgM, fit: [520, 300], alignment: 'left'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        }
                    ],
                    styles: {
                        titulo: {
                            fontSize: 8,
                            bold: true
                        },
                        subtitulo: {
                            fontSize: 8
                        },
                        tablaHead: {
                            color: 'white',
                            fillColor: '#426993',
                            fontSize: 6,
                            bold: true
                        },
                        tablaBody: {
                            fontSize: 5
                        },
                        tablaTotal: {
                            fillColor: '#F6F6F6',
                            fontSize: 6,
                            bold: true
                        },
                        pie: {
                            fontSize: 6
                        }
                    }
                };
                pdfMake.createPdf(docDefinition1).open();
            });

        } else {
            var titleM = nombresLargos02M(response.tipoM, mensual_id);
            var muestra1 = [];
            var cuerpo1M = '<table id="tablaPresu1" class="display" cellspacing="0" width="100%">\
                                <thead id="tablaPresu1Head"></thead>\
                                <tbody id="tablaPresu1Body"></tbody>\
                             </table>';
            $("#divPresuTabla").append(cuerpo1M);
            var muestra1Head = [];
            var head1M = "<tr>\
                            <th>" + titleM[2] + "</th>\
                            <th>Nombre</th>\
                          </tr>";
            $("#tablaPresu1Head").append(head1M);
            muestra1Head.push({text: titleM[2], style: 'tablaHead', alignment: 'center'});
            muestra1Head.push({text: 'Nombre', style: 'tablaHead', alignment: 'center'});
            muestra1.push(muestra1Head);
            var muestra1Body = [];
            var body1M = "<tr>\
                            <td class='center'>" + mensual_id + "</td>\
                            <td class='center'>" + mensual_nombre + "</td>\
                          </tr>";
            $("#tablaPresu1Body").append(body1M);
            muestra1Body.push({text: mensual_id, style: 'tablaBody', alignment: 'center'});
            muestra1Body.push({text: mensual_nombre, style: 'tablaBody', alignment: 'center'});
            muestra1.push(muestra1Body);
            var muestra2 = [];
            var cuerpo2M = '<table id="tablaPresu2" class="display" cellspacing="0" width="100%">\
                                <thead id="tablaPresu2Head"></thead>\
                                <tbody id="tablaPresu2Body"></tbody>\
                                <tfoot id="tablaPresu2Foot"></tfoot>\
                             </table>';
            $("#divPresuTabla").append(cuerpo2M);
            var muestra2Head = [];
            var head2M = "<tr>\
                            <th>Mes</th>\
                            <th>Nombre</th>\
                            <th>Certificado (C)</th>\
                            <th>Compromiso Anual (CoA)</th>\
                            <th>Compromiso (Co)</th>\
                            <th>Devengado (D)</th>\
                            <th>Girado (G)</th>\
                            <th>Pagado (Pa)</th>\
                          </tr>";
            $("#tablaPresu2Head").append(head2M);
            muestra2Head.push({text: 'Mes', style: 'tablaHead', alignment: 'center'});
            muestra2Head.push({text: 'Nombre', style: 'tablaHead', alignment: 'center'});
            muestra2Head.push({text: 'Certificado', style: 'tablaHead', alignment: 'center'});
            muestra2Head.push({text: 'Compromiso Anual', style: 'tablaHead', alignment: 'center'});
            muestra2Head.push({text: 'Compromiso', style: 'tablaHead', alignment: 'center'});
            muestra2Head.push({text: 'Devengado', style: 'tablaHead', alignment: 'center'});
            muestra2Head.push({text: 'Girado', style: 'tablaHead', alignment: 'center'});
            muestra2Head.push({text: 'Pagado', style: 'tablaHead', alignment: 'center'});
            muestra2.push(muestra2Head);
            var meses = "";
            var arrayC = "";
            var arrayCoA = "";
            var arrayCo = "";
            var arrayD = "";
            var arrayG = "";
            var arrayP = "";
            var certT, compAT, compT, devenT, giraT, pagaT;
            certT = compAT = compT = devenT = giraT = pagaT = 0.00;
            $.each(response.list, function (index, value) {
                var cert, compA, comp, deven, gira, paga;
                if (!$.trim(value.certificado)) {
                    cert = 0.00;
                } else {
                    cert = value.certificado;
                    certT += value.certificado;
                }
                if (!$.trim(value.compromiso_anual)) {
                    compA = 0.00;
                } else {
                    compA = value.compromiso_anual;
                    compAT += value.compromiso_anual;
                }
                if (!$.trim(value.compromiso)) {
                    comp = 0.00;
                } else {
                    comp = value.compromiso;
                    compT += value.compromiso;
                }
                if (!$.trim(value.devengado)) {
                    deven = 0.00;
                } else {
                    deven = value.devengado;
                    devenT += value.devengado;
                }
                if (!$.trim(value.girado)) {
                    gira = 0.00;
                } else {
                    gira = value.girado;
                    giraT += value.girado;
                }
                if (!$.trim(value.pagado)) {
                    paga = 0.00;
                } else {
                    paga = value.pagado;
                    pagaT += value.pagado;
                }
                var muestra2Body = [];
                var body2M = "<tr>\
                            <td class='center'>" + value.mes + "</td>\
                            <td class='left'>" + value.nombre + "</td>\
                            <td class='right'>" + formatNumero(cert) + "</td>\
                            <td class='right'>" + formatNumero(compA) + "</td>\
                            <td class='right'>" + formatNumero(comp) + "</td>\
                            <td class='right'>" + formatNumero(deven) + "</td>\
                            <td class='right'>" + formatNumero(gira) + "</td>\
                            <td class='right'>" + formatNumero(paga) + "</td>\
                          </tr>";
                $("#tablaPresu2Body").append(body2M);
                meses += "&mes=" + value.nombre;
                arrayC += "&array=" + cert;
                arrayCoA += "&array=" + compA;
                arrayCo += "&array=" + comp;
                arrayD += "&array=" + deven;
                arrayG += "&array=" + gira;
                arrayP += "&array=" + paga;
                muestra2Body.push({text: value.mes, style: 'tablaBody', alignment: 'center'});
                muestra2Body.push({text: value.nombre, style: 'tablaBody', alignment: 'left'});
                muestra2Body.push({text: formatNumero(cert), style: 'tablaBody', alignment: 'right'});
                muestra2Body.push({text: formatNumero(compA), style: 'tablaBody', alignment: 'right'});
                muestra2Body.push({text: formatNumero(comp), style: 'tablaBody', alignment: 'right'});
                muestra2Body.push({text: formatNumero(deven), style: 'tablaBody', alignment: 'right'});
                muestra2Body.push({text: formatNumero(gira), style: 'tablaBody', alignment: 'right'});
                muestra2Body.push({text: formatNumero(paga), style: 'tablaBody', alignment: 'right'});
                muestra2.push(muestra2Body);
            });
            var muestra2Foot = [];
            foot2M = "<tr class='total'>\
                        <td colspan='2' class='center'><b>TOTAL</b></td>\
                        <td class='right'><b>" + formatNumero(certT) + "</b></td>\
                        <td class='right'><b>" + formatNumero(compAT) + "</b></td>\
                        <td class='right'><b>" + formatNumero(compT) + "</b></td>\
                        <td class='right'><b>" + formatNumero(devenT) + "</b></td>\
                        <td class='right'><b>" + formatNumero(giraT) + "</b></td>\
                        <td class='right'><b>" + formatNumero(pagaT) + "</b></td>\
                      </tr>";
            $("#tablaPresu2Foot").append(foot2M);
            muestra2Foot.push({text: 'TOTAL', style: 'tablaTotal', alignment: 'center', colSpan: 2});
            muestra2Foot.push("");
            muestra2Foot.push({text: formatNumero(certT), style: 'tablaTotal', alignment: 'right'});
            muestra2Foot.push({text: formatNumero(compAT), style: 'tablaTotal', alignment: 'right'});
            muestra2Foot.push({text: formatNumero(compT), style: 'tablaTotal', alignment: 'right'});
            muestra2Foot.push({text: formatNumero(devenT), style: 'tablaTotal', alignment: 'right'});
            muestra2Foot.push({text: formatNumero(giraT), style: 'tablaTotal', alignment: 'right'});
            muestra2Foot.push({text: formatNumero(pagaT), style: 'tablaTotal', alignment: 'right'});
            muestra2.push(muestra2Foot);

            var countIniT = 2;
            var columnasIni = "[";
            var countFase = 0;
            var countFaseT = 0;
            var columnasFase = "";
            $("input[name=fase]").each(function () {
                if (this.checked === false) {
                    countFase++;
                    columnasFase += (Number.parseInt(this.value, 10) - 3) + ", ";
                } else {
                    countFaseT++;
                }
            });
            if (countFase !== 0) {
                columnasFase = columnasFase.substring(0, columnasFase.length - 2);
            }
            var columnasFin = "]";
            var columnas = columnasIni + columnasFase + columnasFin;
            var countT = countIniT + countFaseT;
            var columnasObject = JSON.parse(columnas); // Aca se hace un parse de JS String a JS Object para que pueda ser reconocido

            $('#tablaPresu1').dataTable({
                ordering: false,
                dom: 'rt'
            });

            $('#tablaPresu2').dataTable({
                columnDefs: [
                    {targets: columnasObject, visible: false},
                    {targets: '_all', visible: true}
                ],
                ordering: true,
                dom: '<"centrar-div-tabla"lB>iprtip',
                buttons: [
                    {
                        extend: 'colvis',
                        columnText: function (dt, idx, title) {
                            return (idx + 1) + '.- ' + title;
                        },
                        postfixButtons: ['colvisRestore'],
                        collectionLayout: 'fixed two-column'
                    },
                    {
                        extend: 'excel',
                        footer: true,
                        filename: 'ejecucion_gasto_' + (response.ejec === "00" ? "pliego459" : response.ejec) + '_' + response.año + '_mensualizada' + titleM[1],
                        title: 'EJECUCIÓN DE GASTO ' + response.año + " - MENSUALIZADO" + titleM[0],
                        messageTop: response.tituloPDF,
                        headTop1: titleM[2] + ' : ' + mensual_id,
                        headTop2: 'Nombre : ' + mensual_nombre,
                        exportOptions: {
                            orthogonal: 'sort',
                            columns: ':visible'
                        },
                        customize: function (xlsx) {
                            var sheet = xlsx.xl.worksheets['sheet1.xml'];
                            for (var k = countIniT; k < countT; k++) {
                                var total = $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).length;
                                $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).each(function (i) {
                                    if (i > 0 && i < total - 1) {
                                        $(this).attr('s', '72');
                                    }
                                    if (i === total - 1) {
                                        $(this).attr('s', '75');
                                    }
                                });
                            }
                        }
                    }
                ]
            });
            var btnPDFM = '<button id="exportPDF1N" class="dt-button buttons-html5">\
                                <span>\
                                    <img src="./templates/plugins/datatables/images/pdf.png" data-toggle="tooltip" data-placement="bottom" title="Exportar a PDF">\
                                </span>\
                           </button>';
            $("#tablaPresu2_wrapper .dt-buttons").append(btnPDFM);

            var titulo = 'EJECUCIÓN DE GASTO ' + response.año + " - MENSUALIZADO" + titleM[0];
            var subtitulo = response.tituloPDF;
            llenarGrafico02("./Presupuesto?tipo=02&graph=true" + meses + arrayD + "&titu=" + titulo + "&subtitu=" + subtitulo + "&ancho=1000&alto=600&font=10&bar=0.06&pos=out&fase=D");
            cambiaFiltroGrafico02(meses, arrayC, arrayCoA, arrayCo, arrayD, arrayG, arrayP, titulo, subtitulo);


            ///////////////// Exportar a PDF ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   

            var imageUrl_grsm = './resources/images/logo_grsm.png';
            var imageUrl_system = './resources/images/logo_sirsm.png';
            var imgM, img_grsm, img_system;
            convertImgToDataURLviaCanvas(imageUrl_grsm, function (base64Img) {
                img_grsm = base64Img;
            });
            convertImgToDataURLviaCanvas(imageUrl_system, function (base64Img) {
                img_system = base64Img;
            });
            var newDate = new Date();
            var tiempo = newDate.getDate() + "/" + newDate.getMonth() + "/" + newDate.getFullYear() + "  " + newDate.getHours() + ":" + newDate.getMinutes();

            $("#exportPDF1N").hover(function () {
                var imageUrlM = document.getElementById("imgPresuGrafica02M").src + "&pdf=si";
                convertImgToDataURLviaCanvas(imageUrlM, function (base64Img) {
                    imgM = base64Img;
                });
            });

            $("#exportPDF1N").on('click', function () {
                var docDefinition2 = {
                    //pageOrientation: 'landscape',
                    info: {
                        title: 'ejecucion_gasto_' + (response.ejec === "00" ? "pliego459" : response.ejec) + '_' + response.año + '_mensualizada' + titleM[1]
                    },
                    pageMargins: [20, 60, 20, 40],
                    header: {
                        margin: 10,
                        table: {
                            widths: [15, '*', '*', 15],
                            body: [
                                [
                                    "",
                                    {image: img_system, width: 102, alignment: 'left'},
                                    {image: img_grsm, width: 70, alignment: 'right'},
                                    ""
                                ]
                            ]
                        },
                        layout: {
                            hLineColor: 'white',
                            vLineColor: 'white'
                        }
                    },
                    footer: {
                        margin: 10,
                        table: {
                            widths: ['*', 20],
                            body: [
                                [
                                    {text: 'Fecha y Hora : ' + tiempo, alignment: 'right', style: 'pie'},
                                    ""
                                ]
                            ]
                        },
                        layout: {
                            hLineColor: 'white',
                            vLineColor: 'white'
                        }
                    },
                    content: [
                        {
                            table: {
                                widths: ['*'],
                                body: [
                                    [
                                        {text: 'EJECUCIÓN DE GASTO ' + response.año + " - MENSUALIZADO" + titleM[0] + '\n' + response.tituloPDF + '\n', alignment: 'center', style: 'titulo'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            text: '\nTabla Resumen de Ejecución', alignment: 'left', style: 'subtitulo'
                        },
                        {
                            text: '\n'
                        },
                        {
                            table: {
                                widths: [60, '*'],
                                body: muestra1
                            },
                            layout: {
                                hLineColor: '#ECECEC',
                                vLineColor: '#ECECEC'
                            }
                        },
                        {
                            text: '\n'
                        },
                        {
                            table: {
                                widths: [30, 60, '*', '*', '*', '*', '*', '*'],
                                body: muestra2
                            },
                            layout: {
                                hLineColor: '#ECECEC',
                                vLineColor: '#ECECEC'
                            }
                        },
                        {
                            text: '\n\n'
                        },
                        {
                            table: {
                                widths: ['*'],
                                body: [
                                    [
                                        {text: 'Gráfica de Ejecución', alignment: 'left', style: 'subtitulo'}
                                    ],
                                    [
                                        {image: imgM, fit: [520, 300], alignment: 'left'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        }
                    ],
                    styles: {
                        titulo: {
                            fontSize: 8,
                            bold: true
                        },
                        subtitulo: {
                            fontSize: 8
                        },
                        tablaHead: {
                            color: 'white',
                            fillColor: '#426993',
                            fontSize: 6,
                            bold: true
                        },
                        tablaBody: {
                            fontSize: 5
                        },
                        tablaTotal: {
                            fillColor: '#F6F6F6',
                            fontSize: 6,
                            bold: true
                        },
                        pie: {
                            fontSize: 6
                        }
                    }
                };
                pdfMake.createPdf(docDefinition2).open();
            });
        }

    } else {
        $("#lblPresuFiltGrafico").addClass("oculto");
        $("#divPresuFiltGrafico").addClass("oculto");
        $("#divPresuFiltGrafico").empty();
        $("#divPresuGrafica").addClass("oculto");
        $("#divPresuGrafica").empty();
        var array = response.array;
        var size = 1;
        var muestra = [];
        var label = nombresCortos02(tipo);
        var title = nombresLargos02(tipo);
        cuerpo = '<table id="tablaPresu" class="display" cellspacing="0" width="100%">\
                    <thead id="tablaPresuHead"></thead>\
                    <tbody id="tablaPresuBody"></tbody>\
                    <tfoot id="tablaPresuFoot"></tfoot>\
                  </table>';
        $("#divPresuTabla").append(cuerpo);
        var countIniT = 0;
        var muestraHead = [];
        var anchos = [];
        head = "<tr>";
        if (response.total) {
            head += "<th>" + label[0] + "</th>";
            muestraHead.push({text: label[0], style: 'tablaHead', alignment: 'center'});
            anchos.push(45);
            countIniT += 1;
        } else {
            head += "<th>" + label[0] + "</th>\
                     <th>" + label[1] + "</th>";
            muestraHead.push({text: label[0], style: 'tablaHead', alignment: 'center'});
            muestraHead.push({text: label[1], style: 'tablaHead', alignment: 'center'});
            anchos.push(35);
            anchos.push(200);
            size += 1;
            countIniT += 2;
            if (tipo === "02") {
                head += "<th>Código Inversión</th>";
                muestraHead.push({text: "Código Inversión", style: 'tablaHead', alignment: 'center'});
                anchos.push(30);
                size += 1;
                countIniT += 1;
            }
        }
        for (var i = 0; i < array.length; i++) {
            var tittle = nombresTitulo02(array[i]);
            head += "<th>" + tittle[0] + "</th>\
                     <th>" + tittle[1] + "</th>";
            muestraHead.push({text: tittle[0], style: 'tablaHead', alignment: 'center'});
            anchos.push(35);
            size += 2;
            countIniT += 2;
        }
        head += "<th>PIA</th>\
                <th>Modificaciones</th>\
                <th>PIM (P)</th>\
                <th>Certificado (C)</th>\
                <th>Compromiso Anual (CoA)</th>\
                <th>Compromiso (Co)</th>\
                <th>Devengado (D)</th>\
                <th>Girado (G)</th>\
                <th>Pagado (Pa)</th>\
                <th>Saldo por Certificar (P - C)</th>\
                <th>% Certificado (C/P)</th>\
                <th>Saldo por Comprometer Anual (P - CoA)</th>\
                <th>% Comprometido Anual (CoA/P)</th>\
                <th>Saldo por Comprometer (P - Co)</th>\
                <th>% Comprometido (Co/P)</th>\
                <th>Saldo por Ejecutar (P - D)</th>\
                <th>% Ejecución (D/P)</th>\
                <th>Saldo por Girar (P - G)</th>\
                <th>% Girado (G/P)</th>\
                <th>Saldo por Pagar (P - Pa)</th>\
                <th>% Pagado (Pa/P)</th>\
               </tr>";
        $("#tablaPresuHead").append(head);
        muestraHead.push({text: 'PIM', style: 'tablaHead', alignment: 'center'});
        muestraHead.push({text: 'Certificado', style: 'tablaHead', alignment: 'center'});
        muestraHead.push({text: 'Compromiso Anual', style: 'tablaHead', alignment: 'center'});
        muestraHead.push({text: 'Compromiso', style: 'tablaHead', alignment: 'center'});
        muestraHead.push({text: 'Devengado', style: 'tablaHead', alignment: 'center'});
        muestraHead.push({text: 'Girado', style: 'tablaHead', alignment: 'center'});
        muestraHead.push({text: 'Pagado', style: 'tablaHead', alignment: 'center'});
        muestraHead.push({text: '% Avance', style: 'tablaHead', alignment: 'center'});
        muestra.push(muestraHead);
        anchos.push('*');
        anchos.push('*');
        anchos.push('*');
        anchos.push('*');
        anchos.push('*');
        anchos.push('*');
        anchos.push('*');
        anchos.push(30);
        var count = 0;
        var piaT, modT, pimT, certT, compAT, compT, devenT, giraT, pagaT;
        piaT = modT = pimT = certT = compAT = compT = devenT = giraT = pagaT = 0.00;
        $.each(response.list, function (index, value) {
            count++;
            var pia, mod, pim, cert, cert_saldo, cert_porc, compA, compA_saldo, compA_porc, comp, comp_saldo, comp_porc,
                    deven, deven_saldo, deven_porc, gira, gira_saldo, gira_porc, paga, paga_saldo, paga_porc;
            if (!$.trim(value.pia)) {
                pia = 0.00;
            } else {
                pia = value.pia;
                piaT += value.pia;
            }
            if (!$.trim(value.modificacion)) {
                mod = 0.00;
            } else {
                mod = value.modificacion;
                modT += value.modificacion;
            }
            if (!$.trim(value.pim)) {
                pim = 0.00;
            } else {
                pim = value.pim;
                pimT += value.pim;
            }
            if (!$.trim(value.certificado)) {
                cert = 0.00;
                cert_saldo = pim;
                cert_porc = 0.00;
            } else {
                cert = value.certificado;
                certT += value.certificado;
                cert_saldo = pim - value.certificado;
                cert_porc = (value.certificado / pim) * 100;
            }
            if (!$.trim(value.compromiso_anual)) {
                compA = 0.00;
                compA_saldo = pim;
                compA_porc = 0.00;
            } else {
                compA = value.compromiso_anual;
                compAT += value.compromiso_anual;
                compA_saldo = pim - value.compromiso_anual;
                compA_porc = (value.compromiso_anual / pim) * 100;
            }
            if (!$.trim(value.compromiso)) {
                comp = 0.00;
                comp_saldo = pim;
                comp_porc = 0.00;
            } else {
                comp = value.compromiso;
                compT += value.compromiso;
                comp_saldo = pim - value.compromiso;
                comp_porc = (value.compromiso / pim) * 100;
            }
            if (!$.trim(value.devengado)) {
                deven = 0.00;
                deven_saldo = pim;
                deven_porc = 0.00;
            } else {
                deven = value.devengado;
                devenT += value.devengado;
                deven_saldo = pim - value.devengado;
                deven_porc = (value.devengado / pim) * 100;
            }
            if (!$.trim(value.girado)) {
                gira = 0.00;
                gira_saldo = pim;
                gira_porc = 0.00;
            } else {
                gira = value.girado;
                giraT += value.girado;
                gira_saldo = pim - value.girado;
                gira_porc = (value.girado / pim) * 100;
            }
            if (!$.trim(value.pagado)) {
                paga = 0.00;
                paga_saldo = pim;
                paga_porc = 0.00;
            } else {
                paga = value.pagado;
                pagaT += value.pagado;
                paga_saldo = pim - value.pagado;
                paga_porc = (value.pagado / pim) * 100;
            }
            var muestraBody = [];
            if (tipo === "00") {
                var nombre_ejec = (value.nombre).split("-");
                body = "<tr>\
                 <td class='center'>UE " + value.ejecutora.trim() + "</td>\
                 <td class='left'>" + nombre_ejec[1].trim() + " (" + value.sec_ejec.trim() + ")</td>";
                muestraBody.push({text: "UE " + value.ejecutora.trim(), style: 'tablaBody', alignment: 'center'});
                muestraBody.push({text: nombre_ejec[1].trim() + " (" + value.sec_ejec.trim() + ")", style: 'tablaBody', alignment: 'left'});
            } else {
                body = "<tr>";
                if (response.total) {
                    body += "<td class='center'>" + response.descripcion + "</td>";
                    muestraBody.push({text: response.descripcion, style: 'tablaBody', alignment: 'center'});
                } else {
                    body += "<td class='center'>" + value.codigo + "</td>\
                             <td class='left'>" + value.nombre + "</td>";
                    muestraBody.push({text: value.codigo, style: 'tablaBody', alignment: 'center'});
                    muestraBody.push({text: value.nombre, style: 'tablaBody', alignment: 'left'});
                    if (tipo === "02") {
                        body += "<td class='center'>" + value.proyecto_snip + "</td>";
                        muestraBody.push({text: value.proyecto_snip, style: 'tablaBody', alignment: 'center'});
                    }
                }
            }
            for (var j = 0; j < array.length; j++) {
                var bodyArray = nombresBody02(array[j], value);
                body += bodyArray[0];
                muestraBody.push({text: bodyArray[1], style: 'tablaBody', alignment: 'center'});
            }
            body += "<td class='right'>" + formatNumero(pia) + "</td>\
                        <td class='right'>" + formatNumero(mod) + "</td>\
                        <td class='right'>" + formatNumero(pim) + "</td>\
                        <td class='right'>" + formatNumero(cert) + "</td>\
                        <td class='right'>" + formatNumero(compA) + "</td>\
                        <td class='right'>" + formatNumero(comp) + "</td>\
                        <td class='right'>" + formatNumero(deven) + "</td>\
                        <td class='right'>" + formatNumero(gira) + "</td>\
                        <td class='right'>" + formatNumero(paga) + "</td>\
                        <td class='right'>" + formatNumero(cert_saldo) + "</td>\
                        <td class='center'>" + formatNumero(cert_porc) + "</td>\
                        <td class='right'>" + formatNumero(compA_saldo) + "</td>\
                        <td class='center'>" + formatNumero(compA_porc) + "</td>\
                        <td class='right'>" + formatNumero(comp_saldo) + "</td>\
                        <td class='center'>" + formatNumero(comp_porc) + "</td>\
                        <td class='right'>" + formatNumero(deven_saldo) + "</td>\
                        <td class='center'>" + formatNumero(deven_porc) + "</td>\
                        <td class='right'>" + formatNumero(gira_saldo) + "</td>\
                        <td class='center'>" + formatNumero(gira_porc) + "</td>\
                        <td class='right'>" + formatNumero(paga_saldo) + "</td>\
                        <td class='center'>" + formatNumero(paga_porc) + "</td>\
                       </tr>";
            $("#tablaPresuBody").append(body);
            muestraBody.push({text: formatNumero(pim), style: 'tablaBody', alignment: 'right'});
            muestraBody.push({text: formatNumero(cert), style: 'tablaBody', alignment: 'right'});
            muestraBody.push({text: formatNumero(compA), style: 'tablaBody', alignment: 'right'});
            muestraBody.push({text: formatNumero(comp), style: 'tablaBody', alignment: 'right'});
            muestraBody.push({text: formatNumero(deven), style: 'tablaBody', alignment: 'right'});
            muestraBody.push({text: formatNumero(gira), style: 'tablaBody', alignment: 'right'});
            muestraBody.push({text: formatNumero(paga), style: 'tablaBody', alignment: 'right'});
            muestraBody.push({text: formatNumero(deven_porc) + " %", style: 'tablaBody', alignment: 'right'});
            muestra.push(muestraBody);
        });
        var muestraBodyT = [];
        if (response.total) {
            muestraBodyT.push({text: 'TOTAL', style: 'tablaTotal', alignment: 'right', colSpan: (1 + array.length)});
        } else {
            if (tipo === "02") {
                muestraBodyT.push({text: 'TOTAL', style: 'tablaTotal', alignment: 'right', colSpan: (3 + array.length)});
                muestraBodyT.push("");
                muestraBodyT.push("");
            } else {
                muestraBodyT.push({text: 'TOTAL', style: 'tablaTotal', alignment: 'right', colSpan: (2 + array.length)});
                muestraBodyT.push("");
            }
        }
        for (var k = 0; k < array.length; k++) {
            muestraBodyT.push("");
        }
        foot = "<tr class='total'>\
                    <td colspan='" + size + "' class='right'><b>TOTAL</b></td>\
                    <td class='right'><b>" + formatNumero(piaT) + "</b></td>\
                    <td class='right'><b>" + formatNumero(modT) + "</b></td>\
                    <td class='right'><b>" + formatNumero(pimT) + "</b></td>\
                    <td class='right'><b>" + formatNumero(certT) + "</b></td>\
                    <td class='right'><b>" + formatNumero(compAT) + "</b></td>\
                    <td class='right'><b>" + formatNumero(compT) + "</b></td>\
                    <td class='right'><b>" + formatNumero(devenT) + "</b></td>\
                    <td class='right'><b>" + formatNumero(giraT) + "</b></td>\
                    <td class='right'><b>" + formatNumero(pagaT) + "</b></td>\
                    <td class='right'><b>" + formatNumero(pimT - certT) + "</b></td>\
                    <td class='center'><b>" + formatNumero((certT / pimT) * 100) + "</b></td>\
                    <td class='right'><b>" + formatNumero(pimT - compAT) + "</b></td>\
                    <td class='center'><b>" + formatNumero((compAT / pimT) * 100) + "</b></td>\
                    <td class='right'><b>" + formatNumero(pimT - compT) + "</b></td>\
                    <td class='center'><b>" + formatNumero((compT / pimT) * 100) + "</b></td>\
                    <td class='right'><b>" + formatNumero(pimT - devenT) + "</b></td>\
                    <td class='center'><b>" + formatNumero((devenT / pimT) * 100) + "</b></td>\
                    <td class='right'><b>" + formatNumero(pimT - giraT) + "</b></td>\
                    <td class='center'><b>" + formatNumero((giraT / pimT) * 100) + "</b></td>\
                    <td class='right'><b>" + formatNumero(pimT - pagaT) + "</b></td>\
                    <td class='center'><b>" + formatNumero((pagaT / pimT) * 100) + "</b></td>\
                </tr>";
        $("#tablaPresuFoot").append(foot);
        muestraBodyT.push({text: formatNumero(pimT), style: 'tablaTotal', alignment: 'right'});
        muestraBodyT.push({text: formatNumero(certT), style: 'tablaTotal', alignment: 'right'});
        muestraBodyT.push({text: formatNumero(compAT), style: 'tablaTotal', alignment: 'right'});
        muestraBodyT.push({text: formatNumero(compT), style: 'tablaTotal', alignment: 'right'});
        muestraBodyT.push({text: formatNumero(devenT), style: 'tablaTotal', alignment: 'right'});
        muestraBodyT.push({text: formatNumero(giraT), style: 'tablaTotal', alignment: 'right'});
        muestraBodyT.push({text: formatNumero(pagaT), style: 'tablaTotal', alignment: 'right'});
        muestraBodyT.push({text: formatNumero((devenT / pimT) * 100) + "%", style: 'tablaTotal', alignment: 'right'});
        muestra.push(muestraBodyT);
        var columnasIni = "[";
        var countMarco = 0;
        var countMarcoT = 0;
        var columnasMarco = "";
        $("input[name=marco]").each(function () {
            if (this.checked === false) {
                var valor;
                if (response.total) {
                    valor = Number.parseInt(this.value, 10) - 1;
                } else {
                    if (tipo === "02") {
                        valor = Number.parseInt(this.value, 10) + 1;
                    } else {
                        valor = this.value;
                    }
                }
                countMarco++;
                if (array.length > 0) {
                    columnasMarco += (Number.parseInt(valor, 10) + (array.length * 2)) + ", ";
                } else {
                    columnasMarco += valor + ", ";
                }
            } else {
                countMarcoT++;
            }
        });
        var countFase = 0;
        var countFaseT = 0;
        var columnasFase = "";
        $("input[name=fase]").each(function () {
            if (this.checked === false) {
                var valor;
                if (response.total) {
                    valor = Number.parseInt(this.value, 10) - 1;
                } else {
                    if (tipo === "02") {
                        valor = Number.parseInt(this.value, 10) + 1;
                    } else {
                        valor = this.value;
                    }
                }
                countFase++;
                if (array.length > 0) {
                    columnasFase += (Number.parseInt(valor, 10) + (array.length * 2)) + ", ";
                } else {
                    columnasFase += valor + ", ";
                }
            } else {
                countFaseT++;
            }
        });
        var countSaldo = 0;
        var countSaldoT = 0;
        var columnasSaldo = "";
        $("input[name=saldo]").each(function () {
            if (this.checked === false) {
                var valor;
                if (response.total) {
                    valor = Number.parseInt(this.value, 10) - 1;
                } else {
                    if (tipo === "02") {
                        valor = Number.parseInt(this.value, 10) + 1;
                    } else {
                        valor = this.value;
                    }
                }
                countSaldo++;
                if (array.length > 0) {
                    columnasSaldo += (Number.parseInt(valor, 10) + (array.length * 2)) + ", " + (Number.parseInt(valor, 10) + (array.length * 2) + 1) + ", ";
                } else {
                    columnasSaldo += valor + ", " + (Number.parseInt(valor, 10) + 1) + ", ";
                }
            } else {
                countSaldoT++;
            }
        });
        var columnasFin = "]";
        if (countSaldo !== 0) {
            columnasSaldo = columnasSaldo.substring(0, columnasSaldo.length - 2);
        } else {
            if (countFase !== 0) {
                columnasFase = columnasFase.substring(0, columnasFase.length - 2);
            } else {
                if (countMarco !== 0) {
                    columnasMarco = columnasMarco.substring(0, columnasMarco.length - 2);
                }
            }
        }
        var columnas = columnasIni + columnasMarco + columnasFase + columnasSaldo + columnasFin;
        var countT = countIniT + countMarcoT + countFaseT + (countSaldoT * 2);
        var columnasObject = JSON.parse(columnas); // Aca se hace un parse de JS String a JS Object para que pueda ser reconocido
        $('#tablaPresu').dataTable({
            columnDefs: [
                {targets: columnasObject, visible: false},
                {targets: '_all', visible: true}
            ],
            ordering: true,
            dom: '<"centrar-div-tabla"lB>iprtip',
            buttons: [
                {
                    extend: 'colvis',
                    columnText: function (dt, idx, title) {
                        return (idx + 1) + '.- ' + title;
                    },
                    postfixButtons: ['colvisRestore'],
                    collectionLayout: 'fixed three-column'
                },
                {
                    extend: 'excel',
                    footer: true,
                    filename: 'ejecucion_gasto_' + (response.ejec === "00" ? "pliego459" : response.ejec) + '_' + response.año + '_filtrado_por_' + label[0],
                    title: 'EJECUCIÓN DE GASTO ' + response.año + title,
                    messageTop: response.tituloPDF,
                    exportOptions: {
                        orthogonal: 'sort',
                        columns: ':visible'
                    },
                    customize: function (xlsx) {
                        var sheet = xlsx.xl.worksheets['sheet1.xml'];
                        for (var k = countIniT; k < countIniT + countMarcoT; k++) {
                            var total = $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).length;
                            $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).each(function (i) {
                                if (i > 0 && i < total - 1) {
                                    $(this).attr('s', '72');
                                }
                                if (i === total - 1) {
                                    $(this).attr('s', '75');
                                }
                            });
                        }
                        for (var k = countIniT + countMarcoT; k < countIniT + countMarcoT + countFaseT; k++) {
                            var total = $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).length;
                            $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).each(function (i) {
                                if (i > 0 && i < total - 1) {
                                    $(this).attr('s', '72');
                                }
                                if (i === total - 1) {
                                    $(this).attr('s', '75');
                                }
                            });
                        }
                        for (var k = countIniT + countMarcoT + countFaseT; k < countT; k++) {
                            var total = $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).length;
                            if ((k - countIniT + countMarcoT + countFaseT) % 2 === 0) {
                                $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).each(function (i) {
                                    if (i > 0 && i < total - 1) {
                                        $(this).attr('s', '72');
                                    }
                                    if (i === total - 1) {
                                        $(this).attr('s', '75');
                                    }
                                });
                            } else {
                                $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).each(function (i) {
                                    if (i > 0 && i < total - 1) {
                                        $(this).attr('s', '73');
                                    }
                                    if (i === total - 1) {
                                        $(this).attr('s', '76');
                                    }
                                });
                            }
                        }
                    }
                }
            ]
        });
        btnPDF = '<button id="exportPDF" class="dt-button buttons-html5">\
                    <span>\
                        <img src="./templates/plugins/datatables/images/pdf.png" data-toggle="tooltip" data-placement="bottom" title="Exportar a PDF">\
                    </span>\
                  </button>';
        $("#tablaPresu_wrapper .dt-buttons").append(btnPDF);

        ///////////////// Exportar a PDF ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   

        var imageUrl_grsm = './resources/images/logo_grsm.png';
        var imageUrl_system = './resources/images/logo_sirsm.png';
        var img_grsm, img_system;
        convertImgToDataURLviaCanvas(imageUrl_grsm, function (base64Img) {
            img_grsm = base64Img;
        });
        convertImgToDataURLviaCanvas(imageUrl_system, function (base64Img) {
            img_system = base64Img;
        });
        var newDate = new Date();
        var tiempo = newDate.getDate() + "/" + newDate.getMonth() + "/" + newDate.getFullYear() + "  " + newDate.getHours() + ":" + newDate.getMinutes();

        $("#exportPDF").on('click', function () {
            var docDefinition = {
                pageOrientation: 'landscape',
                info: {
                    title: 'ejecucion_gasto_' + response.ejec + '_' + response.año + '_filtrado_por_' + label[0]
                },
                pageMargins: [20, 60, 20, 40],
                header: {
                    margin: 10,
                    table: {
                        widths: [15, '*', '*', 15],
                        body: [
                            [
                                "",
                                {image: img_system, width: 102, alignment: 'left'},
                                {image: img_grsm, width: 70, alignment: 'right'},
                                ""
                            ]
                        ]
                    },
                    layout: {
                        hLineColor: 'white',
                        vLineColor: 'white'
                    }
                },
                footer: {
                    margin: 10,
                    table: {
                        widths: ['*', 20],
                        body: [
                            [
                                {text: 'Fecha y Hora : ' + tiempo, alignment: 'right', style: 'pie'},
                                ""
                            ]
                        ]
                    },
                    layout: {
                        hLineColor: 'white',
                        vLineColor: 'white'
                    }
                },
                content: [
                    {
                        table: {
                            widths: ['*'],
                            body: [
                                [
                                    {text: 'EJECUCIÓN DE GASTO ' + response.año + title + '\n' + response.tituloPDF + '\n', alignment: 'center', style: 'titulo'}
                                ]
                            ]
                        },
                        layout: {
                            hLineColor: 'white',
                            vLineColor: 'white'
                        }
                    },
                    {
                        text: '\n\nTabla Resumen de Ejecución', alignment: 'left', style: 'subtitulo'
                    },
                    {
                        text: '\n'
                    },
                    {
                        table: {
                            widths: anchos,
                            body: muestra
                        },
                        layout: {
                            hLineColor: '#ECECEC',
                            vLineColor: '#ECECEC'
                        }
                    }
                ],
                styles: {
                    titulo: {
                        fontSize: 8,
                        bold: true
                    },
                    subtitulo: {
                        fontSize: 8
                    },
                    tablaHead: {
                        color: 'white',
                        fillColor: '#426993',
                        fontSize: 6,
                        bold: true
                    },
                    tablaBody: {
                        fontSize: 5
                    },
                    tablaTotal: {
                        fillColor: '#F6F6F6',
                        fontSize: 6,
                        bold: true
                    },
                    pie: {
                        fontSize: 6
                    }
                }
            };
            pdfMake.createPdf(docDefinition).open();
        });
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    }
}

function llenarFiltroGrafico02() {
    $("#divPresuFiltGrafico").empty();
    faseG02 = '<div class="form-row">\
              <label class="col-sm-2">Seleccione una Fase :</label>&nbsp;';
    faseG02 += '<div class="col-auto fontweight3">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="faseg" value="C">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Certificado</span>\
            </label>\
            </div>';
    faseG02 += '<div class="col-auto fontweight3">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="faseg" value="CoA">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Compromiso Anual</span>\
            </label>\
            </div>';
    faseG02 += '<div class="col-auto fontweight3">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="faseg" value="Co">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Compromiso</span>\
            </label>\
            </div>';
    faseG02 += '<div class="col-auto fontweight3">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="faseg" value="D" checked>\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Devengado</span>\
            </label>\
            </div>';
    faseG02 += '<div class="col-auto fontweight3">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="faseg" value="G">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Girado</span>\
            </label>\
            </div>';
    faseG02 += '<div class="col-auto fontweight3">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="faseg" value="P">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Pagado</span>\
            </label>\
            </div>';
    faseG02 += '</div>';
    $("#divPresuFiltGrafico").append(faseG02);
}

function llenarGrafico02(src) {
    $("#divPresuGrafica").empty();
    var imgG02 = '<img id="imgPresuGrafica02M" src="' + src + '"/>';
    $("#divPresuGrafica").append(imgG02);
}

function cambiaFiltroGrafico02(meses, arrayC, arrayCoA, arrayCo, arrayD, arrayG, arrayP, titulo, subtitulo) {
    $("input[name=faseg]").change(function () {
        if (this.checked) {
            $("input[name=faseg]").prop("checked", false);
            $("input[value=" + this.value + "]").prop("checked", true);
            if (this.value === "C") {
                llenarGrafico02("./Presupuesto?tipo=02&graph=true" + meses + arrayC + "&titu=" + titulo + "&subtitu=" + subtitulo + "&ancho=1000&alto=600&font=10&bar=0.06&pos=out&fase=C");
            }
            if (this.value === "CoA") {
                llenarGrafico02("./Presupuesto?tipo=02&graph=true" + meses + arrayCoA + "&titu=" + titulo + "&subtitu=" + subtitulo + "&ancho=1000&alto=600&font=10&bar=0.06&pos=out&fase=CoA");
            }
            if (this.value === "Co") {
                llenarGrafico02("./Presupuesto?tipo=02&graph=true" + meses + arrayCo + "&titu=" + titulo + "&subtitu=" + subtitulo + "&ancho=1000&alto=600&font=10&bar=0.06&pos=out&fase=Co");
            }
            if (this.value === "D") {
                llenarGrafico02("./Presupuesto?tipo=02&graph=true" + meses + arrayD + "&titu=" + titulo + "&subtitu=" + subtitulo + "&ancho=1000&alto=600&font=10&bar=0.06&pos=out&fase=D");
            }
            if (this.value === "G") {
                llenarGrafico02("./Presupuesto?tipo=02&graph=true" + meses + arrayG + "&titu=" + titulo + "&subtitu=" + subtitulo + "&ancho=1000&alto=600&font=10&bar=0.06&pos=out&fase=G");
            }
            if (this.value === "P") {
                llenarGrafico02("./Presupuesto?tipo=02&graph=true" + meses + arrayP + "&titu=" + titulo + "&subtitu=" + subtitulo + "&ancho=1000&alto=600&font=10&bar=0.06&pos=out&fase=P");
            }
        } else {
            $("input[value=" + this.value + "]").prop("checked", true);
        }
    });
}




