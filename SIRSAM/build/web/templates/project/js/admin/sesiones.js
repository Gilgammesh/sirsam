// Monitor de sesiones de usuario que ingresan al Sistema y que Navegan en Inicio

function llenar_alert_sesiones() {
    alert("funciona");
}

function llenar_admin_sesiones() {

    $("#divAdminConte").empty();
    contenido = '<div>\
                    <button id="btnUserSesion" class="btn btn-danger">\
                        <span class="glyphicon glyphicon-refresh spanBtn"></span>Actualizar\
                    </button>\
                 </div>\
                 <br/>\
                 <div>\
                    <ul class="list-group">\
                       <a id="aUserLog" style="cursor: pointer">\
                        <li class="list-group-item d-flex justify-content-between align-items-center activado">\
                            <img src="./resources/images/user.png"/>\
                            <label style="margin-left: 29px;">Número de usuarios logueados</label>\
                            <span id="spanUserLog" class="badge badge-danger"></span>\
                        </li>\
                       </a>\
                       <a id="aUserNav" style="cursor: pointer">\
                        <li class="list-group-item d-flex justify-content-between align-items-center">\
                            <img src="./resources/images/user_.png"/>\
                            <label style="margin-left: 35px;">Número de usuarios navegando</label>\
                            <span id="spanUserNav" class="badge badge-warning"></span>\
                        </li>\
                       </a>\
                       <a id="aUserHist" style="cursor: pointer">\
                        <li class="list-group-item d-flex justify-content-between align-items-center">\
                            <img src="./resources/images/user_registros.png"/>\
                            <label style="margin-left: 10px;">Historial de usuarios logueados</label>\
                        </li>\
                       </a>\
                    </ul>\
                 </div>\
                 <div id="divControlSesion" class="tabla_reporte"></div>\
                 <div id="divTablaSesiones" class="tabla_reporte" style="overflow-x:auto;"></div>';
    $("#divAdminConte").append(contenido);
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataMonitor",
        success: function (response) {
            $("#spanUserLog").empty();
            $("#spanUserNav").empty();
            $("#spanUserLog").append(response.logueados);
            $("#spanUserNav").append(response.navegando);
            sesionesLog();
        }
    });

    $("#btnUserSesion").click(function () {
        $.ajax({
            dataType: 'json',
            url: "./GsonData?url=DataMonitor",
            success: function (response) {
                $("#spanUserLog").empty();
                $("#spanUserNav").empty();
                $("#spanUserLog").append(response.logueados);
                $("#spanUserNav").append(response.navegando);
            }
        });
        if ($("#aUserLog li").hasClass("activado")) {
            sesionesLog();
        }
        if ($("#aUserNav li").hasClass("activado")) {
            sesionesNav();
        }
        if ($("#aUserHist li").hasClass("activado")) {
            sesionesHist();
        }
    });

    $("#aUserLog").click(function () {
        limpiarSesionUl();
        $("#aUserLog li").addClass("activado");
        $("#spanUserLog").addClass("badge-danger");
        $("#spanUserNav").addClass("badge-warning");
        $("#divControlSesion").empty();
        sesionesLog();
    });

    $("#aUserNav").click(function () {
        limpiarSesionUl();
        $("#aUserNav li").addClass("activado");
        $("#spanUserLog").addClass("badge-warning");
        $("#spanUserNav").addClass("badge-danger");
        $("#divControlSesion").empty();
        sesionesNav();
    });

    $("#aUserHist").click(function () {
        limpiarSesionUl();
        $("#aUserHist li").addClass("activado");
        $("#spanUserLog").addClass("badge-warning");
        $("#spanUserNav").addClass("badge-warning");
        $("#divControlSesion").empty();
        var controles = '<div class="form-group row">\
                            <label for="iptFechaDesde" class="col-sm-1 col-form-label">Desde :</label>\
                            <div class="col-sm-2">\
                               <input id="iptFechaDesde" name="desde" type="date" class="col-form-date" data-date-format="dd/mm/yyyy">\
                            </div>\
                            <div class="col-sm-1"></div>\
                            <label for="iptFechaHasta" class="col-sm-1 col-form-label">Hasta :</label>\
                            <div class="col-sm-2">\
                               <input id="iptFechaHasta" name="hasta" type="date" class="col-form-date" data-date-format="dd/mm/yyyy">\
                            </div>\
                         </div>';
        $("#divControlSesion").append(controles);
        document.getElementById("iptFechaDesde").valueAsDate = new Date();
        document.getElementById('iptFechaHasta').valueAsDate = new Date();
        sesionesHist($("#iptFechaDesde").val(), $("#iptFechaHasta").val());

        $("#iptFechaDesde").change(function () {
            sesionesHist($("#iptFechaDesde").val(), $("#iptFechaHasta").val());
        });

        $("#iptFechaHasta").change(function () {
            sesionesHist($("#iptFechaDesde").val(), $("#iptFechaHasta").val());
        });


    });

}

