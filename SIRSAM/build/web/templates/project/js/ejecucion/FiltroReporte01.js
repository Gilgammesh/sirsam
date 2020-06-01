// Reporte de Ejecución de Gasto Histórico

function FiltroReporte01() {
    alert("funciona filtro01");
}

function llenarFiltroReporte01() {
    $("#divPresuFiltReporte").empty();
    ejecutora = '<div class="form-group row">\
                    <label for="listPresuEjecutora" class="col-sm-2 col-form-label">Elija Ejecutora :</label>\
                    <div class="col-sm-7">\
                    <select class="select-form" id="listPresuEjecutora" name="ejec"></select>\
                    </div>\
                    </div>';
    año = '<div class="form-group row line_bottom">\
            <label for="listPresuAñoDesde" class="col-sm-2 col-form-label">Desde Año :</label>\
            <div class="col-sm-2">\
            <select class="select-form" id="listPresuAñoDesde" name="desde"></select>\
            </div>\
            <div class="col-sm-1"></div>\
            <label for="listPresuAñoHasta" class="col-sm-2 col-form-label">Hasta Año :</label>\
            <div class="col-sm-2">\
            <select class="select-form" id="listPresuAñoHasta" name="hasta"></select>\
            </div>\
            </div>';
    marco = '<div class="form-group row line_top">\
            <label class="col-sm-2">Marco Presupuestal :</label>\
            <div class="col-sm-2 fontweight6">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="marco_todo">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Todos</span>\
            </label>\
            </div>\
            </div>';
    marco += '<div class="form-row fontweight3">\
              <label class="col-sm-2"></label>&nbsp;';
    marco += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="marco" value="1" checked>\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">PIA</span>\
            </label>\
            </div>';
    marco += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="marco" value="2">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Modificaciones</span>\
            </label>\
            </div>';
    marco += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="marco" value="3" checked>\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">PIM</span>\
            </label>\
            </div>';
    marco += '</div>';
    fase = '<div class="form-group row line_top">\
            <label class="col-sm-2">Fase :</label>\
            <div class="col-sm-2 fontweight6">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="fase_todo" checked>\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Todas</span>\
            </label>\
            </div>\
            </div>';
    fase += '<div class="form-row fontweight3">\
              <label class="col-sm-2"></label>&nbsp;';
    fase += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="fase" value="4" checked>\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Certificado</span>\
            </label>\
            </div>';
    fase += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="fase" value="5" checked>\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Compromiso Anual</span>\
            </label>\
            </div>';
    fase += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="fase" value="6" checked>\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Compromiso</span>\
            </label>\
            </div>';
    fase += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="fase" value="7" checked>\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Devengado</span>\
            </label>\
            </div>';
    fase += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="fase" value="8" checked>\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Girado</span>\
            </label>\
            </div>';
    fase += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="fase" value="9" checked>\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Pagado</span>\
            </label>\
            </div>';
    fase += '</div>';
    saldo = '<div class="form-group row line_top">\
            <label class="col-sm-2">Saldos y Porcentajes :</label>\
            <div class="col-sm-2 fontweight6">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="saldo_todo">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Todas</span>\
            </label>\
            </div>\
            </div>';
    saldo += '<div class="form-row fontweight3">\
              <label class="col-sm-2"></label>&nbsp;';
    saldo += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="saldo" value="10, 11">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Certificado</span>\
            </label>\
            </div>';
    saldo += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="saldo" value="12, 13">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Compromiso Anual</span>\
            </label>\
            </div>';
    saldo += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="saldo" value="14, 15">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Compromiso</span>\
            </label>\
            </div>';
    saldo += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="saldo" value="16, 17" checked>\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Devengado</span>\
            </label>\
            </div>';
    saldo += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="saldo" value="18, 19">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Girado</span>\
            </label>\
            </div>';
    saldo += '<div class="col-auto">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="saldo" value="20, 21">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Pagado</span>\
            </label>\
            </div>';
    saldo += '</div>';
    botones = '<div class="form-row line_top20">\
                <label class="col-sm-2"></label>\
                <div class="col-auto">\
                <button type="submit" class="btn btn3d btn-danger btn-m">\
                <span class="glyphicon glyphicon-play spanBtn"></span>Generar\
                </button>\
                </div>\
                <div class="col-auto">\
                <button id="btnRepoPresu01" type="reset" value="Reset" class="btn btn3d btn-white btn-m">\
                <span class="glyphicon glyphicon-erase spanBtn"></span>Limpiar\
                </button>\
                </div>\
                </div>';
    html = ejecutora + año + marco + fase + saldo + botones;
    $("#divPresuFiltReporte").append(html);
    limpiar();
}

