// Reporte de Recaudación de Ingresos Histórico

function FiltroReporte06() {
    alert("funciona filtro06");
}

function llenarFiltroReporte06() {
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
            <input type="checkbox" class="custom-control-input" name="marco_todo" checked>\
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
            <input type="checkbox" class="custom-control-input" name="marco" value="2" checked>\
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
    botones = '<div class="form-row line_top20">\
                <label class="col-sm-2"></label>\
                <div class="col-auto">\
                <button type="submit" class="btn btn3d btn-danger btn-m">\
                <span class="glyphicon glyphicon-play spanBtn"></span>Generar\
                </button>\
                </div>\
                <div class="col-auto">\
                <button id="btnRepoPresu06" type="reset" value="Reset" class="btn btn3d btn-white btn-m">\
                <span class="glyphicon glyphicon-erase spanBtn"></span>Limpiar\
                </button>\
                </div>\
                </div>';
    html = ejecutora + año + marco + botones;
    $("#divPresuFiltReporte").append(html);
    limpiar();
}

function controlFiltroReporte06() {
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
            llenarAñosIngreso($('#listPresuEjecutora').val());
        }
    });
    $("#listPresuEjecutora").bind("change", function () {
        llenarAñosIngreso($('#listPresuEjecutora').val());
    });
    cambiaMarco();
    $("#btnRepoPresu06").click(function () {
        $("#divPresuTabla").empty();
        $("#divPresuTabla").addClass("oculto");
        $("#lblPresuFiltGrafico").addClass("oculto");
        $("#divPresuFiltGrafico").empty();
        $("#divPresuFiltGrafico").addClass("oculto");
        $("#divPresuGrafica").empty();
        $("#divPresuGrafica").addClass("oculto");
    });
}

function validarFiltroReporte06() {
    var countMarco = 0;
    var msg;
    $("input[name=marco]").each(function () {
        if (this.checked) {
            countMarco++;
        }
    });
    if (countMarco === 0) {
        msg = "Debe seleccionar al menos un Marco Presupuestal";
        return(msg);
    }
    msg = "OK";
    return(msg);
}

