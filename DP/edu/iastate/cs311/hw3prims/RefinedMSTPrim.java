package edu.iastate.cs311.hw3prims;
import java.util.*;
import java.util.stream.Collectors;



	public class RefinedMSTPrim {
	    private static Map<Vertex, List<Edge>> adjacencyList = new HashMap<>();

	    public static void main(String[] args) {
	        // Create the example graph
	        Vertex A = new Vertex("A");
	        Vertex B = new Vertex("B");
	        Vertex C = new Vertex("C");
	        Vertex D = new Vertex("D");
	        Vertex E = new Vertex("E");
	        Vertex F = new Vertex("F");
	        Vertex G = new Vertex("G");
	        List<Vertex> vertices = Arrays.asList(A, B, C, D, E, F, G);
	        List<Edge> edges = Arrays.asList(
	                new Edge(A, E, 2),
	                new Edge(A, D, 9),
	                new Edge(E, D, 8),
	                new Edge(E, F, 9),
	                new Edge(F, D, 4),
	                new Edge(A, B, 1),
	                new Edge(B, D, 3),
	                new Edge(B, C, 9),
	                new Edge(C, D, 5),
	                new Edge(C, G, 6),
	                new Edge(G, D, 9),
	                new Edge(G, F, 7)
	        );

	        for (Vertex vertex : vertices) {
	            adjacencyList.put(vertex, new ArrayList<>());
	        }

	        for (Edge edge : edges) {
	            adjacencyList.get(edge.src).add(edge);
	            // Add the reverse edge for undirected graphs
	            adjacencyList.get(edge.dest).add(new Edge(edge.dest, edge.src, edge.weight));
	        }

	        // Run the Refined-MST-PRIM algorithm
	        refinedMSTPrim(vertices, A);

	        // Print the MST
	        System.out.println("Minimum Spanning Tree:");
	        for (Vertex vertex : vertices) {
	            if (vertex.pi != null) {
	                System.out.println(vertex.pi.id + " - " + vertex.id);
	            }
	        }
	    }

	    
	    
	    
	    public static void refinedMSTPrim(List<Vertex> vertices, Vertex r) {
	        r.key = 0;

	        List<Vertex> H = new ArrayList<>(vertices);
	        for (int i = 0; i < H.size(); i++) {
	            H.get(i).ind = i;
	        }

	        buildMinHeap(H);

	        int iteration = 0;

	        // Print the initial status at iteration 0
	        System.out.println("Iteration " + iteration + ":");
	        for (Vertex v : vertices) {
	            String pi = v.pi == null ? "null" : v.pi.id;
	            System.out.println("Vertex: " + v.id + ", Key: " + v.key + ", Predecessor: " + pi + ", Index: " + v.ind + ", Heap: " + v.heap);
	        }
	        System.out.println("Heap H: " + H.stream().map(v -> v.id).collect(Collectors.joining(", ")));
	        System.out.println();

	        while (!H.isEmpty()) {
	            Vertex u = extractMin(H);
	            u.heap = false;

	            iteration++;
	            System.out.println("Iteration " + iteration + ":");
	            for (Vertex v : vertices) {
	                String pi = v.pi == null ? "null" : v.pi.id;
	                System.out.println("Vertex: " + v.id + ", Key: " + v.key + ", Predecessor: " + pi + ", Index: " + v.ind + ", Heap: " + v.heap);
	            }
	            System.out.println("Heap H: " + H.stream().map(v -> v.id).collect(Collectors.joining(", ")));
	            System.out.println();

	            // Sort the vertices in alphabetical order
	            List<Edge> sortedEdges = adjacencyList.get(u).stream()
	                    .sorted(Comparator.comparing(e -> e.dest.id))
	                    .collect(Collectors.toList());

	            for (Edge edge : sortedEdges) {
	                Vertex v = edge.dest;
	                if (v.heap && edge.weight < v.key) {
	                    v.pi = u;
	                    v.key = edge.weight;
	                    decreaseKey(H, v);
	                }
	            }
	        }
	    }


	    private static void minHeapify(List<Vertex> H, int i) {
	        int left = 2 * i + 1;
	        int right = 2 * i + 2;
	        int smallest = i;

	        if (left < H.size() && (H.get(left).key < H.get(smallest).key ||
	                (H.get(left).key == H.get(smallest).key && H.get(left).id.compareTo(H.get(smallest).id) < 0))) {
	            smallest = left;
	        }
	        if (right < H.size() && (H.get(right).key < H.get(smallest).key ||
	                (H.get(right).key == H.get(smallest).key && H.get(right).id.compareTo(H.get(smallest).id) < 0))) {
	            smallest = right;
	        }
	        if (smallest != i) {
	            Vertex temp = H.get(i);
	            H.set(i, H.get(smallest));
	            H.set(smallest, temp);

	            H.get(i).ind = i;
	            H.get(smallest).ind = smallest;

	            minHeapify(H, smallest);
	        }
	    }


	    public static void decreaseKey(List<Vertex> H, Vertex v) {
	        int index = v.ind;
	        while (index > 0 && vertexComparator.compare(v, H.get(parent(index))) < 0) {
	            H.set(index, H.get(parent(index)));
	            H.get(index).ind = index;
	            index = parent(index);
	        }
	        H.set(index, v);
	        v.ind = index;
	    }

	    private static final Comparator<Vertex> vertexComparator = (v1, v2) -> {
	        int keyComparison = Integer.compare(v1.key, v2.key);
	        if (keyComparison != 0) {
	            return keyComparison;
	        }
	        return v1.id.compareTo(v2.id);
	    };



//	    public static void refinedMSTPrim(List<Vertex> vertices, Vertex r) {
//	        r.key = 0;
//
//	        List<Vertex> H = new ArrayList<>(vertices);
//	        for (int i = 0; i < H.size(); i++) {
//	            H.get(i).ind = i;
//	        }
//
//	        buildMinHeap(H);
//	        int iteration = 1;
//	        while (!H.isEmpty()) {
//	            Vertex u = extractMin(H);
//	            u.heap = false;
//
//	            System.out.println("Iteration " + iteration + ":");
//	            for (Vertex v : vertices) {
//	                String pi = v.pi == null ? "null" : v.pi.id;
//	                System.out.println("Vertex: " + v.id + ", Key: " + v.key + ", Predecessor: " + pi + ", Index: " + v.ind + ", Heap: " + v.heap);
//	            }
//	            System.out.println("Heap H: " + H.stream().map(v -> v.id).collect(Collectors.joining(", ")));
//	            System.out.println();
//
//	            for (Edge edge : adjacencyList.get(u)) {
//	                Vertex v = edge.dest;
//	                if (v.heap && edge.weight < v.key) {
//	                    v.pi = u;
//	                    v.key = edge.weight;
//	                    decreaseKey(H, v);
//	                }
//	            }
//	            iteration++;
//	        }
//	    }



	    private static void buildMinHeap(List<Vertex> H) {
	        for (int i = H.size() / 2 - 1; i >= 0; i--) {
	            minHeapify(H, i);
	        }
	    }

//	    private static void minHeapify(List<Vertex> H, int i) {
//	        int left = 2 * i + 1;
//	        int right = 2 * i + 2;
//	        int smallest = i;
//
//	        if (left < H.size() && H.get(left).key < H.get(smallest).key) {
//	            smallest = left;
//	        }
//
//	        if (right < H.size() && H.get(right).key < H.get(smallest).key) {
//	            smallest = right;
//	        }
//
//	        if (smallest != i) {
//	            Collections.swap(H, i, smallest);
//	            H.get(i).ind = i;
//	            H.get(smallest).ind = smallest;
//	            minHeapify(H, smallest);
//	        }
//	    }

	    public static Vertex extractMin(List<Vertex> H) {
	        if (H.isEmpty()) {
	            throw new NoSuchElementException("Heap underflow");
	        }
	        Vertex min = H.get(0);
	        H.set(0, H.get(H.size() - 1));
	        H.get(0).ind = 0;
	        H.remove(H.size() - 1);
	        minHeapify(H, 0);
	        return min;
	    }


//	    private static void decreaseKey(List<Vertex> H, Vertex v) {
//	        int index = v.ind;
//	        while (index > 0 && H.get(parent(index)).key > v.key) {
//	            Vertex parentVertex = H.get(parent(index));
//	            H.set(index, parentVertex);
//	            H.set(parent(index), v);
//	            parentVertex.ind = index;
//	            v.ind = parent(index);
//	            index = parent(index);
//	        }
//	    }


	    private static int parent(int i) {
	        return (i - 1) / 2;
	    }
	}

	

