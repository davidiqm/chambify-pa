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
        this.mod = mod;
        components();
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
	Font fontBody = new Font("Segoe UI", Font.PLAIN, 16);
	
	headerLbl = new JLabel("Cuenta");
	headerLbl.setBounds(27, 22, 100, 27);
	headerLbl.setFont(font);
	headerLbl.setForeground(Color.white);
	headerPanel.add(headerLbl);
    	
	userLbl = new JLabel("¡Hola, " + mod.getNombre() + "!");
	userLbl.setBounds(51, 95, 200, 27);
	userLbl.setFont(font);
	userLbl.setForeground(Color.black);
	super.add(userLbl);
        
        personalInfoLbl = new JLabel("Datos Personales");
        personalInfoLbl.setBounds(51, 140, 400, 27);
	personalInfoLbl.setFont(new Font("Segoe UI", Font.BOLD, 16));
	personalInfoLbl.setForeground(Color.black);
	super.add(personalInfoLbl);
        
        userInfoLbl = new JLabel("Usuario: " + mod.getUsuario());
        userInfoLbl.setBounds(51, 184, 400, 27);
	userInfoLbl.setFont(fontBody);
	userInfoLbl.setForeground(Color.black);
	super.add(userInfoLbl);
        
        nameInfoLbl = new JLabel("Nombre: " + mod.getNombre());
        nameInfoLbl.setBounds(51, 231, 400, 27);
	nameInfoLbl.setFont(fontBody);
	nameInfoLbl.setForeground(Color.black);
	super.add(nameInfoLbl);
        
        addressInfoLbl = new JLabel("Correo electrónico: " + mod.getCorreo());
        addressInfoLbl.setBounds(51, 278, 400, 27);
	addressInfoLbl.setFont(fontBody);
	addressInfoLbl.setForeground(Color.black);
	super.add(addressInfoLbl);
    }

    //Vars
    UserController controller;
    //Swing components
    JLabel userLbl, headerLbl, personalInfoLbl, userInfoLbl, nameInfoLbl, addressInfoLbl; 
    JPanel headerPanel;
    public String usuario;
    Usuarios mod;
}
