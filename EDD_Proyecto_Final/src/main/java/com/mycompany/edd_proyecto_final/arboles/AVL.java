package com.mycompany.edd_proyecto_final.arboles;

import com.mycompany.edd_proyecto_final.io.WriteFile;

public class AVL<T> {

    protected Nodo<T> root;
    private String cadena;
    private String graph;
    private int contador = 0;

    public AVL() {
        graph = "";
    }

    
    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return size(root);
    }

    private int size(Nodo<T> x) {
        if (x == null) {
            return 0;
        }
        return x.size;
    }

    public int alturaArbol() {
        return height(root);
    }

    private int height(Nodo<T> x) {
        if (x == null) {
            return -1;
        }
        return x.height;
    }

    public void insertar(T val) {
        root = insertar(root, val);
    }

    public T buscar(T value){
        return buscar(value, root).value;
    }
    public Nodo<T> buscar(T val, Nodo<T> x) {
        if (x == null) {
            return null;
        }

        if (x.value.hashCode() == val.hashCode()) {
            return x;
        } else if (val.hashCode() < x.value.hashCode()) {
            return buscar(val, x.left);
        } else {
            return buscar(val, x.right);
        }
    }

    private Nodo<T> insertar(Nodo<T> x, T val) {
        
        if (x == null) {
            return new Nodo(val, 0, 1);
        }

        if (val.hashCode() < x.value.hashCode()) {

            x.left = insertar(x.left, val);

        } else if (val.hashCode() > x.value.hashCode()) {
            x.right = insertar(x.right, val);
        } else {
            x.value = val;
            
            return x;
        }
        x.size = 1 + size(x.left) + size(x.right);
        x.height = 1 + Math.max(height(x.left), height(x.right));
        return equilibrioi(x);
    }

    private Nodo<T> equilibrioi(Nodo<T> x) {
        if (balanceFactor(x) > 1) {
            if (balanceFactor(x.right) < 0) {
                x.right = rotacionAlaDerecha(x.right);
            }
            x = rotacionIzquierda(x);
        } else if (balanceFactor(x) < -1) {
            if (balanceFactor(x.left) > 0) {
                x.left = rotacionIzquierda(x.left);
            }
            x = rotacionAlaDerecha(x);
        }
        return x;
    }

    private int balanceFactor(Nodo<T> x) {
        return height(x.right) - height(x.left);
    }

    private Nodo<T> rotacionAlaDerecha(Nodo<T> x) {
        Nodo y = x.left;
        x.left = y.right;
        y.right = x;
        y.size = x.size;
        x.size = 1 + size(x.left) + size(x.right);
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));
        return y;
    }

    private Nodo<T> rotacionIzquierda(Nodo<T> x) {
        Nodo<T> y = x.right;
        x.right = y.left;
        y.left = x;
        y.size = x.size;
        x.size = 1 + size(x.left) + size(x.right);
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));
        return y;
    }

    public void delete(T val) {
        root = eliminar(root, val);
    }

    private Nodo<T> eliminar(Nodo<T> x, T val) {
        if (val.hashCode() < x.value.hashCode()) {
            x.left = eliminar(x.left, val);
        } else if (val.hashCode() > x.value.hashCode()) {
            x.right = eliminar(x.right, val);
        } else {
            if (x.left == null) {
                return x.right;
            } else if (x.right == null) {
                return x.left;
            } else {
                Nodo y = x;
                x = min(y.right);
                x.right = deleteMin(y.right);
                x.left = y.left;
            }
        }
        x.size = 1 + size(x.left) + size(x.right);
        x.height = 1 + Math.max(height(x.left), height(x.right));
        return equilibrioi(x);
    }

    private Nodo<T> deleteMin(Nodo<T> x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.size = 1 + size(x.left) + size(x.right);
        x.height = 1 + Math.max(height(x.left), height(x.right));
        return equilibrioi(x);
    }

    private Nodo min(Nodo<T> x) {
        if (x.left == null) {
            return x;
        }
        return min(x.left);
    }

   

    public Nodo<T> getRoot() {
        return root;
    }

    public void setRoot(Nodo<T> root) {
        this.root = root;
    }
    public String testGraph(){
        graph = "digraph avl{\n";
        graph +=  root.hashCode()+"[ label=\""+root.value+"\"];";
        inOrden(root);
        
        graph +="\n}";
        WriteFile wf = new WriteFile();
        wf.writeFile("avl.dot", graph);
        wf.dibujar("avl.dot", "avl.png");
        return graph;
    }

    public void inOrden (Nodo<T> nodo){
        
        if (nodo != null) {
            if (nodo.left != null) {
                graph += nodo.left.hashCode()+"[ label=\""+nodo.left.value+"\"];";
                graph +="\n"+ nodo.hashCode() +" -> "+ nodo.left.hashCode()+";\n\t";
            }
            inOrden(nodo.left);
            if (nodo.right != null) {
                graph +="\n"+ nodo.right.hashCode()+"[ label=\""+nodo.right.value+"\"];";
                graph +="\n"+ nodo.hashCode() +" -> "+ nodo.right.hashCode()+";\n\t";
                
            }
            inOrden(nodo.right);
        }
        
    }
    @Override
    public String toString() {
        return "Arbol{" + "cadena=" + cadena + '}';
    }

}
