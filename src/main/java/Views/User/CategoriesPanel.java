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
public class CategoriesPanel extends JPanel {
    
    public CategoriesPanel(UserController controller) {
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
        
        headerLbl = new JLabel("Categorías");
        headerLbl.setBounds(27, 22, 100, 27);
        headerLbl.setFont(font);
        headerLbl.setForeground(Color.white);
        headerPanel.add(headerLbl);
        
        categoriesLbl = new JLabel("Buscar categoría");
        categoriesLbl.setBounds(51, 95, 150, 27);
        categoriesLbl.setFont(font);
        super.add(categoriesLbl);
    }
    
    private void textFields() {
        searchCategoryTxtF = new JTextField();
        searchCategoryTxtF.setBounds(51, 128, 570, 25);
        super.add(searchCategoryTxtF);
    }
    
    //Vars
    UserController controller;
    //Swing components
    JLabel headerLbl, categoriesLbl;
    JPanel headerPanel, topicPanel;
    JTextField searchCategoryTxtF;
}
