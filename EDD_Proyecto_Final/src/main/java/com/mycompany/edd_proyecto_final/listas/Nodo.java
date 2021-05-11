/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edd_proyecto_final.listas;

import java.util.Objects;

/**
 *
 * @author <button><a href="https://twitter.com/Julio_Ixcoy_">Julio</a></button>
 * nodo para la lista simple, doble, simple circular, doble circular
 */
public class Nodo<T> {

    private Nodo<T> siguiente;
    private Nodo<T> anterior;
    private T value;
    private int id;
    private static int i = 0;

    public Nodo() {
        System.out.println("i -> " + i);
        this.id = i++;
        System.out.println("i -> " + i);
        System.out.println("id -> " + id);
    }

    public Nodo(T value, boolean incrementI) {
        this.value = value;
        id = incrementI ? i++ : 0;
    }

    public Nodo(Nodo<T> siguiente, Nodo<T> anterior, T value) {
        this.siguiente = siguiente;
        this.anterior = anterior;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo<T> anterior) {
        this.anterior = anterior;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Nodo(T value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.value);
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
        final Nodo<?> other = (Nodo<?>) obj;
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String siguienteToString = "-->null";
        String anteriorStr = "";
        if (siguiente != null && siguiente.getId() != 0) {
            siguienteToString = "-->" + siguiente.toString();
            if (anterior != null && siguiente.getId() != 0) {
                anteriorStr = " <- " + " (id: " + id + ", value: " + value + ")";
            }

        }
        if (siguiente.getId() == 0) {
            siguienteToString = "--> (id: 0, value: " + siguiente.getValue() + ")";
            if (anterior != null) {
                anteriorStr = " <- " + " (id: " + id + ", value: " + value + ")";
            }
        }

        return anteriorStr + " (id: " + id + ", value: " + value + ")" + siguienteToString;//+", value=" + value  ;
    }

}
