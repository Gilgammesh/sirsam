function proy_busqueda_avanzada_alert() {
    alert("funciona Búsqueda Avanzada de Proyectos");
}

function llenar_proy_busqueda_avanzada() {
    $("#divProyectos").empty();
    var busqueda = '<div id="divBusqAvanProy">\
                      <label class="lblFiltro">Filtro de Reporte</label>\
                      <div id="divBusqAvanProyFiltro" class="filtro_princ naranja_secun"></br>\
                       <form id="formBusqAvanProyecto" action="./Proyectos?tipo=busqueda_avanzada" method="post">\
                        <div class="form-group row">\
                          <label for="iptBusqAvanProyCodSiaf" class="col-sm-2 col-form-label">Código SIAF :</label>\
                          <div class="col-sm-2">\
                            <input id="iptBusqAvanProyCodSiaf" type="text" class="form-control" maxlength="7" name="codigo_siaf" \
                            onkeypress="return soloNumeroEnter(event)" placeholder="Ingrese código SIAF">\
                          </div>\
                          <label for="iptBusqAvanProyCodSnip" class="col-sm-2 col-form-label">Código SNIP :</label>\
                          <div class="col-sm-2">\
                            <input id="iptBusqAvanProyCodSnip" type="text" class="form-control" maxlength="8" name="codigo_snip" \
                            onkeypress="return soloNumeroEnter(event)" placeholder="Ingrese código SNIP">\
                          </div>\
                          <label for="listBusqAvanProySituac" class="col-sm-2 col-form-label">Situación :</label>\
                          <div class="col-sm-2">\
                             <select class="select-form" id="listBusqAvanProySituac" name="situacion">\
                                <option value="01" selected>En Ejecución</option>\
                                <option value="02">Culminados</option>\
                             </select>\
                          </div>\
                        </div>\
                        <div class="form-group row">\
                          <label for="iptBusqAvanProyNombre" class="form-check-label col-sm-2">Nombre Proyecto :</label>\
                          <div class="col-sm-10">\
                            <input id="iptBusqAvanProyNombre" type="text" class="form-control" name="nombre_proyecto" \
                            placeholder="Ingrese palabras claves del nombre del proyecto">\
                          </div>\
                        </div>\
                        <div class="form-group row">\
                          <label for="listBusqAvanProyEjec" class="col-sm-2 col-form-label">Unidad Ejecutora :</label>\
                          <div class="col-sm-6">\
                            <select class="select-form" id="listBusqAvanProyEjec" name="sec_ejec"></select>\
                          </div>\
                          <label for="listBusqAvanProyTipo" class="col-sm-2 col-form-label">Tipo Proyecto :</label>\
                          <div class="col-sm-2">\
                             <select class="select-form" id="listBusqAvanProyTipo" name="tipo_proyecto">\
                                <option value="00" selected>--TODOS--</option>\
                                <option value="01">INVIERTE.PE</option>\
                                <option value="02">SNIP</option>\
                             </select>\
                          </div>\
                        </div>\
                        <div class="form-group row">\
                          <label for="listBusqAvanProyFunc" class="col-sm-2 col-form-label">Función :</label>\
                          <div class="col-sm-6">\
                            <select class="select-form" id="listBusqAvanProyFunc" name="funcion"></select>\
                          </div>\
                          <label for="listBusqAvanProyEstado" class="col-sm-2 col-form-label">Estado :</label>\
                          <div class="col-sm-2">\
                             <select class="select-form" id="listBusqAvanProyEstado" name="estado">\
                                <option value="00" selected>--TODOS--</option>\
                                <option value="01">ACTIVO</option>\
                                <option value="02">DESACTIVADO</option>\
                             </select>\
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
                            <button id="btnLimpBusqAvanProy" type="reset" class="btn btn3d btn-white btn-m">\
                              <span class="glyphicon glyphicon-erase spanBtn"></span>Limpiar\
                            </button>\
                          </div>\
                        </div></br>\
                       </form>\
                      </div>\
                      <br>\
                      <div id="divBusqAvanProyCont" class="filtro_princ naranja_secun"></div>\
                    </div>';
    $("#divProyectos").append(busqueda);

    $('#btnLimpBusqAvanProy').click(function () {
        $('#divBusqAvanProyConte').empty();
    });

    llenarBusqAvanProyFiltro();
    eventFormBusqAvanProy();

}

