package org.segmenttree;

public class RangeUpdateValue_LazyPropagation {

    public static void rangeUpdate(int start, int end, int i, int l, int r, int[] segmentTree, int[] lazy, int value) {
        if (lazy[i] != 0) {
            segmentTree[i] += (r - l + 1) * lazy[i];
            if (l != r) {
                lazy[2*i+1] += lazy[i];
                lazy[2*i+2] += lazy[i];
            }
            lazy[i] = 0;
        }

        if (l > end || r < start) return;
        else if (l >= start && r <= end) {
            segmentTree[i] += (r-l+1) * value;
            if (l != r) {
                lazy[2*i+1] += value;
                lazy[2*i+2] += value;
            }
            return;
        } else {
            int mid = l + (r-l)/2;
            rangeUpdate(start, end, 2*i+1, l, mid, segmentTree, lazy, value);
            rangeUpdate(start, end, 2*i+2, mid+1, r, segmentTree, lazy, value);
            segmentTree[i] = segmentTree[2*i+1] + segmentTree[2*i+2];
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

        segmentTree[i] = segmentTree[2*i+1] + segmentTree[2*i+2];
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 8};
        int[] segmentTree = new int[arr.length*4];
        int[] lazy = new int[arr.length*4];

        buildTree(0, 0, arr.length-1, arr, segmentTree);

        rangeUpdate(0, 2, 0, 0, arr.length-1, segmentTree, lazy, 2);

        System.out.println("Segment Tree");
        for (int n: segmentTree) {
            if (n!=0)
                System.out.print(n + " ");
        }
        System.out.println("Lazy Tree");
        for (int n: lazy) {
            //if (n!=0)
                System.out.print(n + " ");
        }
    }

}
