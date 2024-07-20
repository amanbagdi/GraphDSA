package org.graph.algos.disjointsetunion;

import java.util.Arrays;

public class DSUBySize {

    public static void main(String[] args) {
        DSU dsu = new DSU(7);

        dsu.unionBySize(1, 2);
        dsu.unionBySize(2, 3);
        dsu.unionBySize(4, 5);
        dsu.unionBySize(6, 7);
        dsu.unionBySize(5, 6);

        //if 3 and 7 same or not
        if (dsu.find(3) == dsu.find(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Different");
        }

        dsu.unionBySize(3, 7);

        if (dsu.find(3) == dsu.find(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Different");
        }

        int[][] edges = {{3,1,2}, {1,1,4}, {3,2,3}, {2,1,4}};
        Arrays.sort(edges, (o1, o2) -> o2[0] - o1[0]);

        for (int[] arr: edges) {
            for (int i: arr) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
    
}
