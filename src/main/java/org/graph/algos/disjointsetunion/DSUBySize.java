package org.graph.algos.disjointsetunion;

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

    }
    
}
