// Llenar el Menu Ejecución Presupuestal

function llenar_ejecucion_alert() {
    alert("funciona llenar Menu Ejecución Presupuestal");
}

function llenar_menu_ejecucion() {

    $("#divContenidoMenu").empty();
    var cont_eje = '<section id="section_ejecucion" class="background_sirsam_">\
                        <div class="menu_indice">\
                            <div class ="container">\
                                <ol class="breadcrumb">\
                                    <li>\
                                        <a>\
                                            <i class="choose-icon ion-cash" style="color: black; font-size: 15px;"></i>  \
                                            Ejecución Presupuestal\
                                        </a>\
                                    </li>\
                                    <li id="liTipoPresuMenu"><i class="fa fa-dashboard"></i> Semáforo de Ejecución Presupuestal</li>\
                                </ol>\
                            </div>\
                        </div>\
                        <br>\
                        <div class="container">\
                            <div id="divFiltroPresu" class="filtro_princ naranja_secun">\
                                <div class="form-group">\
                                    <label for="listPresuReporte" class="col-form-label">Elija Tipo de Reporte :</label>\
                                    <select class="select-form" id="listPresuReporte" name="tipo">\
                                        <option value="11" selected>Semáforo de Ejecución Presupuestal</option>\
                                        <option value="10">Resumen de Ejecución Presupuestal</option>\
                                        <option value="01" >Ejecución de Gasto Histórico</option>\
                                        <option value="02">Ejecución de Gasto Anual</option>\
                                        <option value="03">Certificaciones Presupuestarias</option>\
                                        <option value="04">Expedientes SIAF</option>\
                                        <option value="05">Notas Modificatorias</option>\
                                        <option value="06">Recaudación de Ingresos Histórico</option>\
                                        <option value="07">Recaudación de Ingresos Anual</option>\
                                    </select>\
                                </div>\
                            </div>\
                            <br>\
                            <form id="formPresupuesto" method="post">\
                                <div id="divPresuReportes" class="oculto">\
                                    <label id="lblPresuFiltReporte">Filtro de Reporte</label>\
                                    <div id="divPresuFiltReporte" class="filtro_report naranja_secun"></div>\
                                    <br>\
                                    <div id="divPresuTabla" class="tabla_reporte naranja_secun oculto" style="overflow-x:auto;"></div>\
                                    <br>\
                                    <label id="lblPresuFiltGrafico" class="oculto">Filtro de Gráfico</label>\
                                    <div id="divPresuFiltGrafico" class="filtro_grafico naranja_secun oculto"></div>\
                                    <br>\
                                    <div id="divPresuGrafica" class="naranja_secun oculto"></div>\
                                </div>\
                            </form>\
                            <div id="divPresuReporteResumen">\
                                <div class="filtro_report naranja_secun">\
                                    <div class="form-group row">\
                                        <label for="listPresuEjecutoraSemaf" class="col-sm-2 col-form-label">Elija Ejecutora :</label>\
                                        <div class="col-sm-10">\
                                            <select class="select-form" id="listPresuEjecutoraSemaf"></select>\
                                        </div>\
                                    </div>\
                                    <div class="form-group row">\
                                        <label for="listSemaforoEjecAño" class="col-sm-2 col-form-label">Elija Año :</label>\
                                        <div class="col-sm-2">\
                                            <select class="select-form" id="listSemaforoEjecAño"></select>\
                                        </div>\
                                        <div class="col-sm-2"></div>\
                                        <label for="listSemaforoEjecEstado" class="col-sm-2 col-form-label">Filtro Semáforo :</label>\
                                        <div class="col-sm-2">\
                                            <select class="select-form" id="listSemaforoEjecEstado">\
                                                <option value= "00" selected>--TODOS--</option>\
                                                <option value= "01" style="color: green; font-weight: bold;">Verde</option>\
                                                <option value= "02" style="color: #FFBF00; font-weight: bold;">Ámbar</option>\
                                                <option value= "03" style="color: red; font-weight: bold;">Rojo</option>\
                                            </select>\
                                        </div>\
                                    </div>\
                                </div>\
                                <br>\
                                <div id="divPresuSemaforoEjecucionConte" class="filtro_report naranja_secun"></div>\
                            </div>\
                        </div>\
                    </section>';
    $("#divContenidoMenu").append(cont_eje);
    validaPermisoPresu();
    llenarSemaforoEjecutoras();
    cambiaTipo();
    eventFormReporte();
    limpiar();

}

