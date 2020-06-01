// Llenar Centros de Costo y Metas

function llenar_registro_info_proyecto_alert() {
    alert("funciona llenar Registro de Información de Proyectos");
}

function llenar_registro_info_proyecto(selectProy) {

    $("#divContenidoMenu").empty();
    var cont_reg = '<section id="section_proyectos" class="background_sirsam_">\
                        <div class="menu_indice">\
                          <div class ="container">\
                            <ol class="breadcrumb">\
                              <li>\
                                <a>\
                                  <i class="choose-icon ion-cube" style="color: black; font-size: 15px;"></i> Inversión Pública\
                                </a>\
                              </li>\
                              <li><i class="fa fa-database"></i> Registro de Información de Proyectos</li>\
                            </ol>\
                          </div>\
                        </div>\
                        <br>\
                        <div class="container">\
                            <a id="aReturnRegInfoProyecto" style="cursor: pointer;">\
                               <div class="naranja_secun boton-superior1 pad15" style="cursor: pointer;">\
                                  <span class="glyphicon glyphicon-backward"></span> REGRESAR\
                               </div>\
                            </a>\
                            <div id="divBusqRegProyecto" class="filtro_princ naranja_secun">\
                                <label class="titulo">REGISTRO DE INFORMACIÓN DE PROYECTOS</label>\
                                <form id="formBusqRegProyecto" method="post">\
                                    <div class="form-group">\
                                        <label class="col-form-label">Ingrese el código del Proyecto :</label>\
                                    </div>\
                                    <div class="form-group row">\
                                        <div class="form-check col-sm-2">\
                                            <input id="iptBtnCodSiaf" type="radio" name="radCod" value="siaf" checked>\
                                            <label id="lblCodSiaf" for="iptCodSiaf" class="form-check-label hRef1">\
                                                Código SIAF\
                                            </label>\
                                        </div>\
                                        <div class="col-sm-2">\
                                            <input id="iptCodSiaf" type="text" class="form-control" maxlength="7" name="codigo_siaf" onkeypress="return soloNumeroEnter(event)">\
                                        </div>\
                                    </div>\
                                    <div class="form-group row">\
                                        <div class="form-check col-sm-2">\
                                            <input id="iptBtnCodSnip" type="radio" name="radCod" value="snip">\
                                            <label id="lblCodSnip" for="iptCodSnip" class="form-check-label hRef1">\
                                                Código SNIP\
                                            </label>\
                                        </div>\
                                        <div class="col-sm-2">\
                                            <input id="iptCodSnip" type="text" class="form-control" maxlength="8" name="codigo_snip" onkeypress="return soloNumeroEnter(event)" disabled>\
                                        </div>\
                                    </div>\
                                    <div class="form-row">\
                                        <label class="col-sm-2"></label>\
                                        <div class="col-auto">\
                                            <button type="submit" class="btn btn3d btn-danger btn-m">\
                                                <span class="glyphicon glyphicon-search spanBtn"></span>Buscar\
                                            </button>\
                                        </div>\
                                        <div class="col-auto">\
                                            <button id="btnLimpRegProy" type="button" value="Reset" class="btn btn3d btn-white btn-m">\
                                                <span class="glyphicon glyphicon-erase spanBtn"></span>Limpiar\
                                            </button>\
                                        </div>\
                                    </div>\
                                </form>\
                                <br>\
                            </div>\
                            <br>\
                            <div id="divRegInfoProyecto" class="filtro_princ naranja_secun"></div>\
                        </div>\
                    </section>';
    $("#divContenidoMenu").append(cont_reg);
    $("#aReturnRegInfoProyecto").on('click', function () {
        llenar_menu_proyectos(selectProy);
    });
    controlBusqCodProy();
    eventFormBusqRegProyecto();
}

function controlBusqCodProy() {

    $("#iptBtnCodSiaf").on('click', function () {
        $("#iptCodSiaf").prop("disabled", false);
        $("#iptCodSiaf").focus();
        $("#iptCodSnip").prop("disabled", true);
    });
    $("#lblCodSiaf").on('click', function () {
        $("#iptBtnCodSiaf").prop("checked", true);
        $("#iptBtnCodSnip").prop("checked", false);
        $("#iptCodSiaf").prop("disabled", false);
        $("#iptCodSnip").prop("disabled", true);
    });
    $("#iptBtnCodSnip").on('click', function () {
        $("#iptCodSiaf").prop("disabled", true);
        $("#iptCodSnip").prop("disabled", false);
        $("#iptCodSnip").focus();
    });
    $("#lblCodSnip").on('click', function () {
        $("#iptBtnCodSiaf").prop("checked", false);
        $("#iptBtnCodSnip").prop("checked", true);
        $("#iptCodSiaf").prop("disabled", true);
        $("#iptCodSnip").prop("disabled", false);
    });
    $("#btnLimpRegProy").on('click', function () {
        $("#iptBtnCodSiaf").prop("checked", true);
        $("#iptBtnCodSnip").prop("checked", false);
        $("#iptCodSiaf").val('');
        $("#iptCodSnip").val('');
        $("#iptCodSiaf").prop("disabled", false);
        $("#iptCodSnip").prop("disabled", true);
        $("#divRegInfoProyecto").empty();
    });
}

function eventFormBusqRegProyecto() {
    $("#formBusqRegProyecto").submit(function (evt) {
        var action = "./Proyectos?tipo=00";
        $("#formBusqRegProyecto").attr("action", action);
        toastr.options.closeButton = true;
        toastr.options.timeOut = 2500;
        if (validaRegInfoProyecto() === "OK") {
            evt.preventDefault();
            $("#divRegInfoProyecto").empty();
            gif = '<img src="./resources/gifs/cargando.gif" style="display:block; margin:auto;"></img>';
            $("#divInfoProyectos").append(gif);
            $.ajax({
                dataType: 'json',
                type: 'post',
                url: $(this).attr("action"),
                data: $(this).serialize(),
                success: function (response) {
                    $("#divRegInfoProyecto").empty();
                    llenarRegInfoProyecto(response);
                }
            });
        } else {
            toastr.options.positionClass = "toast-middle-center";
            toastr.warning(validaRegInfoProyecto(), 'Búsqueda');
            evt.preventDefault();
            $("#divRegInfoProyecto").empty();
        }
    });
}

function validaRegInfoProyecto() {
    var msg;
    if ($("#iptBtnCodSiaf").prop("checked")) {
        var cod = $("#iptCodSiaf").val();
        if (cod === "") {
            msg = "La casilla está en blanco!!. Debe ingresar el código SIAF";
            return(msg);
        } else {
            var l = cod.length;
            if (l < 7) {
                msg = "Los códigos SIAF son de 07 dígitos. Ingrese el código correctamente!!";
                return(msg);
            } else {
                msg = "OK";
                return(msg);
            }
        }
    }
    if ($("#iptBtnCodSnip").prop("checked")) {
        var cod = $("#iptCodSnip").val();
        if (cod === "") {
            msg = "La casilla está en blanco!!. Debe ingresar el código SNIP";
            return(msg);
        } else {
            msg = "OK";
            return(msg);
        }
    }
    msg = "OK";
    return(msg);
}

