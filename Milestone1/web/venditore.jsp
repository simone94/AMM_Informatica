<%-- 
    Document   : venditore
    Created on : 23-apr-2016, 17.13.54
    Author     : Acer
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
        <title>Venditore</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Simone Deidda">
        <meta name="keywords" content="vendita di materassi online venditore">
        <link href="style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <c:if test="${errore}"><h3>ERRORE: NON SEI AUTORIZZATO AD ACCEDERE A QUESTA PAGINA</h3></c:if>
        <c:if test="${giusto}">
        <nav>
        <a href="descrizione.html">Descrizione</a>
        <a href="login.html?idU=0">Login</a>
        </nav>
        <div id="body">
            
            <form action="venditore.html" method="GET">
            <input type="hidden" name="idU" id="idU" value="0" />
                
            <label for="nome">Nome dell'oggetto</label>
            <input type="text" name="nome" id="nome" value="" />
            
            <label class="notFirst" for="id">Id dell'oggetto</label>
            <input type="text" name="id" id="id" value="" />
            
            <label class="notFirst" for="foto">URL di una foto dell'oggetto</label>
            <input type="url" name="foto" id="foto" value="" />
            
            <label class="notFirst" for="descrizione">Breve descrizione dell'oggetto</label>
            <textarea rows="5" cols="20" name="descrizione" id="descrizione"></textarea>
            
            <label class="notFirst" for="dettagli">Dettagli tipo colore o eventuali gadget</label>
            <textarea rows="5" cols="20" name="dettagli" id="dettagli"></textarea>
            
            <label class="notFirst" for="prezzo">Prezzo dell'oggetto</label>
            <input type="text" name="prezzo" id="prezzo" value="" />
            
            <label class="notFirst" for="nPezzi">Numero di pezzi a disposizione</label>
            <input type="t" min="0" name="nPezzi" id="nPezzi" value="0" />
            
            <div>
            <input class="tasto" name="Sell" type="submit" value="Continua" />
            </div>
        </form>
            <c:if test="${clear}"><h3>ERRORE: NON SEI AUTORIZZATO AD ACCEDERE A QUESTA PAGINA</h3></c:if>
        </div>
        </c:if>
    </body>
</html>
