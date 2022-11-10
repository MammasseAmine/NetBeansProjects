
package MiniProjet;


public class Catégorie {
    private int NumCateg;
    private String Libellé;

    public Catégorie(int NumCateg, String Libellé) {
        this.NumCateg = NumCateg;
        this.Libellé = Libellé;
    }

    public int getNumCateg() {
        return NumCateg;
    }

    public void setNumCateg(int NumCateg) {
        this.NumCateg = NumCateg;
    }

    public String getLibellé() {
        return Libellé;
    }

    public void setLibellé(String Libellé) {
        this.Libellé = Libellé;
    }
    
    
}
