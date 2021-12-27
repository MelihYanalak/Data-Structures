package com.company;

import java.util.List;
import java.util.Map;

public class entry2 implements Map.Entry<String,List<Integer>> {
    private String key;
    private List<Integer> value;

    entry2(String key, List<Integer> value){
        this.value = value;
        this.key = key;
    }
    @Override
    public String getKey() {
        return key;
    }

    @Override
    public List<Integer> getValue() {
        return value;
    }

    @Override
    public List<Integer> setValue(List<Integer> value) {
        this.value =  value;
        return value;
    }
}
