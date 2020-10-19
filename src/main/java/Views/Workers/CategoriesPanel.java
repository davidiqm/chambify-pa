package Views.Workers;

import Controllers.WorkerController;
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
    
    public CategoriesPanel(WorkerController controller) {
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
        
        categoryCardPanel1 = new CategoryCardPanel(controller, "Categoria1");
        categoryCardPanel1.setLocation(51, 184);
        super.add(categoryCardPanel1);
        
        categoryCardPanel2 = new CategoryCardPanel(controller, "Categoria2");
        categoryCardPanel2.setLocation(399, 184);
        super.add(categoryCardPanel2);
        
        categoryCardPanel3 = new CategoryCardPanel(controller, "Categoria3");
        categoryCardPanel3.setLocation(747, 184);
        super.add(categoryCardPanel3);
        
        categoryCardPanel4 = new CategoryCardPanel(controller, "Categoria4");
        categoryCardPanel4.setLocation(51, 353);
        super.add(categoryCardPanel4);
        
        categoryCardPanel5 = new CategoryCardPanel(controller, "Categoria5");
        categoryCardPanel5.setLocation(399, 353);
        super.add(categoryCardPanel5);
        
        categoryCardPanel6 = new CategoryCardPanel(controller, "Categoria6");
        categoryCardPanel6.setLocation(747, 353);
        super.add(categoryCardPanel6);
        
        categoryCardPanel7 = new CategoryCardPanel(controller, "Categoria7");
        categoryCardPanel7.setLocation(51, 522);
        super.add(categoryCardPanel7);
        
        categoryCardPanel8 = new CategoryCardPanel(controller, "Categoria8");
        categoryCardPanel8.setLocation(399, 522);
        super.add(categoryCardPanel8);
        
        categoryCardPanel9 = new CategoryCardPanel(controller, "Categoria9");
        categoryCardPanel9.setLocation(747, 522);
        super.add(categoryCardPanel9);
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
    WorkerController controller;
    //Swing components
    JLabel headerLbl, categoriesLbl;
    JPanel headerPanel, topicPanel;
    JTextField searchCategoryTxtF;
    CategoryCardPanel categoryCardPanel1, categoryCardPanel2, categoryCardPanel3, categoryCardPanel4,
            categoryCardPanel5, categoryCardPanel6, categoryCardPanel7, categoryCardPanel8, categoryCardPanel9;
}
