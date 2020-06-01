// Reporte de Notas Modificatorias Presupuestales

function FiltroReporte05() {
    alert("funciona filtro05");
}

function llenarFiltroReporte05() {
    $("#divPresuFiltReporte").empty();
    filtro = '<div class="form-group row">\
                    <label for="listNotasFiltroPrinc" class="col-sm-2 col-form-label">Filtro Principal :</label>\
                    <div class="col-sm-6">\
                        <select class="select-form" id="listNotasFiltroPrinc" name="filtro_princ">\
                            <option value="00" selected>Resumen de Modificaciones Presupuestales por Documento</option>\
                            <option value="01">Resumen de Modificaciones Presupuestales por Notas</option>\
                            <option value="02">Nota Modificatoria Detallada</option>\
                        </select>\
                    </div>\
              </div>';
    filtro += '<div class="form-group row">\
                 <label for="listNotasEjecutora" class="col-sm-2 col-form-label">Elija Ejecutora :</label>\
                 <div class="col-sm-6">\
                    <select class="select-form" id="listNotasEjecutora" name="ejec"></select>\
                 </div>\
                 <label class="col-sm-1"></label>\
                 <label for="listNotasAño" class="col-sm-1 col-form-label">Elija Año :</label>\
                 <div class="col-sm-2">\
                    <select class="select-form" id="listNotasAño" name="anho"></select>\
                 </div>\
               </div>';
    meses = '<div class="form-group row">\
                <label for="listPresuMesDesde" class="col-sm-2 col-form-label">Desde Mes :</label>\
                <div class="col-sm-2">\
                    <select class="select-form" id="listPresuMesDesde" name="desde"></select>\
                </div>\
                <label for="listPresuMesHasta" class="col-sm-2 col-form-label">Hasta Mes :</label>\
                <div class="col-sm-2">\
                    <select class="select-form" id="listPresuMesHasta" name="hasta"></select>\
                </div>\
                <div class="col-sm-1"></div>\
                <div id="divNotasEstado" class="oculto">\
                    <label for="listNotasEstado" class="col-sm-1 col-form-label">Estado :</label>\
                    <div class="col-sm-2">\
                        <select class="select-form" id="listNotasEstado" name="estado"></select>\
                    </div>\
                </div>\
             </div>';
    ciclo = '<div id="divNotasCiclo" class="form-group row line_top">\
                <label class="col-sm-2">Ciclo :</label>\
                <div class="col-sm-1 fontweight3">\
                    <label class="custom-control custom-checkbox">\
                    <input type="checkbox" class="custom-control-input" name="ciclo" value="G" checked>\
                    <span class="custom-control-indicator"></span>&nbsp;\
                    <span class="custom-control-description">Gasto</span>\
                    </label>\
                </div>\
                <div class="col-sm-1 fontweight3">\
                    <label class="custom-control custom-checkbox">\
                    <input type="checkbox" class="custom-control-input" name="ciclo" value="I">\
                    <span class="custom-control-indicator"></span>&nbsp;\
                    <span class="custom-control-description">Ingreso</span>\
                    </label>\
                </div>\
             </div>';
    rubro = '<div id="divNotasRubro" class="form-group row line_top">\
                <label for="dlNotasRubro" class="col-sm-2 col-form-label">Rubro de Financiamiento</label>\
                <div class="col-sm-10">\
                    <dl id="dlNotasRubro" class="dropdownF">\
                        <dt>\
                            <a>\
                                <label id="lblSelectRubro"><b>--Todos--</b></label>\
                                <span class="hida">\
                                    <i class="fa fa-filter" aria-hidden="true"></i>\
                                </span>\
                            </a>\
                        </dt>\
                        <dd>\
                            <div class="mutliSelect">\
                                <ul id="ulNotasRubro"></ul>\
                            </div>\
                        </dd>\
                    </dl>\
                </div>\
             </div>';
    tipo = '<div id="divNotasTipo" class="form-group row">\
                <label for="dlNotasTipo" class="col-sm-2 col-form-label">Tipo de Modificación</label>\
                <div class="col-sm-10">\
                    <dl id="dlNotasTipo" class="dropdownF">\
                        <dt>\
                            <a>\
                                <label id="lblSelectTipo"><b>--Todos--</b></label>\
                                <span class="hida">\
                                    <i class="fa fa-filter" aria-hidden="true"></i>\
                                </span>\
                            </a>\
                        </dt>\
                        <dd>\
                            <div class="mutliSelect">\
                                <ul id="ulNotasTipo"></ul>\
                            </div>\
                        </dd>\
                    </dl>\
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
                <button id="btnRepoPresu05" type="reset" value="Reset" class="btn btn3d btn-white btn-m">\
                <span class="glyphicon glyphicon-erase spanBtn"></span>Limpiar\
                </button>\
                </div>\
                </div>';
    html = filtro + meses + ciclo + rubro + tipo + botones;
    $("#divPresuFiltReporte").append(html);
    $("#dlNotasRubro.dropdownF dt a").on('click', function () {
        $("#dlNotasTipo.dropdownF dd ul").hide();
        $("#dlNotasRubro.dropdownF dd ul").slideToggle('fast');
    });
    $("#dlNotasRubro.dropdownF dd ul li a").on('click', function () {
        $("#dlNotasRubro.dropdownF dd ul").hide();
    });
    $(document).bind('click', function (e) {
        var $clicked = $(e.target);
        if (!$clicked.parents().hasClass("dropdownF"))
            $("#dlNotasRubro.dropdownF dd ul").hide();
    });
    $("#dlNotasTipo.dropdownF dt a").on('click', function () {
        $("#dlNotasRubro.dropdownF dd ul").hide();
        $("#dlNotasTipo.dropdownF dd ul").slideToggle('fast');
    });
    $("#dlNotasTipo.dropdownF dd ul li a").on('click', function () {
        $("#dlNotasTipo.dropdownF dd ul").hide();
    });
    $(document).bind('click', function (e) {
        var $clicked = $(e.target);
        if (!$clicked.parents().hasClass("dropdownF"))
            $("#dlNotasTipo.dropdownF dd ul").hide();
    });
    limpiar();
}

function controlFiltroReporte05() {
    llenarNotasEjecutora05("pliego");
    llenarNotasEstado05();
    $("#listNotasEjecutora").bind("change", function () {
        llenarNotasAños05($('#listNotasEjecutora').val());
    });
    $("#listNotasAño").bind("change", function () {
        llenarNotasMeses05($("#listNotasAño").val());
        var ciclo;
        $("input[name=ciclo]").each(function () {
            if (this.checked) {
                ciclo = this.value;
            }
        });
        llenarNotasRubro05($("#listNotasAño").val(), ciclo);
        llenarNotasTipo05($("#listNotasAño").val());
    });
    $("#listNotasFiltroPrinc").bind("change", function () {
        if ($('#listNotasFiltroPrinc').val() === "02") {
            $('#divNotasCiclo').addClass("oculto");
            $('#divNotasEstado').removeClass("oculto");
            llenarNotasEjecutora05("");
        } else {
            $('#divNotasCiclo').removeClass("oculto");
            $('#divNotasEstado').addClass("oculto");
            llenarNotasEjecutora05("pliego");
        }
    });
    $("#listPresuMesDesde").bind("change", function () {
        $.ajax({
            dataType: 'json',
            url: "./GsonData?url=DataNotasMes&año=" + $("#listNotasAño").val() + "&desde=" + $("#listPresuMesDesde").val() + "&orden=DESC",
            success: function (response3) {
                $('#listPresuMesHasta').empty();
                $.each(response3.listMes, function (index3, value3) {
                    var mes3 = "<option value=" + value3.mes + ">" + value3.nombre + "</option>";
                    $("#listPresuMesHasta").append(mes3);
                });
                $('#listPresuMesHasta').prop('selectedIndex', 0);
            }
        });
    });
    $("input[name=ciclo]").change(function () {
        if (this.checked) {
            $("input[name=ciclo]").prop("checked", false);
            $("input[value=" + this.value + "]").prop("checked", true);
            llenarNotasRubro05($("#listNotasAño").val(), this.value);
        } else {
            $("input[value=" + this.value + "]").prop("checked", true);
        }
    });
    $("#btnRepoPresu05").click(function () {
        $("#divPresuTabla").empty();
        $("#divPresuTabla").addClass("oculto");
        $("#lblPresuFiltGrafico").addClass("oculto");
        $("#divPresuFiltGrafico").empty();
        $("#divPresuFiltGrafico").addClass("oculto");
        $("#divPresuGrafica").empty();
        $("#divPresuGrafica").addClass("oculto");
        $('#divNotasCiclo').removeClass("oculto");
        $('#lblNotasEstado').addClass("oculto");
        $('#divNotasEstado').addClass("oculto");
    });
}

