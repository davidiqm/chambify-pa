package Vista.Login;

import javax.swing.*;

/**
 *
 * @author Angel J Garcia Sandoval & David I Quime Montalvo
 */
public class LoginFrame {
    public LoginFrame(){
        components();
    }
    
    protected void components() {
        frame();
        panels();
    }
    
    protected void frame() {
        loginFrame = new JFrame("Iniciar Sesion");
        loginFrame.setSize(460, 720);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.getContentPane().setLayout(null);
        loginFrame.setResizable(false);
        loginFrame.setVisible(true);
    }
    
    protected void panels() {
        loginPanel = new LoginPanel(this);
        loginPanel.setBounds(0, 0, 460, 720);
        loginPanel.setLayout(null);
        loginPanel.setVisible(true);
        loginFrame.getContentPane().add(loginPanel);
        
        registerPanel = new RegisterPanel();
        registerPanel.setBounds(0, 0, 460, 720);
        registerPanel.setLayout(null);
        registerPanel.setVisible(false);
        loginFrame.getContentPane().add(registerPanel);
    }
    
    //Swing components
    JFrame loginFrame;
    public LoginPanel loginPanel;
    public RegisterPanel registerPanel;
}
