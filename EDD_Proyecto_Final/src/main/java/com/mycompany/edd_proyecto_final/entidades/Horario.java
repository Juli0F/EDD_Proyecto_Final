
package com.mycompany.edd_proyecto_final.entidades;

import java.util.Objects;

public class Horario {
    private String id;
    private String hora;
    private String dia;
    private Salon salon;
    private Curso curso;
    private Catedratico catedratico;

    public Horario() {
    }

    public Horario(String id) {
        this.id = id;
    }

    
    
    public Horario(String id, String hora, String dia, Salon salon, Curso curso, Catedratico catedratico) {
        this.id = id;
        this.hora = hora;
        this.dia = dia;
        this.salon = salon;
        this.curso = curso;
        this.catedratico = catedratico;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Catedratico getCatedratico() {
        return catedratico;
    }

    public void setCatedratico(Catedratico catedratico) {
        this.catedratico = catedratico;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.id);
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
        final Horario other = (Horario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
