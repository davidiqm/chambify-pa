package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angel J Garcia Sandoval & David I Quime Montalvo
 */
public class ConnectionBD {
    
    public ConnectionBD() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionURL = "jdbc:sqlserver://sql5059.site4now.net\\SQLEXPRESS:1433;databaseName=DB_A68F20_chambipa;"
                    + "user=DB_A68F20_chambipa_admin;password=raizdemenos1";
            Connection con = DriverManager.getConnection(connectionURL);
            System.out.println("Conectado");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
