/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.exception.PopException;

/**
 *
 * @author Temporal
 */
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
