
package com.mycompany.edd_proyecto_final.entidades;

public class Catedratico extends Persona{

    public Catedratico(String id, String nombre, String direccion) {
        super(id, nombre, direccion);
    }

    public Catedratico() {
    }

    @Override
    public String toString() {
        return "Profesor\nNo. Id: "+super.getId()+super.toString();
    }

    
}
