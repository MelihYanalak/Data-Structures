package com.company;


import java.util.Iterator;

public class matrixIter implements Iterator<Integer>, Iterable<Integer>{
    private int vertex;
    private int current;
    private matrixGraph mg;

    public matrixIter(matrixGraph mg){
        vertex = 0;
        current = 0;
        this.mg = mg;
    }
    @Override
    public Iterator<Integer> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        if(current == mg.getVertexNum()){
            return false;
        }
        else return true;
    }

    @Override
    public Integer next() {
        return current++;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public void setVertex(int vertex) {
        this.vertex = vertex;
    }

    public int getCurrent() {
        return current;
    }

    public int getVertex() {
        return vertex;
    }


}
