
package com.mycompany.edd_proyecto_final.entidades;

import java.util.Objects;

public class Salon {
    
    private String noSalon;
    private String cantidadMaxima;
    private int disponible ;

    public Salon() {
        disponible = 0;
    }

    public Salon(String noSalon, String cantidad) {
        this.noSalon = noSalon;
        this.cantidadMaxima = cantidad;
        disponible = 0;
    }

    public String getNoSalon() {
        return noSalon;
    }

    public int getDisponible() {
        return disponible;
    }

    public void setDisponible() {
        this.disponible += 1;
    }

    
    public void setNoSalon(String noSalon) {
        this.noSalon = noSalon;
    }

    public String getCantidad() {
        return cantidadMaxima;
    }

    public void setCantidad(String cantidad) {
        this.cantidadMaxima = cantidad;
    }

    public boolean isDisponible(){
        int cantidad = Integer.parseInt(cantidadMaxima);
        return (cantidad - disponible) > 0;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.noSalon);
        return hash;
    }

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
        final Salon other = (Salon) obj;
        if (!Objects.equals(this.noSalon, other.noSalon)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "No. Salon: "+ noSalon+"\nLimite De Estudiantes:  "+ cantidadMaxima+"\nAlumnos Asignados: "+disponible;//noSalon="  noSalon + ", cantidadMaxima=" + cantidadMaxima + '}';
    }
    
    
    
    

}
