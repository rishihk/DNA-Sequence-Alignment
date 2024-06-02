package edu.iastate.cs311.hw3prims;

public class Edge {
    Vertex src;
    Vertex dest;
    int weight;

    Edge(Vertex src, Vertex dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}
