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
    private static String driver = "com.mysql.jdbc.Driver";
    private static String db = "u897177112_chambify_pa";
    public String url = "jdbc:mysql://92.249.44.52:3306/"+db;
    public static String user = "u897177112_admin";
    public static String password = "soyadminxD1";
    
    
//    private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//    private static final String url = "jdbc:sqlserver://sql5059.site4now.net\\SQLEXPRESS:1433;databaseName=DB_A68F20_chambipa;"
//                    + "user=DB_A68F20_chambipa_admin;password=raizdemenos1";
    
    public Connection getConexion()
    {
        conn = null;
        try
        {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error al conectar" + e);
        }
        System.out.println("Conexion correcta");
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
