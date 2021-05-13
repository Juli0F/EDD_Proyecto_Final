package com.mycompany.main;

import com.mycompany.edd_proyecto_final.arboles.AVL;
import com.mycompany.edd_proyecto_final.entidades.Estudiante;
import com.mycompany.edd_proyecto_final.listas.DobleCircular;
import com.mycompany.edd_proyecto_final.listas.ListaSimple;
import com.mycompany.edd_proyecto_final.listas.SimpleCircular;
import com.mycompany.exception.PopException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        DobleCircular<Estudiante> lstSimple = new DobleCircular<>();
        AVL<Estudiante> avl = new AVL<>();
//        avl.insertar(1);
//        avl.insertar(2);
//        avl.insertar(3);
//        avl.insertar(4);
//        avl.insertar(5);
//        avl.insertar(6);
        avl.insertar(new Estudiante("01", "Julio-01", "Xela"));
        avl.insertar(new Estudiante("02", "Julio-02", "Xela"));
        avl.insertar(new Estudiante("03", "Julio-03", "Xela"));
        avl.insertar(new Estudiante("04", "Julio-04", "Xela"));
        avl.insertar(new Estudiante("05", "Julio-05", "Xela"));
        avl.insertar(new Estudiante("06", "Julio-06", "Xela"));
        
        System.out.println(avl.testGraph());
        
        

//        lstSimple.push("Uno");
//        lstSimple.push("Dos");
//        lstSimple.push("Tres");
//        lstSimple.push("Cuatro");
//        
//        
//        lstSimple.push(new Estudiante("01", "Julio", "Xela"));
//        lstSimple.push(new Estudiante("02", "Fernando", "Xela"));
//        lstSimple.push(new Estudiante("03", "Julio-03", "Xela"));
//        lstSimple.push(new Estudiante("04", "Julio-04", "Xela"));
//        lstSimple.push(new Estudiante("05", "Julio-05", "Xela"));
//
//        lstSimple.delete(10);
//
//        System.out.println("digraph g {\n" + lstSimple.testP() + "\n}");

    }

}
