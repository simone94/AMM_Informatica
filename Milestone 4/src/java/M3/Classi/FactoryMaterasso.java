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
import java.util.ArrayList;

/**
 *
 * @author euralcoop
 */
public class FactoryMaterasso {
    String connectionString;
    private ArrayList<Materasso> lista = new ArrayList<Materasso>();
    
    private static FactoryMaterasso singleton;
    public static FactoryMaterasso getInstance() {
        if (singleton == null) {
            singleton = new FactoryMaterasso();
        }
        return singleton;
    }
    
    private FactoryMaterasso(){
        /*
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
        */
    }
    
    public ArrayList<Materasso> GetMaterassiList(){
        return lista;
    }
    
    public ArrayList<Materasso> GetEveryMaterasso(){
        try{
            ArrayList<Materasso> fromDataBase = new ArrayList<Materasso>();
            Connection conn = DriverManager.getConnection(connectionString, "simone_deidda", "65075");
            
            String query = "select * from letto";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Materasso other = new Materasso();
                other.setNome(rs.getString("nome"));
                other.setId(rs.getString("idMaterasso"));
                other.setUrl(rs.getString("url"));
                other.setDescrizione(rs.getString("descrizione"));
                other.setDettagli(rs.getString("dettagli"));
                other.setDisponibili(rs.getInt("disponibili"));
                other.setPrezzo(rs.getDouble("prezzo"));
                
                fromDataBase.add(other);
            }
            rs.close();
            conn.close();
            return fromDataBase;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public void delete(String id){
        try{
            Connection conn = DriverManager.getConnection(connectionString, "simone_deidda", "65075");
            String query = "delete from letto where idMaterasso = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id);
            int rs = ps.executeUpdate();

            conn.close();
            }
            
        catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    
    public void change(String id, String what, String nuovo){
        try{
            Connection conn = DriverManager.getConnection(connectionString, "simone_deidda", "65075");
            String query = "update letto set "+ what +" = ? where idMaterasso = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            if(what.equals("prezzo"))
                ps.setDouble(1, Double.parseDouble(nuovo));
            else if(what.equals("disponibili"))
                    ps.setInt(1, Integer.parseInt(nuovo));
                else ps.setString(1, nuovo);
            ps.setString(2, id);
            int rs = ps.executeUpdate();

            conn.close();
            }
            
        catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    
    public void save(Materasso m){
        
        try{
            Connection conn = DriverManager.getConnection(connectionString, "simone_deidda", "65075");
            String query = "INSERT INTO letto (id, nome, idMaterasso, url, descrizione, dettagli, disponibili, prezzo) VALUES (default, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, m.getNome());
            ps.setString(2, m.getId());
            ps.setString(3, m.getUrl());
            ps.setString(4, m.getDescrizione());
            ps.setString(5, m.getDettagli());
            ps.setInt(6, m.getDisponibili());
            ps.setDouble(7, m.getPrezzo());
            int rs = ps.executeUpdate();

            conn.close();
            }
            
        catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    
    public Materasso find(String id){
        try{
            Connection conn = DriverManager.getConnection(connectionString, "simone_deidda", "65075");
            
            String query = "select * from letto where idMaterasso = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                Materasso m = new Materasso();
                m.setUrl(rs.getString("url"));
                m.setId(rs.getString("idMaterasso"));
                m.setNome(rs.getString("nome"));
                m.setDescrizione(rs.getString("descrizione"));
                m.setDettagli(rs.getString("dettagli"));
                m.setDisponibili(rs.getInt("disponibili"));
                m.setPrezzo(rs.getDouble("prezzo"));
                
                return m;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public void setConnectionString(String s){
    this.connectionString = s;
    }

    public String getConnectionString(){
    return this.connectionString;
    }
}
