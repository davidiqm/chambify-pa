package Controllers;

import Views.Login.LoginFrame;
import Views.Login.LoginPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author david
 */
public class LoginController implements ActionListener{
    
    public LoginController(LoginFrame loginFrame) {
        this.loginFrame = loginFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        
        if (source.getText().equals("Botón de prueba")) {
            System.out.println("Boton presionado");
        }
        
        if (source.getText().equals("Registrarse")) {
            loginFrame.loginPanel.setVisible(false);
            loginFrame.registerPanel.setVisible(true);
        }
        
        if (source.getText().equals("Regresar")) {
            loginFrame.loginPanel.setVisible(true);
            loginFrame.registerPanel.setVisible(false);
        }
    }
    
    //Swing components
    LoginFrame loginFrame;
}
