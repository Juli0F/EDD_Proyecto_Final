

package  com.mycompany.edd_proyecto_final.arboles.b;


public class Dividir<T> {

    Nodo_Arbol_B<T> referencia;
    Key key;
    T value;

    public Dividir(Nodo_Arbol_B<T> referencia, Key key, T value) {
        this.referencia = referencia;
        this.key = key;
        this.value = value;
    }

    public Nodo_Arbol_B<T> getReferencia() {
        return referencia;
    }

    public void setReferencia(Nodo_Arbol_B<T> referencia) {
        this.referencia = referencia;
    }

    public void setLlave(Key mLlave) {
        this.key = mLlave;
    }

    public Key getLlave() {
        return key;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
