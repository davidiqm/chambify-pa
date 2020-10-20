package Views.Admin;

import Controllers.AdminAddNewJobController;
import Controllers.AdminAddNewWorkerController;
import Models.*;

import javax.swing.*;
import java.awt.*;

public class AdminAddNewJobPanel extends JPanel{
    public AdminAddNewJobPanel(AdminAddNewJobController controller) {
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
        txNombre = new JTextField();
        txNombre.setBounds(55, 30, 100, 25);
        super.add(txNombre);
        nombreTp = new TextPrompt("Nombre", txNombre);
        nombreTp.changeAlpha(0.75f);
        nombreTp.changeStyle(Font.ITALIC);

        txCategoria = new JTextField();
        txCategoria.setBounds(55, 60, 100, 25);
        super.add(txCategoria);
        categoriaTp = new TextPrompt("Categoria", txCategoria);
        categoriaTp.changeAlpha(0.75f);
        categoriaTp.changeStyle(Font.ITALIC);

        txPrecio = new JTextField();
        txPrecio.setBounds(55, 90, 100, 25);
        super.add(txPrecio);
        precioTp = new TextPrompt("Precio", txPrecio);
        precioTp.changeAlpha(0.75f);
        precioTp.changeStyle(Font.ITALIC);

        txId_job = new JTextField();
        txId_job.setBounds(55, 330, 100, 25);
        super.add(txId_job);
        id_jobTp = new TextPrompt("Id del trabajador", txId_job);
        id_jobTp.changeAlpha(0.75f);
        id_jobTp.changeStyle(Font.ITALIC);
    }

    public static void limpiar() {
        txNombre.setText(null);
        txCategoria.setText(null);
        txPrecio.setText(null);
    }

    public static void agregarOficio() {
        SQLOficios modeloSQL = new SQLOficios();
        Oficios mod = new Oficios();

        if (txNombre.getText().equals("") || txCategoria.equals("") || txPrecio.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Existen campos vacios");
        } else {
            if (modeloSQL.usuarioExistente(txNombre.getText()) == 0) {
                    mod.setNombre(txNombre.getText());
                    mod.setCategoria(txCategoria.getText());
                    mod.setPrecio(Integer.parseInt(txPrecio.getText()));
                    if (modeloSQL.registrar(mod)) {
                        JOptionPane.showMessageDialog(null, "Registro Completado");
                        limpiar();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al registrarse");
                    }
            } else {
                JOptionPane.showMessageDialog(null, "El usuario ya existe");
            }
        }
    }

    public static void modificarOficio() {
        SQLOficios modeloSQL = new SQLOficios();
        Oficios mod = new Oficios();

        if (txNombre.getText().equals("") || txCategoria.equals("") || txPrecio.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Existen campos vacios");
        } else {
                mod.setNombre(txNombre.getText());
                mod.setCategoria(txCategoria.getText());
                mod.setPrecio(Integer.parseInt(txPrecio.getText()));
                mod.setId_oficio(Integer.parseInt(txId_job.getText()));

                if (modeloSQL.modificar(mod)) {
                    JOptionPane.showMessageDialog(null, "Modificacion Completada");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar");
                }

        }
    }

    public static void eliminarOficio() {
        SQLOficios modeloSQL = new SQLOficios();
        Oficios mod = new Oficios();

        if (txId_job.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Existen campos vacios");
        } else {
            mod.setId_oficio(Integer.parseInt(txId_job.getText()));

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
    static private JTextField txNombre, txCategoria, txPrecio, txId_job;
    private TextPrompt nombreTp, categoriaTp, precioTp, id_jobTp;
    public AdminAddNewJobController controller;
}