function llenarBusqAvanProyFiltro() {
    $.ajax({
        dataType: 'json',
        url: "./Proyectos?tipo=ejecutoras&ano=todos",
        success: function (response) {
            $("#listBusqAvanProyEjec").append("<option value= '00'>Pliego 459 - Gobierno Regional San Martin</option>");
            $.each(response.listEjecutoras, function (index, value) {
                var nombre_ejec = (value.nombre_ejecutora).split("-");
                var ejec = "<option value=" + value.sec_ejec + ">UE " + value.ejecutora + " - " + nombre_ejec[1].trim() + " (" + value.sec_ejec + ")</option>";
                $("#listBusqAvanProyEjec").append(ejec);
            });
        }
    });
    $.ajax({
        dataType: 'json',
        url: "./Proyectos?tipo=funcion",
        success: function (response) {
            $("#listBusqAvanProyFunc").append("<option value= '00'>--TODAS--</option>");
            $.each(response.listFuncion, function (index, value) {
                var func = "<option value=" + value.funcion + ">" + value.nombre_funcion + "</option>";
                $("#listBusqAvanProyFunc").append(func);
            });
        }
    });
}

function eventFormBusqAvanProy() {
    $("#formBusqAvanProyecto").submit(function (evt) {
        evt.preventDefault();
        $("#divBusqAvanProyCont").empty();
        var gif = '<img src="./resources/gifs/cargando.gif" style="display:block; margin:auto;"></img>';
        $("#divBusqAvanProyCont").append(gif);
        $.ajax({
            dataType: 'json',
            type: 'post',
            url: $(this).attr("action"),
            data: $(this).serialize(),
            success: function (response) {
                $("#divBusqAvanProyCont").empty();
                llenarBusqAvanProyCont(response);
            }
        });
    });
}