function controlFiltroReporte01() {
    $('#listPresuEjecutora').empty();
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataEjecutoras",
        success: function (response) {
            $("#listPresuEjecutora").append("<option value= '00'>Pliego 459 - Gobierno Regional de San Martin</option>");
            $.each(response.listEjecutoras, function (index, value) {
                var nombre_ejec = (value.nombre).split("-");
                obje = "<option value=" + value.sec_ejec + ">UE " + value.ejecutora + " - " + nombre_ejec[1].trim() + " (" + value.sec_ejec + ")</option>";
                $("#listPresuEjecutora").append(obje);
            });
            $('#listPresuEjecutora').prop('selectedIndex', 1);
            llenarAños($('#listPresuEjecutora').val());
        }
    });
    $("#listPresuEjecutora").bind("change", function () {
        llenarAños($('#listPresuEjecutora').val());
    });
    cambiaMarco();
    cambiaFase();
    cambiaSaldo();
    $("#btnRepoPresu01").click(function () {
        $("#divPresuTabla").empty();
        $("#divPresuTabla").addClass("oculto");
        $("#lblPresuFiltGrafico").addClass("oculto");
        $("#divPresuFiltGrafico").empty();
        $("#divPresuFiltGrafico").addClass("oculto");
        $("#divPresuGrafica").empty();
        $("#divPresuGrafica").addClass("oculto");
    });
}

function validarFiltroReporte01() {
    var countMarco = 0;
    var countFase = 0;
    var msg;
    $("input[name=marco]").each(function () {
        if (this.checked) {
            countMarco++;
        }
    });
    $("input[name=fase]").each(function () {
        if (this.checked) {
            countFase++;
        }
    });
    if (countMarco === 0) {
        msg = "Debe seleccionar al menos un Marco Presupuestal";
        return(msg);
    }
    if (countFase === 0) {
        msg = "Debe seleccionar al menos una Fase";
        return(msg);
    }
    msg = "OK";
    return(msg);
}

