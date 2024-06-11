package org.graph.algos;

import java.util.ArrayList;

public class CycleDetectionDirectedGraph {

    public static boolean cycleDetectionInDirectedGraph(ArrayList<Edge>[] graph, boolean[] vis, int curr, boolean[] recursiveVertex) {
        vis[curr] = true;
        recursiveVertex[curr] = true;

        for (Edge e: graph[curr]) {
            if (recursiveVertex[e.dest]) {
                return true;
            }
            else if (!vis[e.dest]) {
                if (cycleDetectionInDirectedGraph(graph, vis, e.dest, recursiveVertex)) {
                    return true;
                }
            }
        }
        recursiveVertex[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        CreateGraphUtils.createCycleDetectionDirectedGraph(graph);

        boolean[] vis = new boolean[V];
        boolean[] recursiveVertex = new boolean[V];

        if (cycleDetectionInDirectedGraph(graph, vis, 0, recursiveVertex)) {
            System.out.println("Cycle Detected");
        } else {
            System.out.println("Cycle Not Detected");
        }
    }

}
