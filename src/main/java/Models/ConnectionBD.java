package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Angel J Garcia Sandoval & David I Quime Montalvo
 */
public class ConnectionBD {

    private static Connection conn;
    private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String url = "jdbc:sqlserver://sql5059.site4now.net\\SQLEXPRESS:1433;databaseName=DB_A68F20_chambipa;"
                    + "user=DB_A68F20_chambipa_admin;password=raizdemenos1";
    
    public Connection getConexion()
    {
        conn = null;
        try
        {
            Class.forName(driver);
            conn = DriverManager.getConnection(url);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error al conectar" + e);
        }
        return conn;
    }
    
    //    public ConnectionBD() {
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            String connectionURL = "jdbc:sqlserver://sql5059.site4now.net\\SQLEXPRESS:1433;databaseName=DB_A68F20_chambipa;"
//                    + "user=DB_A68F20_chambipa_admin;password=raizdemenos1";
//            Connection con = DriverManager.getConnection(connectionURL);
//            System.out.println("Conectado");
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
