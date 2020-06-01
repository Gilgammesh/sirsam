function proy_ficha_reporte_alert() {
    alert("funciona Ficha de Reporte y Seguimiento de Proyecto");
}

function llenar_proy_ficha_reporte(selectProy, siaf) {

    $("#divContenidoMenu").empty();
    var ficha_proy = '<section id="section_proyectos" class="background_sirsam_">\
                        <div class="menu_indice">\
                            <div class ="container">\
                                <ol class="breadcrumb">\
                                    <li>\
                                        <a>\
                                            <i class="choose-icon ion-cube" style="color: black; font-size: 15px;"></i>  \
                                            Inversión Pública\
                                        </a>\
                                    </li>\
                                    <li id="liTipoInverMenu">\
                                        <i class="fa fa-list-alt"></i> Ficha de Reporte - Proyecto ' + siaf + '\
                                    </li>\
                                </ol>\
                            </div>\
                        </div>\
                        <br>\
                        <div class="container">\
                            <a id="aReturnRegInfoProyecto" style="cursor: pointer;">\
                               <div class="naranja_secun boton-superior1 pad15" style="cursor: pointer;">\
                                  <span class="glyphicon glyphicon-backward"></span> REGRESAR\
                               </div>\
                            </a>\
                            <div id="divProyFichaReporte" class="filtro_report naranja_secun">\
                                <div>\
                                   <label class="titulo">FICHA DE REPORTE Y SEGUIMIENTO DE EJECUCIÓN</label>\
                                </div></br>\
                                <div class="pad15">\
                                    <div class="form-group row">\
                                      <label class="col-sm-2 col-form-label ficha-sombreado1">CODIGO SIAF :</label>\
                                      <label id="lblProyFichaSiaf" class="col-sm-3 col-form-label ficha-sombreado2"></label>\
                                      <label class="col-sm-2"></label>\
                                      <label class="col-sm-2 col-form-label ficha-sombreado1">CODIGO SNIP :</label>\
                                      <label id="lblProyFichaSnip" class="col-sm-3 col-form-label ficha-sombreado2"></label>\
                                    </div>\
                                    <div class="form-group row">\
                                      <label class="col-sm-2 col-form-label ficha-sombreado1">NOMBRE PROYECTO :</label>\
                                      <label id="lblProyFichaNombre" class="col-sm-10 col-form-label ficha-sombreado2"></label>\
                                    </div>\
                                </div>\
                                <ul class="nav nav-tabs" role="tablist">\
                                  <li class="nav-item active">\
                                    <a class="nav-link active show center" data-toggle="tab" href="#divProyFichaRepInfoGeneral" role="tab" aria-selected="true">\
                                      <span class="hidden-sm-up"><i class="ti-window"></i></span>\
                                      <span class="hidden-xs-down">INFORMACIÓN<br/>GENERAL</span>\
                                    </a>\
                                  </li>\
                                  <li class="nav-item">\
                                    <a class="nav-link center" data-toggle="tab" href="#divProyFichaRepEstudioDef" role="tab" aria-selected="false">\
                                      <span class="hidden-sm-up"><i class="ti-file"></i></span>\
                                      <span class="hidden-xs-down">ESTUDIO<br/>DEFINITIVO</span>\
                                    </a>\
                                  </li>\
                                  <li class="nav-item">\
                                    <a class="nav-link center" data-toggle="tab" href="#divProyFichaRepSupervObra" role="tab" aria-selected="false">\
                                      <span class="hidden-sm-up"><i class="ti-eye"></i></span>\
                                      <span class="hidden-xs-down">SUPERVISIÓN<br/>DE OBRA</span>\
                                    </a>\
                                  </li>\
                                  <li class="nav-item">\
                                    <a class="nav-link center" data-toggle="tab" href="#divProyFichaRepEjecuObra" role="tab" aria-selected="false">\
                                      <span class="hidden-sm-up"><i class="ti-bag"></i></span>\
                                      <span class="hidden-xs-down">EJECUCIÓN<br/>DE OBRA</span>\
                                    </a>\
                                  </li>\
                                  <li class="nav-item">\
                                    <a class="nav-link center" data-toggle="tab" href="#divProyFichaRepAvanFisico" role="tab" aria-selected="false">\
                                      <span class="hidden-sm-up"><i class="ti-bar-chart"></i></span>\
                                      <span class="hidden-xs-down">AVANCE<br/>FÍSICO</span>\
                                    </a>\
                                  </li>\
                                  <li class="nav-item">\
                                    <a class="nav-link center" data-toggle="tab" href="#divProyFichaRepEjecFinanc" role="tab" aria-selected="false">\
                                      <span class="hidden-sm-up"><i class="ti-money"></i></span>\
                                      <span class="hidden-xs-down">EJECUCIÓN<br/>FINANCIERA</span>\
                                    </a>\
                                  </li>\
                                  <li class="nav-item">\
                                    <a class="nav-link center" data-toggle="tab" href="#divProyFichaRepContrata" role="tab" aria-selected="false">\
                                      <span class="hidden-sm-up"><i class="ti-notepad"></i></span>\
                                      <span class="hidden-xs-down">CONTRATACIONES<br/>&nbsp;</span>\
                                    </a>\
                                  </li>\
                                  <li class="nav-item">\
                                    <a class="nav-link center" data-toggle="tab" href="#divProyFichaRepUbiGeogra" role="tab" aria-selected="false">\
                                      <span class="hidden-sm-up"><i class="ti-pin"></i></span>\
                                      <span class="hidden-xs-down">UBICACIÓN<br/>GEOGRÁFICA</span>\
                                    </a>\
                                  </li>\
                                  <li class="nav-item">\
                                    <a class="nav-link center" data-toggle="tab" href="#divProyFichaRepGalFotos" role="tab" aria-selected="false">\
                                      <span class="hidden-sm-up"><i class="ti-image"></i></span>\
                                      <span class="hidden-xs-down">GALERÍA<br/>FOTOS</span>\
                                    </a>\
                                  </li>\
                                </ul>\
                                <div class="tab-content tabcontent-border">\
                                  <div class="tab-pane active" id="divProyFichaRepInfoGeneral" role="tabpanel"></div>\
                                  <div class="tab-pane" id="divProyFichaRepEstudioDef" role="tabpanel"></div>\
                                  <div class="tab-pane" id="divProyFichaRepSupervObra" role="tabpanel"></div>\
                                  <div class="tab-pane" id="divProyFichaRepEjecuObra" role="tabpanel"></div>\
                                  <div class="tab-pane" id="divProyFichaRepAvanFisico" role="tabpanel"></div>\
                                  <div class="tab-pane" id="divProyFichaRepEjecFinanc" role="tabpanel"></div>\
                                  <div class="tab-pane" id="divProyFichaRepContrata" role="tabpanel"></div>\
                                  <div class="tab-pane" id="divProyFichaRepUbiGeogra" role="tabpanel"></div>\
                                  <div class="tab-pane" id="divProyFichaRepGalFotos" role="tabpanel"></div>\
                                </div>\
                            </div>\
                        </div>\
                    </section>';
    $("#divContenidoMenu").append(ficha_proy);

    $("#aReturnRegInfoProyecto").on('click', function () {
        llenar_menu_proyectos(selectProy);
    });

    $("#lblProyFichaSiaf").empty();
    $("#lblProyFichaSnip").empty();
    $("#lblProyFichaNombre").empty();
    $.ajax({
        dataType: 'json',
        url: "./Proyectos?tipo=informa_general&codSiaf=" + siaf,
        success: function (response) {
            $("#lblProyFichaSiaf").append(response.siaf);
            $("#lblProyFichaSnip").append(response.snip);
            $("#lblProyFichaNombre").append(response.nombre);
        }
    });
    llenar_proy_ficha_info_general(siaf);
    llenar_proy_ficha_est_definitivo(siaf);
    llenar_proy_ficha_supervision(siaf);
    llenar_proy_ficha_ejecucion(siaf);
    llenar_proy_ficha_avan_fisico(siaf);
    llenar_proy_ficha_ejec_financ(siaf);
    llenar_proy_ficha_contrata(siaf);
    llenar_proy_ficha_ubi_geogra(siaf);
    llenar_proy_ficha_gal_fotos(siaf);

}

