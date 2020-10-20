package Views.Login;

import Controllers.AdminAddNewUserController;
import Controllers.AdminController;
import Controllers.LoginAddNewUserController;
import Controllers.LoginController;
import Views.Admin.AdminAddNewUserPanel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginAddNewUserFrame {
    public LoginAddNewUserFrame()
    {
        controller = new LoginAddNewUserController(this);
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
        addNewUserPanel = new LoginAddNewUserPanel(controller);
        addNewUserPanel.setBounds(0, 0, 460, 720);
        addNewUserPanel.setLayout(null);
        addNewUserPanel.setVisible(true);
        frame.getContentPane().add(addNewUserPanel);
    }

    public void closeWindow() {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                LoginController.addNewUserFrame = null;
            }
        });
    }

    public LoginAddNewUserPanel addNewUserPanel;
    public static JFrame frame;
    public LoginAddNewUserController controller;
}
