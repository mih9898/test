<%@include file="head.jsp" %>
<body>
<%@include file="nav.jsp" %>
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
<div id="footer">
    <p>
        Copyright © 2006 Dusplic. Designed by <a href="http://www.freecsstemplates.org/"><strong>Free CSS Templates</strong></a> | <a href="http://validator.w3.org/check/referer" title="This page validates as XHTML 1.0 Transitional">Valid <abbr title="eXtensible HyperText Markup Language">XHTML</abbr> | Courtesy</a> <a href="http://www.openwebdesign.org" target="_blank">Open Web Design</a>
    </p>
</div>
</body>
</html>
