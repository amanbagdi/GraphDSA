package org.graph.algos.topologicalsort.dfs;

import org.graph.algos.basicgraphcreation.util.CreateGraphUtils;
import org.graph.algos.edge.util.Edge;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortingDAGs{

    public static void topologicalSorting(ArrayList<Edge>[] graph, boolean[] vis, int curr, Stack<Integer> stack) {
        vis[curr] = true;

        for (Edge e: graph[curr]) {
            if (!vis[e.dest]) {
                topologicalSorting(graph, vis, e.dest, stack);
            }
        }
        stack.push(curr);
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        CreateGraphUtils.createDAGGraph(graph);

        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i< vis.length; i++) {
            if (!vis[i]) {
                topologicalSorting(graph, vis, i, stack);
            }
        }
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }

    }

}
