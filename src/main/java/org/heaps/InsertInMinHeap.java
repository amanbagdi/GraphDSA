package org.heaps;

public class InsertInMinHeap {

    public static void swap(int[] minHeap, int i, int j) {
        int temp = minHeap[i];
        minHeap[i] = minHeap[j];
        minHeap[j] = temp;
    }

    public static void insert(int element, int[] minHeap, int size) {
        if (size < minHeap.length) {
            minHeap[size++] = element;
            int j = size-1;
            int parent = (j - 1)/2 ;
            while(parent >= 0) {
                if (minHeap[j] < minHeap[parent]) {
                    swap(minHeap, j , parent);
                    j = parent;
                    parent = (j-1)/2;
                }
                else break;
            }

        } else {
            System.out.println("Array Full. No place to insert more elements.");
        }
    }

    public static void main(String[] args) {
        int[] minHeap = {3,4,10,6,22,45,24,50,7,0,0,0,0,0,0,0}; // 0 indicate empty places
        int size = 9;
        insert(1, minHeap, size);
        for (int n: minHeap) System.out.print(n + " ");
    }

}
