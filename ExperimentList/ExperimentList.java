package com.company;

import java.util.Iterator;

/**
 * This class implements additional functions that will be used for linked list structure
 * @author Melih Yanalak
 *
 */
public class ExperimentList implements Iterable<Node> {
    private Node head; // Head keeps the first experiment of list
    private my_Iterator iter; // iterator to use for indicating

    /**
     *
     * @param input takes an input as a first element of a linked list
     */
    public ExperimentList(Node input){
        head = input;
    }

    /**
     * No parameter constructor.Head will be null
     */
    public ExperimentList(){
        head = null;
        iter = new my_Iterator();
    }

    /**
     *
     * @return Head of the list
     */
    public Node getHead() {
        return head;
    }

    /**
     * For multiple possibilities there are conditions to add (Conditions are made clear in comments)
     * @param e Experiment that will be added to the list
     */
    public void addExp(Experiment e){
        if(head == null){ // If the list is empty
            head = new Node();
            head.setData(e);
            head.setNextDay(null);
            head.setNextExperiment(null);
        }
        else if(head != null){ // If the list is not empty
            if(e.getDay() < head.getData().getDay()){ // If the parameter experiment will be added to the head
                Node temp = head;
                head = new Node();
                head.setData(e);
                head.setNextExperiment(temp);
                head.setNextDay(temp);

            }
            else if(e.getDay() == head.getData().getDay()){ //// If the parameter experiment will be added to the end of the first day
                Node cur = head;
                // In while loop it reaches the end of the first day
                while(cur.getNextExperiment() != null && (cur.getNextExperiment().getData().getDay() == e.getDay())){
                    cur = cur.getNextExperiment();
                }
                if(cur.getNextExperiment() == null){
                    Node temp = new Node();
                    temp.setData(e);
                    temp.setNextExperiment(null);
                    temp.setNextDay(null);
                    cur.setNextExperiment(temp);
                }
                else{
                    Node temp2 = cur.getNextExperiment();
                    Node toAdd = new Node();
                    toAdd.setData(e);
                    toAdd.setNextExperiment(temp2);
                    toAdd.setNextDay(null);
                    cur.setNextExperiment(toAdd);

                }
            }

            else if(e.getDay() >= head.getData().getDay()){ // If the parameter experiment will not be added to the first day
                Node cur = head;
                //Reaches the specified day
                while(cur.getNextDay() != null && (cur.getNextDay().getData().getDay() <= e.getDay())){
                    cur = cur.getNextDay();
                }
                if(e.getDay() > cur.getData().getDay()){ // If there are no experiments with specified day,creates a new day
                    Node temp4 = cur.getNextDay();
                    Node toAdd2 = new Node();
                    toAdd2.setData(e);
                    toAdd2.setNextDay(temp4);
                    toAdd2.setNextExperiment(temp4);
                    cur.setNextDay(toAdd2);
                    cur.setNextExperiment(toAdd2);


                }
                else if(e.getDay() == cur.getData().getDay()){ // If there exist a day that experiment will be added to
                    while(cur.getNextExperiment() != null && (cur.getNextExperiment().getData().getDay() == e.getDay())){
                        cur = cur.getNextExperiment();
                    }
                    if(cur.getNextExperiment() == null){
                        Node temp = new Node();
                        temp.setData(e);
                        temp.setNextExperiment(null);
                        temp.setNextDay(null);
                        cur.setNextExperiment(temp);
                    }
                    else{
                        Node temp2 = cur.getNextExperiment();
                        Node toAdd = new Node();
                        toAdd.setData(e);
                        toAdd.setNextExperiment(temp2);
                        toAdd.setNextDay(null);
                        cur.setNextExperiment(toAdd);

                    }
                }
                else if(cur.getNextDay() == null){
                    Node toAdd3 = new Node();
                    toAdd3.setData(e);
                    toAdd3.setNextExperiment(null);
                    toAdd3.setNextDay(null);
                    cur.setNextDay(toAdd3);
                    cur.setNextExperiment(toAdd3);

                }

            }


        }
    }

    /**
     *
     * @param day Day data of the experiment that will be removed from list
     * @param index Position of the experiment in specified day
     */
    public void removeExp(int day,int index){
        if(day == head.getData().getDay() && index == 0){
            if(head.getNextExperiment() == null){
                head = null;
            }
            else if(head.getData().getDay() < head.getNextExperiment().getData().getDay()){
                head = head.getNextExperiment();
            }
            else if(head.getData().getDay() == head.getNextExperiment().getData().getDay()){
                head.getNextExperiment().setNextDay(head.getNextDay());
                head = head.getNextExperiment();
            }
        }
        else {
            Node cur = head;
            Node prevDay =  head;
            Node prevExp = head;
            while(cur.getData().getDay() != day){
                prevDay = cur;
                prevExp = cur;
                cur = cur.getNextDay();
            }
            int i = 0;
            while (i < index){
                prevExp = cur;
                cur = cur.getNextExperiment();
                i++;
            }
            if(cur.getNextExperiment() == null){
                prevExp.setNextDay(null);
                prevExp.setNextExperiment(null);
            }
            else if (cur.getData().getDay() > prevExp.getData().getDay() && cur.getData().getDay() < cur.getNextExperiment().getData().getDay()){
                Node temp = cur.getNextExperiment();
                prevDay.setNextDay(temp);
                prevExp.setNextExperiment(temp);
            }
            else if (cur.getData().getDay() == prevExp.getData().getDay() && cur.getData().getDay() < cur.getNextExperiment().getData().getDay()){
                prevExp.setNextExperiment(cur.getNextExperiment());
            }
            else if (cur.getData().getDay() > prevExp.getData().getDay() && cur.getData().getDay() == cur.getNextExperiment().getData().getDay()){
                Node temp = cur.getNextExperiment();
                prevDay.setNextDay(temp);
                prevExp.setNextExperiment(temp);
            }
            else if (cur.getData().getDay() == prevExp.getData().getDay() && cur.getData().getDay() == cur.getNextExperiment().getData().getDay()){
                prevExp.setNextExperiment(cur.getNextExperiment());
            }


        }
    }