function llenarRegInfoProyecto(response) {

    if (response.proyecEstado) {
        var codSiaf = response.proyecCodSiaf;
        general = '<div id="divGenRegInfoProy" class="pad15">\
                    <div class="form-group row">\
                        <label class="col-sm-2 col-form-label ficha-sombreado1">CODIGO SIAF :</label>\
                        <label class="col-sm-3 col-form-label ficha-sombreado2">' + codSiaf + '</label>\
                        <label class="col-sm-2"></label>\
                        <label class="col-sm-2 col-form-label ficha-sombreado1">CODIGO SNIP :</label>\
                        <label class="col-sm-3 col-form-label ficha-sombreado2">' + response.proyecCodInv + '</label>\
                    </div>\
                    <div class="form-group row">\
                        <label class="col-sm-2 col-form-label ficha-sombreado1">NOMBRE PROYECTO :</label>\
                        <label class="col-sm-10 col-form-label ficha-sombreado2">' + response.proyecNombre + '</label>\
                    </div>\
                   </div>';
        var estudioFecha, estudioDocumento, estudioContrato, estudioResponsable;
        if (response.estudioEstado) {
            if (!$.trim(response.estudioFecha)) {
                estudioFecha = "";
            } else {
                estudioFecha = response.estudioFecha;
            }
            estudioDocumento = response.estudioDocumento;
            estudioContrato = response.estudioContrato;
            estudioResponsable = response.estudioResponsable;
        } else {
            estudioFecha = "";
            estudioDocumento = "";
            estudioContrato = "";
            estudioResponsable = "";
        }
        var etapaEst = response.etapaEst;
        estudio = '<div id="divEstRegInfoProy" class="border-gris">\
                    <form id="formRegInfoProyecto1_1" action="./Proyectos?tipo=00_1_1&cod_siaf=' + codSiaf + '" method="post">\
                      <div id="divEstRegInfoProyTit" class="pad10 ficha-sombreado1">\
                        <label>1.- <label class="underline">ESTUDIO DEFINITIVO</label></label>&nbsp;&nbsp;\
                        <button id="btnShowEstRegInfoProyCont" type="button" class="btn btn-default btn-m" data-toggle="tooltip" data-placement="bottom" title="Mostrar">\
                           <span class="glyphicon glyphicon-eye-open"></span>\
                        </button>&nbsp;\
                        <button id="btnSaveEstRegInfoProyCont" type="submit" class="btn btn-primary btn-m" data-toggle="tooltip" data-placement="bottom" title="Guardar" disabled>\
                           <span class="glyphicon glyphicon-save"></span>\
                        </button>&nbsp;\
                        <span id="divCheckEstRegInfoProyCont"></span>\
                      </div>\
                      <div id="divEstRegInfoProyCont" class="pad10">\
                       <div id="divEstRegInfoProyCont1">\
                        <div class="form-group row">\
                            <label for="iptEstudFecha" class="col-sm-3 col-form-label">Fecha de Aprobación :</label>\
                            <div class="col-sm-3">\
                                <input name="estudFecha" id="iptEstudFecha" type="date" class="col-form-date" data-date-format="dd/mm/yyyy" value="' + estudioFecha + '" required>\
                            </div>\
                        </div>\
                        <div class="form-group row">\
                            <label for="iptEstudDoc" class="col-sm-3 col-form-label">Documento de Aprobación :</label>\
                            <div class="col-sm-4">\
                                <input name="estudDoc" id="iptEstudDoc" type="text" class="form-control uppercase" value="' + estudioDocumento + '" required>\
                            </div>\
                        </div>\
                        <div class="form-group row">\
                            <label for="iptEstudCont" class="col-sm-3 col-form-label">Contrato :</label>\
                            <div class="col-sm-7">\
                                <input name="estudCont" id="iptEstudCont" type="text" class="form-control uppercase" value="' + estudioContrato + '" required>\
                            </div>\
                        </div>\
                        <div class="form-group row">\
                            <label for="iptEstudResp" class="col-sm-3 col-form-label">Responsable de Elaboración :</label>\
                            <div class="col-sm-7">\
                                <input name="estudResp" id="iptEstudResp" type="text" class="form-control uppercase" value="' + estudioResponsable + '">\
                            </div>\
                        </div>\
                       </div>\
                    </form>\
                    <div id="divEstRegInfoProyCont2" style="overflow-x:auto;">\
                        <form id="formRegInfoProyecto1_2" action="./Proyectos?tipo=00_1_2&cod_siaf=' + codSiaf + '&etapa_est=' + etapaEst + '" method="post">\
                            <label class="col-form-label">ETAPAS</label>\
                            <table id="tableEstRegInfoProyCont1" class="display" cellspacing="0" width="100%">\
                              <thead>\
                                <tr>\
                                  <th style="text-align: center; width: 35px;">Etapa</th>\
                                  <th style="text-align: center; width: 129px;">Fecha Aprobación</th>\
                                  <th style="text-align: center;">Documento Aprobación</th>\
                                  <th style="text-align: center; width: 200px;">Contrato</th>\
                                  <th style="text-align: center; width: 200px;">Responsable Elaboración</th>\
                                  <th style="text-align: center; width: 100px;">Acción</th>\
                                </tr>\
                              </thead>\
                              <tbody>\
                                <tr>\
                                  <td id="tdEstRegInfoProy" style="text-align: center;">' + etapaEst + '</td>\
                                  <td style="text-align: center;">\
                                    <input name="etapaEstFecha" type="date" class="col-form-date" data-date-format="dd/mm/yyyy" required>\
                                  </td>\
                                  <td style="text-align: left;">\
                                    <input name="etapaEstDocu" type="text" class="form-control uppercase" required>\
                                  </td>\
                                  <td style="text-align: left;">\
                                    <input name="etapaEstCont" type="text" class="form-control uppercase" required>\
                                  </td>\
                                  <td style="text-align: left;">\
                                    <input name="etapaEstResp" type="text" class="form-control uppercase" required>\
                                  </td>\
                                  <td style="text-align: center;">\
                                    <button type="submit" id="btnAddEtaEstRegInfoProy" title="Añadir" class="btn btn-success btn-sm">\
                                      <i class="fa fa-plus"></i>\
                                    </button>\
                                  </td>\
                                </tr>\
                              </tbody>\
                            </table>\
                        </form>\
                        <form id="formRegInfoProyecto1_3" method="post">\
                            <table id="tableEstRegInfoProyCont2" class="display" cellspacing="0" width="100%">\
                              <thead>\
                                <tr>\
                                  <th style="text-align: center; width: 35px;">Etapa</th>\
                                  <th style="text-align: center; width: 129px;">Fecha Aprobación</th>\
                                  <th style="text-align: center;">Documento Aprobación</th>\
                                  <th style="text-align: center; width: 200px;">Contrato</th>\
                                  <th style="text-align: center; width: 200px;">Responsable Elaboración</th>\
                                  <th style="text-align: center; width: 100px;">Acción</th>\
                                </tr>\
                              </thead>\
                              <tbody id="tableEstRegInfoProyCont2Body"></tbody>\
                            </table></br>\
                        </form>\
                    </div>\
                    </div>\
                   </div></br>';
        var supervProceso, supervContrato, supervFechaCont, supervMontoCont, supervProveedor, supervModalidad,
                supervSuperNombre, supervSuperCelular, supervCoordNombre, supervCoordCelular, supervAdminNombre,
                supervAdminCelular, supervFechaInicio, supervFechaFin, supervTieneAdelanto;
        if (response.supervEstado) {
            supervProceso = response.supervProceso;
            supervContrato = response.supervContrato;
            if (!$.trim(response.supervFechaCont)) {
                supervFechaCont = "";
            } else {
                supervFechaCont = response.supervFechaCont;
            }
            if (!$.trim(response.supervMontoCont)) {
                supervMontoCont = "";
            } else {
                supervMontoCont = formatNumeroNoComa(response.supervMontoCont);
            }
            supervProveedor = response.supervProveedor;
            supervModalidad = response.supervModalidad;
            supervSuperNombre = response.supervSuperNombre;
            supervSuperCelular = response.supervSuperCelular;
            supervCoordNombre = response.supervCoordNombre;
            supervCoordCelular = response.supervCoordCelular;
            supervAdminNombre = response.supervAdminNombre;
            supervAdminCelular = response.supervAdminCelular;
            if (!$.trim(response.supervFechaInicio)) {
                supervFechaInicio = "";
            } else {
                supervFechaInicio = response.supervFechaInicio;
            }
            if (!$.trim(response.supervFechaFin)) {
                supervFechaFin = "";
            } else {
                supervFechaFin = response.supervFechaFin;
            }
            if (response.supervTieneAdelanto) {
                supervTieneAdelanto = "checked";
            } else {
                supervTieneAdelanto = "";
            }
        } else {
            supervProceso = "";
            supervContrato = "";
            supervFechaCont = "";
            supervMontoCont = "";
            supervProveedor = "";
            supervModalidad = "";
            supervSuperNombre = "";
            supervSuperCelular = "";
            supervCoordNombre = "";
            supervCoordCelular = "";
            supervAdminNombre = "";
            supervAdminCelular = "";
            supervFechaInicio = "";
            supervFechaFin = "";
            supervTieneAdelanto = "";
        }
        var supervAdela = response.supervAdela;
        var supervChecked;
        if (response.proyecSupervision) {
            supervChecked = "checked";
        } else {
            supervChecked = "";
        }
        supervision = '<div id="divSupRegInfoProy" class="border-gris">\
                        <form id="formRegInfoProyecto2" action="./Proyectos?tipo=00_2&cod_siaf=' + codSiaf + '" method="post">\
                        <div id="divSupRegInfoProyTit" class="pad10 ficha-sombreado1">\
                            <label>2.- <label class="underline">SUPERVISIÓN</label></label>&nbsp;&nbsp;\
                            <button id="btnShowSupRegInfoProyCont" type="button" class="btn btn-default btn-m" data-toggle="tooltip" data-placement="bottom" title="Mostrar">\
                               <span class="glyphicon glyphicon-eye-open"></span>\
                            </button>&nbsp;\
                            <button id="btnSaveSupRegInfoProyCont" type="submit" class="btn btn-primary btn-m" data-toggle="tooltip" data-placement="bottom" title="Guardar" disabled>\
                               <span class="glyphicon glyphicon-save"></span>\
                            </button>&nbsp;\
                            <span id="divCheckSupRegInfoProyCont"></span>\
                        </div>\
                        <div id="divSupRegInfoProyCont" class="pad10">\
                          <div id="divSupRegInfoProyCont1">\
                            <div class="form-group row">\
                              <div class="col-sm-3 fontweight6">\
                                <label class="custom-control custom-checkbox">\
                                  <input type="checkbox" class="custom-control-input" name="tieneSuper" value="ok" ' + supervChecked + '>\
                                  <span class="custom-control-indicator"></span>&nbsp;&nbsp;\
                                  <span class="custom-control-description">Cuenta con supervisión</span>\
                                </label>\
                              </div>\
                            </div>\
                          </div>\
                          <div id="divSupRegInfoProyCont2">\
                            <div class="form-group row">\
                              <label for="iptSuperProc" class="col-sm-3 col-form-label">Proceso :</label>\
                              <div class="col-sm-7">\
                                <input name="superProc" id="iptSuperProc" type="text" class="form-control uppercase" value="' + supervProceso + '" >\
                              </div>\
                            </div>\
                            <div class="form-group row">\
                              <label for="iptSuperCont" class="col-sm-3 col-form-label">Contrato :</label>\
                              <div class="col-sm-7">\
                                <input name="superCont" id="iptSuperCont" type="text" class="form-control uppercase" value="' + supervContrato + '" >\
                              </div>\
                            </div>\
                            <div class="form-group row">\
                              <label for="iptSuperFechaCont" class="col-sm-3 col-form-label">Fecha Firma de Contrato :</label>\
                              <div class="col-sm-3">\
                                <input name="superFechaCont" id="iptSuperFechaCont" type="date" class="col-form-date" data-date-format="dd/mm/yyyy" value="' + supervFechaCont + '">\
                              </div>\
                            </div>\
                            <div class="form-group row">\
                              <label for="iptSuperMontoCont" class="col-sm-3 col-form-label">Monto Contratado :</label>\
                              <div class="col-sm-3">\
                                <input name="superMontoCont" id="iptSuperMontoCont" type="text" class="form-control" value="' + supervMontoCont + '" onkeypress="return soloNumDecimal(event, this.value)">\
                              </div>\
                            </div>\
                            <div class="form-group row">\
                              <label for="iptSuperProv" class="col-sm-3 col-form-label">Proveedor :</label>\
                              <div class="col-sm-7">\
                                <input name="superProv" id="iptSuperProv" type="text" class="form-control uppercase" value="' + supervProveedor + '">\
                              </div>\
                            </div>\
                            <div class="form-group row">\
                              <label for="iptSuperModa" class="col-sm-3 col-form-label">Modalidad de Contrato :</label>\
                              <div class="col-sm-7">\
                                <input name="superModa" id="iptSuperModa" type="text" class="form-control uppercase" value="' + supervModalidad + '">\
                              </div>\
                            </div>\
                            <div class="form-group row">\
                              <label for="iptSuperSupNom" class="col-sm-3 col-form-label">Supervisor de Obra :</label>\
                              <div class="col-sm-6">\
                                <input name="superSupNom" id="iptSuperSupNom" type="text" class="form-control uppercase" value="' + supervSuperNombre + '">\
                              </div>\
                            </div>\
                            <div class="form-group row">\
                              <label for="iptSuperSupCel" class="col-sm-3 col-form-label">Celular de Supervisor :</label>\
                              <div class="col-sm-3">\
                                <input name="superSupCel" id="iptSuperSupCel" type="text" class="form-control" maxlength="9" value="' + supervSuperCelular + '" onkeypress="return soloNumero(event)">\
                              </div>\
                            </div>\
                            <div class="form-group row">\
                              <label for="iptSuperCoorNom" class="col-sm-3 col-form-label">Coordinador de Obra :</label>\
                              <div class="col-sm-6">\
                                <input name="superCoorNom" id="iptSuperCoorNom" type="text" class="form-control uppercase" value="' + supervCoordNombre + '">\
                              </div>\
                            </div>\
                            <div class="form-group row">\
                              <label for="iptSuperCoorCel" class="col-sm-3 col-form-label">Celular de Coordinador :</label>\
                              <div class="col-sm-3">\
                                <input name="superCoorCel" id="iptSuperCoorCel" type="text" class="form-control" maxlength="9" value="' + supervCoordCelular + '" onkeypress="return soloNumero(event)">\
                              </div>\
                            </div>\
                            <div class="form-group row">\
                              <label for="iptSuperAdmNom" class="col-sm-3 col-form-label">Administrador de Contrato :</label>\
                              <div class="col-sm-6">\
                                <input name="superAdmNom" id="iptSuperAdmNom" type="text" class="form-control uppercase" value="' + supervAdminNombre + '">\
                              </div>\
                            </div>\
                            <div class="form-group row">\
                              <label for="iptSuperAdmCel" class="col-sm-3 col-form-label">Celular de Administrador :</label>\
                              <div class="col-sm-3">\
                                <input name="superAdmCel" id="iptSuperAdmCel" type="text" class="form-control" maxlength="9" value="' + supervAdminCelular + '" onkeypress="return soloNumero(event)">\
                              </div>\
                            </div>\
                            <div class="form-group row">\
                              <label for="iptSuperFechaIni" class="col-sm-3 col-form-label">Fecha de Inicio Supervisión :</label>\
                              <div class="col-sm-3">\
                                <input name="superFechaIni" id="iptSuperFechaIni" type="date" class="col-form-date" data-date-format="dd/mm/yyyy" value="' + supervFechaInicio + '">\
                              </div>\
                            </div>\
                            <div class="form-group row">\
                              <label for="iptSuperFechaFin" class="col-sm-3 col-form-label">Fecha de Fin Supervisión :</label>\
                              <div class="col-sm-3">\
                                <input name="superFechaFin" id="iptSuperFechaFin" type="date" class="col-form-date" data-date-format="dd/mm/yyyy" value="' + supervFechaFin + '">\
                              </div>\
                            </div>\
                            <div class="form-group row">\
                              <div class="col-sm-3 fontweight6">\
                                <label class="custom-control custom-checkbox">\
                                    <input type="checkbox" class="custom-control-input" name="superTieneAdela" value="ok" ' + supervTieneAdelanto + '>\
                                    <span class="custom-control-indicator"></span>&nbsp;&nbsp;\
                                    <span class="custom-control-description">¿Recibió Adelanto?</span>\
                                </label>\
                              </div>\
                            </div>\
                        </form>\
                            <div id="divSuperAdela" style="overflow-x:auto;">\
                              <form id="formRegInfoProyecto2_1" action="./Proyectos?tipo=00_2_1&cod_siaf=' + codSiaf + '&super_adela=' + supervAdela + '" method="post">\
                                <label class="col-form-label">ADELANTOS</label>\
                                <table id="tableSupRegInfoProyCont1" class="display" cellspacing="0" width="100%">\
                                  <thead>\
                                    <tr>\
                                      <th style="text-align: center; width: 80px;">Número</th>\
                                      <th style="text-align: center; width: 160px;">Adelanto</th>\
                                      <th style="text-align: center; width: 129px;">Fecha</th>\
                                      <th style="text-align: center;">Comentario</th>\
                                      <th style="text-align: center; width: 100px;">Acción</th>\
                                    </tr>\
                                  </thead>\
                                  <tbody>\
                                    <tr>\
                                      <td id="tdSupRegInfoProy" style="text-align: center;">' + supervAdela + '</td>\
                                      <td style="text-align: center;">\
                                        <input name="superMontoAdela" type="text" class="form-control" onkeypress="return soloNumDecimal(event, this.value)" required>\
                                      </td>\
                                      <td style="text-align: center;">\
                                        <input name="superFechaAdela" type="date" class="col-form-date" data-date-format="dd/mm/yyyy" required>\
                                      </td>\
                                      <td style="text-align: left;">\
                                        <textarea name="superComentAdela" rows="2" class="form-control no-resize" form="formRegInfoProyecto2_1" />\
                                      </td>\
                                      <td style="text-align: center;">\
                                        <button type="submit" id="btnAddSupRegInfoProy" title="Añadir" class="btn btn-success btn-sm">\
                                          <i class="fa fa-plus"></i>\
                                        </button>\
                                      </td>\
                                    </tr>\
                                  </tbody>\
                                </table>\
                              </form>\
                              <form id="formRegInfoProyecto2_3" method="post">\
                                <table id="tableSupRegInfoProyCont2" class="display" cellspacing="0" width="100%">\
                                  <thead>\
                                    <tr>\
                                      <th style="text-align: center; width: 80px;">Número</th>\
                                      <th style="text-align: center; width: 160px;">Adelanto</th>\
                                      <th style="text-align: center; width: 129px;">Fecha</th>\
                                      <th style="text-align: center;">Comentario</th>\
                                      <th style="text-align: center; width: 100px;">Acción</th>\
                                    </tr>\
                                  </thead>\
                                  <tbody id="tableSupRegInfoProyCont2Body"></tbody>\
                                  <tfoot id="tableSupRegInfoProyCont2Foot"></tfoot>\
                                </table></br>\
                              </form>\
                            </div>\n\
                          </div>\
                        </div>\
                      </div></br>';
        var ejecuProceso, ejecuContrato, ejecuFechaCont, ejecuMontoCont, ejecuProveedor, ejecuModalidad,
                ejecuResidNombre, ejecuResidCelular, ejecuFechaTerreno, ejecuPlazo, ejecuFechaInicio,
                ejecuTieneAdelantoDirec, ejecuTieneAdelantoMater;
        if (response.ejecuEstado) {
            ejecuProceso = response.ejecuProceso;
            ejecuContrato = response.ejecuContrato;
            if (!$.trim(response.ejecuFechaCont)) {
                ejecuFechaCont = "";
            } else {
                ejecuFechaCont = response.ejecuFechaCont;
            }
            if (!$.trim(response.ejecuMontoCont)) {
                ejecuMontoCont = "";
            } else {
                ejecuMontoCont = formatNumeroNoComa(response.ejecuMontoCont);
            }
            ejecuProveedor = response.ejecuProveedor;
            ejecuModalidad = response.ejecuModalidad;
            ejecuResidNombre = response.ejecuResidNombre;
            ejecuResidCelular = response.ejecuResidCelular;
            if (!$.trim(response.ejecuFechaTerreno)) {
                ejecuFechaTerreno = "";
            } else {
                ejecuFechaTerreno = response.ejecuFechaTerreno;
            }
            if (!$.trim(response.ejecuPlazo)) {
                ejecuPlazo = "";
            } else {
                ejecuPlazo = formatNumeroEnteroNoComa(response.ejecuPlazo);
            }
            if (!$.trim(response.ejecuFechaInicio)) {
                ejecuFechaInicio = "";
            } else {
                ejecuFechaInicio = response.ejecuFechaInicio;
            }
            if (response.ejecuTieneAdelantoDirec) {
                ejecuTieneAdelantoDirec = "checked";
            } else {
                ejecuTieneAdelantoDirec = "";
            }
            if (response.ejecuTieneAdelantoMater) {
                ejecuTieneAdelantoMater = "checked";
            } else {
                ejecuTieneAdelantoMater = "";
            }
        } else {
            ejecuProceso = "";
            ejecuContrato = "";
            ejecuFechaCont = "";
            ejecuMontoCont = "";
            ejecuProveedor = "";
            ejecuModalidad = "";
            ejecuResidNombre = "";
            ejecuResidCelular = "";
            ejecuFechaTerreno = "";
            ejecuPlazo = "";
            ejecuFechaInicio = "";
            ejecuTieneAdelantoDirec = "";
            ejecuTieneAdelantoMater = "";
        }
        var ejecuAdelaDirNro = response.ejecuAdelaDirNro;
        var ejecuAdelaMatNro = response.ejecuAdelaMatNro;
        ejecucion = '<div id="divEjecRegInfoProy" class="border-gris">\
                        <form id="formRegInfoProyecto3" action="./Proyectos?tipo=00_3&cod_siaf=' + codSiaf + '" method="post">\
                            <div id="divEjecRegInfoProyTit" class="pad10 ficha-sombreado1">\
                                <label>3.- <label class="underline">EJECUCIÓN</label></label>&nbsp;&nbsp;\
                                <button id="btnShowEjecRegInfoProyCont" type="button" class="btn btn-default btn-m" data-toggle="tooltip" data-placement="bottom" title="Mostrar">\
                                   <span class="glyphicon glyphicon-eye-open"></span>\
                                </button>&nbsp;\
                                <button id="btnSaveEjecRegInfoProyCont" type="submit" class="btn btn-primary btn-m" data-toggle="tooltip" data-placement="bottom" title="Guardar" disabled>\
                                   <span class="glyphicon glyphicon-save"></span>\
                                </button>&nbsp;\
                                <span id="divCheckEjecRegInfoProyCont"></span>\
                            </div>\
                            <div id="divEjecRegInfoProyCont" class="pad10">\
                                <div class="form-group row">\
                                 <label for="iptEjecProc" class="col-sm-3 col-form-label">Proceso :</label>\
                                 <div class="col-sm-7">\
                                     <input name="ejecProc" id="iptEjecProc" type="text" class="form-control uppercase" value="' + ejecuProceso + '" required>\
                                 </div>\
                                </div>\
                                <div class="form-group row">\
                                 <label for="iptEjecCont" class="col-sm-3 col-form-label">Contrato :</label>\
                                 <div class="col-sm-7">\
                                     <input name="ejecCont" id="iptEjecCont" type="text" class="form-control uppercase" value="' + ejecuContrato + '" required>\
                                 </div>\
                                </div>\
                                <div class="form-group row">\
                                 <label for="iptEjecFechaCont" class="col-sm-3 col-form-label">Fecha Firma de Contrato :</label>\
                                 <div class="col-sm-3">\
                                     <input name="ejecFechaCont" id="iptEjecFechaCont" type="date" class="col-form-date" data-date-format="dd/mm/yyyy" value="' + ejecuFechaCont + '" required>\
                                 </div>\
                                </div>\
                                <div class="form-group row">\
                                 <label for="iptEjecMontoCont" class="col-sm-3 col-form-label">Monto Contratado :</label>\
                                 <div class="col-sm-3">\
                                     <input name="ejecMontoCont" id="iptEjecMontoCont" type="text" class="form-control" value="' + ejecuMontoCont + '" onkeypress="return soloNumDecimal(event, this.value)" required>\
                                 </div>\
                                </div>\
                                <div class="form-group row">\
                                 <label for="iptEjecProv" class="col-sm-3 col-form-label">Proveedor :</label>\
                                 <div class="col-sm-7">\
                                     <input name="ejecProv" id="iptEjecProv" type="text" class="form-control uppercase" value="' + ejecuProveedor + '" required>\
                                 </div>\
                                </div>\
                                <div class="form-group row">\
                                 <label for="iptEjecModa" class="col-sm-3 col-form-label">Modalidad de Contrato :</label>\
                                 <div class="col-sm-7">\
                                     <input name="ejecModa" id="iptEjecModa" type="text" class="form-control uppercase" value="' + ejecuModalidad + '" required>\
                                 </div>\
                                </div>\
                                <div class="form-group row">\
                                 <label for="iptEjecResiNom" class="col-sm-3 col-form-label">Residente de Obra :</label>\
                                 <div class="col-sm-6">\
                                     <input name="ejecResiNom" id="iptEjecResiNom" type="text" class="form-control uppercase" value="' + ejecuResidNombre + '">\
                                 </div>\
                                </div>\
                                <div class="form-group row">\
                                 <label for="iptEjecResiCel" class="col-sm-3 col-form-label">Celular de Residente :</label>\
                                 <div class="col-sm-3">\
                                     <input name="ejecResiCel" id="iptEjecResiCel" type="text" class="form-control" maxlength="9" value="' + ejecuResidCelular + '" onkeypress="return soloNumero(event)">\
                                 </div>\
                                </div>\
                                <div class="form-group row">\
                                 <label for="iptEjecFechaTerre" class="col-sm-3 col-form-label">Fecha entrega de Terreno :</label>\
                                 <div class="col-sm-3">\
                                     <input name="ejecFechaTerre" id="iptEjecFechaTerre" type="date" class="col-form-date" data-date-format="dd/mm/yyyy" value="' + ejecuFechaTerreno + '" required>\
                                 </div>\
                                </div>\
                                <div class="form-group row">\
                                 <label for="iptEjecFechaIni" class="col-sm-3 col-form-label">Fecha de Inicio Obra :</label>\
                                 <div class="col-sm-3">\
                                     <input name="ejecFechaIni" id="iptEjecFechaIni" type="date" class="col-form-date" data-date-format="dd/mm/yyyy" value="' + ejecuFechaInicio + '" required>\
                                 </div>\
                                </div>\
                                <div class="form-group row">\
                                 <label for="iptEjecPlazo" class="col-sm-3 col-form-label">Plazo de Ejecución Obra :</label>\
                                 <div class="col-sm-2">\
                                     <input name="ejecPlazo" id="iptEjecPlazo" type="text" class="form-control" maxlength="4" value="' + ejecuPlazo + '" onkeypress="return soloNumero(event)" required>\
                                 </div>\
                                </div>\
                        </form>\
                                <div class="form-group row">\
                                 <div class="col-sm-3 fontweight6">\
                                     <label class="custom-control custom-checkbox">\
                                         <input type="checkbox" class="custom-control-input" name="ejecTieneAdelaDirec" value="ok" ' + ejecuTieneAdelantoDirec + '>\
                                         <span class="custom-control-indicator"></span>&nbsp;&nbsp;\
                                         <span class="custom-control-description">¿Recibió Adelanto Directo?</span>\
                                     </label>\
                                 </div>\
                                </div>\
                                <div id="divEjecAdelaDirec" style="overflow-x:auto;">\
                                 <form id="formRegInfoProyecto3_1" action="./Proyectos?tipo=00_3_1&cod_siaf=' + codSiaf + '&ejecAdelaNro=' + ejecuAdelaDirNro + '&ejec_tipo=d" method="post">\
                                     <label class="col-form-label">ADELANTOS DIRECTOS</label>\
                                     <table id="tableEjecAdelaDirRegInfoProyCont1" class="display" cellspacing="0" width="100%">\
                                       <thead>\
                                         <tr>\
                                            <th style="text-align: center; width: 80px;">Número</th>\
                                            <th style="text-align: center; width: 160px;">Adelanto</th>\
                                            <th style="text-align: center; width: 129px;">Fecha</th>\
                                            <th style="text-align: center;">Comentario</th>\
                                            <th style="text-align: center; width: 100px;">Acción</th>\
                                         </tr>\
                                       </thead>\
                                       <tbody>\
                                         <tr>\
                                           <td id="tdEjecAdelaDirRegInfoProy" style="text-align: center;">' + ejecuAdelaDirNro + '</td>\
                                           <td style="text-align: center;">\
                                             <input name="ejecMontoAdelaDirec" type="text" class="form-control" onkeypress="return soloNumDecimal(event, this.value)" required>\
                                           </td>\
                                           <td style="text-align: center;">\
                                             <input name="ejecFechaAdelaDirec" type="date" class="col-form-date" data-date-format="dd/mm/yyyy" required>\
                                           </td>\
                                           <td style="text-align: left;">\
                                             <textarea name="ejecComentAdelaDirec" rows="2" class="form-control no-resize" form="formRegInfoProyecto3_1" />\
                                           </td>\
                                           <td style="text-align: center;">\
                                             <button type="submit" id="btnAddEjecAdelaDirRegInfoProy" title="Añadir" class="btn btn-success btn-sm">\
                                               <i class="fa fa-plus"></i>\
                                             </button>\
                                           </td>\
                                         </tr>\
                                       </tbody>\
                                     </table>\
                                 </form>\
                                 <form id="formRegInfoProyecto3_2" method="post">\
                                     <table id="tableEjecAdelaDirRegInfoProyCont2" class="display" cellspacing="0" width="100%">\
                                       <thead>\
                                         <tr>\
                                            <th style="text-align: center; width: 80px;">Número</th>\
                                            <th style="text-align: center; width: 160px;">Adelanto</th>\
                                            <th style="text-align: center; width: 129px;">Fecha</th>\
                                            <th style="text-align: center;">Comentario</th>\
                                            <th style="text-align: center; width: 100px;">Acción</th>\
                                         </tr>\
                                       </thead>\
                                       <tbody id="tableEjecAdelaDirRegInfoProyCont2Body"></tbody>\
                                       <tfoot id="tableEjecAdelaDirRegInfoProyCont2Foot"></tfoot>\
                                     </table></br>\
                                 </form>\
                                </div>\
                                <div class="form-group row">\
                                 <div class="col-sm-3 fontweight6">\
                                     <label class="custom-control custom-checkbox">\
                                         <input type="checkbox" class="custom-control-input" name="ejecTieneAdelaMater" value="ok" ' + ejecuTieneAdelantoMater + '>\
                                         <span class="custom-control-indicator"></span>&nbsp;&nbsp;\
                                         <span class="custom-control-description">¿Recibió Adelanto de Materiales?</span>\
                                     </label>\
                                 </div>\
                                </div>\
                                <div id="divEjecAdelaMater" style="overflow-x:auto;">\
                                 <form id="formRegInfoProyecto3_3" action="./Proyectos?tipo=00_3_1&cod_siaf=' + codSiaf + '&ejecAdelaNro=' + ejecuAdelaMatNro + '&ejec_tipo=m" method="post">\
                                     <label class="col-form-label">ADELANTOS DE MATERIAL</label>\
                                     <table id="tableEjecAdelaMatRegInfoProyCont1" class="display" cellspacing="0" width="100%">\
                                       <thead>\
                                         <tr>\
                                            <th style="text-align: center; width: 80px;">Número</th>\
                                            <th style="text-align: center; width: 160px;">Adelanto</th>\
                                            <th style="text-align: center; width: 129px;">Fecha</th>\
                                            <th style="text-align: left;">Comentario</th>\
                                            <th style="text-align: center; width: 100px;">Acción</th>\
                                         </tr>\
                                       </thead>\
                                       <tbody>\
                                         <tr>\
                                           <td id="tdEjecAdelaMatRegInfoProy" style="text-align: center;">' + ejecuAdelaMatNro + '</td>\
                                           <td style="text-align: center;">\
                                             <input name="ejecMontoAdelaMateria" type="text" class="form-control" onkeypress="return soloNumDecimal(event, this.value)" required>\
                                           </td>\
                                           <td style="text-align: center;">\
                                             <input name="ejecFechaAdelaMateria" type="date" class="col-form-date" data-date-format="dd/mm/yyyy" required>\
                                           </td>\
                                           <td style="text-align: left;">\
                                             <textarea name="ejecComentAdelaMateria" rows="2" class="form-control no-resize" form="formRegInfoProyecto3_3" />\
                                           </td>\
                                           <td style="text-align: center;">\
                                             <button type="submit" id="btnAddEjecAdelaMatRegInfoProy" title="Añadir" class="btn btn-success btn-sm">\
                                               <i class="fa fa-plus"></i>\
                                             </button>\
                                           </td>\
                                         </tr>\
                                       </tbody>\
                                     </table>\
                                 </form>\
                                 <form id="formRegInfoProyecto3_4" method="post">\
                                     <table id="tableEjecAdelaMatRegInfoProyCont2" class="display" cellspacing="0" width="100%">\
                                       <thead>\
                                         <tr>\
                                            <th style="text-align: center; width: 80px;">Número</th>\
                                            <th style="text-align: center; width: 160px;">Adelanto</th>\
                                            <th style="text-align: center; width: 129px;">Fecha</th>\
                                            <th style="text-align: left;">Comentario</th>\
                                            <th style="text-align: center; width: 100px;">Acción</th>\
                                         </tr>\
                                       </thead>\
                                       <tbody id="tableEjecAdelaMatRegInfoProyCont2Body"></tbody>\
                                       <tfoot id="tableEjecAdelaMatRegInfoProyCont2Foot"></tfoot>\
                                     </table></br>\
                                 </form>\
                                </div>\
                            </div>\
                     </div></br>';
        var ampReg = response.ampReg;
        ampliacion = '<div id="divAmpRegInfoProy" class="border-gris">\
                        <div id="divAmpRegInfoProyTit" class="pad10 ficha-sombreado1">\
                            <label>4.- <label class="underline">AMPLIACIONES</label></label>&nbsp;&nbsp;\
                            <button id="btnShowAmpRegInfoProyCont" type="button" class="btn btn-default btn-m" data-toggle="tooltip" data-placement="bottom" title="Mostrar">\
                                <span class="glyphicon glyphicon-eye-open"></span>\
                            </button>\
                        </div>\
                        <div id="divAmpRegInfoProyCont" class="pad10" style="overflow-x:auto;">\
                          <form id="formRegInfoProyecto4_1" action="./Proyectos?tipo=00_4_1&cod_siaf=' + codSiaf + '&num_amp=' + ampReg + '" method="post">\
                            <table id="tableAmpRegInfoProyCont1" class="display" cellspacing="0" width="100%">\
                              <thead>\
                                <tr>\
                                  <th style="text-align: center; width: 50px;">Número</th>\
                                  <th style="text-align: center; width: 129px;">Fecha</th>\
                                  <th style="text-align: center; width: 70px;">Días</th>\
                                  <th style="text-align: center;">Documento</th>\
                                  <th style="text-align: center; width: 98px;">Estado</th>\
                                  <th style="text-align: center; width: 100px;">Acción</th>\
                                </tr>\
                              </thead>\
                              <tbody>\
                                <tr>\
                                  <td id="tdAmpRegInfoProy" style="text-align: center;">' + ampReg + '</td>\
                                  <td style="text-align: center;">\
                                    <input name="ampliaFecha" type="date" class="col-form-date" data-date-format="dd/mm/yyyy" required>\
                                  </td>\
                                  <td style="text-align: center;">\
                                    <input name="ampliaDias" type="text" class="form-control" onkeypress="return soloNumero(event)" required>\
                                  </td>\
                                  <td style="text-align: left;">\
                                    <input name="ampliaDocu" id="iptEjecResiNom" type="text" class="form-control uppercase" required>\
                                  </td>\
                                  <td style="text-align: center;">\
                                    <label class="custom-control custom-checkbox" style="font-weight: normal;">\
                                      <input name="ampliaEstado" type="checkbox" class="custom-control-input" value="ok" checked>\
                                      <span class="custom-control-indicator"></span>&nbsp;&nbsp;\
                                      <span class="custom-control-description">Procedente</span>\
                                    </label>\
                                  </td>\
                                  <td style="text-align: center;">\
                                    <button type="submit" id="btnAddAmpRegInfoProy" title="Añadir" class="btn btn-success btn-sm">\
                                      <i class="fa fa-plus"></i>\
                                    </button>\
                                  </td>\
                                </tr>\
                              </tbody>\
                            </table>\
                          </form>\
                          <form id="formRegInfoProyecto4_2" method="post">\
                            <table id="tableAmpRegInfoProyCont2" class="display" cellspacing="0" width="100%">\
                              <thead>\
                                <tr>\
                                  <th style="text-align: center; width: 50px;">Número</th>\
                                  <th style="text-align: center; width: 129px;">Fecha</th>\
                                  <th style="text-align: center; width: 70px;">Días</th>\
                                  <th style="text-align: center;">Documento</th>\
                                  <th style="text-align: center; width: 98px;">Estado</th>\
                                  <th style="text-align: center; width: 100px;">Acción</th>\
                                </tr>\
                              </thead>\
                              <tbody id="tableAmpRegInfoProyCont2Body"></tbody>\
                            </table></br>\
                          </form>\
                        </div>\
                       </div></br>';
        var pasuReg = response.pasuReg;
        parasusp = '<div id="divPasuRegInfoProy" class="border-gris">\
                        <div id="divPasuRegInfoProyTit" class="pad10 ficha-sombreado1">\
                            <label>5.- <label class="underline">PARALIZACIONES Y SUSPENSIONES</label></label>&nbsp;&nbsp;\
                            <button id="btnShowPasuRegInfoProyCont" type="button" class="btn btn-default btn-m" data-toggle="tooltip" data-placement="bottom" title="Mostrar">\
                                <span class="glyphicon glyphicon-eye-open"></span>\
                            </button>\
                        </div>\
                        <div id="divPasuRegInfoProyCont" class="pad10" style="overflow-x:auto;">\
                          <form id="formRegInfoProyecto5_1" action="./Proyectos?tipo=00_5_1&cod_siaf=' + codSiaf + '&num_pasu=' + pasuReg + '" method="post">\
                            <table id="tablePasuRegInfoProyCont1" class="display" cellspacing="0" width="100%">\
                              <thead>\
                                <tr>\
                                  <th style="text-align: center; width: 50px;">Número</th>\
                                  <th style="text-align: center; width: 129px;">Fecha</th>\
                                  <th style="text-align: center; width: 70px;">Días</th>\
                                  <th style="text-align: center;">Documento</th>\
                                  <th style="text-align: center; width: 150px;">Tipo</th>\
                                  <th style="text-align: center; width: 100px;">Acción</th>\
                                </tr>\
                              </thead>\
                              <tbody>\
                                <tr>\
                                  <td id="tdPasuRegInfoProy" style="text-align: center;">' + pasuReg + '</td>\
                                  <td style="text-align: center;">\
                                    <input name="parasusFecha" type="date" class="col-form-date" data-date-format="dd/mm/yyyy" required>\
                                  </td>\
                                  <td style="text-align: center;">\
                                    <input name="parasusDias" type="text" class="form-control" onkeypress="return soloNumero(event)" required>\
                                  </td>\
                                  <td style="text-align: left;">\
                                    <input name="parasusDocu" id="iptEjecResiNom" type="text" class="form-control uppercase" required>\
                                  </td>\
                                  <td style="text-align: center;">\
                                    <select id="listParaSusTipoProy" name="parasusTipo" class="select-form">\
                                      <option value="paralizacion" selected>Paralización</option>\
                                      <option value="suspension">Suspensión</option>\
                                    </select>\
                                  </td>\
                                  <td style="text-align: center;">\
                                    <button type="submit" id="btnAddPasuRegInfoProy" title="Añadir" class="btn btn-success btn-sm">\
                                      <i class="fa fa-plus"></i>\
                                    </button>\
                                  </td>\
                                </tr>\
                              </tbody>\
                            </table>\
                          </form>\
                          <form id="formRegInfoProyecto5_2" method="post">\
                            <table id="tablePasuRegInfoProyCont2" class="display" cellspacing="0" width="100%">\
                              <thead>\
                                <tr>\
                                  <th style="text-align: center; width: 50px;">Número</th>\
                                  <th style="text-align: center; width: 129px;">Fecha</th>\
                                  <th style="text-align: center; width: 70px;">Días</th>\
                                  <th style="text-align: center;">Documento</th>\
                                  <th style="text-align: center; width: 150px;">Tipo</th>\
                                  <th style="text-align: center; width: 100px;">Acción</th>\
                                </tr>\
                              </thead>\
                              <tbody id="tablePasuRegInfoProyCont2Body"></tbody>\
                            </table></br>\
                          </form>\
                        </div>\
                       </div></br>';
        contratos = '<div id="divContRegInfoProy" class="border-gris">\
                        <div id="divContRegInfoProyTit" class="pad10 ficha-sombreado1">\
                            <label>6.- <label class="underline">CONTRATACIONES</label></label>&nbsp;&nbsp;\
                            <button id="btnShowContRegInfoProyCont" type="button" class="btn btn-default btn-m" data-toggle="tooltip" data-placement="bottom" title="Mostrar">\
                                <span class="glyphicon glyphicon-eye-open"></span>\
                            </button>\
                        </div>\
                        <form id="formRegInfoProyecto6" method="post" enctype="multipart/form-data">\
                            <div id="divContRegInfoProyCont" class="pad10" style="overflow-x:auto;">\
                              <table id="tableContRegInfoProyCont" class="display" cellspacing="0" width="100%">\
                                <thead>\
                                  <tr>\
                                    <th style="text-align: center;">Id</th>\
                                    <th style="text-align: center;">Contrato</th>\
                                    <th style="text-align: center;">Tipo Proceso</th>\
                                    <th style="text-align: center;">Contratista</th>\
                                    <th style="text-align: center; width: 80px;">Fecha</th>\
                                    <th style="text-align: center; width: 100px;">Monto</th>\
                                    <th style="text-align: center; width: 90px;">Adjunto</th>\
                                    <th style="text-align: center; width: 85px;">Acción</th>\
                                  </tr>\
                                </thead>\
                                <tbody id="tableContRegInfoProyContBody"></tbody>\
                              </table></br>\
                            </div>\
                        </form>\
                      </div></br>';
        componentes = '<div id="divCompRegInfoProy" class="border-gris">\
                        <div id="divCompRegInfoProyTit" class="pad10 ficha-sombreado1">\
                            <label>7.- <label class="underline">COMPONENTES</label></label>&nbsp;&nbsp;\
                            <button id="btnShowCompRegInfoProyCont" type="button" class="btn btn-default btn-m" data-toggle="tooltip" data-placement="bottom" title="Mostrar">\
                                <span class="glyphicon glyphicon-eye-open"></span>\
                            </button>\
                        </div>\
                        <div id="divCompRegInfoProyCont" class="pad10" style="overflow-x:auto;">\
                          <form id="formRegInfoProyecto7" method="post">\
                            <table id="tableCompRegInfoProyCont" class="display" cellspacing="0" width="100%">\
                              <thead>\
                                <tr>\
                                  <th style="text-align: center; width: 20px;">N°</th>\
                                  <th style="text-align: center;">Componente</th>\
                                  <th style="text-align: center; width: 100px;">Monto Viable</th>\
                                  <th style="text-align: center; width: 100px;">Monto Estudio Definitivo</th>\
                                  <th style="text-align: center; width: 100px;">Monto Contrato</th>\
                                  <th style="text-align: center; width: 100px;">Monto Actualizado</th>\
                                  <th style="text-align: center;">Comentario</th>\
                                  <th style="text-align: center; width: 100px;">Acción</th>\
                                </tr>\
                              </thead>\
                              <tbody id="tableCompRegInfoProyContBody"></tbody>\
                              <tfoot id="tableCompRegInfoProyContFoot"></tfoot>\
                            </table></br>\
                          </form>\
                        </div>\
                       </div></br>';
        calendario = '<div id="divCalRegInfoProy" class="border-gris">\
                        <div id="divCalRegInfoProyTit" class="pad10 ficha-sombreado1">\
                            <label>8.- <label class="underline">CRONOGRAMA DE AVANCE</label></label>&nbsp;&nbsp;\
                            <button id="btnShowCalRegInfoProyCont" type="button" class="btn btn-default btn-m" data-toggle="tooltip" data-placement="bottom" title="Mostrar">\
                                <span class="glyphicon glyphicon-eye-open"></span>\
                            </button>\
                        </div>\
                        <div id="divCalRegInfoProyCont" class="pad10" style="overflow-x:auto;">\
                          <form id="formRegInfoProyecto8_1" action="./Proyectos?tipo=00_8_1&cod_siaf=' + codSiaf + '" method="post">\
                            <table id="tableCalRegInfoProyCont1" class="display" cellspacing="0" width="100%">\
                              <thead>\
                                <tr>\
                                  <th style="text-align: center; width: 120px;">Año</th>\
                                  <th style="text-align: center;">Mes</th>\
                                  <th style="text-align: center; width: 120px;">Acción</th>\
                                </tr>\
                              </thead>\
                              <tbody>\
                                <tr>\
                                  <td style="text-align: center;">\
                                    <select class="select-form" id="listAnoCalRegInfoProy" name="calendarAno"></select>\
                                  </td>\
                                  <td style="text-align: center;">\
                                    <select class="select-form" id="listMesCalRegInfoProy" name="calendarMes"></select>\
                                  </td>\
                                  <td style="text-align: center;">\
                                    <button type="submit" id="btnAddCalRegInfoProy" title="Añadir" class="btn btn-success btn-sm">\
                                      <i class="fa fa-plus"></i>\
                                    </button>\
                                  </td>\
                                </tr>\
                              </tbody>\
                            </table></br>\
                          </form>\
                          <table id="tableCalRegInfoProyCont2" class="display" cellspacing="0" width="100%">\
                            <thead>\
                              <tr>\
                                <th style="text-align: center; width: 50px;">Orden</th>\
                                <th style="text-align: center; width: 80px;">Año</th>\
                                <th style="text-align: center;">Mes</th>\
                                <th style="text-align: center;">Monto Programado</th>\
                                <th style="text-align: center;">Monto Ejecutado</th>\
                                <th style="text-align: center;">Valorización Pagada</th>\
                                <th style="text-align: center; width: 100px;">Acción</th>\
                              </tr>\
                            </thead>\
                            <tbody id="tableCalRegInfoProyCont2Body"></tbody>\
                            <tfoot id="tableCalRegInfoProyCont2Foot"></tfoot>\
                          </table></br>\
                          <form id="formRegInfoProyecto8_3" method="post">\
                            <table id="tableCalRegInfoProyCont3" class="display" cellspacing="0" width="100%"></table></br>\
                          </form>\
                        </div>\
                       </div></br>';
        ubicacion = '<div id="divUbigRegInfoProy" class="border-gris">\
                        <div id="divUbigRegInfoProyTit" class="pad10 ficha-sombreado1">\
                            <label>9.- <label class="underline">UBICACIÓN GEOGRÁFICA</label></label>&nbsp;&nbsp;\
                            <button id="btnShowUbigRegInfoProyCont" type="button" class="btn btn-default btn-m" data-toggle="tooltip" data-placement="bottom" title="Mostrar">\
                                <span class="glyphicon glyphicon-eye-open"></span>\
                            </button>\
                        </div>\
                        <form id="formRegInfoProyecto9" method="post">\
                            <div id="divUbigRegInfoProyCont" class="pad10" style="overflow-x:auto;">\
                              <table id="tableUbigRegInfoProyCont" class="display" cellspacing="0" width="100%">\
                                <thead>\
                                  <tr>\
                                    <th style="text-align: center;">Id</th>\
                                    <th style="text-align: center;">Departamento</th>\
                                    <th style="text-align: center;">Provincia</th>\
                                    <th style="text-align: center;">Distrito</th>\
                                    <th style="text-align: center;">Localidad</th>\
                                    <th style="text-align: center; width: 120px;">Latitud</th>\
                                    <th style="text-align: center; width: 120px;">Longitud</th>\
                                    <th style="text-align: center; width: 100px;">Acción</th>\
                                  </tr>\
                                </thead>\
                                <tbody id="tableUbigRegInfoProyContBody"></tbody>\
                              </table></br>\
                            </div>\
                        </form>\
                      </div></br>';
        fotografias = '<div id="divFotRegInfoProy" class="border-gris">\
                        <div id="divFotRegInfoProyTit" class="pad10 ficha-sombreado1">\
                            <label>10.- <label class="underline">GALERÍA DE FOTOS</label></label>&nbsp;&nbsp;\
                            <button id="btnShowFotRegInfoProyCont" type="button" class="btn btn-default btn-m" data-toggle="tooltip" data-placement="bottom" title="Mostrar">\
                                <span class="glyphicon glyphicon-eye-open"></span>\
                            </button>\
                        </div>\
                        <div id="divFotRegInfoProyCont">\
                          <form id="formRegInfoProyecto10_1" action="./Proyectos?tipo=00_10_1&cod_siaf=' + codSiaf + '" method="post" enctype="multipart/form-data">\
                            <div class="col-sm-6" style="padding-top: 10px;">\
                              <div class="form-group">\
                                <label for="iptFotoTitulo" class="col-form-label">Título :</label>\
                                <input name="fotoTitulo" id="iptFotoTitulo" type="text" class="form-control uppercase" required >\
                              </div>\
                              <div class="form-group">\
                                <label for="iptFotoDescripcion" class="col-form-label">Descripción :</label>\
                                <textarea name="fotoDescripcion" rows="7" id="iptFotoDescripcion" class="form-control no-resize" form="formRegInfoProyecto10_1" />\
                              </div>\
                              <div class="form-group">\
                                <label class="custom-control custom-checkbox">\
                                  <input name="fotoEsPrincipal" id="iptFotoEsPrincipal" type="checkbox" class="custom-control-input" value="ok">\
                                  <span class="custom-control-indicator"></span>&nbsp;&nbsp;\
                                  <span class="custom-control-description">¿Es la foto principal?</span>\
                                </label>\
                              </div></br>\
                              <div class="form-group">\
                                <button type="submit" title="Añadir" class="btn btn-success btn-m">\
                                  <i class="fa fa-plus"> Añadir Foto</i>\
                                </button>\
                              </div>\
                            </div>\
                            <div class="col-sm-6">\
                              <div id="divFotRegInfoProyCont" class="form-group">\
                                <input name="fotoArchivo" id="iptFotoArchivo" type="file" data-height="400" accept="image/*" required>\
                              </div>\
                            </div>\
                          </form>\
                          <div class="pad10" style="overflow-x:auto;">\
                            <form id="formRegInfoProyecto10_3" method="post" enctype="multipart/form-data">\
                              <table id="tableFotRegInfoProyCont" class="display" cellspacing="0" width="100%">\
                                <thead>\
                                  <tr>\
                                    <th style="text-align: center; width: 50px;">Orden</th>\
                                    <th style="text-align: center; width: 200px;">Foto</th>\
                                    <th style="text-align: center; width: 150px;">Título</th>\
                                    <th style="text-align: center;">Descripción</th>\
                                    <th style="text-align: center; width: 98px;">Tipo</th>\
                                    <th style="text-align: center; width: 100px;">Acción</th>\
                                  </tr>\
                                </thead>\
                                <tbody id="tableFotRegInfoProyContBody"></tbody>\
                              </table></br>\
                            </form>\
                          </div>\
                        </div>\
                      </div></br>';
        HTML = general + estudio + supervision + ejecucion + ampliacion + parasusp + contratos + componentes + calendario + ubicacion + fotografias;
        $("#divRegInfoProyecto").append(HTML);
        controlRegInfoProy(response);
        eventFormRegInfoProyecto();
    } else {
        empty = '<div class="pad20">\
                   <label class="titulo">No hay información para mostrar correspondiente a éste Proyecto</label>\
                 </div>';
        $("#divRegInfoProyecto").append(empty);
    }

}

