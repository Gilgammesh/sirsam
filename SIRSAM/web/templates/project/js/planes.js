// Llenar el Menu Planeamiento Estratégico

function llenar_planes_alert() {
    alert("funciona llenar Menu Planeamiento Estratégico");
}

function llenar_menu_planes() {

    $("#divContenidoMenu").empty();
    var cont_plan = '<section id="section_planes" class="background_sirsam_">\
                        <div class="menu_indice">\
                            <div class ="container">\
                                <ol class="breadcrumb">\
                                    <li>\
                                        <a>\
                                            <i class="choose-icon ion-arrow-graph-up-right" style="color: black; font-size: 15px;"></i>  \
                                            Planeamiento Estratégico\
                                        </a>\
                                    </li>\
                                    <li id="liTipoMenuPlanes"></li>\
                                </ol>\
                            </div>\
                        </div>\
                        <br>\
                        <div class="container">\
                            <a id="aRegInfoPlanes" style="cursor: pointer;">\
                              <div class="naranja_secun boton-superior pad8" style="cursor: pointer;">\
                               <img src="./resources/images/planeamiento2.png">&nbsp; REGISTRAR INFORMACIÓN  <img src="./resources/images/planeamiento3.png">\
                              </div>\
                            </a>\
                            <div class="filtro_princ naranja_secun">\
                                <div class="form-group">\
                                    <label for="listCategoriaPlanes" class="col-form-label">Elija Reporte :</label>\
                                    <select class="select-form" id="listCategoriaPlanes"></select>\
                                </div>\
                            </div>\
                            <br>\
                            <div class="filtro_report naranja_secun">\
                                <div id="divNivelPadrePlanes"></div>\
                                <div id="divNivelesPlanes"></div>\
                            </div>\
                            <br>\
                            <div id="divIndicadorPlanes"></div>\
                        </div>\
                    </section>';
    $("#divContenidoMenu").append(cont_plan);

    llenarCategoriasPlanes();

}

function llenarCategoriasPlanes() {

    $.ajax({
        dataType: 'json',
        url: "./Planeamiento?url=categorias",
        success: function (response) {

            $.each(response.listCateg, function (index, value) {
                var categ = "<option value=" + value.cateId + ">" + value.cateNombre + "</option>";
                $("#listCategoriaPlanes").append(categ);
                $('#listCategoriaPlanes').prop('selectedIndex', 0);
            });
            llenarJerarquiaPadre($("#listCategoriaPlanes").val());

            $("#listCategoriaPlanes").bind("change", function () {
                var cate_id = $("#listCategoriaPlanes").val();
                llenarJerarquiaPadre(cate_id);
                $("#divIndicadorPlanes").removeClass("filtro_report");
                $("#divIndicadorPlanes").removeClass("naranja_secun");
            });
        }
    });

}

function llenarJerarquiaPadre(cateId) {
    $("#liTipoMenuPlanes").empty();
    $("#divNivelPadrePlanes").empty();
    $("#divNivelesPlanes").empty();
    $("#divIndicadorPlanes").empty();
    $.ajax({
        dataType: 'json',
        url: "./Planeamiento?url=jerarquia_padre&cate_id=" + cateId,
        success: function (response) {
            $("#liTipoMenuPlanes").append('<i class="fa ' + response.cate_icon + '"></i> ' + response.cate_nombre);
            var padre = '<div class="form-group row">\
                            <label for="listJerarquiaPadre" class="col-sm-2 col-form-label nivel">' + response.nombre_padre + ' :</label>\
                            <div class="col-sm-10">\
                               <select class="select-form nivel" id="listJerarquiaPadre"></select>\
                            </div>\
                         </div>';
            $("#divNivelPadrePlanes").append(padre);
            $("#listJerarquiaPadre").append("<option value='0' style='font-weight: bold;'>--SELECCIONE " + response.nombre_padre + "--</option>");
            $.each(response.listPadre, function (index, value) {
                var nive_codigo;
                var nive_nombre;
                var nive_sigla;
                if (!$.trim(value.niveCodigo)) {
                    nive_codigo = "";
                } else {
                    nive_codigo = value.niveCodigo + " : ";
                }
                if (!$.trim(value.niveNombre)) {
                    nive_nombre = "";
                } else {
                    nive_nombre = value.niveNombre;
                }
                if (!$.trim(value.niveSigla)) {
                    nive_sigla = "";
                } else {
                    nive_sigla = " (" + value.niveSigla + ")";
                }
                var jerarq = "<option value=" + value.niveId + "_" + value.niveSub + "_" + value.niveIndicador + "_" + value.niveDetalle + "_nive>" + nive_codigo + nive_nombre + nive_sigla + "</option>";
                $("#listJerarquiaPadre").append(jerarq);

                $("#listJerarquiaPadre").bind("change", function () {
                    var nive_id = $("#listJerarquiaPadre").val();
                    if (nive_id === "0") {
                        $("#divNivelesPlanes").empty();
                        $("#divIndicadorPlanes").empty();
                    } else {
                        llenarNivelesJerarquia(nive_id);
                        llenarIndicadoresNiveles(nive_id);
                    }
                });

            });
        }
    });

}

