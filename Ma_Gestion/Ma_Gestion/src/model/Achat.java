/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
/**
 * 
 * @author PC
 */

public class Achat {
     public int	N_achat;
    public String nom_fourn;
   public String designation;
    public  int quantité ;	
    public	double prix_total ;	 
 	public double prix_unitaire ;
     public   String date_achat;

    public Achat(int	N_achat,String nom_fourn, String designation, int quantité, double prix_total, double prix_unitaire,String date) {
        this.N_achat=N_achat;
        this.nom_fourn = nom_fourn;
        this.designation = designation;
        this.quantité = quantité;
        this.prix_total = prix_total;
        this.prix_unitaire = prix_unitaire;
        this.date_achat = date;
        
    }

    public int getN_achat() {
        return N_achat;
    }

    public String getNom_fourn() {
        return nom_fourn;
    }

    public String getDesignation() {
        return designation;
    }

    public int getQuantité() {
        return quantité;
    }

    public double getPrix_total() {
        return prix_total;
    }

    public double getPrix_unitaire() {
        return prix_unitaire;
    }

    public String getDate_achat() {
        return date_achat;
    }
        
}