function llenar_proy_ficha_info_general(siaf) {
    $('#divProyFichaRepInfoGeneral').empty();
    $.ajax({
        dataType: 'json',
        url: "./Proyectos?tipo=informa_general&codSiaf=" + siaf,
        success: function (response) {
            var muestraInfoGenEjec;
            var muestraInfoGenModif = [];
            general = '<div style="height: 32px;">\
                          <button id="btnProyFichaInfoGenPdf" style="float: right;" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="Exportar a PDF">\
                            <span>\
                                <img src="./templates/plugins/datatables/images/pdf.png">\
                            </span>\
                          </button>\
                       </div>\
                        <div class="pad15">\
                        <div class="pad15">\
                        <div class="form-group row">\
                          <label class="col-sm-2 col-form-label ficha-sombreado1">FECHA REGISTRO :</label>\
                          <label class="col-sm-3 col-form-label ficha-sombreado2">' + response.fechaReg + '</label>\
                          <label class="col-sm-2"></label>\
                          <label class="col-sm-2 col-form-label ficha-sombreado1">TIPO PROYECTO :</label>\
                          <label class="col-sm-3 col-form-label ficha-sombreado2">' + (response.tipo).toUpperCase() + '</label>\
                         </div>\
                        <div class="form-group row">\
                          <label class="col-sm-2 col-form-label ficha-sombreado1">CADENA FUNCIONAL :</label>\
                          <label class="col-sm-10 col-form-label ficha-sombreado2">' + response.cadena + '</label>\
                        </div>\
                        <div class="form-group row">\
                          <label class="col-sm-2 col-form-label ficha-sombreado1">UNIDAD FORMULADORA :</label>\
                          <label class="col-sm-10 col-form-label ficha-sombreado2">' + response.formuladora + '</label>\
                        </div>\
                        <div class="form-group row">\
                          <label class="col-sm-2 col-form-label ficha-sombreado1">UNIDAD EVALUADORA :</label>\
                          <label class="col-sm-10 col-form-label ficha-sombreado2">' + response.evaluadora + '</label>\
                        </div>';
            if (response.tipo === "snip") {
                general += '<div class="form-group row">\
                              <label class="col-sm-2 col-form-label ficha-sombreado1">UNIDAD EJECUTORA :</label>\
                              <label class="col-sm-10 col-form-label ficha-sombreado2">' + response.ejecutora + '</label>\
                            </div>';
                muestraInfoGenEjec = {
                    style: 'interlineado',
                    table: {
                        widths: [90, '*'],
                        body: [
                            [
                                {text: 'UNIDAD EJECUTORA :', alignment: 'left', style: 'sombreado1'},
                                {text: response.ejecutora, alignment: 'left', style: 'sombreado2'}
                            ]
                        ]
                    },
                    layout: {
                        hLineColor: 'white',
                        vLineColor: 'white'
                    }
                };
            }
            if (response.tipo === "invierte.pe") {
                general += '<div class="form-group row">\
                              <label class="col-sm-3 col-form-label ficha-sombreado1">UNIDAD EJECUTORA INVERSION :</label>\
                              <label class="col-sm-9 col-form-label ficha-sombreado2">' + response.ejecutoraInv + '</label>\
                            </div>\
                            <div class="form-group row">\
                              <label class="col-sm-3 col-form-label ficha-sombreado1">UNIDAD EJECUTORA PRESUPUESTAL :</label>\
                              <label class="col-sm-9 col-form-label ficha-sombreado2">' + response.ejecutoraPre + '</label>\
                            </div>';
                muestraInfoGenEjec =
                        {
                            style: 'interlineado',
                            table: {
                                widths: [110, '*'],
                                body: [
                                    [
                                        {text: 'UNIDAD EJECUTORA INVERSION :', alignment: 'left', style: 'sombreado1'},
                                        {text: response.ejecutoraInv, alignment: 'left', style: 'sombreado2'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            style: 'interlineado',
                            table: {
                                widths: [110, '*'],
                                body: [
                                    [
                                        {text: 'UNIDAD EJECUTORA PRESUPUESTAL :', alignment: 'left', style: 'sombreado1'},
                                        {text: response.ejecutoraPre, alignment: 'left', style: 'sombreado2'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        };
            }
            general += '<div class="form-group row">\
                          <label class="col-sm-2 col-form-label ficha-sombreado1">BENEFICIARIOS :</label>\
                          <label class="col-sm-2 col-form-label ficha-sombreado2">' + formatNumeroNoComa(response.beneficiarios) + '</label>\
                          <label class="col-sm-1"></label>\
                          <label class="col-sm-3 col-form-label ficha-sombreado1">FUENTE FINANCIAMIENTO :</label>\
                          <label class="col-sm-4 col-form-label ficha-sombreado2">' + response.fuente + '</label>\
                        </div>\
                        <div class="form-group row">\
                          <label class="col-sm-2 col-form-label ficha-sombreado1">FECHA VIABILIDAD :</label>\
                          <label class="col-sm-2 col-form-label ficha-sombreado2">' + response.fechaVia + '</label>\
                          <label class="col-sm-1"></label>\
                          <label class="col-sm-3 col-form-label ficha-sombreado1">RESPONSABLE VIABILIDAD :</label>\
                          <label class="col-sm-4 col-form-label ficha-sombreado2">' + response.responsableVia + '</label>\
                        </div>\
                        <div class="form-group row">\
                          <label class="col-sm-2 col-form-label ficha-sombreado1">SITUACION :</label>\
                          <label class="col-sm-3 col-form-label ficha-sombreado2">' + response.situacion + '</label>\
                          <label class="col-sm-2"></label>\
                          <label class="col-sm-2 col-form-label ficha-sombreado1">ESTADO :</label>\
                          <label class="col-sm-3 col-form-label ficha-sombreado2">' + response.estado + '</label>\
                        </div>\
                        <div class="form-group row">\
                          <label class="col-sm-2 col-form-label ficha-sombreado1">MONTO VIABILIDAD :</label>\
                          <label class="col-sm-3 col-form-label ficha-sombreado2">' + formatNumeroDecimal(response.montoViable) + '</label>\
                          <label class="col-sm-2"></label>\
                          <label class="col-sm-2 col-form-label ficha-sombreado1">MONTO ESTUDIO :</label>\
                          <label class="col-sm-3 col-form-label ficha-sombreado2">' + formatNumeroDecimal(response.montoEstudio) + '</label>\
                        </div>\
                        <div class="form-group row">\
                          <label class="col-sm-3 col-form-label ficha-sombreado1">MONTO INVERSION ACTUALIZADO :</label>\
                          <label class="col-sm-3 col-form-label ficha-sombreado2">' + formatNumeroDecimal(response.montoActual) + '</label>\
                        </div>\
                        </div>\
                        <div>\
                        <div style="overflow-x:auto;">\
                          <table id="tableProyFichaMontoActual" class="display" cellspacing="0" width="100%">\
                              <thead>\
                                <tr>\
                                  <th style="text-align: center;">Id</th>\
                                  <th style="text-align: center;">Fecha Modificación</th>\
                                  <th style="text-align: center;">Monto Actualizado</th>\
                                  <th style="text-align: center;">Comentarios</th>\
                                  <th style="text-align: center;">Usuario</th>\
                                </tr>\
                              </thead>\
                              <tbody id="tableProyFichaMontoActualBody"></tbody>\
                          </table\
                        </div>\
                        </div>\
                        </div>';
            $('#divProyFichaRepInfoGeneral').append(general);
            var muestraInfoGenModifHead = [];
            muestraInfoGenModifHead.push({text: 'Id', style: 'tablaHead', alignment: 'center'});
            muestraInfoGenModifHead.push({text: 'Fecha Modificación', style: 'tablaHead', alignment: 'center'});
            muestraInfoGenModifHead.push({text: 'Monto Actualizado', style: 'tablaHead', alignment: 'center'});
            muestraInfoGenModifHead.push({text: 'Comentarios', style: 'tablaHead', alignment: 'center'});
            muestraInfoGenModifHead.push({text: 'Usuario', style: 'tablaHead', alignment: 'center'});
            muestraInfoGenModif.push(muestraInfoGenModifHead);
            $.each(response.listModif, function (index, value) {
                body = "<tr'>\
                          <td style='text-align: center;'>" + (index + 1) + "</td>\
                          <td style='text-align: center;'>" + value.prmoFechaModificacion + "</td>\
                          <td style='text-align: right;'>" + formatNumeroDecimal(value.prmoMontoActualizado) + "</td>\
                          <td style='text-align: left;'>" + value.prmoComentarios + "</td>\
                          <td style='text-align: left;'>" + value.prmoUsuario + "</td>\
                        </tr>";
                $("#tableProyFichaMontoActualBody").append(body);
                var muestraInfoGenModifBody = [];
                muestraInfoGenModifBody.push({text: (index + 1), style: 'tablaBody', alignment: 'center'});
                muestraInfoGenModifBody.push({text: value.prmoFechaModificacion, style: 'tablaBody', alignment: 'center'});
                muestraInfoGenModifBody.push({text: formatNumeroDecimal(value.prmoMontoActualizado), style: 'tablaBody', alignment: 'right'});
                muestraInfoGenModifBody.push({text: value.prmoComentarios, style: 'tablaBody', alignment: 'left'});
                muestraInfoGenModifBody.push({text: value.prmoUsuario, style: 'tablaBody', alignment: 'left'});
                muestraInfoGenModif.push(muestraInfoGenModifBody);
            });

            $('#tableProyFichaMontoActual').dataTable({
                ordering: false,
                bPaginate: false,
                dom: '<"centrar-div-tabla"<"labelDataTableModif">B>rt',
                buttons: [
                    {
                        extend: 'excel',
                        filename: 'modificaciones_monto_inversion_proyecto_' + siaf,
                        title: 'MODIFICACIONES AL MONTO DE INVERSIÓN',
                        headTop1: 'Código SIAF : ' + siaf,
                        headTop2: 'Código SNIP : ' + response.snip,
                        headTop3: 'Nombre Proyecto : ' + response.nombre,
                        exportOptions: {
                            orthogonal: 'sort',
                            columns: ':visible'
                        },
                        customize: function (xlsx) {
                            var sheet = xlsx.xl.worksheets['sheet1.xml'];
                            for (var k = 2; k < 3; k++) {
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
            $("div.labelDataTableModif").html('<label class="col-form-label">MODIFICACIONES MONTO INVERSION</label>\
                          <button id="btnShowProyFichaMontoModif" type="button" class="btn btn-default btn-m" data-toggle="tooltip" data-placement="bottom" title="Ocultar">\
                            <span class="glyphicon glyphicon-eye-close"></span>\
                          </button>');

            $("#btnShowProyFichaMontoModif").click(function () {
                $("#btnShowProyFichaMontoModif").empty();
                if ($("#tableProyFichaMontoActual").is(":hidden")) {
                    $("#btnShowProyFichaMontoModif").append('<span class="glyphicon glyphicon-eye-close"></span>');
                    $('#btnShowProyFichaMontoModif').prop('title', 'Ocultar');
                    $("#tableProyFichaMontoActual").toggle(500);
                } else {
                    $("#btnShowProyFichaMontoModif").append('<span class="glyphicon glyphicon-eye-open"></span>');
                    $('#btnShowProyFichaMontoModif').prop('title', 'Mostrar');
                    $("#tableProyFichaMontoActual").hide(500);
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
            $("#btnProyFichaInfoGenPdf").on('click', function () {
                var docDefinition = {
                    pageOrientation: 'landscape',
                    info: {
                        title: 'informacion_general_proyecto_' + siaf
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
                                        {text: 'INFORMACIÓN GENERAL DE PROYECTO', alignment: 'center', style: 'tituloU'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            style: 'interlineado1',
                            table: {
                                widths: [90, '*', 80, 90, '*'],
                                body: [
                                    [
                                        {text: 'CODIGO SIAF :', alignment: 'left', style: 'sombreado1'},
                                        {text: response.siaf, alignment: 'left', style: 'sombreado2'},
                                        "",
                                        {text: 'CODIGO SNIP :', alignment: 'left', style: 'sombreado1'},
                                        {text: response.snip, alignment: 'left', style: 'sombreado2'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            style: 'interlineado',
                            table: {
                                widths: [90, '*'],
                                body: [
                                    [
                                        {text: 'NOMBRE PROYECTO :', alignment: 'left', style: 'sombreado1'},
                                        {text: response.nombre, alignment: 'left', style: 'sombreado2'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            style: 'interlineado',
                            table: {
                                widths: [90, '*', 80, 90, '*'],
                                body: [
                                    [
                                        {text: 'FECHA REGISTRO :', alignment: 'left', style: 'sombreado1'},
                                        {text: response.fechaReg, alignment: 'left', style: 'sombreado2'},
                                        "",
                                        {text: 'TIPO PROYECTO :', alignment: 'left', style: 'sombreado1'},
                                        {text: (response.tipo).toUpperCase(), alignment: 'left', style: 'sombreado2'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            style: 'interlineado',
                            table: {
                                widths: [90, '*'],
                                body: [
                                    [
                                        {text: 'CADENA FUNCIONAL :', alignment: 'left', style: 'sombreado1'},
                                        {text: response.cadena, alignment: 'left', style: 'sombreado2'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            style: 'interlineado',
                            table: {
                                widths: [90, '*'],
                                body: [
                                    [
                                        {text: 'UNIDAD FORMULADORA :', alignment: 'left', style: 'sombreado1'},
                                        {text: response.formuladora, alignment: 'left', style: 'sombreado2'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            style: 'interlineado',
                            table: {
                                widths: [90, '*'],
                                body: [
                                    [
                                        {text: 'UNIDAD EVALUADORA :', alignment: 'left', style: 'sombreado1'},
                                        {text: response.formuladora, alignment: 'left', style: 'sombreado2'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        muestraInfoGenEjec,
                        {
                            style: 'interlineado',
                            table: {
                                widths: [90, '*', 60, 100, '*'],
                                body: [
                                    [
                                        {text: 'BENEFICIARIOS :', alignment: 'left', style: 'sombreado1'},
                                        {text: formatNumeroNoComa(response.beneficiarios), alignment: 'left', style: 'sombreado2'},
                                        "",
                                        {text: 'FUENTE FINANCIAMIENTO :', alignment: 'left', style: 'sombreado1'},
                                        {text: response.fuente, alignment: 'left', style: 'sombreado2'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            style: 'interlineado',
                            table: {
                                widths: [90, '*', 60, 100, '*'],
                                body: [
                                    [
                                        {text: 'FECHA VIABILIDAD :', alignment: 'left', style: 'sombreado1'},
                                        {text: response.fechaVia, alignment: 'left', style: 'sombreado2'},
                                        "",
                                        {text: 'RESPONSABLE VIABILIDAD :', alignment: 'left', style: 'sombreado1'},
                                        {text: response.responsableVia, alignment: 'left', style: 'sombreado2'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            style: 'interlineado',
                            table: {
                                widths: [90, '*', 80, 90, '*'],
                                body: [
                                    [
                                        {text: 'SITUACION :', alignment: 'left', style: 'sombreado1'},
                                        {text: response.situacion, alignment: 'left', style: 'sombreado2'},
                                        "",
                                        {text: 'ESTADO :', alignment: 'left', style: 'sombreado1'},
                                        {text: response.estado, alignment: 'left', style: 'sombreado2'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            style: 'interlineado',
                            table: {
                                widths: [90, '*', 80, 90, '*'],
                                body: [
                                    [
                                        {text: 'MONTO VIABILIDAD :', alignment: 'left', style: 'sombreado1'},
                                        {text: formatNumeroDecimal(response.montoViable), alignment: 'left', style: 'sombreado2'},
                                        "",
                                        {text: 'MONTO ESTUDIO :', alignment: 'left', style: 'sombreado1'},
                                        {text: formatNumeroDecimal(response.montoEstudio), alignment: 'left', style: 'sombreado2'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            style: 'interlineado',
                            table: {
                                widths: [110, '*', 80, 90, '*'],
                                body: [
                                    [
                                        {text: 'MONTO INVERSION ACTUALIZADO :', alignment: 'left', style: 'sombreado1'},
                                        {text: formatNumeroDecimal(response.montoActual), alignment: 'left', style: 'sombreado2'},
                                        "",
                                        "",
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
                        {text: 'MODIFICACIONES AL MONTO DE INVERSIÓN', alignment: 'left', style: 'subtitulo'},
                        {
                            style: 'interlineado1',
                            table: {
                                widths: [25, 120, 100, '*', 100],
                                body: muestraInfoGenModif
                            },
                            layout: {
                                hLineColor: '#ECECEC',
                                vLineColor: '#ECECEC'
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
                            fontSize: 8,
                            bold: true,
                            color: '#334A74',
                            decoration: 'underline'
                        },
                        subtitulo: {
                            fontSize: 7,
                            bold: true,
                            color: '#334A74'
                        },
                        subtituloU: {
                            fontSize: 7,
                            bold: true,
                            color: '#334A74',
                            decoration: 'underline'
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
                        subHeader: {
                            color: 'white',
                            fillColor: '#587BA0',
                            fontSize: 6,
                            bold: true
                        },
                        subFooter: {
                            fillColor: '#D2DBE5',
                            fontSize: 6
                        },
                        tablaTotal: {
                            fillColor: '#F6F6F6',
                            fontSize: 6,
                            bold: true
                        },
                        pie: {
                            fontSize: 5
                        },
                        interlineado: {
                            margin: [0, 2, 0, 2]
                        },
                        interlineado1: {
                            margin: [0, 5, 0, 2]
                        }
                    }
                };
                pdfMake.createPdf(docDefinition).open();
            });
        }
    });

}

function llenar_proy_ficha_est_definitivo(siaf) {
    $('#divProyFichaRepEstudioDef').empty();
    $.ajax({
        dataType: 'json',
        url: "./Proyectos?tipo=estudio_def&codSiaf=" + siaf,
        success: function (response) {
            var fecha, documento, contrato, responsable, estadoEtapa;
            if (response.estado) {
                fecha = response.fecha;
                documento = response.documento;
                contrato = response.contrato;
                responsable = response.responsable;
                estadoEtapa = response.estadoEtapa;
            } else {
                fecha = "";
                documento = "";
                contrato = "";
                responsable = "";
                estadoEtapa = false;
            }
            estudio = '<div style="height: 32px;">\
                          <button id="btnProyFichaEstDefPdf" style="float: right;" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="Exportar a PDF">\
                            <span>\
                                <img src="./templates/plugins/datatables/images/pdf.png">\
                            </span>\
                          </button>\
                       </div>\
                        <div class="pad15">\
                        <div class="pad15">\
                        <div class="form-group row">\
                          <label class="col-sm-3 col-form-label ficha-sombreado1">FECHA APROBACIÓN :</label>\
                          <label class="col-sm-3 col-form-label ficha-sombreado2">' + fecha + '</label>\
                        </div>\
                        <div class="form-group row">\
                          <label class="col-sm-3 col-form-label ficha-sombreado1">DOCUMENTO APROBACIÓN :</label>\
                          <label class="col-sm-9 col-form-label ficha-sombreado2">' + documento + '</label>\
                        </div>\
                        <div class="form-group row">\
                          <label class="col-sm-3 col-form-label ficha-sombreado1">CONTRATO :</label>\
                          <label class="col-sm-9 col-form-label ficha-sombreado2">' + contrato + '</label>\
                        </div>\
                        <div class="form-group row">\
                          <label class="col-sm-3 col-form-label ficha-sombreado1">RESPONSABLE ELABORACIÓN :</label>\
                          <label class="col-sm-9 col-form-label ficha-sombreado2">' + responsable + '</label>\
                        </div>\
                       </div>\
                       <div id="divTableProyFichaEstudioDef"></div>';
            $('#divProyFichaRepEstudioDef').append(estudio);

            var muestraEstDefEtapa;

            if (estadoEtapa) {
                var muestraEstDefEtapaTbl = [];
                estudioEtapa = '<div style="overflow-x:auto;">\
                                  <table id="tableProyFichaEstudioDef" class="display" cellspacing="0" width="100%">\
                                    <thead>\
                                      <tr>\
                                        <th style="text-align: center; width: 35px;">Etapa</th>\
                                        <th style="text-align: center; width: 129px;">Fecha Aprobación</th>\
                                        <th style="text-align: center;">Documento Aprobación</th>\
                                        <th style="text-align: center; width: 200px;">Contrato</th>\
                                        <th style="text-align: center; width: 200px;">Responsable Elaboración</th>\
                                      </tr>\
                                    </thead>\
                                    <tbody id="tableProyFichaEstudioDefBody"></tbody>\
                                  </table\
                                </div></div>';
                $('#divTableProyFichaEstudioDef').append(estudioEtapa);
                var muestraEstDefEtapaTblHead = [];
                muestraEstDefEtapaTblHead.push({text: 'Etapa', style: 'tablaHead', alignment: 'center'});
                muestraEstDefEtapaTblHead.push({text: 'Fecha Aprobación', style: 'tablaHead', alignment: 'center'});
                muestraEstDefEtapaTblHead.push({text: 'Documento Aprobación', style: 'tablaHead', alignment: 'center'});
                muestraEstDefEtapaTblHead.push({text: 'Contrato', style: 'tablaHead', alignment: 'center'});
                muestraEstDefEtapaTblHead.push({text: 'Responsable Elaboración', style: 'tablaHead', alignment: 'center'});
                muestraEstDefEtapaTbl.push(muestraEstDefEtapaTblHead);

                $.each(response.listEstudioEtapa, function (index, value) {
                    var muestraEstDefEtapaTblBody = [];
                    var presetEtapa = value.presetEtapa;
                    var presetFechaAproba;
                    if (!$.trim(value.presetFechaAproba)) {
                        presetFechaAproba = "";
                    } else {
                        presetFechaAproba = castDateString(value.presetFechaAproba);
                    }
                    var presetDocAproba;
                    if (!$.trim(value.presetDocAproba)) {
                        presetDocAproba = "";
                    } else {
                        presetDocAproba = value.presetDocAproba;
                    }
                    var presetContrato;
                    if (!$.trim(value.presetContrato)) {
                        presetContrato = "";
                    } else {
                        presetContrato = value.presetContrato;
                    }
                    var presetResponsable;
                    if (!$.trim(value.presetResponsable)) {
                        presetResponsable = "";
                    } else {
                        presetResponsable = value.presetResponsable;
                    }
                    var body = "<tr>\
                                <td style='text-align: center;'>" + presetEtapa + "</td>\
                                <td style='text-align: center;'>" + presetFechaAproba + "</td>\
                                <td style='text-align: left;'>" + presetDocAproba + "</td>\
                                <td style='text-align: left;'>" + presetContrato + "</td>\
                                <td style='text-align: left;'>" + presetResponsable + "</td>\
                            </tr>";
                    $("#tableProyFichaEstudioDefBody").append(body);
                    muestraEstDefEtapaTblBody.push({text: presetEtapa, style: 'tablaBody', alignment: 'center'});
                    muestraEstDefEtapaTblBody.push({text: presetFechaAproba, style: 'tablaBody', alignment: 'center'});
                    muestraEstDefEtapaTblBody.push({text: presetDocAproba, style: 'tablaBody', alignment: 'left'});
                    muestraEstDefEtapaTblBody.push({text: presetContrato, style: 'tablaBody', alignment: 'left'});
                    muestraEstDefEtapaTblBody.push({text: presetResponsable, style: 'tablaBody', alignment: 'left'});
                    muestraEstDefEtapaTbl.push(muestraEstDefEtapaTblBody);
                });

                $('#tableProyFichaEstudioDef').dataTable({
                    ordering: false,
                    bPaginate: false,
                    dom: '<"centrar-div-tabla"<"labelDataTableEstDef">B>rt',
                    buttons: [
                        {
                            extend: 'excel',
                            filename: 'etapas_estudio_definitivo_proyecto_' + siaf,
                            title: 'ETAPAS DEL ESTUDIO DEFINITIVO',
                            headTop1: 'Código SIAF : ' + siaf,
                            headTop2: 'Código SNIP : ' + response.snip,
                            headTop3: 'Nombre Proyecto : ' + response.nombre,
                            exportOptions: {
                                orthogonal: 'sort',
                                columns: ':visible'
                            }
                        }
                    ]
                });
                $("div.labelDataTableEstDef").html('<label class="col-form-label">ETAPAS DEL ESTUDIO</label');

                muestraEstDefEtapa =
                        {text: '\n'},
                        {text: 'ETAPAS DEL ESTUDIO DEFINITIVO', alignment: 'left', style: 'subtitulo'},
                        {
                            style: 'interlineado1',
                            table: {
                                widths: [35, 120, '*', 150, 150],
                                body: muestraEstDefEtapaTbl
                            },
                            layout: {
                                hLineColor: '#ECECEC',
                                vLineColor: '#ECECEC'
                            }
                        };
            } else {
                muestraEstDefEtapa = {text: '\n'};
            }

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
            $("#btnProyFichaEstDefPdf").on('click', function () {
                var docDefinition = {
                    pageOrientation: 'landscape',
                    info: {
                        title: 'estudio_definitivo_proyecto_' + siaf
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
                                        {text: 'ESTUDIO DEFINITIVO DE PROYECTO', alignment: 'center', style: 'tituloU'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            style: 'interlineado1',
                            table: {
                                widths: [90, '*', 60, 90, '*'],
                                body: [
                                    [
                                        {text: 'CODIGO SIAF :', alignment: 'left', style: 'sombreado1'},
                                        {text: response.siaf, alignment: 'left', style: 'sombreado2'},
                                        "",
                                        {text: 'CODIGO SNIP :', alignment: 'left', style: 'sombreado1'},
                                        {text: response.snip, alignment: 'left', style: 'sombreado2'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            style: 'interlineado',
                            table: {
                                widths: [90, '*'],
                                body: [
                                    [
                                        {text: 'NOMBRE PROYECTO :', alignment: 'left', style: 'sombreado1'},
                                        {text: response.nombre, alignment: 'left', style: 'sombreado2'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            style: 'interlineado',
                            table: {
                                widths: [100, '*', 60, 100, '*'],
                                body: [
                                    [
                                        {text: 'FECHA APROBACIÓN :', alignment: 'left', style: 'sombreado1'},
                                        {text: fecha, alignment: 'left', style: 'sombreado2'},
                                        "",
                                        {text: 'DOCUMENTO APROBACIÓN :', alignment: 'left', style: 'sombreado1'},
                                        {text: documento, alignment: 'left', style: 'sombreado2'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            style: 'interlineado',
                            table: {
                                widths: [100, '*', 60, 100, '*'],
                                body: [
                                    [
                                        {text: 'CONTRATO :', alignment: 'left', style: 'sombreado1'},
                                        {text: contrato, alignment: 'left', style: 'sombreado2'},
                                        "",
                                        {text: 'RESPONSABLE ELABORACIÓN :', alignment: 'left', style: 'sombreado1'},
                                        {text: responsable, alignment: 'left', style: 'sombreado2'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        muestraEstDefEtapa
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
                            fontSize: 8,
                            bold: true,
                            color: '#334A74',
                            decoration: 'underline'
                        },
                        subtitulo: {
                            fontSize: 7,
                            bold: true,
                            color: '#334A74'
                        },
                        subtituloU: {
                            fontSize: 7,
                            bold: true,
                            color: '#334A74',
                            decoration: 'underline'
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
                        subHeader: {
                            color: 'white',
                            fillColor: '#587BA0',
                            fontSize: 6,
                            bold: true
                        },
                        subFooter: {
                            fillColor: '#D2DBE5',
                            fontSize: 6
                        },
                        tablaTotal: {
                            fillColor: '#F6F6F6',
                            fontSize: 6,
                            bold: true
                        },
                        pie: {
                            fontSize: 5
                        },
                        interlineado: {
                            margin: [0, 2, 0, 2]
                        },
                        interlineado1: {
                            margin: [0, 5, 0, 2]
                        }
                    }
                };
                pdfMake.createPdf(docDefinition).open();
            });

        }
    });

}

function llenar_proy_ficha_supervision(siaf) {
    $('#divProyFichaRepSupervObra').empty();
    $.ajax({
        dataType: 'json',
        url: "./Proyectos?tipo=supervision&codSiaf=" + siaf,
        success: function (response) {
            if (response.supervision) {
                var proceso, contrato, fechaCont, montoCont, proveedor, modalidad,
                        superv, coord, admin, fechaIni, fechaFin, tieneAdela;
                if (response.estado) {
                    if (!$.trim(response.proceso)) {
                        proceso = "";
                    } else {
                        proceso = response.proceso;
                    }
                    if (!$.trim(response.contrato)) {
                        contrato = "";
                    } else {
                        contrato = response.contrato;
                    }
                    if (!$.trim(response.fechaCont)) {
                        fechaCont = "";
                    } else {
                        fechaCont = response.fechaCont;
                    }
                    if (!$.trim(response.montoCont)) {
                        montoCont = 0.00;
                    } else {
                        montoCont = response.montoCont;
                    }
                    if (!$.trim(response.proveedor)) {
                        proveedor = "";
                    } else {
                        proveedor = response.proveedor;
                    }
                    if (!$.trim(response.modalidad)) {
                        modalidad = "";
                    } else {
                        modalidad = response.modalidad;
                    }
                    if (!$.trim(response.supervCelular)) {
                        if (!$.trim(response.supervNombre)) {
                            superv = "";
                        } else {
                            superv = response.supervNombre;
                        }
                    } else {
                        if (!$.trim(response.supervNombre)) {
                            superv = "";
                        } else {
                            superv = response.supervNombre + " (" + response.supervCelular + ")";
                        }
                    }
                    if (!$.trim(response.coordCelular)) {
                        if (!$.trim(response.coordNombre)) {
                            coord = "";
                        } else {
                            coord = response.coordNombre;
                        }
                    } else {
                        if (!$.trim(response.coordNombre)) {
                            coord = "";
                        } else {
                            coord = response.coordNombre + " (" + response.coordCelular + ")";
                        }
                    }
                    if (!$.trim(response.adminCelular)) {
                        if (!$.trim(response.adminNombre)) {
                            admin = "";
                        } else {
                            admin = response.adminNombre;
                        }
                    } else {
                        if (!$.trim(response.adminNombre)) {
                            admin = "";
                        } else {
                            admin = response.adminNombre + " (" + response.adminCelular + ")";
                        }
                    }
                    if (!$.trim(response.fechaInicio)) {
                        fechaIni = "";
                    } else {
                        fechaIni = response.fechaInicio;
                    }
                    if (!$.trim(response.fechaFin)) {
                        fechaFin = "";
                    } else {
                        fechaFin = response.fechaFin;
                    }
                    if (!$.trim(response.tieneAdelanto)) {
                        tieneAdela = false;
                    } else {
                        tieneAdela = response.tieneAdelanto;
                    }
                } else {
                    proceso = "";
                    contrato = "";
                    fechaCont = "";
                    montoCont = "";
                    proveedor = "";
                    modalidad = "";
                    superv = "";
                    coord = "";
                    admin = "";
                    fechaIni = "";
                    fechaFin = "";
                    tieneAdela = false;
                }
                supervision = '<div style="height: 32px;">\
                                <button id="btnProyFichaSupervPdf" style="float: right;" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="Exportar a PDF">\
                                  <span>\
                                      <img src="./templates/plugins/datatables/images/pdf.png">\
                                  </span>\
                                </button>\
                               </div>\
                               <div class="pad15">\
                               <div class="pad15">\
                                <div class="form-group row">\
                                  <label class="col-sm-3 col-form-label ficha-sombreado1">PROCESO :</label>\
                                  <label class="col-sm-9 col-form-label ficha-sombreado2">' + proceso + '</label>\
                                </div>\
                                <div class="form-group row">\
                                  <label class="col-sm-3 col-form-label ficha-sombreado1">CONTRATO :</label>\
                                  <label class="col-sm-9 col-form-label ficha-sombreado2">' + contrato + '</label>\
                                </div>\
                                <div class="form-group row">\
                                  <label class="col-sm-3 col-form-label ficha-sombreado1">FECHA FIRMA CONTRATO :</label>\
                                  <label class="col-sm-3 col-form-label ficha-sombreado2">' + fechaCont + '</label>\
                                </div>\
                                <div class="form-group row">\
                                  <label class="col-sm-3 col-form-label ficha-sombreado1">MONTO CONTRATADO :</label>\
                                  <label class="col-sm-3 col-form-label ficha-sombreado2">' + formatNumeroDecimal(montoCont) + '</label>\
                                </div>\
                                <div class="form-group row">\
                                  <label class="col-sm-3 col-form-label ficha-sombreado1">PROVEEDOR :</label>\
                                  <label class="col-sm-9 col-form-label ficha-sombreado2">' + proveedor + '</label>\
                                </div>\
                                <div class="form-group row">\
                                  <label class="col-sm-3 col-form-label ficha-sombreado1">MODALIDAD CONTRATO :</label>\
                                  <label class="col-sm-9 col-form-label ficha-sombreado2">' + modalidad + '</label>\
                                </div>\
                                <div class="form-group row">\
                                  <label class="col-sm-3 col-form-label ficha-sombreado1">SUPERVISOR DE OBRA :</label>\
                                  <label class="col-sm-9 col-form-label ficha-sombreado2">' + superv + '</label>\
                                </div>\
                                <div class="form-group row">\
                                  <label class="col-sm-3 col-form-label ficha-sombreado1">COORDINADOR DE OBRA :</label>\
                                  <label class="col-sm-9 col-form-label ficha-sombreado2">' + coord + '</label>\
                                </div>\
                                <div class="form-group row">\
                                  <label class="col-sm-3 col-form-label ficha-sombreado1">ADMINISTRADOR CONTRATO :</label>\
                                  <label class="col-sm-9 col-form-label ficha-sombreado2">' + admin + '</label>\
                                </div>\
                                <div class="form-group row">\
                                  <label class="col-sm-3 col-form-label ficha-sombreado1">FECHA DE INICIO :</label>\
                                  <label class="col-sm-3 col-form-label ficha-sombreado2">' + fechaIni + '</label>\
                                </div>\
                                <div class="form-group row">\
                                  <label class="col-sm-3 col-form-label ficha-sombreado1">FECHA DE FIN :</label>\
                                  <label class="col-sm-3 col-form-label ficha-sombreado2">' + fechaFin + '</label>\
                                </div>\
                              </div>\
                              <div id="divTableProyFichaSupervAdela"></div></div>';
                $('#divProyFichaRepSupervObra').append(supervision);
                var muestraSuperAdela;
                if (tieneAdela) {
                    var muestraSuperAdelaTbl = [];
                    supervisionAdela = '<div style="overflow-x:auto;">\
                                         <table id="tableProyFichaSuperv" class="display" cellspacing="0" width="100%">\
                                            <thead>\
                                              <tr>\
                                                <th style="text-align: center; width: 80px;">Número</th>\
                                                <th style="text-align: center; width: 160px;">Adelanto</th>\
                                                <th style="text-align: center; width: 129px;">Fecha</th>\
                                                <th style="text-align: center;">Comentario</th>\
                                              </tr>\
                                            </thead>\
                                            <tbody id="tableProyFichaSupervBody"></tbody>\
                                            <tfoot id="tableProyFichaSupervFoot"></tfoot>\
                                          </table>\
                                        </div>';
                    $('#divTableProyFichaSupervAdela').append(supervisionAdela);
                    var muestraSuperAdelaTblHead = [];
                    muestraSuperAdelaTblHead.push({text: 'Número', style: 'tablaHead', alignment: 'center'});
                    muestraSuperAdelaTblHead.push({text: 'Adelanto', style: 'tablaHead', alignment: 'center'});
                    muestraSuperAdelaTblHead.push({text: 'Fecha', style: 'tablaHead', alignment: 'center'});
                    muestraSuperAdelaTblHead.push({text: 'Comentario', style: 'tablaHead', alignment: 'center'});
                    muestraSuperAdelaTbl.push(muestraSuperAdelaTblHead);
                    var prsuadMontoT = 0.00;
                    $.each(response.listSuperAdela, function (index, value) {
                        var muestraSuperAdelaTblBody = [];
                        var prsuadNro = value.prsuadNro;
                        var prsuadMonto;
                        if (!$.trim(value.prsuadMonto)) {
                            prsuadMonto = "";
                        } else {
                            prsuadMonto = formatNumeroDecimal(value.prsuadMonto);
                            prsuadMontoT += value.prsuadMonto;
                        }
                        var prsuadFecha;
                        if (!$.trim(value.prsuadFecha)) {
                            prsuadFecha = "";
                        } else {
                            prsuadFecha = value.prsuadFecha;
                        }
                        var prsuadComentario = value.prsuadComentario;
                        var body = "<tr>\
                                      <td style='text-align: center;'>" + prsuadNro + "</td>\
                                      <td style='text-align: center;'>" + prsuadMonto + "</td>\
                                      <td style='text-align: center;'>" + prsuadFecha + "</td>\
                                      <td style='text-align: left;'>" + prsuadComentario + "</td>\
                                    </tr>";
                        $("#tableProyFichaSupervBody").append(body);
                        muestraSuperAdelaTblBody.push({text: prsuadNro, style: 'tablaBody', alignment: 'center'});
                        muestraSuperAdelaTblBody.push({text: prsuadMonto, style: 'tablaBody', alignment: 'center'});
                        muestraSuperAdelaTblBody.push({text: prsuadFecha, style: 'tablaBody', alignment: 'center'});
                        muestraSuperAdelaTblBody.push({text: prsuadComentario, style: 'tablaBody', alignment: 'left'});
                        muestraSuperAdelaTbl.push(muestraSuperAdelaTblBody);
                    });

                    var foot = "<tr class='total'>\
                                  <td style='text-align: center;'><b>TOTAL</b></td>\
                                  <td style='text-align: center;'><b>" + formatNumeroDecimal(prsuadMontoT) + "</b></td>\
                                  <td></td>\
                                  <td></td>\
                                </tr>";
                    $("#tableProyFichaSupervFoot").append(foot);
                    var muestraSuperAdelaTblFoot = [];
                    muestraSuperAdelaTblFoot.push({text: 'TOTAL', style: 'tablaTotal', alignment: 'center'});
                    muestraSuperAdelaTblFoot.push({text: formatNumeroDecimal(prsuadMontoT), style: 'tablaTotal', alignment: 'center'});
                    muestraSuperAdelaTblFoot.push("");
                    muestraSuperAdelaTblFoot.push("");
                    muestraSuperAdelaTbl.push(muestraSuperAdelaTblFoot);

                    $('#tableProyFichaSuperv').dataTable({
                        ordering: false,
                        bPaginate: false,
                        dom: '<"centrar-div-tabla"<"labelDataTableSupAdela">B>rt',
                        buttons: [
                            {
                                extend: 'excel',
                                footer: true,
                                filename: 'adelantos_supervision_proyecto_' + siaf,
                                title: 'ADELANTOS EN LA SUPERVISIÓN',
                                headTop1: 'Código SIAF : ' + siaf,
                                headTop2: 'Código SNIP : ' + response.snip,
                                headTop3: 'Nombre Proyecto : ' + response.nombre,
                                exportOptions: {
                                    orthogonal: 'sort',
                                    columns: ':visible'
                                },
                                customize: function (xlsx) {
                                    var sheet = xlsx.xl.worksheets['sheet1.xml'];
                                    for (var k = 1; k < 2; k++) {
                                        var total = $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).length;
                                        $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).each(function (i) {
                                            if (i > 0 && i < total - 1) {
                                                $(this).attr('s', '72');
                                            }
                                            if (i === total - 1) {
                                                $(this).attr('s', '75');
                                            }
                                        });
                                    }
                                }
                            }
                        ]
                    });
                    $("div.labelDataTableSupAdela").html('<label class="col-form-label">ADELANTOS</label>');

                    muestraSuperAdela =
                            {text: '\n'},
                            {text: 'ADELANTOS EN LA SUPERVISIÓN', alignment: 'left', style: 'subtitulo'},
                            {
                                style: 'interlineado1',
                                table: {
                                    widths: [50, 120, 120, '*'],
                                    body: muestraSuperAdelaTbl
                                },
                                layout: {
                                    hLineColor: '#ECECEC',
                                    vLineColor: '#ECECEC'
                                }
                            };

                } else {
                    muestraSuperAdela = {text: '\n'};
                }

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
                $("#btnProyFichaSupervPdf").on('click', function () {
                    var docDefinition = {
                        pageOrientation: 'landscape',
                        info: {
                            title: 'supervision_obra_proyecto_' + siaf
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
                                            {text: 'SUPERVISIÓN DE OBRA DE PROYECTO', alignment: 'center', style: 'tituloU'}
                                        ]
                                    ]
                                },
                                layout: {
                                    hLineColor: 'white',
                                    vLineColor: 'white'
                                }
                            },
                            {
                                style: 'interlineado1',
                                table: {
                                    widths: [90, '*', 60, 90, '*'],
                                    body: [
                                        [
                                            {text: 'CODIGO SIAF :', alignment: 'left', style: 'sombreado1'},
                                            {text: response.siaf, alignment: 'left', style: 'sombreado2'},
                                            "",
                                            {text: 'CODIGO SNIP :', alignment: 'left', style: 'sombreado1'},
                                            {text: response.snip, alignment: 'left', style: 'sombreado2'}
                                        ]
                                    ]
                                },
                                layout: {
                                    hLineColor: 'white',
                                    vLineColor: 'white'
                                }
                            },
                            {
                                style: 'interlineado',
                                table: {
                                    widths: [90, '*'],
                                    body: [
                                        [
                                            {text: 'NOMBRE PROYECTO :', alignment: 'left', style: 'sombreado1'},
                                            {text: response.nombre, alignment: 'left', style: 'sombreado2'}
                                        ]
                                    ]
                                },
                                layout: {
                                    hLineColor: 'white',
                                    vLineColor: 'white'
                                }
                            },
                            {
                                style: 'interlineado',
                                table: {
                                    widths: [80, '*', 60, 80, '*'],
                                    body: [
                                        [
                                            {text: 'PROCESO :', alignment: 'left', style: 'sombreado1'},
                                            {text: proceso, alignment: 'left', style: 'sombreado2'},
                                            "",
                                            {text: 'CONTRATO :', alignment: 'left', style: 'sombreado1'},
                                            {text: contrato, alignment: 'left', style: 'sombreado2'}
                                        ]
                                    ]
                                },
                                layout: {
                                    hLineColor: 'white',
                                    vLineColor: 'white'
                                }
                            },
                            {
                                style: 'interlineado',
                                table: {
                                    widths: [110, '*', 60, 110, '*'],
                                    body: [
                                        [
                                            {text: 'FECHA FIRMA CONTRATO :', alignment: 'left', style: 'sombreado1'},
                                            {text: fechaCont, alignment: 'left', style: 'sombreado2'},
                                            "",
                                            {text: 'MONTO CONTRATADO :', alignment: 'left', style: 'sombreado1'},
                                            {text: formatNumeroDecimal(montoCont), alignment: 'left', style: 'sombreado2'}
                                        ]
                                    ]
                                },
                                layout: {
                                    hLineColor: 'white',
                                    vLineColor: 'white'
                                }
                            }, {
                                style: 'interlineado',
                                table: {
                                    widths: [110, '*', 60, 110, '*'],
                                    body: [
                                        [
                                            {text: 'PROVEEDOR :', alignment: 'left', style: 'sombreado1'},
                                            {text: proveedor, alignment: 'left', style: 'sombreado2'},
                                            "",
                                            {text: 'MODALIDAD CONTRATO :', alignment: 'left', style: 'sombreado1'},
                                            {text: modalidad, alignment: 'left', style: 'sombreado2'}
                                        ]
                                    ]
                                },
                                layout: {
                                    hLineColor: 'white',
                                    vLineColor: 'white'
                                }
                            },
                            {
                                style: 'interlineado',
                                table: {
                                    widths: [110, '*', 60, 110, '*'],
                                    body: [
                                        [
                                            {text: 'SUPERVISOR DE OBRA :', alignment: 'left', style: 'sombreado1'},
                                            {text: superv, alignment: 'left', style: 'sombreado2'},
                                            "",
                                            {text: 'COORDINADOR DE OBRA :', alignment: 'left', style: 'sombreado1'},
                                            {text: coord, alignment: 'left', style: 'sombreado2'}
                                        ]
                                    ]
                                },
                                layout: {
                                    hLineColor: 'white',
                                    vLineColor: 'white'
                                }
                            },
                            {
                                style: 'interlineado',
                                table: {
                                    widths: [110, '*', 60, 90, '*'],
                                    body: [
                                        [
                                            {text: 'ADMINISTRADOR CONTRATO :', alignment: 'left', style: 'sombreado1'},
                                            {text: admin, alignment: 'left', style: 'sombreado2'},
                                            "",
                                            "",
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
                                style: 'interlineado',
                                table: {
                                    widths: [80, '*', 60, 80, '*'],
                                    body: [
                                        [
                                            {text: 'FECHA DE INICIO :', alignment: 'left', style: 'sombreado1'},
                                            {text: fechaIni, alignment: 'left', style: 'sombreado2'},
                                            "",
                                            {text: 'FECHA DE FIN :', alignment: 'left', style: 'sombreado1'},
                                            {text: fechaFin, alignment: 'left', style: 'sombreado2'}
                                        ]
                                    ]
                                },
                                layout: {
                                    hLineColor: 'white',
                                    vLineColor: 'white'
                                }
                            },
                            muestraSuperAdela
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
                                fontSize: 8,
                                bold: true,
                                color: '#334A74',
                                decoration: 'underline'
                            },
                            subtitulo: {
                                fontSize: 7,
                                bold: true,
                                color: '#334A74'
                            },
                            subtituloU: {
                                fontSize: 7,
                                bold: true,
                                color: '#334A74',
                                decoration: 'underline'
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
                            subHeader: {
                                color: 'white',
                                fillColor: '#587BA0',
                                fontSize: 6,
                                bold: true
                            },
                            subFooter: {
                                fillColor: '#D2DBE5',
                                fontSize: 6
                            },
                            tablaTotal: {
                                fillColor: '#F6F6F6',
                                fontSize: 6,
                                bold: true
                            },
                            pie: {
                                fontSize: 5
                            },
                            interlineado: {
                                margin: [0, 2, 0, 2]
                            },
                            interlineado1: {
                                margin: [0, 5, 0, 2]
                            }
                        }
                    };
                    pdfMake.createPdf(docDefinition).open();
                });

            } else {
                $("#btnProyFichaSupervPdf").hide();
                supervision = '<div class="pad30">\
                                <div class="form-group row">\
                                  <label class="col-sm-12 col-form-label ficha-sombreado2">ESTE PROYECTO NO CUENTA CON SUPERVISIÓN Ó NO SE HA REGISTRADO DICHA INFORMACIÓN</label>\
                                </div>\
                               </div>';
                $('#divProyFichaRepSupervObra').append(supervision);
            }
        }
    });

}

function llenar_proy_ficha_ejecucion(siaf) {
    $('#divProyFichaRepEjecuObra').empty();
    $.ajax({
        dataType: 'json',
        url: "./Proyectos?tipo=ejecucion&codSiaf=" + siaf,
        success: function (response) {
            var proceso, contrato, fechaCont, montoCont, proveedor, modalidad, residente, plazo, fechaTerre,
                    fechaIni, fechaFin, fechaFinNueva, tieneAmplia, tieneParaSusp, tieneAdelaDirec, tieneAdelaMater;
            if (response.estado) {
                if (!$.trim(response.proceso)) {
                    proceso = "";
                } else {
                    proceso = response.proceso;
                }
                if (!$.trim(response.contrato)) {
                    contrato = "";
                } else {
                    contrato = response.contrato;
                }
                if (!$.trim(response.fechaCont)) {
                    fechaCont = "";
                } else {
                    fechaCont = response.fechaCont;
                }
                if (!$.trim(response.montoCont)) {
                    montoCont = 0.00;
                } else {
                    montoCont = response.montoCont;
                }
                if (!$.trim(response.proveedor)) {
                    proveedor = "";
                } else {
                    proveedor = response.proveedor;
                }
                if (!$.trim(response.modalidad)) {
                    modalidad = "";
                } else {
                    modalidad = response.modalidad;
                }
                if (!$.trim(response.residCelular)) {
                    if (!$.trim(response.residNombre)) {
                        residente = "";
                    } else {
                        residente = response.residNombre;
                    }
                } else {
                    if (!$.trim(response.residNombre)) {
                        residente = "";
                    } else {
                        residente = response.residNombre + " (" + response.residCelular + ")";
                    }
                }
                if (!$.trim(response.fechaTerreno)) {
                    fechaTerre = "";
                } else {
                    fechaTerre = response.fechaTerreno;
                }
                if (!$.trim(response.fechaInicio)) {
                    fechaIni = "";
                } else {
                    fechaIni = response.fechaInicio;
                }
                if (!$.trim(response.plazo)) {
                    plazo = "";
                } else {
                    plazo = response.plazo;
                }
                if (!$.trim(response.fechaFin)) {
                    fechaFin = "";
                } else {
                    fechaFin = response.fechaFin;
                }
                if (!$.trim(response.fechaFinNueva)) {
                    fechaFinNueva = "";
                } else {
                    fechaFinNueva = response.fechaFinNueva;
                }
                if (!$.trim(response.tieneAmplia)) {
                    tieneAmplia = false;
                } else {
                    tieneAmplia = response.tieneAmplia;
                }
                if (!$.trim(response.tieneParaSusp)) {
                    tieneParaSusp = false;
                } else {
                    tieneParaSusp = response.tieneParaSusp;
                }
                if (!$.trim(response.tieneAdelaDirec)) {
                    tieneAdelaDirec = false;
                } else {
                    tieneAdelaDirec = response.tieneAdelaDirec;
                }
                if (!$.trim(response.tieneAdelaMater)) {
                    tieneAdelaMater = false;
                } else {
                    tieneAdelaMater = response.tieneAdelaMater;
                }
            } else {
                proceso = "";
                contrato = "";
                fechaCont = "";
                montoCont = "";
                proveedor = "";
                modalidad = "";
                residente = "";
                fechaTerre = "";
                fechaIni = "";
                plazo = "";
                fechaFin = "";
                fechaFinNueva = "";
                tieneAmplia = false;
                tieneParaSusp = false;
                tieneAdelaDirec = false;
                tieneAdelaMater = false;
            }
            ejecucion = '<div style="height: 32px;">\
                          <button id="btnProyFichaEjecuPdf" style="float: right;" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="Exportar a PDF">\
                            <span>\
                                <img src="./templates/plugins/datatables/images/pdf.png">\
                            </span>\
                          </button>\
                         </div>\
                         <div class="pad15">\
                         <div class="pad15">\
                           <div class="form-group row">\
                             <label class="col-sm-3 col-form-label ficha-sombreado1">PROCESO :</label>\
                             <label class="col-sm-9 col-form-label ficha-sombreado2">' + proceso + '</label>\
                           </div>\
                           <div class="form-group row">\
                             <label class="col-sm-3 col-form-label ficha-sombreado1">CONTRATO :</label>\
                             <label class="col-sm-9 col-form-label ficha-sombreado2">' + contrato + '</label>\
                           </div>\
                           <div class="form-group row">\
                             <label class="col-sm-3 col-form-label ficha-sombreado1">FECHA FIRMA CONTRATO :</label>\
                             <label class="col-sm-3 col-form-label ficha-sombreado2">' + fechaCont + '</label>\
                           </div>\
                           <div class="form-group row">\
                             <label class="col-sm-3 col-form-label ficha-sombreado1">MONTO CONTRATADO :</label>\
                             <label class="col-sm-3 col-form-label ficha-sombreado2">' + formatNumeroDecimal(montoCont) + '</label>\
                           </div>\
                           <div class="form-group row">\
                             <label class="col-sm-3 col-form-label ficha-sombreado1">PROVEEDOR :</label>\
                             <label class="col-sm-9 col-form-label ficha-sombreado2">' + proveedor + '</label>\
                           </div>\
                           <div class="form-group row">\
                             <label class="col-sm-3 col-form-label ficha-sombreado1">MODALIDAD CONTRATO :</label>\
                             <label class="col-sm-9 col-form-label ficha-sombreado2">' + modalidad + '</label>\
                           </div>\
                           <div class="form-group row">\
                             <label class="col-sm-3 col-form-label ficha-sombreado1">RESIDENTE DE OBRA :</label>\
                             <label class="col-sm-9 col-form-label ficha-sombreado2">' + residente + '</label>\
                           </div>\
                           <div class="form-group row">\
                             <label class="col-sm-3 col-form-label ficha-sombreado1">FECHA ENTREGA TERRENO :</label>\
                             <label class="col-sm-3 col-form-label ficha-sombreado2">' + fechaTerre + '</label>\
                           </div>\
                           <div class="form-group row">\
                             <label class="col-sm-3 col-form-label ficha-sombreado1">FECHA DE INICIO :</label>\
                             <label class="col-sm-3 col-form-label ficha-sombreado2">' + fechaIni + '</label>\
                           </div>\
                           <div class="form-group row">\
                             <label class="col-sm-3 col-form-label ficha-sombreado1">PLAZO EJECUCIÓN :</label>\
                             <label class="col-sm-3 col-form-label ficha-sombreado2">' + plazo + ' días</label>\
                           </div>\
                           <div class="form-group row">\
                             <label class="col-sm-3 col-form-label ficha-sombreado1">FECHA TÉRMINO OBRA :</label>\
                             <label class="col-sm-3 col-form-label ficha-sombreado2">' + fechaFin + '</label>\
                           </div>\
                           <div class="form-group row">\
                             <label class="col-sm-3 col-form-label ficha-sombreado1">NUEVA FECHA TÉRMINO OBRA :</label>\
                             <label class="col-sm-3 col-form-label ficha-sombreado2">' + fechaFinNueva + '</label>\
                           </div>\
                         </div>\
                         <div id="divTableProyFichaEjecuAmpliaciones"></div>\
                         <div id="divTableProyFichaEjecuParaliSuspen"></div>\
                         <div id="divTableProyFichaEjecuAdelaDirec"></div>\
                         <div id="divTableProyFichaEjecuAdelaMater"></div></div>';
            $('#divProyFichaRepEjecuObra').append(ejecucion);

            var muestraEjecuAdd = [];
            muestraEjecuAdd.push({text: ''});
            if (tieneAmplia) {
                var muestraEjecuAmpTbl = [];
                ejecucionAmplia = '<div style="overflow-x:auto;">\
                                     <table id="tableProyFichaAmplia" class="display" cellspacing="0" width="100%">\
                                        <thead>\
                                          <tr>\
                                            <th style="text-align: center; width: 50px;">Número</th>\
                                            <th style="text-align: center; width: 129px;">Fecha</th>\
                                            <th style="text-align: center; width: 70px;">Días</th>\
                                            <th style="text-align: center;">Documento</th>\
                                            <th style="text-align: center; width: 98px;">Estado</th>\
                                          </tr>\
                                        </thead>\
                                        <tbody id="tableProyFichaAmpliaBody"></tbody>\
                                        <tfoot id="tableProyFichaAmpliaFoot"></tfoot>\
                                     </table></br>\
                                   </div>';
                $('#divTableProyFichaEjecuAmpliaciones').append(ejecucionAmplia);
                var muestraEjecuAmpTblHead = [];
                muestraEjecuAmpTblHead.push({text: 'Número', style: 'tablaHead', alignment: 'center'});
                muestraEjecuAmpTblHead.push({text: 'Fecha', style: 'tablaHead', alignment: 'center'});
                muestraEjecuAmpTblHead.push({text: 'Días', style: 'tablaHead', alignment: 'center'});
                muestraEjecuAmpTblHead.push({text: 'Documento', style: 'tablaHead', alignment: 'center'});
                muestraEjecuAmpTblHead.push({text: 'Estado', style: 'tablaHead', alignment: 'center'});
                muestraEjecuAmpTbl.push(muestraEjecuAmpTblHead);
                var pramDiasT = 0;
                $.each(response.listAmplia, function (index, value) {
                    var muestraEjecuAmpTblBody = [];
                    var pramNro = value.pramNro;
                    var pramFecha;
                    if (!$.trim(value.pramFecha)) {
                        pramFecha = "";
                    } else {
                        pramFecha = value.pramFecha;
                    }
                    var pramDias;
                    if (!$.trim(value.pramDias)) {
                        pramDias = "";
                    } else {
                        pramDias = value.pramDias;
                        if (value.pramProcedente) {
                            pramDiasT += value.pramDias;
                        }
                    }
                    var pramDocumento = value.pramDocumento;
                    var pramProcedente, pramProcedentePdf;
                    if (value.pramProcedente) {
                        pramProcedente = '<span class="label label-success">Procedente</span>';
                        pramProcedentePdf = 'Procedente';
                    } else {
                        pramProcedente = '<span class="label label-danger">Improcedente</span>';
                        pramProcedentePdf = 'Improcedente';
                    }
                    var body = "<tr>\
                                  <td style='text-align: center;'>" + pramNro + "</td>\
                                  <td style='text-align: center;'>" + pramFecha + "</td>\
                                  <td style='text-align: center;'>" + pramDias + "</td>\
                                  <td style='text-align: left;'>" + pramDocumento + "</td>\
                                  <td style='text-align: center;'>" + pramProcedente + "</td>\
                                </tr>";
                    $("#tableProyFichaAmpliaBody").append(body);
                    muestraEjecuAmpTblBody.push({text: pramNro, style: 'tablaBody', alignment: 'center'});
                    muestraEjecuAmpTblBody.push({text: pramFecha, style: 'tablaBody', alignment: 'center'});
                    muestraEjecuAmpTblBody.push({text: pramDias, style: 'tablaBody', alignment: 'center'});
                    muestraEjecuAmpTblBody.push({text: pramDocumento, style: 'tablaBody', alignment: 'left'});
                    muestraEjecuAmpTblBody.push({text: pramProcedentePdf, style: 'tablaBody', alignment: 'center'});
                    muestraEjecuAmpTbl.push(muestraEjecuAmpTblBody);
                });

                var foot = "<tr class='total'>\
                              <td colspan='2' style='text-align: center;'><b>TOTAL</b></td>\
                              <td style='text-align: center;'><b>" + pramDiasT + "</b></td>\
                              <td></td>\
                              <td></td>\
                            </tr>";
                $("#tableProyFichaAmpliaFoot").append(foot);
                var muestraEjecuAmpTblFoot = [];
                muestraEjecuAmpTblFoot.push({text: 'TOTAL', style: 'tablaTotal', alignment: 'center', colSpan: 2});
                muestraEjecuAmpTblFoot.push("");
                muestraEjecuAmpTblFoot.push({text: pramDiasT, style: 'tablaTotal', alignment: 'center'});
                muestraEjecuAmpTblFoot.push("");
                muestraEjecuAmpTblFoot.push("");
                muestraEjecuAmpTbl.push(muestraEjecuAmpTblFoot);

                $('#tableProyFichaAmplia').dataTable({
                    ordering: false,
                    bPaginate: false,
                    dom: '<"centrar-div-tabla"<"labelDataTableAmp">B>rt',
                    buttons: [
                        {
                            extend: 'excel',
                            footer: true,
                            filename: 'ampliaciones_plazo_ejecucion_proyecto_' + siaf,
                            title: 'AMPLIACIONES DE PLAZO EN LA EJECUCIÓN',
                            headTop1: 'Código SIAF : ' + response.siaf,
                            headTop2: 'Código SNIP : ' + response.snip,
                            headTop3: 'Nombre Proyecto : ' + response.nombre,
                            exportOptions: {
                                orthogonal: 'sort',
                                columns: ':visible'
                            }
                        }
                    ]
                });
                $("div.labelDataTableAmp").html('<label class="col-form-label">AMPLIACIONES DE PLAZO</label>');

                muestraEjecuAdd.push({text: '\n'});
                muestraEjecuAdd.push({text: 'AMPLIACIONES DE PLAZO', alignment: 'left', style: 'subtitulo'});
                muestraEjecuAdd.push(
                        {
                            style: 'interlineado1',
                            table: {
                                widths: [50, 100, 50, '*', 80],
                                body: muestraEjecuAmpTbl
                            },
                            layout: {
                                hLineColor: '#ECECEC',
                                vLineColor: '#ECECEC'
                            }
                        });

            }

            if (tieneParaSusp) {
                var muestraEjecuParaSuspTbl = [];
                ejecucionParaSusp = '<div style="overflow-x:auto;">\
                                        <table id="tableProyFichaParaSusp" class="display" cellspacing="0" width="100%">\
                                           <thead>\
                                             <tr>\
                                               <th style="text-align: center; width: 50px;">Número</th>\
                                               <th style="text-align: center; width: 129px;">Fecha</th>\
                                               <th style="text-align: center; width: 70px;">Días</th>\
                                               <th style="text-align: center;">Documento</th>\
                                               <th style="text-align: center; width: 150px;">Tipo</th>\
                                             </tr>\
                                           </thead>\
                                           <tbody id="tableProyFichaParaSuspBody"></tbody>\
                                           <tfoot id="tableProyFichaParaSuspFoot"></tfoot>\
                                        </table></br>\
                                      </div>';
                $('#divTableProyFichaEjecuParaliSuspen').append(ejecucionParaSusp);
                var muestraEjecuParaSuspTblHead = [];
                muestraEjecuParaSuspTblHead.push({text: 'Número', style: 'tablaHead', alignment: 'center'});
                muestraEjecuParaSuspTblHead.push({text: 'Fecha', style: 'tablaHead', alignment: 'center'});
                muestraEjecuParaSuspTblHead.push({text: 'Días', style: 'tablaHead', alignment: 'center'});
                muestraEjecuParaSuspTblHead.push({text: 'Documento', style: 'tablaHead', alignment: 'center'});
                muestraEjecuParaSuspTblHead.push({text: 'Tipo', style: 'tablaHead', alignment: 'center'});
                muestraEjecuParaSuspTbl.push(muestraEjecuParaSuspTblHead);
                var prpsDiasT = 0;
                $.each(response.listParaSusp, function (index, value) {
                    var muestraEjecuParaSuspTblBody = [];
                    var prpsNro = value.prpsNro;
                    var prpsFecha;
                    if (!$.trim(value.prpsFecha)) {
                        prpsFecha = "";
                    } else {
                        prpsFecha = value.prpsFecha;
                    }
                    var prpsDias;
                    if (!$.trim(value.prpsDias)) {
                        prpsDias = "";
                    } else {
                        prpsDias = value.prpsDias;
                        prpsDiasT += value.prpsDias;
                    }
                    var prpsDocumento = value.prpsDocumento;
                    var prpsTipo = value.prpsTipo;
                    var body = "<tr>\
                                  <td style='text-align: center;'>" + prpsNro + "</td>\
                                  <td style='text-align: center;'>" + prpsFecha + "</td>\
                                  <td style='text-align: center;'>" + prpsDias + "</td>\
                                  <td style='text-align: left;'>" + prpsDocumento + "</td>\
                                  <td style='text-align: center;'>" + prpsTipo.toUpperCase() + "</td>\
                                </tr>";
                    $("#tableProyFichaParaSuspBody").append(body);
                    muestraEjecuParaSuspTblBody.push({text: prpsNro, style: 'tablaBody', alignment: 'center'});
                    muestraEjecuParaSuspTblBody.push({text: prpsFecha, style: 'tablaBody', alignment: 'center'});
                    muestraEjecuParaSuspTblBody.push({text: prpsDias, style: 'tablaBody', alignment: 'center'});
                    muestraEjecuParaSuspTblBody.push({text: prpsDocumento, style: 'tablaBody', alignment: 'left'});
                    muestraEjecuParaSuspTblBody.push({text: prpsTipo.toUpperCase(), style: 'tablaBody', alignment: 'center'});
                    muestraEjecuParaSuspTbl.push(muestraEjecuParaSuspTblBody);
                });

                var foot = "<tr class='total'>\
                              <td colspan='2' style='text-align: center;'><b>TOTAL</b></td>\
                              <td style='text-align: center;'><b>" + prpsDiasT + "</b></td>\
                              <td></td>\
                              <td></td>\
                            </tr>";
                $("#tableProyFichaParaSuspFoot").append(foot);
                var muestraEjecuParaSuspTblFoot = [];
                muestraEjecuParaSuspTblFoot.push({text: 'TOTAL', style: 'tablaTotal', alignment: 'center', colSpan: 2});
                muestraEjecuParaSuspTblFoot.push("");
                muestraEjecuParaSuspTblFoot.push({text: prpsDiasT, style: 'tablaTotal', alignment: 'center'});
                muestraEjecuParaSuspTblFoot.push("");
                muestraEjecuParaSuspTblFoot.push("");
                muestraEjecuParaSuspTbl.push(muestraEjecuParaSuspTblFoot);

                $('#tableProyFichaParaSusp').dataTable({
                    ordering: false,
                    bPaginate: false,
                    dom: '<"centrar-div-tabla"<"labelDataTableParaSusp">B>rt',
                    buttons: [
                        {
                            extend: 'excel',
                            footer: true,
                            filename: 'paralizaciones_suspensiones_ejecucion_proyecto_' + siaf,
                            title: 'PARALIZACIONES Y SUSPENSIONES EN LA EJECUCIÓN',
                            headTop1: 'Código SIAF : ' + response.siaf,
                            headTop2: 'Código SNIP : ' + response.snip,
                            headTop3: 'Nombre Proyecto : ' + response.nombre,
                            exportOptions: {
                                orthogonal: 'sort',
                                columns: ':visible'
                            }
                        }
                    ]
                });
                $("div.labelDataTableParaSusp").html('<label class="col-form-label">PARALIZACIONES Y SUSPENSIONES</label>');

                muestraEjecuAdd.push({text: '\n'});
                muestraEjecuAdd.push({text: 'PARALIZACIONES Y SUSPENSIONES', alignment: 'left', style: 'subtitulo'});
                muestraEjecuAdd.push(
                        {
                            style: 'interlineado1',
                            table: {
                                widths: [50, 100, 50, '*', 80],
                                body: muestraEjecuParaSuspTbl
                            },
                            layout: {
                                hLineColor: '#ECECEC',
                                vLineColor: '#ECECEC'
                            }
                        });

            }

            if (tieneAdelaDirec) {
                var muestraEjecuAdelaDirTbl = [];
                ejecucionAdelaDirec = '<div style="overflow-x:auto;">\
                                         <table id="tableProyFichaEjecAdelaDirec" class="display" cellspacing="0" width="100%">\
                                            <thead>\
                                              <tr>\
                                                <th style="text-align: center; width: 80px;">Número</th>\
                                                <th style="text-align: center; width: 160px;">Adelanto</th>\
                                                <th style="text-align: center; width: 129px;">Fecha</th>\
                                                <th style="text-align: center;">Comentario</th>\
                                              </tr>\
                                            </thead>\
                                            <tbody id="tableProyFichaEjecAdelaDirecBody"></tbody>\
                                            <tfoot id="tableProyFichaEjecAdelaDirecFoot"></tfoot>\
                                          </table></br>\
                                       </div>';
                $('#divTableProyFichaEjecuAdelaDirec').append(ejecucionAdelaDirec);
                var muestraEjecuAdelaDirTblHead = [];
                muestraEjecuAdelaDirTblHead.push({text: 'Número', style: 'tablaHead', alignment: 'center'});
                muestraEjecuAdelaDirTblHead.push({text: 'Adelanto', style: 'tablaHead', alignment: 'center'});
                muestraEjecuAdelaDirTblHead.push({text: 'Fecha', style: 'tablaHead', alignment: 'center'});
                muestraEjecuAdelaDirTblHead.push({text: 'Comentario', style: 'tablaHead', alignment: 'center'});
                muestraEjecuAdelaDirTbl.push(muestraEjecuAdelaDirTblHead);
                var prejadMontoT = 0.00;
                $.each(response.listEjecAdDir, function (index, value) {
                    var muestraEjecuAdelaDirTblBody = [];
                    var prejadNro = value.prejadNro;
                    var prejadMonto;
                    if (!$.trim(value.prejadMonto)) {
                        prejadMonto = "";
                    } else {
                        prejadMonto = formatNumeroDecimal(value.prejadMonto);
                        prejadMontoT += value.prejadMonto;
                    }
                    var prejadFecha;
                    if (!$.trim(value.prejadFecha)) {
                        prejadFecha = "";
                    } else {
                        prejadFecha = value.prejadFecha;
                    }
                    var prejadComentario = value.prejadComentario;
                    var body = "<tr>\
                                  <td style='text-align: center;'>" + prejadNro + "</td>\
                                  <td style='text-align: center;'>" + prejadMonto + "</td>\
                                  <td style='text-align: center;'>" + prejadFecha + "</td>\
                                  <td style='text-align: left;'>" + prejadComentario + "</td>\
                                </tr>";
                    $("#tableProyFichaEjecAdelaDirecBody").append(body);
                    muestraEjecuAdelaDirTblBody.push({text: prejadNro, style: 'tablaBody', alignment: 'center'});
                    muestraEjecuAdelaDirTblBody.push({text: prejadMonto, style: 'tablaBody', alignment: 'center'});
                    muestraEjecuAdelaDirTblBody.push({text: prejadFecha, style: 'tablaBody', alignment: 'center'});
                    muestraEjecuAdelaDirTblBody.push({text: prejadComentario, style: 'tablaBody', alignment: 'left'});
                    muestraEjecuAdelaDirTbl.push(muestraEjecuAdelaDirTblBody);
                });

                var foot = "<tr class='total'>\
                              <td style='text-align: center;'><b>TOTAL</b></td>\
                              <td style='text-align: center;'><b>" + formatNumeroDecimal(prejadMontoT) + "</b></td>\
                              <td></td>\
                              <td></td>\
                            </tr>";
                $("#tableProyFichaEjecAdelaDirecFoot").append(foot);
                var muestraEjecuAdelaDirTblFoot = [];
                muestraEjecuAdelaDirTblFoot.push({text: 'TOTAL', style: 'tablaTotal', alignment: 'center'});
                muestraEjecuAdelaDirTblFoot.push({text: formatNumeroDecimal(prejadMontoT), style: 'tablaTotal', alignment: 'center'});
                muestraEjecuAdelaDirTblFoot.push("");
                muestraEjecuAdelaDirTblFoot.push("");
                muestraEjecuAdelaDirTbl.push(muestraEjecuAdelaDirTblFoot);

                $('#tableProyFichaEjecAdelaDirec').dataTable({
                    ordering: false,
                    bPaginate: false,
                    dom: '<"centrar-div-tabla"<"labelDataTableAdelaDirec">B>rt',
                    buttons: [
                        {
                            extend: 'excel',
                            footer: true,
                            filename: 'adelantos_directos_ejecucion_proyecto_' + siaf,
                            title: 'ADELANTOS DIRECTOS EN LA EJECUCIÓN',
                            headTop1: 'Código SIAF : ' + response.siaf,
                            headTop2: 'Código SNIP : ' + response.snip,
                            headTop3: 'Nombre Proyecto : ' + response.nombre,
                            exportOptions: {
                                orthogonal: 'sort',
                                columns: ':visible'
                            },
                            customize: function (xlsx) {
                                var sheet = xlsx.xl.worksheets['sheet1.xml'];
                                for (var k = 1; k < 2; k++) {
                                    var total = $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).length;
                                    $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).each(function (i) {
                                        if (i > 0 && i < total - 1) {
                                            $(this).attr('s', '72');
                                        }
                                        if (i === total - 1) {
                                            $(this).attr('s', '75');
                                        }
                                    });
                                }
                            }
                        }
                    ]
                });
                $("div.labelDataTableAdelaDirec").html('<label class="col-form-label">ADELANTOS DIRECTOS</label>');

                muestraEjecuAdd.push({text: '\n'});
                muestraEjecuAdd.push({text: 'ADELANTOS DIRECTOS', alignment: 'left', style: 'subtitulo'});
                muestraEjecuAdd.push(
                        {
                            style: 'interlineado1',
                            table: {
                                widths: [50, 100, 100, '*'],
                                body: muestraEjecuAdelaDirTbl
                            },
                            layout: {
                                hLineColor: '#ECECEC',
                                vLineColor: '#ECECEC'
                            }
                        });

            }

            if (tieneAdelaMater) {
                var muestraEjecuAdelaMatTbl = [];
                ejecucionAdelaMater = '<div style="overflow-x:auto;">\
                                         <table id="tableProyFichaEjecAdelaMater" class="display" cellspacing="0" width="100%">\
                                            <thead>\
                                              <tr>\
                                                <th style="text-align: center; width: 80px;">Número</th>\
                                                <th style="text-align: center; width: 160px;">Adelanto</th>\
                                                <th style="text-align: center; width: 129px;">Fecha</th>\
                                                <th style="text-align: center;">Comentario</th>\
                                              </tr>\
                                            </thead>\
                                            <tbody id="tableProyFichaEjecAdelaMaterBody"></tbody>\
                                            <tfoot id="tableProyFichaEjecAdelaMaterFoot"></tfoot>\
                                          </table></br>\
                                       </div>';
                $('#divTableProyFichaEjecuAdelaMater').append(ejecucionAdelaMater);
                var muestraEjecuAdelaMatTblHead = [];
                muestraEjecuAdelaMatTblHead.push({text: 'Número', style: 'tablaHead', alignment: 'center'});
                muestraEjecuAdelaMatTblHead.push({text: 'Adelanto', style: 'tablaHead', alignment: 'center'});
                muestraEjecuAdelaMatTblHead.push({text: 'Fecha', style: 'tablaHead', alignment: 'center'});
                muestraEjecuAdelaMatTblHead.push({text: 'Comentario', style: 'tablaHead', alignment: 'center'});
                muestraEjecuAdelaMatTbl.push(muestraEjecuAdelaMatTblHead);
                var prejadMontoT = 0.00;
                $.each(response.listEjecAdMat, function (index, value) {
                    var muestraEjecuAdelaMatTblBody = [];
                    var prejadNro = value.prejadNro;
                    var prejadMonto;
                    if (!$.trim(value.prejadMonto)) {
                        prejadMonto = "";
                    } else {
                        prejadMonto = formatNumeroDecimal(value.prejadMonto);
                        prejadMontoT += value.prejadMonto;
                    }
                    var prejadFecha;
                    if (!$.trim(value.prejadFecha)) {
                        prejadFecha = "";
                    } else {
                        prejadFecha = value.prejadFecha;
                    }
                    var prejadComentario = value.prejadComentario;
                    var body = "<tr>\
                                  <td style='text-align: center;'>" + prejadNro + "</td>\
                                  <td style='text-align: center;'>" + prejadMonto + "</td>\
                                  <td style='text-align: center;'>" + prejadFecha + "</td>\
                                  <td style='text-align: left;'>" + prejadComentario + "</td>\
                                </tr>";
                    $("#tableProyFichaEjecAdelaMaterBody").append(body);
                    muestraEjecuAdelaMatTblBody.push({text: prejadNro, style: 'tablaBody', alignment: 'center'});
                    muestraEjecuAdelaMatTblBody.push({text: prejadMonto, style: 'tablaBody', alignment: 'center'});
                    muestraEjecuAdelaMatTblBody.push({text: prejadFecha, style: 'tablaBody', alignment: 'center'});
                    muestraEjecuAdelaMatTblBody.push({text: prejadComentario, style: 'tablaBody', alignment: 'left'});
                    muestraEjecuAdelaMatTbl.push(muestraEjecuAdelaMatTblBody);
                });

                var foot = "<tr class='total'>\
                              <td style='text-align: center;'><b>TOTAL</b></td>\
                              <td style='text-align: center;'><b>" + formatNumeroDecimal(prejadMontoT) + "</b></td>\
                              <td></td>\
                              <td></td>\
                            </tr>";
                $("#tableProyFichaEjecAdelaMaterFoot").append(foot);
                var muestraEjecuAdelaMatTblFoot = [];
                muestraEjecuAdelaMatTblFoot.push({text: 'TOTAL', style: 'tablaTotal', alignment: 'center'});
                muestraEjecuAdelaMatTblFoot.push({text: formatNumeroDecimal(prejadMontoT), style: 'tablaTotal', alignment: 'center'});
                muestraEjecuAdelaMatTblFoot.push("");
                muestraEjecuAdelaMatTblFoot.push("");
                muestraEjecuAdelaMatTbl.push(muestraEjecuAdelaMatTblFoot);

                $('#tableProyFichaEjecAdelaMater').dataTable({
                    ordering: false,
                    bPaginate: false,
                    dom: '<"centrar-div-tabla"<"labelDataTableAdelaMater">B>rt',
                    buttons: [
                        {
                            extend: 'excel',
                            footer: true,
                            filename: 'adelantos_material_ejecucion_proyecto_' + siaf,
                            title: 'ADELANTOS DE MATERIAL EN LA EJECUCIÓN',
                            headTop1: 'Código SIAF : ' + response.siaf,
                            headTop2: 'Código SNIP : ' + response.snip,
                            headTop3: 'Nombre Proyecto : ' + response.nombre,
                            exportOptions: {
                                orthogonal: 'sort',
                                columns: ':visible'
                            },
                            customize: function (xlsx) {
                                var sheet = xlsx.xl.worksheets['sheet1.xml'];
                                for (var k = 1; k < 2; k++) {
                                    var total = $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).length;
                                    $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).each(function (i) {
                                        if (i > 0 && i < total - 1) {
                                            $(this).attr('s', '72');
                                        }
                                        if (i === total - 1) {
                                            $(this).attr('s', '75');
                                        }
                                    });
                                }
                            }
                        }
                    ]
                });
                $("div.labelDataTableAdelaMater").html('<label class="col-form-label">ADELANTOS DE MATERIAL</label>');

                muestraEjecuAdd.push({text: '\n'});
                muestraEjecuAdd.push({text: 'ADELANTOS DE MATERIAL', alignment: 'left', style: 'subtitulo'});
                muestraEjecuAdd.push(
                        {
                            style: 'interlineado1',
                            table: {
                                widths: [50, 100, 100, '*'],
                                body: muestraEjecuAdelaMatTbl
                            },
                            layout: {
                                hLineColor: '#ECECEC',
                                vLineColor: '#ECECEC'
                            }
                        });

            }

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
            $("#btnProyFichaEjecuPdf").on('click', function () {
                var docDefinition = {
                    pageOrientation: 'landscape',
                    info: {
                        title: 'ejecucion_obra_proyecto_' + siaf
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
                                        {text: 'EJECUCIÓN DE OBRA DE PROYECTO', alignment: 'center', style: 'tituloU'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            style: 'interlineado1',
                            table: {
                                widths: [90, '*', 60, 90, '*'],
                                body: [
                                    [
                                        {text: 'CODIGO SIAF :', alignment: 'left', style: 'sombreado1'},
                                        {text: response.siaf, alignment: 'left', style: 'sombreado2'},
                                        "",
                                        {text: 'CODIGO SNIP :', alignment: 'left', style: 'sombreado1'},
                                        {text: response.snip, alignment: 'left', style: 'sombreado2'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            style: 'interlineado',
                            table: {
                                widths: [90, '*'],
                                body: [
                                    [
                                        {text: 'NOMBRE PROYECTO :', alignment: 'left', style: 'sombreado1'},
                                        {text: response.nombre, alignment: 'left', style: 'sombreado2'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            style: 'interlineado',
                            table: {
                                widths: [80, '*', 60, 80, '*'],
                                body: [
                                    [
                                        {text: 'PROCESO :', alignment: 'left', style: 'sombreado1'},
                                        {text: proceso, alignment: 'left', style: 'sombreado2'},
                                        "",
                                        {text: 'CONTRATO :', alignment: 'left', style: 'sombreado1'},
                                        {text: contrato, alignment: 'left', style: 'sombreado2'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            style: 'interlineado',
                            table: {
                                widths: [110, '*', 60, 110, '*'],
                                body: [
                                    [
                                        {text: 'FECHA FIRMA CONTRATO :', alignment: 'left', style: 'sombreado1'},
                                        {text: fechaCont, alignment: 'left', style: 'sombreado2'},
                                        "",
                                        {text: 'MONTO CONTRATADO :', alignment: 'left', style: 'sombreado1'},
                                        {text: formatNumeroDecimal(montoCont), alignment: 'left', style: 'sombreado2'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            style: 'interlineado',
                            table: {
                                widths: [80, '*', 60, 80, '*'],
                                body: [
                                    [
                                        {text: 'PROVEEDOR :', alignment: 'left', style: 'sombreado1'},
                                        {text: proveedor, alignment: 'left', style: 'sombreado2'},
                                        "",
                                        {text: 'MODALIDAD CONTRATO :', alignment: 'left', style: 'sombreado1'},
                                        {text: modalidad, alignment: 'left', style: 'sombreado2'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            style: 'interlineado',
                            table: {
                                widths: [110, '*', 60, 110, '*'],
                                body: [
                                    [
                                        {text: 'RESIDENTE DE OBRA :', alignment: 'left', style: 'sombreado1'},
                                        {text: residente, alignment: 'left', style: 'sombreado2'},
                                        "",
                                        {text: 'FECHA ENTREGA TERRENO :', alignment: 'left', style: 'sombreado1'},
                                        {text: fechaTerre, alignment: 'left', style: 'sombreado2'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            style: 'interlineado',
                            table: {
                                widths: [100, '*', 60, 100, '*'],
                                body: [
                                    [
                                        {text: 'FECHA DE INICIO :', alignment: 'left', style: 'sombreado1'},
                                        {text: fechaIni, alignment: 'left', style: 'sombreado2'},
                                        "",
                                        {text: 'PLAZO EJECUCIÓN :', alignment: 'left', style: 'sombreado1'},
                                        {text: plazo, alignment: 'left', style: 'sombreado2'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            style: 'interlineado',
                            table: {
                                widths: [110, '*', 60, 110, '*'],
                                body: [
                                    [
                                        {text: 'FECHA TÉRMINO OBRA :', alignment: 'left', style: 'sombreado1'},
                                        {text: fechaFin, alignment: 'left', style: 'sombreado2'},
                                        "",
                                        {text: 'NUEVA FECHA TÉRMINO OBRA ::', alignment: 'left', style: 'sombreado1'},
                                        {text: fechaFinNueva, alignment: 'left', style: 'sombreado2'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        muestraEjecuAdd
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
                            fontSize: 8,
                            bold: true,
                            color: '#334A74',
                            decoration: 'underline'
                        },
                        subtitulo: {
                            fontSize: 7,
                            bold: true,
                            color: '#334A74'
                        },
                        subtituloU: {
                            fontSize: 7,
                            bold: true,
                            color: '#334A74',
                            decoration: 'underline'
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
                        subHeader: {
                            color: 'white',
                            fillColor: '#587BA0',
                            fontSize: 6,
                            bold: true
                        },
                        subFooter: {
                            fillColor: '#D2DBE5',
                            fontSize: 6
                        },
                        tablaTotal: {
                            fillColor: '#F6F6F6',
                            fontSize: 6,
                            bold: true
                        },
                        pie: {
                            fontSize: 5
                        },
                        interlineado: {
                            margin: [0, 2, 0, 2]
                        },
                        interlineado1: {
                            margin: [0, 5, 0, 2]
                        }
                    }
                };
                pdfMake.createPdf(docDefinition).open();
            });

        }
    });

}

function llenar_proy_ficha_avan_fisico(siaf) {
    $('#divProyFichaRepAvanFisico').empty();
    avance = '<div style="height: 32px;">\
                <button id="btnProyFichaAvanFisPdf" style="float: right;" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="Exportar a PDF">\
                  <span>\
                    <img src="./templates/plugins/datatables/images/pdf.png">\
                  </span>\
                </button>\
               </div>\
               <div class="pad15">\
               <div>\
                <div style="overflow-x:auto;">\
                  <table id="tableProyFichaAvanFisComp" class="display" cellspacing="0" width="100%">\
                    <thead>\
                      <tr>\
                        <th style="text-align: center; width: 20px;">N°</th>\
                        <th style="text-align: center;">Componente</th>\
                        <th style="text-align: center; width: 100px;">Monto Viable</th>\
                        <th style="text-align: center; width: 100px;">Monto Estudio Definitivo</th>\
                        <th style="text-align: center; width: 100px;">Monto Contratado</th>\
                        <th style="text-align: center; width: 100px;">Monto Actualizado</th>\
                        <th style="text-align: center; width: 100px;">Monto Ejecutado</th>\
                        <th style="text-align: center; width: 100px;">Avance %</th>\
                        <th style="text-align: center;">Comentario</th>\
                      </tr>\
                    </thead>\
                    <tbody id="tableProyFichaAvanFisCompBody"></tbody>\
                    <tfoot id="tableProyFichaAvanFisCompFoot"></tfoot>\
                  </table\
                </div></br>\
                <div id="divProyFichaAvanFisPerio" style="overflow-x:auto;"></div>\
                </br>\
                <div id="divProyFichaAvanFisPerioImg"></div>\
              </div></div>';
    $('#divProyFichaRepAvanFisico').append(avance);

    $.ajax({
        dataType: 'json',
        url: "./Proyectos?tipo=avance_fisico&codSiaf=" + siaf,
        success: function (response) {
            var prcpMontoViable1T = 0.00;
            var prcpMontoEstudio1T = 0.00;
            var prcpMontoContratado1T = 0.00;
            var prcpMontoActualizado1T = 0.00;
            var prvaMontoEjecutado1T = 0.00;
            var avance1T = 0.00;
            var muestraAvanFisAdd = [];
            muestraAvanFisAdd.push({text: ''});
            var muestraAvanFisCompTbl = [];
            var muestraAvanFisCompTblHead = [];
            muestraAvanFisCompTblHead.push({text: 'N°', style: 'tablaHead', alignment: 'center'});
            muestraAvanFisCompTblHead.push({text: 'Componente', style: 'tablaHead', alignment: 'center'});
            muestraAvanFisCompTblHead.push({text: 'Monto Viable', style: 'tablaHead', alignment: 'center'});
            muestraAvanFisCompTblHead.push({text: 'Monto Estudio Definitivo', style: 'tablaHead', alignment: 'center'});
            muestraAvanFisCompTblHead.push({text: 'Monto Contratado', style: 'tablaHead', alignment: 'center'});
            muestraAvanFisCompTblHead.push({text: 'Monto Actualizado', style: 'tablaHead', alignment: 'center'});
            muestraAvanFisCompTblHead.push({text: 'Monto Ejecutado', style: 'tablaHead', alignment: 'center'});
            muestraAvanFisCompTblHead.push({text: 'Avance %', style: 'tablaHead', alignment: 'center'});
            muestraAvanFisCompTblHead.push({text: 'Comentario', style: 'tablaHead', alignment: 'center'});
            muestraAvanFisCompTbl.push(muestraAvanFisCompTblHead);
            $.each(response.listComponAvan, function (index, value) {
                var muestraAvanFisCompTblBody = [];
                var prcpOrden = value.prcpOrden;
                var prcpComponente = value.prcpComponente;
                var prcpMontoViable;
                if (!$.trim(value.prcpMontoViable)) {
                    prcpMontoViable = "";
                } else {
                    prcpMontoViable = value.prcpMontoViable;
                    prcpMontoViable1T += value.prcpMontoViable;
                }
                var prcpMontoEstudio;
                if (!$.trim(value.prcpMontoEstudio)) {
                    prcpMontoEstudio = "";
                } else {
                    prcpMontoEstudio = value.prcpMontoEstudio;
                    prcpMontoEstudio1T += value.prcpMontoEstudio;
                }
                var prcpMontoContratado;
                if (!$.trim(value.prcpMontoContratado)) {
                    prcpMontoContratado = "";
                } else {
                    prcpMontoContratado = value.prcpMontoContratado;
                    prcpMontoContratado1T += value.prcpMontoContratado;
                }
                var prcpMontoActualizado;
                if (!$.trim(value.prcpMontoActualizado)) {
                    prcpMontoActualizado = "";
                } else {
                    prcpMontoActualizado = value.prcpMontoActualizado;
                    prcpMontoActualizado1T += value.prcpMontoActualizado;
                }
                var prvaMontoEjecutado;
                var avance;
                if (!$.trim(value.prvaMontoEjecutado)) {
                    prvaMontoEjecutado = "";
                    avance = 0.00;
                } else {
                    prvaMontoEjecutado = value.prvaMontoEjecutado;
                    prvaMontoEjecutado1T += value.prvaMontoEjecutado;
                    if (!$.trim(value.prcpMontoContratado)) {
                        avance = 0.00;
                    } else {
                        avance = (prvaMontoEjecutado / prcpMontoContratado) * 100;
                    }
                }
                var prcpComentarios;
                if (!$.trim(value.prcpComentarios)) {
                    prcpComentarios = "";
                } else {
                    prcpComentarios = value.prcpComentarios;
                }
                var body1 = "<tr>\
                              <td style='text-align: center;'>" + prcpOrden + "</td>\
                              <td style='text-align: left;'>" + prcpComponente + "</td>\
                              <td style='text-align: right;'>" + formatNumeroDecimal(prcpMontoViable) + "</td>\
                              <td style='text-align: right;'>" + formatNumeroDecimal(prcpMontoEstudio) + "</td>\
                              <td style='text-align: right;'>" + formatNumeroDecimal(prcpMontoContratado) + "</td>\
                              <td style='text-align: right;'>" + formatNumeroDecimal(prcpMontoActualizado) + "</td>\
                              <td style='text-align: right;'>" + formatNumeroDecimal(prvaMontoEjecutado) + "</td>\
                              <td style='text-align: center;'><b>" + formatNumeroDecimal(avance) + "</b></td>\
                              <td style='text-align: left;'>" + prcpComentarios + "</td>\
                             </tr>";
                $("#tableProyFichaAvanFisCompBody").append(body1);
                muestraAvanFisCompTblBody.push({text: prcpOrden, style: 'tablaBody', alignment: 'center'});
                muestraAvanFisCompTblBody.push({text: prcpComponente, style: 'tablaBody', alignment: 'left'});
                muestraAvanFisCompTblBody.push({text: formatNumeroDecimal(prcpMontoViable), style: 'tablaBody', alignment: 'right'});
                muestraAvanFisCompTblBody.push({text: formatNumeroDecimal(prcpMontoEstudio), style: 'tablaBody', alignment: 'right'});
                muestraAvanFisCompTblBody.push({text: formatNumeroDecimal(prcpMontoContratado), style: 'tablaBody', alignment: 'right'});
                muestraAvanFisCompTblBody.push({text: formatNumeroDecimal(prcpMontoActualizado), style: 'tablaBody', alignment: 'right'});
                muestraAvanFisCompTblBody.push({text: formatNumeroDecimal(prvaMontoEjecutado), style: 'tablaBody', alignment: 'right'});
                muestraAvanFisCompTblBody.push({text: formatNumeroDecimal(avance), style: 'tablaBodyN', alignment: 'center'});
                muestraAvanFisCompTblBody.push({text: prcpComentarios, style: 'tablaBody', alignment: 'left'});
                muestraAvanFisCompTbl.push(muestraAvanFisCompTblBody);
            });
            if (prvaMontoEjecutado1T === 0.00) {
                avance1T = 0.00;
            } else {
                if (prcpMontoContratado1T === 0.00) {
                    avance1T = 0.00;
                } else {
                    avance1T = (prvaMontoEjecutado1T / prcpMontoContratado1T) * 100;
                }
            }
            var foot1 = "<tr class='total'>\
                          <td colspan='2' style='text-align: center;'><b>TOTAL</b></td>\
                          <td style='text-align: right;'><b>" + formatNumeroDecimal(prcpMontoViable1T) + "</b></td>\
                          <td style='text-align: right;'><b>" + formatNumeroDecimal(prcpMontoEstudio1T) + "</b></td>\
                          <td style='text-align: right;'><b>" + formatNumeroDecimal(prcpMontoContratado1T) + "</b></td>\
                          <td style='text-align: right;'><b>" + formatNumeroDecimal(prcpMontoActualizado1T) + "</b></td>\
                          <td style='text-align: right;'><b>" + formatNumeroDecimal(prvaMontoEjecutado1T) + "</b></td>\
                          <td style='text-align: center;'><b>" + formatNumeroDecimal(avance1T) + "</b></td>\
                          <td></td>\
                         </tr>";
            $("#tableProyFichaAvanFisCompFoot").append(foot1);
            var muestraAvanFisCompTblFoot = [];
            muestraAvanFisCompTblFoot.push({text: 'TOTAL', style: 'tablaTotal', alignment: 'center', colSpan: 2});
            muestraAvanFisCompTblFoot.push("");
            muestraAvanFisCompTblFoot.push({text: formatNumeroDecimal(prcpMontoViable1T), style: 'tablaTotal', alignment: 'right'});
            muestraAvanFisCompTblFoot.push({text: formatNumeroDecimal(prcpMontoEstudio1T), style: 'tablaTotal', alignment: 'right'});
            muestraAvanFisCompTblFoot.push({text: formatNumeroDecimal(prcpMontoContratado1T), style: 'tablaTotal', alignment: 'right'});
            muestraAvanFisCompTblFoot.push({text: formatNumeroDecimal(prcpMontoActualizado1T), style: 'tablaTotal', alignment: 'right'});
            muestraAvanFisCompTblFoot.push({text: formatNumeroDecimal(prvaMontoEjecutado1T), style: 'tablaTotal', alignment: 'right'});
            muestraAvanFisCompTblFoot.push({text: formatNumeroDecimal(avance1T), style: 'tablaTotal', alignment: 'center'});
            muestraAvanFisCompTblFoot.push("");
            muestraAvanFisCompTbl.push(muestraAvanFisCompTblFoot);

            $('#tableProyFichaAvanFisComp').dataTable({
                ordering: false,
                bPaginate: false,
                dom: '<"centrar-div-tabla"<"labelDataTableAvanFisxComp">B>rt',
                buttons: [
                    {
                        extend: 'excel',
                        footer: true,
                        filename: 'avance_fisico_x_componente_proyecto_' + siaf,
                        title: 'AVANCE FÍSICO POR COMPONENTE',
                        headTop1: 'Código SIAF : ' + response.siaf,
                        headTop2: 'Código SNIP : ' + response.snip,
                        headTop3: 'Nombre Proyecto : ' + response.nombre,
                        exportOptions: {
                            orthogonal: 'sort',
                            columns: ':visible'
                        },
                        customize: function (xlsx) {
                            var sheet = xlsx.xl.worksheets['sheet1.xml'];
                            for (var k = 2; k < 7; k++) {
                                var total = $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).length;
                                $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).each(function (i) {
                                    if (i > 0 && i < total - 1) {
                                        $(this).attr('s', '72');
                                    }
                                    if (i === total - 1) {
                                        $(this).attr('s', '75');
                                    }
                                });
                            }
                            for (var k = 7; k < 8; k++) {
                                var total = $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).length;
                                $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).each(function (i) {
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
            $("div.labelDataTableAvanFisxComp").html('<label class="col-form-label">AVANCE FÍSICO POR COMPONENTE</label>');

            muestraAvanFisAdd.push({text: '\n'});
            muestraAvanFisAdd.push({text: 'AVANCE FÍSICO POR COMPONENTE', alignment: 'left', style: 'subtitulo'});
            muestraAvanFisAdd.push(
                    {
                        style: 'interlineado1',
                        table: {
                            widths: [20, '*', 50, 50, 50, 50, 50, 40, '*'],
                            body: muestraAvanFisCompTbl
                        },
                        layout: {
                            hLineColor: '#ECECEC',
                            vLineColor: '#ECECEC'
                        }
                    });

            if (response.estado) {
                var muestraAvanFisPerioTbl = [];
                var table = '<table id="tableProyFichaAvanFisPerio" class="display" cellspacing="0" width="100%">\
                              <thead>\
                                <tr>\
                                  <th rowspan="2" style="text-align: center; width: 50px;">Orden</th>\
                                  <th rowspan="2" style="text-align: center; width: 130px;">Periodo</th>\
                                  <th colspan="3" style="text-align: center;">PROGRAMADO</th>\
                                  <th colspan="3" style="text-align: center;">EJECUTADO</th>\
                                  <th rowspan="2" style="text-align: center; width: 130px;">Valorización Pagada</th>\
                                </tr>\
                                <tr>\
                                  <th style="text-align: center;">Parcial</th>\
                                  <th style="text-align: center;">Acumulado</th>\
                                  <th style="text-align: center;">Avance %</th>\
                                  <th style="text-align: center;">Parcial</th>\
                                  <th style="text-align: center;">Acumulado</th>\
                                  <th style="text-align: center;">Avance %</th>\
                                </tr>\
                              </thead>\
                              <tbody id="tableProyFichaAvanFisPerioBody"></tbody>\
                              <tfoot id="tableProyFichaAvanFisPerioFoot"></tfoot>\
                             </table>';
                $("#divProyFichaAvanFisPerio").append(table);

                var muestraAvanFisPerioTblHead1 = [];
                muestraAvanFisPerioTblHead1.push({text: 'Orden', style: 'tablaHead', alignment: 'center', rowSpan: 2});
                muestraAvanFisPerioTblHead1.push({text: 'Periodo', style: 'tablaHead', alignment: 'center', rowSpan: 2});
                muestraAvanFisPerioTblHead1.push({text: 'PROGRAMADO', style: 'tablaHead', alignment: 'center', colSpan: 3});
                muestraAvanFisPerioTblHead1.push("");
                muestraAvanFisPerioTblHead1.push("");
                muestraAvanFisPerioTblHead1.push({text: 'EJECUTADO', style: 'tablaHead', alignment: 'center', colSpan: 3});
                muestraAvanFisPerioTblHead1.push("");
                muestraAvanFisPerioTblHead1.push("");
                muestraAvanFisPerioTblHead1.push({text: 'Valorización Pagada', style: 'tablaHead', alignment: 'center', rowSpan: 2});
                muestraAvanFisPerioTbl.push(muestraAvanFisPerioTblHead1);

                var muestraAvanFisPerioTblHead2 = [];
                muestraAvanFisPerioTblHead2.push("");
                muestraAvanFisPerioTblHead2.push("");
                muestraAvanFisPerioTblHead2.push({text: 'Parcial', style: 'tablaHead', alignment: 'center'});
                muestraAvanFisPerioTblHead2.push({text: 'Acumulado', style: 'tablaHead', alignment: 'center'});
                muestraAvanFisPerioTblHead2.push({text: 'Avance %', style: 'tablaHead', alignment: 'center'});
                muestraAvanFisPerioTblHead2.push({text: 'Parcial', style: 'tablaHead', alignment: 'center'});
                muestraAvanFisPerioTblHead2.push({text: 'Acumulado', style: 'tablaHead', alignment: 'center'});
                muestraAvanFisPerioTblHead2.push({text: 'Avance %', style: 'tablaHead', alignment: 'center'});
                muestraAvanFisPerioTblHead2.push("");
                muestraAvanFisPerioTbl.push(muestraAvanFisPerioTblHead2);

                var prvaMontoProgramado2T = 0.00;
                var prvaMontoEjecutado2T = 0.00;
                var prvaMontoPagado2T = 0.00;
                $.each(response.listCalendar, function (index, value) {
                    var muestraAvanFisPerioTblBody = [];
                    var prpeAno = value.prpeAno;
                    var prpeMes = value.prpeMes;
                    var prpeNombreMes = value.nombreMes;
                    var prvaMontoProgramado;
                    if (!$.trim(value.prvaMontoProgramado)) {
                        prvaMontoProgramado = "";
                    } else {
                        prvaMontoProgramado = value.prvaMontoProgramado;
                        prvaMontoProgramado2T += value.prvaMontoProgramado;
                    }
                    var prvaMontoEjecutado;
                    if (!$.trim(value.prvaMontoEjecutado)) {
                        prvaMontoEjecutado = "";
                    } else {
                        prvaMontoEjecutado = value.prvaMontoEjecutado;
                        prvaMontoEjecutado2T += value.prvaMontoEjecutado;
                    }
                    var prvaMontoPagado;
                    if (!$.trim(value.prvaMontoPagado)) {
                        prvaMontoPagado = "";
                    } else {
                        prvaMontoPagado = value.prvaMontoPagado;
                        prvaMontoPagado2T += value.prvaMontoPagado;
                    }
                    var body2 = "<tr>\
                                    <td style='text-align: center;'>" + (index + 1) + "</td>\
                                    <td style='text-align: center;'>" + prpeNombreMes + " - " + prpeAno + "</td>\
                                    <td style='text-align: right;'>" + formatNumeroDecimal(prvaMontoProgramado) + "</td>\
                                    <td style='text-align: right;'>" + formatNumeroDecimal(prvaMontoProgramado2T) + "</td>\
                                    <td style='text-align: center;'><b>" + formatNumeroDecimal((prvaMontoProgramado2T / prcpMontoContratado1T) * 100) + "</b></td>\
                                    <td style='text-align: right;'>" + formatNumeroDecimal(prvaMontoEjecutado) + "</td>\
                                    <td style='text-align: right;'>" + formatNumeroDecimal(prvaMontoEjecutado2T) + "</td>\
                                    <td style='text-align: center;'><b>" + formatNumeroDecimal((prvaMontoEjecutado2T / prcpMontoContratado1T) * 100) + "</b></td>\
                                    <td style='text-align: right;'>" + formatNumeroDecimal(prvaMontoPagado) + "</td>\
                                  </tr>";
                    $("#tableProyFichaAvanFisPerioBody").append(body2);
                    muestraAvanFisPerioTblBody.push({text: (index + 1), style: 'tablaBody', alignment: 'center'});
                    muestraAvanFisPerioTblBody.push({text: prpeNombreMes + " - " + prpeAno, style: 'tablaBody', alignment: 'center'});
                    muestraAvanFisPerioTblBody.push({text: formatNumeroDecimal(prvaMontoProgramado), style: 'tablaBody', alignment: 'right'});
                    muestraAvanFisPerioTblBody.push({text: formatNumeroDecimal(prvaMontoProgramado2T), style: 'tablaBody', alignment: 'right'});
                    muestraAvanFisPerioTblBody.push({text: formatNumeroDecimal((prvaMontoProgramado2T / prcpMontoContratado1T) * 100), style: 'tablaBodyN', alignment: 'center'});
                    muestraAvanFisPerioTblBody.push({text: formatNumeroDecimal(prvaMontoEjecutado), style: 'tablaBody', alignment: 'right'});
                    muestraAvanFisPerioTblBody.push({text: formatNumeroDecimal(prvaMontoEjecutado2T), style: 'tablaBody', alignment: 'right'});
                    muestraAvanFisPerioTblBody.push({text: formatNumeroDecimal((prvaMontoEjecutado2T / prcpMontoContratado1T) * 100), style: 'tablaBodyN', alignment: 'center'});
                    muestraAvanFisPerioTblBody.push({text: formatNumeroDecimal(prvaMontoPagado), style: 'tablaBody', alignment: 'right'});
                    muestraAvanFisPerioTbl.push(muestraAvanFisPerioTblBody);
                });
                var foot2 = "<tr class='total'>\
                          <td colspan='2' style='text-align: center;'><b>TOTAL</b></td>\
                          <td style='text-align: right;'><b>" + formatNumeroDecimal(prvaMontoProgramado2T) + "</b></td>\
                          <td></td>\
                          <td></td>\
                          <td style='text-align: right;'><b>" + formatNumeroDecimal(prvaMontoEjecutado2T) + "</b></td>\
                          <td></td>\
                          <td></td>\
                          <td style='text-align: right;'><b>" + formatNumeroDecimal(prvaMontoPagado2T) + "</b></td>\
                         </tr>";
                $("#tableProyFichaAvanFisPerioFoot").append(foot2);
                var muestraAvanFisPerioTblFoot = [];
                muestraAvanFisPerioTblFoot.push({text: 'TOTAL', style: 'tablaTotal', alignment: 'center', colSpan: 2});
                muestraAvanFisPerioTblFoot.push("");
                muestraAvanFisPerioTblFoot.push({text: formatNumeroDecimal(prvaMontoProgramado2T), style: 'tablaTotal', alignment: 'right'});
                muestraAvanFisPerioTblFoot.push("");
                muestraAvanFisPerioTblFoot.push("");
                muestraAvanFisPerioTblFoot.push({text: formatNumeroDecimal(prvaMontoEjecutado2T), style: 'tablaTotal', alignment: 'right'});
                muestraAvanFisPerioTblFoot.push("");
                muestraAvanFisPerioTblFoot.push("");
                muestraAvanFisPerioTblFoot.push({text: formatNumeroDecimal(prvaMontoPagado2T), style: 'tablaTotal', alignment: 'right'});
                muestraAvanFisPerioTbl.push(muestraAvanFisPerioTblFoot);

                $('#tableProyFichaAvanFisPerio').dataTable({
                    ordering: false,
                    bPaginate: false,
                    dom: '<"centrar-div-tabla"<"labelDataTableAvanFisxPeri">B>rt',
                    buttons: [
                        {
                            extend: 'excel',
                            footer: true,
                            filename: 'avance_fisico_x_periodo_proyecto_' + siaf,
                            title: 'AVANCE FÍSICO POR PERÍODO DE EJECUCIÓN',
                            headTop1: 'Código SIAF : ' + response.siaf,
                            headTop2: 'Código SNIP : ' + response.snip,
                            headTop3: 'Nombre Proyecto : ' + response.nombre,
                            exportOptions: {
                                orthogonal: 'sort',
                                columns: ':visible'
                            },
                            customize: function (xlsx) {
                                var sheet = xlsx.xl.worksheets['sheet1.xml'];
                                for (var k = 2; k < 3; k++) {
                                    var total = $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).length;
                                    $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).each(function (i) {
                                        if (i > 0 && i < total - 1) {
                                            $(this).attr('s', '72');
                                        }
                                        if (i === total - 1) {
                                            $(this).attr('s', '75');
                                        }
                                    });
                                }
                                for (var k = 3; k < 4; k++) {
                                    var total = $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).length;
                                    $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).each(function (i) {
                                        if (i > 0 && i < total) {
                                            $(this).attr('s', '72');
                                        }
                                    });
                                }
                                for (var k = 4; k < 5; k++) {
                                    var total = $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).length;
                                    $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).each(function (i) {
                                        if (i > 0 && i < total) {
                                            $(this).attr('s', '73');
                                        }
                                    });
                                }
                                for (var k = 5; k < 6; k++) {
                                    var total = $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).length;
                                    $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).each(function (i) {
                                        if (i > 0 && i < total - 1) {
                                            $(this).attr('s', '72');
                                        }
                                        if (i === total - 1) {
                                            $(this).attr('s', '75');
                                        }
                                    });
                                }
                                for (var k = 6; k < 7; k++) {
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
                                for (var k = 8; k < 9; k++) {
                                    var total = $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).length;
                                    $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).each(function (i) {
                                        if (i > 0 && i < total - 1) {
                                            $(this).attr('s', '72');
                                        }
                                        if (i === total - 1) {
                                            $(this).attr('s', '75');
                                        }
                                    });
                                }
                            }
                        }
                    ]
                });
                $("div.labelDataTableAvanFisxPeri").html('<label class="col-form-label">AVANCE FÍSICO POR PERIODO</label>');

                muestraAvanFisAdd.push({text: '\n'});
                muestraAvanFisAdd.push({text: 'AVANCE FÍSICO POR PERIODO', alignment: 'left', style: 'subtitulo'});
                muestraAvanFisAdd.push(
                        {
                            style: 'interlineado1',
                            table: {
                                widths: [30, '*', 80, 80, 80, 80, 80, 80, 80],
                                body: muestraAvanFisPerioTbl
                            },
                            layout: {
                                hLineColor: '#ECECEC',
                                vLineColor: '#ECECEC'
                            }
                        });

                var contImg = '<div>\
                                <a style="float: right;" href="./Proyectos?tipo=curva_control&codSiaf=' + siaf + '&ancho=1000&alto=500" download>\
                                  <span>\
                                    <img src="./resources/images/foto.png" data-toggle="tooltip" data-placement="bottom" title="Descargar Imagen">\
                                  </span>\
                                </a>\
                               </div>\
                               <div>\
                                <img src="./Proyectos?tipo=curva_control&codSiaf=' + siaf + '&ancho=1000&alto=500">\
                               </div>';
                $("#divProyFichaAvanFisPerioImg").append(contImg);

            }

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

            var imageUrl_CurvaAvance = './Proyectos?tipo=curva_control&codSiaf=' + response.siaf + '&ancho=1000&alto=500';
            var img_CurvaAvance;
            convertImgToDataURLviaCanvas(imageUrl_CurvaAvance, function (base64Img) {
                img_CurvaAvance = base64Img;
            });

            var muestraAvanFisAddImg = [];

            $("#btnProyFichaAvanFisPdf").on('click', function () {

                muestraAvanFisAddImg = [];

                if (response.estado) {
                    muestraAvanFisAddImg.push({text: '\n'});
                    muestraAvanFisAddImg.push(
                            {
                                style: 'interlineado1',
                                table: {
                                    widths: [20, '*', 20],
                                    body: [
                                        [
                                            "",
                                            {image: img_CurvaAvance, width: 600, alignment: 'center'},
                                            ""
                                        ]
                                    ]
                                },
                                layout: {
                                    hLineColor: 'white',
                                    vLineColor: 'white'
                                }
                            }
                    );
                } else {
                    muestraAvanFisAddImg.push({text: ''});
                }

                var docDefinition = {
                    pageOrientation: 'landscape',
                    info: {
                        title: 'avance_fisico_proyecto_' + siaf
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
                                        {text: 'AVANCE FÍSICO DE PROYECTO', alignment: 'center', style: 'tituloU'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            style: 'interlineado1',
                            table: {
                                widths: [90, '*', 60, 90, '*'],
                                body: [
                                    [
                                        {text: 'CODIGO SIAF :', alignment: 'left', style: 'sombreado1'},
                                        {text: response.siaf, alignment: 'left', style: 'sombreado2'},
                                        "",
                                        {text: 'CODIGO SNIP :', alignment: 'left', style: 'sombreado1'},
                                        {text: response.snip, alignment: 'left', style: 'sombreado2'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            style: 'interlineado',
                            table: {
                                widths: [90, '*'],
                                body: [
                                    [
                                        {text: 'NOMBRE PROYECTO :', alignment: 'left', style: 'sombreado1'},
                                        {text: response.nombre, alignment: 'left', style: 'sombreado2'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        muestraAvanFisAdd,
                        muestraAvanFisAddImg
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
                            fontSize: 8,
                            bold: true,
                            color: '#334A74',
                            decoration: 'underline'
                        },
                        subtitulo: {
                            fontSize: 7,
                            bold: true,
                            color: '#334A74'
                        },
                        subtituloU: {
                            fontSize: 7,
                            bold: true,
                            color: '#334A74',
                            decoration: 'underline'
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
                        tablaBodyN: {
                            fontSize: 6,
                            bold: true
                        },
                        subHeader: {
                            color: 'white',
                            fillColor: '#587BA0',
                            fontSize: 6,
                            bold: true
                        },
                        subFooter: {
                            fillColor: '#D2DBE5',
                            fontSize: 6
                        },
                        tablaTotal: {
                            fillColor: '#F6F6F6',
                            fontSize: 6,
                            bold: true
                        },
                        pie: {
                            fontSize: 5
                        },
                        interlineado: {
                            margin: [0, 2, 0, 2]
                        },
                        interlineado1: {
                            margin: [0, 5, 0, 2]
                        }
                    }
                };
                pdfMake.createPdf(docDefinition).open();
            });

        }
    });
}

function llenar_proy_ficha_ejec_financ(siaf) {
    $('#divProyFichaRepEjecFinanc').empty();
    var muestraEjecFinanProy = [];
    var muestraEjecFinanAdd = [];
    financ = '<div style="height: 32px;">\
                <button id="btnProyFichaEjecFinancPdf" style="float: right;" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="Exportar a PDF">\
                  <span>\
                    <img src="./templates/plugins/datatables/images/pdf.png">\
                  </span>\
                </button>\
               </div>\
               <div class="pad15">\
               <div>\
                <div style="overflow-x:auto;">\
                  <table id="tableProyFichaEjecFinanHisto" class="display" cellspacing="0" width="100%">\
                    <thead>\
                      <tr>\
                        <th style="text-align: center;">Año</th>\
                        <th style="text-align: center;">PIA</th>\
                        <th style="text-align: center;">PIM</th>\
                        <th style="text-align: center;">Devengado</th>\
                        <th style="text-align: center;">Avance %</th>\
                      </tr>\
                    </thead>\
                    <tbody id="tableProyFichaEjecFinanHistoBody"></tbody>\
                  </table\
                </div></br>\
                <div id="divProyFichaEjecFinanActual" style="overflow-x:auto;"></div></br>\
                <div style="overflow-x:auto;">\
                  <table id="tableProyFichaEjecFinanResum" class="display" cellspacing="0" width="100%">\
                    <thead id="tableProyFichaEjecFinanResumHead"></thead>\
                    <tbody id="tableProyFichaEjecFinanResumBody"></tbody>\
                  </table\
                </div></br>\
                <div>\
                  <label class="col-form-label">PAGOS REALIZADOS AL PROYECTO</label>\
                  <button id="btnShowProyFichaPagosSiaf" type="button" class="btn btn-default btn-m" data-toggle="tooltip" data-placement="bottom" title="Mostrar">\
                     <span class="glyphicon glyphicon-eye-open"></span>\
                  </button>\
                </div>\
              </div>\
              <div>\
                <div id="divtableProyFichaPagosSiaf" style="overflow-x:auto;"></div>\
              </div></div>';
    $('#divProyFichaRepEjecFinanc').append(financ);

    $('#divtableProyFichaPagosSiaf').hide();

    $.ajax({
        dataType: 'json',
        url: "./Proyectos?tipo=ejec_financiera&codSiaf=" + siaf,
        success: function (response) {
            muestraEjecFinanProy.push({
                style: 'interlineado1',
                table: {
                    widths: [90, '*', 60, 90, '*'],
                    body: [
                        [
                            {text: 'CODIGO SIAF :', alignment: 'left', style: 'sombreado1'},
                            {text: response.siaf, alignment: 'left', style: 'sombreado2'},
                            "",
                            {text: 'CODIGO SNIP :', alignment: 'left', style: 'sombreado1'},
                            {text: response.snip, alignment: 'left', style: 'sombreado2'}
                        ]
                    ]
                },
                layout: {
                    hLineColor: 'white',
                    vLineColor: 'white'
                }
            });
            muestraEjecFinanProy.push({
                style: 'interlineado',
                table: {
                    widths: [90, '*'],
                    body: [
                        [
                            {text: 'NOMBRE PROYECTO :', alignment: 'left', style: 'sombreado1'},
                            {text: response.nombre, alignment: 'left', style: 'sombreado2'}
                        ]
                    ]
                },
                layout: {
                    hLineColor: 'white',
                    vLineColor: 'white'
                }
            });
            var muestraEjecFinanHistoTbl = [];
            var muestraEjecFinanHistoTblHead = [];
            muestraEjecFinanHistoTblHead.push({text: 'Año', style: 'tablaHead', alignment: 'center'});
            muestraEjecFinanHistoTblHead.push({text: 'PIA', style: 'tablaHead', alignment: 'center'});
            muestraEjecFinanHistoTblHead.push({text: 'PIM', style: 'tablaHead', alignment: 'center'});
            muestraEjecFinanHistoTblHead.push({text: 'Devengado', style: 'tablaHead', alignment: 'center'});
            muestraEjecFinanHistoTblHead.push({text: 'Avance %', style: 'tablaHead', alignment: 'center'});
            muestraEjecFinanHistoTbl.push(muestraEjecFinanHistoTblHead);
            $.each(response.listHisto, function (index, value) {
                var muestraEjecFinanHistoTblBody = [];
                var ano_eje, pia, pim, devengado, avance;
                ano_eje = value.ano_eje;
                if (!$.trim(value.pia)) {
                    pia = 0.00;
                } else {
                    pia = value.pia;
                }
                if (!$.trim(value.pim)) {
                    pim = 0.00;
                } else {
                    pim = value.pim;
                }
                if (!$.trim(value.devengado)) {
                    devengado = 0.00;
                    avance = 0.00;
                } else {
                    devengado = value.devengado;
                    if (pim === 0.00) {
                        avance = 0.00;
                    } else {
                        avance = (devengado / pim) * 100;
                    }
                }
                body1 = "<tr>\
                          <td style='text-align: center;'>" + ano_eje + "</td>\
                          <td style='text-align: right;'>" + formatNumeroDecimal(pia) + "</td>\
                          <td style='text-align: right;'>" + formatNumeroDecimal(pim) + "</td>\
                          <td style='text-align: right;'>" + formatNumeroDecimal(devengado) + "</td>\
                          <td style='text-align: center;'>" + formatNumeroDecimal(avance) + "</td>\
                         </tr>";
                $("#tableProyFichaEjecFinanHistoBody").append(body1);
                muestraEjecFinanHistoTblBody.push({text: ano_eje, style: 'tablaBody', alignment: 'center'});
                muestraEjecFinanHistoTblBody.push({text: formatNumeroDecimal(pia), style: 'tablaBody', alignment: 'right'});
                muestraEjecFinanHistoTblBody.push({text: formatNumeroDecimal(pim), style: 'tablaBody', alignment: 'right'});
                muestraEjecFinanHistoTblBody.push({text: formatNumeroDecimal(devengado), style: 'tablaBody', alignment: 'right'});
                muestraEjecFinanHistoTblBody.push({text: formatNumeroDecimal(avance), style: 'tablaBodyN', alignment: 'center'});
                muestraEjecFinanHistoTbl.push(muestraEjecFinanHistoTblBody);
            });

            $('#divProyFichaEjecFinanActual').empty();
            if (response.estadoActual) {
                var muestraEjecFinanDetalleTbl = [];
                tabla2 = '<table id="tableProyFichaEjecFinanActual" class="display" cellspacing="0" width="100%">\
                            <thead>\
                              <tr>\
                                <th style="text-align: center;">Unidad Ejecutora</th>\
                                <th style="text-align: center;">Rubro</th>\
                                <th style="text-align: center;">Meta</th>\
                                <th style="text-align: center;">Clasificador</th>\
                                <th style="text-align: center;">PIA</th>\
                                <th style="text-align: center;">PIM</th>\
                                <th style="text-align: center;">Devengado</th>\
                                <th style="text-align: center;">Avance %</th>\
                              </tr>\
                            </thead>\
                            <tbody id="tableProyFichaEjecFinanActualBody"></tbody>\
                            <tfoot id="tableProyFichaEjecFinanActualFoot"></tfoot>\
                          </table>';
                $('#divProyFichaEjecFinanActual').append(tabla2);
                var muestraEjecFinanDetalleTblHead = [];
                muestraEjecFinanDetalleTblHead.push({text: 'Unidad Ejecutora', style: 'tablaHead', alignment: 'center'});
                muestraEjecFinanDetalleTblHead.push({text: 'Rubro', style: 'tablaHead', alignment: 'center'});
                muestraEjecFinanDetalleTblHead.push({text: 'Meta', style: 'tablaHead', alignment: 'center'});
                muestraEjecFinanDetalleTblHead.push({text: 'Clasificador', style: 'tablaHead', alignment: 'center'});
                muestraEjecFinanDetalleTblHead.push({text: 'PIA', style: 'tablaHead', alignment: 'center'});
                muestraEjecFinanDetalleTblHead.push({text: 'PIM', style: 'tablaHead', alignment: 'center'});
                muestraEjecFinanDetalleTblHead.push({text: 'Devengado', style: 'tablaHead', alignment: 'center'});
                muestraEjecFinanDetalleTblHead.push({text: 'Avance %', style: 'tablaHead', alignment: 'center'});
                muestraEjecFinanDetalleTbl.push(muestraEjecFinanDetalleTblHead);
                $.each(response.listActual, function (index, value) {
                    var muestraEjecFinanHistoTblBody = [];
                    var ano_eje, pia, pim, devengado, avance;
                    ano_eje = value.ano_eje;
                    if (!$.trim(value.pia)) {
                        pia = 0.00;
                    } else {
                        pia = value.pia;
                    }
                    if (!$.trim(value.pim)) {
                        pim = 0.00;
                    } else {
                        pim = value.pim;
                    }
                    if (!$.trim(value.devengado)) {
                        devengado = 0.00;
                        avance = 0.00;
                    } else {
                        devengado = value.devengado;
                        if (pim === 0.00) {
                            avance = 0.00;
                        } else {
                            avance = (devengado / pim) * 100;
                        }
                    }
                    body2 = "<tr'>\
                                <td style='text-align: center;'><b>" + ano_eje + "</b></td>\
                                <td style='text-align: right;'><b>" + formatNumeroDecimal(pia) + "</b></td>\
                                <td style='text-align: right;'><b>" + formatNumeroDecimal(pim) + "</b></td>\
                                <td style='text-align: right;'><b>" + formatNumeroDecimal(devengado) + "</b></td>\
                                <td style='text-align: center;'><b>" + formatNumeroDecimal(avance) + "</b></td>\
                             </tr>";
                    $("#tableProyFichaEjecFinanHistoBody").append(body2);
                    muestraEjecFinanHistoTblBody.push({text: ano_eje, style: 'tablaBody', alignment: 'center'});
                    muestraEjecFinanHistoTblBody.push({text: formatNumeroDecimal(pia), style: 'tablaBody', alignment: 'right'});
                    muestraEjecFinanHistoTblBody.push({text: formatNumeroDecimal(pim), style: 'tablaBody', alignment: 'right'});
                    muestraEjecFinanHistoTblBody.push({text: formatNumeroDecimal(devengado), style: 'tablaBody', alignment: 'right'});
                    muestraEjecFinanHistoTblBody.push({text: formatNumeroDecimal(avance), style: 'tablaBodyN', alignment: 'center'});
                    muestraEjecFinanHistoTbl.push(muestraEjecFinanHistoTblBody);
                });

                $('#tableProyFichaEjecFinanHisto').dataTable({
                    ordering: false,
                    bPaginate: false,
                    dom: '<"centrar-div-tabla"<"labelDataTableEjecuHisto">B>rt',
                    buttons: [
                        {
                            extend: 'excel',
                            filename: 'ejecucion_financiera_historica_proyecto_' + siaf,
                            title: 'EJECUCIÓN FINANCIERA HISTÓRICA',
                            headTop1: 'Código SIAF : ' + siaf,
                            headTop2: 'Código SNIP : ' + response.snip,
                            headTop3: 'Nombre Proyecto : ' + response.nombre,
                            exportOptions: {
                                orthogonal: 'sort',
                                columns: ':visible'
                            },
                            customize: function (xlsx) {
                                var sheet = xlsx.xl.worksheets['sheet1.xml'];
                                for (var k = 1; k < 4; k++) {
                                    var total = $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).length;
                                    $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).each(function (i) {
                                        if (i > 0 && i < total) {
                                            $(this).attr('s', '72');
                                        }
                                    });
                                }
                                for (var k = 4; k < 5; k++) {
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
                $("div.labelDataTableEjecuHisto").html('<label class="col-form-label">EJECUCIÓN HISTÓRICA</label>');

                muestraEjecFinanAdd.push({text: '\n'});
                muestraEjecFinanAdd.push({text: 'EJECUCIÓN HISTÓRICA', alignment: 'left', style: 'subtitulo'});
                muestraEjecFinanAdd.push(
                        {
                            style: 'interlineado1',
                            table: {
                                widths: [50, 80, 80, 80, 80],
                                body: muestraEjecFinanHistoTbl
                            },
                            layout: {
                                hLineColor: '#ECECEC',
                                vLineColor: '#ECECEC'
                            }
                        });

                if (response.estadoDetallado) {
                    var piaDT, pimDT, devengadoDT, avanceDT;
                    piaDT = pimDT = devengadoDT = avanceDT = 0.00;
                    $.each(response.listDetallado, function (index, value) {
                        var pia, pim, devengado, avance;
                        if (!$.trim(value.pia)) {
                            pia = 0.00;
                        } else {
                            pia = value.pia;
                            piaDT += value.pia;
                        }
                        if (!$.trim(value.pim)) {
                            pim = 0.00;
                        } else {
                            pim = value.pim;
                            pimDT += value.pim;
                        }
                        if (!$.trim(value.devengado)) {
                            devengado = 0.00;
                            avance = 0.00;
                        } else {
                            devengado = value.devengado;
                            devengadoDT += value.devengado;
                            if (pim === 0.00) {
                                avance = 0.00;
                            } else {
                                avance = (devengado / pim) * 100;
                            }
                        }
                        body3 = "<tr>\
                                    <td style='text-align: center;'>UE " + value.ejecutora + " (" + value.sec_ejec + ")</td>\
                                    <td style='text-align: left;'>" + value.fuente_financ + " - " + value.nombre_fuente_financ + "</td>\
                                    <td style='text-align: center;'>" + value.sec_func + "</td>\
                                    <td style='text-align: center;'>" + value.clasificador + "</td>\
                                    <td style='text-align: right;'>" + formatNumeroDecimal(pia) + "</td>\
                                    <td style='text-align: right;'>" + formatNumeroDecimal(pim) + "</td>\
                                    <td style='text-align: right;'>" + formatNumeroDecimal(devengado) + "</td>\
                                    <td style='text-align: center;'>" + formatNumeroDecimal(avance) + "</td>\
                                 </tr>";
                        $("#tableProyFichaEjecFinanActualBody").append(body3);
                        var muestraEjecFinanDetalleTblBody = [];
                        muestraEjecFinanDetalleTblBody.push({text: 'UE ' + value.ejecutora + ' (' + value.sec_ejec + ')', style: 'tablaBody', alignment: 'center'});
                        muestraEjecFinanDetalleTblBody.push({text: value.fuente_financ + " - " + value.nombre_fuente_financ, style: 'tablaBody', alignment: 'left'});
                        muestraEjecFinanDetalleTblBody.push({text: value.sec_func, style: 'tablaBody', alignment: 'center'});
                        muestraEjecFinanDetalleTblBody.push({text: value.clasificador, style: 'tablaBody', alignment: 'center'});
                        muestraEjecFinanDetalleTblBody.push({text: formatNumeroDecimal(pia), style: 'tablaBody', alignment: 'right'});
                        muestraEjecFinanDetalleTblBody.push({text: formatNumeroDecimal(pim), style: 'tablaBody', alignment: 'right'});
                        muestraEjecFinanDetalleTblBody.push({text: formatNumeroDecimal(devengado), style: 'tablaBody', alignment: 'right'});
                        muestraEjecFinanDetalleTblBody.push({text: formatNumeroDecimal(avance), style: 'tablaBodyN', alignment: 'center'});
                        muestraEjecFinanDetalleTbl.push(muestraEjecFinanDetalleTblBody);
                    });
                    if (!$.trim(devengadoDT)) {
                        devengadoDT = 0.00;
                        avanceDT = 0.00;
                    } else {
                        if (pimDT === 0.00) {
                            avanceDT = 0.00;
                        } else {
                            avanceDT = (devengadoDT / pimDT) * 100;
                        }
                    }

                    foot3 = "<tr class='total'>\
                                <td colspan='4' style='text-align: center;'><b>TOTAL</b></td>\
                                <td style='text-align: right;'><b>" + formatNumeroDecimal(piaDT) + "</b></td>\
                                <td style='text-align: right;'><b>" + formatNumeroDecimal(pimDT) + "</b></td>\
                                <td style='text-align: right;'><b>" + formatNumeroDecimal(devengadoDT) + "</b></td>\
                                <td style='text-align: center;'><b>" + formatNumeroDecimal(avanceDT) + "</b></td>\
                             </tr>";
                    $("#tableProyFichaEjecFinanActualFoot").append(foot3);
                    var muestraEjecFinanDetalleTblFoot = [];
                    muestraEjecFinanDetalleTblFoot.push({text: 'TOTAL', style: 'tablaTotal', alignment: 'center', colSpan: 4});
                    muestraEjecFinanDetalleTblFoot.push("");
                    muestraEjecFinanDetalleTblFoot.push("");
                    muestraEjecFinanDetalleTblFoot.push("");
                    muestraEjecFinanDetalleTblFoot.push({text: formatNumeroDecimal(piaDT), style: 'tablaTotal', alignment: 'right'});
                    muestraEjecFinanDetalleTblFoot.push({text: formatNumeroDecimal(pimDT), style: 'tablaTotal', alignment: 'right'});
                    muestraEjecFinanDetalleTblFoot.push({text: formatNumeroDecimal(devengadoDT), style: 'tablaTotal', alignment: 'right'});
                    muestraEjecFinanDetalleTblFoot.push({text: formatNumeroDecimal(avanceDT), style: 'tablaTotal', alignment: 'center'});
                    muestraEjecFinanDetalleTbl.push(muestraEjecFinanDetalleTblFoot);

                    $('#tableProyFichaEjecFinanActual').dataTable({
                        ordering: false,
                        bPaginate: false,
                        dom: '<"centrar-div-tabla"<"labelDataTableEjecuActualDet">B>rt',
                        buttons: [
                            {
                                extend: 'excel',
                                footer: true,
                                filename: 'ejecucion_financiera_actual_detallada_proyecto_' + siaf,
                                title: 'EJECUCIÓN FINANCIERA ACTUAL DETALLADA',
                                headTop1: 'Código SIAF : ' + siaf,
                                headTop2: 'Código SNIP : ' + response.snip,
                                headTop3: 'Nombre Proyecto : ' + response.nombre,
                                exportOptions: {
                                    orthogonal: 'sort',
                                    columns: ':visible'
                                },
                                customize: function (xlsx) {
                                    var sheet = xlsx.xl.worksheets['sheet1.xml'];
                                    for (var k = 4; k < 7; k++) {
                                        var total = $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).length;
                                        $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).each(function (i) {
                                            if (i > 0 && i < total - 1) {
                                                $(this).attr('s', '72');
                                            }
                                            if (i === total - 1) {
                                                $(this).attr('s', '75');
                                            }
                                        });
                                    }
                                    for (var k = 7; k < 8; k++) {
                                        var total = $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).length;
                                        $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).each(function (i) {
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
                    $("div.labelDataTableEjecuActualDet").html('<label class="col-form-label">EJECUCIÓN ACTUAL DETALLADA</label>');

                    muestraEjecFinanAdd.push({text: '\n'});
                    muestraEjecFinanAdd.push({text: 'EJECUCIÓN ACTUAL DETALLADA', alignment: 'left', style: 'subtitulo'});
                    muestraEjecFinanAdd.push(
                            {
                                style: 'interlineado1',
                                table: {
                                    widths: [70, '*', 40, 70, 60, 60, 60, 50],
                                    body: muestraEjecFinanDetalleTbl
                                },
                                layout: {
                                    hLineColor: '#ECECEC',
                                    vLineColor: '#ECECEC'
                                }
                            });

                }
                var muestraEjecFinanResumTbl = [];
                var pim_actual, deven_actual, deven_acumulado, montoActual, deficit;
                if (!$.trim(response.pim_actual)) {
                    pim_actual = 0.00;
                } else {
                    pim_actual = response.pim_actual;
                }
                if (!$.trim(response.deven_actual)) {
                    deven_actual = 0.00;
                } else {
                    deven_actual = response.deven_actual;
                }
                if (!$.trim(response.deven_acumulado)) {
                    deven_acumulado = 0.00;
                } else {
                    deven_acumulado = response.deven_acumulado;
                }
                if (!$.trim(response.montoActual)) {
                    montoActual = 0.00;
                } else {
                    montoActual = response.montoActual;
                }
                deficit = montoActual - deven_acumulado - pim_actual;
                head4 = '<tr>\
                            <th style="text-align: center;">PIM (' + response.año_actual + ') (P)</th>\
                            <th style="text-align: center;">Devengado (' + response.año_actual + ') (D)</th>\
                            <th style="text-align: center;">Devengado (Acumulada al ' + response.año_anterior + ') (DA)</th>\
                            <th style="text-align: center;">Monto Inversión Actualizado (MI)</th>\
                            <th style="text-align: center;">Saldo o Déficit (MI - DA - P)</th>\
                         </tr>';
                $("#tableProyFichaEjecFinanResumHead").append(head4);
                var muestraEjecFinanResumTblHead = [];
                muestraEjecFinanResumTblHead.push({text: 'PIM (' + response.año_actual + ') (P)', style: 'tablaHead', alignment: 'center'});
                muestraEjecFinanResumTblHead.push({text: 'Devengado (' + response.año_actual + ') (D)', style: 'tablaHead', alignment: 'center'});
                muestraEjecFinanResumTblHead.push({text: 'Devengado (Acumulada al ' + response.año_anterior + ') (DA)', style: 'tablaHead', alignment: 'center'});
                muestraEjecFinanResumTblHead.push({text: 'Monto Inversión Actualizado (MI)', style: 'tablaHead', alignment: 'center'});
                muestraEjecFinanResumTblHead.push({text: 'Saldo o Déficit (MI - DA - P)', style: 'tablaHead', alignment: 'center'});
                muestraEjecFinanResumTbl.push(muestraEjecFinanResumTblHead);
                body4 = "<tr>\
                            <td style='text-align: right;'>" + formatNumeroDecimal(pim_actual) + "</td>\
                            <td style='text-align: right;'>" + formatNumeroDecimal(deven_actual) + "</td>\
                            <td style='text-align: right;'>" + formatNumeroDecimal(deven_acumulado) + "</td>\
                            <td style='text-align: right;'>" + formatNumeroDecimal(montoActual) + "</td>\
                            <td style='text-align: right;'>" + formatNumeroDecimal(deficit) + "</td>\
                         </tr>";
                $("#tableProyFichaEjecFinanResumBody").append(body4);
                var muestraEjecFinanResumTblBody = [];
                muestraEjecFinanResumTblBody.push({text: formatNumeroDecimal(pim_actual), style: 'tablaBody', alignment: 'right'});
                muestraEjecFinanResumTblBody.push({text: formatNumeroDecimal(deven_actual), style: 'tablaBody', alignment: 'right'});
                muestraEjecFinanResumTblBody.push({text: formatNumeroDecimal(deven_acumulado), style: 'tablaBody', alignment: 'right'});
                muestraEjecFinanResumTblBody.push({text: formatNumeroDecimal(montoActual), style: 'tablaBody', alignment: 'right'});
                muestraEjecFinanResumTblBody.push({text: formatNumeroDecimal(deficit), style: 'tablaBody', alignment: 'right'});
                muestraEjecFinanResumTbl.push(muestraEjecFinanResumTblBody);

                $('#tableProyFichaEjecFinanResum').dataTable({
                    ordering: false,
                    bPaginate: false,
                    dom: '<"centrar-div-tabla"<"labelDataTableEjecuResumen">B>rt',
                    buttons: [
                        {
                            extend: 'excel',
                            filename: 'ejecucion_financiera_resumen_proyecto_' + siaf,
                            title: 'EJECUCIÓN FINANCIERA RESUMEN',
                            headTop1: 'Código SIAF : ' + siaf,
                            headTop2: 'Código SNIP : ' + response.snip,
                            headTop3: 'Nombre Proyecto : ' + response.nombre,
                            exportOptions: {
                                orthogonal: 'sort',
                                columns: ':visible'
                            },
                            customize: function (xlsx) {
                                var sheet = xlsx.xl.worksheets['sheet1.xml'];
                                for (var k = 0; k < 1; k++) {
                                    var total = $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).length;
                                    $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).each(function (i) {
                                        if (i > 4 && i < total) {
                                            $(this).attr('s', '72');
                                        }
                                    });
                                }
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
                $("div.labelDataTableEjecuResumen").html('<label class="col-form-label">RESUMEN EJECUCIÓN</label>');

                muestraEjecFinanAdd.push({text: '\n'});
                muestraEjecFinanAdd.push({text: 'RESUMEN EJECUCIÓN', alignment: 'left', style: 'subtitulo'});
                muestraEjecFinanAdd.push(
                        {
                            style: 'interlineado1',
                            table: {
                                widths: [80, 80, 80, 80, 80],
                                body: muestraEjecFinanResumTbl
                            },
                            layout: {
                                hLineColor: '#ECECEC',
                                vLineColor: '#ECECEC'
                            }
                        });

            } else {

                $('#tableProyFichaEjecFinanHisto').dataTable({
                    ordering: false,
                    bPaginate: false,
                    dom: '<"centrar-div-tabla"<"labelDataTableEjecuHisto">B>rt',
                    buttons: [
                        {
                            extend: 'excel',
                            filename: 'ejecucion_financiera_historica_proyecto_' + siaf,
                            title: 'EJECUCIÓN FINANCIERA HISTÓRICA',
                            headTop1: 'Código SIAF : ' + siaf,
                            headTop2: 'Código SNIP : ' + response.snip,
                            headTop3: 'Nombre Proyecto : ' + response.nombre,
                            exportOptions: {
                                orthogonal: 'sort',
                                columns: ':visible'
                            },
                            customize: function (xlsx) {
                                var sheet = xlsx.xl.worksheets['sheet1.xml'];
                                for (var k = 1; k < 4; k++) {
                                    var total = $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).length;
                                    $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).each(function (i) {
                                        if (i > 0 && i < total) {
                                            $(this).attr('s', '72');
                                        }
                                    });
                                }
                                for (var k = 4; k < 5; k++) {
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
                $("div.labelDataTableEjecuHisto").html('<label class="col-form-label">EJECUCIÓN HISTÓRICA</label>');

                muestraEjecFinanAdd.push({text: '\n'});
                muestraEjecFinanAdd.push({text: 'EJECUCIÓN HISTÓRICA', alignment: 'left', style: 'subtitulo'});
                muestraEjecFinanAdd.push(
                        {
                            style: 'interlineado1',
                            table: {
                                widths: [50, 80, 80, 80, 80],
                                body: muestraEjecFinanHistoTbl
                            },
                            layout: {
                                hLineColor: '#ECECEC',
                                vLineColor: '#ECECEC'
                            }
                        });

                var muestraEjecFinanResumTbl = [];
                var deven_acumulado, montoActual, deficit;
                if (!$.trim(response.deven_acumulado)) {
                    deven_acumulado = 0.00;
                } else {
                    deven_acumulado = response.deven_acumulado;
                }
                if (!$.trim(response.montoActual)) {
                    montoActual = 0.00;
                } else {
                    montoActual = response.montoActual;
                }
                deficit = montoActual - deven_acumulado;
                head5 = '<tr>\
                            <th style="text-align: center;">Devengado Acumulado (DA)</th>\
                            <th style="text-align: center;">Monto Inversión Actualizado (MI)</th>\
                            <th style="text-align: center;">Saldo o Déficit (MI - DA)</th>\
                         </tr>';
                $("#tableProyFichaEjecFinanResumHead").append(head5);
                var muestraEjecFinanResumTblHead = [];
                muestraEjecFinanResumTblHead.push({text: 'Devengado Acumulado (DA)', style: 'tablaHead', alignment: 'center'});
                muestraEjecFinanResumTblHead.push({text: 'Monto Inversión Actualizado (MI)', style: 'tablaHead', alignment: 'center'});
                muestraEjecFinanResumTblHead.push({text: 'Saldo o Déficit (MI - DA)', style: 'tablaHead', alignment: 'center'});
                muestraEjecFinanResumTbl.push(muestraEjecFinanResumTblHead);
                body5 = "<tr>\
                            <td style='text-align: right;'>" + formatNumeroDecimal(deven_acumulado) + "</td>\
                            <td style='text-align: right;'>" + formatNumeroDecimal(montoActual) + "</td>\
                            <td style='text-align: right;'>" + formatNumeroDecimal(deficit) + "</td>\
                         </tr>";
                $("#tableProyFichaEjecFinanResumBody").append(body5);
                var muestraEjecFinanResumTblBody = [];
                muestraEjecFinanResumTblBody.push({text: formatNumeroDecimal(deven_acumulado), style: 'tablaBody', alignment: 'right'});
                muestraEjecFinanResumTblBody.push({text: formatNumeroDecimal(montoActual), style: 'tablaBody', alignment: 'right'});
                muestraEjecFinanResumTblBody.push({text: formatNumeroDecimal(deficit), style: 'tablaBody', alignment: 'right'});
                muestraEjecFinanResumTbl.push(muestraEjecFinanResumTblBody);

                $('#tableProyFichaEjecFinanResum').dataTable({
                    ordering: false,
                    bPaginate: false,
                    dom: '<"centrar-div-tabla"<"labelDataTableEjecuResumen">B>rt',
                    buttons: [
                        {
                            extend: 'excel',
                            filename: 'ejecucion_financiera_resumen_proyecto_' + siaf,
                            title: 'EJECUCIÓN FINANCIERA RESUMEN',
                            headTop1: 'Código SIAF : ' + siaf,
                            headTop2: 'Código SNIP : ' + response.snip,
                            headTop3: 'Nombre Proyecto : ' + response.nombre,
                            exportOptions: {
                                orthogonal: 'sort',
                                columns: ':visible'
                            },
                            customize: function (xlsx) {
                                var sheet = xlsx.xl.worksheets['sheet1.xml'];
                                for (var k = 0; k < 1; k++) {
                                    var total = $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).length;
                                    $('row c[r^="' + arrayABC_excel(k) + '"]', sheet).each(function (i) {
                                        if (i > 4 && i < total) {
                                            $(this).attr('s', '72');
                                        }
                                    });
                                }
                                for (var k = 1; k < 3; k++) {
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
                $("div.labelDataTableEjecuResumen").html('<label class="col-form-label">RESUMEN EJECUCIÓN</label>');

                muestraEjecFinanAdd.push({text: '\n'});
                muestraEjecFinanAdd.push({text: 'RESUMEN EJECUCIÓN', alignment: 'left', style: 'subtitulo'});
                muestraEjecFinanAdd.push(
                        {
                            style: 'interlineado1',
                            table: {
                                widths: [80, 80, 80],
                                body: muestraEjecFinanResumTbl
                            },
                            layout: {
                                hLineColor: '#ECECEC',
                                vLineColor: '#ECECEC'
                            }
                        });

            }
        }
    });

    var muestraEjecFinanPagosTbl = [];
    $.ajax({
        dataType: 'json',
        url: "./Proyectos?tipo=detalle_pagos&codSiaf=" + siaf,
        success: function (response) {
            $('#divtableProyFichaPagosSiaf').empty();
            table6 = '<table id="tableProyFichaPagosSiaf" class="display" cellspacing="0" width="100%">\
                        <thead>\
                         <tr>\
                           <th style="text-align: center;">Año</th>\
                           <th style="text-align: center;">Expediente SIAF</th>\
                           <th style="text-align: center;">Fecha</th>\
                           <th style="text-align: center;">Unidad Ejecutora</th>\
                           <th style="text-align: center;">Meta</th>\
                           <th style="text-align: center;">Rubro</th>\
                           <th style="text-align: center;">Clasificador</th>\
                           <th style="text-align: center;">Devengado</th>\
                           <th style="text-align: center;">RUC</th>\
                           <th style="text-align: center;">Razón Social</th>\
                           <th style="text-align: center;">Certificación</th>\
                         </tr>\
                        </thead>\
                        <tbody id="tableProyFichaPagosSiafBody"></tbody>\
                      </table>';
            $('#divtableProyFichaPagosSiaf').append(table6);
            var muestraEjecFinanPagosTblHead = [];
            muestraEjecFinanPagosTblHead.push({text: 'Año', style: 'tablaHead', alignment: 'center'});
            muestraEjecFinanPagosTblHead.push({text: 'Expediente SIAF', style: 'tablaHead', alignment: 'center'});
            muestraEjecFinanPagosTblHead.push({text: 'Fecha', style: 'tablaHead', alignment: 'center'});
            muestraEjecFinanPagosTblHead.push({text: 'Unidad Ejecutora', style: 'tablaHead', alignment: 'center'});
            muestraEjecFinanPagosTblHead.push({text: 'Meta', style: 'tablaHead', alignment: 'center'});
            muestraEjecFinanPagosTblHead.push({text: 'Rubro', style: 'tablaHead', alignment: 'center'});
            muestraEjecFinanPagosTblHead.push({text: 'Clasificador', style: 'tablaHead', alignment: 'center'});
            muestraEjecFinanPagosTblHead.push({text: 'Devengado', style: 'tablaHead', alignment: 'center'});
            muestraEjecFinanPagosTblHead.push({text: 'RUC', style: 'tablaHead', alignment: 'center'});
            muestraEjecFinanPagosTblHead.push({text: 'Razón Social', style: 'tablaHead', alignment: 'center'});
            muestraEjecFinanPagosTblHead.push({text: 'Certificación', style: 'tablaHead', alignment: 'center'});
            muestraEjecFinanPagosTbl.push(muestraEjecFinanPagosTblHead);
            $.each(response.listPagos, function (index, value) {
                var devengado, ruc, razon_social, certificacion;
                if (!$.trim(value.devengado)) {
                    devengado = 0.00;
                } else {
                    devengado = value.devengado;
                }
                if (!$.trim(value.ruc)) {
                    ruc = "";
                } else {
                    ruc = value.ruc;
                }
                if (!$.trim(value.razon_social)) {
                    razon_social = "";
                } else {
                    razon_social = value.razon_social;
                }
                if (!$.trim(value.certificacion)) {
                    certificacion = "";
                } else {
                    certificacion = value.certificacion;
                }
                body6 = "<tr'>\
                           <td style='text-align: center;'>" + value.ano_eje + "</td>\
                           <td style='text-align: center;'>" + value.expediente + "</td>\
                           <td style='text-align: center;'>" + value.fecha_doc + "</td>\
                           <td style='text-align: center;'>UE " + value.ejecutora + " (" + value.sec_ejec + ")</td>\
                           <td style='text-align: center;'>" + value.sec_func + "</td>\
                           <td style='text-align: center;'>" + value.fuente_financ + "</td>\
                           <td style='text-align: center;'>" + value.clasificador + "</td>\
                           <td style='text-align: right;'>" + formatNumeroDecimal(devengado) + "</td>\
                           <td style='text-align: center;'>" + ruc + "</td>\
                           <td style='text-align: left;'>" + razon_social + "</td>\
                           <td style='text-align: center;'>" + certificacion + "</td>\
                         </tr>";
                $('#tableProyFichaPagosSiafBody').append(body6);
                var muestraEjecFinanPagosTblBody = [];
                muestraEjecFinanPagosTblBody.push({text: value.ano_eje, style: 'tablaBody', alignment: 'center'});
                muestraEjecFinanPagosTblBody.push({text: value.expediente, style: 'tablaBody', alignment: 'center'});
                muestraEjecFinanPagosTblBody.push({text: value.fecha_doc, style: 'tablaBody', alignment: 'center'});
                muestraEjecFinanPagosTblBody.push({text: 'UE ' + value.ejecutora + ' (' + value.sec_ejec + ')', style: 'tablaBody', alignment: 'center'});
                muestraEjecFinanPagosTblBody.push({text: value.sec_func, style: 'tablaBody', alignment: 'center'});
                muestraEjecFinanPagosTblBody.push({text: value.fuente_financ, style: 'tablaBody', alignment: 'center'});
                muestraEjecFinanPagosTblBody.push({text: value.clasificador, style: 'tablaBody', alignment: 'center'});
                muestraEjecFinanPagosTblBody.push({text: formatNumeroDecimal(devengado), style: 'tablaBody', alignment: 'right'});
                muestraEjecFinanPagosTblBody.push({text: ruc, style: 'tablaBody', alignment: 'center'});
                muestraEjecFinanPagosTblBody.push({text: razon_social, style: 'tablaBody', alignment: 'left'});
                muestraEjecFinanPagosTblBody.push({text: certificacion, style: 'tablaBody', alignment: 'center'});
                muestraEjecFinanPagosTbl.push(muestraEjecFinanPagosTblBody);
            });

            $('#tableProyFichaPagosSiaf').dataTable({
                ordering: true,
                dom: '<"centrar-div-tabla"lfB>iprtip',
                buttons: [
                    {
                        extend: 'excel',
                        filename: 'detalle_pagos_proyecto_' + siaf,
                        title: 'DETALLE DE PAGOS REALIZADOS AL PROYECTO',
                        headTop1: 'Código SIAF : ' + siaf,
                        headTop2: 'Código SNIP : ' + response.snip,
                        headTop3: 'Nombre Proyecto : ' + response.nombre,
                        exportOptions: {
                            orthogonal: 'sort',
                            columns: ':visible'
                        },
                        customize: function (xlsx) {
                            var sheet = xlsx.xl.worksheets['sheet1.xml'];
                            for (var k = 7; k < 8; k++) {
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

            $("#btnShowProyFichaPagosSiaf").click(function () {
                $("#btnShowProyFichaPagosSiaf").empty();
                if ($("#divtableProyFichaPagosSiaf").is(":hidden")) {
                    $("#btnShowProyFichaPagosSiaf").append('<span class="glyphicon glyphicon-eye-close"></span>');
                    $('#btnShowProyFichaPagosSiaf').prop('title', 'Ocultar');
                    $("#divtableProyFichaPagosSiaf").toggle(500);
                } else {
                    $("#btnShowProyFichaPagosSiaf").append('<span class="glyphicon glyphicon-eye-open"></span>');
                    $('#btnShowProyFichaPagosSiaf').prop('title', 'Mostrar');
                    $("#divtableProyFichaPagosSiaf").hide(500);
                }
            });

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

    var muestraEjecFinanPagos = [];

    $("#btnProyFichaEjecFinancPdf").on('click', function () {

        muestraEjecFinanPagos = [];
        if ($("#divtableProyFichaPagosSiaf").is(":hidden")) {
            muestraEjecFinanPagos.push({text: ''});
        } else {
            muestraEjecFinanPagos.push({text: '\n'});
            muestraEjecFinanPagos.push({text: 'DETALLE DE PAGOS REALIZADOS AL PROYECTO', alignment: 'left', style: 'subtitulo'});
            muestraEjecFinanPagos.push(
                    {
                        style: 'interlineado1',
                        table: {
                            widths: [30, 40, 40, 60, 40, 30, 50, 60, 50, '*', 50],
                            body: muestraEjecFinanPagosTbl
                        },
                        layout: {
                            hLineColor: '#ECECEC',
                            vLineColor: '#ECECEC'
                        }
                    });
        }
        var docDefinition = {
            pageOrientation: 'landscape',
            info: {
                title: 'ejecucion_financiera_proyecto_' + siaf
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
                                {text: 'EJECUCIÓN FINANCIERA DE PROYECTO', alignment: 'center', style: 'tituloU'}
                            ]
                        ]
                    },
                    layout: {
                        hLineColor: 'white',
                        vLineColor: 'white'
                    }
                },
                muestraEjecFinanProy,
                muestraEjecFinanAdd,
                muestraEjecFinanPagos
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
                    fontSize: 8,
                    bold: true,
                    color: '#334A74',
                    decoration: 'underline'
                },
                subtitulo: {
                    fontSize: 7,
                    bold: true,
                    color: '#334A74'
                },
                subtituloU: {
                    fontSize: 7,
                    bold: true,
                    color: '#334A74',
                    decoration: 'underline'
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
                tablaBodyN: {
                    fontSize: 6,
                    bold: true
                },
                subHeader: {
                    color: 'white',
                    fillColor: '#587BA0',
                    fontSize: 6,
                    bold: true
                },
                subFooter: {
                    fillColor: '#D2DBE5',
                    fontSize: 6
                },
                tablaTotal: {
                    fillColor: '#F6F6F6',
                    fontSize: 6,
                    bold: true
                },
                pie: {
                    fontSize: 5
                },
                interlineado: {
                    margin: [0, 2, 0, 2]
                },
                interlineado1: {
                    margin: [0, 5, 0, 2]
                }
            }
        };
        pdfMake.createPdf(docDefinition).open();
    });

}

function llenar_proy_ficha_contrata(siaf) {
    $('#divProyFichaRepContrata').empty();
    contrat = '<div style="height: 32px;">\
                <button id="btnProyFichaContratPdf" style="float: right;" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="Exportar a PDF">\
                  <span>\
                    <img src="./templates/plugins/datatables/images/pdf.png">\
                  </span>\
                </button>\
               </div>\
               <div class="pad15">\
               <div>\
                <div style="overflow-x:auto;">\
                  <table id="tableProyFichaContrata" class="display" cellspacing="0" width="100%">\
                    <thead>\
                      <tr>\
                        <th style="text-align: center;">Id</th>\
                        <th style="text-align: center;">Contrato</th>\
                        <th style="text-align: center;">Tipo Proceso</th>\
                        <th style="text-align: center;">Contratista</th>\
                        <th style="text-align: center; width: 80px;">Fecha</th>\
                        <th style="text-align: center; width: 100px;">Monto</th>\
                        <th style="text-align: center; width: 90px;" class="noexport">Adjunto</th>\
                      </tr>\
                    </thead>\
                    <tbody id="tableProyFichaContrataBody"></tbody>\
                  </table\
                </div>\
              </div></div>';
    $('#divProyFichaRepContrata').append(contrat);
    $.ajax({
        dataType: 'json',
        url: "./Proyectos?tipo=contrataciones&codSiaf=" + siaf,
        success: function (response) {
            var dataBase = response.dataBase;
            var muestraEjecContratoTbl = [];
            var muestraEjecContratoTblHead = [];
            muestraEjecContratoTblHead.push({text: 'Id', style: 'tablaHead', alignment: 'center'});
            muestraEjecContratoTblHead.push({text: 'Contrato', style: 'tablaHead', alignment: 'center'});
            muestraEjecContratoTblHead.push({text: 'Tipo Proceso', style: 'tablaHead', alignment: 'center'});
            muestraEjecContratoTblHead.push({text: 'Contratista', style: 'tablaHead', alignment: 'center'});
            muestraEjecContratoTblHead.push({text: 'Fecha', style: 'tablaHead', alignment: 'center'});
            muestraEjecContratoTblHead.push({text: 'Monto', style: 'tablaHead', alignment: 'center'});
            muestraEjecContratoTbl.push(muestraEjecContratoTblHead);
            $.each(response.listContratos, function (index, value) {
                var prcoOrden = value.prcoOrden;
                var prcoContrato = value.prcoContrato;
                var prcoTipoProceso = value.prcoTipoProceso;
                var prcoContratista = value.prcoContratista;
                var prcoFecha = value.prcoFechaSuscripcion;
                var prcoMonto;
                if (!$.trim(value.prcoMontoSuscripcion)) {
                    prcoMonto = "";
                } else {
                    prcoMonto = formatNumeroDecimal(value.prcoMontoSuscripcion);
                }
                var prcoUrl = "";
                var prcoImg = "";
                if (dataBase === "servidor") {
                    if (!$.trim(value.prcoUrlLinux)) {
                        prcoUrl = "no";
                        prcoImg = "<img src='./resources/images/no-archivo.png'></img>";
                    } else {
                        prcoUrl = "si";
                        prcoImg = "<a href='./Archivos?tipo=proyectos&url=contratos&cod_siaf=" + siaf + "&contrato_orden=" + prcoOrden + "' target='_blank'>\
                                     <img src='./resources/images/pdf-icon.png'></img>\
                                   </a>";
                    }
                }
                if (dataBase === "local") {
                    if (!$.trim(value.prcoUrlWindows)) {
                        prcoUrl = "no";
                        prcoImg = "<img src='./resources/images/no-archivo.png'></img>";
                    } else {
                        prcoUrl = "si";
                        prcoImg = "<a href='./Archivos?tipo=proyectos&url=contratos&cod_siaf=" + siaf + "&contrato_orden=" + prcoOrden + "' target='_blank'>\
                                     <img src='./resources/images/pdf-icon.png'></img>\
                                   </a>";
                    }
                }
                body5 = '<tr>\
                           <td style="text-align: center;">' + (index + 1) + '</td>\
                           <td style="text-align: left;">' + prcoContrato + '</td>\
                           <td style="text-align: left;">' + prcoTipoProceso + '</td>\
                           <td style="text-align: left;">' + prcoContratista + '</td>\
                           <td style="text-align: center;">' + prcoFecha + '</td>\
                           <td style="text-align: right;">' + prcoMonto + '</td>\
                           <td id="' + prcoUrl + '" style="text-align: center;">' + prcoImg + '</td>\
                         </tr>';
                $('#tableProyFichaContrataBody').append(body5);
                var muestraEjecContratoTblBody = [];
                muestraEjecContratoTblBody.push({text: (index + 1), style: 'tablaBody', alignment: 'center'});
                muestraEjecContratoTblBody.push({text: prcoContrato, style: 'tablaBody', alignment: 'left'});
                muestraEjecContratoTblBody.push({text: prcoTipoProceso, style: 'tablaBody', alignment: 'left'});
                muestraEjecContratoTblBody.push({text: prcoContratista, style: 'tablaBody', alignment: 'left'});
                muestraEjecContratoTblBody.push({text: prcoFecha, style: 'tablaBody', alignment: 'center'});
                muestraEjecContratoTblBody.push({text: prcoMonto, style: 'tablaBody', alignment: 'right'});
                muestraEjecContratoTbl.push(muestraEjecContratoTblBody);
            });

            $('#tableProyFichaContrata').dataTable({
                ordering: false,
                bPaginate: false,
                dom: '<"centrar-div-tabla"fB>rt',
                buttons: [
                    {
                        extend: 'excel',
                        filename: 'contrataciones_proyecto_' + siaf,
                        title: 'CONTRATACIONES',
                        headTop1: 'Código SIAF : ' + siaf,
                        headTop2: 'Código SNIP : ' + response.snip,
                        headTop3: 'Nombre Proyecto : ' + response.nombre,
                        exportOptions: {
                            orthogonal: 'sort',
                            columns: ':not(.noexport)'
                        },
                        customize: function (xlsx) {
                            var sheet = xlsx.xl.worksheets['sheet1.xml'];
                            for (var k = 5; k < 6; k++) {
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

            $("#btnProyFichaContratPdf").on('click', function () {
                var docDefinition = {
                    pageOrientation: 'landscape',
                    info: {
                        title: 'contrataciones_proyecto_' + siaf
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
                                        {text: 'CONTRATACIONES DE PROYECTO', alignment: 'center', style: 'tituloU'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            style: 'interlineado1',
                            table: {
                                widths: [90, '*', 60, 90, '*'],
                                body: [
                                    [
                                        {text: 'CODIGO SIAF :', alignment: 'left', style: 'sombreado1'},
                                        {text: response.siaf, alignment: 'left', style: 'sombreado2'},
                                        "",
                                        {text: 'CODIGO SNIP :', alignment: 'left', style: 'sombreado1'},
                                        {text: response.snip, alignment: 'left', style: 'sombreado2'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            style: 'interlineado',
                            table: {
                                widths: [90, '*'],
                                body: [
                                    [
                                        {text: 'NOMBRE PROYECTO :', alignment: 'left', style: 'sombreado1'},
                                        {text: response.nombre, alignment: 'left', style: 'sombreado2'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            style: 'interlineado1',
                            table: {
                                widths: [15, '*', 70, 150, 40, 50],
                                body: muestraEjecContratoTbl
                            },
                            layout: {
                                hLineColor: '#ECECEC',
                                vLineColor: '#ECECEC'
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
                            fontSize: 8,
                            bold: true,
                            color: '#334A74',
                            decoration: 'underline'
                        },
                        subtitulo: {
                            fontSize: 7,
                            bold: true,
                            color: '#334A74'
                        },
                        subtituloU: {
                            fontSize: 7,
                            bold: true,
                            color: '#334A74',
                            decoration: 'underline'
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
                        tablaBodyN: {
                            fontSize: 6,
                            bold: true
                        },
                        subHeader: {
                            color: 'white',
                            fillColor: '#587BA0',
                            fontSize: 6,
                            bold: true
                        },
                        subFooter: {
                            fillColor: '#D2DBE5',
                            fontSize: 6
                        },
                        tablaTotal: {
                            fillColor: '#F6F6F6',
                            fontSize: 6,
                            bold: true
                        },
                        pie: {
                            fontSize: 5
                        },
                        interlineado: {
                            margin: [0, 2, 0, 2]
                        },
                        interlineado1: {
                            margin: [0, 5, 0, 2]
                        }
                    }
                };
                pdfMake.createPdf(docDefinition).open();
            });

        }
    });

}

function llenar_proy_ficha_ubi_geogra(siaf) {
    $('#divProyFichaRepUbiGeogra').empty();
    ubigeo = '<div style="height: 32px;">\
                <button id="btnProyFichaUbigeoPdf" style="float: right;" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="Exportar a PDF">\
                  <span>\
                    <img src="./templates/plugins/datatables/images/pdf.png">\
                  </span>\
                </button>\
               </div>\
               <div class="pad15">\
               <div>\
                <div style="overflow-x:auto;">\
                  <table id="tableProyFichaUbigeo" class="display" cellspacing="0" width="100%">\
                    <thead>\
                      <tr>\
                        <th style="text-align: center;">Id</th>\
                        <th style="text-align: center;">Departamento</th>\
                        <th style="text-align: center;">Provincia</th>\
                        <th style="text-align: center;">Distrito</th>\
                        <th style="text-align: center;">Localidad</th>\
                        <th style="text-align: center; width: 120px;">Latitud</th>\
                        <th style="text-align: center; width: 120px;">Longitud</th>\
                      </tr>\
                    </thead>\
                    <tbody id="tableProyFichaUbigeoBody"></tbody>\
                  </table\
                </div>\
              </div></br>\
              <div id="divProyFichaUbigeoMap"></div></div>';
    $('#divProyFichaRepUbiGeogra').append(ubigeo);
    $.ajax({
        dataType: 'json',
        url: "./Proyectos?tipo=ubigeo&codSiaf=" + siaf,
        success: function (response) {
            var locations = [];
            var size = 0;
            var latitudT = 0.00;
            var longitudT = 0.00;
            var muestraEjecUbigeoTbl = [];
            var muestraEjecUbigeoTblHead = [];
            muestraEjecUbigeoTblHead.push({text: 'Id', style: 'tablaHead', alignment: 'center'});
            muestraEjecUbigeoTblHead.push({text: 'Departamento', style: 'tablaHead', alignment: 'center'});
            muestraEjecUbigeoTblHead.push({text: 'Provincia', style: 'tablaHead', alignment: 'center'});
            muestraEjecUbigeoTblHead.push({text: 'Distrito', style: 'tablaHead', alignment: 'center'});
            muestraEjecUbigeoTblHead.push({text: 'Localidad', style: 'tablaHead', alignment: 'center'});
            muestraEjecUbigeoTblHead.push({text: 'Latitud', style: 'tablaHead', alignment: 'center'});
            muestraEjecUbigeoTblHead.push({text: 'Longitud', style: 'tablaHead', alignment: 'center'});
            muestraEjecUbigeoTbl.push(muestraEjecUbigeoTblHead);
            $.each(response.listUbigeo, function (index, value) {
                var depart, provin, distri, locali, latitud, longitud;
                if (!$.trim(value.prubDepartamento)) {
                    depart = "";
                } else {
                    depart = value.prubDepartamento;
                }
                if (!$.trim(value.prubProvincia)) {
                    provin = "";
                } else {
                    provin = value.prubProvincia;
                }
                if (!$.trim(value.prubDistrito)) {
                    distri = "";
                } else {
                    distri = value.prubDistrito;
                }
                if (!$.trim(value.prubLocalidad)) {
                    locali = "";
                } else {
                    locali = value.prubLocalidad;
                }
                if (!$.trim(value.prubLatitud)) {
                    latitud = "";
                    if (!$.trim(value.prubLongitud)) {
                        longitud = "";
                    } else {
                        longitud = value.prubLongitud;
                    }
                } else {
                    latitud = value.prubLatitud;
                    if (!$.trim(value.prubLongitud)) {
                        longitud = "";
                    } else {
                        longitud = value.prubLongitud;
                        latitudT += value.prubLatitud;
                        longitudT += value.prubLongitud;
                        locations.push([locali, latitud, longitud, (size + 1)]);
                        size++;
                    }
                }
                body6 = '<tr>\
                           <td style="text-align: center;">' + (index + 1) + '</td>\
                           <td style="text-align: left;">' + depart + '</td>\
                           <td style="text-align: left;">' + provin + '</td>\
                           <td style="text-align: left;">' + distri + '</td>\
                           <td style="text-align: left;">' + locali + '</td>\
                           <td style="text-align: center;">' + latitud + '</td>\
                           <td style="text-align: center;">' + longitud + '</td>\
                         </tr>';
                $('#tableProyFichaUbigeoBody').append(body6);
                var muestraEjecUbigeoTblBody = [];
                muestraEjecUbigeoTblBody.push({text: (index + 1), style: 'tablaBody', alignment: 'center'});
                muestraEjecUbigeoTblBody.push({text: depart, style: 'tablaBody', alignment: 'left'});
                muestraEjecUbigeoTblBody.push({text: provin, style: 'tablaBody', alignment: 'left'});
                muestraEjecUbigeoTblBody.push({text: distri, style: 'tablaBody', alignment: 'left'});
                muestraEjecUbigeoTblBody.push({text: locali, style: 'tablaBody', alignment: 'left'});
                muestraEjecUbigeoTblBody.push({text: latitud, style: 'tablaBody', alignment: 'center'});
                muestraEjecUbigeoTblBody.push({text: longitud, style: 'tablaBody', alignment: 'center'});
                muestraEjecUbigeoTbl.push(muestraEjecUbigeoTblBody);
            });

            $('#tableProyFichaUbigeo').dataTable({
                ordering: false,
                bPaginate: false,
                dom: '<"centrar-div-tabla"fB>rt',
                buttons: [
                    {
                        extend: 'excel',
                        filename: 'ubicacion_geografica_proyecto_' + siaf,
                        title: 'UBICACIÓN GEOGRÁFICA',
                        headTop1: 'Código SIAF : ' + siaf,
                        headTop2: 'Código SNIP : ' + response.snip,
                        headTop3: 'Nombre Proyecto : ' + response.nombre,
                        exportOptions: {
                            orthogonal: 'sort',
                            columns: ':visible'
                        }
                    }
                ]
            });

            if (size > 0) {

                $('#divProyFichaUbigeoMap').empty();
                var mapCont = '</br><div>\
                               <label>MAPA DE UBICACIÓN</label>\
                               </div>\
                               <div id="divProyFichaUbigeoMapGoogle" class="gmaps"></div>';
                $('#divProyFichaUbigeoMap').append(mapCont);

                var map = new google.maps.Map(document.getElementById('divProyFichaUbigeoMapGoogle'), {
                    zoom: 10,
                    center: new google.maps.LatLng((latitudT / size), (longitudT / size)),
                    mapTypeId: google.maps.MapTypeId.ROADMAP
                });

                var infowindow = new google.maps.InfoWindow();

                var marker, i;

                for (i = 0; i < locations.length; i++) {
                    marker = new google.maps.Marker({
                        position: new google.maps.LatLng(locations[i][1], locations[i][2]),
                        map: map
                    });

                    google.maps.event.addListener(marker, 'click', (function (marker, i) {
                        return function () {
                            infowindow.setContent(locations[i][0]);
                            infowindow.open(map, marker);
                        };
                    })(marker, i));
                }

            }

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

            $("#btnProyFichaUbigeoPdf").on('click', function () {
                var docDefinition = {
                    pageOrientation: 'landscape',
                    info: {
                        title: 'ubicacion_geografica_proyecto_' + siaf
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
                                        {text: 'UBICACIÓN GEOGRÁFICA', alignment: 'center', style: 'tituloU'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            style: 'interlineado1',
                            table: {
                                widths: [90, '*', 60, 90, '*'],
                                body: [
                                    [
                                        {text: 'CODIGO SIAF :', alignment: 'left', style: 'sombreado1'},
                                        {text: response.siaf, alignment: 'left', style: 'sombreado2'},
                                        "",
                                        {text: 'CODIGO SNIP :', alignment: 'left', style: 'sombreado1'},
                                        {text: response.snip, alignment: 'left', style: 'sombreado2'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            style: 'interlineado',
                            table: {
                                widths: [90, '*'],
                                body: [
                                    [
                                        {text: 'NOMBRE PROYECTO :', alignment: 'left', style: 'sombreado1'},
                                        {text: response.nombre, alignment: 'left', style: 'sombreado2'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: 'white',
                                vLineColor: 'white'
                            }
                        },
                        {
                            style: 'interlineado1',
                            table: {
                                widths: [20, 70, 70, 70, '*', 70, 70],
                                body: muestraEjecUbigeoTbl
                            },
                            layout: {
                                hLineColor: '#ECECEC',
                                vLineColor: '#ECECEC'
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
                            fontSize: 8,
                            bold: true,
                            color: '#334A74',
                            decoration: 'underline'
                        },
                        subtitulo: {
                            fontSize: 7,
                            bold: true,
                            color: '#334A74'
                        },
                        subtituloU: {
                            fontSize: 7,
                            bold: true,
                            color: '#334A74',
                            decoration: 'underline'
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
                        tablaBodyN: {
                            fontSize: 6,
                            bold: true
                        },
                        subHeader: {
                            color: 'white',
                            fillColor: '#587BA0',
                            fontSize: 6,
                            bold: true
                        },
                        subFooter: {
                            fillColor: '#D2DBE5',
                            fontSize: 6
                        },
                        tablaTotal: {
                            fillColor: '#F6F6F6',
                            fontSize: 6,
                            bold: true
                        },
                        pie: {
                            fontSize: 5
                        },
                        interlineado: {
                            margin: [0, 2, 0, 2]
                        },
                        interlineado1: {
                            margin: [0, 5, 0, 2]
                        }
                    }
                };
                pdfMake.createPdf(docDefinition).open();
            });

        }
    });

}

function llenar_proy_ficha_gal_fotos(siaf) {
    $('#divProyFichaRepGalFotos').empty();
    $.ajax({
        dataType: 'json',
        url: "./Proyectos?tipo=galeria_fotos&codSiaf=" + siaf,
        success: function (response) {
            if (response.estado) {
                var urlFotos = [];
                var tituloFotos = [];
                var descripFotos = [];
                $.each(response.listFotos, function (index, value) {
                    var titulo, descripcion, url, principal, tipo;
                    if (!$.trim(value.prfoTitulo)) {
                        titulo = "";
                    } else {
                        titulo = value.prfoTitulo;
                    }
                    if (!$.trim(value.prfoDescripcion)) {
                        descripcion = "";
                    } else {
                        descripcion = value.prfoDescripcion;
                    }
                    if (response.dataBase === "local") {
                        if (!$.trim(value.prfoUrlWindows)) {
                            url = "";
                        } else {
                            url = value.prfoUrlWindows;
                        }
                    }
                    if (response.dataBase === "servidor") {
                        if (!$.trim(value.prfoUrlLinux)) {
                            url = "";
                        } else {
                            url = value.prfoUrlLinux;
                        }
                    }
                    principal = value.prfoPrincipal;
                    tipo = value.prfoTipo;
                    if (principal) {
                        fotos = '<div style="height: 32px;">\
                                  <button id="btnProyFichaFotosPdf" style="float: right;" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="Exportar a PDF">\
                                    <span>\
                                      <img src="./templates/plugins/datatables/images/pdf.png">\
                                    </span>\
                                  </button>\
                                </div>\
                                <div class="pad15">\
                                <label class="center">FOTO PRINCIPAL</label></br>\
                                <a href="./Imagen?ruta=' + url + '&type=' + tipo + '" class="fresco" data-fresco-group="galeria" \
                                  title="Haga click para visualizar todas las fotos" data-fresco-caption="<p>' + titulo + '</p><p>' + descripcion + '</p>">\
                                  <img src="./Imagen?ruta=' + url + '&type=' + tipo + '" alt="">\
                                </a>\
                             </div>';
                    } else {
                        fotos = '<div class="hide">\
                                    <a href="./Imagen?ruta=' + url + '&type=' + tipo + '" class="fresco" data-fresco-group="galeria" \
                                        data-fresco-caption="<p>' + titulo + '</p><p>' + descripcion + '</p>">\
                                      <img src="./Imagen?ruta=' + url + '&type=' + tipo + '" alt="">\
                                    </a>\
                                 </div>';

                    }
                    $('#divProyFichaRepGalFotos').append(fotos);
                    urlFotos.push("./Imagen?ruta=" + url + "&type=" + tipo);
                    tituloFotos.push(titulo);
                    descripFotos.push(descripcion);
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

                var imgFotos = [];

                for (var i = 0; i < urlFotos.length; i++) {
                    convertImgToDataURLviaCanvas(urlFotos[i], function (base64Img) {
                        imgFotos.push(base64Img);
                    });
                }

                var muestraGaleriaProy = [];

                $("#btnProyFichaFotosPdf").on('click', function () {

                    muestraGaleriaProy = [];

                    for (var j = 0; j < urlFotos.length; j++) {
                        muestraGaleriaProy.push(
                                {
                                    style: 'interlineado',
                                    table: {
                                        widths: [20, 300, 20],
                                        body: [
                                            [
                                                "",
                                                {
                                                    table: {
                                                        widths: ['*'],
                                                        body: [
                                                            [
                                                                {
                                                                    table: {
                                                                        widths: ['*'],
                                                                        body: [
                                                                            [
                                                                                {image: imgFotos[j], width: 280, alignment: 'center'}
                                                                            ],
                                                                            [
                                                                                {text: tituloFotos[j], alignment: 'left', style: 'sombreado1'}
                                                                            ],
                                                                            [
                                                                                {text: descripFotos[j], alignment: 'left', style: 'sombreado2'}
                                                                            ]
                                                                        ]
                                                                    },
                                                                    layout: {
                                                                        hLineColor: '#334A74',
                                                                        vLineColor: '#334A74'
                                                                    }
                                                                }
                                                            ]
                                                        ]
                                                    },
                                                    layout: {
                                                        hLineColor: 'white',
                                                        vLineColor: 'white'
                                                    }
                                                },
                                                ""
                                            ]
                                        ]
                                    },
                                    layout: {
                                        hLineColor: 'white',
                                        vLineColor: 'white'
                                    }
                                }
                        );
                    }

                    var docDefinition = {
                        //pageOrientation: 'landscape',
                        info: {
                            title: 'galeria_fotos_proyecto_' + siaf
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
                                            {text: 'GALERÍA DE FOTOS DE PROYECTO', alignment: 'center', style: 'tituloU'}
                                        ]
                                    ]
                                },
                                layout: {
                                    hLineColor: 'white',
                                    vLineColor: 'white'
                                }
                            },
                            {
                                style: 'interlineado1',
                                table: {
                                    widths: [70, '*', 60, 70, '*'],
                                    body: [
                                        [
                                            {text: 'CODIGO SIAF :', alignment: 'left', style: 'sombreado1'},
                                            {text: response.siaf, alignment: 'left', style: 'sombreado2'},
                                            "",
                                            {text: 'CODIGO SNIP :', alignment: 'left', style: 'sombreado1'},
                                            {text: response.snip, alignment: 'left', style: 'sombreado2'}
                                        ]
                                    ]
                                },
                                layout: {
                                    hLineColor: 'white',
                                    vLineColor: 'white'
                                }
                            },
                            {
                                style: 'interlineado',
                                table: {
                                    widths: [70, '*'],
                                    body: [
                                        [
                                            {text: 'NOMBRE PROYECTO :', alignment: 'left', style: 'sombreado1'},
                                            {text: response.nombre, alignment: 'left', style: 'sombreado2'}
                                        ]
                                    ]
                                },
                                layout: {
                                    hLineColor: 'white',
                                    vLineColor: 'white'
                                }
                            },
                            muestraGaleriaProy
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
                                fontSize: 8,
                                bold: true,
                                color: '#334A74',
                                decoration: 'underline'
                            },
                            subtitulo: {
                                fontSize: 7,
                                bold: true,
                                color: '#334A74'
                            },
                            subtituloU: {
                                fontSize: 7,
                                bold: true,
                                color: '#334A74',
                                decoration: 'underline'
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
                            tablaBodyN: {
                                fontSize: 6,
                                bold: true
                            },
                            subHeader: {
                                color: 'white',
                                fillColor: '#587BA0',
                                fontSize: 6,
                                bold: true
                            },
                            subFooter: {
                                fillColor: '#D2DBE5',
                                fontSize: 6
                            },
                            tablaTotal: {
                                fillColor: '#F6F6F6',
                                fontSize: 6,
                                bold: true
                            },
                            pie: {
                                fontSize: 5
                            },
                            interlineado: {
                                margin: [0, 2, 0, 2]
                            },
                            interlineado1: {
                                margin: [0, 5, 0, 2]
                            }
                        }
                    };
                    pdfMake.createPdf(docDefinition).open();
                });

            } else {
                fotos = '<div class="pad15"></br>\
                          <div class="form-group row">\
                            <label class="col-sm-12 col-form-label ficha-sombreado2">NO SE HAN REGISTRADO FOTOS DE ÉSTE PROYECTO</label>\
                          </div>\
                         </div>';
                $('#divProyFichaRepGalFotos').append(fotos);
            }
        }
    });
}
