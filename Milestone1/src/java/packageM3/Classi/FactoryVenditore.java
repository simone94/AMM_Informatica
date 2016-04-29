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
public class FactoryVenditore {
    
    private static FactoryVenditore singleton;
    public static FactoryVenditore getInstance() {
        if (singleton == null) {
            singleton = new FactoryVenditore();
        }
        return singleton;
    }
    
    private Venditore other;
    
    public FactoryVenditore(){
        Venditore ven1 = new Venditore();
        ven1.setId(0);
        ven1.setNome("Giulio");
        ven1.setCognome("Di Gioia");
        ven1.setUsername("giudigio");
        ven1.setPassword("ciaodavide");
        ven1.setMoney(new Saldo());
        this.other=ven1;
    }
    
    public Venditore getVenditore(){
        return other;
    }
    
}
