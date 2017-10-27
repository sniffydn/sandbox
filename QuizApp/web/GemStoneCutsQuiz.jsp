<%-- 
    Document   : GemStoneCutsQuiz
    Created on : Oct 27, 2017, 1:50:26 PM
    Author     : dnyffeler
--%>

<%@page import="quiz.GemStoneCutsQuiz"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gem Stone Cuts Quiz</title>
    </head>
    <body>
        <h1>Gem Stone Cuts Quiz</h1>

        <img src="sources/gemstoneCuts.jpg" alt=""/>
            <br/>
        <form action="../QuizApp/GemStoneCutsQuiz" method="get">
            <table>
                <%
                    for(String name: GemStoneCutsQuiz.key.keySet()) {%>
                    <tr><td><%=name%>:</td><td><input type="text" name="<%=name%>" value="1"></td></tr>
                    <%}
                %>
            </table>
            <input type="submit"/>
        </form>
    </body>
</html>
