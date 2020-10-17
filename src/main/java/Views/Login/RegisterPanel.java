package Views.Login;

import Controllers.LoginController;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Angel J Garcia Sandoval & David I Quime Montalvo
 */
public class RegisterPanel extends JPanel {
    public RegisterPanel(LoginController controller) {
        this.controller = controller;
        components();
    }

    private void components() {
        labels();
        buttons();
    }
    
    private void labels() {
        testlbl = new JLabel("Un texto de prueba");
        testlbl.setBounds(150, 150, 100, 25);
        super.add(testlbl);
    }
    
    private void buttons() {
        back = new JButton("Regresar");
        back.setBounds(150, 200, 150, 25);
        back.addActionListener(controller);
        super.add(back);
    }
    
    //Variables
    LoginController controller;
    //Swing components
    JButton back;
    JLabel testlbl;
}
