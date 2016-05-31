/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M3.Classi;

/**
 *
 * @author euralcoop
 */
public class FactoryVenditore {
    Venditore v = new Venditore();
    
    private static FactoryVenditore singleton;
    public static FactoryVenditore getInstance() {
        if (singleton == null) {
            singleton = new FactoryVenditore();
        }
        return singleton;
    }
    
    private FactoryVenditore(){
        v.setNome("Giulio");
        v.setCognome("di Gioia");
        v.setId(1);
        v.setUsername("giudigio");
        v.setPassword("ciaodavide");
        v.setSaldo(100.00);
    }
    
    public Venditore GetVenditore(){
        return v;
    }
}
