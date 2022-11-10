
package dateinjavatomysql;

import java.sql.*;
public class connexion {
    
    Statement stmt;

    public connexion() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dateinjavatomysql","root","");
            
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Statement createStatement() {
        return stmt; 
    }
    
    
    
}
