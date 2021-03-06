package Views.Login;

import Controllers.AdminController;
import Controllers.LoginController;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Angel J Garcia Sandoval & David I Quime Montalvo
 */
public class LoginFrame {
    public LoginFrame(){
        controller = new LoginController(this);
        components();
    }
    
    protected void components() {
        frame();
        panels();
        initFrame();
    }

    
    protected void frame() {
        loginFrame = new JFrame("Iniciar Sesion");
        loginFrame.setSize(460, 720);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.getContentPane().setLayout(null);
        loginFrame.setResizable(false);
    }
    
    private void initFrame()
    {
        loginFrame.setVisible(true);
    }
    protected void panels() {
        loginPanel = new LoginPanel(controller);
        loginPanel.setBounds(0, 0, 460, 720);
        loginPanel.setLayout(null);
        loginPanel.setVisible(true);
        loginFrame.getContentPane().add(loginPanel);
        
        registerPanel = new RegisterPanel(controller);
        registerPanel.setBounds(0, 0, 460, 720);
        registerPanel.setLayout(null);
        registerPanel.setVisible(false);
        loginFrame.getContentPane().add(registerPanel);
    }

    //Variables
    LoginController controller;
    //Swing components
    public JFrame loginFrame;
    public LoginPanel loginPanel;
    public RegisterPanel registerPanel;
}
