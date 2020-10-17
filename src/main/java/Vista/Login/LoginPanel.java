package Vista.Login;

import Controlador.LoginController;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Angel J Garcia Sandoval & David I Quime Montalvo
 */
public class LoginPanel extends JPanel{
    public LoginPanel(LoginFrame frame) {
        components(frame);
    }
    
    protected void components(LoginFrame frame) {
        actions(frame);
        labels();
        buttons();
    }
    
    protected void labels() {
        title = new JLabel("Chambify");
        title.setBounds(200, 100, 100, 25);
        super.add(title);
    }
    
    protected void buttons() {
        testbtn = new JButton("Botón de prueba");
        testbtn.setBounds(150, 150, 100, 25);
        testbtn.addActionListener(controller);
        super.add(testbtn);
        
        registerbtn = new JButton("Registrarse");
        registerbtn.setBounds(150, 200, 100, 25);
        registerbtn.addActionListener(controller);
        super.add(registerbtn);
    }
    
    protected void actions(LoginFrame frame) {
        controller = new LoginController(this, frame);
    }
    
    JLabel title;
    public JButton testbtn, registerbtn;
    LoginController controller; 
}