function controlRegInfoProy(response) {

    $("#divEstRegInfoProyCont").hide();
    $("#divSupRegInfoProyCont").hide();
    $("#divEjecRegInfoProyCont").hide();
    $("#divAmpRegInfoProyCont").hide();
    $("#divPasuRegInfoProyCont").hide();
    $("#divContRegInfoProyCont").hide();
    $("#divCompRegInfoProyCont").hide();
    $("#divCalRegInfoProyCont").hide();
    $("#divUbigRegInfoProyCont").hide();
    $("#divFotRegInfoProyCont").hide();

    $("#btnShowEstRegInfoProyCont").click(function () {
        $("#btnShowEstRegInfoProyCont").empty();
        if ($("#divEstRegInfoProyCont").is(":hidden")) {
            $("#btnShowEstRegInfoProyCont").append('<span class="glyphicon glyphicon-eye-close"></span>');
            $('#btnShowEstRegInfoProyCont').prop('title', 'Ocultar');
            $("#btnSaveEstRegInfoProyCont").prop("disabled", false);
            $("#divEstRegInfoProyCont").toggle(500);
            $('html,body').animate({
                scrollTop: $("#divEstRegInfoProyCont").offset().top - 10},
                    'fast');
        } else {
            $("#btnShowEstRegInfoProyCont").append('<span class="glyphicon glyphicon-eye-open"></span>');
            $('#btnShowEstRegInfoProyCont').prop('title', 'Mostrar');
            $("#btnSaveEstRegInfoProyCont").prop("disabled", true);
            $("#divEstRegInfoProyCont").hide(500);
            $('html,body').animate({
                scrollTop: $("#divEstRegInfoProyTit").offset().top - 10},
                    'fast');
        }

    });
    $("#btnShowSupRegInfoProyCont").click(function () {
        $("#btnShowSupRegInfoProyCont").empty();
        if ($("#divSupRegInfoProyCont").is(":hidden")) {
            $("#btnShowSupRegInfoProyCont").append('<span class="glyphicon glyphicon-eye-close"></span>');
            $('#btnShowSupRegInfoProyCont').prop('title', 'Ocultar');
            $("#btnSaveSupRegInfoProyCont").prop("disabled", false);
            $("#divSupRegInfoProyCont").toggle(500);
            $('html,body').animate({
                scrollTop: $("#divSupRegInfoProyCont").offset().top - 10},
                    'fast');
        } else {
            $("#btnShowSupRegInfoProyCont").append('<span class="glyphicon glyphicon-eye-open"></span>');
            $('#btnShowSupRegInfoProyCont').prop('title', 'Mostrar');
            $("#btnSaveSupRegInfoProyCont").prop("disabled", true);
            $("#divSupRegInfoProyCont").hide(500);
            $('html,body').animate({
                scrollTop: $("#divSupRegInfoProyTit").offset().top - 10},
                    'fast');
        }
    });
    $("#btnShowEjecRegInfoProyCont").click(function () {
        $("#btnShowEjecRegInfoProyCont").empty();
        if ($("#divEjecRegInfoProyCont").is(":hidden")) {
            $("#btnShowEjecRegInfoProyCont").append('<span class="glyphicon glyphicon-eye-close"></span>');
            $('#btnShowEjecRegInfoProyCont').prop('title', 'Ocultar');
            $("#btnSaveEjecRegInfoProyCont").prop("disabled", false);
            $("#divEjecRegInfoProyCont").toggle(500);
            $('html,body').animate({
                scrollTop: $("#divEjecRegInfoProyCont").offset().top - 10},
                    'fast');
        } else {
            $("#btnShowEjecRegInfoProyCont").append('<span class="glyphicon glyphicon-eye-open"></span>');
            $('#btnShowEjecRegInfoProyCont').prop('title', 'Mostrar');
            $("#btnSaveEjecRegInfoProyCont").prop("disabled", true);
            $("#divEjecRegInfoProyCont").hide(500);
            $('html,body').animate({
                scrollTop: $("#divEjecRegInfoProyTit").offset().top - 10},
                    'fast');
        }
    });
    $("#btnShowAmpRegInfoProyCont").click(function () {
        $("#btnShowAmpRegInfoProyCont").empty();
        if ($("#divAmpRegInfoProyCont").is(":hidden")) {
            $("#btnShowAmpRegInfoProyCont").append('<span class="glyphicon glyphicon-eye-close"></span>');
            $('#btnShowAmpRegInfoProyCont').prop('title', 'Ocultar');
            $("#divAmpRegInfoProyCont").toggle(500);
            $('html,body').animate({
                scrollTop: $("#divAmpRegInfoProyCont").offset().top - 10},
                    'fast');
        } else {
            $("#btnShowAmpRegInfoProyCont").append('<span class="glyphicon glyphicon-eye-open"></span>');
            $('#btnShowAmpRegInfoProyCont').prop('title', 'Mostrar');
            $("#divAmpRegInfoProyCont").hide(500);
            $('html,body').animate({
                scrollTop: $("#divAmpRegInfoProyTit").offset().top - 10},
                    'fast');
        }
    });
    $("#btnShowPasuRegInfoProyCont").click(function () {
        $("#btnShowPasuRegInfoProyCont").empty();
        if ($("#divPasuRegInfoProyCont").is(":hidden")) {
            $("#btnShowPasuRegInfoProyCont").append('<span class="glyphicon glyphicon-eye-close"></span>');
            $('#btnShowPasuRegInfoProyCont').prop('title', 'Ocultar');
            $("#divPasuRegInfoProyCont").toggle(500);
            $('html,body').animate({
                scrollTop: $("#divPasuRegInfoProyCont").offset().top - 10},
                    'fast');
        } else {
            $("#btnShowPasuRegInfoProyCont").append('<span class="glyphicon glyphicon-eye-open"></span>');
            $('#btnShowPasuRegInfoProyCont').prop('title', 'Mostrar');
            $("#divPasuRegInfoProyCont").hide(500);
            $('html,body').animate({
                scrollTop: $("#divPasuRegInfoProyTit").offset().top - 10},
                    'fast');
        }
    });
    $("#btnShowContRegInfoProyCont").click(function () {
        $("#btnShowContRegInfoProyCont").empty();
        if ($("#divContRegInfoProyCont").is(":hidden")) {
            $("#btnShowContRegInfoProyCont").append('<span class="glyphicon glyphicon-eye-close"></span>');
            $('#btnShowContRegInfoProyCont').prop('title', 'Ocultar');
            $("#divContRegInfoProyCont").toggle(500);
            $('html,body').animate({
                scrollTop: $("#divContRegInfoProyCont").offset().top - 10},
                    'fast');
        } else {
            $("#btnShowContRegInfoProyCont").append('<span class="glyphicon glyphicon-eye-open"></span>');
            $('#btnShowContRegInfoProyCont').prop('title', 'Mostrar');
            $("#divContRegInfoProyCont").hide(500);
            $('html,body').animate({
                scrollTop: $("#divContRegInfoProyTit").offset().top - 10},
                    'fast');
        }
    });
    $("#btnShowCompRegInfoProyCont").click(function () {
        $("#btnShowCompRegInfoProyCont").empty();
        if ($("#divCompRegInfoProyCont").is(":hidden")) {
            $("#btnShowCompRegInfoProyCont").append('<span class="glyphicon glyphicon-eye-close"></span>');
            $('#btnShowCompRegInfoProyCont').prop('title', 'Ocultar');
            $("#divCompRegInfoProyCont").toggle(500);
            $('html,body').animate({
                scrollTop: $("#divCompRegInfoProyCont").offset().top - 10},
                    'fast');
        } else {
            $("#btnShowCompRegInfoProyCont").append('<span class="glyphicon glyphicon-eye-open"></span>');
            $('#btnShowCompRegInfoProyCont').prop('title', 'Mostrar');
            $("#divCompRegInfoProyCont").hide(500);
            $('html,body').animate({
                scrollTop: $("#divCompRegInfoProyTit").offset().top - 10},
                    'fast');
        }
    });
    $("#btnShowCalRegInfoProyCont").click(function () {
        $("#btnShowCalRegInfoProyCont").empty();
        if ($("#divCalRegInfoProyCont").is(":hidden")) {
            $("#btnShowCalRegInfoProyCont").append('<span class="glyphicon glyphicon-eye-close"></span>');
            $('#btnShowCalRegInfoProyCont').prop('title', 'Ocultar');
            $("#divCalRegInfoProyCont").toggle(500);
            $('html,body').animate({
                scrollTop: $("#divCalRegInfoProyCont").offset().top - 10},
                    'fast');
        } else {
            $("#btnShowCalRegInfoProyCont").append('<span class="glyphicon glyphicon-eye-open"></span>');
            $('#btnShowCalRegInfoProyCont').prop('title', 'Mostrar');
            $("#divCalRegInfoProyCont").hide(500);
            $('html,body').animate({
                scrollTop: $("#divCalRegInfoProyTit").offset().top - 10},
                    'fast');
        }
    });
    $("#btnShowFotRegInfoProyCont").click(function () {
        $("#btnShowFotRegInfoProyCont").empty();
        if ($("#divFotRegInfoProyCont").is(":hidden")) {
            $("#btnShowFotRegInfoProyCont").append('<span class="glyphicon glyphicon-eye-close"></span>');
            $('#btnShowFotRegInfoProyCont').prop('title', 'Ocultar');
            $("#divFotRegInfoProyCont").toggle(500);
            $('html,body').animate({
                scrollTop: $("#divFotRegInfoProyCont").offset().top - 10},
                    'fast');
        } else {
            $("#btnShowFotRegInfoProyCont").append('<span class="glyphicon glyphicon-eye-open"></span>');
            $('#btnShowFotRegInfoProyCont').prop('title', 'Mostrar');
            $("#divFotRegInfoProyCont").hide(500);
            $('html,body').animate({
                scrollTop: $("#divFotRegInfoProyTit").offset().top - 10},
                    'fast');
        }
    });
    $("#btnShowUbigRegInfoProyCont").click(function () {
        $("#btnShowUbigRegInfoProyCont").empty();
        if ($("#divUbigRegInfoProyCont").is(":hidden")) {
            $("#btnShowUbigRegInfoProyCont").append('<span class="glyphicon glyphicon-eye-close"></span>');
            $('#btnShowUbigRegInfoProyCont').prop('title', 'Ocultar');
            $("#divUbigRegInfoProyCont").toggle(500);
            $('html,body').animate({
                scrollTop: $("#divUbigRegInfoProyCont").offset().top - 10},
                    'fast');
        } else {
            $("#btnShowUbigRegInfoProyCont").append('<span class="glyphicon glyphicon-eye-open"></span>');
            $('#btnShowUbigRegInfoProyCont').prop('title', 'Mostrar');
            $("#divUbigRegInfoProyCont").hide(500);
            $('html,body').animate({
                scrollTop: $("#divUbigRegInfoProyTit").offset().top - 10},
                    'fast');
        }
    });
    if (response.proyecSupervision) {
        $("#divSupRegInfoProyCont2").show();
    } else {
        $("#divSupRegInfoProyCont2").hide();
    }
    $("input[name=tieneSuper]").change(function () {
        if (this.checked) {
            $("#divSupRegInfoProyCont2").toggle();
        } else {
            $("#divSupRegInfoProyCont2").hide();
        }
    });

    if (response.supervEstado) {
        if (response.supervTieneAdelanto) {
            $("#divSuperAdela").show();
        } else {
            $("#divSuperAdela").hide();
        }
    } else {
        $("#divSuperAdela").hide();
    }
    $("input[name=superTieneAdela]").change(function () {
        if (this.checked) {
            $("#divSuperAdela").toggle();
        } else {
            $("#divSuperAdela").hide();
        }
    });
    if (response.ejecuTieneAdelantoDirec) {
        $("#divEjecAdelaDirec").show();
    } else {
        $("#divEjecAdelaDirec").hide();
    }
    $("input[name=ejecTieneAdelaDirec]").change(function () {
        if (this.checked) {
            $("#divEjecAdelaDirec").toggle();
        } else {
            $("#divEjecAdelaDirec").hide();
        }
    });
    if (response.ejecuTieneAdelantoMater) {
        $("#divEjecAdelaMater").show();
    } else {
        $("#divEjecAdelaMater").hide();
    }
    $("input[name=ejecTieneAdelaMater]").change(function () {
        if (this.checked) {
            $("#divEjecAdelaMater").toggle();
        } else {
            $("#divEjecAdelaMater").hide();
        }
    });

    $('#tableEstRegInfoProyCont1').dataTable({
        ordering: false,
        bPaginate: false,
        dom: 'rt'
    });
    llenarRegListEstEtapProy(response);
    $('#tableEstRegInfoProyCont2').dataTable({
        ordering: false,
        bPaginate: false,
        dom: 'rt'
    });

    $('#tableSupRegInfoProyCont1').dataTable({
        ordering: false,
        bPaginate: false,
        dom: 'rt'
    });
    llenarRegListSuperAdelaProy(response);
    $('#tableSupRegInfoProyCont2').dataTable({
        ordering: false,
        bPaginate: false,
        dom: 'rt'
    });

    $('#tableEjecAdelaDirRegInfoProyCont1').dataTable({
        ordering: false,
        bPaginate: false,
        dom: 'rt'
    });
    llenarRegListEjecAdelaDirProy(response);
    $('#tableEjecAdelaDirRegInfoProyCont2').dataTable({
        ordering: false,
        bPaginate: false,
        dom: 'rt'
    });

    $('#tableEjecAdelaMatRegInfoProyCont1').dataTable({
        ordering: false,
        bPaginate: false,
        dom: 'rt'
    });
    llenarRegListEjecAdelaMatProy(response);
    $('#tableEjecAdelaMatRegInfoProyCont2').dataTable({
        ordering: false,
        bPaginate: false,
        dom: 'rt'
    });

    $('#tableAmpRegInfoProyCont1').dataTable({
        ordering: false,
        bPaginate: false,
        dom: 'rt'
    });
    llenarRegListAmpliaProy(response);
    $('#tableAmpRegInfoProyCont2').dataTable({
        ordering: false,
        bPaginate: false,
        dom: 'rt'
    });

    $('#tablePasuRegInfoProyCont1').dataTable({
        ordering: false,
        bPaginate: false,
        dom: 'rt'
    });
    llenarRegListParaSuspProy(response);
    $('#tablePasuRegInfoProyCont2').dataTable({
        ordering: false,
        bPaginate: false,
        dom: 'rt'
    });

    llenarRegListContratoProy(response);
    $('#tableContRegInfoProyCont').dataTable({
        ordering: false,
        bPaginate: false,
        dom: 'rt'
    });

    llenarRegListCompoProy(response);
    $('#tableCompRegInfoProyCont').dataTable({
        ordering: false,
        bPaginate: false,
        dom: 'rt'
    });

    llenarRegListCalendarProy1();
    $('#tableCalRegInfoProyCont1').dataTable({
        ordering: false,
        bPaginate: false,
        dom: 'rt'
    });
    llenarRegListCalendarProy2(response);

    llenarRegListUbigeoProy(response);
    $('#tableUbigRegInfoProyCont').dataTable({
        ordering: false,
        bPaginate: false,
        dom: 'rt'
    });

    llenarRegListFotosProy(response);

    $('#iptFotoArchivo').dropify({
        "defaultFile": "./resources/images/proyecto.jpg",
        "messages": {
            default: 'Arrastre una imagen o haga clic aquí',
            replace: 'Arrastre una imagen o haga clic en reemplazar',
            remove: 'Remover',
            error: 'Lo sentimos, la imagen es demasiado grande'
        }
    });

    var drEvent = $('#input-file-events').dropify();
    drEvent.on('dropify.beforeClear', function (event, element) {
        return confirm("Desear borrar el archivo \"" + element.file.name + "\" ?");
    });
    drEvent.on('dropify.afterClear', function (event, element) {
        alert('Archivo borrado');
    });
    drEvent.on('dropify.errors', function (event, element) {
        console.log('Tiene errores');
    });
    var drDestroy = $('#input-file-to-destroy').dropify();
    drDestroy = drDestroy.data('dropify');
    $('#toggleDropify').on('click', function (e) {
        e.preventDefault();
        if (drDestroy.isDropified()) {
            drDestroy.destroy();
        } else {
            drDestroy.init();
        }
    });

}

