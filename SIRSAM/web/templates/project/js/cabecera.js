$(function () {

    menuLoginPermisos();

});

function menuClean() {
    $('li.dinamico').removeClass('active');
}

function menuDinamico() {
    menuClean();
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=menuDinamico",
        success: function (response) {
            var menu = response.menu;
            $("#" + menu).addClass('active');
            window["llenar_" + menu]();
        }
    });
}

function menuLoginPermisos() {

    $('li.dinamico').addClass('hide');

    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=Inicio",
        success: function (response) {
            toastr.options.closeButton = true;
            toastr.options.timeOut = 2000;
            toastr.options.positionClass = "toast-bottom-right";
            var perfil = response.perfil;
            var save = true;
            if (perfil === "") {
                user_login();
                var menu_inicio = '<li id="menu_inicio" class="dinamico">\
                                    <a href="#inicio" id="ainicio" class="dinamico"></a>\
                                   </li>';
                $('#ulBarraNav').append(menu_inicio);
                var handleMatchMedia = function (md) {
                    if (md.matches) {
                        $('#ainicio').empty();
                        $('#ainicio').html('<span class="choose-icon ion-home"></span>&nbsp;&nbsp;Inicio');
                    } else {
                        $('#ainicio').empty();
                        $('#ainicio').html('<span class="choose-icon ion-home"></span>&nbsp;Inicio<br>&nbsp;');
                    }
                };
                var mq = window.matchMedia("(max-width: 999px)");
                handleMatchMedia(mq);
                mq.addListener(handleMatchMedia);
                menuDinamico();
                $('a.dinamico').click(function () {
                    var aId = this.id;
                    var liId = 'menu_' + aId.substring(1, aId.length);
                    $.ajax({
                        dataType: 'json',
                        url: "./GsonData?url=insertDinamico&menu=" + liId,
                        success: function (response) {
                        }
                    });
                    menuClean();
                    $("#" + liId).addClass('active');
                    window["llenar_" + liId]();
                });

                $("#formLogin").submit(function (evt) {
                    evt.preventDefault();
                    $.ajax({
                        dataType: 'json',
                        type: 'post',
                        url: $(this).attr("action"),
                        data: $(this).serialize(),
                        success: function (response) {
                            toastr.options.closeButton = true;
                            toastr.options.timeOut = 2000;
                            toastr.options.positionClass = "toast-top-right";
                            if (response.success) {
                                window.location = response.msg;
                            } else {
                                toastr.warning(response.msg, 'Inicio de Sesión');
                            }
                        }
                    });
                });

            } else {
                var sexo = "";
                if (response.sexo === "M") {
                    sexo = "masculino";
                }
                if (response.sexo === "F") {
                    sexo = "femenino";
                }
                login(sexo);
                datos_login();

                $('#ulBarraNav').empty();
                $.each(response.listPermisos, function (index, value) {
                    var menu = value.menuNombre;
                    var nombre = menu.split("_");
                    var menu_lista = '<li id="' + menu + '" class="dinamico">\
                                        <a href="#' + nombre[1] + '" id="a' + nombre[1] + '" class="dinamico"></a>\
                                       </li>';
                    $('#ulBarraNav').append(menu_lista);
                });
                var handleMatchMedia = function (md) {
                    if (md.matches) {
                        vaciar();
                        $('#ainicio').html('<span class="choose-icon ion-home"></span>&nbsp;&nbsp;Inicio');
                        $('#aestadistica').html('<span class="choose-icon ion-pie-graph"></span>&nbsp;&nbsp;Estadística Regional');
                        $('#aplanes').html('<span class="choose-icon ion-arrow-graph-up-right"></span>&nbsp;&nbsp;Planeamiento Estratégico');
                        $('#aejecucion').html('<span class="choose-icon ion-cash"></span>&nbsp;&nbsp;Ejecución Presupuestal');
                        $('#aproyectos').html('<span class="choose-icon ion-cube"></span>&nbsp;&nbsp;Inversión Pública');
                        $('#anormas').html('<span class="choose-icon ion-clipboard"></span>&nbsp;&nbsp;Normatividad Institucional');
                        $('#aadmin').html('<span class="choose-icon ion-settings"></span>&nbsp;&nbsp;Administrador');
                    } else {
                        vaciar();
                        $('#ainicio').html('<span class="choose-icon ion-home"></span>&nbsp;Inicio<br>&nbsp;');
                        $('#aestadistica').html('<span class="choose-icon ion-pie-graph"></span>&nbsp;Estadística<br>Regional');
                        $('#aplanes').html('<span class="choose-icon ion-arrow-graph-up-right"></span>&nbsp;Planeamiento<br>Estratégico');
                        $('#aejecucion').html('<span class="choose-icon ion-cash"></span>&nbsp;Ejecución<br>Presupuestal');
                        $('#aproyectos').html('<span class="choose-icon ion-cube"></span>&nbsp;Inversión<br>Pública');
                        $('#anormas').html('<span class="choose-icon ion-clipboard"></span>&nbsp;Normatividad<br>Institucional');
                        $('#aadmin').html('<span class="choose-icon ion-settings"></span><br>&nbsp;Admin');
                    }
                };
                var mq = window.matchMedia("(max-width: 999px)");
                handleMatchMedia(mq);
                mq.addListener(handleMatchMedia);
                menuDinamico();
                $('a.dinamico').click(function () {
                    var aId = this.id;
                    var liId = 'menu_' + aId.substring(1, aId.length);
                    $.ajax({
                        dataType: 'json',
                        url: "./GsonData?url=insertDinamico&menu=" + liId,
                        success: function (response) {
                        }
                    });
                    menuClean();
                    $("#" + liId).addClass('active');
                    window["llenar_" + liId]();
                });

                $("#formLogout").submit(function (evt) {
                    evt.preventDefault();
                    $.ajax({
                        dataType: 'json',
                        type: 'post',
                        url: $(this).attr("action"),
                        data: $(this).serialize(),
                        success: function (response) {
                            window.location = response.window;
                        }
                    });
                });

                $("#btnContra1").click(function () {
                    contraseña();
                    datos_cont();
                    document.getElementById('divContra').classList.add('div-contrasena');
                    document.getElementById('divFondo').classList.add('div-atras');

                    $("#btnContra2").click(function () {
                        $("#divContra").empty();
                        document.getElementById('divContra').classList.remove('div-contrasena');
                        document.getElementById('divFondo').classList.remove('div-atras');
                    });

                    $("#formContra").submit(function (evt) {
                        evt.preventDefault();
                        $.ajax({
                            dataType: 'json',
                            type: 'post',
                            url: $(this).attr("action"),
                            data: $(this).serialize(),
                            success: function (response) {
                                if (response.success) {
                                    toastr.info(response.msg, 'Cambio de Contraseña');
                                    $("#divContra").empty();
                                    document.getElementById('divContra').classList.remove('div-contrasena');
                                    document.getElementById('divFondo').classList.remove('div-atras');
                                    window.location = response.window;
                                } else {
                                    toastr.warning(response.msg, 'Cambio de Contraseña');
                                }
                            }
                        });
                    });

                });
            }
        }
    });

}

