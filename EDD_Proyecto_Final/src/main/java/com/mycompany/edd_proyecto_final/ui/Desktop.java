/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edd_proyecto_final.ui;

import com.mycompany.edd_practica_2.readf_file.Interprete;
import com.mycompany.edd_proyecto_final.arboles.AVL;
import com.mycompany.edd_proyecto_final.arboles.b.ArbolB;
import com.mycompany.edd_proyecto_final.entidades.Asignacion;
import com.mycompany.edd_proyecto_final.entidades.Catedratico;
import com.mycompany.edd_proyecto_final.entidades.Curso;
import com.mycompany.edd_proyecto_final.entidades.Edificio;
import com.mycompany.edd_proyecto_final.entidades.Estudiante;
import com.mycompany.edd_proyecto_final.entidades.Horario;
import com.mycompany.edd_proyecto_final.entidades.Usuario;
import com.mycompany.edd_proyecto_final.hash.HashTable;
import com.mycompany.edd_proyecto_final.io.WriteFile;
import com.mycompany.edd_proyecto_final.listas.ListaDoble;
import com.mycompany.edd_proyecto_final.listas.ListaSimple;
import javax.swing.JInternalFrame;

public class Desktop extends javax.swing.JFrame {

    
    public Desktop() {
        initComponents();
        setLocationRelativeTo(null);
        menuBar.setVisible(false);
        agregarInternal(new Login(menuBar,this));
        
        if (estudiante != null) {
            rep2.setVisible(false);
            rep3.setVisible(false);
            rep4.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        btnFile = new javax.swing.JMenu();
        btnCargar = new javax.swing.JMenuItem();
        btnSave = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        btnCrear = new javax.swing.JMenu();
        crearEstudiante = new javax.swing.JMenuItem();
        crearCatedratico = new javax.swing.JMenuItem();
        crearHorario = new javax.swing.JMenuItem();
        aboutMenuItem3 = new javax.swing.JMenuItem();
        aboutMenuItem5 = new javax.swing.JMenuItem();
        aboutMenuItem6 = new javax.swing.JMenuItem();
        aboutMenuItem9 = new javax.swing.JMenuItem();
        aboutMenuItem7 = new javax.swing.JMenuItem();
        btnEditar = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        editCatedratico = new javax.swing.JMenuItem();
        aboutMenuItem10 = new javax.swing.JMenuItem();
        aboutMenuItem8 = new javax.swing.JMenuItem();
        btnGraficar = new javax.swing.JMenu();
        graphEstudiante = new javax.swing.JMenuItem();
        graphCatedratico = new javax.swing.JMenuItem();
        graphHorario = new javax.swing.JMenuItem();
        graphCurso = new javax.swing.JMenuItem();
        graphUsuario = new javax.swing.JMenuItem();
        graphEdificio = new javax.swing.JMenuItem();
        graphAsignacion = new javax.swing.JMenuItem();
        btnAcerca = new javax.swing.JMenu();
        contentMenuItem1 = new javax.swing.JMenuItem();
        rep2 = new javax.swing.JMenuItem();
        rep3 = new javax.swing.JMenuItem();
        rep4 = new javax.swing.JMenuItem();
        btnSalir = new javax.swing.JMenu();
        exitMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnFile.setMnemonic('f');
        btnFile.setText("Archivo");

        btnCargar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        btnCargar.setMnemonic('o');
        btnCargar.setText("Cargar");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });
        btnFile.add(btnCargar);

        btnSave.setMnemonic('s');
        btnSave.setText("Guardar");
        btnFile.add(btnSave);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Salir");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        btnFile.add(exitMenuItem);

        menuBar.add(btnFile);

        btnCrear.setMnemonic('h');
        btnCrear.setText("Crear");

