// Llenar el Menu Administrador

function llenar_admin_alert() {
    alert("funciona llenar Menu Administrador");
}

function llenar_menu_admin() {

    $("#divContenidoMenu").empty();
    var cont_adm = '<section id="section_admin" class="background_sirsam_">\
                        <div class="menu_indice">\
                            <div class ="container">\
                                <ol class="breadcrumb">\
                                    <li>\
                                        <a>\
                                            <i class="choose-icon ion-settings" style="color: black; font-size: 15px;"></i>  \
                                            Administrador\
                                        </a>\
                                    </li>\
                                    <li id="liTipoAdminMenu"><i class="fa fa-users"></i> Usuarios del Sistema</li>\
                                </ol>\
                            </div>\
                        </div>\
                        <br>\
                        <div class="container">\
                            <div id="divFiltroAdmin" class="filtro_princ naranja_secun">\
                                <div class="form-group">\
                                    <label for="listFiltroAdmin" class="col-form-label">Elija Registro :</label>\
                                    <select class="select-form" id="listFiltroAdmin" name="tipo">\
                                        <option value="01" selected>Usuarios del Sistema</option>\
                                        <option value="02">Perfiles y Permisos</option>\
                                        <option value="03">Monitor de Sesiones</option>\
                                        <option value="04">Sincronización SIAF</option>\
                                    </select>\
                                </div>\
                            </div>\
                            <br>\
                            <div id="divAdminConte" class="filtro_report naranja_secun"></div>\
                        </div>\
                    </section>\
                    <div id="divUsuario"></div>\
                    <div id="divPerfil"></div>\
                    <div id="divPermisos"></div>';
    $("#divContenidoMenu").append(cont_adm);

    llenar_admin_usuarios();

    $("#listFiltroAdmin").bind("change", function () {
        administrador_bread($("#listFiltroAdmin").val());
        if ($("#listFiltroAdmin").val() === "01") {
            llenar_admin_usuarios();
        }
        if ($("#listFiltroAdmin").val() === "02") {
            llenar_admin_perfiles();
        }
        if ($("#listFiltroAdmin").val() === "03") {
            llenar_admin_sesiones();
        }
        if ($("#listFiltroAdmin").val() === "04") {
            llenar_admin_sincronizacion();
        }
    });

}

function administrador_bread(id) {
    $("#liTipoAdminMenu").empty();
    if (id === "01") {
        $("#liTipoAdminMenu").append('<i class="fa fa-users"></i> Usuarios del Sistema');
    }
    if (id === "02") {
        $("#liTipoAdminMenu").append('<i class="fa fa-list-alt"></i> Perfiles y Permisos');
    }
    if (id === "03") {
        $("#liTipoAdminMenu").append('<i class="fa fa-dashboard"></i> Monitor de Sesiones');
    }
    if (id === "04") {
        $("#liTipoAdminMenu").append('<i class="fa fa-database"></i> Sincronización SIAF');
    }
}