/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageM3.Classi;

import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class FactoryOggetti {
    
    private static FactoryOggetti singleton;
    public static FactoryOggetti getInstance() {
        if (singleton == null) {
            singleton = new FactoryOggetti();
        }
        return singleton;
    }
    
    public ArrayList<Oggetti> listaOggetti = new ArrayList<Oggetti>();
    
    public FactoryOggetti(){
        Oggetti ogg1 = new Oggetti();
        ogg1.setNome("Materasso Matrimoniale");
        ogg1.setPrezzo(189.99);
        ogg1.setQuantita(58);
        ogg1.setUrl(".\\Images\\matrimoniale.jpg");
        ogg1.setDescrizione("Materasso grande dove dormire col vostro coniuge.");
        ogg1.setId("matrimoniale");
        ogg1.setDettagli("Disponibile con coperte e cuscini compresi nel prezzo e di colore bianco perla e blu scuro.");
        
        listaOggetti.add(ogg1);
        
        Oggetti ogg2 = new Oggetti();
        ogg2.setNome("Materasso per Culle");
        ogg2.setPrezzo(13.99);
        ogg2.setQuantita(64);
        ogg2.setUrl(".\\Images\\culla.jpg");
        ogg2.setDescrizione("Materasso piccolo dove dovrebbe dormire il vostro pargolo.");
        ogg2.setId("culle");
        ogg2.setDettagli("Disponibile con coperte e cuscini compresi nel prezzo e di colore azzurro e rosa.");
        listaOggetti.add(ogg2);
        
        Oggetti ogg3 = new Oggetti();
        ogg3.setNome("Materasso Futon");
        ogg3.setPrezzo(196.80);
        ogg3.setQuantita(12);
        ogg3.setUrl(".\\Images\\futon.jpg");
        ogg3.setDescrizione("Materasso arrotolabile giapponese.");
        ogg3.setId("futon");
        ogg3.setDettagli("Disponibile con coperte e cuscini compresi nel prezzo e con motivo a quadri grandi e piccoli.");
        listaOggetti.add(ogg3);
        
        Oggetti ogg4 = new Oggetti();
        ogg4.setNome("Materasso Gonfiabile");
        ogg4.setPrezzo(19.99);
        ogg4.setQuantita(86);
        ogg4.setUrl(".\\Images\\gonfiabile.jpg");
        ogg4.setDescrizione("Materasso da spiaggia, gonfiabile a bocca o tramite apposita pompetta.");
        ogg4.setId("gonfiabile");
        ogg4.setDettagli("Disponibile con e senza la pratica pompetta e di colore magenta, blu elettrico e verde acqua.");
        listaOggetti.add(ogg4);
        
        Oggetti ogg5 = new Oggetti();
        ogg5.setNome("Materasso ad Acqua");
        ogg5.setPrezzo(152.90);
        ogg5.setQuantita(54);
        ogg5.setUrl(".\\Images\\acqua.jpg");
        ogg5.setDescrizione("Materasso singolo, riempibile tramite l'apposita pompa d'acqua.");
        ogg5.setId("acqua");
        ogg1.setDettagli("Disponibile con  la pratica pompa compresa nel prezzo e di colore beige e nero.");
        listaOggetti.add(ogg5);
        
    }
    
    public ArrayList<Oggetti> getOggettiEsposti(){
        
        return listaOggetti;
    }
    
    public Oggetti find(String id){
        Oggetti o = null;
        for(Oggetti trovato: listaOggetti){
            if(trovato.getId().equals(id)) return trovato;
        }
    return o;
    }
}