function eventFormRegInfoProyecto() {

    $("#formRegInfoProyecto1_1").submit(function (evt) {
        evt.preventDefault();
        $.ajax({
            dataType: 'json',
            type: 'post',
            url: $(this).attr("action"),
            data: $(this).serialize(),
            success: function (response) {
                if (response.estado) {
                    $("#divCheckEstRegInfoProyCont").empty();
                    $("#divCheckEstRegInfoProyCont").append('<span class="label1 label-warning"><i class="fa fa-check"></i> Actualizado</span>');
                    alertify.log(response.msg);
                } else {
                    $("#divCheckEstRegInfoProyCont").empty();
                    alertify.log(response.msg);
                }
            }
        });
    });
    $("#formRegInfoProyecto1_2").submit(function (evt) {
        evt.preventDefault();
        $.ajax({
            dataType: 'json',
            type: 'post',
            url: $(this).attr("action"),
            data: $(this).serialize(),
            success: function (responseUps) {
                if (responseUps.estado) {
                    $("#tdEstRegInfoProy").empty();
                    $("#tdEstRegInfoProy").append(responseUps.etapaEst);
                    var actionUps = "./Proyectos?tipo=00_1_2&cod_siaf=" + responseUps.proyecCodSiaf + "&etapa_est=" + responseUps.etapaEst;
                    $("#formRegInfoProyecto1_2").attr("action", actionUps);
                    llenarRegListEstEtapProy(responseUps);
                    limpiarRegListEstEtapProy();
                } else {
                    alertify.log(responseUps.msg);
                }
            }
        });
    });
    $("#formRegInfoProyecto1_3").submit(function (evt) {
        evt.preventDefault();
        $.ajax({
            dataType: 'json',
            type: 'post',
            url: $(this).attr("action"),
            data: $(this).serialize(),
            success: function (responseUps) {
                $("#tdEstRegInfoProy").empty();
                $("#tdEstRegInfoProy").append(responseUps.etapaEst);
                var actionUps = "./Proyectos?tipo=00_1_2&cod_siaf=" + responseUps.proyecCodSiaf + "&etapa_est=" + responseUps.etapaEst;
                $("#formRegInfoProyecto1_2").attr("action", actionUps);
                llenarRegListEstEtapProy(responseUps);
            }
        });
    });
    $("#formRegInfoProyecto2").submit(function (evt) {
        evt.preventDefault();
        $.ajax({
            dataType: 'json',
            type: 'post',
            url: $(this).attr("action"),
            data: $(this).serialize(),
            success: function (response) {
                if (response.estado) {
                    $("#divCheckSupRegInfoProyCont").empty();
                    $("#divCheckSupRegInfoProyCont").append('<span class="label1 label-warning"><i class="fa fa-check"></i> Actualizado</span>');
                    alertify.log(response.msg);
                } else {
                    $("#divCheckSupRegInfoProyCont").empty();
                    alertify.log(response.msg);
                }
            }
        });
    });
    $("#formRegInfoProyecto2_1").submit(function (evt) {
        evt.preventDefault();
        $.ajax({
            dataType: 'json',
            type: 'post',
            url: $(this).attr("action"),
            data: $(this).serialize(),
            success: function (responseUps) {
                $("#tdSupRegInfoProy").empty();
                $("#tdSupRegInfoProy").append(responseUps.supervAdela);
                var actionUps = "./Proyectos?tipo=00_2_1&cod_siaf=" + responseUps.proyecCodSiaf + "&super_adela=" + responseUps.supervAdela;
                $("#formRegInfoProyecto2_1").attr("action", actionUps);
                llenarRegListSuperAdelaProy(responseUps);
                limpiarRegListSuperAdelaProy();
            }
        });
    });
    $("#formRegInfoProyecto2_3").submit(function (evt) {
        evt.preventDefault();
        $.ajax({
            dataType: 'json',
            type: 'post',
            url: $(this).attr("action"),
            data: $(this).serialize(),
            success: function (responseUps) {
                $("#tdSupRegInfoProy").empty();
                $("#tdSupRegInfoProy").append(responseUps.supervAdela);
                var actionUps = "./Proyectos?tipo=00_2_1&cod_siaf=" + responseUps.proyecCodSiaf + "&super_adela=" + responseUps.supervAdela;
                $("#formRegInfoProyecto2_1").attr("action", actionUps);
                llenarRegListSuperAdelaProy(responseUps);
            }
        });
    });
    $("#formRegInfoProyecto3").submit(function (evt) {
        var action = document.getElementById("formRegInfoProyecto3").action;
        var tieneAdelaDirec = $("input[name=ejecTieneAdelaDirec]").is(':checked');
        var tieneAdelaMater = $("input[name=ejecTieneAdelaMater]").is(':checked');
        $("#formRegInfoProyecto3").attr("action", action + "&ejecTieneAdelaDirec=" + tieneAdelaDirec + "&ejecTieneAdelaMater=" + tieneAdelaMater);
        evt.preventDefault();
        $.ajax({
            dataType: 'json',
            type: 'post',
            url: $(this).attr("action"),
            data: $(this).serialize(),
            success: function (response) {
                if (response.estado) {
                    $("#divCheckEjecRegInfoProyCont").empty();
                    $("#divCheckEjecRegInfoProyCont").append('<span class="label1 label-warning"><i class="fa fa-check"></i> Actualizado</span>');
                    alertify.log(response.msg);
                } else {
                    $("#divCheckEjecRegInfoProyCont").empty();
                    alertify.log(response.msg);
                }
            }
        });
    });
    $("#formRegInfoProyecto3_1").submit(function (evt) {
        evt.preventDefault();
        $.ajax({
            dataType: 'json',
            type: 'post',
            url: $(this).attr("action"),
            data: $(this).serialize(),
            success: function (responseUps) {
                $("#tdEjecAdelaDirRegInfoProy").empty();
                $("#tdEjecAdelaDirRegInfoProy").append(responseUps.ejecuAdelaDirNro);
                var actionUps = "./Proyectos?tipo=00_3_1&cod_siaf=" + responseUps.proyecCodSiaf + "&ejecAdelaNro=" + responseUps.ejecuAdelaDirNro + "&ejec_tipo=d";
                $("#formRegInfoProyecto3_1").attr("action", actionUps);
                llenarRegListEjecAdelaDirProy(responseUps);
                limpiarRegListEjecAdelaDirProy();
            }
        });
    });
    $("#formRegInfoProyecto3_2").submit(function (evt) {
        evt.preventDefault();
        $.ajax({
            dataType: 'json',
            type: 'post',
            url: $(this).attr("action"),
            data: $(this).serialize(),
            success: function (responseUps) {
                $("#tdEjecAdelaDirRegInfoProy").empty();
                $("#tdEjecAdelaDirRegInfoProy").append(responseUps.ejecuAdelaDirNro);
                var actionUps = "./Proyectos?tipo=00_3_1&cod_siaf=" + responseUps.proyecCodSiaf + "&ejecAdelaNro=" + responseUps.ejecuAdelaDirNro + "&ejec_tipo=d";
                $("#formRegInfoProyecto3_1").attr("action", actionUps);
                llenarRegListEjecAdelaDirProy(responseUps);
            }
        });
    });
    $("#formRegInfoProyecto3_3").submit(function (evt) {
        evt.preventDefault();
        $.ajax({
            dataType: 'json',
            type: 'post',
            url: $(this).attr("action"),
            data: $(this).serialize(),
            success: function (responseUps) {
                $("#tdEjecAdelaMatRegInfoProy").empty();
                $("#tdEjecAdelaMatRegInfoProy").append(responseUps.ejecuAdelaMatNro);
                var actionUps = "./Proyectos?tipo=00_3_1&cod_siaf=" + responseUps.proyecCodSiaf + "&ejecAdelaNro=" + responseUps.ejecuAdelaMatNro + "&ejec_tipo=m";
                $("#formRegInfoProyecto3_3").attr("action", actionUps);
                llenarRegListEjecAdelaMatProy(responseUps);
                limpiarRegListEjecAdelaMatProy();
            }
        });
    });
    $("#formRegInfoProyecto3_4").submit(function (evt) {
        evt.preventDefault();
        $.ajax({
            dataType: 'json',
            type: 'post',
            url: $(this).attr("action"),
            data: $(this).serialize(),
            success: function (responseUps) {
                $("#tdEjecAdelaMatRegInfoProy").empty();
                $("#tdEjecAdelaMatRegInfoProy").append(responseUps.ejecuAdelaMatNro);
                var actionUps = "./Proyectos?tipo=00_3_1&cod_siaf=" + responseUps.proyecCodSiaf + "&ejecAdelaNro=" + responseUps.ejecuAdelaMatNro + "&ejec_tipo=m";
                $("#formRegInfoProyecto3_3").attr("action", actionUps);
                llenarRegListEjecAdelaMatProy(responseUps);
            }
        });
    });
    $("#formRegInfoProyecto4_1").submit(function (evt) {
        evt.preventDefault();
        $.ajax({
            dataType: 'json',
            type: 'post',
            url: $(this).attr("action"),
            data: $(this).serialize(),
            success: function (responseUps) {
                if (responseUps.estado) {
                    $("#tdAmpRegInfoProy").empty();
                    $("#tdAmpRegInfoProy").append(responseUps.ampReg);
                    var actionUps = "./Proyectos?tipo=00_4_1&cod_siaf=" + responseUps.proyecCodSiaf + "&num_amp=" + responseUps.ampReg;
                    $("#formRegInfoProyecto4_1").attr("action", actionUps);
                    llenarRegListAmpliaProy(responseUps);
                    limpiarRegListAmpliaProy();
                } else {
                    alertify.log(responseUps.msg);
                }
            }
        });
    });
    $("#formRegInfoProyecto4_2").submit(function (evt) {
        evt.preventDefault();
        $.ajax({
            dataType: 'json',
            type: 'post',
            url: $(this).attr("action"),
            data: $(this).serialize(),
            success: function (responseUps) {
                if (responseUps.estado) {
                    $("#tdAmpRegInfoProy").empty();
                    $("#tdAmpRegInfoProy").append(responseUps.ampReg);
                    var actionUps = "./Proyectos?tipo=00_4_1&cod_siaf=" + responseUps.proyecCodSiaf + "&num_amp=" + responseUps.ampReg;
                    $("#formRegInfoProyecto4_1").attr("action", actionUps);
                    llenarRegListAmpliaProy(responseUps);
                    limpiarRegListAmpliaProy();
                } else {
                    alertify.log(responseUps.msg);
                }
            }
        });
    });
    $("#formRegInfoProyecto5_1").submit(function (evt) {
        evt.preventDefault();
        $.ajax({
            dataType: 'json',
            type: 'post',
            url: $(this).attr("action"),
            data: $(this).serialize(),
            success: function (responseUps) {
                if (responseUps.estado) {
                    $("#tdPasuRegInfoProy").empty();
                    $("#tdPasuRegInfoProy").append(responseUps.pasuReg);
                    var actionUps = "./Proyectos?tipo=00_5_1&cod_siaf=" + responseUps.proyecCodSiaf + "&num_pasu=" + responseUps.pasuReg;
                    $("#formRegInfoProyecto5_1").attr("action", actionUps);
                    llenarRegListParaSuspProy(responseUps);
                    limpiarRegListParaSuspProy();
                } else {
                    alertify.log(responseUps.msg);
                }
            }
        });
    });
    $("#formRegInfoProyecto5_2").submit(function (evt) {
        evt.preventDefault();
        $.ajax({
            dataType: 'json',
            type: 'post',
            url: $(this).attr("action"),
            data: $(this).serialize(),
            success: function (responseUps) {
                if (responseUps.estado) {
                    $("#tdPasuRegInfoProy").empty();
                    $("#tdPasuRegInfoProy").append(responseUps.pasuReg);
                    var actionUps = "./Proyectos?tipo=00_5_1&cod_siaf=" + responseUps.proyecCodSiaf + "&num_pasu=" + responseUps.pasuReg;
                    $("#formRegInfoProyecto5_1").attr("action", actionUps);
                    llenarRegListParaSuspProy(responseUps);
                    limpiarRegListParaSuspProy();
                } else {
                    alertify.log(responseUps.msg);
                }
            }
        });
    });
    $("#formRegInfoProyecto6").submit(function (evt) {
        evt.preventDefault();
        var form = $('#formRegInfoProyecto6')[0];
        var data = new FormData(form);
        $.ajax({
            dataType: 'json',
            processData: false,
            url: $(this).attr("action"),
            method: "POST",
            data: data,
            contentType: false,
            success: function (responseUpd) {
                llenarRegListContratoProy(responseUpd);
            }
        });
    });
    $("#formRegInfoProyecto7").submit(function (evt) {
        evt.preventDefault();
        $.ajax({
            dataType: 'json',
            type: 'post',
            url: $(this).attr("action"),
            data: $(this).serialize(),
            success: function (responseUpd) {
                llenarRegListCompoProy(responseUpd);
            }
        });
    });
    $("#formRegInfoProyecto8_1").submit(function (evt) {
        evt.preventDefault();
        $.ajax({
            dataType: 'json',
            type: 'post',
            url: $(this).attr("action"),
            data: $(this).serialize(),
            success: function (responseIns) {
                if (responseIns.estado) {
                    $("#tableCalRegInfoProyCont3").empty();
                    llenarRegListCalendarProy2(responseIns);
                } else {
                    toastr.options.closeButton = true;
                    toastr.options.timeOut = 2500;
                    toastr.options.positionClass = "toast-middle-center";
                    toastr.warning("Ya existe el mes para este año!!", 'Calendario');
                }
            }
        });
    });
    $("#formRegInfoProyecto8_3").submit(function (evt) {
        evt.preventDefault();
        $.ajax({
            dataType: 'json',
            type: 'post',
            url: $(this).attr("action"),
            data: $(this).serialize(),
            success: function (responseUps) {
                llenarRegListCalendarProy2(responseUps);
                $("#trCalRegInfoProy" + responseUps.idxTr).addClass("tr-row-editable");
                llenarRegListCalendarProy3(responseUps.proyecCodSiaf, responseUps.ano, responseUps.mes, responseUps.idxTr);
                //$('html,body').animate({
                //    scrollTop: $("#tableCalRegInfoProyCont3").offset().top - 10},
                //        'fast');
            }
        });
    });
    $("#formRegInfoProyecto9").submit(function (evt) {
        evt.preventDefault();
        $.ajax({
            dataType: 'json',
            type: 'post',
            url: $(this).attr("action"),
            data: $(this).serialize(),
            success: function (responseUpd) {
                llenarRegListUbigeoProy(responseUpd);
            }
        });
    });
    $("#formRegInfoProyecto10_1").submit(function (evt) {
        toastr.options.closeButton = true;
        toastr.options.timeOut = 2500;
        evt.preventDefault();
        var form = new FormData($("#formRegInfoProyecto10_1")[0]);
        $.ajax({
            dataType: 'json',
            processData: false,
            url: $(this).attr("action"),
            method: "POST",
            data: form,
            contentType: false,
            success: function (responseIns) {
                if (responseIns.estado) {
                    limpiarRegListFotosProy();
                    llenarRegListFotosProy(responseIns);
                } else {
                    toastr.options.positionClass = "toast-middle-center";
                    toastr.warning(responseIns.msg, 'Galería de Fotos');
                }
            }
        });
    });
    $("#formRegInfoProyecto10_3").submit(function (evt) {
        evt.preventDefault();
        var form = new FormData($("#formRegInfoProyecto10_3")[0]);
        $.ajax({
            dataType: 'json',
            processData: false,
            url: $(this).attr("action"),
            method: "POST",
            data: form,
            contentType: false,
            success: function (responseUpd) {
                llenarRegListFotosProy(responseUpd);
            }
        });
    });

}

