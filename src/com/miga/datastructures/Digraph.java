package com.miga.datastructures;

import java.util.HashMap;
import java.util.TreeSet;

public class Digraph<V> {

    private HashMap<V, TreeSet<V>> adjList;

    Digraph() {
        adjList = new HashMap<V, TreeSet<V>>();
    }

    public void addVertex(V vertex) {
        if (adjList.containsKey(vertex))
            return;
        adjList.put(vertex, new TreeSet<V>());
    }

    public void addVertex(V from, V to) {
        addVertex(from);
        addVertex(to);
        adjList.get(from).add(to);
    }

    public void printBreadthFirst() {
        for (V v: adjList.keySet()) {
            System.out.println(v + " -> " + adjList.get(v));
        }
    }

    public static void main (String[] args) {
        Digraph<Integer> digraph = new Digraph<Integer>();
        digraph.addVertex(2, 3);
        digraph.addVertex(4, 1);
        digraph.addVertex(1, 2);
        digraph.addVertex(1, 3);
        digraph.printBreadthFirst();
    }
}