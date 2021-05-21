package com.mycompany.edd_proyecto_final.ui;

import com.mycompany.edd_proyecto_final.entidades.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EditarUsuario extends javax.swing.JInternalFrame {

    public EditarUsuario() {
        initComponents();
        enabledBtn(false);
        actionTxt(txtPassword);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtUsuario2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtTipo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        getContentPane().setLayout(null);

        jLabel1.setText("Usuario");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(6, 18, 62, 24);
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(86, 14, 183, 33);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(281, 14, 72, 33);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 53, 446, 10);

        jLabel2.setFont(new java.awt.Font("Lucida Console", 2, 14)); // NOI18N
        jLabel2.setText("             Datos Usuario");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(57, 69, 270, 29);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(152, 104, 163, 10);

        jLabel3.setText("ID");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(6, 123, 12, 26);

        txtid.setEnabled(false);
        getContentPane().add(txtid);
        txtid.setBounds(75, 120, 280, 33);

        jLabel4.setText("Usuario");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(6, 184, 45, 16);
        getContentPane().add(txtUsuario2);
        txtUsuario2.setBounds(75, 175, 280, 34);

        jLabel5.setText("Contraseña");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(6, 239, 67, 16);
        getContentPane().add(txtPassword);
        txtPassword.setBounds(80, 232, 280, 30);

        txtTipo.setEnabled(false);
        getContentPane().add(txtTipo);
        txtTipo.setBounds(80, 280, 280, 40);

        jLabel6.setText("Tipo");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(14, 300, 50, 20);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar);
        btnGuardar.setBounds(107, 332, 90, 40);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar);
        btnEliminar.setBounds(217, 332, 90, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        usuario = Desktop.lstUsr.get(new Usuario(txtUsuario.getText(), "", "", ""));
        if (usuario == null) {
            JOptionPane.showMessageDialog(null, "No se Encontro Usuario con Id: " + txtUsuario.getText());
            txtUsuario.setText("");
            return;
        }
        txtUsuario.setText("");
        txtid.setText(usuario.getId());
        txtUsuario2.setText(usuario.getUsuario());
        txtTipo.setText(usuario.getTipo());
        txtPassword.setText(usuario.getPassword());
        enabledBtn(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        usuario.setPassword(txtPassword.getText());
        usuario.setUsuario(txtUsuario2.getText());

        clearText();
        enabledBtn(false);

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        if (!Desktop.lstUsr.delete(usuario)) {
            JOptionPane.showMessageDialog(null, "Ocurrio Un Error Al Intentar Eliminar AL Usuario","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        JOptionPane.showMessageDialog(null, "Usuario Eliminado Correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
        clearText();
        enabledBtn(false);
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void clearText() {
        txtUsuario.setText("");
        txtid.setText("");
        txtUsuario2.setText("");
        txtTipo.setText("");
        txtPassword.setText("");
    }

    private void enabledBtn(boolean enable) {
        btnEliminar.setEnabled(enable);
        btnGuardar.setEnabled(enable);
    }
     private void actionTxt(JTextField input) {
        input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnGuardarActionPerformed(e);
            }
        });
    }
    private Usuario usuario;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtUsuario2;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables

}
