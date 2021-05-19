
package com.mycompany.edd_proyecto_final.ui;

import com.mycompany.edd_proyecto_final.entidades.Estudiante;
import javax.swing.JOptionPane;

public class CrearEstudiante extends javax.swing.JInternalFrame {

    
    public CrearEstudiante() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCarnet = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();

        jLabel1.setText("Carnet");

        jLabel2.setText("Nombre");

        jLabel3.setText("Direccion");

        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107))))
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(txtDireccion)
                    .addComponent(btnCrear, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        if (txtCarnet.getText().isBlank() || txtCarnet.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Carnet es Obligatorio", "Informacion", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Estudiante estudiannte = Desktop.hashEstudiante.getValue(new Estudiante(txtCarnet.getText(), "", ""));
        
        if (estudiannte == null) {
         estudiannte = new Estudiante(txtCarnet.getText(), txtNombre.getText(), txtDireccion.getText());
            
            if (Desktop.hashEstudiante.insertar(estudiannte)) {
                JOptionPane.showMessageDialog(null, "Estudiante Registrado COrrectamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                clearTex();
                return;
            }
            
        }
        JOptionPane.showMessageDialog(null, "Estudiante No se Pudo Registrar", "Informacion", JOptionPane.ERROR_MESSAGE);
        
        
    }//GEN-LAST:event_btnCrearActionPerformed

    private void clearTex(){
        txtCarnet.setText("");
        txtDireccion.setText("");
        txtNombre.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtCarnet;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
