import java.util.*;

public class countingsort {

    public static void countingSortDescending(int arr[]) {
        // Find the largest element in the array
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }
        
        // Create a count array
        int count[] = new int[largest + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        
        // Sort the array in descending order
        int j = 0;
        for (int i = count.length - 1; i >= 0; i--) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {4, 2, 2, 8, 3, 3, 1};
        
        countingSortDescending(arr);
        
        // Print the sorted array
        System.out.println("Sorted array in descending order:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}


/* imoport java.util.*;
public class CountingSort {

    public static void countingSortAscending(int arr[]) {
        // Find the largest element in the array
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }
        
        // Create a count array
        int count[] = new int[largest + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        
        // Sort the array in ascending order
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {4, 2, 2, 8, 3, 3, 1};
        
        countingSortAscending(arr);
        
        // Print the sorted array
        System.out.println("Sorted array in ascending order:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
} */

