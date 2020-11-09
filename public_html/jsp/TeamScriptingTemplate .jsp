<html>
<head>
    <title>Mike and Joe</title>
        </head>

<body>
<h2>Concept Name</h2>
Expression<br />
<h2>Description</h2>
JSP scripting elements allow the use of Java programing statements in your JSP page.
This is done by inserting the value of a scripting language expression into the data stream retuned to the client
They are trypically used to create and access Java objects and define methods.
They can not contain semi colons and should be used sparingly! There are three main ways that they are applied:
1. Instance and class variables of the JSP page's servlet class are created in declarations and then accessed in expressions.<br />
2. Local vairables of the JSP page are created and used in expressions.<br />
3 Attributes of scope objects are created and used in expressions<br />
<h2>Syntax</h2>
<%= "scripting-language-expression" %><br />
<h2>Example</h2>
<%= new java.util.Date()%><br />
<h2>JSP Translator</h2>
{{bing}}
The code will then look like this:<br />
out.write("<td>${1.2 + 2.3}</td>\n");
<h2>Best Practices</h2>
Do not overuse Expressions in JSP pages! Overuse leads to a decrease in readability and performance loss.
Can not contain semi colons
Best way to include String values from controller.<br />
<h2>Drawbacks</h2>
Can not be re used<br />
Reduces maintainability and readability of code<br />
They are not unit testable<br />
If an exception is thrown it breaks the whole page and does not move further in the processing.<br />

</body>
</html>d