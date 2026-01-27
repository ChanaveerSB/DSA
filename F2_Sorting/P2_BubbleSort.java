package F2_Sorting;

import java.util.Arrays;

public class P2_BubbleSort {
    static void bubbleSort(int[] arr,int n){
        for(int i=0;i<n-1;i++){
            int didswap=0;  
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    didswap = 1;
                }
            }
            //if given array is already sorted then didswap == 0 so no need to go through bubble sort it
            if(didswap==0){
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    } 
    public static void main(String[] args) {
        int[] arr={2,5,3,1,4};
        int n=arr.length;
        bubbleSort(arr,n);
    }
}
