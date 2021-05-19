package com.mycompany.edd_proyecto_final.hash;

import com.mycompany.edd_proyecto_final.listas.ListaSimple;

public class HashTable<V> {

    private ListaSimple<V> indices;
    private ListaSimple<V> valor;
    private int charge;
    private int cont;

    public HashTable() {

        valor = new ListaSimple<>(37);
        charge = 0;
        cont = 0;
    }

    public int getEspacioOcupado() {
        return charge;
    }

    private int getIndexByHash(V value) {
        return value.hashCode() % valor.size();

    }

    //verifica si el factor de carga es menor o igual a 55%
    //el +1 es para tomar en cuenta el nodo que se insertara
    private boolean isInsertable() {
        return ((55 * valor.size() + 1) / 100) >= charge;
    }

    public boolean insertar(V value) {
        //posicion donde se almacenara el valor
        int index = getIndexByHash(value);
        if (index < 0) {
            index *= -1;
        }

        if (isInsertable()) {

            //cambie el while por el if, porque al momento de recuperar el objeto almacenado
            //y a este se le aplica el metodo colisionesFix(value, index), me lanza un error de overflow
            //while 
            if (valor.get(index) != null) {
                //aca debo aplicar la otra formula, para encontrar el nuevo lugar  a donde enviare el valor
                //al obtenerlo debo verificar que este vacio nuevamente, hasta encontrar un lugar disponible
                //guardo el indice en index  y termino el ciclo
                index = colisionesFix(value, index);
                index = (index < 0) ? (-1 * index) : index;
            }

            System.out.println("Index " + index);
            if (valor.push(value, index)) {
                charge++;
                return true;
            }
            return false;

        } else {
            rehashing(value);
            System.out.println("rehash necesario");
            return true;
        }
    }

    /*i es el index que hubiera ocupado, de haber estado disponible*/
    private int colisionesFix(V value, int i) {
        //(llv mod 7 + 1) * i.

        return (value.hashCode() % 7 + 1) * i;
    }

    private void rehashing(V v) {
        //para el rehashing almacenare temporalmente los valores en la lista llamada indices

        indices = valor;
        int i = 0;
        //agregue esta parte, porque se me habia olvidado insertar el ultimo valor antes de hacer el hashing
        while (!indices.push(v, i)) {
            i++;
        }

        valor = null;
        charge = 0;
        valor = new ListaSimple<>(indices.size() * 2);

        rehashing(0);
    }

    private void rehashing(int index) {

        V v = indices.get(index);

        if (v != null) {
            insertar(v);
        }

        if (index != indices.size()) {
            index++;
            rehashing(index);
        }
    }

    public V getValue(V value) {

        int index = getIndexByHash(value);
        index = (index < 0) ? (-1 * index) : index;
        System.out.println("get-Index: " + index);
        V v = valor.get(index);

        if ((v != null) && v.hashCode() == value.hashCode()) {
            return v;
        } else {
            //aca debo llamar a la otra funcion, que busque el valor buscado 
            cont++;
            System.out.println("cont " + cont);

            index = getIndexColision(value, index);// != null? valor.get(index)
            index = (index < 0) ? (-1 * index) : index;
            
            V valueRec = valor.get(index);
            if ((valueRec != null) && value.hashCode() == valueRec.hashCode()) {
                return valueRec;
            }

            return null;
        }

    }

    private Integer getIndexColision(V value, int index) {

        return colisionesFix(value, index);
    }

    public boolean eliminar(V value) {

        int index = getIndexByHash(value);
        if (valor.get(index).hashCode() == value.hashCode()) {
            return valor.pushForce(null, index);

        } else {
            index = getIndexColision(value, index);
            if (valor.get(index).hashCode() == value.hashCode()) {
                charge--;
                return valor.pushForce(null, index);
            }
        }
        return false;

    }

    public String testGraph() {

        String cadena = "node [shape = box]\n"
                + "key[label=\"Clave\" width = 1.5, style = filled, fillcolor = firebrick1, group = 1 ];\n"
                + "valor[label=\"Valor\" width = 1.5, style = filled, fillcolor = firebrick1, group = 2 ];\n"
                + "nodo0 [label =\"0\"  width = 1.5 style = filled, fillcolor = bisque1, group = 1 ];\n";
        cadena += "key -> valor;\n";
        cadena += "{rank = same; key; valor}\n"
                + "key -> nodo0;\n";

        for (int i = 0; i <= valor.size(); i++) {
            cadena += "nodo" + i + " [label =\"" + i + "\" pos = \"1.5!\" width = 1.5 style = filled, fillcolor = bisque1, group = 1 ];\n";

        }

        cadena += enlazarNodos(false);

        String nodoValue = nodoValue();
        cadena += nodoValue + "\n";
        String primer = "";
        if (nodoValue.length() > 10) {
            primer = (String) nodoValue.subSequence(0, 11);
            if (!Character.isDigit(primer.charAt(primer.length() - 1))) {
                primer = primer.substring(0, primer.length() - 1);
                cadena += "valor -> " + primer + "\n";
            }
        }

        //
        return cadena;
    }

    private String nodoValue() {
        String nodoValue = "";

        nodoValue = nodoValue(0);
        return nodoValue;
    }

    private String nodoValue(int index) {
        String cadena = "";
        V v = valor.get(index);

        if (index <= valor.size()) {

            if (v != null) {

                cadena += "nodoValue" + index + "[label=\"" + v.toString() + "\" group = 2]\n";
                cadena += "nodo" + index + " -> nodoValue" + index + "\n";
                cadena += "{rank = same; nodo" + index + "; nodoValue" + index + "};\n";

            }
            cadena += nodoValue(index + 1);

            return cadena;
        }
        return cadena;
    }

    private String enlazarNodos(boolean contNull) {
        String cadena = "";
        for (int i = 0; i < valor.size(); i++) {
            cadena += "nodo" + i + " -> nodo" + (i + 1) + ";\n";
        }
        return cadena;
    }

    public int size() {
        return valor.size();
    }
}
