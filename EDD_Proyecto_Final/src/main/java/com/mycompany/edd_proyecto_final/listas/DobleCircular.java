
package com.mycompany.edd_proyecto_final.listas;

import com.mycompany.interfaces.Estructuras_Acciones;
import com.mycompany.exception.PopException;

public class DobleCircular<T> implements Estructuras_Acciones<T> {

    private Nodo<T> root;
    private int cantNodos;

    public DobleCircular() {
        root = null;
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
            root.setId(0);
            cantNodos = 1;
            root.setSiguiente(root);
            root.setAnterior(root);
        } else {
            push(new Nodo<T>(value), root);
        }
    }

    private void push(Nodo<T> value, Nodo<T> nodo) {

        if (nodo.getId() == cantNodos - 1) {
            value.setId(cantNodos);
            value.setAnterior(nodo);
            value.setSiguiente(root);
            nodo.setSiguiente(value);
            root.setAnterior(value);
            cantNodos += 1;
        } else {
            push(value, nodo.getSiguiente());
        }

    }

    @Override
    public T pop(int deletePos) throws PopException {
        if (deletePos == 0) {
            Nodo<T> temp = root;
            T value = temp.getValue();
            root = root.getSiguiente();
            root.setAnterior(temp.getAnterior());
            temp.getAnterior().setSiguiente(root);
            reindexar(0, root);
            cantNodos -= 1;

            return value;

        } else if (deletePos == 1) {
            Nodo<T> temp = root.getAnterior();

            T value = temp.getValue();
            temp.getAnterior().setSiguiente(root);
            root.setAnterior(temp.getAnterior());
            //reindexar(root.getAnterior().getId(), root);

            cantNodos -= 1;
            return value;
        } else {
            throw new PopException("valor de parametro pop, Se esperaba 1 | 0");
        }

    }

    @Override
    public T get(int index) {
        return (root != null) ? get(index, root) : null;
    }

    private T get(int index, Nodo<T> nodo) {

        if (nodo.getId() == index) {
            return nodo.getValue();
        } else {
            if (nodo.getId() != cantNodos - 1) {//verifica que no sea el ultimo nodo
                return get(index, nodo.getSiguiente());
            }

        }

        return null;
    }

    @Override
    public boolean contains(T value) {
        return (root != null) ? contains(value, root) : null;
    }

    private boolean contains(T value, Nodo<T> nodo) {
        if (value.hashCode() == nodo.getValue().hashCode()) {
            return true;
        } else {
            if (nodo.getId() != cantNodos - 1) {
                return contains(value, nodo.getSiguiente());
            }
        }
        return false;
    }

    @Override
    public boolean delete(T value) {
        if (root.getValue().hashCode() == value.hashCode()) {

            //guardamos la referencia de root, al cual llamare como root old
            //ya que root old sigue apuntado al nodo siguiente el cual es el nuevo root
            //a root old le eliminaremos la referencia que tiene al nuevo root, seteandole como null
            Nodo<T> temp = root;
            root = root.getSiguiente();
            temp.setSiguiente(null);//se elimina el apuntador al nodo siguiente "el nuevo root"

            cantNodos -= 1;
            reindexar(0, root);
            return true;
        } else {
            return delete(value, root);
        }
    }

    private boolean delete(T value, Nodo<T> nodo) {
        if (nodo.getSiguiente().getValue().hashCode() == value.hashCode()) {

            Nodo<T> temp = nodo.getSiguiente();
            nodo.setSiguiente(nodo.getSiguiente().getSiguiente());
            cantNodos -= 1;
            reindexar(nodo.getId(), nodo);
            temp = null;
            return true;
        } else if (nodo.getSiguiente().getId() != 0) {
            return delete(value, nodo.getSiguiente());
        }
        return false;
    }

    @Override
    public boolean delete(int index) {
        if (index == 0) {
            Nodo<T> temp = root;
            //ro.setSiguiente(temp.getSiguiente())
            root = root.getSiguiente();
            temp = null;
            cantNodos -= 1;
            reindexar(0, root);
            temp = null;
            return true;
        } else {
            return delete(index, root);
        }
    }

    private boolean delete(int index, Nodo<T> nodo) {

        if (nodo.getSiguiente().getId() == index) {
            Nodo<T> temp = nodo.getSiguiente();
            nodo.setSiguiente(temp.getSiguiente());
            cantNodos -= 1;
            reindexar(index, nodo.getSiguiente());
            return true;
        } else if (nodo.getSiguiente().getId() != 0) {
            return delete(index, nodo.getSiguiente());
        }
        return false;
    }

    @Override
    public int size() {
        return cantNodos;
    }

    @Override
    public String toString() {
        String anteriorStr =  "";//root.toStringAnterior(cantNodos-1);
        return root.toString()+"\n";//+anteriorStr;

    }
    public String testP(int group){
        return root.testGraph(true,true,group);
    }

    private void reindexar(int index, Nodo<T> nodo) {
        if (nodo.getId() != 0) {
            nodo.setId(index);
        }

        if (nodo.getSiguiente() != null) {
            if (nodo.getSiguiente().getId() != 0 && index != cantNodos) {
                reindexar(index + 1, nodo.getSiguiente());
            }

        } else {
            //nodo.setSiguiente(root);//se recolaca el apuntado al nuevo root, para mantener la lista circular
        }
    }
}
