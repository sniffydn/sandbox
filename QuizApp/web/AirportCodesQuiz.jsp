<%@page import="quiz.AirportCodesResults"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Airport Codes Quiz</title>
    </head>
    <body>
        <h1>Airport Codes Quiz</h1>

        <table>
<tr><td>PEK</td><td>CUN</td><td>ENG</td></tr>
<tr><td>HND</td><td>SYD</td><td>CAN</td></tr>
<tr><td>PET</td><td>REY</td><td>SWE</td></tr>
<tr><td>BOM</td><td>BZL</td><td>CPH</td></tr>
<tr><td>MUC</td><td>GRU</td><td>ORD</td></tr>
<tr><td>HNL</td><td>CDG</td><td>FCO</td></tr>
<tr><td>GMP</td><td>SGN</td><td>FRA</td></tr>
<tr><td>YVR</td><td>ARN</td><td>LHR</td></tr>
<tr><td>SOK</td><td>LED</td><td>HCM</td></tr>
<tr><td>KEF</td><td>RUH</td><td>COP</td></tr>
</table>
            <br/>
        <form action="../QuizApp/AirportCodesResults" method="get">
            <table>
                <%
                    for(String name: AirportCodesResults.key.keySet()) {%>
                    <tr><td><%=name%>:</td><td><input type="text" name="<%=name%>" value="X"></td></tr>
                    <%}
                %>
            </table>
            <input type="submit"/>
        </form>
    </body>
</html>
