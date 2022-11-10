package MiniProjet;

public class Lectures {
   private int NumLecture;
   private String NomLecture, AdresseLecture;

    public Lectures(int NumLecture, String NomLecture, String AdresseLecture) {
        this.NumLecture = NumLecture;
        this.NomLecture = NomLecture;
        this.AdresseLecture = AdresseLecture;
    }
   

   

    public int getNumLecture() {
        return NumLecture;
    }

    public void setNumLecture(int NumLecture) {
        this.NumLecture = NumLecture;
    }

    public String getNomLecture() {
        return NomLecture;
    }

    public void setNomLecture(String NomLecture) {
        this.NomLecture = NomLecture;
    }

    public String getAdresseLecture() {
        return AdresseLecture;
    }

    public void setAdresseLecture(String AdresseLecture) {
        this.AdresseLecture = AdresseLecture;
    }

}
