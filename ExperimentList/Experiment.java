package com.company;

import java.sql.Time;

/**
 * Experiment class that will keep different kind of data necessary
 * @author Melih Yanalak
 */
public class Experiment {
    private String setup;
    private int day;
    private Time time;
    private Boolean completed;
    private Float accuracy;

    /**
     * Constructor with all the information parameters
     * @param setup_input setup input
     * @param day_input day input
     * @param time_input time input
     * @param completed_input completed imput
     * @param accuracy_input accuracy imput
     */
    public Experiment(String setup_input,int day_input,Time time_input,Boolean completed_input,Float accuracy_input){
        setup = setup_input;
        day = day_input;
        time = time_input;
        completed = completed_input;
        accuracy = accuracy_input;
    }

    /**
     * Getter function
     * @return completed data
     */
    public Boolean getCompleted() {
        return completed;
    }

    /**
     * Getter function
     * @return accuracy data
     */
    public Float getAccuracy() {
        return accuracy;
    }

    /**
     * Getter function
     * @return time data
     */
    public Time getTime() {
        return time;
    }

    /**
     * Getter function
     * @return setup data
     */
    public String getSetup() {
        return setup;
    }

    /**
     * Getter function
     * @return day data
     */
    public int getDay() {
        return day;
    }

    /**
     * Setter function
     * @param day day input
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * Setter function
     * @param setup setup input
     */
    public void setSetup(String setup) {
        this.setup = setup;
    }

    /**
     * Setter function
     * @param accuracy accuracy input
     */
    public void setAccuracy(Float accuracy) {
        this.accuracy = accuracy;
    }

    /**
     * Setter function
     * @param completed completed input
     */
    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    /**
     * Setter function
     * @param time time input
     */
    public void setTime(Time time) {
        this.time = time;
    }

    /**
     * To string method that overridden,comes from Object class
     * @return returns string that includes data
     */
    @Override
    public String toString() {
        return (
                "SETUP : "+setup+"  -  "+
                " DAY : "+day+"  -  "+
                " TIME : "+time+"  -  "+
                " COMPLETED : "+completed+"  -  "+
                " ACCURACY : "+accuracy+"\n"
                );

    }

}
