/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edd_practica_2.readf_file;

import com.mycompany.edd_proyecto_final.arboles.AVL;
import com.mycompany.edd_proyecto_final.entidades.Catedratico;
import com.mycompany.edd_proyecto_final.entidades.Curso;
import com.mycompany.edd_proyecto_final.entidades.Edificio;
import com.mycompany.edd_proyecto_final.entidades.Estudiante;
import com.mycompany.edd_proyecto_final.entidades.Persona;
import com.mycompany.edd_proyecto_final.entidades.Salon;
import com.mycompany.edd_proyecto_final.entidades.Usuario;
import com.mycompany.edd_proyecto_final.listas.ListaDoble;

/**
 *
 * @author Temporal
 */
public class Interprete {
    
    public static ListaDoble<Edificio> lstEdificios = new ListaDoble<>();
    public static ListaDoble<Curso> lstCursos = new ListaDoble<>();
    public static ListaDoble<Usuario> lstUsr = new ListaDoble<>();
    public static AVL<Catedratico> treeAvl = new AVL<>();
    
    public Interprete() {
        
    }
    
    public void interpreteEstudiante(String linea) throws Exception {
        
        String[] datos = linea.split(",");
        Persona p = new Estudiante(datos[0], datos[1], datos[2]);
    }
    
    public void interpreteUsuario(String linea) throws Exception {
        
        String[] datos = linea.split(",");
        Usuario usuario = new Usuario(datos[0], datos[1], datos[2], datos[3]);
        if (!lstUsr.contains(usuario)) {
            if (datos[3].equalsIgnoreCase("estudiante") || datos[3].equalsIgnoreCase("colaborador")) {
                
                lstUsr.push(usuario);
            }else{
                Read.lstErr.push("Tipo de Usuario No valido: " + datos[0] + ", " + datos[1] );
            }
        } else {
            Read.lstErr.push("Usuario : " + datos[0] + ", " + datos[1] + " ya se encuentra registrado");
        }
    }
    
    public void interpreteCatedratico(String linea) throws Exception {
        String[] datos = linea.split(",");
        Catedratico catedratico = new Catedratico(datos[0], datos[1], datos[2]);
        
        if (treeAvl.buscar(catedratico) == null) {
            treeAvl.insertar(catedratico);
        } else {
            Read.lstErr.push("Codigo De Catedratico: " + datos[0] + " ya se encuentra registrado");
        }
        
    }
    
    public void interpreteEdificio(String linea) throws Exception {
        
        Edificio edificio = new Edificio(linea);
        if (!lstEdificios.contains(edificio)) {
            lstEdificios.push(edificio);
        } else {
            Read.lstErr.push("Edificio: " + linea + " ya se encuentra registrado");
        }
    }
    
    public void interpreteSalon(String linea) throws Exception {
        String[] datos = linea.split(",");
        Edificio temp = new Edificio(datos[0]);
        Salon salon = new Salon(datos[1], datos[2]);
        
        if (lstEdificios.contains(temp)) {
            temp = lstEdificios.get(temp);
            temp.getLstSalon().push(salon);
        } else {
            Read.lstErr.push("No se Encontro Edificio: " + datos[0] + " no se almaceno El Salon Con los Datos: " + salon.toString());
        }
        
    }
    
    public void interpreteCurso(String linea) throws Exception {
        String[] datos = linea.split(",");
        Curso curso = new Curso(datos[0], datos[1], datos[2], datos[3]);
        
        if (!lstCursos.contains(curso)) {
            lstCursos.push(curso);
        } else {
            Read.lstErr.push("Codigo de Curso: " + datos[0] + " Ya Se Encuntra Registrado! ");
        }
    }
    
    public void interpreteHorario(String linea) throws Exception {
        
    }
    
    public void interpreteAsignar(String linea) throws Exception {
        
    }
}
