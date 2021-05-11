/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.main;

import com.mycompany.edd_proyecto_final.listas.ListaSimple;
import com.mycompany.edd_proyecto_final.listas.SimpleCircular;
import com.mycompany.exception.PopException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author <a>@Julio_Ixcoy_</a>
 */
public class Main {
    
    public static void main(String[] args) {
        SimpleCircular<String> lstSimple = new SimpleCircular<>();
        
        lstSimple.push("Uno");
        lstSimple.push("Dos");
        lstSimple.push("Tres");
        lstSimple.push("Cuatro");
        
        
            lstSimple.delete(10);
        System.out.println("get "+lstSimple.get(2));
       
        System.out.println("to String\n"+lstSimple.toString());
        
    }
    
}
