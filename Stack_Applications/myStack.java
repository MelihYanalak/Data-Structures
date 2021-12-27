package com.company;

import java.util.Arrays;

public class myStack<E> {
    private Object data[];
    private int used;

    public myStack(){
        data = new Object[20];
        used = 0;
    }
    public myStack(int capacity){
        data = new Object[capacity];
        used = 0;
    }
    public void push(E input){
        if(used == data.length){
            increase_C();
        }
        data[used] = input;
        used++;
    }
    public E pop(){
        if(used == 0){
            return null;
        }
        E temp = (E) data[used-1];
        data[used-1] = null;
        used--;
        return temp;
    }
    public boolean empty(){
        if (used == 0){
            return true;
        }
        else {
            return false;
        }
    }
    public E peek(){
        E temp = (E) data[used-1];
        return temp;
    }

    private void increase_C(){
        data = Arrays.copyOf(data,(data.length * 2)); //O(n) complexity
    }






}
