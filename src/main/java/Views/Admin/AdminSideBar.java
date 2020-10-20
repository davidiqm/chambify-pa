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
public class AdminSideBar extends JPanel{
    public AdminSideBar(AdminController controller)
    {
        this.controller = controller;
        components();
    }
    
    private void components()
    {
        buttons();
    }
    
    private void buttons()
    {
        Font titleFont = new Font("Segoe UI", Font.BOLD, 22);
        Font font = new Font("Segoe UI", Font.BOLD, 20);
        
//        usersBtn = new JButton("Usuarios");
//        usersBtn.setForeground(Color.WHITE);
//        usersBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        usersBtn.setBounds(0, 100, 250, 50);
//        usersBtn.setBorderPainted(false);
//        usersBtn.setFocusPainted(false);
//        usersBtn.setContentAreaFilled(false);
////        usuariosBtn.addActionListener(this);
//        super.add(usersBtn);
        
        usersBtn = new JButton("Usuarios");
        usersBtn.setFont(font);
        usersBtn.setBounds(20, 207, 200, 52);
        //indexBtn.setBackground(Color.WHITE);
        usersBtn.setForeground(Color.WHITE);
        usersBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        usersBtn.setBorderPainted(false);
        usersBtn.setFocusPainted(false);
        usersBtn.setContentAreaFilled(false);
        usersBtn.addActionListener(controller);
        super.add(usersBtn);
        
//        workersBtn = new JButton("Trabajadores");
//        workersBtn.setForeground(Color.WHITE);
//        workersBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        workersBtn.setBounds(0, 160, 250, 50);
//        workersBtn.setBorderPainted(false);
//        workersBtn.setFocusPainted(false);
//        workersBtn.setContentAreaFilled(false);
////        usuariosBtn.addActionListener(this);
//        super.add(workersBtn);
        
        workersBtn = new JButton("Trabajadores");
        workersBtn.setFont(font);
        workersBtn.setBounds(20, 273, 200, 52);
        //categoriesBtn.setBackground(Color.WHITE);
        workersBtn.setForeground(Color.WHITE);
        workersBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        workersBtn.setBorderPainted(false);
        workersBtn.setFocusPainted(false);
        workersBtn.setContentAreaFilled(false);
        workersBtn.addActionListener(controller);
        super.add(workersBtn);

        categoriaBtn = new JButton("Oficios");
        categoriaBtn.setFont(font);
        categoriaBtn.setBounds(20, 330, 200, 52);
        //categoriesBtn.setBackground(Color.WHITE);
        categoriaBtn.setForeground(Color.WHITE);
        categoriaBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        categoriaBtn.setBorderPainted(false);
        categoriaBtn.setFocusPainted(false);
        categoriaBtn.setContentAreaFilled(false);
        categoriaBtn.addActionListener(controller);
        super.add(categoriaBtn);

        chambifyBtn = new JButton("Chambify");
        chambifyBtn.setFont(titleFont);
        chambifyBtn.setBounds(20, 128, 200, 52);
        //chambifyBtn.setBackground(Color.WHITE);
        chambifyBtn.setForeground(Color.WHITE);
        chambifyBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        chambifyBtn.setBorderPainted(false);
        chambifyBtn.setFocusPainted(false);
        chambifyBtn.setContentAreaFilled(false);
        chambifyBtn.addActionListener(controller);
        super.add(chambifyBtn);

        logoutBtn = new JButton("Salir");
        logoutBtn.setFont(font);
        logoutBtn.setBounds(20, 618, 200, 52);
        //logoutBtn.setBackground(Color.WHITE);
        logoutBtn.setForeground(Color.WHITE);
        logoutBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logoutBtn.setBorderPainted(false);
        logoutBtn.setFocusPainted(false);
        logoutBtn.setContentAreaFilled(false);
        logoutBtn.addActionListener(controller);
        super.add(logoutBtn);
    }
    
//    private void labels() {
//        title = new JLabel("Chambify");
//        title.setBounds(200, 100, 100, 25);
//        super.add(title);
//    }
    
    public JButton usersBtn, workersBtn, chambifyBtn, categoriaBtn, logoutBtn;
    private JLabel title;
    public AdminController controller;
}
