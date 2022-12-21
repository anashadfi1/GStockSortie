/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author anass
 */
public class Commande {
    private int id;
    private String Code;
    private int idClient;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return Code;
    }

    
    public void setCode(String Code) {
        this.Code = Code;
    }

    

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
    public Commande(int id, String Code,int idClient) {
        this.id = id;
        this.Code = Code;
        this.idClient = idClient;
    }
    

    public Commande(String Code,int idClient) {
        this.Code = Code;
        this.idClient = idClient;
    }
    
   
    
    
    

    
}
