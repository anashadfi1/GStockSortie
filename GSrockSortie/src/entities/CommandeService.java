/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author anass
 */


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.iDao;
import java.sql.Date;
public class CommandeService implements iDao<Commande> {
    private CommandeService cs ;

    
    public CommandeService() {
       
    }

    @Override
    public boolean create(Commande c) {

        try {
            String req = "insert into Commande values (?, ?,?)";
            PreparedStatement cs = Connexion.getConnection().prepareStatement(req);
            
            cs.setString(1, c.getCode());
            if (cs.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;

    }

   
    
    @Override
    public boolean delete(Commande c) {
        try {
            String req = "delete from Commande where id  =?";
            PreparedStatement cs = Connexion.getConnection().prepareStatement(req);
            cs.setInt(1, c.getId());
            if (cs.executeUpdate() == 1) {
                System.out.println("please work");
                return true;
                
                     
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;}
   
    
    

    
    @Override
    public boolean update(Commande c) {
         try {
            String req = "update Commande set code =?, idClient = ? where id = ?";
            PreparedStatement cs = Connexion.getConnection().prepareStatement(req);
            cs.setString(1, c.getCode());
            cs.setInt(3,c.getIdClient());
            cs.setInt(4,c.getId());
            if (cs.executeUpdate() == 1) {
                System.out.println("please work");
                return true;
                
                     
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;}

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Commande findById(int id) {
        Commande c = null;
        try {
            String sql = "select * from Commande where id = " + id;
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                //à corriger
                return new Commande(rs.getInt("id"),rs.getString("code"),rs.getInt("idClient"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;}
    
   
    
    @Override
    public List<Commande> findAll() {
        List<Commande> cmd = new ArrayList<Commande>();
        try {
            String sql = "select * from Commande";
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                //à corriger
                cmd.add(new Commande(rs.getInt("id"),rs.getString("code"),rs.getInt("idClient")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cmd;}

}