function llenarTablaReporte01(response) {
    var muestra = [];
    cuerpo = '<table id="tablaPresu" class="display" cellspacing="0" width="100%">\
                <thead id="tablaPresuHead"></thead>\
                <tbody id="tablaPresuBody"></tbody>\
              </table>';
    $("#divPresuTabla").append(cuerpo);
    head = "<tr>\
                <th>Año</th>\
                <th>PIA</th>\
                <th>Modificaciones</th>\
                <th>PIM (P)</th>\
                <th>Certificado (C)</th>\
                <th>Compromiso Anual (CoA)</th>\
                <th>Compromiso (Co)</th>\
                <th>Devengado (D)</th>\
                <th>Girado (G)</th>\
                <th>Pagado (Pa)</th>\
                <th>Saldo por Certificar (P - C)</th>\
                <th>% Certificado (C/P)</th>\
                <th>Saldo por Comprometer Anual (P - CoA)</th>\
                <th>% Comprometido Anual (CoA/P)</th>\
                <th>Saldo por Comprometer (P - Co)</th>\
                <th>% Comprometido (Co/P)</th>\
                <th>Saldo por Ejecutar (P - D)</th>\
                <th>% Ejecución (D/P)</th>\
                <th>Saldo por Girar (P - G)</th>\
                <th>% Girado (G/P)</th>\
                <th>Saldo por Pagar (P - Pa)</th>\
                <th>% Pagado (Pa/P)</th>\
            </tr>";
    $("#tablaPresuHead").append(head);
    muestra.push([
        {text: 'Año', style: 'tablaHead', alignment: 'center'},
        {text: 'PIA', style: 'tablaHead', alignment: 'center'},
        {text: 'PIM', style: 'tablaHead', alignment: 'center'},
        {text: 'Certificado', style: 'tablaHead', alignment: 'center'},
        {text: 'Compromiso Anual', style: 'tablaHead', alignment: 'center'},
        {text: 'Compromiso', style: 'tablaHead', alignment: 'center'},
        {text: 'Devengado', style: 'tablaHead', alignment: 'center'},
        {text: 'Girado', style: 'tablaHead', alignment: 'center'},
        {text: 'Pagado', style: 'tablaHead', alignment: 'center'},
        {text: 'Saldo por Devengar', style: 'tablaHead', alignment: 'center'},
        {text: 'Ejecución %', style: 'tablaHead', alignment: 'center'}
    ]);
    var count = 0;
    $.each(response.list, function (index, value) {
        count++;
        body = "<tr>\
                    <td class='center'>" + value.ano_eje + "</td>\
                    <td class='right'>" + formatNumero(value.pia) + "</td>\
                    <td class='right'>" + formatNumero(value.modificacion) + "</td>\
                    <td class='right'>" + formatNumero(value.pim) + "</td>\
                    <td class='right'>" + formatNumero(value.certificado) + "</td>\
                    <td class='right'>" + formatNumero(value.compromiso_anual) + "</td>\
                    <td class='right'>" + formatNumero(value.compromiso) + "</td>\
                    <td class='right'>" + formatNumero(value.ejecucion) + "</td>\
                    <td class='right'>" + formatNumero(value.girado) + "</td>\
                    <td class='right'>" + formatNumero(value.pagado) + "</td>\
                    <td class='right'>" + formatNumero(value.pim - value.certificado) + "</td>\
                    <td class='center'>" + formatNumero((value.certificado / value.pim) * 100) + "</td>\
                    <td class='right'>" + formatNumero(value.pim - value.compromiso_anual) + "</td>\
                    <td class='center'>" + formatNumero((value.compromiso_anual / value.pim) * 100) + "</td>\
                    <td class='right'>" + formatNumero(value.pim - value.compromiso) + "</td>\
                    <td class='center'>" + formatNumero((value.compromiso / value.pim) * 100) + "</td>\
                    <td class='right'>" + formatNumero(value.pim - value.ejecucion) + "</td>\
                    <td class='center'>" + formatNumero((value.ejecucion / value.pim) * 100) + "</td>\
                    <td class='right'>" + formatNumero(value.pim - value.girado) + "</td>\
                    <td class='center'>" + formatNumero((value.girado / value.pim) * 100) + "</td>\
                    <td class='right'>" + formatNumero(value.pim - value.pagado) + "</td>\
                    <td class='center'>" + formatNumero((value.pagado / value.pim) * 100) + "</td>\
                </tr>";
        $("#tablaPresuBody").append(body);
        muestra.push([
            {text: value.ano_eje, style: 'tablaBody', alignment: 'center'},
            {text: formatNumero(value.pia), style: 'tablaBody', alignment: 'right'},
            {text: formatNumero(value.pim), style: 'tablaBody', alignment: 'right'},
            {text: formatNumero(value.certificado), style: 'tablaBody', alignment: 'right'},
            {text: formatNumero(value.compromiso_anual), style: 'tablaBody', alignment: 'right'},
            {text: formatNumero(value.compromiso), style: 'tablaBody', alignment: 'right'},
            {text: formatNumero(value.ejecucion), style: 'tablaBody', alignment: 'right'},
            {text: formatNumero(value.girado), style: 'tablaBody', alignment: 'right'},
            {text: formatNumero(value.pagado), style: 'tablaBody', alignment: 'right'},
            {text: formatNumero(value.pim - value.ejecucion), style: 'tablaBody', alignment: 'right'},
            {text: formatNumero((value.ejecucion / value.pim) * 100), style: 'tablaBody', alignment: 'right'}
        ]);
    });
    var countIniT = 1;
    var columnasIni = "[";
    var countMarco = 0;
    var countMarcoT = 0;
    var columnasMarco = "";
    $("input[name=marco]").each(function () {
        if (this.checked === false) {
            countMarco++;
            columnasMarco += this.value + ", ";
        } else {
            countMarcoT++;
        }
    });
    var countFase = 0;
    var countFaseT = 0;
    var columnasFase = "";
    $("input[name=fase]").each(function () {
        if (this.checked === false) {
            countFase++;
            columnasFase += this.value + ", ";
        } else {
            countFaseT++;
        }
    });
    var countSaldo = 0;
    var countSaldoT = 0;
    var columnasSaldo = "";
    $("input[name=saldo]").each(function () {
        if (this.checked === false) {
            countSaldo++;
            columnasSaldo += this.value + ", ";
        } else {
            countSaldoT++;
        }
    });
    var columnasFin = "]";
    if (countSaldo !== 0) {
        columnasSaldo = columnasSaldo.substring(0, columnasSaldo.length - 2);
    } else {
        if (countFase !== 0) {
            columnasFase = columnasFase.substring(0, columnasFase.length - 2);
        } else {
            if (countMarco !== 0) {
                columnasMarco = columnasMarco.substring(0, columnasMarco.length - 2);
            }
        }
    }
    var columnas = columnasIni + columnasMarco + columnasFase + columnasSaldo + columnasFin;
    var countT = countIniT + countMarcoT + countFaseT + (countSaldoT * 2);
    var columnasObject = JSON.parse(columnas); // Aca se hace un parse de JS String a JS Object para que pueda ser reconocido
    $('#tablaPresu').dataTable({
        columnDefs: [
            {targets: columnasObject, visible: false},
            {targets: '_all', visible: true}
        ],
        ordering: false,
        dom: '<"centrar-div-tabla"lB>iprtip',
        buttons: [
            {
                extend: 'colvis',
                columnText: function (dt, idx, title) {
                    return (idx + 1) + '.- ' + title;
                },
                postfixButtons: ['colvisRestore'],
                collectionLayout: 'fixed three-column'
            },
            {
                extend: 'excel',
                filename: 'ejecucion_gasto_' + response.ejec + '_historico',
                title: 'EJECUCIÓN DE GASTO HISTÓRICO',
                messageTop: response.tituloPDF,
                exportOptions: {
                    orthogonal: 'sort',
                    columns: ':visible'
                },
                customize: function (xlsx) {
                    var sheet = xlsx.xl.worksheets['sheet1.xml'];
                    for (var k = countIniT; k < countIniT + countMarcoT; k++) {
                        var total = $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).length;
                        $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).each(function (i) {
                            if (i > 0 && i < total) {
                                $(this).attr('s', '72');
                            }
                        });
                    }
                    for (var k = countIniT + countMarcoT; k < countIniT + countMarcoT + countFaseT; k++) {
                        var total = $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).length;
                        $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).each(function (i) {
                            if (i > 0 && i < total) {
                                $(this).attr('s', '72');
                            }
                        });
                    }
                    for (var k = countIniT + countMarcoT + countFaseT; k < countT; k++) {
                        var total = $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).length;
                        if ((k - countIniT + countMarcoT + countFaseT) % 2 === 0) {
                            $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).each(function (i) {
                                if (i > 0 && i < total) {
                                    $(this).attr('s', '72');
                                }
                            });
                        } else {
                            $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).each(function (i) {
                                if (i > 0 && i < total) {
                                    $(this).attr('s', '73');
                                }
                            });
                        }
                    }
                }
            }
        ]
    });
    btnPDF = '<button id="exportPDF" class="dt-button buttons-html5">\
                <span>\
                    <img src="./templates/plugins/datatables/images/pdf.png" data-toggle="tooltip" data-placement="bottom" title="Exportar a PDF">\
                </span>\
              </button>';
    $("#tablaPresu_wrapper .dt-buttons").append(btnPDF);
    $("#lblPresuFiltGrafico").removeClass("oculto");
    $("#divPresuFiltGrafico").removeClass("oculto");
    llenarFiltroGrafico01();
    $("#divPresuGrafica").removeClass("oculto");
    llenarGrafico01("./Presupuesto?tipo=01&graph=true&ejec=" + response.ejec + "&desde=" + response.desde + "&hasta=" + response.hasta + "&ancho=1000&alto=500&font=10&bar=0.10&pos=in&pia=no&pim=no&fase=Devengado");
    cambiaFiltroGrafico01(response.ejec, response.desde, response.hasta);
    ///////////////// Exportar a PDF ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   

    var imageUrl_grsm = './resources/images/logo_grsm.png';
    var imageUrl_system = './resources/images/logo_sirsm.png';
    var img1, img_grsm, img_system;
    convertImgToDataURLviaCanvas(imageUrl_grsm, function (base64Img) {
        img_grsm = base64Img;
    });
    convertImgToDataURLviaCanvas(imageUrl_system, function (base64Img) {
        img_system = base64Img;
    });
    var newDate = new Date();
    var tiempo = newDate.getDate() + "/" + newDate.getMonth() + "/" + newDate.getFullYear() + "  " + newDate.getHours() + ":" + newDate.getMinutes();
    $("#exportPDF").hover(function () {
        var imageUrl1 = document.getElementById("imgPresuGrafica").src + "&pdf=si";
        convertImgToDataURLviaCanvas(imageUrl1, function (base64Img) {
            img1 = base64Img;
        });
    });
    $("#exportPDF").on('click', function () {
        var docDefinition = {
            info: {
                title: 'ejecucion_gasto_' + response.ejec + '_historico'
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
                                {text: 'EJECUCIÓN DE GASTO HISTÓRICO\n' + response.tituloPDF + '\n', alignment: 'center', style: 'titulo'}
                            ]
                        ]
                    },
                    layout: {
                        hLineColor: 'white',
                        vLineColor: 'white'
                    }
                },
                {
                    text: '\n\nTabla Resumen de Ejecución', alignment: 'left', style: 'subtitulo'
                },
                {
                    text: '\n'
                },
                {
                    table: {
                        widths: [12, '*', '*', '*', '*', '*', '*', '*', '*', '*', 20],
                        body: muestra
                    },
                    layout: {
                        hLineColor: '#ECECEC',
                        vLineColor: '#ECECEC'
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
                                {text: 'Gráfica de Ejecución', alignment: 'left', style: 'subtitulo'}
                            ],
                            [
                                {image: img1, fit: [520, 220], alignment: 'left'}
                            ]
                        ]
                    },
                    layout: {
                        hLineColor: 'white',
                        vLineColor: 'white'
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
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 

}

