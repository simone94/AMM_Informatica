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
        <title>Venditore</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Simone Deidda">
        <meta name="keywords" content="vendita di materassi online venditore">
        <link href="M2/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <c:if test="${errore}"><h3>ERRORE! NON SEI AUTORIZZATO A VISUALIZZARE LA PAGINA</h3></c:if>
        <c:if test="${giusto}">
        <nav>
        <a href="descrizione.html">Descrizione</a>
        <a href="login.html?idUtente=${utente.getId()}&&tipoId=${utente.getTipo()}">Login</a>
        </nav>
        <div id="body">
        <form action="venditore.html" method="GET">
            <label for="nome">Nome dell'oggetto</label>
            <input type="text" name="nome" id="nome" value="" />
            
            <label class="notFirst" for="id">Id dell'oggetto</label>
            <input type="text" name="id" id="id" value="" />
            
            <label class="notFirst" for="foto">URL di una foto dell'oggetto</label>
            <input type="text" name="foto" id="foto" value="" />
            
            <label class="notFirst" for="descrizione">Breve descrizione dell'oggetto</label>
            <textarea rows="5" cols="20" name="descrizione" id="descrizione"></textarea>
            
            <label class="notFirst" for="dettagli">Altri dettagli come colori o gadget</label>
            <textarea rows="5" cols="20" name="dettagli" id="dettagli"></textarea>
            
            <label class="notFirst" for="prezzo">Prezzo dell'oggetto</label>
            <input type="text" name="prezzo" id="prezzo" value="" />
            
            <label class="notFirst" for="nPezzi">Numero di pezzi a disposizione</label>
            <input type="number" min="0" name="nPezzi" id="nPezzi" value="0" />
            
            <input type="hidden" name="idUtente" value="${utente.getId()}" />
            <input type="hidden" name="tipoId" value="${utente.getTipo()}" />
            <div>
            <input class="tasto" type="submit" name="Continua" value="Continua" />
            </div>
        </form>
        </div>
        </c:if>
    </body>
</html>
