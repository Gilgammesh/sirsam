// Reporte de Semáforo de Ejecución del Pliego

function SemaforoEjecucion() {
    alert("funciona semáforo de ejecución");
}

function llenarSemaforoEjecucionFiltro() {
    $("#divPresuReporteResumen").empty();
    filtro = '<div class="filtro_report naranja_secun">\
                <div class="form-group row">\
                    <label for="listPresuEjecutoraSemaf" class="col-sm-2 col-form-label">Elija Ejecutora :</label>\
                    <div class="col-sm-10">\
                        <select class="select-form" id="listPresuEjecutoraSemaf"></select>\
                    </div>\
                </div>\
                <div class="form-group row">\
                    <label for="listSemaforoEjecAño" class="col-sm-2 col-form-label">Elija Año :</label>\
                    <div class="col-sm-2">\
                        <select class="select-form" id="listSemaforoEjecAño"></select>\
                    </div>\
                    <div class="col-sm-2"></div>\
                    <label for="listSemaforoEjecEstado" class="col-sm-2 col-form-label">Filtro Semáforo :</label>\
                    <div class="col-sm-2">\
                        <select class="select-form" id="listSemaforoEjecEstado">\
                            <option value= "00" selected>--TODOS--</option>\
                            <option value= "01" style="color: green; font-weight: bold;">Verde</option>\
                            <option value= "02" style="color: #FFBF00; font-weight: bold;">Ámbar</option>\
                            <option value= "03" style="color: red; font-weight: bold;">Rojo</option>\
                        </select>\
                    </div>\
                </div>\
             </div>';
    filtro += '<br>';
    reporte = '<div id="divPresuSemaforoEjecucionConte" class="filtro_report naranja_secun"></div>';
    HTML = filtro + reporte;
    $("#divPresuReporteResumen").append(HTML);
    llenarSemaforoEjecutoras();
}

function controlSemaforoEjecucionFiltro() {
    $("#listPresuEjecutoraSemaf").bind("change", function () {
        llenarSemaforoAños($('#listPresuEjecutoraSemaf').val());
    });
    $("#listSemaforoEjecAño").bind("change", function () {
        var ejec = $('#listPresuEjecutoraSemaf').val();
        var año = $('#listSemaforoEjecAño').val();
        var estado = $("#listSemaforoEjecEstado").val();
        llenarSemaforoEjecucionContenido(ejec, año, estado);
    });
    $("#listSemaforoEjecEstado").bind("change", function () {
        var ejec = $('#listPresuEjecutoraSemaf').val();
        var año = $('#listSemaforoEjecAño').val();
        var estado = $("#listSemaforoEjecEstado").val();
        llenarSemaforoEjecucionContenido(ejec, año, estado);
    });
}

