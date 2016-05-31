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
public class FactoryCliente {
    Cliente c =new Cliente();
    
    private static FactoryCliente singleton;
    public static FactoryCliente getInstance() {
        if (singleton == null) {
            singleton = new FactoryCliente();
        }
        return singleton;
    }
    
    private FactoryCliente(){
        c.setNome("Piero");
        c.setCognome("de Pieri");
        c.setId(0);
        c.setUsername("piedepie");
        c.setPassword("ciaocarca");
        c.setSaldo(100.00);
    }
    
    public Cliente GetCliente(){
        return c;
    }
}
