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
        <title>Cliente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Simone Deidda">
        <meta name="keywords" content="vendita di materassi online cliente">
        <link href="M2/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
    <c:if test="${errore}"><h3>ERRORE! NON SEI AUTORIZZATO A VISUALIZZARE LA PAGINA</h3></c:if>
    <c:if test="${giusto}">
        <nav>
        <a href="descrizione.html">Descrizione</a>
        <a href="login.html?idUtente=${utente.getId()}">Login</a>
        </nav>
        <div id="body">
        <table>
            <tr>
                <th>Nome del prodotto</th>
                <th>Foto</th>
                <th>Numero di pezzi disponibili</th>
                <th>Prezzo</th>
                <th>Link</th>
            </tr>
            <c:set var="dispari" value="true"/>
            <c:set var="pari" value="false"/>
            <c:forEach var="m" items="${materassi}">
                <c:if test="${dispari}">
                    <tr class="dispari"> 
                        <td>${m.getNome()}</td>
                        <td><img title="${m.getId()}" alt="Foto di un ${m.getNome()}" src="${m.getUrl()}" width="120" height="80"></td>
                        <td>${m.getDisponibili()}</td>
                        <td>€ ${m.getPrezzo()}</td>
                        <td><a href="cliente.html?chiCompro=${m.getId()}&idUtente=${utente.getId()}">Metti nel carrello</a></td>
                    </tr>
                </c:if>
                <c:if test="${pari}">
                    <tr> 
                        <td>${m.getNome()}</td>
                        <td><img title="${m.getId()}" alt="Foto di un ${m.getNome()}" src="${m.getUrl()}" width="120" height="80"></td>
                        <td>${m.getDisponibili()}</td>
                        <td>€ ${m.getPrezzo()}</td>
                        <td><a href="cliente.html?chiCompro=${m.getId()}&idUtente=${utente.getId()}">Metti nel carrello</a></td>
                    </tr>
                </c:if>
                    <p class="hidden">${dispari=!dispari} ${pari=!pari}</p>
            </c:forEach>
            
        </table>
        </div>
        </c:if>
    </body>
</html>

