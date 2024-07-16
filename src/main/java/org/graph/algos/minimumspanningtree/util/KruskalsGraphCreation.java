package org.graph.algos.minimumspanningtree.util;

import org.graph.algos.edge.util.WeightedEdge;

import java.util.ArrayList;

public class KruskalsGraphCreation {

    public static ArrayList<WeightedEdge>[] createGraph(int V) {
        ArrayList<WeightedEdge>[] graph = new ArrayList[V];

        for (int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[1].add(new WeightedEdge(1,2, 10));
        graph[1].add(new WeightedEdge(1,3, 15));
        graph[1].add(new WeightedEdge(1,4, 30));

        graph[2].add(new WeightedEdge(2,1,10));
        graph[2].add(new WeightedEdge(2,4,40));

        graph[3].add(new WeightedEdge(3, 1,15));
        graph[3].add(new WeightedEdge(3, 4,50));

        graph[4].add(new WeightedEdge(4, 1, 30));
        graph[4].add(new WeightedEdge(4, 2, 40));
        graph[4].add(new WeightedEdge(4, 3, 50));

        return graph;
    }

}
