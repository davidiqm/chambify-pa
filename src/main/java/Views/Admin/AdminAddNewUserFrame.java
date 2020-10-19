/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Admin;

import Controllers.AdminAddNewUserController;
import Controllers.AdminController;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Angel
 */
public class AdminAddNewUserFrame{
    public AdminAddNewUserFrame()
    {
        controller = new AdminAddNewUserController(this);
        components();
    }
    
    private void components()
    {
        frame();
        panel();
        closeWindow();
        initFrame();
    }
    
    private void frame()
    {
        frame = new JFrame("Agregar Usuario");
        frame.setSize(200, 350);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
    }
    
    public void initFrame()
    {
        frame.setVisible(true);
    }
    private void panel()
    {
        addNewUserPanel = new AdminAddNewUserPanel(controller);
        addNewUserPanel.setBounds(0, 0, 460, 720);
        addNewUserPanel.setLayout(null);
        addNewUserPanel.setVisible(true);
        frame.getContentPane().add(addNewUserPanel);
    }
    
    public void closeWindow() {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                AdminController.addNewUserFrame = null;
            }
        });
    }
    
    public AdminAddNewUserPanel addNewUserPanel;
    public static JFrame frame;
    public AdminAddNewUserController controller;
}
