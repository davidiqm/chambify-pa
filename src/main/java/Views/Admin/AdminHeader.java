/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Admin;

import Models.Usuarios;
import sun.misc.JavaLangAccess;
import sun.swing.SwingAccessor;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Angel
 */
public class AdminHeader extends JPanel{
    public AdminHeader(Usuarios mod)
    {
        complements();
        userLbl.setText("¡Hola, " + mod.getNombre());
    }

    private void complements()
    {
        label();
    }

    private void label()
    {
        Font titleFont = new Font("Segoe UI", Font.BOLD, 22);
        userLbl = new JLabel();
        userLbl.setBounds(40, 5, 300, 30);
        userLbl.setFont(titleFont);
        userLbl.setForeground(Color.WHITE);
        super.add(userLbl);
    }

    private JLabel userLbl;
}
