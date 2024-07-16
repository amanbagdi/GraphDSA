package org.graph.algos.shortestpath.multisource;

import org.graph.algos.edge.util.WeightedEdge;
import org.graph.algos.shortestpath.utility.FloydWarshallGraphCreation;

import java.util.ArrayList;
import java.util.Arrays;

public class FloydWarshallAlgo {

    public static void findShortestPath(int[][] adjacencyMatrix) {
        int n = adjacencyMatrix.length;
        for (int via=0; via<n; via++) {

            int[][] copyArray = Arrays.copyOf(adjacencyMatrix, n);

            for (int i=0; i< n; i++) {
                for (int j=0; j<n; j++) {
                    if (copyArray[i][via] == Integer.MAX_VALUE || copyArray[via][j] == Integer.MAX_VALUE)
                        continue;
                    adjacencyMatrix[i][j] = Math.min(adjacencyMatrix[i][j], copyArray[i][via] + copyArray[via][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<WeightedEdge>[] graph = FloydWarshallGraphCreation.createGraph();
        int size = graph.length;
        int[][] adjacencyMatrix = new int[size][size];
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                if (i != j) {
                    adjacencyMatrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i=0; i<size; i++) {
            for (WeightedEdge we: graph[i]) {
                adjacencyMatrix[i][we.dest] = we.wt;
            }
        }

        /*for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }*/

        findShortestPath(adjacencyMatrix);

        /*System.out.println("0 -> 1 : " + adjacencyMatrix[0][1]);
        System.out.println("0 -> 2 : " + adjacencyMatrix[0][2]);
        System.out.println("0 -> 3 : " + adjacencyMatrix[0][3]);
        System.out.println("0 -> 4 : " + adjacencyMatrix[0][4]);
        System.out.println("0 -> 5 : " + adjacencyMatrix[0][5]);*/
    }

}
