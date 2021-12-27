package com.company;

import java.util.*;

public class File_Map implements Map
{
    /*
    For this hashmap, you will use arraylists which will provide easy but costly implementation.
    Your should provide and explain the complexities for each method in your report.
    * */
   ArrayList<String> fnames;
   ArrayList<List<Integer>> occurances;
    public File_Map(){
        fnames = new ArrayList<String>(2);
        occurances = new ArrayList<List<Integer>>(2);
    }
    @Override
    public int size() {
        return fnames.size();
    } // o1

    @Override
    public boolean isEmpty() {
        return fnames.isEmpty();
    } //o1

    @Override
    public boolean containsKey(Object key) {
        return (fnames.contains(key));
    } // oN

    @Override
    public boolean containsValue(Object value) {

        return (occurances.contains(value)); // oN
    }

    @Override
    public List<Integer> get(Object key) { //oN
        if (!fnames.contains(key)){
            return null;
        }
        else {
            return (occurances.get(fnames.indexOf(key)));
        }
    }

    @Override
    /*Each put operation will extend the occurance list*/
    public Object put(Object key, Object value) { // 
            List<Integer> oldValue = null;
            if (fnames.contains(key)){
                occurances.get(fnames.indexOf(key)).add((int)value);
            }
            else {
                fnames.add((String) key);
                occurances.add(new ArrayList<Integer>(2));
                occurances.get(fnames.indexOf(key)).add((int)value);
                return null;
            }
            return null;
    }

    @Override
    public Object remove(Object key) {
        List<Integer> oldValue = null;
        if (fnames.contains(key)){
            oldValue = occurances.get(fnames.indexOf(key));
            occurances.remove(fnames.indexOf(key));
            fnames.remove(fnames.indexOf(key));
        }
        return oldValue;
    }

    @Override
    public void putAll(Map m) {
        HashSet<entry2> s = (HashSet<entry2>) m.keySet();
        for (entry2 e2 : s){
                fnames.add(e2.getKey());
                occurances.add(e2.getValue());

        }

    }

    @Override
    public void clear() {
        fnames.clear();
        occurances.clear();
    }

    @Override
    public Set keySet() {
        Set<String> names = new HashSet<String>();
        for (String x : fnames) {
            names.add(x);
        }
        return names;
    }

    @Override
    public Collection values() {
        Collection<List<Integer>> result = new ArrayList<List<Integer>>();
        for (List<Integer> a : occurances){
            result.add(a);
        }
        return result;
    }

    @Override
    public Set<entry2> entrySet() {
        Set<entry2> result = new HashSet<entry2>();
        for (int i = 0; i < size(); i++){
            result.add(new entry2(fnames.get(i),occurances.get(i)));
        }
        return result;
    }
}
