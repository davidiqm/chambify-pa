/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Angel
 */
public class SQLTrabajadores extends ConnectionBD{
    public boolean registrar(Trabajadores wrk) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO trabajadores (usuario, nombre, oficio, edad, correo, id_tipo) VALUES (?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, wrk.getUsuario());
            ps.setString(2, wrk.getNombre());
            ps.setString(3, wrk.getOficio());
            ps.setString(4, wrk.getEdad());
            ps.setString(5, wrk.getCorreo());
            ps.setInt(6, wrk.getId_tipo());
            ps.execute();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            return false;
        }
    }
    
    public boolean modificar(Trabajadores wrk) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE trabajadores SET usuario=?, nombre=?, oficio=?, edad=?, correo=?, id_tipo=? WHERE id_trabajador=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, wrk.getUsuario());
            ps.setString(2, wrk.getNombre());
            ps.setString(3, wrk.getOficio());
            ps.setString(4, wrk.getEdad());
            ps.setString(5, wrk.getCorreo());
            ps.setInt(6, wrk.getId_tipo());
            ps.setInt(7, wrk.getId_trabajador());
            ps.execute();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            return false;
        }
    }
    
    public boolean eliminar(Trabajadores wrk) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM trabajadores WHERE id_trabajador=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, wrk.getId_trabajador());
            ps.execute();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            return false;
        }
    }
    
    public int usuarioExistente(String usr) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT count(id_trabajador) FROM trabajadores WHERE usuario = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

            return 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            return 1;
        }
    }

    public boolean emailCorrecto(String correo) {

        // Patrón para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(correo);

        return mather.find();
    }
}
