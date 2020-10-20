package Models;

import java.sql.*;
import java.util.regex.*;
import javax.swing.*;

public class SQLUsuarios extends ConnectionBD {

    public boolean registrar(Usuarios usr) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO usuarios (usuario, contrasena, nombre, correo, id_tipo) VALUES (?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            ps.setString(2, usr.getContrasena());
            ps.setString(3, usr.getNombre());
            ps.setString(4, usr.getCorreo());
            ps.setInt(5, usr.getId_tipo());
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

        String sql = "SELECT count(id_usuario) FROM usuarios WHERE usuario = ?";
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

    public boolean login(Usuarios usr) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT u.id_usuario, u.usuario, u.contrasena, u.nombre, u.id_tipo, t.nombre FROM usuarios AS u INNER JOIN tipo_usuario AS t ON u.id_tipo=t.codigo WHERE usuario = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            rs = ps.executeQuery();

            if (rs.next()) {
                if (usr.getContrasena().equals(rs.getString(3))) {
                    
                    String sqlUpdateFecha = "UPDATE usuarios SET fecha = ?, hora = ? WHERE id_usuario=?;";
                    ps = con.prepareStatement(sqlUpdateFecha);
                    ps.setString(1, usr.getFecha());
                    ps.setString(2, usr.getHora());
                    ps.setInt(3, rs.getInt(1));
                    ps.execute();
                    
                    usr.setId_usuario(rs.getInt(1));
                    usr.setNombre(rs.getString(4));
                    usr.setId_tipo(rs.getInt(5));
                    usr.setNombre_tipo(rs.getString(6));
                    return true;
                } else {
                    return false;
                }
            }

            return false;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            return false;
        }
    }
}
