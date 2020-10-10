<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%--<c:set var="header_title" value="Lab 2 - JSTL" scope="page"/>--%>

<%@include file="websitesInclude/head.jsp" %>
<body>
<%@include file="websitesInclude/nav.jsp" %>
<div id="content">
    <div id="posts">
        <h2> Project 4 - Analyzer</h2>
        <form action="${pageContext.request.contextPath}/AnalyzerReadFileServlet"
              method="POST"
              enctype="multipart/form-data">
            <label for="file">File: </label>
            <input type="file" id="file" required name="file"> <br>
            <input type="submit" value="Analyze">
        </form>
    </div>
</div>
<%@include file="websitesInclude/footer.jsp"%>
</body>
</html>
