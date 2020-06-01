// Administración de Usuarios del Sistema

function llenar_admin_usuarios() {

    $("#divAdminConte").empty();
    contenido = '<div>\
                    <button id="btnNuevoUsuario" class="btn btn3d btn-white btn-m">Añadir Nuevo Usuario\
                       <img src="./resources/images/nuevo_usuario.png"/>\
                    </button>\
                 </div>\
                 <div id="divTablaUsuario" class="tabla_reporte" style="overflow-x:auto;"></div>';
    $("#divAdminConte").append(contenido);
    usuarios();

    $("#btnNuevoUsuario").click(function () {
        nuevoUsua();
        $("#nUsuaFoto").attr("src", "./resources/images/masculino.png");
        document.getElementById("nlistSexo").value = "M";
        $.ajax({
            dataType: 'json',
            url: "./GsonData?url=DataPerfiles",
            success: function (response) {
                $.each(response.listPerfiles, function (index, value) {
                    obje = "<option value=" + value.perfId + ">" + value.perfNombre + "</option>";
                    $("#nlistPerfil").append(obje);
                });
                document.getElementById("nlistPerfil").value = "1";
            }
        });
        $.ajax({
            dataType: 'json',
            url: "./GsonData?url=DataEjecutoras",
            success: function (response) {
                $("#nlistEjecutora").append("<option value= '000000'>Pliego 459 - Gobierno Regional de San Martin</option>");
                $.each(response.listEjecutoras, function (index, value) {
                    var nombre_ejec = (value.nombre).split("-");
                    var objeE = "<option value=" + value.sec_ejec + ">UE " + value.ejecutora + " - " + nombre_ejec[1].trim() + " (" + value.sec_ejec + ")</option>";
                    $("#nlistEjecutora").append(objeE);
                });
                $('#nlistEjecutora').prop('selectedIndex', 1);
            }
        });
        document.getElementById('divUsuario').classList.add('div-usuario');
        document.getElementById('divFondo').classList.add('div-atras');
        $("#divUsuario").css('top', ((($(window).height() - $("#divUsuario").height()) / 2) + $(window).scrollTop()) + "px");

        $("#nlistSexo").bind("change", function () {
            if ($("#nlistSexo").val() === "M") {
                $("#nUsuaFoto").attr("src", "./resources/images/masculino.png");
            }
            if ($("#nlistSexo").val() === "F") {
                $("#nUsuaFoto").attr("src", "./resources/images/femenino.png");
            }
        });

        $("#nBtnCancUsua").click(function () {
            $("#divUsuario").empty();
            document.getElementById('divUsuario').classList.remove('div-usuario');
            document.getElementById('divFondo').classList.remove('div-atras');
        });

        $("#formNuevoUsua").submit(function (evt) {
            evt.preventDefault();
            $.ajax({
                dataType: 'json',
                type: 'post',
                url: $(this).attr("action"),
                data: $(this).serialize(),
                success: function (response) {
                    if (response.success) {
                        alertify.log(response.msg);
                        $("#divUsuario").empty();
                        document.getElementById('divUsuario').classList.remove('div-usuario');
                        document.getElementById('divFondo').classList.remove('div-atras');
                        usuarios();
                    } else {
                        alertify.log(response.msg);
                    }
                }
            });
        });

    });
}

