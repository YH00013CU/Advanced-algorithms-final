package task_1;

public class duplicates {
    public static int duplicates(char arr[], int n) {
 // If the length of the array is 0 or 1, there can be no duplicates
        if (n == 0 || n == 1) {
            return n;
        }
        // Create a new array to store the unique characters.
        char[] temp = new char[n];
        int j = 0;
        // Iterate over the array, skipping over duplicates.
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                temp[j++] = arr[i];
            }
        }
        // Add the last character to the new array.
        temp[j++] = arr[n - 1];
        // Copy the unique characters from the new array back into the original array.
        for (int i = 0; i < j; i++) {
            arr[i] = temp[i];
        }
        // Return the number of unique characters.
        return j;
    }

    public static void main(String[] args) {
        // Create an array with duplicate characters.
        char arr[] = {'a', 'a', 'b', 'b', 'c', 'c', 'd', 'd'};
        int length = arr.length;
        // Call the duplicates method to remove duplicates and get the new length of the array.
        length = duplicates(arr, length);
        // Print out the unique characters in the array.
        for (int i = 0; i < length; i++)
            System.out.print(arr[i] + " ");
    }
}