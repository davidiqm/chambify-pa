package Controllers;

import Views.User.UserFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Angel J Garcia Sandoval & David I Quime Montalvo
 */
public class UserController implements ActionListener {

    
    public UserController(UserFrame userFrame) {
        this.userFrame = userFrame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
    //Variables
    UserFrame userFrame;
}
