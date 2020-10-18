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
 * @author Angel J Garcia Sandoval & David I Quime Montalvo
 */

public class AdminPanel extends JPanel{
    public AdminPanel()
    {
        components();
    }
    
    private void components()
    {
        botones();
    }
    
    private void botones()
    {
        usuariosBtn = new JButton("Usuarios");
        Font font = new Font("Monserrat", Font.BOLD, 12);
        Color blanquito = new Color(87, 35, 100);
        usuariosBtn.setForeground(blanquito);
        usuariosBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        usuariosBtn.setBounds(0, 0, 80, 28);
        usuariosBtn.setBorderPainted(false);
        usuariosBtn.setFocusPainted(false);
        usuariosBtn.setContentAreaFilled(false);
//        usuariosBtn.addActionListener(this);
        super.add(usuariosBtn);
    }
    
    private JButton usuariosBtn;
}