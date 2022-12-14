<%-- 
    Document   : SaveVirtualSensor
    Created on : 10/05/2014, 09:43:37 AM
    Author     : Duvan
--%>


<%@page import="DataBase.Connector"%>
<%@page import="Entities.VirtualSensor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
    <head>
        <%!
            VirtualSensor newVirtualSensor;
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%
            newVirtualSensor=new VirtualSensor(0,request.getParameter("description"),
                    request.getParameter("identifier"),request.getParameter("keyword"),
                    Integer.parseInt(request.getParameter("state")),request.getParameter("events"),
                    request.getParameter("characteristics"),request.getParameter("classifier"),
                    request.getParameter("measure"),request.getParameter("observedProperty"),
                    null,Integer.parseInt(request.getParameter("value")),
                    Integer.parseInt(request.getParameter("pdf")),Integer.parseInt(request.getParameter("minValue")),
                    Integer.parseInt(request.getParameter("maxValue")),Integer.parseInt(request.getParameter("virtualThing")));
            Connector con =new Connector();
            con.saveVirtualSensor(newVirtualSensor);
            con.close();
            response.sendRedirect("./index.xhtml");
        %>        
    </body>
</html>