function llenarTablaReporte06(response) {
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
                <th>PIM</th>\
                <th>Recaudado</th>\
            </tr>";
    $("#tablaPresuHead").append(head);
    muestra.push([
        {text: 'Año', style: 'tablaHead', alignment: 'center'},
        {text: 'PIA', style: 'tablaHead', alignment: 'center'},
        {text: 'Modificaciones', style: 'tablaHead', alignment: 'center'},
        {text: 'PIM', style: 'tablaHead', alignment: 'center'},
        {text: 'Recaudado', style: 'tablaHead', alignment: 'center'}
    ]);
    var count = 0;
    $.each(response.list, function (index, value) {
        count++;
        body = "<tr>\
                    <td class='center'>" + value.ano_eje + "</td>\
                    <td class='right'>" + formatNumero(value.pia) + "</td>\
                    <td class='right'>" + formatNumero(value.modificacion) + "</td>\
                    <td class='right'>" + formatNumero(value.pim) + "</td>\
                    <td class='right'>" + formatNumero(value.recaudado) + "</td>\
                </tr>";
        $("#tablaPresuBody").append(body);
        muestra.push([
            {text: value.ano_eje, style: 'tablaBody', alignment: 'center'},
            {text: formatNumero(value.pia), style: 'tablaBody', alignment: 'right'},
            {text: formatNumero(value.modificacion), style: 'tablaBody', alignment: 'right'},
            {text: formatNumero(value.pim), style: 'tablaBody', alignment: 'right'},
            {text: formatNumero(value.recaudado), style: 'tablaBody', alignment: 'right'}
        ]);
    });
    var columnasIni = "[";
    var countMarco = 0;
    var columnasMarco = "";
    $("input[name=marco]").each(function () {
        if (this.checked === false) {
            countMarco++;
            columnasMarco += this.value + ", ";
        }
    });
    var columnasFin = "]";
    if (countMarco !== 0) {
        columnasMarco = columnasMarco.substring(0, columnasMarco.length - 2);
    }
    var columnas = columnasIni + columnasMarco + columnasFin;
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
                collectionLayout: 'fixed two-column'
            },
            {
                extend: 'excel',
                filename: 'recaudacion_ingreso_' + response.ejec + '_historico',
                title: 'RECAUDACIÓN DE INGRESO HISTÓRICO',
                messageTop: response.tituloPDF,
                exportOptions: {
                    orthogonal: 'sort',
                    columns: ':visible'
                },
                customize: function (xlsx) {
                    var sheet = xlsx.xl.worksheets['sheet1.xml'];
                    for (var k = 1; k < 5; k++) {
                        var total = $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).length;
                        $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).each(function (i) {
                            if (i > 0 && i < total) {
                                $(this).attr('s', '72');
                            }
                        });
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
    llenarFiltroGrafico06();
    $("#divPresuGrafica").removeClass("oculto");
    llenarGrafico06("./Presupuesto?tipo=06&graph=true&ejec=" + response.ejec + "&desde=" + response.desde + "&hasta=" + response.hasta + "&ancho=1000&alto=500&font=10&bar=0.10&pos=in&pia=no&pim=no");
    cambiaFiltroGrafico06(response.ejec, response.desde, response.hasta);

    ///////////////// Exportar a PDF ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   

    var imageUrl_grsm = './resources/images/logo_grsm.png';
    var imageUrl_system = './resources/images/logo_sirsm.png';
    var img6, img_grsm, img_system;
    convertImgToDataURLviaCanvas(imageUrl_grsm, function (base64Img) {
        img_grsm = base64Img;
    });
    convertImgToDataURLviaCanvas(imageUrl_system, function (base64Img) {
        img_system = base64Img;
    });
    var newDate = new Date();
    var tiempo = newDate.getDate() + "/" + newDate.getMonth() + "/" + newDate.getFullYear() + "  " + newDate.getHours() + ":" + newDate.getMinutes();

    $("#exportPDF").hover(function () {
        var imageUrl6 = document.getElementById("imgPresuGrafica06").src + "&pdf=si";
        convertImgToDataURLviaCanvas(imageUrl6, function (base64Img) {
            img6 = base64Img;
        });
    });

    $("#exportPDF").on('click', function () {
        var docDefinition = {
            info: {
                title: 'recaudacion_ingreso_' + response.ejec + '_historico'
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
                                {text: 'RECAUDACIÓN DE INGRESO HISTÓRICO\n' + response.tituloPDF + '\n', alignment: 'center', style: 'titulo'}
                            ]
                        ]
                    },
                    layout: {
                        hLineColor: 'white',
                        vLineColor: 'white'
                    }
                },
                {
                    text: '\n\nTabla Resumen de Recaudación', alignment: 'left', style: 'subtitulo'
                },
                {
                    text: '\n'
                },
                {
                    table: {
                        widths: [30, '*', '*', '*', '*', '*'],
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
                                {text: 'Gráfica de Recaudación', alignment: 'left', style: 'subtitulo'}
                            ],
                            [
                                {image: img6, fit: [520, 250], alignment: 'left'}
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

function llenarFiltroGrafico06() {
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
    $("#divPresuFiltGrafico").append(marco);
}

function cambiaFiltroGrafico06(ejec, desde, hasta) {

    $("input[name=piag]").change(function () {
        var fase;
        $("input[name=faseg]").each(function () {
            if (this.checked) {
                fase = this.value;
            }
        });
        if (this.checked) {
            if ($("input[name=pimg]").is(":checked") === true) {
                llenarGrafico06("./Presupuesto?tipo=06&graph=true&ejec=" + ejec + "&desde=" + desde + "&hasta=" + hasta + "&ancho=1000&alto=550&font=10&bar=0.30&pos=in&pia=si&pim=si");
            }
            if ($("input[name=pimg]").is(":checked") === false) {
                llenarGrafico06("./Presupuesto?tipo=06&graph=true&ejec=" + ejec + "&desde=" + desde + "&hasta=" + hasta + "&ancho=1000&alto=550&font=10&bar=0.30&pos=in&pia=si&pim=no");
            }
        } else {
            if ($("input[name=pimg]").is(":checked") === true) {
                llenarGrafico06("./Presupuesto?tipo=06&graph=true&ejec=" + ejec + "&desde=" + desde + "&hasta=" + hasta + "&ancho=1000&alto=550&font=10&bar=0.30&pos=in&pia=no&pim=si");
            }
            if ($("input[name=pimg]").is(":checked") === false) {
                llenarGrafico06("./Presupuesto?tipo=06&graph=true&ejec=" + ejec + "&desde=" + desde + "&hasta=" + hasta + "&ancho=1000&alto=550&font=10&bar=0.10&pos=in&pia=no&pim=no");
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
                llenarGrafico06("./Presupuesto?tipo=06&graph=true&ejec=" + ejec + "&desde=" + desde + "&hasta=" + hasta + "&ancho=1000&alto=550&font=10&bar=0.30&pos=in&pia=si&pim=si");
            }
            if ($("input[name=piag]").is(":checked") === false) {
                llenarGrafico06("./Presupuesto?tipo=06&graph=true&ejec=" + ejec + "&desde=" + desde + "&hasta=" + hasta + "&ancho=1000&alto=550&font=10&bar=0.30&pos=in&pia=no&pim=si");
            }
        } else {
            if ($("input[name=piag]").is(":checked") === true) {
                llenarGrafico06("./Presupuesto?tipo=06&graph=true&ejec=" + ejec + "&desde=" + desde + "&hasta=" + hasta + "&ancho=1000&alto=550&font=10&bar=0.30&pos=in&pia=si&pim=no");
            }
            if ($("input[name=piag]").is(":checked") === false) {
                llenarGrafico06("./Presupuesto?tipo=06&graph=true&ejec=" + ejec + "&desde=" + desde + "&hasta=" + hasta + "&ancho=1000&alto=550&font=10&bar=0.10&pos=in&pia=no&pim=no");
            }
        }
    });

}

function llenarGrafico06(src) {
    $("#divPresuGrafica").empty();
    var img = '<img id="imgPresuGrafica06" src="' + src + '"/>';
    $("#divPresuGrafica").append(img);
}