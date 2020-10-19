package Views.User;

import Controllers.UserController;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Angel J Garcia Sandoval & David I Quime Montalvo
 */
public class SearchPanel extends JPanel {
    
    public SearchPanel(UserController controller) {
        this.controller = controller;
        components();
    }
    
    private void components() {
        panels();
        labels();
        textFields();
    }
    
    private void panels() {
        headerPanel = new JPanel();
        headerPanel.setBounds(0, 0, 1080, 70);
        headerPanel.setBackground(new Color(112, 112, 112));
        headerPanel.setLayout(null);
        headerPanel.setVisible(true);
        super.add(headerPanel);
    }
    
    private void labels() {
        Font font = new Font("Segoe UI", Font.PLAIN, 20);
        
        headerLbl = new JLabel("Buscar");
        headerLbl.setBounds(27, 22, 100, 27);
        headerLbl.setFont(font);
        headerLbl.setForeground(Color.white);
        headerPanel.add(headerLbl);
        
        searchLbl = new JLabel("¡Busca lo que necesites!");
        searchLbl.setBounds(51, 95, 300, 27);
        searchLbl.setFont(font);
        super.add(searchLbl);
        
        resultsLbl = new JLabel("Resultados...");
        resultsLbl.setBounds(51, 200, 108, 27);
        resultsLbl.setFont(font);
        super.add(resultsLbl);
    }
    
    private void textFields() {
        searchTxtF = new JTextField();
        searchTxtF.setBounds(51, 128, 570, 25);
        super.add(searchTxtF);
    }
    
    //Vars
    UserController controller;
    //Swing components
    JLabel headerLbl, searchLbl, resultsLbl;
    JPanel headerPanel, topicPanel;
    JTextField searchTxtF;
}
