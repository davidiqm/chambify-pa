/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Admin;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Angel
 */
public class AdminFrame {
    
    public AdminFrame()
    {
        components();
    }
    
    private void components()
    {
        frame();
        panel();
        initFrame();
    }
    
    private void frame()
    {
        frame = new JFrame("Dashboard - Admin");
        frame.setSize(1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);
        frame.setResizable(false);
    }
    
    private void initFrame()
    {
        frame.setVisible(true);
    }
    private void panel()
    {
        sideBar = new AdminSideBar();
        sideBar.setBounds(0, 0, 250, 720);
        sideBar.setLayout(null);
        sideBar.setBackground(new Color(64, 64, 64));
        sideBar.setVisible(true);
        frame.getContentPane().add(sideBar); 
        
        header = new AdminHeader();
        header.setBounds(250, 0, 1030, 60);
        header.setLayout(null);
        header.setBackground(new Color(64, 64, 64));
        header.setVisible(true);
        frame.getContentPane().add(header);
        
        users = new AdminPanelUsers();
        users.setBounds(250, 60, 1030, 720);
        users.setLayout(null);
        users.setVisible(true);
        frame.getContentPane().add(users);
    }

    private JFrame frame;
    private AdminPanelUsers users;
    private AdminSideBar sideBar;
    private AdminHeader header;
}