function llenarNotasEjecutora05(nivel) {
    $('#listNotasEjecutora').empty();
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataEjecutoras",
        success: function (response) {
            if (nivel === "pliego") {
                $("#listNotasEjecutora").append("<option value= '00'>Pliego 459 - Gobierno Regional de San Martin</option>");
            }
            $.each(response.listEjecutoras, function (index, value) {
                var nombre_ejec = (value.nombre).split("-");
                var objeEjec = "<option value=" + value.sec_ejec + ">UE " + value.ejecutora + " - " + nombre_ejec[1].trim() + " (" + value.sec_ejec + ")</option>";
                $("#listNotasEjecutora").append(objeEjec);
            });
            $('#listNotasEjecutora').prop('selectedIndex', 0);
            llenarNotasAños05($('#listNotasEjecutora').val());
        }
    });
}

function llenarNotasAños05(ejecutora) {
    $('#listNotasAño').empty();
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataPresuAños&sec_ejec=" + ejecutora,
        success: function (responseA) {
            $.each(responseA.listAños, function (indexA, valueA) {
                var objeA = "<option value=" + valueA.ano_eje + ">" + valueA.ano_eje + "</option>";
                $("#listNotasAño").append(objeA);
            });
            $('#listNotasAño').prop('selectedIndex', 0);
            var año = $("#listNotasAño").val();
            llenarNotasMeses05(año);
            llenarNotasRubro05(año, "G");
            llenarNotasTipo05(año);
        }
    });
}

function llenarNotasMeses05(ano) {
    $('#listPresuMesDesde').empty();
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataNotasMes&año=" + ano + "&desde=1&orden=ASC",
        success: function (response1) {
            $.each(response1.listMes, function (index1, value1) {
                var listmes1 = "<option value=" + value1.mes + ">" + value1.nombre + "</option>";
                $("#listPresuMesDesde").append(listmes1);
            });
            $('#listPresuMesDesde').prop('selectedIndex', 0);
            $('#listPresuMesHasta').empty();
            $.ajax({
                dataType: 'json',
                url: "./GsonData?url=DataNotasMes&año=" + ano + "&desde=1&orden=DESC",
                success: function (response2) {
                    $.each(response2.listMes, function (index2, value2) {
                        var listmes2 = "<option value=" + value2.mes + ">" + value2.nombre + "</option>";
                        $("#listPresuMesHasta").append(listmes2);
                    });
                    $('#listPresuMesHasta').prop('selectedIndex', 0);
                }
            });
        }
    });
}

function llenarNotasTipo05(ano) {
    $("#ulNotasTipo").empty();
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataNotasTipo&año=" + ano,
        success: function (responseT) {
            var tip1 = '<li><label class="custom-control custom-checkbox">\
                            <input type="checkbox" class="custom-control-input" value="todo" name="tipo_todo" checked>\
                            <span class="custom-control-indicator"></span>&nbsp;\
                            <span class="custom-control-description"><b>--Todos--</b></span>\
                         </label></li>';
            $("#ulNotasTipo").append(tip1);
            var sizeT = 0;
            $.each(responseT.list, function (indexT, valueT) {
                sizeT++;
                var tip2 = '<li><label class="custom-control custom-checkbox">\
                                <input type="checkbox" class="custom-control-input" value="' + valueT.codigo + '" name="tipo" checked>\
                                <span class="custom-control-indicator"></span>&nbsp;\
                                <span class="custom-control-description"><b>' + valueT.codigo + "</b> - " + valueT.nombre + '</span>\
                             </label></li>';
                $("#ulNotasTipo").append(tip2);
            });
            $("input[name=tipo_todo]").change(function () {
                $("#lblSelectTipo").empty();
                if (this.checked) {
                    $("#lblSelectTipo").append("<b>--Todos--</b>");
                    $("input[name=tipo]").prop("checked", true);
                }
                if (this.checked === false) {
                    $("#lblSelectTipo").append("<b style='color: orangered;'>--Ninguno--</b>");
                    $("input[name=tipo]").prop("checked", false);
                }
            });
            $("input[name=tipo]").change(function () {
                $("#lblSelectTipo").empty();
                if (this.checked === false) {
                    $("input[name=tipo_todo]").prop("checked", false);
                }
                var count = 0;
                var text = "";
                $("input[name=tipo]").each(function () {
                    if (this.checked) {
                        count++;
                        text += this.value + ", ";
                    }
                });
                text = "<b>" + text.substring(0, text.length - 2) + "</b>";
                if (count === sizeT) {
                    text = "<b>--Todas--</b>";
                    $("input[name=tipo_todo]").prop("checked", true);
                }
                if (count === 0) {
                    text = "<b style='color: orangered;'>--Ninguno--</b>";
                }
                $("#lblSelectTipo").append(text);
            });
        }
    });
}

function llenarNotasRubro05(año, ciclo) {
    $("#ulNotasRubro").empty();
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataNotasRubro&año=" + año + "&ciclo=" + ciclo,
        success: function (responseR) {
            var rub1 = '<li><label class="custom-control custom-checkbox">\
                            <input type="checkbox" class="custom-control-input" value="todo" name="rubro_todo" checked>\
                            <span class="custom-control-indicator"></span>&nbsp;\
                            <span class="custom-control-description"><b>--Todos--</b></span>\
                         </label></li>';
            $("#ulNotasRubro").append(rub1);
            var size = 0;
            $.each(responseR.list, function (indexR, valueR) {
                size++;
                var rub2 = '<li><label class="custom-control custom-checkbox">\
                                <input type="checkbox" class="custom-control-input" value="' + valueR.codigo + '" name="rubro" checked>\
                                <span class="custom-control-indicator"></span>&nbsp;\
                                <span class="custom-control-description"><b>' + valueR.codigo + "</b> - " + valueR.nombre + '</span>\
                             </label></li>';
                $("#ulNotasRubro").append(rub2);
            });
            $("input[name=rubro_todo]").change(function () {
                $("#lblSelectRubro").empty();
                if (this.checked) {
                    $("#lblSelectRubro").append("<b>--Todos--</b>");
                    $("input[name=rubro]").prop("checked", true);
                }
                if (this.checked === false) {
                    $("#lblSelectRubro").append("<b style='color: orangered;'>--Ninguno--</b>");
                    $("input[name=rubro]").prop("checked", false);
                }
            });
            $("input[name=rubro]").change(function () {
                $("#lblSelectRubro").empty();
                if (this.checked === false) {
                    $("input[name=rubro_todo]").prop("checked", false);
                }
                var count = 0;
                var text = "";
                $("input[name=rubro]").each(function () {
                    if (this.checked) {
                        count++;
                        text += this.value + ", ";
                    }
                });
                text = "<b>" + text.substring(0, text.length - 2) + "</b>";
                if (count === size) {
                    text = "<b>--Todas--</b>";
                    $("input[name=rubro_todo]").prop("checked", true);
                }
                if (count === 0) {
                    text = "<b style='color: orangered;'>--Ninguno--</b>";
                }
                $("#lblSelectRubro").append(text);
            });
        }
    });
}

function llenarNotasEstado05() {
    $("#listNotasEstado").empty();
    var estado = '<option value="1">Aprobado</option>\
                  <option value="2">Anulado</option>';
    $("#listNotasEstado").append(estado);
}

function validarFiltroReporte05() {
    var msg;
    msg = "OK";
    var countRubro = 0;
    $("input[name=rubro]").each(function () {
        if (this.checked) {
            countRubro++;
        }
    });
    if (countRubro === 0) {
        msg = "Debe seleccionar al menos un Rubro de Financiamiento";
        return(msg);
    }
    var countTipo = 0;
    $("input[name=tipo]").each(function () {
        if (this.checked) {
            countTipo++;
        }
    });
    if (countTipo === 0) {
        msg = "Debe seleccionar al menos un Tipo de Modificación";
        return(msg);
    }
    return(msg);
}


