package org.graph.algos.articulationpoint;

import org.graph.algos.edge.util.Edge;

import java.util.ArrayList;

public class APTarjansAlgo {

    public static void findArticulationPoint(ArrayList<Edge>[] graph, boolean[] vis, int[] dt, int[] low, int curr, int parent, int time) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int disConChild = 0;

        for (Edge e: graph[curr]) {
            if (e.dest == parent) continue;
            else if (vis[e.dest]) low[curr] = Math.min(low[curr], dt[e.dest]);
            else {
                findArticulationPoint(graph, vis, dt, low, e.dest, curr, time);
                low[curr] = Math.min(low[curr], low[e.dest]);
                if (parent != -1 && dt[curr] <= low[e.dest]) {
                    System.out.println("Articulation Point: " + curr);
                }
                disConChild++;
            }
        }
        if (parent == -1 && disConChild > 1) {
            System.out.println("Articulation Point: " + curr);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = ArticulationPointGraphCreation.createGraph(V);
        boolean[] vis = new boolean[V];
        int[] dt = new int[V];
        int[] low = new int[V];
        int curr = 0;

        findArticulationPoint(graph, vis, dt, low, curr, -1, 0);
    }

}
