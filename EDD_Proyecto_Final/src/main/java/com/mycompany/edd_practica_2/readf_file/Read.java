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

    public static ListaSimple<String> lstErr;
    private String strRead;
    private String strReadErr;

    public Read() {
        lstErr = new ListaSimple<>();
        strRead = "";
        strReadErr = "";
    }

    public void leerTexto(File file) {

        leerTexto(file.getAbsolutePath());
    }

    public void leerTexto(File file, JTextArea area) {

        leerTexto(file.getAbsolutePath());
        area.setText(strRead);

    }

    public void leerTexto(File file, JTextArea area, JTextArea showErrores) {

        leerTexto(file.getAbsolutePath());
        area.setText(strRead);
        showErrores.setText(strReadErr);

    }

    public void leerTexto(String path) {

        System.out.println("path " + path);

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String linea = br.readLine();
            Interprete in = new Interprete();
            int cont = 1;
            int bien = 1;

            while (linea != null) {

                System.out.println(linea);
                
                
                String[] lineaSplit = linea.replaceAll("\"", "").replaceAll("\\)", "").split("\\(");

                switch (lineaSplit[0].toLowerCase().trim()) {
                    case "estudiante":
                        in.interpreteEstudiante(lineaSplit[1].trim().substring(0, lineaSplit[1].length() - 2));
                        strRead += bien + ": " + linea + "\n";
                        bien++;
                        break;
                    case "usuario":
                        in.interpreteUsuario(lineaSplit[1].trim().substring(0, lineaSplit[1].length() - 2));
                        strRead += bien + ": " + linea + "\n";
                        bien++;
                        break;
                    case "catedratico":
                        in.interpreteCatedratico(lineaSplit[1].trim().substring(0, lineaSplit[1].length() - 2));
                        strRead += bien + ": " + linea + "\n";
                        bien++;
                        break;
                    case "edificio":
                        in.interpreteEdificio(lineaSplit[1].trim().substring(0, lineaSplit[1].length() - 2));
                        strRead += bien + ": " + linea + "\n";
                        bien++;
                        break;
                    case "salon":
                        in.interpreteSalon(lineaSplit[1].trim().substring(0, lineaSplit[1].length() - 2));
                        strRead += bien + ": " + linea + "\n";
                        bien++;
                        break;
                    case "curso":
                        in.interpreteCurso(lineaSplit[1].trim().substring(0, lineaSplit[1].length() - 2));
                        strRead += bien + ": " + linea + "\n";
                        bien++;
                        break;
                    case "horario":
                        in.interpreteHorario(lineaSplit[1].trim().substring(0, lineaSplit[1].length() - 2));
                        strRead += bien + ": " + linea + "\n";
                        bien++;
                        break;
                    case "asignar":
                        in.interpreteAsignar(lineaSplit[1].trim().substring(0, lineaSplit[1].length() - 2));
                        strRead += bien + ": " + linea + "\n";
                        bien++;
                        break;
                    default:
                        strReadErr += cont + ": " + linea + "\n";
                        lstErr.push(linea);
                        cont++;

                }

                linea = br.readLine();

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("hash: "+Interprete.hashEstudiante.size());
        System.out.println("Curso: "+ Interprete.lstCursos.size());
        System.out.println("Edificio: "+Interprete.lstEdificios.size());
        System.out.println("Usuario: "+Interprete.lstUsr.size());

    }

    public void leerTexto(String path, JTextArea area) {

        leerTexto(path);
        area.setText(strRead);
    }

}
