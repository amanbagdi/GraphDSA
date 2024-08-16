package org.heaps;


public class BuildMinHeap {

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void minHeapify(int i, int[] arr) {
        int smallest = i;
        if ((2*i+1) < arr.length && arr[2*i+1] < arr[smallest]) smallest = 2*i+1;
        if ((2+i+2) < arr.length && arr[2*i+2] < arr[smallest]) smallest = 2*i+2;

        if (i != smallest)
            swap(arr, i, smallest);

    }

    public static void buildMinHeap(int[] arr) {
        int indexOfParentOfLastNode = ((arr.length-1) - 1)/2 ;
        for (int i=indexOfParentOfLastNode; i>=0; i--) {
            minHeapify(i, arr);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,6,3,4,22,45,24,50,7};

        buildMinHeap(arr);

        for (int n: arr) System.out.print(n + " ");
    }

}
