
package com.mycompany.edd_proyecto_final.entidades;

import java.util.Objects;

public class Persona {

    private String id;
    private String nombre;
    private String direccion;

    public Persona(String id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Persona() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
////
//    @Override
//    public int hashCode() {
//        int hash = 3;
//        hash = 71 * hash + Objects.hashCode(this.id);
//        return hash;
//    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  "\nnombre: " + nombre + "\n direccion: " + direccion ;
    }
    
            
}
