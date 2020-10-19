/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Views.Admin.AdminAddNewUserFrame;
import Views.Admin.AdminFrame;
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
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == adminFrame.users.agregarUsuario) 
        {
            agregarUsuario();
        }
    }
    
    public AdminFrame adminFrame;
    public static AdminAddNewUserFrame addNewUserFrame;
}
