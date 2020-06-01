// Reporte de Resumen de Ejecución Presupuestal Ejecutiva

function ResumenEjecucion() {
    alert("funciona Resumen de Ejecución");
}

function llenarResumenEjecucionFiltro() {
    $("#divPresuReporteResumen").empty();
    filtro = '<div class="filtro_report naranja_secun">\
                <div class="form-group row">\
                    <label for="listPresuEjecutoraResum" class="col-sm-2 col-form-label">Elija Ejecutora :</label>\
                    <div id="divBlockSelectEjec" class="col-sm-6">\
                        <select class="select-form" id="listPresuEjecutoraResum"></select>\
                    </div>\
                    <label class="col-sm-1"></label>\
                    <label for="listPresuAñoResum" class="col-sm-1 col-form-label">Elija Año :</label>\
                    <div class="col-sm-2">\
                        <select class="select-form" id="listPresuAñoResum"></select>\
                    </div>\
                </div>\
             </div>';
    filtro += '<br>';
    reporte = '<div id="divPresuReporteResumenContenido" class="filtro_report naranja_secun"></div>';
    HTML = filtro + reporte;
    $("#divPresuReporteResumen").append(HTML);
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataEjecutoras",
        success: function (response) {
            $.each(response.listEjecutoras, function (index, value) {
                var nombre_ejec = (value.nombre).split("-");
                objeE = "<option value=" + value.sec_ejec + ">UE " + value.ejecutora + " - " + nombre_ejec[1].trim() + " (" + value.sec_ejec + ")</option>";
                $("#listPresuEjecutoraResum").append(objeE);
            });
            $('#listPresuEjecutoraResum').prop('selectedIndex', 0);
            $.ajax({
                dataType: 'json',
                url: "./GsonData?url=DataPresuAñosResumen",
                success: function (response) {
                    $.each(response.listAños, function (index, value) {
                        objeA = "<option value=" + value.ano_eje + ">" + value.ano_eje + "</option>";
                        $("#listPresuAñoResum").append(objeA);
                    });
                    $('#listPresuAñoResum').prop('selectedIndex', 0);
                    llenarResumenEjecucionReporte($('#listPresuAñoResum').val(), $('#listPresuEjecutoraResum').val());
                }
            });
        }
    });
}

