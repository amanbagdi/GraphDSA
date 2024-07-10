package org.graph.algos.topologicalsort.bfs;

import org.graph.algos.edge.util.Edge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnsAlgo {

    public static void topoSort(ArrayList<Edge>[] graph, int[] inDegree, Queue<Integer> queue) {
        while(!queue.isEmpty()) {
            int node = queue.remove();
            System.out.print(node + " ");

            for (Edge e: graph[node]) {
                inDegree[e.dest]--;
                if (inDegree[e.dest] == 0) queue.add(e.dest);
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = KahnsGraphCreation.createGraph(V);
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[V];

        for (int i=0; i<V; i++) {
            for (Edge e: graph[i]) {
                inDegree[e.dest]++;
            }
        }
        for (int i=0; i<V; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }
        topoSort(graph, inDegree, queue);
    }

}
