package org.graph.algos.disjointsetunion;

public class DSUByRank {

    public static void main(String[] args) {
        DSU dsu = new DSU(7);

        dsu.unionByRank(1, 2);
        dsu.unionByRank(2, 3);
        dsu.unionByRank(4, 5);
        dsu.unionByRank(6, 7);
        dsu.unionByRank(5, 6);

        //if 3 and 7 same or not
        if (dsu.find(3) == dsu.find(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Different");
        }

        dsu.unionByRank(3, 7);

        if (dsu.find(3) == dsu.find(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Different");
        }

    }

}
