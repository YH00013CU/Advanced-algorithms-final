package adt;

import java.util.Arrays;

public class Task7 {
    
    // Sorts the given array using the heap sort algorithm
    public static void heapSort(int[] arr) {
        // Build a max heap using the array
        buildMaxHeap(arr);
        
        // Extract elements from the max heap in decreasing order and put them at the end of the array
        for (int i = arr.length - 1; i >= 1; i--) {
            // Swap the root (max element) of the heap with the last element of the heap
            swap(arr, 0, i);
            // Restore the max heap property of the remaining elements in the heap
            maxHeapify(arr, i, 0);
        }
    }
    
    // Builds a max heap using the given array
    private static void buildMaxHeap(int[] arr) {
        // Start from the last non-leaf node in the heap and heapify each subtree bottom-up
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, arr.length, i);
        }
    }
    
    // Restores the max heap property of the heap rooted at the given index
    private static void maxHeapify(int[] arr, int heapSize, int index) {
        // Compute the indices of the left and right children of the node at the given index
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        
        // Find the index of the largest element among the node and its children
        int largest = index;
        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }
        
        // If the largest element is not the node itself, swap the node with the largest element
        // and recursively max-heapify the subtree rooted at the largest element
        if (largest != index) {
            swap(arr, index, largest);
            maxHeapify(arr, heapSize, largest);
        }
    }
    
    // Swaps the elements at the given indices in the array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6,100};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
