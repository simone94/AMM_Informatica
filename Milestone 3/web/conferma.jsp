<%-- 
    Document   : conferma
    Created on : 18-mag-2016, 19.30.24
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
        <title>Conferma</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Simone Deidda">
        <meta name="keywords" content="vendita di materassi online login">
        <link href="M2/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        
    
        <nav>
            <p>Saldo disponibile: ${utente.getSaldo()}</p>
        </nav>
        <div id="body">
        
            <h1>Ciao ${utente.getNome()} ${utente.getCognome()}</h1>
            <h3>Hai confermato questo oggetto:</h3>
            <img title="${materasso.getId()}" alt="Foto di un ${materasso.getNome()}" src="${materasso.getUrl()}" width="120" height="80">
            <ul>
                <li><p>Nome: ${materasso.getNome()}</p></li>
                <li><p>Id: ${materasso.getId()}</p></li>
                <li><p>Descrizione: ${materasso.getDescrizione()}</p></li>
                <li><p>Dettagli: ${materasso.getDettagli()}</p></li>
                <li><p>Disponibili: ${materasso.getDisponibili()}</p></li>
                <li><p>Prezzo: ${materasso.getPrezzo()}</p></li>
            </ul>
            <c:if test="${AmIClient}">
                <form action="Last" method="GET">
                <input type="hidden" name="Saldo" id="Saldo" value="${utente.getSaldo()}" />
                <input type="hidden" name="chiCompro" id="chiCompro" value="${materasso.getId()}" />
                <input class="tasto" type="submit" name="Submit" value="Procedi" />
                </form>
            </c:if>
            <c:if test="${errore}"><h2>NON HAI ABBASTANZA SOLDI PER EFFETTUARE L'ACQUISTO</h2></c:if>
            <c:if test="${giusto}"><h2>PAGAMENTO AVVENUTO CON SUCCESSO</h2></c:if>
        </div>
    
    </body>
</html>

