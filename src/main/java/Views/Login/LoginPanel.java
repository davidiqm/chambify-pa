package Views.Login;

import Controllers.LoginController;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Angel J Garcia Sandoval & David I Quime Montalvo
 */
public class LoginPanel extends JPanel{
    public LoginPanel(LoginController controller) {
        this.controller = controller;
        components();
    }
    
    private void components() {
        labels();
        buttons();
    }
    
    private void labels() {
        title = new JLabel("Chambify");
        title.setBounds(200, 100, 100, 25);
        super.add(title);
    }
    
    private void buttons() {
        testbtn = new JButton("Botón de prueba");
        testbtn.setBounds(150, 150, 150, 25);
        testbtn.addActionListener(controller);
        super.add(testbtn);
        
        registerbtn = new JButton("Registrarse");
        registerbtn.setBounds(150, 200, 150, 25);
        registerbtn.addActionListener(controller);
        super.add(registerbtn);
    }
    
    //Variables
    LoginController controller; 
    //Swing components
    public JButton testbtn, registerbtn;
    JLabel title;
}