function limpiarSesionUl() {
    $("#aUserLog li").removeClass("activado");
    $("#aUserNav li").removeClass("activado");
    $("#aUserHist li").removeClass("activado");
    $("#spanUserLog").removeClass("badge-danger");
    $("#spanUserLog").removeClass("badge-warning");
    $("#spanUserNav").removeClass("badge-danger");
    $("#spanUserNav").removeClass("badge-warning");
}

function sesionesLog() {
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataMonitorLogin",
        success: function (response) {
            $("#divTablaSesiones").empty();
            conten = '<table id="tablaSesiones" class="display" cellspacing="0" width="100%">\
                            <thead id="tablaSesionesHead"></thead>\
                            <tfoot id="tablaSesionesFoot"></tfoot>\
                            <tbody id="tablaSesionesBody"></tbody>\
                    </table>';
            $("#divTablaSesiones").append(conten);
            head = "<tr>\
                        <th style='text-align: center;'>Id</th>\
                        <th style='text-align: center;'>Ingreso</th>\
                        <th style='text-align: center;'>Usuario</th>\
                        <th style='text-align: center;'>Explorador</th>\
                        <th style='text-align: center;'>Dispositivo</th>\
                        <th style='text-align: center;'>Módulo</th>\
                    </tr>";
            $("#tablaSesionesHead").append(head);
            $("#tablaSesionesFoot").append(head);
            $.each(response.listSesionL, function (index, value) {
                var brow, browser;
                if (!$.trim(value.browser)) {
                    brow = "desconocido";
                    browser = "Desconocido";
                } else {
                    browser = value.browser;
                    if (value.browser.substring(0, 6) === "Chrome") {
                        brow = "chrome";
                    } else if (value.browser.substring(0, 7) === "Firefox") {
                        brow = "firefox";
                    } else if (value.browser.substring(0, 2) === "IE") {
                        brow = "ie";
                    } else if (value.browser.substring(0, 17) === "Internet Explorer") {
                        brow = "ie";
                    } else if (value.browser.substring(0, 5) === "Opera") {
                        brow = "opera";
                    } else if (value.browser.substring(0, 6) === "Safari") {
                        brow = "safari";
                    } else if (value.browser.substring(0, 14) === "Microsoft Edge") {
                        brow = "edge";
                    } else {
                        brow = "generic";
                        browser = "Genérico";
                    }
                }
                var devi, device;
                if (!$.trim(value.device)) {
                    devi = "desconocido";
                    device = "Desconocido";
                } else {
                    device = value.device;
                    if (value.device === "Computadora") {
                        devi = "computadora";
                    } else if (value.device === "SmartPhone") {
                        devi = "smartphone";
                    } else if (value.device === "Tablet") {
                        devi = "tablet";
                    } else if (value.device === "Consola de Juego") {
                        devi = "game";
                    } else if (value.device === "Reproductor Digital") {
                        devi = "dmr";
                    } else if (value.device === "SmartWatch") {
                        devi = "smartwatch";
                    } else {
                        devi = "generic";
                        device = "Genérico";
                    }
                }
                var inicio;
                if (!$.trim(value.inicioLogin)) {
                    inicio = "";
                } else {
                    inicio = value.inicioLogin;
                }
                body = "<tr>\
                            <td align='center'>" + (index + 1) + "</td>\
                            <td align='center'>" + inicio + "</td>\
                            <td align='center'>\
                            " + value.nombres + "  " + value.apellidoPaterno + "  " + value.apellidoMaterno + "\
                            </td>\
                            <td align='center'>\
                                <img src='./resources/images/browsers/" + brow + ".png'/><br>\
                                " + browser + "\
                            </td>\
                            <td align='center'>\
                                <img src='./resources/images/devices/" + devi + ".png'/><br>\
                                " + device + "\
                            </td>\
                            <td align='center'>" + value.menuDescripcion + "</td>\
                        </tr>";
                $("#tablaSesionesBody").append(body);
            });
            $('#tablaSesiones').dataTable({
                ordering: true,
                dom: '<"centrar-div-tabla"lfB>iprtip',
                buttons: [
                    {
                        extend: 'excel',
                        filename: 'lista_usuarios_logueados',
                        title: 'LISTA DE USUARIOS LOGUEADOS',
                        messageTop: 'SISTEMA INTEGRADO REGIONAL SAN MARTIN (SIRSAM)',
                        exportOptions: {
                            orthogonal: 'sort',
                            columns: ':visible'
                        }
                    }
                ]
            });
        }
    });
}

