
<%@include file="head.jsp" %>
<body>
<%@include file="nav.jsp" %>
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
<div id="footer">
    <p>
        Copyright © 2006 Dusplic. Designed by <a href="http://www.freecsstemplates.org/"><strong>Free CSS Templates</strong></a> | <a href="http://validator.w3.org/check/referer" title="This page validates as XHTML 1.0 Transitional">Valid <abbr title="eXtensible HyperText Markup Language">XHTML</abbr> | Courtesy</a> <a href="http://www.openwebdesign.org" target="_blank">Open Web Design</a>
    </p>
</div>
</body>
</html>
