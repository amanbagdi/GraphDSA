package org.graph.algos;

import java.util.ArrayList;

public class CycleDetectionUndirectedGraph {

    public static void cycleDetection(ArrayList<Edge>[] graph, boolean[] vis, int curr, int parent) {
        vis[curr] = true;

        for (Edge e: graph[curr]) {
            if (!vis[e.dest]) {
                cycleDetection(graph, vis, e.dest, curr);
            } else if (e.dest != parent && parent != -1) {
                System.out.println(curr + " " + e.dest + " " + parent);
                System.out.println("Cycle Detected");
                break;
            }
        }
    }

    public static boolean cycleDetectionWithReturnValue(ArrayList<Edge>[] graph, boolean[] vis, int curr, int parent) {
        vis[curr] = true;

        for (Edge e: graph[curr]) {
            if (!vis[e.dest]) {
                if (cycleDetectionWithReturnValue(graph, vis, e.dest, curr)) {
                    return true;
                }
            } else if (e.dest != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        CreateGraphUtils.createCycleDetectionUndirectedGraph(graph);

        boolean[] vis = new boolean[V];

        cycleDetection(graph, vis, 0, -1);

        vis = new boolean[V];

        if (cycleDetectionWithReturnValue(graph, vis, 0, -1)) {
            System.out.println("Cycle Detected");
        } else {
            System.out.println("No Cycle Detected");
        }


    }

}
