/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package mysqlproba;
import java.sql.*;
/**
 *
 * @author Kudesnik
 */
public class MySQLproba {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */

    
    public static void main(String[] args)  throws SQLException{
        // TODO code application logic here
            Connection myConn = null;
            Statement myStatement = null;
            ResultSet myResultSet = null;
            String user = "root";
            String pass = "Kasutaja1neW!";

        
        //DBclass myDBClass = new DBclass();
        
        try {
            //1. Get connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", user,pass);
            
            //2. Create a statement
            myStatement=myConn.createStatement();
            
            //3. Execute SQL query
            myResultSet=myStatement.executeQuery("SELECT * FROM city;");
            
            //4.Process result set
            while (myResultSet.next()) {                
                System.out.println(myResultSet.getString("city"));
                
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            if (myResultSet!=null) {
                myResultSet.close();
            }
            if (myStatement!=null) {
                myStatement.close();
            }
            if (myConn!=null) {
                myConn.close();
            }
            
        }
        
    }
    
}