function sesionesNav() {
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataMonitorNavega",
        success: function (response) {
            $("#divTablaSesiones").empty();
            conten = '<table id="tablaSesiones" class="display" cellspacing="0" width="100%">\
                            <thead id="tablaSesionesHead"></thead>\
                            <tfoot id="tablaSesionesFoot"></tfoot>\
                            <tbody id="tablaSesionesBody"></tbody>\
                    </table>';
            $("#divTablaSesiones").append(conten);
            head = "<tr>\
                        <th style='text-align: center;'>Id</th>\
                        <th style='text-align: center;'>Sesion ID</th>\
                        <th style='text-align: center;'>Ingreso</th>\
                        <th style='text-align: center;'>Explorador</th>\
                        <th style='text-align: center;'>Dispositivo</th>\
                        <th style='text-align: center;'>Módulo</th>\
                    </tr>";
            $("#tablaSesionesHead").append(head);
            $("#tablaSesionesFoot").append(head);
            $.each(response.listSesionN, function (index, value) {
                var brow, browser;
                if (!$.trim(value.browser)) {
                    brow = "desconocido";
                    browser = "Desconocido";
                } else {
                    browser = value.browser;
                    if (value.browser.substring(0, 6) === "Chrome") {
                        brow = "chrome";
                    } else if (value.browser.substring(0, 7) === "Firefox") {
                        brow = "firefox";
                    } else if (value.browser.substring(0, 2) === "IE") {
                        brow = "ie";
                    } else if (value.browser.substring(0, 17) === "Internet Explorer") {
                        brow = "ie";
                    } else if (value.browser.substring(0, 5) === "Opera") {
                        brow = "opera";
                    } else if (value.browser.substring(0, 6) === "Safari") {
                        brow = "safari";
                    } else if (value.browser.substring(0, 14) === "Microsoft Edge") {
                        brow = "edge";
                    } else {
                        brow = "generic";
                        browser = "Genérico";
                    }
                }
                var devi, device;
                if (!$.trim(value.device)) {
                    devi = "desconocido";
                    device = "Desconocido";
                } else {
                    device = value.device;
                    if (value.device === "Computadora") {
                        devi = "computadora";
                    } else if (value.device === "SmartPhone") {
                        devi = "smartphone";
                    } else if (value.device === "Tablet") {
                        devi = "tablet";
                    } else if (value.device === "Consola de Juego") {
                        devi = "game";
                    } else if (value.device === "Reproductor Digital") {
                        devi = "dmr";
                    } else if (value.device === "SmartWatch") {
                        devi = "smartwatch";
                    } else {
                        devi = "generic";
                        device = "Genérico";
                    }
                }
                var inicio;
                if (!$.trim(value.inicioNavega)) {
                    inicio = "";
                } else {
                    inicio = value.inicioNavega;
                }
                body = "<tr>\
                            <td align='center'>" + (index + 1) + "</td>\
                            <td align='center'>" + value.sesiId + "</td>\
                            <td align='center'>" + inicio + "</td>\
                            <td align='center'>\
                                <img src='./resources/images/browsers/" + brow + ".png'/><br>\
                                " + browser + "\
                            </td>\
                            <td align='center'>\
                                <img src='./resources/images/devices/" + devi + ".png'/><br>\
                                " + device + "\
                            </td>\
                            <td align='center'>" + value.menuDescripcion + "</td>\
                        </tr>";
                $("#tablaSesionesBody").append(body);
            });
            $('#tablaSesiones').dataTable({
                ordering: true,
                dom: '<"centrar-div-tabla"lfB>iprtip',
                buttons: [
                    {
                        extend: 'excel',
                        filename: 'lista_usuarios_navegando',
                        title: 'LISTA DE USUARIOS NAVEGANDO EN INICIO',
                        messageTop: 'SISTEMA INTEGRADO REGIONAL SAN MARTIN (SIRSAM)',
                        exportOptions: {
                            orthogonal: 'sort',
                            columns: ':visible'
                        }
                    }
                ]
            });
        }
    });
}

