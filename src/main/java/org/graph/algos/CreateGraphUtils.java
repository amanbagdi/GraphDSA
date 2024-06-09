package org.example;

import java.util.ArrayList;

public class CreateGraphUtils {

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i=0; i< graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5,  3));
        graph[5].add(new Edge(5,  4));
        graph[5].add(new Edge(5,  6));

        graph[6].add(new Edge(6,  5));
    }

    public static void createDisconnectedGraph(ArrayList<Edge>[] graph) {
        for (int i=0; i< graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 1));

        graph[2].add(new Edge(2, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5,  4));
    }

    public static void createCycleDetectionUndirectedGraph(ArrayList<Edge>[] graph) {
        for (int i=0; i< graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,4));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,4));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 2));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5,  4));
    }

    public static void createCycleDetectionDirectedGraph(ArrayList<Edge>[] graph) {
        for (int i=0; i< graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));
    }

    //DAG - Directed Acyclic Graph
    public static void createDAGGraph(ArrayList<Edge>[] graph) {
        for (int i=0; i< graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5,  0));
        graph[5].add(new Edge(5,  2));
    }

}
