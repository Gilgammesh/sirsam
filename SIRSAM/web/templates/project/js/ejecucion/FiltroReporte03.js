// Reporte de Certificaciones Presupuestarias

function FiltroReporte03() {
    alert("funciona filtro03");
}

function llenarFiltroReporte03() {
    $("#divPresuFiltReporte").empty();
    filtro = '<div class="form-group row">\
                    <label for="listPresuEjecCerti" class="col-sm-2 col-form-label">Elija Ejecutora :</label>\
                    <div class="col-sm-6">\
                        <select class="select-form" id="listPresuEjecCerti" name="ejec"></select>\
                    </div>\
                    <label class="col-sm-1"></label>\
                    <label for="listPresuAño" class="col-sm-1 col-form-label">Elija Año :</label>\
                    <div class="col-sm-2">\
                        <select class="select-form" id="listPresuAño" name="anho"></select>\
                    </div>\
                </div>';
    filtro += '<div class="form-group row">\
                    <label for="listPresuFiltroPrincCerti" class="col-sm-2 col-form-label">Filtro Principal :</label>\
                    <div class="col-sm-4">\
                        <select class="select-form" id="listPresuFiltroPrincCerti" name="filtro_princ">\
                            <option value="00" selected>--Consolidado de Certificaciones--</option>\
                            <option value="01">Certificación Detallada</option>\
                            <option value="02">Certificación Historial</option>\
                            <option value="03">Certificación Estado</option>\
                            <option value="04">Por Documento</option>\
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
                        </select>\
                    </div>\
                    <label id="lblFiltroSecunCerti" for="dlFiltSecunCerti" class="col-sm-2 col-form-label oculto">Filtros Secundarios :</label>\
                    <div id="divFiltroSecunCerti" class="col-sm-4 oculto">\
                        <dl id="dlFiltSecunCerti" class="dropdownF">\
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
                                        <li id="lifiltSCerti_00"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="00" name="filtroS_ninguno" checked>\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">--NINGUNO--</span>\
                                        </label></li>\
                                        <li id="lifiltSCerti_05"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="05" name="filtroS_meta">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Meta Presupuestaria</span>\
                                        </label></li>\
                                        <li id="lifiltSCerti_06"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="06" name="filtroS_fuente">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Fuente de Financiamiento</span>\
                                        </label></li>\
                                        <li id="lifiltSCerti_07"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="07" name="filtroS_rubro">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Rubro de Financiamiento</span>\
                                        </label></li>\
                                        <li id="lifiltSCerti_08"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="08" name="filtroS_catgasto">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Categoría de Gasto</span>\
                                        </label></li>\
                                        <li id="lifiltSCerti_09"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="09" name="filtroS_generica">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Genérica de Gasto</span>\
                                        </label></li>\
                                        <li id="lifiltSCerti_10"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="10" name="filtroS_subgenerica">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">SubGenérica de Gasto</span>\
                                        </label></li>\
                                        <li id="lifiltSCerti_11"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="11" name="filtroS_subgenericadet">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">SubGenérica Detallada de Gasto</span>\
                                        </label></li>\
                                        <li id="lifiltSCerti_12"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="12" name="filtroS_especifica">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Específica de Gasto</span>\
                                        </label></li>\
                                        <li id="lifiltSCerti_13"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="13" name="filtroS_especificadet">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Específica Detallada de Gasto</span>\
                                        </label></li>\
                                        <li id="lifiltSCerti_14"><label class="custom-control custom-checkbox">\
                                            <input type="checkbox" class="custom-control-input" value="14" name="filtroS_provincia">\
                                            <span class="custom-control-indicator"></span>&nbsp;\
                                            <span class="custom-control-description">Provincia</span>\
                                        </label></li>\
                                    </ul>\
                                </div>\
                            </dd>\
                        </dl>\
                    </div>\
               </div>';
    filtro += '<div id="divFiltroCerti" class="form-group row oculto"></div>';
    filtro += '<div id="divFiltrosSecunCerti"></div>';
    filtro += '<div id="divFiltroNroCerti" class="form-group row oculto">\
                 <label for="inpFiltroNroCerti" class="col-sm-2 col-form-label">Nº de Certificación :</label>\
                 <div class="col-sm-2">\
                    <input type="text" class="form-control" id="inpFiltroNroCerti" maxlength="10" name="num_certi" onkeypress="return soloNumero(event)">\
                 </div>\
               </div>';
    fase = '<div id="divEjecCertFase">\
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
            <span class="custom-control-description">Compromiso Anual</span>\
            </label>\
            </div>';
    fase += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="fase" value="6" checked>\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Compromiso</span>\
            </label>\
            </div>';
    fase += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="fase" value="7" checked>\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Devengado</span>\
            </label>\
            </div>';
    fase += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="fase" value="8" checked>\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Girado</span>\
            </label>\
            </div>';
    fase += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="fase" value="9" checked>\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Pagado</span>\
            </label>\
            </div>';
    fase += '</div></div>';
    etapa = '<div id="divEjecCertEtapa" class="oculto">\
            <div class="form-group row line_top">\
            <label class="col-sm-2">Etapa :</label>\
            <div class="col-sm-2 fontweight3">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="etapa" value="1" checked>\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Certificación</span>\
            </label>\
            </div>\
            <div class="col-sm-2 fontweight3">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="etapa" value="2">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Compromiso Anual</span>\
            </label>\
            </div>\
            </div>\
            </div>';
    saldo = '<div id="divEjecCertSaldo">\
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
            <input type="checkbox" class="custom-control-input" name="saldo" value="10, 11">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Compromiso Anual</span>\
            </label>\
            </div>';
    saldo += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="saldo" value="12, 13">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Compromiso</span>\
            </label>\
            </div>';
    saldo += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="saldo" value="14, 15">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Devengado</span>\
            </label>\
            </div>';
    saldo += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="saldo" value="16, 17">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Girado</span>\
            </label>\
            </div>';
    saldo += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="saldo" value="18, 19">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Pagado</span>\
            </label>\
            </div>';
    saldo += '</div></div>';
    estado = '<div id="divEjecCertEstado" class="oculto">\
            <div class="form-group row line_top">\
            <label class="col-sm-2">Etapa :</label>\
            <div class="col-sm-2 fontweight3">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="estado" value="A">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Aprobado</span>\
            </label>\
            </div>\
            <div class="col-sm-2 fontweight3">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="estado" value="R">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Rechazado</span>\
            </label>\
            </div>\
            <div class="col-sm-2 fontweight3">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="estado" value="P" checked>\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Pendiente</span>\
            </label>\
            </div>\
            <div class="col-sm-2 fontweight3">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="estado" value="E">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Por habilitar envio</span>\
            </label>\
            </div>\
            </div>\
            </div>';
    documento = '<div id="divEjecCertDocu" class="form-group row line_top oculto">\
                    <label for="listEjecCertDocu" class="col-sm-2 col-form-label">Elija Documento :</label>\
                    <div class="col-sm-5">\
                        <select class="select-form" id="listEjecCertDocu" name="cod_doc"></select>\
                    </div>\
                    <label class="col-sm-1"></label>\
                    <label for="inpFiltroNroDocu" class="col-sm-2 col-form-label">Nº de Documento :</label>\
                    <div class="col-sm-1">\
                       <input type="text" class="form-control" id="inpFiltroNroDocu" maxlength="5" name="num_doc" onkeypress="return soloNumero(event)">\
                    </div>\
                 </div>';
    botones = '<div class="form-row line_top20">\
                <label class="col-sm-2"></label>\
                <div class="col-auto">\
                <button type="submit" class="btn btn3d btn-danger btn-m">\
                <span class="glyphicon glyphicon-play spanBtn"></span>Generar\
                </button>\
                </div>\
                <div class="col-auto">\
                <button id="btnRepoPresu03" type="reset" value="Reset" class="btn btn3d btn-white btn-m">\
                <span class="glyphicon glyphicon-erase spanBtn"></span>Limpiar\
                </button>\
                </div>\
                </div>';
    html = filtro + fase + etapa + saldo + estado + documento + botones;
    $("#divPresuFiltReporte").append(html);
    var arraySecun = [];
    $("#dlFiltSecunCerti input").each(function () {
        arraySecun.push(this.value);
    });
    $("#dlFiltSecunCerti.dropdownF dt a").on('click', function () {
        $("#dlFiltPrincCerti.dropdownF dd ul").hide();
        hidedlFiltSecund(arraySecun, "");
        $("#dlFiltSecund_20.dropdownF dd ul").hide();
        $("#dlFiltSecunCerti.dropdownF dd ul").slideToggle('fast');
    });
    $("#dlFiltSecunCerti.dropdownF dd ul li a").on('click', function () {
        $("#dlFiltSecunCerti.dropdownF dd ul").hide();
    });
    $(document).bind('click', function (e) {
        var $clicked = $(e.target);
        if (!$clicked.parents().hasClass("dropdownF"))
            $("#dlFiltSecunCerti.dropdownF dd ul").hide();
    });
    limpiar();
}

function limpiarCheckFiltroSecun03() {
    $("#dlFiltSecunCerti input").prop("checked", false);
    $("#lifiltSCerti_00 input").prop("checked", true);
}

