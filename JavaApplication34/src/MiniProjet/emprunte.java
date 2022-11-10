package MiniProjet;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class emprunte {
    private int NumLecture;
    private String ISBN;
    Date dateemp,daterout;

    public emprunte(int NumLecture, String ISBN, Date dateemp, Date daterout) {
        this.NumLecture = NumLecture;
        this.ISBN = ISBN;
        this.dateemp = dateemp;
        this.daterout = daterout;
    }

    public int getNumLecture() {
        return NumLecture;
    }

    public void setNumLecture(int NumLecture) {
        this.NumLecture = NumLecture;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Date getDateemp() {
        return dateemp;
    }

    public void setDateemp(Date dateemp) {
        this.dateemp = dateemp;
    }

    public Date getdaterout() {
        return daterout;
    }

    public void setdaterout(Date Daterout) {
        this.daterout = Daterout;
    }
    
    public Date prolonger(){
        System.out.println("Pour quelle Date");
         Scanner sc = new Scanner(System.in);
         String string_date = sc.nextLine();
        SimpleDateFormat formatter =new SimpleDateFormat("yyyy/dd/MM");    
        try {
            daterout = formatter.parse(string_date);
        } catch (ParseException ex) {
            System.out.println("La date n'est pas valide");
        }
        return daterout;
    }
    
}
