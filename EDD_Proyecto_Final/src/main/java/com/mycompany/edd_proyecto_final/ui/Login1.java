/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edd_proyecto_final.ui;

import com.mycompany.edd_proyecto_final.entidades.Usuario;
import static com.mycompany.edd_proyecto_final.ui.Desktop.lstUsr;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

/**
 *
 * @author Temporal
 */
public class Login1 extends javax.swing.JInternalFrame {

    /**
     * Creates new form Login
     */
    public Login1(JMenuBar bar) {
        initComponents();
        this.bar = bar;
        txtUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Cambiar el foco");
            }
        });
        txtPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton1ActionPerformed(e);
            }
        });
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setForeground(java.awt.Color.darkGray);
        setDesktopIcon(null);
        setEnabled(false);

        jLabel1.setText("Usuario");

        jLabel2.setText("Contraseña");

        jButton1.setText("Entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(txtUser)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (txtUser.getText().equalsIgnoreCase("root") && txtPassword.getText().equalsIgnoreCase("toor")) {
            bar.setVisible(true);
            dispose();
        } else {
            Usuario usr = new Usuario();
            usr.setUsuario(txtUser.getText());
            usr.setPassword(txtPassword.getText());

            if (lstUsr.contains(usr)) {
                Usuario usuario = lstUsr.get(usr);
                if (usuario.getPassword().equals(usr.getPassword())) {
                    if (!usuario.getTipo().equalsIgnoreCase("colaborador")) {
                        permisos();
                    }
                    bar.setVisible(true);
                    dispose();
                } else {

                    cleanTxt();
                }
            } else {
                cleanTxt();
            }

        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void cleanTxt() {

        txtPassword.setText("");
        txtUser.setText("");
        JOptionPane.showMessageDialog(null, "Usuario o Contraseña no existen", "Informacio", JOptionPane.INFORMATION_MESSAGE);
    }

    private void permisos() {

        for (Component component : bar.getComponents()) {
            //   System.out.println("componnt: " + component.toString());

            if (component.toString().contains("Editar")) {
                System.out.println("Text");
                JMenu m = (JMenu) component;
                m.setVisible(false);
            } else if (component.toString().contains("Crear")) {
                System.out.println("Crear");
                JMenu m = (JMenu) component;
                m.setVisible(false);
            } else if (component.toString().contains("Archivo")) {
                System.out.println("Crear");
                JMenu m = (JMenu) component;
                m.setVisible(false);

            }
        }
    }
    private JMenuBar bar;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
