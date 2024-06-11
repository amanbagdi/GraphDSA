package org.graph.algos;

import org.graph.algos.edge.util.Edge;

import java.util.ArrayList;
import java.util.Stack;

import static org.graph.algos.basicgraphcreation.util.CreateGraphUtils.createGraph;

public class AllPathsSrcToDest {

    public static void allPaths(ArrayList<Edge>[] graph, boolean[] vis, int curr, int dest, Stack<Integer> stack) {
        vis[curr] = true;
        stack.push(curr);
        if (curr == dest) {
            for (Integer n: stack) {
                    System.out.print(n + " ");
            }
            System.out.println();
            return;
        }

        for (Edge e: graph[curr]) {
            if (!vis[e.dest]) {
                allPaths(graph, vis, e.dest, dest, stack);
                vis[e.dest] = false;
                stack.pop();
            }
        }
    }

    public static void printAllPaths(ArrayList<Edge>[] graph, boolean[] vis, int curr, int dest, String path) {
        if (curr == dest) {
            System.out.println(path);
            return;
        }

        for (Edge e: graph[curr]) {
            if (!vis[e.dest]) {
                vis[curr] = true;
                printAllPaths(graph, vis, e.dest, dest, path + e.dest);
                vis[curr] = false;
            }
        }
    }


    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        allPaths(graph, vis, 0, 5, stack);

        printAllPaths(graph, vis, 0, 5, "0");
    }

}
