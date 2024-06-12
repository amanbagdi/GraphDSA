package org.graph.algos.stronglyconnectedcomponents;

import org.graph.algos.edge.util.Edge;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajuAlgo {

    public static void topologicalSort(ArrayList<Edge>[] graph, boolean[] vis, Stack<Integer> stack, int curr) {
        vis[curr] = true;
        for (Edge e: graph[curr]) {
            if (!vis[e.dest]) {
                topologicalSort(graph, vis, stack, e.dest);
            }
        }
        stack.push(curr);
    }

    public static void transposeGraph(ArrayList<Edge>[] graph, ArrayList<Edge>[] transposedGraph) {
        for (ArrayList<Edge> edges : graph) {
            for (Edge e : edges) {
                transposedGraph[e.dest].add(new Edge(e.dest, e.src));
            }
        }
        /*for (int i=0; i<transposedGraph.length; i++) {
            System.out.println("Node : " + i);
            for(Edge e: transposedGraph[i]) {
                System.out.println(e.src + " -> " + e.dest);
            }
        }*/

    }

    public static void dfs(ArrayList<Edge>[] transposedGraph, boolean[] vis, int curr) {
        vis[curr] = true;
        System.out.print(curr);
        for (Edge e: transposedGraph[curr]) {
            if (!vis[e.dest]) {
                dfs(transposedGraph, vis, e.dest);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = KosarajuGraphCreation.createGraph(V);
        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        int curr = 0;

        topologicalSort(graph, vis, stack, curr);

        ArrayList<Edge>[] transposedGraph = new ArrayList[V];
        for (int i=0; i<V; i++) {
            transposedGraph[i] = new ArrayList<>();
        }
        transposeGraph(graph, transposedGraph);

        vis = new boolean[V];
        while(!stack.empty()) {
            int element = stack.pop();
            if (!vis[element]) {
                dfs(transposedGraph, vis, element);
                System.out.println();
            }
        }
    }

    //1. Topological Sort - store elements in stack
    //2. Transpose graph - reverse direction of all edges
    //3. Perform DFS on nodes popping out from Stack

}