function llenarNivelesJerarquia(niveId) {
    $("#divNivelesPlanes").empty();
    $("#divIndicadorPlanes").empty();
    $.ajax({
        dataType: 'json',
        url: "./Planeamiento?url=niveles_jerarquia&nive_id=" + niveId,
        success: function (response) {
            $.each(response.listNiveles, function (index, value) {
                var nivel = '<div class="nivel">\
                                <div class="form-group row">\
                                    <label for="listNivel' + value.niveJerarquia + '" class="col-sm-2 col-form-label nivel">' + value.niveJerarquiaNombre + ' :</label>\
                                    <div class="col-sm-10">\
                                        <select class="select-form nivel" id="listNivel' + value.niveJerarquia + '"></select>\
                                    </div>\
                                </div>\
                                <div id="divNivel' + value.niveJerarquia + 'Detalle"></div>\
                             </div>';
                $("#divNivelesPlanes").append(nivel);
                $("#listNivel" + value.niveJerarquia).empty();
                $("#listNivel" + value.niveJerarquia).append("<option value='0_" + response.nive_padre + "' style='font-weight: bold;'>--SELECCIONE " + value.niveJerarquiaNombre + "--</option>");
                if (value.niveJerarquia === 1) {
                    $("#listNivel" + value.niveJerarquia).prop('disabled', false);
                    llenarContenidoNiveles($("#listJerarquiaPadre").val(), value.niveJerarquia, response.nivel_id);
                } else {
                    $("#listNivel" + value.niveJerarquia).prop('disabled', true);
                }

                $("#listNivel" + value.niveJerarquia).bind("change", function () {
                    var long = response.listNiveles.length;
                    var jerar = value.niveJerarquia;
                    var valor_jera = $("#listNivel" + value.niveJerarquia).val().split("_");
                    var prim_valor = valor_jera[0];
                    if (jerar === 0) {
                        $("#divNivel" + (jerar + 1) + "Detalle").empty();
                        $("#divNivel" + (jerar + 1) + "Detalle").append(response.detalle);
                    } else {
                        $("#divNivel" + jerar + "Detalle").empty();
                        $("#divNivel" + jerar + "Detalle").append(response.detalle);
                    }
                    if (long === jerar) {
                        llenarIndicadoresNiveles($("#listNivel" + jerar).val());
                    } else {
                        if (prim_valor === "0") {
                            for (var i = jerar + 1; i <= long; i++) {
                                listasLimpiarPlanes(response.nivel_id, i);
                                $("#listNivel" + i).prop('disabled', true);
                            }
                        } else {
                            $("#listNivel" + (jerar + 1)).prop('disabled', false);
                            llenarContenidoNiveles($("#listNivel" + jerar).val(), (jerar + 1), response.nivel_id);
                            for (var k = jerar + 2; k <= long; k++) {
                                listasLimpiarPlanes(response.nivel_id, k);
                                $("#listNivel" + k).prop('disabled', true);
                            }
                        }
                        llenarIndicadoresNiveles($("#listNivel" + jerar).val());
                    }
                });
            });
        }
    });
}

function listasLimpiarPlanes(niveId, niveJera) {
    $("#listNivel" + niveJera).empty();
    $.ajax({
        dataType: 'json',
        url: "./Planeamiento?url=niveles_jerarquia&nive_id=" + niveId + "&jerarquia=" + niveJera,
        success: function (responseJ) {
            $("#listNivel" + responseJ.jerarquia).append("<option value='0' style='font-weight: bold;'>--SELECCIONE " + responseJ.jerarquia_nombre + "--</option>");
        }
    });
}


function llenarContenidoNiveles(nivePadreId, niveJera, niveId) {
    $.ajax({
        dataType: 'json',
        url: "./Planeamiento?url=contenido_niveles&nive_padre_id=" + nivePadreId + "&nive_jera=" + niveJera + "&nive_id=" + niveId,
        success: function (response) {
            if (response.nive_detalle) {
                if (niveJera === 1) {
                    $("#divNivel" + niveJera + "Detalle").empty();
                    $("#divNivel" + niveJera + "Detalle").append(response.detalle);
                } else {
                    $("#divNivel" + (niveJera - 1) + "Detalle").empty();
                    $("#divNivel" + (niveJera - 1) + "Detalle").append(response.detalle);
                }
            }
            $("#listNivel" + response.nive_jera).empty();
            $("#listNivel" + response.nive_jera).append("<option value='0_" + response.nive_padre + "' style='font-weight: bold;'>--SELECCIONE " + response.jerarquia_nombre + "--</option>");
            $.each(response.list, function (index, value) {
                var conte;
                if (response.nive_sub) {
                    var lugar;
                    var periodo;
                    if (!$.trim(value.nisuProvincia) && !$.trim(value.nisuDistrito)) {
                        lugar = value.departamento;
                    } else {
                        if (!$.trim(value.nisuDistrito)) {
                            lugar = value.provincia;
                        } else {
                            lugar = value.distrito;
                        }
                    }
                    if (value.nisuActualiza) {
                        periodo = "al " + value.nisuFin;
                    } else {
                        periodo = value.nisuInicio + "-" + value.nisuFin;
                    }
                    conte = "<option value=" + value.nisuId + "_false_" + value.nisuIndicador + "_" + value.niveDetalle + "_" + response.tipo + ">" + lugar + " " + periodo + "</option>";
                } else {
                    var nive_codigo;
                    var nive_nombre;
                    var nive_sigla;
                    if (!$.trim(value.niveCodigo)) {
                        nive_codigo = "";
                    } else {
                        nive_codigo = value.niveCodigo + " : ";
                    }
                    if (!$.trim(value.niveNombre)) {
                        nive_nombre = "";
                    } else {
                        nive_nombre = value.niveNombre;
                    }
                    if (!$.trim(value.niveSigla)) {
                        nive_sigla = "";
                    } else {
                        nive_sigla = " (" + value.niveSigla + ")";
                    }
                    conte = "<option value=" + value.niveId + "_" + value.niveSub + "_" + value.niveIndicador + "_" + value.niveDetalle + "_" + response.tipo + ">" + nive_codigo + nive_nombre + nive_sigla + "</option>";
                }
                $("#listNivel" + response.nive_jera).append(conte);
            });
        }
    });
}