function controlFiltroReporte03() {
    $('#listPresuEjecCerti').empty();
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataEjecutoras",
        success: function (response) {
            $.each(response.listEjecutoras, function (index, value) {
                var nombre_ejec = (value.nombre).split("-");
                obje = "<option value=" + value.sec_ejec + ">UE " + value.ejecutora + " - " + nombre_ejec[1].trim() + " (" + value.sec_ejec + ")</option>";
                $("#listPresuEjecCerti").append(obje);
            });
            $('#listPresuEjecCerti').prop('selectedIndex', 0);
            llenarAñoCerti($('#listPresuEjecCerti').val());
        }
    });
    $("#listPresuEjecCerti").bind("change", function () {
        var ejec = $('#listPresuEjecCerti').val();
        llenarAñoCerti(ejec);
    });
    $("#listPresuAño").bind("change", function () {
        var ejec = $('#listPresuEjecCerti').val();
        var año = $("#listPresuAño").val();
        var valP = $("#listPresuFiltroPrincCerti").val();
        llenarFiltPrinc03(valP, año, ejec);
    });
    $("#listPresuFiltroPrincCerti").bind("change", function () {
        var ejec = $('#listPresuEjecCerti').val();
        var año = $("#listPresuAño").val();
        var valP = $("#listPresuFiltroPrincCerti").val();
        $("#divFiltrosSecunCerti").empty();
        if (valP === "00") {
            $("#divFiltroCerti").empty();
            $("#divFiltroCerti").addClass("oculto");
            $("#lblFiltroSecunCerti").addClass("oculto");
            $("#divFiltroSecunCerti").addClass("oculto");
            $("#divFiltroNroCerti").addClass("oculto");
            $("#divEjecCertFase").removeClass("oculto");
            $("#divEjecCertSaldo").removeClass("oculto");
            $("#divEjecCertEtapa").addClass("oculto");
            $("#divEjecCertEstado").addClass("oculto");
            $("#divEjecCertDocu").addClass("oculto");
            limpiarCheckFiltroSecun03();
        } else if (valP === "01") {
            $("#divFiltroCerti").empty();
            $("#divFiltroCerti").addClass("oculto");
            $("#lblFiltroSecunCerti").addClass("oculto");
            $("#divFiltroSecunCerti").addClass("oculto");
            $("#divFiltroNroCerti").removeClass("oculto");
            $("#divEjecCertFase").removeClass("oculto");
            $("#divEjecCertSaldo").removeClass("oculto");
            $("#divEjecCertEtapa").addClass("oculto");
            $("#divEjecCertEstado").addClass("oculto");
            $("#divEjecCertDocu").addClass("oculto");
        } else if (valP === "02") {
            $("#divFiltroCerti").empty();
            $("#divFiltroCerti").addClass("oculto");
            $("#lblFiltroSecunCerti").addClass("oculto");
            $("#divFiltroSecunCerti").addClass("oculto");
            $("#divFiltroNroCerti").removeClass("oculto");
            $("#divEjecCertFase").addClass("oculto");
            $("#divEjecCertSaldo").addClass("oculto");
            $("#divEjecCertEtapa").removeClass("oculto");
            $("#divEjecCertEstado").addClass("oculto");
            $("#divEjecCertDocu").addClass("oculto");
        } else if (valP === "03") {
            $("#divFiltroCerti").empty();
            $("#divFiltroCerti").addClass("oculto");
            $("#lblFiltroSecunCerti").addClass("oculto");
            $("#divFiltroSecunCerti").addClass("oculto");
            $("#divFiltroNroCerti").addClass("oculto");
            $("#divEjecCertFase").addClass("oculto");
            $("#divEjecCertSaldo").addClass("oculto");
            $("#divEjecCertEtapa").removeClass("oculto");
            $("#divEjecCertEstado").removeClass("oculto");
            $("#divEjecCertDocu").addClass("oculto");
        } else if (valP === "04") {
            $("#divFiltroCerti").empty();
            $("#divFiltroCerti").addClass("oculto");
            $("#lblFiltroSecunCerti").addClass("oculto");
            $("#divFiltroSecunCerti").addClass("oculto");
            $("#divFiltroNroCerti").addClass("oculto");
            $("#divEjecCertFase").addClass("oculto");
            $("#divEjecCertSaldo").addClass("oculto");
            $("#divEjecCertEtapa").removeClass("oculto");
            $("#divEjecCertEstado").addClass("oculto");
            $("#divEjecCertDocu").removeClass("oculto");
            llenarTipoDocu03($("#listPresuAño").val(), $("#listPresuEjecCerti").val(), $("input[name=etapa]:checked").val());
            $("input[name=etapa]").change(function () {
                llenarTipoDocu03($("#listPresuAño").val(), $("#listPresuEjecCerti").val(), $("input[name=etapa]:checked").val());
            });
        } else {
            $("#divFiltroNroCerti").addClass("oculto");
            $("#divEjecCertFase").removeClass("oculto");
            $("#divEjecCertSaldo").removeClass("oculto");
            $("#divEjecCertEtapa").addClass("oculto");
            $("#divEjecCertEstado").addClass("oculto");
            $("#divEjecCertDocu").addClass("oculto");
            $("#divFiltroCerti").empty();
            var conFiltCert = '<label id="lblFiltPrincCerti" for="dlFiltPrincCerti" class="col-sm-2 col-form-label"></label>\
                               <div id="divFiltPrincCerti" class="col-sm-10">\
                                    <dl id="dlFiltPrincCerti" class="dropdownF">\
                                        <dt>\
                                            <a>\
                                                <label id="lblSelectPrincCerti"><b style="color: orangered;">--Ninguno--</b></label>\
                                                <span class="hida">\
                                                    <i class="fa fa-filter" aria-hidden="true"></i>\
                                                </span>\
                                            </a>\
                                        </dt>\
                                        <dd>\
                                            <div class="mutliSelect">\
                                                <ul id="ulFiltPrimCerti"></ul>\
                                            </div>\
                                        </dd>\
                                    </dl>\
                               </div>';
            $("#divFiltroCerti").append(conFiltCert);
            $("#divFiltroCerti").removeClass("oculto");
            $("#lblFiltroSecunCerti").removeClass("oculto");
            $("#divFiltroSecunCerti").removeClass("oculto");
            limpiarCheckFiltroSecun03();
            $("#dlFiltSecunCerti li").removeClass("oculto");
            $("#lifiltSCerti_" + valP).addClass("oculto");
            if (valP === "05") {
                $("#lblFiltPrincCerti").append("Meta");
            }
            if (valP === "06") {
                $("#lblFiltPrincCerti").append("Fuente Financiamiento");
            }
            if (valP === "07") {
                $("#lblFiltPrincCerti").append("Rubro Financiamiento");
            }
            if (valP === "08") {
                $("#lblFiltPrincCerti").append("Categoría de Gasto");
            }
            if (valP === "09") {
                $("#lblFiltPrincCerti").append("Genérica");
            }
            if (valP === "10") {
                $("#lblFiltPrincCerti").append("SubGenérica");
            }
            if (valP === "11") {
                $("#lblFiltPrincCerti").append("SubGenérica Detallada");
            }
            if (valP === "12") {
                $("#lblFiltPrincCerti").append("Específica");
            }
            if (valP === "13") {
                $("#lblFiltPrincCerti").append("Específica Detallada");
            }
            if (valP === "14") {
                $("#lblFiltPrincCerti").append("Provincia");
            }
            llenarFiltPrinc03(valP, año, ejec);
            var arraySecun = [];
            $("#dlFiltSecunCerti input").each(function () {
                arraySecun.push(this.value);
            });
            $("#dlFiltPrincCerti.dropdownF dt a").on('click', function () {
                $("#dlFiltSecunCerti.dropdownF dd ul").hide();
                hidedlFiltSecund(arraySecun, "");
                $("#dlFiltSecund_20.dropdownF dd ul").hide();
                $("#dlFiltPrincCerti.dropdownF dd ul").slideToggle('fast');
            });
            $("#dlFiltPrincCerti.dropdownF dd ul li a").on('click', function () {
                $("#dlFiltPrincCerti.dropdownF dd ul").hide();
            });
            $(document).bind('click', function (e) {
                var $clicked = $(e.target);
                if (!$clicked.parents().hasClass("dropdownF"))
                    $("#dlFiltPrincCerti.dropdownF dd ul").hide();
            });
        }
    });
    var arraySecun = [];
    $("#dlFiltSecunCerti input").each(function () {
        arraySecun.push(this.value);
    });
    $("#dlFiltSecunCerti input").change(function () {
        if (this.value === "00") {
            if (this.checked) {
                $("#dlFiltSecunCerti input").prop("checked", false);
                $("#lifiltSCerti_00 input").prop("checked", true);
                $("#divFiltrosSecunCerti").empty();
            } else {
                var count1 = 0;
                $("#dlFiltSecunCerti input").each(function () {
                    if (this.checked) {
                        count1++;
                    }
                });
                if (count1 === 0) {
                    $("#lifiltSCerti_00 input").prop("checked", true);
                } else {
                    $("#lifiltSCerti_00 input").prop("checked", false);
                }
            }
        } else {
            var ejecS = $('#listPresuEjecCerti').val();
            var añoS = $("#listPresuAño").val();
            if (this.checked) {
                content3 = '<div id="divFiltSecund_' + this.value + '" class="form-group row">\
                                <label id="lblFiltSecund_' + this.value + '" for="dlFiltSecund_' + this.value + '" class="col-sm-2 col-form-label"></label>\
                                <div class="col-sm-10">\
                                    <dl id="dlFiltSecund_' + this.value + '" class="dropdownF">\
                                        <dt>\
                                            <a>\
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
                $("#divFiltrosSecunCerti").append(content3);
                llenarFiltSecund03(this.value, añoS, ejecS);
                $("#lifiltSCerti_00 input").prop("checked", false);
                var valdl = this.value;
                $("#dlFiltSecund_" + valdl + ".dropdownF dt a").on('click', function () {
                    $("#dlFiltPrincCerti.dropdownF dd ul").hide();
                    $("#dlFiltSecunCerti.dropdownF dd ul").hide();
                    hidedlFiltSecund(arraySecun, valdl);
                    $("#dlFiltSecund_20.dropdownF dd ul").hide();
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
                    $("#lifiltSCerti_00 input").prop("checked", true);
                }
            }
        }
    });
    cambiaFaseCert();
    cambiaEtapaCert();
    cambiaSaldoCert();
    cambiaEstadoCert();
    $("#btnRepoPresu03").click(function () {
        $("#divPresuTabla").empty();
        $("#divPresuTabla").addClass("oculto");
        $("#lblPresuFiltGrafico").addClass("oculto");
        $("#divPresuFiltGrafico").empty();
        $("#divPresuFiltGrafico").addClass("oculto");
        $("#divPresuGrafica").empty();
        $("#divPresuGrafica").addClass("oculto");
        $("#divFiltroCerti").empty();
        $("#divFiltroCerti").addClass("oculto");
        $("#lblFiltroSecunCerti").addClass("oculto");
        $("#divFiltrosSecunCerti").empty();
        $("#divFiltroSecunCerti").addClass("oculto");
        $("#divFiltroNroCerti").addClass("oculto");
        $("#divEjecCertFase").removeClass("oculto");
        $("#divEjecCertSaldo").removeClass("oculto");
        $("#divEjecCertEtapa").addClass("oculto");
        $("#divEjecCertEstado").addClass("oculto");
        $("#divEjecCertDocu").addClass("oculto");
        limpiarCheckFiltroSecun03();
    });
}

