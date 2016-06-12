/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function (){
   $("#Filtra").keyup(function(){  
        
        var id = $("#idU").val();
        var tipo = $("#tipo").val();
        var txt = $("#Filtra").val();
       
        $.ajax({
            url: "filter.json",
            data:{
              find: "search",
              q: txt
            },
            dataType: 'json',
            success : function(data, state){
                listaFiltrata(data);
            },
            error : function(data, state){
            }
        });
        
       
        function listaFiltrata(listaMaterassi){
            if(listaMaterassi.length > 0){
            $("#miss").remove();
            $("#remake").empty();
            var nuovo_tr = document.createElement("tr");
            var arr = Array("Nome del Prodotto","Foto","Numero di Pezzi Disponibili","Prezzo","Link")
            
            for(var j=0; j<arr.length; j++){
                var nuovo_th = document.createElement("th");
                var text = document.createTextNode(arr[j]);
                nuovo_th.appendChild(text);
                nuovo_tr.appendChild(nuovo_th);
            }
            
            $("#remake").append(nuovo_tr);
            var dispari = true;
            for(var materassi in listaMaterassi){                
                nuovo_tr = document.createElement("tr");
                if(dispari) nuovo_tr.setAttribute("class","dispari");
                
                var nuovo_td = document.createElement("td");
                text = document.createTextNode(listaMaterassi[materassi].nome);
                nuovo_td.appendChild(text);
                nuovo_tr.appendChild(nuovo_td);
                
                nuovo_td = document.createElement("td");
                var immagine = document.createElement("img");
                immagine.setAttribute("title",listaMaterassi[materassi].id);
                immagine.setAttribute("src",listaMaterassi[materassi].url);
                immagine.setAttribute("alt","Foto di un" + listaMaterassi[materassi].nome);
                immagine.setAttribute("width","120");
                immagine.setAttribute("height","80");
                nuovo_td.appendChild(immagine);
                nuovo_tr.appendChild(nuovo_td);
                
                nuovo_td = document.createElement("td");
                text = document.createTextNode(listaMaterassi[materassi].disponibili);
                nuovo_td.appendChild(text);
                nuovo_tr.appendChild(nuovo_td);
                
                nuovo_td = document.createElement("td");
                text = document.createTextNode("€ " + listaMaterassi[materassi].prezzo);
                nuovo_td.appendChild(text);
                nuovo_tr.appendChild(nuovo_td);
                
                nuovo_td = document.createElement("td");
                var nuovo_link = document.createElement("a");
                nuovo_link.setAttribute("href","cliente.html?chiCompro=" + listaMaterassi[materassi].id + "&&idUtente=" + id + "&&tipoId=" + tipo);
                text = document.createTextNode("Metti nel Carrello");
                nuovo_link.appendChild(text);
                nuovo_td.appendChild(nuovo_link);
                nuovo_tr.appendChild(nuovo_td);
                
                $("#remake").append(nuovo_tr);
                dispari=!dispari;
                }                
            }
            else{
                $("#remake").empty();
                var nuovo_h3 = document.createElement("h3");
                nuovo_h3.setAttribute("id","miss");
                var text = document.createTextNode("NESSUNA CORRISPONDENZA TROVATA");
                nuovo_h3.appendChild(text);                
                $("#body").append(nuovo_h3);
            }
        }
    }); 
});