function llenarIndicadoresNiveles(niveId) {
    $.ajax({
        dataType: 'json',
        url: "./Planeamiento?url=nivel_indicadores&nive_id=" + niveId,
        success: function (response) {
            $("#divIndicadorPlanes").empty();
            if (response.nive_indicador) {
                $("#divIndicadorPlanes").addClass("filtro_report");
                $("#divIndicadorPlanes").addClass("naranja_secun");
                var divs = '<div id="divIndicadorMenuPlanes"></div>\
                            <div id="divIndicadorContPlanes"></div>';
                $("#divIndicadorPlanes").append(divs);
                var listI = '<div class="form-group row">\
                                <label for="listIndicadores" class="col-sm-2 col-form-label">Indicador :</label>\
                                <div class="col-sm-10">\
                                    <select class="select-form" id="listIndicadores"></select>\
                                </div>\
                             </div>';
                $("#divIndicadorMenuPlanes").append(listI);
                $.each(response.listIndi, function (index, value) {
                    var indi_nombre;
                    var indi_sigla;
                    if (!$.trim(value.indiNombre)) {
                        indi_nombre = "";
                    } else {
                        indi_nombre = value.indiNombre;
                    }
                    if (!$.trim(value.indiSigla)) {
                        indi_sigla = "";
                    } else {
                        indi_sigla = value.indiSigla + " : ";
                    }
                    var conte = "<option value=" + value.indiId + ">" + indi_sigla + indi_nombre + "</option>";
                    $("#listIndicadores").append(conte);
                });
                $('#listIndicadores').prop('selectedIndex', 0);
                llenarIndicadorContenido($("#listIndicadores").val());
                $('html,body').animate({
                    scrollTop: $("#divIndicadorPlanes").offset().top - 10},
                        'fast');

                $("#listIndicadores").bind("change", function () {
                    var indi_id = $("#listIndicadores").val();
                    if (indi_id === "0") {
                        $("#divIndicadorContPlanes").empty();
                    } else {
                        llenarIndicadorContenido(indi_id);
                    }
                    $('html,body').animate({
                        scrollTop: $("#divIndicadorPlanes").offset().top - 10},
                            'fast');
                });

            } else {
                $("#divIndicadorPlanes").removeClass("filtro_report");
                $("#divIndicadorPlanes").removeClass("naranja_secun");
            }
        }
    });
}


