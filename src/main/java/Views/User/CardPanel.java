package Views.User;

import Controllers.UserController;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Angel J Garcia Sandoval & David I Quime Montalvo
 */
public class CardPanel extends JPanel {
    
    public CardPanel(UserController controller) {
        this.controller = controller;
        components();
    }
    
    private void components() {
        panels();
        labels();
    }
    
    private void panels() {
        this.setSize(280, 236);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setVisible(true);
        
        imagePanel = new JPanel();
        imagePanel.setBounds(0, 0, 280, 121);
        imagePanel.setVisible(true);
        imagePanel.setBackground(Color.RED);
        this.add(imagePanel);
    }
    
    private void labels() {
        titleLbl = new JLabel("Titulo card");
        titleLbl.setBounds(12, 130, 256, 30);
        titleLbl.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        this.add(titleLbl);
        
        descriptionLbl = new JLabel("Descripcion card");
        descriptionLbl.setBounds(12, 168, 256, 50);
        descriptionLbl.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        this.add(descriptionLbl);
    }
    
    //Vars
    UserController controller;
    //Swing components
    JLabel titleLbl, descriptionLbl;
    JPanel imagePanel;
}
