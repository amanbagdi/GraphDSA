package org.graph.algos;

import org.graph.algos.edge.util.Edge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static org.graph.algos.basicgraphcreation.util.CreateGraphUtils.createGraph;

public class BFS_DFS_Practice {

    public static void bfs(ArrayList<Edge>[] graph, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;

        while(!q.isEmpty()) {
            int curr = q.remove();
            System.out.println(curr);

            for (Edge e: graph[curr]) {
                if (!vis[e.dest]) {
                    q.add(e.dest);
                    vis[e.dest] = true;
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, boolean[] vis, int curr) {
        System.out.println(curr);
        vis[curr] = true;

        for (Edge e: graph[curr]) {
            if (!vis[e.dest]) {
                dfs(graph, vis, e.dest);
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        boolean[] vis = new boolean[V];

        System.out.println("BFS -----------------------");

        bfs(graph, vis);

        System.out.println("DFS -----------------------");
        vis = new boolean[V];

        dfs(graph, vis, 0);
    }

}
