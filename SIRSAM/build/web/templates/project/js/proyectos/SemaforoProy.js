function proy_semaforo_proyecto_alert() {
    alert("funciona Semáforo de Proyectos");
}

function llenar_proy_semaforo_proyecto() {
    $("#divProyectos").empty();
    filtro = '<div id="divProySemaforoFiltro" class="filtro_report naranja_secun">\
                <div class="form-group row">\
                  <label for="listProySemaforoEjec" class="col-sm-2 col-form-label">Elija Ejecutora :</label>\
                  <div class="col-sm-10">\
                    <select class="select-form" id="listProyEjecutoraSemaforo"></select>\
                  </div>\
                </div>\
                <div class="form-group row">\
                  <label for="listProySemaforoTipo" class="col-sm-2 col-form-label">Filtro Tipo :</label>\
                  <div class="col-sm-3">\
                    <select class="select-form" id="listProySemaforoTipo">\
                      <option value="00" selected>--TODOS--</option>\
                      <option value="01">Proyectos Genéricos</option>\
                      <option value="02">Proyectos Específicos</option>\
                    </select>\
                  </div>\
                  <div class="col-sm-1"></div>\
                  <label for="listProySemaforoEstado" class="col-sm-2 col-form-label">Filtro Semáforo :</label>\
                  <div class="col-sm-2">\
                    <select class="select-form" id="listProySemaforoEstado">\
                      <option value= "00" selected>--TODOS--</option>\
                      <option value= "01" style="color: green; font-weight: bold;">Verde</option>\
                      <option value= "02" style="color: #FFBF00; font-weight: bold;">Ámbar</option>\
                      <option value= "03" style="color: red; font-weight: bold;">Rojo</option>\
                    </select>\
                  </div>\
                </div>\
              </div>\
              <br>\
              <div id="divProySemaforoContenido" class="filtro_report naranja_secun">\
              </div>';
    $("#divProyectos").append(filtro);
    llenarProyEjecSemaforo();
    controlProyFiltroSemaforo();
}

function llenarProyEjecSemaforo() {
    $.ajax({
        dataType: 'json',
        url: "./Proyectos?tipo=ejecutoras",
        success: function (response) {
            $("#listProyEjecutoraSemaforo").append("<option value= '00'>Pliego 459 - Gobierno Regional de San Martin</option>");
            $.each(response.listEjecutoras, function (index, value) {
                var nombre_ejec = (value.nombre_ejecutora).split("-");
                obje = "<option value=" + value.sec_ejec + ">UE " + value.ejecutora + " - " + nombre_ejec[1].trim() + " (" + value.sec_ejec + ")</option>";
                $("#listProyEjecutoraSemaforo").append(obje);
            });
            $('#listProyEjecutoraSemaforo').prop('selectedIndex', 0);
            var ejec = $('#listProyEjecutoraSemaforo').val();
            var tipo = $('#listProySemaforoTipo').val();
            var estado = $("#listProySemaforoEstado").val();
            llenar_proy_semaforo_proyecto_contenido(ejec, tipo, estado);
        }
    });
}

function controlProyFiltroSemaforo() {
    $("#listProyEjecutoraSemaforo").bind("change", function () {
        var ejec = $('#listProyEjecutoraSemaforo').val();
        var tipo = $('#listProySemaforoTipo').val();
        var estado = $("#listProySemaforoEstado").val();
        llenar_proy_semaforo_proyecto_contenido(ejec, tipo, estado);
    });
    $("#listProySemaforoTipo").bind("change", function () {
        var ejec = $('#listProyEjecutoraSemaforo').val();
        var tipo = $('#listProySemaforoTipo').val();
        var estado = $("#listProySemaforoEstado").val();
        llenar_proy_semaforo_proyecto_contenido(ejec, tipo, estado);
    });
    $("#listProySemaforoEstado").bind("change", function () {
        var ejec = $('#listProyEjecutoraSemaforo').val();
        var tipo = $('#listProySemaforoTipo').val();
        var estado = $("#listProySemaforoEstado").val();
        llenar_proy_semaforo_proyecto_contenido(ejec, tipo, estado);
    });
}

