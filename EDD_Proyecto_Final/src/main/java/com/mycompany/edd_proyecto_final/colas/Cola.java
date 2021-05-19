
package com.mycompany.edd_proyecto_final.colas;

import com.mycompany.edd_proyecto_final.listas.Nodo;
import com.mycompany.exception.PopException;

public class Cola<T> {

    private Nodo<T> root;
    private int cantNodos;

    public Cola() {
        root = null;
        cantNodos = 0;
    }

    public void push(T value) {
        Nodo<T> nodoAdd = new Nodo<>(value);
        if (root == null) {
            root = nodoAdd;
            root.setId(cantNodos);
            cantNodos = 1;
        } else {

            push(nodoAdd, root);
            
        }
    }

    private void push(Nodo<T> nodoAdd, Nodo<T> nodo) {
        if (nodo.getSiguiente() == null) {
            nodo.setSiguiente(nodoAdd);
            nodo.setId(cantNodos);
            cantNodos += 1;
        } else {
            push(nodoAdd, nodo.getSiguiente());
        }
    }

    /**
     *
     * @param deletePos 0 : elimina el primero de la lista 1 : elimina el ultimo
     * de la lista
     * @return
     * @throws com.mycompany.exception.PopException
     */
    public T pop()  {


            if (root == null) {
                return null;
            } else {
                T value = root.getValue();
                root = root.getSiguiente();
                cantNodos -= 1;
                return value;
            }


    }
    
    public boolean empty() {
        return root == null;
    }

    public T peek() {
        return root.getValue();
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
        
        if (root != null) {
            root = root.getSiguiente();
            cantNodos -= 1;
            return true;
        }
        return false;

    }
    public int size() {
        return cantNodos;
    }

    @Override
    public String toString() {
        return root.toString();
    }

    
}
