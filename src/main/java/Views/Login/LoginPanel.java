package Views.Login;

import Controllers.AdminController;
import Controllers.LoginController;
import Models.*;
import Views.Admin.AdminFrame;
import Views.User.UserFrame;
import Views.Workers.WorkerFrame;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

/**
 *
 * @author Angel J Garcia Sandoval & David I Quime Montalvo
 */
public class LoginPanel extends JPanel{
    public LoginPanel(LoginController controller) {
        this.controller = controller;
        components();
    }
    
    private void components() {
        panel();
        labels();
        buttons();
        textFields();
    }
    
    private void panel() {
        this.setBackground(new Color(123, 123, 123));
    }
    
    private void labels() {
        title = new JLabel("Chambify");
        title.setBounds(152, 115, 200, 50);
        title.setLayout(null);
        title.setForeground(Color.white);
        title.setFont(new Font("Segoe UI", Font.BOLD, 36));
        super.add(title);
        
        userLbl = new JLabel("Usuario");
        userLbl.setBounds(130, 214, 100, 20);
        userLbl.setLayout(null);
        userLbl.setForeground(Color.white);
        userLbl.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        super.add(userLbl);
        
        passwordLbl = new JLabel("Contraseña");
        passwordLbl.setBounds(130, 282 , 100, 20);
        passwordLbl.setLayout(null);
        passwordLbl.setForeground(Color.white);
        passwordLbl.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        super.add(passwordLbl);

        registrarLbl = new JLabel("aquí.");
        registrarLbl.setBounds(130, 400 , 50, 20);
        registrarLbl.setLayout(null);
        registrarLbl.setForeground(Color.white);
        registrarLbl.addMouseListener(controller);
        registrarLbl.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        super.add(registrarLbl);
    }
    
    private void textFields()
    {
        usuarioTx = new JTextField();
        usuarioTx.setBounds(130, 236, 200, 25);
//        usuarioTx.setOpaque(false);
//        usuarioTx.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        usuarioTx.setHorizontalAlignment(JTextField.CENTER);
        //usuarioTx.setDocument(new LimiteDeCaracteres(10));
        usuarioTx.setDocument(new LimiteDeCaracteres(20));
        super.add(usuarioTx);
        
        contrasenaTx = new JPasswordField();
        contrasenaTx.setBounds(130, 304, 200, 25);
//        contrasenaTx.setOpaque(false);
//        contrasenaTx.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contrasenaTx.setHorizontalAlignment(JTextField.CENTER);
        contrasenaTx.setDocument(new LimiteDeCaracteres(20));
        super.add(contrasenaTx);
    }
    
    private void buttons() {
        testbtn = new JButton("Iniciar Sesión");
        testbtn.setBounds(136, 379, 189, 25);
        testbtn.addActionListener(controller);
        super.add(testbtn);
    }
    
    public int autentificar() {
        SQLUsuarios modeloSQL = new SQLUsuarios();
        Usuarios modelo = new Usuarios();
        Trabajadores[] jobers = new Trabajadores[6];

        Date date = new Date();
        DateFormat fechayhora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String contra = new String(contrasenaTx.getPassword());
        if(!usuarioTx.getText().equals("") && !contra.equals(""))
        {
            String nuevaContra = Hash.sha1(contra);
            modelo.setUsuario(usuarioTx.getText());
            modelo.setContrasena(nuevaContra);
            modelo.setFecha(Fecha.fechaHoy());
            modelo.setHora(Fecha.horaHoy());
            
            jobers = initWorkers(jobers);

            if(modeloSQL.login(modelo))
            {

                switch(modelo.getId_tipo())
                {
                    case 0:
                        AdminFrame  admin = new AdminFrame(modelo);
                        return 1;
                    case 1:
                        UserFrame usuario = new UserFrame(modelo, jobers);
                        return 1;
                    case 2:
                        WorkerFrame worker = new WorkerFrame();
                        return 1;
                    default:
                        JOptionPane.showMessageDialog(null, "Error de credenciales");
                }
            }else
            {
                JOptionPane.showMessageDialog(null, "Datos Incorrectos");
            }
        } else
        {
            JOptionPane.showMessageDialog(null, "Campos vacios");
        }
        return 0;
    }
    
    public Trabajadores[] initWorkers (Trabajadores[] jobers) {
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            ConnectionBD conexion = new ConnectionBD();
            Connection cn = conexion.getConection();
            Object[] datosFila = new Object[4];
            String sql = "SELECT nombre, oficio, correo, edad FROM trabajadores LIMIT 6";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
//            ResultSetMetaData rsMd = rs.getMetaData();
//            int cantidadCol = rsMd.getColumnCount();
            int counter = 0;
            
            while (rs.next()) {
                for (int i = 0; i < 4; i++) {
                    datosFila[i] = rs.getObject(i + 1);
                }  
                
                String nombre = datosFila[0].toString();
                String oficio = datosFila[1].toString();
                String correo = datosFila[2].toString();
                String edad = datosFila[3].toString();
                
                jobers[counter] = new Trabajadores(nombre, oficio, edad, correo);

                counter++;
            }
            
            return jobers;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar " + ex);
        }
        
        return null;
    }
    
    //Variables
    LoginController controller;
    //Swing components
    public JButton testbtn, registerbtn;
    private static JTextField usuarioTx;
    private static JPasswordField  contrasenaTx;
    public JLabel title, userLbl, passwordLbl, registrarLbl;
}
