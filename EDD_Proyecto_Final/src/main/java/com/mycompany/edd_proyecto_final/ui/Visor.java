package com.mycompany.edd_proyecto_final.ui;

import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class Visor extends javax.swing.JInternalFrame {

    public Visor(String pathImg) {

        initComponents();
        this.pathImg = pathImg;
        view();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jLabel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void view() {

        String ruta;

        try {
            File archivoelegido = new File(pathImg);
            ruta = archivoelegido.getPath();
            ImageIcon imagen = new ImageIcon(pathImg);
            jLabel1.setIcon(imagen);
            jLabel1.setVisible(true);
            System.out.println("Cargando Imagen");
            // jScrollPane1.setBounds(160, 10, 410, 300);
            jScrollPane1.setViewportView(jLabel1);
            jScrollPane1.setVisible(true);
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error Al Cargar Imagen", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }

    private String pathImg;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
