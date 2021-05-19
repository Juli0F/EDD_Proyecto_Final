
package com.mycompany.edd_proyecto_final.entidades;

import com.mycompany.edd_proyecto_final.listas.ListaSimple;
import java.util.Objects;

public class Edificio {
    
    private String id;
    private ListaSimple<Salon> lstSalon;

    public Edificio() {
    }

    
    public Edificio(String id) {
        this.id = id;
        this.lstSalon = new ListaSimple<>();
        //System.out.println(id+" hashcode: "+ hashCode());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ListaSimple<Salon> getLstSalon() {
        return lstSalon;
    }

    public void setLstSalon(ListaSimple<Salon> lstSalon) {
        this.lstSalon = lstSalon;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Edificio other = (Edificio) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    public void graphSalon(){
        String graph = "subgraph {";
        System.out.println("---> "+ this.lstSalon.testGraph(hashCode()));
        
    }

    @Override
    public String toString() {
        //String cadena = "subgraph "+hashCode()+"g {"+ lstSalon.testGraph(hashCode()) + "}//";
        //return "Edificio" + "id:" + id + "\"]\n //" ;
        return lstSalon.testGraph(this.hashCode());
    }
    
    

}