function llenar_proy_semaforo_proyecto_contenido(ejec, tipo, estado) {
    var titulo_reporte = $("#listProyEjecutoraSemaforo option:selected").text();
    $("#divProySemaforoContenido").empty();
    proyCont = '<div>\
                  <label class="titulo">SEMÁFORO EJECUCIÓN DE PROYECTOS</label>\
                  <label class="titulo">' + titulo_reporte.toUpperCase() + '</label>\
                </div>\
                <br>\
                <div id="divProyLeyendaSemaforo" class="leyendaSemaf"></div>\
                <div id="divTablaProySemaforo" style="overflow-x:auto;"></div>';
    $("#divProySemaforoContenido").append(proyCont);
    var imageUrl_verde = './resources/images/semaforo_verde.png';
    var imageUrl_naranja = './resources/images/semaforo_naranja.png';
    var imageUrl_rojo = './resources/images/semaforo_rojo.png';
    var img_verde, img_naranja, img_rojo;
    convertImgToDataURLviaCanvas(imageUrl_verde, function (base64Img) {
        img_verde = base64Img;
    });
    convertImgToDataURLviaCanvas(imageUrl_naranja, function (base64Img) {
        img_naranja = base64Img;
    });
    convertImgToDataURLviaCanvas(imageUrl_rojo, function (base64Img) {
        img_rojo = base64Img;
    });
    $('#divTablaProySemaforo').empty();
    $('#divTablaProySemaforo').append('<img src="./resources/gifs/cargando.gif" style="display:block; margin:auto;"></img>');
    $.ajax({
        dataType: 'json',
        url: "./Proyectos?tipo=semaforo&ejec=" + ejec + "&tipo_proy=" + tipo + "&estado=" + estado,
        success: function (response) {
            var leyenda1 = response.rojo;
            var leyenda2 = response.naranja;
            var leyenda3 = response.verde;
            $('#divProyLeyendaSemaforo').empty();
            leyendP = '<div class="col-sm-4"><img src="./resources/images/semaforo_rojo.png">&nbsp; ' + response.rojo + '</img></div>\
                       <div class="col-sm-4"><img src="./resources/images/semaforo_naranja.png">&nbsp; ' + response.naranja + '</img></div>\
                       <div class="col-sm-4"><img src="./resources/images/semaforo_verde.png">&nbsp; ' + response.verde + '</img></div>';
            $('#divProyLeyendaSemaforo').append(leyendP);
            $('#divTablaProySemaforo').empty();
            table = '<table id="tablaProySemaforo" class="display" cellspacing="0" width="100%">\
                        <thead id="tablaProySemaforoHead"></thead>\
                        <tbody id="tablaProySemaforoBody"></tbody>\
                     </table>';
            $("#divTablaProySemaforo").append(table);
            var año_actual = response.año_actual;
            var año_anterior = response.año_anterior;
            head = '<tr>\
                      <th class="center">Código SIAF</th>\
                      <th class="center">Código SNIP</th>\
                      <th class="center">Nombre Proyecto</th>\
                      <th class="center">Unidad Ejecutora</th>\
                      <th class="center">PIM (' + año_actual + ') (P)</th>\
                      <th class="center">Devengado (' + año_actual + ') (D)</th>\
                      <th class="center">Devengado (Acumulado al ' + año_anterior + ') (DA)</th>\
                      <th class="center">Avance Financiero %</th>\
                      <th class="center">Monto Contratado (MC)</th>\
                      <th class="center">Monto Inversión (MI)</th>\
                      <th class="center">Déficit de Proyecto (MI-DA-P)</th>\
                      <th class="center">Avance Físico %</th>\
                      <th class="center noexport">Semáforo</th>\
                    </tr>';
            $("#tablaProySemaforoHead").append(head);
            if (response.tipo === "00" || response.tipo === "01") {
                if (response.estadoSemaf) {
                    $.each(response.listSemaforo1, function (index, value) {
                        var siaf = value.act_proy;
                        var nombre = value.proyNombre;
                        var ejecutora = "";
                        if (response.ejec === "00") {
                            ejecutora = "Pliego " + response.pliego;
                        } else {
                            ejecutora = "UE " + value.ejecutora + " (" + value.sec_ejec + ")";
                        }
                        var pim;
                        if (!$.trim(value.pim)) {
                            pim = 0.00;
                        } else {
                            pim = value.pim;
                        }
                        var deven, avanFin;
                        if (!$.trim(value.devengado)) {
                            deven = 0.00;
                            avanFin = 0.00;
                        } else {
                            deven = value.devengado;
                            if (pim === 0.00) {
                                avanFin = 0.00;
                            } else {
                                avanFin = (deven / pim) * 100;
                            }
                        }
                        body1 = '<tr>\
                                <td class="center">' + siaf + '</td>\
                                <td class="center"></td>\
                                <td class="left">' + nombre + '</td>\
                                <td class="left">' + ejecutora + '</td>\
                                <td class="right">' + formatNumeroDecimal(pim) + '</td>\
                                <td class="right">' + formatNumeroDecimal(deven) + '</td>\
                                <td class="center"></td>\
                                <td class="center">' + formatNumeroDecimal(avanFin) + '</td>\
                                <td class="right"></td>\
                                <td class="right"></td>\
                                <td class="right"></td>\
                                <td class="center"></td>\
                                <td class="center"></td>\
                             </tr>';
                        $("#tablaProySemaforoBody").append(body1);
                    });
                }
            }
            var arraySecEjec = response.arraySecEjec;
            var arrayEjecutora = response.arrayEjecutora;
            if (response.tipo === "00" || response.tipo === "02") {
                $.each(response.listSemaforo2, function (index, value) {
                    var siaf = value.act_proy;
                    var snip;
                    if (!$.trim(value.proyCodigoInversion)) {
                        snip = "";
                    } else {
                        snip = value.proyCodigoInversion;
                    }
                    var nombre = value.proyNombre;
                    var ejecutora = "UE " + arrayEjecutora[index] + " (" + arraySecEjec[index] + ")";
                    var pim;
                    if (!$.trim(value.pim)) {
                        pim = 0.00;
                    } else {
                        pim = value.pim;
                    }
                    var deven, avanFin;
                    if (!$.trim(value.devengado)) {
                        deven = 0.00;
                        avanFin = 0.00;
                    } else {
                        deven = value.devengado;
                        if (pim === 0.00) {
                            avanFin = 0.00;
                        } else {
                            avanFin = (deven / pim) * 100;
                        }
                    }
                    var devenA;
                    if (!$.trim(value.devengado_acumulado)) {
                        devenA = 0.00;
                    } else {
                        devenA = value.devengado_acumulado;
                    }
                    var contra, ejecutado, avanFis, inver, deficit, img_estado, estadoS;
                    if (!$.trim(value.prcpMontoContratado)) {
                        contra = 0.00;
                    } else {
                        contra = value.prcpMontoContratado;
                    }
                    if (!$.trim(value.prvaMontoEjecutado)) {
                        ejecutado = 0.00;
                        avanFis = 0.00;
                    } else {
                        ejecutado = value.prvaMontoEjecutado;
                        if (contra === 0.00) {
                            avanFis = 0.00;
                        } else {
                            avanFis = (ejecutado / contra) * 100;
                        }
                    }
                    if (!$.trim(value.proyMontoActualizado)) {
                        inver = 0.00;
                    } else {
                        inver = value.proyMontoActualizado;
                    }
                    deficit = inver - (devenA + pim);
                    if (avanFis >= 100) {
                        estadoS = '<img src="./resources/images/semaforo_verde.png"></img>';
                        img_estado = img_verde;
                    }
                    if (avanFis >= 80 && avanFis < 100) {
                        estadoS = '<img src="./resources/images/semaforo_naranja.png"></img>';
                        img_estado = img_naranja;
                    }
                    if (avanFis < 80) {
                        estadoS = '<img src="./resources/images/semaforo_rojo.png"></img>';
                        img_estado = img_rojo;
                    }
                    body2 = '<tr>\
                                <td class="center">\
                                    <a id="atdProySemafCodSiaf' + siaf + '" class="td_proyecto">' + siaf + '</a>\
                                </td>\
                                <td class="center">\
                                    <a id="atdProySemafCodSnip' + siaf + '" class="td_proyecto">' + snip + '</a>\
                                </td>\
                                <td class="left">' + nombre + '</td>\
                                <td class="left">' + ejecutora + '</td>\
                                <td class="right">' + formatNumeroDecimal(pim) + '</td>\
                                <td class="right">' + formatNumeroDecimal(deven) + '</td>\
                                <td class="right">' + formatNumeroDecimal(devenA) + '</td>\
                                <td class="center">' + formatNumeroDecimal(avanFin) + '</td>\
                                <td class="right">' + formatNumeroDecimal(contra) + '</td>\
                                <td class="right">' + formatNumeroDecimal(inver) + '</td>\
                                <td class="right">' + formatNumeroDecimal(deficit) + '</td>\
                                <td class="center"><b>' + formatNumeroDecimal(avanFis) + '<b></td>\
                                <td class="center">' + estadoS + '</td>\
                             </tr>';
                    if (response.ejec === "00") {
                        $("#tablaProySemaforoBody").append(body2);
                    } else {
                        if (response.ejec === arraySecEjec[index]) {
                            $("#tablaProySemaforoBody").append(body2);
                        }
                    }

                    $("#atdProySemafCodSiaf" + siaf).click(function () {
                        llenar_proy_ficha_reporte($("#listProyReporte").val(), siaf);
                    });

                    $("#atdProySemafCodSnip" + siaf).click(function () {
                        llenar_proy_ficha_reporte($("#listProyReporte").val(), siaf);
                    });

                });

            }

            $('#tablaProySemaforo').dataTable({
                ordering: false,
                dom: '<"centrar-div-tabla"lfB>iprtip',
                buttons: [
                    {
                        extend: 'excel',
                        filename: 'semaforo_ejecucion_inversion_publica_' + (response.ejec === "00" ? "pliego459" : response.ejec) + '_' + año_actual,
                        title: 'SEMÁFORO EJECUCIÓN DE INVERSIÓN PÚBLICA - ' + año_actual,
                        messageTop: titulo_reporte.toUpperCase(),
                        exportOptions: {
                            orthogonal: 'sort',
                            columns: ':not(.noexport)'
                        },
                        customize: function (xlsx) {
                            var sheet = xlsx.xl.worksheets['sheet1.xml'];
                            for (var k = 4; k < 7; k++) {
                                var total = $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).length;
                                $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).each(function (i) {
                                    if (i > 0 && i < total) {
                                        $(this).attr('s', '72');
                                    }
                                });
                            }
                            for (var k = 7; k < 8; k++) {
                                var total = $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).length;
                                $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).each(function (i) {
                                    if (i > 0 && i < total) {
                                        $(this).attr('s', '73');
                                    }
                                });
                            }
                            for (var k = 8; k < 11; k++) {
                                var total = $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).length;
                                $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).each(function (i) {
                                    if (i > 0 && i < total) {
                                        $(this).attr('s', '72');
                                    }
                                });
                            }
                            for (var k = 11; k < 12; k++) {
                                var total = $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).length;
                                $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).each(function (i) {
                                    if (i > 0 && i < total) {
                                        $(this).attr('s', '73');
                                    }
                                });
                            }
                        }
                    }
                ]
            });

            var btnPDF = '<button id="btnProySemafPdf" class="dt-button buttons-html5">\
                            <span>\
                                <img src="./templates/plugins/datatables/images/pdf.png" data-toggle="tooltip" data-placement="bottom" title="Exportar a PDF">\
                            </span>\
                          </button>';
            $("#tablaProySemaforo_wrapper .dt-buttons").append(btnPDF);
            $("#tablaProySemaforo_wrapper .dt-buttons").css("margin-bottom", "10px");

            var imageUrl_grsm = './resources/images/logo_grsm.png';
            var imageUrl_system = './resources/images/logo_sirsm.png';
            var img_grsm, img_system;
            convertImgToDataURLviaCanvas(imageUrl_grsm, function (base64Img) {
                img_grsm = base64Img;
            });
            convertImgToDataURLviaCanvas(imageUrl_system, function (base64Img) {
                img_system = base64Img;
            });
            var newDate = new Date();
            var tiempo = newDate.getDate() + "/" + newDate.getMonth() + "/" + newDate.getFullYear() + "  " + newDate.getHours() + ":" + newDate.getMinutes();

            var muestra = [];
            $("#btnProySemafPdf").on('click', function () {
                muestra = [];
                var muestraHead = [];
                muestraHead.push({text: 'Código SIAF', style: 'tablaHead', alignment: 'center'});
                muestraHead.push({text: 'Código SNIP', style: 'tablaHead', alignment: 'center'});
                muestraHead.push({text: 'Nombre Proyecto', style: 'tablaHead', alignment: 'center'});
                muestraHead.push({text: 'Unidad Ejecutora', style: 'tablaHead', alignment: 'center'});
                muestraHead.push({text: 'PIM (' + año_actual + ') (P)', style: 'tablaHead', alignment: 'center'});
                muestraHead.push({text: 'Devengado (' + año_actual + ') (D)', style: 'tablaHead', alignment: 'center'});
                muestraHead.push({text: 'Devengado (Acumulado al ' + año_anterior + ') (DA)', style: 'tablaHead', alignment: 'center'});
                muestraHead.push({text: 'Avance Financiero %', style: 'tablaHead', alignment: 'center'});
                muestraHead.push({text: 'Monto Contratado (MC)', style: 'tablaHead', alignment: 'center'});
                muestraHead.push({text: 'Monto Inversión (MI)', style: 'tablaHead', alignment: 'center'});
                muestraHead.push({text: 'Déficit de Proyecto (MI-DA-P)', style: 'tablaHead', alignment: 'center'});
                muestraHead.push({text: 'Monto Ejecutado', style: 'tablaHead', alignment: 'center'});
                muestraHead.push({text: 'Avance Físico %', style: 'tablaHead', alignment: 'center'});
                muestraHead.push({text: 'Semáforo', style: 'tablaHead', alignment: 'center'});
                muestra.push(muestraHead);

                if (response.tipo === "00" || response.tipo === "01") {
                    if (response.estadoSemaf) {
                        $.each(response.listSemaforo1, function (index, value) {
                            var muestraBody = [];
                            var siaf = value.act_proy;
                            var nombre = value.proyNombre;
                            var ejecutora = "";
                            if (response.ejec === "00") {
                                ejecutora = "Pliego " + response.pliego;
                            } else {
                                ejecutora = "UE " + value.ejecutora + " (" + value.sec_ejec + ")";
                            }
                            var pim;
                            if (!$.trim(value.pim)) {
                                pim = 0.00;
                            } else {
                                pim = value.pim;
                            }
                            var deven, avanFin;
                            if (!$.trim(value.devengado)) {
                                deven = 0.00;
                                avanFin = 0.00;
                            } else {
                                deven = value.devengado;
                                if (pim === 0.00) {
                                    avanFin = 0.00;
                                } else {
                                    avanFin = (deven / pim) * 100;
                                }
                            }
                            muestraBody.push({text: siaf, style: 'tablaBody', alignment: 'center'});
                            muestraBody.push({text: '', style: 'tablaBody', alignment: 'center'});
                            muestraBody.push({text: nombre, style: 'tablaBody', alignment: 'left'});
                            muestraBody.push({text: ejecutora, style: 'tablaBody', alignment: 'left'});
                            muestraBody.push({text: formatNumeroDecimal(pim), style: 'tablaBody', alignment: 'right'});
                            muestraBody.push({text: formatNumeroDecimal(deven), style: 'tablaBody', alignment: 'right'});
                            muestraBody.push({text: '', style: 'tablaBody', alignment: 'center'});
                            muestraBody.push({text: formatNumeroDecimal(avanFin), style: 'tablaBody', alignment: 'center'});
                            muestraBody.push({text: '', style: 'tablaBody', alignment: 'center'});
                            muestraBody.push({text: '', style: 'tablaBody', alignment: 'center'});
                            muestraBody.push({text: '', style: 'tablaBody', alignment: 'center'});
                            muestraBody.push({text: '', style: 'tablaBody', alignment: 'center'});
                            muestraBody.push({text: '', style: 'tablaBody', alignment: 'center'});
                            muestraBody.push({text: '', style: 'tablaBody', alignment: 'center'});
                            muestra.push(muestraBody);
                        });
                    }
                }
                if (response.tipo === "00" || response.tipo === "02") {
                    $.each(response.listSemaforo2, function (index, value) {
                        var muestraBody = [];
                        var siaf = value.act_proy;
                        var snip;
                        if (!$.trim(value.proyCodigoInversion)) {
                            snip = "";
                        } else {
                            snip = value.proyCodigoInversion;
                        }
                        var nombre = value.proyNombre;
                        var ejecutora = "UE " + arrayEjecutora[index] + " (" + arraySecEjec[index] + ")";
                        var pim;
                        if (!$.trim(value.pim)) {
                            pim = 0.00;
                        } else {
                            pim = value.pim;
                        }
                        var deven, avanFin;
                        if (!$.trim(value.devengado)) {
                            deven = 0.00;
                            avanFin = 0.00;
                        } else {
                            deven = value.devengado;
                            if (pim === 0.00) {
                                avanFin = 0.00;
                            } else {
                                avanFin = (deven / pim) * 100;
                            }
                        }
                        var devenA;
                        if (!$.trim(value.devengado_acumulado)) {
                            devenA = 0.00;
                        } else {
                            devenA = value.devengado_acumulado;
                        }
                        var contra, ejecutado, avanFis, inver, deficit, img_estado, estadoS;
                        if (!$.trim(value.prcpMontoContratado)) {
                            contra = 0.00;
                        } else {
                            contra = value.prcpMontoContratado;
                        }
                        if (!$.trim(value.prvaMontoEjecutado)) {
                            ejecutado = 0.00;
                            avanFis = 0.00;
                        } else {
                            ejecutado = value.prvaMontoEjecutado;
                            if (contra === 0.00) {
                                avanFis = 0.00;
                            } else {
                                avanFis = (ejecutado / contra) * 100;
                            }
                        }
                        if (!$.trim(value.proyMontoActualizado)) {
                            inver = 0.00;
                        } else {
                            inver = value.proyMontoActualizado;
                        }
                        deficit = inver - (devenA + pim);
                        if (avanFis >= 100) {
                            estadoS = '<img src="./resources/images/semaforo_verde.png"></img>';
                            img_estado = img_verde;
                        }
                        if (avanFis >= 80 && avanFis < 100) {
                            estadoS = '<img src="./resources/images/semaforo_naranja.png"></img>';
                            img_estado = img_naranja;
                        }
                        if (avanFis < 80) {
                            estadoS = '<img src="./resources/images/semaforo_rojo.png"></img>';
                            img_estado = img_rojo;
                        }
                        muestraBody.push({text: siaf, style: 'tablaBody', alignment: 'center'});
                        muestraBody.push({text: snip, style: 'tablaBody', alignment: 'center'});
                        muestraBody.push({text: nombre, style: 'tablaBody', alignment: 'left'});
                        muestraBody.push({text: ejecutora, style: 'tablaBody', alignment: 'left'});
                        muestraBody.push({text: formatNumeroDecimal(pim), style: 'tablaBody', alignment: 'right'});
                        muestraBody.push({text: formatNumeroDecimal(deven), style: 'tablaBody', alignment: 'right'});
                        muestraBody.push({text: formatNumeroDecimal(devenA), style: 'tablaBody', alignment: 'right'});
                        muestraBody.push({text: formatNumeroDecimal(avanFin), style: 'tablaBodyB', alignment: 'center'});
                        muestraBody.push({text: formatNumeroDecimal(contra), style: 'tablaBody', alignment: 'right'});
                        muestraBody.push({text: formatNumeroDecimal(inver), style: 'tablaBody', alignment: 'right'});
                        muestraBody.push({text: formatNumeroDecimal(deficit), style: 'tablaBody', alignment: 'right'});
                        muestraBody.push({text: formatNumeroDecimal(ejecutado), style: 'tablaBody', alignment: 'right'});
                        muestraBody.push({text: formatNumeroDecimal(avanFis), style: 'tablaBodyB', alignment: 'center'});
                        muestraBody.push({image: img_estado, style: 'tablaBody', width: 10, alignment: 'center'});
                        if (response.ejec === "00") {
                            muestra.push(muestraBody);
                        } else {
                            if (response.ejec === arraySecEjec[index]) {
                                muestra.push(muestraBody);
                            }
                        }

                    });

                }

                var docDefinition = {
                    pageOrientation: 'landscape',
                    info: {
                        title: 'semaforo_ejecucion_inversion_publica_' + (response.ejec === "00" ? "pliego459" : response.ejec) + '_' + año_actual
                    },
                    pageMargins: [40, 60, 40, 40],
                    header: {
                        margin: 10,
                        table: {
                            widths: [20, '*', '*', 20],
                            body: [
                                [
                                    "",
                                    {image: img_system, width: 102, alignment: 'left'},
                                    {image: img_grsm, width: 70, alignment: 'right'},
                                    ""
                                ]
                            ]
                        },
                        layout: {
                            hLineColor: 'white',
                            vLineColor: 'white'
                        }
                    },
                    footer: {
                        margin: 10,
                        table: {
                            widths: ['*', 20],
                            body: [
                                [
                                    {text: 'Fecha y Hora : ' + tiempo, alignment: 'right', style: 'pie'},
                                    ""
                                ]
                            ]
                        },
                        layout: {
                            hLineColor: 'white',
                            vLineColor: 'white'
                        }
                    },
                    content: [
                        {
                            table: {
                                widths: ['*'],
                                body: [
                                    [
                                        {text: 'SEMÁFORO EJECUCIÓN DE INVERSIÓN PÚBLICA - ' + año_actual + '\n' + titulo_reporte.toUpperCase(), alignment: 'center', style: 'titulo'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            text: '\n'
                        },
                        {
                            table: {
                                widths: [30, 10, '*', 3, 10, '*', 3, 10, '*', 20],
                                body: [
                                    [
                                        "",
                                        {image: img_rojo, width: 11, alignment: 'right'},
                                        {text: leyenda1, style: 'subtitulo', alignment: 'left'},
                                        "",
                                        {image: img_naranja, width: 11, alignment: 'right'},
                                        {text: leyenda2, style: 'subtitulo', alignment: 'left'},
                                        "",
                                        {image: img_verde, width: 11, alignment: 'right'},
                                        {text: leyenda3, style: 'subtitulo', alignment: 'left'},
                                        ""
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            text: '\n'
                        },
                        {
                            table: {
                                widths: [27, 26, '*', 45, 43, 43, 43, 30, 43, 43, 43, 43, 25, 28],
                                body: muestra
                            },
                            layout: {
                                hLineColor: '#ECECEC',
                                vLineColor: '#ECECEC'
                            }
                        }
                    ],
                    styles: {
                        titulo: {
                            fontSize: 8,
                            bold: true
                        },
                        subtitulo: {
                            fontSize: 7,
                            bold: true
                        },
                        tablaHead: {
                            color: 'white',
                            fillColor: '#426993',
                            fontSize: 6,
                            bold: true
                        },
                        tablaBody: {
                            fontSize: 6
                        },
                        tablaBodyB: {
                            fontSize: 6,
                            bold: true
                        },
                        tablaTotal: {
                            fillColor: '#EBEBEB',
                            fontSize: 6,
                            bold: true
                        },
                        pie: {
                            fontSize: 6
                        }
                    }
                };
                pdfMake.createPdf(docDefinition).open();
            });

        }
    });

}