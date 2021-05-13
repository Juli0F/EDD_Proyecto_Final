
package com.mycompany.edd_proyecto_final.listas;

import com.mycompany.interfaces.Estructuras_Acciones;
import com.mycompany.exception.PopException;
import java.util.ArrayList;
import java.util.List;

public class ListaSimple<T> implements Estructuras_Acciones<T> {

    private Nodo<T> root;
    private int cantNodos;

    public ListaSimple() {
        cantNodos = 0;
    }

    @Override
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

    /**
     *
     * @param deletePos 0 : elimina el primero de la lista 1 : elimina el ultimo
     * de la lista
     * @return
     * @throws com.mycompany.exception.PopException
     */
    @Override
    public T pop(int deletePos) throws PopException {

        if (deletePos == 0) {
            if (root == null) {
                return null;
            } else {
                T value = root.getValue();
                root = root.getSiguiente();
                cantNodos -= 1;
                return value;
            }

        } else if (deletePos == 1) {
            return pop(root.getSiguiente());
        } else {
            throw new PopException("accion desconocida, parametro debe ser 1 | 0");
        }

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

    @Override
    public boolean empty() {
        return root == null;
    }

    @Override
    public T get(int index) {
        return getNodo(index, root);
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

    @Override
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

    @Override
    public boolean delete(T value) {
        Nodo<T> nodoDelete = new Nodo<>(value, false);
        if (root.hashCode() == nodoDelete.hashCode()) {
            root = root.getSiguiente();
            cantNodos -= 1;
            return true;
        }
        return delete(nodoDelete, root) ;
    }

    private boolean delete(Nodo<T> value, Nodo<T> nodo) {
        if (nodo == null) {
            return false;
        } else {
            if (value.hashCode() == nodo.getSiguiente().hashCode()) {

                nodo.setSiguiente(nodo.getSiguiente().getSiguiente());
                cantNodos -= 1;
                return true;

            } else {
                return delete(value, nodo.getSiguiente());
            }
        }
    }

    @Override
    public boolean delete(int index) {

        //return (root.getId() == index) ? true : delete(index, root);
        if (root != null && root.getId() == index) {
            root = root.getSiguiente();
            cantNodos -= 1;
            return true;
        } else {
            return delete(index, root);
        }

    }

    private boolean delete(int index, Nodo<T> nodo) {

        if (nodo == null) {
            return false;
        } else {
            if (nodo.getSiguiente().getId() == index) {

                nodo.getSiguiente().setSiguiente(nodo.getSiguiente().getSiguiente());
                cantNodos -= 1;
                return true;
            } else {
                return delete(index, nodo.getSiguiente());
            }
        }
    }

    public int size() {
        return cantNodos;
    }
}
