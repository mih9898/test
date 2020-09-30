<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="header_title" value="Lab 2 - JSTL" scope="page"/>

<%@include file="websitesInclude/head.jsp" %>
<body>
<%@include file="websitesInclude/nav.jsp" %>
<div id="content">
    <div id="posts">
        <h2> Tokens</h2>
        <p>${tokens}</p>

    </div>
</div>
<%@include file="websitesInclude/footer.jsp"%>
</body>
</html>