function limpiarRegListEstEtapProy() {
    $("input[name=etapaEstFecha]").val("");
    $("input[name=etapaEstDocu]").val("");
    $("input[name=etapaEstCont]").val("");
    $("input[name=etapaEstResp]").val("");
}

function llenarRegListEstEtapProy(response) {
    var codigo = response.proyecCodSiaf;
    $("#tableEstRegInfoProyCont2Body").empty();
    $.each(response.listEstudioEtapa, function (index, value) {
        var presetEtapa = value.presetEtapa;
        var presetFechaAproba;
        if (!$.trim(value.presetFechaAproba)) {
            presetFechaAproba = "";
        } else {
            presetFechaAproba = castDateString(value.presetFechaAproba);
        }
        var presetDocAproba;
        if (!$.trim(value.presetDocAproba)) {
            presetDocAproba = "";
        } else {
            presetDocAproba = value.presetDocAproba;
        }
        var presetContrato;
        if (!$.trim(value.presetContrato)) {
            presetContrato = "";
        } else {
            presetContrato = value.presetContrato;
        }
        var presetResponsable;
        if (!$.trim(value.presetResponsable)) {
            presetResponsable = "";
        } else {
            presetResponsable = value.presetResponsable;
        }
        var body = "<tr id='trEstEtapRegInfoProy" + presetEtapa + "' class='tr-row-table'>\
                      <td style='text-align: center;'>" + presetEtapa + "</td>\
                      <td style='text-align: center;'>" + presetFechaAproba + "</td>\
                      <td style='text-align: left;'>" + presetDocAproba + "</td>\
                      <td style='text-align: left;'>" + presetContrato + "</td>\
                      <td style='text-align: left;'>" + presetResponsable + "</td>\
                      <td style='text-align: center;'>\
                        <button id='btnEditEstEtapRegInfoProy" + presetEtapa + "' type='button' title='Editar' class='btn btn-default btn-sm'>\
                          <i class='fa fa-edit'></i>\
                        </button>\
                        <button id='btnDelEstEtapRegInfoProy" + presetEtapa + "' type='button' title='Eliminar' class='btn btn-danger btn-sm no-edit'>\
                          <i class='fa fa-trash no-edit'></i>\
                        </button>\
                      </td>\
                    </tr>";
        $("#tableEstRegInfoProyCont2Body").append(body);
        $("#btnDelEstEtapRegInfoProy" + presetEtapa).click(function () {
            alertify.confirm("¿Está seguro que desea eliminar este registro?", function (evt) {
                if (evt) {
                    $.ajax({
                        dataType: 'json',
                        url: "./Proyectos?tipo=00_1_3&cod_siaf=" + codigo + "&etapa_est=" + presetEtapa,
                        success: function (responseDel) {
                            $("#tdEstRegInfoProy").empty();
                            $("#tdEstRegInfoProy").append(responseDel.etapaEst);
                            var actionDel = "./Proyectos?tipo=00_1_2&cod_siaf=" + responseDel.proyecCodSiaf + "&etapa_est=" + responseDel.etapaEst;
                            $("#formRegInfoProyecto1_2").attr("action", actionDel);
                            llenarRegListEstEtapProy(responseDel);
                        }
                    });
                }
            });
        });
    });

    $('#tableEstRegInfoProyCont2Body').on('click', 'tr.tr-row-table', function (evt) {

        if (!$(evt.target).hasClass('no-edit')) {

            $('#tableEstRegInfoProyCont2Body tr.tr-row-table').removeClass('hide');
            $("#trEstEtapRegInfoProyForm").remove();
            var array = [];
            $("#" + $(this).attr('id') + " td").each(function () {
                array.push($(this).text());
            });
            var actionUpd = "./Proyectos?tipo=00_1_2&cod_siaf=" + codigo + "&etapa_est=" + array[0];
            $("#formRegInfoProyecto1_3").attr("action", actionUpd);
            var input = '<tr id="trEstEtapRegInfoProyForm" class="tr-row-editable">\
                            <td style="text-align: center;">' + array[0] + '</td>\
                            <td style="text-align: center;">\
                              <input name="etapaEstFecha" type="date" class="col-form-date" data-date-format="dd/mm/yyyy" value="' + castDateString1(array[1]) + '" required>\
                            </td>\
                            <td style="text-align: left;">\
                              <input name="etapaEstDocu" type="text" class="form-control uppercase" value="' + array[2] + '" required>\
                            </td>\
                            <td style="text-align: left;">\
                              <input name="etapaEstCont" type="text" class="form-control uppercase" value="' + array[3] + '" required>\
                            </td>\
                            <td style="text-align: left;">\
                              <input name="etapaEstResp" type="text" class="form-control uppercase" value="' + array[4] + '" required>\
                            </td>\
                            <td style="text-align: center;">\
                              <button type="submit" id="btnUpdEstEtapRegInfoProy" title="Actualizar" class="btn btn-success btn-sm">\
                                <i class="fa fa-check"></i>\
                              </button>\
                              <button type="button" id="btnCanEstEtapRegInfoProy" title="Cancelar" class="btn btn-warning btn-sm">\
                                <i class="fa fa-remove"></i>\
                              </button>\
                            </td>\
                         </tr>';
            $("#" + $(this).attr('id')).before(input);
            $(this).addClass('hide');

            $("#btnCanEstEtapRegInfoProy").click(function () {
                $('#tableEstRegInfoProyCont2Body tr.tr-row-table').removeClass('hide');
                $("#trEstEtapRegInfoProyForm").remove();
            });

        }

    });
}

function limpiarRegListSuperAdelaProy() {
    $("input[name=superMontoAdela]").val("");
    $("input[name=superFechaAdela]").val("");
    $("textarea[name=superComentAdela]").val("");
}

function llenarRegListSuperAdelaProy(response) {
    var codigo = response.proyecCodSiaf;
    var prsuadMontoT = 0.00;
    $("#tableSupRegInfoProyCont2Body").empty();
    $("#tableSupRegInfoProyCont2Foot").empty();
    $.each(response.listSuperAdela, function (index, value) {
        var prsuadNro = value.prsuadNro;
        var prsuadMonto;
        if (!$.trim(value.prsuadMonto)) {
            prsuadMonto = "";
        } else {
            prsuadMonto = formatNumeroDecimal(value.prsuadMonto);
            prsuadMontoT += value.prsuadMonto;
        }
        var prsuadFecha;
        if (!$.trim(value.prsuadFecha)) {
            prsuadFecha = "";
        } else {
            prsuadFecha = castDateString(value.prsuadFecha);
        }
        var prsuadComentario = value.prsuadComentario;
        var body = "<tr id='trSupAdelaRegInfoProy" + prsuadNro + "' class='tr-row-table'>\
                      <td style='text-align: center;'>" + prsuadNro + "</td>\
                      <td style='text-align: center;'>" + prsuadMonto + "</td>\
                      <td style='text-align: center;'>" + prsuadFecha + "</td>\
                      <td style='text-align: left;'>" + prsuadComentario + "</td>\
                      <td style='text-align: center;'>\
                        <button id='btnEditSupAdelaRegInfoProy" + prsuadNro + "' type='button' title='Editar' class='btn btn-default btn-sm'>\
                          <i class='fa fa-edit'></i>\
                        </button>\
                        <button id='btnDelSupAdelaRegInfoProy" + prsuadNro + "' type='button' title='Eliminar' class='btn btn-danger btn-sm no-edit'>\
                          <i class='fa fa-trash no-edit'></i>\
                        </button>\
                      </td>\
                    </tr>";
        $("#tableSupRegInfoProyCont2Body").append(body);
        $("#btnDelSupAdelaRegInfoProy" + prsuadNro).click(function () {
            alertify.confirm("¿Está seguro que desea eliminar este registro?", function (evt) {
                if (evt) {
                    $.ajax({
                        dataType: 'json',
                        url: "./Proyectos?tipo=00_2_2&cod_siaf=" + codigo + "&super_adela=" + prsuadNro,
                        success: function (responseDel) {
                            $("#tdSupRegInfoProy").empty();
                            $("#tdSupRegInfoProy").append(responseDel.supervAdela);
                            var actionDel = "./Proyectos?tipo=00_2_1&cod_siaf=" + responseDel.proyecCodSiaf + "&super_adela=" + responseDel.supervAdela;
                            $("#formRegInfoProyecto2_1").attr("action", actionDel);
                            llenarRegListSuperAdelaProy(responseDel);
                        }
                    });
                }
            });
        });
    });
    var foot = "<tr class='total'>\
                  <td style='text-align: center;'><b>TOTAL</b></td>\
                  <td style='text-align: center;'><b>" + formatNumeroDecimal(prsuadMontoT) + "</b></td>\
                  <td></td>\
                  <td></td>\
                  <td></td>\
                </tr>";
    $("#tableSupRegInfoProyCont2Foot").append(foot);

    $('#tableSupRegInfoProyCont2Body').on('click', 'tr.tr-row-table', function (evt) {

        if (!$(evt.target).hasClass('no-edit')) {

            $('#tableSupRegInfoProyCont2Body tr.tr-row-table').removeClass('hide');
            $("#trSupAdelaRegInfoProyForm").remove();
            var array = [];
            $("#" + $(this).attr('id') + " td").each(function () {
                array.push($(this).text());
            });
            var actionUpd = "./Proyectos?tipo=00_2_1&cod_siaf=" + codigo + "&super_adela=" + array[0];
            $("#formRegInfoProyecto2_3").attr("action", actionUpd);
            var input = '<tr id="trSupAdelaRegInfoProyForm" class="tr-row-editable">\
                            <td style="text-align: center;">' + array[0] + '</td>\
                            <td style="text-align: center;">\
                              <input name="superMontoAdela" type="text" class="form-control" value="' + array[1].replace(/,/g, '') + '" onkeypress="return soloNumDecimal(event, this.value)">\
                            </td>\
                            <td style="text-align: center;">\
                              <input name="superFechaAdela" type="date" class="col-form-date" data-date-format="dd/mm/yyyy" value="' + castDateString1(array[2]) + '" required>\
                            </td>\
                            <td style="text-align: left;">\
                              <textarea name="superComentAdela" rows="2" class="form-control no-resize" form="formRegInfoProyecto2_3">' + array[3].trim() + '</textarea>\
                            </td>\
                            <td style="text-align: center;">\
                              <button type="submit" id="btnUpdSupAdelaRegInfoProy" title="Actualizar" class="btn btn-success btn-sm">\
                                <i class="fa fa-check"></i>\
                              </button>\
                              <button type="button" id="btnCanSupAdelaRegInfoProy" title="Cancelar" class="btn btn-warning btn-sm">\
                                <i class="fa fa-remove"></i>\
                              </button>\
                            </td>\
                         </tr>';
            $("#" + $(this).attr('id')).before(input);
            $(this).addClass('hide');

            $("#btnCanSupAdelaRegInfoProy").click(function () {
                $('#tableSupRegInfoProyCont2Body tr.tr-row-table').removeClass('hide');
                $("#trSupAdelaRegInfoProyForm").remove();
            });

        }

    });
}

