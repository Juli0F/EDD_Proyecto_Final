
package  com.mycompany.edd_proyecto_final.arboles.b;

public class Key {

    private String key;

    public Key(String key) {
        this.key = key;
    }

    public boolean igualA(Key pObjeto) {
        return key.equals(pObjeto.getKey());
    }

    public boolean menorQue(Key pObjeto) {
        return key.compareTo((String) pObjeto.getKey()) < 0;
    }

    public boolean mayorQue(Key pObjeto) {
        return key.compareTo((String) pObjeto.getKey()) > 0;
    }

    public boolean menorOIgualQue(Key pObjeto) {
        return key.compareTo((String) pObjeto.getKey()) <= 0;
    }

    public boolean mayorOIgualQue(Key pObjeto) {
        return key.compareTo((String) pObjeto.getKey()) >= 0;
    }

    public String getKey() {
        return key;
    }
}
