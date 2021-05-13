package com.mycompany.edd_proyecto_final.arboles;

import java.util.Objects;

public class Nodo<T> {

    protected T value;       // the associated value
    protected int height;      // height of the subtree
    protected int size;        // number of nodes in subtree
    protected Nodo<T> left;       // left subtree
    protected Nodo<T> right;      // right subtree

    public Nodo(T val, int height, int size) {
        this.value = val;
        this.size = size;
        this.height = height;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String testGraph() {
        String graph = "";
        try {
            
        if (left != null ) {
            graph += value.hashCode() + "->" + left.value.hashCode()+"\n";
            graph += value.hashCode() + "->" + right.value.hashCode()+"\n";
            graph += left.testGraph();
        }

//        if (right != null && value != null) {
//            graph += value.hashCode() + "->" + left.value.hashCode()+"\n";
//            graph += value.hashCode() + "->" + right.value.hashCode()+"\n";
//            graph += right.testGraph();
//        }
        } catch (Exception e) {
        }


        return graph;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.value);
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

}
