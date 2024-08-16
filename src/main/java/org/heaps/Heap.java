package org.heaps;

public class Heap {

    int[] arr;
    int size;
    int capacity;

    public Heap(int capacity) {
        this.capacity = capacity;
        arr = new int[this.capacity];
        size=0;
    }

    public int left(int i) {
        return 2*i+1;
    }
    public int right(int i) {
        return 2*i+2;
    }
    public int parent(int i) {
        return (i-1)/2;
    }

}
