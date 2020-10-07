<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%--<c:set var="header_title" value="Lab 2 - JSTL" scope="page"/>--%>

<%@include file="../websitesInclude/head.jsp" %>
<body>
<%@include file="../websitesInclude/nav.jsp" %>
<div id="content">
    <div id="posts">
        <h2> Lab 3 - Forms</h2>
        <form action="${pageContext.request.contextPath}/addPageDisplayServlet"
              method="get">
            <label for="searchTerm">Search Term: </label>
            <input type="text" id="searchTerm" name="searchTerm"> <br>

            <p>Search Term: </p>
            <input type="radio" id="employeeID" name="employeeID" value="employeeID">
            <label for="employeeID">Employee ID</label><br>
            <input type="radio" id="firstName" name="firstName" value="firstName">
            <label for="firstName">First Name</label><br>
            <input type="radio" id="lastName" name="lastName" value="lastName">
            <label for="lastName">Other</label> <br>
            <input type="submit" value="Search">
        </form>

    </div>
</div>
<%@include file="../websitesInclude/footer.jsp" %>
</body>
</html>
