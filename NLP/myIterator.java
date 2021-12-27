package com.company;

import java.util.Iterator;

public class myIterator implements Iterator<Word_Map.Node> {
    private Word_Map.Node head;
    private Word_Map.Node current;

    public myIterator(Word_Map.Node a){
        head = a;
        current = null;
    }

    public Word_Map.Node getHead() {
        return head;
    }

    public myIterator(){
        head = null;
        current = null;
    }
    public void setCurrent(Word_Map.Node current) {
        this.current = current;
    }

    public void setHead(Word_Map.Node head) {
        this.head = head;
    }

    @Override
    public boolean hasNext() {
        if (current == null && head != null){
            return true;
        }
        return (current.getNextInserted() != null);

    }
    public Word_Map.Node get(){
        return current;
    }
    @Override
    public Word_Map.Node next() {
        if (current == null && head != null){
            current = head;
            return current;
        }
        current = current.getNextInserted();
        return current;
    }
}
