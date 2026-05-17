package Easy;

public class P1_MaxElement {
    public static int findLargestElement(int[] arr, int n) {
        int max = arr[0];  

        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {  
                max = arr[i];
            }
        }

        return max;  // Return the largest element found
    }
    public static void main(String[] args) {
        // Array 1
        int[] arr1 = {2, 5, 1, 3, 0};
        int n = arr1.length;  // Size of the array
        int max = P1_MaxElement.findLargestElement(arr1, n);  // Call the function to find the largest element
        System.out.println("The largest element in the array is: " + max);  // Output the result
    
        // Array 2
        int[] arr2 = {8, 10, 5, 7, 9};
        n = arr2.length;  // Size of the array
        max = P1_MaxElement.findLargestElement(arr2, n);  // Call the function to find the largest element
        System.out.println("The largest element in the array is: " + max);  // Output the result
    }
}
