/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Views.Admin.AdminAddNewWorkerFrame;
import Views.Admin.AdminAddNewWorkerPanel;
import java.awt.event.*;

/**
 *
 * @author Angel
 */
public class AdminAddNewWorkerController implements ActionListener{
    public AdminAddNewWorkerController(AdminAddNewWorkerFrame addNewWorkerFrame)
    {
        this.addNewWorkerFrame = addNewWorkerFrame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == addNewWorkerFrame.addNewWorkerPanel.addBtn)
        {
            AdminAddNewWorkerPanel.agregarTrabajador();
        }
        if (e.getSource() == addNewWorkerFrame.addNewWorkerPanel.mdfBtn)
        {
            AdminAddNewWorkerPanel.modificarTrabajador();
        }
        if (e.getSource() == addNewWorkerFrame.addNewWorkerPanel.delBtn)
        {
            AdminAddNewWorkerPanel.eliminarTrabajador();
        }
    }
    
    
    public AdminAddNewWorkerFrame addNewWorkerFrame;
    public AdminAddNewWorkerPanel addWorker;
}