function llenarResumenEjecucionReporte(año, ejec) {
    $("#listPresuEjecutoraResum option").prop('disabled', true);
    $("#listPresuEjecutoraResum").addClass("cargando");
    $("#divPresuReporteResumenContenido").empty();
    boton = '<div id="divBtnReporteResumenPdf" class="oculto">\
                <a>\
                   <img src="./templates/plugins/datatables/images/pdf.png" data-toggle="tooltip" data-placement="bottom" title="Exportar a PDF">\
                </a>\
             </div>';
    titulo = '<div>\
                <label class="titulo">RESUMEN DE EJECUCIÓN PRESUPUESTAL - ' + año + '</label>\
                <label id="lblEjecutoraResum" class="titulo"></label>\
              </div>';
    titulo += '<br><br>';
    graficos = '<div class="imagen_centrada col-lg-4 tercia">\
                    <label>Avance de Ejecución Presupuestal (S/)</label>\
                    <p></p>\
                    <img src="./Presupuesto?tipo=10&model=grafica1&pdf=no&año=' + año + '&ejec=' + ejec + '&ancho=333&alto=300&font=10&bar=0.30&pos=in" class="cargando_gif">\
                </div>';
    graficos += '<div class="imagen_centrada col-lg-4 tercia">\
                    <label>Avance de Ejecución Presupuestal por Proyectos</label>\
                    <p></p>\
                    <img src="./Presupuesto?tipo=10&model=grafica2&pdf=no&año=' + año + '&ejec=' + ejec + '&ancho=333&alto=300&font=10&bar=0.30&pos=in" class="cargando_gif">\
                </div>';
    graficos += '<div class="imagen_centrada col-lg-4 tercia">\
                    <label>Avance de Ejecución Presupuestal por Productos</label>\
                    <p></p>\
                    <img src="./Presupuesto?tipo=10&model=grafica3&pdf=no&año=' + año + '&ejec=' + ejec + '&ancho=333&alto=300&font=10&bar=0.30&pos=in" class="cargando_gif">\
                </div>';
    graficos += '<div class="imagen_centrada col-lg-12 unico">\
                    <label>Avance de Ejecución Presupuestal - Mensualizada</label>\
                    <p></p>\
                    <img src="./Presupuesto?tipo=10&model=grafica4&pdf=no&año=' + año + '&ejec=' + ejec + '&ancho=1100&alto=500&font=10&bar=0.20&pos=out" class="cargando_gif">\
                </div>';
    graficos += '<div class="imagen_centrada col-lg-12 unico">\
                    <label>Avance de Ejecución Presupuestal por Proyectos - Mensualizada</label>\
                    <p></p>\
                    <img src="./Presupuesto?tipo=10&model=grafica5&pdf=no&año=' + año + '&ejec=' + ejec + '&ancho=1100&alto=500&font=10&bar=0.20&pos=out" class="cargando_gif">\
                </div>';
    graficos += '<div class="imagen_centrada col-lg-12 unico">\
                    <label>Avance de Ejecución Presupuestal por Productos - Mensualizada</label>\
                    <p></p>\
                    <img src="./Presupuesto?tipo=10&model=grafica6&pdf=no&año=' + año + '&ejec=' + ejec + '&ancho=1100&alto=500&font=10&bar=0.20&pos=out" class="cargando_gif">\
                </div>';
    graficos += '<br>';
    tablas = '<div>\
                <label>Ejecución Presupuestal por Proyecto/Producto</label>\
                <p></p>\
                <div style="overflow-x:auto;">\
                    <table id="tablaResumActProy" class="display" cellspacing="0" width="100%"></table>\
                </div>\
              </div>';
    tablas += '<br>';
    tablas += '<div>\
                <label>Ejecución Presupuestal por Genérica de Gasto</label>\
                <p></p>\
                <div style="overflow-x:auto;">\
                    <table id="tablaResumGeneric" class="display" cellspacing="0" width="100%"></table>\
                </div>\
              </div>';
    tablas += '<br>';
    tablas += '<div>\
                <label>Ejecución Presupuestal por Fuente de Financiamiento</label>\
                <p></p>\
                <div style="overflow-x:auto;">\
                    <table id="tablaResumFuente" class="display" cellspacing="0" width="100%"></table>\
                </div>\
              </div>';
    tablas += '<br>';
    tablas += '<div>\
                <label>Ejecución Presupuestal por Categoría de Gasto</label>\
                <p></p>\
                <div style="overflow-x:auto;">\
                    <table id="tablaResumCateg" class="display" cellspacing="0" width="100%"></table>\
                </div>\
              </div>';
    tablas += '<br>';
    HTML = boton + titulo + graficos + tablas;
    $("#divPresuReporteResumenContenido").append(HTML);
    var titulo_reporte;
    if (ejec === "00") {
        titulo_reporte = "PLIEGO 459 - GOBIERNO REGIONAL DE SAN MARTIN";
        $("#lblEjecutoraResum").append(titulo_reporte);
    } else {
        $.ajax({
            dataType: 'json',
            url: "./GsonData?url=DataEjecutora&año=" + año + "&ejec=" + ejec,
            success: function (response) {
                var nombre_ejec = (response.nombre).split("-");
                titulo_reporte = "EJECUTORA " + response.ejecutora + " - " + nombre_ejec[1].trim() + " (" + ejec + ")";
                $("#lblEjecutoraResum").append(titulo_reporte);
            }
        });
    }
    var muestra1 = [];
    var muestra2 = [];
    var muestra3 = [];
    var muestra4 = [];
    $('#tablaResumActProy').append('<img src="./resources/gifs/cargando.gif" style="display:block; margin:auto;"></img>');
    $.ajax({
        dataType: 'json',
        url: "./Presupuesto?tipo=10&model=tablas&año=" + año + "&ejec=" + ejec,
        success: function (response) {
            $('#tablaResumActProy').empty();
            cuerpo1 = '<thead id="tablaResumActProyHead"></thead>\
                       <tbody id="tablaResumActProyBody"></tbody>\
                       <tfoot id="tablaResumActProyFoot"></tfoot>';
            $("#tablaResumActProy").append(cuerpo1);
            head1 = '<tr>\
                        <th class="center">Proyecto/Producto</th>\
                        <th class="center">PIA</th>\
                        <th class="center">PIM</th>\
                        <th class="center">Certificado</th>\
                        <th class="center">Compromiso Anual</th>\
                        <th class="center">Saldo por Comprometer</th>\
                        <th class="center">Devengado</th>\
                        <th class="center">Avance %</th>\
                     </tr>';
            $("#tablaResumActProyHead").append(head1);
            muestra1.push([
                {text: 'Proyecto/Producto', style: 'tablaHead', alignment: 'center'},
                {text: 'PIA', style: 'tablaHead', alignment: 'center'},
                {text: 'PIM', style: 'tablaHead', alignment: 'center'},
                {text: 'Certificado', style: 'tablaHead', alignment: 'center'},
                {text: 'Compromiso Anual', style: 'tablaHead', alignment: 'center'},
                {text: 'Saldo por Comprometer', style: 'tablaHead', alignment: 'center'},
                {text: 'Devengado', style: 'tablaHead', alignment: 'center'},
                {text: 'Avance %', style: 'tablaHead', alignment: 'center'}
            ]);
            var pia1T, pim1T, cert1T, comp1T, deven1T;
            pia1T = pim1T = cert1T = comp1T = deven1T = 0.00;
            $.each(response.listPorActProy, function (idx1, value1) {
                var cert1, comp1, deve1, saldo1, avance1, act_proy;
                if (value1.tipo_act_proy === "2") {
                    act_proy = "Proyectos";
                }
                if (value1.tipo_act_proy === "3") {
                    act_proy = "Productos";
                }
                if (!$.trim(value1.certificado)) {
                    cert1 = formatNumero(0.00);
                } else {
                    cert1 = formatNumero(value1.certificado);
                    cert1T += value1.certificado;
                }
                if (!$.trim(value1.compromiso_anual)) {
                    comp1 = formatNumero(0.00);
                    saldo1 = formatNumero(value1.pim);
                } else {
                    comp1 = formatNumero(value1.compromiso_anual);
                    comp1T += value1.compromiso_anual;
                    saldo1 = formatNumero(value1.pim - value1.compromiso_anual);
                }
                if (!$.trim(value1.devengado)) {
                    deve1 = formatNumero(0.00);
                    avance1 = formatNumero(0.00);
                } else {
                    deve1 = formatNumero(value1.devengado);
                    deven1T += value1.devengado;
                    if (value1.pim === 0.00) {
                        avance1 = formatNumero(0.00);
                    } else {
                        avance1 = formatNumero((value1.devengado / value1.pim) * 100);
                    }
                }
                body1 = '<tr>\
                            <td class="left">' + value1.tipo_act_proy + ' - ' + act_proy + '</td>\
                            <td class="right">' + formatNumero(value1.pia) + '</td>\
                            <td class="right">' + formatNumero(value1.pim) + '</td>\
                            <td class="right">' + cert1 + '</td>\
                            <td class="right">' + comp1 + '</td>\
                            <td class="right">' + saldo1 + '</td>\
                            <td class="right">' + deve1 + '</td>\
                            <td class="right">' + avance1 + '</td>\
                         </tr>';
                $("#tablaResumActProyBody").append(body1);
                pia1T += value1.pia;
                pim1T += value1.pim;
                muestra1.push([
                    {text: value1.tipo_act_proy + ' - ' + act_proy, style: 'tablaBody', alignment: 'left'},
                    {text: formatNumero(value1.pia), style: 'tablaBody', alignment: 'right'},
                    {text: formatNumero(value1.pim), style: 'tablaBody', alignment: 'right'},
                    {text: cert1, style: 'tablaBody', alignment: 'right'},
                    {text: comp1, style: 'tablaBody', alignment: 'right'},
                    {text: saldo1, style: 'tablaBody', alignment: 'right'},
                    {text: deve1, style: 'tablaBody', alignment: 'right'},
                    {text: avance1, style: 'tablaBody', alignment: 'right'}
                ]);
            });
            foot1T = '<tr class="total">\
                        <td class="right"><b>TOTAL</b></td>\
                        <td class="right"><b>' + formatNumero(pia1T) + '</b></td>\
                        <td class="right"><b>' + formatNumero(pim1T) + '</b></td>\
                        <td class="right"><b>' + formatNumero(cert1T) + '</b></td>\
                        <td class="right"><b>' + formatNumero(comp1T) + '</b></td>\
                        <td class="right"><b>' + formatNumero(pim1T - comp1T) + '</b></td>\
                        <td class="right"><b>' + formatNumero(deven1T) + '</b></td>\
                        <td class="right"><b>' + formatNumero((deven1T / pim1T) * 100) + '</b></td>\
                      </tr>';
            $("#tablaResumActProyFoot").append(foot1T);
            muestra1.push([
                {text: 'TOTAL', style: 'tablaTotal', alignment: 'right'},
                {text: formatNumero(pia1T), style: 'tablaTotal', alignment: 'right'},
                {text: formatNumero(pim1T), style: 'tablaTotal', alignment: 'right'},
                {text: formatNumero(cert1T), style: 'tablaTotal', alignment: 'right'},
                {text: formatNumero(comp1T), style: 'tablaTotal', alignment: 'right'},
                {text: formatNumero(pim1T - comp1T), style: 'tablaTotal', alignment: 'right'},
                {text: formatNumero(deven1T), style: 'tablaTotal', alignment: 'right'},
                {text: formatNumero((deven1T / pim1T) * 100), style: 'tablaTotal', alignment: 'right'}
            ]);
            $('#tablaResumActProy').dataTable().fnDestroy();
            $('#tablaResumActProy').dataTable({
                paging: false,
                ordering: true,
                bPaginate: false,
                dom: 'rt'
            });
        }
    });
    $('#tablaResumGeneric').append('<img src="./resources/gifs/cargando.gif" style="display:block; margin:auto;"></img>');
    $.ajax({
        dataType: 'json',
        url: "./Presupuesto?tipo=10&model=tablas&año=" + año + "&ejec=" + ejec,
        success: function (response) {
            $('#tablaResumGeneric').empty();
            cuerpo2 = '<thead id="tablaResumGenericHead"></thead>\
                       <tbody id="tablaResumGenericBody"></tbody>\
                       <tfoot id="tablaResumGenericFoot"></tfoot>';
            $("#tablaResumGeneric").append(cuerpo2);
            head2 = '<tr>\
                        <th class="center">Genérica de Gasto</th>\
                        <th class="center">PIA</th>\
                        <th class="center">PIM</th>\
                        <th class="center">Certificado</th>\
                        <th class="center">Compromiso Anual</th>\
                        <th class="center">Saldo por Comprometer</th>\
                        <th class="center">Devengado</th>\
                        <th class="center">Avance %</th>\
                     </tr>';
            $("#tablaResumGenericHead").append(head2);
            muestra2.push([
                {text: 'Genérica de Gasto', style: 'tablaHead', alignment: 'center'},
                {text: 'PIA', style: 'tablaHead', alignment: 'center'},
                {text: 'PIM', style: 'tablaHead', alignment: 'center'},
                {text: 'Certificado', style: 'tablaHead', alignment: 'center'},
                {text: 'Compromiso Anual', style: 'tablaHead', alignment: 'center'},
                {text: 'Saldo por Comprometer', style: 'tablaHead', alignment: 'center'},
                {text: 'Devengado', style: 'tablaHead', alignment: 'center'},
                {text: 'Avance %', style: 'tablaHead', alignment: 'center'}
            ]);
            var pia2T, pim2T, cert2T, comp2T, deven2T;
            pia2T = pim2T = cert2T = comp2T = deven2T = 0.00;
            $.each(response.listPorGeneric, function (idx2, value2) {
                var cert2, comp2, deve2, saldo2, avance2;
                if (!$.trim(value2.certificado)) {
                    cert2 = formatNumero(0.00);
                } else {
                    cert2 = formatNumero(value2.certificado);
                    cert2T += value2.certificado;
                }
                if (!$.trim(value2.compromiso_anual)) {
                    comp2 = formatNumero(0.00);
                    saldo2 = formatNumero(value2.pim);
                } else {
                    comp2 = formatNumero(value2.compromiso_anual);
                    comp2T += value2.compromiso_anual;
                    saldo2 = formatNumero(value2.pim - value2.compromiso_anual);
                }
                if (!$.trim(value2.devengado)) {
                    deve2 = formatNumero(0.00);
                    avance2 = formatNumero(0.00);
                } else {
                    deve2 = formatNumero(value2.devengado);
                    deven2T += value2.devengado;
                    if (value2.pim === 0.00) {
                        avance2 = formatNumero(0.00);
                    } else {
                        avance2 = formatNumero((value2.devengado / value2.pim) * 100);
                    }
                }
                body2 = '<tr>\
                            <td class="left">' + value2.clasificador + ' - ' + value2.descripcion + '</td>\
                            <td class="right">' + formatNumero(value2.pia) + '</td>\
                            <td class="right">' + formatNumero(value2.pim) + '</td>\
                            <td class="right">' + cert2 + '</td>\
                            <td class="right">' + comp2 + '</td>\
                            <td class="right">' + saldo2 + '</td>\
                            <td class="right">' + deve2 + '</td>\
                            <td class="right">' + avance2 + '</td>\
                         </tr>';
                $("#tablaResumGenericBody").append(body2);
                pia2T += value2.pia;
                pim2T += value2.pim;
                muestra2.push([
                    {text: value2.clasificador + ' - ' + value2.descripcion, style: 'tablaBody', alignment: 'left'},
                    {text: formatNumero(value2.pia), style: 'tablaBody', alignment: 'right'},
                    {text: formatNumero(value2.pim), style: 'tablaBody', alignment: 'right'},
                    {text: cert2, style: 'tablaBody', alignment: 'right'},
                    {text: comp2, style: 'tablaBody', alignment: 'right'},
                    {text: saldo2, style: 'tablaBody', alignment: 'right'},
                    {text: deve2, style: 'tablaBody', alignment: 'right'},
                    {text: avance2, style: 'tablaBody', alignment: 'right'}
                ]);
            });
            foot2T = '<tr class="total">\
                        <td class="right"><b>TOTAL</b></td>\
                        <td class="right"><b>' + formatNumero(pia2T) + '</b></td>\
                        <td class="right"><b>' + formatNumero(pim2T) + '</b></td>\
                        <td class="right"><b>' + formatNumero(cert2T) + '</b></td>\
                        <td class="right"><b>' + formatNumero(comp2T) + '</b></td>\
                        <td class="right"><b>' + formatNumero(pim2T - comp2T) + '</b></td>\
                        <td class="right"><b>' + formatNumero(deven2T) + '</b></td>\
                        <td class="right"><b>' + formatNumero((deven2T / pim2T) * 100) + '</b></td>\
                      </tr>';
            $("#tablaResumGenericFoot").append(foot2T);
            muestra2.push([
                {text: 'TOTAL', style: 'tablaTotal', alignment: 'right'},
                {text: formatNumero(pia2T), style: 'tablaTotal', alignment: 'right'},
                {text: formatNumero(pim2T), style: 'tablaTotal', alignment: 'right'},
                {text: formatNumero(cert2T), style: 'tablaTotal', alignment: 'right'},
                {text: formatNumero(comp2T), style: 'tablaTotal', alignment: 'right'},
                {text: formatNumero(pim2T - comp2T), style: 'tablaTotal', alignment: 'right'},
                {text: formatNumero(deven2T), style: 'tablaTotal', alignment: 'right'},
                {text: formatNumero((deven2T / pim2T) * 100), style: 'tablaTotal', alignment: 'right'}
            ]);
            $('#tablaResumGeneric').dataTable().fnDestroy();
            $('#tablaResumGeneric').dataTable({
                paging: false,
                ordering: true,
                bPaginate: false,
                dom: 'rt'
            });
        }
    });
    $('#tablaResumFuente').append('<img src="./resources/gifs/cargando.gif" style="display:block; margin:auto;"></img>');
    $.ajax({
        dataType: 'json',
        url: "./Presupuesto?tipo=10&model=tablas&año=" + año + "&ejec=" + ejec,
        success: function (response) {
            $("#tablaResumFuente").empty();
            cuerpo3 = '<thead id="tablaResumFuenteHead"></thead>\
                       <tbody id="tablaResumFuenteBody"></tbody>\
                       <tfoot id="tablaResumFuenteFoot"></tfoot>';
            $("#tablaResumFuente").append(cuerpo3);
            head3 = '<tr>\
                        <th class="center">Fuente de Financiamiento</th>\
                        <th class="center">PIA</th>\
                        <th class="center">PIM</th>\
                        <th class="center">Certificado</th>\
                        <th class="center">Compromiso Anual</th>\
                        <th class="center">Saldo por Comprometer</th>\
                        <th class="center">Devengado</th>\
                        <th class="center">Avance %</th>\
                     </tr>';
            $("#tablaResumFuenteHead").append(head3);
            muestra3.push([
                {text: 'Fuente de Financiamiento', style: 'tablaHead', alignment: 'center'},
                {text: 'PIA', style: 'tablaHead', alignment: 'center'},
                {text: 'PIM', style: 'tablaHead', alignment: 'center'},
                {text: 'Certificado', style: 'tablaHead', alignment: 'center'},
                {text: 'Compromiso Anual', style: 'tablaHead', alignment: 'center'},
                {text: 'Saldo por Comprometer', style: 'tablaHead', alignment: 'center'},
                {text: 'Devengado', style: 'tablaHead', alignment: 'center'},
                {text: 'Avance %', style: 'tablaHead', alignment: 'center'}
            ]);
            var pia3T, pim3T, cert3T, comp3T, deven3T;
            pia3T = pim3T = cert3T = comp3T = deven3T = 0.00;
            $.each(response.listPorFuente, function (idx3, value3) {
                var cert3, comp3, deve3, saldo3, avance3;
                if (!$.trim(value3.certificado)) {
                    cert3 = formatNumero(0.00);
                } else {
                    cert3 = formatNumero(value3.certificado);
                    cert3T += value3.certificado;
                }
                if (!$.trim(value3.compromiso_anual)) {
                    comp3 = formatNumero(0.00);
                    saldo3 = formatNumero(value3.pim);
                } else {
                    comp3 = formatNumero(value3.compromiso_anual);
                    comp3T += value3.compromiso_anual;
                    saldo3 = formatNumero(value3.pim - value3.compromiso_anual);
                }
                if (!$.trim(value3.devengado)) {
                    deve3 = formatNumero(0.00);
                    avance3 = formatNumero(0.00);
                } else {
                    deve3 = formatNumero(value3.devengado);
                    deven3T += value3.devengado;
                    if (value3.pim === 0.00) {
                        avance3 = formatNumero(0.00);
                    } else {
                        avance3 = formatNumero((value3.devengado / value3.pim) * 100);
                    }
                }
                body3 = '<tr>\
                            <td class="left">' + value3.fuente_financ_agregada + ' - ' + value3.nombre + '</td>\
                            <td class="right">' + formatNumero(value3.pia) + '</td>\
                            <td class="right">' + formatNumero(value3.pim) + '</td>\
                            <td class="right">' + cert3 + '</td>\
                            <td class="right">' + comp3 + '</td>\
                            <td class="right">' + saldo3 + '</td>\
                            <td class="right">' + deve3 + '</td>\
                            <td class="right">' + avance3 + '</td>\
                         </tr>';
                $("#tablaResumFuenteBody").append(body3);
                pia3T += value3.pia;
                pim3T += value3.pim;
                muestra3.push([
                    {text: value3.fuente_financ_agregada + ' - ' + value3.nombre, style: 'tablaBody', alignment: 'left'},
                    {text: formatNumero(value3.pia), style: 'tablaBody', alignment: 'right'},
                    {text: formatNumero(value3.pim), style: 'tablaBody', alignment: 'right'},
                    {text: cert3, style: 'tablaBody', alignment: 'right'},
                    {text: comp3, style: 'tablaBody', alignment: 'right'},
                    {text: saldo3, style: 'tablaBody', alignment: 'right'},
                    {text: deve3, style: 'tablaBody', alignment: 'right'},
                    {text: avance3, style: 'tablaBody', alignment: 'right'}
                ]);
            });
            foot3T = '<tr class="total">\
                        <td class="right"><b>TOTAL</b></td>\
                        <td class="right"><b>' + formatNumero(pia3T) + '</b></td>\
                        <td class="right"><b>' + formatNumero(pim3T) + '</b></td>\
                        <td class="right"><b>' + formatNumero(cert3T) + '</b></td>\
                        <td class="right"><b>' + formatNumero(comp3T) + '</b></td>\
                        <td class="right"><b>' + formatNumero(pim3T - comp3T) + '</b></td>\
                        <td class="right"><b>' + formatNumero(deven3T) + '</b></td>\
                        <td class="right"><b>' + formatNumero((deven3T / pim3T) * 100) + '</b></td>\
                       </tr>';
            $("#tablaResumFuenteFoot").append(foot3T);
            muestra3.push([
                {text: 'TOTAL', style: 'tablaTotal', alignment: 'right'},
                {text: formatNumero(pia3T), style: 'tablaTotal', alignment: 'right'},
                {text: formatNumero(pim3T), style: 'tablaTotal', alignment: 'right'},
                {text: formatNumero(cert3T), style: 'tablaTotal', alignment: 'right'},
                {text: formatNumero(comp3T), style: 'tablaTotal', alignment: 'right'},
                {text: formatNumero(pim3T - comp3T), style: 'tablaTotal', alignment: 'right'},
                {text: formatNumero(deven3T), style: 'tablaTotal', alignment: 'right'},
                {text: formatNumero((deven3T / pim3T) * 100), style: 'tablaTotal', alignment: 'right'}
            ]);
            $('#tablaResumFuente').dataTable().fnDestroy();
            $('#tablaResumFuente').dataTable({
                paging: false,
                ordering: true,
                bPaginate: false,
                dom: 'rt'
            });
        }
    });
    $('#tablaResumCateg').append('<img src="./resources/gifs/cargando.gif" style="display:block; margin:auto;"></img>');
    $.ajax({
        dataType: 'json',
        url: "./Presupuesto?tipo=10&model=tablas&año=" + año + "&ejec=" + ejec,
        success: function (response) {
            $('#tablaResumCateg').empty();
            cuerpo4 = '<thead id="tablaResumCategHead"></thead>\
                       <tbody id="tablaResumCategBody"></tbody>\
                       <tfoot id="tablaResumCategFoot"></tfoot>';
            $("#tablaResumCateg").append(cuerpo4);
            head4 = '<tr>\
                        <th class="center">Categoría de Gasto</th>\
                        <th class="center">PIA</th>\
                        <th class="center">PIM</th>\
                        <th class="center">Certificado</th>\
                        <th class="center">Compromiso Anual</th>\
                        <th class="center">Saldo por Comprometer</th>\
                        <th class="center">Devengado</th>\
                        <th class="center">Avance %</th>\
                     </tr>';
            $("#tablaResumCategHead").append(head4);
            muestra4.push([
                {text: 'Categoría de Gasto', style: 'tablaHead', alignment: 'center'},
                {text: 'PIA', style: 'tablaHead', alignment: 'center'},
                {text: 'PIM', style: 'tablaHead', alignment: 'center'},
                {text: 'Certificado', style: 'tablaHead', alignment: 'center'},
                {text: 'Compromiso Anual', style: 'tablaHead', alignment: 'center'},
                {text: 'Saldo por Comprometer', style: 'tablaHead', alignment: 'center'},
                {text: 'Devengado', style: 'tablaHead', alignment: 'center'},
                {text: 'Avance %', style: 'tablaHead', alignment: 'center'}
            ]);
            var pia4T, pim4T, cert4T, comp4T, deven4T;
            pia4T = pim4T = cert4T = comp4T = deven4T = 0.00;
            $.each(response.listPorCateg, function (idx4, value4) {
                var cert4, comp4, deve4, saldo4, avance4;
                if (!$.trim(value4.certificado)) {
                    cert4 = formatNumero(0.00);
                } else {
                    cert4 = formatNumero(value4.certificado);
                    cert4T += value4.certificado;
                }
                if (!$.trim(value4.compromiso_anual)) {
                    comp4 = formatNumero(0.00);
                    saldo4 = formatNumero(value4.pim);
                } else {
                    comp4 = formatNumero(value4.compromiso_anual);
                    comp4T += value4.compromiso_anual;
                    saldo4 = formatNumero(value4.pim - value4.compromiso_anual);
                }
                if (!$.trim(value4.devengado)) {
                    deve4 = formatNumero(0.00);
                    avance4 = formatNumero(0.00);
                } else {
                    deve4 = formatNumero(value4.devengado);
                    deven4T += value4.devengado;
                    if (value4.pim === 0.00) {
                        avance4 = formatNumero(0.00);
                    } else {
                        avance4 = formatNumero((value4.devengado / value4.pim) * 100);
                    }
                }
                body4 = '<tr>\
                            <td class="left">' + value4.categoria_gasto + ' - ' + value4.nombre + '</td>\
                            <td class="right">' + formatNumero(value4.pia) + '</td>\
                            <td class="right">' + formatNumero(value4.pim) + '</td>\
                            <td class="right">' + cert4 + '</td>\
                            <td class="right">' + comp4 + '</td>\
                            <td class="right">' + saldo4 + '</td>\
                            <td class="right">' + deve4 + '</td>\
                            <td class="right">' + avance4 + '</td>\
                         </tr>';
                $("#tablaResumCategBody").append(body4);
                pia4T += value4.pia;
                pim4T += value4.pim;
                muestra4.push([
                    {text: value4.categoria_gasto + ' - ' + value4.nombre, style: 'tablaBody', alignment: 'left'},
                    {text: formatNumero(value4.pia), style: 'tablaBody', alignment: 'right'},
                    {text: formatNumero(value4.pim), style: 'tablaBody', alignment: 'right'},
                    {text: cert4, style: 'tablaBody', alignment: 'right'},
                    {text: comp4, style: 'tablaBody', alignment: 'right'},
                    {text: saldo4, style: 'tablaBody', alignment: 'right'},
                    {text: deve4, style: 'tablaBody', alignment: 'right'},
                    {text: avance4, style: 'tablaBody', alignment: 'right'}
                ]);
            });
            foot4T = '<tr class="total">\
                        <td class="right"><b>TOTAL</b></td>\
                        <td class="right"><b>' + formatNumero(pia4T) + '</b></td>\
                        <td class="right"><b>' + formatNumero(pim4T) + '</b></td>\
                        <td class="right"><b>' + formatNumero(cert4T) + '</b></td>\
                        <td class="right"><b>' + formatNumero(comp4T) + '</b></td>\
                        <td class="right"><b>' + formatNumero(pim4T - comp4T) + '</b></td>\
                        <td class="right"><b>' + formatNumero(deven4T) + '</b></td>\
                        <td class="right"><b>' + formatNumero((deven4T / pim4T) * 100) + '</b></td>\
                      </tr>';
            $("#tablaResumCategFoot").append(foot4T);
            muestra4.push([
                {text: 'TOTAL', style: 'tablaTotal', alignment: 'right'},
                {text: formatNumero(pia4T), style: 'tablaTotal', alignment: 'right'},
                {text: formatNumero(pim4T), style: 'tablaTotal', alignment: 'right'},
                {text: formatNumero(cert4T), style: 'tablaTotal', alignment: 'right'},
                {text: formatNumero(comp4T), style: 'tablaTotal', alignment: 'right'},
                {text: formatNumero(pim4T - comp4T), style: 'tablaTotal', alignment: 'right'},
                {text: formatNumero(deven4T), style: 'tablaTotal', alignment: 'right'},
                {text: formatNumero((deven4T / pim4T) * 100), style: 'tablaTotal', alignment: 'right'}
            ]);
            $("#divBtnReporteResumenPdf").removeClass('oculto');

            $("#listPresuEjecutoraResum option").prop('disabled', false);
            $("#listPresuEjecutoraResum").removeClass("cargando");

            $('#tablaResumCateg').dataTable().fnDestroy();
            $('#tablaResumCateg').dataTable({
                paging: false,
                ordering: true,
                bPaginate: false,
                dom: 'rt'
            });
        }
    });

    var imageUrl1 = './Presupuesto?tipo=10&model=grafica1&pdf=si&año=' + año + '&ejec=' + ejec + '&ancho=220&alto=260&font=9&bar=0.30&pos=in';
    var imageUrl2 = './Presupuesto?tipo=10&model=grafica2&pdf=si&año=' + año + '&ejec=' + ejec + '&ancho=220&alto=260&font=9&bar=0.30&pos=in';
    var imageUrl3 = './Presupuesto?tipo=10&model=grafica3&pdf=si&año=' + año + '&ejec=' + ejec + '&ancho=220&alto=260&font=9&bar=0.30&pos=in';
    var imageUrl4 = './Presupuesto?tipo=10&model=grafica4&pdf=si&año=' + año + '&ejec=' + ejec + '&ancho=900&alto=400&font=9&bar=0.20&pos=out';
    var imageUrl5 = './Presupuesto?tipo=10&model=grafica5&pdf=si&año=' + año + '&ejec=' + ejec + '&ancho=900&alto=400&font=9&bar=0.20&pos=out';
    var imageUrl6 = './Presupuesto?tipo=10&model=grafica6&pdf=si&año=' + año + '&ejec=' + ejec + '&ancho=900&alto=400&font=9&bar=0.20&pos=out';
    var imageUrl_grsm = './resources/images/logo_grsm.png';
    var imageUrl_system = './resources/images/logo_sirsm.png';
    var img1, img2, img3, img4, img5, img6, img_grsm, img_system;
    convertImgToDataURLviaCanvas(imageUrl1, function (base64Img) {
        img1 = base64Img;
    });
    convertImgToDataURLviaCanvas(imageUrl2, function (base64Img) {
        img2 = base64Img;
    });
    convertImgToDataURLviaCanvas(imageUrl3, function (base64Img) {
        img3 = base64Img;
    });
    convertImgToDataURLviaCanvas(imageUrl4, function (base64Img) {
        img4 = base64Img;
    });
    convertImgToDataURLviaCanvas(imageUrl5, function (base64Img) {
        img5 = base64Img;
    });
    convertImgToDataURLviaCanvas(imageUrl6, function (base64Img) {
        img6 = base64Img;
    });
    convertImgToDataURLviaCanvas(imageUrl_grsm, function (base64Img) {
        img_grsm = base64Img;
    });
    convertImgToDataURLviaCanvas(imageUrl_system, function (base64Img) {
        img_system = base64Img;
    });
    var newDate = new Date();
    var tiempo = newDate.getDate() + "/" + newDate.getMonth() + "/" + newDate.getFullYear() + "  " + newDate.getHours() + ":" + newDate.getMinutes();
    $("#divBtnReporteResumenPdf a").on('click', function () {

        var docDefinition = {
            info: {
                title: 'resumen_ejecucion_' + ejec + '_' + año
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
                                {text: 'RESUMEN DE EJECUCIÓN PRESUPUESTAL - ' + año + '\n' + titulo_reporte + '\n', alignment: 'center', style: 'titulo'}
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
                        widths: ['*', '*', '*'],
                        body: [
                            [
                                {text: 'Avance de Ejecución (S/)', alignment: 'left', style: 'subtitulo'},
                                {text: 'Avance de Ejecución por Proyectos (S/)', alignment: 'left', style: 'subtitulo'},
                                {text: 'Avance de Ejecución por Productos (S/)', alignment: 'left', style: 'subtitulo'}
                            ],
                            [
                                {image: img1, fit: [140, 160], alignment: 'center'},
                                {image: img2, fit: [140, 160], alignment: 'center'},
                                {image: img3, fit: [140, 160], alignment: 'center'}
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
                        widths: ['*'],
                        body: [
                            [
                                {text: 'Avance de Ejecución Presupuestal - Mensualizada', alignment: 'left', style: 'subtitulo'}
                            ],
                            [
                                {image: img4, fit: [520, 220], alignment: 'left'}
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
                        widths: ['*'],
                        body: [
                            [
                                {text: 'Avance de Ejecución Presupuestal por Proyectos - Mensualizada', alignment: 'left', style: 'subtitulo'}
                            ],
                            [
                                {image: img5, fit: [520, 220], alignment: 'left'}
                            ]
                        ]
                    },
                    layout: {
                        hLineColor: 'white',
                        vLineColor: 'white'
                    }
                },
                {
                    text: '\n\n'
                },
                {
                    table: {
                        widths: ['*'],
                        body: [
                            [
                                {text: 'Avance de Ejecución Presupuestal por Productos - Mensualizada', alignment: 'left', style: 'subtitulo'}
                            ],
                            [
                                {image: img6, fit: [520, 220], alignment: 'left'}
                            ]
                        ]
                    },
                    layout: {
                        hLineColor: 'white',
                        vLineColor: 'white'
                    }
                },
                {
                    text: '\n\nEjecución Presupuestal por Proyecto/Producto\n', alignment: 'left', style: 'subtitulo'
                },
                {
                    table: {
                        widths: [150, '*', '*', '*', '*', '*', '*', '*'],
                        body: muestra1
                    },
                    layout: {
                        hLineColor: '#ECECEC',
                        vLineColor: '#ECECEC'
                    }
                },
                {
                    text: '\n\nEjecución Presupuestal por Genérica de Gasto\n', alignment: 'left', style: 'subtitulo'
                },
                {
                    table: {
                        widths: [150, '*', '*', '*', '*', '*', '*', '*'],
                        body: muestra2
                    },
                    layout: {
                        hLineColor: '#ECECEC',
                        vLineColor: '#ECECEC'
                    }
                },
                {
                    text: '\n\nEjecución Presupuestal por Fuente de Financiamiento\n', alignment: 'left', style: 'subtitulo'
                },
                {
                    table: {
                        widths: [150, '*', '*', '*', '*', '*', '*', '*'],
                        body: muestra3
                    },
                    layout: {
                        hLineColor: '#ECECEC',
                        vLineColor: '#ECECEC'
                    }
                },
                {
                    text: '\n\nEjecución Presupuestal por Categoría de Gasto\n', alignment: 'left', style: 'subtitulo'
                },
                {
                    table: {
                        widths: [150, '*', '*', '*', '*', '*', '*', '*'],
                        body: muestra4
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
                    fontSize: 8
                },
                tablaHead: {
                    color: 'white',
                    fillColor: '#426993',
                    fontSize: 6,
                    bold: true
                },
                tablaBody: {
                    fontSize: 5
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