// Monitor de Sincronización de las Unidades Ejecutoras y Tablas de SIAF de cada una... 

function llenar_alert_sincronizacion() {
    alert("funciona");
}

function llenar_admin_sincronizacion() {

    $("#divAdminConte").empty();
    contenido = '<div>\
                    <ul class="list-group">\
                        <li class="list-group-item align-items-center label-primary" style="text-align: center;">\
                            <label >SINCRONIZACION DE LAS BASES DE DATOS SIAF DE LA UNIDADES EJECUTORAS</label>\
                        </li>\
                    </ul>\
                 </div>\
                 <div class="form-group row tabla_reporte">\
                    <label for="iptFecha" class="col-sm-1 col-form-label">Fecha :</label>\
                    <div class="col-sm-2">\
                       <input id="iptFecha" name="fecha" type="date" class="col-form-date" data-date-format="dd/mm/yyyy">\
                    </div>\
                    <div class="col-sm-2"></div>\
                    <div style="float: right;">\
                       <button id="btnActualSincro" class="btn btn-danger">\
                           <span class="glyphicon glyphicon-refresh spanBtn"></span>Actualizar\
                       </button>\
                    </div>\
                 </div>\
                 <div id="divTablaSincronizaEjec" class="tabla_reporte" style="overflow-x:auto;"></div>\
                 <div id="divTablaSincronizaTablas" class="tabla_reporte" style="overflow-x:auto;"></div>';
    $("#divAdminConte").append(contenido);

    //document.getElementById("iptFecha").valueAsDate = new Date();    Cambia la hora a partir de 19:00 horas
    var today = new Date();
    var year = today.getFullYear();
    var month = today.getMonth();
    var day = today.getDate();
    var fecha = year + "-" + castMonth(month) + "-" + castDay(day);

    $("#iptFecha").val(fecha);

    sincronizaEjec($("#iptFecha").val());

    $("#iptFecha").change(function () {
        sincronizaEjec($("#iptFecha").val());
    });

    $("#btnActualSincro").click(function () {
        sincronizaEjec($("#iptFecha").val());
    });

}

