<%@ page import="java.io.PrintWriter" %>
<%@include file="websitesInclude/head.jsp" %>
<body>
<%@include file="websitesInclude/nav.jsp" %>
<div id="content">
    <div id="posts">
        <h2>Lab 6 - Using the ServletContext </h2>
        <hr>
        <br>
        <h3>See left top side of DOM to see the output</h3>
        <%
            PrintWriter pw = response.getWriter();
            ServletContext context = request.getServletContext();
            pw.print("Context value - " + context.getAttribute("test1"));
        %>
    </div>
</div>
<%@include file="websitesInclude/footer.jsp"%>
</body>
</html>
