/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Admin;

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
    }
    
    private void frame()
    {
        frame = new JFrame("Iniciar Sesion");
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    
    private void panel()
    {
        panel = new AdminPanel();
        panel.setBounds(0, 0, 700, 500);
        panel.setLayout(null);
        panel.setVisible(true);
        frame.getContentPane().add(panel);
    }

    private JFrame frame;
    private AdminPanel panel;
}
