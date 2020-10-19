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
public class AdminSideBar extends JPanel{
    public AdminSideBar()
    {
        components();
    }
    
    private void components()
    {
        buttons();
    }
    
    private void buttons()
    {
        usersBtn = new JButton("Usuarios");
        usersBtn.setForeground(Color.WHITE);
        usersBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        usersBtn.setBounds(0, 100, 250, 50);
        usersBtn.setBorderPainted(false);
        usersBtn.setFocusPainted(false);
        usersBtn.setContentAreaFilled(false);
//        usuariosBtn.addActionListener(this);
        super.add(usersBtn);
        
        workersBtn = new JButton("Trabajadores");
        workersBtn.setForeground(Color.WHITE);
        workersBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        workersBtn.setBounds(0, 160, 250, 50);
        workersBtn.setBorderPainted(false);
        workersBtn.setFocusPainted(false);
        workersBtn.setContentAreaFilled(false);
//        usuariosBtn.addActionListener(this);
        super.add(workersBtn);
    }
    
    private JButton usersBtn, workersBtn;
    
}
