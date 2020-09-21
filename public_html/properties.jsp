<%@include file="websitesInclude/head.jsp" %>
<body>
<%@include file="websitesInclude/nav.jsp" %>
<div id="content">
    <div id="posts">
        <h2>Project 3 - Properties data </h2>
        <h3>Output: </h3>
        <table>
            <tr>
                <th>Author's first name</th><td>${properties["author.name"]}</td>
            </tr>
            <tr>
                <th>Author's last name</th><td>${properties["author.last_name"]}</td>
            </tr>
            <tr>
                <th>Author's email</th><td>${properties["author.email"]}</td>
            </tr>
            <tr>
                <th>Course</th><td>${properties["course.name"]}</td>
            </tr>
            <tr>
                <th>Course days</th><td>${properties["course.days"]}</td>
            </tr>
            <tr>
                <th>Course time</th><td>${properties["course.time"]}</td>
            </tr>
            <tr>
                <th>Course description</th><td>${properties["course.description"]}</td>
            </tr>
            <tr>
                <th>Instructor</th><td>${properties["course.instructor"]}</td>
            </tr>
        </table>
    </div>
</div>
<%@include file="websitesInclude/footer.jsp"%>
</body>
</html>
