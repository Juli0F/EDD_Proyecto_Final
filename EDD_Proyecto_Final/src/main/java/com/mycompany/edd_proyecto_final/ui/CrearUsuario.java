/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edd_proyecto_final.ui;

import com.mycompany.edd_proyecto_final.entidades.Estudiante;
import com.mycompany.edd_proyecto_final.entidades.Usuario;
import static com.mycompany.edd_proyecto_final.ui.Desktop.lstUsr;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Temporal
 */
public class CrearUsuario extends javax.swing.JInternalFrame {

    /**
     * Creates new form CrearUsuario
     */
    public CrearUsuario() {
        initComponents();
        isStudent = false;
        clearTxt();
        actionCombo();
        actionTxtId();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUser = new javax.swing.JTextField();
        lblUsuario = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        btnCrear = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();

        setBorder(null);

        lblUsuario.setText("Usuario");

        lblPassword.setText("Clave");

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Colaborador", "Estudiante" }));

        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        jLabel3.setText("Tipo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cmbTipo, 0, 136, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addComponent(txtId))
                    .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(txtPassword))
                .addGap(0, 50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPassword)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(txtPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        
        String tipo = (String) cmbTipo.getSelectedItem();
        
        if (tipo.equalsIgnoreCase("estudiante")) {
            Estudiante s = Desktop.hashEstudiante.getValue(new Estudiante(txtId.getText(), "", ""));
            if (s == null) {
                JOptionPane.showMessageDialog(null, txtId.getText() + ", No  Se Encuentra Registrado  ", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        
        if (!lstUsr.contains(new Usuario("", txtUser.getText(), "", ""))) {
            
            Usuario usuario = new Usuario("", txtUser.getText(), txtPassword.getText(), tipo);
            lstUsr.push(usuario);

        } else {
            JOptionPane.showMessageDialog(null, txtUser.getText() + ", Ya Se Encuentra Registrado ", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
        clearTxt();

    }//GEN-LAST:event_btnCrearActionPerformed

    private void txtVisible(boolean visible) {
        txtPassword.setVisible(visible);
        txtUser.setVisible(visible);
        lblPassword.setVisible(visible);
        lblUsuario.setVisible(visible);
    }

    private void clearTxt() {

        txtPassword.setText("");
        txtUser.setText("");
        txtId.setText("");
        txtVisible(false);
        btnCrear.setEnabled(false);
    }

    private void actionCombo() {
        cmbTipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                isStudent = !isStudent;
                if (isStudent) {
                    lblId.setText("Carnet");

                } else {
                    lblId.setText("Id");
                }
                txtVisible(true);
            }
        });
    }
    private void actionTxtId(){
        txtId.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e); //To change body of generated methods, choose Tools | Templates.
                System.out.println("key typed"+ e.getKeyChar());
                 btnCrear.setEnabled(!(txtId.getText().isBlank() || txtId.getText().isEmpty())) ;
                    
                
            }
            
        });
        
        txtPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCrearActionPerformed(e);
            }
        });

    }

    private boolean isStudent;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField txtId;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
