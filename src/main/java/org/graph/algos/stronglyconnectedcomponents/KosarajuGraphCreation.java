package org.graph.algos.stronglyconnectedcomponents;

import org.graph.algos.edge.util.Edge;

import java.util.ArrayList;

public class KosarajuGraphCreation {

    public static ArrayList<Edge>[] createGraph(int V) {
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));

        return graph;
    }
    
}
