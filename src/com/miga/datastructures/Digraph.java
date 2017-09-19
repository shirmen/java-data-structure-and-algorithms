package com.miga.datastructures;

import java.util.HashMap;
import java.util.TreeSet;

public class Digraph<T> {

    private HashMap<T, TreeSet<T>> adjList;

    Digraph() {
        adjList = new HashMap<T, TreeSet<T>>();
    }

    public void addVertex(T vertex) {
        if (adjList.containsKey(vertex))
            return;
        adjList.put(vertex, new TreeSet<T>());
    }

    public void addVertex(T from, T to) {
        addVertex(from);
        addVertex(to);
        adjList.get(from).add(to);
    }

    public void printBreadthFirst() {
        for (T t: adjList.keySet()) {
            System.out.println(t + " -> " + adjList.get(t));
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