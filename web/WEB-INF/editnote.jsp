<%-- 
    Document   : editnote
    Created on : 25-Jan-2023, 9:21:55 AM
    Author     : Renee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Note</title>
    </head>
    <body>
        <form>
            <h1>Simple Note Keeper</h1>
            <h2>Edit Note</h2>
            Title: <input type="text" name="title" value="${note.title}">
            <br>
            Contents: <textarea name="contents" rows="7" cols="25" value="${note.contents}"></textarea>
            <br>
            <input type="submit" name="submit" value="Save">
        </form>
    </body>
</html>
 