
package com.mycompany.interfaces;

import com.mycompany.exception.PopException;

public interface Estructuras_Acciones <T>{
    public boolean delete(T value);
    public void push(T value);
    public boolean empty();
    public T pop(int deletePos) throws PopException;
    public T get(int index);
    public boolean contains(T value);
    public boolean delete(int index);
    public int size();
}
