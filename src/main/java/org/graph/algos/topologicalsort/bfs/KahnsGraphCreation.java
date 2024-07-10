package org.graph.algos.topologicalsort.bfs;

import org.graph.algos.edge.util.Edge;
import org.graph.algos.edge.util.WeightedEdge;

import java.util.ArrayList;

public class KahnsGraphCreation {

    public static ArrayList<Edge>[] createGraph(int V) {
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));

        return graph;
    }
}
