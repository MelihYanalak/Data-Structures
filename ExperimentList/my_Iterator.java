package com.company;

/**
 * Iterator class that will be used in ExperimentList class to indicate
 * @author Melih Yanalak
 */
public class my_Iterator implements java.util.Iterator<Node> {
    private Node current;

    /**
     * Overridden method comes from iterator
     * @return true if an experiment has next experiment
     */
    @Override
    public boolean hasNext() {

        if(current.getNextExperiment() == null){
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * Moves forward by one experiment and returns next one
     * @return next experiment
     */
    @Override
    public Node next() {
        if(hasNext()){
            current = current.getNextExperiment();
        }
        return current;
    }
    public my_Iterator(ExperimentList l){
        current = l.getHead();
    }

    /**
     * removes element
     */
    @Override
    public void remove() {}
    public  my_Iterator(){
        current = null;
    }

}
