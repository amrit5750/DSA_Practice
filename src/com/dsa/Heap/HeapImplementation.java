package com.dsa.Heap;

public class HeapImplementation {

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(50);
        heap.insert(55);
        heap.insert(53);
        heap.insert(52);
        heap.insert(54);
        heap.print();

        int[] arr = { -1, 54, 53, 55, 52, 50 };
        int n = 5;
        for (int i = arr.length / 2; i > 0; i--) {
            heap.heapifyMax(arr, n, i);

        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }

    }

}

class Heap {

    static int[] arr = new int[100];
    static int size = 0;

    Heap() {
        arr[0] = -1;
        size = 0;
    }

    public void insert(int val) {
        size++;
        int index = size;
        arr[index] = val;

        while (index > 1) {
            int parent = index / 2;

            if (arr[parent] < arr[index]) {
                int temp = arr[parent];
                arr[parent] = arr[index];
                arr[index] = temp;
                index = parent;

            } else {
                return;
            }
        }

    }

    public void print() {
        for (int i = 0; i <= size; i++) {
            System.out.println(arr[i]);
        }
    }

    public void delete() {
        if (size == 0) {
            throw new RuntimeException("heap is empty");
        }

        arr[1] = arr[size];
        size--;
        // take root node to it correct position
        int i = 1;
        while (i < size) {
            int leftindex = 2 * i;
            int righindex = 2 * i + 1;

            if (leftindex < size && arr[i] < arr[leftindex]) {
                int temp = arr[i];
                arr[leftindex] = arr[i];
                arr[i] = temp;
                i = leftindex;

            }
            if (righindex < size && arr[i] < arr[righindex]) {
                int temp = arr[i];
                arr[righindex] = arr[i];
                arr[i] = temp;
                i = righindex;

            } else {
                return;
            }
        }
    }

    public void heapSort(int arr[], int n) {

        // Build max heap
        for (int i = n / 2; i > 0; i--) {
            heapifyMax(arr, n, i);
        }

        // One by one extract elements from heap
        // Move current root to end
        // call max heapify on the reduced heap
        // After this loop the array will be sorted in increasing order
        for (int i = n; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapifyMax(arr, i - 1, 0);
        }
    }

    public void heapifyMax(int arr[], int n, int i) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[largest] < arr[left]) {
            largest = left;
        }
        if (right < n && arr[largest] < arr[right]) {
            largest = right;

        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapifyMax(arr, n, largest);
        }
    }

    public void heapifyMin(int arr[], int n, int i) {

        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[smallest] > arr[left]) {
            smallest = left;
        }
        if (right < n && arr[smallest] > arr[right]) {
            smallest = right;

        }

        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            heapifyMin(arr, n, smallest);
        }

    }

}
