<%-- 
    Document   : SaveSmartSpace
--%>

<%@page import="DataBase.Connector"%>
<%@page import="Entities.SmartSpace"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%!
            SmartSpace newSmartSpace;
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <% 
            Connector con=new Connector();
            newSmartSpace = new SmartSpace(0, request.getParameter("Classifier"),
                    request.getParameter("Description"), request.getParameter("Elevation"),
                    request.getParameter("FeatureCode"), request.getParameter("GeoClass"),
                    request.getParameter("Identifier"), request.getParameter("Keyword"),
                    request.getParameter("Latitude"), request.getParameter("Longitude"),
                    request.getParameter("LocationName"), request.getParameter("Address"),Integer.parseInt(request.getParameter("IntelligentZone")));
            con.saveSmartSpace(newSmartSpace);
            con.close();
            response.sendRedirect("./index.xhtml");
        %>
    </body>
</html>
