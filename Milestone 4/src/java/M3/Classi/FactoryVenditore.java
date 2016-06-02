/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M3.Classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author euralcoop
 */
public class FactoryVenditore {
    String connectionString;
    Venditore v = new Venditore();
    
    private static FactoryVenditore singleton;
    public static FactoryVenditore getInstance() {
        if (singleton == null) {
            singleton = new FactoryVenditore();
        }
        return singleton;
    }
    
    private FactoryVenditore(){
        /*
        v.setNome("Giulio");
        v.setCognome("di Gioia");
        v.setId(1);
        v.setUsername("giudigio");
        v.setPassword("ciaodavide");
        v.setSaldo(100.00);
        */
    }
    
    public Venditore findWithId(int id){
        try {
            
            Connection conn = DriverManager.getConnection(connectionString, "simone_deidda", "65075");
            String query = "select * from utente where id = ? and tipo = 1";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                Venditore other = new Venditore();
                other.setNome(rs.getString("nome"));
                other.setCognome(rs.getString("cognome"));
                other.setUsername(rs.getString("username"));
                other.setPassword(rs.getString("password"));
                other.setTipo(rs.getInt("tipo"));
                other.setId(rs.getInt("id"));
                other.setSaldo(rs.getDouble("saldo"));
                
                rs.close();
                conn.close();
                return other;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public Venditore findWithUsernameAndPassword(String username, String password){
        try {
            
            Connection conn = DriverManager.getConnection(connectionString, "simone_deidda", "65075");
            String query = "select * from utente where username = ? and password = ? and tipo = 1";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                Venditore other = new Venditore();
                other.setNome(rs.getString("nome"));
                other.setCognome(rs.getString("cognome"));
                other.setUsername(rs.getString("username"));
                other.setPassword(rs.getString("password"));
                other.setTipo(rs.getInt("tipo"));
                other.setId(rs.getInt("id"));
                other.setSaldo(rs.getDouble("saldo"));
                
                rs.close();
                conn.close();
                return other;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public Venditore GetVenditore(){
        return v;
    }
    public void setConnectionString(String s){
    this.connectionString = s;
    }

    public String getConnectionString(){
    return this.connectionString;
    }
}