function llenarIndicadorContenido(indiId) {
    $.ajax({
        dataType: 'json',
        url: "./Planeamiento?url=indicador_detalle&indi_id=" + indiId,
        success: function (response) {
            $("#divIndicadorContPlanes").empty();
            var contH = '<div class="form-group row">\
                          <label class="col-sm-2 col-form-label">Descargas :</label>';

            if (response.indi_ficha) {
                contH += '<div class="col-sm-2">\
                            <a id="aIndicadorFicha" class="hRef">\
                              <img src="./resources/images/ficha_tecnica.png">\
                            </a>\
                          </div>';
            }
            contH += '<div class="col-sm-2">\
                        <a id="aIndicadorFuente" class="hRef disabled">\
                          <img src="./resources/images/fuente_informacion.png">\
                        </a>\
                      </div>\
                    </div>\
                    <div id="divTblFuenteIndi" style="display: none;">\
                        <table id="tablaFuenteIndi" class="display" cellspacing="0" width="100%">\
                            <thead id="tablaFuenteIndiHead"></thead>\
                            <tbody id="tablaFuenteIndiBody"></tbody>\
                        </table>\
                    </div>\
                    <br>\
                    <div class="tab-content tabcontent-border fondo-tab">\
                      <div class="tab-pane active" id="divTableroIndi" role="tabpanel"></div>\
                      <div class="tab-pane" id="divDinamicoIndi" role="tabpanel"></div>\
                    </div>';
            $("#divIndicadorContPlanes").append(contH);

            ///////////////// Exportar a PDF ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   

            var imageUrl_grsm = './resources/images/logo_grsm.png';
            var imageUrl_system = './resources/images/logo_sirsm.png';
            var imageUrl_indicador = "./Planeamiento?url=grafica_ficha&indi_id=" + indiId;
            var img_grsm, img_system, image_indicador;
            convertImgToDataURLviaCanvas(imageUrl_grsm, function (base64Img) {
                img_grsm = base64Img;
            });
            convertImgToDataURLviaCanvas(imageUrl_system, function (base64Img) {
                img_system = base64Img;
            });
            convertImgToDataURLviaCanvas(imageUrl_indicador, function (base64Img) {
                image_indicador = base64Img;
            });

            if (response.indi_ficha) {
                $("#aIndicadorFicha").click(function () {
                    var arrayPadre = $("#listJerarquiaPadre").val().split("_");
                    var padrePrinc = arrayPadre[0].trim();
                    var niveles = [];
                    niveles.push({
                        table: {
                            widths: ['*'],
                            body: [
                                [
                                    {text: 'FICHA TÉCNICA DE INDICADOR', alignment: 'center', style: 'sombreado1'}
                                ]
                            ]
                        },
                        layout: {
                            hLineColor: '#7B8AA5',
                            vLineColor: '#7B8AA5'
                        }
                    });

                    if (padrePrinc === "1") {
                        var nivel_nombre = [];
                        var nivel_descripcion = [];
                        var countN = 0;
                        $("#divNivelesPlanes label.nivel").each(function (index, obj) {
                            nivel_nombre.push($(this).text());

                        });

                        $("#divNivelesPlanes select.nivel option:selected").each(function (index, obj) {
                            if ($(this).val().split("_")[0] > 0) {
                                nivel_descripcion.push($(this).text());
                                countN++;
                            }
                        });
                        if (countN === 3) {
                            niveles.push({
                                table: {
                                    widths: ['*'],
                                    body: [
                                        [
                                            {text: nivel_nombre[2].split(":")[0].trim() + " " + (nivel_descripcion[2].split(":")[0].trim()).split(".")[1].trim(), alignment: 'center', style: 'sombreado1'}
                                        ],
                                        [
                                            {text: nivel_descripcion[2].split(":")[1].trim(), alignment: 'left', style: 'sombreado2'}
                                        ]
                                    ]
                                },
                                layout: {
                                    hLineColor: '#7B8AA5',
                                    vLineColor: '#7B8AA5'
                                }
                            });
                        }
                        if (countN === 4) {
                            niveles.push({
                                table: {
                                    widths: [400, '*'],
                                    body: [
                                        [
                                            {text: nivel_nombre[2].split(":")[0].trim() + " " + (nivel_descripcion[2].split(":")[0].trim()).split(".")[1].trim(), alignment: 'center', style: 'sombreado1'},
                                            {text: nivel_nombre[3].split(":")[0].trim() + " " + (nivel_descripcion[3].split(":")[0].trim()).split(".")[2].trim(), alignment: 'center', style: 'sombreado1'}
                                        ],
                                        [
                                            {text: nivel_descripcion[2].split(":")[1].trim(), alignment: 'left', style: 'sombreado2'},
                                            {text: nivel_descripcion[3].split(":")[1].trim(), alignment: 'left', style: 'sombreado2'}
                                        ]
                                    ]
                                },
                                layout: {
                                    hLineColor: '#7B8AA5',
                                    vLineColor: '#7B8AA5'
                                }
                            });
                        }

                    } else {
                        var nivel_padre = $("#divNivelPadrePlanes label.nivel").text();
                        var nombre_nivel_padre = $("#divNivelPadrePlanes select.nivel option:selected").text();
                        niveles.push({
                            table: {
                                widths: [70, '*'],
                                body: [
                                    [
                                        {text: nivel_padre, alignment: 'left', style: 'sombreado1'},
                                        {text: nombre_nivel_padre, alignment: 'left', style: 'sombreado2'}
                                    ]
                                ]
                            },
                            layout: {
                                hLineColor: '#7B8AA5',
                                vLineColor: '#7B8AA5'
                            }
                        });

                        var nivel_nombre = [];
                        $("#divNivelesPlanes label.nivel").each(function (index, obj) {
                            nivel_nombre.push($(this).text());
                        });

                        $("#divNivelesPlanes select.nivel option:selected").each(function (index, obj) {
                            if ($(this).val().split("_")[0] > 0) {
                                if ($(this).val().split("_")[4] === "nisu") {
                                    niveles.push({
                                        table: {
                                            widths: [70, '*'],
                                            body: [
                                                [
                                                    {text: nivel_nombre[index], alignment: 'left', style: 'sombreado1'},
                                                    {text: $(this).text(), alignment: 'left', style: 'sombreado2'}
                                                ]
                                            ]
                                        },
                                        layout: {
                                            hLineColor: '#7B8AA5',
                                            vLineColor: '#7B8AA5'
                                        }
                                    });
                                } else {
                                    niveles.push({
                                        table: {
                                            widths: ['*'],
                                            body: [
                                                [
                                                    {text: nivel_nombre[index], alignment: 'center', style: 'sombreado1'}
                                                ],
                                                [
                                                    {text: $(this).text(), alignment: 'left', style: 'sombreado2'}
                                                ]
                                            ]
                                        },
                                        layout: {
                                            hLineColor: '#7B8AA5',
                                            vLineColor: '#7B8AA5'
                                        }
                                    });
                                }
                            }
                        });
                    }

                    var nombre;
                    if (!$.trim(response.nombre)) {
                        nombre = "";
                    } else {
                        nombre = response.nombre;
                    }
                    var definicion;
                    if (!$.trim(response.definicion)) {
                        definicion = "";
                    } else {
                        definicion = response.definicion;
                    }
                    var tipo;
                    if (!$.trim(response.tipo)) {
                        tipo = "";
                    } else {
                        tipo = response.tipo;
                    }
                    var desagrega;
                    if (!$.trim(response.desagrega)) {
                        desagrega = "";
                    } else {
                        desagrega = response.desagrega;
                    }
                    var unidad;
                    if (!$.trim(response.unidad)) {
                        unidad = "";
                    } else {
                        unidad = response.unidad;
                    }
                    var base;
                    if (!$.trim(response.base)) {
                        base = "";
                    } else {
                        base = response.base;
                    }
                    var actual;
                    if (!$.trim(response.actual)) {
                        actual = "";
                    } else {
                        actual = response.actual;
                    }
                    var justificacion;
                    if (!$.trim(response.justificacion)) {
                        justificacion = "";
                    } else {
                        justificacion = response.justificacion;
                    }
                    var limitaciones;
                    if (!$.trim(response.limitaciones)) {
                        limitaciones = "";
                    } else {
                        limitaciones = response.limitaciones;
                    }
                    var formula;
                    if (!$.trim(response.formula)) {
                        formula = "";
                    } else {
                        formula = response.formula;
                    }
                    var periodicidad;
                    if (!$.trim(response.periodicidad)) {
                        periodicidad = "";
                    } else {
                        periodicidad = response.periodicidad;
                    }
                    var fuente;
                    if (!$.trim(response.fuente)) {
                        fuente = "";
                    } else {
                        fuente = response.fuente;
                    }
                    var verificacion;
                    if (!$.trim(response.verificacion)) {
                        verificacion = "";
                    } else {
                        verificacion = response.verificacion;
                    }
                    var responsable;
                    if (!$.trim(response.responsable)) {
                        responsable = "";
                    } else {
                        responsable = response.responsable;
                    }
                    var sentido;
                    if (!$.trim(response.sentido)) {
                        sentido = "";
                    } else {
                        sentido = response.sentido;
                    }
                    var frecuencia;
                    if (!$.trim(response.frecuencia)) {
                        frecuencia = "";
                    } else {
                        frecuencia = response.frecuencia;
                    }

                    var tabla_muestra_1 = [];
                    var tabla_muestra_2 = [];
                    var tabla_muestra_3 = [];
                    var tabla_anchos = [];
                    tabla_muestra_1.push({text: 'Línea de base', alignment: 'center', style: 'sombreado2X'});
                    tabla_muestra_2.push({text: 'Periodo', alignment: 'center', style: 'sombreado2X'});
                    tabla_muestra_3.push({text: 'Resultado', alignment: 'center', style: 'sombreado2X'});
                    tabla_anchos.push(60);
                    $.each(response.listDatos, function (indexD, valueD) {
                        var varP, medicion;
                        if (!$.trim(valueD.varP)) {
                            varP = "";
                        } else {
                            varP = valueD.varP;
                        }
                        if (!$.trim(valueD.medicion)) {
                            medicion = "";
                        } else {
                            medicion = formatNumero(valueD.medicion);
                        }
                        tabla_anchos.push('*');
                        if (indexD === 0) {
                            tabla_muestra_1.push({text: 'X', alignment: 'center', style: 'sombreado2X'});
                        } else {
                            tabla_muestra_1.push("");
                        }
                        tabla_muestra_2.push({text: varP, alignment: 'center', style: 'sombreado2X'});
                        tabla_muestra_3.push({text: medicion, alignment: 'center', style: 'sombreado2X'});
                    });

                    var docDefinition = {
                        pageOrientation: 'landscape',
                        info: {
                            title: 'ficha_indicador'
                        },
                        pageMargins: [20, 60, 20, 20],
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
                        content: [
                            niveles,
                            {
                                table: {
                                    widths: [390, '*'],
                                    body: [
                                        [
                                            {text: 'Nombre del Indicador', alignment: 'center', style: 'sombreado1'},
                                            {text: 'Nivel de desagregación geográfica', alignment: 'center', style: 'sombreado1'}
                                        ],
                                        [
                                            {text: nombre, alignment: 'left', style: 'sombreado2'},
                                            {text: desagrega, alignment: 'left', style: 'sombreado2'}
                                        ],
                                        [
                                            {text: 'Descripción del Indicador', alignment: 'center', style: 'sombreado1'},
                                            {text: 'Fórmula del indicador', alignment: 'center', style: 'sombreado1'}
                                        ],
                                        [
                                            {text: definicion, alignment: 'left', style: 'sombreado2'},
                                            {text: formula, alignment: 'left', style: 'sombreado2'}
                                        ]
                                    ]
                                },
                                layout: {
                                    hLineColor: '#7B8AA5',
                                    vLineColor: '#7B8AA5'
                                }
                            },
                            {
                                table: {
                                    widths: [300, 200, '*'],
                                    body: [
                                        [
                                            {text: 'Fuente de Información', alignment: 'center', style: 'sombreado1'},
                                            {text: 'Sentido del indicador', alignment: 'center', style: 'sombreado1'},
                                            {text: 'Frecuencia de evaluación', alignment: 'center', style: 'sombreado1'}
                                        ],
                                        [
                                            {text: fuente, alignment: 'left', style: 'sombreado2'},
                                            {text: sentido, alignment: 'left', style: 'sombreado2'},
                                            {text: frecuencia, alignment: 'left', style: 'sombreado2'}
                                        ]
                                    ]
                                },
                                layout: {
                                    hLineColor: '#7B8AA5',
                                    vLineColor: '#7B8AA5'
                                }
                            },
                            {
                                table: {
                                    widths: [390, '*'],
                                    body: [
                                        [
                                            {text: 'Órgano responsable de la medición', alignment: 'left', style: 'sombreado1'},
                                            {text: responsable, alignment: 'left', style: 'sombreado2'}
                                        ]
                                    ]
                                },
                                layout: {
                                    hLineColor: '#7B8AA5',
                                    vLineColor: '#7B8AA5'
                                }
                            },
                            {
                                table: {
                                    widths: ['*'],
                                    body: [
                                        [
                                            {text: 'Comportamiento del indicador en el tiempo', alignment: 'center', style: 'sombreado1'}
                                        ]
                                    ]
                                },
                                layout: {
                                    hLineColor: '#7B8AA5',
                                    vLineColor: '#7B8AA5'
                                }
                            },
                            {
                                table: {
                                    widths: tabla_anchos,
                                    body: [
                                        tabla_muestra_1,
                                        tabla_muestra_2,
                                        tabla_muestra_3
                                    ]
                                },
                                layout: {
                                    hLineColor: '#7B8AA5',
                                    vLineColor: '#7B8AA5'
                                }
                            },
                            {
                                table: {
                                    widths: ['*'],
                                    body: [
                                        [
                                            {image: image_indicador, width: 650, height: 130, alignment: 'center'}
                                        ]
                                    ]
                                },
                                layout: {
                                    hLineColor: '#7B8AA5',
                                    vLineColor: '#7B8AA5'
                                }
                            },
                            {
                                table: {
                                    widths: [390, '*'],
                                    body: [
                                        [
                                            {text: 'Limitaciones o supuestos', alignment: 'center', style: 'sombreado1'},
                                            {text: 'Justificación', alignment: 'center', style: 'sombreado1'}
                                        ],
                                        [
                                            {text: limitaciones, alignment: 'left', style: 'sombreado2'},
                                            {text: justificacion, alignment: 'left', style: 'sombreado2'}
                                        ]
                                    ]
                                },
                                layout: {
                                    hLineColor: '#7B8AA5',
                                    vLineColor: '#7B8AA5'
                                }
                            }
                        ],
                        styles: {
                            titulo: {
                                fontSize: 9,
                                color: 'black',
                                bold: true,
                                decoration: 'underline'
                            },
                            subtitulo1: {
                                fontSize: 7,
                                color: '#1F3660',
                                fillColor: 'whitesmoke',
                                bold: true
                            },
                            subtitulo2: {
                                fontSize: 7,
                                color: 'black',
                                bold: true
                            },
                            sombreado1: {
                                fillColor: '#334A74',
                                color: 'white',
                                fontSize: 7,
                                bold: true
                            },
                            sombreado2: {
                                fillColor: 'white',
                                color: 'black',
                                fontSize: 7,
                                bold: false
                            },
                            sombreado1X: {
                                fillColor: '#334A74',
                                color: 'white',
                                fontSize: 7,
                                bold: true
                            },
                            sombreado2X: {
                                fillColor: 'white',
                                color: 'black',
                                fontSize: 7,
                                bold: false
                            }
                        }
                    };
                    pdfMake.createPdf(docDefinition).open();
                });
            }

            var head = '<tr>';
            var idx = [];
            $.each(response.listV, function (indexV, valueV) {
                head += '<th id="' + valueV.invaId + '">' + valueV.invaNombre + '</th>';
                if (valueV.tivaNombre === "numeric") {
                    idx.push(indexV);
                }
            });
            head += '</tr>';
            $("#tablaFuenteIndiHead").append(head);

            var sizeV = response.sizeV;
            $.each(response.listF, function (indexF, valueF) {
                $("#tablaFuenteIndiBody").append(llenarContNVar(sizeV, valueF));
            });

            $('#tablaFuenteIndi').dataTable({
                dom: 'Brt',
                buttons: [
                    {
                        extend: 'excel',
                        filename: 'fuente_informacion_indicador',
                        title: '',
                        headTopNoMerge1: response.tipo_indicador + ": " + response.indi_nombre,
                        headTopNoMerge2: 'Fuente de Información',
                        customize: function (xlsx) {
                            var sheet = xlsx.xl.worksheets['sheet1.xml'];
                            for (var k = 0; k < idx.length; k++) {
                                $('row c[r^="' + arrayABC_excel(idx[k]) + '"]', sheet).each(function (i) {
                                    if (i > 0) {
                                        $(this).attr('s', '72');
                                    }
                                });
                            }
                        }
                    }
                ],
                "fnInitComplete": function (oSettings, json) {
                    $("#aIndicadorFuente").removeClass("disabled");
                    $("#aIndicadorFuente").on('click', function () {
                        $("#divTblFuenteIndi button.buttons-excel").trigger('click');
                    });
                }
            });

            llenarIndicadorTablero(indiId);

            $("#aTableroIndi").click(function () {
                $('html,body').animate({
                    scrollTop: $("#divIndicadorPlanes").offset().top - 10},
                        'fast');
            });

            $("#aDinamicoIndi").click(function () {
                $('html,body').animate({
                    scrollTop: $("#divIndicadorPlanes").offset().top - 10},
                        'fast');
            });
        }
    });
}

