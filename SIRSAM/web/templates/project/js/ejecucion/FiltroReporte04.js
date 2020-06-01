// Reporte de Expedientes SIAF

function FiltroReporte04() {
    alert("funciona filtro05");
}

function llenarFiltroReporte04() {
    $("#divPresuFiltReporte").empty();
    filtro = '<div class="form-group row">\
                    <label for="listExpeEjecutora" class="col-sm-2 col-form-label">Elija Ejecutora :</label>\
                    <div class="col-sm-6">\
                        <select class="select-form" id="listExpeEjecutora" name="ejec"></select>\
                    </div>\
                    <label class="col-sm-1"></label>\
                    <label for="listExpeAño" class="col-sm-1 col-form-label">Elija Año :</label>\
                    <div class="col-sm-2">\
                        <select class="select-form" id="listExpeAño" name="anho"></select>\
                    </div>\
                </div>';
    filtro += '<div class="form-group row">\
                 <label for="inpFiltroNroExpe" class="col-sm-2 col-form-label">Nº de Expediente :</label>\
                 <div class="col-sm-2">\
                    <input type="text" class="form-control" id="inpFiltroNroExpe" maxlength="10" name="num_exped" onkeypress="return soloNumero(event)" placeholder="Expediente">\
                 </div>\
               </div>';
    filtro += '<div class="form-group">\
                   <label class="radio-inline"><input id="inptRuc" type="radio" name="provee" value="R" checked>RUC de Proveedor</label>\
                   <label class="radio-inline"><input id="inptNombre" type="radio" name="provee" value="N">Nombre de Proveedor</label>\
               </div>';
    filtro += '<div id="divFiltroProveRuc" class="form-group row">\
                 <label for="inpFiltroProveRuc" class="col-sm-2 col-form-label">RUC de Proveedor :</label>\
                 <div class="col-sm-3">\
                    <input type="text" class="form-control" id="inpFiltroProveRuc" maxlength="11" name="provee_ruc" onkeypress="return soloNumero(event)" placeholder="RUC">\
                 </div>\
               </div>';
    filtro += '<div id="divFiltroProveNombre" class="form-group row oculto">\
                 <label for="inpFiltroProveNombre" class="col-sm-2 col-form-label">Nombre de Proveedor :</label>\
                 <div class="col-sm-5">\
                    <input type="text" class="form-control" id="inpFiltroProveNombre" name="provee_nombre" placeholder="Apellidos y Nombres" style="text-transform:uppercase">\
                 </div>\
               </div>';
    botones = '<div class="form-row line_top20">\
                <label class="col-sm-2"></label>\
                <div class="col-auto">\
                <button type="submit" class="btn btn3d btn-danger btn-m">\
                <span class="glyphicon glyphicon-play spanBtn"></span>Generar\
                </button>\
                </div>\
                <div class="col-auto">\
                <button id="btnRepoPresu04" type="reset" value="Reset" class="btn btn3d btn-white btn-m">\
                <span class="glyphicon glyphicon-erase spanBtn"></span>Limpiar\
                </button>\
                </div>\
                </div>';
    html = filtro + botones;
    $("#divPresuFiltReporte").append(html);
    limpiar();
}

function controlFiltroReporte04() {
    $('#listExpeEjecutora').empty();
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DataEjecutoras",
        success: function (response) {
            $.each(response.listEjecutoras, function (index, value) {
                var nombre_ejec = (value.nombre).split("-");
                obje = "<option value=" + value.sec_ejec + ">UE " + value.ejecutora + " - " + nombre_ejec[1].trim() + " (" + value.sec_ejec + ")</option>";
                $("#listExpeEjecutora").append(obje);
            });
            $('#listExpeEjecutora').prop('selectedIndex', 0);
            llenarAñoExpe($('#listExpeEjecutora').val());
        }
    });
    $("#inptRuc").change(function () {
        if (this.checked) {
            limpiarFiltroReporte04();
            $("#divFiltroProveRuc").removeClass("oculto");
            $("#divFiltroProveNombre").addClass("oculto");
        }
    });
    $("#inptNombre").change(function () {
        if (this.checked) {
            limpiarFiltroReporte04();
            $("#divFiltroProveRuc").addClass("oculto");
            $("#divFiltroProveNombre").removeClass("oculto");
        }
    });
    $("#btnRepoPresu04").click(function () {
        $("#divPresuTabla").empty();
        $("#divPresuTabla").addClass("oculto");
        $("#lblPresuFiltGrafico").addClass("oculto");
        $("#divPresuFiltGrafico").empty();
        $("#divPresuFiltGrafico").addClass("oculto");
        $("#divPresuGrafica").empty();
        $("#divPresuGrafica").addClass("oculto");
    });
}

