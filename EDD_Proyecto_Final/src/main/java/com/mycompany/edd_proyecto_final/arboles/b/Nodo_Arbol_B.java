

package  com.mycompany.edd_proyecto_final.arboles.b;

import java.lang.reflect.Array;

public class Nodo_Arbol_B<T> {

    int mK;
    int mB;
    Key[] keys;
    T[] data;
    Nodo_Arbol_B<T>[] referencias;

    
    public String getDotName() {
        return "Nodo" + this.hashCode();
    }

    public String testGraph() {

        StringBuilder b = new StringBuilder();

        b.append(getDotName());
        b.append("[label=\"<P0>");
        for (int i = 0; i < mB; i++) {
            b.append("|").append(keys[i].getKey());
            //b.append("|").append(data[i].toString());//esta linea imprime el toString de cada valor almacenado en un arbol
            b.append("|<P").append(i + 1).append(">");
        }

        b.append("\"];\n");

        for (int i = 0; i <= mB; i++) {
            if (referencias[i] != null) {
                b.append(referencias[i].testGraph());
                b.append(getDotName()).append(":P").append(i).append(" -> ").append(referencias[i].getDotName()).append(";\n");
            }
        }

        return b.toString();
    }

    public Nodo_Arbol_B(int pK, Class clazz) {
        this.mK = pK;
        mB = 0;
        keys = new Key[2 * pK + 1];
        data = (T[]) Array.newInstance(clazz, 2 * pK + 1);
        referencias = new Nodo_Arbol_B[(2 * pK) + 2];
    }

    public Nodo_Arbol_B(int pK, Key key, T value, Class clazz) {
        this(pK, clazz);
        mB = 1;
        keys[0] = key;
        data[0] = value;
    }

    public void setK(int mK) {
        this.mK = mK;
    }

    public int getK() {
        return mK;
    }
}