function vaciar() {
    $('#ainicio').empty();
    $('#aestadistica').empty();
    $('#aplanes').empty();
    $('#aejecucion').empty();
    $('#aproyectos').empty();
    $('#anormas').empty();
}

function user_login() {

    $("#divUserLogin").empty();

    Inicio = '<div class="navbar pull-right">\
                <ul class="nav navbar-nav">\
                    <li class="dropdown user user-menu">';

    Cabecera = '<a href="#" class="dropdown-toggle" data-toggle="dropdown">\
                    <img src="./resources/images/user.png"/>&nbsp;&nbsp;\
                    <span>INICIAR SESIÓN</span>\
                </a>';

    CuerpoIni = '<ul class="dropdown-menu">\
                    <li class="user-footer">\
                        <form id="formLogin" method="post" action="./Usuario?action=connect">';

    Cuerpo = '<div>\
                <p>Usuario :</p>\
                <input type="text" class="form-control" name="login" placeholder="DNI"/>\
              </div>';

    Cuerpo += '<div style="margin-top: 5px;">\
                    <p>Contraseña :</p>\
                    <input type="password" class="form-control" name="password" placeholder="Contraseña"/>\
               </div>';

    Cuerpo += '<div style="margin-top: 5px;">\
                    <p>Captcha :</p>\
                    <img id="captcha" src="./captcha.jpg" style="height: 34px; width: 100%;"/>\
               </div>';

    Cuerpo += '<div style="margin-top: 8px;">\
                    <input t id="usua_captcha" class="form-control" name="captcha" maxlength="6" placeholder="Captcha"/>\
               </div>';

    Cuerpo += '<div class="pull-right" style="margin-top: 10px;">\
                    <button type="submit" class="btn btn3d btn-white btn-sm">\
                        <div class="pull-left">\
                            Ingresar al<br>Sistema\
                        </div>\
                        <div class="pull-right" style="margin-left:9px; color: #FF7700;">\
                            <i class="fa fa-sign-in fa-3x"></i>\
                        </div>\
                    </button>\
               </div>';

    CuerpoFin = '</form></li></ul>';

    Final = '</li></ul></div>';

    HTML = Inicio + Cabecera + CuerpoIni + Cuerpo + CuerpoFin + Final;

    $("#divUserLogin").append(HTML);

}