function limpiarFiltroReporte04() {
    $("#inpFiltroProveRuc").val("");
    $("#inpFiltroProveNombre").val("");
}

function validarFiltroReporte04() {
    var msg;
    if ($("#inpFiltroProveRuc").val() !== "") {
        if ($("#inptRuc:checked").val() === "R") {
            if ($("#inpFiltroProveRuc").val().length < 11) {
                msg = "Debe ingresar un RUC Valido de 11 dígitos";
                return(msg);
            }
        }
    }
    msg = "OK";
    return(msg);
}


function llenarTablaReporte04(response) {    
    var cuerpo = '<div style="margin-bottom: 15px;">\
                    <table id="tablaExpeSIAF" class="display" cellspacing="0" width="80%">\
                        <thead id="tablaExpeSIAFHead"></thead>\
                        <tbody id="tablaExpeSIAFBody"></tbody>\
                    </table>\
                  </div>\
                  <div id="divDetalleExpeSIAF"></div>';
    $("#divPresuTabla").append(cuerpo);
    var head = "<tr>\
                    <th>Expediente</th>\
                    <th>Rubro de Financiamiento</th>\
                    <th>Tipo de Recurso</th>\
                </tr>";
    $("#tablaExpeSIAFHead").append(head);
    $.each(response.listEX, function (indexEX, valueEX) {
        var body = "<tr>\
                        <td class='center'>\
                            <a id='a_" + valueEX.expediente + "' class='td_proyecto'>" + valueEX.expediente + "</a>\
                        </td>\
                        <td class='center'>" + valueEX.fuente_financ + " - " + valueEX.nombre_fuente_financ + "</td>\
                        <td class='center'>" + valueEX.tipo_recurso + " - " + valueEX.nombre_tipo_recurso + "</td>\
                    </tr>";
        $("#tablaExpeSIAFBody").append(body);
        $("#a_" + valueEX.expediente).click(function () {
            llenarDetalleExpeSIAF04(response.año, response.ejec, valueEX.expediente, valueEX.fuente_financ + " - " + valueEX.nombre_fuente_financ, response.tituloPDF);
        });
    });
    $('#tablaExpeSIAF').dataTable({
        paging: true,
        ordering: false,
        dom: '<"centrar-div-tabla"lf>iprtip'
    });
}

