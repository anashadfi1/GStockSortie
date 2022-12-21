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
import entities.Client;

public class ClientService implements iDao<Client> {

    private ClientService cs ;

    
    public ClientService() {
       
    }

    @Override
    public boolean create(Client c) {

        try {
            String req = "insert into Client values (null,?,?,?)";
            PreparedStatement CS1 = Connexion.getConnection().prepareStatement(req);
            CS1.setString(1, c.getNom());
            CS1.setString(2, c.getTel());
            CS1.setString(3, c.getEmail());
            if (CS1.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;

    }

   
    
    @Override
    public boolean delete(Client c) {
        try {
            String req = "delete from Client where id  = ? ";
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
    public boolean update(Client c) {
        try {
            String req;
            req = "update Client set  nom = ?, telephone = ?, email =? where id= ?";
            PreparedStatement cs = Connexion.getConnection().prepareStatement(req);
            cs.setString(1, c.getNom());
            cs.setString(2, c.getTel());
            cs.setString(3, c.getEmail());
            cs.setInt(4, c.getId());
            if (cs.executeUpdate() == 1) {
                System.out.println("Succesfully updated");
                return true;
            }
            else
                System.out.println("Not Updated !!!!!!!!");

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
    public Client findById(int id) {
        try {
            String sql = "select * from Client where id = " + id;
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                //à corriger
                return new Client(rs.getInt("id"),rs.getString("nom"),
                        rs.getString("telephone"),rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;}
    
   
    
    @Override
    public List<Client> findAll() {
        List<Client> clt = new ArrayList<Client>();
        try {
            String sql = "select * from Client";
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                //à corriger
                clt.add(new Client(rs.getInt("id"),rs.getString("nom"),
                        rs.getString("telephone"),rs.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clt;}
}
   /* @Override
    public boolean create(Client o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Client o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Client o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Client findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Client> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
*/
    
