package com.company;

public abstract class abstractGraph {
    private boolean directed;
    private int vertexNum;


    public void setDirected(boolean directed) {
        this.directed = directed;
    }

    public void setVertexNum(int vertexNum) {
        this.vertexNum = vertexNum;
    }

    public int getVertexNum() {
        return vertexNum;
    }

    public boolean isDirected() {
        return directed;
    }

}
