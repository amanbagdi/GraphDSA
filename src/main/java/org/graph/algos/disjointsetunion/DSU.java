package org.graph.algos.disjointsetunion;

import java.util.Arrays;

public class DSU {

    // 7 elements - numbered from 1 to 7
    int[] parent;
    int[] rank;
    int[] size;

    public DSU(int n) {
        parent = new int[n+1];
        rank = new int[n+1];
        size = new int[n+1];
        for (int i=1;i<=n;i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int element) {
        if (parent[element] == element)
            return element;

        return parent[element] = find(parent[element]);
    }

    public void unionByRank(int e1, int e2) {
        int p1 = find(e1);
        int p2 = find(e2);
        if (p1 == p2)
            return;
        if (rank[p1] == rank[p2]) {
            parent[p2] = p1;
            rank[p1]++;
        } else if (rank[p1] > rank[p2]) {
            parent[e2] = p1;
        } else {
            parent[e1] = p2;
        }
    }

    public void unionBySize(int e1, int e2) {
        int p1 = find(e1);
        int p2 = find(e2);

        if (size[p1] > size[p2]) {
            parent[e2] = p1;
            size[p1] = size[p1] + size[p2];
        } else {
            parent[e1] = p2;
            size[p2] = size[p2] + size[p1];
        }
    }
}
