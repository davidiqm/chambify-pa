package Views.Workers;

import Controllers.WorkerController;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author david
 */
public class CategoryCardPanel extends JPanel {
    
    public CategoryCardPanel(WorkerController controller, String category) {
        this.controller = controller;
        this.category = category;
        components();
    }
    
    private void components() {
        panel();
        button();
    }
    
    private void panel() {
        this.setSize(258, 124);
        this.setLayout(null);
        this.setBackground(new Color(120, 3, 3));
        this.setVisible(true);
    }
    
    private void button() {
        categoryBtn = new JButton(category);
        categoryBtn.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        categoryBtn.setBounds(0, 0, 258, 124);
        //chambifyBtn.setBackground(Color.WHITE);
        categoryBtn.setForeground(Color.WHITE);
        categoryBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        categoryBtn.setBorderPainted(false);
        categoryBtn.setFocusPainted(false);
        categoryBtn.setContentAreaFilled(false);
        categoryBtn.addActionListener(controller);
        this.add(categoryBtn);
    }
    
    //Vars
    WorkerController controller;
    String category;
    //Swing components
    JButton categoryBtn;
}
