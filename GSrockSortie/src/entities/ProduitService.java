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

public class ProduitService implements iDao<Produit> {

    private ProduitService pds ;

    
    public ProduitService() {
       
    }

    @Override
    public boolean create(Produit p) {

        try {
            String req = "insert into testing values (null, ?, ? , ? , ?, ?)";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, p.getDesignation());
            ps.setDouble(2, p.getPrixAchat());
            ps.setInt(3, p.getIdRayon());
            ps.setInt(4, p.getIdCategorie());
            ps.setDouble(5, p.getTVA());
            ps.setInt(6, p.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;

    }

   
    
    @Override
    public boolean delete(Produit p) {
        try {
            String req = "delete from testing where id  = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, p.getId());
            if (ps.executeUpdate() == 1) {
                System.out.println("please work");
                return true;
                
                     
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;}
   
    
    

    
    @Override
    public boolean update(Produit p) {
        try {
            String req = "update testing set designation = ? , prixAchat = ?, idRayon = ?, idCategorie = ?, TVA = ? where id = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            
            ps.setString(1, p.getDesignation());
            ps.setDouble(2, p.getPrixAchat());
            ps.setInt(3, p.getIdRayon());
            ps.setInt(4, p.getIdCategorie());
            ps.setDouble(5, p.getTVA());
            ps.setInt(6, p.getId());
            if (ps.executeUpdate() == 1) {
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
    public Produit findById(int id) {
        Produit produit = null;
        try {
            String sql = "select * from testing where id = " + id;
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                //à corriger
                return new Produit(rs.getString("Designation"),rs.getDouble("prixAchat"),
                        rs.getInt("idRayon"),rs.getInt("idCategorie"),rs.getDouble("TVA"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;}
    
   
    
    @Override
    public List<Produit> findAll() {
        List<Produit> produits = new ArrayList<Produit>();
        try {
            String sql = "select * from testing";
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                //à corriger
                produits.add(new Produit(rs.getString("Designation"), rs.getDouble("prixAchat"),
                        rs.getInt("idRayon"),rs.getInt("idCategorie"),rs.getDouble("TVA")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produits;}
    
    

    
}