function validaPermisoPresu() {

    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=validaPermiso&menu=4",
        success: function (response) {
            var perfil = response.perfil;
            var ejec = response.ejec;
            if (response.registra) {
                var btn = '<a id="aNuevoCentroMeta" style="cursor: pointer;">\
                            <div class="naranja_secun boton-superior pad8" style="cursor: pointer;">\
                               <img src="./resources/images/ejecucion1.png"> CENTROS DE COSTO - METAS <img src="./resources/images/ejecucion3.png">\
                            </div>\
                           </a>';
                $("#divFiltroPresu").before(btn);

                $("#aNuevoCentroMeta").on('click', function () {
                    llenar_centro_costo_meta(perfil, ejec);
                });

            }
        }
    });

}

function eventFormReporte() {
    $("#formPresupuesto").submit(function (evt) {
        var action = "./Presupuesto?tipo=" + $("#listPresuReporte").val();
        $("#formPresupuesto").attr("action", action);
        toastr.options.closeButton = true;
        toastr.options.timeOut = 2500;
        var funcion_validar = "validarFiltroReporte" + $("#listPresuReporte").val();
        var funcion_tabla = "llenarTablaReporte" + $("#listPresuReporte").val();
        if (window[funcion_validar]() === "OK") {
            evt.preventDefault();
            $("#divPresuTabla").removeClass("oculto");
            $("#divPresuTabla").empty();
            gif = '<img src="./resources/gifs/cargando.gif" style="display:block; margin:auto;"></img>';
            $("#divPresuTabla").append(gif);
            $("#divPresuGrafica").empty();
            $.ajax({
                dataType: 'json',
                type: 'post',
                url: $(this).attr("action"),
                data: $(this).serialize(),
                success: function (response) {
                    $("#divPresuTabla").empty();
                    window[funcion_tabla](response);
                }
            });
        } else {
            toastr.options.positionClass = "toast-middle-center";
            toastr.warning(window[funcion_validar](), 'Reporte');
            evt.preventDefault();
        }
    });
}

function limpiar() {
    $("#divPresuTabla").empty();
    $("#divPresuFiltGrafico").empty();
    $("#divPresuGrafica").empty();
    $("#divPresuTabla").addClass("oculto");
    $("#lblPresuFiltGrafico").addClass("oculto");
    $("#divPresuFiltGrafico").addClass("oculto");
    $("#divPresuGrafica").addClass("oculto");
}

function llenarAños(ejecutora) {
    $('#listPresuAñoDesde').empty();
    $('#listPresuAñoHasta').empty();
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataPresuAñosDesde&sec_ejec=" + ejecutora,
        success: function (response) {
            $.each(response.listAñoDesde, function (index, value) {
                obje1 = "<option value=" + value.ano_eje + ">" + value.ano_eje + "</option>";
                $("#listPresuAñoDesde").append(obje1);
            });
            $('#listPresuAñoHasta').empty();
            $.ajax({
                dataType: 'json',
                url: "./GsonData?url=DataPresuAñosHasta&año=" + $("#listPresuAñoDesde").val(),
                success: function (response) {
                    $.each(response.listAñoHasta, function (index, value) {
                        obje2 = "<option value=" + value.ano_eje + ">" + value.ano_eje + "</option>";
                        $("#listPresuAñoHasta").append(obje2);
                    });
                }
            });
            $("#listPresuAñoDesde").bind("change", function () {
                $('#listPresuAñoHasta').empty();
                $.ajax({
                    dataType: 'json',
                    url: "./GsonData?url=DataPresuAñosHasta&año=" + $("#listPresuAñoDesde").val(),
                    success: function (response) {
                        $('#listPresuAñoHasta').empty();
                        $.each(response.listAñoHasta, function (index, value) {
                            obje3 = "<option value=" + value.ano_eje + ">" + value.ano_eje + "</option>";
                            $("#listPresuAñoHasta").append(obje3);
                        });
                    }
                });
            });
        }
    });
}

