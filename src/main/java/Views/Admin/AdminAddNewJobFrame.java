package Views.Admin;

import Controllers.AdminAddNewJobController;
import Controllers.AdminAddNewWorkerController;
import Controllers.AdminController;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AdminAddNewJobFrame {
    public AdminAddNewJobFrame()
    {
        controller = new AdminAddNewJobController(this);
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
        addNewJobPanel = new AdminAddNewJobPanel(controller);
        addNewJobPanel.setBounds(0, 0, 460, 720);
        addNewJobPanel.setLayout(null);
        addNewJobPanel.setVisible(true);
        frame.getContentPane().add(addNewJobPanel);
    }

    public void closeWindow() {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                AdminController.addNewJobFrame = null;
            }
        });
    }

    public AdminAddNewJobPanel addNewJobPanel;
    public static JFrame frame;
    public AdminAddNewJobController controller;
}