function limpiarRegListEjecAdelaDirProy() {
    $("input[name=ejecMontoAdelaDirec]").val("");
    $("input[name=ejecFechaAdelaDirec]").val("");
    $("textarea[name=ejecComentAdelaDirec]").val("");
}

function llenarRegListEjecAdelaDirProy(response) {
    var codigo = response.proyecCodSiaf;
    var prejadMontoT = 0.00;
    $("#tableEjecAdelaDirRegInfoProyCont2Body").empty();
    $("#tableEjecAdelaDirRegInfoProyCont2Foot").empty();
    $.each(response.listEjecAdDir, function (index, value) {
        var prejadNro = value.prejadNro;
        var prejadMonto;
        if (!$.trim(value.prejadMonto)) {
            prejadMonto = "";
        } else {
            prejadMonto = formatNumeroDecimal(value.prejadMonto);
            prejadMontoT += value.prejadMonto;
        }
        var prejadFecha;
        if (!$.trim(value.prejadFecha)) {
            prejadFecha = "";
        } else {
            prejadFecha = castDateString(value.prejadFecha);
        }
        var prejadComentario = value.prejadComentario;
        var body = "<tr id='trEjecAdelaDirRegInfoProy" + prejadNro + "' class='tr-row-table'>\
                      <td style='text-align: center;'>" + prejadNro + "</td>\
                      <td style='text-align: center;'>" + prejadMonto + "</td>\
                      <td style='text-align: center;'>" + prejadFecha + "</td>\
                      <td style='text-align: left;'>" + prejadComentario + "</td>\
                      <td style='text-align: center;'>\
                        <button id='btnEditEjecAdelaDirRegInfoProy" + prejadNro + "' type='button' title='Editar' class='btn btn-default btn-sm'>\
                          <i class='fa fa-edit'></i>\
                        </button>\
                        <button id='btnDelEjecAdelaDirRegInfoProy" + prejadNro + "' type='button' title='Eliminar' class='btn btn-danger btn-sm no-edit'>\
                          <i class='fa fa-trash no-edit'></i>\
                        </button>\
                      </td>\
                    </tr>";
        $("#tableEjecAdelaDirRegInfoProyCont2Body").append(body);
        $("#btnDelEjecAdelaDirRegInfoProy" + prejadNro).click(function () {
            alertify.confirm("¿Está seguro que desea eliminar este registro?", function (evt) {
                if (evt) {
                    $.ajax({
                        dataType: 'json',
                        url: "./Proyectos?tipo=00_3_2&cod_siaf=" + codigo + "&ejecAdelaNro=" + prejadNro + "&ejec_tipo=d",
                        success: function (responseDel) {
                            $("#tdEjecAdelaDirRegInfoProy").empty();
                            $("#tdEjecAdelaDirRegInfoProy").append(responseDel.ejecuAdelaDirNro);
                            var actionDel = "./Proyectos?tipo=00_3_1&cod_siaf=" + responseDel.proyecCodSiaf + "&ejecAdelaNro=" + responseDel.ejecuAdelaDirNro + "&ejec_tipo=d";
                            $("#formRegInfoProyecto3_1").attr("action", actionDel);
                            llenarRegListEjecAdelaDirProy(responseDel);
                        }
                    });
                }
            });
        });
    });
    var foot = "<tr class='total'>\
                  <td style='text-align: center;'><b>TOTAL</b></td>\
                  <td style='text-align: center;'><b>" + formatNumeroDecimal(prejadMontoT) + "</b></td>\
                  <td></td>\
                  <td></td>\
                  <td></td>\
                </tr>";
    $("#tableEjecAdelaDirRegInfoProyCont2Foot").append(foot);

    $('#tableEjecAdelaDirRegInfoProyCont2Body').on('click', 'tr.tr-row-table', function (evt) {

        if (!$(evt.target).hasClass('no-edit')) {

            $('#tableEjecAdelaDirRegInfoProyCont2Body tr.tr-row-table').removeClass('hide');
            $("#trEjecAdelaDirRegInfoProyForm").remove();
            var array = [];
            $("#" + $(this).attr('id') + " td").each(function () {
                array.push($(this).text());
            });
            var actionUpd = "./Proyectos?tipo=00_3_1&cod_siaf=" + codigo + "&ejecAdelaNro=" + array[0] + "&ejec_tipo=d";
            $("#formRegInfoProyecto3_2").attr("action", actionUpd);
            var input = '<tr id="trEjecAdelaDirRegInfoProyForm" class="tr-row-editable">\
                            <td style="text-align: center;">' + array[0] + '</td>\
                            <td style="text-align: center;">\
                              <input name="ejecMontoAdelaDirec" type="text" class="form-control" value="' + array[1].replace(/,/g, '') + '" onkeypress="return soloNumDecimal(event, this.value)">\
                            </td>\
                            <td style="text-align: center;">\
                              <input name="ejecFechaAdelaDirec" type="date" class="col-form-date" data-date-format="dd/mm/yyyy" value="' + castDateString1(array[2]) + '" required>\
                            </td>\
                            <td style="text-align: left;">\
                              <textarea name="ejecComentAdelaDirec" rows="2" class="form-control no-resize" form="formRegInfoProyecto3_2">' + array[3].trim() + '</textarea>\
                            </td>\
                            <td style="text-align: center;">\
                              <button type="submit" id="btnUpdEjecAdelaDirRegInfoProy" title="Actualizar" class="btn btn-success btn-sm">\
                                <i class="fa fa-check"></i>\
                              </button>\
                              <button type="button" id="btnCanEjecAdelaDirRegInfoProy" title="Cancelar" class="btn btn-warning btn-sm">\
                                <i class="fa fa-remove"></i>\
                              </button>\
                            </td>\
                         </tr>';
            $("#" + $(this).attr('id')).before(input);
            $(this).addClass('hide');

            $("#btnCanEjecAdelaDirRegInfoProy").click(function () {
                $('#tableEjecAdelaDirRegInfoProyCont2Body tr.tr-row-table').removeClass('hide');
                $("#trEjecAdelaDirRegInfoProyForm").remove();
            });

        }

    });
}

function limpiarRegListEjecAdelaMatProy() {
    $("input[name=ejecMontoAdelaMateria]").val("");
    $("input[name=ejecFechaAdelaMateria]").val("");
    $("textarea[name=ejecComentAdelaMateria]").val("");
}

function llenarRegListEjecAdelaMatProy(response) {
    var codigo = response.proyecCodSiaf;
    var prejadMontoT = 0.00;
    $("#tableEjecAdelaMatRegInfoProyCont2Body").empty();
    $("#tableEjecAdelaMatRegInfoProyCont2Foot").empty();
    $.each(response.listEjecAdMat, function (index, value) {
        var prejadNro = value.prejadNro;
        var prejadMonto;
        if (!$.trim(value.prejadMonto)) {
            prejadMonto = "";
        } else {
            prejadMonto = formatNumeroDecimal(value.prejadMonto);
            prejadMontoT += value.prejadMonto;
        }
        var prejadFecha;
        if (!$.trim(value.prejadFecha)) {
            prejadFecha = "";
        } else {
            prejadFecha = castDateString(value.prejadFecha);
        }
        var prejadComentario = value.prejadComentario;
        var body = "<tr id='trEjecAdelaMatRegInfoProy" + prejadNro + "' class='tr-row-table'>\
                      <td style='text-align: center;'>" + prejadNro + "</td>\
                      <td style='text-align: center;'>" + prejadMonto + "</td>\
                      <td style='text-align: center;'>" + prejadFecha + "</td>\
                      <td style='text-align: left;'>" + prejadComentario + "</td>\
                      <td style='text-align: center;'>\
                        <button id='btnEditEjecAdelaMatRegInfoProy" + prejadNro + "' type='button' title='Editar' class='btn btn-default btn-sm'>\
                          <i class='fa fa-edit'></i>\
                        </button>\
                        <button id='btnDelEjecAdelaMatRegInfoProy" + prejadNro + "' type='button' title='Eliminar' class='btn btn-danger btn-sm no-edit'>\
                          <i class='fa fa-trash no-edit'></i>\
                        </button>\
                      </td>\
                    </tr>";
        $("#tableEjecAdelaMatRegInfoProyCont2Body").append(body);
        $("#btnDelEjecAdelaMatRegInfoProy" + prejadNro).click(function () {
            alertify.confirm("¿Está seguro que desea eliminar este registro?", function (evt) {
                if (evt) {
                    $.ajax({
                        dataType: 'json',
                        url: "./Proyectos?tipo=00_3_2&cod_siaf=" + codigo + "&ejecAdelaNro=" + prejadNro + "&ejec_tipo=m",
                        success: function (responseDel) {
                            $("#tdEjecAdelaMatRegInfoProy").empty();
                            $("#tdEjecAdelaMatRegInfoProy").append(responseDel.ejecuAdelaMatNro);
                            var actionDel = "./Proyectos?tipo=00_3_1&cod_siaf=" + responseDel.proyecCodSiaf + "&ejecAdelaNro=" + responseDel.ejecuAdelaMatNro + "&ejec_tipo=m";
                            $("#formRegInfoProyecto3_3").attr("action", actionDel);
                            llenarRegListEjecAdelaMatProy(responseDel);
                        }
                    });
                }
            });
        });
    });
    var foot = "<tr class='total'>\
                  <td style='text-align: center;'><b>TOTAL</b></td>\
                  <td style='text-align: center;'><b>" + formatNumeroDecimal(prejadMontoT) + "</b></td>\
                  <td></td>\
                  <td></td>\
                  <td></td>\
                </tr>";
    $("#tableEjecAdelaMatRegInfoProyCont2Foot").append(foot);

    $('#tableEjecAdelaMatRegInfoProyCont2Body').on('click', 'tr.tr-row-table', function (evt) {

        if (!$(evt.target).hasClass('no-edit')) {

            $('#tableEjecAdelaMatRegInfoProyCont2Body tr.tr-row-table').removeClass('hide');
            $("#trEjecAdelaMatRegInfoProyForm").remove();
            var array = [];
            $("#" + $(this).attr('id') + " td").each(function () {
                array.push($(this).text());
            });
            var actionUpd = "./Proyectos?tipo=00_3_1&cod_siaf=" + codigo + "&ejecAdelaNro=" + array[0] + "&ejec_tipo=m";
            $("#formRegInfoProyecto3_4").attr("action", actionUpd);
            var input = '<tr id="trEjecAdelaMatRegInfoProyForm" class="tr-row-editable">\
                            <td style="text-align: center;">' + array[0] + '</td>\
                            <td style="text-align: center;">\
                              <input name="ejecMontoAdelaMateria" type="text" class="form-control" value="' + array[1].replace(/,/g, '') + '" onkeypress="return soloNumDecimal(event, this.value)">\
                            </td>\
                            <td style="text-align: center;">\
                              <input name="ejecFechaAdelaMateria" type="date" class="col-form-date" data-date-format="dd/mm/yyyy" value="' + castDateString1(array[2]) + '" required>\
                            </td>\
                            <td style="text-align: left;">\
                              <textarea name="ejecComentAdelaMateria" rows="2" class="form-control no-resize" form="formRegInfoProyecto3_4">' + array[3].trim() + '</textarea>\
                            </td>\
                            <td style="text-align: center;">\
                              <button type="submit" id="btnUpdEjecAdelaMatRegInfoProy" title="Actualizar" class="btn btn-success btn-sm">\
                                <i class="fa fa-check"></i>\
                              </button>\
                              <button type="button" id="btnCanEjecAdelaMatRegInfoProy" title="Cancelar" class="btn btn-warning btn-sm">\
                                <i class="fa fa-remove"></i>\
                              </button>\
                            </td>\
                         </tr>';
            $("#" + $(this).attr('id')).before(input);
            $(this).addClass('hide');

            $("#btnCanEjecAdelaMatRegInfoProy").click(function () {
                $('#tableEjecAdelaMatRegInfoProyCont2Body tr.tr-row-table').removeClass('hide');
                $("#trEjecAdelaMatRegInfoProyForm").remove();
            });

        }

    });
}

function limpiarRegListAmpliaProy() {
    $("input[name=ampliaFecha]").val("");
    $("input[name=ampliaDias]").val("");
    $("input[name=ampliaDocu]").val("");
}

function llenarRegListAmpliaProy(response) {
    var codigo = response.proyecCodSiaf;
    $("#tableAmpRegInfoProyCont2Body").empty();
    $.each(response.listAmplia, function (index, value) {
        var pramNro = value.pramNro;
        var pramFecha;
        if (!$.trim(value.pramFecha)) {
            pramFecha = "";
        } else {
            pramFecha = castDateString(value.pramFecha);
        }
        var pramDias;
        if (!$.trim(value.pramDias)) {
            pramDias = "";
        } else {
            pramDias = value.pramDias;
        }
        var pramDocumento = value.pramDocumento;
        var pramProcedente;
        if (value.pramProcedente) {
            pramProcedente = '<span class="label label-success">Procedente</span>';
        } else {
            pramProcedente = '<span class="label label-danger">Improcedente</span>';
        }
        var body = "<tr id='trAmpRegInfoProy" + pramNro + "' class='tr-row-table'>\
                      <td style='text-align: center;'>" + pramNro + "</td>\
                      <td style='text-align: center;'>" + pramFecha + "</td>\
                      <td style='text-align: center;'>" + pramDias + "</td>\
                      <td style='text-align: left;'>" + pramDocumento + "</td>\
                      <td style='text-align: center;'>" + pramProcedente + "</td>\
                      <td style='text-align: center;'>\
                        <button id='btnEditAmpRegInfoProy" + pramNro + "' type='button' title='Editar' class='btn btn-default btn-sm'>\
                          <i class='fa fa-edit'></i>\
                        </button>\
                        <button id='btnDelAmpRegInfoProy" + pramNro + "' type='button' title='Eliminar' class='btn btn-danger btn-sm no-edit'>\
                          <i class='fa fa-trash no-edit'></i>\
                        </button>\
                      </td>\
                    </tr>";
        $("#tableAmpRegInfoProyCont2Body").append(body);
        $("#btnDelAmpRegInfoProy" + pramNro).click(function () {
            alertify.confirm("¿Está seguro que desea eliminar este registro?", function (evt) {
                if (evt) {
                    $.ajax({
                        dataType: 'json',
                        url: "./Proyectos?tipo=00_4_2&cod_siaf=" + codigo + "&num_amp=" + pramNro,
                        success: function (responseDel) {
                            $("#tdAmpRegInfoProy").empty();
                            $("#tdAmpRegInfoProy").append(responseDel.ampReg);
                            var actionDel = "./Proyectos?tipo=00_4_1&cod_siaf=" + responseDel.proyecCodSiaf + "&num_amp=" + responseDel.ampReg;
                            $("#formRegInfoProyecto4_1").attr("action", actionDel);
                            llenarRegListAmpliaProy(responseDel);
                        }
                    });
                }
            });
        });
    });

    $('#tableAmpRegInfoProyCont2Body').on('click', 'tr.tr-row-table', function (evt) {

        if (!$(evt.target).hasClass('no-edit')) {

            $('#tableAmpRegInfoProyCont2Body tr.tr-row-table').removeClass('hide');
            $("#trAmpRegInfoProyForm").remove();
            var array = [];
            $("#" + $(this).attr('id') + " td").each(function () {
                array.push($(this).text());
            });
            var actionUpd = "./Proyectos?tipo=00_4_1&cod_siaf=" + codigo + "&num_amp=" + array[0];
            $("#formRegInfoProyecto4_2").attr("action", actionUpd);
            var checked;
            if (array[4].toLowerCase() === "procedente") {
                checked = "checked";
            } else {
                checked = "";
            }
            var input = '<tr id="trAmpRegInfoProyForm" class="tr-row-editable">\
                            <td style="text-align: center;">' + array[0] + '</td>\
                            <td style="text-align: center;">\
                              <input name="ampliaFecha" type="date" class="col-form-date" data-date-format="dd/mm/yyyy" value="' + castDateString1(array[1]) + '" required>\
                            </td>\
                            <td style="text-align: center;">\
                              <input name="ampliaDias" type="text" class="form-control" onkeypress="return soloNumero(event)" value="' + array[2] + '" required>\
                            </td>\
                            <td style="text-align: left;">\
                              <input name="ampliaDocu" type="text" class="form-control uppercase" value="' + array[3] + '" required>\
                            </td>\
                            <td style="text-align: center;">\
                              <label class="custom-control custom-checkbox" style="font-weight: normal;">\
                                <input name="ampliaEstado" type="checkbox" class="custom-control-input" value="ok" ' + checked + '>\
                                <span class="custom-control-indicator"></span>&nbsp;&nbsp;\
                                <span class="custom-control-description">Procedente</span>\
                              </label>\
                            </td>\
                            <td style="text-align: center;">\
                              <button type="submit" id="btnUpdAmpRegInfoProy" title="Actualizar" class="btn btn-success btn-sm">\
                                <i class="fa fa-check"></i>\
                              </button>\
                              <button type="button" id="btnCanAmpRegInfoProy" title="Cancelar" class="btn btn-warning btn-sm">\
                                <i class="fa fa-remove"></i>\
                              </button>\
                            </td>\
                         </tr>';
            $("#" + $(this).attr('id')).before(input);
            $(this).addClass('hide');

            $("#btnCanAmpRegInfoProy").click(function () {
                $('#tableAmpRegInfoProyCont2Body tr.tr-row-table').removeClass('hide');
                $("#trAmpRegInfoProyForm").remove();
            });

        }

    });
}

function limpiarRegListParaSuspProy() {
    $("input[name=parasusFecha]").val("");
    $("input[name=parasusDias]").val("");
    $("input[name=parasusDocu]").val("");
}

