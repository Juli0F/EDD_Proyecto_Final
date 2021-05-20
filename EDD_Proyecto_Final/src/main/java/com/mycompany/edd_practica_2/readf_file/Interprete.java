/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edd_practica_2.readf_file;

import com.mycompany.edd_proyecto_final.arboles.b.Key;
import com.mycompany.edd_proyecto_final.entidades.Asignacion;
import com.mycompany.edd_proyecto_final.entidades.Catedratico;
import com.mycompany.edd_proyecto_final.entidades.Curso;
import com.mycompany.edd_proyecto_final.entidades.Edificio;
import com.mycompany.edd_proyecto_final.entidades.Estudiante;
import com.mycompany.edd_proyecto_final.entidades.Horario;
import com.mycompany.edd_proyecto_final.entidades.Salon;
import com.mycompany.edd_proyecto_final.entidades.Usuario;
import static com.mycompany.edd_proyecto_final.ui.Desktop.hashEstudiante;
import static com.mycompany.edd_proyecto_final.ui.Desktop.lstAsignacion;
import static com.mycompany.edd_proyecto_final.ui.Desktop.lstCursos;
import static com.mycompany.edd_proyecto_final.ui.Desktop.lstEdificios;
import static com.mycompany.edd_proyecto_final.ui.Desktop.lstUsr;
import static com.mycompany.edd_proyecto_final.ui.Desktop.treeAvl;
import static com.mycompany.edd_proyecto_final.ui.Desktop.treeHorario;

public class Interprete {
    
    
    //public static AVL<Salon> AVLsalon = new AVL<>();
    
    public Interprete() {
        
    }
    
    public void interpreteEstudiante(String linea) throws Exception {
        
        String[] datos = linea.split(",");
        datos = borrarEspacios(datos);
        Estudiante p = new Estudiante(datos[0].trim(), datos[1].trim(), datos[2].trim());
        hashEstudiante.insertar(p);
        
    }
    
    public void interpreteUsuario(String linea) throws Exception {
        
        
        String[] datos = linea.replace(";", "").split(",");
        datos = borrarEspacios(datos);
        Usuario usuario = new Usuario(datos[0].trim(), datos[1].trim(), datos[2].trim(), datos[3].trim());
        if (!lstUsr.contains(usuario)) {
            System.out.println("tipo: "+datos[3]);
            datos[3] = datos[3].trim();
            if (datos[3].trim().equalsIgnoreCase("estudiante") || datos[3].trim().equalsIgnoreCase("colaborador")) {
            //System.out.println("tipo: "+datos[4]+" ..insertando");    
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
        datos = borrarEspacios(datos);
        Catedratico catedratico = new Catedratico(datos[0], datos[1], datos[2]);
        
        if (treeAvl.buscar(catedratico) == null) {
            treeAvl.insertar(catedratico);
        } else {
            Read.lstErr.push("Codigo De Catedratico: " + datos[0] + " ya se encuentra registrado");
        }
        
    }
    
    public void interpreteEdificio(String linea) throws Exception {
        linea = linea.replaceAll(";", "");
        Edificio edificio = new Edificio(linea.trim());
        
        if (!lstEdificios.contains(edificio)) {
            lstEdificios.push(edificio);
        } else {
            Read.lstErr.push("Edificio: " + linea + " ya se encuentra registrado");
        }
    }
    
    public void interpreteSalon(String linea) throws Exception {
        linea = linea.replace(";", "");
                 //0    1   2
//        /Salon(“T3”, 110, 75);
        String[] datos = linea.split(",");
        datos = borrarEspacios(datos);
        Edificio temp = new Edificio(datos[0]);
        Salon salon = new Salon(datos[1].trim(), datos[2]);
        
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
        datos = borrarEspacios(datos);
        Curso curso = new Curso(datos[0], datos[1], datos[2], datos[3]);
        
        if (!lstCursos.contains(curso)) {
            lstCursos.push(curso);
        } else {
            Read.lstErr.push("Codigo de Curso: " + datos[0] + " Ya Se Encuntra Registrado! ");
        }
    }
    
    public void interpreteHorario(String linea) throws Exception {
        String[] datos = linea.split(",");
        datos = borrarEspacios(datos);
        //Horario
        //   0      1       2       3       4           5           6      
        //(código, período, día, codCurso, codSalón, codEdificio, numIdentificacion);
        Edificio e = lstEdificios.get(new Edificio(datos[5]));
        if (e == null) {
            Read.lstErr.push("Codigo del Edificio: " + datos[5] + " No Se Encuntra Registrado! ");
        }else{
            Salon s = e.getLstSalon().get(new Salon(datos[4].trim(), ""));
            if (s != null) {
               // Horario horario = new Horario(datos[0], datos[1], datos[2], s, curso, catedratico)
               Curso curso = lstCursos.get(new Curso(datos[3], "", "", ""));
                if (curso != null) {
                    Catedratico catedratico = treeAvl.buscar(new Catedratico(datos[6], "", ""));
                  Horario horario = new Horario(datos[0].trim(), datos[1].trim(), datos[2].trim(), s, curso, catedratico);  
                    treeHorario.insertar(new Key(horario.getId()),horario);
                }else{
                    Read.lstErr.push("Codigo de Catedratico: " + datos[3] + " No Se Encuntra Registrado! ");
                }
            }else{
                Read.lstErr.push("Codigo de Salon: " + datos[4] + " No Se Encuntra Registrado! ");
            }
        }
    }
    
    public void interpreteAsignar(String linea) throws Exception {
        linea = linea.replace(";", "");
        String[] datos = linea.split(",");
        
        datos = borrarEspacios(datos);
            //      0          1       2      3
        //Asignar(carnet, codHorario, zona, final)
        
        Horario horario = treeHorario.get(new Key(datos[1]));
        
        if (horario != null && horario.getSalon() != null &&  horario.getSalon().isDisponible()) {
            Estudiante estudiante = hashEstudiante.getValue(new Estudiante(datos[0], "",""));
            if (estudiante != null) {
                Asignacion asignacion = new Asignacion(estudiante, horario, datos[2], datos[3]);
                lstAsignacion.push(asignacion);
            }else{
                System.out.println("Error En Asignacion");
                Read.lstErr.push("Codigo de Estudiante: " + datos[0] + " No Se Encuntra Registrado! ");
            }
        }else{
            System.out.println("Error En Asignacion");
            Read.lstErr.push("Codigo de Horario: " + datos[1] + " No Se Encuntra Registrado! ");
        }
        
        
    }
    private String[] borrarEspacios(String[] datos){
        
        for (int i = 0; i < datos.length; i++) {
             datos[i] = datos[i].trim();
            
        }
        return datos;
    }
}
