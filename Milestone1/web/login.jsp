<%-- 
    Document   : login
    Created on : 23-apr-2016, 17.11.29
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
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Simone Deidda">
        <meta name="keywords" content="vendita di materassi online login">
        <link href="style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <nav>
        <a href="descrizione.html">Descrizione</a>
        <a href="cliente.html">Cliente</a>
        <a href="venditore.html">Venditore</a>
        </nav>
        <div id="body">
            
            <c:if test="${errore}"><h3 >USERNAME O PASSWORD SBAGLIATI RIPROVA</h3></c:if>
        <form action="login.html" method="GET">
            <label for="username">Username</label>
            <input type="text" name="username" id="username" value="" />
            
            <label class="notFirst" for="password">Password </label>
            <input type="password" name="password" id="password" value="" />
            <div>
                <input class="tasto" type="submit" name="Submit" value="Login" />
            </div>
        </form>
        <p>Se non ricordi Username o Password clicca <a href="info.jsp">Qui</a></p>
        </div>
    </body>
</html>
