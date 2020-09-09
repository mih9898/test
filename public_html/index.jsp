<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>linkingDemo</title>
    <style>
        li a {
            font-size: larger;
            list-style-type: none;
            font-style: italic;
            padding: .4em;
            color: red;
        }
        a.right {
            color:lightseagreen;
        }

    </style>
</head>
<body>
<h1>Links: </h1>
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
</body>
</html> 