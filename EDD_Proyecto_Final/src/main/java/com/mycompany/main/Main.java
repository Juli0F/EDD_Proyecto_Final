package com.mycompany.main;

import com.mycompany.edd_proyecto_final.arboles.AVL;
import com.mycompany.edd_proyecto_final.entidades.Catedratico;
import com.mycompany.edd_proyecto_final.entidades.Estudiante;
import com.mycompany.edd_proyecto_final.entidades.Usuario;
import com.mycompany.edd_proyecto_final.listas.DobleCircular;
import com.mycompany.edd_proyecto_final.listas.ListaSimple;
import com.mycompany.edd_proyecto_final.listas.SimpleCircular;
import com.mycompany.exception.PopException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
       
        ListaSimple<Integer> lstSimple = new ListaSimple<>(37);
        lstSimple.push(5, 20);
        System.out.println("size: "+ lstSimple.size());
        System.out.println("value: "+ lstSimple.get(20));
        
        Estudiante s = new Estudiante("1","estudiante","test");
        Catedratico c = new Catedratico("1", "Catedratico", "123");
        Usuario u = new Usuario("1", "1", "password", "1");
        
        System.out.println("s: "+ s.hashCode());
        System.out.println("c: "+ c.hashCode());
        System.out.println("u: "+u.hashCode());
        
    }

}
