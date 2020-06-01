// Administración de Perfiles y Permisos de los Usuarios

function llenar_admin_perfiles() {

    $("#divAdminConte").empty();
    contenido = '<div>\
                    <button id="btnNuevoPerfil" class="btn btn3d btn-white btn-m">Añadir Nuevo Perfil\
                       <img src="./resources/images/nuevo_perfil.png"/>\
                    </button>\
                 </div>\
                 <div id="divTablaPerfiles" class="tabla_reporte" style="overflow-x:auto;">\
                 </div>';
    $("#divAdminConte").append(contenido);
    perfiles();

    $("#btnNuevoPerfil").click(function () {
        nuevoPerfil();
        document.getElementById('divPerfil').classList.add('div-perfil');
        document.getElementById('divFondo').classList.add('div-atras');
        $("#divPerfil").css('top', ((($(window).height() - $("#divPerfil").height()) / 2) + $(window).scrollTop()) + "px");

        $("#nBtnCancPerfil").click(function () {
            $("#divPerfil").empty();
            document.getElementById('divPerfil').classList.remove('div-perfil');
            document.getElementById('divFondo').classList.remove('div-atras');
        });

        $("#formNuevoPerfil").submit(function (evt) {
            evt.preventDefault();
            $.ajax({
                dataType: 'json',
                type: 'post',
                url: $(this).attr("action"),
                data: $(this).serialize(),
                success: function (response) {
                    if (response.success) {
                        alertify.log(response.msg);
                        $("#divPerfil").empty();
                        document.getElementById('divPerfil').classList.remove('div-perfil');
                        document.getElementById('divFondo').classList.remove('div-atras');
                        perfiles();
                    } else {
                        alertify.log(response.msg);
                    }
                }
            });
        });

    });
}

