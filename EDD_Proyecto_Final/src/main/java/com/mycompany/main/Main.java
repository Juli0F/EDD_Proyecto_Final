package com.mycompany.main;

import com.mycompany.edd_proyecto_final.arboles.AVL;
import com.mycompany.edd_proyecto_final.entidades.Catedratico;
import com.mycompany.edd_proyecto_final.entidades.Edificio;
import com.mycompany.edd_proyecto_final.entidades.Estudiante;
import com.mycompany.edd_proyecto_final.entidades.Salon;
import com.mycompany.edd_proyecto_final.entidades.Usuario;
import com.mycompany.edd_proyecto_final.hash.HashTable;
import com.mycompany.edd_proyecto_final.listas.DobleCircular;
import com.mycompany.edd_proyecto_final.listas.ListaSimple;
import com.mycompany.edd_proyecto_final.listas.SimpleCircular;
import com.mycompany.exception.PopException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        m.testHash();
//
//        ListaSimple<Edificio> lstSimple = new ListaSimple<>();
//        Edificio e = new Edificio("ed-1");
//        //System.out.println("e"+ e.toString());
//        e.getLstSalon().push(new Salon("ed-1-1", "20"));
//        e.getLstSalon().push(new Salon("ed-1-2", "20"));
//        e.getLstSalon().push(new Salon("ed-1-3", "20"));
//        e.getLstSalon().push(new Salon("ed-1-4", "20"));
//        e.getLstSalon().push(new Salon("ed-1-5", "20"));
//        e.getLstSalon().push(new Salon("ed-1-6", "20"));
//
//        lstSimple.push(e);
//
//        e = new Edificio("ed-2");
//        e.getLstSalon().push(new Salon("ed-2-1", "20"));
//        e.getLstSalon().push(new Salon("ed-2-2", "20"));
//        e.getLstSalon().push(new Salon("ed-2-3", "20"));
//        e.getLstSalon().push(new Salon("ed-2-4", "20"));
//        e.getLstSalon().push(new Salon("ed-2-5", "20"));
//        e.getLstSalon().push(new Salon("ed-2-6", "20"));
//        lstSimple.push(e);
//
//        System.out.println("size " + lstSimple.size());
//
//        System.out.println(lstSimple.testGraph(lstSimple.get(1).hashCode()));
//
////        
////        Estudiante s = new Estudiante("1","estudiante","test");
////        Catedratico c = new Catedratico("1", "Catedratico", "123");
////        Usuario u = new Usuario("1", "1", "password", "1");
////        
////        System.out.println("s: "+ s.hashCode());
////        System.out.println("c: "+ c.hashCode());
////        System.out.println("u: "+u.hashCode());
//        
    }
    public void testHash(){
        Edificio e = new Edificio("e-0");
        Edificio e1 = new Edificio("e-1");
        Edificio e2 = new Edificio("e-2");
        Edificio e3 = new Edificio("e-3");
        Edificio e4 = new Edificio("e-4");
        Edificio e5 = new Edificio("e-5");
        Edificio e6 = new Edificio("e-6");
        Edificio e7 = new Edificio("e-7");
        Edificio e8 = new Edificio("e-8");
        Edificio e9 = new Edificio("e-9");
        
        
        
        HashTable<Edificio> hashTest = new HashTable<>();
        hashTest.insertar(e);
        hashTest.insertar(e1);
        hashTest.insertar(e2);
        hashTest.insertar(e3);
        hashTest.insertar(e4);
        hashTest.insertar(e5);
        hashTest.insertar(e6);
        hashTest.insertar(e7);
        hashTest.insertar(e8);
        hashTest.insertar(e9);
        
        
//        Edificio eRec = hashTest.getValue(new Edificio("e-10"));
//        System.out.println((eRec== null)?"null":eRec.getId());
//        
        hashTest.eliminar(new Edificio("e-9"));
        Edificio eRec = hashTest.getValue(new Edificio("e-9"));
        System.out.println((eRec== null)?"null":eRec.getId());
        
        
        System.out.println(hashTest.testGraph());
        
        
    }

}
