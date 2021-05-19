package com.mycompany.main;

import com.mycompany.edd_proyecto_final.arboles.AVL;
import com.mycompany.edd_proyecto_final.entidades.Catedratico;
import com.mycompany.edd_proyecto_final.entidades.Edificio;
import com.mycompany.edd_proyecto_final.entidades.Estudiante;
import com.mycompany.edd_proyecto_final.entidades.Salon;
import com.mycompany.edd_proyecto_final.entidades.Usuario;
import com.mycompany.edd_proyecto_final.hash.HashTable;
import com.mycompany.edd_proyecto_final.io.WriteFile;
import com.mycompany.edd_proyecto_final.listas.DobleCircular;
import com.mycompany.edd_proyecto_final.listas.ListaDoble;
import com.mycompany.edd_proyecto_final.listas.ListaSimple;
import com.mycompany.edd_proyecto_final.listas.SimpleCircular;
import com.mycompany.exception.PopException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        // Main m = new Main();
        //m.testHash();
//
        ListaDoble<Edificio> lstSimple = new ListaDoble<>();
        

        for (int i = 0; i < 4; i++) {
            Edificio e = new Edificio("ed-"+i);

            for (int j = 0; j < 10; j++) {

                e.getLstSalon().push(new Salon("ed-"+i+"-" + j, "20"));
            }
            lstSimple.push(e);
        }
        System.out.println("size " + lstSimple.size());

        //System.out.println(lstSimple.testGraph());
        WriteFile wf = new WriteFile();
        String graph = "digraph  test {\n"+lstSimple.testGraph()+"\n}";
        wf.writeFile("file.dot", graph);
        wf.dibujar("file.dot", "file.png");
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

    public void testHash() {
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
        System.out.println((eRec == null) ? "null" : eRec.getId());

        System.out.println(hashTest.testGraph());

    }

}
