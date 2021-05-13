
package com.mycompany.edd_proyecto_final.listas;

import com.mycompany.interfaces.Estructuras_Acciones;
import com.mycompany.exception.PopException;

public class ListaDoble<T> implements Estructuras_Acciones<T> {

    private Nodo<T> root;
    private int cantNodos;

    public ListaDoble() {
        cantNodos = 0;
    }

    @Override
    public boolean empty() {
        return root == null;
    }

    @Override
    public void push(T value) {
        if (root == null) {
            root = new Nodo<>(value);
            root.setId(cantNodos);
            cantNodos += 1;
        } else {
            
            push(new Nodo<T>(value, false), root);
        }

    }

    private void push(Nodo<T> value, Nodo<T> nodo) {

        if (nodo.getSiguiente() == null) {
            value.setId(cantNodos);
            nodo.setSiguiente(value);
            nodo.getSiguiente().setAnterior(nodo);
            cantNodos += 1;
        } else {
            push(value, nodo.getSiguiente());
        }

    }

    //1|0
    @Override
    public T pop(int deletePos) throws PopException {
        if (deletePos == 0) {
            T value = root.getValue();
            root = root.getSiguiente();
            root.setAnterior(null);
            reindexar(0, root);
            cantNodos += 1;
            return value;
        } else if(deletePos == 1) {
            return pop(root);
        }else{
            throw new PopException("valor esperado para pop: 0|1");
        }
    }

    private T pop(Nodo<T> nodo) {
        if (nodo != null) {
            if (nodo.getSiguiente() == null) {
                T value = nodo.getValue();
                nodo.getAnterior().setSiguiente(nodo.getSiguiente());
                nodo.getSiguiente().setAnterior(nodo.getAnterior());
                reindexar(nodo.getId(), nodo.getSiguiente());
                cantNodos -= 1;
                return value;
            } else {
                return pop(nodo);
            }
        }
        return null;
    }

    @Override
    public T get(int index) {
        return get(index, root);
    }

    private T get(int index, Nodo<T> nodo) {
        if (nodo != null) {
            if (nodo.getId() == index) {
                return nodo.getValue();
            } else {
                return get(index, nodo.getSiguiente());
            }
        }
        return null;
    }

    @Override
    public boolean contains(T value) {

        return contains(value, root);

    }

    private boolean contains(T value, Nodo<T> nodo) {
        if (nodo != null) {
            if (value.hashCode() == nodo.getValue().hashCode()) {
                return true;
            } else {
                return contains(value, nodo.getSiguiente());
            }

        }
        return false;
    }

    @Override
    public boolean delete(T value) {
     return  delete(value, root);
    }

    private boolean delete(T value, Nodo<T> nodo) {
        if (nodo != null) {

            if (value.hashCode() == nodo.getValue().hashCode()) {
                nodo.getAnterior().setSiguiente(nodo.getSiguiente());
                nodo.getSiguiente().setAnterior(nodo.getAnterior());
                reindexar(nodo.getId(), nodo.getSiguiente());
                nodo = null;
                cantNodos -= 1;
                return true;
            } else {
                return delete(value, nodo.getSiguiente());
            }
        }
        return false;
    }

    @Override
    public boolean delete(int index) {
       return delete(index, root);
    }
    private boolean delete(int index , Nodo<T> nodo){
        if (nodo != null) {
            if (index == nodo.getId()) {
                
                nodo.getSiguiente().setAnterior(nodo.getAnterior());
                nodo.getAnterior().setSiguiente(nodo.getSiguiente());
                reindexar(index, nodo.getSiguiente());
                nodo = null;
                return true;
            }else{
                return  delete(index, nodo.getSiguiente());
            }
        }
        return false;
    }

    @Override
    public int size() {
        return cantNodos;
    }
    private void reindexar(int index, Nodo<T> nodo){
        if (nodo != null) {
            nodo.setId(index);
            reindexar(index+1, nodo.getSiguiente());
        }
    }

}