function hidedlFiltSecund(array, val) {
    for (var i = 0; i < array.length; i++) {
        if (array[i] !== val) {
            $("#dlFiltSecund_" + array[i] + ".dropdownF dd ul").hide();
        }
    }
}

function llenarFiltSecund03(val, año, ejec) {
    $("#lblFiltSecund_" + val).empty();
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
            $("#ulFiltSecund_" + val).append(obje1);
            var size = 0;
            $.each(response.list, function (index, value) {
                size++;
                var obje2;
                if (val === "14") {
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
                    if (val === "14") {
                        llenarDistrito03(ejec, año, "");
                    }
                }
                if (this.checked === false) {
                    $("#lblSelectSecund_" + val).append("<b style='color: orangered;'>--Ninguno--</b>");
                    $("input[name=filtro_" + val + "]").prop("checked", false);
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
                        if (val === "14") {
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
                if (val === "14") {
                    if (count === size) {
                        llenarDistrito03(ejec, año, "");
                    } else {
                        llenarDistrito03(ejec, año, array);
                    }
                }
                $("#lblSelectSecund_" + val).append(text);
            });
        }
    });
}

function llenarFiltPrinc03(val, año, ejec) {
    $("#ulFiltPrimCerti").empty();
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataFiltros&ejec=" + ejec + "&año=" + año + "&val=" + val,
        success: function (response) {
            var obje1 = '<li><label class="custom-control custom-checkbox">\
                        <input type="checkbox" class="custom-control-input" value="todo" name="filtro_todo">\
                        <span class="custom-control-indicator"></span>&nbsp;\
                        <span class="custom-control-description"><b>--Todas--</b></span>\
                     </label></li>';
            $("#ulFiltPrimCerti").append(obje1);
            var size = 0;
            if (val !== "00" && val !== "01" && val !== "02" && val !== "03" && val !== "04") {
                $.each(response.list, function (index, value) {
                    size++;
                    var obje2 = '';
                    if (val === "14") {
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
                    $("#ulFiltPrimCerti").append(obje2);
                });
            }
            $("input[name=filtro_todo]").change(function () {
                $("#lblSelectPrincCerti").empty();
                if (this.checked) {
                    $("#lblSelectPrincCerti").append("<b>--Todas--</b>");
                    $("input[name=filtro]").prop("checked", true);
                    if (val === "14") {
                        llenarDistrito03(ejec, año, "");
                    }
                }
                if (this.checked === false) {
                    $("#lblSelectPrincCerti").append("<b style='color: orangered;'>--Ninguno--</b>");
                    $("input[name=filtro]").prop("checked", false);
                    if (val === "14") {
                        $("#divFiltSecund_20").remove();
                    }
                }
            });
            $("input[name=filtro]").change(function () {
                $("#lblSelectPrincCerti").empty();
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
                        if (val === "14") {
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
                if (val === "14") {
                    if (count === size) {
                        llenarDistrito03(ejec, año, "");
                    } else {
                        llenarDistrito03(ejec, año, array);
                    }
                }
                $("#lblSelectPrincCerti").append(text);
            });
        }
    });
}

