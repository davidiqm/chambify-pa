/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Views.Admin.AdminAddNewUserFrame;
import Views.Admin.AdminAddNewUserPanel;
import java.awt.event.*;


/**
 *
 * @author Angel
 */
public class AdminAddNewUserController implements ActionListener{
    
    public AdminAddNewUserController(AdminAddNewUserFrame addNewUserFrame)
    {
        this.addNewUserFrame = addNewUserFrame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == addNewUserFrame.addNewUserPanel.addBtn)
        {
            addUser.registrarse();
        }
    }
    
    
    public AdminAddNewUserFrame addNewUserFrame;
    public AdminAddNewUserPanel addUser;
}
