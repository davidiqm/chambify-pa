/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Views.Admin.*;
import Views.Login.LoginFrame;

import java.awt.event.*;

/**
 *
 * @author Angel
 */
public class AdminController implements ActionListener{
    public AdminController(AdminFrame adminFrame) {
        this.adminFrame = adminFrame;
    }
    
    // Metodos
    private void agregarUsuario()
    {
        if (addNewUserFrame == null)
        {
            addNewUserFrame = new AdminAddNewUserFrame();
            addNewUserFrame.initFrame();
        }
    }
    
    private void agregarTrabajador()
    {
        if (addNewWorkerFrame == null)
        {
            addNewWorkerFrame = new AdminAddNewWorkerFrame();
            addNewWorkerFrame.initFrame();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == adminFrame.users.agregarUsuario) 
        {
            agregarUsuario();
        }

        if (e.getSource() == adminFrame.workers.agregar)
        {
            agregarTrabajador();
        }
        if (e.getSource() == adminFrame.workers.findBtn)
        {
            AdminPanelWorkers.buscarTrabajador();
        }
        if (e.getSource() == adminFrame.sideBar.chambifyBtn)
        {
            adminFrame.users.setVisible(true);
            adminFrame.workers.setVisible(false);
            AdminPanelUsers.agregarDatos();
        }
        if (e.getSource() == adminFrame.sideBar.usersBtn)
        {
            adminFrame.users.setVisible(true);
            adminFrame.workers.setVisible(false);
            AdminPanelUsers.agregarDatos();
        }
        if (e.getSource() == adminFrame.sideBar.workersBtn)
        {
            adminFrame.users.setVisible(false);
            adminFrame.workers.setVisible(true);
            AdminPanelWorkers.agregarDatos();
        }
    }
    
    public AdminFrame adminFrame;
    public static AdminAddNewUserFrame addNewUserFrame;
    public static AdminAddNewWorkerFrame addNewWorkerFrame;
}
