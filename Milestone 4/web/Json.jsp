<%-- 
    Document   : json
    Created on : 6-giu-2016, 14.48.16
    Author     : Acer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<json:array>
    <c:forEach var="materassi" items="${listaMaterassi}">
        <json:object>
            <json:property name="nome" value="${materassi.getNome()}"/>
            <json:property name="id" value="${materassi.getId()}"/>
            <json:property name="url" value="${materassi.getUrl()}"/>
            <json:property name="descrizione" value="${materassi.getDescrizione()}"/>
            <json:property name="dettagli" value="${materassi.getDettagli()}"/>
            <json:property name="disponibili" value="${materassi.getDisponibili()}"/>
            <json:property name="prezzo" value="${materassi.getPrezzo()}"/>            
        </json:object>
    </c:forEach>
</json:array>