<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%--<c:set var="header_title" value="Lab 2 - JSTL" scope="page"/>--%>

<%@include file="../websitesInclude/head.jsp" %>
<body>
<%@include file="../websitesInclude/nav.jsp" %>
<div id="content">
    <div id="posts">
        <h2> Project 4 - Search Page</h2>
        <form action="${pageContext.request.contextPath}/employeeSearchServlet"
              method="get">
            <label for="searchTerm">Search Term: </label>
            <input type="text" id="searchTerm" name="searchTerm"> <br>
            <p>Search Term: </p>
            <input type="radio" id="employeeID" name="searchType" value="emp_id">
            <label for="employeeID">Employee ID</label><br>
            <input type="radio" id="firstName" name="searchType" value="first_name">
            <label for="firstName">First Name</label><br>
            <input type="radio" id="ssn" name="searchType" value="ssn">
            <label for="ssn">Social Security Number</label> <br>
            <input type="radio" id="dept" name="searchType" value="dept">
            <label for="dept">Department</label> <br>
            <input type="radio" id="room" name="searchType" value="room">
            <label for="room">Room</label> <br>
            <input type="radio" id="phone" name="searchType" value="phone">
            <label for="phone">Phone</label> <br>
            <input type="submit" value="Search">
        </form>

    </div>
</div>
<c:remove var = "project4AddMessage"/>
<%@include file="../websitesInclude/footer.jsp" %>
</body>
</html>