function llenarIndicadorTablero(indiId) {
    $("#divTableroIndi").empty();
    $.ajax({
        dataType: 'json',
        url: "./Planeamiento?url=indicador_tablero&indi_id=" + indiId,
        success: function (response) {
            var variable_principal = response.variable_principal;
            var tipo_indicador = response.tipo_indicador;
            var indi_nombre = response.indi_nombre;
            var unidad_medida = response.unidad_medida;
            var contT = '<div class="pad-tablero">\
                            <div class="form-group row">\
                                <div class="col-sm-12">\
                                    <div class="indicador_var_prin">\
                                        <label for="listIndiVarP" class="col-sm-2 col-form-label">' + variable_principal + ' :</label>\
                                        <div class="col-sm-6">\
                                            <select class="select-form" id="listIndiVarP"></select>\
                                        </div>\
                                    </div>\
                                </div>\
                            </div>\
                            <div class="form-group row">\
                                <div class="col-sm-9">\
                                    <div class="indicador_nombre">\
                                        <b>' + tipo_indicador + ' :</b></br>\
                                        ' + indi_nombre + '\
                                    </div>\
                                </div>\
                                <div class="col-sm-3">\
                                    <div class="indicador_medicion">\
                                        <b>Medición </b>(' + unidad_medida + ') :\
                                        <div>\
                                            <span id="spanMedicion"></span>\
                                        </div>\
                                    </div>\
                                </div>\
                            </div>\
                            <div id="divOrdenTablero"></div>\
                         </div>';
            $("#divTableroIndi").append(contT);

            $("#listIndiVarP").empty();
            $.each(response.listP, function (indexP, valueP) {
                var conteLP = "<option value=" + valueP.varP + ">" + valueP.varP + "</option>";
                $("#listIndiVarP").append(conteLP);
            });
            $('#listIndiVarP').prop('selectedIndex', 0);
            llenarIndicadorMedicion($("#listIndiVarP").val(), indiId, unidad_medida);

            $.each(response.listT, function (indexT, valueT) {
                var conT = "<div class='form-group row'>\
                                <div class='" + valueT.intaPosicion + "'>\
                                    <div class='indicador_tablero'>\
                                        <img src='./Planeamiento?url=grafica&indi_id=" + indiId + "&graf_id=" + valueT.grafId + "&tiga_id=" + valueT.tigaId + "' class='img-responsive'>\
                                    </div>\
                                </div>\
                            </div>";
                $("#divOrdenTablero").append(conT);
            });

            $("#listIndiVarP").bind("change", function () {
                llenarIndicadorMedicion($("#listIndiVarP").val(), indiId, unidad_medida);
            });

        }
    });
}