function llenarSemaforoEjecucionContenido(ejec, año, estado) {
    $("#divPresuSemaforoEjecucionConte").empty();
    titulo = '<div>\
                <label class="titulo">SEMÁFORO DE EJECUCIÓN DE GASTO - ' + año + '</label>\
                <label id="lblSemafTitEjec" class="titulo"></label>\
              </div>';
    titulo += '<br><div id="divLeyendaSemaf" class="leyendaSemaf"></div>';
    tabla = '<div style="overflow-x:auto; width: 100%;">\
                <table id="tablaPresuSemaforoEjec" class="display" cellspacing="0" width="100%"></table>\
             </div>';
    HTML = titulo + tabla;
    $("#divPresuSemaforoEjecucionConte").append(HTML);
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
    $('#tablaPresuSemaforoEjec').append('<img src="./resources/gifs/cargando.gif" style="display:block; margin:auto;"></img>');
    var muestra = [];
    var anchos = [];
    var muestraHead = [];
    var muestraBody = [];
    var muestraFoot = [];
    var ejecutora;
    var listSemaf;
    var mesSemaf;
    $.ajax({
        dataType: 'json',
        url: "./Presupuesto?tipo=11_1&ejec=" + ejec + "&año=" + año + "&estado=" + estado,
        success: function (response) {
            ejecutora = response.ejec;
            listSemaf = response.list;
            mesSemaf = response.mes;
            var tituloE = response.titulo;
            var titulodoc = response.titulo1;
            $('#lblSemafTitEjec').empty();
            $('#lblSemafTitEjec').append(tituloE);
            $('#divLeyendaSemaf').empty();
            var leyenda = '<div class="col-sm-4"><img src="./resources/images/semaforo_rojo.png">&nbsp;&nbsp;' + response.rojo + '</img></div>';
            leyenda += '<div class="col-sm-4"><img src="./resources/images/semaforo_naranja.png">&nbsp;&nbsp;' + response.naranja + '</img></div>';
            leyenda += '<div class="col-sm-4"><img src="./resources/images/semaforo_verde.png">&nbsp;&nbsp;' + response.verde + '</img></div>';
            $('#divLeyendaSemaf').append(leyenda);
            var leyenda1 = response.rojo;
            var leyenda2 = response.naranja;
            var leyenda3 = response.verde;
            $('#tablaPresuSemaforoEjec').empty();
            var cuerpo = '<thead id="tablaPresuSemaforoEjecHead"></thead>\
                          <tbody id="tablaPresuSemaforoEjecBody"></tbody>\
                          <tfoot id="tablaPresuSemaforoEjecFoot"></tfoot>';
            $("#tablaPresuSemaforoEjec").append(cuerpo);
            var head = '';
            head += '<tr>\
                     <th class="center">Ranking</th>';
            if (ejecutora === "00") {
                head += '<th class="center">Ejecutora</th>\
                         <th class="center">Nombre</th>';
            } else {
                head += '<th class="center">Meta</th>\
                         <th class="center">Finalidad</th>\
                         <th class="center">Centro de Costo</th>';
            }
            head += '<th class="center">PIM</th>\
                     <th class="center">Certificado</th>\
                     <th class="center">Devengado</th>\
                     <th class="center">Saldo por Devengar</th>\
                     <th class="center">Avance %</th>\
                     <th class="center">Semáforo</th>\
                     </tr>';
            $("#tablaPresuSemaforoEjecHead").append(head);
            var pimT, certT, devenT, estadoT, avanceT, img_estadoT;
            pimT = certT = devenT = avanceT = 0.00;
            $.each(response.list, function (index, value) {
                var cert, deve, saldo, avance, estado, img_estado, ceco_nombre;
                if (!$.trim(value.ceco_nombre)) {
                    ceco_nombre = "No Asignado";
                } else {
                    ceco_nombre = value.ceco_nombre;
                }
                if (!$.trim(value.certificado)) {
                    cert = 0.00;
                } else {
                    cert = value.certificado;
                    certT += value.certificado;
                }
                if (!$.trim(value.ejecucion)) {
                    deve = 0.00;
                    saldo = value.pim;
                    avance = 0.00;
                } else {
                    deve = value.ejecucion;
                    devenT += value.ejecucion;
                    saldo = value.pim - value.ejecucion;
                    if (value.pim === 0.00) {
                        avance = 0.00;
                    } else {
                        avance = (value.ejecucion / value.pim) * 100;
                    }
                }
                if (avance < (5 * response.mes)) {
                    estado = "rojo";
                }
                if (avance >= (5 * response.mes) && avance < (8 * response.mes)) {
                    estado = "naranja";
                }
                if (avance >= (8 * response.mes)) {
                    estado = "verde";
                }
                var nombre_ejec = (value.nombre).split("-");
                var body = '';
                body += '<tr>\
                         <td class="center">' + (index + 1) + '</td>';
                if (ejecutora === "00") {
                    body += '<td class="left">UE ' + value.ejecutora.trim() + '</td>\
                             <td class="left">' + nombre_ejec[1].trim() + ' (' + value.sec_ejec.trim() + ')</td>';
                } else {
                    body += '<td class="center">' + value.sec_func + '</td>\
                             <td class="left">' + value.nombre + '</td>\
                             <td class="left">' + ceco_nombre + '</td>';
                }
                body += '<td class="right">' + formatNumero(value.pim) + '</td>\
                         <td class="right">' + formatNumero(cert) + '</td>\
                         <td class="right">' + formatNumero(deve) + '</td>\
                         <td class="right">' + formatNumero(saldo) + '</td>\
                         <td class="center"><b>' + formatNumero(avance) + '</b></td>\
                         <td class="center">\
                            <img class="' + estado + '_img" src="./resources/images/semaforo_' + estado + '.png"/>\
                         </td>\
                         </tr>';
                $("#tablaPresuSemaforoEjecBody").append(body);
                pimT += value.pim;
            });
            if (pimT === 0.00) {
                avanceT = 0.00;
            } else {
                avanceT = (devenT / pimT) * 100;
            }
            if (avanceT < (5 * response.mes)) {
                estadoT = "rojo";
            }
            if (avanceT >= (5 * response.mes) && avanceT < (8 * response.mes)) {
                estadoT = "naranja";
            }
            if (avanceT >= (8 * response.mes)) {
                estadoT = "verde";
            }
            var foot = '';
            foot += '<tr class="total">';
            if (ejecutora === "00") {
                foot += '<td colspan="3" class="right"><b>' + tituloE + ' - TOTAL</b></td>';
            } else {
                foot += '<td colspan="4" class="right"><b>' + tituloE + ' - TOTAL</b></td>';
            }
            foot += '<td class="right"><b>' + formatNumero(pimT) + '</b></td>\
                     <td class="right"><b>' + formatNumero(certT) + '</b></td>\
                     <td class="right"><b>' + formatNumero(devenT) + '</b></td>\
                     <td class="right"><b>' + formatNumero(pimT - devenT) + '</b></td>\
                     <td class="center"><b>' + formatNumero(avanceT) + '</b></td>\
                     <td class="center"><img class="' + estadoT + '_img" src="./resources/images/semaforo_' + estadoT + '.png"></img></td>\
                     </tr>';
            $("#tablaPresuSemaforoEjecFoot").append(foot);

            $('#tablaPresuSemaforoEjec').dataTable({
                ordering: true,
                bPaginate: false,
                dom: 'Brt',
                buttons: [
                    {
                        extend: 'excel',
                        footer: true,
                        filename: 'semaforo_ejecucion_' + titulodoc + '_' + año,
                        title: 'SEMÁFORO DE EJECUCIÓN DE GASTO - ' + año,
                        messageTop: tituloE,
                        headTop1: '(ROJO) ' + leyenda1 + "  =||=  (NARANJA) " + leyenda2 + "  =||=  (VERDE) " + leyenda3,
                        exportOptions: {
                            orthogonal: 'sort',
                            columns: ':visible'
                        },
                        customize: function (xlsx) {
                            var sheet = xlsx.xl.worksheets['sheet1.xml'];
                            if (ejecutora === "00") {
                                var total = $('row c[r^="D"]', sheet).length;
                                $('row c[r^="D"]', sheet).each(function (i) {
                                    if (i > 0 && i < total - 1) {
                                        $(this).attr('s', '72');
                                    }
                                    if (i === total - 1) {
                                        $(this).attr('s', '75');
                                    }
                                });
                                $('row c[r^="E"]', sheet).each(function (i) {
                                    if (i > 0 && i < total - 1) {
                                        $(this).attr('s', '72');
                                    }
                                    if (i === total - 1) {
                                        $(this).attr('s', '75');
                                    }
                                });
                                $('row c[r^="F"]', sheet).each(function (i) {
                                    if (i > 0 && i < total - 1) {
                                        $(this).attr('s', '72');
                                    }
                                    if (i === total - 1) {
                                        $(this).attr('s', '75');
                                    }
                                });
                                $('row c[r^="G"]', sheet).each(function (i) {
                                    if (i > 0 && i < total - 1) {
                                        $(this).attr('s', '72');
                                    }
                                    if (i === total - 1) {
                                        $(this).attr('s', '75');
                                    }
                                });
                                $('row c[r^="H"]', sheet).each(function (i) {
                                    if (i > 0 && i < total - 1) {
                                        $(this).attr('s', '73');
                                    }
                                    if (i === total - 1) {
                                        $(this).attr('s', '76');
                                    }
                                });
                                $('row c[r^="I"]', sheet).each(function () {
                                    if ($('is t', this).text() === 'rojo') {
                                        $(this).attr('s', '77');
                                    }
                                    if ($('is t', this).text() === 'naranja') {
                                        $(this).attr('s', '78');
                                    }
                                    if ($('is t', this).text() === 'verde') {
                                        $(this).attr('s', '79');
                                    }
                                });
                            } else {
                                $('row c[r^="E"]', sheet).each(function (i) {
                                    if (i > 0 && i < total - 1) {
                                        $(this).attr('s', '72');
                                    }
                                    if (i === total - 1) {
                                        $(this).attr('s', '75');
                                    }
                                });
                                $('row c[r^="F"]', sheet).each(function (i) {
                                    if (i > 0 && i < total - 1) {
                                        $(this).attr('s', '72');
                                    }
                                    if (i === total - 1) {
                                        $(this).attr('s', '75');
                                    }
                                });
                                $('row c[r^="G"]', sheet).each(function (i) {
                                    if (i > 0 && i < total - 1) {
                                        $(this).attr('s', '72');
                                    }
                                    if (i === total - 1) {
                                        $(this).attr('s', '75');
                                    }
                                });
                                $('row c[r^="H"]', sheet).each(function (i) {
                                    if (i > 0 && i < total - 1) {
                                        $(this).attr('s', '72');
                                    }
                                    if (i === total - 1) {
                                        $(this).attr('s', '75');
                                    }
                                });
                                $('row c[r^="I"]', sheet).each(function (i) {
                                    if (i > 0 && i < total - 1) {
                                        $(this).attr('s', '73');
                                    }
                                    if (i === total - 1) {
                                        $(this).attr('s', '76');
                                    }
                                });
                            }
                        }
                    }
                ]
            });

            var btnPDF = '<button id="exportPDF" class="dt-button buttons-html5">\
                            <span>\
                                <img src="./templates/plugins/datatables/images/pdf.png" data-toggle="tooltip" data-placement="bottom" title="Exportar a PDF">\
                            </span>\
                          </button>';
            $("#tablaPresuSemaforoEjec_wrapper .dt-buttons").append(btnPDF);
            $("#tablaPresuSemaforoEjec_wrapper .dt-buttons").css("margin-bottom", "10px");

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

            $("#exportPDF").on('click', function () {
                muestra = [];
                anchos = [];
                muestraHead = [];
                muestraHead.push({text: 'Ranking', style: 'tablaHead', alignment: 'center'});
                anchos.push(25);
                if (ejecutora === "00") {
                    muestraHead.push({text: 'Ejecutora', style: 'tablaHead', alignment: 'center'});
                    muestraHead.push({text: 'Nombre', style: 'tablaHead', alignment: 'center'});
                    anchos.push(30);
                    anchos.push(100);
                } else {
                    muestraHead.push({text: 'Meta', style: 'tablaHead', alignment: 'center'});
                    muestraHead.push({text: 'Finalidad', style: 'tablaHead', alignment: 'center'});
                    muestraHead.push({text: 'Centro de Costo', style: 'tablaHead', alignment: 'center'});
                    anchos.push(25);
                    anchos.push(80);
                    anchos.push(80);
                }
                muestraHead.push({text: 'PIM', style: 'tablaHead', alignment: 'center'});
                muestraHead.push({text: 'Certificado', style: 'tablaHead', alignment: 'center'});
                muestraHead.push({text: 'Devengado', style: 'tablaHead', alignment: 'center'});
                muestraHead.push({text: 'Saldo por Devengar', style: 'tablaHead', alignment: 'center'});
                muestraHead.push({text: 'Avance %', style: 'tablaHead', alignment: 'center'});
                muestraHead.push({text: 'Estado', style: 'tablaHead', alignment: 'center'});
                muestra.push(muestraHead);
                anchos.push('*');
                anchos.push('*');
                anchos.push('*');
                anchos.push('*');
                anchos.push(30);
                anchos.push(20);
                $.each(listSemaf, function (index, value) {
                    muestraBody = [];
                    var cert, deve, saldo, avance, estado, img_estado, ceco_nombre;
                    if (!$.trim(value.ceco_nombre)) {
                        ceco_nombre = "No Asignado";
                    } else {
                        ceco_nombre = value.ceco_nombre;
                    }
                    if (!$.trim(value.certificado)) {
                        cert = 0.00;
                    } else {
                        cert = value.certificado;
                        certT += value.certificado;
                    }
                    if (!$.trim(value.ejecucion)) {
                        deve = 0.00;
                        saldo = value.pim;
                        avance = 0.00;
                    } else {
                        deve = value.ejecucion;
                        devenT += value.ejecucion;
                        saldo = value.pim - value.ejecucion;
                        if (value.pim === 0.00) {
                            avance = 0.00;
                        } else {
                            avance = (value.ejecucion / value.pim) * 100;
                        }
                    }
                    if (avance < (5 * mesSemaf)) {
                        img_estado = img_rojo;
                    }
                    if (avance >= (5 * mesSemaf) && avance < (8 * mesSemaf)) {
                        img_estado = img_naranja;
                    }
                    if (avance >= (8 * mesSemaf)) {
                        img_estado = img_verde;
                    }
                    var nombre_ejec = (value.nombre).split("-");
                    muestraBody.push({text: (index + 1), style: 'tablaBody', alignment: 'center'});
                    if (ejecutora === "00") {
                        muestraBody.push({text: 'UE ' + value.ejecutora.trim(), style: 'tablaBody', alignment: 'left'});
                        muestraBody.push({text: nombre_ejec[1].trim() + ' (' + value.sec_ejec.trim() + ')', style: 'tablaBody', alignment: 'left'});
                    } else {
                        muestraBody.push({text: value.sec_func, style: 'tablaBody', alignment: 'center'});
                        muestraBody.push({text: value.nombre, style: 'tablaBody', alignment: 'left'});
                        muestraBody.push({text: value.ceco_nombre, style: 'tablaBody', alignment: 'left'});
                    }
                    muestraBody.push({text: formatNumero(value.pim), style: 'tablaBody', alignment: 'right'});
                    muestraBody.push({text: formatNumero(cert), style: 'tablaBody', alignment: 'right'});
                    muestraBody.push({text: formatNumero(deve), style: 'tablaBody', alignment: 'right'});
                    muestraBody.push({text: formatNumero(saldo), style: 'tablaBody', alignment: 'right'});
                    muestraBody.push({text: formatNumero(avance), style: 'tablaBody', alignment: 'center'});
                    muestraBody.push({image: img_estado, style: 'tablaBody', width: 10, alignment: 'center'});
                    muestra.push(muestraBody);
                    pimT += value.pim;
                });
                muestraFoot = [];
                if (pimT === 0.00) {
                    avanceT = 0.00;
                } else {
                    avanceT = (devenT / pimT) * 100;
                }
                if (avanceT < (5 * mesSemaf)) {
                    img_estadoT = img_rojo;
                }
                if (avanceT >= (5 * mesSemaf) && avanceT < (8 * mesSemaf)) {
                    img_estadoT = img_naranja;
                }
                if (avanceT >= (8 * mesSemaf)) {
                    img_estadoT = img_verde;
                }
                if (ejecutora === "00") {
                    muestraFoot.push({text: 'TOTAL', style: 'tablaTotal', alignment: 'right', colSpan: 3});
                    muestraFoot.push("");
                    muestraFoot.push("");
                } else {
                    muestraFoot.push({text: 'TOTAL', style: 'tablaTotal', alignment: 'right', colSpan: 4});
                    muestraFoot.push("");
                    muestraFoot.push("");
                    muestraFoot.push("");
                }
                muestraFoot.push({text: formatNumero(pimT), style: 'tablaTotal', alignment: 'right'});
                muestraFoot.push({text: formatNumero(certT), style: 'tablaTotal', alignment: 'right'});
                muestraFoot.push({text: formatNumero(devenT), style: 'tablaTotal', alignment: 'right'});
                muestraFoot.push({text: formatNumero(pimT - devenT), style: 'tablaTotal', alignment: 'right'});
                muestraFoot.push({text: formatNumero(avanceT), style: 'tablaTotal', alignment: 'center'});
                muestraFoot.push({image: img_estadoT, style: 'tablaTotal', width: 10, alignment: 'center'});
                muestra.push(muestraFoot);

                var docDefinition = {
                    //pageOrientation: 'landscape',
                    info: {
                        title: 'semaforo_ejecucion_' + titulodoc + '_' + año
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
                                        {text: 'SEMÁFORO DE EJECUCIÓN DE GASTO - ' + año + '\n' + tituloE + '\n', alignment: 'center', style: 'titulo'}
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
    });
}