function llenarFiltroGrafico01() {
    $("#divPresuFiltGrafico").empty();
    marco = '<div class="form-row">\
              <label class="col-sm-2 fontweight5">Marco Presupuestal :</label>&nbsp;';
    marco += '<div class="col-auto fontweight3">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="piag">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">PIA</span>\
            </label>\
            </div>';
    marco += '<div class="col-auto fontweight3">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="pimg">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">PIM</span>\
            </label>\
            </div>';
    marco += '</div>';
    fase = '<div class="form-row line_top">\
              <label class="col-sm-2">Seleccione una Fase :</label>&nbsp;';
    fase += '<div class="col-auto fontweight3">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="faseg" value="Certificado">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Certificado</span>\
            </label>\
            </div>';
    fase += '<div class="col-auto fontweight3">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="faseg" value="CompromisoAnual">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Compromiso Anual</span>\
            </label>\
            </div>';
    fase += '<div class="col-auto fontweight3">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="faseg" value="Compromiso">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Compromiso</span>\
            </label>\
            </div>';
    fase += '<div class="col-auto fontweight3">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="faseg" value="Devengado" checked>\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Devengado</span>\
            </label>\
            </div>';
    fase += '<div class="col-auto fontweight3">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="faseg" value="Girado">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Girado</span>\
            </label>\
            </div>';
    fase += '<div class="col-auto fontweight3">\
            <label class="custom-control custom-checkbox">\
            <input type="checkbox" class="custom-control-input" name="faseg" value="Pagado">\
            <span class="custom-control-indicator"></span>&nbsp;\
            <span class="custom-control-description">Pagado</span>\
            </label>\
            </div>';
    fase += '</div>';
    html = marco + fase;
    $("#divPresuFiltGrafico").append(html);
}

