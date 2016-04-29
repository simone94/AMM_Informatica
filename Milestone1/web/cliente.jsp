<%-- 
    Document   : cliente
    Created on : 23-apr-2016, 17.12.24
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
        <title>Cliente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Simone Deidda">
        <meta name="keywords" content="vendita di materassi online cliente">
        <link href="style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
            
        <c:if test="${errore}">
            <h3>ERRORE: NON SEI AUTORIZZATO AD ACCEDERE A QUESTA PAGINA!</h3>
        </c:if>
        <c:if test="${giusto}">
        <nav>
        <a href="descrizione.html">Descrizione</a>
        <a href="login.html?idU=1">Login</a>
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
            <c:set var="dispari" value="true"></c:set>
            <c:forEach var="materasso" items="${listaMaterassi}">
                <c:if test="${dispari}">
                    <tr class="dispari">
                        <td>${materasso.getNome()}</td>
                        <td><img title="${materasso.getId()}" alt="Foto di un ${materasso.getNome()}" src="${materasso.getUrl()}" idth="120" height="80"></td>
                        <td>${materasso.getQuantita()}</td>
                        <td>${materasso.getPrezzo()}</td>
                        <td><a href="cliente.html?idM=${materasso.getId()}&idU=1">Metti nel carrello</a></td>
                    </tr>  
                </c:if>
                <c:if test="${!dispari}">
                    <tr>
                        <td>${materasso.getNome()}</td>
                        <td><img title="${materasso.getId()}" alt="Foto di un ${materasso.getNome()}" src="${materasso.getUrl()}" idth="120" height="80"></td>
                        <td>${materasso.getQuantita()}</td>
                        <td>${materasso.getPrezzo()}</td>
                        <td><a href="cliente.html?idM=${materasso.getId()}&idU=1">Metti nel carrello</a></td>
                    </tr>  
                </c:if>
                
                    <p class="nascondi">${dispari=!dispari}</p>
            </c:forEach>
            
        </table>
        
        </div>
        </c:if>
    </body>
</html>
