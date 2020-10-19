package Controllers;

import Views.Workers.WorkerFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Angel J Garcia Sandoval & David I Quime Montalvo
 */
public class WorkerController implements ActionListener {

    
    public WorkerController(WorkerFrame workerFrame) {
        this.workerFrame = workerFrame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == workerFrame.chambifyBtn) {
            workerFrame.indexPanel.setVisible(true);
            workerFrame.searchPanel.setVisible(false);
            workerFrame.categoriesPanel.setVisible(false);
	    workerFrame.userPanel.setVisible(false);
	}
        
        if (e.getSource() == workerFrame.indexBtn) {
            workerFrame.indexPanel.setVisible(true);
            workerFrame.searchPanel.setVisible(false);
            workerFrame.categoriesPanel.setVisible(false);
	    workerFrame.userPanel.setVisible(false);
        }
        
        if (e.getSource() == workerFrame.searchBtn) {
            workerFrame.indexPanel.setVisible(false);
            workerFrame.searchPanel.setVisible(true);
            workerFrame.categoriesPanel.setVisible(false);
	    workerFrame.userPanel.setVisible(false);
        }
        
        if (e.getSource() == workerFrame.categoriesBtn) {
            workerFrame.indexPanel.setVisible(false);
            workerFrame.searchPanel.setVisible(false);
            workerFrame.categoriesPanel.setVisible(true);
	    workerFrame.userPanel.setVisible(false);
        }
       
	if (e.getSource() == workerFrame.userBtn) {
            workerFrame.indexPanel.setVisible(false);
	    workerFrame.searchPanel.setVisible(false);
	    workerFrame.categoriesPanel.setVisible(false);
	    workerFrame.userPanel.setVisible(true);
	}

        if (e.getSource() == workerFrame.logoutBtn) {
            logoutDialog();
        }
    }
    
    private void logoutDialog() {
        int option = JOptionPane.showConfirmDialog(null, "¿Desea salir del programa?", "Chambify", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        
        if(option == 0)  System.exit(0);  
    }
    
    //Variables
    WorkerFrame workerFrame;
}
