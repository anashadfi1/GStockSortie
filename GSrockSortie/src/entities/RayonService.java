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
import entities.Produit;
public class RayonService implements iDao<Rayon> {
    private RayonService rs ;

    
    public RayonService() {
       
    }

    @Override
    public boolean create(Rayon r) {

        try {
            String req = "insert into Rayon values (id, codeRayon)";
            PreparedStatement cs = Connexion.getConnection().prepareStatement(req);
            cs.setInt(1, r.getId());
            cs.setString(1, r.getCodeRayon());
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
    public boolean delete(Rayon r) {
        try {
            String req = "delete from Commande where id  = c.getId(), code = c.getCode()";
            PreparedStatement rs = Connexion.getConnection().prepareStatement(req);
            rs.setInt(1, r.getId());
            rs.setString(1, r.getCodeRayon());
            if (rs.executeUpdate() == 1) {
                System.out.println("please work");
                return true;
                
                     
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;}
   
    
    

    
    @Override
    public boolean update(Rayon r) {
         try {
            String req = "update Commande set id  = c.getId(), code = c.getCode()";
            PreparedStatement rs = Connexion.getConnection().prepareStatement(req);
            rs.setInt(1, r.getId());
            rs.setString(1, r.getCodeRayon());
            if (rs.executeUpdate() == 1) {
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
    public Rayon findById(int id) {
        Rayon r = null;
        try {
            String sql = "select * from Rayon where id = " + id;
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                //à corriger
                return new Rayon(rs.getString("codeRayon"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;}
    
   
    
    @Override
    public List<Rayon> findAll() {
        List<Rayon> cmd = new ArrayList<Rayon>();
        try {
            String sql = "select * from Commande";
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                //à corriger
                cmd.add(new Rayon(rs.getString("codeRayon")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cmd;}

}

