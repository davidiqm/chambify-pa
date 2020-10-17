package Views.User;

import Controllers.UserController;
import java.awt.Color;
import java.awt.Font;
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
        sidebar.setBounds(0, 0, 250, 720);
        sidebar.setLayout(null);
        sidebar.setBackground(new Color(64, 64, 64));
        sidebar.setVisible(true);
        userFrame.getContentPane().add(sidebar);
        
        header = new JPanel();
        header.setBounds(250, 0, 1030, 60);
        header.setLayout(null);
        header.setBackground(new Color(64, 64, 64));
        header.setVisible(true);
        userFrame.getContentPane().add(header);
    }
    
    private void buttons() {
        indexBtn = new JButton("Inicio");
        indexBtn.setBounds(0, 100, 250, 50);
        indexBtn.setBackground(Color.WHITE);
        indexBtn.setForeground(Color.WHITE);
        indexBtn.setBorderPainted(false);
        indexBtn.setBorderPainted(false);
        indexBtn.setContentAreaFilled(false);
        indexBtn.addActionListener(controller);
        sidebar.add(indexBtn);
    }
    
    private void labels() {
        welcomeLbl = new JLabel("Chambify");
        welcomeLbl.setBounds(20, 20, 100, 25);
        welcomeLbl.setFont(new Font("Arial", Font.PLAIN, 14));
        welcomeLbl.setForeground(Color.white);
        header.add(welcomeLbl);
    }
    
    //Variables
    UserController controller;
    //Swing components
    JButton indexBtn;
    JLabel welcomeLbl;
    JPanel sidebar, header;
    JFrame userFrame;
    IndexPanel indexPanel;
}
