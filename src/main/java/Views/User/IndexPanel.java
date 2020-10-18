package Views.User;

import Controllers.UserController;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Angel J Garcia Sandoval & David I Quime Montalvo
 */
public class IndexPanel extends JPanel {
    
    public IndexPanel(UserController controller) {
        this.controller = controller;
        components();
    }
    
    private void components() {
        panels();
        labels();
    }
    
    private void panels() {
        headerPanel = new JPanel();
        headerPanel.setBounds(0, 0, 1080, 70);
        headerPanel.setBackground(new Color(112, 112, 112));
        headerPanel.setLayout(null);
        headerPanel.setVisible(true);
        super.add(headerPanel);
        
        topicPanel = new JPanel();
        topicPanel.setBounds(51, 236, 962, 236);
        topicPanel.setLayout(null);
        topicPanel.setVisible(true);
        super.add(topicPanel);
    }
    
    private void labels() {
        Font font = new Font("Segoe UI", Font.PLAIN, 20);
        
        headerLbl = new JLabel("Inicio");
        headerLbl.setBounds(27, 22, 100, 27);
        headerLbl.setFont(font);
        headerLbl.setForeground(Color.white);
        headerPanel.add(headerLbl);
        
        topicLbl = new JLabel("Los más solicitados");
        topicLbl.setBounds(51, 95, 200, 27);
        topicLbl.setFont(font);
        topicLbl.setForeground(Color.black);
        super.add(topicLbl);
        
        recommendLbl = new JLabel("Para el hogar...");
        recommendLbl.setBounds(51, 400, 200, 27);
        recommendLbl.setFont(font);
        recommendLbl.setForeground(Color.black);
        super.add(recommendLbl);
    }
    
    //Vars
    UserController controller;
    //Swing components
    JLabel headerLbl, topicLbl, recommendLbl;
    JPanel headerPanel, topicPanel;
}