function sincronizaEjec(fecha) {
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataSincronizaEjecutoras&fecha=" + fecha + "",
        success: function (response) {
            $("#divTablaSincronizaEjec").empty();
            $("#divTablaSincronizaTablas").empty();
            conten = '<table id="tablaSincronizaEjec" class="display" cellspacing="0" width="100%">\
                            <thead id="tablaSincronizaEjecHead"></thead>\
                            <tfoot id="tablaSincronizaEjecFoot"></tfoot>\
                            <tbody id="tablaSincronizaEjecBody"></tbody>\
                    </table>';
            $("#divTablaSincronizaEjec").append(conten);
            head = "<tr>\
                        <th style='text-align: center;'>Id</th>\
                        <th style='text-align: center;'>Unidad Ejecutora</th>\
                        <th style='text-align: center;'>Última Fecha de Sincronización</th>\
                        <th style='text-align: center;'>Fecha</th>\
                        <th style='text-align: center;'>Sincronizó</th>\
                    </tr>";
            $("#tablaSincronizaEjecHead").append(head);
            $("#tablaSincronizaEjecFoot").append(head);
            $.each(response.list, function (index, value) {
                var nombre_ejec = (value.nombre).split("-");
                var fecha;
                var sincronizo;
                if (!$.trim(value.fecha)) {
                    fecha = "";
                    sincronizo = '<span class="label label-danger">NO</span>';
                } else {
                    fecha = value.fecha;
                    sincronizo = '<span class="label label-success">SI</span>';
                }
                var ejecutora = "UE " + value.ejecutora + " - " + nombre_ejec[1].trim() + " (" + value.sec_ejec + ")";
                var body = "<tr>\
                            <td align='center'>" + (index + 1) + "</td>\
                            <td align='left'>\
                                <a id='aRef_" + value.sec_ejec + "' class='hRef'>" + ejecutora + "</a>\
                            </td>\
                            <td id='td_" + value.sec_ejec + "' align='center'></td>\
                            <td align='center'>" + fecha + "</td>\
                            <td align='center'>" + sincronizo + "</td>\
                         </tr>";
                $.ajax({
                    dataType: 'json',
                    url: "./GsonData?url=DataSincronizaUltimaFecha&sec_ejec=" + value.sec_ejec,
                    success: function (responseU) {
                        var fecha_hora = responseU.fecha_hora.split(",");
                        var diaESP = diasENGtoESP(fecha_hora[0]);
                        if (!$.trim(value.fecha)) {
                            fecha_hora = "<span style='color: orangered;'>" + diaESP + "," + fecha_hora[1] + "</span>";
                        } else {
                            fecha_hora = "<span>" + diaESP + "," + fecha_hora[1] + "</span>";
                        }
                        $("#td_" + responseU.ejec).append(fecha_hora);
                    }
                });
                $("#tablaSincronizaEjecBody").append(body);

                $("#aRef_" + value.sec_ejec).click(function () {
                    sincronizaTablas(value.sec_ejec, fecha, ejecutora);
                });

            });
            $('#tablaSincronizaEjec').dataTable({
                ordering: true,
                pageLength: 25,
                dom: '<"centrar-div-tabla"lfB>iprtip',
                buttons: [
                    {
                        extend: 'excel',
                        filename: 'lista_ejecutoras_sincronizadas',
                        title: 'LISTA DE UNIDADES EJECUTORAS SINCRONIZADAS - SIAF',
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

function sincronizaTablas(ejec, fecha, ejecutora) {
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataSincronizaTablas&ejec=" + ejec + "&fecha=" + fecha + "&ejecutora=" + ejecutora + "",
        success: function (response) {
            $("#divTablaSincronizaTablas").empty();
            conten = '<div>\
                        <ul class="list-group">\
                            <li class="list-group-item align-items-center label-primary" style="text-align: center;">\
                                <label >SINCRONIZACION DE TABLAS DE LA ' + response.ejecutora + '</label>\
                            </li>\
                        </ul>\
                      </div>\
                      <table id="tablaSincronizaTablas" class="display" cellspacing="0" width="100%">\
                            <thead id="tablaSincronizaTablasHead"></thead>\
                            <tfoot id="tablaSincronizaTablasFoot"></tfoot>\
                            <tbody id="tablaSincronizaTablasBody"></tbody>\
                      </table>';
            $("#divTablaSincronizaTablas").append(conten);
            head = "<tr>\
                        <th style='text-align: center;'>Id</th>\
                        <th style='text-align: center;'>Unidad Ejecutora</th>\
                        <th style='text-align: center;'>Fecha/Hora</th>\
                        <th style='text-align: center;'>HostName</th>\
                        <th style='text-align: center;'>IP Local</th>\
                        <th style='text-align: center;'>Tabla</th>\
                        <th style='text-align: center;'>Sincronizó</th>\
                        <th style='text-align: center;'>Log SIAF Cliente</th>\
                        <th style='text-align: center;'>Log Web Server</th>\
                    </tr>";
            $("#tablaSincronizaTablasHead").append(head);
            $("#tablaSincronizaTablasFoot").append(head);
            $.each(response.list, function (index, value) {
                var tabla;
                var sincronizo;
                if (value.sincronizo === "NO") {
                    tabla = "<span style='color: orangered;'>" + value.tabla + "</span>";
                    sincronizo = '<span class="label label-danger">' + value.sincronizo + '</span>';
                }
                if (value.sincronizo === "SI") {
                    tabla = "<span>" + value.tabla + "</span>";
                    sincronizo = '<span class="label label-success">' + value.sincronizo + '</span>';
                }
                var logCliente;
                if (!$.trim(value.logCliente)) {
                    logCliente = "";
                } else {
                    logCliente = value.logCliente;
                }
                var logServidor;
                if (!$.trim(value.logServidor)) {
                    logServidor = "";
                } else {
                    logServidor = value.logServidor;
                }
                var body = "<tr>\
                            <td align='center'>" + (index + 1) + "</td>\
                            <td align='center'>" + response.ejecutora + "</td>\
                            <td align='center'>" + value.fechaHora + "</td>\
                            <td align='center'>" + value.hostname + "</td>\
                            <td align='center'>" + value.ipLocal + "</td>\
                            <td align='center'>" + tabla + "</td>\
                            <td align='center'>" + sincronizo + "</td>\
                            <td align='center'>" + logCliente + "</td>\
                            <td align='center'>" + logServidor + "</td>\
                         </tr>";
                $("#tablaSincronizaTablasBody").append(body);
            });

            $('#tablaSincronizaTablas').dataTable({
                ordering: true,
                dom: '<"centrar-div-tabla"lfB>iprtip',
                buttons: [
                    {
                        extend: 'excel',
                        filename: 'lista_tablas_sincronizadas_ue_' + response.sec_ejec,
                        title: 'LISTA DE TABLAS SINCRONIZADAS DE SIAF',
                        messageTop: response.ejecutora,
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

function diasENGtoESP(diaENG) {
    var diaESP;
    if (diaENG === "Monday") {
        diaESP = "Lunes";
    }
    if (diaENG === "Tuesday") {
        diaESP = "Martes";
    }
    if (diaENG === "Wednesday") {
        diaESP = "Miércoles";
    }
    if (diaENG === "Thursday") {
        diaESP = "Jueves";
    }
    if (diaENG === "Friday") {
        diaESP = "Viernes";
    }
    if (diaENG === "Saturday") {
        diaESP = "Sábado";
    }
    if (diaENG === "Sunday") {
        diaESP = "Domingo";
    }
    return diaESP;
}