function llenarTablaReporte05(response) {
    var tipo = $("#listNotasFiltroPrinc").val();
    if (tipo === "00" || tipo === "01") {
        var documentos_nota = [];
        var titu_file = tipo === "00" ? "por_documento" : "por_notas";
        var titu_doc = tipo === "00" ? "POR DOCUMENTO" : "POR NOTAS";
        var boton = '<div class="btn-proy-busqueda">\
                        <a id="aExportNotaR">\
                           <img src="./templates/plugins/datatables/images/pdf.png" alt="Exportar a PDF" title="Exportar a PDF">\
                        </a>\
                     </div>\
                     <div class="margen-reportes-presu" style="margin-bottom: 15px;">\
                         <div class="titulo_reportes">\
                           <label>RESUMEN DE MODIFICACIONES PRESUPUESTALES</label>\
                     </div>';
        $("#divPresuTabla").append(boton);
        $.each(response.listRubro, function (index0, value0) {
            var muestra = [];
            var anchos = [];
            var tablas = '<div class="tabla_reporte" style="overflow-x:auto;">\
                              <label class="notas_subtitulo">RUBRO DE FINANCIAMIENTO : ' + value0.codigo + ' - ' + value0.nombre + '</label>\
                              <br>\
                              <table id="tablaNotas' + value0.codigo + '" class="display" cellspacing="0" width="100%">\
                                <thead id="tablaNotas' + value0.codigo + 'Head"></thead>\
                                <tbody id="tablaNotas' + value0.codigo + 'Body"></tbody>\
                                <tfoot id="tablaNotas' + value0.codigo + 'Foot"></tfoot>\
                              </table>\
                              <br>\
                          </div>';
            $("#divPresuTabla").append(tablas);
            var muestraHead = [];
            var head = '<tr>';
            var countIniT = 0;
            if (tipo === "00") {
                head += '<th>Documento</th>\
                         <th>Nº Documento</th>\
                         <th>Mes de Creación</th>\
                         <th>Fecha de Regularización</th>';
                muestraHead.push({text: 'DOCUMENTO', style: 'tablaHead', alignment: 'center'});
                muestraHead.push({text: 'Nº DOCUMENTO', style: 'tablaHead', alignment: 'center'});
                muestraHead.push({text: 'MES CREACIÓN', style: 'tablaHead', alignment: 'center'});
                muestraHead.push({text: 'FECHA REGULARIZACIÓN', style: 'tablaHead', alignment: 'center'});
                anchos.push('*');
                anchos.push(60);
                anchos.push(25);
                anchos.push(50);
                countIniT += 4;
            }
            if (tipo === "01") {
                head += '<th>Notas</th>\
                         <th>Unidad Ejecutora</th>\
                         <th>Mes</th>';
                muestraHead.push({text: 'NOTAS', style: 'tablaHead', alignment: 'center'});
                muestraHead.push({text: 'UNIDAD EJECUTORA', style: 'tablaHead', alignment: 'center'});
                muestraHead.push({text: 'MES', style: 'tablaHead', alignment: 'center'});
                anchos.push(50);
                anchos.push('*');
                anchos.push(30);
                countIniT += 3;
            }
            var countGen = 0;
            var countGenT = 0;
            $.each(response.listGenerica, function (index1, value1) {
                head += '<th>' + value1.clasificador + ' - ' + value1.descripcion + '</th>';
                countGen++;
                countGenT++;
                muestraHead.push({text: value1.clasificador + ' - ' + value1.descripcion, style: 'tablaHead', alignment: 'center'});
                anchos.push(43);
            });
            head += '<th>Total</th>\
                     </tr>';
            muestraHead.push({text: 'TOTAL', style: 'tablaHead', alignment: 'center'});
            anchos.push(45);
            countGenT += 1;
            var countT = countIniT + countGenT;
            $("#tablaNotas" + value0.codigo + "Head").append(head);
            muestra.push(muestraHead);
            var tipoModifH;
            if (value0.codigo === "00") {
                tipoModifH = response.listTipoRubro00;
            }
            if (value0.codigo === "09") {
                tipoModifH = response.listTipoRubro09;
            }
            if (value0.codigo === "13") {
                tipoModifH = response.listTipoRubro13;
            }
            if (value0.codigo === "18") {
                tipoModifH = response.listTipoRubro18;
            }
            if (value0.codigo === "19") {
                tipoModifH = response.listTipoRubro19;
            }
            var monto0H, monto1H, monto2H, monto3H, monto4H, monto5H, monto6H, monto7H, monto8H, montoH;
            monto0H = monto1H = monto2H = monto3H = monto4H = monto5H = monto6H = monto7H = monto8H = montoH = 0.00;
            $.each(tipoModifH, function (indexTH, valueTH) {
                var muestraBody1 = [];
                var bodyH = "<tr id='trTipoModif_" + value0.codigo + "_" + valueTH.codigo + "' class='subheader'>";
                if (tipo === "00") {
                    bodyH += "<td class='left' colspan='" + (5 + countGen) + "'>TIPO DE MODIFICACION : " + valueTH.codigo + " - " + valueTH.nombre + "</td>\
                              <td style='display: none;'></td>\
                              <td style='display: none;'></td>\
                              <td style='display: none;'></td>";
                    muestraBody1.push({text: 'TIPO DE MODIFICACION : ' + valueTH.codigo + ' - ' + valueTH.nombre, style: 'subHeader', alignment: 'left', colSpan: 5 + countGen});
                    muestraBody1.push("");
                    muestraBody1.push("");
                    muestraBody1.push("");
                }
                if (tipo === "01") {
                    bodyH += "<td class='left' colspan='" + (4 + countGen) + "'>TIPO DE MODIFICACION : " + valueTH.codigo + " - " + valueTH.nombre + "</td>\
                              <td style='display: none;'></td>\
                              <td style='display: none;'></td>";
                    muestraBody1.push({text: 'TIPO DE MODIFICACION : ' + valueTH.codigo + ' - ' + valueTH.nombre, style: 'subHeader', alignment: 'left', colSpan: 4 + countGen});
                    muestraBody1.push("");
                    muestraBody1.push("");
                }
                $.each(response.listGenerica, function (index, value) {
                    bodyH += "<td style='display: none;'></td>";
                    muestraBody1.push("");
                });
                bodyH += "<td style='display: none;'></td>\
                          </tr>";
                $("#tablaNotas" + value0.codigo + "Body").append(bodyH);
                muestraBody1.push("");
                muestra.push(muestraBody1);
                var tipoModifB;
                if (value0.codigo === "00") {
                    if (valueTH.codigo === "001") {
                        tipoModifB = response.listT_00_001;
                    }
                    if (valueTH.codigo === "002") {
                        tipoModifB = response.listT_00_002;
                    }
                    if (valueTH.codigo === "003") {
                        tipoModifB = response.listT_00_003;
                    }
                    if (valueTH.codigo === "004") {
                        tipoModifB = response.listT_00_004;
                    }
                    if (valueTH.codigo === "006") {
                        tipoModifB = response.listT_00_006;
                    }
                    if (valueTH.codigo === "007") {
                        tipoModifB = response.listT_00_007;
                    }
                }
                if (value0.codigo === "09") {
                    if (valueTH.codigo === "001") {
                        tipoModifB = response.listT_09_001;
                    }
                    if (valueTH.codigo === "002") {
                        tipoModifB = response.listT_09_002;
                    }
                    if (valueTH.codigo === "003") {
                        tipoModifB = response.listT_09_003;
                    }
                    if (valueTH.codigo === "004") {
                        tipoModifB = response.listT_09_004;
                    }
                    if (valueTH.codigo === "006") {
                        tipoModifB = response.listT_09_006;
                    }
                    if (valueTH.codigo === "007") {
                        tipoModifB = response.listT_09_007;
                    }
                }
                if (value0.codigo === "13") {
                    if (valueTH.codigo === "001") {
                        tipoModifB = response.listT_13_001;
                    }
                    if (valueTH.codigo === "002") {
                        tipoModifB = response.listT_13_002;
                    }
                    if (valueTH.codigo === "003") {
                        tipoModifB = response.listT_13_003;
                    }
                    if (valueTH.codigo === "004") {
                        tipoModifB = response.listT_13_004;
                    }
                    if (valueTH.codigo === "006") {
                        tipoModifB = response.listT_13_006;
                    }
                    if (valueTH.codigo === "007") {
                        tipoModifB = response.listT_13_007;
                    }
                }
                if (value0.codigo === "18") {
                    if (valueTH.codigo === "001") {
                        tipoModifB = response.listT_18_001;
                    }
                    if (valueTH.codigo === "002") {
                        tipoModifB = response.listT_18_002;
                    }
                    if (valueTH.codigo === "003") {
                        tipoModifB = response.listT_18_003;
                    }
                    if (valueTH.codigo === "004") {
                        tipoModifB = response.listT_18_004;
                    }
                    if (valueTH.codigo === "006") {
                        tipoModifB = response.listT_18_006;
                    }
                    if (valueTH.codigo === "007") {
                        tipoModifB = response.listT_18_007;
                    }
                }
                if (value0.codigo === "19") {
                    if (valueTH.codigo === "001") {
                        tipoModifB = response.listT_19_001;
                    }
                    if (valueTH.codigo === "002") {
                        tipoModifB = response.listT_19_002;
                    }
                    if (valueTH.codigo === "003") {
                        tipoModifB = response.listT_19_003;
                    }
                    if (valueTH.codigo === "004") {
                        tipoModifB = response.listT_19_004;
                    }
                    if (valueTH.codigo === "006") {
                        tipoModifB = response.listT_19_006;
                    }
                    if (valueTH.codigo === "007") {
                        tipoModifB = response.listT_19_007;
                    }
                }
                var bodyB;
                var monto0B, monto1B, monto2B, monto3B, monto4B, monto5B, monto6B, monto7B, monto8B, montoB;
                monto0B = monto1B = monto2B = monto3B = monto4B = monto5B = monto6B = monto7B = monto8B = montoB = 0.00;
                $.each(tipoModifB, function (indexTB, valueTB) {
                    var monto0, monto1, monto2, monto3, monto4, monto5, monto6, monto7, monto8, monto;
                    if (!$.trim(valueTB.monto0)) {
                        monto0 = 0.00;
                    } else {
                        monto0 = valueTB.monto0;
                        monto0B += valueTB.monto0;
                    }
                    if (!$.trim(valueTB.monto1)) {
                        monto1 = 0.00;
                    } else {
                        monto1 = valueTB.monto1;
                        monto1B += valueTB.monto1;
                    }
                    if (!$.trim(valueTB.monto2)) {
                        monto2 = 0.00;
                    } else {
                        monto2 = valueTB.monto2;
                        monto2B += valueTB.monto2;
                    }
                    if (!$.trim(valueTB.monto3)) {
                        monto3 = 0.00;
                    } else {
                        monto3 = valueTB.monto3;
                        monto3B += valueTB.monto3;
                    }
                    if (!$.trim(valueTB.monto4)) {
                        monto4 = 0.00;
                    } else {
                        monto4 = valueTB.monto4;
                        monto4B += valueTB.monto4;
                    }
                    if (!$.trim(valueTB.monto5)) {
                        monto5 = 0.00;
                    } else {
                        monto5 = valueTB.monto5;
                        monto5B += valueTB.monto5;
                    }
                    if (!$.trim(valueTB.monto6)) {
                        monto6 = 0.00;
                    } else {
                        monto6 = valueTB.monto6;
                        monto6B += valueTB.monto6;
                    }
                    if (!$.trim(valueTB.monto7)) {
                        monto7 = 0.00;
                    } else {
                        monto7 = valueTB.monto7;
                        monto7B += valueTB.monto7;
                    }
                    if (!$.trim(valueTB.monto8)) {
                        monto8 = 0.00;
                    } else {
                        monto8 = valueTB.monto8;
                        monto8B += valueTB.monto8;
                    }
                    if (!$.trim(valueTB.monto)) {
                        monto = 0.00;
                    } else {
                        monto = valueTB.monto;
                        montoB += valueTB.monto;
                    }
                    var muestraBody2 = [];
                    bodyB += "<tr>";
                    if (tipo === "00") {
                        var docu = valueTB.nombre_documento.split(" (");
                        bodyB += "<td class='left'>" + docu[0] + "</td>\
                                <td class='left'>" + valueTB.num_doc + "</td>\
                                <td class='left'>" + valueTB.nombre_mes + "</td>\
                                <td class='left'>" + valueTB.fecha_doc + "</td>";
                        muestraBody2.push({text: docu[0], style: 'tablaBody', alignment: 'left'});
                        muestraBody2.push({text: valueTB.num_doc, style: 'tablaBody', alignment: 'left'});
                        muestraBody2.push({text: valueTB.nombre_mes, style: 'tablaBody', alignment: 'left'});
                        muestraBody2.push({text: valueTB.fecha_doc, style: 'tablaBody', alignment: 'left'});
                    }
                    if (tipo === "01") {
                        var nombre_ejec = valueTB.nombre.split("-");
                        var ejecutora = "UE " + valueTB.ejecutora + " - " + nombre_ejec[1].trim() + " (" + valueTB.sec_ejec + ")";
                        bodyB += "<td class='left'>" + valueTB.sec_nota + "</td>\
                                  <td class='left'>" + ejecutora + "</td>\
                                  <td class='left'>" + valueTB.nombre_mes + "</td>";
                        muestraBody2.push({text: valueTB.sec_nota, style: 'tablaBody', alignment: 'left'});
                        muestraBody2.push({text: ejecutora, style: 'tablaBody', alignment: 'left'});
                        muestraBody2.push({text: valueTB.nombre_mes, style: 'tablaBody', alignment: 'left'});
                    }
                    bodyB += "<td class='right'>" + formatNumero(monto0) + "</td>\
                              <td class='right'>" + formatNumero(monto1) + "</td>\
                              <td class='right'>" + formatNumero(monto2) + "</td>\
                              <td class='right'>" + formatNumero(monto3) + "</td>\
                              <td class='right'>" + formatNumero(monto4) + "</td>\
                              <td class='right'>" + formatNumero(monto5) + "</td>\
                              <td class='right'>" + formatNumero(monto6) + "</td>\
                              <td class='right'>" + formatNumero(monto7) + "</td>\
                              <td class='right'>" + formatNumero(monto8) + "</td>\
                              <td class='right'>" + formatNumero(monto) + "</td>\
                              </tr>";
                    muestraBody2.push({text: formatNumero(monto0), style: 'tablaBody', alignment: 'right'});
                    muestraBody2.push({text: formatNumero(monto1), style: 'tablaBody', alignment: 'right'});
                    muestraBody2.push({text: formatNumero(monto2), style: 'tablaBody', alignment: 'right'});
                    muestraBody2.push({text: formatNumero(monto3), style: 'tablaBody', alignment: 'right'});
                    muestraBody2.push({text: formatNumero(monto4), style: 'tablaBody', alignment: 'right'});
                    muestraBody2.push({text: formatNumero(monto5), style: 'tablaBody', alignment: 'right'});
                    muestraBody2.push({text: formatNumero(monto6), style: 'tablaBody', alignment: 'right'});
                    muestraBody2.push({text: formatNumero(monto7), style: 'tablaBody', alignment: 'right'});
                    muestraBody2.push({text: formatNumero(monto8), style: 'tablaBody', alignment: 'right'});
                    muestraBody2.push({text: formatNumero(monto), style: 'tablaBody', alignment: 'right'});
                    muestra.push(muestraBody2);
                });
                var muestraBody3 = [];
                bodyB += "<tr class='subfooter'>";
                if (tipo === "00") {
                    bodyB += "<td class='left' colspan='4'>SUBTOTAL TIPO " + valueTH.codigo + "</td>\
                              <td style='display: none;'></td>\
                              <td style='display: none;'></td>\
                              <td style='display: none;'></td>";
                    muestraBody3.push({text: 'SUBTOTAL TIPO ' + valueTH.codigo, style: 'subFooter', alignment: 'center', colSpan: 4});
                    muestraBody3.push("");
                    muestraBody3.push("");
                    muestraBody3.push("");
                }
                if (tipo === "01") {
                    bodyB += "<td class='left' colspan='3'>SUBTOTAL TIPO " + valueTH.codigo + "</td>\
                              <td style='display: none;'></td>\
                              <td style='display: none;'></td>";
                    muestraBody3.push({text: 'SUBTOTAL TIPO ' + valueTH.codigo, style: 'subFooter', alignment: 'center', colSpan: 3});
                    muestraBody3.push("");
                    muestraBody3.push("");
                }
                bodyB += "<td class='right'>" + formatNumero(monto0B) + "</td>\
                          <td class='right'>" + formatNumero(monto1B) + "</td>\
                          <td class='right'>" + formatNumero(monto2B) + "</td>\
                          <td class='right'>" + formatNumero(monto3B) + "</td>\
                          <td class='right'>" + formatNumero(monto4B) + "</td>\
                          <td class='right'>" + formatNumero(monto5B) + "</td>\
                          <td class='right'>" + formatNumero(monto6B) + "</td>\
                          <td class='right'>" + formatNumero(monto7B) + "</td>\
                          <td class='right'>" + formatNumero(monto8B) + "</td>\
                          <td class='right'>" + formatNumero(montoB) + "</td>\
                          </tr>";
                $("#trTipoModif_" + value0.codigo + "_" + valueTH.codigo).after(bodyB);
                muestraBody3.push({text: formatNumero(monto0B), style: 'subFooter', alignment: 'right'});
                muestraBody3.push({text: formatNumero(monto1B), style: 'subFooter', alignment: 'right'});
                muestraBody3.push({text: formatNumero(monto2B), style: 'subFooter', alignment: 'right'});
                muestraBody3.push({text: formatNumero(monto3B), style: 'subFooter', alignment: 'right'});
                muestraBody3.push({text: formatNumero(monto4B), style: 'subFooter', alignment: 'right'});
                muestraBody3.push({text: formatNumero(monto5B), style: 'subFooter', alignment: 'right'});
                muestraBody3.push({text: formatNumero(monto6B), style: 'subFooter', alignment: 'right'});
                muestraBody3.push({text: formatNumero(monto7B), style: 'subFooter', alignment: 'right'});
                muestraBody3.push({text: formatNumero(monto8B), style: 'subFooter', alignment: 'right'});
                muestraBody3.push({text: formatNumero(montoB), style: 'subFooter', alignment: 'right'});
                muestra.push(muestraBody3);
                monto0H += monto0B;
                monto1H += monto1B;
                monto2H += monto2B;
                monto3H += monto3B;
                monto4H += monto4B;
                monto5H += monto5B;
                monto6H += monto6B;
                monto7H += monto7B;
                monto8H += monto8B;
                montoH += montoB;
            });
            var muestraFoot = [];
            var foot = "<tr class='total'>";
            if (tipo === "00") {
                foot += "<td colspan='4' class='center'><b>TOTAL DE MODIFICACIONES</b></td>";
                muestraFoot.push({text: 'TOTAL DE MODIFICACIONES', style: 'tablaTotal', alignment: 'center', colSpan: 4});
                muestraFoot.push("");
                muestraFoot.push("");
                muestraFoot.push("");
            }
            if (tipo === "01") {
                foot += "<td colspan='3' class='center'><b>TOTAL DE MODIFICACIONES</b></td>";
                muestraFoot.push({text: 'TOTAL DE MODIFICACIONES', style: 'tablaTotal', alignment: 'center', colSpan: 3});
                muestraFoot.push("");
                muestraFoot.push("");
            }
            foot += "<td class='right'><b>" + formatNumero(monto0H) + "</b></td>\
                     <td class='right'><b>" + formatNumero(monto1H) + "</b></td>\
                     <td class='right'><b>" + formatNumero(monto2H) + "</b></td>\
                     <td class='right'><b>" + formatNumero(monto3H) + "</b></td>\
                     <td class='right'><b>" + formatNumero(monto4H) + "</b></td>\
                     <td class='right'><b>" + formatNumero(monto5H) + "</b></td>\
                     <td class='right'><b>" + formatNumero(monto6H) + "</b></td>\
                     <td class='right'><b>" + formatNumero(monto7H) + "</b></td>\
                     <td class='right'><b>" + formatNumero(monto8H) + "</b></td>\
                     <td class='right'><b>" + formatNumero(montoH) + "</b></td>\
                     </tr>";
            $("#tablaNotas" + value0.codigo + "Foot").append(foot);
            muestraFoot.push({text: formatNumero(monto0H), style: 'tablaTotal', alignment: 'right'});
            muestraFoot.push({text: formatNumero(monto1H), style: 'tablaTotal', alignment: 'right'});
            muestraFoot.push({text: formatNumero(monto2H), style: 'tablaTotal', alignment: 'right'});
            muestraFoot.push({text: formatNumero(monto3H), style: 'tablaTotal', alignment: 'right'});
            muestraFoot.push({text: formatNumero(monto4H), style: 'tablaTotal', alignment: 'right'});
            muestraFoot.push({text: formatNumero(monto5H), style: 'tablaTotal', alignment: 'right'});
            muestraFoot.push({text: formatNumero(monto6H), style: 'tablaTotal', alignment: 'right'});
            muestraFoot.push({text: formatNumero(monto7H), style: 'tablaTotal', alignment: 'right'});
            muestraFoot.push({text: formatNumero(monto8H), style: 'tablaTotal', alignment: 'right'});
            muestraFoot.push({text: formatNumero(montoH), style: 'tablaTotal', alignment: 'right'});
            muestra.push(muestraFoot);
            $('#tablaNotas' + value0.codigo).dataTable({
                ordering: false,
                paging: false,
                dom: '<"centrar-div-tabla"lB>rt',
                buttons: [
                    {
                        extend: 'excel',
                        footer: true,
                        filename: 'resumen_modificaciones_presupuestales_' + response.ciclo + '_' + titu_file + '_rubro_' + value0.codigo + '_' + response.año,
                        title: 'RESUMEN DE MODIFICACIONES PRESUPUESTALES DE ' + (response.ciclo).toUpperCase() + ' ' + titu_doc + ' - ' + response.meses + " - " + response.año,
                        messageTop: response.titulo,
                        headTop1: 'RUBRO DE FINANCIAMIENTO : ' + value0.codigo + ' - ' + value0.nombre,
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
            documentos_nota.push(
                    {
                        text: '\nRUBRO DE FINANCIAMIENTO : ' + value0.codigo + ' - ' + value0.nombre, alignment: 'left', style: 'subtitulo'
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
                    },
                    {
                        text: '\n'
                    }
            );
        });
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
        $("#aExportNotaR").on('click', function () {
            var docDefinition = {
                pageOrientation: 'landscape',
                info: {
                    title: 'resumen_modificaciones_presupuestales_' + response.ciclo + '_' + titu_file + '_' + response.año
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
                                    {text: 'RESUMEN DE MODIFICACIONES PRESUPUESTALES DE ' + (response.ciclo).toUpperCase() + ' ' + titu_doc + '\n'
                                                + response.meses + ' - ' + response.año + '\n' + response.titulo + '\n', alignment: 'center', style: 'titulo'}
                                ]
                            ]
                        },
                        layout: {
                            hLineColor: 'white',
                            vLineColor: 'white'
                        }
                    },
                    documentos_nota
                ],
                styles: {
                    titulo: {
                        fontSize: 7,
                        bold: true
                    },
                    subtitulo: {
                        fontSize: 7
                    },
                    tablaHead: {
                        color: 'white',
                        fillColor: '#426993',
                        fontSize: 5,
                        bold: true
                    },
                    tablaBody: {
                        fontSize: 5
                    },
                    subHeader: {
                        color: 'white',
                        fillColor: '#587BA0',
                        fontSize: 5,
                        bold: true
                    },
                    subFooter: {
                        fillColor: '#D2DBE5',
                        fontSize: 5
                    },
                    tablaTotal: {
                        fillColor: '#F6F6F6',
                        fontSize: 5,
                        bold: true
                    },
                    pie: {
                        fontSize: 5
                    }
                }
            };
            pdfMake.createPdf(docDefinition).open();
        });
    }

    if (tipo === "02") {
        var cuerpo = '<div style="margin-bottom: 15px;">\
                        <table id="tablaPresu" class="display" cellspacing="0" width="100%">\
                            <thead id="tablaPresuHead"></thead>\
                            <tbody id="tablaPresuBody"></tbody>\
                        </table>\
                      </div>\
                      <div id="divDetalleNota"></div>';
        $("#divPresuTabla").append(cuerpo);
        var head = "<tr>\
                        <th>Nota</th>\
                        <th>Fecha</th>\
                        <th>Tipo</th>\
                        <th>Rubro</th>\
                        <th>Documento</th>\
                        <th>Justificación</th>\
                    </tr>";
        $("#tablaPresuHead").append(head);
        var anio = $('#listNotasAño').val();
        var mes1 = $('#listPresuMesDesde option:selected').text();
        var mes2 = $('#listPresuMesHasta option:selected').text();
        var estado = $('#listNotasEstado option:selected').text();
        $.each(response.list, function (index, value) {
            var parts = (value.nombre_documento).split("(");
            var body = "<tr>\
                            <td class='center'>\
                                <a id='a_" + value.sec_nota + "' class='td_proyecto'>" + value.sec_nota + "</a>\
                            </td>\
                            <td class='center'>" + value.fecha_doc + "</td>\
                            <td class='center'>" + value.codigo + "</td>\
                            <td class='center'>" + value.fuente_financ + "</td>\
                            <td class='left'>" + parts[0].trim() + " Nº " + value.num_doc + "</td>\
                            <td class='left'>" + value.glosa + "</td>\
                         </tr>";
            $("#tablaPresuBody").append(body);
            $("#a_" + value.sec_nota).click(function () {
                llenarNotaDetalle05(
                        response.año,
                        response.ejec,
                        value.sec_nota,
                        value.nombre_mes,
                        value.fecha_doc,
                        estado,
                        value.codigo,
                        value.nombre,
                        parts[0].trim(),
                        value.num_doc,
                        value.cod_doc,
                        value.glosa,
                        response.titulo
                        );
            });
        });
        $('#tablaPresu').dataTable({
            ordering: true,
            dom: '<"centrar-div-tabla"lB>iprtip',
            buttons: [
                {
                    extend: 'excel',
                    filename: 'resumen_notas_modificatorias_' + anio + '_de_' + mes1 + '_a_' + mes2,
                    title: 'RESUMEN DE NOTAS MODIFICATORIAS - ' + anio,
                    messageTop: 'Desde ' + mes1 + ' Hasta ' + mes2,
                    exportOptions: {
                        orthogonal: 'sort',
                        columns: ':visible'
                    }
                }
            ]
        });
    }

}

