package org.graph.algos.minimumspanningtree;

import org.graph.algos.WeightedEdge;
import org.graph.algos.minimumspanningtree.util.PrimsGraphCreation;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {

    static class Pair implements Comparable<Pair> {
        int node;
        int cost;

        public Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo (Pair pair2) {
            return this.cost - pair2.cost;
        }
    }

    public static int minimumSpanningTree(ArrayList<WeightedEdge>[] graph, boolean[] vis, int src) {
        int cost=0;
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(src, 0));

        while(!queue.isEmpty()) {
            Pair curr = queue.remove();
            if (!vis[curr.node]) {
                vis[curr.node] = true;
                cost += curr.cost;

                for (WeightedEdge e : graph[curr.node]) {
                    if (!vis[e.dest]) {
                        queue.add(new Pair(e.dest, e.wt));
                    }
                }
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<WeightedEdge>[] graph = PrimsGraphCreation.createGraph(V);
        boolean[] vis = new boolean[V];
        int src = 0;
        int minCost = minimumSpanningTree(graph, vis, src);
        System.out.println("Minimum cost: " + minCost);
    }
}
