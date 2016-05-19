<%-- 
    Document   : venditore
    Created on : 16-mag-2016, 17.44.53
    Author     : euralcoop
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>MATERASSISSIMI ONLINE</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Simone Deidda">
        <meta name="keywords" content="vendita di materassi online descrizione">
        <link href="M2/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <nav>
        <a href="login.html">Login</a>
        </nav>
        <div id="body">
        <h1>Vendita Online di Materassi</h1>
        <p>
            Benritrovati, approfittate di questo momento d'oro! Continuano i grandi sconti su tutti i materassi, 
            50% di sconto più un altro 20% se ordini subito su questo sito!
        </p>
        
        <ol>
            <c:forEach var="m" items="${materassi}">
                <li><a href="#${m.getId()}">Link al ${m.getNome()}</a></li>
            </c:forEach>
        </ol>
        <c:forEach var="m" items="${materassi}">
            <h2 id="${m.getId()}">${m.getNome()}</h2>
            <p>${m.getDescrizione()}</p>
            <h3>Dettagli</h3>
            <p>${m.getDettagli()}</p>
        </c:forEach>
        </div>
    </body>
</html>