function llenarAñosIngreso(ejecutora) {
    $('#listPresuAñoDesde').empty();
    $('#listPresuAñoHasta').empty();
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataPresuAñosDesdeIngreso&sec_ejec=" + ejecutora,
        success: function (response) {
            $.each(response.listAñoDesde, function (index, value) {
                obje1 = "<option value=" + value.ano_eje + ">" + value.ano_eje + "</option>";
                $("#listPresuAñoDesde").append(obje1);
            });
            $('#listPresuAñoHasta').empty();
            $.ajax({
                dataType: 'json',
                url: "./GsonData?url=DataPresuAñosHastaIngreso&año=" + $("#listPresuAñoDesde").val(),
                success: function (response) {
                    $.each(response.listAñoHasta, function (index, value) {
                        obje2 = "<option value=" + value.ano_eje + ">" + value.ano_eje + "</option>";
                        $("#listPresuAñoHasta").append(obje2);
                    });
                }
            });
            $("#listPresuAñoDesde").bind("change", function () {
                $('#listPresuAñoHasta').empty();
                $.ajax({
                    dataType: 'json',
                    url: "./GsonData?url=DataPresuAñosHastaIngreso&año=" + $("#listPresuAñoDesde").val(),
                    success: function (response) {
                        $('#listPresuAñoHasta').empty();
                        $.each(response.listAñoHasta, function (index, value) {
                            obje3 = "<option value=" + value.ano_eje + ">" + value.ano_eje + "</option>";
                            $("#listPresuAñoHasta").append(obje3);
                        });
                    }
                });
            });
        }
    });
}

function llenarAñoEjec(ejecutora, mensual_val) {
    $('#listPresuAño').empty();
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataPresuAños&sec_ejec=" + ejecutora,
        success: function (response) {
            $.each(response.listAños, function (index, value) {
                obje = "<option value=" + value.ano_eje + ">" + value.ano_eje + "</option>";
                $("#listPresuAño").append(obje);
            });
            $('#listPresuAño').prop('selectedIndex', 0);
            var año = $("#listPresuAño").val();
            var valP = $("#listPresuFiltroPrinc").val();
            llenarFiltPrinc02(valP, año, ejecutora, mensual_val);
        }
    });
}

function llenarAñoEjecIngreso(ejecutora, mensual_val) {
    $('#listPresuAño').empty();
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataPresuAñosIngreso&sec_ejec=" + ejecutora,
        success: function (response) {
            $.each(response.listAños, function (index, value) {
                obje = "<option value=" + value.ano_eje + ">" + value.ano_eje + "</option>";
                $("#listPresuAño").append(obje);
            });
            $('#listPresuAño').prop('selectedIndex', 0);
            var año = $("#listPresuAño").val();
            var valP = $("#listPresuFiltroPrinc").val();
            llenarFiltPrinc07(valP, año, ejecutora, mensual_val);
        }
    });
}

function llenarAñoCerti(ejecutora) {
    $('#listPresuAño').empty();
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataPresuAños&sec_ejec=" + ejecutora,
        success: function (response) {
            $.each(response.listAños, function (index, value) {
                obje = "<option value=" + value.ano_eje + ">" + value.ano_eje + "</option>";
                $("#listPresuAño").append(obje);
            });
            $('#listPresuAño').prop('selectedIndex', 0);
            var año = $("#listPresuAño").val();
            var valP = $("#listPresuFiltroPrincCerti").val();
            llenarFiltPrinc03(valP, año, ejecutora);
        }
    });
}

function llenarAñoExpe(ejecutora) {
    $('#listExpeAño').empty();
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataPresuAños&sec_ejec=" + ejecutora,
        success: function (response) {
            $.each(response.listAños, function (index, value) {
                obje = "<option value=" + value.ano_eje + ">" + value.ano_eje + "</option>";
                $("#listExpeAño").append(obje);
            });
            $('#listExpeAño').prop('selectedIndex', 0);
        }
    });
}

function llenarSemaforoEjecutoras() {
    $('#listPresuEjecutoraSemaf').empty();
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataEjecutoras",
        success: function (response) {
            $("#listPresuEjecutoraSemaf").append("<option value= '00'>Pliego 459 - Gobierno Regional de San Martin</option>");
            $.each(response.listEjecutoras, function (index, value) {
                var nombre_ejec = (value.nombre).split("-");
                obje = "<option value=" + value.sec_ejec + ">UE " + value.ejecutora + " - " + nombre_ejec[1].trim() + " (" + value.sec_ejec + ")</option>";
                $("#listPresuEjecutoraSemaf").append(obje);
            });
            $('#listPresuEjecutoraSemaf').prop('selectedIndex', 0);
            llenarSemaforoAños($('#listPresuEjecutoraSemaf').val());
        }
    });
    controlSemaforoEjecucionFiltro();
}