function login(sexo) {

    $("#divUserLogin").empty();

    Inicio = '<div class="navbar pull-right">\
                <ul class="nav navbar-nav">\
                    <li class="dropdown user user-menu">';

    Cabecera = '<a href="#" class="dropdown-toggle" data-toggle="dropdown">\
                    <img src="./resources/images/' + sexo + '-s.png"/>&nbsp;&nbsp;\
                    <span id="user-nombre"></span>\
                </a>';

    CuerpoIni = '<ul class="dropdown-menu drop-sty">\
                    <li class="user-header">\
                        <img class="img-circle z-image" src="./resources/images/' + sexo + '-m.png"/>\n\
                        <p id="user-nombres"></p>\
                    </li>\
                    <li class="user-footer">';

    Cuerpo = '<div class="pull-left">\
                <button id="btnContra1" class="btn btn3d btn-default btn-sm" style="color: #004489;">\
                    <div class="pull-left">\
                        Cambiar<br>Contraseña\
                    </div>\
                    <div class="pull-right" style="margin-left:6px; color: #FF7700;">\
                        <i class="fa fa-key fa-3x"></i>\
                    </div>\
                </button>\
              </div>';

    Cuerpo += '<div class="pull-right">\
                    <form id="formLogout" method="post">\
                        <button type="submit" class="btn btn3d btn-default btn-sm" style="color: #004489;">\
                            <div class="pull-left">\
                                Salir del<br>Sistema\
                            </div>\
                            <div class="pull-right" style="margin-left:11px; color: #FF7700;">\
                                <i class="fa fa-sign-out fa-3x"></i>\
                            </div>\
                        </button>\
                    </form>\
               </div>';

    CuerpoFin = '</li></ul>';

    Final = '</li></ul></div>';

    HTML = Inicio + Cabecera + CuerpoIni + Cuerpo + CuerpoFin + Final;

    $("#divUserLogin").append(HTML);
}

function datos_login() {
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataLogin",
        success: function (response) {
            var nombres = response.nombres;
            var nombre1 = response.nombre1;
            var paterno = response.apellido_paterno;
            var materno = response.apellido_materno;
            $('#user-nombre').append(nombre1 + " " + paterno);
            $('#user-nombres').append(nombres + '<br>' + paterno + ' ' + materno);
            var action = "./Usuario?action=disconnect";
            $("#formLogout").attr("action", action);
        }
    });
}

function contraseña() {

    $("#divContra").empty();
    contenido = '<form id="formContra" method="post">\
                    <div class="form-group" style="text-align: center;">\
                        <label class="col-form-label">CAMBIAR CONTRASEÑA</label>\
                    </div>\
                    <div class="form-group">\
                        <label for="contraactual" class="col-form-label">Contraseña Actual :</label>\
                        <input id="contraactual" type="password" name="passwordA" class="form-control" placeholder="Ingrese Contraseña Actual" />\
                    </div>\
                    <div class="form-group">\
                        <label for="contranueva" class="col-form-label">Contraseña Nueva :</label>\
                        <input id="contranueva" type="password" name="passwordN" class="form-control" placeholder="Ingrese Contraseña Nueva" />\
                    </div>\
                    <div class="form-group">\
                        <label for="contranuevaR" class="col-form-label">Confirmar Contraseña Nueva :</label>\
                        <input id="contranuevaR" type="password" name="passwordR" class="form-control" placeholder="Ingrese Contraseña Nueva" />\
                    </div>\
                    <br/>\
                    <div class="form-row">\
                        <div class="col-auto">\
                            <button type="submit" class="btn btn3d btn-primary btn-m">\
                                <span class="glyphicon glyphicon-floppy-disk spanBtn"></span>Guardar\
                            </button>\
                        </div>\
                        <div class="col-auto">\
                            <button id="btnContra2" type="reset" value="Reset" class="btn btn3d btn-danger btn-m">\
                                <span class="glyphicon glyphicon-ban-circle spanBtn"></span>Cancelar\
                            </button>\
                        </div>\
                    </div>\
                 </form>';
    $("#divContra").append(contenido);

}

function datos_cont() {
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataLogin",
        success: function (response) {
            var action = "./Usuario?action=password&usua_id=" + response.id_usuario;
            $("#formContra").attr("action", action);
        }
    });
}
