/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Admin;

import Controllers.AdminController;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Angel
 */
public class AdminFrame {
    
    public AdminFrame()
    {
        controller = new AdminController(this);
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
        sideBar = new AdminSideBar(controller);
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
        
        users = new AdminPanelUsers(controller);
        users.setBounds(250, 60, 1030, 720);
        users.setLayout(null);
        users.setVisible(true);
        frame.getContentPane().add(users);
        
        workers = new AdminPanelWorkers(controller);
        workers.setBounds(250, 60, 1030, 720);
        workers.setLayout(null);
        workers.setVisible(false);
        frame.getContentPane().add(workers);
    }

    public JFrame frame;
    public AdminPanelUsers users;
    public AdminSideBar sideBar;
    private AdminHeader header;
    public AdminController controller;
    public AdminPanelWorkers workers;
}