function llenarDetalleExpeSIAF04(año, ejec, expe, rubro, titulo) {
    $("#divDetalleExpeSIAF").empty();
    var generalE = '<div class="btn-proy-busqueda">\
                        <a id="aExportExpe_' + expe + '">\
                           <img src="./templates/plugins/datatables/images/pdf.png" alt="Exportar a PDF" title="Exportar a PDF">\
                        </a>\
                   </div>\
                   <div class="margen-reportes-presu">\
                        <div class="form-group row">\
                           <label class="col-sm-2"></label>\
                           <label class="col-sm-3 col-form-label ficha-sombreado1">NUMERO DE EXPEDIENTE :</label>\
                           <label class="col-sm-3 col-form-label ficha-sombreado2">' + expe + '</label>\
                           <label class="col-sm-4"></label>\
                        </div>\
                        <div class="form-group row">\
                           <label class="col-sm-2"></label>\
                           <label class="col-sm-3 col-form-label ficha-sombreado1">RUBRO DE FINANCIAMIENTO :</label>\
                           <label class="col-sm-5 col-form-label ficha-sombreado2">' + rubro + '</label>\
                           <label class="col-sm-2"></label>\
                        </div>\
                    </div>';
    $("#divDetalleExpeSIAF").append(generalE);
    var muestra1 = [];
    var muestraTG = [];
    var muestra2G = [];
    var muestraTI = [];
    var muestra2I = [];
    var tablaE = '<div style="margin-top: 15px;">\
                    <table id="tablaExpeSIAFFases_' + expe + '" class="display" cellspacing="0" width="100%">\
                        <label>RESUMEN</label>\
                        <thead id="tablaExpeSIAFFasesHead_' + expe + '"></thead>\
                        <tbody id="tablaExpeSIAFFasesBody_' + expe + '"></tbody>\
                    </table>\
                    <br>\
                 </div>';
    $("#divDetalleExpeSIAF").append(tablaE);
    var muestraHead1 = [];
    var headF = "<tr>\
                    <th>Ciclo</th>\
                    <th>Fase</th>\
                    <th>Certificación</th>\
                    <th>Documento</th>\
                    <th>Numero</th>\
                    <th>Fecha</th>\
                    <th>Monto</th>\
                    <th>RUC</th>\
                    <th>Nombre</th>\
                    <th>Banco</th>\
                    <th>Cuenta</th>\
                    <th>Año Cta</th>\
                    <th>Estado</th>\
                </tr>";
    $("#tablaExpeSIAFFasesHead_" + expe).append(headF);
    muestraHead1.push({text: 'Ciclo', style: 'tablaHead', alignment: 'center'});
    muestraHead1.push({text: 'Fase', style: 'tablaHead', alignment: 'center'});
    muestraHead1.push({text: 'Certificación', style: 'tablaHead', alignment: 'center'});
    muestraHead1.push({text: 'Documento', style: 'tablaHead', alignment: 'center'});
    muestraHead1.push({text: 'Fecha', style: 'tablaHead', alignment: 'center'});
    muestraHead1.push({text: 'Monto', style: 'tablaHead', alignment: 'center'});
    muestraHead1.push({text: 'RUC', style: 'tablaHead', alignment: 'center'});
    muestraHead1.push({text: 'Nombre', style: 'tablaHead', alignment: 'center'});
    muestraHead1.push({text: 'Estado', style: 'tablaHead', alignment: 'center'});
    muestra1.push(muestraHead1);
    $.ajax({
        dataType: 'json',
        url: "./GsonData?url=DetalleExpeSIAFFase&año=" + año + "&ejec=" + ejec + "&expe=" + expe,
        success: function (responseEXF) {
            var bodyF = "";
            $.each(responseEXF.listEXF, function (indexEXF, valueEXF) {
                var numero, ruc, nombre, banco, cta, ano;
                if (!$.trim(valueEXF.numero)) {
                    numero = "";
                } else {
                    numero = valueEXF.numero;
                }
                if (!$.trim(valueEXF.ruc)) {
                    ruc = "";
                } else {
                    ruc = valueEXF.ruc;
                }
                if (!$.trim(valueEXF.nombre)) {
                    nombre = "";
                } else {
                    nombre = valueEXF.nombre;
                }
                if (!$.trim(valueEXF.banco)) {
                    banco = "";
                } else {
                    banco = valueEXF.banco;
                }
                if (!$.trim(valueEXF.cta)) {
                    cta = "";
                } else {
                    cta = valueEXF.cta;
                }
                if (!$.trim(valueEXF.ano)) {
                    ano = "";
                } else {
                    ano = valueEXF.ano;
                }
                var muestraBody1 = [];
                bodyF += "<tr>\
                            <td class='left'>" + valueEXF.ciclo + "</td>\
                            <td class='left'>" + valueEXF.fase + "</td>\
                            <td class='left'>" + valueEXF.certificacion + "</td>\
                            <td class='left'>" + valueEXF.nombre_documento + "</td>\
                            <td class='left'>" + numero + "</td>\
                            <td class='left'>" + valueEXF.fecha_doc + "</td>\
                            <td class='right'>" + formatNumero(valueEXF.monto) + "</td>\
                            <td class='left'>" + ruc + "</td>\
                            <td class='left'>" + nombre + "</td>\
                            <td class='left'>" + banco + "</td>\
                            <td class='left'>" + cta + "</td>\
                            <td class='left'>" + ano + "</td>\
                            <td class='center'>" + valueEXF.estado_envio + "</td>\
                          </tr>";
                muestraBody1.push({text: valueEXF.ciclo, style: 'tablaBody', alignment: 'left'});
                muestraBody1.push({text: valueEXF.fase, style: 'tablaBody', alignment: 'left'});
                muestraBody1.push({text: valueEXF.certificacion, style: 'tablaBody', alignment: 'center'});
                muestraBody1.push({text: valueEXF.nombre_documento + ' ' + numero, style: 'tablaBody', alignment: 'left'});
                muestraBody1.push({text: valueEXF.fecha_doc, style: 'tablaBody', alignment: 'center'});
                muestraBody1.push({text: formatNumero(valueEXF.monto), style: 'tablaBody', alignment: 'right'});
                muestraBody1.push({text: ruc, style: 'tablaBody', alignment: 'center'});
                muestraBody1.push({text: nombre, style: 'tablaBody', alignment: 'left'});
                muestraBody1.push({text: valueEXF.estado_envio, style: 'tablaBody', alignment: 'center'});
                muestra1.push(muestraBody1);
            });
            $("#tablaExpeSIAFFasesBody_" + responseEXF.expe).append(bodyF);
            $('#tablaExpeSIAFFases_' + responseEXF.expe).dataTable({
                paging: false,
                ordering: false,
                dom: 'rt'
            });
            var muestraHead2G = [];
            if (responseEXF.gasto === "0") {
                muestraTG.push({text: '', border: [false, false, false, false]});
                muestraHead2G.push({text: '', border: [false, false, false, false]});
                muestraHead2G.push({text: '', border: [false, false, false, false]});
                muestraHead2G.push({text: '', border: [false, false, false, false]});
                muestraHead2G.push({text: '', border: [false, false, false, false]});
                muestraHead2G.push({text: '', border: [false, false, false, false]});
                muestraHead2G.push({text: '', border: [false, false, false, false]});
                muestraHead2G.push({text: '', border: [false, false, false, false]});
                muestraHead2G.push({text: '', border: [false, false, false, false]});
                muestra2G.push(muestraHead2G);
            }
            if (responseEXF.gasto === "1") {
                var tablaEG = '<div style="margin-top: 10px; float: left;" width="60%">\
                                <table id="tablaExpeSIAFFasesGasto_' + responseEXF.expe + '" class="display" cellspacing="0" width="100%">\
                                    <label>DETALLE DEL GASTO</label>\
                                    <thead id="tablaExpeSIAFFasesGastoHead_' + responseEXF.expe + '"></thead>\
                                    <tbody id="tablaExpeSIAFFasesGastoBody_' + responseEXF.expe + '"></tbody>\
                                </table>\
                                <br>\
                               </div>';
                $("#divDetalleExpeSIAF").append(tablaEG);
                var headFG = "<tr>\
                                <th>Ciclo</th>\
                                <th>Fase</th>\
                                <th>Secuencia</th>\
                                <th>Meta</th>\
                                <th>Específica</th>\
                                <th>Descripción</th>\
                                <th>Monto</th>\
                              </tr>";
                $("#tablaExpeSIAFFasesGastoHead_" + responseEXF.expe).append(headFG);
                muestraTG.push({text: 'DETALLE DEL GASTO', alignment: 'center', style: 'titulo'});
                muestraHead2G.push({text: 'Ciclo', style: 'tablaHead', alignment: 'center'});
                muestraHead2G.push({text: 'Fase', style: 'tablaHead', alignment: 'center'});
                muestraHead2G.push({text: 'Secuencia', style: 'tablaHead', alignment: 'center'});
                muestraHead2G.push({text: 'Meta', style: 'tablaHead', alignment: 'center'});
                muestraHead2G.push({text: 'Especifica', style: 'tablaHead', alignment: 'center'});
                muestraHead2G.push({text: 'Descripción', style: 'tablaHead', alignment: 'center'});
                muestraHead2G.push({text: 'Monto', style: 'tablaHead', alignment: 'center'});
                muestraHead2G.push({text: '', border: [false, false, false, false]});
                muestra2G.push(muestraHead2G);
                var bodyFG = "";
                $.each(responseEXF.listEXFG, function (indexEXFG, valueEXFG) {
                    var muestraBody2G = [];
                    bodyFG += "<tr>\
                                <td class='left'>" + valueEXFG.ciclo + "</td>\
                                <td class='left'>" + valueEXFG.fase + "</td>\
                                <td class='left'>" + valueEXFG.secuencia + "</td>\
                                <td class='left'>" + valueEXFG.sec_func + "</td>\
                                <td class='left'>" + valueEXFG.clasificador + "</td>\
                                <td class='left'>" + valueEXFG.descripcion + "</td>\
                                <td class='right'>" + formatNumero(valueEXFG.monto) + "</td>\
                              </tr>";
                    muestraBody2G.push({text: valueEXFG.ciclo, style: 'tablaBody', alignment: 'left'});
                    muestraBody2G.push({text: valueEXFG.fase, style: 'tablaBody', alignment: 'left'});
                    muestraBody2G.push({text: valueEXFG.secuencia, style: 'tablaBody', alignment: 'center'});
                    muestraBody2G.push({text: valueEXFG.sec_func, style: 'tablaBody', alignment: 'center'});
                    muestraBody2G.push({text: valueEXFG.clasificador, style: 'tablaBody', alignment: 'center'});
                    muestraBody2G.push({text: valueEXFG.descripcion, style: 'tablaBody', alignment: 'left'});
                    muestraBody2G.push({text: formatNumero(valueEXFG.monto), style: 'tablaBody', alignment: 'right'});
                    muestraBody2G.push({text: '', border: [false, false, false, false]});
                    muestra2G.push(muestraBody2G);
                });
                $("#tablaExpeSIAFFasesGastoBody_" + responseEXF.expe).append(bodyFG);
                $('#tablaExpeSIAFFasesGasto_' + responseEXF.expe).dataTable({
                    paging: false,
                    ordering: false,
                    dom: 'rt'
                });
            }
            var muestraHead2I = [];
            if (responseEXF.ingreso === "0") {
                muestraTI.push({text: '', border: [false, false, false, false]});
                muestraHead2I.push({text: '', border: [false, false, false, false]});
                muestraHead2I.push({text: '', border: [false, false, false, false]});
                muestraHead2I.push({text: '', border: [false, false, false, false]});
                muestraHead2I.push({text: '', border: [false, false, false, false]});
                muestraHead2I.push({text: '', border: [false, false, false, false]});
                muestraHead2I.push({text: '', border: [false, false, false, false]});
                muestra2I.push(muestraHead2I);
            }
            if (responseEXF.ingreso === "1") {
                var tablaEI = '<div style="margin-top: 10px; float: right;" width="40%">\
                                <table id="tablaExpeSIAFFasesIngreso_' + responseEXF.expe + '" class="display" cellspacing="0" width="100%">\
                                    <label>DETALLE DEL INGRESO</label>\
                                    <thead id="tablaExpeSIAFFasesIngresoHead_' + responseEXF.expe + '"></thead>\
                                    <tbody id="tablaExpeSIAFFasesIngresoBody_' + responseEXF.expe + '"></tbody>\
                                </table>\
                                <br>\
                               </div>';
                $("#divDetalleExpeSIAF").append(tablaEI);
                var headFI = "<tr>\
                                <th>Ciclo</th>\
                                <th>Fase</th>\
                                <th>Secuencia</th>\
                                <th>Específica</th>\
                                <th>Descripción</th>\
                                <th>Monto</th>\
                              </tr>";
                $("#tablaExpeSIAFFasesIngresoHead_" + responseEXF.expe).append(headFI);
                muestraTI.push({text: 'DETALLE DEL INGRESO', alignment: 'center', style: 'titulo'});
                muestraHead2I.push({text: 'Ciclo', style: 'tablaHead', alignment: 'center'});
                muestraHead2I.push({text: 'Fase', style: 'tablaHead', alignment: 'center'});
                muestraHead2I.push({text: 'Secuencia', style: 'tablaHead', alignment: 'center'});
                muestraHead2I.push({text: 'Especifica', style: 'tablaHead', alignment: 'center'});
                muestraHead2I.push({text: 'Descripción', style: 'tablaHead', alignment: 'center'});
                muestraHead2I.push({text: 'Monto', style: 'tablaHead', alignment: 'center'});
                muestra2I.push(muestraHead2I);
                var bodyFI = "";
                $.each(responseEXF.listEXFI, function (indexEXFI, valueEXFI) {
                    var muestraBody2I = [];
                    bodyFI += "<tr>\
                                <td class='left'>" + valueEXFI.ciclo + "</td>\
                                <td class='left'>" + valueEXFI.fase + "</td>\
                                <td class='left'>" + valueEXFI.secuencia + "</td>\
                                <td class='left'>" + valueEXFI.clasificador + "</td>\
                                <td class='left'>" + valueEXFI.descripcion + "</td>\
                                <td class='right'>" + formatNumero(valueEXFI.monto) + "</td>\
                               </tr>";
                    muestraBody2I.push({text: valueEXFI.ciclo, style: 'tablaBody', alignment: 'left'});
                    muestraBody2I.push({text: valueEXFI.fase, style: 'tablaBody', alignment: 'left'});
                    muestraBody2I.push({text: valueEXFI.secuencia, style: 'tablaBody', alignment: 'center'});
                    muestraBody2I.push({text: valueEXFI.clasificador, style: 'tablaBody', alignment: 'center'});
                    muestraBody2I.push({text: valueEXFI.descripcion, style: 'tablaBody', alignment: 'left'});
                    muestraBody2I.push({text: formatNumero(valueEXFI.monto), style: 'tablaBody', alignment: 'right'});
                    muestra2I.push(muestraBody2I);
                });
                $("#tablaExpeSIAFFasesIngresoBody_" + responseEXF.expe).append(bodyFI);
                $('#tablaExpeSIAFFasesIngreso_' + responseEXF.expe).dataTable({
                    paging: false,
                    ordering: false,
                    dom: 'rt'
                });
            }
        }
    });
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
    $("#aExportExpe_" + expe).on('click', function () {
        var docDefinition = {
            //pageOrientation: 'landscape',
            info: {
                title: 'expediente_siaf_' + expe
            },
            pageMargins: [20, 60, 20, 40],
            header: {
                margin: 10,
                table: {
                    widths: [15, '*', '*', 15],
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
                                {text: 'EXPEDIENTE SIAF Nº ' + expe + ' - ' + año + '\n' + titulo, alignment: 'center', style: 'titulo'}
                            ]
                        ]
                    },
                    layout: {
                        hLineColor: 'white',
                        vLineColor: 'white'
                    }
                },
                {text: '\n'},
                {
                    table: {
                        widths: [120, 90, 80, '*'],
                        body: [
                            [
                                "",
                                {text: 'NUMERO DE EXPEDIENTE :', alignment: 'left', style: 'sombreado1'},
                                {text: expe, alignment: 'left', style: 'sombreado2'},
                                ""
                            ]
                        ]
                    },
                    layout: {
                        hLineColor: 'white',
                        vLineColor: 'white'
                    }
                },
                {text: '\n'},
                {
                    table: {
                        widths: [120, 90, 150, '*'],
                        body: [
                            [
                                "",
                                {text: 'RUBRO DE FINANCIAMIENTO :', alignment: 'left', style: 'sombreado1'},
                                {text: rubro, alignment: 'left', style: 'sombreado2'},
                                ""
                            ]
                        ]
                    },
                    layout: {
                        hLineColor: 'white',
                        vLineColor: 'white'
                    }
                },
                {text: '\n'},
                {
                    table: {
                        widths: [25, 32, 32, '*', 30, 35, 38, '*', 20],
                        body: muestra1
                    },
                    layout: {
                        hLineColor: '#ECECEC',
                        vLineColor: '#ECECEC'
                    }
                },
                {text: '\n'},
                {
                    table: {
                        widths: [300, '*'],
                        body: [
                            [
                                [
                                    muestraTG,
                                    {
                                        table: {
                                            widths: [20, 30, 25, 15, 28, '*', 25, 3],
                                            body: muestra2G
                                        },
                                        layout: {
                                            hLineColor: '#ECECEC',
                                            vLineColor: '#ECECEC'
                                        }
                                    }
                                ],
                                [
                                    muestraTI,
                                    {
                                        table: {
                                            widths: [20, 30, 25, 28, '*', 25],
                                            body: muestra2I
                                        },
                                        layout: {
                                            hLineColor: '#ECECEC',
                                            vLineColor: '#ECECEC'
                                        }
                                    }
                                ]
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
                    fontSize: 7,
                    bold: true
                },
                sombreado1: {
                    fillColor: '#334A74',
                    color: 'whitesmoke',
                    fontSize: 6,
                    bold: false
                },
                sombreado2: {
                    fillColor: 'whitesmoke',
                    color: '#334A74',
                    fontSize: 6,
                    bold: false
                },
                tituloU: {
                    fontSize: 7,
                    bold: true,
                    color: '#334A74',
                    decoration: 'underline'
                },
                subtitulo: {
                    fontSize: 7
                },
                tablaHead: {
                    color: 'white',
                    fillColor: '#426993',
                    fontSize: 5,
                    bold: true
                },
                tablaBody: {
                    fontSize: 5
                },
                subHeader: {
                    color: 'white',
                    fillColor: '#587BA0',
                    fontSize: 5,
                    bold: true
                },
                subFooter: {
                    fillColor: '#D2DBE5',
                    fontSize: 5
                },
                tablaTotal: {
                    fillColor: '#F6F6F6',
                    fontSize: 5,
                    bold: true
                },
                pie: {
                    fontSize: 5
                }
            }
        };
        pdfMake.createPdf(docDefinition).open();
    });
}