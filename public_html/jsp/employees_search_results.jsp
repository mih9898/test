<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%--<c:set var="header_title" value="Lab 2 - JSTL" scope="page"/>--%>

<%@include file="../websitesInclude/head.jsp" %>
<body>
<%@include file="../websitesInclude/nav.jsp" %>
<div id="content">
    <div id="posts">
        <h2>Project 3 - Properties data </h2>
        <h3>Output: </h3>
        <table>
            <tr>
                <th>Employee ID</th><td>${search.results["employeeID"]}</td>
            </tr>
            <tr>
                <th>First Name</th><td>${search.results["employeeID"]}</td>
            </tr>
            <tr>
                <th>Last Name</th><td>${search.results["employeeID"]}</td>
            </tr>
            <tr>
                <th>Social Security Number</th><td>${search.results["employeeID"]}</td>
            </tr>
            <tr>
                <th>Department</th><td>${search.results["employeeID"]}</td>
            </tr>
            <tr>
                <th>Room</th><td>${search.results["employeeID"]}</td>
            </tr>
            <tr>
                <th>Phone</th><td>${search.results["employeeID"]}</td>
            </tr>
        </table>

    </div>
</div>
<%@include file="../websitesInclude/footer.jsp" %>
</body>
</html>
