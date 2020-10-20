package Models;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLOficios extends ConnectionBD{
    public boolean registrar(Oficios job) {
        PreparedStatement ps = null;
        Connection con = getConection();

        String sql = "INSERT INTO oficios (nombre, categoria, precio) VALUES (?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, job.getNombre());
            ps.setString(2, job.getCategoria());
            ps.setDouble(3, job.getPrecio());
            ps.execute();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            return false;
        }
    }

    public boolean modificar(Oficios job) {
        PreparedStatement ps = null;
        Connection con = getConection();

        String sql = "UPDATE oficios SET nombre=?, categoria=?, precio=? WHERE id_oficio=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, job.getNombre());
            ps.setString(2, job.getCategoria());
            ps.setDouble(3, job.getPrecio());
            ps.setInt(4, job.getId_oficio());
            ps.execute();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            return false;
        }
    }

    public boolean eliminar(Oficios job) {
        PreparedStatement ps = null;
        Connection con = getConection();

        String sql = "DELETE FROM oficios WHERE id_oficio=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, job.getId_oficio());
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
        Connection con = getConection();

        String sql = "SELECT count(id_oficio) FROM oficios WHERE nombre = ?";
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
