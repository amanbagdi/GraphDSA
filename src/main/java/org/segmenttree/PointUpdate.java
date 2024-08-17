package org.segmenttree;

public class PointUpdate {

    public static void updateValueAtIndex(int val, int idx, int i, int l, int r, int[] segmentTree) {
        if (l == r && l == idx) {
            segmentTree[i] = val;
            return;
        }
        int mid = l + (r-l)/2;
        if (idx <= mid) {
            updateValueAtIndex(val, idx, 2*i+1, l, mid, segmentTree);
        } else {
            updateValueAtIndex(val, idx, 2*i+2, mid+1, r, segmentTree);
        }
        segmentTree[i] = segmentTree[2*i+1] + segmentTree[2*i+2];
    }

    public static void buildTree(int i, int l, int r, int[] arr, int[] segmentTree) {
        if (l == r) {
            segmentTree[i] = arr[l];
            return;
        }
        int mid = l + (r-l)/2;

        buildTree(2*i+1, l, mid, arr, segmentTree);
        buildTree(2*i+2, mid+1, r, arr, segmentTree);

        segmentTree[i] = segmentTree[2*i+1] + segmentTree[2*i+2];
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 8};
        int[] segmentTree = new int[arr.length*4];

        buildTree(0, 0, arr.length-1, arr, segmentTree);

        updateValueAtIndex(10, 1, 0, 0, arr.length-1, segmentTree);
        for (int n: segmentTree) {
            if (n!=0)
                System.out.print(n + " ");
        }
    }

}
