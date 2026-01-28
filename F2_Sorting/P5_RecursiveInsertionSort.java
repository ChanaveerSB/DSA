package F2_Sorting;

import java.util.Arrays;

public class P5_RecursiveInsertionSort {
    static void recInsertionSort(int[] arr,int i,int n){
        if(i==n) return;

        int j=i;
        while(j>0 && arr[j-1]>arr[j]){
            int t=arr[j-1];
            arr[j-1]=arr[j];
            arr[j]=t;

            j--;
        }

        recInsertionSort(arr, i+1, n);

    }
    public static void main(String[] args) {
        int[] arr={5,4,3,4,1};
        int n=arr.length;
        recInsertionSort(arr,0,n);

        System.out.println(Arrays.toString(arr));
    }
    
}
