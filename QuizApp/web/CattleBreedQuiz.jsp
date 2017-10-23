<%-- 
    Document   : CattleBreedQuiz
    Created on : Oct 20, 2017, 3:01:24 PM
    Author     : dnyffeler
--%>

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
        <form action="../QuizApp/CattleBreedResults" method="get">
            Watusi:<input type="text" name="Watusi" value="1"><br/>
            Texas Longhorn:<input type="text" name="Texas Longhorn" value="1"><br/>
            Angus:<input type="text" name="Angus" value="1"><br/>
            Red Angus:<input type="text" name="Red Angus" value="1"><br/>
            Piedmontese:<input type="text" name="Piedmontese" value="1"><br/>
            Shorthorn:<input type="text" name="Shorthorn" value="1"><br/>
            Holstein:<input type="text" name="Holstein" value="1"><br/>
            Simmental:<input type="text" name="Simmental" value="1"><br/>
            Scottish Highland:<input type="text" name="Scottish Highland" value="1"><br/>
            Gelbvieh:<input type="text" name="Gelbvieh" value="1"><br/>
            Limousin:<input type="text" name="Limousin" value="1"><br/>
            Hereford:<input type="text" name="Hereford" value="1"><br/>
            Brahman:<input type="text" name="Brahman" value="1"><br/>
            Dexter:<input type="text" name="Dexter" value="1"><br/>
            Charolais:<input type="text" name="Charolais" value="1"><br/>
            Belted Galloway:<input type="text" name="Belted Galloway" value="1"><br/>
            <br/>
            <input type="submit"/>
        </form>
    </body>
</html>
