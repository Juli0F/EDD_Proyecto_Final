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
        System.out.println("get-Index: "+ index);
        V v = valor.get(index);
        
        
        if ( ( v != null) &&  v.hashCode() == value.hashCode()) {
            return v;
        } else {
            //aca debo llamar a la otra funcion, que busque el valor buscado 
            cont++;
            System.out.println("cont "+cont);
            
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
            
        }else{
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
    
    public String  testGraph(){
        return valor.testGraph(1);
    }

}
