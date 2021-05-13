
package com.mycompany.edd_proyecto_final.pilas;

import com.mycompany.interfaces.Estructuras_Acciones;
import com.mycompany.edd_proyecto_final.listas.Nodo;
import com.mycompany.exception.PopException;

public class Pila<T>  {

    private Nodo<T> root;
    private int cantNodos;

    public Pila() {
        root = null;
        cantNodos = 0;
    }

    
    public boolean empty() {
        return root == null;
    }

    
    public void push(T value) {
        Nodo<T> nodoAdd = new Nodo<>(value, true);
        if (root == null) {
            root = nodoAdd;

            cantNodos = 1;
        } else {

            push(nodoAdd, root);
            cantNodos += 1;
        }
    }

    private void push(Nodo<T> nodoAdd, Nodo<T> nodo) {
        if (nodo.getSiguiente() == null) {
            nodo.setSiguiente(nodoAdd);
        } else {
            push(nodoAdd, nodo.getSiguiente());
        }
    }

      
    public T pop()  {

        return pop(root);
        

    }

    /**
     * elimina el ultimo nodo
     *
     * @param nodo
     * @return
     */
    private T pop(Nodo<T> nodo) {

        if (nodo == null) {
            return null;
        } else {
            if (nodo.getSiguiente() == null) {
                T value = nodo.getValue();
                cantNodos -= 1;
                nodo = null;
                return value;
            } else {
                return pop(nodo.getSiguiente());
            }
        }
    }

    public T peek() {
        return getNodo(cantNodos-1, root);
    }

    private T getNodo(int index, Nodo<T> nodo) {

        if (nodo == null) {
            return null;
        } else {
            if (index == nodo.getId()) {
                return nodo.getValue();
            } else {
                return getNodo(index, nodo.getSiguiente());
            }
        }
    }

    
    public boolean contains(T value) {
        return contains(value, root);
    }

    private boolean contains(T value, Nodo<T> nodo) {
        if (nodo == null) {
            return false;
        } else {
            if (value.hashCode() == nodo.hashCode()) {
                return true;
            } else {
                return contains(value, nodo.getSiguiente());
            }
        }
    }

    
    
    
    public boolean delete() {
        T temp = pop(root);
        return (temp == null);
        

    }

    public int size() {
        return cantNodos;
    }
}
