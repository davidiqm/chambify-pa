package Views.Admin;

import Controllers.AdminController;
import Models.ConnectionBD;
import Models.MiModelo;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class AdminPanelCategorias extends JPanel{
    public AdminPanelCategorias(AdminController controller)
    {
        this.controller = controller;
        complements();
        buttons();
    }

    private void complements()
    {
        table();
        text();
        agregarDatos();
    }

    private void table()
    {
        barras = new JScrollPane(tabla);
        modelo = new MiModelo();
        modelo.addColumn("Nombre");
        modelo.addColumn("Categoria");
        modelo.addColumn("Precio");
        tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        tabla.setBounds(10, 20, 1000, 300);
        scroll.setBounds(10, 20, 1000, 300);
        super.add(scroll);
    }
    private void text()
    {
        finTx = new JTextField();
        finTx.setBounds(170, 325, 75, 25);
        super.add(finTx);
    }
    private void buttons()
    {
        agregarUsuario = new JButton();
        agregarUsuario.setText("CRUD");
        agregarUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        agregarUsuario.setBounds(10, 320, 75, 25);
        agregarUsuario.addActionListener(controller);
        super.add(agregarUsuario);

        findBtn = new JButton();
        findBtn.setBounds(90, 325, 75, 25);
        findBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        findBtn.setText("Buscar");
        findBtn.addActionListener(controller);
        super.add(findBtn);
    }

    public static void agregarDatos() {

        try {
            modelo = new MiModelo();
            tabla.setModel(modelo);
            PreparedStatement ps = null;
            ResultSet rs = null;
            ConnectionBD conexion = new ConnectionBD();
            Connection cn = conexion.getConection();
            String sql = "SELECT nombre, categoria, precio FROM oficios";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadCol = rsMd.getColumnCount();
            modelo.addColumn("Nombre");
            modelo.addColumn("Categoria");
            modelo.addColumn("Precio");

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
    public static void buscarOficio() {
        String campo = finTx.getText();
        String where = "";

        if (!"".equals(campo)) {
            where = "WHERE nombre = '" + campo + "'";
        }
        try {
            modelo = new MiModelo();
            tabla.setModel(modelo);
            PreparedStatement ps = null;
            ResultSet rs = null;
            ConnectionBD conexion = new ConnectionBD();
            Connection cn = conexion.getConection();
            String sql = "SELECT nombre, categoria, precio FROM oficios " + where;
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadCol = rsMd.getColumnCount();
            modelo.addColumn("Nombre");
            modelo.addColumn("Categoria");
            modelo.addColumn("Precio");
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
    private JScrollPane barras;
    private static MiModelo modelo;
    private static JTable tabla;
    public JButton agregarUsuario, findBtn;
    private static JTextField finTx;
    AdminController controller;
}
