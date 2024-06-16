package org.graph.algos.bridgeingraph;

import org.graph.algos.edge.util.Edge;

import java.util.ArrayList;

public class TarjansAlgo {

    public static void bridgeInGraph(ArrayList<Edge>[] graph, int[] dt, int[] low, int time, int parent, int curr, boolean[] vis) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        for (Edge e: graph[curr]) {
            if (e.dest == parent) {
                continue;
            } else if (vis[e.dest]) {
                low[curr] = Math.min(low[curr], dt[e.dest]);
            } else {
                bridgeInGraph(graph,  dt, low, time, curr, e.dest, vis);
                low[curr] = Math.min(low[curr], low[e.dest]);
                if (dt[curr] < low[e.dest]) {
                    System.out.println("Bridge is: " + curr + " -> " + e.dest);
                }
            }
        }

    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = TarjansGraphCreation.createGraph(V);

        int[] dt = new int[V];
        int[] low = new int[V];

        int time=0;
        boolean[] vis = new boolean[V];
        int parent = -1;
        bridgeInGraph(graph, dt, low, time, parent, 0, vis);
    }

}
