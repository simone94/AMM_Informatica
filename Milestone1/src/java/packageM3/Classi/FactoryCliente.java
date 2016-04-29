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
public class FactoryCliente {
    
    private static FactoryCliente singleton;
    public static FactoryCliente getInstance() {
        if (singleton == null) {
            singleton = new FactoryCliente();
        }
        return singleton;
    }
    
    private Cliente other;
    
    public FactoryCliente(){
        Cliente cli1 = new Cliente();
        cli1.setId(1);
        cli1.setNome("Piero");
        cli1.setCognome("De Pieri");
        cli1.setUsername("piedepie");
        cli1.setPassword("ciaocarca");
        cli1.setMoney(new Saldo());
        this.other=cli1;
    }
    
    public Cliente getCliente(){
        return other;
    }
    
}
