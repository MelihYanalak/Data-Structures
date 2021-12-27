package com.company;

import java.sql.Time;

/**
 * Driver(Test) Class
 * @author Melih Yanalak
 */
public class Main {

    public static void main(String[] args) {
	    ExperimentList eList = new ExperimentList();
	    Experiment e2 = new Experiment("e2 ",2,new Time(9,0,0),true,(float)0.91);
        Experiment e4 = new Experiment("e4 ",3,new Time(10,0,0),true,(float)0.82);
        Experiment e = new Experiment("e ",1,new Time(17,30,0),true,(float)1);
        Experiment e3 = new Experiment("e3 ",2,new Time(12,50,0),true,(float)0.7);
	    eList.addExp(e2); // adding when head is null
        eList.addExp(e4); //adding to the end of the list
        eList.addExp(e); // adding to the head of the list
        eList.addExp(e3); // adding to the middle of the list
        System.out.println("-------FIRST LOOKING OF LIST--------\n");
        eList.printList();
        eList.removeDay(2);
        System.out.println("-------AFTER REMOVING DAY 2--------\n");
        eList.printList();
        eList.removeExp(1,0);
        System.out.println("-------AFTER REMOVING HEAD --------\n");
        eList.printList();
        eList.addExp(e);
        eList.addExp(e2);
        eList.addExp(e3);
        eList.setExp(2,1,new Experiment("Set method called",2,(new Time(4,52,0)),true,(float)0.11));
        System.out.println("-------AFTER SETTING EXPERIMENT --------\n");
        System.out.println(eList.getExp(2,1).getData());

        System.out.println("-------BEFORE SORTING DAY 2--------\n");
        eList.listExp(2);
        eList.orderDay(2);
        System.out.println("-------AFTER SORTING DAY 2--------\n");
        eList.listExp(2);
        ExperimentList eList2 = eList.orderExperiments();
        System.out.println("-------AFTER SORTING ALL THE LIST--------\n");
        eList2.printList();
    }
}