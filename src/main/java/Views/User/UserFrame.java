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
        initFrame();
    }
    
    private void frame() {
        userFrame = new JFrame("Dashboard");
        userFrame.setSize(1280, 720);
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userFrame.setLocationRelativeTo(null);
        userFrame.getContentPane().setLayout(null);
        userFrame.setResizable(false);
    }
    
    private void initFrame()
    {
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
	
	userPanel = new UserPanel(controller);
	userPanel.setBounds(200, 0, 1080, 720);
	userPanel.setLayout(null);
	userPanel.setVisible(false);
	userFrame.getContentPane().add(userPanel);
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
        chambifyBtn.setFocusPainted(false);
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
        searchBtn.setFocusPainted(false);
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
        categoriesBtn.setFocusPainted(false);
        categoriesBtn.setContentAreaFilled(false);
        categoriesBtn.addActionListener(controller);
        sidebar.add(categoriesBtn);
        
        userBtn = new JButton("Cuenta");
	userBtn.setFont(font);
	userBtn.setBounds(0, 402, 200, 52);
	//userBtn.setBackground(Color.WHITE);
	userBtn.setForeground(Color.WHITE);
	userBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	userBtn.setBorderPainted(false);
        userBtn.setFocusPainted(false);
	userBtn.setContentAreaFilled(false);
	userBtn.addActionListener(controller);
	sidebar.add(userBtn);
        
        logoutBtn = new JButton("Salir");
        logoutBtn.setFont(font);
        logoutBtn.setBounds(0, 618, 200, 52);
        //logoutBtn.setBackground(Color.WHITE);
        logoutBtn.setForeground(Color.WHITE);
        logoutBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logoutBtn.setBorderPainted(false);
        logoutBtn.setFocusPainted(false);
        logoutBtn.setContentAreaFilled(false);
        logoutBtn.addActionListener(controller);
        sidebar.add(logoutBtn);
    }
    
    private void labels() {
    }
    
    //Variables
    UserController controller;
    //Swing components
    public JButton chambifyBtn, indexBtn, searchBtn, categoriesBtn, optionsBtn, userBtn, logoutBtn;
    public IndexPanel indexPanel;
    public SearchPanel searchPanel;
    public CategoriesPanel categoriesPanel;
    public UserPanel userPanel;
    JFrame userFrame;
    JLabel welcomeLbl;
    JPanel sidebar;
}
