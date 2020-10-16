package Vista;

import javax.swing.*;

/**
 *
 * @author Angel J Garcia Sandoval & David I Quime Montalvo
 */
public class Login {
    public Login(){
        components();
    }
    
    public void components() {
        frames();
    }
    
    public void frames() {
        login = new JFrame("Iniciar Sesion");
        login.setSize(200, 250);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setLocationRelativeTo(null);
        login.getContentPane().setLayout(null);
        login.setVisible(true);
    }
    
    //Swing components
    JFrame login;
}
