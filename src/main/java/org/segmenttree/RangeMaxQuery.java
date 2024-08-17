package org.segmenttree;

public class RangeMaxQuery {


    public static int query(int start, int end, int i, int l, int r, int[] segmentTree) {
        if (l > end || r < start) return 0;
        else if (l >= start && r <= end) return segmentTree[i];
        else {
            int mid = l + (r-l)/2;
            int q1 = query(start, end, 2*i+1, l, mid, segmentTree);
            int q2 = query(start, end, 2*i+2, mid+1, r, segmentTree);
            return q1 > q2 ? q1 : q2;
        }
    }

    public static void buildTree(int i, int l, int r, int[] arr, int[] segmentTree) {
        if (l == r) {
            segmentTree[i] = arr[l];
            return;
        }
        int mid = l + (r-l)/2;

        buildTree(2*i+1, l, mid, arr, segmentTree);
        buildTree(2*i+2, mid+1, r, arr, segmentTree);

        segmentTree[i] = segmentTree[2*i+1] > segmentTree[2*i+2] ? segmentTree[2*i+1] : segmentTree[2*i+2];
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 8};
        int[] segmentTree = new int[arr.length*4];

        buildTree(0, 0, arr.length-1, arr, segmentTree);

        int rangeMax = query(0, 2, 0, 0, arr.length-1, segmentTree);
        System.out.println("rangeMax = " + rangeMax);
    }
}