        crearEstudiante.setMnemonic('c');
        crearEstudiante.setText("Estudiante");
        crearEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearEstudianteActionPerformed(evt);
            }
        });
        btnCrear.add(crearEstudiante);

        crearCatedratico.setMnemonic('a');
        crearCatedratico.setText("Catedratico");
        crearCatedratico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearCatedraticoActionPerformed(evt);
            }
        });
        btnCrear.add(crearCatedratico);

        crearHorario.setMnemonic('a');
        crearHorario.setText("Horario");
        crearHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearHorarioActionPerformed(evt);
            }
        });
        btnCrear.add(crearHorario);

        aboutMenuItem3.setMnemonic('a');
        aboutMenuItem3.setText("Curso");
        aboutMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItem3ActionPerformed(evt);
            }
        });
        btnCrear.add(aboutMenuItem3);

        aboutMenuItem5.setMnemonic('a');
        aboutMenuItem5.setText("Usuario");
        aboutMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItem5ActionPerformed(evt);
            }
        });
        btnCrear.add(aboutMenuItem5);

        aboutMenuItem6.setMnemonic('a');
        aboutMenuItem6.setText("Edificio");
        aboutMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItem6ActionPerformed(evt);
            }
        });
        btnCrear.add(aboutMenuItem6);

        aboutMenuItem9.setMnemonic('a');
        aboutMenuItem9.setText("Salon");
        aboutMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItem9ActionPerformed(evt);
            }
        });
        btnCrear.add(aboutMenuItem9);

        aboutMenuItem7.setMnemonic('a');
        aboutMenuItem7.setText("Asignacion");
        aboutMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItem7ActionPerformed(evt);
            }
        });
        btnCrear.add(aboutMenuItem7);

        menuBar.add(btnCrear);

        btnEditar.setMnemonic('e');
        btnEditar.setText("Editar");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Estudiante");
        cutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutMenuItemActionPerformed(evt);
            }
        });
        btnEditar.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Catedratico");
        copyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyMenuItemActionPerformed(evt);
            }
        });
        btnEditar.add(copyMenuItem);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Horario");
        pasteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteMenuItemActionPerformed(evt);
            }
        });
        btnEditar.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Curso");
        deleteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMenuItemActionPerformed(evt);
            }
        });
        btnEditar.add(deleteMenuItem);

        editCatedratico.setMnemonic('a');
        editCatedratico.setText("Catedratico");
        editCatedratico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCatedraticoActionPerformed(evt);
            }
        });
        btnEditar.add(editCatedratico);

        aboutMenuItem10.setMnemonic('a');
        aboutMenuItem10.setText("Salon");
        aboutMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItem10ActionPerformed(evt);
            }
        });
        btnEditar.add(aboutMenuItem10);

        aboutMenuItem8.setMnemonic('a');
        aboutMenuItem8.setText("Asignacion");
        aboutMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItem8ActionPerformed(evt);
            }
        });
        btnEditar.add(aboutMenuItem8);

        menuBar.add(btnEditar);

        btnGraficar.setMnemonic('h');
        btnGraficar.setText("Graficar");

        graphEstudiante.setMnemonic('c');
        graphEstudiante.setText("Estudiante");
        graphEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphEstudianteActionPerformed(evt);
            }
        });
        btnGraficar.add(graphEstudiante);

        graphCatedratico.setMnemonic('a');
        graphCatedratico.setText("Catedratico");
        graphCatedratico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphCatedraticoActionPerformed(evt);
            }
        });
        btnGraficar.add(graphCatedratico);

        graphHorario.setMnemonic('a');
        graphHorario.setText("Horario");
        graphHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphHorarioActionPerformed(evt);
            }
        });
        btnGraficar.add(graphHorario);

        graphCurso.setMnemonic('a');
        graphCurso.setText("Curso");
        graphCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphCursoActionPerformed(evt);
            }
        });
        btnGraficar.add(graphCurso);

        graphUsuario.setMnemonic('a');
        graphUsuario.setText("Usuario");
        graphUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphUsuarioActionPerformed(evt);
            }
        });
        btnGraficar.add(graphUsuario);

        graphEdificio.setMnemonic('a');
        graphEdificio.setText("Edificio");
        graphEdificio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphEdificioActionPerformed(evt);
            }
        });
        btnGraficar.add(graphEdificio);

        graphAsignacion.setMnemonic('a');
        graphAsignacion.setText("Asignacion");
        graphAsignacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphAsignacionActionPerformed(evt);
            }
        });
        btnGraficar.add(graphAsignacion);

        menuBar.add(btnGraficar);

        btnAcerca.setMnemonic('h');
        btnAcerca.setText("Reportes");

        contentMenuItem1.setMnemonic('c');
        contentMenuItem1.setText("Asignacion Por Estudiante");
        contentMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentMenuItem1ActionPerformed(evt);
            }
        });
        btnAcerca.add(contentMenuItem1);

        rep2.setMnemonic('c');
        rep2.setText("Asignacion A Un Curso");
        rep2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rep2ActionPerformed(evt);
            }
        });
        btnAcerca.add(rep2);

        rep3.setMnemonic('c');
        rep3.setText("Cursos en un Salon");
        rep3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rep3ActionPerformed(evt);
            }
        });
        btnAcerca.add(rep3);

        rep4.setMnemonic('c');
        rep4.setText("Estudiantes Aprobados");
        rep4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rep4ActionPerformed(evt);
            }
        });
        btnAcerca.add(rep4);

        menuBar.add(btnAcerca);

        btnSalir.setMnemonic('e');
        btnSalir.setText("Salir");

        exitMenuItem1.setMnemonic('x');
        exitMenuItem1.setText("Salir");
        exitMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItem1ActionPerformed(evt);
            }
        });
        btnSalir.add(exitMenuItem1);

        menuBar.add(btnSalir);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1004, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        //System.exit(0);

        //agregarInternal(new Login(menuBar));
