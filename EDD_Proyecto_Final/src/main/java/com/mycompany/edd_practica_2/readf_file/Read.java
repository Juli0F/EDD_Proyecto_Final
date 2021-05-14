/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edd_practica_2.readf_file;

import com.mycompany.edd_proyecto_final.listas.ListaSimple;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.swing.JTextArea;

/**
 *
 * @author Temporal
 */
public class Read {

    public static ListaSimple<String> lstErr ;
    private String strRead;

    public Read() {
        lstErr = new ListaSimple<>();
        strRead = "";
    }

    public void leerTexto(File file) {

        leerTexto(file.getAbsolutePath());
    }

    public void leerTexto(File file, JTextArea area) {

        leerTexto(file.getAbsolutePath());
        area.setText(strRead);
        
    }

    public void leerTexto(String path) {

        
        System.out.println("path " + path);

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String linea = br.readLine();
            Interprete in = new Interprete();

            while (linea != null) {

                strRead += linea + "\n";
                System.out.println(linea);
                String[] lineaSplit = linea.split("\\(");

                switch (lineaSplit[0]) {
                    case "Estudiate":
                        in.interpreteEstudiante(lineaSplit[1].trim().substring(0, lineaSplit[1].length()-2));

                        break;
                    case "usuario":
                        in.interpreteUsuario(lineaSplit[1].trim().substring(0, lineaSplit[1].length()-2));

                        break;
                    case "Catedratico":
                        in.interpreteCatedratico(lineaSplit[1].trim().substring(0, lineaSplit[1].length()-2));

                        break;
                    case "Edificio":
                        in.interpreteEdificio(lineaSplit[1].trim().substring(0, lineaSplit[1].length()-2));
                        break;
                    case "Salon":
                        in.interpreteSalon(lineaSplit[1].trim().substring(0, lineaSplit[1].length()-2));
                        break;
                    case "Curso":
                        in.interpreteCurso(lineaSplit[1].trim().substring(0, lineaSplit[1].length()-2));
                        break;
                    case "Horario":
                        in.interpreteHorario(lineaSplit[1].trim().substring(0, lineaSplit[1].length()-2));
                        break;
                    case "Asignar":
                        in.interpreteAsignar(lineaSplit[1].trim().substring(0, lineaSplit[1].length()-2));
                        break;
                    default:
                        lstErr.push(linea);

                }

                linea = br.readLine();

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void leerTexto(String path, JTextArea area) {

        leerTexto(path);
        area.setText(strRead);
    }

}
