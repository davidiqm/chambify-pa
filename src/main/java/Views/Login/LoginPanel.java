package Views.Login;

import Controllers.LoginController;
import Models.Fecha;
import Models.Hash;
import Models.LimiteDeCaracteres;
import Models.SQLUsuarios;
import Models.Usuarios;
import Views.Admin.AdminFrame;
import Views.User.UserFrame;
import Views.Workers.WorkerFrame;
import java.awt.Color;
import java.awt.Font;
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
        userLbl.setBounds(130, 214, 50, 20);
        userLbl.setLayout(null);
        userLbl.setForeground(Color.white);
        userLbl.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        super.add(userLbl);
        
        passwordLbl = new JLabel("Contraseña");
        passwordLbl.setBounds(130, 282 , 50, 20);
        passwordLbl.setLayout(null);
        passwordLbl.setForeground(Color.white);
        passwordLbl.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        super.add(passwordLbl);
    }
    
    private void textFields()
    {
        usuarioTx = new JTextField();
        usuarioTx.setBounds(130, 236, 200, 25);
//        usuarioTx.setOpaque(false);
//        usuarioTx.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        usuarioTx.setHorizontalAlignment(JTextField.CENTER);
        usuarioTx.setDocument(new LimiteDeCaracteres(10));
        super.add(usuarioTx);
        
        contrasenaTx = new JPasswordField();
        contrasenaTx.setBounds(130, 304, 200, 25);
//        contrasenaTx.setOpaque(false);
//        contrasenaTx.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contrasenaTx.setHorizontalAlignment(JTextField.CENTER);
        contrasenaTx.setDocument(new LimiteDeCaracteres(10));
        super.add(contrasenaTx);
    }
    
    private void buttons() {
        testbtn = new JButton("Iniciar Sesión");
        testbtn.setBounds(136, 379, 189, 25);
        testbtn.addActionListener(controller);
        super.add(testbtn);
        
//        registerbtn = new JButton("Registrarse");
//        registerbtn.setBounds(150, 300, 150, 25);
//        registerbtn.addActionListener(controller);
//        super.add(registerbtn);
    }
    
    public int autentificar() {
        SQLUsuarios modeloSQL = new SQLUsuarios();
        Usuarios modelo = new Usuarios();
        
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
            
            if(modeloSQL.login(modelo))
            {
//                if(modelo.)
//                menus = new InterfazNutrimorinMenus(modelo);
//                menus.iniVentana();
//                ventana.dispose();
                switch(modelo.getId_tipo())
                {
                    case 1:
                        AdminFrame  admin = new AdminFrame();
                        return 1;
                    case 2:
                        UserFrame usuario = new UserFrame();
                        return 1;
                    case 3:
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
    
    //Variables
    LoginController controller; 
    //Swing components
    public JButton testbtn, registerbtn;
    private static JTextField usuarioTx;
    private static JPasswordField  contrasenaTx;
    JLabel title, userLbl, passwordLbl;
}