function llenarBusqAvanProyCont(response) {
    table = '<div style="overflow-x:auto;">\
              <table id="tablaBusqAvanProyConte" class="display" cellspacing="0" width="100%">\
                <thead id="tablaBusqAvanProyContHead"></thead>\
                <tbody id="tablaBusqAvanProyContBody"></tbody>\
              </table>\
             </div>';
    $("#divBusqAvanProyCont").append(table);
    var muestra = [];
    var anchos = [];
    var año_actual = response.año_actual;
    var año_anterior = response.año_anterior;

    if (response.situacion === "01") {
        var arraySecEjec = response.arraySecEjec;
        var arrayEjecutora = response.arrayEjecutora;
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
                </tr>';
        $("#tablaBusqAvanProyContHead").append(head);
        var muestraHead = [];
        muestraHead.push({text: 'Código SIAF', style: 'tablaHead', alignment: 'center'});
        anchos.push(27);
        muestraHead.push({text: 'Código SNIP', style: 'tablaHead', alignment: 'center'});
        anchos.push(26);
        muestraHead.push({text: 'Nombre Proyecto', style: 'tablaHead', alignment: 'center'});
        anchos.push('*');
        muestraHead.push({text: 'Unidad Ejecutora', style: 'tablaHead', alignment: 'left'});
        anchos.push(45);
        muestraHead.push({text: 'PIM (' + año_actual + ') (P)', style: 'tablaHead', alignment: 'center'});
        anchos.push(43);
        muestraHead.push({text: 'Devengado (' + año_actual + ') (D)', style: 'tablaHead', alignment: 'center'});
        anchos.push(43);
        muestraHead.push({text: 'Devengado (Acumulado al ' + año_anterior + ') (DA)', style: 'tablaHead', alignment: 'center'});
        anchos.push(43);
        muestraHead.push({text: 'Avance Financiero %', style: 'tablaHead', alignment: 'center'});
        anchos.push(30);
        muestraHead.push({text: 'Monto Contratado (MC)', style: 'tablaHead', alignment: 'center'});
        anchos.push(43);
        muestraHead.push({text: 'Monto Inversión (MI)', style: 'tablaHead', alignment: 'center'});
        anchos.push(43);
        muestraHead.push({text: 'Déficit de Proyecto (MI-DA-P)', style: 'tablaHead', alignment: 'center'});
        anchos.push(43);
        muestraHead.push({text: 'Monto Ejecutado', style: 'tablaHead', alignment: 'center'});
        anchos.push(43);
        muestraHead.push({text: 'Avance Físico %', style: 'tablaHead', alignment: 'center'});
        anchos.push(25);
        muestra.push(muestraHead);
        $.each(response.listBusqueda, function (index, value) {
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
            var contra, ejecutado, avanFis, inver, deficit;
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
            body = '<tr>\
                      <td class="center">\
                        <a id="atdBusqAvanProyCodSiaf' + siaf + '" class="td_proyecto">' + siaf + '</a>\
                      </td>\
                      <td class="center">\
                        <a id="atdBusqAvanProyCodSnip' + siaf + '" class="td_proyecto">' + snip + '</a>\
                      </td>\
                      <td class="left">' + nombre + '</td>\
                      <td class="left">' + ejecutora + '</td>\
                      <td class="right">' + formatNumeroDecimal(pim) + '</td>\
                      <td class="right">' + formatNumeroDecimal(deven) + '</td>\
                      <td class="right">' + formatNumeroDecimal(devenA) + '</td>\
                      <td class="center"><b>' + formatNumeroDecimal(avanFin) + '</b></td>\
                      <td class="right">' + formatNumeroDecimal(contra) + '</td>\
                      <td class="right">' + formatNumeroDecimal(inver) + '</td>\
                      <td class="right">' + formatNumeroDecimal(deficit) + '</td>\
                      <td class="center"><b>' + formatNumeroDecimal(avanFis) + '<b></td>\
                    </tr>';
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
            if (response.ejec === "00") {
                $("#tablaBusqAvanProyContBody").append(body);
                muestra.push(muestraBody);
            } else {
                if (response.ejec === arraySecEjec[index]) {
                    $("#tablaBusqAvanProyContBody").append(body);
                    muestra.push(muestraBody);
                }
            }

            $("#atdBusqAvanProyCodSiaf" + siaf).click(function () {
                llenar_proy_ficha_reporte($("#listProyReporte").val(), siaf);
            });

            $("#atdBusqAvanProyCodSnip" + siaf).click(function () {
                llenar_proy_ficha_reporte($("#listProyReporte").val(), siaf);
            });

        });

        $('#tablaBusqAvanProyConte').dataTable({
            ordering: true,
            dom: '<"centrar-div-tabla"lfB>iprtip',
            buttons: [
                {
                    extend: 'excel',
                    footer: true,
                    filename: 'ejecucion_inversion_publica_' + (response.ejec === "00" ? "pliego459" : response.ejec) + '_' + año_actual,
                    title: 'EJECUCIÓN DE INVERSIÓN PÚBLICA - ' + año_actual,
                    exportOptions: {
                        orthogonal: 'sort',
                        columns: ':visible'
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
                        for (var k = 8; k < 12; k++) {
                            var total = $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).length;
                            $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).each(function (i) {
                                if (i > 0 && i < total) {
                                    $(this).attr('s', '72');
                                }
                            });
                        }
                        for (var k = 12; k < 13; k++) {
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
    }

    if (response.situacion === "02") {
        var arraySecEjec = response.arraySecEjec;
        var arrayEjecutora = response.arrayEjecutora;
        head = '<tr>\
                  <th class="center">Código SIAF</th>\
                  <th class="center">Código SNIP</th>\
                  <th class="center">Nombre Proyecto</th>\
                  <th class="center">Unidad Ejecutora</th>\
                  <th class="center">Devengado Acumulado (DA)</th>\
                  <th class="center">Monto Contratado (MC)</th>\
                  <th class="center">Monto Inversión (MI)</th>\
                  <th class="center">Déficit de Proyecto (MI-DA)</th>\
                  <th class="center">Monto Ejecutado</th>\
                  <th class="center">Avance Físico %</th>\
                </tr>';
        $("#tablaBusqAvanProyContHead").append(head);
        var muestraHead = [];
        muestraHead.push({text: 'Código SIAF', style: 'tablaHead', alignment: 'center'});
        anchos.push(27);
        muestraHead.push({text: 'Código SNIP', style: 'tablaHead', alignment: 'center'});
        anchos.push(26);
        muestraHead.push({text: 'Nombre Proyecto', style: 'tablaHead', alignment: 'center'});
        anchos.push('*');
        muestraHead.push({text: 'Unidad Ejecutora', style: 'tablaHead', alignment: 'center'});
        anchos.push(45);
        muestraHead.push({text: 'Devengado Acumulado (DA)', style: 'tablaHead', alignment: 'center'});
        anchos.push(43);
        muestraHead.push({text: 'Monto Contratado (MC)', style: 'tablaHead', alignment: 'center'});
        anchos.push(43);
        muestraHead.push({text: 'Monto Inversión (MI)', style: 'tablaHead', alignment: 'center'});
        anchos.push(43);
        muestraHead.push({text: 'Déficit de Proyecto (MI-DA)', style: 'tablaHead', alignment: 'center'});
        anchos.push(43);
        muestraHead.push({text: 'Monto Ejecutado', style: 'tablaHead', alignment: 'center'});
        anchos.push(43);
        muestraHead.push({text: 'Avance Físico %', style: 'tablaHead', alignment: 'center'});
        anchos.push(25);
        muestra.push(muestraHead);
        $.each(response.listBusqueda, function (index, value) {
            var muestraBody = [];
            var siaf = value.proyCodigoSiaf;
            var snip;
            if (!$.trim(value.proyCodigoInversion)) {
                snip = "";
            } else {
                snip = value.proyCodigoInversion;
            }
            var nombre = value.proyNombre;
            var ejecutora = "UE " + arrayEjecutora[index] + " (" + arraySecEjec[index] + ")";
            var devenA;
            if (!$.trim(value.devengado_acumulado)) {
                devenA = 0.00;
            } else {
                devenA = value.devengado_acumulado;
            }
            var contra, ejecutado, avanFis, inver, deficit;
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
            deficit = inver - devenA;
            body = '<tr>\
                      <td class="center">\
                        <a id="atdBusqAvanProyCodSiaf' + siaf + '" class="td_proyecto">' + siaf + '</a>\
                      </td>\
                      <td class="center">\
                        <a id="atdBusqAvanProyCodSnip' + siaf + '" class="td_proyecto">' + snip + '</a>\
                      </td>\
                      <td class="left">' + nombre + '</td>\
                      <td class="left">' + ejecutora + '</td>\
                      <td class="right">' + formatNumeroDecimal(devenA) + '</td>\
                      <td class="right">' + formatNumeroDecimal(contra) + '</td>\
                      <td class="right">' + formatNumeroDecimal(inver) + '</td>\
                      <td class="right">' + formatNumeroDecimal(deficit) + '</td>\
                      <td class="right">' + formatNumeroDecimal(ejecutado) + '</td>\
                      <td class="center"><b>' + formatNumeroDecimal(avanFis) + '<b></td>\
                    </tr>';
            muestraBody.push({text: siaf, style: 'tablaBody', alignment: 'center'});
            muestraBody.push({text: snip, style: 'tablaBody', alignment: 'center'});
            muestraBody.push({text: nombre, style: 'tablaBody', alignment: 'left'});
            muestraBody.push({text: ejecutora, style: 'tablaBody', alignment: 'center'});
            muestraBody.push({text: formatNumeroDecimal(devenA), style: 'tablaBody', alignment: 'right'});
            muestraBody.push({text: formatNumeroDecimal(contra), style: 'tablaBody', alignment: 'right'});
            muestraBody.push({text: formatNumeroDecimal(inver), style: 'tablaBody', alignment: 'right'});
            muestraBody.push({text: formatNumeroDecimal(deficit), style: 'tablaBody', alignment: 'right'});
            muestraBody.push({text: formatNumeroDecimal(ejecutado), style: 'tablaBody', alignment: 'right'});
            muestraBody.push({text: formatNumeroDecimal(avanFis), style: 'tablaBodyB', alignment: 'center'});
            if (response.ejec === "00") {
                $("#tablaBusqAvanProyContBody").append(body);
                muestra.push(muestraBody);
            } else {
                if (response.ejec === arraySecEjec[index]) {
                    $("#tablaBusqAvanProyContBody").append(body);
                    muestra.push(muestraBody);
                }
            }

            $("#atdBusqAvanProyCodSiaf" + siaf).click(function () {
                llenar_proy_ficha_reporte($("#listProyReporte").val(), siaf);
            });

            $("#atdBusqAvanProyCodSnip" + siaf).click(function () {
                llenar_proy_ficha_reporte($("#listProyReporte").val(), siaf);
            });

        });

        $('#tablaBusqAvanProyConte').dataTable({
            ordering: true,
            dom: '<"centrar-div-tabla"lfB>iprtip',
            buttons: [
                {
                    extend: 'excel',
                    footer: true,
                    filename: 'ejecucion_inversion_publica_' + (response.ejec === "00" ? "pliego459" : response.ejec) + '_' + año_actual,
                    title: 'EJECUCIÓN DE INVERSIÓN PÚBLICA',
                    exportOptions: {
                        orthogonal: 'sort',
                        columns: ':visible'
                    },
                    customize: function (xlsx) {
                        var sheet = xlsx.xl.worksheets['sheet1.xml'];
                        for (var k = 4; k < 9; k++) {
                            var total = $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).length;
                            $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).each(function (i) {
                                if (i > 0 && i < total) {
                                    $(this).attr('s', '72');
                                }
                            });
                        }
                        for (var k = 9; k < 10; k++) {
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
    }

    var btnPDF = '<button id="btnProyBusqAvanPdf" class="dt-button buttons-html5">\
                            <span>\
                                <img src="./templates/plugins/datatables/images/pdf.png" data-toggle="tooltip" data-placement="bottom" title="Exportar a PDF">\
                            </span>\
                          </button>';
    $("#tablaBusqAvanProyConte_wrapper .dt-buttons").append(btnPDF);
    $("#tablaBusqAvanProyConte_wrapper .dt-buttons").css("margin-bottom", "10px");

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

    $("#btnProyBusqAvanPdf").on('click', function () {

        var docDefinition = {
            pageOrientation: 'landscape',
            info: {
                title: 'ejecucion_inversion_publica_' + (response.ejec === "00" ? "pliego459" : response.ejec) + '_' + año_actual
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
                                {text: 'EJECUCIÓN DE INVERSIÓN PÚBLICA', alignment: 'center', style: 'titulo'}
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
                        widths: anchos,
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