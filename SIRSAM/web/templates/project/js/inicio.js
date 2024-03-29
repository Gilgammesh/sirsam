// Llenar el Menu Inicio

function llenar_inicio_alert() {
    alert("funciona llenar Menu Inicio");
}

function llenar_menu_inicio() {

    $("#divContenidoMenu").empty();
    var cont_ini = '<section id="rt-showcase-surround" class="background_sirsam_">\
                        <div id="rt-showcase" class="slider-container">\
                            <div class="rt-container slider-container">\
                                <div id="titulo_inicio" class="rt-grid-12 rt-alpha rt-omega">\
                                    <label>INDICADORES PRIORIZADOS DE LA REGION SAN MARTIN</label>\
                                </div>\
                                <div class="rt-grid-12 rt-alpha rt-omega">\
                                    <div class="csslider1 autoplay">\
                                        <input name="cs_anchor1" id="cs_slide1_0" type="radio" class="cs_anchor slide">\
                                        <input name="cs_anchor1" id="cs_slide1_1" type="radio" class="cs_anchor slide">\
                                        <input name="cs_anchor1" id="cs_slide1_2" type="radio" class="cs_anchor slide">\
                                        <input name="cs_anchor1" id="cs_slide1_3" type="radio" class="cs_anchor slide">\
                                        <input name="cs_anchor1" id="cs_slide1_4" type="radio" class="cs_anchor slide">\
                                        <input name="cs_anchor1" id="cs_slide1_5" type="radio" class="cs_anchor slide">\
                                        <input name="cs_anchor1" id="cs_play1" type="radio" class="cs_anchor" checked="">\
                                        <input name="cs_anchor1" id="cs_pause1_0" type="radio" class="cs_anchor pause">\
                                        <input name="cs_anchor1" id="cs_pause1_1" type="radio" class="cs_anchor pause">\
                                        <input name="cs_anchor1" id="cs_pause1_2" type="radio" class="cs_anchor pause">\
                                        <input name="cs_anchor1" id="cs_pause1_3" type="radio" class="cs_anchor pause">\
                                        <input name="cs_anchor1" id="cs_pause1_4" type="radio" class="cs_anchor pause">\
                                        <input name="cs_anchor1" id="cs_pause1_5" type="radio" class="cs_anchor pause">\
                                        <ul>\
                                            <div style="width: 100%; visibility: hidden; font-size: 0px; line-height: 0;">\
                                                <img src="./resources/images/componente1_ind.jpg" style="width: 100%;">\
                                            </div>\
                                            <li class="num0 img">\
                                                <img src="./resources/images/componente1_ind.jpg">\
                                            </li>\
                                            <li class="num1 img">\
                                                <img src="./resources/images/componente2_ind.jpg">\
                                            </li>\
                                            <li class="num2 img">\
                                                <img src="./resources/images/componente3_ind.jpg">\
                                            </li>\
                                            <li class="num3 img">\
                                                <img src="./resources/images/componente4_ind.jpg">\
                                            </li>\
                                            <li class="num4 img">\
                                                <img src="./resources/images/componente5_ind.jpg">\
                                            </li>\
                                            <li class="num5 img">\
                                                <img src="./resources/images/componente6_ind.jpg">\
                                            </li>\
                                        </ul>\
                                        <div class="cs_description">\
                                            <label class="num0">\
                                                <span class="cs_title"><span class="cs_wrapper">Componente 1</span></span>\
                                                <br><span class="cs_descr"><span class="cs_wrapper">Derechos humanos e inclusión social</span></span>\
                                            </label>\
                                            <label class="num1">\
                                                <span class="cs_title"><span class="cs_wrapper">Componente 2</span></span>\
                                                <br><span class="cs_descr"><span class="cs_wrapper">Oportunidades y acceso a los servicios</span></span>\
                                            </label>\
                                            <label class="num2">\
                                                <span class="cs_title"><span class="cs_wrapper">Componente 3</span></span>\
                                                <br><span class="cs_descr"><span class="cs_wrapper">Estado y gobernabilidad</span></span>\
                                            </label>\
                                            <label class="num3">\
                                                <span class="cs_title"><span class="cs_wrapper">Componente 4</span></span>\
                                                <br><span class="cs_descr"><span class="cs_wrapper">Economía diversificada, competitividad y empleo</span></span>\
                                            </label>\
                                            <label class="num4">\
                                                <span class="cs_title"><span class="cs_wrapper">Componente 5</span></span>\
                                                <br><span class="cs_descr"><span class="cs_wrapper">Desarrollo territorial e infraestructura productiva</span></span>\
                                            </label>\
                                            <label class="num5">\
                                                <span class="cs_title"><span class="cs_wrapper">Componente 6</span></span>\
                                                <br><span class="cs_descr"><span class="cs_wrapper">Ambiente, diversidad biológica y gestión del riesgo de desastres</span></span>\
                                            </label>\
                                        </div>\
                                        <div class="cs_play_pause">\
                                            <label class="cs_play" for="cs_play1">PLAY&nbsp;</label>\
                                            <label class="cs_pause num0" for="cs_pause1_0">PAUSA&nbsp;</label>\
                                            <label class="cs_pause num1" for="cs_pause1_1">PAUSA&nbsp;</label>\
                                            <label class="cs_pause num2" for="cs_pause1_2">PAUSA&nbsp;</label>\
                                            <label class="cs_pause num3" for="cs_pause1_3">PAUSA&nbsp;</label>\
                                            <label class="cs_pause num4" for="cs_pause1_4">PAUSA&nbsp;</label>\
                                            <label class="cs_pause num5" for="cs_pause1_5">PAUSA&nbsp;</label>\
                                        </div>\
                                        <div class="cs_arrowprev">\
                                            <label class="num0" for="cs_slide1_0"></label>\
                                            <label class="num1" for="cs_slide1_1"></label>\
                                            <label class="num2" for="cs_slide1_2"></label>\
                                            <label class="num3" for="cs_slide1_3"></label>\
                                            <label class="num4" for="cs_slide1_4"></label>\
                                            <label class="num5" for="cs_slide1_5"></label>\
                                        </div>\
                                        <div class="cs_arrownext">\
                                            <label class="num0" for="cs_slide1_0"></label>\
                                            <label class="num1" for="cs_slide1_1"></label>\
                                            <label class="num2" for="cs_slide1_2"></label>\
                                            <label class="num3" for="cs_slide1_3"></label>\
                                            <label class="num4" for="cs_slide1_4"></label>\
                                            <label class="num5" for="cs_slide1_5"></label>\
                                        </div>\
                                        <div class="cs_bullets">\
                                            <label class="num0" for="cs_slide1_0">\
                                                <span class="cs_point"></span>\
                                                <span class="cs_thumb"><img src="./resources/images/componente1_ind_jumbo.jpg" title="Componente 1"></span>\
                                            </label>\
                                            <label class="num1" for="cs_slide1_1">\
                                                <span class="cs_point"></span>\
                                                <span class="cs_thumb"><img src="./resources/images/componente2_ind_jumbo.jpg" title="Componente 2"></span>\
                                            </label>\
                                            <label class="num2" for="cs_slide1_2">\
                                                <span class="cs_point"></span>\
                                                <span class="cs_thumb"><img src="./resources/images/componente3_ind_jumbo.jpg" title="Componente 3"></span>\
                                            </label>\
                                            <label class="num3" for="cs_slide1_3">\
                                                <span class="cs_point"></span>\
                                                <span class="cs_thumb"><img src="./resources/images/componente4_ind_jumbo.jpg" title="Componente 4"></span>\
                                            </label>\
                                            <label class="num4" for="cs_slide1_4">\
                                                <span class="cs_point"></span>\
                                                <span class="cs_thumb"><img src="./resources/images/componente5_ind_jumbo.jpg" title="Componente 5"></span>\
                                            </label>\
                                            <label class="num5" for="cs_slide1_5">\
                                                <span class="cs_point"></span>\
                                                <span class="cs_thumb"><img src="./resources/images/componente6_ind_jumbo.jpg" title="Componente 6"></span>\
                                            </label>\
                                        </div>\
                                    </div>\
                                </div>\
                                <div class="clear"></div>\
                            </div>\
                        </div>\
                    </section>';
    $("#divContenidoMenu").append(cont_ini);

}

