package org.graph.algos.minimumspanningtree;

import org.graph.algos.disjointsetunion.DSU;
import org.graph.algos.edge.util.WeightedEdge;
import org.graph.algos.minimumspanningtree.util.KruskalsGraphCreation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KruskalsAlgo {

    public static int findMinimumSpanningTree(List<WeightedEdge> edgeList, int V) {
        DSU dsu = new DSU(V);
        int minCost = 0;
        for (WeightedEdge we: edgeList) {
            int p1 = dsu.find(we.src);
            int p2 = dsu.find(we.dest);

            if (p1 != p2) {
                minCost += we.wt;
                dsu.unionByRank(we.src, we.dest);
            }
        }
        return minCost;
    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<WeightedEdge>[] graph = KruskalsGraphCreation.createGraph(V+1);
        List<WeightedEdge> edgeList = new ArrayList<>();

        for (int i=0; i<V;i++) {
            for (WeightedEdge we: graph[i]) {
                edgeList.add(we);
            }
        }

        edgeList.sort(Comparator.comparingInt(we -> we.wt));

        int minCost = findMinimumSpanningTree(edgeList, V);
        System.out.println("Minimum cost = " + minCost);
    }

}