function cambiaFiltroGrafico01(ejec, desde, hasta) {

    $("input[name=piag]").change(function () {
        var fase;
        $("input[name=faseg]").each(function () {
            if (this.checked) {
                fase = this.value;
            }
        });
        if (this.checked) {
            if ($("input[name=pimg]").is(":checked") === true) {
                llenarGrafico01("./Presupuesto?tipo=01&graph=true&ejec=" + ejec + "&desde=" + desde + "&hasta=" + hasta + "&ancho=1000&alto=500&font=10&bar=0.30&pos=in&pia=si&pim=si&fase=" + fase + "");
            }
            if ($("input[name=pimg]").is(":checked") === false) {
                llenarGrafico01("./Presupuesto?tipo=01&graph=true&ejec=" + ejec + "&desde=" + desde + "&hasta=" + hasta + "&ancho=1000&alto=500&font=10&bar=0.30&pos=in&pia=si&pim=no&fase=" + fase + "");
            }
        } else {
            if ($("input[name=pimg]").is(":checked") === true) {
                llenarGrafico01("./Presupuesto?tipo=01&graph=true&ejec=" + ejec + "&desde=" + desde + "&hasta=" + hasta + "&ancho=1000&alto=500&font=10&bar=0.30&pos=in&pia=no&pim=si&fase=" + fase + "");
            }
            if ($("input[name=pimg]").is(":checked") === false) {
                llenarGrafico01("./Presupuesto?tipo=01&graph=true&ejec=" + ejec + "&desde=" + desde + "&hasta=" + hasta + "&ancho=1000&alto=500&font=10&bar=0.10&pos=in&pia=no&pim=no&fase=" + fase + "");
            }
        }
    });
    $("input[name=pimg]").change(function () {
        var fase;
        $("input[name=faseg]").each(function () {
            if (this.checked) {
                fase = this.value;
            }
        });
        if (this.checked) {
            if ($("input[name=piag]").is(":checked") === true) {
                llenarGrafico01("./Presupuesto?tipo=01&graph=true&ejec=" + ejec + "&desde=" + desde + "&hasta=" + hasta + "&ancho=1000&alto=500&font=10&bar=0.30&pos=in&pia=si&pim=si&fase=" + fase + "");
            }
            if ($("input[name=piag]").is(":checked") === false) {
                llenarGrafico01("./Presupuesto?tipo=01&graph=true&ejec=" + ejec + "&desde=" + desde + "&hasta=" + hasta + "&ancho=1000&alto=500&font=10&bar=0.30&pos=in&pia=no&pim=si&fase=" + fase + "");
            }
        } else {
            if ($("input[name=piag]").is(":checked") === true) {
                llenarGrafico01("./Presupuesto?tipo=01&graph=true&ejec=" + ejec + "&desde=" + desde + "&hasta=" + hasta + "&ancho=1000&alto=500&font=10&bar=0.30&pos=in&pia=si&pim=no&fase=" + fase + "");
            }
            if ($("input[name=piag]").is(":checked") === false) {
                llenarGrafico01("./Presupuesto?tipo=01&graph=true&ejec=" + ejec + "&desde=" + desde + "&hasta=" + hasta + "&ancho=1000&alto=500&font=10&bar=0.10&pos=in&pia=no&pim=no&fase=" + fase + "");
            }
        }
    });
    $("input[name=faseg]").change(function () {
        if (this.checked) {
            $("input[name=faseg]").prop("checked", false);
            $("input[value=" + this.value + "]").prop("checked", true);
            if ($("input[name=piag]").is(":checked") === true && $("input[name=pimg]").is(":checked") === true) {
                llenarGrafico01("./Presupuesto?tipo=01&graph=true&ejec=" + ejec + "&desde=" + desde + "&hasta=" + hasta + "&ancho=1000&alto=500&font=10&bar=0.30&pos=in&pia=si&pim=si&fase=" + this.value + "");
            }
            if ($("input[name=piag]").is(":checked") === true && $("input[name=pimg]").is(":checked") === false) {
                llenarGrafico01("./Presupuesto?tipo=01&graph=true&ejec=" + ejec + "&desde=" + desde + "&hasta=" + hasta + "&ancho=1000&alto=500&font=10&bar=0.30&pos=in&pia=si&pim=no&fase=" + this.value + "");
            }
            if ($("input[name=piag]").is(":checked") === false && $("input[name=pimg]").is(":checked") === true) {
                llenarGrafico01("./Presupuesto?tipo=01&graph=true&ejec=" + ejec + "&desde=" + desde + "&hasta=" + hasta + "&ancho=1000&alto=500&font=10&bar=0.30&pos=in&pia=no&pim=si&fase=" + this.value + "");
            }
            if ($("input[name=piag]").is(":checked") === false && $("input[name=pimg]").is(":checked") === false) {
                llenarGrafico01("./Presupuesto?tipo=01&graph=true&ejec=" + ejec + "&desde=" + desde + "&hasta=" + hasta + "&ancho=1000&alto=500&font=10&bar=0.10&pos=in&pia=no&pim=no&fase=" + this.value + "");
            }
        } else {
            $("input[value=" + this.value + "]").prop("checked", true);
        }
    });
}

function llenarGrafico01(src) {
    $("#divPresuGrafica").empty();
    img = '<img id="imgPresuGrafica" src="' + src + '"/>';
    $("#divPresuGrafica").append(img);
}