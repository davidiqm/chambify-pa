/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Admin;

import Models.MiModelo;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Angel
 */
public class AdminPanelUsers extends JPanel{
    
    public AdminPanelUsers()
    {
        complements();
        buttons();
    }
    
    private void complements()
    {
        table();
    }
    
    private void table()
    {
        barras = new JScrollPane(tabla);
        modelo = new MiModelo();
        modelo.addColumn("Usuario");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Edad");
        modelo.addColumn("Telefono");
        modelo.addColumn("Ultima_vez");
        modelo.addColumn("Creado_el");
        tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        tabla.setBounds(10, 20, 1000, 300);
        scroll.setBounds(10, 20, 1000, 300);
        super.add(scroll);
    }
    
    private void buttons()
    {
        agregarUsuario = new JButton();
        agregarUsuario.setText("Agregar");
        agregarUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        agregarUsuario.setBounds(10, 320, 75, 25);
        //agregarUsuario.addActionListener(this);
        super.add(agregarUsuario);
    }
    
    private JScrollPane barras;
    private MiModelo modelo;
    private JTable tabla;
    private JButton agregarUsuario;
}
