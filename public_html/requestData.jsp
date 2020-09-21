<%@include file="websitesInclude/head.jsp" %>
<body>
<%@include file="websitesInclude/nav.jsp" %>
<div id="content">
    <div id="posts">
        <h2>Project 3 - Request Data </h2>
        <h3>Output: </h3>
        <ul>
            <li>The remote computer making the request - ${requestData.remoteComputer}</li>
            <li>The address of the remote computer making the request - ${requestData.remoteAddress}</li>
            <li>The HTTP method of the request - ${requestData.httpMethod}</li>
            <li>The request URI - ${requestData.requestURI}</li>
            <li>The request URL - ${requestData.requestURL}</li>
            <li>The protocol of the request - ${requestData.requestProtocol}</li>
            <li>The server name - ${requestData.localName}</li>
            <li>The server port number - ${requestData.portName}</li>
            <li>The current Locale of the server - ${requestData.locale}</li>
            <li>The query string - ${requestData.queryString}</li>
            <li>The value of a query parameter with the name of "queryParameter" - ${requestData.queryParameter}</li>
            <li>The value of the request header with the name of "User-Agent" - ${requestData.requestHeader}</li>
        </ul>
    </div>
</div>
<%@include file="websitesInclude/footer.jsp"%>
</body>
</html>