function llenarNotaDetalle05(año, ejec, nota, mes, fecha, estado, tipo, modif, documento, num_doc, cod_doc, glosa, titulo) {
    $("#divDetalleNota").empty();
    var detalle_nota = [];
    var muestraG = [];
    var general = '<div class="btn-proy-busqueda">\
                           <a id="aExportNota">\
                              <img src="./templates/plugins/datatables/images/pdf.png" alt="Exportar a PDF" title="Exportar a PDF">\
                           </a>\
                        </div>\
                        <div class="margen-reportes-presu">\
                         <div class="titulo_reportes">\
                           <label>NOTA ' + nota + '</label>\
                         </div>\
                         <br>\
                         <div class="form-group row">\
                           <label class="col-sm-2 col-form-label ficha-sombreado1">MES :</label>\
                           <label class="col-sm-2 col-form-label ficha-sombreado2">' + mes + '</label>\
                           <label class="col-sm-1"></label>\
                           <label class="col-sm-1 col-form-label ficha-sombreado1">FECHA :</label>\
                           <label class="col-sm-2 col-form-label ficha-sombreado2">' + fecha + '</label>\
                           <label class="col-sm-1"></label>\
                           <label class="col-sm-1 col-form-label ficha-sombreado1">ESTADO :</label>\
                           <label class="col-sm-2 col-form-label ficha-sombreado2">' + estado + '</label>\
                         </div>\
                         <div class="form-group row">\
                           <label class="col-sm-2 col-form-label ficha-sombreado1">TIPO DE MODIFICACION :</label>\
                           <label class="col-sm-10 col-form-label ficha-sombreado2">' + tipo + ' - ' + modif + '</label>\
                         </div>\
                         <div class="form-group row">\
                           <label class="col-sm-2 col-form-label ficha-sombreado1">DOCUMENTO :</label>\
                           <label class="col-sm-10 col-form-label ficha-sombreado2">' + documento + ' Nº ' + num_doc + '</label>\
                         </div>\
                         <div class="form-group row">\
                           <label class="col-sm-2 col-form-label ficha-sombreado1">JUSTIFICACIÓN :</label>\
                           <label class="col-sm-10 col-form-label ficha-sombreado2">' + glosa + '</label>\
                         </div>\
                       </div>';
    $("#divDetalleNota").append(general);
    var tablaG = '<div style="margin-top: 15px;">\
                        <label>DETALLE DEL GASTO</label>\
                        <br>\
                        <table id="tablaNotasDetG" class="display" cellspacing="0" width="100%">\
                            <thead id="tablaNotasDetGHead"></thead>\
                            <tbody id="tablaNotasDetGBody"></tbody>\
                            <tfoot id="tablaNotasDetGFoot"></tfoot>\
                        </table>\
                        <br>\
                      </div>';
    $("#divDetalleNota").append(tablaG);
    var muestraHeadG = [];
    var headG = '<tr>\
                         <th>Meta</th>\
                         <th>Nombre Meta</th>\
                         <th>Rubro</th>\
                         <th>Nombre Rubro</th>\
                         <th>Especifica</th>\
                         <th>Nombre Específica</th>\
                         <th>Anulación</th>\
                         <th>Crédito</th>\
                      </tr>';
    $("#tablaNotasDetGHead").append(headG);
    muestraHeadG.push({text: 'META', style: 'tablaHead', alignment: 'center'});
    muestraHeadG.push({text: 'NOMBRE META', style: 'tablaHead', alignment: 'center'});
    muestraHeadG.push({text: 'RUBRO', style: 'tablaHead', alignment: 'center'});
    muestraHeadG.push({text: 'NOMBRE DE RUBRO', style: 'tablaHead', alignment: 'center'});
    muestraHeadG.push({text: 'ESPECÍFICA', style: 'tablaHead', alignment: 'center'});
    muestraHeadG.push({text: 'NOMBRE ESPECÍFICA', style: 'tablaHead', alignment: 'center'});
    muestraHeadG.push({text: 'ANULACIÓN', style: 'tablaHead', alignment: 'center'});
    muestraHeadG.push({text: 'CRÉDITO', style: 'tablaHead', alignment: 'center'});
    muestraG.push(muestraHeadG);

    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataNotaDetalle&ejec=" + ejec + "&año=" + año + "&nota=" + nota + "&num_doc=" + num_doc + "&cod_doc=" + cod_doc,
        success: function (response) {
            var anulaGT = 0.00;
            var crediGT = 0.00;
            $.each(response.listG, function (indexG, valueG) {
                var anulaG, crediG;
                if (valueG.monto0 === 0.00) {
                    anulaG = "";
                } else {
                    anulaG = formatNumero(valueG.monto0);
                }
                anulaGT += valueG.monto0;
                if (valueG.monto1 === 0.00) {
                    crediG = "";
                } else {
                    crediG = formatNumero(valueG.monto1);
                }
                crediGT += valueG.monto1;
                var muestraBodyG = [];
                var bodyG = '<tr>\
                            <td class="left">' + valueG.sec_func + '</td>\
                            <td class="left">' + valueG.nombre_sec_func + '</td>\
                            <td class="left">' + valueG.fuente_financ + '</td>\
                            <td class="left">' + valueG.nombre_fuente_financ + '</td>\
                            <td class="left">' + valueG.clasificador + '</td>\
                            <td class="left">' + valueG.descripcion + '</td>\
                            <td class="right">' + anulaG + '</td>\
                            <td class="right">' + crediG + '</td>\
                         </tr>';
                $("#tablaNotasDetGBody").append(bodyG);
                muestraBodyG.push({text: valueG.sec_func, style: 'tablaBody', alignment: 'left'});
                muestraBodyG.push({text: valueG.nombre_sec_func, style: 'tablaBody', alignment: 'left'});
                muestraBodyG.push({text: valueG.fuente_financ, style: 'tablaBody', alignment: 'left'});
                muestraBodyG.push({text: valueG.nombre_fuente_financ, style: 'tablaBody', alignment: 'left'});
                muestraBodyG.push({text: valueG.clasificador, style: 'tablaBody', alignment: 'left'});
                muestraBodyG.push({text: valueG.descripcion, style: 'tablaBody', alignment: 'left'});
                muestraBodyG.push({text: anulaG, style: 'tablaBody', alignment: 'right'});
                muestraBodyG.push({text: crediG, style: 'tablaBody', alignment: 'right'});
                muestraG.push(muestraBodyG);
            });
            var anulaGTT, crediGTT;
            if (anulaGT === 0.00) {
                anulaGTT = "";
            } else {
                anulaGTT = formatNumero(anulaGT);
            }
            if (crediGT === 0.00) {
                crediGTT = "";
            } else {
                crediGTT = formatNumero(crediGT);
            }
            var muestraFootG = [];
            var footG = '<tr class="total">\
                        <td colspan="6" class="right"><b>TOTAL : </b></td>\
                        <td class="right"><b>' + anulaGTT + '</b></td>\
                        <td class="right"><b>' + crediGTT + '</b></td>\
                     </tr>';
            $("#tablaNotasDetGFoot").append(footG);
            muestraFootG.push({text: 'TOTAL : ', style: 'tablaTotal', alignment: 'right', colSpan: 6});
            muestraFootG.push("");
            muestraFootG.push("");
            muestraFootG.push("");
            muestraFootG.push("");
            muestraFootG.push("");
            muestraFootG.push({text: anulaGTT, style: 'tablaTotal', alignment: 'right'});
            muestraFootG.push({text: crediGTT, style: 'tablaTotal', alignment: 'right'});
            muestraG.push(muestraFootG);
            $('#tablaNotasDetG').dataTable({
                ordering: false,
                paging: false,
                dom: 'rt'
            });
            detalle_nota.push(
                    {
                        text: 'DETALLE DEL GASTO', alignment: 'center', style: 'titulo'
                    },
                    {text: '\n'},
                    {
                        table: {
                            widths: [15, '*', 100, 65, 33, '*', 35, 35],
                            body: muestraG
                        },
                        layout: {
                            hLineColor: 'black',
                            vLineColor: 'black'
                        }
                    }
            );
            if (response.ingreso) {
                var muestraI = [];
                var tablaI = '<div style="margin-top: 15px;">\
                            <label>DETALLE DEL INGRESO</label>\
                            <br>\
                            <table id="tablaNotasDetI" class="display" cellspacing="0" width="100%">\
                                <thead id="tablaNotasDetIHead"></thead>\
                                <tbody id="tablaNotasDetIBody"></tbody>\
                                <tfoot id="tablaNotasDetIFoot"></tfoot>\
                            </table>\
                            <br>\
                          </div>';
                $("#divDetalleNota").append(tablaI);
                var muestraHeadI = [];
                var headI = '<tr>\
                            <th>Rubro de Financiamiento</th>\
                            <th>Categoría de Ingreso</th>\
                            <th>Especifica</th>\
                            <th>Nombre Específica</th>\
                            <th>Anulación</th>\
                            <th>Crédito</th>\
                         </tr>';
                $("#tablaNotasDetIHead").append(headI);
                muestraHeadI.push({text: 'RUBRO DE FINANCIAMIENTO', style: 'tablaHead', alignment: 'center'});
                muestraHeadI.push({text: 'CATEGORÍA DE INGRESO', style: 'tablaHead', alignment: 'center'});
                muestraHeadI.push({text: 'ESPECÍFICA', style: 'tablaHead', alignment: 'center'});
                muestraHeadI.push({text: 'NOMBRE ESPECÍFICA', style: 'tablaHead', alignment: 'center'});
                muestraHeadI.push({text: 'ANULACIÓN', style: 'tablaHead', alignment: 'center'});
                muestraHeadI.push({text: 'CRÉDITO', style: 'tablaHead', alignment: 'center'});
                muestraI.push(muestraHeadI);
                var anulaIT = 0.00;
                var crediIT = 0.00;
                $.each(response.listI, function (indexI, valueI) {
                    var anulaI, crediI;
                    if (valueI.monto0 === 0.00) {
                        anulaI = "";
                    } else {
                        anulaI = formatNumero(valueI.monto0);
                    }
                    anulaIT += valueI.monto0;
                    if (valueI.monto1 === 0.00) {
                        crediI = "";
                    } else {
                        crediI = formatNumero(valueI.monto1);
                    }
                    crediIT += valueI.monto1;
                    var muestraBodyI = [];
                    var bodyI = '<tr>\
                                <td class="left">' + valueI.fuente_financ + ' - ' + valueI.nombre_fuente_financ + '</td>\
                                <td class="left">' + valueI.categoria_ingreso + ' - ' + valueI.nombre_categoria_ingreso + '</td>\
                                <td class="left">' + valueI.clasificador + '</td>\
                                <td class="left">' + valueI.descripcion + '</td>\
                                <td class="right">' + anulaI + '</td>\
                                <td class="right">' + crediI + '</td>\
                             </tr>';
                    $("#tablaNotasDetIBody").append(bodyI);
                    muestraBodyI.push({text: valueI.fuente_financ + ' - ' + valueI.nombre_fuente_financ, style: 'tablaBody', alignment: 'left'});
                    muestraBodyI.push({text: valueI.categoria_ingreso + ' - ' + valueI.nombre_categoria_ingreso, style: 'tablaBody', alignment: 'left'});
                    muestraBodyI.push({text: valueI.clasificador, style: 'tablaBody', alignment: 'left'});
                    muestraBodyI.push({text: valueI.descripcion, style: 'tablaBody', alignment: 'left'});
                    muestraBodyI.push({text: anulaI, style: 'tablaBody', alignment: 'right'});
                    muestraBodyI.push({text: crediI, style: 'tablaBody', alignment: 'right'});
                    muestraI.push(muestraBodyI);
                });
                var anulaITT, crediITT;
                if (anulaIT === 0.00) {
                    anulaITT = "";
                } else {
                    anulaITT = formatNumero(anulaIT);
                }
                if (crediIT === 0.00) {
                    crediITT = "";
                } else {
                    crediITT = formatNumero(crediIT);
                }
                var muestraFootI = [];
                var footI = '<tr class="total">\
                            <td colspan="4" class="right"><b>TOTAL : </b></td>\
                            <td class="right"><b>' + anulaITT + '</b></td>\
                            <td class="right"><b>' + crediITT + '</b></td>\
                         </tr>';
                $("#tablaNotasDetIFoot").append(footI);
                muestraFootI.push({text: 'TOTAL : ', style: 'tablaTotal', alignment: 'right', colSpan: 4});
                muestraFootI.push("");
                muestraFootI.push("");
                muestraFootI.push("");
                muestraFootI.push({text: anulaITT, style: 'tablaTotal', alignment: 'right'});
                muestraFootI.push({text: crediITT, style: 'tablaTotal', alignment: 'right'});
                muestraI.push(muestraFootI);
                $('#tablaNotasDetI').dataTable({
                    ordering: false,
                    paging: false,
                    dom: 'rt'
                });
                detalle_nota.push(
                        {text: '\n'},
                        {
                            text: 'DETALLE DEL INGRESO', alignment: 'center', style: 'titulo'
                        },
                        {text: '\n'},
                        {
                            table: {
                                widths: ['*', '*', 33, '*', 35, 35],
                                body: muestraI
                            },
                            layout: {
                                hLineColor: 'black',
                                vLineColor: 'black'
                            }
                        }
                );
            }
            if (response.connumero) {
                var muestraUE = [];
                var tablaUE = '<div style="margin-top: 15px;">\
                                <label>DETALLE DE NOTAS MODIFICATORIAS RELACIONADAS CON LA ' + documento + ' Nº ' + num_doc + '</label>\
                                <br>\
                                <table id="tablaNotasDetUE" class="display" cellspacing="0" width="80%">\
                                    <thead id="tablaNotasDetUEHead"></thead>\
                                    <tbody id="tablaNotasDetUEBody"></tbody>\
                                    <tfoot id="tablaNotasDetUEFoot"></tfoot>\
                                </table>\
                                <br>\
                              </div>';
                $("#divDetalleNota").append(tablaUE);
                var muestraHeadUE = [];
                var headUE = '<tr>\
                            <th>Unidad Ejecutora</th>\
                            <th>Numero de Nota</th>\
                            <th>Anulación</th>\
                            <th>Crédito</th>\
                         </tr>';
                $("#tablaNotasDetUEHead").append(headUE);
                muestraHeadUE.push({text: '', border: [false, false, false, false]});
                muestraHeadUE.push({text: 'UNIDAD EJECUTORA', style: 'tablaHead', alignment: 'center'});
                muestraHeadUE.push({text: 'NÚMERO DE NOTA', style: 'tablaHead', alignment: 'center'});
                muestraHeadUE.push({text: 'ANULACIÓN', style: 'tablaHead', alignment: 'center'});
                muestraHeadUE.push({text: 'CRÉDITO', style: 'tablaHead', alignment: 'center'});
                muestraHeadUE.push({text: '', border: [false, false, false, false]});
                muestraUE.push(muestraHeadUE);
                var anulaUET = 0.00;
                var crediUET = 0.00;
                $.each(response.listUE, function (indexUE, valueUE) {
                    var anulaUE, crediUE;
                    if (valueUE.monto0 === 0.00) {
                        anulaUE = "";
                    } else {
                        anulaUE = formatNumero(valueUE.monto0);
                    }
                    anulaUET += valueUE.monto0;
                    if (valueUE.monto1 === 0.00) {
                        crediUE = "";
                    } else {
                        crediUE = formatNumero(valueUE.monto1);
                    }
                    crediUET += valueUE.monto1;
                    var muestraBodyUE = [];
                    var nombre_ejec = valueUE.nombre.split("-");
                    var bodyUE = '<tr>\
                                <td class="left">UE ' + valueUE.ejecutora + ' - ' + nombre_ejec[1].trim() + ' (' + valueUE.sec_ejec + ')</td>\
                                <td class="center">' + valueUE.sec_nota + '</td>\
                                <td class="right">' + anulaUE + '</td>\
                                <td class="right">' + crediUE + '</td>\
                              </tr>';
                    $("#tablaNotasDetUEBody").append(bodyUE);
                    muestraBodyUE.push({text: '', border: [false, false, false, false]});
                    muestraBodyUE.push({text: 'UE ' + valueUE.ejecutora + ' - ' + nombre_ejec[1].trim() + ' (' + valueUE.sec_ejec + ')', style: 'tablaBody', alignment: 'left'});
                    muestraBodyUE.push({text: valueUE.sec_nota, style: 'tablaBody', alignment: 'center'});
                    muestraBodyUE.push({text: anulaUE, style: 'tablaBody', alignment: 'right'});
                    muestraBodyUE.push({text: crediUE, style: 'tablaBody', alignment: 'right'});
                    muestraBodyUE.push({text: '', border: [false, false, false, false]});
                    muestraUE.push(muestraBodyUE);
                });
                var anulaUETT, crediUETT;
                if (anulaUET === 0.00) {
                    anulaUETT = "";
                } else {
                    anulaUETT = formatNumero(anulaUET);
                }
                if (crediUET === 0.00) {
                    crediUETT = "";
                } else {
                    crediUETT = formatNumero(crediUET);
                }
                var muestraFootUE = [];
                var footUE = '<tr class="total">\
                            <td colspan="2" class="right"><b>TOTAL : </b></td>\
                            <td class="right"><b>' + anulaUETT + '</b></td>\
                            <td class="right"><b>' + crediUETT + '</b></td>\
                          </tr>';
                $("#tablaNotasDetUEFoot").append(footUE);
                muestraFootUE.push({text: '', border: [false, false, false, false]});
                muestraFootUE.push({text: 'TOTAL : ', style: 'tablaTotal', alignment: 'right', colSpan: 2});
                muestraFootUE.push("");
                muestraFootUE.push({text: anulaUETT, style: 'tablaTotal', alignment: 'right'});
                muestraFootUE.push({text: crediUETT, style: 'tablaTotal', alignment: 'right'});
                muestraFootUE.push({text: '', border: [false, false, false, false]});
                muestraUE.push(muestraFootUE);
                $('#tablaNotasDetUE').dataTable({
                    ordering: false,
                    paging: false,
                    dom: 'rt'
                });
                detalle_nota.push(
                        {text: '\n'},
                        {
                            text: 'DETALLE DE NOTAS MODIFICATORIAS RELACIONADAS CON LA ' + documento + ' Nº ' + num_doc, alignment: 'center', style: 'titulo'
                        },
                        {text: '\n'},
                        {
                            table: {
                                widths: [80, '*', 80, 50, 50, 80],
                                body: muestraUE
                            },
                            layout: {
                                hLineColor: 'black',
                                vLineColor: 'black'
                            }
                        }
                );
            }
        }
    });

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
    $("#aExportNota").on('click', function () {
        var docDefinition = {
            info: {
                title: 'nota_modificatoria_detallada_' + nota + '_' + ejec + '_' + año
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
                                {text: 'NOTA MODIFICATORIA DETALLADA - ' + año + '\n' + titulo, alignment: 'center', style: 'titulo'}
                            ]
                        ]
                    },
                    layout: {
                        hLineColor: 'white',
                        vLineColor: 'white'
                    }
                },
                {text: '\n'},
                {
                    table: {
                        widths: ['*'],
                        body: [
                            [
                                {text: 'NOTA ' + nota, alignment: 'center', style: 'tituloU'}
                            ]
                        ]
                    },
                    layout: {
                        hLineColor: 'white',
                        vLineColor: 'white'
                    }
                },
                {text: '\n'},
                {
                    table: {
                        widths: [80, 60, '*', 60, 60, '*', 60, 60],
                        body: [
                            [
                                {text: 'MES :', alignment: 'left', style: 'sombreado1'},
                                {text: mes, alignment: 'left', style: 'sombreado2'},
                                "",
                                {text: 'FECHA :', alignment: 'left', style: 'sombreado1'},
                                {text: fecha, alignment: 'left', style: 'sombreado2'},
                                "",
                                {text: 'ESTADO :', alignment: 'left', style: 'sombreado1'},
                                {text: estado, alignment: 'left', style: 'sombreado2'}
                            ]
                        ]
                    },
                    layout: {
                        hLineColor: 'white',
                        vLineColor: 'white'
                    }
                },
                {
                    table: {
                        widths: [80, '*'],
                        body: [
                            [
                                {text: 'TIPO DE MODIFICACION :', alignment: 'left', style: 'sombreado1'},
                                {text: tipo + ' - ' + modif, alignment: 'left', style: 'sombreado2'}
                            ]
                        ]
                    },
                    layout: {
                        hLineColor: 'white',
                        vLineColor: 'white'
                    }
                },
                {
                    table: {
                        widths: [80, '*'],
                        body: [
                            [
                                {text: 'DOCUMENTO :', alignment: 'left', style: 'sombreado1'},
                                {text: documento + ' Nº ' + num_doc, alignment: 'left', style: 'sombreado2'}
                            ]
                        ]
                    },
                    layout: {
                        hLineColor: 'white',
                        vLineColor: 'white'
                    }
                },
                {
                    table: {
                        widths: [80, '*'],
                        body: [
                            [
                                {text: 'JUSTIFICACIÓN :', alignment: 'left', style: 'sombreado1'},
                                {text: glosa, alignment: 'left', style: 'sombreado2'}
                            ]
                        ]
                    },
                    layout: {
                        hLineColor: 'white',
                        vLineColor: 'white'
                    }
                },
                {text: '\n'},
                detalle_nota
            ],
            styles: {
                titulo: {
                    fontSize: 7,
                    bold: true
                },
                sombreado1: {
                    fillColor: '#334A74',
                    color: 'whitesmoke',
                    fontSize: 6,
                    bold: false
                },
                sombreado2: {
                    fillColor: 'whitesmoke',
                    color: '#334A74',
                    fontSize: 6,
                    bold: false
                },
                tituloU: {
                    fontSize: 7,
                    bold: true,
                    color: '#334A74',
                    decoration: 'underline'
                },
                subtitulo: {
                    fontSize: 7
                },
                tablaHead: {
                    color: 'white',
                    fillColor: '#426993',
                    fontSize: 5,
                    bold: true
                },
                tablaBody: {
                    fontSize: 5
                },
                subHeader: {
                    color: 'white',
                    fillColor: '#587BA0',
                    fontSize: 5,
                    bold: true
                },
                subFooter: {
                    fillColor: '#D2DBE5',
                    fontSize: 5
                },
                tablaTotal: {
                    fillColor: '#F6F6F6',
                    fontSize: 5,
                    bold: true
                },
                pie: {
                    fontSize: 5
                }
            }
        };
        pdfMake.createPdf(docDefinition).open();
    });
}

