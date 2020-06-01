// Llenar Centros de Costo y Metas

function llenar_centro_meta_alert() {
    alert("funciona llenar Centros de Costo y Metas");
}

function llenar_centro_costo_meta(perfil, ejec) {

    $("#divContenidoMenu").empty();
    var cont_ceco = '<section id="section_proyecto_ficha" class="background_sirsam_">\
                        <div class="menu_indice">\
                            <div class ="container">\
                                <ol class="breadcrumb">\
                                    <li>\
                                        <a id="aCentroMetaRegresar" style="cursor: pointer;">\
                                            <i class="choose-icon ion-cash" style="color: black; font-size: 15px;"></i>  \
                                            Ejecución Presupuestal\
                                        </a>\
                                    </li>\
                                    <li id="liTipoPresuCeco"><i class="fa fa-map-marker"></i> Centros de Costo</li>\
                                </ol>\
                            </div>\
                        </div>\
                        <br>\
                        <div class="container">\
                            <div class="filtro_princ naranja_secun">\
                                <div class="form-group">\
                                    <label for="listTipoCentro" class="col-form-label">Elija Tipo de Registro :</label>\
                                    <select class="select-form" id="listTipoCentro">\
                                        <option value="01" selected>Centros de Costo</option>\
                                        <option value="02">Metas Presupuestales - Centros de Costo</option>\
                                    </select>\
                                </div>\
                            </div>\
                            <br>\
                            <div id="divConteMetaCentro" class="filtro_princ naranja_secun">\
                                <div id="divEjecCentro" class="form-group"></div>\
                                <div>\
                                    <button id="btnNuevoCentro" class="btn btn3d btn-white btn-m">Añadir Centro de Costo\
                                        <img src="./resources/images/nuevo_centro.png"/>\
                                    </button>\
                                </div>\
                                <div id="divTablaCentro" class="tabla_reporte" style="overflow-x:auto;"></div>\
                            </div>\
                        </div>\
                    </section>\
                    <div id="divCentroCosto"></div>\
                    <div id="divMetaCentroCosto"></div>';
    $("#divContenidoMenu").append(cont_ceco);

    if (perfil === "0") {

        $("#divEjecCentro").empty();
        var cont = '<label for="listEjecCentro" class="col-form-label">Elija Ejecutora :</label>\
                    <select class="select-form" id="listEjecCentro"></select>';
        $("#divEjecCentro").append(cont);
        $('#listEjecCentro').empty();
        $.ajax({
            dataType: 'json',
            url: "./GsonData?url=DataEjecutoras",
            success: function (response) {
                $.each(response.listEjecutoras, function (index, value) {
                    var nombre_ejec = (value.nombre).split("-");
                    var obje = "<option value=" + value.sec_ejec + ">UE " + value.ejecutora + " - " + nombre_ejec[1].trim() + " (" + value.sec_ejec + ")</option>";
                    $("#listEjecCentro").append(obje);
                });
                $('#listEjecCentro').prop('selectedIndex', 0);
                llenarListaCentros($('#listEjecCentro').val());
                controlesCentroMeta($('#listEjecCentro').val());
                $("#listEjecCentro").bind("change", function () {
                    var ejecS = $('#listEjecCentro').val();
                    llenarListaCentros(ejecS);
                    controlesCentroMeta(ejecS);
                });
            }
        });
    } else {
        llenarListaCentros(ejec);
        controlesCentroMeta(ejec);
    }

    $("#aCentroMetaRegresar").click(function () {
        llenar_menu_ejecucion();
    });
    $("#listTipoCentro").bind("change", function () {
        var tipo = $("#listTipoCentro").val();
        presupuesto_ceco_bread(tipo);
        cambiaCentroMetaReg(tipo, perfil, ejec);
    });
}

function presupuesto_ceco_bread(id) {
    $("#liTipoPresuCeco").empty();
    if (id === "01") {
        $("#liTipoPresuCeco").append('<i class="fa fa-map-marker"></i> Centros de Costo');
    }
    if (id === "02") {
        $("#liTipoPresuCeco").append('<i class="fa fa-flag"></i> Metas Presupuestales - Centros de Costo');
    }
}

