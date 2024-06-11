package org.graph.algos.basicgraphcreation.util;

import org.graph.algos.edge.util.WeightedEdge;

import java.util.ArrayList;

public class BasicGraphCreation {

    public static void createGraph(ArrayList<WeightedEdge>[] graph) {
        for (int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new WeightedEdge(0,2, 1));

        graph[1].add(new WeightedEdge(1,2,6));
        graph[1].add(new WeightedEdge(1, 3,3));

        graph[2].add(new WeightedEdge(2, 0, 1));
        graph[2].add(new WeightedEdge(2, 1,6));
        graph[2].add(new WeightedEdge(2, 3,2));

        graph[3].add(new WeightedEdge(3, 1, 3));
        graph[3].add(new WeightedEdge(3, 2,2));

    }


    public static void main(String[] args) {
        int V = 4;  // v -> no. of total vertices in the graph

        ArrayList<WeightedEdge>[] graph = new ArrayList[V];
        createGraph(graph);

        System.out.println("Neighbours of node - 1 with their weights are :");

        for (WeightedEdge e: graph[1]) {
            System.out.println(e.dest + " " + e.wt);
        }
    }
}