function usuarios() {
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataUsuarios",
        success: function (response) {
            $("#divTablaUsuario").empty();
            conten = '<table id="tablaUsuario" class="display" cellspacing="0" width="100%">\
                        <thead id="tablaUsuarioHead"></thead>\
                        <tfoot id="tablaUsuarioFoot"></tfoot>\
                        <tbody id="tablaUsuarioBody"></tbody>\
                     </table>';
            $("#divTablaUsuario").append(conten);
            head = "<tr>\
                        <th style='text-align: center;'>Id</th>\
                        <th style='text-align: center;'>Apellido paterno</th>\
                        <th style='text-align: center;'>Apellido materno</th>\
                        <th style='text-align: center;'>Nombres</th>\
                        <th style='text-align: center;'>Documento Identidad</th>\
                        <th style='text-align: center;'>Unidad Ejecutora</th>\
                        <th style='text-align: center;'>Sexo</th>\
                        <th style='text-align: center;'>Perfil</th>\
                        <th style='text-align: center;'>Estado</th>\
                        <th style='text-align: center;'>Acción</th>\
                    </tr>";
            $("#tablaUsuarioHead").append(head);
            $("#tablaUsuarioFoot").append(head);
            $.each(response.listUsuarios, function (index, value) {
                var sexo;
                var estado;
                var ejecutora;
                if (value.usuaSexo === "M") {
                    sexo = "Masculino";
                }
                if (value.usuaSexo === "F") {
                    sexo = "Femenino";
                }
                if (value.usuaEstado === true) {
                    estado = "Activo";
                }
                if (value.usuaEstado === false) {
                    estado = "Inactivo";
                }
                if (value.sec_ejec === "000000") {
                    ejecutora = "PLIEGO 459 - GOBIERNO REGIONAL SAN MARTIN";
                } else {
                    var nombre_ejec = (value.nombre).split("-");
                    ejecutora = "UE " + value.ejecutora + " - " + nombre_ejec[1].trim() + " (" + value.sec_ejec + ")";
                }
                body = "<tr>\
                            <td align='center'>" + (index + 1) + "</td>\
                            <td align='left'>" + value.usuaApellidoPaterno + "</td>\
                            <td align='left'>" + value.usuaApellidoMaterno + "</td>\
                            <td align='left'>" + value.usuaNombres + "</td>\
                            <td align='center'>" + value.usuaLogin + "</td>\
                            <td align='left'>" + ejecutora + "</td>\
                            <td align='center'>" + sexo + "</td>\
                            <td align='left'>" + value.perfNombre + "</td>\
                            <td align='center'>" + estado + "</td>\
                            <td align='center'>\
                                <button id='btnEditU" + value.usuaId + "' title='Editar' class='btn btn-default btn-sm'>\
                                    <i class='fa fa-edit'></i>\
                                </button>\
                                <button id='btnDeleteU" + value.usuaId + "' title='Eliminar' class='btn btn-danger btn-sm'>\
                                    <i class='fa fa-trash'></i>\
                                </button>\
                            </td>\
                        </tr>";
                $("#tablaUsuarioBody").append(body);

                $("#btnEditU" + value.usuaId).click(function () {
                    editUsua();
                    editUsuaLlenar(value.usuaId);
                    document.getElementById('divUsuario').classList.add('div-usuario');
                    document.getElementById('divFondo').classList.add('div-atras');
                    $("#divUsuario").css('top', ((($(window).height() - $("#divUsuario").height()) / 2) + $(window).scrollTop()) + "px");

                    $("#elistSexo").bind("change", function () {
                        if ($("#elistSexo").val() === "M") {
                            $("#eUsuaFoto").attr("src", "./resources/images/masculino.png");
                        }
                        if ($("#elistSexo").val() === "F") {
                            $("#eUsuaFoto").attr("src", "./resources/images/femenino.png");
                        }
                    });

                    $("#eBtnCancUsua").click(function () {
                        $("#divUsuario").empty();
                        document.getElementById('divUsuario').classList.remove('div-usuario');
                        document.getElementById('divFondo').classList.remove('div-atras');
                    });

                    $("#formEditUsua").submit(function (evt) {
                        evt.preventDefault();
                        $.ajax({
                            dataType: 'json',
                            type: 'post',
                            url: $(this).attr("action"),
                            data: $(this).serialize(),
                            success: function (response) {
                                if (response.success) {
                                    alertify.log(response.msg);
                                    $("#divUsuario").empty();
                                    document.getElementById('divUsuario').classList.remove('div-usuario');
                                    document.getElementById('divFondo').classList.remove('div-atras');
                                    usuarios();
                                } else {
                                    alertify.log(response.msg);
                                }

                            }
                        });
                    });

                });

                $("#btnDeleteU" + value.usuaId).click(function () {
                    alertify.confirm("¿Está seguro que desea eliminar este usuario?", function (e) {
                        if (e) {
                            $.ajax({
                                dataType: 'json',
                                url: "./Usuario?action=delete&usua_id=" + value.usuaId + "",
                                success: function (response) {
                                    alertify.log(response.msg);
                                    usuarios();
                                }
                            });
                        } else {
                        }
                    });
                });

            });
            $('#tablaUsuario').dataTable({
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
                        filename: 'lista_usuarios_sistema',
                        title: 'LISTA DE USUARIOS',
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

function nuevoUsua() {

    $("#divUsuario").empty();
    contenido = '<form id="formNuevoUsua" method="post" action="./Usuario?action=nuevo">\
                    <div class="col-md-6">\
                        <div class="form-group">\
                            <label for="nNombres" class="col-form-label">Nombres :</label>\
                            <input id="nNombres" type="text" name="nombres" class="form-control" style="text-transform:uppercase" \
                            placeholder="Ingrese Nombres"/>\
                        </div>\
                        <div class="form-group">\
                            <label for="nPaterno" class="col-form-label">Apellido Paterno :</label>\
                            <input id="nPaterno" type="text" name="paterno" class="form-control" style="text-transform:uppercase" \
                            placeholder="Ingrese Apellido Paterno"/>\
                        </div>\
                        <div class="form-group">\
                            <label for="nMaterno" class="col-form-label">Apellido Materno :</label>\
                            <input id="nMaterno" type="text" name="materno" class="form-control" style="text-transform:uppercase" \
                            placeholder="Ingrese Apellido Materno"/>\
                        </div>\
                        <div class="form-group">\
                            <label for="nDNI" class="col-form-label">Documento de Identidad :</label>\
                            <input id="nDNI" type="text" name="dni" class="form-control" maxlength="8" \
                            placeholder="INGRESE DOCUMENTO" onkeypress="return soloNumero(event)"/>\
                        </div>\
                        <div class="form-group">\
                            <label for="nPassword" class="col-form-label">Contraseña :</label>\
                            <input id="nPassword" type="text" name="password" class="form-control" \
                            placeholder="INGRESE CONTRASEÑA"/>\
                        </div>\
                    </div>\
                    <div class="col-md-6">\
                        <div class="form-group">\
                            <img id="nUsuaFoto" width="90%"/>\
                        </div>\
                        <div class="form-group">\
                            <label for="nlistSexo" class="col-form-label">Género :</label>\
                            <select id="nlistSexo" class="select-form" name="sexo">\
                                <option value="M">Masculino</option>\
                                <option value="F">Femenino</option>\
                            </select>\
                        </div>\
                        <div class="form-group">\
                            <label for="nlistPerfil" class="col-form-label">Perfil :</label>\
                            <select id="nlistPerfil" class="select-form" name="perf_id"></select>\
                        </div>\
                    </div>\
                    <div class="col-md-12">\
                        <div class="form-group">\
                            <label for="nlistEjecutora" class="col-form-label">Unidad Ejecutora :</label>\
                            <select id="nlistEjecutora" class="select-form" name="sec_ejec"></select>\
                        </div>\
                        <br/>\
                        <div class="form-group">\
                            <label class="custom-control custom-checkbox">\
                                <input id="nEstado" type="checkbox" class="custom-control-input" value="true" name="estado" checked>\
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
                                <button id="nBtnCancUsua" type="reset" value="Reset" class="btn btn3d btn-danger btn-m">\
                                    <span class="glyphicon glyphicon-ban-circle spanBtn"></span>Cancelar\
                                </button>\
                            </div>\
                        </div>\
                    </div>\
                </form>';
    $("#divUsuario").append(contenido);
}

function editUsua() {

    $("#divUsuario").empty();
    contenido = '<form id="formEditUsua" method="post">\
                    <div class="col-md-6">\
                        <div class="form-group">\
                            <label for="eNombres" class="col-form-label">Nombres :</label>\
                            <input id="eNombres" type="text" name="nombres" class="form-control" style="text-transform:uppercase" \
                            placeholder="Ingrese Nombres"/>\
                        </div>\
                        <div class="form-group">\
                            <label for="ePaterno" class="col-form-label">Apellido Paterno :</label>\
                            <input id="ePaterno" type="text" name="paterno" class="form-control" style="text-transform:uppercase" \
                            placeholder="Ingrese Apellido Paterno"/>\
                        </div>\
                        <div class="form-group">\
                            <label for="eMaterno" class="col-form-label">Apellido Materno :</label>\
                            <input id="eMaterno" type="text" name="materno" class="form-control" style="text-transform:uppercase" \
                            placeholder="Ingrese Apellido Materno"/>\
                        </div>\
                        <div class="form-group">\
                            <label for="eDNI" class="col-form-label">Documento de Identidad :</label>\
                            <input id="eDNI" type="text" name="dni" class="form-control" maxlength="8" \
                            placeholder="INGRESE DOCUMENTO" onkeypress="return soloNumero(event)"/>\
                        </div>\
                        <div class="form-group">\
                            <label for="ePassword" class="col-form-label">Contraseña :</label>\
                            <input id="ePassword" type="text" name="password" class="form-control" \
                            placeholder="INGRESE CONTRASEÑA"/>\
                        </div>\
                    </div>\
                    <div class="col-md-6">\
                        <div class="form-group">\
                            <img id="eUsuaFoto" width="90%"/>\
                        </div>\
                        <div class="form-group">\
                            <label for="elistSexo" class="col-form-label">Género :</label>\
                            <select id="elistSexo" class="select-form" name="sexo">\
                                <option value="F">Femenino</option>\
                                <option value="M">Masculino</option>\
                            </select>\
                        </div>\
                        <div class="form-group">\
                            <label for="elistPerfil" class="col-form-label">Perfil :</label>\
                            <select id="elistPerfil" class="select-form" name="perf_id"></select>\
                        </div>\
                    </div>\
                    <div class="col-md-12">\
                        <div class="form-group">\
                            <label for="elistEjecutora" class="col-form-label">Unidad Ejecutora :</label>\
                            <select id="elistEjecutora" class="select-form" name="sec_ejec"></select>\
                        </div>\
                        <br/>\
                        <div class="form-group">\
                            <label class="custom-control custom-checkbox">\
                                <input id="eEstado" type="checkbox" class="custom-control-input" value="true" name="estado" checked>\
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
                                <button id="eBtnCancUsua" type="reset" value="Reset" class="btn btn3d btn-danger btn-m">\
                                    <span class="glyphicon glyphicon-ban-circle spanBtn"></span>Cancelar\
                                </button>\
                            </div>\
                        </div>\
                    </div>\
                </form>';
    $("#divUsuario").append(contenido);
}

function editUsuaLlenar(id) {

    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataEditUsua&id=" + id,
        success: function (response) {
            var sexo;
            $("#eNombres").val(response.nombres);
            $("#ePaterno").val(response.paterno);
            $("#eMaterno").val(response.materno);
            $("#eDNI").val(response.dni);
            $("#ePassword").val(response.password);
            $("#eEstado").prop("checked", response.estado);
            if (response.sexo === "M") {
                sexo = "masculino";
            }
            if (response.sexo === "F") {
                sexo = "femenino";
            }
            $("#eUsuaFoto").attr("src", "./resources/images/" + sexo + ".png");
            document.getElementById("elistSexo").value = response.sexo;
            var perfil = response.perfil;
            $.ajax({
                dataType: 'json',
                url: "./GsonData?url=DataPerfiles",
                success: function (responseP) {
                    $.each(responseP.listPerfiles, function (indexP, valueP) {
                        var objeP = "<option value=" + valueP.perfId + ">" + valueP.perfNombre + "</option>";
                        $("#elistPerfil").append(objeP);
                    });
                    document.getElementById("elistPerfil").value = perfil;
                }
            });
            var ejec = response.ejec;
            $.ajax({
                dataType: 'json',
                url: "./GsonData?url=DataEjecutoras",
                success: function (response) {
                    $("#elistEjecutora").append("<option value= '000000'>Pliego 459 - Gobierno Regional de San Martin</option>");
                    $.each(response.listEjecutoras, function (index, value) {
                        var nombre_ejec = (value.nombre).split("-");
                        var objeE = "<option value=" + value.sec_ejec + ">UE " + value.ejecutora + " - " + nombre_ejec[1].trim() + " (" + value.sec_ejec + ")</option>";
                        $("#elistEjecutora").append(objeE);
                    });
                    document.getElementById("elistEjecutora").value = ejec;
                }
            });
            var action = "./Usuario?action=editar&usua_id=" + id + "";
            $("#formEditUsua").attr("action", action);
        }
    });
}