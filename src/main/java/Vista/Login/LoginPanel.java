package Vista.Login;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Angel J Garcia Sandoval & David I Quime Montalvo
 */
public class LoginPanel extends JPanel{
    public LoginPanel() {
        components();
    }
    
    protected void components() {
        labels();
    }
    
    protected void labels() {
        titulo = new JLabel("Chambify");
        titulo.setBounds(200, 100, 100, 25);
        super.add(titulo);
    }
    
    JLabel titulo;
}
