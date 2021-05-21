


package com.mycompany.edd_proyecto_final.ui;

import com.mycompany.edd_proyecto_final.entidades.Asignacion;
import com.mycompany.edd_proyecto_final.entidades.Estudiante;
import javax.swing.table.DefaultTableModel;

public class HomeStudent extends javax.swing.JInternalFrame {


    public HomeStudent(Estudiante estudiante) {
        initComponents();
        this.setTitle("Notas");
        this.estudiante = estudiante;
        datosHome();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Curso", "Zona", "Final", "Nota"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setRowHeight(32);
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void datosHome(){
        DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
        
        for (int i = 0; i < Desktop.lstAsignacion.size(); i++) {
            Asignacion asignacion = Desktop.lstAsignacion.get(i);
            if (asignacion.getEstudiante().equals(estudiante)) {
                dtm.addRow(new Object[]{
                    asignacion.getHorario().getCurso().getNombre(), asignacion.getZona(),asignacion.getFin(),asignacion.getNotaFinal()
                });
            }
            
        }
        jTable2.setModel(dtm);
    }
    private Estudiante estudiante;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables

}
