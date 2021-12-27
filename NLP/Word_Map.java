package com.company;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.*;

public class Word_Map implements Map, Iterable {

    final static int INITCAP=10;  //initial capacity
    int CURRCAP = INITCAP;   //current capacity
    final static float LOADFACT = 0.75f;
    private Node table[];
    private myIterator iter = new myIterator();
    private int numKeys = 0;

    public Word_Map() {
        this.table = new Node[INITCAP];
    }

    @Override
    public Iterator iterator() {
        return iter;
    }

    static class Node {
        // complete this class according to the given structure in homework definition
        private entry ent;
        private Node nextInserted;
        public Node(entry ent,Node nextInserted){
            this.ent = ent;
            this.nextInserted = nextInserted;
        }

        public entry getEnt() {
            return ent;
        }

        public Node getNextInserted() {
            return nextInserted;
        }

        public String getWord() {
            return ent.getKey();
        }

        public File_Map getValue() {
            return ent.getValue();
        }

        public void setNextInserted(Node nextInserted) {
            this.nextInserted = nextInserted;
        }
        public void setValue(File_Map input){
            ent.setValue(input);
        }




    }

    @Override
    public int size() {
        return numKeys;
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    /*Use linked structure instead of table index
    to perform search operation effectively
     * */
    public boolean containsKey(Object key) {
        int index = find(key);
        if (table[index] == null){
            return false;
        }
        else {
            return true;
        }

    }

    @Override
    /*Use linked structure instead of table index
    to perform search operation effectively
     * */
    public boolean containsValue(Object value) {
        myIterator tempIter = new myIterator(iter.getHead());
        while (tempIter.hasNext()){
            if (tempIter.next().getValue() == value){
                return true;
            }
        }
        return false;
    }
    public int find(Object key){
        int index = (key.hashCode() % table.length);
        if (index < 0 ){
            index = index + table.length;
        }
        while (table[index] != null && !key.equals(table[index].getWord())){
            index++;
            if (index >= table.length){
                index = 0;
            }

        }
        return index;
    }

    @Override
    public File_Map get(Object key) {
        int index = find(key);
        return (table[index].getValue());

    }
    public Object put(Object key){
        int index = find(key);
        table[index] = new Node(new entry( (String) key, new File_Map()),null);
        if (numKeys == 0){
            iter.setHead(table[index]);
            iter.setCurrent(table[index]);
        }
        else {
            iter.get().setNextInserted(table[index]);
            iter.setCurrent(table[index]);

        }
        numKeys++;
        double loadFactor = (double) numKeys / (double) table.length;
        if (loadFactor > LOADFACT) {
            rehash();
        }
        return null;
    }
    @Override
    /*
    Use linear probing in case of collision
    * */
    public Object put(Object key, Object value) {
        int index = find(key);
        if (table[index] == null) {
            table[index] = new Node(new entry( (String) key, (File_Map) value),null);
            if (numKeys == 0){
                iter.setHead(table[index]);
                iter.setCurrent(table[index]);
            }
            else {
                iter.get().setNextInserted(table[index]);
                iter.setCurrent(table[index]);
            }
            numKeys++;

            // Check whether rehash is needed.
            double loadFactor = (double) numKeys / (double) table.length;
            if (loadFactor > LOADFACT) {
                rehash();
            }
            return null;
        }
        File_Map oldVal = table[index].getValue();
        //table[index].getValue().put(value);
        return oldVal;

    }
    private void rehash(){
        Node oldTable[] = table;
        table = new Node[2* oldTable.length + 1];
        numKeys = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] != null) {
// Insert entry in expanded table
                put(oldTable[i].getWord(), oldTable[i].getValue());
            }
        }

    }

    @Override
    /*You do not need to implement remove function
    * */
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {
        HashSet<entry> s = (HashSet<entry>) m.keySet();
        for (entry e : s){
            put(e.getKey(),e.getValue());
        }
    }

    @Override
    public void clear() {
        table = new Node[INITCAP];
        numKeys = 0;
        iter.setCurrent(null);
        iter.setHead(null);
    }

    @Override
    /*Use linked structure instead of table index
    for efficiency
     * */
    public Set keySet() {
        Set<String> words = new HashSet<String>();
        myIterator tempIter = new myIterator(iter.getHead());
        while (tempIter.hasNext()){
            words.add(tempIter.next().getWord());
        }
        return words;
    }
    public String veryHelperMethod(String fileName,int index){

        for (String s : (HashSet<String>)keySet()){
            if (get(s).keySet().contains(fileName)) {
                if (get(s).get(fileName).contains(index)) {
                    return s;
                }
            }
        }
        return null;

    }
    @Override
    /*Use linked structure instead of table index
    for efficiency
     * */
    public Collection values() {
        Set<File_Map> words = new HashSet<File_Map>();
        myIterator tempIter = new myIterator(iter.getHead());
        while (tempIter.hasNext()){
            words.add(tempIter.next().getValue());
        }
        return words;
    }

    @Override
    /*You do not need to implement entrySet function
     * */
    public Set<entry> entrySet() {
        Set<entry> words = new HashSet<entry>();
        myIterator tempIter = new myIterator(iter.getHead());
        while (tempIter.hasNext()){
            words.add(tempIter.next().getEnt());
        }
        return words;
    }
}
