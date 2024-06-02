package edu.iastate.cs311.hw3prims;

public class Vertex {
    String id;
    int key;
    Vertex pi;
    boolean heap;
    int ind;

    Vertex(String id) {
        this.id = id;
        this.key = Integer.MAX_VALUE;
        this.pi = null;
        this.heap = true;
        this.ind = 0;
    }
}