/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edd_practica_2.readf_file;

import com.mycompany.edd_proyecto_final.arboles.AVL;
import com.mycompany.edd_proyecto_final.entidades.Asignacion;
import com.mycompany.edd_proyecto_final.entidades.Catedratico;
import com.mycompany.edd_proyecto_final.entidades.Curso;
import com.mycompany.edd_proyecto_final.entidades.Edificio;
import com.mycompany.edd_proyecto_final.entidades.Estudiante;
import com.mycompany.edd_proyecto_final.entidades.Horario;
import com.mycompany.edd_proyecto_final.entidades.Salon;
import com.mycompany.edd_proyecto_final.entidades.Usuario;
import com.mycompany.edd_proyecto_final.hash.HashTable;
import com.mycompany.edd_proyecto_final.listas.ListaDoble;

public class Interprete {
    
    public static ListaDoble<Edificio> lstEdificios = new ListaDoble<>();
    public static ListaDoble<Curso> lstCursos = new ListaDoble<>();
    public static ListaDoble<Usuario> lstUsr = new ListaDoble<>();
    public static AVL<Catedratico> treeAvl = new AVL<>();
    public static HashTable<Estudiante> hashEstudiante = new HashTable<>();
    public static AVL<Horario> treeHorario = new AVL<>();
    public static ListaDoble<Asignacion> lstAsignacion = new ListaDoble<>();
    //public static AVL<Salon> AVLsalon = new AVL<>();
    
    public Interprete() {
        
    }
    
    public void interpreteEstudiante(String linea) throws Exception {
        
        String[] datos = linea.split(",");
        Estudiante p = new Estudiante(datos[0], datos[1], datos[2]);
        hashEstudiante.insertar(p);
        
    }
    
    public void interpreteUsuario(String linea) throws Exception {
        
        String[] datos = linea.split(",");
        Usuario usuario = new Usuario(datos[0], datos[1], datos[2], datos[3]);
        if (!lstUsr.contains(usuario)) {
            System.out.println("tipo: "+datos[3]);
            if (datos[3].equalsIgnoreCase("estudiante") || datos[3].equalsIgnoreCase("colaborador")) {
            System.out.println("tipo: "+datos[4]+" ..insertando");    
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
//            AVLsalon.insertar(salon);
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
        String[] datos = linea.split(",");
        //Horario
        //   0      1       2       3       4           5           6      
        //(código, período, día, codCurso, codSalón, codEdificio, numIdentificacion);
        Edificio e = lstEdificios.get(new Edificio(datos[5]));
        if (e == null) {
            Read.lstErr.push("Codigo del Edificio: " + datos[5] + " No Se Encuntra Registrado! ");
        }else{
            Salon s = e.getLstSalon().get(new Salon(datos[4], ""));
            if (s != null) {
               // Horario horario = new Horario(datos[0], datos[1], datos[2], s, curso, catedratico)
               Curso curso = lstCursos.get(new Curso(datos[3], "", "", ""));
                if (curso != null) {
                    Catedratico catedratico = treeAvl.buscar(new Catedratico(datos[6], "", ""));
                  Horario horario = new Horario(datos[0], datos[1], datos[2], s, curso, catedratico);  
                    treeHorario.insertar(horario);
                }else{
                    Read.lstErr.push("Codigo de Catedratico: " + datos[3] + " No Se Encuntra Registrado! ");
                }
            }else{
                Read.lstErr.push("Codigo de Salon: " + datos[4] + " No Se Encuntra Registrado! ");
            }
        }
    }
    
    public void interpreteAsignar(String linea) throws Exception {
        String[] datos = linea.split(",");
            //      0          1       2      3
        //Asignar(carnet, codHorario, zona, final)
        
        Horario horario = treeHorario.buscar(new Horario(datos[1]));
        
        if (horario.getSalon().isDisponible()) {
            Estudiante estudiante = hashEstudiante.getValue(new Estudiante(datos[0], "",""));
            if (estudiante != null) {
                Asignacion asignacion = new Asignacion(estudiante, horario, datos[2], datos[3]);
                lstAsignacion.push(asignacion);
            }else{
                Read.lstErr.push("Codigo de Estudiante: " + datos[0] + " No Se Encuntra Registrado! ");
            }
        }else{
            Read.lstErr.push("Codigo de Horario: " + datos[1] + " No Se Encuntra Registrado! ");
        }
        
        
    }
}
