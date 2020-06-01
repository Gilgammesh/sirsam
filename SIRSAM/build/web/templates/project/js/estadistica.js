// Llenar el Menu Estadística Regional

function llenar_estadistica_alert() {
    alert("funciona llenar Menu Estadística Regional");
}

function llenar_menu_estadistica() {

    $("#divContenidoMenu").empty();
    var cont_est = '<section id="section_estadistica" class="background_sirsam_">\
                        <div class="menu_indice">\
                            <div class ="container">\
                                <ol class="breadcrumb">\
                                    <li>\
                                        <a>\
                                            <i class="choose-icon ion-pie-graph" style="color: black; font-size: 15px;"></i>  \
                                            Estadística Regional\
                                        </a>\
                                    </li>\
                                    <li><i class="fa fa-bullseye"></i> Indicadores Regionales</li>\
                                </ol>\
                            </div>\
                        </div>\
                        <br>\
                        <div class="container">\
                            <a id="aRegInfoEstadistica" style="cursor: pointer;">\
                              <div class="naranja_secun boton-superior pad8" style="cursor: pointer;">\
                               <img src="./resources/images/estadistica1.png"> REGISTRAR INFORMACIÓN  <img src="./resources/images/estadistica3.png">\
                              </div>\
                            </a>\
                            <div class="filtro_princ naranja_secun">\
                                <div id="divSectorEstadistica" class="form-group">\
                                    <label for="listSectorEstadistica" class="col-form-label">Elija Sector Estadístico : </label></br>\
                                    <select class="selectpicker" id="listSectorEstadistica"></select>\
                                </div>\
                            </div>\
                            </br>\
                            <div id="divIndiEstadistica"></div>\
                        </div>\
                    </section>';
    $("#divContenidoMenu").append(cont_est);

    llenarSectoresEstadistica();

}

function llenarSectoresEstadistica() {
    $.ajax({
        dataType: 'json',
        url: "./Estadistica?url=sectores",
        success: function (response) {

            $("#listSectorEstadistica").append('<option value="00">--ELIJA SECTOR--</option>');

            $.each(response.listSectores, function (index, value) {
                var data = "<i class='" + value.sectIcon + "' aria-hidden='true'></i> " + value.sectNombre;
                var sect = '<option value=' + value.sectId + ' data-content="' + data + '"></option>';
                $("#listSectorEstadistica").append(sect);
            });

            $('#listSectorEstadistica').selectpicker();

            $("#divIndiFiltroEstadistica").empty();
            $("#divIndiContenidoEstadistica").empty();

            $("#listSectorEstadistica").bind("change", function () {
                var sector = $("#listSectorEstadistica").val();
                $("#divIndiEstadistica").empty();
                if (sector !== "00") {
                    llenarIndicadorFiltroEstadistica(sector);
                }
            });
        }
    });
}

function llenarIndicadorFiltroEstadistica(sector) {
    filtro = '<div class="filtro_princ naranja_secun">\
                <div class="form-group">\
                    <label for="listInstrumentoEstadistica" class="col-form-label">Instrumento de Planeamiento : </label></br>\
                    <select class="select-form" id="listInstrumentoEstadistica"></select>\
                </div>\
                <div class="form-group">\
                    <label for="listIndicadoresEstadistica" class="col-form-label">Indicador Regional : </label></br>\
                    <select class="select-form" id="listIndicadoresEstadistica"></select>\
                </div>\n\
                <div id="divIndiContenidoEstadistica"></div>\
              </div>';
    $("#divIndiEstadistica").append(filtro);

    llenarInstrumentosEstadistica(sector);

}

function llenarInstrumentosEstadistica(sector) {
    $.ajax({
        dataType: 'json',
        url: "./Estadistica?url=instrumentos&sector=" + sector,
        success: function (response) {

            $("#listInstrumentoEstadistica").append('<option value="00">--TODOS--</option>');

            $.each(response.listInstrumentos, function (index, value) {
                var inst = '<option value=' + value.instId + '>' + value.instNombre + ' (' + value.instSigla + ')</option>';
                $("#listInstrumentoEstadistica").append(inst);
            });

            llenarIndicadoresEstadistica(response.sector, $("#listInstrumentoEstadistica").val());

            $("#listInstrumentoEstadistica").bind("change", function () {
                $("#listIndicadoresEstadistica").empty();
                $("#divIndiContenidoEstadistica").empty();
                var instrumento = $("#listInstrumentoEstadistica").val();
                llenarIndicadoresEstadistica(response.sector, instrumento);
            });
        }
    });
}

