package Controllers;

import Views.Admin.AdminAddNewUserFrame;
import Views.Admin.AdminAddNewUserPanel;
import Views.Login.LoginAddNewUserFrame;
import Views.Login.LoginAddNewUserPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginAddNewUserController implements ActionListener {
    public LoginAddNewUserController(LoginAddNewUserFrame addNewUserFrame)
    {
        this.addNewUserFrame = addNewUserFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addNewUserFrame.addNewUserPanel.addBtn)
        {
            LoginAddNewUserPanel.registrarse();
        }
    }


    public LoginAddNewUserFrame addNewUserFrame;
    public LoginAddNewUserPanel addUser;
}
