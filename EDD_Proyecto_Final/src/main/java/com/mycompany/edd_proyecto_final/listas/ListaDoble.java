package com.mycompany.edd_proyecto_final.listas;

import com.mycompany.edd_proyecto_final.entidades.Edificio;
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
        } else if (deletePos == 1) {
            return pop(root);
        } else {
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
        if (root.getValue().hashCode() == value.hashCode()) {
            
            root = root.getSiguiente();
            root.setAnterior(null);
            reindexar(0,root );
            cantNodos-=1;
            return true;
        }
        return delete(value, root);
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

    private boolean delete(int index, Nodo<T> nodo) {
        if (nodo != null) {
            if (index == nodo.getId()) {

                nodo.getSiguiente().setAnterior(nodo.getAnterior());
                nodo.getAnterior().setSiguiente(nodo.getSiguiente());
                reindexar(index, nodo.getSiguiente());
                nodo = null;
                return true;
            } else {
                return delete(index, nodo.getSiguiente());
            }
        }
        return false;
    }

    @Override
    public int size() {
        return cantNodos;
    }

    private void reindexar(int index, Nodo<T> nodo) {
        if (nodo != null) {
            nodo.setId(index);
            reindexar(index + 1, nodo.getSiguiente());
        }
    }

    public T get(T value) {

        return getT(value, root);
    }

    private T getT(T value, Nodo<T> nodo) {
        if (nodo != null) {
            if (value.hashCode() == nodo.getValue().hashCode()) {
                return nodo.getValue();
            } else {
                return getT(value, nodo.getSiguiente());
            }

        }
        return null;
    }

    public String testGraph(int group) {
        return root.testGraph(true, true, group);
    }

    public String testGraph() {
    
        T t = null;
        String cadena = "";
        //System.out.println("t class"+ t.getClass().getName());
        //cadena += (t instanceof Edificio)?label(0, root):labelNoEdificio(0, root);
        cadena += (root != null && root.getValue() instanceof Edificio)?label(0, root):labelNoEdificio(0, root);
        cadena += "0 -> " + (this.size() - 1) + ";\n";
        cadena += (this.size() - 1) + "->0;\n";
        return cadena;
    }

    private String label(int indice, Nodo<T> t) {
        String cadena = "";
        if (t != null) {
            cadena += indice + " [label =\"posocion: " + (indice) + "\n" + t.toString() + "\" width = 1.5 style = filled, fillcolor = firebrick1, group = " + t.getValue().hashCode() + "  ];\n";
            cadena += indice + " -> " + t.getValue().toString();

            cadena += label(indice + 1, t.getSiguiente());
            //enlaza los nodos 
            if (indice - 1 != -1 && (indice) < this.size()) {
                cadena += indice + "->" + (indice - 1) + "\n";
                cadena += (indice - 1) + "->" + (indice) + "\n";

            }
        }

        return cadena;
    }

    private String labelNoEdificio(int indice, Nodo<T> t) {
        String cadena = "";
        if (t != null) {
            cadena += indice + " [label =\"posocion: " + (indice) + "\n" + t.getValue().toString() + "\" width = 1.5 style = filled, fillcolor = firebrick1, group = " + t.getValue().hashCode() + "  ];\n";
            //cadena += indice + " -> " + t.getValue().toString();

            cadena += labelNoEdificio(indice + 1, t.getSiguiente());
            //enlaza los nodos 
            if (indice - 1 != -1 && (indice) < this.size()) {
                cadena += indice + "->" + (indice - 1) + "\n";
                cadena += (indice - 1) + "->" + (indice) + "\n";

            }
        }

        return cadena;
    }

}
