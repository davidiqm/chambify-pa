package Controllers;

import Views.Admin.AdminAddNewJobFrame;
import Views.Admin.AdminAddNewJobPanel;
import Views.Admin.AdminAddNewWorkerFrame;
import Views.Admin.AdminAddNewWorkerPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminAddNewJobController implements ActionListener {
    public AdminAddNewJobController(AdminAddNewJobFrame addNewJobFrame)
    {
        this.addNewJobFrame = addNewJobFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addNewJobFrame.addNewJobPanel.addBtn)
        {
            AdminAddNewJobPanel.agregarOficio();
        }
        if (e.getSource() == addNewJobFrame.addNewJobPanel.mdfBtn)
        {
            AdminAddNewJobPanel.modificarOficio();
        }
        if (e.getSource() == addNewJobFrame.addNewJobPanel.delBtn)
        {
            AdminAddNewJobPanel.eliminarOficio();
        }
    }


    public AdminAddNewJobFrame addNewJobFrame;
    public AdminAddNewJobPanel addJob;
}