//        Login login = new Login(menuBar);
//        login.setSize(250, 400);
//
//        login.setLocation(desktopPane.getWidth() / 2 - 125, desktopPane.getHeight() / 2 - 200);
//        login.setVisible(true);
//        desktopPane.repaint();
//        desktopPane.add(login);
//        desktopPane.revalidate();

        agregarInternal(new Login(menuBar,this));
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed

        agregarInternal(new LoadFile());
    }//GEN-LAST:event_btnCargarActionPerformed

    private void deleteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMenuItemActionPerformed
        agregarInternal(new EditarCurso());
    }//GEN-LAST:event_deleteMenuItemActionPerformed

    private void graphEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphEstudianteActionPerformed
        String graph = "digraph hash{\n ";
        graph += hashEstudiante.testGraph();
        graph += "\n}";
        writeGraph("estudiante.dot", "estudiante.png", graph);
        agregarInternal(new Visor("estudiante.png"));
    }//GEN-LAST:event_graphEstudianteActionPerformed

    private void graphCatedraticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphCatedraticoActionPerformed
        String graph = "digraph c { \n";
        graph += treeAvl.testGraph();
        graph += "\n}";
        writeGraph("catedratico.dot", "catedratico.png", graph);
        
        agregarInternal(new Visor("catedratico.png"));
        
    }//GEN-LAST:event_graphCatedraticoActionPerformed

    private void graphHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphHorarioActionPerformed
        String graph = Desktop.treeHorario.testGraph();
        writeGraph("horario.dot", "horario.png", graph);
        agregarInternal(new Visor("horario.png"));
    }//GEN-LAST:event_graphHorarioActionPerformed

    private void graphCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphCursoActionPerformed
        String graph = "digraph curso { \n";
        graph += lstCursos.testGraph();
        graph += "\n}";
        writeGraph("curso.dot", "curso.png", graph);
        agregarInternal(new Visor("curso.png"));
    }//GEN-LAST:event_graphCursoActionPerformed

    private void graphUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphUsuarioActionPerformed
        String graph = "digraph usuario { \n";
        graph += lstUsr.testGraph();
        graph += "\n}";
        writeGraph("usuario.dot", "usuario.png", graph);
        agregarInternal(new Visor("usuario.png"));
    }//GEN-LAST:event_graphUsuarioActionPerformed

    private void graphEdificioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphEdificioActionPerformed
        String graph = "digraph Edificio { \n";
        graph += lstEdificios.testGraph();
        graph += "\n}";
        writeGraph("edificio.dot", "edificio.png", graph);
        agregarInternal(new Visor("edificio.png"));
    }//GEN-LAST:event_graphEdificioActionPerformed

    private void graphAsignacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphAsignacionActionPerformed
        String graph = "digraph Edificio { \n";
        graph += lstAsignacion.testGraph();
        graph += "\n}";
        writeGraph("Asignacion.dot", "Asignacion.png", graph);
        agregarInternal(new Visor("asignacion.png"));
    }//GEN-LAST:event_graphAsignacionActionPerformed

    private void aboutMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItem5ActionPerformed
        agregarInternal(new CrearUsuario());
    }//GEN-LAST:event_aboutMenuItem5ActionPerformed

    private void crearEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearEstudianteActionPerformed
        agregarInternal(new CrearEstudiante());
    }//GEN-LAST:event_crearEstudianteActionPerformed

    private void cutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutMenuItemActionPerformed
        agregarInternal(new EditarEstudiante());
    }//GEN-LAST:event_cutMenuItemActionPerformed

    private void crearCatedraticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearCatedraticoActionPerformed
        agregarInternal(new CrearCatedratico());
    }//GEN-LAST:event_crearCatedraticoActionPerformed

    private void aboutMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItem6ActionPerformed
        agregarInternal(new CrearEdificio());
    }//GEN-LAST:event_aboutMenuItem6ActionPerformed

    private void aboutMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItem9ActionPerformed
        agregarInternal(new CrearSalon());
    }//GEN-LAST:event_aboutMenuItem9ActionPerformed

    private void aboutMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItem10ActionPerformed
        agregarInternal(new EditSalon());
    }//GEN-LAST:event_aboutMenuItem10ActionPerformed

    private void copyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyMenuItemActionPerformed
        agregarInternal(new EditarCatedratico());
    }//GEN-LAST:event_copyMenuItemActionPerformed

    private void aboutMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItem8ActionPerformed
        agregarInternal(new EditarAsignacion());
    }//GEN-LAST:event_aboutMenuItem8ActionPerformed

    private void aboutMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItem7ActionPerformed
        agregarInternal(new CrearAsignacion());
    }//GEN-LAST:event_aboutMenuItem7ActionPerformed

    private void crearHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearHorarioActionPerformed
        agregarInternal(new CrearHorario());
    }//GEN-LAST:event_crearHorarioActionPerformed

    private void aboutMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItem3ActionPerformed
        agregarInternal(new CrearCurso());
    }//GEN-LAST:event_aboutMenuItem3ActionPerformed

    private void pasteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteMenuItemActionPerformed
        agregarInternal(new EditarHorario());
    }//GEN-LAST:event_pasteMenuItemActionPerformed

    private void editCatedraticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCatedraticoActionPerformed
        agregarInternal(new EditarCatedratico());
    }//GEN-LAST:event_editCatedraticoActionPerformed

    private void exitMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItem1ActionPerformed
        agregarInternal(new Login(menuBar,this));
    }//GEN-LAST:event_exitMenuItem1ActionPerformed

    private void contentMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contentMenuItem1ActionPerformed
        agregarInternal(new PrimerReporte(estudiante));
    }//GEN-LAST:event_contentMenuItem1ActionPerformed

    private void rep2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rep2ActionPerformed
        agregarInternal(new SegundoReporte());
    }//GEN-LAST:event_rep2ActionPerformed

    private void rep3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rep3ActionPerformed
        agregarInternal(new TercerReporte());
    }//GEN-LAST:event_rep3ActionPerformed

    private void rep4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rep4ActionPerformed
        agregarInternal(new CuartoReporte());
    }//GEN-LAST:event_rep4ActionPerformed

    public void agregarInternal(JInternalFrame internal) {
        //internal.setSize(desktopPane.getSize());
         internal.setLocation(desktopPane.getWidth() / 2 - (internal.getWidth()/2), desktopPane.getHeight() / 2 - (internal.getHeight()/2));
        internal.setVisible(true);
        desktopPane.removeAll();
        desktopPane.repaint();
        desktopPane.add(internal);
        desktopPane.repaint();
        desktopPane.revalidate();

    }

    private void writeGraph(String nameDot, String namePng,String content){
        wf = new WriteFile();
        wf.writeFile(nameDot, content);
        wf.dibujar(nameDot, namePng);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Desktop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Desktop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Desktop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Desktop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Desktop().setVisible(true);
            }
        });
    }
    private WriteFile wf;
    
    public static Estudiante estudiante;
    public static ListaDoble<Edificio> lstEdificios = new ListaDoble<>();
    public static ListaDoble<Curso> lstCursos = new ListaDoble<>();
    public static ListaDoble<Usuario> lstUsr = new ListaDoble<>();
    public static AVL<Catedratico> treeAvl = new AVL<>();
    public static HashTable<Estudiante> hashEstudiante = new HashTable<>();
    public static ArbolB<Horario> treeHorario = new ArbolB<>(Horario.class);
    public static ListaDoble<Asignacion> lstAsignacion = new ListaDoble<>();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem10;
    private javax.swing.JMenuItem aboutMenuItem3;
    private javax.swing.JMenuItem aboutMenuItem5;
    private javax.swing.JMenuItem aboutMenuItem6;
    private javax.swing.JMenuItem aboutMenuItem7;
    private javax.swing.JMenuItem aboutMenuItem8;
    private javax.swing.JMenuItem aboutMenuItem9;
    private javax.swing.JMenu btnAcerca;
    private javax.swing.JMenuItem btnCargar;
    private javax.swing.JMenu btnCrear;
    private javax.swing.JMenu btnEditar;
    private javax.swing.JMenu btnFile;
    private javax.swing.JMenu btnGraficar;
    private javax.swing.JMenu btnSalir;
    private javax.swing.JMenuItem btnSave;
    private javax.swing.JMenuItem contentMenuItem1;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem crearCatedratico;
    private javax.swing.JMenuItem crearEstudiante;
    private javax.swing.JMenuItem crearHorario;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem editCatedratico;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenuItem exitMenuItem1;
    private javax.swing.JMenuItem graphAsignacion;
    private javax.swing.JMenuItem graphCatedratico;
    private javax.swing.JMenuItem graphCurso;
    private javax.swing.JMenuItem graphEdificio;
    private javax.swing.JMenuItem graphEstudiante;
    private javax.swing.JMenuItem graphHorario;
    private javax.swing.JMenuItem graphUsuario;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem rep2;
    private javax.swing.JMenuItem rep3;
    private javax.swing.JMenuItem rep4;
    // End of variables declaration//GEN-END:variables

}
