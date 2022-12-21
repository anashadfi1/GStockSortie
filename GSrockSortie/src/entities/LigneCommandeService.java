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


public class LigneCommandeService implements iDao<LigneCommande> {
    private LigneCommandeService lcs ;
    
    
    public LigneCommandeService() {
       
    }

    @Override
    public boolean create(LigneCommande l) {

        try {
            String req = "insert into LigneCommande values (id, nom, tel , email)";
            PreparedStatement cs = Connexion.getConnection().prepareStatement(req);
            
            cs.setInt(1, l.getIdCommande());
            cs.setInt(2, l.getIdProduit());
            cs.setDouble(3, l.getPrixVente());
            cs.setInt(4, l.getQte());
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
    public boolean delete(LigneCommande l) {
            try {
            String req = "delete from Commande where id  = c.getId(), code = c.getCode()";
            PreparedStatement cs = Connexion.getConnection().prepareStatement(req);
            
            cs.setInt(1, l.getIdCommande());
            cs.setInt(2, l.getIdProduit());
            cs.setDouble(3, l.getPrixVente());
            cs.setInt(4, l.getQte());
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
    public boolean update(LigneCommande l) {
         try {
            String req = "update Commande set id  = c.getId(), code = c.getCode()";
            PreparedStatement cs = Connexion.getConnection().prepareStatement(req);
            
            cs.setInt(1, l.getIdCommande());
            cs.setInt(2, l.getIdProduit());
            cs.setDouble(3, l.getPrixVente());
            cs.setInt(4, l.getQte());
            if (cs.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;

   
        }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public LigneCommande findById(int id) {
        LigneCommande l = null;
        try {
            String sql = "select * from Commande where id = " + id;
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                //à corriger
                return new LigneCommande(rs.getInt("idCommande"),rs.getInt("idProduit"),rs.getDouble("prixVente"),rs.getInt("Qte"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;}
    
   
    
    @Override
    public List<LigneCommande> findAll() {
        List<LigneCommande> cmd = new ArrayList<LigneCommande>();
        try {
            String sql = "select * from LigneCommande";
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                //à corriger
                cmd.add(new LigneCommande(rs.getInt("idCommande"),rs.getInt("idProduit"),rs.getDouble("prixVente"),rs.getInt("Qte")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cmd;}

}

