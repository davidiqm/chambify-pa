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
public class AdminPanelWorkers extends JPanel{
    public AdminPanelWorkers(AdminController controller)
    {
        this.controller = controller;
        components();
    }
    
    private void components()
    {
        table();
        buttons();
        text();
        agregarDatos();
    }
    
    private void buttons()
    {
        agregar = new JButton();
        agregar.setText("CRUD");
        agregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        agregar.setBounds(10, 570, 75, 25);
        agregar.addActionListener(controller);
        super.add(agregar);
        
        findBtn = new JButton();
        findBtn.setBounds(90, 570, 75, 25);
        findBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        findBtn.setText("Buscar");
        findBtn.addActionListener(controller);
        super.add(findBtn);
    }
    
    private void text()
    {
        finTx = new JTextField();
        finTx.setBounds(170, 570, 75, 25);
        super.add(finTx);
        finTp = new TextPrompt("Usuario", finTx);
        finTp.changeAlpha(0.75f);
        finTp.changeStyle(Font.ITALIC);
    }
    private void table()
    {
        barras = new JScrollPane(tabla);
        modelo = new MiModelo();
        modelo.addColumn("Usuario");
        modelo.addColumn("Oficio");
        modelo.addColumn("Nombre");
        modelo.addColumn("Edad");
        modelo.addColumn("Correo");
        modelo.addColumn("Tipo de Usuario");
        modelo.addColumn("Ultima_vez");
        tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        tabla.setBounds(10, 20, 1000, 550);
        scroll.setBounds(10, 20, 1000, 550);
        super.add(scroll);
    }
    
    public static void agregarDatos() {

        try {
            modelo = new MiModelo();
            tabla.setModel(modelo);
            PreparedStatement ps = null;
            ResultSet rs = null;
            ConnectionBD conexion = new ConnectionBD();
            Connection cn = conexion.getConection();
            String sql = "SELECT usuario, oficio, nombre, edad, correo, id_tipo, fecha FROM trabajadores";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadCol = rsMd.getColumnCount();
            modelo.addColumn("Usuario");
            modelo.addColumn("Oficio");
            modelo.addColumn("Nombre");
            modelo.addColumn("Edad");
            modelo.addColumn("Correo");
            modelo.addColumn("Tipo de Usuario");
            modelo.addColumn("Ultima_vez");
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
    
    public static void buscarTrabajador() {
        String campo = finTx.getText();
        String where = "";

        if (!"".equals(campo)) {
            where = "WHERE usuario = '" + campo + "'";
        }
        try {
            modelo = new MiModelo();
            tabla.setModel(modelo);
            PreparedStatement ps = null;
            ResultSet rs = null;
            ConnectionBD conexion = new ConnectionBD();
            Connection cn = conexion.getConection();
            String sql = "SELECT usuario, oficio, nombre, edad, correo, id_tipo, fecha FROM trabajadores " + where;
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadCol = rsMd.getColumnCount();
            modelo.addColumn("Usuario");
            modelo.addColumn("Oficio");
            modelo.addColumn("Nombre");
            modelo.addColumn("Edad");
            modelo.addColumn("Correo");
            modelo.addColumn("Tipo de Usuario");
            modelo.addColumn("Ultima_vez");
            while (rs.next()) {
                Object[] datosFila = new Object[cantidadCol];
                for (int i = 0; i < cantidadCol; i++) {
                    datosFila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(datosFila);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar" + ex);
        }
    }
    public AdminController controller;
    private JScrollPane barras;
    private static MiModelo modelo;
    private static JTable tabla;
    private static JTextField finTx;
    public static JButton agregar, findBtn;
    private TextPrompt finTp;
}