function sesionesHist(desde, hasta) {
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataMonitorHistoLogin&desde=" + desde + "&hasta=" + hasta + "",
        success: function (response) {
            $("#divTablaSesiones").empty();
            conten = '<table id="tablaSesiones" class="display" cellspacing="0" width="100%">\
                            <thead id="tablaSesionesHead"></thead>\
                            <tfoot id="tablaSesionesFoot"></tfoot>\
                            <tbody id="tablaSesionesBody"></tbody>\
                    </table>';
            $("#divTablaSesiones").append(conten);
            head = "<tr>\
                        <th style='text-align: center;'>Id</th>\
                        <th style='text-align: center;'>Sesion ID</th>\
                        <th style='text-align: center;'>Ingreso</th>\
                        <th style='text-align: center;'>Fin</th>\
                        <th style='text-align: center;'>Usuario</th>\
                        <th style='text-align: center;'>Explorador</th>\
                        <th style='text-align: center;'>Dispositivo</th>\
                    </tr>";
            $("#tablaSesionesHead").append(head);
            $("#tablaSesionesFoot").append(head);
            $.each(response.listSesionL, function (index, value) {
                var brow, browser;
                if (!$.trim(value.browser)) {
                    brow = "desconocido";
                    browser = "Desconocido";
                } else {
                    browser = value.browser;
                    if (value.browser.substring(0, 6) === "Chrome") {
                        brow = "chrome";
                    } else if (value.browser.substring(0, 7) === "Firefox") {
                        brow = "firefox";
                    } else if (value.browser.substring(0, 2) === "IE") {
                        brow = "ie";
                    } else if (value.browser.substring(0, 17) === "Internet Explorer") {
                        brow = "ie";
                    } else if (value.browser.substring(0, 5) === "Opera") {
                        brow = "opera";
                    } else if (value.browser.substring(0, 6) === "Safari") {
                        brow = "safari";
                    } else if (value.browser.substring(0, 14) === "Microsoft Edge") {
                        brow = "edge";
                    } else {
                        brow = "generic";
                        browser = "Genérico";
                    }
                }
                var devi, device;
                if (!$.trim(value.device)) {
                    devi = "desconocido";
                    device = "Desconocido";
                } else {
                    device = value.device;
                    if (value.device === "Computadora") {
                        devi = "computadora";
                    } else if (value.device === "SmartPhone") {
                        devi = "smartphone";
                    } else if (value.device === "Tablet") {
                        devi = "tablet";
                    } else if (value.device === "Consola de Juego") {
                        devi = "game";
                    } else if (value.device === "Reproductor Digital") {
                        devi = "dmr";
                    } else if (value.device === "SmartWatch") {
                        devi = "smartwatch";
                    } else {
                        devi = "generic";
                        device = "Genérico";
                    }
                }
                var inicio;
                if (!$.trim(value.inicioLogin)) {
                    inicio = "";
                } else {
                    inicio = value.inicioLogin;
                }
                var fin;
                if (!$.trim(value.finLogin)) {
                    fin = "";
                } else {
                    fin = value.finLogin;
                }
                body = "<tr>\
                            <td align='center'>" + (index + 1) + "</td>\
                            <td align='center'>" + value.sesiId + "</td>\
                            <td align='center'>" + inicio + "</td>\
                            <td align='center'>" + fin + "</td>\
                            <td align='center'>\
                            " + value.nombres + "  " + value.apellidoPaterno + "  " + value.apellidoMaterno + "\
                            </td>\
                            <td align='center'>\
                                <img src='./resources/images/browsers/" + brow + ".png'/><br>\
                                " + browser + "\
                            </td>\
                            <td align='center'>\
                                <img src='./resources/images/devices/" + devi + ".png'/><br>\
                                " + device + "\
                            </td>\
                        </tr>";
                $("#tablaSesionesBody").append(body);
            });
            $('#tablaSesiones').dataTable({
                ordering: true,
                dom: '<"centrar-div-tabla"lfB>iprtip',
                buttons: [
                    {
                        extend: 'excel',
                        filename: 'reporte_usuarios_logueados_desde_' + desde + '_hasta_' + hasta,
                        title: 'REPORTE DE USUARIOS LOGUEADOS',
                        messageTop: 'DESDE: ' + desde + '  HASTA: ' + hasta,
                        exportOptions: {
                            orthogonal: 'sort',
                            columns: ':visible'
                        }
                    }
                ]
            });
        }
    });
}