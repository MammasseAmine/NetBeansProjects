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
public class Vente {

    int N_vente;
    String marchandise;
    float prix_a_payer;
    float benefice;
    String date;

    public Vente(int N_vente,String marchandise, float prix_a_payer, float benefice, String date) {
        this.N_vente = N_vente;
        this.marchandise = marchandise;
        this.prix_a_payer = prix_a_payer;
        this.benefice = benefice;
        this.date = date;
    }

    public int getN_vente() {
        return N_vente;
    }

    
    public String getMarchandise() {
        return marchandise;
    }

    public float getPrix_a_payer() {
        return prix_a_payer;
    }

    public float getBenefice() {
        return benefice;
    }

    public String getDate() {
        return date;
    }
    

}