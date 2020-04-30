package com.ndev.serachservice.model;

import java.util.HashMap;
import java.util.Map;

public class PrefixTree {

    private String prefix;
    private boolean completed;
    private Map<Character,PrefixTree> childNodes = new HashMap<>();

    public PrefixTree(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Map<Character, PrefixTree> getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(Map<Character, PrefixTree> childNodes) {
        this.childNodes = childNodes;
    }
}


