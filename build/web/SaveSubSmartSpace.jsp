<%-- 
    Document   : SaveSmartSpace
    Created on : 10/05/2014, 10:39:40 AM
    Author     : Duvan
--%>

<%@page import="DataBase.Connector"%>
<%@page import="Entities.SubSmartSpace"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%!
            SubSmartSpace newSubSmartSpace;
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <% 
            Connector con=new Connector();
            newSubSmartSpace = new SubSmartSpace(0, request.getParameter("classifier"),
                    request.getParameter("description"),request.getParameter("featureCode"),
                    request.getParameter("identifier"), request.getParameter("keyword"),
                    request.getParameter("locationName"),
                    Integer.parseInt(request.getParameter("maxHost")),
                    Integer.parseInt(request.getParameter("SmartSpace")));
            con.saveSubSmartSpace(newSubSmartSpace);
            con.close();
            response.sendRedirect("./index.xhtml");
        %>
    </body>
</html>
