package org.graph.algos;

import org.graph.algos.basicgraphcreation.util.CreateGraphUtils;
import org.graph.algos.edge.util.Edge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_DFS_Disconnected_Graph {

    public static void bfs(ArrayList<Edge>[] graph, boolean[] vis, int src) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis[src] = true;

        while(!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            for (Edge e: graph[curr]) {
                if (!vis[e.dest]) {
                    q.add(e.dest);
                    vis[e.dest] = true;
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, boolean[] vis, int curr) {
        System.out.print(curr + " ");
        vis[curr] = true;

        for (Edge e: graph[curr]) {
            if (!vis[e.dest]) {
                dfs(graph, vis, e.dest);
            }
        }
    }
    
    
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        CreateGraphUtils.createDisconnectedGraph(graph);
        boolean[] vis = new boolean[V];

        System.out.println("BFS --------------------");
        for (int i=0; i< vis.length; i++) {
            if (!vis[i]) {
                bfs(graph, vis, i);
                System.out.print("**Disconnection** ");
            }
        }

        System.out.println();

        vis = new boolean[V];

        System.out.println("DFS --------------------");
        for (int i=0; i<vis.length; i++) {
            if (!vis[i]) {
                dfs(graph, vis, i);
                System.out.print("**Disconnection** ");
            }
        }

    }

}
