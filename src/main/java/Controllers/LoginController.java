package Controllers;

import Views.Admin.AdminAddNewUserFrame;
import Views.Login.LoginFrame;
import Views.Login.LoginPanel;
import Views.User.UserFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Angel J Garcia Sandoval & David I Quime Montalvo
 */
public class LoginController implements ActionListener {
    
    public LoginController(LoginFrame loginFrame) {
        this.loginFrame = loginFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == loginFrame.loginPanel.testbtn) {
            int successful = loginFrame.loginPanel.autentificar();
            
            if (successful == 1) loginFrame.loginFrame.dispose();
//            userFrame = new UserFrame();

        }
        
        if (e.getSource() == loginFrame.loginPanel.registerbtn) {
            AdminAddNewUserFrame newUser = new AdminAddNewUserFrame();
//            loginFrame.loginPanel.setVisible(false);
//            loginFrame.registerPanel.setVisible(true);
        }
        
        if (e.getSource() == loginFrame.registerPanel.back) {
            loginFrame.loginPanel.setVisible(true);
            loginFrame.registerPanel.setVisible(false);
        }
        
    }
    
    //Swing components
    LoginFrame loginFrame;
    UserFrame userFrame;
}
