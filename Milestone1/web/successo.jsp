<%-- 
    Document   : successo
    Created on : 27-apr-2016, 19.05.58
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
        <title>Confermato</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Simone Deidda">
        <meta name="keywords" content="vendita di materassi online confermato">
        <link href="style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
    <c:if test="${errore}"><h3>ERRORE: NON HAI ABBASTANZA SOLDI PER ACQUISTARE L'OGGETTO</h3></c:if>
        <nav>
            <p>Saldo attuale: ${utente.getMoney().getSaldo()}</p>
        </nav>
        <div id="body">
            <h1>Hai confermato questo oggetto</h1>
            <ul>
                
                <li>Nome Oggetto: ${coso.getNome()}</li>
                <li>Id Oggetto: ${coso.getId()}</li>
                <li>Url Oggetto: ${coso.getUrl()}</li>
                <li>Descrizione Oggetto: ${coso.getDescrizione()}</li>
                <li>Dettagli Oggetto: ${coso.getDettagli()}</li>
                <li>Prezzo Oggetto: ${coso.getPrezzo()}</li>
                <li>Oggetti Disponibili: ${coso.getQuantita()}</li>
            </ul>
            <c:if test="${cliente}">
            <form action="Last" method="GET">
            <input type="hidden" name="saldo" id="saldo" value="${utente.getMoney().getSaldo()}" />
            <input type="hidden" name="prezzo" id="prezzo" value="${coso.getPrezzo()}" />
            <input type="hidden" name="idM" id="idM" value="${coso.getId()}" />
            <div>
                <input class="tasto" type="submit" name="Compra" value="Compra Subito" />
            </div>
            </form>
            </c:if>
             <c:if test="${giusto}"><h3>OGGETTO ACQUISTATO CORRETTAMENTE</h3></c:if>   
        </div>
    </body>
</html>
