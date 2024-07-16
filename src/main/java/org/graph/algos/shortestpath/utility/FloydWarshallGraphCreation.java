package org.graph.algos.shortestpath.utility;

import org.graph.algos.edge.util.WeightedEdge;

import java.util.ArrayList;

public class FloydWarshallGraphCreation {

    public static ArrayList<WeightedEdge>[] createGraph() {
        ArrayList<WeightedEdge>[] graph = new ArrayList[6];

        for (int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new WeightedEdge(0,1, 2));
        graph[0].add(new WeightedEdge(0,2, 4));

        graph[1].add(new WeightedEdge(1,2,1));
        graph[1].add(new WeightedEdge(1, 3,7));

        graph[2].add(new WeightedEdge(2, 4,3));

        graph[3].add(new WeightedEdge(3, 5, 1));

        graph[4].add(new WeightedEdge(4, 3, 2));
        graph[4].add(new WeightedEdge(4, 5, 5));

        return graph;
    }

}