function cambiaCentroMetaReg(tipo, perfil, ejec) {

    if (tipo === "01") {
        $("#divConteMetaCentro").empty();
        var cont1 = '<div id="divEjecCentro" class="form-group"></div>\
                    <div>\
                        <button id="btnNuevoCentro" class="btn btn3d btn-white btn-m">Añadir Centro de Costo\
                            <img src="./resources/images/nuevo_centro.png"/>\
                        </button>\
                    </div>\
                    <div id="divTablaCentro" class="tabla_reporte" style="overflow-x:auto;"></div>';
        $("#divConteMetaCentro").append(cont1);
        if (perfil === "0") {
            $("#divEjecCentro").empty();
            var cont = '<label for="listEjecCentro" class="col-form-label">Elija Ejecutora :</label>\
                        <select class="select-form" id="listEjecCentro"></select>';
            $("#divEjecCentro").append(cont);
            $('#listEjecCentro').empty();
            $.ajax({
                dataType: 'json',
                url: "./GsonData?url=DataEjecutoras",
                success: function (response) {
                    $.each(response.listEjecutoras, function (index, value) {
                        var nombre_ejec = (value.nombre).split("-");
                        var obje = "<option value=" + value.sec_ejec + ">UE " + value.ejecutora + " - " + nombre_ejec[1].trim() + " (" + value.sec_ejec + ")</option>";
                        $("#listEjecCentro").append(obje);
                    });
                    $('#listEjecCentro').prop('selectedIndex', 0);
                    llenarListaCentros($('#listEjecCentro').val());
                    controlesCentroMeta($('#listEjecCentro').val());
                    $("#listEjecCentro").bind("change", function () {
                        var ejecS = $('#listEjecCentro').val();
                        llenarListaCentros(ejecS);
                        controlesCentroMeta(ejecS);
                    });
                }
            });
        } else {
            llenarListaCentros(ejec);
            controlesCentroMeta(ejec);
        }
    }

    if (tipo === "02") {
        $("#divConteMetaCentro").empty();
        var cont1 = '<div id="divEjecMetaCeco" class="form-group"></div>\
                     <div id="divMetaCecoAno" class="form-group"></div>\
                     <div id="divTablaMetaCeco" class="tabla_reporte" style="overflow-x:auto;"></div>';
        $("#divConteMetaCentro").append(cont1);
        if (perfil === "0") {
            $("#divEjecMetaCeco").empty();
            var contE = '<label for="listEjecMetaCeco" class="col-form-label">Elija Ejecutora :</label>\
                        <select class="select-form" id="listEjecMetaCeco"></select>';
            $("#divEjecMetaCeco").append(contE);
            $("#divMetaCecoAno").empty();
            var contM = '<label for="listMetaCecoAno" class="col-form-label">Elija Año :</label>\
                         <select class="select-form" id="listMetaCecoAno"></select>';
            $("#divMetaCecoAno").append(contM);
            $('#listEjecMetaCeco').empty();
            $('#listMetaCecoAno').empty();
            $.ajax({
                dataType: 'json',
                url: "./GsonData?url=DataEjecutoras",
                success: function (response) {
                    $.each(response.listEjecutoras, function (index, value) {
                        var nombre_ejec = (value.nombre).split("-");
                        var obje = "<option value=" + value.sec_ejec + ">UE " + value.ejecutora + " - " + nombre_ejec[1].trim() + " (" + value.sec_ejec + ")</option>";
                        $("#listEjecMetaCeco").append(obje);
                    });
                    $('#listEjecMetaCeco').prop('selectedIndex', 0);
                    $.ajax({
                        dataType: 'json',
                        url: "./GsonData?url=DataAñosMeta&ejec=" + $('#listEjecMetaCeco').val(),
                        success: function (responseA) {
                            $.each(responseA.listAños, function (indexA, valueA) {
                                var obje = "<option value=" + valueA.ano_eje + ">" + valueA.ano_eje + "</option>";
                                $("#listMetaCecoAno").append(obje);
                            });
                            $('#listMetaCecoAno').prop('selectedIndex', 0);
                            llenarListaMetaCeco(responseA.ejec, $('#listMetaCecoAno').val());

                            $("#listEjecMetaCeco").bind("change", function () {
                                var ejecS = $('#listEjecMetaCeco').val();
                                var anoS = $('#listMetaCecoAno').val();
                                llenarListaMetaCeco(ejecS, anoS);
                            });

                            $("#listMetaCecoAno").bind("change", function () {
                                var ejecS = $('#listEjecMetaCeco').val();
                                var anoS = $('#listMetaCecoAno').val();
                                llenarListaMetaCeco(ejecS, anoS);
                            });
                        }
                    });
                }
            });
        } else {
            $("#divEjecMetaCeco").empty();
            $("#divMetaCecoAno").empty();
            var contM = '<label for="listMetaCecoAno" class="col-form-label">Elija Año :</label>\
                         <select class="select-form" id="listMetaCecoAno"></select>';
            $("#divMetaCecoAno").append(contM);
            $('#listEjecMetaCeco').empty();
            $('#listMetaCecoAno').empty();
            $.ajax({
                dataType: 'json',
                url: "./GsonData?url=DataAñosMeta&ejec=" + ejec,
                success: function (response) {
                    $.each(response.listAños, function (index, value) {
                        var obje = "<option value=" + value.ano_eje + ">" + value.ano_eje + "</option>";
                        $("#listMetaCecoAno").append(obje);
                    });
                    $('#listMetaCecoAno').prop('selectedIndex', 0);
                    llenarListaMetaCeco(response.ejec, $('#listMetaCecoAno').val());

                    $("#listMetaCecoAno").bind("change", function () {
                        var anoS = $('#listMetaCecoAno').val();
                        llenarListaMetaCeco(response.ejec, anoS);
                    });
                }
            });
        }
    }

}

