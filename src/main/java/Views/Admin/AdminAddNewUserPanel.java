/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Admin;

import Controllers.AdminAddNewUserController;
import Models.Hash;
import Models.LimiteDeCaracteres;
import Models.SQLUsuarios;
import Models.TextPrompt;
import Models.Usuarios;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Angel
 */
public class AdminAddNewUserPanel extends JPanel{
    public AdminAddNewUserPanel(AdminAddNewUserController controller)
    {
        this.controller = controller;
        components();
    }
    
    private void components()
    {
        labels();
        buttons();
        textFields();
    }
    
    private void labels()
    {
//        addNewUserlb = new JLabel();
//        addNewUserlb.setBounds();
        addNewUserlb = new JLabel();
        addNewUserlb.setBounds(40, 0, 150, 28);
        addNewUserlb.setText("Agrega un nuevo usuario.");
        super.add(addNewUserlb);
    }
    
    private void buttons()
    {
        addBtn = new JButton();
        addBtn.setBounds(55, 275, 90, 28);
        addBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addBtn.setText("Agregar");
        addBtn.addActionListener(controller);
        super.add(addBtn);
    }
    
    private void textFields()
    {
        txUser = new JTextField();
        txUser.setBounds(55, 30, 100, 25);
        super.add(txUser);
        userTp = new TextPrompt("Usuario", txUser);
        userTp.changeAlpha(0.75f);
        userTp.changeStyle(Font.ITALIC);
        
        txName = new JTextField();
        txName.setBounds(55, 150, 100, 25);
        super.add(txName);
        nameTp = new TextPrompt("Nombre", txName);
        nameTp.changeAlpha(0.75f);
        nameTp.changeStyle(Font.ITALIC);
        
        txEmail = new JTextField();
        txEmail.setBounds(55, 190, 100, 25);
        super.add(txEmail);
        emailTp = new TextPrompt("Correo", txEmail);
        emailTp.changeAlpha(0.75f);
        emailTp.changeStyle(Font.ITALIC);
        
        txId_tipo = new JTextField();
        txId_tipo.setBounds(55, 230, 100, 25);
        super.add(txId_tipo);
        id_TipoTp = new TextPrompt("Tipo de Usuario", txId_tipo);
        id_TipoTp.changeAlpha(0.75f);
        id_TipoTp.changeStyle(Font.ITALIC);
        
        txPassword = new JPasswordField();
        txPassword.setBounds(55, 70, 100, 25);
        txPassword.setDocument(new LimiteDeCaracteres(10));
        super.add(txPassword);
        passTp = new TextPrompt("Contraseña", txPassword);
        passTp.changeAlpha(0.75f);
        passTp.changeStyle(Font.ITALIC);

        txPassword2 = new JPasswordField();
        txPassword2.setBounds(55, 110, 100, 25);
        txPassword2.setDocument(new LimiteDeCaracteres(10));
        super.add(txPassword2);
        pass2Tp = new TextPrompt("Repetir Contraseña", txPassword2);
        pass2Tp.changeAlpha(0.75f);
        pass2Tp.changeStyle(Font.ITALIC);
        
    }
    
    public static void limpiar() {
        txPassword2.setText(null);
        txPassword.setText(null);
        txEmail.setText(null);
        txName.setText(null);
        txUser.setText(null);
    }
    
    public static void registrarse() {
        SQLUsuarios modeloSQL = new SQLUsuarios();
        Usuarios mod = new Usuarios();
        String contra = new String(txPassword.getPassword());
        String cContra = new String(txPassword2.getPassword());

        if (txUser.getText().equals("") || contra.equals("") || cContra.equals("") || 
                txName.getText().equals("") || txEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Existen campos vacios");
        } else {
            if (contra.equals(cContra)) {
                
                if (modeloSQL.usuarioExistente(txUser.getText()) == 0) {
                    if (modeloSQL.emailCorrecto(txEmail.getText())) {
                        String nuevaContra = Hash.sha1(contra);
                        mod.setUsuario(txUser.getText());
                        mod.setContrasena(nuevaContra);
                        mod.setNombre(txName.getText());
                        mod.setCorreo(txEmail.getText());
                        mod.setId_tipo(Integer.parseInt(txId_tipo.getText()));

                        if (modeloSQL.registrar(mod)) {
                            JOptionPane.showMessageDialog(null, "Registro Completado");
                            limpiar();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al registrarse");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Formato de correo invalido");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario ya existe");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Las contrasenas no coinciden.");
            }
        }
    }
    
    private JLabel addNewUserlb;
    public JButton addBtn;
    static private JTextField txUser, txName, txEmail, txId_tipo;
    static private JPasswordField txPassword, txPassword2;
    private TextPrompt userTp, nameTp, emailTp, passTp, pass2Tp, id_TipoTp;
    public AdminAddNewUserController controller;
}
