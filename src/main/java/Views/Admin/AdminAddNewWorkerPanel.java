/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Admin;

import Controllers.AdminAddNewWorkerController;
import Models.Hash;
import Models.LimiteDeCaracteres;
import Models.SQLTrabajadores;
import Models.SQLUsuarios;
import Models.TextPrompt;
import Models.Trabajadores;
import Models.Usuarios;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.*;

/**
 *
 * @author Angel
 */
public class AdminAddNewWorkerPanel extends JPanel {

    public AdminAddNewWorkerPanel(AdminAddNewWorkerController controller) {
        this.controller = controller;
        components();
    }

    private void components() {
        labels();
        buttons();
        textFields();
    }

    private void labels() {
//        addNewUserlb = new JLabel();
//        addNewUserlb.setBounds();
        addNewUserlb = new JLabel();
        addNewUserlb.setBounds(40, 0, 150, 28);
        addNewUserlb.setText("CRUD");
        super.add(addNewUserlb);
    }

    private void buttons() {
        addBtn = new JButton();
        addBtn.setBounds(55, 210, 90, 25);
        addBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addBtn.setText("Agregar");
        addBtn.addActionListener(controller);
        super.add(addBtn);

        mdfBtn = new JButton();
        mdfBtn.setBounds(55, 240, 90, 25);
        mdfBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mdfBtn.setText("Modificar");
        mdfBtn.addActionListener(controller);
        super.add(mdfBtn);

        delBtn = new JButton();
        delBtn.setBounds(55, 270, 90, 25);
        delBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        delBtn.setText("Eliminar");
        delBtn.addActionListener(controller);
        super.add(delBtn);

    }

    private void textFields() {
        txUser = new JTextField();
        txUser.setBounds(55, 30, 100, 25);
        super.add(txUser);
        userTp = new TextPrompt("Usuario", txUser);
        userTp.changeAlpha(0.75f);
        userTp.changeStyle(Font.ITALIC);

        txOficio = new JTextField();
        txOficio.setBounds(55, 60, 100, 25);
        super.add(txOficio);
        oficioTp = new TextPrompt("Oficio", txOficio);
        oficioTp.changeAlpha(0.75f);
        oficioTp.changeStyle(Font.ITALIC);

        txName = new JTextField();
        txName.setBounds(55, 90, 100, 25);
        super.add(txName);
        nameTp = new TextPrompt("Nombre", txName);
        nameTp.changeAlpha(0.75f);
        nameTp.changeStyle(Font.ITALIC);

        txEdad = new JTextField();
        txEdad.setBounds(55, 120, 100, 25);
        super.add(txEdad);
        edadTp = new TextPrompt("Edad", txEdad);
        edadTp.changeAlpha(0.75f);
        edadTp.changeStyle(Font.ITALIC);

        txEmail = new JTextField();
        txEmail.setBounds(55, 150, 100, 25);
        super.add(txEmail);
        emailTp = new TextPrompt("Correo", txEmail);
        emailTp.changeAlpha(0.75f);
        emailTp.changeStyle(Font.ITALIC);

        txId_tipo = new JTextField();
        txId_tipo.setBounds(55, 180, 100, 25);
        txId_tipo.setText("3");
        txId_tipo.setEditable(false);
        super.add(txId_tipo);
        id_TipoTp = new TextPrompt("Tipo de Usuario", txId_tipo);
        id_TipoTp.changeAlpha(0.75f);
        id_TipoTp.changeStyle(Font.ITALIC);

        txId_wrk = new JTextField();
        txId_wrk.setBounds(55, 330, 100, 25);
        super.add(txId_wrk);
        id_wrkTp = new TextPrompt("Id del trabajador", txId_wrk);
        id_wrkTp.changeAlpha(0.75f);
        id_wrkTp.changeStyle(Font.ITALIC);
    }

    public static void limpiar() {
        txEmail.setText(null);
        txName.setText(null);
        txUser.setText(null);
    }

    public static void agregarTrabajador() {
        SQLTrabajadores modeloSQL = new SQLTrabajadores();
        Trabajadores mod = new Trabajadores();

        if (txUser.getText().equals("") || txOficio.equals("") || txName.equals("")
                || txEdad.getText().equals("") || txEmail.getText().equals("") || txId_tipo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Existen campos vacios");
        } else {
            if (modeloSQL.usuarioExistente(txUser.getText()) == 0) {
                if (modeloSQL.emailCorrecto(txEmail.getText())) {
                    mod.setUsuario(txUser.getText());
                    mod.setOficio(txOficio.getText());
                    mod.setNombre(txName.getText());
                    mod.setEdad(txEdad.getText());
                    mod.setCorreo(txEmail.getText());
                    mod.setId_tipo(3);

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
        }
    }

    public static void modificarTrabajador() {
        SQLTrabajadores modeloSQL = new SQLTrabajadores();
        Trabajadores mod = new Trabajadores();

        if (txUser.getText().equals("") || txOficio.equals("") || txName.equals("")
                || txEdad.getText().equals("") || txEmail.getText().equals("") || txId_tipo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Existen campos vacios");
        } else {
            if (modeloSQL.emailCorrecto(txEmail.getText())) {
                mod.setUsuario(txUser.getText());
                mod.setOficio(txOficio.getText());
                mod.setNombre(txName.getText());
                mod.setEdad(txEdad.getText());
                mod.setCorreo(txEmail.getText());
                mod.setId_tipo(3);
                mod.setId_trabajador(Integer.parseInt(txId_wrk.getText()));

                if (modeloSQL.modificar(mod)) {
                    JOptionPane.showMessageDialog(null, "Modificacion Completada");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Formato de correo invalido");
            }
        }
    }

    public static void eliminarTrabajador() {
        SQLTrabajadores modeloSQL = new SQLTrabajadores();
        Trabajadores mod = new Trabajadores();

        if (txId_wrk.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Existen campos vacios");
        } else {
            mod.setId_trabajador(Integer.parseInt(txId_wrk.getText()));

            if (modeloSQL.eliminar(mod)) {
                JOptionPane.showMessageDialog(null, "Eliminacion Completada");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
            }
        }
    }
    private JLabel addNewUserlb;
    public JButton addBtn, mdfBtn, delBtn;
    static private JTextField txUser, txName, txEmail, txOficio, txEdad, txId_tipo, txId_wrk;
    private TextPrompt userTp, nameTp, emailTp, oficioTp, edadTp, id_TipoTp, id_wrkTp;
    public AdminAddNewWorkerController controller;
}
