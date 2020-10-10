<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="header_title" value="Lab 2 - JSTL" scope="page"/>

<%@include file="../websitesInclude/head.jsp" %>
<body>
<%@include file="../websitesInclude/nav.jsp" %>
<div id="content">
    <div id="posts">
        <h2> Project 4 - Search results</h2>
        <h3>${project4AddMessage}</h3>
        <table>
            <tr>
                <th>EmployeeID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>SSN</th>
                <th>Department</th>
                <th>Room</th>
                <th>Phone</th>
            </tr>
                <c:forEach items="${search.results}" var="employee">
                   <tr>
                       <td><c:out value="${employee.employeeID}"/></td>
                       <td><c:out value="${employee.firstName}"/></td>
                       <td><c:out value="${employee.lastName}"/></td>
                       <td><c:out value="${employee.ssn}"/></td>
                       <td><c:out value="${employee.department}"/></td>
                       <td><c:out value="${employee.room}"/></td>
                       <td><c:out value="${employee.phone}"/></td>
                   </tr>
                   </c:forEach>
        </table>

    </div>
</div>
<%@include file="../websitesInclude/footer.jsp" %>
</body>
</html>
