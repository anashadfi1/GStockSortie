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
public class Client {
    private int id;
    private String nom;
    private String tel;
    private String email;

    public Client(String nom, String tel, String email) {
        this.nom = nom;
        this.tel = tel;
        this.email = email;
    }
    public Client(int id,String nom, String tel, String email) {
        this.id = id;
        this.nom = nom;
        this.tel = tel;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", nom=" + nom + ", tel=" + tel + ", email=" + email + '}';
    }
    
    
}
