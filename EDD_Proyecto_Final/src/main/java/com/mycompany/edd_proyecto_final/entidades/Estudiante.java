
package com.mycompany.edd_proyecto_final.entidades;



public class Estudiante extends Persona{

    public Estudiante(String id, String nombre, String direccion) {
        super(id, nombre, direccion);
    }

    public Estudiante() {
    }
    

    @Override
    public String toString() {
        return "Estudiante\nCarnet: "+super.getId() + super.toString(); 
    }
    
    
}
