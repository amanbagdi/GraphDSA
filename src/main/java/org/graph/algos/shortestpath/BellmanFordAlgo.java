package org.graph.algos.shortestpath;

import org.graph.algos.edge.util.WeightedEdge;
import org.graph.algos.shortestpath.utility.BellmanFordGraphCreation;

import java.util.ArrayList;

public class BellmanFordAlgo {

    public static void main(String[] args) {
        int V = 5;
        ArrayList<WeightedEdge>[] graph = BellmanFordGraphCreation.createGraph(V);
        ArrayList<WeightedEdge> edgeList = new ArrayList<>();
        int[] dist = new int[V];
        for (int i=0; i<V; i++) {
            if (i != 0) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        for (int i=0; i<V; i++) {
            for (WeightedEdge e: graph[i]) {
                edgeList.add(e);
            }
        }

        bellmanFord(edgeList, V, dist);
        for (int i=0; i<V; i++) {
            System.out.println(i + " -> " + dist[i]);
        }
    }

    private static void bellmanFord(ArrayList<WeightedEdge> edgeList, int V, int[] dist) {

        for (int i=0; i<V-1; i++) {
            for (WeightedEdge e: edgeList) {
                if ((dist[e.src] + e.wt) < dist[e.dest]) {
                    dist[e.dest] = dist[e.src] + e.wt;
                }
            }
        }

    }
}
