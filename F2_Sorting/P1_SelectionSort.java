package F2_Sorting;

import java.util.Arrays;

public class P1_SelectionSort {
    static void selectionSort(int[] arr,int n){
        int min = 0;
        for(int i=0;i<n-1;i++){
            min = i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            //swap
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int[] arr={2,5,1,3,4};
        int n=arr.length;
        selectionSort(arr,n);
        
    }
}

//Time Complexity
//Worst case = O(n^2)
//Avg case = O(n^2)
//Best case = 0(n^2)

