package org.graph.algos.shortestpath.utility;

import org.graph.algos.edge.util.WeightedEdge;

import java.util.ArrayList;

public class BellmanFordGraphCreation {

    public static ArrayList<WeightedEdge>[] createGraph(int V) {
        ArrayList<WeightedEdge>[] graph = new ArrayList[V];

        for (int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new WeightedEdge(0,1, 2));
        graph[0].add(new WeightedEdge(0,2, 4));

        graph[1].add(new WeightedEdge(1,2,-4));

        graph[2].add(new WeightedEdge(2, 3,2));

        graph[3].add(new WeightedEdge(3, 4, 4));

        graph[4].add(new WeightedEdge(4, 1, -1));

        return graph;
    }

}
