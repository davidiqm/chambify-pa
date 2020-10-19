/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Admin;

import Controllers.AdminAddNewWorkerController;
import Controllers.AdminController;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Angel
 */
public class AdminAddNewWorkerFrame {
    public AdminAddNewWorkerFrame()
    {
        controller = new AdminAddNewWorkerController(this);
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
        frame.setSize(200, 450);
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
        addNewWorkerPanel = new AdminAddNewWorkerPanel(controller);
        addNewWorkerPanel.setBounds(0, 0, 460, 720);
        addNewWorkerPanel.setLayout(null);
        addNewWorkerPanel.setVisible(true);
        frame.getContentPane().add(addNewWorkerPanel);
    }
    
    public void closeWindow() {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                AdminController.addNewWorkerFrame = null;
            }
        });
    }
    
    public AdminAddNewWorkerPanel addNewWorkerPanel;
    public static JFrame frame;
    public AdminAddNewWorkerController controller;
}
