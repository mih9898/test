<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%--<c:set var="header_title" value="Lab 2 - JSTL" scope="page"/>--%>

<%@include file="websitesInclude/head.jsp" %>
<body>
<%@include file="websitesInclude/nav.jsp" %>
<div id="content">
    <div id="posts">
        <h2> Project 4 - Analyzer Summary</h2>
        <details>
            <summary>File Summary</summary>
            <p>${fileTokensSummary}</p>
        </details>

        <details>
            <summary>Distinct Tokens Summary</summary>
            <p>${distinctTokensSummary}</p>
        </details>

        <details>
            <summary>Largest Toekens Summary</summary>
            <p>${largestTokensSummary}</p>
        </details>

        <details>
            <summary>Distinct Counts Tokens Summary</summary>
            <p>${distinctCountsSummary}</p>
        </details>

        <details>
            <summary>Lexical Tokens Summary</summary>
            <p>${lexicalSummary}</p>
        </details>

        <details>
            <summary>Tokens Length Summary</summary>
            <p>${tokensLengthSummary}</p>
        </details>

        <details>
            <summary>Search Tokens Locations Summary</summary>
            <p>${searchLocationsSummary}</p>
        </details>

    </div>
</div>
<%--<%@include file="websitesInclude/footer.jsp"%>--%></details>
</body>
</html>
