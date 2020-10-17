/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Login.LoginFrame;
import Vista.Login.LoginPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author david
 */
public class LoginController implements ActionListener{
    
    public LoginController(LoginPanel login, LoginFrame frame) {
        this.login = login;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        
        if(source.getText().equals("Botón de prueba")) {
            System.out.println(e.getSource().toString());
        }
        
        if(source.getText().equals("Registrarse")) {
            frame.loginPanel.setVisible(false);
            frame.registerPanel.setVisible(true);
        }
    }
    
    LoginPanel login;
    LoginFrame frame;
}
