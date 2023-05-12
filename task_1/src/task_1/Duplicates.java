package task_1;

public class Duplicates {

    // This method removes duplicates from a character array and returns the new length of the array
    public static int removeDuplicates(char[] arr) {
        // Check if the array is null or empty, return 0 if so
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // Initialize a pointer j to 0
        int j = 0;
        // Iterate over the array starting from index 1
        for (int i = 1; i < arr.length; i++) {
            // If the current character is not equal to the previous character
            if (arr[i] != arr[j]) {
                // Move the pointer j to the next index and set its value to the current character
                j++;
                arr[j] = arr[i];
            }
        }
        // Return the length of the new array (j + 1)
        return j + 1;
    }

    public static void main(String[] args) {
        // Initialize an array with duplicate characters
        char[] arr = {'a', 'a', 'b', 'b', 'c', 'c', 'd', 'd'};
        // Call the removeDuplicates method and get the new length of the array
        int length = removeDuplicates(arr);
        // Iterate over the array up to the new length and print out each character
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
