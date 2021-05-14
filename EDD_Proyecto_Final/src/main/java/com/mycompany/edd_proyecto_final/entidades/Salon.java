
package com.mycompany.edd_proyecto_final.entidades;

import java.util.Objects;

public class Salon {
    
    private String noSalon;
    private String cantidad;

    public Salon() {
    }

    public Salon(String noSalon, String cantidad) {
        this.noSalon = noSalon;
        this.cantidad = cantidad;
    }

    public String getNoSalon() {
        return noSalon;
    }

    public void setNoSalon(String noSalon) {
        this.noSalon = noSalon;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
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
        return "No. Salon: "+ noSalon+"\nLimite De Estudiantes:  "+ cantidad;//noSalon="  noSalon + ", cantidad=" + cantidad + '}';
    }
    
    
    
    

}