function llenarDistrito03(ejec, año, array) {
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
    $("#divFiltrosSecunCerti").append(distrito);
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
    $("#dlFiltSecunCerti input").each(function () {
        arraySecun.push(this.value);
    });
    $("#dlFiltSecund_20.dropdownF dt a").on('click', function () {
        $("#dlFiltPrincCerti.dropdownF dd ul").hide();
        $("#dlFiltSecunCerti.dropdownF dd ul").hide();
        hidedlFiltSecund(arraySecun, "");
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

function validarFiltroReporte03() {
    var countFiltro = 0;
    var msg = "OK";
    $("input[name=filtro]").each(function () {
        if (this.checked) {
            countFiltro++;
        }
    });
    var filtP = $("#listPresuFiltroPrincCerti").val();
    if (filtP === "00") {
        msg = "OK";
    } else if (filtP === "01") {
        if ($("input[name=num_certi]").val() === "") {
            msg = "Debe ingresar un número de certificación";
        }
    } else if (filtP === "02") {

    } else if (filtP === "03") {

    } else if (filtP === "04") {

    } else {
        if (countFiltro === 0) {
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
            }
        }
    }
    return(msg);
}

function nombresCortos03(tipo) {
    var array = [];
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
    return(array);
}

function nombresTitulo03(tipo) {
    var titulo = [];
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
    return(titulo);
}

function nombresBody03(tipo, value) {
    var body = [];
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
    return(body);
}

function llenarTablaReporte03(response) {
    //alert(response.select);
    //alert(response.query);   
    var tipo = $("#listPresuFiltroPrincCerti").val();
    if (tipo === "01") {

        var muestra1 = [];
        var muestra2 = [];
        var muestra3 = [];
        var cuerpo3 = '<div id="divBtnCertDetallePdf">\
                           <a>\
                              <img src="./templates/plugins/datatables/images/pdf.png" data-toggle="tooltip" data-placement="bottom" title="Exportar a PDF">\
                           </a>\
                        </div>\
                       <div style="margin-top: 15px;">\
                        <label class="titulo" id="lblPresu1"></label>\
                        <table id="tablaPresu1" class="display" cellspacing="0" width="100%">\
                           <thead id="tablaPresuHead1"></thead>\
                           <tbody id="tablaPresuBody1"></tbody>\
                        </table>\
                       </div>\
                       <div style="margin-top: 15px;">\
                        <label id="lblPresu2"></label>\
                        <table id="tablaPresu2" class="display" cellspacing="0" width="100%">\
                           <thead id="tablaPresuHead2"></thead>\
                           <tbody id="tablaPresuBody2"></tbody>\
                           <tfoot id="tablaPresuFoot"></tfoot>\
                        </table>\
                       </div>\
                       <div style="margin-top: 15px;">\
                        <label id="lblPresu3"></label>\
                        <table id="tablaPresu3" class="display" cellspacing="0" width="100%">\
                           <thead id="tablaPresuHead3"></thead>\
                           <tbody id="tablaPresuBody3"></tbody>\
                        </table>\
                       </div>';
        $("#divPresuTabla").append(cuerpo3);
        var muestraHead1 = [];
        var head1 = "<tr>\
                        <th>Certificación</th>\
                        <th>Fuente</th>\
                        <th>Nombre</th>\
                        <th>Glosa</th>\
                     </tr>";
        $("#tablaPresuHead1").append(head1);
        muestraHead1.push({text: 'Certificación', style: 'tablaHead', alignment: 'center'});
        muestraHead1.push({text: 'Fuente', style: 'tablaHead', alignment: 'center'});
        muestraHead1.push({text: 'Nombre', style: 'tablaHead', alignment: 'center'});
        muestraHead1.push({text: 'Glosa', style: 'tablaHead', alignment: 'center'});
        muestra1.push(muestraHead1);
        var muestraBody1 = [];
        $("#lblPresu1").append("CERTIFICACION " + response.certificacion);
        var body1 = "<tr>\
                        <td class='center'>" + response.certificacion + "</td>\
                        <td class='center'>" + response.fuente + "</td>\
                        <td class='left'>" + response.nombre + "</td>\
                        <td class='left'>" + response.glosa + "</td>\
                     </tr>";
        $("#tablaPresuBody1").append(body1);
        muestraBody1.push({text: response.certificacion, style: 'tablaBody', alignment: 'center'});
        muestraBody1.push({text: response.fuente, style: 'tablaBody', alignment: 'center'});
        muestraBody1.push({text: response.nombre, style: 'tablaBody', alignment: 'left'});
        muestraBody1.push({text: response.glosa, style: 'tablaBody', alignment: 'left'});
        muestra1.push(muestraBody1);
        var muestraHead2 = [];
        $("#lblPresu2").append("DETALLE");
        var head2 = "<tr>\
                        <th>Meta</th>\
                        <th>Finalidad</th>\
                        <th>Específica</th>\
                        <th>Descripción</th>\
                        <th>Certificado (C)</th>\
                        <th>Compromiso Anual (CoA)</th>\
                        <th>Compromiso (Co)</th>\
                        <th>Devengado (D)</th>\
                        <th>Girado (G)</th>\
                        <th>Pagado (Pa)</th>\
                        <th>Saldo por Comprometer Anual (C - CoA)</th>\
                        <th>% Comprometido Anual (CoA/C)</th>\
                        <th>Saldo por Comprometer (C - Co)</th>\
                        <th>% Comprometido (Co/C)</th>\
                        <th>Saldo por Devengar (C - D)</th>\
                        <th>% Devengado (D/C)</th>\
                        <th>Saldo por Girar (C - G)</th>\
                        <th>% Girado (G/C)</th>\
                        <th>Saldo por Pagar (C - Pa)</th>\
                        <th>% Pagado (Pa/C)</th>\
                     </tr>";
        $("#tablaPresuHead2").append(head2);
        muestraHead2.push({text: 'Meta', style: 'tablaHead', alignment: 'center'});
        muestraHead2.push({text: 'Finalidad', style: 'tablaHead', alignment: 'center'});
        muestraHead2.push({text: 'Específica', style: 'tablaHead', alignment: 'center'});
        muestraHead2.push({text: 'Descripción', style: 'tablaHead', alignment: 'center'});
        muestraHead2.push({text: 'Certificado', style: 'tablaHead', alignment: 'center'});
        muestraHead2.push({text: 'Compromiso Anual', style: 'tablaHead', alignment: 'center'});
        muestraHead2.push({text: 'Compromiso', style: 'tablaHead', alignment: 'center'});
        muestraHead2.push({text: 'Devengado', style: 'tablaHead', alignment: 'center'});
        muestraHead2.push({text: 'Girado', style: 'tablaHead', alignment: 'center'});
        muestraHead2.push({text: 'Pagado', style: 'tablaHead', alignment: 'center'});
        muestraHead2.push({text: 'Saldo por Devengar', style: 'tablaHead', alignment: 'center'});
        muestra2.push(muestraHead2);
        var certT, compAT, compT, devenT, giraT, pagaT;
        certT = compAT = compT = devenT = giraT = pagaT = 0.00;
        $.each(response.listD, function (index, value) {
            var cert, compA, compA_saldo, compA_porc, comp, comp_saldo, comp_porc, deven, deven_saldo,
                    deven_porc, gira, gira_saldo, gira_porc, paga, paga_saldo, paga_porc;
            if (!$.trim(value.certificado)) {
                cert = 0.00;
            } else {
                cert = value.certificado;
                certT += value.certificado;
            }
            if (!$.trim(value.compromiso_anual)) {
                compA = 0.00;
                compA_saldo = cert;
                compA_porc = 0.00;
            } else {
                compA = value.compromiso_anual;
                compAT += value.compromiso_anual;
                compA_saldo = value.certificado - value.compromiso_anual;
                compA_porc = (value.compromiso_anual / value.certificado) * 100;
            }
            if (!$.trim(value.compromiso)) {
                comp = 0.00;
                comp_saldo = cert;
                comp_porc = 0.00;
            } else {
                comp = value.compromiso;
                compT += value.compromiso;
                comp_saldo = value.certificado - value.compromiso;
                comp_porc = (value.compromiso / value.certificado) * 100;
            }
            if (!$.trim(value.devengado)) {
                deven = 0.00;
                deven_saldo = cert;
                deven_porc = 0.00;
            } else {
                deven = value.devengado;
                devenT += value.devengado;
                deven_saldo = value.certificado - value.devengado;
                deven_porc = (value.devengado / value.certificado) * 100;
            }
            if (!$.trim(value.girado)) {
                gira = 0.00;
                gira_saldo = cert;
                gira_porc = 0.00;
            } else {
                gira = value.girado;
                giraT += value.girado;
                gira_saldo = value.certificado - value.girado;
                gira_porc = (value.girado / value.certificado) * 100;
            }
            if (!$.trim(value.pagado)) {
                paga = 0.00;
                paga_saldo = cert;
                paga_porc = 0.00;
            } else {
                paga = value.pagado;
                pagaT += value.pagado;
                paga_saldo = value.certificado - value.pagado;
                paga_porc = (value.pagado / value.certificado) * 100;
            }
            var muestraBody2 = [];
            var body2 = "<tr>\
                            <td class='center'>" + value.sec_func + "</td>\
                            <td class='left'>" + value.nombre_sec_func + "</td>\
                            <td class='center'>" + value.clasificador + "</td>\
                            <td class='left'>" + value.descripcion + "</td>\
                            <td class='right'>" + formatNumero(cert) + "</td>\
                            <td class='right'>" + formatNumero(compA) + "</td>\
                            <td class='right'>" + formatNumero(comp) + "</td>\
                            <td class='right'>" + formatNumero(deven) + "</td>\
                            <td class='right'>" + formatNumero(gira) + "</td>\
                            <td class='right'>" + formatNumero(paga) + "</td>\
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
            $("#tablaPresuBody2").append(body2);
            muestraBody2.push({text: value.sec_func, style: 'tablaBody', alignment: 'center'});
            muestraBody2.push({text: value.nombre_sec_func, style: 'tablaBody', alignment: 'left'});
            muestraBody2.push({text: value.clasificador, style: 'tablaBody', alignment: 'center'});
            muestraBody2.push({text: value.descripcion, style: 'tablaBody', alignment: 'left'});
            muestraBody2.push({text: formatNumero(cert), style: 'tablaBody', alignment: 'right'});
            muestraBody2.push({text: formatNumero(compA), style: 'tablaBody', alignment: 'right'});
            muestraBody2.push({text: formatNumero(comp), style: 'tablaBody', alignment: 'right'});
            muestraBody2.push({text: formatNumero(deven), style: 'tablaBody', alignment: 'right'});
            muestraBody2.push({text: formatNumero(gira), style: 'tablaBody', alignment: 'right'});
            muestraBody2.push({text: formatNumero(paga), style: 'tablaBody', alignment: 'right'});
            muestraBody2.push({text: formatNumero(deven_saldo), style: 'tablaBody', alignment: 'right'});
            muestra2.push(muestraBody2);
        });
        var muestraFoot = [];
        var foot = "<tr class='total'>\
                        <td colspan='4' class='right'><b>TOTAL</b></td>\
                        <td class='right'><b>" + formatNumero(certT) + "</b></td>\
                        <td class='right'><b>" + formatNumero(compAT) + "</b></td>\
                        <td class='right'><b>" + formatNumero(compT) + "</b></td>\
                        <td class='right'><b>" + formatNumero(devenT) + "</b></td>\
                        <td class='right'><b>" + formatNumero(giraT) + "</b></td>\
                        <td class='right'><b>" + formatNumero(pagaT) + "</b></td>\
                        <td class='right'><b>" + formatNumero(certT - compAT) + "</b></td>\
                        <td class='center'><b>" + formatNumero((compAT / certT) * 100) + "</b></td>\
                        <td class='right'><b>" + formatNumero(certT - compT) + "</b></td>\
                        <td class='center'><b>" + formatNumero((compT / certT) * 100) + "</b></td>\
                        <td class='right'><b>" + formatNumero(certT - devenT) + "</b></td>\
                        <td class='center'><b>" + formatNumero((devenT / certT) * 100) + "</b></td>\
                        <td class='right'><b>" + formatNumero(certT - giraT) + "</b></td>\
                        <td class='center'><b>" + formatNumero((giraT / certT) * 100) + "</b></td>\
                        <td class='right'><b>" + formatNumero(certT - pagaT) + "</b></td>\
                        <td class='center'><b>" + formatNumero((pagaT / certT) * 100) + "</b></td>\
                    </tr>";
        $("#tablaPresuFoot").append(foot);
        muestraFoot.push({text: 'TOTAL', style: 'tablaTotal', alignment: 'right', colSpan: 4});
        muestraFoot.push("");
        muestraFoot.push("");
        muestraFoot.push("");
        muestraFoot.push({text: formatNumero(certT), style: 'tablaTotal', alignment: 'right'});
        muestraFoot.push({text: formatNumero(compAT), style: 'tablaTotal', alignment: 'right'});
        muestraFoot.push({text: formatNumero(compT), style: 'tablaTotal', alignment: 'right'});
        muestraFoot.push({text: formatNumero(devenT), style: 'tablaTotal', alignment: 'right'});
        muestraFoot.push({text: formatNumero(giraT), style: 'tablaTotal', alignment: 'right'});
        muestraFoot.push({text: formatNumero(pagaT), style: 'tablaTotal', alignment: 'right'});
        muestraFoot.push({text: formatNumero(certT - devenT), style: 'tablaTotal', alignment: 'right'});
        muestra2.push(muestraFoot);

        var muestraHead3 = [];
        $("#lblPresu3").append("EXPEDIENTES SIAF");
        var head3 = "<tr>\
                        <th>Expediente SIAF</th>\
                        <th>Fase</th>\
                        <th>Meta</th>\
                        <th>Finalidad</th>\
                        <th>Específica</th>\
                        <th>Descripción</th>\
                        <th>Monto</th>\
                     </tr>";
        $("#tablaPresuHead3").append(head3);
        muestraHead3.push({text: 'Expediente SIAF', style: 'tablaHead', alignment: 'center'});
        muestraHead3.push({text: 'Fase', style: 'tablaHead', alignment: 'center'});
        muestraHead3.push({text: 'Meta', style: 'tablaHead', alignment: 'center'});
        muestraHead3.push({text: 'Finalidad', style: 'tablaHead', alignment: 'center'});
        muestraHead3.push({text: 'Específica', style: 'tablaHead', alignment: 'center'});
        muestraHead3.push({text: 'Descripción', style: 'tablaHead', alignment: 'center'});
        muestraHead3.push({text: 'Monto', style: 'tablaHead', alignment: 'center'});
        muestra3.push(muestraHead3);
        var montoC, montoD, montoG, montoP;
        montoC = montoD = montoG = montoP = 0.00;
        $.each(response.listExp, function (index, value) {
            var muestraBody3 = [];
            var body3 = "<tr>\
                            <td class='center'>" + value.expediente + "</td>\
                            <td class='left'>" + value.fase + "</td>\
                            <td class='center'>" + value.sec_func + "</td>\
                            <td class='left'>" + value.nombre + "</td>\
                            <td class='center'>" + value.clasificador + "</td>\
                            <td class='left'>" + value.descripcion + "</td>\
                            <td class='right'>" + formatNumero(value.monto) + "</td>\
                         </tr>";
            $("#tablaPresuBody3").append(body3);
            muestraBody3.push({text: value.expediente, style: 'tablaBody', alignment: 'center'});
            muestraBody3.push({text: value.fase, style: 'tablaBody', alignment: 'left'});
            muestraBody3.push({text: value.sec_func, style: 'tablaBody', alignment: 'center'});
            muestraBody3.push({text: value.nombre, style: 'tablaBody', alignment: 'left'});
            muestraBody3.push({text: value.clasificador, style: 'tablaBody', alignment: 'center'});
            muestraBody3.push({text: value.descripcion, style: 'tablaBody', alignment: 'left'});
            muestraBody3.push({text: formatNumero(value.monto), style: 'tablaBody', alignment: 'right'});
            muestra3.push(muestraBody3);
        });
        var countIniT = 5;
        var columnasIni = "[";
        var countFase = 0;
        var countFaseT = 0;
        var columnasFase = "";
        $("input[name=fase]").each(function () {
            if (this.checked === false) {
                var valor = this.value;
                countFase++;
                columnasFase += valor + ", ";
            } else {
                countFaseT++;
            }
        });
        var countSaldo = 0;
        var countSaldoT = 0;
        var columnasSaldo = "";
        $("input[name=saldo]").each(function () {
            if (this.checked === false) {
                var valor = this.value;
                countSaldo++;
                columnasSaldo += valor + ", ";
            } else {
                countSaldoT++;
            }
        });
        var columnasFin = "]";
        if (countSaldo !== 0) {
            columnasSaldo = columnasSaldo.substring(0, columnasSaldo.length - 2);
        } else {
            columnasFase = columnasFase.substring(0, columnasFase.length - 2);
        }
        var columnas = columnasIni + columnasFase + columnasSaldo + columnasFin;
        var countT = countIniT + countFaseT + (countSaldoT * 2);
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
                    collectionLayout: 'fixed three-column'
                },
                {
                    extend: 'excel',
                    footer: true,
                    filename: 'certificacion_' + response.certificacion + '_detallada_' + response.año,
                    title: 'CERTIFICACION DETALLADA - ' + response.año,
                    messageTop: response.tituloPDF,
                    headTop1: 'Certificación : ' + response.certificacion,
                    headTop2: 'Fuente de Financiamiento : ' + response.fuente + ' - ' + response.nombre,
                    headTop3: 'Glosa : ' + response.glosa,
                    exportOptions: {
                        orthogonal: 'sort',
                        columns: ':visible'
                    },
                    customize: function (xlsx) {
                        var sheet = xlsx.xl.worksheets['sheet1.xml'];
                        for (var k = countIniT - 1; k < countIniT + countFaseT; k++) {
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
                        for (var k = countIniT + countFaseT; k < countT; k++) {
                            var total = $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).length;
                            if ((k - countIniT + countFaseT) % 2 === 0) {
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
        $('#tablaPresu3').dataTable({
            ordering: true,
            dom: '<"centrar-div-tabla"lB>iprtip',
            buttons: [
                {
                    extend: 'excel',
                    footer: true,
                    filename: 'certificacion_' + response.certificacion + '_detalle_expedientes_' + response.año,
                    title: 'CERTIFICACION DETALLADA - ' + response.año,
                    messageTop: response.tituloPDF,
                    headTop1: 'Certificación : ' + response.certificacion,
                    headTop2: 'Fuente de Financiamiento : ' + response.fuente + ' - ' + response.nombre,
                    headTop3: 'Glosa : ' + response.glosa,
                    exportOptions: {
                        orthogonal: 'sort',
                        columns: ':visible'
                    },
                    customize: function (xlsx) {
                        var sheet = xlsx.xl.worksheets['sheet1.xml'];
                        var total = $('row c[r^="G"]', sheet).length;
                        $('row c[r^="G"]', sheet).each(function (i) {
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
        $("#divBtnCertDetallePdf a").on('click', function () {
            var docDefinition = {
                pageOrientation: 'landscape',
                info: {
                    title: 'certificacion_' + response.certificacion + '_detallada_' + response.año
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
                                    {text: 'CERTIFICACION DETALLADA - ' + response.año + '\n' + response.tituloPDF, alignment: 'center', style: 'titulo'}
                                ]
                            ]
                        },
                        layout: {
                            hLineColor: 'white',
                            vLineColor: 'white'
                        }
                    },
                    {
                        text: '\n'
                    },
                    {
                        table: {
                            widths: [40, 25, 80, 250],
                            body: muestra1
                        },
                        layout: {
                            hLineColor: '#ECECEC',
                            vLineColor: '#ECECEC'
                        }
                    },
                    {
                        text: '\n DETALLE \n', alignment: 'center', style: 'titulo'
                    },
                    {
                        table: {
                            widths: [20, 220, 35, 170, '*', '*', '*', '*', '*', '*', '*'],
                            body: muestra2
                        },
                        layout: {
                            hLineColor: '#ECECEC',
                            vLineColor: '#ECECEC'
                        }
                    },
                    {
                        text: '\nEXPEDIENTES SIAF\n', alignment: 'center', style: 'titulo'
                    },
                    {
                        table: {
                            widths: [50, 50, 30, '*', 40, '*', 40],
                            body: muestra3
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
                        fillColor: '#EBEBEB',
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
    } else if (tipo === "02") {

        var muestra1 = [];
        var muestra2 = [];
        var cuerpo3 = '<table id="tablaPresu1" class="display" cellspacing="0" width="100%">\
                        <thead id="tablaPresuHead1"></thead>\
                        <tbody id="tablaPresuBody1"></tbody>\
                       </table>\
                       <table id="tablaPresu2" class="display" cellspacing="0" width="100%">\
                        <thead id="tablaPresuHead2"></thead>\
                        <tbody id="tablaPresuBody2"></tbody>\
                        <tfoot id="tablaPresuFoot"></tfoot>\
                       </table>';
        $("#divPresuTabla").append(cuerpo3);
        var muestraHead1 = [];
        var head1 = "<tr>\
                        <th>Certificación</th>\
                        <th>Fuente</th>\
                        <th>Nombre</th>\
                        <th>Glosa</th>\
                     </tr>";
        $("#tablaPresuHead1").append(head1);
        muestraHead1.push({text: 'Certificación', style: 'tablaHead', alignment: 'center'});
        muestraHead1.push({text: 'Fuente', style: 'tablaHead', alignment: 'center'});
        muestraHead1.push({text: 'Nombre', style: 'tablaHead', alignment: 'center'});
        muestraHead1.push({text: 'Glosa', style: 'tablaHead', alignment: 'center'});
        muestra1.push(muestraHead1);
        var muestraBody1 = [];
        var body1 = "<tr>\
                        <td class='center'>" + response.certificacion + "</td>\
                        <td class='center'>" + response.fuente + "</td>\
                        <td class='left'>" + response.nombre + "</td>\
                        <td class='left'>" + response.glosa + "</td>\
                     </tr>";
        $("#tablaPresuBody1").append(body1);
        muestraBody1.push({text: response.certificacion, style: 'tablaBody', alignment: 'center'});
        muestraBody1.push({text: response.fuente, style: 'tablaBody', alignment: 'center'});
        muestraBody1.push({text: response.nombre, style: 'tablaBody', alignment: 'left'});
        muestraBody1.push({text: response.glosa, style: 'tablaBody', alignment: 'left'});
        muestra1.push(muestraBody1);
        var muestraHead2 = [];
        var etapaH = "";
        var etapa1H = "";
        if (response.etapa === "1") {
            etapaH = "Certificado";
            etapa1H = "Certificaciones";
        }
        if (response.etapa === "2") {
            etapaH = "Comprometido";
            etapa1H = "Compromisos Anuales";
        }
        var head2 = "<tr>\
                        <th>Secuencia</th>\
                        <th>Fecha</th>\
                        <th>Meta</th>\
                        <th>Nombre</th>\
                        <th>Específica</th>\
                        <th>Nombre</th>\
                        <th>Monto " + etapaH + " (S/)</th>\
                        <th>Documento</th>\
                        <th>Nº Documento</th>\
                        <th>Tipo Registro</th>\
                     </tr>";
        $("#tablaPresuHead2").append(head2);
        muestraHead2.push({text: 'Secuencia', style: 'tablaHead', alignment: 'center'});
        muestraHead2.push({text: 'Fecha', style: 'tablaHead', alignment: 'center'});
        muestraHead2.push({text: 'Meta', style: 'tablaHead', alignment: 'center'});
        muestraHead2.push({text: 'Específica', style: 'tablaHead', alignment: 'center'});
        muestraHead2.push({text: 'Nombre', style: 'tablaHead', alignment: 'center'});
        muestraHead2.push({text: 'Monto ' + etapaH + ' (S/)', style: 'tablaHead', alignment: 'center'});
        muestraHead2.push({text: 'Documento', style: 'tablaHead', alignment: 'center'});
        muestraHead2.push({text: 'Nº Documento', style: 'tablaHead', alignment: 'center'});
        muestraHead2.push({text: 'Tipo Registro', style: 'tablaHead', alignment: 'center'});
        muestra2.push(muestraHead2);
        var montoT = 0.00;
        $.each(response.listH, function (index, value) {
            var monto = 0.00;
            var tipo_registro = "";
            if (!$.trim(value.monto)) {
                monto = 0.00;
            } else {
                monto = value.monto;
                montoT += value.monto;
            }
            if (value.tipo_registro === "N") {
                tipo_registro = "Normal";
            }
            if (value.tipo_registro === "A") {
                tipo_registro = "Anulación";
            }
            if (value.tipo_registro === "M") {
                tipo_registro = "Ampliación";
            }
            if (value.tipo_registro === "R") {
                tipo_registro = "Rebaja";
            }
            if (value.tipo_registro === "D") {
                tipo_registro = "Devolución";
            }
            var muestraBody2 = [];
            var body2 = "<tr>\
                            <td class='center'>" + value.secuencia + "-" + value.correlativo + "</td>\
                            <td class='center'>" + value.fecha_doc + "</td>\
                            <td class='center'>" + value.sec_func + "</td>\
                            <td class='left'>" + value.nombre_sec_func + "</td>\
                            <td class='center'>" + value.clasificador + "</td>\
                            <td class='left'>" + value.descripcion + "</td>\
                            <td class='right'>" + formatNumero(monto) + "</td>\
                            <td class='left'>" + value.nombre_documento + "</td>\
                            <td class='left'>" + value.num_doc + "</td>\
                            <td class='center'>" + tipo_registro + "</td>\
                         </tr>";
            $("#tablaPresuBody2").append(body2);
            muestraBody2.push({text: value.secuencia + '-' + value.correlativo, style: 'tablaBody', alignment: 'center'});
            muestraBody2.push({text: value.fecha_doc, style: 'tablaBody', alignment: 'center'});
            muestraBody2.push({text: value.sec_func, style: 'tablaBody', alignment: 'center'});
            muestraBody2.push({text: value.clasificador, style: 'tablaBody', alignment: 'center'});
            muestraBody2.push({text: value.descripcion, style: 'tablaBody', alignment: 'left'});
            muestraBody2.push({text: formatNumero(monto), style: 'tablaBody', alignment: 'right'});
            muestraBody2.push({text: value.nombre_documento, style: 'tablaBody', alignment: 'left'});
            muestraBody2.push({text: value.num_doc, style: 'tablaBody', alignment: 'left'});
            muestraBody2.push({text: tipo_registro, style: 'tablaBody', alignment: 'center'});
            muestra2.push(muestraBody2);
        });
        var muestraFoot = [];
        var foot = "<tr class='total'>\
                        <td class='right' colspan='6'>TOTAL</td>\
                        <td class='right'>" + formatNumero(montoT) + "</td>\
                        <td></td>\
                        <td></td>\
                        <td></td>\
                    </tr>";
        $("#tablaPresuFoot").append(foot);
        muestraFoot.push({text: 'TOTAL', style: 'tablaTotal', alignment: 'right', colSpan: 5});
        muestraFoot.push("");
        muestraFoot.push("");
        muestraFoot.push("");
        muestraFoot.push("");
        muestraFoot.push({text: formatNumero(montoT), style: 'tablaTotal', alignment: 'right'});
        muestraFoot.push({text: '', border: [false, false, false, false]});
        muestraFoot.push({text: '', border: [false, false, false, false]});
        muestraFoot.push({text: '', border: [false, false, false, false]});
        muestra2.push(muestraFoot);

        $('#tablaPresu1').dataTable({
            ordering: false,
            dom: 'rt'
        });
        $('#tablaPresu2').dataTable({
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
                    filename: 'historial_' + etapa1H.toLowerCase() + '_certificacion_' + response.certificacion + '_' + response.año,
                    title: 'HISTORIAL DE ' + etapa1H.toUpperCase() + ' - ' + response.año,
                    messageTop: response.tituloPDF,
                    headTop1: 'Certificación : ' + response.certificacion,
                    headTop2: 'Fuente de Financiamiento : ' + response.fuente + ' - ' + response.nombre,
                    headTop3: 'Glosa : ' + response.glosa,
                    exportOptions: {
                        orthogonal: 'sort',
                        columns: ':visible'
                    },
                    customize: function (xlsx) {
                        var sheet = xlsx.xl.worksheets['sheet1.xml'];
                        var total = $('row c[r^="G"]', sheet).length;
                        $('row c[r^="G"]', sheet).each(function (i) {
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
        var btnPDF = '<button id="exportPDF" class="dt-button buttons-html5">\
                        <span>\
                            <img src="./templates/plugins/datatables/images/pdf.png" data-toggle="tooltip" data-placement="bottom" title="Exportar a PDF">\
                        </span>\
                      </button>';
        $("#tablaPresu2_wrapper .dt-buttons").append(btnPDF);
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
                    title: 'historial_' + etapa1H.toLowerCase() + '_certificacion_' + response.certificacion + '_' + response.año
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
                                    {text: 'HISTORIAL DE ' + etapa1H.toUpperCase() + ' - ' + response.año + '\n' + response.tituloPDF, alignment: 'center', style: 'titulo'}
                                ]
                            ]
                        },
                        layout: {
                            hLineColor: 'white',
                            vLineColor: 'white'
                        }
                    },
                    {
                        text: '\n'
                    },
                    {
                        table: {
                            widths: [40, 25, 80, 250],
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
                            widths: [40, 30, 30, 40, '*', 60, '*', 150, 50],
                            body: muestra2
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
                        fillColor: '#EBEBEB',
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

    } else if (tipo === "03") {

        var muestra = [];
        var cuerpo3 = '<table id="tablaPresu" class="display" cellspacing="0" width="100%">\
                        <thead id="tablaPresuHead"></thead>\
                        <tbody id="tablaPresuBody"></tbody>\
                       </table>';
        $("#divPresuTabla").append(cuerpo3);
        var muestraHead = [];
        var etapaE = "";
        var etapa1E = "";
        if (response.etapa === "1") {
            etapaE = "Certificado";
            etapa1E = "Certificacion";
        }
        if (response.etapa === "2") {
            etapaE = "Comprometido";
            etapa1E = "Compromiso Anual";
        }
        var head = "<tr>\
                        <th>Certificación</th>\
                        <th>Fuente</th>\
                        <th>Fecha</th>\
                        <th>Documento</th>\
                        <th>Nº Documento</th>\
                        <th>Monto " + etapaE + " (S/)</th>\
                        <th>Tipo Registro</th>\
                        <th>Estado Registro</th>\
                        <th>Estado Envio</th>\
                     </tr>";
        $("#tablaPresuHead").append(head);
        muestraHead.push({text: 'Certificacion', style: 'tablaHead', alignment: 'center'});
        muestraHead.push({text: 'Fuente', style: 'tablaHead', alignment: 'center'});
        muestraHead.push({text: 'Fecha', style: 'tablaHead', alignment: 'center'});
        muestraHead.push({text: 'Documento', style: 'tablaHead', alignment: 'center'});
        muestraHead.push({text: 'Nº Documento', style: 'tablaHead', alignment: 'center'});
        muestraHead.push({text: 'Monto ' + etapaE + ' (S/)', style: 'tablaHead', alignment: 'center'});
        muestraHead.push({text: 'Tipo Registro', style: 'tablaHead', alignment: 'center'});
        muestraHead.push({text: 'Estado Registro', style: 'tablaHead', alignment: 'center'});
        muestraHead.push({text: 'Estado Envio', style: 'tablaHead', alignment: 'center'});
        muestra.push(muestraHead);
        $.each(response.listE, function (index, value) {
            var monto = 0.00;
            var tipo_registro = "";
            if (!$.trim(value.monto)) {
                monto = 0.00;
            } else {
                monto = value.monto;
            }
            if (value.tipo_registro === "N") {
                tipo_registro = "Normal";
            }
            if (value.tipo_registro === "A") {
                tipo_registro = "Anulación";
            }
            if (value.tipo_registro === "M") {
                tipo_registro = "Ampliación";
            }
            if (value.tipo_registro === "R") {
                tipo_registro = "Rebaja";
            }
            if (value.tipo_registro === "D") {
                tipo_registro = "Devolución";
            }
            var muestraBody = [];
            var body = "<tr>\
                            <td class='center'>" + value.certificacion + "</td>\
                            <td class='left'>" + value.fuente_financ_agregada + " - " + value.nombre_fuente_financ_agregada + "</td>\
                            <td class='center'>" + value.fecha_doc + "</td>\
                            <td class='left'>" + value.nombre_documento + "</td>\
                            <td class='left'>" + value.num_doc + "</td>\
                            <td class='right'>" + formatNumero(monto) + "</td>\
                            <td class='center'>" + tipo_registro + "</td>\
                            <td class='center'>" + value.estado_registro + "</td>\
                            <td class='center'>" + value.estado_envio + "</td>\
                         </tr>";
            $("#tablaPresuBody").append(body);
            muestraBody.push({text: value.certificacion, style: 'tablaBody', alignment: 'center'});
            muestraBody.push({text: value.fuente_financ_agregada + ' - ' + value.nombre_fuente_financ_agregada, style: 'tablaBody', alignment: 'left'});
            muestraBody.push({text: value.fecha_doc, style: 'tablaBody', alignment: 'center'});
            muestraBody.push({text: value.nombre_documento, style: 'tablaBody', alignment: 'left'});
            muestraBody.push({text: value.num_doc, style: 'tablaBody', alignment: 'left'});
            muestraBody.push({text: formatNumero(monto), style: 'tablaBody', alignment: 'right'});
            muestraBody.push({text: tipo_registro, style: 'tablaBody', alignment: 'center'});
            muestraBody.push({text: value.estado_registro, style: 'tablaBody', alignment: 'center'});
            muestraBody.push({text: value.estado_envio, style: 'tablaBody', alignment: 'center'});
            muestra.push(muestraBody);
        });

        $('#tablaPresu').dataTable({
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
                    filename: 'estado_certificaciones_etapa_' + etapa1E.toLowerCase() + '_' + response.año,
                    title: 'ESTADO DE CERTIFICACIONES - ETAPA ' + etapa1E.toUpperCase() + ' - ' + response.año,
                    messageTop: response.tituloPDF,
                    exportOptions: {
                        orthogonal: 'sort',
                        columns: ':visible'
                    },
                    customize: function (xlsx) {
                        var sheet = xlsx.xl.worksheets['sheet1.xml'];
                        var total = $('row c[r^="F"]', sheet).length;
                        $('row c[r^="F"]', sheet).each(function (i) {
                            if (i > 0 && i < total) {
                                $(this).attr('s', '72');
                            }
                        });
                    }
                }
            ]
        });
        var btnPDF = '<button id="exportPDF" class="dt-button buttons-html5">\
                        <span>\
                            <img src="./templates/plugins/datatables/images/pdf.png" data-toggle="tooltip" data-placement="bottom" title="Exportar a PDF">\
                        </span>\
                      </button>';
        $("#tablaPresu_wrapper .dt-buttons").append(btnPDF);
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
                    title: 'estado_certificaciones_etapa_' + etapa1E.toLowerCase() + '_' + response.año
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
                                    {text: 'ESTADO DE CERTIFICACIONES - ETAPA ' + etapa1E.toUpperCase() + ' - ' + response.año + '\n' + response.tituloPDF, alignment: 'center', style: 'titulo'}
                                ]
                            ]
                        },
                        layout: {
                            hLineColor: 'white',
                            vLineColor: 'white'
                        }
                    },
                    {
                        text: '\n'
                    },
                    {
                        table: {
                            widths: [40, 120, 30, '*', '*', 50, 50, 40, 40],
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
                        fillColor: '#EBEBEB',
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

    } else if (tipo === "04") {

        var muestra = [];
        var cuerpo3 = '<table id="tablaPresu" class="display" cellspacing="0" width="100%">\
                        <thead id="tablaPresuHead"></thead>\
                        <tbody id="tablaPresuBody"></tbody>\
                       </table>';
        $("#divPresuTabla").append(cuerpo3);
        var muestraHead = [];
        var etapaD = "";
        if (response.etapa === "1") {
            etapaD = "Certificado";
        }
        if (response.etapa === "2") {
            etapaD = "Comprometido";
        }
        var head = "<tr>\
                        <th>Certificación</th>\
                        <th>Fuente</th>\
                        <th>Fecha</th>\
                        <th>Documento</th>\
                        <th>Nº Documento</th>\
                        <th>Monto " + etapaD + " (S/)</th>\
                        <th>Tipo Registro</th>\
                     </tr>";
        $("#tablaPresuHead").append(head);
        muestraHead.push({text: 'Certificacion', style: 'tablaHead', alignment: 'center'});
        muestraHead.push({text: 'Fuente', style: 'tablaHead', alignment: 'center'});
        muestraHead.push({text: 'Fecha', style: 'tablaHead', alignment: 'center'});
        muestraHead.push({text: 'Documento', style: 'tablaHead', alignment: 'center'});
        muestraHead.push({text: 'Nº Documento', style: 'tablaHead', alignment: 'center'});
        muestraHead.push({text: 'Monto ' + etapaE + ' (S/)', style: 'tablaHead', alignment: 'center'});
        muestraHead.push({text: 'Tipo Registro', style: 'tablaHead', alignment: 'center'});
        muestra.push(muestraHead);
        $.each(response.listD, function (index, value) {
            var monto = 0.00;
            var tipo_registro = "";
            if (!$.trim(value.monto)) {
                monto = 0.00;
            } else {
                monto = value.monto;
            }
            if (value.tipo_registro === "N") {
                tipo_registro = "Normal";
            }
            if (value.tipo_registro === "A") {
                tipo_registro = "Anulación";
            }
            if (value.tipo_registro === "M") {
                tipo_registro = "Ampliación";
            }
            if (value.tipo_registro === "R") {
                tipo_registro = "Rebaja";
            }
            if (value.tipo_registro === "D") {
                tipo_registro = "Devolución";
            }
            var muestraBody = [];
            var body = "<tr>\
                            <td class='center'>" + value.certificacion + "</td>\
                            <td class='left'>" + value.fuente_financ_agregada + " - " + value.nombre_fuente_financ_agregada + "</td>\
                            <td class='center'>" + value.fecha_doc + "</td>\
                            <td class='left'>" + value.nombre_documento + "</td>\
                            <td class='left'>" + value.num_doc + "</td>\
                            <td class='right'>" + formatNumero(monto) + "</td>\
                            <td class='center'>" + tipo_registro + "</td>\
                         </tr>";
            $("#tablaPresuBody").append(body);
            muestraBody.push({text: value.certificacion, style: 'tablaBody', alignment: 'center'});
            muestraBody.push({text: value.fuente_financ_agregada + ' - ' + value.nombre_fuente_financ_agregada, style: 'tablaBody', alignment: 'left'});
            muestraBody.push({text: value.fecha_doc, style: 'tablaBody', alignment: 'center'});
            muestraBody.push({text: value.nombre_documento, style: 'tablaBody', alignment: 'left'});
            muestraBody.push({text: value.num_doc, style: 'tablaBody', alignment: 'left'});
            muestraBody.push({text: formatNumero(monto), style: 'tablaBody', alignment: 'right'});
            muestraBody.push({text: tipo_registro, style: 'tablaBody', alignment: 'center'});
            muestra.push(muestraBody);
        });

        $('#tablaPresu').dataTable({
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
                    filename: 'certificaciones_por_documento_' + response.año,
                    title: 'CERTIFICACIONES POR DOCUMENTO - ' + response.año,
                    messageTop: response.tituloPDF,
                    exportOptions: {
                        orthogonal: 'sort',
                        columns: ':visible'
                    },
                    customize: function (xlsx) {
                        var sheet = xlsx.xl.worksheets['sheet1.xml'];
                        var total = $('row c[r^="F"]', sheet).length;
                        $('row c[r^="F"]', sheet).each(function (i) {
                            if (i > 0 && i < total) {
                                $(this).attr('s', '72');
                            }
                        });
                    }
                }
            ]
        });
        var btnPDF = '<button id="exportPDF" class="dt-button buttons-html5">\
                        <span>\
                            <img src="./templates/plugins/datatables/images/pdf.png" data-toggle="tooltip" data-placement="bottom" title="Exportar a PDF">\
                        </span>\
                      </button>';
        $("#tablaPresu_wrapper .dt-buttons").append(btnPDF);
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
                    title: 'certificaciones_por_documento_' + response.año
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
                                    {text: 'CERTIFICACIONES POR DOCUMENTO - ' + response.año + '\n' + response.tituloPDF, alignment: 'center', style: 'titulo'}
                                ]
                            ]
                        },
                        layout: {
                            hLineColor: 'white',
                            vLineColor: 'white'
                        }
                    },
                    {
                        text: '\n'
                    },
                    {
                        table: {
                            widths: [40, 120, 30, '*', '*', 50, 50],
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
                        fillColor: '#EBEBEB',
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

    } else {
        var array = response.array;
        var sizeS = array.length;
        var size = 0;
        var sizeT = 0;
        var muestra = [];
        var label = nombresCortos03(tipo);
        var cuerpo3 = '<table id="tablaPresu" class="display" cellspacing="0" width="100%">\
                        <thead id="tablaPresuHead"></thead>\
                        <tbody id="tablaPresuBody"></tbody>\
                        <tfoot id="tablaPresuFoot"></tfoot>\
                       </table>';
        $("#divPresuTabla").append(cuerpo3);
        var muestraHead = [];
        var anchos = [];
        head = "<tr>\
                <th>Certificación</th>\
                <th>Fuente</th>\
                <th>Nombre</th>\
                <th>Glosa</th>";
        sizeT += 4;
        var countIniT = 5;
        muestraHead.push({text: 'Certificación', style: 'tablaHead', alignment: 'center'});
        muestraHead.push({text: 'Fuente', style: 'tablaHead', alignment: 'center'});
        muestraHead.push({text: 'Nombre', style: 'tablaHead', alignment: 'center'});
        anchos.push(40);
        anchos.push(25);
        anchos.push(100);
        if (response.filtro !== "00" && response.filtro !== "06") {
            head += "<th>" + label[0] + "</th>\
                     <th>" + label[1] + "</th>";
            muestraHead.push({text: label[0], style: 'tablaHead', alignment: 'center'});
            anchos.push(35);
            size += 2;
            sizeT += 2;
            countIniT += 2;
        }
        if (sizeS >= 0) {
            for (var i = 0; i < sizeS; i++) {
                var tittle = nombresTitulo03(array[i]);
                head += "<th>" + tittle[0] + "</th>\
                         <th>" + tittle[1] + "</th>";
                muestraHead.push({text: tittle[0], style: 'tablaHead', alignment: 'center'});
                anchos.push(35);
                sizeT += 2;
                countIniT += 2;
            }
        }
        head += "<th>Certificado (C)</th>\
                    <th>Compromiso Anual (CoA)</th>\
                    <th>Compromiso (Co)</th>\
                    <th>Devengado (D)</th>\
                    <th>Girado (G)</th>\
                    <th>Pagado (Pa)</th>\
                    <th>Saldo por Comprometer Anual (C - CoA)</th>\
                    <th>% Comprometido Anual (CoA/C)</th>\
                    <th>Saldo por Comprometer (C - Co)</th>\
                    <th>% Comprometido (Co/C)</th>\
                    <th>Saldo por Devengar (C - D)</th>\
                    <th>% Devengado (D/C)</th>\
                    <th>Saldo por Girar (C - G)</th>\
                    <th>% Girado (G/C)</th>\
                    <th>Saldo por Pagar (C - Pa)</th>\
                    <th>% Pagado (Pa/C)</th>\
                   </tr>";
        $("#tablaPresuHead").append(head);
        muestraHead.push({text: 'Certificado', style: 'tablaHead', alignment: 'center'});
        muestraHead.push({text: 'Compromiso Anual', style: 'tablaHead', alignment: 'center'});
        muestraHead.push({text: 'Compromiso', style: 'tablaHead', alignment: 'center'});
        muestraHead.push({text: 'Devengado', style: 'tablaHead', alignment: 'center'});
        muestraHead.push({text: 'Girado', style: 'tablaHead', alignment: 'center'});
        muestraHead.push({text: 'Pagado', style: 'tablaHead', alignment: 'center'});
        muestraHead.push({text: 'Saldo por Devengar', style: 'tablaHead', alignment: 'center'});
        anchos.push('*');
        anchos.push('*');
        anchos.push('*');
        anchos.push('*');
        anchos.push('*');
        anchos.push('*');
        anchos.push('*');
        muestra.push(muestraHead);
        var certT, compAT, compT, devenT, giraT, pagaT;
        certT = compAT = compT = devenT = giraT = pagaT = 0.00;
        $.each(response.list, function (index, value) {
            var cert, compA, compA_saldo, compA_porc, comp, comp_saldo, comp_porc, deven, deven_saldo,
                    deven_porc, gira, gira_saldo, gira_porc, paga, paga_saldo, paga_porc;
            if (!$.trim(value.certificado)) {
                cert = 0.00;
            } else {
                cert = value.certificado;
                certT += value.certificado;
            }
            if (!$.trim(value.compromiso_anual)) {
                compA = 0.00;
                compA_saldo = cert;
                compA_porc = 0.00;
            } else {
                compA = value.compromiso_anual;
                compAT += value.compromiso_anual;
                compA_saldo = value.certificado - value.compromiso_anual;
                compA_porc = (value.compromiso_anual / value.certificado) * 100;
            }
            if (!$.trim(value.compromiso)) {
                comp = 0.00;
                comp_saldo = cert;
                comp_porc = 0.00;
            } else {
                comp = value.compromiso;
                compT += value.compromiso;
                comp_saldo = value.certificado - value.compromiso;
                comp_porc = (value.compromiso / value.certificado) * 100;
            }
            if (!$.trim(value.devengado)) {
                deven = 0.00;
                deven_saldo = cert;
                deven_porc = 0.00;
            } else {
                deven = value.devengado;
                devenT += value.devengado;
                deven_saldo = value.certificado - value.devengado;
                deven_porc = (value.devengado / value.certificado) * 100;
            }
            if (!$.trim(value.girado)) {
                gira = 0.00;
                gira_saldo = cert;
                gira_porc = 0.00;
            } else {
                gira = value.girado;
                giraT += value.girado;
                gira_saldo = value.certificado - value.girado;
                gira_porc = (value.girado / value.certificado) * 100;
            }
            if (!$.trim(value.pagado)) {
                paga = 0.00;
                paga_saldo = cert;
                paga_porc = 0.00;
            } else {
                paga = value.pagado;
                pagaT += value.pagado;
                paga_saldo = value.certificado - value.pagado;
                paga_porc = (value.pagado / value.certificado) * 100;
            }
            var muestraBody = [];
            body = "<tr>\
                    <td class='center'>" + value.certificacion + "</td>\
                    <td class='center'>" + value.fuente_financ_agregada + "</td>\
                    <td class='left'>" + value.nombre_fuente_financ_agregada + "</td>\
                    <td class='left'>" + value.glosa + "</td>";
            muestraBody.push({text: value.certificacion, style: 'tablaBody', alignment: 'center'});
            muestraBody.push({text: value.fuente_financ_agregada, style: 'tablaBody', alignment: 'center'});
            muestraBody.push({text: value.nombre_fuente_financ_agregada, style: 'tablaBody', alignment: 'center'});
            if (response.filtro !== "00" && response.filtro !== "06") {
                body += "<td class='center'>" + value.codigo + "</td>\
                     <td class='left'>" + value.nombre + "</td>";
                muestraBody.push({text: value.codigo, style: 'tablaBody', alignment: 'center'});
            }
            if (sizeS >= 0) {
                for (var j = 0; j < sizeS; j++) {
                    var bodyArray = nombresBody03(array[j], value);
                    body += bodyArray[0];
                    muestraBody.push({text: bodyArray[1], style: 'tablaBody', alignment: 'center'});
                }
            }
            body += "<td class='right'>" + formatNumero(cert) + "</td>\
                        <td class='right'>" + formatNumero(compA) + "</td>\
                        <td class='right'>" + formatNumero(comp) + "</td>\
                        <td class='right'>" + formatNumero(deven) + "</td>\
                        <td class='right'>" + formatNumero(gira) + "</td>\
                        <td class='right'>" + formatNumero(paga) + "</td>\
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
            muestraBody.push({text: formatNumero(cert), style: 'tablaBody', alignment: 'right'});
            muestraBody.push({text: formatNumero(compA), style: 'tablaBody', alignment: 'right'});
            muestraBody.push({text: formatNumero(comp), style: 'tablaBody', alignment: 'right'});
            muestraBody.push({text: formatNumero(deven), style: 'tablaBody', alignment: 'right'});
            muestraBody.push({text: formatNumero(gira), style: 'tablaBody', alignment: 'right'});
            muestraBody.push({text: formatNumero(paga), style: 'tablaBody', alignment: 'right'});
            muestraBody.push({text: formatNumero(deven_saldo), style: 'tablaBody', alignment: 'right'});
            muestra.push(muestraBody);
        });
        var muestraBodyT = [];
        muestraBodyT.push({text: 'TOTAL', style: 'tablaTotal', alignment: 'right', colSpan: (3 + size)});
        muestraBodyT.push("");
        muestraBodyT.push("");
        if (response.filtro !== "00" && response.filtro !== "06") {
            muestraBodyT.push("");
        }
        if (sizeS >= 0) {
            for (var k = 0; k < sizeS; k++) {
                muestraBodyT.push("");
            }
        }
        foot = "<tr class='total'>\
                 <td colspan='" + sizeT + "' class='right'><b>TOTAL</b></td>\
                 <td class='right'><b>" + formatNumero(certT) + "</b></td>\
                 <td class='right'><b>" + formatNumero(compAT) + "</b></td>\
                 <td class='right'><b>" + formatNumero(compT) + "</b></td>\
                 <td class='right'><b>" + formatNumero(devenT) + "</b></td>\
                 <td class='right'><b>" + formatNumero(giraT) + "</b></td>\
                 <td class='right'><b>" + formatNumero(pagaT) + "</b></td>\
                 <td class='right'><b>" + formatNumero(certT - compAT) + "</b></td>\
                 <td class='center'><b>" + formatNumero((compAT / certT) * 100) + "</b></td>\
                 <td class='right'><b>" + formatNumero(certT - compT) + "</b></td>\
                 <td class='center'><b>" + formatNumero((compT / certT) * 100) + "</b></td>\
                 <td class='right'><b>" + formatNumero(certT - devenT) + "</b></td>\
                 <td class='center'><b>" + formatNumero((devenT / certT) * 100) + "</b></td>\
                 <td class='right'><b>" + formatNumero(certT - giraT) + "</b></td>\
                 <td class='center'><b>" + formatNumero((giraT / certT) * 100) + "</b></td>\
                 <td class='right'><b>" + formatNumero(certT - pagaT) + "</b></td>\
                 <td class='center'><b>" + formatNumero((pagaT / certT) * 100) + "</b></td>\
                </tr>";
        $("#tablaPresuFoot").append(foot);
        muestraBodyT.push({text: formatNumero(certT), style: 'tablaTotal', alignment: 'right'});
        muestraBodyT.push({text: formatNumero(compAT), style: 'tablaTotal', alignment: 'right'});
        muestraBodyT.push({text: formatNumero(compT), style: 'tablaTotal', alignment: 'right'});
        muestraBodyT.push({text: formatNumero(devenT), style: 'tablaTotal', alignment: 'right'});
        muestraBodyT.push({text: formatNumero(giraT), style: 'tablaTotal', alignment: 'right'});
        muestraBodyT.push({text: formatNumero(pagaT), style: 'tablaTotal', alignment: 'right'});
        muestraBodyT.push({text: formatNumero(certT - devenT), style: 'tablaTotal', alignment: 'right'});
        muestra.push(muestraBodyT);
        var columnasIni = "[";
        var countFase = 0;
        var countFaseT = 0;
        var columnasFase = "";
        $("input[name=fase]").each(function () {
            if (this.checked === false) {
                var valor = this.value;
                countFase++;
                if (size > 0) {
                    columnasFase += (Number.parseInt(valor, 10) + size + (2 * sizeS)) + ", ";
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
                var valor = this.value;
                countSaldo++;
                if (size > 0) {
                    columnasSaldo += (Number.parseInt(valor, 10) + size + (2 * sizeS)) + ", " + (Number.parseInt(valor, 10) + (size + (2 * sizeS) + 1)) + ", ";
                } else {
                    columnasSaldo += valor + ", ";
                }
            } else {
                countSaldoT++;
            }
        });
        var columnasFin = "]";
        if (countSaldo !== 0) {
            columnasSaldo = columnasSaldo.substring(0, columnasSaldo.length - 2);
        } else {
            columnasFase = columnasFase.substring(0, columnasFase.length - 2);
        }
        var columnas = columnasIni + columnasFase + columnasSaldo + columnasFin;
        var countT = countIniT + countFaseT + (countSaldoT * 2);
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
                    filename: 'certificaciones_presupuestarias_' + (response.ejec === "00" ? "pliego459" : response.ejec) + '_' + response.año,
                    title: 'CERTIFICACIONES PRESUPUESTARIAS - ' + response.año,
                    messageTop: response.tituloPDF,
                    exportOptions: {
                        orthogonal: 'sort',
                        columns: ':visible'
                    },
                    customize: function (xlsx) {
                        var sheet = xlsx.xl.worksheets['sheet1.xml'];
                        for (var k = countIniT - 1; k < countIniT + countFaseT; k++) {
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
                        for (var k = countIniT + countFaseT; k < countT; k++) {
                            var total = $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).length;
                            if ((k - countIniT + countFaseT) % 2 === 0) {
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
        var btnPDF = '<button id="exportPDF" class="dt-button buttons-html5">\
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
                    title: 'certificaciones_presupuestarias_' + response.ejec + '_' + response.año
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
                                    {text: 'CERTIFICACIONES PRESUPUESTARIAS - ' + response.año + '\n' + response.tituloPDF + '\n', alignment: 'center', style: 'titulo'}
                                ]
                            ]
                        },
                        layout: {
                            hLineColor: 'white',
                            vLineColor: 'white'
                        }
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
                        fillColor: '#EBEBEB',
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


function cambiaFaseCert() {
    $("input[name=fase_todo]").change(function () {
        if (this.checked) {
            $("input[name=fase]").prop("checked", true);
        }
        if (this.checked === false) {
            $("input[name=fase]").prop("checked", false);
        }
    });
    $("input[name=fase]").change(function () {
        if (this.checked === false) {
            $("input[name=fase_todo]").prop("checked", false);
        }
        var count = 0;
        $("input[name=fase]").each(function () {
            if (this.checked) {
                count++;
            }
        });
        if (count === 5) {
            $("input[name=fase_todo]").prop("checked", true);
        }
    });
}

function cambiaEtapaCert() {
    $("input[name=etapa]").change(function () {
        if (this.checked) {
            $("input[name=etapa]").prop("checked", false);
            $("input[value=" + this.value + "]").prop("checked", true);
        } else {
            $("input[value=" + this.value + "]").prop("checked", true);
        }
    });
}

function llenarTipoDocu03(año, ejec, tipo) {
    $('#listEjecCertDocu').empty();
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataEjecDocuCerti&año=" + año + "&ejec=" + ejec + "&tipo=" + tipo,
        success: function (response) {
            $.each(response.listDoc, function (index, value) {
                objeDoc = "<option value=" + value.cod_doc + ">" + value.nombre + "</option>";
                $("#listEjecCertDocu").append(objeDoc);
            });
        }
    });
}

function cambiaSaldoCert() {
    $("input[name=saldo_todo]").change(function () {
        if (this.checked) {
            $("input[name=saldo]").prop("checked", true);
        }
        if (this.checked === false) {
            $("input[name=saldo]").prop("checked", false);
        }
    });
    $("input[name=saldo]").change(function () {
        if (this.checked === false) {
            $("input[name=saldo_todo]").prop("checked", false);
        }
        var count = 0;
        $("input[name=saldo]").each(function () {
            if (this.checked) {
                count++;
            }
        });
        if (count === 5) {
            $("input[name=saldo_todo]").prop("checked", true);
        }
    });
}

function cambiaEstadoCert() {
    $("input[name=estado]").change(function () {
        if (this.checked) {
            $("input[name=estado]").prop("checked", false);
            $("input[value=" + this.value + "]").prop("checked", true);
        } else {
            $("input[value=" + this.value + "]").prop("checked", true);
        }
    });
}