    /**
     *
     * @param day Removes all the experiments in the specified day
     */
    public void removeDay(int day){
        int i = 0;
        Node cur = head;
        while (cur.getData().getDay() != day){
            cur = cur.getNextDay();
        }
        while(cur.getNextExperiment() != null){
            i++;
            cur = cur.getNextExperiment();
        }
        while(i > 0){
            removeExp(day,i-1);
            i--;
        }
    }

    /**
     * Orders each experiment according to the accuracy value(ascending)
     * @param day day that will be sorted
     */
    public void orderDay(int day){
        Node cur = head;
        while (cur.getData().getDay() != day){
            cur = cur.getNextDay();
        }
        while(cur.getNextExperiment() != null && cur.getNextExperiment().getData().getDay() == day){
            Node temp = cur.getNextExperiment();
            while(temp!= null && temp.getData().getDay() == day){
                if(cur.getData().getAccuracy() > temp.getData().getAccuracy() ){
                    Experiment temp2 = cur.getData();
                    cur.setData(temp.getData());
                    temp.setData(temp2);
                }
                temp = temp.getNextExperiment();
            }
                cur = cur.getNextExperiment();

        }


    }

    /**
     * Orders all the experiments in the list and Creates a new sorted list
     * @return Returns new sorted list
     */
    public ExperimentList orderExperiments(){
        ExperimentList returnList = copyList();
        Node cur = returnList.getHead();
        while(cur.getNextExperiment() != null ){
            Node temp = cur.getNextExperiment();
            while(temp!= null ){
                if(cur.getData().getAccuracy() > temp.getData().getAccuracy() ){
                    Experiment temp2 = cur.getData();
                    cur.setData(temp.getData());
                    temp.setData(temp2);
                }
                temp = temp.getNextExperiment();
            }
            cur = cur.getNextExperiment();

        }
        return returnList;
    }

    /**
     *
     * @param day day input
     * @param index index input
     * @return returns the specified experiment with index and day
     */
    public Node getExp(int day,int index){
        Node temp = head;
        while (temp.getData().getDay() != day){
            temp = temp.getNextDay();
        }
        int i = 0;
        while(i < index){
            temp = temp.getNextExperiment();
            i++;
        }
        return temp;
    }

    /**
     * Changes the experiment information
     * @param day day input
     * @param index index input
     * @param input Experiment that will be replaced
     */
    public void setExp(int day,int index,Experiment input){
        Node temp = head;
        while (temp.getData().getDay() != day){
            temp = temp.getNextDay();
        }
        int i = 0;
        while(i < index){
            temp = temp.getNextExperiment();
            i++;
        }
        temp.setData(input);
    }

    /**
     * Prints all the experiments in the list in order to check accuracy of program
     */
    public void printList(){
        if(head != null ){
            Node current = head;
            while(current != null){
                System.out.println(current.getData());
                current = current.getNextExperiment();
            }
        }
    }

    /**
     * Lists all the experiments in the specified day
     * @param day day input
     */
    public void listExp(int day){
        Node temp = head;
        if(head == null){
            return;
        }
        while (temp.getData().getDay() != day && temp.getNextDay() != null ){
            temp = temp.getNextDay();
        }

        while(temp != null && temp.getData().getDay() == day  ){
            if(temp.getData().getCompleted()==true) {
                System.out.println(temp.getData() + "\n");
            }
            temp = temp.getNextExperiment();
        }
    }

    /**
     * Overridden method that comes from Iterable interface
     * @return Iterator that i created myself
     */
    @Override
    public my_Iterator iterator() {
        return iter;
    }

    /**
     * Creates another list and copies the original one in order to be used as a helper function in orderExperiments
     * @return new copy
     */
    public ExperimentList copyList()
    {
        Node current = head;	// used to iterate over original list
        Node newList = null; // head of the new list
        Node tail = null;	// point to last node in new list

        while (current != null)
        {
            // special case for the first new node
            if (newList == null)
            {
                newList = new Node(current.getData(),null, current.getNextDay());
                tail = newList;
            }
            else
            {
                tail.setNextExperiment(new Node());
                tail = tail.getNextExperiment();
                tail.setData(current.getData());
                tail.setNextDay(current.getNextDay());
                tail.setNextExperiment(null);
            }
            current = current.getNextExperiment();
        }

        return (new ExperimentList(newList));
    }




}
