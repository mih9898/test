<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="header_title" value="Lab 2 - JSTL" scope="page"/>

<%@include file="websitesInclude/head.jsp" %>
<body>
<%@include file="websitesInclude/nav.jsp" %>
<div id="content">
    <div id="posts">
        <h2> ${header_title}</h2>
        <table>
            <tr><th>Name</th></tr>
            <c:forEach var="name" items="${names}">
                <tr><td>${name}</td></tr>
            </c:forEach>
        </table>
    </div>
</div>
<%@include file="websitesInclude/footer.jsp"%>
</body>
</html>
