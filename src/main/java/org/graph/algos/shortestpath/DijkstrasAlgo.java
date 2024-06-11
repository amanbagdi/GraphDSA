package org.graph.algos.shortestpath;

import org.graph.algos.edge.util.WeightedEdge;
import org.graph.algos.shortestpath.utility.DijkstrasGraphCreation;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstrasAlgo {

    public static void shortestPath(ArrayList<WeightedEdge>[] graph, boolean[] vis, int[] dist) {
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(0,0));

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            int curr = pair.node;
                vis[curr] = true;
                for (WeightedEdge e: graph[curr]) {
                    if (!vis[e.dest] && (dist[curr] + e.wt) < dist[e.dest]) {
                        dist[e.dest] = dist[curr] + e.wt;
                        queue.add(new Pair(e.dest, dist[e.dest]));
                    }
                }
        }
    }

    static class Pair implements Comparable<Pair> {
        int node;
        int distance;

        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Pair pair2) {
            return this.distance - pair2.distance;
        }
    }

    public static void main(String[] args) {
        ArrayList<WeightedEdge>[] graph = DijkstrasGraphCreation.createGraph();
        boolean[] vis = new boolean[6];
        int[] dist = new int[6];
        dist[0] = 0;
        for (int i = 1; i < 6; i++)
            dist[i] = Integer.MAX_VALUE;
        shortestPath(graph, vis, dist);

        for (int i=0; i<6; i++) {
            System.out.println(i + " -> " + dist[i]);
        }
    }

}
