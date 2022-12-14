<%-- 
    Document   : SaveIntelligentZone
    Created on : 10/05/2014, 09:43:37 AM
    Author     : Duvan
--%>

<%@page import="DataBase.Connector"%>
<%@page import="Entities.IntelligentZone"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
    <head>
        <%!
            IntelligentZone newIntelligentZone;
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%
            newIntelligentZone=new IntelligentZone(0,request.getParameter("classifier"),
                    request.getParameter("description"),request.getParameter("elevation"),
                    request.getParameter("featureCode"),request.getParameter("geoclass"),
                    request.getParameter("identifier"),request.getParameter("keyword"),
                    request.getParameter("latitude"),request.getParameter("longitude"),
                    request.getParameter("locationName"),request.getParameter("registrantCity"),
                    request.getParameter("registrantCountry"),request.getParameter("registrantName"),
                    request.getParameter("registrantOrganization"),request.getParameter("registrantPhone"),
                    request.getParameter("registrantStreet"),request.getParameter("webDomain"));
            Connector con =new Connector();
            con.saveIntelligentZone(newIntelligentZone);
            con.close();
            response.sendRedirect("./index.xhtml");
        %>        
    </body>
</html>
