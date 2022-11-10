/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;





import model.Achat;
import model.Fournisseur;
import model.Stock;
import model.Utilisateur;
import model.Vente;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author PC
 */
public class ConnectDB {

    private final String User = "root";
    private final String password = "";
    String ipLocal = "localhost";

    private String url = "jdbc:mysql://" + ipLocal + ":3306/gestionmag";
    private Connection cnx;
    private Statement st, jt;
    private ResultSet rst;
    
    

    public void DeleteAllElementTab(JTable T, int column, int row) {
        int i = 0;
        int j = 0;
        while (i < row) {
            while (j <= column) {
                T.setValueAt("", i, j);
                j++;
            }
            j = 0;
            i++;
        }

    }

    public String showDate() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(" YYYY-MM-dd");
        return sdf.format(d);

    }

    public String showDateTime() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
        return sdf.format(d);

    }

    public void ConnexionIntoDataBase() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver OK");
            try {
                cnx = DriverManager.getConnection(url, User, password);
                System.out.println("successful connexion");
            } catch (SQLException ex) {
                Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, " erreur de connexion activer le serveur ou verifier "
                        + "\nla configuration du serveur");

            } finally {
                exit();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   public int FindUser(String user, String pass) {
        int re=0;
    try {
    st=cnx.createStatement();
    String sql="SELECT * FROM user";
    rst=(ResultSet) st.executeQuery(sql);
    while(rst.next()){
    if (rst.getString("username").equals(user) && rst.getString("password").equals(pass)){
    
        if(rst.getString("type").equals("Vendeur")){
    
         re=2;
    
    }else{
        if(rst.getString("type").equals("Gérant")){
      
    
          re=1;
      }
    
    }
    
    
    }
    
    
    
    }}catch(Exception e ){
    
    
    }
    
    
    return re;
    
    }
   
   //**************************************
   public void FindUserSearch(JTable T ,String user,String recherche) {
    try {
    st = cnx.createStatement();
            String sql = "SELECT * FROM user WHERE " + user + " like '" + recherche + "%'  ";
            rst = (ResultSet) st.executeQuery(sql);
            int i = 0, j;
            while (rst.next()) {
                j = 0;
                T.setValueAt(rst.getInt("id_user"), i, j);
                j++;
                T.setValueAt(rst.getString("username").toString(), i, j);
                j++;
                T.setValueAt(rst.getString("password").toString(), i, j);
                j++;
                T.setValueAt(rst.getString("type").toString(), i, j);
                j++;
                i++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " erreur de recuperation");
        }
    }
   
   //**************************************************
    
    public void UpdateUser(int id,Utilisateur ut) {

        try {
            String sql = "Update user set username='" + ut.username + "',password='" + ut.password+"',"
                    +"type='"+ut.type +"'"+"where id_user="+id;

            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }

    public void insertFournisseur(Fournisseur Fourn) {

        try {
            st = cnx.createStatement();
            
            String sql1 = "INSERT INTO `fournisseur`( `nom_prenom`, `N_telephone`, `Adresse`,`Ville`) "
                    + "VALUES ('" + Fourn.nom_prenom + "'," + "'" + Fourn.telephone + "','" + Fourn.adresse + "','" + Fourn.ville + "')";
            st.executeUpdate(sql1);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "erreur operation");
            exit();
        }

    }
    public void insertUser(Utilisateur Usern){
        try{ 

            st=cnx.createStatement();    
            
            
       if(FindUser(Usern.username, Usern.password)==0){
   String sql1 = "INSERT INTO `user`( username,password,type) "
                    + "VALUES ('" + Usern.username+ "','" + Usern.password + "','" + Usern.type + "')"; 
       
       st.executeUpdate(sql1);
       }else{ JOptionPane.showMessageDialog(null, "L'utilisateur existe déja");
       }
       
        }
       
        
    catch(SQLException ex){
     Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "erreur operation");
            exit();
    }}
    

    public void AllUser(JTable T){
    try {
        st=cnx.createStatement();
        String sql="select * from user";
        rst=(ResultSet) st.executeQuery(sql);
        int i=0,j;
        while(rst.next()){
        
        j = 0;
                T.setValueAt(rst.getInt("id_user"), i, j);
                j++;
                T.setValueAt(rst.getString("username").toString(), i, j);
                j++;
                T.setValueAt(rst.getString("password").toString(), i, j);
                j++;
                T.setValueAt(rst.getString("type").toString(), i, j);
                j++;
                i++;

        }
    } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " erreur de recuperation");
        }}

    public void AllFournisseur(JTable T) {
        try {
            st = cnx.createStatement();
            String sql = "select * from fournisseur";
            rst = (ResultSet) st.executeQuery(sql);
            int i = 0, j;

            while (rst.next()) {
                j = 0;
                T.setValueAt(rst.getInt("N_Fourn"), i, j);
                j++;
                T.setValueAt(rst.getString("nom_prenom").toString(), i, j);
                j++;
                T.setValueAt(rst.getString("N_telephone").toString(), i, j);
                j++;
                T.setValueAt(rst.getString("Adresse").toString(), i, j);
                j++;
                T.setValueAt(rst.getString("Ville").toString(), i, j);
                j++;
                i++;

            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " erreur de recuperation");
        }
    }

   public void DeleteUser(int id ){
       
       
   String sql="DELETE FROM user WHERE id_user="+id;
   try{
       if(id!=1){
       st.executeUpdate(sql);}
       else{
       JOptionPane.showMessageDialog(null,"Impossible de supprimer cet utilisateur");
       }
   } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
   
   }
    public void DeleteFourn(int id) {
        String sql = "DELETE FROM fournisseur WHERE N_Fourn=" + id;
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void UpdateFourn(int id, Fournisseur fr) {

        try { st = cnx.createStatement();
            String sql = "Update fournisseur set nom_prenom='" + fr.nom_prenom + "',N_telephone='" + fr.telephone + "',"
                    + "Adresse='" + fr.adresse + "'" + ",Ville='" + fr.ville + "'"
                    + " where N_Fourn=" + id;
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

   

   

    public void Findfournisseur(JTable T, String word, String recherche) {
        try {
            st = cnx.createStatement();
            String sql = "SELECT * FROM fournisseur WHERE " + word + " like '" + recherche + "%'  ";
            rst = (ResultSet) st.executeQuery(sql);
            int i = 0, j;
            while (rst.next()) {
                j = 0;
                T.setValueAt(rst.getInt("N_Fourn"), i, j);
                j++;
                T.setValueAt(rst.getString("nom_prenom").toString(), i, j);
                j++;
                T.setValueAt(rst.getString("N_telephone").toString(), i, j);
                j++;
                T.setValueAt(rst.getString("Adresse").toString(), i, j);
                j++;
                T.setValueAt(rst.getString("Ville").toString(), i, j);
                j++;
                i++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " erreur de recuperation");
        }
    }

    public void FindNomFourn(JComboBox combo) {
        try {
            st = cnx.createStatement();
            String sql = "select nom_prenom  from fournisseur";
            rst = (ResultSet) st.executeQuery(sql);
            ArrayList<String> ar = new ArrayList<>();
            ArrayList<String> rpl = new ArrayList<>();

            while (rst.next()) {

                ar.add(rst.getString("nom_prenom").toString());
            }
            rpl = Rplace(ar);
            for (int i = 0; i < rpl.size(); i++) {
                combo.addItem(rpl.get(i));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " erreur de recuperation");
        }

    }

    public float AllAchat(JTable T) {
        float f = 0;
        try {
            ArrayList<Achat> list = new ArrayList<Achat>();
            st = cnx.createStatement();
            String sql = "select * from achat";
            rst = (ResultSet) st.executeQuery(sql);
            //int i=0,j;
            while (rst.next()) {
                f = rst.getFloat("prix_total") + f;

                Achat ach = new Achat(rst.getInt("N_achat"), rst.getString("nom_fourn"), rst.getString("designation"), rst.getInt("quantite"),
                        rst.getFloat("prix_total"), rst.getFloat("prix_unitaire"),
                        rst.getDate("date_achat") + "");
                list.add(ach);
            }

            DefaultTableModel mo = (DefaultTableModel) T.getModel();
            mo.setRowCount(0);
            DecimalFormat df = new DecimalFormat("0.00");
            Object row[] = new Object[7];
            for (int k = 0; k < list.size(); k++) {
                row[0] = list.get(k).getN_achat();
                row[1] = list.get(k).getNom_fourn();
                row[2] = list.get(k).getDesignation();
                row[3] = list.get(k).getQuantité();
                row[4] = list.get(k).getPrix_total();
                row[5] = df.format(list.get(k).getPrix_unitaire());
                row[6] = list.get(k).getDate_achat();
                mo.addRow(row);
            }
            list.clear();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " erreur de recuperation");
        }
        return f;
    }

    public void insertAchat(Achat ach) {
        try {
            st = cnx.createStatement();
            String sql1 = "INSERT INTO `achat`( `nom_fourn`, `designation`, `quantite`"
                    + ", `prix_total`, `prix_unitaire`, `date_achat`)"
                    + "VALUES ('" + ach.nom_fourn + "'," + "'" + ach.designation + "','" + ach.quantité + "'"
                    + ",'" + ach.prix_total + "','" + ach.prix_total / ach.quantité + "','" + ach.date_achat + "') ";
            st.executeUpdate(sql1);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "erreur operation");
            exit();
        }
    }

    public void UpdateAchat(int id, Achat ach) {

        try {
            String sql = "Update achat set nom_fourn='" + ach.nom_fourn + "',designation='" + ach.designation + "',"
                    + "quantite='" + ach.quantité + "'" + ",prix_total='" + ach.prix_total + "',"
                    + "prix_unitaire='" + ach.prix_total / ach.quantité + "'"
                    + "where N_achat=" + id;
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void DeleteAchat(int id) {
        String sql = "DELETE FROM achat WHERE N_achat=" + id;
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void FindAchat(JTable T, String word, String recherche, JLabel j1, JLabel j2) {
        int qte = 0;
        float prixT = 0;
        try {
            ArrayList<Achat> list = new ArrayList<Achat>();
            st = cnx.createStatement();
            String sql = "SELECT * FROM achat WHERE " + word + " like '" + recherche + "%'  ";
            rst = (ResultSet) st.executeQuery(sql);

            while (rst.next()) {
                qte = qte + rst.getInt("quantite");

                prixT = prixT + rst.getFloat("prix_total");

                Achat ach = new Achat(rst.getInt("N_achat"), rst.getString("nom_fourn"), rst.getString("designation"), rst.getInt("quantite"),
                        rst.getFloat("prix_total"), rst.getFloat("prix_unitaire"),
                        rst.getDate("date_achat") + "");
                list.add(ach);
            }
            DefaultTableModel mo = (DefaultTableModel) T.getModel();
            DecimalFormat df = new DecimalFormat("0.00");
            mo.setRowCount(0);
            Object row[] = new Object[7];
            for (int k = 0; k < list.size(); k++) {
                row[0] = list.get(k).getN_achat();
                row[1] = list.get(k).getNom_fourn();
                row[2] = list.get(k).getDesignation();
                row[3] = list.get(k).getQuantité();
                row[4] = list.get(k).getPrix_total();
                row[5] = df.format(list.get(k).getPrix_unitaire());
                row[6] = list.get(k).getDate_achat();
                mo.addRow(row);
            }
            list.clear();
            j1.setText("qte totale " + qte);
            j2.setText("prix totale " + prixT);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " erreur de recuperation");
        }
    }

    public void FindAchatDate(JTable T, String d1, String d2, JLabel j1, JLabel j2) {
        int qte = 0;
        float prixT = 0;
        try {
            ArrayList<Achat> list = new ArrayList<Achat>();
            st = cnx.createStatement();
            String sql = "SELECT * FROM achat WHERE date_achat between'" + d1 + "' and '" + d2 + "'  ";
            rst = (ResultSet) st.executeQuery(sql);
            while (rst.next()) {
                qte = qte + rst.getInt("quantite");
                prixT = prixT + rst.getFloat("prix_total");
                Achat ach = new Achat(rst.getInt("N_achat"), rst.getString("nom_fourn"), rst.getString("designation"), rst.getInt("quantite"),
                        rst.getFloat("prix_total"), rst.getFloat("prix_unitaire"),
                        rst.getDate("date_achat") + "");
                list.add(ach);
            }
            DefaultTableModel mo = (DefaultTableModel) T.getModel();
            DecimalFormat df = new DecimalFormat("0.00");
            mo.setRowCount(0);
            Object row[] = new Object[7];
            for (int k = 0; k < list.size(); k++) {
                row[0] = list.get(k).getN_achat();
                row[1] = list.get(k).getNom_fourn();
                row[2] = list.get(k).getDesignation();
                row[3] = list.get(k).getQuantité();
                row[4] = list.get(k).getPrix_total();
                row[5] = df.format(list.get(k).getPrix_unitaire());
                row[6] = list.get(k).getDate_achat();
                mo.addRow(row);
            }
            list.clear();
            j1.setText("qte totale " + qte);
            j2.setText("prix totale " + prixT);

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " erreur de recuperation");
        }
    }

   

    public void FindPrixTotale(String s, JTextField jt) {
        try {
            st = cnx.prepareStatement(url);
            String sql = "SELECT sum(prix_total) FROM `achat` WHERE nom_fourn = '" + s + "'  ";
            st = cnx.prepareStatement(sql);
            rst = st.executeQuery(sql);
            if (rst.next()) {
                String f = rst.getString("sum(prix_total)");
                jt.setText(f + "");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " erreur de recuperation");
        }
    }

    

  

    public String FindPrixTotaleRESTE() {
        String f = "";
        try {
            st = cnx.prepareStatement(url);
            String sql = "SELECT sum(montant_reste) FROM `facture` WHERE etat = 'non servir'  ";
            st = cnx.prepareStatement(sql);
            rst = st.executeQuery(sql);
            if (rst.next()) {
                f = rst.getString("sum(montant_reste)");

            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " erreur de recuperation");
        }
        return f;
    }

    public void FindDesignation(JComboBox combo) {
        try {
            st = cnx.createStatement();
            String sql = "select designation  from achat";
            rst = (ResultSet) st.executeQuery(sql);
            ArrayList<String> ar = new ArrayList<>();
            ArrayList<String> rpl = new ArrayList<>();
            while (rst.next()) {
                ar.add(rst.getString("designation").toString());

            }
            rpl = Rplace(ar);
            for (int i = 0; i < rpl.size(); i++) {
                combo.addItem(rpl.get(i));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " erreur de recuperation");
        }

    }

    ArrayList<String> Rplace(ArrayList<String> ar) {
        ArrayList<String> rpl = new ArrayList<>();
        int K = 0;
        boolean test;
        while (K < ar.size()) {
            test = true;
            for (int i = 0; i < rpl.size(); i++) {
                if (ar.get(K).equals(rpl.get(i))) {
                    test = false;
                }
            }
            if (test) {
                rpl.add(ar.get(K));
            }
            K++;
        }

        return rpl;
    }

    public void FindQteTotal(String sql, String sql1, JTextField jt) {
        try {
            st = cnx.prepareStatement(url);

            st = cnx.prepareStatement(sql);
            rst = st.executeQuery(sql);
            //  DecimalFormat df=new DecimalFormat("0.00");
            if (rst.next()) {

                float f = rst.getFloat(sql1);
                jt.setText(/*df.format(*/f/*)*/ + "");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " erreur de recuperation");
        }
    }
    ArrayList<String> DES = new ArrayList<>();

    public void AllStock(JTable T) {

        try {
            ArrayList<Stock> list = new ArrayList<Stock>();
            st = cnx.createStatement();
            String sql = "select * from stock";
            rst = (ResultSet) st.executeQuery(sql);
            DES.clear();
            while (rst.next()) {

                Stock ST = new Stock(rst.getInt("N_prod"), rst.getString("designation"),
                        rst.getString("categorie"), rst.getString("unite"),
                        rst.getDate("date_exp") + "", rst.getInt("qte_totale"),
                        rst.getInt("qte_vente"), rst.getFloat("prix_vent"),
                        rst.getFloat("prix_unt")
                );
                list.add(ST);
            }

            DefaultTableModel mo = (DefaultTableModel) T.getModel();
            mo.setRowCount(0);
            DecimalFormat df = new DecimalFormat("0.00");
            Object row[] = new Object[11];
            for (int k = 0; k < list.size(); k++) {
                row[0] = list.get(k).getN_prod();
                row[1] = list.get(k).getDesignation();
                DES.add(list.get(k).getDesignation());
                row[2] = list.get(k).getCategorie();
                row[3] = list.get(k).getUnite();
                row[4] = list.get(k).getDate_exp();
                row[5] = df.format(list.get(k).getQte_totale());
                row[6] = list.get(k).getQte_vente();
                row[7] = list.get(k).getQte_reste();
                row[8] = /*df.format(*/ list.get(k).getPrix_unt()/*)*/;
                row[9] = list.get(k).getPrix_vent();
                row[10] = list.get(k).getGain();

                mo.addRow(row);
            }
            list.clear();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " erreur de recuperation");
        }
    }

    public ArrayList<String> CONTROLE() {

        ArrayList<String> rpl = new ArrayList<>();
        ArrayList<String> rpl1 = new ArrayList<>();
        int K = 0;
        boolean test;
        while (K < DES.size()) {
            test = true;
            for (int i = 0; i < rpl.size(); i++) {
                if (DES.get(K).equals(rpl.get(i))) {
                    test = false;
                }
            }
            if (test) {
                rpl.add(DES.get(K));
            }
            if (test == false) {
                rpl1.add(DES.get(K));
            }
            K++;
        }

        return rpl1;
    }

    public ArrayList<String> CONTROLE2(JComboBox com) {

        ArrayList<String> rpl = new ArrayList<>();

        int K = 0;
        boolean test;
        while (K < com.getItemCount()) {
            test = true;
            for (int i = 0; i < DES.size(); i++) {
                if (com.getItemAt(K).toString().equals(DES.get(i))) {
                    test = false;
                }
            }
            if (test) {
                rpl.add((String) com.getItemAt(K));
            }
            K++;
        }

        return rpl;
    }

    public void insertStock(Stock ST, int s) {

        try {
            System.out.println(ST.getDesignation() + " " + ST.getCategorie()
                    + " " + ST.getUnite() + " " + ST.getDate_exp() + " HH" + ST.getQte_totale()
                    + " " + ST.getQte_vente() + " " + ST.getQte_reste() + " " + " " + ST.getPrix_unt()
                    + " " + ST.getPrix_vent() + " " + ST.getGain());
            st = cnx.createStatement();
            String sql;
            if (s == 1) {
                sql = "INSERT INTO stock(  designation, categorie,unite,"
                        + "date_exp,qte_totale,qte_vente,qte_reste,prix_unt,"
                        + "prix_vent,gain) "
                        + "VALUES ('" + ST.getDesignation() + "'," + "'" + ST.getCategorie()
                        + "','" + ST.getUnite() + "','" + ST.getDate_exp()
                        + "','" + ST.getQte_totale() + "','" + ST.getQte_vente() + "','" + ST.getQte_reste()
                        + "','" + ST.getPrix_unt() + "','" + ST.getPrix_vent() + "','" + ST.getGain() + "') ";
            } else {
                sql = "INSERT INTO stock(  designation, categorie,unite,"
                        + "qte_totale,qte_vente,qte_reste,prix_unt,"
                        + "prix_vent,gain) "
                        + "VALUES ('" + ST.getDesignation() + "'," + "'" + ST.getCategorie()
                        + "','" + ST.getUnite() + "'"
                        + ",'" + ST.getQte_totale() + "','" + ST.getQte_vente() + "','" + ST.getQte_reste()
                        + "','" + ST.getPrix_unt() + "','" + ST.getPrix_vent() + "','" + ST.getGain() + "') ";
            }
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "erreur operation");
            exit();
        }

    }

    public void DeleteStock(int id) {
        String sql = "DELETE FROM stock WHERE N_prod=" + id;
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void UpdateStock(String sql) {

        try {

            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void FindStock(JTable T, String sql) {

        try {
            ArrayList<Stock> list = new ArrayList<Stock>();
            st = cnx.createStatement();

            rst = (ResultSet) st.executeQuery(sql);
            while (rst.next()) {

                Stock ST = new Stock(rst.getInt("N_prod"), rst.getString("designation"),
                        rst.getString("categorie"), rst.getString("unite"),
                        rst.getDate("date_exp") + "", rst.getInt("qte_totale"),
                        rst.getInt("qte_vente"), rst.getFloat("prix_vent"),
                        rst.getFloat("prix_unt")
                );
                list.add(ST);
            }

            DefaultTableModel mo = (DefaultTableModel) T.getModel();
            mo.setRowCount(0);
            DecimalFormat df = new DecimalFormat("0.00");
            Object row[] = new Object[11];
            for (int k = 0; k < list.size(); k++) {
                row[0] = list.get(k).getN_prod();
                row[1] = list.get(k).getDesignation();

                row[2] = list.get(k).getCategorie();
                row[3] = list.get(k).getUnite();
                row[4] = list.get(k).getDate_exp();
                row[5] = df.format(list.get(k).getQte_totale());
                row[6] = list.get(k).getQte_vente();
                row[7] = list.get(k).getQte_reste();
                row[8] = /*df.format(*/ list.get(k).getPrix_unt()/*)*/;
                row[9] = list.get(k).getPrix_vent();
                row[10] = list.get(k).getGain();

                mo.addRow(row);
            }
            list.clear();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " erreur de recuperation");
        }
    }

    public void AllStockVente(JTable T) {

        try {
            ArrayList<Stock> list = new ArrayList<Stock>();
            st = cnx.createStatement();
            String sql = "select N_prod,designation,qte_totale,"
                    + " qte_vente,qte_reste,prix_vent,gain from stock";
            rst = (ResultSet) st.executeQuery(sql);
            DES.clear();
            while (rst.next()) {
                Stock ST = new Stock(rst.getInt("N_prod"), rst.getString("designation"),
                        rst.getInt("qte_totale"),
                        rst.getInt("qte_vente"), rst.getInt("qte_reste"),
                        rst.getFloat("prix_vent"), rst.getFloat("gain")
                );

                list.add(ST);
            }

            DefaultTableModel mo = (DefaultTableModel) T.getModel();
            mo.setRowCount(0);
            DecimalFormat df = new DecimalFormat("0.00");
            Object row[] = new Object[7];
            for (int k = 0; k < list.size(); k++) {
                row[0] = list.get(k).getN_prod();
                row[1] = list.get(k).getDesignation();

                row[2] = df.format(list.get(k).getQte_totale());
                row[3] = list.get(k).getQte_vente();
                row[4] = list.get(k).getQte_reste();

                row[5] = list.get(k).getPrix_vent();
                row[6] = list.get(k).getGain();

                mo.addRow(row);
            }
            list.clear();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " erreur de recuperation");
        }
    }

    public void AllStockVenteRcherche(JTable T, String S) {

        try {
            ArrayList<Stock> list = new ArrayList<Stock>();
            st = cnx.createStatement();
            String sql = "select N_prod,designation,qte_totale,"
                    + " qte_vente,qte_reste,prix_vent,prix_unt,gain from stock where "
                    + "designation like '" + S + "%'";
            rst = (ResultSet) st.executeQuery(sql);
            DES.clear();
            while (rst.next()) {

                Stock ST = new Stock(rst.getInt("N_prod"), rst.getString("designation"),
                        rst.getInt("qte_totale"),
                        rst.getInt("qte_vente"), rst.getInt("qte_reste"),
                        rst.getFloat("prix_vent"), rst.getFloat("gain")
                );
                list.add(ST);
            }

            DefaultTableModel mo = (DefaultTableModel) T.getModel();
            mo.setRowCount(0);
            DecimalFormat df = new DecimalFormat("0.00");
            Object row[] = new Object[7];
            for (int k = 0; k < list.size(); k++) {
                row[0] = list.get(k).getN_prod();
                row[1] = list.get(k).getDesignation();

                row[2] = df.format(list.get(k).getQte_totale());
                row[3] = list.get(k).getQte_vente();
                row[4] = list.get(k).getQte_reste();

                row[5] = list.get(k).getPrix_vent();
                row[6] = list.get(k).getGain();

                mo.addRow(row);
            }
            list.clear();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " erreur de recuperation");
        }
    }
    public void UpdateQteResteMinus( int id,int qte) {
        try {
            st = cnx.prepareStatement(url);
            String sql = "SELECT qte_totale,qte_vente FROM `stock` WHERE N_prod = " + id + "  ";
            st = cnx.prepareStatement(sql);
            rst = st.executeQuery(sql);
            if (rst.next()) {
                int totale = rst.getInt("qte_totale");
                int vente = rst.getInt("qte_vente")+qte;
                
                String sql2 = "Update stock set qte_vente='" + vente + "',qte_reste='" 
                        + (totale-vente) + "'"
                    + "where N_prod="+id;

            st.executeUpdate(sql2);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " erreur de recuperation");
        }
    }
    public void UpdateQteResteAdd( String des,int qte) {
        try {
            st = cnx.prepareStatement(url);
            String sql = "select Qte_reste,qte_vente,designation FROM `stock` WHERE designation = '" + des + "'  ";
            st = cnx.prepareStatement(sql);
            rst = st.executeQuery(sql);
            if (rst.next()) {
                int vente = rst.getInt("qte_vente")-qte;
                int reste = rst.getInt("Qte_reste")+qte;
                
                String sql2 = "Update stock set qte_vente='" + vente + "',qte_reste='" 
                        + reste + "'"
                    + "where designation='"+des+"'";

            st.executeUpdate(sql2);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " erreur de recuperation");
        }
    }
     
      public void insertVente(Vente V) {

        try {
            st = cnx.createStatement();
            String sql1 = "INSERT INTO vente(marchandise,prix_a_payer,benefice,date_vente) "
                    + "VALUES ('" + V.getMarchandise() + "','" + V.getPrix_a_payer()
                    + "','"+V.getBenefice()+"','"+V.getDate()+"')";
            st.executeUpdate(sql1);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "erreur operation");
            exit();
        }

    }
        public void AllVente(JTable T) {

        try {
            ArrayList<Vente> list = new ArrayList<Vente>();
            st = cnx.createStatement();
            String sql = "select * from vente";
            rst = (ResultSet) st.executeQuery(sql);
            
            while (rst.next()) {
String s="";s= rst.getDate("date_vente")+""+" " +rst.getTime("date_vente")+""; 
                Vente V = new Vente(rst.getInt("N_vente"), rst.getString("marchandise"),
                         rst.getFloat("prix_a_payer"),rst.getFloat("benefice"),
                  s  );
                list.add(V);
            }

            DefaultTableModel mo = (DefaultTableModel) T.getModel();
            mo.setRowCount(0);
            DecimalFormat df = new DecimalFormat("0.00");
            Object row[] = new Object[7];
            for (int k = 0; k < list.size(); k++) {
                row[0] = list.get(k).getN_vente();
                
                row[1] = list.get(k).getMarchandise();
             
                row[2] = df.format(list.get(k).getPrix_a_payer());
                row[3] = df.format(list.get(k).getBenefice());
                row[4] = /*df.format(*/ list.get(k).getDate()/*)*/;
                

                mo.addRow(row);
            }
           // list.clear();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " erreur de recuperation");
        }
    }
            public void FindVente(JTable T,String sql,JLabel j1,JLabel j2) {

        try {
            ArrayList<Vente> list = new ArrayList<Vente>();
            st = cnx.createStatement();
            
            rst = (ResultSet) st.executeQuery(sql);
           float prix=0,benefice=0;
            while (rst.next()) {
String s="";s= rst.getDate("date_vente")+""+" " +rst.getTime("date_vente")+""; 
                Vente V = new Vente(rst.getInt("N_vente"), rst.getString("marchandise"),
                         rst.getFloat("prix_a_payer"),rst.getFloat("benefice"),
                  s  );
                prix=prix+rst.getFloat("prix_a_payer");
                benefice=rst.getFloat("benefice")+benefice;
                      
                list.add(V);
            }

            DefaultTableModel mo = (DefaultTableModel) T.getModel();
            mo.setRowCount(0);
            DecimalFormat df = new DecimalFormat("0.00");
            Object row[] = new Object[7];
            for (int k = 0; k < list.size(); k++) {
                row[0] = list.get(k).getN_vente();
               
               
               
                row[1] = list.get(k).getMarchandise();
             
                row[2] = df.format(list.get(k).getPrix_a_payer());
                row[3] = df.format(list.get(k).getBenefice());
                row[4] = /*df.format(*/ list.get(k).getDate()/*)*/;
                

                mo.addRow(row);
            }
           j1.setText("prix V T: "+prix);
            j2.setText("bénifice: "+benefice);

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " erreur de recuperation");
        }
    }
           
             public void DeleteVente(int id) {
        String sql = "DELETE FROM vente WHERE  	N_vente=" + id;
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void exit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
             
   
}
