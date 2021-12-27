package com.company;

import java.util.Map;

public class entry implements Map.Entry<String,File_Map> {
    private String key;//WORD
    private File_Map value; // MAP

    public entry(String key,File_Map value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public File_Map getValue() {
        return value;
    }

    @Override
    public File_Map setValue(File_Map value) {
        this.value = value;
        return value;
    }
}