function llenarRegListParaSuspProy(response) {
    var codigo = response.proyecCodSiaf;
    $("#tablePasuRegInfoProyCont2Body").empty();
    $.each(response.listParaSusp, function (index, value) {
        var prpsNro = value.prpsNro;
        var prpsFecha;
        if (!$.trim(value.prpsFecha)) {
            prpsFecha = "";
        } else {
            prpsFecha = castDateString(value.prpsFecha);
        }
        var prpsDias;
        if (!$.trim(value.prpsDias)) {
            prpsDias = "";
        } else {
            prpsDias = value.prpsDias;
        }
        var prpsDocumento = value.prpsDocumento;
        var prpsTipo = value.prpsTipo;
        var body = "<tr id='trPasuRegInfoProy" + prpsNro + "' class='tr-row-table'>\
                      <td style='text-align: center;'>" + prpsNro + "</td>\
                      <td style='text-align: center;'>" + prpsFecha + "</td>\
                      <td style='text-align: center;'>" + prpsDias + "</td>\
                      <td style='text-align: left;'>" + prpsDocumento + "</td>\
                      <td style='text-align: center;'>" + prpsTipo + "</td>\
                      <td style='text-align: center;'>\
                        <button id='btnEditPasuRegInfoProy" + prpsNro + "' type='button' title='Editar' class='btn btn-default btn-sm'>\
                          <i class='fa fa-edit'></i>\
                        </button>\
                        <button id='btnDelPasuRegInfoProy" + prpsNro + "' type='button' title='Eliminar' class='btn btn-danger btn-sm no-edit'>\
                          <i class='fa fa-trash no-edit'></i>\
                        </button>\
                      </td>\
                    </tr>";
        $("#tablePasuRegInfoProyCont2Body").append(body);
        $("#btnDelPasuRegInfoProy" + prpsNro).click(function () {
            alertify.confirm("¿Está seguro que desea eliminar este registro?", function (evt) {
                if (evt) {
                    $.ajax({
                        dataType: 'json',
                        url: "./Proyectos?tipo=00_5_2&cod_siaf=" + codigo + "&num_pasu=" + prpsNro,
                        success: function (responseDel) {
                            $("#tdPasuRegInfoProy").empty();
                            $("#tdPasuRegInfoProy").append(responseDel.pasuReg);
                            var actionDel = "./Proyectos?tipo=00_5_1&cod_siaf=" + responseDel.proyecCodSiaf + "&num_pasu=" + responseDel.pasuReg;
                            $("#formRegInfoProyecto5_1").attr("action", actionDel);
                            llenarRegListParaSuspProy(responseDel);
                        }
                    });
                }
            });
        });
    });

    $('#tablePasuRegInfoProyCont2Body').on('click', 'tr.tr-row-table', function (evt) {

        if (!$(evt.target).hasClass('no-edit')) {

            $('#tablePasuRegInfoProyCont2Body tr.tr-row-table').removeClass('hide');
            $("#trPasuRegInfoProyForm").remove();
            var array = [];
            $("#" + $(this).attr('id') + " td").each(function () {
                array.push($(this).text());
            });
            var actionUpd = "./Proyectos?tipo=00_5_1&cod_siaf=" + codigo + "&num_pasu=" + array[0];
            $("#formRegInfoProyecto5_2").attr("action", actionUpd);
            var selectPara;
            var selectSusp;
            if (array[4] === "paralizacion") {
                selectPara = "selected";
                selectSusp = "";
            }
            if (array[4] === "suspension") {
                selectPara = "";
                selectSusp = "selected";
            }
            var input = '<tr id="trPasuRegInfoProyForm" class="tr-row-editable">\
                            <td style="text-align: center;">' + array[0] + '</td>\
                            <td style="text-align: center;">\
                              <input name="parasusFecha" type="date" class="col-form-date" data-date-format="dd/mm/yyyy" value="' + castDateString1(array[1]) + '" required>\
                            </td>\
                            <td style="text-align: center;">\
                              <input name="parasusDias" type="text" class="form-control" onkeypress="return soloNumero(event)" value="' + array[2] + '" required>\
                            </td>\
                            <td style="text-align: left;">\
                              <input name="parasusDocu" type="text" class="form-control uppercase" value="' + array[3] + '" required>\
                            </td>\
                            <td style="text-align: center;">\
                              <select id="listParaSusTipoProy" name="parasusTipo" class="select-form">\
                                <option value="paralizacion" ' + selectPara + '>Paralización</option>\
                                <option value="suspension" ' + selectSusp + '>Suspensión</option>\
                              </select>\
                            </td>\
                            <td style="text-align: center;">\
                              <button type="submit" id="btnUpdPasuRegInfoProy" title="Actualizar" class="btn btn-success btn-sm">\
                                <i class="fa fa-check"></i>\
                              </button>\
                              <button type="button" id="btnCanPasuRegInfoProy" title="Cancelar" class="btn btn-warning btn-sm">\
                                <i class="fa fa-remove"></i>\
                              </button>\
                            </td>\
                         </tr>';
            $("#" + $(this).attr('id')).before(input);
            $(this).addClass('hide');

            $("#btnCanPasuRegInfoProy").click(function () {
                $('#tablePasuRegInfoProyCont2Body tr.tr-row-table').removeClass('hide');
                $("#trPasuRegInfoProyForm").remove();
            });

        }

    });
}

function llenarRegListContratoProy(response) {
    var codigo = response.proyecCodSiaf;
    var dataBase = response.dataBase;
    $("#tableContRegInfoProyContBody").empty();
    $.each(response.listContratos, function (index, value) {
        var prcoOrden = value.prcoOrden;
        var prcoContrato = value.prcoContrato;
        var prcoTipoProceso = value.prcoTipoProceso;
        var prcoContratista = value.prcoContratista;
        var prcoFecha;
        if (!$.trim(value.prcoFechaSuscripcion)) {
            prcoFecha = "";
        } else {
            prcoFecha = castDateString(value.prcoFechaSuscripcion);
        }
        var prcoMonto;
        if (!$.trim(value.prcoMontoSuscripcion)) {
            prcoMonto = "";
        } else {
            prcoMonto = formatNumeroDecimal(value.prcoMontoSuscripcion);
        }
        var prcoUrl = "";
        var prcoImg = "";
        if (dataBase === "servidor") {
            if (!$.trim(value.prcoUrlLinux)) {
                prcoUrl = "no";
                prcoImg = "<img src='./resources/images/no-archivo.png'></img>";
            } else {
                prcoUrl = "si";
                prcoImg = "<a href='./Archivos?tipo=proyectos&url=contratos&cod_siaf=" + codigo + "&contrato_orden=" + prcoOrden + "' target='_blank'>\
                            <img id='imgPdfContRegInfoProy" + prcoOrden + "' src='./resources/images/pdf-icon.png' class='no-edit'></img>\
                           </a>";
            }
        }
        if (dataBase === "local") {
            if (!$.trim(value.prcoUrlWindows)) {
                prcoUrl = "no";
                prcoImg = "<img src='./resources/images/no-archivo.png'></img>";
            } else {
                prcoUrl = "si";
                prcoImg = "<a href='./Archivos?tipo=proyectos&url=contratos&cod_siaf=" + codigo + "&contrato_orden=" + prcoOrden + "' target='_blank'>\
                            <img id='imgPdfContRegInfoProy" + prcoOrden + "' src='./resources/images/pdf-icon.png' class='no-edit'></img>\
                           </a>";
            }
        }
        var body = "<tr id='trContRegInfoProy" + prcoOrden + "' class='tr-row-table'>\
                      <td id='" + prcoOrden + "' style='text-align: center;'>" + (index + 1) + "</td>\
                      <td style='text-align: left;'>" + prcoContrato + "</td>\
                      <td style='text-align: left;'>" + prcoTipoProceso + "</td>\
                      <td style='text-align: left;'>" + prcoContratista + "</td>\
                      <td style='text-align: center;'>" + prcoFecha + "</td>\
                      <td style='text-align: right;'>" + prcoMonto + "</td>\
                      <td id='" + prcoUrl + "' style='text-align: center;'>" + prcoImg + "</td>\
                      <td style='text-align: center;'>\
                        <button id='btnEditContRegInfoProy" + prcoOrden + "' type='button' title='Editar' class='btn btn-default btn-sm'>\
                          <i class='fa fa-edit'></i>\
                        </button>\
                      </td>\
                    </tr>";
        $("#tableContRegInfoProyContBody").append(body);
        $("#btnEditContRegInfoProy" + prcoOrden).click(function () {
            $("#tableContRegInfoProyContBody tr").removeClass("tr-row-editable");
            $("#trContRegInfoProy" + prcoOrden).addClass("tr-row-editable");
        });
    });

    $('#tableContRegInfoProyContBody').on('click', 'tr.tr-row-table', function (evt) {

        if (!$(evt.target).hasClass('no-edit')) {

            $('#tableContRegInfoProyContBody tr.tr-row-table').removeClass('hide');
            $("#trContRegInfoProyForm").remove();
            var array = [];
            var arrayHtml = [];
            $("#" + $(this).attr('id') + " td").each(function () {
                array.push($(this).text());
                arrayHtml.push($(this).attr('id'));
            });
            var required;
            if (arrayHtml[6] === "si") {
                required = "";
            }
            if (arrayHtml[6] === "no") {
                required = "required";
            }
            var actionUpd = "./Proyectos?tipo=00_6&cod_siaf=" + codigo + "&orden=" + arrayHtml[0] + "&archivo=si";
            $("#formRegInfoProyecto6").attr("action", actionUpd);
            var input = '<tr id="trContRegInfoProyForm" class="tr-row-editable">\
                            <td style="text-align: center;">' + array[0] + '</td>\
                            <td style="text-align: left;">' + array[1] + '</td>\
                            <td style="text-align: left;">' + array[2] + '</td>\
                            <td style="text-align: left;">' + array[3] + '</td>\
                            <td style="text-align: center;">' + array[4] + '</td>\
                            <td style="text-align: right;">' + array[5] + '</td>\
                            <td style="text-align: center;">\
                              <input name="archivoCont" id="iptContArchivoUpd" type="file" data-height="80" accept="application/pdf" ' + required + '>\
                            </td>\
                            <td style="text-align: center;">\
                              <button type="submit" id="btnUpdContRegInfoProy" title="Actualizar" class="btn btn-success btn-sm">\
                                <i class="fa fa-check"></i>\
                              </button>\
                              <button type="button" id="btnCanContRegInfoProy" title="Cancelar" class="btn btn-warning btn-sm">\
                                <i class="fa fa-remove"></i>\
                              </button>\
                            </td>\
                         </tr>';
            $("#" + $(this).attr('id')).before(input);
            $(this).addClass('hide');

            $('#iptContArchivoUpd').dropify({
                "messages": {
                    default: '',
                    replace: '',
                    remove: 'x',
                    error: ''
                }
            });
            if (arrayHtml[6] === "si") {
                $('#trContRegInfoProyForm .dropify-wrapper').addClass('has-preview');
                $('#trContRegInfoProyForm .dropify-loader').hide();
                $('#trContRegInfoProyForm .dropify-preview').show();
                $('#trContRegInfoProyForm .dropify-filename-inner').append('archivo.pdf');
                $('#trContRegInfoProyForm .dropify-render').append('<i class="dropify-font-file"></i><span class="dropify-extension">pdf</span>');

                $("button.dropify-clear").click(function () {
                    actionUpd = "./Proyectos?tipo=00_6&cod_siaf=" + codigo + "&orden=" + arrayHtml[0] + "&archivo=no";
                    $("#formRegInfoProyecto6").attr("action", actionUpd);
                });

            }

            $("#btnCanContRegInfoProy").click(function () {
                $('#tableContRegInfoProyContBody tr.tr-row-table').removeClass('hide');
                $("#trContRegInfoProyForm").remove();
            });

        }

    });

}

function llenarRegListCompoProy(response) {
    var codigo = response.proyecCodSiaf;
    $("#tableCompRegInfoProyContBody").empty();
    $("#tableCompRegInfoProyContFoot").empty();
    var prcpMontoViableT = 0.00;
    var prcpMontoEstudioT = 0.00;
    var prcpMontoContratadoT = 0.00;
    var prcpMontoActualizadoT = 0.00;
    $.each(response.listCompon, function (index, value) {
        var prcpOrden = value.prcpOrden;
        var prcpComponente = value.prcpComponente;
        var prcpMontoViable;
        if (!$.trim(value.prcpMontoViable)) {
            prcpMontoViable = "";
        } else {
            prcpMontoViable = formatNumeroDecimal(value.prcpMontoViable);
            prcpMontoViableT += value.prcpMontoViable;
        }
        var prcpMontoEstudio;
        if (!$.trim(value.prcpMontoEstudio)) {
            prcpMontoEstudio = "";
        } else {
            prcpMontoEstudio = formatNumeroDecimal(value.prcpMontoEstudio);
            prcpMontoEstudioT += value.prcpMontoEstudio;
        }
        var prcpMontoContratado;
        if (!$.trim(value.prcpMontoContratado)) {
            prcpMontoContratado = "";
        } else {
            prcpMontoContratado = formatNumeroDecimal(value.prcpMontoContratado);
            prcpMontoContratadoT += value.prcpMontoContratado;
        }
        var prcpMontoActualizado;
        if (!$.trim(value.prcpMontoActualizado)) {
            prcpMontoActualizado = "";
        } else {
            prcpMontoActualizado = formatNumeroDecimal(value.prcpMontoActualizado);
            prcpMontoActualizadoT += value.prcpMontoActualizado;
        }
        var prcpComentarios;
        if (!$.trim(value.prcpComentarios)) {
            prcpComentarios = "";
        } else {
            prcpComentarios = value.prcpComentarios;
        }
        var body = "<tr id='trCompRegInfoProy" + prcpOrden + "' class='tr-row-table'>\
                      <td style='text-align: center;'>" + prcpOrden + "</td>\
                      <td style='text-align: left;'>" + prcpComponente + "</td>\
                      <td style='text-align: right;'>" + prcpMontoViable + "</td>\
                      <td style='text-align: right;'>" + prcpMontoEstudio + "</td>\
                      <td style='text-align: right;'>" + prcpMontoContratado + "</td>\
                      <td style='text-align: right;'>" + prcpMontoActualizado + "</td>\
                      <td style='text-align: left;'>" + prcpComentarios + "</td>\
                      <td style='text-align: center;'>\
                        <button id='btnEditCompRegInfoProy" + prcpOrden + "' type='button' title='Editar' class='btn btn-default btn-sm'>\
                          <i class='fa fa-edit'></i>\
                        </button>\
                      </td>\
                    </tr>";
        $("#tableCompRegInfoProyContBody").append(body);
    });

    var foot = "<tr class='total'>\
                  <td colspan='2' style='text-align: center;'><b>TOTAL</b></td>\
                  <td style='text-align: right;'><b>" + formatNumeroDecimal(prcpMontoViableT) + "</b></td>\
                  <td style='text-align: right;'><b>" + formatNumeroDecimal(prcpMontoEstudioT) + "</b></td>\
                  <td style='text-align: right;'><b>" + formatNumeroDecimal(prcpMontoContratadoT) + "</b></td>\
                  <td style='text-align: right;'><b>" + formatNumeroDecimal(prcpMontoActualizadoT) + "</b></td>\
                  <td></td>\
                  <td></td>\
                </tr>";
    $("#tableCompRegInfoProyContFoot").append(foot);

    $('#tableCompRegInfoProyContBody').on('click', 'tr.tr-row-table', function () {

        $('#tableCompRegInfoProyContBody tr.tr-row-table').removeClass('hide');
        $("#trCompRegInfoProyForm").remove();
        var array = [];
        $("#" + $(this).attr('id') + " td").each(function () {
            array.push($(this).text());
        });
        var actionUpd = "./Proyectos?tipo=00_7&cod_siaf=" + codigo + "&comp_ord=" + array[0];
        $("#formRegInfoProyecto7").attr("action", actionUpd);
        var input = '<tr id="trCompRegInfoProyForm" class="tr-row-editable">\
                      <td style="text-align: center;">' + array[0] + '</td>\
                      <td style="text-align: left;">' + array[1] + '</td>\
                      <td style="text-align: right;">' + array[2].replace(/,/g, '') + '</td>\
                      <td style="text-align: right;">\
                        <input name="compMontoEstudio" type="text" class="form-control" value="' + array[3].replace(/,/g, '') + '" onkeypress="return soloNumDecimal(event, this.value)">\
                      </td>\
                      <td style="text-align: right;">\
                        <input name="compMontoContrato" type="text" class="form-control" value="' + array[4].replace(/,/g, '') + '" onkeypress="return soloNumDecimal(event, this.value)">\
                      </td>\
                      <td style="text-align: right;">\
                        <input name="compMontoActualizado" type="text" class="form-control" value="' + array[5].replace(/,/g, '') + '" onkeypress="return soloNumDecimal(event, this.value)">\
                      </td>\
                      <td style="text-align: left;">\
                        <textarea name="compComentario" rows="6" class="form-control no-resize" form="formRegInfoProyecto7" uppercase>' + array[6] + '</textarea>\
                      </td>\
                      <td style="text-align: center;">\
                        <button type="submit" id="btnUpdCompRegInfoProy" title="Actualizar" class="btn btn-success btn-sm">\
                          <i class="fa fa-check"></i>\
                        </button>\
                        <button type="button" id="btnCanCompRegInfoProy" title="Cancelar" class="btn btn-warning btn-sm">\
                          <i class="fa fa-remove"></i>\
                        </button>\
                      </td>\
                     </tr>';
        $("#" + $(this).attr('id')).before(input);
        $(this).addClass('hide');

        $("#btnCanCompRegInfoProy").click(function () {
            $('#tableCompRegInfoProyContBody tr.tr-row-table').removeClass('hide');
            $("#trCompRegInfoProyForm").remove();
        });

    });
}

function limpiarRegListCalendarProy1() {
    $('#listMesCalRegInfoProy').prop('selectedIndex', 0);
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataMeses",
        success: function (response) {
            var index = response.index;
            $('#listMesCalRegInfoProy').prop('selectedIndex', index);
        }
    });
}

function llenarRegListCalendarProy1() {

    $('#listAnoCalRegInfoProy').empty();
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataAnosRegProy",
        success: function (response) {
            var arrayAnos = response.arrayAnos;
            for (var i = 0; i < arrayAnos.length; i++) {
                $("#listAnoCalRegInfoProy").append("<option value=" + arrayAnos[i] + ">" + arrayAnos[i] + "</option>");
            }
        }
    });

    $('#listMesCalRegInfoProy').empty();
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataMeses",
        success: function (response) {
            var index = response.index;
            $.each(response.listMeses, function (index, value) {
                $("#listMesCalRegInfoProy").append("<option value=" + value.mes + ">" + value.nombre + "</option>");
            });
            $('#listMesCalRegInfoProy').prop('selectedIndex', index);
        }
    });

}

