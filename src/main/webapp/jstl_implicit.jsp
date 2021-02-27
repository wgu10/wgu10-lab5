<%-- 
    Document   : jstlpreview
    Author     : ganGuwen
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>ServletContext (pageContext.servletContext)</h1>
        <table border=1>
            <tr>
                <th>Name</th>
                <th>Value</th>
            </tr>
            <tr>
               
                <td><c:out value="Context Path" /></td>
                <td><c:out value="${pageContext.servletContext.contextPath}" /></td>
            </tr>
            <tr>
                <td><c:out value="Effective Major Version" /></td>
                <td><c:out value="${pageContext.servletContext.effectiveMajorVersion}" /></td>
            </tr>
            <tr>
                <td><c:out value="Effective Minor Version" /></td>
                <td><c:out value="${pageContext.servletContext.effectiveMinorVersion}" /></td>
            </tr>
            <tr>
                <td><c:out value="Major Version" /></td>
                <td><c:out value="${pageContext.servletContext.majorVersion}" /></td>
            </tr>
            <tr>
                <td><c:out value="Minor Version" /></td>
                <td><c:out value="${pageContext.servletContext.minorVersion}" /></td>
            </tr>
            <tr>
                <td><c:out value="Server Info" /></td>
                <td><c:out value="${pageContext.servletContext.serverInfo}" /></td>
            </tr>
            <tr>
                <td><c:out value="Servlet Context Name" /></td>
                <td><c:out value="${pageContext.servletContext.servletContextName}" /></td>
            </tr>
            <tr>
                <td><c:out value="Virtual Server Name" /></td>
                <td><c:out value="${pageContext.servletContext.virtualServerName}" /></td>
            </tr>
        </table>        
        
        <h1>ServletRequest (pageContext.request)</h1>
        <table border=1>
            <tr>
                <th>Name</th>
                <th>Value</th>
            </tr>
            <tr>
                <td><c:out value="Character Encoding" /></td>
                <td><c:out value="${pageContext.request.characterEncoding}" /></td>
            </tr>
            <tr>
                <td><c:out value="Content Length" /></td>
                <td><c:out value="${pageContext.request.contentLength}" /></td>
            </tr>
            <tr>
                <td><c:out value="Content Type" /></td>
                <td><c:out value="${pageContext.request.contentType}" /></td>
            </tr>
            <tr>
                <td><c:out value="Local Address" /></td>
                <td><c:out value="${pageContext.request.localAddr}" /></td>
            </tr>
            <tr>
                <td><c:out value="Local Name" /></td>
                <td><c:out value="${pageContext.request.localName}" /></td>
            </tr>
            <tr>
                <td><c:out value="Local Port" /></td>
                <td><c:out value="${pageContext.request.localPort}" /></td>
            </tr>
            <tr>
                <td><c:out value="Locale" /></td>
                <td><c:out value="${pageContext.request.locale}" /></td>
            </tr>
            <tr>
                <td><c:out value="Protocol" /></td>
                <td><c:out value="${pageContext.request.protocol}" /></td>
            </tr>
            <tr>
                <td><c:out value="Remote Address" /></td>
                <td><c:out value="${pageContext.request.remoteAddr}" /></td>
            </tr>
            <tr>
                <td><c:out value="Remote Host" /></td>
                <td><c:out value="${pageContext.request.remoteHost}" /></td>
            </tr>
            <tr>
                <td><c:out value="Remote Port" /></td>
                <td><c:out value="${pageContext.request.remotePort}" /></td>
            </tr>
            <tr>
                <td><c:out value="Scheme" /></td>
                <td><c:out value="${pageContext.request.scheme}" /></td>
            </tr>
            <tr>
                <td><c:out value="Secure" /></td>
                <td><c:out value="${pageContext.request.secure}" /></td>
            </tr>
            <tr>
                <td><c:out value="Server Name" /></td>
                <td><c:out value="${pageContext.request.serverName}" /></td>
            </tr>
            <tr>
                <td><c:out value="Server Port" /></td>
                <td><c:out value="${pageContext.request.serverPort}" /></td>
            </tr>
        </table>

        <h1>HttpServletRequest (pageContext.request)</h1>
        <table border=1>
            <tr>
                <th>Name</th>
                <th>Value</th>
            </tr>
            <tr>
                <td><c:out value="Auth Type" /></td>
                <td><c:out value="${pageContext.request.authType}" /></td>
            </tr>
            <tr>
                <td><c:out value="Context Path" /></td>
                <td><c:out value="${pageContext.request.contextPath}" /></td>
            </tr>
            <tr>
                <td><c:out value="Method" /></td>
                <td><c:out value="${pageContext.request.method}" /></td>
            </tr>
            <tr>
                <td><c:out value="Path Info" /></td>
                <td><c:out value="${pageContext.request.pathInfo}" /></td>
            </tr>
            <tr>
                <td><c:out value="Path Translated" /></td>
                <td><c:out value="${pageContext.request.pathTranslated}" /></td>
            </tr>
            <tr>
                <td><c:out value="Query String" /></td>
                <td><c:out value="${pageContext.request.queryString}" /></td>
            </tr>
            <tr>
                <td><c:out value="Remote User" /></td>
                <td><c:out value="${pageContext.request.remoteUser}" /></td>
            </tr>
            <tr>
                <td><c:out value="Requested Session Id" /></td>
                <td><c:out value="${pageContext.request.requestedSessionId}" /></td>
            </tr>
            <tr>
                <td><c:out value="Request URI" /></td>
                <td><c:out value="${pageContext.request.requestURI}" /></td>
            </tr>
            <tr>
                <td><c:out value="Request URL" /></td>
                <td><c:out value="${pageContext.request.requestURL}" /></td>
            </tr>
            <tr>
                <td><c:out value="Servlet Path" /></td>
                <td><c:out value="${pageContext.request.servletPath}" /></td>
            </tr>
            <tr>
                <td><c:out value="Session ID from Cookie" /></td>
                <td><c:out value="${pageContext.request.requestedSessionIdFromCookie}" /></td>
            </tr>
            <tr>
                <td><c:out value="Session ID from URL" /></td>
                <td><c:out value="${pageContext.request.requestedSessionIdFromURL}" /></td>
            </tr>
        </table>

        <h1>ServletResponse (pageContext.response)</h1>
        <table border=1>
            <tr>
                <th>Name</th>
                <th>Value</th>
            </tr>
            <tr>
                <td><c:out value="Character Encoding" /></td>
                <td><c:out value="${pageContext.response.characterEncoding}" /></td>
            </tr>
            <tr>
                <td><c:out value="Content Type" /></td>
                <td><c:out value="${pageContext.response.contentType}" /></td>
            </tr>
            <tr>
                <td><c:out value="Locale" /></td>
                <td><c:out value="${pageContext.response.locale}" /></td>
            </tr>
            <tr>
                <td><c:out value="Committed" /></td>
                <td><c:out value="${pageContext.response.committed}" /></td>
            </tr>
        </table>

        <h1>HttpServletResponse (pageContext.response)</h1>
        <table border=1>
            <tr>
                <th>Name</th>
                <th>Value</th>
            </tr>
            <tr>
                <td><c:out value="Status" /></td>
                <td><c:out value="${pageContext.response.status}" /></td>
            </tr>
        </table>

        <c:if test="${not empty header}">
            <h1>HTTP Headers</h1>
            <table border=1>
                <tr>
                    <th>Name</th>
                    <th>Value</th>
                </tr>
                <c:forEach var="nextHeader" items="${header}">
                    <tr>
                        <td><c:out value="${nextHeader.key}" /></td>
                        <td><c:out value="${nextHeader.value}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${not empty cookie}">
            <h1>Cookies</h1>
            <table border=1>
                <tr>
                    <th>Name</th>
                    <th>Value</th>
                </tr>
                <c:forEach var="nextCookie" items="${cookie}">
                    <tr>
                        <td><c:out value="${nextCookie.key}" /></td>
                        <td><c:out value="${nextCookie.value.value}" /></td>
                    </tr>
                </c:forEach>
            </table>        
        </c:if>
        <c:if test="${not empty initParam}">
            <h1>Initialization Parameters</h1>
            <table border=1>
                <tr>
                    <th>Name</th>
                    <th>Value</th>
                </tr>
                <c:forEach var="nextParam" items="${initParam}">
                    <tr>
                        <td><c:out value="${nextParam.key}" /></td>
                        <td><c:out value="${nextParam.value}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${not empty param}">
            <h1>Request Parameters</h1>
            <table border=1>
                <tr>
                    <th>Name</th>
                    <th>Value</th>
                </tr>
                <c:forEach var="nextParam" items="${param}">
                    <tr>
                        <td><c:out value="${nextParam.key}" /></td>
                        <td><c:out value="${nextParam.value}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${not empty pageScope}">
            <h1>Page Scope Attributes</h1>
            <table border=1>
                <tr>
                    <th>Name</th>
                    <th>Value</th>
                </tr>
                <c:forEach var="nextAttr" items="${pageScope}">
                    <tr>
                        <td><c:out value="${nextAttr.key}" /></td>
                        <td><c:out value="${nextAttr.value}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${not empty requestScope}">
            <h1>Request Scope Attributes</h1>
            <table border=1>
                <tr>
                    <th>Name</th>
                    <th>Value</th>
                </tr>
                <c:forEach var="nextAttr" items="${requestScope}">
                    <tr>
                        <td><c:out value="${nextAttr.key}" /></td>
                        <td><c:out value="${nextAttr.value}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${not empty sessionScope}">
            <h1>Session Scope Attributes</h1>
            <table border=1>
                <tr>
                    <th>Name</th>
                    <th>Value</th>
                </tr>
                <c:forEach var="nextAttr" items="${sessionScope}">
                    <tr>
                        <td><c:out value="${nextAttr.key}" /></td>
                        <td><c:out value="${nextAttr.value}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${not empty applicationScope}">
            <h1>Application Scope Attributes</h1>
            <table border=1>
                <tr>
                    <th>Name</th>
                    <th>Value</th>
                </tr>
                <c:forEach var="nextAttr" items="${applicationScope}">
                    <tr>
                        <td><c:out value="${nextAttr.key}" /></td>
                        <td><c:out value="${nextAttr.value}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

    </body>
</html>
