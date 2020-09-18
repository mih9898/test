
<%@include file="websitesInclude/head.jsp" %>
<body>
<%@include file="websitesInclude/nav.jsp" %>
<div id="content">
    <div id="posts">
        <div class="post">
            <h2>Unit 3 - Lab3</h2>
            <h3>First JSP</h3>
            <p>Image: </p>
            <img src="images/cat2.jpg" alt="cat">
            <hr>
            <p style="font-variant-caps: all-petite-caps;">Current Date:
                <b><%= new java.util.Date() %></b>
            </p>

        </div>
    </div>
</div>
<%@include file="websitesInclude/footer.jsp"%>>
</body>
</html>
