<%-- 
    Document   : SaveVirtualThing
--%>

<%@page import="java.util.Date"%>
<%@page import="DataBase.Connector"%>
<%@page import="Entities.VirtualThing"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
    <head>
        <%!
            VirtualThing newVirtualThing;
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%
            newVirtualThing=new VirtualThing(0,request.getParameter("description"),
                    request.getParameter("identifier"),request.getParameter("keyword"),
                    request.getParameter("name"),request.getParameter("category"),
                    request.getParameter("alternateName"),request.getParameter("image"),
                    request.getParameter("potentialAction"),Integer.parseInt(request.getParameter("state")),
                    request.getParameter("events"),request.getParameter("characteristics"),                   
                    Integer.parseInt(request.getParameter("SubSmartSpace")));
            Connector con =new Connector();
            con.saveVirtualThing(newVirtualThing);
            con.close();
            response.sendRedirect("./index.xhtml");
        %>        
    </body>
</html>
