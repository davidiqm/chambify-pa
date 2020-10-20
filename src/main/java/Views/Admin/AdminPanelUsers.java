/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Admin;

import Controllers.AdminController;
import Models.ConnectionBD;
import Models.MiModelo;
import Models.TextPrompt;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.*;

/**
 *
 * @author Angel
 */
public class AdminPanelUsers extends JPanel{
    
    public AdminPanelUsers(AdminController controller)
    {
        this.controller = controller;
        complements();
        buttons();
    }
    
    private void complements()
    {
        table();
        agregarDatos();
    }
    
    private void table()
    {
        barras = new JScrollPane(tabla);
        modelo = new MiModelo();
        modelo.addColumn("Usuario");
        modelo.addColumn("Contrasena");
        modelo.addColumn("Nombre");
        modelo.addColumn("Correo");
        modelo.addColumn("Tipo de Usuario");
        tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        tabla.setBounds(10, 20, 1000, 550);
        scroll.setBounds(10, 20, 1000, 550);
        super.add(scroll);
    }
    
    private void buttons()
    {
        agregarUsuario = new JButton();
        agregarUsuario.setText("Agregar");
        agregarUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        agregarUsuario.setBounds(10, 570, 75, 25);
        agregarUsuario.addActionListener(controller);
        super.add(agregarUsuario);
    }
    
    public static void agregarDatos() {

        try {
            modelo = new MiModelo();
            tabla.setModel(modelo);
            PreparedStatement ps = null;
            ResultSet rs = null;
            ConnectionBD conexion = new ConnectionBD();
            Connection cn = conexion.getConection();
            String sql = "SELECT usuario, contrasena, nombre, correo, id_tipo FROM usuarios";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadCol = rsMd.getColumnCount();
            modelo.addColumn("Usuario");
            modelo.addColumn("Contrasena");
            modelo.addColumn("Nombre");
            modelo.addColumn("Correo");
            modelo.addColumn("Tipo de Usuario");

            while (rs.next()) {
                Object[] datosFila = new Object[cantidadCol];
                for (int i = 0; i < cantidadCol; i++) {
                    datosFila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(datosFila);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar " + ex);
        }
    }
    
    private JScrollPane barras;
    private static MiModelo modelo;
    private static JTable tabla;
    public JButton agregarUsuario;
    AdminController controller;
}
