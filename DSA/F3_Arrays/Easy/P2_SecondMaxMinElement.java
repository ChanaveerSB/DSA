package Easy;

// import java.util.Arrays;

public class P2_SecondMaxMinElement {
    public static int secondLargestElement(int[] nums) {
        int n = nums.length;

        if(nums== null || n < 2) //(n==0 || n==1)
            return -1;

        int max=Integer.MIN_VALUE , secMax=Integer.MIN_VALUE;   //{1, 2, 4, 6, 7, 5}

        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                secMax=max;
                max=nums[i];
            } 
            else if(nums[i] > secMax && nums[i] < max) {
                secMax=nums[i];
            }
        }

        if(secMax == Integer.MIN_VALUE) return -1;

        return secMax;

        //normal approach
        // int n=nums.length;
        // Arrays.sort(nums);
        // int max=nums[n-1];
        // int secMax=Integer.MIN_VALUE;
        // for(int j=n-2;j>=0;j++){
        //     if(nums[j] != max) {
        //         secMax=nums[j];
        //         break;
        //     }    
        // }

        // return secMax; 

    }
    public static int secondSmallestElement(int[] nums) {
        int n = nums.length;

        if(nums== null || n < 2) //(n==0 || n==1)
            return -1;

        int min=Integer.MAX_VALUE , secMin=Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            if(nums[i]<min){
                secMin=min;
                min=nums[i];
            } 
            else if(nums[i] < secMin && nums[i] != min) {
                secMin=nums[i];
            }
        }

        if(secMin == Integer.MAX_VALUE) return -1;

        return secMin;

        //normal approach
        // int n=nums.length;
        // Arrays.sort(nums);
        // int min=nums[0];
        // int secMin;
        // for(int j=1;j<n;j++){
        //     if(nums[j] != min) {
        //         secMin=nums[j];
        //         break;
        //     }    
        // }

        // return secMin;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6, 7, 5};
        // int[] nums = {5, 5, 5, 5, 5, 5};

        int smax = P2_SecondMaxMinElement.secondLargestElement(nums);
        int smin = P2_SecondMaxMinElement.secondSmallestElement(nums);

        System.out.println("The second largest element is: " + smax);
        System.out.println("The second smallest element is: " + smin);
    }
}


//normal approach
// Class to solve the problem of finding the second smallest and second largest elements
// class Solution {
//     // Method to find the second smallest and second largest elements in the array
//     public static void getElements(int[] arr, int n) {

//         // Edge case: when the array has less than 2 elements
//         if (n == 0 || n == 1) {
//             System.out.println(-1 + " " + -1);  // Print -1 for both second smallest and second largest
//             return;
//         }

//         // Initialize variables to track the smallest, second smallest, largest, and second largest elements
//         int small = Integer.MAX_VALUE, second_small = Integer.MAX_VALUE;
//         int large = Integer.MIN_VALUE, second_large = Integer.MIN_VALUE;

//         // Find the smallest and largest elements in the array
//         for (int i = 0; i < n; i++) {
//             small = Math.min(small, arr[i]);  // Update the smallest element
//             large = Math.max(large, arr[i]);  // Update the largest element
//         }

//         // Find the second smallest and second largest elements
//         for (int i = 0; i < n; i++) {
//             if (arr[i] < second_small && arr[i] != small) {
//                 second_small = arr[i];  // Update second smallest if a smaller element is found
//             }
//             if (arr[i] > second_large && arr[i] != large) {
//                 second_large = arr[i];  // Update second largest if a larger element is found
//             }
//         }

//         // Output the second smallest and second largest elements
//         System.out.println("Second smallest is " + second_small);
//         System.out.println("Second largest is " + second_large);
//     }
// }

// public class Main {

//     public static void main(String[] args) {

//         // Driver code
//         int n = 6;
//         int[] arr = {1, 2, 4, 6, 7, 5};  // Array of elements

//         // Call the function to find and print the second smallest and second largest elements
//         Solution.getElements(arr, n);
//     }
// }