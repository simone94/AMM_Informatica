/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M3.Classi;

import java.util.ArrayList;

/**
 *
 * @author euralcoop
 */
public class FactoryMaterasso {
    private ArrayList<Materasso> lista = new ArrayList<Materasso>();
    
    private static FactoryMaterasso singleton;
    public static FactoryMaterasso getInstance() {
        if (singleton == null) {
            singleton = new FactoryMaterasso();
        }
        return singleton;
    }
    
    private FactoryMaterasso(){
        Materasso m1=new Materasso();
        m1.setNome("Materasso Matrimoniale");
        m1.setId("matrimoniale");
        m1.setDescrizione("Materasso grande dove dormire col vostro coniuge.");
        m1.setDettagli("Disponibile con coperte e cuscini compresi nel prezzo e di colore bianco perla e blu scuro.");
        m1.setUrl("M2\\Images\\matrimoniale.jpg");
        m1.setDisponibili(58);
        m1.setPrezzo(189.99);
        lista.add(m1);
        
        Materasso m2=new Materasso();
        m2.setNome("Materasso per Culle");
        m2.setId("culle");
        m2.setDescrizione("Materasso piccolo dove dovrebbe dormire il vostro pargolo.");
        m2.setDettagli("Disponibile con coperte e cuscini compresi nel prezzo e di colore azzurro e rosa.");
        m2.setUrl("M2\\Images\\culla.JPG");
        m2.setDisponibili(64);
        m2.setPrezzo(13.99);
        lista.add(m2);
        
        Materasso m3=new Materasso();
        m3.setNome("Materasso Futon");
        m3.setId("futon");
        m3.setDescrizione("Materasso arrotolabile giapponese.");
        m3.setDettagli("Disponibile con coperte e cuscini compresi nel prezzo e con motivo a quadri grandi e piccoli.");
        m3.setUrl("M2\\Images\\futon.jpg");
        m3.setDisponibili(12);
        m3.setPrezzo(196.80);
        lista.add(m3);
        
        Materasso m4=new Materasso();
        m4.setNome("Materassino Gonfiabile");
        m4.setId("gonfiabile");
        m4.setDescrizione("Materasso da spiaggia, gonfiabile a bocca o tramite apposita pompetta.");
        m4.setDettagli("Disponibile con e senza la pratica pompetta e di colore magenta, blu elettrico e verde acqua.");
        m4.setUrl("M2\\Images\\gonfiabile.jpg");
        m4.setDisponibili(86);
        m4.setPrezzo(19.99);
        lista.add(m4);
        
        Materasso m5=new Materasso();
        m5.setNome("Materassino ad Acqua");
        m5.setId("acqua");
        m5.setDescrizione("Materasso singolo, riempibile tramite l'apposita pompa d'acqua.");
        m5.setDettagli("Disponibile con  la pratica pompa compresa nel prezzo e di colore beige e nero.");
        m5.setUrl("M2\\Images\\acqua.jpg");
        m5.setDisponibili(54);
        m5.setPrezzo(152.90);
        lista.add(m5);
    }
    
    public ArrayList<Materasso> GetMaterassiList(){
        return lista;
    }
}
