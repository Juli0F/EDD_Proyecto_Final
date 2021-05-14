
package com.mycompany.edd_proyecto_final.entidades;

import java.util.Objects;

public class Usuario {
    
    private String usuario;
    private String password;
    private String tipo;//estudiante | colaborador | super 
    private String id;

    public Usuario() {
    }

    
    public Usuario(String id,String usuario, String password, String tipo ) {
        this.usuario = usuario;
        this.password = password;
        this.tipo = tipo;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

        
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.usuario);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return  usuario + "\npassword: " + password + "\ntipo: " + tipo ;
    }
    
    

}
