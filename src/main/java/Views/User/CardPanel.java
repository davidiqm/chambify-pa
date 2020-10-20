package Views.User;

import Controllers.UserController;
import Models.Trabajadores;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Angel J Garcia Sandoval & David I Quime Montalvo
 */
public class CardPanel extends JPanel {
    
//    public CardPanel(UserController controller) {
//        this.controller = controller;
//        components();
//    }
    
    public CardPanel(UserController controller, Trabajadores jobers) {
        this.controller = controller;
        this.jobers = jobers;
        components();
    }
    
    private void components() {
        panels();
        labels();
        button();
    }
    
    private void panels() {
        this.setSize(280, 236);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setLayout(null);
        this.setVisible(true);
        
        imagePanel = new JPanel();
        imagePanel.setBounds(0, 0, 280, 121);
        imagePanel.setVisible(true);
        imagePanel.setBackground(Color.RED);
        imagePanel.setLayout(null);
        this.add(imagePanel);
    }
    
    private void labels() {
        titleLbl = new JLabel(jobers.getOficio());
        titleLbl.setBounds(12, 130, 256, 30);
        titleLbl.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        titleLbl.setLayout(null);
        this.add(titleLbl);
        
        descriptionLbl = new JLabel(jobers.getNombre());
        descriptionLbl.setBounds(12, 168, 256, 50);
        descriptionLbl.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        descriptionLbl.setLayout(null);
        this.add(descriptionLbl);
    }
    
    private void button() {
        cardBtn = new JButton();
        //cardBtn.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        cardBtn.setSize(280, 236);
        //cardBtn.setBackground(Color.WHITE);
        //cardBtn.setForeground(Color.WHITE);
        cardBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cardBtn.setBorderPainted(false);
        cardBtn.setFocusPainted(false);
        cardBtn.setContentAreaFilled(false);
        cardBtn.setLayout(null);
        cardBtn.addActionListener(controller);
        this.add(cardBtn);
    }
    
    //Vars
    UserController controller;
    Trabajadores jobers;
    //Swing components
    JLabel titleLbl, descriptionLbl;
    JPanel imagePanel;
    JButton cardBtn;
}
