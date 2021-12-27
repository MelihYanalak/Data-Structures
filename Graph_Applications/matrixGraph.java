package com.company;

import java.util.Iterator;

public class matrixGraph extends abstractGraph {
    private boolean[][] adjMatrix;

    public matrixGraph(boolean directed, int vertexNum) {
        //super(directed, vertexNum);
        setDirected(directed);
        setVertexNum(vertexNum);
        adjMatrix = new boolean[vertexNum][vertexNum];
        // JAVA INITIALIZES TO FALSE
    }


    public boolean isPopular(int v){
        for (int i = 0; i<getVertexNum() ; i++){
            if (adjMatrix[i][v-1] == false && (i != v-1)){
                return false;
            }
        }
        return true;
    }
    public int findNum(){
        int count = 0;
        for (int i = 1; i <= getVertexNum(); i++){
            if (isPopular(i)){
                count++;
            }
        }
        return count;
    }
    public void addRelation(int v1,int v2){
        if (isDirected()){
            adjMatrix[v1-1][v2-1] = true;
        }
        else {
            adjMatrix[v1-1][v2-1] = true;
            adjMatrix[v2-1][v1-1] = true;
        }

    }
    public void makeTransitive(){
        for (int i = 0; i < getVertexNum(); i++){
            for (int j = 0; j < getVertexNum(); j++){
                if (adjMatrix[i][j] && (i != j)){
                    for (int k = 0; k < getVertexNum() ; k++){
                        if (adjMatrix[j][k]){
                            adjMatrix[i][k] = true;
                        }
                    }
                    for (int k = 0; k < getVertexNum() ; k++){
                        if (adjMatrix[k][i]){
                            adjMatrix[k][j] = true;
                        }
                    }
                }
            }

        }

    }
    public void printMatrix(){

        for (int i = 0; i < getVertexNum(); i++) {
            for (int j = 0; j < getVertexNum(); j++) {
                System.out.print(adjMatrix[i][j]+" ");

            }
            System.out.println();
        }
    }
    public boolean isRelation(int v1,int v2){
        return adjMatrix[v1-1][v2-1];
    }








}
