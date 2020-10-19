package Views.Login;

import Controllers.LoginController;
import Models.Fecha;
import Models.Hash;
import Models.LimiteDeCaracteres;
import Models.SQLUsuarios;
import Models.Usuarios;
import Views.Admin.AdminFrame;
import Views.User.UserFrame;
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
        labels();
        buttons();
        textFields();
    }
    
    private void labels() {
        title = new JLabel("Chambify");
        title.setBounds(200, 100, 100, 25);
        super.add(title);
    }
    
    private void textFields()
    {
        usuarioTx = new JTextField();
        usuarioTx.setBounds(150, 150, 200, 30);
//        usuarioTx.setOpaque(false);
//        usuarioTx.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        usuarioTx.setHorizontalAlignment(JTextField.CENTER);
        usuarioTx.setDocument(new LimiteDeCaracteres(10));
        super.add(usuarioTx);
        
        contrasenaTx = new JPasswordField();
        contrasenaTx.setBounds(150, 185, 200, 30);
//        contrasenaTx.setOpaque(false);
//        contrasenaTx.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contrasenaTx.setHorizontalAlignment(JTextField.CENTER);
        contrasenaTx.setDocument(new LimiteDeCaracteres(10));
        super.add(contrasenaTx);
    }
    
    private void buttons() {
        testbtn = new JButton("Botón de prueba");
        testbtn.setBounds(150, 220, 150, 25);
        testbtn.addActionListener(controller);
        super.add(testbtn);
        
        registerbtn = new JButton("Registrarse");
        registerbtn.setBounds(150, 300, 150, 25);
        registerbtn.addActionListener(controller);
        super.add(registerbtn);
    }
    
    public static void autentificar() {
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
                        break;
                    case 2:
                        UserFrame usuario = new UserFrame();
                }
            }else
            {
                JOptionPane.showMessageDialog(null, "Datos Incorrectos");
            }
        } else
        {
            JOptionPane.showMessageDialog(null, "Campos vacios");
        }
    }
    
    //Variables
    LoginController controller; 
    //Swing components
    public JButton testbtn, registerbtn;
    private static JTextField usuarioTx;
    private static JPasswordField  contrasenaTx;
    JLabel title;
}
