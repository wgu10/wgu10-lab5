<%-- 
    Document   : cust
    Author     : ganGuwen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>JSP Page</title>
    </head>

    <body>
        <h1>Create a Customer</h1>

        <c:if test="${not empty requestScope.problems}">
            <p>We have found one or more problems with your work, please correct and re-submit.</p>

            <ol>
                <c:forEach var="problem" items="${requestScope.problems}">
                    <li>Problem with ${problem.propertyPath}: ${problem.message}</li>
                </c:forEach>
            </ol>
        </c:if>

        <form action="/wgu10-lab5/cust" method="post">
            <ul>
                <li>
                    <label for="custId">ID</label>
                    <input value="${requestScope.cust.id}" type="text" id="custId" name="custId">
                </li>
                <li>
                    <label for="custEmail">E-mail:</label>
                    <input value="${requestScope.cust.email}" type="email" id="custEmail" name="custEmail">
                </li>

                <li>
                    <label for="custFirstName">First Name</label>
                    <input value="${requestScope.cust.firstName}" type="text" id="custFirstName" name="custFirstName">
                </li>

                <li>
                    <label for="custLastName">Last Name</label>
                    <input value="${requestScope.cust.lastName}" type="text" id="custLastName" name="custLastName">
                </li>

                <li>
                    <label for="comments">Comments:</label>
                    <textarea id="comments" name="comments"></textarea>
                </li>
            </ul>

            <button type="submit">Submit</button>

        </form>        


    </body>
</html>