function llenarIndicadoresEstadistica(sector, instrumento) {
    $.ajax({
        dataType: 'json',
        url: "./Estadistica?url=indicadores&sector=" + sector + "&instrumento=" + instrumento,
        success: function (response) {

            $("#listIndicadoresEstadistica").append('<option value="00">--SELECCIONE INDICADOR--</option>');

            $.each(response.listIndicadores, function (index, value) {
                var indiCodigo, indiNombre, indiSigla;
                if (!$.trim(value.indiCodigo)) {
                    indiCodigo = "";
                } else {
                    indiCodigo = value.indiCodigo + " - ";
                }
                if (!$.trim(value.indiNombre)) {
                    indiNombre = "";
                } else {
                    indiNombre = value.indiNombre;
                }
                if (!$.trim(value.indiSigla)) {
                    indiSigla = "";
                } else {
                    indiSigla = " (" + value.indiSigla + ")";
                }
                var indi = '<option value=' + value.indiId + '>' + indiCodigo + indiNombre + indiSigla + '</option>';
                $("#listIndicadoresEstadistica").append(indi);
            });


            $("#listIndicadoresEstadistica").bind("change", function () {
                $("#divIndiContenidoEstadistica").empty();
                var indi = $("#listIndicadoresEstadistica").val();
                llenarIndiContenidoEstadistica(indi);
            });
        }
    });
}

function llenarIndiContenidoEstadistica(indi) {
    $.ajax({
        dataType: 'json',
        url: "./Estadistica?url=indicador&indi=" + indi,
        success: function (response) {
            var cont = '<div class="form-group">\
                          <label class="col-form-label">Descargas :</label>\
                          <div>\
                            <a id="aIndiFichaEstadistica" class="hRef">\
                              <img src="./resources/images/ficha_tecnica.png">\
                            </a>\
                          </div>\
                        </div>\
                        <ul class="nav nav-tabs" role="tablist">\
                          <li class="nav-item active">\
                            <a id="aIndiTableroEstadistica" class="nav-link active show" data-toggle="tab" href="#divIndiTableroEstadistica" role="tab" aria-selected="true">\
                              <span class="hidden-sm-up"><i class="ti-home"></i></span>\
                              <span class="hidden-xs-down">Tablero de Control</span>\
                            </a>\
                          </li>\
                          <li class="nav-item">\
                            <a id="aIndiDataEstadistica" class="nav-link" data-toggle="tab" href="#divIndiDataEstadistica" role="tab" aria-selected="false">\
                              <span class="hidden-sm-up"><i class="ti-user"></i></span>\
                              <span class="hidden-xs-down">Datos Dinámicos</span>\
                            </a>\
                          </li>\
                        </ul>\
                        <div class="tab-content tabcontent-border fondo-tab">\
                          <div class="tab-pane active" id="divIndiTableroEstadistica" role="tabpanel"></div>\
                          <div class="tab-pane" id="divIndiDataEstadistica" role="tabpanel"></div>\
                        </div>';
            $("#divIndiContenidoEstadistica").append(cont);

            llenarIndiTableroEstadistica(response);
            //llenarIndiDataEstadistica(response);

        }
    });
}

function llenarIndiTableroEstadistica(response) {
    var tabl = '<div class="pad-tablero">\
                  <div class="form-group row">\
                    <div class="col-sm-12">\
                      <div class="indicador_var_prin">\
                        <label for="listIndiVarP" class="col-sm-2 col-form-label">' + variable_principal + ' :</label>\
                        <div class="col-sm-6">\
                          <select class="select-form" id="listIndiVarP"></select>\
                        </div>\
                      </div>\
                    </div>\
                  </div>\
                  <div class="form-group row">\
                    <div class="col-sm-9">\
                      <div class="indicador_nombre">\
                        <b>' + tipo_indicador + ' :</b></br>\
                        ' + indi_nombre + '\
                      </div>\
                    </div>\
                    <div class="col-sm-3">\
                      <div class="indicador_medicion">\
                        <b>Medición </b>(' + unidad_medida + ') :\
                        <div>\
                          <span id="spanMedicion"></span>\
                        </div>\
                      </div>\
                    </div>\
                  </div>\
                  <div id="divIndiTablero"></div>\
                </div>';
    $("#divIndiTableroEstadistica").append(tabl);
}