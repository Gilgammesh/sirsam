// Llenar el Menu Inversión Pública (Proyectos)

function llenar_proyectos_alert() {
    alert("funciona llenar Menu Inversión Pública");
}

function llenar_menu_proyectos(tipo) {

    $("#divContenidoMenu").empty();
    var cont_pro = '<section id="section_proyectos" class="background_sirsam_">\
                        <div class="menu_indice">\
                            <div class ="container">\
                                <ol class="breadcrumb">\
                                    <li>\
                                        <a>\
                                            <i class="choose-icon ion-cube" style="color: black; font-size: 15px;"></i>  \
                                            Inversión Pública\
                                        </a>\
                                    </li>\
                                    <li id="liTipoInverMenu"></li>\
                                </ol>\
                            </div>\
                        </div>\
                        <br>\
                        <div class="container">\
                            <div id="divProyFiltro" class="filtro_princ naranja_secun">\
                                <div class="form-group">\
                                    <label for="listProyReporte" class="col-form-label">Elija Tipo de Consulta :</label>\
                                    <select class="select-form" id="listProyReporte">\
                                        <option value="00">Semáforo de Proyectos (En Ejecución)</option>\
                                        <option value="01">Búsqueda Avanzada de Proyectos</option>\
                                    </select>\
                                </div>\
                            </div>\
                            <br>\
                            <div id="divProyectos">\
                            </div>\
                        </div>\
                    </section>';
    $("#divContenidoMenu").append(cont_pro);
    validaPermisoProyecto();
    llenarTipoProy(tipo);
    cambiaTipoProy();
    
}

function validaPermisoProyecto() {

    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=validaPermiso&menu=5",
        success: function (response) {
            if (response.registra) {
                var btn = '<a id="aRegInfoProyecto" style="cursor: pointer;">\
                               <div class="naranja_secun boton-superior pad8" style="cursor: pointer;">\
                                  <img src="./resources/images/proyecto1.png" />\
                                  REGISTRAR INFORMACIÓN\
                                  <img src="./resources/images/proyecto2.png" />\
                               </div>\
                            </a>';
                $("#divProyFiltro").before(btn);

                $("#aRegInfoProyecto").on('click', function () {
                    llenar_registro_info_proyecto($("#listProyReporte").val());
                });

            }
        }
    });

}

function llenarTipoProy(tipo) {
    $('#liTipoInverMenu').empty();
    if (!$.trim(tipo)) {
        $('#liTipoInverMenu').append('<i class="fa fa-dashboard"></i> Semáforo de Proyectos (En Ejecución)');
        $('#listProyReporte').prop('selectedIndex', 0);
        llenar_proy_semaforo_proyecto();

    } else {
        if (tipo === "00") {
            $('#liTipoInverMenu').append('<i class="fa fa-dashboard"></i> Semáforo de Proyectos (En Ejecución)');
            $('#listProyReporte').prop('selectedIndex', 0);
            llenar_proy_semaforo_proyecto();
        }
        if (tipo === "01") {
            $('#liTipoInverMenu').append('<i class="fa fa-search"></i> Búsqueda Avanzada de Proyectos');
            $('#listProyReporte').prop('selectedIndex', 1);
            llenar_proy_busqueda_avanzada();
        }
    }
}

function cambiaTipoProy() {
    $("#listProyReporte").bind("change", function () {
        $('#liTipoInverMenu').empty();
        if ($("#listProyReporte").val() === "00") {
            $('#liTipoInverMenu').append('<i class="fa fa-dashboard"></i> Semáforo de Proyectos (En Ejecución)');
            $('#listProyReporte').prop('selectedIndex', 0);
            llenar_proy_semaforo_proyecto();
        }
        if ($("#listProyReporte").val() === "01") {
            $('#liTipoInverMenu').append('<i class="fa fa-search"></i> Búsqueda Avanzada de Proyectos');
            $('#listProyReporte').prop('selectedIndex', 1);
            llenar_proy_busqueda_avanzada();
        }
    });
}


