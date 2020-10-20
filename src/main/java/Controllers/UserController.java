package Controllers;

import Views.User.DetailsFrame;
import Views.User.UserFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Angel J Garcia Sandoval & David I Quime Montalvo
 */
public class UserController implements ActionListener {

    
    public UserController(UserFrame userFrame) {
        this.userFrame = userFrame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == userFrame.chambifyBtn) {
            userFrame.indexPanel.setVisible(true);
            userFrame.searchPanel.setVisible(false);
            userFrame.categoriesPanel.setVisible(false);
	    userFrame.userPanel.setVisible(false);
	}
        
        if (e.getSource() == userFrame.indexBtn) {
            userFrame.indexPanel.setVisible(true);
            userFrame.searchPanel.setVisible(false);
            userFrame.categoriesPanel.setVisible(false);
	    userFrame.userPanel.setVisible(false);
        }
        
        if (e.getSource() == userFrame.indexPanel.recommendCard1.cardBtn) {
            DetailsFrame detailsFrame = new DetailsFrame(userFrame.indexPanel.recommendCard1.jobers);
        }
        
        if (e.getSource() == userFrame.indexPanel.recommendCard2.cardBtn) {
            DetailsFrame detailsFrame = new DetailsFrame(userFrame.indexPanel.recommendCard2.jobers);
        }
        
        if (e.getSource() == userFrame.indexPanel.recommendCard3.cardBtn) {
            DetailsFrame detailsFrame = new DetailsFrame(userFrame.indexPanel.recommendCard3.jobers);
        }
        
        if (e.getSource() == userFrame.indexPanel.topicCard1.cardBtn) {
            DetailsFrame detailsFrame = new DetailsFrame(userFrame.indexPanel.topicCard1.jobers);
        }
        
        if (e.getSource() == userFrame.indexPanel.topicCard2.cardBtn) {
            DetailsFrame detailsFrame = new DetailsFrame(userFrame.indexPanel.topicCard2.jobers);
        }
        
        if (e.getSource() == userFrame.indexPanel.topicCard3.cardBtn) {
            DetailsFrame detailsFrame = new DetailsFrame(userFrame.indexPanel.topicCard3.jobers);
        }
        
        if (e.getSource() == userFrame.searchBtn) {
            userFrame.indexPanel.setVisible(false);
            userFrame.searchPanel.setVisible(true);
            userFrame.categoriesPanel.setVisible(false);
	    userFrame.userPanel.setVisible(false);
        }
        
        if (e.getSource() == userFrame.categoriesBtn) {
            userFrame.indexPanel.setVisible(false);
            userFrame.searchPanel.setVisible(false);
            userFrame.categoriesPanel.setVisible(true);
	    userFrame.userPanel.setVisible(false);
        }
       
	if (e.getSource() == userFrame.userBtn) {
            userFrame.indexPanel.setVisible(false);
	    userFrame.searchPanel.setVisible(false);
	    userFrame.categoriesPanel.setVisible(false);
	    userFrame.userPanel.setVisible(true);
	}

        if (e.getSource() == userFrame.logoutBtn) {
            logoutDialog();
        }
    }
    
    private void logoutDialog() {
        int option = JOptionPane.showConfirmDialog(null, "¿Desea salir del programa?", "Chambify", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        
        if(option == 0)  System.exit(0);  
    }
    
    //Variables
    UserFrame userFrame;
}
