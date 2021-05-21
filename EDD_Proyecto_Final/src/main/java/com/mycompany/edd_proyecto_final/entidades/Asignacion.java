package com.mycompany.edd_proyecto_final.entidades;

import java.util.Objects;

public class Asignacion {

    private Estudiante estudiante;
    private Horario horario;
    private String zona;
    private String fin;

    public Asignacion() {
    }

    public Asignacion(Estudiante estudiante, Horario horario, String zona, String fin) {
        this.estudiante = estudiante;
        this.horario = horario;
        this.zona = zona;
        this.fin = fin;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getNotaFinal() {

        return "" + (Integer.parseInt(fin) + Integer.parseInt(zona));
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.estudiante);
        hash = 97 * hash + Objects.hashCode(this.horario);
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
        final Asignacion other = (Asignacion) obj;
        if (!Objects.equals(this.estudiante, other.estudiante)) {
            return false;
        }
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String studen = (estudiante != null) ? estudiante.getId()
                + " - " + estudiante.getNombre() : "null";
        String strHorario = (horario != null) ?
                horario.getDia() + " - " + horario.getHora()
                + "\n---Curso--\n"+ horario.getCurso().getNombre() : "Eliminado";

        return "-------Estudiante------\n "
                + studen
                + "\n zona: " + zona
                + "\n final: " + fin
                + "\n ----horario----\n"
                + strHorario;
    }

}
