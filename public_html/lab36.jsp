<%!
    public void jspInit(){
        ServletContext context = getServletContext();
        context.setAttribute("test1", "test2");
    }
%>

<%@include file="websitesInclude/head.jsp" %>
<body>
<%@include file="websitesInclude/nav.jsp" %>
<div id="content">
    <div id="posts">
        <h2>Lab 6 - Using the ServletContext </h2>
        <hr>
        <br>
        <h3>Context attribute value: </h3>
    <span style="font-size:300%;"><%= application.getAttribute("test1") %></span>
    <% response.sendRedirect("lab36b.jsp");%>
    </div>
</div>
<%@include file="websitesInclude/footer.jsp"%>
</body>
</html>
