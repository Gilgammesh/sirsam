// Reporte de Recaudación de Ingresos Anual

function FiltroReporte07() {
    alert("funciona filtro07");
}

function llenarFiltroReporte07() {
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
                            <option value="01">Mensualizado</option>\
                            <option value="02">Fuente de Financiamiento</option>\
                            <option value="03">Rubro de Financiamiento</option>\
                            <option value="04">Categoría de Ingreso</option>\
                            <option value="05">Genérica de Ingreso</option>\
                            <option value="06">SubGenérica de Ingreso</option>\
                            <option value="07">SubGenérica Detallada de Ingreso</option>\
                            <option value="08">Específica de Ingreso</option>\
                            <option value="09">Específica Detallada de Ingreso</option>\
                            <option value="10">Banco</option>\
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
                                        <li id="lifiltS_01"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="01" name="filtroS_ejecutora">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Unidad Ejecutora</span>\
                                        </label></li>\
                                        <li id="lifiltS_02"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="02" name="filtroS_fuente">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Fuente de Financiamiento</span>\
                                        </label></li>\
                                        <li id="lifiltS_03"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="03" name="filtroS_rubro">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Rubro de Financiamiento</span>\
                                        </label></li>\
                                        <li id="lifiltS_04"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="04" name="filtroS_catingre">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Categoría de Ingreso</span>\
                                        </label></li>\
                                        <li id="lifiltS_05"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="05" name="filtroS_generica">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Genérica de Ingreso</span>\
                                        </label></li>\
                                        <li id="lifiltS_06"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="06" name="filtroS_subgenerica">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">SubGenérica de Ingreso</span>\
                                        </label></li>\
                                        <li id="lifiltS_07"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="07" name="filtroS_subgenericadet">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">SubGenérica Detallada de Ingreso</span>\
                                        </label></li>\
                                        <li id="lifiltS_08"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="08" name="filtroS_especifica">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Específica de Ingreso</span>\
                                        </label></li>\
                                        <li id="lifiltS_09"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="09" name="filtroS_especificadet">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Específica Detallada de Ingreso</span>\
                                        </label></li>\
                                        <li id="lifiltS_10"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="10" name="filtroS_banco">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Banco</span>\
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
                                            <input type="checkbox" class="custom-control-input" value="01" name="filtroMensual_fuente">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Fuente de Financiamiento</span>\
                                        </label></li>\
                                        <li id="lifiltMensual_02"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="02" name="filtroMensual_rubro">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Rubro de Financiamiento</span>\
                                        </label></li>\
                                        <li id="lifiltMensual_03"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="03" name="filtroMensual_catingre">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Categoría de Ingreso</span>\
                                        </label></li>\
                                        <li id="lifiltMensual_04"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="04" name="filtroMensual_generica">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Genérica de Ingreso</span>\
                                        </label></li>\
                                        <li id="lifiltMensual_05"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="05" name="filtroMensual_subgenerica">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">SubGenérica de Ingreso</span>\
                                        </label></li>\
                                        <li id="lifiltMensual_06"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="06" name="filtroMensual_subgenericadet">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">SubGenérica Detallada de Ingreso</span>\
                                        </label></li>\
                                        <li id="lifiltMensual_07"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="07" name="filtroMensual_especifica">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Específica de Ingreso</span>\
                                        </label></li>\
                                        <li id="lifiltMensual_08"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="08" name="filtroMensual_especificadet">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Específica Detallada de Ingreso</span>\
                                        </label></li>\
                                        <li id="lifiltMensual_09"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="09" name="filtroMensual_banco">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Banco</span>\
                                        </label></li>\
                                        <li id="lifiltMensual_10"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="10" name="filtroMensual_tiporecur">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Tipo de Recurso</span>\
                                        </label></li>\
                                        <li id="lifiltMensual_11"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="11" name="filtroMensual_ctacte">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Cuenta Corriente</span>\
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
                                <a>\
                                    <label id="lblSelectPrinc"></label>\
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
    filtro += '<div id="divFiltroTipoRecurso" class="form-group row oculto"></div>';
    filtro += '<div id="divFiltroCuentaCorriente" class="form-group row oculto"></div>';
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
    botones = '<div class="form-row line_top20">\
                <label class="col-sm-2"></label>\
                <div class="col-auto">\
                <button type="submit" class="btn btn3d btn-danger btn-m">\
                <span class="glyphicon glyphicon-play spanBtn"></span>Generar\
                </button>\
                </div>\
                <div class="col-auto">\
                <button id="btnRepoPresu07" type="reset" value="Reset" class="btn btn3d btn-white btn-m">\
                <span class="glyphicon glyphicon-erase spanBtn"></span>Limpiar\
                </button>\
                </div>\
                </div>';
    html = filtro + marco + botones;
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
        $("#dlFiltTipoRecurso.dropdownF dd ul").hide();
        $("#dlFiltCuentaCorriente.dropdownF dd ul").hide();
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
        $("#dlFiltTipoRecurso.dropdownF dd ul").hide();
        $("#dlFiltCuentaCorriente.dropdownF dd ul").hide();
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

function limpiarCheckFiltroSecun07() {
    $("#dlFiltSecun input").prop("checked", false);
    $("#lifiltS_00 input").prop("checked", true);
    $("#dlFiltSecunMensual input").prop("checked", false);
    $("#lifiltMensual_00 input").prop("checked", true);
}

function controlFiltroReporte07() {
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
            llenarAñoEjecIngreso($('#listPresuEjecutora').val(), mensual_val);
        }
    });
    $("#listPresuEjecutora").bind("change", function () {
        var ejec = $('#listPresuEjecutora').val();
        llenarAñoEjecIngreso(ejec, mensual_val);
        if (ejec === "00") {
            $("#lifiltS_01").removeClass("oculto");
        } else {
            $("#lifiltS_01").addClass("oculto");
        }
    });
    $("#listPresuAño").bind("change", function () {
        var ejec = $('#listPresuEjecutora').val();
        var año = $("#listPresuAño").val();
        var valP = $("#listPresuFiltroPrinc").val();
        llenarFiltPrinc07(valP, año, ejec, mensual_val);
        if (ejec === "00") {
            $("#lifiltS_01").removeClass("oculto");
        } else {
            $("#lifiltS_01").addClass("oculto");
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
            $("#divFiltro").addClass("oculto");
            $("#lblFiltPrinc").empty();
            $("#divFiltPrinc").addClass("oculto");
            $("#lblFiltroSecundario").addClass("oculto");
            $("#divFiltroSecundario").addClass("oculto");
            $("#lblFiltroSecundarioMensual").addClass("oculto");
            $("#divFiltroSecundarioMensual").addClass("oculto");
            limpiarCheckFiltroSecun07();
            $("#divFiltroTipoRecurso").addClass("oculto");
            $("#divFiltroCuentaCorriente").addClass("oculto");
        } else if (valP === "01") {
            $("#divPresuMarco").addClass("oculto");
            $("#divPresuFase").removeClass("oculto");
            $("#divFiltro").addClass("oculto");
            $("#lblFiltPrinc").empty();
            $("#divFiltPrinc").addClass("oculto");
            $("#lblFiltroSecundario").addClass("oculto");
            $("#divFiltroSecundario").addClass("oculto");
            limpiarCheckFiltroSecun07();
            $("#lblFiltroSecundarioMensual").removeClass("oculto");
            $("#divFiltroSecundarioMensual").removeClass("oculto");
            $("#divFiltroTipoRecurso").addClass("oculto");
            $("#divFiltroCuentaCorriente").addClass("oculto");
        } else {
            $("#divPresuMarco").removeClass("oculto");
            $("#divPresuFase").removeClass("oculto");
            $("#divFiltro").removeClass("oculto");
            $("#lblFiltroSecundario").removeClass("oculto");
            $("#divFiltroSecundario").removeClass("oculto");
            $("#lblFiltroSecundarioMensual").addClass("oculto");
            $("#divFiltroSecundarioMensual").addClass("oculto");
            limpiarCheckFiltroSecun07();
            $("#lblFiltPrinc").empty();
            $("#dlFiltSecun li").removeClass("oculto");
            $("#lifiltS_" + valP).addClass("oculto");
            $("#divFiltroTipoRecurso").addClass("oculto");
            $("#divFiltroCuentaCorriente").addClass("oculto");
            if (valP === "02") {
                $("#lblFiltPrinc").append("Fuente Financiamiento");
            }
            if (valP === "03") {
                $("#lblFiltPrinc").append("Rubro Financiamiento");
            }
            if (valP === "04") {
                $("#lblFiltPrinc").append("Categoría de Ingreso");
            }
            if (valP === "05") {
                $("#lblFiltPrinc").append("Genérica");
            }
            if (valP === "06") {
                $("#lblFiltPrinc").append("SubGenérica");
            }
            if (valP === "07") {
                $("#lblFiltPrinc").append("SubGenérica Detallada");
            }
            if (valP === "08") {
                $("#lblFiltPrinc").append("Específica");
            }
            if (valP === "09") {
                $("#lblFiltPrinc").append("Específica Detallada");
            }
            if (valP === "10") {
                $("#lblFiltPrinc").append("Banco");
            }
            $("#divFiltPrinc").removeClass("oculto");
            llenarFiltPrinc07(valP, año, ejec, mensual_val);
        }
        if (ejec === "00") {
            $("#lifiltS_01").removeClass("oculto");
        } else {
            $("#lifiltS_01").addClass("oculto");
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
                                            <a style="font-weight: normal;">\
                                                <label id="lblSelectSecund_' + this.value + '"><b style="color: orangered;">--Ninguno--</b></label>\
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
                llenarFiltSecund07(this.value, añoS, ejecS);
                $("#lifiltS_00 input").prop("checked", false);
                var valdl = this.value;
                $("#dlFiltSecund_" + valdl + ".dropdownF dt a").on('click', function () {
                    $("#dlFiltPrinc.dropdownF dd ul").hide();
                    $("#dlFiltSecun.dropdownF dd ul").hide();
                    $("#dlFiltSecunMensual.dropdownF dd ul").hide();
                    $("#dlFiltTipoRecurso.dropdownF dd ul").hide();
                    $("#dlFiltCuentaCorriente.dropdownF dd ul").hide();
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
                                            <a style="font-weight: normal;">\
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
            llenarFiltSecundMensual07(this.value, añoM, ejecM);
            $("#lifiltS_00 input").prop("checked", false);
            var valdlM = this.value;
            $("#dlFiltSecundMensual_" + valdlM + ".dropdownF dt a").on('click', function () {
                $("#dlFiltPrinc.dropdownF dd ul").hide();
                $("#dlFiltSecun.dropdownF dd ul").hide();
                $("#dlFiltSecunMensual.dropdownF dd ul").hide();
                $("#dlFiltTipoRecurso.dropdownF dd ul").hide();
                $("#dlFiltCuentaCorriente.dropdownF dd ul").hide();
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
        $("#dlFiltTipoRecurso.dropdownF dd ul").hide();
        $("#dlFiltCuentaCorriente.dropdownF dd ul").hide();
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
    $("#btnRepoPresu07").click(function () {
        $("#divPresuTabla").empty();
        $("#divPresuTabla").addClass("oculto");
        $("#lblPresuFiltGrafico").addClass("oculto");
        $("#divPresuFiltGrafico").empty();
        $("#divPresuFiltGrafico").addClass("oculto");
        $("#divPresuGrafica").empty();
        $("#divPresuGrafica").addClass("oculto");
        $("#divFiltSecunMensual").empty();
        $("#divFiltrosSecundarios").empty();
        $("#divPresuMarco").removeClass("oculto");
        $("#divPresuFase").removeClass("oculto");
        $("#divFiltro").addClass("oculto");
        $("#lblFiltPrinc").empty();
        $("#divFiltPrinc").addClass("oculto");
        $("#lblFiltroSecundario").addClass("oculto");
        $("#divFiltroSecundario").addClass("oculto");
        $("#lblFiltroSecundarioMensual").addClass("oculto");
        $("#divFiltroSecundarioMensual").addClass("oculto");
        limpiarCheckFiltroSecun07();
        $("#divFiltroTipoRecurso").addClass("oculto");
        $("#divFiltroCuentaCorriente").addClass("oculto");
    });
}

function llenarFiltSecund07(val, año, ejec) {
    $("#lblFiltSecund_" + val).empty();
    if (val === "01") {
        $("#lblFiltSecund_" + val).append("Unidad Ejecutora");
    }
    if (val === "02") {
        $("#lblFiltSecund_" + val).append("Fuente Financiamiento");
    }
    if (val === "03") {
        $("#lblFiltSecund_" + val).append("Rubro Financiamiento");
    }
    if (val === "04") {
        $("#lblFiltSecund_" + val).append("Categoría de Ingreso");
    }
    if (val === "05") {
        $("#lblFiltSecund_" + val).append("Genérica");
    }
    if (val === "06") {
        $("#lblFiltSecund_" + val).append("SubGenérica");
    }
    if (val === "07") {
        $("#lblFiltSecund_" + val).append("SubGenérica Detallada");
    }
    if (val === "08") {
        $("#lblFiltSecund_" + val).append("Específica");
    }
    if (val === "09") {
        $("#lblFiltSecund_" + val).append("Específica Detallada");
    }
    if (val === "10") {
        $("#lblFiltSecund_" + val).append("Banco");
    }
    $("#ulFiltSecund_" + val).empty();
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataFiltrosIngreso&ejec=" + ejec + "&año=" + año + "&val=" + val,
        success: function (response) {
            var obje1 = '<li><label class="custom-control custom-checkbox">\
                        <input type="checkbox" class="custom-control-input" value="todo" name="filtro_todo_' + val + '">\
                        <span class="custom-control-indicator"></span>&nbsp;\
                        <span class="custom-control-description"><b>--Todas--</b></span>\
                     </label></li>';
            $("#ulFiltSecund_" + val).append(obje1);
            var size = 0;
            $.each(response.list, function (index, value) {
                size++;
                var obje2 = '';
                if (val === "10") {
                    obje2 = '<li><label class="custom-control custom-checkbox">\
                                <input id="' + value.nombre + '" type="checkbox" class="custom-control-input" value="' + value.codigo + '" name="filtro_' + val + '">\
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
            $("input[name=filtro_todo_" + val + "]").change(function () {
                $("#lblSelectSecund_" + val).empty();
                if (this.checked) {
                    $("#lblSelectSecund_" + val).append("<b>--Todas--</b>");
                    $("input[name=filtro_" + val + "]").prop("checked", true);
                }
                if (this.checked === false) {
                    $("#lblSelectSecund_" + val).append("<b style='color: orangered;'>--Ninguno--</b>");
                    $("input[name=filtro_" + val + "]").prop("checked", false);
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
                        if (val === "10") {
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
                $("#lblSelectSecund_" + val).append(text);
            });
        }
    });
}

function llenarFiltPrinc07(val, año, ejec, valM) {
    if (val === "00") {
        $("#ulFiltPrim").empty();
    } else if (val === "01") {
        if (valM === "00") {
            $("#divFiltSecunMensual").empty();
        } else {
            $("#ulFiltSecundMensual_" + valM).empty();
            $.ajax({
                dataType: 'json',
                url: "./GsonData?url=DataFiltrosMensualIngreso&ejec=" + ejec + "&año=" + año + "&val=" + valM,
                success: function (response) {
                    $.each(response.list, function (index, value) {
                        var objeM2 = '<li><label class="custom-control custom-checkbox">\
                                        <input id="' + value.nombre + '" type="checkbox" class="custom-control-input" value="' + value.codigo + '" name="filtro_' + response.val + '">\
                                        <span class="custom-control-indicator"></span>&nbsp;\
                                        <span id="spanMensual_' + value.codigo + '" class="custom-control-description">\
                                            <b>' + value.codigo + "</b> - " + value.nombre + '\
                                        </span>\
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
            url: "./GsonData?url=DataFiltrosIngreso&ejec=" + ejec + "&año=" + año + "&val=" + val,
            success: function (response) {
                var obje1 = '<li><label class="custom-control custom-checkbox">\
                                <input type="checkbox" class="custom-control-input" value="todo" name="filtro_todo">\
                                <span class="custom-control-indicator"></span>&nbsp;\
                                <span class="custom-control-description"><b>--Todas--</b></span>\
                             </label></li>';
                $("#ulFiltPrim").append(obje1);
                var size = 0;
                $.each(response.list, function (index, value) {
                    size++;
                    var obje2 = '';
                    if (val === "10") {
                        obje2 = '<li><label class="custom-control custom-checkbox">\
                                    <input id="' + value.nombre + '" type="checkbox" class="custom-control-input" value="' + value.codigo + '" name="filtro">\
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
                $("input[name=filtro_todo]").change(function () {
                    $("#lblSelectPrinc").empty();
                    if (this.checked) {
                        $("#lblSelectPrinc").append("<b>--Todas--</b>");
                        $("input[name=filtro]").prop("checked", true);
                        if (response.val === "02") {
                            llenarTipoRecurso07(ejec, año, "");
                        } else if (response.val === "10") {
                            llenarCuentaCorriente07(ejec, año, "");
                        } else {
                            $("#divFiltroTipoRecurso").addClass("oculto");
                            $("#divFiltroCuentaCorriente").addClass("oculto");
                        }
                    }
                    if (this.checked === false) {
                        $("#lblSelectPrinc").append("<b style='color: orangered;'>--Ninguno--</b>");
                        $("input[name=filtro]").prop("checked", false);
                        $("#divFiltroTipoRecurso").addClass("oculto");
                        $("#divFiltroCuentaCorriente").addClass("oculto");
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
                            if (val === "10") {
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
                    if (response.val === "02") {
                        if (count === size) {
                            llenarTipoRecurso07(ejec, año, "");
                        } else {
                            llenarTipoRecurso07(ejec, año, array);
                        }
                    } else if (response.val === "10") {
                        if (count === size) {
                            llenarCuentaCorriente07(ejec, año, "");
                        } else {
                            llenarCuentaCorriente07(ejec, año, array);
                        }
                    } else {
                        $("#divFiltroTipoRecurso").addClass("oculto");
                        $("#divFiltroCuentaCorriente").addClass("oculto");
                    }
                    $("#lblSelectPrinc").append(text);
                });
            }
        });
    }
}

function llenarFiltSecundMensual07(val, año, ejec) {
    $("#lblFiltSecundMensual_" + val).empty();
    if (val === "01") {
        $("#lblFiltSecundMensual_" + val).append("Fuente Financiamiento");
    }
    if (val === "02") {
        $("#lblFiltSecundMensual_" + val).append("Rubro Financiamiento");
    }
    if (val === "03") {
        $("#lblFiltSecundMensual_" + val).append("Categoría de Ingreso");
    }
    if (val === "04") {
        $("#lblFiltSecundMensual_" + val).append("Genérica");
    }
    if (val === "05") {
        $("#lblFiltSecundMensual_" + val).append("SubGenérica");
    }
    if (val === "06") {
        $("#lblFiltSecundMensual_" + val).append("SubGenérica Detallada");
    }
    if (val === "07") {
        $("#lblFiltSecundMensual_" + val).append("Específica");
    }
    if (val === "08") {
        $("#lblFiltSecundMensual_" + val).append("Específica Detallada");
    }
    if (val === "09") {
        $("#lblFiltSecundMensual_" + val).append("Banco");
    }
    if (val === "10") {
        $("#lblFiltSecundMensual_" + val).append("Tipo de Recurso");
    }
    if (val === "11") {
        $("#lblFiltSecundMensual_" + val).append("Cuenta Corriente");
    }
    $("#ulFiltSecundMensual_" + val).empty();
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataFiltrosMensualIngreso&ejec=" + ejec + "&año=" + año + "&val=" + val,
        success: function (response) {
            $.each(response.list, function (index, value) {
                if (response.val === "10") {
                    var objeM2 = '<li><label class="custom-control custom-checkbox">\
                                    <input id="' + value.nombre + '" type="checkbox" class="custom-control-input" value="' + value.codigo + '-' + value.fuente_financ_agregada + '" name="filtro_' + response.val + '">\
                                    <span class="custom-control-indicator"></span>&nbsp;\
                                    <span id="spanMensual_' + value.codigo + '" class="custom-control-description">\
                                        <b>' + value.codigo + "</b> - " + value.nombre + ' <b>(' + value.nombre_fuente_financ_agregada + ')</b>\
                                    </span>\
                                  </label></li>';
                    $("#ulFiltSecundMensual_" + response.val).append(objeM2);
                } else if (response.val === "11") {
                    var objeM2 = '<li><label class="custom-control custom-checkbox">\
                                    <input id="' + value.nombre + '" type="checkbox" class="custom-control-input" value="' + value.codigo + '-' + value.banco + '-' + value.ano_eje + '" name="filtro_' + response.val + '">\
                                    <span class="custom-control-indicator"></span>&nbsp;\
                                    <span id="spanMensual_' + value.codigo + '" class="custom-control-description">\
                                        <b>' + value.codigo + "</b> - " + value.nombre + ' <b>(' + value.nombre_banco + ' - ' + value.ano_eje + ')</b>\
                                    </span>\
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

function validarFiltroReporte07() {
    var msg;
    var filtP = $("#listPresuFiltroPrinc").val();
    if (filtP === "01") {
        var countFuente = 0;
        if ($("input[name=filtroMensual_fuente]").is(":checked") === true) {
            $("input[name=filtro_01]").each(function () {
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
            $("input[name=filtro_02]").each(function () {
                if (this.checked) {
                    countRubro++;
                }
            });
            if (countRubro === 0) {
                msg = "Debe seleccionar al menos un Rubro de Financiamiento";
                return(msg);
            }
        }
        var countCatIngreso = 0;
        if ($("input[name=filtroMensual_catingre]").is(":checked") === true) {
            $("input[name=filtro_03]").each(function () {
                if (this.checked) {
                    countCatIngreso++;
                }
            });
            if (countCatIngreso === 0) {
                msg = "Debe seleccionar al menos una Categoría de Ingreso";
                return(msg);
            }
        }
        var countGen = 0;
        if ($("input[name=filtroMensual_generica]").is(":checked") === true) {
            $("input[name=filtro_04]").each(function () {
                if (this.checked) {
                    countGen++;
                }
            });
            if (countGen === 0) {
                msg = "Debe seleccionar al menos una Genérica de Ingreso";
                return(msg);
            }
        }
        var countSubGen = 0;
        if ($("input[name=filtroMensual_subgenerica]").is(":checked") === true) {
            $("input[name=filtro_05]").each(function () {
                if (this.checked) {
                    countSubGen++;
                }
            });
            if (countSubGen === 0) {
                msg = "Debe seleccionar al menos una Sub Genérica de Ingreso";
                return(msg);
            }
        }
        var countSubGenDet = 0;
        if ($("input[name=filtroMensual_subgenericadet]").is(":checked") === true) {
            $("input[name=filtro_06]").each(function () {
                if (this.checked) {
                    countSubGenDet++;
                }
            });
            if (countSubGenDet === 0) {
                msg = "Debe seleccionar al menos una Sub Genérica Detallada de Ingreso";
                return(msg);
            }
        }
        var countEsp = 0;
        if ($("input[name=filtroMensual_especifica]").is(":checked") === true) {
            $("input[name=filtro_07]").each(function () {
                if (this.checked) {
                    countEsp++;
                }
            });
            if (countEsp === 0) {
                msg = "Debe seleccionar al menos una Específica de Ingreso";
                return(msg);
            }
        }
        var countEspDet = 0;
        if ($("input[name=filtroMensual_especificadet]").is(":checked") === true) {
            $("input[name=filtro_08]").each(function () {
                if (this.checked) {
                    countEspDet++;
                }
            });
            if (countEspDet === 0) {
                msg = "Debe seleccionar al menos una Específica Detallada de Ingreso";
                return(msg);
            }
        }
        var countBanco = 0;
        if ($("input[name=filtroMensual_banco]").is(":checked") === true) {
            $("input[name=filtro_09]").each(function () {
                if (this.checked) {
                    countBanco++;
                }
            });
            if (countBanco === 0) {
                msg = "Debe seleccionar al menos un Banco";
                return(msg);
            }
        }
        var countTipoRecurso = 0;
        if ($("input[name=filtroMensual_tiporecur]").is(":checked") === true) {
            $("input[name=filtro_10]").each(function () {
                if (this.checked) {
                    countTipoRecurso++;
                }
            });
            if (countTipoRecurso === 0) {
                msg = "Debe seleccionar al menos un Tipo de Recurso";
                return(msg);
            }
        }
        var countCtaCte = 0;
        if ($("input[name=filtroMensual_ctacte]").is(":checked") === true) {
            $("input[name=filtro_11]").each(function () {
                if (this.checked) {
                    countCtaCte++;
                }
            });
            if (countCtaCte === 0) {
                msg = "Debe seleccionar al menos una Cuenta Corriente";
                return(msg);
            }
        }
        msg = "OK";
        return(msg);
    } else {
        var countFiltro = 0;
        var countMarco = 0;
        $("input[name=filtro]").each(function () {
            if (this.checked) {
                countFiltro++;
            }
        });
        $("input[name=marco]").each(function () {
            if (this.checked) {
                countMarco++;
            }
        });
        if (countMarco === 0) {
            msg = "Debe seleccionar al menos un Marco Presupuestal";
            return(msg);
        }
        if (filtP === "00") {
            msg = "OK";
            return(msg);
        }
        if (filtP !== "00") {
            if (countFiltro === 0) {
                if (filtP === "02") {
                    msg = "Debe seleccionar al menos una Fuente de Financiamiento";
                }
                if (filtP === "03") {
                    msg = "Debe seleccionar al menos un Rubro de Financiamiento";
                }
                if (filtP === "04") {
                    msg = "Debe seleccionar al menos una Categoría de Ingreso";
                }
                if (filtP === "05") {
                    msg = "Debe seleccionar al menos una Genérica de Ingreso";
                }
                if (filtP === "06") {
                    msg = "Debe seleccionar al menos una Sub Genérica de Ingreso";
                }
                if (filtP === "07") {
                    msg = "Debe seleccionar al menos una Sub Genérica Detallada de Ingreso";
                }
                if (filtP === "08") {
                    msg = "Debe seleccionar al menos una Específica de Ingreso";
                }
                if (filtP === "09") {
                    msg = "Debe seleccionar al menos una Específica Detallada de Ingreso";
                }
                if (filtP === "10") {
                    msg = "Debe seleccionar al menos un Banco";
                }
                return(msg);
            }
        }
        var countRubro = 0;
        if ($("input[name=filtroMensual_rubro]").is(":checked") === true) {
            $("input[name=filtro_02]").each(function () {
                if (this.checked) {
                    countRubro++;
                }
            });
            if (countRubro === 0) {
                msg = "Debe seleccionar al menos un Rubro de Financiamiento";
                return(msg);
            }
        }
        var countCatIngreso = 0;
        if ($("input[name=filtroMensual_catingre]").is(":checked") === true) {
            $("input[name=filtro_03]").each(function () {
                if (this.checked) {
                    countCatIngreso++;
                }
            });
            if (countCatIngreso === 0) {
                msg = "Debe seleccionar al menos una Categoría de Ingreso";
                return(msg);
            }
        }
        var countGen = 0;
        if ($("input[name=filtroMensual_generica]").is(":checked") === true) {
            $("input[name=filtro_04]").each(function () {
                if (this.checked) {
                    countGen++;
                }
            });
            if (countGen === 0) {
                msg = "Debe seleccionar al menos una Genérica de Ingreso";
                return(msg);
            }
        }
        var countSubGen = 0;
        if ($("input[name=filtroMensual_subgenerica]").is(":checked") === true) {
            $("input[name=filtro_05]").each(function () {
                if (this.checked) {
                    countSubGen++;
                }
            });
            if (countSubGen === 0) {
                msg = "Debe seleccionar al menos una Sub Genérica de Ingreso";
                return(msg);
            }
        }
        var countSubGenDet = 0;
        if ($("input[name=filtroMensual_subgenericadet]").is(":checked") === true) {
            $("input[name=filtro_06]").each(function () {
                if (this.checked) {
                    countSubGenDet++;
                }
            });
            if (countSubGenDet === 0) {
                msg = "Debe seleccionar al menos una Sub Genérica Detallada de Ingreso";
                return(msg);
            }
        }
        var countEsp = 0;
        if ($("input[name=filtroMensual_especifica]").is(":checked") === true) {
            $("input[name=filtro_07]").each(function () {
                if (this.checked) {
                    countEsp++;
                }
            });
            if (countEsp === 0) {
                msg = "Debe seleccionar al menos una Específica de Ingreso";
                return(msg);
            }
        }
        var countEspDet = 0;
        if ($("input[name=filtroMensual_especificadet]").is(":checked") === true) {
            $("input[name=filtro_08]").each(function () {
                if (this.checked) {
                    countEspDet++;
                }
            });
            if (countEspDet === 0) {
                msg = "Debe seleccionar al menos una Específica Detallada de Ingreso";
                return(msg);
            }
        }
        var countBanco = 0;
        if ($("input[name=filtroMensual_banco]").is(":checked") === true) {
            $("input[name=filtro_10]").each(function () {
                if (this.checked) {
                    countBanco++;
                }
            });
            if (countBanco === 0) {
                msg = "Debe seleccionar al menos un Banco";
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

function nombresLargos07(tipo) {
    var titulo;
    if (tipo === "00") {
        titulo = "";
    }
    if (tipo === "02") {
        titulo = " - Filtrado por Fuente de Financiamiento";
    }
    if (tipo === "03") {
        titulo = " - Filtrado por Rubro de Financiamiento";
    }
    if (tipo === "04") {
        titulo = " - Filtrado por Categoría de Ingreso";
    }
    if (tipo === "05") {
        titulo = " - Filtrado por Genérica";
    }
    if (tipo === "06") {
        titulo = " - Filtrado por SubGenérica";
    }
    if (tipo === "07") {
        titulo = " - Filtrado por SubGenérica Detallada";
    }
    if (tipo === "08") {
        titulo = " - Filtrado por Específica";
    }
    if (tipo === "09") {
        titulo = " - Filtrado por Específica Detallada";
    }
    if (tipo === "10") {
        titulo = " - Filtrado por Banco";
    }
    return(titulo);
}

function nombresLargos07M(tipo, id) {
    var titulo = [];
    if (tipo === "00") {
        titulo[0] = "";
        titulo[1] = "";
        titulo[2] = "";
    }
    if (tipo === "01") {
        titulo[0] = " - Filtrado por Fuente de Financiamiento (" + id + ")";
        titulo[1] = "_filtrado_por_fuente_financiamiento";
        titulo[2] = "Fuente de Financiamiento";
    }
    if (tipo === "02") {
        titulo[0] = " - Filtrado por Rubro de Financiamiento (" + id + ")";
        titulo[1] = "_filtrado_por_rubro_financiamiento";
        titulo[2] = "Rubro de Financiamiento";
    }
    if (tipo === "03") {
        titulo[0] = " - Filtrado por Categoría de Ingreso (" + id + ")";
        titulo[1] = "_filtrado_por_categoria_ingreso";
        titulo[2] = "Categoría de Ingreso";
    }
    if (tipo === "04") {
        titulo[0] = " - Filtrado por Genérica de Ingreso (" + id + ")";
        titulo[1] = "_filtrado_por_generica_ingreso";
        titulo[2] = "Genérica";
    }
    if (tipo === "05") {
        titulo[0] = " - Filtrado por SubGenérica de Ingreso (" + id + ")";
        titulo[1] = "_filtrado_por_subgenerica_ingreso";
        titulo[2] = "SubGenérica";
    }
    if (tipo === "06") {
        titulo[0] = " - Filtrado por SubGenérica Detallada de Ingreso (" + id + ")";
        titulo[1] = "_filtrado_por_subgenerica_detallada_ingreso";
        titulo[2] = "SubGenérica Detallada";
    }
    if (tipo === "07") {
        titulo[0] = " - Filtrado por Específica de Ingreso (" + id + ")";
        titulo[1] = "_filtrado_por_especifica_ingreso";
        titulo[2] = "Específica";
    }
    if (tipo === "08") {
        titulo[0] = " - Filtrado por Específica Detallada de Ingreso (" + id + ")";
        titulo[1] = "_filtrado_por_especifica_detallada_ingreso";
        titulo[2] = "Específica Detallada";
    }
    if (tipo === "09") {
        titulo[0] = " - Filtrado por Banco (" + id + ")";
        titulo[1] = "_filtrado_por_banco";
        titulo[2] = "Banco";
    }
    if (tipo === "10") {
        titulo[0] = " - Filtrado por Tipo de Recurso (" + id + ")";
        titulo[1] = "_filtrado_por_tipo_recurso";
        titulo[2] = "Tipo de Recurso";
    }
    if (tipo === "11") {
        titulo[0] = " - Filtrado por Cuenta Corriente (" + id + ")";
        titulo[1] = "_filtrado_por_cuenta_corriente";
        titulo[2] = "Cuenta Corriente";
    }
    return(titulo);
}

function nombresCortos07(tipo) {
    var array = [];
    if (tipo === "00") {
        array[0] = "Ejecutora";
        array[1] = "Nombre";
    }
    if (tipo === "02") {
        array[0] = "Fuente";
        array[1] = "Nombre";
    }
    if (tipo === "03") {
        array[0] = "Rubro";
        array[1] = "Nombre";
    }
    if (tipo === "04") {
        array[0] = "Cat. Ingreso";
        array[1] = "Nombre";
    }
    if (tipo === "05") {
        array[0] = "Genérica";
        array[1] = "Descripción";
    }
    if (tipo === "06") {
        array[0] = "SubGenérica";
        array[1] = "Descripción";
    }
    if (tipo === "07") {
        array[0] = "SubGenéricaDet";
        array[1] = "Descripción";
    }
    if (tipo === "08") {
        array[0] = "Específica";
        array[1] = "Descripción";
    }
    if (tipo === "09") {
        array[0] = "EspecíficaDet";
        array[1] = "Descripción";
    }
    if (tipo === "10") {
        array[0] = "Banco";
        array[1] = "Nombre";
    }
    return(array);
}

function nombresTitulo07(tipo) {
    var titulo = [];
    if (tipo === "ejecutora") {
        titulo[0] = "Ejecutora";
        titulo[1] = "Nombre";
    }
    if (tipo === "fuente_financ_agregada") {
        titulo[0] = "Fuente";
        titulo[1] = "Nombre";
    }
    if (tipo === "fuente_financ") {
        titulo[0] = "Rubro";
        titulo[1] = "Nombre";
    }
    if (tipo === "categoria_ingreso") {
        titulo[0] = "Cat. Ingreso";
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
    if (tipo === "banco") {
        titulo[0] = "Banco";
        titulo[1] = "Nombre";
    }
    return(titulo);
}

function nombresBody07(tipo, value) {
    var body = [];
    if (tipo === "ejecutora") {
        var nombre_ejec = (value.nombre_ejecutora).split("-");
        body[0] = "<td class='center'>UE " + value.ejecutora + "</td>\
                   <td class='left'>" + nombre_ejec[1].trim() + "(" + value.sec_ejec + ")</td>";
        body[1] = "UE " + value.ejecutora;
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
    if (tipo === "categoria_ingreso") {
        body[0] = "<td class='center'>" + value.categoria_ingreso + "</td>\
                   <td class='left'>" + value.nombre_categoria_ingreso + "</td>";
        body[1] = value.categoria_ingreso;
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
    if (tipo === "banco") {
        body[0] = "<td class='center'>" + value.banco + "</td>\
                   <td class='left'>" + value.nombre_banco + "</td>";
        body[1] = value.banco;
    }
    return(body);
}

function llenarTablaReporte07(response) {
    //alert(response.select1);
    //alert(response.select2);
    //alert(response.query1);
    //alert(response.query2);
    var tipo = $("#listPresuFiltroPrinc").val();
    if (tipo === "01") {
        $("#lblPresuFiltGrafico").addClass("oculto");
        $("#divPresuFiltGrafico").addClass("oculto");
        $("#divPresuFiltGrafico").empty();
        $("#divPresuGrafica").removeClass("oculto");
        if (response.tipoM === "00") {
            var titleM = nombresLargos07M(response.tipoM, "");
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
                            <th>Recaudado</th>\
                          </tr>";
            $("#tablaPresu2Head").append(head2M);
            muestra2Head.push({text: 'Mes', style: 'tablaHead', alignment: 'center'});
            muestra2Head.push({text: 'Nombre', style: 'tablaHead', alignment: 'center'});
            muestra2Head.push({text: 'Recaudado', style: 'tablaHead', alignment: 'center'});
            muestra2.push(muestra2Head);

            var meses = "";
            var arrayR = "";
            var recauT = 0.00;
            $.each(response.list, function (index, value) {
                var recau;
                if (!$.trim(value.recaudado)) {
                    recau = 0.00;
                } else {
                    recau = value.recaudado;
                    recauT += value.recaudado;
                }
                var muestra2Body = [];
                var body2M = "<tr>\
                                <td class='center'>" + value.mes + "</td>\
                                <td class='left'>" + value.nombre + "</td>\
                                <td class='right'>" + formatNumero(recau) + "</td>\
                              </tr>";
                $("#tablaPresu2Body").append(body2M);
                meses += "&mes=" + value.nombre;
                arrayR += "&array=" + recau;
                muestra2Body.push({text: value.mes, style: 'tablaBody', alignment: 'center'});
                muestra2Body.push({text: value.nombre, style: 'tablaBody', alignment: 'left'});
                muestra2Body.push({text: formatNumero(recau), style: 'tablaBody', alignment: 'right'});
                muestra2.push(muestra2Body);
            });
            var muestra2Foot = [];
            var foot2M = "<tr class='total'>\
                            <td colspan='2' class='center'><b>TOTAL</b></td>\
                            <td class='right'><b>" + formatNumero(recauT) + "</b></td>\
                          </tr>";
            $("#tablaPresu2Foot").append(foot2M);
            muestra2Foot.push({text: 'TOTAL', style: 'tablaTotal', alignment: 'center', colSpan: 2});
            muestra2Foot.push("");
            muestra2Foot.push({text: formatNumero(recauT), style: 'tablaTotal', alignment: 'right'});
            muestra2.push(muestra2Foot);

            $('#tablaPresu2N').dataTable({
                columnDefs: [
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
                        filename: 'recaudacion_ingreso_' + (response.ejec === "00" ? "pliego459" : response.ejec) + '_' + response.año + '_mensualizado' + titleM[1],
                        title: 'RECAUDACIÓN DE INGRESO ' + response.año + " - MENSUALIZADO" + titleM[0],
                        messageTop: response.tituloPDF,
                        exportOptions: {
                            orthogonal: 'sort',
                            columns: ':visible'
                        },
                        customize: function (xlsx) {
                            var sheet = xlsx.xl.worksheets['sheet1.xml'];
                            var total = $('row c[r^="C"]', sheet).length;
                            $('row c[r^="C"]', sheet).each(function (i) {
                                if (i > 0 && i < total - 1) {
                                    $(this).attr('s', '72');
                                }
                                if (i === total - 1) {
                                    $(this).attr('s', '75');
                                }
                            });
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
            var titulo = 'RECAUDACIÓN DE INGRESO ' + response.año + " - MENSUALIZADO" + titleM[0];
            var subtitulo = response.tituloPDF;
            llenarGrafico07("./Presupuesto?tipo=07&graph=true" + meses + arrayR + "&titu=" + titulo + "&subtitu=" + subtitulo + "&ancho=1000&alto=600&font=10&bar=0.06&pos=out");

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
                var imageUrlM = document.getElementById("imgPresuGrafica07M").src + "&pdf=si";
                convertImgToDataURLviaCanvas(imageUrlM, function (base64Img) {
                    imgM = base64Img;
                });
            });

            $("#exportPDF2N").on('click', function () {
                var docDefinition1 = {
                    //pageOrientation: 'landscape',
                    info: {
                        title: 'recaudacion_ingreso_' + (response.ejec === "00" ? "pliego459" : response.ejec) + '_' + response.año + '_mensualizada' + titleM[1]
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
                                        {text: 'RECAUDACIÓN DE INGRESO ' + response.año + " - MENSUALIZADO" + titleM[0] + '\n' + response.tituloPDF + '\n', alignment: 'center', style: 'titulo'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            text: '\nTabla Resumen de Recaudación', alignment: 'left', style: 'subtitulo'
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
                                        {text: 'Gráfica de Recaudación', alignment: 'left', style: 'subtitulo'}
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
            var titleM = nombresLargos07M(response.tipoM, mensual_id);
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
                            <th>Recaudado</th>\
                          </tr>";
            $("#tablaPresu2Head").append(head2M);
            muestra2Head.push({text: 'Mes', style: 'tablaHead', alignment: 'center'});
            muestra2Head.push({text: 'Nombre', style: 'tablaHead', alignment: 'center'});
            muestra2Head.push({text: 'Recaudado', style: 'tablaHead', alignment: 'center'});
            muestra2.push(muestra2Head);
            var meses = "";
            var arrayR = "";
            var recauT = 0.00;
            $.each(response.list, function (index, value) {
                var recau;
                if (!$.trim(value.recaudado)) {
                    recau = 0.00;
                } else {
                    recau = value.recaudado;
                    recauT += value.recaudado;
                }
                var muestra2Body = [];
                var body2M = "<tr>\
                            <td class='center'>" + value.mes + "</td>\
                            <td class='left'>" + value.nombre + "</td>\
                            <td class='right'>" + formatNumero(recau) + "</td>\
                          </tr>";
                $("#tablaPresu2Body").append(body2M);
                meses += "&mes=" + value.nombre;
                arrayR += "&array=" + recau;
                muestra2Body.push({text: value.mes, style: 'tablaBody', alignment: 'center'});
                muestra2Body.push({text: value.nombre, style: 'tablaBody', alignment: 'left'});
                muestra2Body.push({text: formatNumero(recau), style: 'tablaBody', alignment: 'right'});
                muestra2.push(muestra2Body);
            });
            var muestra2Foot = [];
            foot2M = "<tr class='total'>\
                        <td colspan='2' class='center'><b>TOTAL</b></td>\
                        <td class='right'><b>" + formatNumero(recauT) + "</b></td>\
                      </tr>";
            $("#tablaPresu2Foot").append(foot2M);
            muestra2Foot.push({text: 'TOTAL', style: 'tablaTotal', alignment: 'center', colSpan: 2});
            muestra2Foot.push("");
            muestra2Foot.push({text: formatNumero(recauT), style: 'tablaTotal', alignment: 'right'});
            muestra2.push(muestra2Foot);


            $('#tablaPresu1').dataTable({
                ordering: false,
                dom: 'rt'
            });

            $('#tablaPresu2').dataTable({
                columnDefs: [
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
                        filename: 'recaudacion_ingreso_' + (response.ejec === "00" ? "pliego459" : response.ejec) + '_' + response.año + '_mensualizada' + titleM[1],
                        title: 'RECAUDACIÓN DE INGRESO ' + response.año + " - MENSUALIZADO" + titleM[0],
                        messageTop: response.tituloPDF,
                        headTop1: titleM[2] + ' : ' + mensual_id,
                        headTop2: 'Nombre : ' + mensual_nombre,
                        exportOptions: {
                            orthogonal: 'sort',
                            columns: ':visible'
                        },
                        customize: function (xlsx) {
                            var sheet = xlsx.xl.worksheets['sheet1.xml'];
                            var total = $('row c[r^="C"]', sheet).length;
                            $('row c[r^="C"]', sheet).each(function (i) {
                                if (i > 0 && i < total - 1) {
                                    $(this).attr('s', '72');
                                }
                                if (i === total - 1) {
                                    $(this).attr('s', '75');
                                }
                            });
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

            var titulo = 'RECAUDACIÓN DE INGRESO ' + response.año + " - MENSUALIZADO" + titleM[0];
            var subtitulo = response.tituloPDF;
            llenarGrafico07("./Presupuesto?tipo=07&graph=true" + meses + arrayR + "&titu=" + titulo + "&subtitu=" + subtitulo + "&ancho=1000&alto=600&font=10&bar=0.06&pos=out");

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
                var imageUrlM = document.getElementById("imgPresuGrafica07M").src + "&pdf=si";
                convertImgToDataURLviaCanvas(imageUrlM, function (base64Img) {
                    imgM = base64Img;
                });
            });

            $("#exportPDF1N").on('click', function () {
                var docDefinition2 = {
                    //pageOrientation: 'landscape',
                    info: {
                        title: 'recaudacion_ingreso_' + (response.ejec === "00" ? "pliego459" : response.ejec) + '_' + response.año + '_mensualizada' + titleM[1]
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
                                        {text: 'RECAUDACIÓN DE INGRESO ' + response.año + " - MENSUALIZADO" + titleM[0] + '\n' + response.tituloPDF + '\n', alignment: 'center', style: 'titulo'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            text: '\nTabla Resumen de Recaudación', alignment: 'left', style: 'subtitulo'
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
                                        {text: 'Gráfica de Recaudación', alignment: 'left', style: 'subtitulo'}
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
        var size = 2;
        var sizePdf = 2;
        var muestra = [];
        var label = nombresCortos07(tipo);
        var titulo = nombresLargos07(tipo);
        cuerpo = '<table id="tablaPresu" class="display" cellspacing="0" width="100%">\
                    <thead id="tablaPresuHead"></thead>\
                    <tbody id="tablaPresuBody"></tbody>\
                    <tfoot id="tablaPresuFoot"></tfoot>\
                  </table>';
        $("#divPresuTabla").append(cuerpo);
        var countIniT = 2;
        var muestraHead = [];
        var anchos = [];
        head = "<tr>\
                <th>" + label[0] + "</th>\
                <th>" + label[1] + "</th>";
        muestraHead.push({text: label[0], style: 'tablaHead', alignment: 'center'});
        muestraHead.push({text: label[1], style: 'tablaHead', alignment: 'center'});
        anchos.push(35);
        anchos.push(200);
        if (response.subtipo === "tipo_rec") {
            head += "<th>Tipo Recurso</th>\
                     <th>Nombre</th>";
            muestraHead.push({text: 'Tipo Recurso', style: 'tablaHead', alignment: 'center'});
            muestraHead.push({text: 'Nombre', style: 'tablaHead', alignment: 'center'});
            anchos.push(35);
            anchos.push(100);
            size += 2;
            sizePdf += 2;
            countIniT += 2;
        }
        if (response.subtipo === "cta_cte") {
            head += "<th>Cuenta Corriente</th>\
                     <th>Nombre</th>\
                     <th>Año Cuenta</th>";
            muestraHead.push({text: 'Cuenta Corriente', style: 'tablaHead', alignment: 'center'});
            muestraHead.push({text: 'Nombre', style: 'tablaHead', alignment: 'center'});
            muestraHead.push({text: 'Año Cuenta', style: 'tablaHead', alignment: 'center'});
            anchos.push(35);
            anchos.push(80);
            anchos.push(35);
            size += 3;
            sizePdf += 3;
            countIniT += 3;
        }
        for (var i = 0; i < array.length; i++) {
            var tittle = nombresTitulo07(array[i]);
            head += "<th>" + tittle[0] + "</th>\
                     <th>" + tittle[1] + "</th>";
            muestraHead.push({text: tittle[0], style: 'tablaHead', alignment: 'center'});
            anchos.push(35);
            size += 2;
            sizePdf += 1;
            countIniT += 2;
        }
        head += "<th>PIA</th>\
                 <th>Modificaciones</th>\
                 <th>PIM</th>\
                 <th>Recaudado</th>\
                 </tr>";
        $("#tablaPresuHead").append(head);
        muestraHead.push({text: 'PIA', style: 'tablaHead', alignment: 'center'});
        muestraHead.push({text: 'Modificaciones', style: 'tablaHead', alignment: 'center'});
        muestraHead.push({text: 'PIM', style: 'tablaHead', alignment: 'center'});
        muestraHead.push({text: 'Recaudado', style: 'tablaHead', alignment: 'center'});
        muestra.push(muestraHead);
        anchos.push('*');
        anchos.push('*');
        anchos.push('*');
        anchos.push('*');
        var count = 0;
        var piaT, modT, pimT, recauT;
        piaT = modT = pimT = recauT = 0.00;
        $.each(response.list, function (index, value) {
            count++;
            var recau;
            if (!$.trim(value.recaudado)) {
                recau = 0.00;
            } else {
                recau = value.recaudado;
                recauT += value.recaudado;
            }
            var muestraBody = [];
            if (tipo === "00") {
                body = "<tr>\
                            <td class='center'>UE " + response.ejecutora + "</td>\
                            <td class='left'>" + response.nombre_ejec + " (" + response.ejec + ")</td>";
                muestraBody.push({text: 'UE ' + response.ejecutora, style: 'tablaBody', alignment: 'center'});
                muestraBody.push({text: response.nombre_ejec + ' (' + response.ejec + ')', style: 'tablaBody', alignment: 'left'});
            } else {
                body = "<tr>\
                            <td class='center'>" + value.codigo + "</td>\
                            <td class='left'>" + value.nombre + "</td>";
                muestraBody.push({text: value.codigo, style: 'tablaBody', alignment: 'center'});
                muestraBody.push({text: value.nombre, style: 'tablaBody', alignment: 'left'});
            }
            if (response.subtipo === "tipo_rec") {
                body += "<td class='center'>" + value.tipo_recurso + "</td>\
                         <td class='left'>" + value.nombre_tipo_recurso + "</td>";
                muestraBody.push({text: value.tipo_recurso, style: 'tablaBody', alignment: 'center'});
                muestraBody.push({text: value.nombre_tipo_recurso, style: 'tablaBody', alignment: 'left'});
            }
            if (response.subtipo === "cta_cte") {
                body += "<td class='center'>" + value.cta_cte + "</td>\
                         <td class='left'>" + value.nombre_cta_cte + "</td>\
                         <td class='center'>" + value.ano_eje + "</td>";
                muestraBody.push({text: value.cta_cte, style: 'tablaBody', alignment: 'center'});
                muestraBody.push({text: value.nombre_cta_cte, style: 'tablaBody', alignment: 'left'});
                muestraBody.push({text: value.ano_eje, style: 'tablaBody', alignment: 'center'});
            }
            for (var j = 0; j < array.length; j++) {
                var bodyArray = nombresBody07(array[j], value);
                body += bodyArray[0];
                muestraBody.push({text: bodyArray[1], style: 'tablaBody', alignment: 'center'});
            }
            body += "   <td class='right'>" + formatNumero(value.pia) + "</td>\
                        <td class='right'>" + formatNumero(value.modificacion) + "</td>\
                        <td class='right'>" + formatNumero(value.pim) + "</td>\
                        <td class='right'>" + formatNumero(recau) + "</td>\
                     </tr>";
            $("#tablaPresuBody").append(body);
            piaT += value.pia;
            modT += value.modificacion;
            pimT += value.pim;
            muestraBody.push({text: formatNumero(value.pia), style: 'tablaBody', alignment: 'right'});
            muestraBody.push({text: formatNumero(value.modificacion), style: 'tablaBody', alignment: 'right'});
            muestraBody.push({text: formatNumero(value.pim), style: 'tablaBody', alignment: 'right'});
            muestraBody.push({text: formatNumero(recau), style: 'tablaBody', alignment: 'right'});
            muestra.push(muestraBody);
        });
        var muestraBodyT = [];
        muestraBodyT.push({text: 'TOTAL', style: 'tablaTotal', alignment: 'right', colSpan: sizePdf});
        muestraBodyT.push("");
        if (response.subtipo === "tipo_rec") {
            muestraBodyT.push("");
            muestraBodyT.push("");
        }
        if (response.subtipo === "cta_cte") {
            muestraBodyT.push("");
            muestraBodyT.push("");
            muestraBodyT.push("");
        }
        for (var k = 0; k < array.length; k++) {
            muestraBodyT.push("");
        }
        foot = "<tr class='total'>\
                    <td colspan='" + size + "' class='right'><b>TOTAL</b></td>\
                    <td class='right'><b>" + formatNumero(piaT) + "</b></td>\
                    <td class='right'><b>" + formatNumero(modT) + "</b></td>\
                    <td class='right'><b>" + formatNumero(pimT) + "</b></td>\
                    <td class='right'><b>" + formatNumero(recauT) + "</b></td>\
                </tr>";
        $("#tablaPresuFoot").append(foot);
        muestraBodyT.push({text: formatNumero(piaT), style: 'tablaTotal', alignment: 'right'});
        muestraBodyT.push({text: formatNumero(modT), style: 'tablaTotal', alignment: 'right'});
        muestraBodyT.push({text: formatNumero(pimT), style: 'tablaTotal', alignment: 'right'});
        muestraBodyT.push({text: formatNumero(recauT), style: 'tablaTotal', alignment: 'right'});
        muestra.push(muestraBodyT);
        var columnasIni = "[";
        var countMarco = 0;
        var countMarcoT = 0;
        var columnasMarco = "";
        $("input[name=marco]").each(function () {
            if (this.checked === false) {
                var valor = this.value;
                countMarco++;
                if (response.subtipo === "tipo_rec") {
                    if (array.length > 0) {
                        columnasMarco += (Number.parseInt(valor, 10) + 2 + (array.length * 2)) + ", ";
                    } else {
                        columnasMarco += (Number.parseInt(valor, 10) + 2) + ", ";
                    }
                } else if (response.subtipo === "cta_cte") {
                    if (array.length > 0) {
                        columnasMarco += (Number.parseInt(valor, 10) + 3 + (array.length * 2)) + ", ";
                    } else {
                        columnasMarco += (Number.parseInt(valor, 10) + 3) + ", ";
                    }
                } else {
                    if (array.length > 0) {
                        columnasMarco += (Number.parseInt(valor, 10) + (array.length * 2)) + ", ";
                    } else {
                        columnasMarco += valor + ", ";
                    }
                }
            } else {
                countMarcoT++;
            }
        });
        var columnasFin = "]";
        if (countMarco !== 0) {
            columnasMarco = columnasMarco.substring(0, columnasMarco.length - 2);
        }
        var columnas = columnasIni + columnasMarco + columnasFin;
        var countT = countIniT + countMarcoT + 1;
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
                    collectionLayout: 'fixed two-column'
                },
                {
                    extend: 'excel',
                    footer: true,
                    filename: 'recaudacion_ingreso_' + (response.ejec === "00" ? "pliego459" : response.ejec) + '_' + response.año + '_filtrado_por_' + label[0],
                    title: 'RECAUDACIÓN DE INGRESO ' + response.año + titulo,
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
                    title: 'recaudacion_ingreso_' + (response.ejec === "00" ? "pliego459" : response.ejec) + '_' + response.año + '_filtrado_por_' + label[0]
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
                                    {text: 'RECAUDACIÓN DE INGRESO ' + response.año + titulo + '\n' + response.tituloPDF + '\n', alignment: 'center', style: 'titulo'}
                                ]
                            ]
                        },
                        layout: {
                            hLineColor: 'white',
                            vLineColor: 'white'
                        }
                    },
                    {
                        text: '\n\nTabla Resumen de Recaudación', alignment: 'left', style: 'subtitulo'
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

function llenarTipoRecurso07(ejec, año, array) {
    $("#divFiltroTipoRecurso").removeClass("oculto");
    $("#divFiltroTipoRecurso").empty();
    var filt = '<label for="dlFiltTipoRecurso" class="col-sm-2 col-form-label">Tipo de Recurso</label>\
                <div class="col-sm-10">\
                    <dl id="dlFiltTipoRecurso" class="dropdownF">\
                        <dt>\
                            <a>\
                                <label id="lblSelectTipoRec"><b style="color: orangered;">--Ninguno--</b></label>\
                                <span class="hida">\
                                    <i class="fa fa-filter" aria-hidden="true"></i>\
                                </span>\
                            </a>\
                        </dt>\
                        <dd>\
                            <div class="mutliSelect">\
                                <ul id="ulFiltTipoRecurso"></ul>\
                            </div>\
                        </dd>\
                    </dl>\
                </div>';
    $("#divFiltroTipoRecurso").append(filt);
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataTipoRecurso&ejec=" + ejec + "&ciclo=I&año=" + año + array,
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
            $("#ulFiltTipoRecurso").append(obje1);
            var size = 0;
            $.each(response.list, function (index, value) {
                size++;
                var obje2 = '<li><label class="custom-control custom-checkbox">\
                                <input type="checkbox" class="custom-control-input" value="' + value.codigo + '" name="tipo_recurso">\
                                <span class="custom-control-indicator"></span>&nbsp;\
                                <span class="custom-control-description">\
                                    <b>' + value.codigo + "</b> - " + value.nombre + ' <b>(' + value.nombre_fuente_financ_agregada + ')</b>\
                                </span>\
                             </label></li>';
                $("#ulFiltTipoRecurso").append(obje2);
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
    $("#dlFiltTipoRecurso.dropdownF dt a").on('click', function () {
        $("#dlFiltPrinc.dropdownF dd ul").hide();
        $("#dlFiltSecun.dropdownF dd ul").hide();
        $("#dlFiltSecunMensual.dropdownF dd ul").hide();
        $("#dlFiltCuentaCorriente.dropdownF dd ul").hide();
        hidedlFiltSecund(arraySecun, "");
        hidedlFiltSecundMensual(arraySecunMensual, "");
        $("#dlFiltTipoRecurso.dropdownF dd ul").slideToggle('fast');
    });
    $("#dlFiltTipoRecurso.dropdownF dd ul li a").on('click', function () {
        $("#dlFiltTipoRecurso.dropdownF dd ul").hide();
    });
    $(document).bind('click', function (e) {
        var $clicked = $(e.target);
        if (!$clicked.parents().hasClass("dropdownF"))
            $("#dlFiltTipoRecurso.dropdownF dd ul").hide();
    });
}

function llenarCuentaCorriente07(ejec, año, array) {
    $("#divFiltroCuentaCorriente").removeClass("oculto");
    $("#divFiltroCuentaCorriente").empty();
    var filt = '<label for="dlFiltCuentaCorriente" class="col-sm-2 col-form-label">Cuenta Corriente</label>\
                <div class="col-sm-10">\
                    <dl id="dlFiltCuentaCorriente" class="dropdownF">\
                        <dt>\
                            <a>\
                                <label id="lblSelectCtaCte"><b style="color: orangered;">--Ninguno--</b></label>\
                                <span class="hida">\
                                    <i class="fa fa-filter" aria-hidden="true"></i>\
                                </span>\
                            </a>\
                        </dt>\
                        <dd>\
                            <div class="mutliSelect">\
                                <ul id="ulFiltCuentaCorriente"></ul>\
                            </div>\
                        </dd>\
                    </dl>\
                </div>';
    $("#divFiltroCuentaCorriente").append(filt);
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataCuentaCorriente&ejec=" + ejec + "&año=" + año + array,
        success: function (response) {
            var obje1 = '<li><label class="custom-control custom-checkbox">\
                            <input type="checkbox" class="custom-control-input" value="ninguno" name="cta_cte_ninguno" checked>\
                            <span class="custom-control-indicator"></span>&nbsp;\
                            <span class="custom-control-description"><b>--NINGUNA--</b></span>\
                         </label></li>\
                         <li><label class="custom-control custom-checkbox">\
                            <input type="checkbox" class="custom-control-input" value="todo" name="cta_cte_todo">\
                            <span class="custom-control-indicator"></span>&nbsp;\
                            <span class="custom-control-description"><b>--TODAS--</b></span>\
                         </label></li>';
            $("#ulFiltCuentaCorriente").append(obje1);
            var size = 0;
            $.each(response.list, function (index, value) {
                size++;
                var obje2 = '<li><label class="custom-control custom-checkbox">\
                                <input id="' + value.nombre + '" type="checkbox" class="custom-control-input" value="' + value.codigo + '-' + value.ano_eje + '" name="cta_cte">\
                                <span class="custom-control-indicator"></span>&nbsp;\
                                <span class="custom-control-description">\
                                    <b>' + value.codigo + "</b> - " + value.nombre + ' <b>(' + value.nombre_banco + ' - ' + value.ano_eje + ')</b>\
                                </span>\
                             </label></li>';
                $("#ulFiltCuentaCorriente").append(obje2);
            });
            $("input[name=cta_cte_ninguno]").change(function () {
                $("#lblSelectCtaCte").empty();
                $("#lblSelectCtaCte").append('<b style="color: orangered;">--Ninguna--</b>');
                $("input[name=cta_cte_ninguno]").prop("checked", true);
                $("input[name=cta_cte_todo]").prop("checked", false);
                $("input[name=cta_cte]").prop("checked", false);
            });
            $("input[name=cta_cte_todo]").change(function () {
                $("#lblSelectCtaCte").empty();
                if (this.checked) {
                    $("#lblSelectCtaCte").append('<b>--Todas--</b>');
                    $("input[name=cta_cte]").prop("checked", true);
                    $("input[name=cta_cte_ninguno]").prop("checked", false);
                }
                if (this.checked === false) {
                    $("#lblSelectCtaCte").append('<b style="color: orangered;">--Ninguna--</b>');
                    $("input[name=cta_cte]").prop("checked", false);
                    $("input[name=cta_cte_ninguno]").prop("checked", true);
                }
            });
            $("input[name=cta_cte]").change(function () {
                $("#lblSelectCtaCte").empty();
                $("input[name=cta_cte_ninguno]").prop("checked", false);
                if (this.checked === false) {
                    $("input[name=cta_cte_todo]").prop("checked", false);
                }
                var count = 0;
                var text = "";
                $("input[name=cta_cte]").each(function () {
                    if (this.checked) {
                        count++;
                        text += this.id + ", ";
                    }
                });
                text = "<b>" + text.substring(0, text.length - 2) + "</b>";
                if (count === size) {
                    text = "<b>--Todas--</b>";
                    $("input[name=cta_cte_todo]").prop("checked", true);
                    $("input[name=cta_cte_ninguno]").prop("checked", false);
                }
                if (count === 0) {
                    text = '<b style="color: orangered;">--Ninguna--</b>';
                    $("input[name=cta_cte_ninguno]").prop("checked", true);
                }
                $("#lblSelectCtaCte").append(text);
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
    $("#dlFiltCuentaCorriente.dropdownF dt a").on('click', function () {
        $("#dlFiltPrinc.dropdownF dd ul").hide();
        $("#dlFiltSecun.dropdownF dd ul").hide();
        $("#dlFiltSecunMensual.dropdownF dd ul").hide();
        $("#dlFiltTipoRecurso.dropdownF dd ul").hide();
        hidedlFiltSecund(arraySecun, "");
        hidedlFiltSecundMensual(arraySecunMensual, "");
        $("#dlFiltCuentaCorriente.dropdownF dd ul").slideToggle('fast');
    });
    $("#dlFiltCuentaCorriente.dropdownF dd ul li a").on('click', function () {
        $("#dlFiltCuentaCorriente.dropdownF dd ul").hide();
    });
    $(document).bind('click', function (e) {
        var $clicked = $(e.target);
        if (!$clicked.parents().hasClass("dropdownF"))
            $("#dlFiltCuentaCorriente.dropdownF dd ul").hide();
    });
}

function llenarGrafico07(src) {
    $("#divPresuGrafica").empty();
    var imgG07 = '<img id="imgPresuGrafica07M" src="' + src + '"/>';
    $("#divPresuGrafica").append(imgG07);
}




