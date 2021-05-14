
package com.mycompany.edd_proyecto_final.hash;

import com.mycompany.edd_proyecto_final.listas.ListaSimple;


public class HashTable<K, V> {
    private ListaSimple<K> indices;
    private ListaSimple<V> valor;
    private int charge;

    public HashTable() {
        indices = new ListaSimple<>();
        valor = new ListaSimple<>();
        charge = 0;
    }
    
    
    private int getIndexByHash(V value){
        return value.hashCode() % valor.size();
        
    }
    
    private boolean isInsertable(){
        return ((55*valor.size()+1)/100)< charge;
    }
    public void insertar(V value){
        
        int index = getIndexByHash(value);
        if (valor.push(value, index)) {
            System.out.println("Valor insertado");
           charge++;
        }else{
            System.out.println("rehash necesario");
        }
    }
    
    

}