function llenarSemaforoAños(ejecutora) {
    $('#listSemaforoEjecAño').empty();
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataPresuAños&sec_ejec=" + ejecutora,
        success: function (response) {
            $.each(response.listAños, function (index, value) {
                obje = "<option value=" + value.ano_eje + ">" + value.ano_eje + "</option>";
                $("#listSemaforoEjecAño").append(obje);
            });
            $('#listSemaforoEjecAño').prop('selectedIndex', 0);
            llenarSemaforoEjecucionContenido(ejecutora, $('#listSemaforoEjecAño').val(), $('#listSemaforoEjecEstado').val());
        }
    });
}

function cambiaTipo() {
    $("#listPresuReporte").bind("change", function () {
        presupuesto_bread($("#listPresuReporte").val());
        if ($("#listPresuReporte").val() === "10") {
            $("#divPresuReportes").addClass("oculto");
            $("#divPresuReporteResumen").removeClass("oculto");
            llenarResumenEjecucionFiltro();
            $("#listPresuEjecutoraResum").bind("change", function () {
                llenarResumenEjecucionReporte($('#listPresuAñoResum').val(), $('#listPresuEjecutoraResum').val());
            });
            $("#listPresuAñoResum").bind("change", function () {
                llenarResumenEjecucionReporte($('#listPresuAñoResum').val(), $('#listPresuEjecutoraResum').val());
            });

            $("#divBlockSelectEjec").mousedown(function () {
                if ($("#listPresuEjecutoraResum").hasClass("cargando")) {
                    alertify.log("Espere que carguen todos los datos de la Unidad Ejecutora");
                }
            });

        } else if ($("#listPresuReporte").val() === "11") {
            $("#divPresuReportes").addClass("oculto");
            $("#divPresuReporteResumen").removeClass("oculto");
            llenarSemaforoEjecucionFiltro();
        } else {
            limpiar();
            $("#divPresuReportes").removeClass("oculto");
            $("#divPresuReporteResumen").addClass("oculto");
            $("#divPresuReporteResumen").empty();
            var funcion_llenar = "llenarFiltroReporte" + $("#listPresuReporte").val();
            var funcion_control = "controlFiltroReporte" + $("#listPresuReporte").val();
            window[funcion_llenar]();
            window[funcion_control]();
        }
    });
}

function presupuesto_bread(id) {
    $("#liTipoPresuMenu").empty();
    if (id === "01") {
        $("#liTipoPresuMenu").append('<i class="fa fa-list"></i> Ejecución de Gasto Histórico');
    }
    if (id === "02") {
        $("#liTipoPresuMenu").append('<i class="fa fa-list-alt"></i> Ejecución de Gasto Anual');
    }
    if (id === "03") {
        $("#liTipoPresuMenu").append('<i class="fa fa-cube"></i> Certificaciones Presupuestarias');
    }
    if (id === "04") {
        $("#liTipoPresuMenu").append('<i class="fa fa-credit-card"></i> Expedientes SIAF');
    }
    if (id === "05") {
        $("#liTipoPresuMenu").append('<i class="fa fa-newspaper-o"></i> Notas Modificatorias');
    }
    if (id === "06") {
        $("#liTipoPresuMenu").append('<i class="fa fa-indent"></i> Recaudación de Ingresos Histórico');
    }
    if (id === "07") {
        $("#liTipoPresuMenu").append('<i class="fa fa-server"></i> Recaudación de Ingresos Anual');
    }
    if (id === "10") {
        $("#liTipoPresuMenu").append('<i class="fa fa-columns"></i> Resumen de Ejecución Presupuestal');
    }
    if (id === "11") {
        $("#liTipoPresuMenu").append('<i class="fa fa-dashboard"></i> Semáforo de Ejecución Presupuestal');
    }
}

function cambiaMarco() {
    $("input[name=marco_todo]").change(function () {
        if (this.checked) {
            $("input[name=marco]").prop("checked", true);
        }
        if (this.checked === false) {
            $("input[name=marco]").prop("checked", false);
        }
    });
    $("input[name=marco]").change(function () {
        if (this.checked === false) {
            $("input[name=marco_todo]").prop("checked", false);
        }
        var count = 0;
        $("input[name=marco]").each(function () {
            if (this.checked) {
                count++;
            }
        });
        if (count === 3) {
            $("input[name=marco_todo]").prop("checked", true);
        }
    });
}

function cambiaFase() {
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
        if (count === 6) {
            $("input[name=fase_todo]").prop("checked", true);
        }
    });
}

function cambiaSaldo() {
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
        if (count === 6) {
            $("input[name=saldo_todo]").prop("checked", true);
        }
    });
}