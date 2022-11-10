
package MiniProjet;

import java.util.ArrayList;


public class Livres {
    private String ISBN;
    private ArrayList<Integer> NumCateg = new ArrayList<Integer>();
    private String NomAuteur;
    private String NomEditeur;
    private byte NbreExemplaire;

    public Livres(String ISBN, String NomAuteur, String NomEditeur, byte NbreExemplaire) {
        this.ISBN = ISBN;
        this.NomAuteur = NomAuteur;
        this.NomEditeur = NomEditeur;
        this.NbreExemplaire = NbreExemplaire;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public ArrayList<Integer> getNumCateg() {
        return NumCateg;
    }

    public void setNumCateg(ArrayList<Integer> NumCateg) {
        this.NumCateg = NumCateg;
    }

    public String getNomAuteur() {
        return NomAuteur;
    }

    public void setNomAuteur(String NomAuteur) {
        this.NomAuteur = NomAuteur;
    }

    public String getNomEditeur() {
        return NomEditeur;
    }

    public void setNomEditeur(String NomEditeur) {
        this.NomEditeur = NomEditeur;
    }

    public byte getNbreExemplaire() {
        return NbreExemplaire;
    }

    public void setNbreExemplaire(byte NbreExemplaire) {
        this.NbreExemplaire = NbreExemplaire;
    }
    
    
     
}
