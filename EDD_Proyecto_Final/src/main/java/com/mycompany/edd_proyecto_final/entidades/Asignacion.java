
package com.mycompany.edd_proyecto_final.entidades;

public class Asignacion {

    private Estudiante estudiante;
    private Horario horario;
    private String zona ;
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

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    @Override
    public String toString() {
        return  "-------Estudiante------\n "+estudiante.getId() + " - "+estudiante.getNombre() + "\n zona: " + zona + "\n final: " + fin +
                "\n ----horario----\n" +horario.getDia()+" - "+ horario.getHora()+"\n---Curso--\n"+horario.getCurso().getNombre();
    }
    
    
}
