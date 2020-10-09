<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%--<c:set var="header_title" value="Lab 2 - JSTL" scope="page"/>--%>

<%@include file="../websitesInclude/head.jsp" %>
<body>
<%@include file="../websitesInclude/nav.jsp" %>
<div id="content">
    <div id="posts">
        <h2> Lab 3 - Forms</h2>
        <h3>${project4AddMessage}</h3>

        <form action="${pageContext.request.contextPath}/addEmployeeServlet"
              method="post">
            <label for="employeeID">Employee ID: </label>
            <input type="text" id="employeeID" name="employeeID"> <br>

            <label for="firstName">First Name: </label>
            <input type="text" id="firstName" required name="firstName"> <br>

            <label for="lastName">Last Name: </label>
            <input type="text" id="lastName" required name="lastName"> <br>

            <label for="ssn">Social Security Number: </label>
            <input type="text" id="ssn" required name="ssn"> <br>

            <label for="dept">Department:</label>
            <select name="dept" id="dept">
                <option value="IT">IT</option>
                <option value="Admin">Admin</option>
                <option value="Eng">English</option>
                <option value="HR">Human Resourses</option>
            </select> <br>
            <label for="room">Room: </label>
            <input type="text" id="room" required name="room"> <br>

            <label for="phone">Phone Number: </label>
            <input type="text" id="phone" required name="phone"> <br>

            <input type="submit" value="Record Employee">
        </form>
    </div>
</div>

<% session.removeAttribute("project4AddMessage");%>
<%@include file="../websitesInclude/footer.jsp" %>
</body>
</html>
