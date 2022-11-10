
package datecomparision;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class connexion {
    Statement stmt;
    
    public connexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datecomparision","root","");
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
       
    }

    public Statement getStmt() {
        return stmt;
    }
   
}
