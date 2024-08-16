package org.heaps;

public class BuildMaxHeap {

    public static void swap(Heap heap, int i, int j) {
        int temp = heap.arr[i];
        heap.arr[i] = heap.arr[j];
        heap.arr[j] = temp;
    }

    public static void maxHeapify(int i, Heap heap) {
        int[] arr = heap.arr;
        int largest = i;
        if (heap.left(i) < arr.length && arr[heap.left(i)] > arr[largest]) largest = heap.left(i);
        if (heap.right(i) < arr.length && arr[heap.right(i)] > arr[largest]) largest = heap.right(i);

        if (i != largest)
            swap(heap, i, largest);

    }
    public static void buildMaxHeap(Heap heap) {
        int parentIndex = heap.parent(heap.size);

        for (int i=parentIndex; i>=0; i--) {
            maxHeapify(i, heap);
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        int[] arr = {10,6,3,4,22,45,24,50,7};
        heap.arr = arr;
        heap.size = arr.length;

        buildMaxHeap(heap);

        for (int n: heap.arr) System.out.print(n + " ");
    }

}
