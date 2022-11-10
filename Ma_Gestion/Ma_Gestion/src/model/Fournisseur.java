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

public class Fournisseur {
     public int N_four;
   public String nom_prenom;
   public String telephone ;
   public String adresse;
    public String ville;

    public Fournisseur(String nom_prenom, String telephone, String adresse, String ville) {
        this.nom_prenom = nom_prenom;
        this.telephone = telephone;
        this.adresse = adresse;
        this.ville = ville;
    }

    public Fournisseur(int N_four, String nom_prenom, String telephone, String adresse, String ville) {
        this.N_four = N_four;
        this.nom_prenom = nom_prenom;
        this.telephone = telephone;
        this.adresse = adresse;
        this.ville = ville;
    }

    public int getN_four() {
        return N_four;
    }

    public String getNom_prenom() {
        return nom_prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getVille() {
        return ville;
    }
     
    
}  
