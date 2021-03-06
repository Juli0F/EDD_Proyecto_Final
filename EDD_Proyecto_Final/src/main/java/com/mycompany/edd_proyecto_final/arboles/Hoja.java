package com.mycompany.edd_proyecto_final.arboles;

public class Hoja<T> {

    private Hoja<T> derecha;
    private Hoja<T> izquierda;
    private int id;
    private T value;

    public Hoja(Hoja<T> derecha, Hoja<T> izquierda, int id, T value) {
        this.derecha = derecha;
        this.izquierda = izquierda;
        this.id = id;
        this.value = value;
    }

    public Hoja<T> getDerecha() {
        return derecha;
    }

    public void setDerecha(Hoja<T> derecha) {
        this.derecha = derecha;
    }

    public Hoja<T> getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Hoja<T> izquierda) {
        this.izquierda = izquierda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
    
    
}
