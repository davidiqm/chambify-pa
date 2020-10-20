package Controllers;

import Views.Admin.AdminAddNewUserFrame;
import Views.Admin.AdminAddNewWorkerFrame;
import Views.Login.LoginAddNewUserFrame;
import Views.Login.LoginFrame;
import Views.User.UserFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Angel J Garcia Sandoval & David I Quime Montalvo
 */
public class LoginController implements ActionListener, MouseListener {
    
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
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == loginFrame.loginPanel.registrarLbl)
        {
            agregarUsuario();
        }
    }
    private void agregarUsuario()
    {
        if (addNewUserFrame == null)
        {
            addNewUserFrame = new LoginAddNewUserFrame();
            addNewUserFrame.initFrame();
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {

    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
    //Swing components
    LoginFrame loginFrame;
    UserFrame userFrame;
    public static LoginAddNewUserFrame addNewUserFrame;
}
