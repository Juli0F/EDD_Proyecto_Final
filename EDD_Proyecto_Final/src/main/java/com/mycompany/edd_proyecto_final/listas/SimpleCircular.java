
package com.mycompany.edd_proyecto_final.listas;

import com.mycompany.interfaces.Estructuras_Acciones;
import com.mycompany.exception.PopException;

public class SimpleCircular<T> implements Estructuras_Acciones<T> {

    private Nodo<T> root;
    private int cantNodos;

    public SimpleCircular() {
        cantNodos = 0;
        root = null;
    }

    @Override
    public boolean empty() {
        return root == null;
    }

    @Override
    public void push(T value) {
        if (root == null) {
            root = new Nodo<>(value);
            root.setSiguiente(root);
            root.setId(cantNodos);
            cantNodos = 1;
        } else {
            push(new Nodo<T>(value), root.getSiguiente());
        }
    }

    private void push(Nodo<T> value, Nodo<T> nodo) {

        if (nodo.getSiguiente().getId() == 0) {
            value.setSiguiente(root);
            value.setId(cantNodos);
            cantNodos++;
            nodo.setSiguiente(value);
            return;
        }
        push(value, nodo.getSiguiente());

    }

    @Override
    public T pop(int deletePos) throws PopException {

        if (deletePos == 0) {
            T value = root.getValue();
            //guardamos la referencia de root, al cual llamare como root old
            //ya que root old sigue apuntado al nodo siguiente el cual es el nuevo root
            //a root old le eliminaremos la referencia que tiene al nuevo root, seteandole como null
            Nodo<T> temp = root;
            root = root.getSiguiente();
            temp.setSiguiente(null);//se elimina el apuntador al nodo siguiente "el nuevo root"
            reindexar(0, root);
            cantNodos -= 1;
            return value;
        } else if (deletePos == 1) {
            return pop(root);
        } else {
            throw new PopException("Valor esperado para hacer pop 1 | 0");
        }

    }

    private T pop(Nodo<T> nodo) {
        if (nodo.getId() == cantNodos - 2) {
            T value = nodo.getSiguiente().getValue();
            Nodo<T> temp = nodo.getSiguiente();
            nodo.setSiguiente(root);
            temp.setSiguiente(null);
            cantNodos -= 1;
            return value;

        }
        return pop(nodo.getSiguiente());
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
        }else if(nodo.getSiguiente().getId() != 0){
            return delete(value,nodo.getSiguiente());
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
        }else{
            return delete(index, root);
        }
    }

    private boolean delete(int index, Nodo<T> nodo){
    
        if (nodo.getSiguiente().getId() == index) {
            Nodo<T> temp  = nodo.getSiguiente();
            nodo.setSiguiente(temp.getSiguiente());
            cantNodos -= 1;
            reindexar(index, nodo.getSiguiente());
            return true;
        }else if (nodo.getSiguiente().getId() != 0) {
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
        String rootStr = root.toString();
        return rootStr;
        //return "SimpleCircular{" + "root=" + root.toString() + ", cantNodos=" + cantNodos + '}';
    }

    private void reindexar(int index, Nodo<T> nodo) {
        if (nodo.getId() != 0) {
        nodo.setId(index);      
        }
        
        if (nodo.getSiguiente() != null) {
            if (nodo.getSiguiente().getId() != 0 && index != cantNodos ) {
                reindexar(index + 1, nodo.getSiguiente());    
            }
            
        } else {
            nodo.setSiguiente(root);//se recolaca el apuntado al nuevo root, para mantener la lista circular
        }
    }

}