function llenarRegListCalendarProy2(response) {
    var codigo = response.proyecCodSiaf;
    $('#tableCalRegInfoProyCont2').dataTable().fnDestroy();
    $("#tableCalRegInfoProyCont2Body").empty();
    $("#tableCalRegInfoProyCont2Foot").empty();
    var prvaMontoProgramadoT = 0.00;
    var prvaMontoEjecutadoT = 0.00;
    var prvaMontoPagadoT = 0.00;
    $.each(response.listCalendar, function (index, value) {
        var prpeAno = value.prpeAno;
        var prpeMes = value.prpeMes;
        var prpeNombreMes = value.nombreMes;
        var prvaMontoProgramado;
        if (!$.trim(value.prvaMontoProgramado)) {
            prvaMontoProgramado = "";
        } else {
            prvaMontoProgramado = formatNumeroDecimal(value.prvaMontoProgramado);
            prvaMontoProgramadoT += value.prvaMontoProgramado;
        }
        var prvaMontoEjecutado;
        if (!$.trim(value.prvaMontoEjecutado)) {
            prvaMontoEjecutado = "";
        } else {
            prvaMontoEjecutado = formatNumeroDecimal(value.prvaMontoEjecutado);
            prvaMontoEjecutadoT += value.prvaMontoEjecutado;
        }
        var prvaMontoPagado;
        if (!$.trim(value.prvaMontoPagado)) {
            prvaMontoPagado = "";
        } else {
            prvaMontoPagado = formatNumeroDecimal(value.prvaMontoPagado);
            prvaMontoPagadoT += value.prvaMontoPagado;
        }
        var body = "<tr id='trCalRegInfoProy" + (index + 1) + "'>\
                      <td style='text-align: center;'>" + (index + 1) + "</td>\
                      <td style='text-align: center;'>" + prpeAno + "</td>\
                      <td style='text-align: center;'>" + prpeNombreMes.toUpperCase() + "</td>\
                      <td style='text-align: right;'>" + prvaMontoProgramado + "</td>\
                      <td style='text-align: right;'>" + prvaMontoEjecutado + "</td>\
                      <td style='text-align: right;'>" + prvaMontoPagado + "</td>\
                      <td style='text-align: center;'>\
                        <button id='btnEditCalRegInfoProy" + (index + 1) + "' type='button' title='Editar' class='btn btn-default btn-sm'>\
                          <i class='fa fa-edit'></i>\
                        </button>\
                        <button id='btnDelCalRegInfoProy" + (index + 1) + "' type='button' title='Eliminar' class='btn btn-danger btn-sm'>\
                          <i class='fa fa-trash'></i>\
                        </button>\
                      </td>\
                    </tr>";
        $("#tableCalRegInfoProyCont2Body").append(body);
        $("#btnEditCalRegInfoProy" + (index + 1)).click(function () {
            $("#tableCalRegInfoProyCont2Body tr").removeClass("tr-row-editable");
            $("#trCalRegInfoProy" + (index + 1)).addClass("tr-row-editable");
            llenarRegListCalendarProy3(codigo, prpeAno, prpeMes, (index + 1));
            $('html,body').animate({
                scrollTop: $("#tableCalRegInfoProyCont3").offset().top - 10},
                    'fast');
        });
        $("#btnDelCalRegInfoProy" + (index + 1)).click(function () {
            alertify.confirm("¿Está seguro que desea eliminar este registro?", function (evt) {
                if (evt) {
                    $.ajax({
                        dataType: 'json',
                        url: "./Proyectos?tipo=00_8_2&cod_siaf=" + codigo + "&calendarAno=" + prpeAno + "&calendarMes=" + prpeMes,
                        success: function (responseDel) {
                            $("#tableCalRegInfoProyCont3").empty();
                            llenarRegListCalendarProy2(responseDel);
                        }
                    });
                }
            });
        });
    });

    var foot = "<tr class='total'>\
                  <td colspan='3' style='text-align: center;'><b>TOTAL</b></td>\
                  <td style='text-align: right;'><b>" + formatNumeroDecimal(prvaMontoProgramadoT) + "</b></td>\
                  <td style='text-align: right;'><b>" + formatNumeroDecimal(prvaMontoEjecutadoT) + "</b></td>\
                  <td style='text-align: right;'><b>" + formatNumeroDecimal(prvaMontoPagadoT) + "</b></td>\
                  <td></td>\
                </tr>";
    $("#tableCalRegInfoProyCont2Foot").append(foot);

    $('#tableCalRegInfoProyCont2').dataTable({
        ordering: true,
        bPaginate: false,
        dom: 'rt'
    });

}

function llenarRegListCalendarProy3(codigo, ano, mes, idxTr) {
    $("#tableCalRegInfoProyCont3").empty();
    $.ajax({
        dataType: 'json',
        url: "./Proyectos?tipo=00_8&cod_siaf=" + codigo + "&calendarAno=" + ano + "&calendarMes=" + mes,
        success: function (responseGet) {
            var table = '<thead>\
                          <tr>\
                            <th style="text-align: center; width: 50px;">N°</th>\
                            <th style="text-align: center;">Componente</th>\
                            <th style="text-align: center; width: 120px;">Monto Programado</th>\
                            <th style="text-align: center; width: 120px;">Monto Ejecutado</th>\
                            <th style="text-align: center; width: 120px;">Valorización Pagada</th>\
                            <th style="text-align: center; width: 100px;">Acción</th>\
                          </tr>\
                         </thead>\
                         <tbody id="tableCalRegInfoProyCont3Body"></tbody>';
            $("#tableCalRegInfoProyCont3").append(table);
            $('#tableCalRegInfoProyCont3').dataTable().fnDestroy();
            $.each(responseGet.listCalendarComp, function (index, value) {
                var prcpOrden = value.prcpOrden;
                var prcpComponente = value.prcpComponente;
                var prvaMontoProgramado;
                if (!$.trim(value.prvaMontoProgramado)) {
                    prvaMontoProgramado = "";
                } else {
                    prvaMontoProgramado = formatNumeroDecimal(value.prvaMontoProgramado);
                }
                var prvaMontoEjecutado;
                if (!$.trim(value.prvaMontoEjecutado)) {
                    prvaMontoEjecutado = "";
                } else {
                    prvaMontoEjecutado = formatNumeroDecimal(value.prvaMontoEjecutado);
                }
                var prvaMontoPagado;
                if (!$.trim(value.prvaMontoPagado)) {
                    prvaMontoPagado = "";
                } else {
                    prvaMontoPagado = formatNumeroDecimal(value.prvaMontoPagado);
                }
                var body = "<tr id='trCalCompRegInfoProy" + prcpOrden + "' class='tr-row-table'>\
                              <td style='text-align: center;'>" + prcpOrden + "</td>\
                              <td style='text-align: left;'>" + prcpComponente + "</td>\
                              <td style='text-align: right;'>" + prvaMontoProgramado + "</td>\
                              <td style='text-align: right;'>" + prvaMontoEjecutado + "</td>\
                              <td style='text-align: right;'>" + prvaMontoPagado + "</td>\
                              <td style='text-align: center;'>\
                                <button id='btnEditCalCompRegInfoProy" + prcpOrden + "' type='button' title='Editar' class='btn btn-default btn-sm'>\
                                  <i class='fa fa-edit'></i>\
                                </button>\
                              </td>\
                            </tr>";
                $("#tableCalRegInfoProyCont3Body").append(body);
            });

            $('#tableCalRegInfoProyCont3').dataTable({
                ordering: false,
                bPaginate: false,
                dom: 'rt'
            });

            $('#tableCalRegInfoProyCont3Body').on('click', 'tr.tr-row-table', function () {

                $('#tableCalRegInfoProyCont3Body tr.tr-row-table').removeClass('hide');
                $("#trCalRegInfoProyForm").remove();
                var array = [];
                $("#" + $(this).attr('id') + " td").each(function () {
                    array.push($(this).text());
                });
                var calMontProgra;
                if (array[2] === "" || array[2] === null) {
                    calMontProgra = "";
                } else {
                    calMontProgra = array[2].replace(/,/g, '');
                }
                var calMontEjecuta;
                if (array[3] === "" || array[3] === null) {
                    calMontEjecuta = "";
                } else {
                    calMontEjecuta = array[3].replace(/,/g, '');
                }
                var calValorPaga;
                if (array[4] === "" || array[4] === null) {
                    calValorPaga = "";
                } else {
                    calValorPaga = array[4].replace(/,/g, '');
                }
                var actionUpd = "./Proyectos?tipo=00_8_3&cod_siaf=" + codigo + "&calendarAno=" + ano + "&calendarMes=" + mes + "&idxTr=" + idxTr + "&comp_ord=" + array[0];
                $("#formRegInfoProyecto8_3").attr("action", actionUpd);
                var input = '<tr id="trCalRegInfoProyForm" class="tr-row-editable">\
                              <td style="text-align: center;">' + array[0] + '</td>\
                              <td style="text-align: left;">' + array[1] + '</td>\
                              <td style="text-align: right;">\
                                <input name="calCompMontoProgramado" type="text" class="form-control" value="' + calMontProgra + '" onkeypress="return soloNumDecimal(event, this.value)">\
                              </td>\
                              <td style="text-align: right;">\
                                <input name="calCompMontoEjecutado" type="text" class="form-control" value="' + calMontEjecuta + '" onkeypress="return soloNumDecimal(event, this.value)">\
                              </td>\
                              <td style="text-align: right;">\
                                <input name="calCompValorPagado" type="text" class="form-control" value="' + calValorPaga + '" onkeypress="return soloNumDecimal(event, this.value)">\
                              </td>\
                              <td style="text-align: center;">\
                                <button type="submit" id="btnUpdCalRegInfoProy" title="Actualizar" class="btn btn-success btn-sm">\
                                  <i class="fa fa-check"></i>\
                                </button>\
                                <button type="button" id="btnCanCalRegInfoProy" title="Cancelar" class="btn btn-warning btn-sm">\
                                  <i class="fa fa-remove"></i>\
                                </button>\
                              </td>\
                             </tr>';
                $("#" + $(this).attr('id')).before(input);
                $(this).addClass('hide');

                $("#btnCanCalRegInfoProy").click(function () {
                    $('#tableCalRegInfoProyCont3Body tr.tr-row-table').removeClass('hide');
                    $("#trCalRegInfoProyForm").remove();
                });

            });

        }
    });
}

function llenarRegListUbigeoProy(response) {
    var codigo = response.proyecCodSiaf;
    $("#tableUbigRegInfoProyContBody").empty();
    $.each(response.listUbigeo, function (index, value) {
        var depart, provin, distri, locali, latitud, longitud;
        if (!$.trim(value.prubDepartamento)) {
            depart = "";
        } else {
            depart = value.prubDepartamento;
        }
        if (!$.trim(value.prubProvincia)) {
            provin = "";
        } else {
            provin = value.prubProvincia;
        }
        if (!$.trim(value.prubDistrito)) {
            distri = "";
        } else {
            distri = value.prubDistrito;
        }
        if (!$.trim(value.prubLocalidad)) {
            locali = "";
        } else {
            locali = value.prubLocalidad;
        }
        if (!$.trim(value.prubLatitud)) {
            latitud = "";
        } else {
            latitud = value.prubLatitud;
        }
        if (!$.trim(value.prubLongitud)) {
            longitud = "";
        } else {
            longitud = value.prubLongitud;
        }
        var body = "<tr id='trUbigRegInfoProy" + index + "' class='tr-row-table'>\
                      <td id='" + index + "' style='text-align: center;'>" + (index + 1) + "</td>\
                      <td style='text-align: left;'>" + depart + "</td>\
                      <td style='text-align: left;'>" + provin + "</td>\
                      <td style='text-align: left;'>" + distri + "</td>\
                      <td style='text-align: left;'>" + locali + "</td>\
                      <td style='text-align: center;'>" + latitud + "</td>\
                      <td style='text-align: center;'>" + longitud + "</td>\
                      <td style='text-align: center;'>\
                        <button id='btnEditUbigRegInfoProy" + index + "' type='button' title='Editar' class='btn btn-default btn-sm'>\
                          <i class='fa fa-edit'></i>\
                        </button>\
                      </td>\
                    </tr>";
        $("#tableUbigRegInfoProyContBody").append(body);
        $("#btnEditUbigRegInfoProy" + index).click(function () {
            $("#tableUbigRegInfoProyContBody tr").removeClass("tr-row-editable");
            $("#trUbigRegInfoProy" + index).addClass("tr-row-editable");
        });
    });

    $('#tableUbigRegInfoProyContBody').on('click', 'tr.tr-row-table', function (evt) {

        if (!$(evt.target).hasClass('no-edit')) {

            $('#tableUbigRegInfoProyContBody tr.tr-row-table').removeClass('hide');
            $("#trUbigRegInfoProyForm").remove();
            var array = [];
            var arrayHtml = [];
            $("#" + $(this).attr('id') + " td").each(function () {
                array.push($(this).text());
                arrayHtml.push($(this).attr('id'));
            });
            var actionUpd = "./Proyectos?tipo=00_9&cod_siaf=" + codigo + "&index=" + arrayHtml[0];
            $("#formRegInfoProyecto9").attr("action", actionUpd);
            var input = '<tr id="trUbigRegInfoProyForm" class="tr-row-editable">\
                            <td style="text-align: center;">' + array[0] + '</td>\
                            <td style="text-align: left;">' + array[1] + '</td>\
                            <td style="text-align: left;">' + array[2] + '</td>\
                            <td style="text-align: left;">' + array[3] + '</td>\
                            <td style="text-align: left;">' + array[4] + '</td>\
                            <td style="text-align: center;">\
                              <input name="ubigLatitud" type="text" class="form-control" value="' + array[5] + '" onkeypress="return soloNumCoordenada(event, this.value)">\
                            </td>\
                            <td style="text-align: center;">\
                              <input name="ubigLongitud" type="text" class="form-control" value="' + array[6] + '" onkeypress="return soloNumCoordenada(event, this.value)">\
                            </td>\
                            <td style="text-align: center;">\
                              <button type="submit" id="btnUpdUbigRegInfoProy" title="Actualizar" class="btn btn-success btn-sm">\
                                <i class="fa fa-check"></i>\
                              </button>\
                              <button type="button" id="btnCanUbigRegInfoProy" title="Cancelar" class="btn btn-warning btn-sm">\
                                <i class="fa fa-remove"></i>\
                              </button>\
                            </td>\
                         </tr>';
            $("#" + $(this).attr('id')).before(input);
            $(this).addClass('hide');

            $("#btnCanUbigRegInfoProy").click(function () {
                $('#tableUbigRegInfoProyContBody tr.tr-row-table').removeClass('hide');
                $("#trUbigRegInfoProyForm").remove();
            });

        }

    });

}

function limpiarRegListFotosProy() {
    $("input[name=fotoTitulo]").val("");
    $("textarea[name=fotoDescripcion]").val("");
    $("input[name=fotoEsPrincipal]").prop("checked", false);
    $("#divFotRegInfoProyCont img").attr('src', './resources/images/proyecto.jpg');
}

function llenarRegListFotosProy(response) {
    var codigo = response.proyecCodSiaf;
    var dataBase = response.dataBase;
    $('#tableFotRegInfoProyCont').dataTable().fnDestroy();
    $("#tableFotRegInfoProyContBody").empty();
    $.each(response.listFotos, function (index, value) {
        var prfoOrden = value.prfoOrden;
        var prfoUrl = "";
        if (dataBase === "servidor") {
            prfoUrl = value.prfoUrlLinux;
        }
        if (dataBase === "local") {
            prfoUrl = value.prfoUrlWindows;
        }
        var prfoType = value.prfoTipo;
        var prfoTitulo = value.prfoTitulo;
        var prfoDescripcion;
        if (!$.trim(value.prfoDescripcion)) {
            prfoDescripcion = "";
        } else {
            prfoDescripcion = value.prfoDescripcion;
        }
        var prfoPrincipal;
        if (value.prfoPrincipal) {
            prfoPrincipal = '<span class="label label-primary">Principal</span>';
        } else {
            prfoPrincipal = '<span class="label label-danger">Secundario</span>';
        }
        var body = "<tr id='trFotRegInfoProy" + prfoOrden + "' class='tr-row-table'>\
                      <td id='" + prfoType + "' style='text-align: center;'>" + prfoOrden + "</td>\
                      <td id='" + prfoUrl + "' style='text-align: center;'>\
                        <img alt='' src='./Imagen?ruta=" + prfoUrl + "&type=" + prfoType + "' width='250'></img>\
                      </td>\
                      <td style='text-align: left;'>" + prfoTitulo + "</td>\
                      <td style='text-align: left;'>" + prfoDescripcion + "</td>\
                      <td style='text-align: center;'>" + prfoPrincipal + "</td>\
                      <td style='text-align: center;'>\
                        <button id='btnEditFotRegInfoProy" + prfoOrden + "' type='button' title='Editar' class='btn btn-default btn-sm'>\
                          <i class='fa fa-edit'></i>\
                        </button>\
                        <button id='btnDelFotRegInfoProy" + prfoOrden + "' type='button' title='Eliminar' class='btn btn-danger btn-sm no-edit'>\
                          <i class='fa fa-trash no-edit'></i>\
                        </button>\
                      </td>\
                    </tr>";
        $("#tableFotRegInfoProyContBody").append(body);
        $("#btnEditFotRegInfoProy" + prfoOrden).click(function () {
            $("#tableFotRegInfoProyContBody tr").removeClass("tr-row-editable");
            $("#trFotRegInfoProy" + prfoOrden).addClass("tr-row-editable");
        });
        $("#btnDelFotRegInfoProy" + prfoOrden).click(function () {
            alertify.confirm("¿Está seguro que desea eliminar este registro?", function (evt) {
                if (evt) {
                    $.ajax({
                        dataType: 'json',
                        url: "./Proyectos?tipo=00_10_2&cod_siaf=" + codigo + "&fotoOrden=" + prfoOrden + "&fotoUrl=" + prfoUrl,
                        success: function (responseDel) {
                            llenarRegListFotosProy(responseDel);
                        }
                    });
                }
            });
        });
    });

    $('#tableFotRegInfoProyCont').dataTable({
        ordering: false,
        bPaginate: true,
        dom: '<"centrar-div-tabla"lf>iprt'
    });

    $('#tableFotRegInfoProyContBody').on('click', 'tr.tr-row-table', function (evt) {

        if (!$(evt.target).hasClass('no-edit')) {

            $('#tableFotRegInfoProyContBody tr.tr-row-table').removeClass('hide');
            $("#trFotRegInfoProyForm").remove();
            var array = [];
            var arrayHtml = [];
            $("#" + $(this).attr('id') + " td").each(function () {
                array.push($(this).text());
                arrayHtml.push($(this).attr('id'));
            });
            var actionUpd = "./Proyectos?tipo=00_10_3&cod_siaf=" + codigo + "&fotoOrden=" + array[0];
            $("#formRegInfoProyecto10_3").attr("action", actionUpd);
            var checked;
            if (array[4].toLowerCase() === "principal") {
                checked = "checked";
            } else {
                checked = "";
            }
            var input = '<tr id="trFotRegInfoProyForm" class="tr-row-editable">\
                      <td style="text-align: center;">' + array[0] + '</td>\
                      <td style="text-align: center;">\
                        <input name="fotoArchivo" id="iptFotoArchivoUpd" type="file" data-height="150" accept="image/*" >\
                      </td>\
                      <td style="text-align: left;">\
                        <textarea name="fotoTitulo" rows="3" class="form-control no-resize" form="formRegInfoProyecto10_3" uppercase>' + array[2].trim() + '</textarea>\
                      </td>\
                      <td style="text-align: left;">\
                        <textarea name="fotoDescripcion" rows="7" class="form-control no-resize" form="formRegInfoProyecto10_3">' + array[3].trim() + '</textarea>\
                      </td>\
                        <td style="text-align: center;">\
                          <label class="custom-control custom-checkbox" style="font-weight: normal;">\
                            <input name="fotoEsPrincipal" type="checkbox" class="custom-control-input" value="ok" ' + checked + '>\
                            <span class="custom-control-indicator"></span>&nbsp;&nbsp;\
                            <span class="custom-control-description">Principal</span>\
                          </label>\
                        </td>\
                      <td style="text-align: center;">\
                        <button type="submit" id="btnUpdFotRegInfoProy" title="Actualizar" class="btn btn-success btn-sm">\
                          <i class="fa fa-check"></i>\
                        </button>\
                        <button type="button" id="btnCanFotRegInfoProy" title="Cancelar" class="btn btn-warning btn-sm">\
                          <i class="fa fa-remove"></i>\
                        </button>\
                      </td>\
                     </tr>';
            $("#" + $(this).attr('id')).before(input);
            $(this).addClass('hide');

            $('#iptFotoArchivoUpd').dropify({
                "messages": {
                    default: 'Arrastre una imagen o haga clic aquí',
                    replace: 'Arrastre una imagen o haga clic en reemplazar',
                    remove: 'Remover',
                    error: 'Lo sentimos, la imagen es demasiado grande'
                }
            });
            $('#trFotRegInfoProyForm .dropify-wrapper').addClass('has-preview');
            $('#trFotRegInfoProyForm .dropify-loader').hide();
            $('#trFotRegInfoProyForm .dropify-preview').show();
            $('#trFotRegInfoProyForm .dropify-filename-inner').append(array[0] + '.jpg');
            $('#trFotRegInfoProyForm .dropify-render').append("<img src='./Imagen?ruta=" + arrayHtml[1] + "&type=" + arrayHtml[0] + "' style='maxheight: 150px;'></img>");

            $("#btnCanFotRegInfoProy").click(function () {
                $('#tableFotRegInfoProyContBody tr.tr-row-table').removeClass('hide');
                $("#trFotRegInfoProyForm").remove();
            });

        }

    });

}





