package com.mycompany.edd_proyecto_final.listas;

import com.mycompany.edd_proyecto_final.entidades.Edificio;
import java.util.Objects;

public class Nodo<T> {

    private Nodo<T> siguiente;
    private Nodo<T> anterior;
    private T value;
    private int id;
    private static int i = 0;

    public Nodo() {

        this.id = i++;

    }

    public Nodo(T value, boolean incrementI) {
        this.value = value;
        id = incrementI ? i++ : 0;
    }

    public Nodo(Nodo<T> siguiente, Nodo<T> anterior, T value) {
        this.siguiente = siguiente;
        this.anterior = anterior;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo<T> anterior) {
        this.anterior = anterior;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Nodo(T value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.value);
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

    public String testGraph(boolean doble, boolean circular, int group) {
        String cadena = "";
        if (circular) {

            if (siguiente.getSiguiente() == null && siguiente.getSiguiente().getId() == 0) {
                cadena += this.getSiguiente().getId() + "[group = " + group + ",label=\"" + this.getSiguiente().getValue().toString() + "\"];\n";
                cadena += this.getSiguiente().getId() + " -> " + siguiente.getSiguiente().getId();
                cadena += "\n" + siguiente.getSiguiente().getId() + " -> " + siguiente.getId() + "\n";
            }

        }

        if (siguiente != null && siguiente.getId() != 0) {
            cadena += this.getId() + "[group = " + group + ",label=\"" + this.getValue().toString() + "\"];\n";
            cadena += this.getId() + " -> " + siguiente.getId();

            if (doble) {
                cadena += "\n" + siguiente.getId() + " -> " + this.getId();
            }

            cadena += "\n" + siguiente.testGraph(doble, circular, siguiente.value.hashCode());

        } else {
            cadena += this.getId() + "[group = " + group + ",  label=\"" + this.getValue().toString() + "\"];\n";
        }
        return cadena;

    }

    @Override
    public String toString() {
//        String siguienteToString = "->null";
//        String anteriorStr = "";
//        if (siguiente != null && siguiente.getId() != 0) {
//            siguienteToString = siguiente.toString();
//            if (anterior != null && siguiente.getId() != 0) {
//                anteriorStr = "-> " + value.toString();
//                //anteriorStr = " <- " + " (id: " + id + ", value: " + value + ")";
//            }
//
//        }
//        if (siguiente.getId() == 0) {
//            siguienteToString = "->( " + siguiente.getValue().toString() + ")";
//            if (anterior != null) {
//                anteriorStr = " -> " + value.toString();//" (id: " + id + ", value: " + value + ")";
//                //anteriorStr = " <- " + " (id: " + id + ", value: " + value + ")";
//            }
//        }
//
//        return anteriorStr + value.toString() + siguienteToString;//+", value=" + value  ;
        String cadena = "";
        if (value instanceof Edificio) {
            Edificio e = (Edificio)value;
            cadena = "Edificio: "+e.getId()+"\nCantidad De Salones: "+e.getLstSalon().size();
        }
        return cadena;//Nodo: "+this.id+" value: "+ value.toString();
    }

}
