package com.mycompany.edd_proyecto_final.listas;

import com.mycompany.interfaces.Estructuras_Acciones;
import com.mycompany.exception.PopException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListaSimple<T> implements Estructuras_Acciones<T> {

    private Nodo<T> root;
    private int cantNodos;

    public ListaSimple() {
        cantNodos = 0;
    }

    public ListaSimple(int spaceInit) {
        for (int i = 0; i < spaceInit; i++) {

            push(null);

        }
    }

    public boolean push(T value, int index) {

        if (index < cantNodos) {
            return pushIndex(value, root, index);
        }

        return false;

    }

    private boolean pushIndex(T value, Nodo<T> nodo, int index) {
        if (nodo.getSiguiente() == null) {
            return false;
        }
        if (nodo.getSiguiente().getId() == index) {
            if (nodo.getSiguiente().getValue() == null) {
                nodo.getSiguiente().setValue(value);
                return true;
            } else {
                return false;
            }

        } else {
            return pushIndex(value, nodo.getSiguiente(), index);
        }

    }

    public boolean pushForce(T value, int index) {

        if (index < cantNodos) {
            return pushIndexForce(value, root, index);
        }
        return false;

    }

    private boolean pushIndexForce(T value, Nodo<T> nodo, int index) {
        if (nodo.getSiguiente().getId() == index) {
            // if (nodo.getSiguiente().getValue() == null) {
            nodo.getSiguiente().setValue(value);
            return true;
            //} else {
            //  return false;
            //}

        } else {
            return pushIndexForce(value, nodo.getSiguiente(), index);
        }

    }

    @Override
    public void push(T value) {
        Nodo<T> nodoAdd = new Nodo<>(value, true);
        if (root == null) {
            root = nodoAdd;

            cantNodos = 1;
            //System.out.println("(1 root) Cantidad de nodos:  " + cantNodos);
            //System.out.println(value.toString());

        } else {

            push(nodoAdd, root);
            cantNodos += 1;
            //  System.out.println("    Cantidad de nodos: " + cantNodos);
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
    public T pop(int deletePos)  {

        try {

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
        } catch (PopException e) {
            e.printStackTrace();
        }

        return null;
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
        try {

            return getNodo(index, root);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

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

            pop(0);
            return true;
        }
        return delete(nodoDelete, root);
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

    public String testGraph() {
        return root.testGraph(true, true, root.hashCode());
    }

    public String testGraph(int group) {

        Random r = new Random();
        int x = r.nextInt(100000);

        String cadena = "s" + x + " [label =\"posocion: " + (0) + "\" width = 1.5 ,  group = " + group + "  ];\n";;
        cadena += label(x, 0, root, group);
        return cadena;

    }

    private String label(int random, int indice, Nodo<T> t, int group) {
        String cadena = "";
        if (t != null) {
            cadena += "s" + (indice + random) + " [label =\"posocion: " + (indice) + "\n" + t.getValue().toString() + "\" width = 1.5 style = filled, fillcolor = lightskyblue, group = " + group + "  ];\n";

            //cadena += "s"+indice +" -> "+t.getValue().toString();
            cadena += label(random, indice + 1, t.getSiguiente(), group);
            //enlaza los nodos 
            if (indice - 1 != -1 && (indice) < this.size()) {
                cadena += " s" + ((indice + random) - 1) + "-> s" + (indice + random) + "\n";
                //   cadena += (indice-1) + "->" + (indice ) + "\n";

            }
        }

        return cadena;
    }

    public int size() {
        return cantNodos;
    }
}
