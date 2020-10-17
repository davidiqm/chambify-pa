package Vista.Login;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Angel J Garcia Sandoval & David I Quime Montalvo
 */
public class RegisterPanel extends JPanel {
    public RegisterPanel() {
        components();
    }

    private void components() {
        labels();
    }
    
    private void labels() {
        prueba = new JLabel("Un texto de prueba");
        prueba.setBounds(150, 150, 100, 25);
        //prueba.addActionListener(controller);
        super.add(prueba);
    }
    
    JLabel prueba;
}
