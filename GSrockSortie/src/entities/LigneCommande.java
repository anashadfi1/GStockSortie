/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;


public class LigneCommande {
    private int idCommande;
    private int idProduit;
    private double prixVente;
    private int Qte;

    public LigneCommande(int idCommande, int idProduit, double prixVente, int Qte) {
        this.idCommande = idCommande;
        this.idProduit = idProduit;
        this.prixVente = prixVente;
        this.Qte = Qte;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }

    public int getQte() {
        return Qte;
    }

    public void setQte(int Qte) {
        this.Qte = Qte;
    }
    
}
