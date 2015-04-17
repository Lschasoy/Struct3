
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>¿Quien es último campeón del Mundo?</h3>
        <html:form action="/Mundial">
        <table border="1">
            <tr>
                <th>Pais</th>
            <td>
                <html:select property="pais"> 
                    <html:options collection="tablapaises" property="key" labelProperty="value"/>
                </html:select> 
            </td>
            </tr> 
            <tr>
                <th>Observaciones</th>
                <td> 
                    <html:textarea property="observaciones" cols="50" rows="3" />
                </td>
            </tr> 
            <tr>
                <td>
                    <html:submit value="Enviar"/>
                </td> 
            </tr>
        </table>
        </html:form>  
    </body>
</html>
