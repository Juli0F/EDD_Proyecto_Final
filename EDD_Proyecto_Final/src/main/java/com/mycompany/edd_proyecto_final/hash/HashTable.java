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

    private int getIndexByHash(V value) {
        return value.hashCode() % valor.size();

    }

    //verifica si el factor de carga es menor o igual a 55%
    //el +1 es para tomar en cuenta el nodo que se insertara
    private boolean isInsertable() {
        return ((55 * valor.size() + 1) / 100) > charge;
    }

    public void insertar(V value) {
        //posicion donde se almacenara el valor
        int index = getIndexByHash(value);

        if (isInsertable()) {

//            
//            ListaSimple<V> lst = valor.get(index);
//            if (lst == null) {
//                lst = new ListaSimple<>();
//                
//            }
//            
//            lst.push(value);
            while (valor.get(index) != null) {
                //aca debo aplicar la otra formula, para encontrar el nuevo lugar  a donde enviare el valor
                //al obtenerlo debo verificar que este vacio nuevamente, hasta encontrar un lugar disponible
                //guardo el indice en index  y termino el ciclo
                index = colisionesFix(value, index);
            }
            valor.push(value, index);

            charge++;

        } else {
            rehashing();
            System.out.println("rehash necesario");
        }
    }

    /*i es el index que hubiera ocupado, de haber estado disponible*/
    private int colisionesFix(V value, int i) {
        //(llv mod 7 + 1) * i.

        return (value.hashCode() % 7 + 1) * i;
    }

    private void rehashing() {
        //para el rehashing almacenare temporalmente los valores en la lista llamada indices

        indices = valor;
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
        System.out.println("get-Index: " + index);
        V v = valor.get(index);

        if ((v != null) && v.hashCode() == value.hashCode()) {
            return v;
        } else {
            //aca debo llamar a la otra funcion, que busque el valor buscado 
            cont++;
            System.out.println("cont " + cont);

            Integer indexV = getIndexColision(value, index);// != null? valor.get(index)

            V valueRec = valor.get(indexV);
            if ((valueRec != null) && value.hashCode() == valueRec.hashCode()) {
                return valueRec;
            }

            return null;
        }

    }

    private Integer getIndexColision(V value, int index) {

        return colisionesFix(value, index);
        //index = colisionesFix(value, index);
//        if (index < valor.size()) {
//
//            if (valor.get(index).equals(value)) {
//                return index;
//                //return value;
//            }
//            return getIndexColision(value, index);
//        }

        //return null;
    }

    public boolean eliminar(V value) {

        int index = getIndexByHash(value);
        if (valor.get(index).hashCode() == value.hashCode()) {
            return valor.pushForce(null, index);

        } else {
            index = getIndexColision(value, index);
            if (valor.get(index).hashCode() == value.hashCode()) {
                return valor.pushForce(null, index);
            }
        }
        return false;

//        int index = getIndexByHash(value);
//        if (valor.get(index).equals(value)) {
//            V v = valor.get(index);
//            v = null;
//            return true;
//        } else {
//            Integer indexColision = getIndexColision(value, index);
//
//            if (indexColision != null) {
//
//                V v = valor.get(indexColision);
//                v = null;
//                return true;
//            }
//        }
//        return false;
    }

    public String testGraph() {

        String cadena = "node [shape = box]\n"
                + "key[label=\"Clave\" width = 1.5, style = filled, fillcolor = firebrick1, group = 1 ];\n"
                + "valor[label=\"Valor\" width = 1.5, style = filled, fillcolor = firebrick1, group = 2 ];\n"
                + "nodo0 [label =\"0\"  width = 1.5 style = filled, fillcolor = bisque1, group = 1 ];\n";
        cadena += "key -> valor;\n";
        cadena += "{rank = same; key; valor}\n"
                + "key -> nodo0;\n";
        for (int i = 1; i <= valor.size(); i++) {
            cadena += "nodo" + i + " [label =\"" + i + "\" pos = \"1.5!\" width = 1.5 style = filled, fillcolor = bisque1, group = 1 ];\n";

        }
        //muestra la columna de cla
        
        cadena += enlazarNodos(false);
        
        String nodoValue = nodoValue();
        cadena += nodoValue+"\n";
        String primer = (String) nodoValue.subSequence(0, 11);
        //
        
        if (!Character.isDigit(primer.charAt(primer.length()-1))) {
            primer = primer.substring(0, primer.length()-1);
        }
        cadena += "valor -> "+primer+"\n";
        return cadena;
    }

    private String nodoValue() {
        String nodoValue = "";

        nodoValue = nodoValue(6);
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
//esto era para que me imprimiera solo las celdas que tuvieran un valor
//si contNull = verdadero entonces contaba los valores nulos de lo contrario los omitia
//        if (!contNull) {
//            for (int i = 0; i < valor.size(); i++) {
//                V v = valor.get(i);
//                if (v != null) {
//                    cadena += "nodo" + i + " -> nodo" + (i + 1) + ";\n";
//                }
//                
//            }
//        } else {
//            for (int i = 0; i < valor.size(); i++) {
//                cadena += "nodo" + i + " -> nodo" + (i + 1) + ";\n";
//            }
//        }

         for (int i = 0; i < valor.size(); i++) {
                cadena += "nodo" + i + " -> nodo" + (i + 1) + ";\n";
            }
        return cadena;
    }

    public void graph(V value, int index) {

        String cadena = "";
        cadena += index + "-> " + value.toString();

    }

}