function llenarIndicadorMedicion(valueP, indiId, unidad) {
    $("#spanMedicion").empty();
    $.ajax({
        dataType: 'json',
        url: "./Planeamiento?url=indicador_medicion&valueP=" + valueP + "&indi_id=" + indiId,
        success: function (response) {
            if (!$.trim(response.medicion)) {
                $("#spanMedicion").append("");
            } else {
                if (unidad === "Porcentaje") {
                    $("#spanMedicion").append(formatNumeroDecimal(response.medicion) + " %");
                } else if (unidad === "Número") {
                    $("#spanMedicion").append(formatNumeroEntero(response.medicion));
                } else {
                    $("#spanMedicion").append(formatNumeroDecimal(response.medicion));
                }
            }
            if ($("div.indicador_nombre").innerHeight() < $("div.indicador_medicion").innerHeight()) {
                $("div.indicador_nombre").css('height', $("div.indicador_medicion").innerHeight() + "px");
            }
            if ($("div.indicador_nombre").innerHeight() > $("div.indicador_medicion").innerHeight()) {
                $("div.indicador_medicion").css('height', $("div.indicador_nombre").innerHeight() + "px");
            }
        }
    });
}


function llenarContNVar(size, value) {
    var body = '<tr>';
    for (var k = 1; k <= size; k++) {
        if (k === 1) {
            if (!$.trim(value.var1)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var1 + '</td>';
            }
        }
        if (k === 2) {
            if (!$.trim(value.var2)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var2 + '</td>';
            }
        }
        if (k === 3) {
            if (!$.trim(value.var3)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var3 + '</td>';
            }
        }
        if (k === 4) {
            if (!$.trim(value.var4)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var4 + '</td>';
            }
        }
        if (k === 5) {
            if (!$.trim(value.var5)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var5 + '</td>';
            }
        }
        if (k === 6) {
            if (!$.trim(value.var6)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var6 + '</td>';
            }
        }
        if (k === 7) {
            if (!$.trim(value.var7)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var7 + '</td>';
            }
        }
        if (k === 8) {
            if (!$.trim(value.var8)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var8 + '</td>';
            }
        }
        if (k === 9) {
            if (!$.trim(value.var9)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var9 + '</td>';
            }
        }
        if (k === 10) {
            if (!$.trim(value.var10)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var10 + '</td>';
            }
        }
        if (k === 11) {
            if (!$.trim(value.var11)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var11 + '</td>';
            }
        }
        if (k === 12) {
            if (!$.trim(value.var12)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var12 + '</td>';
            }
        }
        if (k === 13) {
            if (!$.trim(value.var13)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var13 + '</td>';
            }
        }
        if (k === 14) {
            if (!$.trim(value.var14)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var14 + '</td>';
            }
        }
        if (k === 15) {
            if (!$.trim(value.var15)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var15 + '</td>';
            }
        }
        if (k === 16) {
            if (!$.trim(value.var16)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var16 + '</td>';
            }
        }
        if (k === 17) {
            if (!$.trim(value.var17)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var17 + '</td>';
            }
        }
        if (k === 18) {
            if (!$.trim(value.var18)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var18 + '</td>';
            }
        }
        if (k === 19) {
            if (!$.trim(value.var19)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var19 + '</td>';
            }
        }
        if (k === 20) {
            if (!$.trim(value.var20)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var20 + '</td>';
            }
        }
        if (k === 21) {
            if (!$.trim(value.var21)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var21 + '</td>';
            }
        }
        if (k === 22) {
            if (!$.trim(value.var22)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var22 + '</td>';
            }
        }
        if (k === 23) {
            if (!$.trim(value.var23)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var23 + '</td>';
            }
        }
        if (k === 24) {
            if (!$.trim(value.var24)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var24 + '</td>';
            }
        }
        if (k === 25) {
            if (!$.trim(value.var25)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var25 + '</td>';
            }
        }
        if (k === 26) {
            if (!$.trim(value.var26)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var26 + '</td>';
            }
        }
        if (k === 27) {
            if (!$.trim(value.var27)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var27 + '</td>';
            }
        }
        if (k === 28) {
            if (!$.trim(value.var28)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var28 + '</td>';
            }
        }
        if (k === 29) {
            if (!$.trim(value.var29)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var29 + '</td>';
            }
        }
        if (k === 30) {
            if (!$.trim(value.var30)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var30 + '</td>';
            }
        }
        if (k === 31) {
            if (!$.trim(value.var31)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var31 + '</td>';
            }
        }
        if (k === 32) {
            if (!$.trim(value.var32)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var32 + '</td>';
            }
        }
        if (k === 33) {
            if (!$.trim(value.var33)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var33 + '</td>';
            }
        }
        if (k === 34) {
            if (!$.trim(value.var34)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var34 + '</td>';
            }
        }
        if (k === 35) {
            if (!$.trim(value.var35)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var35 + '</td>';
            }
        }
        if (k === 36) {
            if (!$.trim(value.var36)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var36 + '</td>';
            }
        }
        if (k === 37) {
            if (!$.trim(value.var37)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var37 + '</td>';
            }
        }
        if (k === 38) {
            if (!$.trim(value.var38)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var38 + '</td>';
            }
        }
        if (k === 39) {
            if (!$.trim(value.var39)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var39 + '</td>';
            }
        }
        if (k === 40) {
            if (!$.trim(value.var40)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var40 + '</td>';
            }
        }
        if (k === 41) {
            if (!$.trim(value.var41)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var41 + '</td>';
            }
        }
        if (k === 42) {
            if (!$.trim(value.var42)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var42 + '</td>';
            }
        }
        if (k === 43) {
            if (!$.trim(value.var43)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var43 + '</td>';
            }
        }
        if (k === 44) {
            if (!$.trim(value.var44)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var44 + '</td>';
            }
        }
        if (k === 45) {
            if (!$.trim(value.var45)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var45 + '</td>';
            }
        }
        if (k === 46) {
            if (!$.trim(value.var46)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var46 + '</td>';
            }
        }
        if (k === 47) {
            if (!$.trim(value.var47)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var47 + '</td>';
            }
        }
        if (k === 48) {
            if (!$.trim(value.var48)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var48 + '</td>';
            }
        }
        if (k === 49) {
            if (!$.trim(value.var49)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var49 + '</td>';
            }
        }
        if (k === 50) {
            if (!$.trim(value.var50)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var50 + '</td>';
            }
        }
        if (k === 51) {
            if (!$.trim(value.var51)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var51 + '</td>';
            }
        }
        if (k === 52) {
            if (!$.trim(value.var52)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var52 + '</td>';
            }
        }
        if (k === 53) {
            if (!$.trim(value.var53)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var53 + '</td>';
            }
        }
        if (k === 54) {
            if (!$.trim(value.var54)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var54 + '</td>';
            }
        }
        if (k === 55) {
            if (!$.trim(value.var55)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var55 + '</td>';
            }
        }
        if (k === 56) {
            if (!$.trim(value.var56)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var56 + '</td>';
            }
        }
        if (k === 57) {
            if (!$.trim(value.var57)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var57 + '</td>';
            }
        }
        if (k === 58) {
            if (!$.trim(value.var58)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var58 + '</td>';
            }
        }
        if (k === 59) {
            if (!$.trim(value.var59)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var59 + '</td>';
            }
        }
        if (k === 60) {
            if (!$.trim(value.var60)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var60 + '</td>';
            }
        }
        if (k === 61) {
            if (!$.trim(value.var61)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var61 + '</td>';
            }
        }
        if (k === 62) {
            if (!$.trim(value.var62)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var62 + '</td>';
            }
        }
        if (k === 63) {
            if (!$.trim(value.var63)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var63 + '</td>';
            }
        }
        if (k === 64) {
            if (!$.trim(value.var64)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var64 + '</td>';
            }
        }
        if (k === 65) {
            if (!$.trim(value.var65)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var65 + '</td>';
            }
        }
        if (k === 66) {
            if (!$.trim(value.var66)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var66 + '</td>';
            }
        }
        if (k === 67) {
            if (!$.trim(value.var67)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var67 + '</td>';
            }
        }
        if (k === 68) {
            if (!$.trim(value.var68)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var68 + '</td>';
            }
        }
        if (k === 69) {
            if (!$.trim(value.var69)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var69 + '</td>';
            }
        }
        if (k === 70) {
            if (!$.trim(value.var70)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var70 + '</td>';
            }
        }
        if (k === 71) {
            if (!$.trim(value.var71)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var71 + '</td>';
            }
        }
        if (k === 72) {
            if (!$.trim(value.var72)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var72 + '</td>';
            }
        }
        if (k === 73) {
            if (!$.trim(value.var73)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var73 + '</td>';
            }
        }
        if (k === 74) {
            if (!$.trim(value.var74)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var74 + '</td>';
            }
        }
        if (k === 75) {
            if (!$.trim(value.var75)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var75 + '</td>';
            }
        }
        if (k === 76) {
            if (!$.trim(value.var76)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var76 + '</td>';
            }
        }
        if (k === 77) {
            if (!$.trim(value.var77)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var77 + '</td>';
            }
        }
        if (k === 78) {
            if (!$.trim(value.var78)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var78 + '</td>';
            }
        }
        if (k === 79) {
            if (!$.trim(value.var79)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var79 + '</td>';
            }
        }
        if (k === 80) {
            if (!$.trim(value.var80)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var80 + '</td>';
            }
        }
        if (k === 81) {
            if (!$.trim(value.var81)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var81 + '</td>';
            }
        }
        if (k === 82) {
            if (!$.trim(value.var82)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var82 + '</td>';
            }
        }
        if (k === 83) {
            if (!$.trim(value.var83)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var83 + '</td>';
            }
        }
        if (k === 84) {
            if (!$.trim(value.var84)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var84 + '</td>';
            }
        }
        if (k === 85) {
            if (!$.trim(value.var85)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var85 + '</td>';
            }
        }
        if (k === 86) {
            if (!$.trim(value.var86)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var86 + '</td>';
            }
        }
        if (k === 87) {
            if (!$.trim(value.var87)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var87 + '</td>';
            }
        }
        if (k === 88) {
            if (!$.trim(value.var88)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var88 + '</td>';
            }
        }
        if (k === 89) {
            if (!$.trim(value.var89)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var89 + '</td>';
            }
        }
        if (k === 90) {
            if (!$.trim(value.var90)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var90 + '</td>';
            }
        }
        if (k === 91) {
            if (!$.trim(value.var91)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var91 + '</td>';
            }
        }
        if (k === 92) {
            if (!$.trim(value.var92)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var92 + '</td>';
            }
        }
        if (k === 93) {
            if (!$.trim(value.var93)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var93 + '</td>';
            }
        }
        if (k === 94) {
            if (!$.trim(value.var94)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var94 + '</td>';
            }
        }
        if (k === 95) {
            if (!$.trim(value.var95)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var95 + '</td>';
            }
        }
        if (k === 96) {
            if (!$.trim(value.var96)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var96 + '</td>';
            }
        }
        if (k === 97) {
            if (!$.trim(value.var97)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var97 + '</td>';
            }
        }
        if (k === 98) {
            if (!$.trim(value.var98)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var98 + '</td>';
            }
        }
        if (k === 99) {
            if (!$.trim(value.var99)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var99 + '</td>';
            }
        }
        if (k === 100) {
            if (!$.trim(value.var100)) {
                body += '<td></td>';
            } else {
                body += '<td>' + value.var100 + '</td>';
            }
        }
    }
    body += '</tr>';
    return body;
}