function perfiles() {
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataPerfiles",
        success: function (response) {
            $("#divTablaPerfiles").empty();
            conten = '<table id="tablaPerfiles" class="display" cellspacing="0" width="100%">\
                        <thead id="tablaPerfilesHead"></thead>\
                        <tfoot id="tablaPerfilesFoot"></tfoot>\
                        <tbody id="tablaPerfilesBody"></tbody>\
                      </table>';
            $("#divTablaPerfiles").append(conten);
            var head = "<tr>\
                        <th style='text-align: center;'>Id</th>\
                        <th style='text-align: center;'>Perfil</th>";
            var countMenu = 0;
            $.each(response.listMenu, function (indexM, valueM) {
                var menu = valueM.menuNombre.split("_");
                head += "<th style='text-align: center;'>\
                            Menu<br/>" + menu[1].charAt(0).toUpperCase() + menu[1].slice(1) + "\
                         </th>";
                countMenu++;
            });
            head += "<th style='text-align: center;'>Acción</th>\
                     </tr>";
            $("#tablaPerfilesHead").append(head);
            $("#tablaPerfilesFoot").append(head);
            $.each(response.listPerfiles, function (index, value) {
                var body = "<tr>\
                            <td align='center'>" + (index + 1) + "</td>\
                            <td align='left'>" + value.perfNombre + "</td>";

                for (var i = 1; i <= countMenu; i++) {
                    body += "<td id='td_perf_" + value.perfId + "_" + i + "' align='center'></td>";
                    $.ajax({
                        dataType: 'json',
                        url: "./GsonData?url=DataPermisos&perf_id=" + value.perfId + "&menu_id=" + i,
                        success: function (responseP) {
                            var registra;
                            var activo;
                            if (responseP.registra) {
                                registra = '<span class="label label-primary">Registra</span>';
                            } else {
                                registra = '<span class="label label-danger">Registra</span>';
                            }
                            if (responseP.activo) {
                                activo = '<span class="label label-primary">Activo</span>';
                            } else {
                                activo = '<span class="label label-danger">Activo</span>';
                            }
                            var detalle = activo + "<br/>" + registra;
                            $("#td_perf_" + responseP.perf_id + "_" + responseP.menu_id).append(detalle);
                        }
                    });
                }

                body += "<td align='center'>\
                            <button id='btnEditP" + value.perfId + "' title='Editar' class='btn btn-default btn-sm'>\
                                <i class='fa fa-edit'></i>\
                            </button>\
                            <button id='btnAsignaP" + value.perfId + "' title='Asignar Permisos' class='btn btn-primary btn-sm'>\
                                <i class='fa fa-map-marker'></i>\
                            </button>\
                            <button id='btnDeleteP" + value.perfId + "' title='Eliminar' class='btn btn-danger btn-sm'>\
                                <i class='fa fa-trash'></i>\
                            </button>\
                         </td>\
                         </tr>";
                $("#tablaPerfilesBody").append(body);

                $("#btnEditP" + value.perfId).click(function () {
                    editPerfil();
                    editPerfilLlenar(value.perfId);
                    document.getElementById('divPerfil').classList.add('div-perfil');
                    document.getElementById('divFondo').classList.add('div-atras');
                    $("#divPerfil").css('top', ((($(window).height() - $("#divPerfil").height()) / 2) + $(window).scrollTop()) + "px");

                    $("#eBtnCancPerfil").click(function () {
                        $("#divPerfil").empty();
                        document.getElementById('divPerfil').classList.remove('div-perfil');
                        document.getElementById('divFondo').classList.remove('div-atras');
                    });

                    $("#formEditPerfil").submit(function (evt) {
                        evt.preventDefault();
                        $.ajax({
                            dataType: 'json',
                            type: 'post',
                            url: $(this).attr("action"),
                            data: $(this).serialize(),
                            success: function (response) {
                                if (response.success) {
                                    alertify.log(response.msg);
                                    $("#divPerfil").empty();
                                    document.getElementById('divPerfil').classList.remove('div-perfil');
                                    document.getElementById('divFondo').classList.remove('div-atras');
                                    perfiles();
                                } else {
                                    alertify.log(response.msg);
                                }

                            }
                        });
                    });
                });

                $("#btnAsignaP" + value.perfId).click(function () {
                    editPermisos();
                    editPermisosLlenar(value.perfId);

                    $("#eBtnCancPermisos").click(function () {
                        $("#divPermisos").empty();
                        document.getElementById('divPermisos').classList.remove('div-permisos');
                        document.getElementById('divFondo').classList.remove('div-atras');
                    });

                    $("#formEditPermisos").submit(function (evt) {
                        evt.preventDefault();
                        $.ajax({
                            dataType: 'json',
                            type: 'post',
                            url: $(this).attr("action"),
                            data: $(this).serialize(),
                            success: function (response) {
                                if (response.success) {
                                    alertify.log(response.msg);
                                    $("#divPermisos").empty();
                                    document.getElementById('divPermisos').classList.remove('div-permisos');
                                    document.getElementById('divFondo').classList.remove('div-atras');
                                    perfiles();
                                } else {
                                    alertify.log(response.msg);
                                }

                            }
                        });
                    });
                });

                $("#btnDeleteP" + value.perfId).click(function () {
                    alertify.confirm("¿Está seguro que desea eliminar este perfil de usuario?", function (e) {
                        if (e) {
                            $.ajax({
                                dataType: 'json',
                                url: "./Usuario?action=delete_perfil&perf_id=" + value.perfId + "",
                                success: function (response) {
                                    alertify.log(response.msg);
                                    perfiles();
                                }
                            });
                        } else {
                        }
                    });
                });

            });

            $('#tablaPerfiles').dataTable({
                ordering: true,
                dom: '<"centrar-div-tabla"lfB>iprtip',
                buttons: [
                    {
                        extend: 'colvis',
                        columnText: function (dt, idx, titlex) {
                            return (idx + 1) + '.- ' + titlex;
                        },
                        postfixButtons: ['colvisRestore'],
                        collectionLayout: 'fixed two-column'
                    },
                    {
                        extend: 'excel',
                        filename: 'lista_perfiles_usuario',
                        title: 'LISTA DE PERFILES DE USUARIO',
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

function nuevoPerfil() {

    $("#divPerfil").empty();
    contenido = '<form id="formNuevoPerfil" method="post" action="./Usuario?action=nuevo_perfil">\
                    <div class="form-group">\
                        <label for="nPerfil" class="col-form-label">Perfil :</label>\
                        <input id="nPerfil" type="text" name="perfil" class="form-control" style="text-transform:uppercase" placeholder="Ingrese Nombre del Perfil" />\
                    </div>\
                    <div class="form-group">\
                        <label for="nDescripcion" class="col-form-label">Descripción del Perfil :</label>\
                        <textarea id="nDescripcion" type="text" rows="3" name="descripcion" class="form-control" placeholder="INGRESE DESCRIPCIÓN DEL PERFIL" />\
                    </div>\
                    <div class="form-row">\
                        <div class="col-auto">\
                            <button type="submit" class="btn btn3d btn-primary btn-m">\
                                <span class="glyphicon glyphicon-floppy-disk spanBtn"></span>Guardar\
                            </button>\
                        </div>\
                        <div class="col-auto">\
                            <button id="nBtnCancPerfil" type="reset" value="Reset" class="btn btn3d btn-danger btn-m">\
                                <span class="glyphicon glyphicon-ban-circle spanBtn"></span>Cancelar\
                            </button>\
                        </div>\
                    </div>\
                </form>';
    $("#divPerfil").append(contenido);
}

function editPerfil() {

    $("#divPerfil").empty();
    contenido = '<form id="formEditPerfil" method="post">\
                    <div class="form-group">\
                        <label for="ePerfil" class="col-form-label">Perfil :</label>\
                        <input id="ePerfil" type="text" name="perfil" class="form-control" style="text-transform:uppercase" placeholder="Ingrese Nombre del Perfil" />\
                    </div>\
                    <div class="form-group">\
                        <label for="eDescripcion" class="col-form-label">Descripción del Perfil :</label>\
                        <textarea id="eDescripcion" type="text" rows="3" name="descripcion" class="form-control" placeholder="INGRESE DESCRIPCIÓN DEL PERFIL" />\
                    </div>\
                    <div class="form-row">\
                        <div class="col-auto">\
                            <button type="submit" class="btn btn3d btn-primary btn-m">\
                                <span class="glyphicon glyphicon-floppy-disk spanBtn"></span>Guardar\
                            </button>\
                        </div>\
                        <div class="col-auto">\
                            <button id="eBtnCancPerfil" type="reset" value="Reset" class="btn btn3d btn-danger btn-m">\
                                <span class="glyphicon glyphicon-ban-circle spanBtn"></span>Cancelar\
                            </button>\
                        </div>\
                    </div>\
                </form>';
    $("#divPerfil").append(contenido);
}

function editPerfilLlenar(id) {

    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataEditPerfil&id=" + id,
        success: function (response) {
            $("#ePerfil").val(response.perfil);
            $("#eDescripcion").val(response.descripcion);
            var action = "./Usuario?action=editar_perfil&perf_id=" + response.id + "";
            $("#formEditPerfil").attr("action", action);
        }
    });
}

function editPermisos() {

    $("#divPermisos").empty();
    contenido = '<form id="formEditPermisos" method="post">\
                    <div class="form-group">\
                        <label for="ePerfil" class="col-form-label">Perfil :</label>\
                        <input id="ePerfil" type="text" name="perfil" class="form-control" style="text-transform:uppercase" readonly />\
                    </div>\
                    <div class="form-group">\
                        <label for="eDescripcion" class="col-form-label">Descripción del Perfl :</label>\
                        <textarea id="eDescripcion" type="text" rows="3" name="descripcion" class="form-control" readonly />\
                    </div>\
                    <ul id="ulPermisos" class="list-group"></ul>\
                    <div class="form-row">\
                        <div class="col-auto">\
                            <button type="submit" class="btn btn3d btn-primary btn-m">\
                                <span class="glyphicon glyphicon-floppy-disk spanBtn"></span>Guardar\
                            </button>\
                        </div>\
                        <div class="col-auto">\
                            <button id="eBtnCancPermisos" type="reset" value="Reset" class="btn btn3d btn-danger btn-m">\
                                <span class="glyphicon glyphicon-ban-circle spanBtn"></span>Cancelar\
                            </button>\
                        </div>\
                    </div>\
                </form>';
    $("#divPermisos").append(contenido);

}

function editPermisosLlenar(id) {

    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataEditPerfil&id=" + id,
        success: function (response) {
            $("#ePerfil").val(response.perfil);
            $("#eDescripcion").val(response.descripcion);
        }
    });

    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataPermisos&perf_id=" + id,
        success: function (response) {
            var tit = '<li class="list-group-item d-flex justify-content-between align-items-center" style="background-color: #3c8dbc; color: white;">\
                           <label>MENÚ DEL SISTEMA</label>\
                           <span class="badge label-danger" style="font-size: 13px;">Registra</span>\
                       </li>';
            $("#ulPermisos").append(tit);
            var countM = 0;
            $.each(response.listPermisos, function (index, value) {
                countM++;
                var cont = '<li class="list-group-item d-flex justify-content-between align-items-center">\
                                <label class="custom-control custom-checkbox">';
                if (value.activo) {
                    cont += '<input type="checkbox" class="custom-control-input" name="activo_' + value.menuId + '" value=' + value.menuId + ' checked="">';
                } else {
                    cont += '<input type="checkbox" class="custom-control-input" name="activo_' + value.menuId + '" value=' + value.menuId + '>';
                }
                cont += '<span class="custom-control-indicator"></span>&nbsp;&nbsp;&nbsp;\
                         <span class="custom-control-description">' + value.menuDescripcion + '</span>\
                         </label>\
                         <label class="custom-control custom-checkbox" style="float: right;">';
                if (value.registra) {
                    cont += '<input type="checkbox" class="custom-control-input" name="registra_' + value.menuId + '" value=' + value.menuId + ' checked="">';
                } else {
                    cont += '<input type="checkbox" class="custom-control-input" name="registra_' + value.menuId + '" value=' + value.menuId + '>';
                }
                cont += '<span class="custom-control-indicator red"></span>\
                         <span class="custom-control-description"></span>\
                         </label>\
                         </li>';
                $("#ulPermisos").append(cont);
            });
            var action = "./Usuario?action=update_permisos&perf_id=" + response.id + "&count=" + countM + "";
            $("#formEditPermisos").attr("action", action);
            document.getElementById('divPermisos').classList.add('div-permisos');
            document.getElementById('divFondo').classList.add('div-atras');
            $("#divPermisos").css('top', ((($(window).height() - $("#divPermisos").height()) / 2) + $(window).scrollTop()) + "px");
        }
    });

}