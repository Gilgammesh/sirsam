<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%--
 @author CARLOS SANTANDER
--%>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" href="./resources/icons/logo.ico" type="image/x-icon" />
        <link rel="shortcut icon" href="./resources/icons/logo.ico" type="image/x-icon" />        
        <title>Sistema Integrado Regional San Martín</title>  
    </head>

    <body>

        <%@include file="./WEB-INF/cabecera/cabecera_css.jspf" %> 
        <%@include file="./WEB-INF/cabecera/cabecera_js.jspf" %>        
        <%@include file="./WEB-INF/cabecera/cabecera.jspf" %>        
        <%-- INICIO --%>   
        <%@include file="./WEB-INF/inicio/inicio_css.jspf" %> 
        <%@include file="./WEB-INF/inicio/inicio_js.jspf" %>
        <%-- TABLERO DE CONTROL --%>
        <%@include file="./WEB-INF/estadistica/estadistica_css.jspf" %> 
        <%@include file="./WEB-INF/estadistica/estadistica_js.jspf" %>
        <%-- PLANEAMIENTO ESTRATEGICO --%>
        <%@include file="./WEB-INF/planes/planes_css.jspf" %> 
        <%@include file="./WEB-INF/planes/planes_js.jspf" %> 
        <%-- EJECUCION PRESUPUESTAL --%>
        <%@include file="./WEB-INF/ejecucion/ejecucion_css.jspf" %> 
        <%@include file="./WEB-INF/ejecucion/ejecucion_js.jspf" %> 
        <%-- INVERSION PÚBLICA --%>
        <%@include file="./WEB-INF/proyectos/proyectos_css.jspf" %> 
        <%@include file="./WEB-INF/proyectos/proyectos_js.jspf" %> 
        <%-- NORMATIVIDAD --%>
        <%@include file="./WEB-INF/normas/normas_css.jspf" %> 
        <%@include file="./WEB-INF/normas/normas_js.jspf" %> 
        <%-- ADMINISTRADOR --%>
        <%@include file="./WEB-INF/admin/admin_css.jspf" %> 
        <%@include file="./WEB-INF/admin/admin_js.jspf" %> 
        <%-------------------%>

        <div id="divContenidoMenu">
            <%-- Aca se llena el contenido de los Menús --%>            
        </div>        

    </body>

</html>
