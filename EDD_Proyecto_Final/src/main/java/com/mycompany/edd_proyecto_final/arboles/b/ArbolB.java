package com.mycompany.edd_proyecto_final.arboles.b;

public class ArbolB<T> {

    private Nodo_Arbol_B<T> root;
    private int mK;
    private int altura;
    private Class clazz;

    public String testGraph() {
        StringBuilder b = new StringBuilder();
        b.append("digraph g { \n node [shape=record];\n");
        b.append(root.testGraph());
        b.append("}");
        return b.toString();
    }

    public ArbolB() {
        this.mK = 2;
        this.altura = 0;
    }

    public ArbolB(Class clazz) {
        this();
        this.clazz = clazz;
    }

    public void insertar(T value) {
        Key key = new Key(String.valueOf(value.hashCode()));

        if (this.altura == 0) {

            this.root = new Nodo_Arbol_B<>(this.mK, key, value, this.clazz);
            this.altura = 1;
            System.out.println("Valor root Insertado Arbol-B: " + value.toString());
            return;
        }

        Dividir<T> dividiendo = insertDiv(this.root, key, value, 1);

        if (dividiendo == null) {
        } else {

            Nodo_Arbol_B<T> ptr = this.root;

            this.root = new Nodo_Arbol_B<>(this.mK, dividiendo.getLlave(), dividiendo.getValue(), this.clazz);
            this.root.referencias[0] = ptr;
            this.root.referencias[1] = dividiendo.getReferencia();
            this.altura++;
        }
    }

    public void insertar(Key key, T value) {
        //Key key = new Key(String.valueOf(value.hashCode()));

        if (this.altura == 0) {

            this.root = new Nodo_Arbol_B<>(this.mK, key, value, this.clazz);
            this.altura = 1;
            System.out.println("Valor root Insertado Arbol-B: " + value.toString());
            return;
        }

        Dividir<T> dividiendo = insertDiv(this.root, key, value, 1);

        if (dividiendo == null) {
        } else {

            Nodo_Arbol_B<T> ptr = this.root;

            this.root = new Nodo_Arbol_B<>(this.mK, dividiendo.getLlave(), dividiendo.getValue(), this.clazz);
            this.root.referencias[0] = ptr;
            this.root.referencias[1] = dividiendo.getReferencia();
            this.altura++;
        }
    }

    protected Dividir insertDiv(Nodo_Arbol_B<T> node, Key key, T data, int level) {

        Dividir<T> splitted = null;
        Nodo_Arbol_B<T> ptr = null;

        int i = 0;
        while ((i < node.mB) && (key.mayorQue(node.keys[i]))) {
            i++;
        }

        if ((i < node.mB) && key.igualA(node.keys[i])) {

            System.out.println("Valor Repetido: " + data.toString());
            node.data[i] = data;

            return null;
        }

        if (level < this.altura) {

            splitted = insertDiv(node.referencias[i], key, data, level + 1);

            if (splitted == null) {
                return null;
            } else {
                key = splitted.key;
                data = splitted.value;
                ptr = splitted.referencia;
            }
        }

        i = node.mB - 1;
        while ((i >= 0)
                && (node.keys[i] == null || key.menorQue(node.keys[i]))) {
            node.keys[i + 1] = node.keys[i];
            node.data[i + 1] = node.data[i];
            node.referencias[i + 2] = node.referencias[i + 1];
            i--;
        }

        node.keys[i + 1] = key;
        node.data[i + 1] = data;
        if (splitted != null) {
            node.referencias[i + 2] = splitted.referencia;
        }
        node.mB++;

        if (node.mB > 2 * mK) {

            Nodo_Arbol_B<T> newnode = new Nodo_Arbol_B<>(this.mK, this.clazz);
            newnode.referencias[this.mK] = node.referencias[node.mB];
            node.referencias[node.mB] = null;
            node.mB = this.mK + 1;
            for (i = 0; i < this.mK; i++) {
                newnode.keys[i] = node.keys[i + node.mB];
                node.keys[i + node.mB] = null;
                newnode.data[i] = node.data[i + node.mB];
                node.data[i + node.mB] = null;
                newnode.referencias[i] = node.referencias[i + node.mB];
                node.referencias[i + node.mB] = null;
            }
            node.mB--;

            splitted = new Dividir(newnode, node.keys[node.mB], node.data[node.mB]);
            node.keys[node.mB] = null;
            node.data[node.mB] = null;
            newnode.mB = this.mK;
            node.mB = this.mK;

            return splitted;
        }

        return null;
    }

    public T get(Key key) {
        return get(key, root);
    }

    private T get(Key key, Nodo_Arbol_B<T> node) {

        if ((node == null) || (node.mB < 1)) {
            System.err.println("error");
            return null;
        }

        if (key.menorQue(node.keys[0])) {
            return get(key, node.referencias[0]);
        }

        if (key.mayorQue(node.keys[node.mB - 1])) {
            return get(key, node.referencias[node.mB]);
        }

        int i = 0;
        while ((i < node.mB - 1) && (key.mayorQue(node.keys[i]))) {
            i++;
        }

        if (key.igualA(node.keys[i])) {
            return node.data[i];
        }

        return get(key, node.referencias[i]);

    }

    public int getHeight() {
        return altura;
    }

    public Nodo_Arbol_B<T> getRoot() {
        return root;
    }
}
