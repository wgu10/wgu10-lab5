<%-- 
    Document   : custConf
    Author     : ganGuwen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success</title>
    </head>
    <body>
        <h1>Created Customer</h1>
        <ul>
            <li>${requestScope.cust.id}</li>
            <li>${requestScope.cust.email}</li>
            <li>${requestScope.cust.firstName}</li>
            <li>${requestScope.cust.lastName}</li>
        </ul>
    </body>
</html>
