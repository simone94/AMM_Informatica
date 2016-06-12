<%-- 
    Document   : scegli
    Created on : 2-giu-2016, 10.12.07
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
        <title>Area Venditore</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Simone Deidda">
        <meta name="keywords" content="vendita di materassi online area vanditore">
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
            <h1>Ciao ${utente.getNome()} ${utente.getCognome()}</h1>
            <h2>Scegli cosa fare:</h2>
        
            <input type="hidden" name="idUtente" value="${utente.getId()}" />
            <input type="hidden" name="tipoId" value="${utente.getTipo()}" />
            
            <h3>Inserisci un nuovo elemento</h3>
            <input class="tasto" type="submit" name="New" value="Nuovo" />
            <h3>Cancella un elemento</h3>
            <p>
                <select name="deleteWho">
                    <c:forEach var="m" items="${materassi}" >
                        <option value="${m.getId()}">${m.getNome()}</option>
                    </c:forEach>
                </select>
                <div>
                <input class="tasto" type="submit" name="Delete" value="Cancella" />
                </div>
            </p>
            <h3>Modifica un elemento</h3>
            <p>
                <select name="correctWho">
                    <c:forEach var="m" items="${materassi}">
                        <option value="${m.getId()}">${m.getNome()}</option>
                    </c:forEach>
                </select>
                <select name="correctWhat">
                    <option value="nome">Nome</option>
                    <option value="idMaterasso">Id Materasso</option>
                    <option value="url">URL</option>
                    <option value="descricione">Descrizione</option>
                    <option value="disponibili">Disponibili</option>
                    <option value="dettagli">Dettagli</option>
                    <option value="prezzo">Prezzo</option>
                </select>
                <label class="notFirst" for="descrizione">Inserisci qui il la modifica da apportare</label>
                <textarea rows="5" cols="20" name="right" id="right"></textarea>
                <div>
                <input class="tasto" type="submit" name="Correction" value="Modifica" />
                </div>
            </p>
        </form>
            
        <c:if test="${errore}"><h3>USERNAME O PASSWORD SBAGLIATI, RIPROVA</h3></c:if> 
        </div>
        </c:if>
    </body>
</html>
