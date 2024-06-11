package org.graph.algos.minimumspanningtree.util;

import org.graph.algos.WeightedEdge;

import java.util.ArrayList;

public class PrimsGraphCreation {

    public static ArrayList<WeightedEdge>[] createGraph(int V) {
        ArrayList<WeightedEdge>[] graph = new ArrayList[V];

        for (int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new WeightedEdge(0,1, 10));
        graph[0].add(new WeightedEdge(0,2, 15));
        graph[0].add(new WeightedEdge(0,3, 30));

        graph[1].add(new WeightedEdge(1,0,10));
        graph[1].add(new WeightedEdge(1,3,40));

        graph[2].add(new WeightedEdge(2, 0,15));
        graph[2].add(new WeightedEdge(2, 3,50));

        graph[3].add(new WeightedEdge(3, 0, 30));
        graph[3].add(new WeightedEdge(3, 1, 40));
        graph[3].add(new WeightedEdge(3, 2, 50));

        return graph;
    }

}
