package com.company;

/**
 * This clas implemented to keep experiments and also their links
 * @author Melih Yanalak
 */
public class Node {
    private Experiment data;
    private Node nextExperiment;
    private Node nextDay;

    /**
     * Constructor with no parameter
     */
    public Node(){ }

    /**
     * Constructor with data parameters
     * @param input experiment data
     * @param nextEx next Experiment of the current experiment
     * @param nextD The first experiment of the next day of the current experiment
     */
    public Node(Experiment input,Node nextEx,Node nextD){
        data = input;
        nextExperiment = nextEx;
        nextDay = nextD;
    }

    /**
     * Setter function
     * @param input experiment input
     */
    public void setData(Experiment input){
        data = input;
    }

    /**
     * Setter function
     * @param input Next Experiment
     */
    public void setNextExperiment(Node input){
        nextExperiment = input;
    }

    /**
     * Setter function
     * @param input Next Day
     */
    public void setNextDay(Node input){
        nextDay = input;
    }

    /**
     * Getter Function
     * @return data
     */
    public Experiment getData(){
        return data;
    }
    /**
     * Getter Function
     * @return next experiment
     */
    public Node getNextExperiment(){
        return nextExperiment;
    }
    /**
     * Getter Function
     * @return next day
     */
    public Node getNextDay(){
        return nextDay;
    }

    /**
     * Overridden toString method
     * @return returns the string that includes data of object
     */
    @Override
    public String toString() {
        return (
                "---DATA---\n"+data.toString()+"\n\n"+
                "---NEXT EXPERIMENT---\n"+nextExperiment.data.toString()+"\n\n"+
                "---NEXT DAY---\n"+nextDay.data.toString()
                );
    }
}
