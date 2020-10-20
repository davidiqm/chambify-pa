package Views.User;

import Controllers.UserController;
import Models.Usuarios;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 *
 * @author Angel J Garcia Sandoval & David I Quime Montalvo
 */
public class UserPanel extends JPanel {
    
    public UserPanel(UserController controller, Usuarios mod) {
        this.controller = controller;
        components();
		userLbl.setText("¡Hola, " + mod.getNombre() + "!");
    }
    
    private void components() {
        panels();
		labels();
    }
    
    private void panels() {
	headerPanel = new JPanel();
	headerPanel.setBounds(0, 0, 1080, 70);
	headerPanel.setBackground(new Color(112, 112, 122));
	headerPanel.setLayout(null);
	headerPanel.setVisible(true);
	super.add(headerPanel);
    }
    
    private void labels() {
	Font font = new Font("Segoe UI", Font.PLAIN, 20);
	
	headerLbl = new JLabel("Cuenta");
	headerLbl.setBounds(27, 22, 100, 27);
	headerLbl.setFont(font);
	headerLbl.setForeground(Color.white);
	headerPanel.add(headerLbl);
    	
	userLbl = new JLabel();
	userLbl.setBounds(51, 95, 150, 27);
	userLbl.setFont(font);
	userLbl.setForeground(Color.black);
	super.add(userLbl);
    }

    //Vars
    UserController controller;
    //Swing components
    JLabel userLbl, headerLbl; 
    JPanel headerPanel;
    public String usuario;
    Usuarios mod;
}