function llenarListaCentros(ejec) {
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataCentros&ejec=" + ejec,
        success: function (response) {
            $("#divTablaCentro").empty();
            conten = '<table id="tablaCentro" class="display" cellspacing="0" width="100%">\
                        <thead id="tablaCentroHead"></thead>\
                        <tfoot id="tablaCentroFoot"></tfoot>\
                        <tbody id="tablaCentroBody"></tbody>\
                      </table>';
            $("#divTablaCentro").append(conten);
            head = "<tr>\
                        <th style='text-align: center;'>Id</th>\
                        <th style='text-align: center;'>Código</th>\
                        <th style='text-align: center;'>Centro de Costo</th>\
                        <th style='text-align: center;'>Estado</th>\
                        <th style='text-align: center;'>Acción</th>\
                    </tr>";
            $("#tablaCentroHead").append(head);
            $("#tablaCentroFoot").append(head);
            $.each(response.listCentros, function (index, value) {
                var estado;
                if (value.ceco_estado) {
                    estado = "Activo";
                } else {
                    estado = "Inactivo";
                }
                body = "<tr>\
                            <td style='text-align: center;'>" + (index + 1) + "</td>\
                            <td style='text-align: center;'>" + value.ceco_codigo + "</td>\
                            <td style='text-align: left;'>" + value.ceco_nombre + "</td>\
                            <td style='text-align: center;'>" + estado + "</td>\
                            <td style='text-align: center;'>\
                                <button id='btnEditCeco" + value.ceco_id + "' title='Editar' class='btn btn-default btn-sm' style='margin-right: 10px;'>\
                                    <i class='fa fa-edit'></i>\
                                </button>\
                                <button id='btnDelCeco" + value.ceco_id + "' title='Eliminar' class='btn btn-default btn-sm'>\
                                    <i class='fa fa-trash'></i>\
                                </button>\
                            </td>\
                        </tr>";
                $("#tablaCentroBody").append(body);

                $("#btnEditCeco" + value.ceco_id).click(function () {
                    editCentro(ejec, value.ceco_id);
                    document.getElementById('divCentroCosto').classList.add('div-centrocosto');
                    document.getElementById('divFondo').classList.add('div-atras');
                    $("#divCentroCosto").css('top', ((($(window).height() - $("#divCentroCosto").height()) / 2) + $(window).scrollTop()) + "px");
                    $("#btnCancCentro").click(function () {
                        $("#divCentroCosto").empty();
                        document.getElementById('divCentroCosto').classList.remove('div-centrocosto');
                        document.getElementById('divFondo').classList.remove('div-atras');
                    });
                    $("#formEditCentro").submit(function () {
                        $.ajax({
                            dataType: 'json',
                            type: 'post',
                            url: $(this).attr("action"),
                            data: $(this).serialize(),
                            success: function (response) {
                                if (response.success) {
                                    alertify.log(response.msg);
                                    $("#divCentroCosto").empty();
                                    document.getElementById('divCentroCosto').classList.remove('div-centrocosto');
                                    document.getElementById('divFondo').classList.remove('div-atras');
                                    llenarListaCentros(ejec);
                                } else {
                                    toastr.options.closeButton = true;
                                    toastr.options.timeOut = 2000;
                                    toastr.options.positionClass = "toast-middle-center";
                                    toastr.warning(response.msg, 'Centro de Costo');
                                }

                            }
                        });
                        return false;
                    });
                });

                $("#btnDelCeco" + value.ceco_id).click(function () {
                    alertify.confirm("¿Está seguro que desea eliminar este Centro de Costo?", function (e) {
                        if (e) {
                            $.ajax({
                                dataType: 'json',
                                url: "./Presupuesto?tipo=eliminar_centro&ceco_id=" + value.ceco_id + "",
                                success: function (response) {
                                    alertify.log(response.msg);
                                    llenarListaCentros(ejec);
                                }
                            });
                        } else {
                        }
                    });
                });

            });
            $('#tablaCentro').dataTable({
                ordering: true,
                dom: '<"centrar-div-tabla"lfB>iprtip',
                buttons: [
                    {
                        extend: 'excel',
                        footer: true,
                        filename: 'centros_costo_' + ejec,
                        title: 'CENTROS DE COSTO - EJECUTORA ' + ejec,
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

function controlesCentroMeta(ejec) {

    $("#btnNuevoCentro").click(function () {
        nuevoCentro(ejec);
        document.getElementById('divCentroCosto').classList.add('div-centrocosto');
        document.getElementById('divFondo').classList.add('div-atras');
        $("#divCentroCosto").css('top', ((($(window).height() - $("#divCentroCosto").height()) / 2) + $(window).scrollTop()) + "px");
        $("#btnCancCentro").click(function () {
            $("#divCentroCosto").empty();
            document.getElementById('divCentroCosto').classList.remove('div-centrocosto');
            document.getElementById('divFondo').classList.remove('div-atras');
        });
        $("#formNuevoCentro").submit(function () {
            $.ajax({
                dataType: 'json',
                type: 'post',
                url: $(this).attr("action"),
                data: $(this).serialize(),
                success: function (response) {
                    if (response.success) {
                        alertify.log(response.msg);
                        $("#divCentroCosto").empty();
                        document.getElementById('divCentroCosto').classList.remove('div-centrocosto');
                        document.getElementById('divFondo').classList.remove('div-atras');
                        llenarListaCentros(ejec);
                    } else {
                        toastr.options.closeButton = true;
                        toastr.options.timeOut = 2000;
                        toastr.options.positionClass = "toast-middle-center";
                        toastr.warning(response.msg, 'Centro de Costo');
                    }

                }
            });
            return false;
        });
    });

}


function nuevoCentro(ejec) {
    $("#divCentroCosto").empty();
    contenido = '<form id="formNuevoCentro" method="post" action="./Presupuesto?tipo=nuevo_centro&ejec=' + ejec + '">\
                    <div class="form-group">\
                        <label for="iptCecoCod" class="col-form-label">Codigo :</label>\
                        <input id="iptCecoCod" type="text" maxlength="4" name="codigo" class="form-control" onkeypress="return soloNumero(event)" \
                            style="text-transform:uppercase" placeholder="Ingrese Codigo de máximo 4 numeros"/>\
                    </div>\
                    <div class="form-group">\
                        <label for="iptCecoNom" class="col-form-label">Centro de Costo :</label>\
                        <textarea id="iptCecoNom" type="text" rows="3" name="nombre" class="form-control" style="text-transform:uppercase" \
                            placeholder="Ingrese Nombre del Centro de Costo"></textarea>\
                    </div>\
                    <div class="form-group">\
                        <label class="custom-control custom-checkbox">\
                            <input type="checkbox" class="custom-control-input" value="true" name="activo" checked>\
                            <span class="custom-control-indicator"></span>&nbsp;\
                            <span class="custom-control-description">Activo</span>\
                        </label>\
                    </div>\
                    <div class="form-row">\
                        <div class="col-auto">\
                            <button type="submit" class="btn btn3d btn-primary btn-m">\
                                <span class="glyphicon glyphicon-floppy-disk spanBtn"></span>Guardar\
                            </button>\
                        </div>\
                        <div class="col-auto">\
                            <button id="btnCancCentro" type="reset" value="Reset" class="btn btn3d btn-danger btn-m">\
                                <span class="glyphicon glyphicon-ban-circle spanBtn"></span>Cancelar\
                            </button>\
                        </div>\
                    </div>\
                </form>';
    $("#divCentroCosto").append(contenido);
}

function editCentro(ejec, id) {
    $("#divCentroCosto").empty();
    var conE = '<form id="formEditCentro" method="post" action="./Presupuesto?tipo=editar_centro&ejec=' + ejec + '&id=' + id + '">\
                    <div class="form-group">\
                        <label for="iptCecoCod" class="col-form-label">Codigo :</label>\
                        <input id="iptCecoCod" type="text" maxlength="4" name="codigo" class="form-control" onkeypress="return soloNumero(event)" \
                            style="text-transform:uppercase" placeholder="Ingrese Codigo de máximo 4 numeros"/>\
                    </div>\
                    <div class="form-group">\
                        <label for="iptCecoNom" class="col-form-label">Centro de Costo :</label>\
                        <textarea id="iptCecoNom" type="text" rows="3" name="nombre" class="form-control" style="text-transform:uppercase" \
                            placeholder="Ingrese Nombre del Centro de Costo"></textarea>\
                    </div>\
                    <div class="form-group">\
                        <label class="custom-control custom-checkbox">\
                            <input id="inptCecoAct" type="checkbox" class="custom-control-input" value="true" name="activo">\
                            <span class="custom-control-indicator"></span>&nbsp;\
                            <span id="spanCecoAct" class="custom-control-description"></span>\
                        </label>\
                    </div>\
                    <div class="form-row">\
                        <div class="col-auto">\
                            <button type="submit" class="btn btn3d btn-primary btn-m">\
                                <span class="glyphicon glyphicon-floppy-disk spanBtn"></span>Guardar\
                            </button>\
                        </div>\
                        <div class="col-auto">\
                            <button id="btnCancCentro" type="reset" value="Reset" class="btn btn3d btn-danger btn-m">\
                                <span class="glyphicon glyphicon-ban-circle spanBtn"></span>Cancelar\
                            </button>\
                        </div>\
                    </div>\
                </form>';
    $("#divCentroCosto").append(conE);
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataEditCeco&id=" + id,
        success: function (response) {
            $("#iptCecoCod").val(response.ceco_codigo);
            $("#iptCecoNom").val(response.ceco_nombre);
            if (response.ceco_estado) {
                $("#inptCecoAct").prop("checked", true);
                $("#spanCecoAct").append("Activo");
            } else {
                $("#inptCecoAct").prop("checked", false);
                $("#spanCecoAct").append("Inactivo");
            }
        }
    });
}


function llenarListaMetaCeco(ejec, ano) {
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataMetaCeco&ejec=" + ejec + "&ano=" + ano,
        success: function (response) {
            $("#divTablaMetaCeco").empty();
            conten = '<table id="tablaMetaCeco" class="display" cellspacing="0" width="100%">\
                        <thead id="tablaMetaCecoHead"></thead>\
                        <tfoot id="tablaMetaCecoFoot"></tfoot>\
                        <tbody id="tablaMetaCecoBody"></tbody>\
                      </table>';
            $("#divTablaMetaCeco").append(conten);
            head = "<tr>\
                        <th style='text-align: center;'>Meta</th>\
                        <th style='text-align: center;'>Finalidad</th>\
                        <th style='text-align: center;'>Centro de Costo</th>\
                        <th style='text-align: center;'>Acción</th>\
                    </tr>";
            $("#tablaMetaCecoHead").append(head);
            $("#tablaMetaCecoFoot").append(head);
            $.each(response.listMetaCeco, function (index, value) {
                var body = "<tr>\
                            <td style='text-align: center;'>" + value.sec_func + "</td>\
                            <td style='text-align: left;'>" + value.descripcion + "</td>";
                if (!$.trim(value.ceco_id)) {
                    body += "<td style='text-align: left; color: red;'>NO ASIGNADO</td>";
                } else {
                    body += "<td style='text-align: left;'><b>" + value.ceco_codigo + "</b> - " + value.ceco_nombre + "</td>";
                }
                body += "<td style='text-align: center;'>\
                            <button id='btnEditMeCe" + value.sec_func + "' title='Editar' class='btn btn-default btn-sm'>\
                                <i class='fa fa-edit'></i>\
                            </button>\
                         </td>\
                         </tr>";
                $("#tablaMetaCecoBody").append(body);
                $("#btnEditMeCe" + value.sec_func).click(function () {
                    editMetaCeco(ano, ejec, value.sec_func);
                    document.getElementById('divMetaCentroCosto').classList.add('div-metaceco');
                    document.getElementById('divFondo').classList.add('div-atras');
                    $("#divMetaCentroCosto").css('top', ((($(window).height() - $("#divMetaCentroCosto").height()) / 2) + $(window).scrollTop()) + "px");
                    $("#btnCancMetaCeco").click(function () {
                        $("#divMetaCentroCosto").empty();
                        document.getElementById('divMetaCentroCosto').classList.remove('div-metaceco');
                        document.getElementById('divFondo').classList.remove('div-atras');
                    });
                    $("#formEditMetaCeco").submit(function () {
                        $.ajax({
                            dataType: 'json',
                            type: 'post',
                            url: $(this).attr("action"),
                            data: $(this).serialize(),
                            success: function (response) {
                                if (response.success) {
                                    alertify.log(response.msg);
                                    $("#divMetaCentroCosto").empty();
                                    document.getElementById('divMetaCentroCosto').classList.remove('div-metaceco');
                                    document.getElementById('divFondo').classList.remove('div-atras');
                                    llenarListaMetaCeco(response.ejec, response.ano);
                                } else {
                                    toastr.options.closeButton = true;
                                    toastr.options.timeOut = 2000;
                                    toastr.options.positionClass = "toast-middle-center";
                                    toastr.warning(response.msg, 'Meta y Centro de Costo');
                                }

                            }
                        });
                        return false;
                    });
                });
            });
            $('#tablaMetaCeco').dataTable({
                ordering: true,
                dom: '<"centrar-div-tabla"lfB>iprtip',
                buttons: [
                    {
                        extend: 'excel',
                        footer: true,
                        filename: 'metas_y_centros_costo_' + ejec,
                        title: 'METAS Y CENTROS DE COSTO - EJECUTORA ' + ejec,
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

function editMetaCeco(ano, ejec, meta) {
    $("#divMetaCentroCosto").empty();
    var conEM = '<form id="formEditMetaCeco" method="post" action="./Presupuesto?tipo=editar_meta_centro&ano=' + ano + '&ejec=' + ejec + '&sec_func=' + meta + '">\
                    <div class="form-group">\
                        <label for="iptMeta" class="col-form-label">Meta :</label>\
                        <input id="iptMeta" type="text" name="meta" class="form-control" readonly/>\
                    </div>\
                    <div class="form-group">\
                        <label for="iptMetaFinal" class="col-form-label">Finalidad :</label>\
                        <textarea id="iptMetaFinal" type="text" rows="3" name="finalidad" class="form-control" style="text-transform:uppercase" readonly></textarea>\
                    </div>\
                    <div class="form-group">\
                        <label for="listMetaCeco" class="col-form-label">Centro de Costo :</label>\
                        <select class="select-form" id="listMetaCeco" name="ceco_id"></select>\
                    </div>\
                    <div class="form-row">\
                        <div class="col-auto">\
                            <button type="submit" class="btn btn3d btn-primary btn-m">\
                                <span class="glyphicon glyphicon-floppy-disk spanBtn"></span>Guardar\
                            </button>\
                        </div>\
                        <div class="col-auto">\
                            <button id="btnCancMetaCeco" type="reset" value="Reset" class="btn btn3d btn-danger btn-m">\
                                <span class="glyphicon glyphicon-ban-circle spanBtn"></span>Cancelar\
                            </button>\
                        </div>\
                    </div>\
                 </form>';
    $("#divMetaCentroCosto").append(conEM);
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataEditMetaCeco&ano=" + ano + "&ejec=" + ejec + "&sec_func=" + meta,
        success: function (response) {
            $("#iptMeta").val(response.meta);
            $("#iptMetaFinal").val(response.finalidad);
            $("#listMetaCeco").empty();
            $.ajax({
                dataType: 'json',
                url: "./GsonData?url=DataCentros&ejec=" + response.ejec,
                success: function (responseC) {
                    $("#listMetaCeco").append("<option value=0 style='font-weight: bold;'>--NINGUNO--</option>");
                    $.each(responseC.listCentros, function (indexC, valueC) {
                        var objeC = "<option value=" + valueC.ceco_id + ">" + valueC.ceco_codigo + " - " + valueC.ceco_nombre + "</option>";
                        $("#listMetaCeco").append(objeC);
                    });
                    if (!$.trim(response.id)) {
                        $('#listMetaCeco').prop('selectedIndex', 0);
                    } else {
                        document.getElementById("listMetaCeco").value = response.id;
                    }
                }
            });
        }
    });
}



