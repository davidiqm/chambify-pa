/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.User;

import Models.Trabajadores;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

/**
 *
 * @author david
 */
public class DetailsFrame {
    
    public DetailsFrame(Trabajadores jober) {
        this.jober = jober;
        components();
    }
    
    private void components() {
        frame();
        panels();
        labels();
    }
    
    private void frame() {
        detailFrame = new JFrame();
        detailFrame = new JFrame("Más detalles");
        detailFrame.setSize(300, 250);
        detailFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        detailFrame.setLocationRelativeTo(null);
        detailFrame.getContentPane().setLayout(null);
        detailFrame.setResizable(false);
        detailFrame.setVisible(true);
    }
    
    private void panels() {
        headerPanel = new JPanel();
        headerPanel.setBounds(0, 0, 400, 84);
        headerPanel.setBackground(new Color(112, 112, 112));
        headerPanel.setLayout(null);
        headerPanel.setVisible(true);
        detailFrame.add(headerPanel);
    }
    
    private void labels() {
        jobLbl = new JLabel(jober.getOficio());
        jobLbl.setBounds(10, 10, 200, 50);
        jobLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jobLbl.setLayout(null);
        jobLbl.setForeground(Color.white);
        headerPanel.add(jobLbl);
        
        nameLbl = new JLabel(jober.getNombre());
        nameLbl.setBounds(10, 39, 200, 50);
        nameLbl.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        nameLbl.setLayout(null);
        nameLbl.setForeground(Color.white);
        headerPanel.add(nameLbl);
        
        ageLbl = new JLabel("Edad: " + jober.getEdad());
        ageLbl.setBounds(10, 97, 300, 50);
        ageLbl.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        ageLbl.setLayout(null);
        detailFrame.add(ageLbl);
        
        contactLbl = new JLabel("Contacto" + jober.getCorreo());
        contactLbl.setBounds(10, 124, 300, 50);
        contactLbl.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contactLbl.setLayout(null);
        detailFrame.add(contactLbl);
    }
    
    Trabajadores jober;
    JFrame detailFrame;
    JPanel headerPanel;
    JLabel jobLbl, nameLbl, ageLbl, contactLbl;
}
