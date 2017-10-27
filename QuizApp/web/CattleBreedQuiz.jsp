<%-- 
    Document   : CattleBreedQuiz
    Created on : Oct 20, 2017, 3:01:24 PM
    Author     : dnyffeler
--%>

<%@page import="quiz.CattleBreedResults"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cattle Breed Quiz</title>
    </head>
    <body>
        <h1>Cattle Breed Quiz</h1>

        <img src="sources/cattleBreeds.jpg" alt=""/>
            <br/>
        <form action="../QuizApp/CattleBreedResults" method="get">
            <table>
                <%
                    for(String name: CattleBreedResults.key.keySet()) {%>
                    <tr><td><%=name%>:</td><td><input type="text" name="<%=name%>" value="1"></td></tr>
                    <%}
                %>
            </table>
            <input type="submit"/>
        </form>
    </body>
</html>
