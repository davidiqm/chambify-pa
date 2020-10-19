package Views.User;

import Controllers.UserController;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Angel J Garcia Sandoval & David I Quime Montalvo
 */
public class UserFrame {
    
    public UserFrame() {
        controller = new UserController(this);
        components();
    }
    
    private void components() {
        frame();
        panels();
        buttons();
        labels();
    }
    
    private void frame() {
        userFrame = new JFrame("Dashboard");
        userFrame.setSize(1280, 720);
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userFrame.setLocationRelativeTo(null);
        userFrame.getContentPane().setLayout(null);
        userFrame.setResizable(false);
        userFrame.setVisible(true);
    }
    
    private void panels() {
        sidebar = new JPanel();
        sidebar.setBounds(0, 0, 200, 720);
        sidebar.setLayout(null);
        sidebar.setBackground(new Color(112, 112, 112));
        sidebar.setVisible(true);
        userFrame.getContentPane().add(sidebar);
        
        indexPanel = new IndexPanel(controller);
        indexPanel.setBounds(200, 0, 1080, 720);
        indexPanel.setLayout(null);
        indexPanel.setVisible(true);
        userFrame.getContentPane().add(indexPanel);
        
        searchPanel = new SearchPanel(controller);
        searchPanel.setBounds(200, 0, 1080, 720);
        searchPanel.setLayout(null);
        searchPanel.setVisible(false);
        userFrame.getContentPane().add(searchPanel);
        
        categoriesPanel = new CategoriesPanel(controller);
        categoriesPanel.setBounds(200, 0, 1080, 720);
        categoriesPanel.setLayout(null);
        categoriesPanel.setVisible(false);
        userFrame.getContentPane().add(categoriesPanel);
    }
    
    private void buttons() {
        Font titleFont = new Font("Segoe UI", Font.BOLD, 22);
        Font font = new Font("Segoe UI", Font.BOLD, 20);
        
        chambifyBtn = new JButton("Chambify");
        chambifyBtn.setFont(titleFont);
        chambifyBtn.setBounds(0, 128, 200, 52);
        //chambifyBtn.setBackground(Color.WHITE);
        chambifyBtn.setForeground(Color.WHITE);
        chambifyBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        chambifyBtn.setBorderPainted(false);
        chambifyBtn.setBorderPainted(false);
        chambifyBtn.setContentAreaFilled(false);
        chambifyBtn.addActionListener(controller);
        sidebar.add(chambifyBtn);
        
        indexBtn = new JButton("Inicio");
        indexBtn.setFont(font);
        indexBtn.setBounds(0, 207, 200, 52);
        //indexBtn.setBackground(Color.WHITE);
        indexBtn.setForeground(Color.WHITE);
        indexBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        indexBtn.setBorderPainted(false);
        indexBtn.setFocusPainted(false);
        indexBtn.setContentAreaFilled(false);
        indexBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        indexBtn.addActionListener(controller);
        sidebar.add(indexBtn);
        
        searchBtn = new JButton("Buscar");
        searchBtn.setFont(font);
        searchBtn.setBounds(0, 273, 200, 52);
        //searchBtn.setBackground(Color.WHITE);
        searchBtn.setForeground(Color.WHITE);
        searchBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchBtn.setBorderPainted(false);
        searchBtn.setBorderPainted(false);
        searchBtn.setContentAreaFilled(false);
        searchBtn.addActionListener(controller);
        sidebar.add(searchBtn);
        
        categoriesBtn = new JButton("Categorias");
        categoriesBtn.setFont(font);
        categoriesBtn.setBounds(0, 338, 200, 52);
        //categoriesBtn.setBackground(Color.WHITE);
        categoriesBtn.setForeground(Color.WHITE);
        categoriesBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        categoriesBtn.setBorderPainted(false);
        categoriesBtn.setBorderPainted(false);
        categoriesBtn.setContentAreaFilled(false);
        categoriesBtn.addActionListener(controller);
        sidebar.add(categoriesBtn);
        
        logoutBtn = new JButton("Salir");
        logoutBtn.setFont(font);
        logoutBtn.setBounds(0, 618, 200, 52);
        //logoutBtn.setBackground(Color.WHITE);
        logoutBtn.setForeground(Color.WHITE);
        logoutBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logoutBtn.setBorderPainted(false);
        logoutBtn.setBorderPainted(false);
        logoutBtn.setContentAreaFilled(false);
        logoutBtn.addActionListener(controller);
        sidebar.add(logoutBtn);
    }
    
    private void labels() {
    }
    
    //Variables
    UserController controller;
    //Swing components
    public JButton chambifyBtn, indexBtn, searchBtn, categoriesBtn, optionsBtn, logoutBtn;
    public IndexPanel indexPanel;
    public SearchPanel searchPanel;
    public CategoriesPanel categoriesPanel;
    JFrame userFrame;
    JLabel welcomeLbl;
    JPanel sidebar;
}
