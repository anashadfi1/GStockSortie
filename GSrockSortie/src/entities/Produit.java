/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author diaed
 */
public class Produit {


	private int id;
	private String designation;
	private Double prixAchat;
	private int idRayon;
	private int idCategorie;
	
        private double TVA;
	private static int comp;

	public Produit(String designation, Double prixAchat, int idRayon, int idCategorie, double TVA) {
		this.designation = designation;
		this.prixAchat = prixAchat;
		this.idRayon = idRayon;
		this.idCategorie = idCategorie;
                this.TVA = TVA;
                
	}
	
	

	/*public Produit(int id, String reference, String marque, double prix, Date dateAchat, Salle salle) {
		this.id = id;
		this.reference = reference;
		this.marque = marque;
		this.prix = prix;
		this.dateAchat = dateAchat;
		this.salle = salle;
	}*/

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public Double getPrixAchat() {
            return prixAchat;
        }

        public void setPrixAchat(Double prixAchat) {
            this.prixAchat = prixAchat;
        }

        public int getIdRayon() {
            return idRayon;
        }

        public void setIdRayon(int idRayon) {
            this.idRayon = idRayon;
        }

        public int getIdCategorie() {
            return idCategorie;
        }

        public void setIdCategorie(int idCategorie) {
            this.idCategorie = idCategorie;
        }

        public double getTVA() {
            return TVA;
        }

        public void setTVA(double TVA) {
            this.TVA = TVA;
        }



	




	


	@Override
	public String toString() {
		return "Produit [id=" + id + ", Designation=" + designation + ", prixAchat=" + prixAchat + ", idRayon=" + idRayon
				+ ", idCategorie=" + idCategorie + ", TVA= "+TVA+ "]";
	}
	
	
}
