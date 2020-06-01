// Llenar el Menu Normatividad Institucional

function llenar_normas_alert() {
    alert("funciona llenar Menu Normatividad Institucional");
}

function llenar_menu_normas() {

    $("#divContenidoMenu").empty();
    var cont_nor = '<section id="section_normas" class="background_sirsam_">\
                        <img class="mantenimiento" src="./resources/images/construccion.jpg">\
                    </section>';
    $("#divContenidoMenu").append(cont_nor);


}

