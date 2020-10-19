/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Admin;

import Controllers.AdminController;
import javax.swing.JPanel;

/**
 *
 * @author Angel
 */
public class AdminPanelWorkers extends JPanel{
    public AdminPanelWorkers(AdminController controller)
    {
        this.controller = controller;
        components();
    }
    
    private void components()
    {
        
    }
    
    public AdminController controller;
}
