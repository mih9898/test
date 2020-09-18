<%@include file="websitesInclude/head.jsp" %>
<body>
<%@include file="websitesInclude/nav.jsp" %>
<div id="content">

    <div id="posts">
        <div class="post">
            <h2>
                Unit2 / Lab2 <span class="small">(linking output)</span>
            </h2>
            <ol>
                <li>
                    <a href="http://localhost:8080/java112/index.jsp">
                        Wrong way to link to the home page
                    </a>
                </li>
                <li>
                    <a href="/java112/index.jsp">
                        Wrong way to link to the home page
                    </a>
                </li>
                <li>
                    <a href="/java112" class="right">
                        The right way to link to the home page!
                    </a>
                </li>
            </ol>
        </div>
    </div>
</div>
<%@include file="websitesInclude/footer.jsp"%>
</body>
</html>
