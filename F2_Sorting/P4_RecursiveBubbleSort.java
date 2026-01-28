package F2_Sorting;

import java.util.Arrays;

public class P4_RecursiveBubbleSort {
    static void recBubbleSort(int[] arr,int n){
            if(n==1) return;    //because n=arr.length and elements are arr.length-1
        
            boolean didSwap=false;

            for(int j=0;j<n-1;j++)  //j<n-1 because how ever n-i in n-i-1 is similar to n here n-i=len-i and here n=legth-i ie 5,4,3,2,1
            {
                if(arr[j]>arr[j+1]){
                    int t=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=t;
                    didSwap=true;
                }
            }

            if(!didSwap) return;
        
        recBubbleSort(arr, n-1);
    } 
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1};
        int n=arr.length;

        System.out.println(Arrays.toString(arr));

        recBubbleSort(arr,n);

        System.out.println(Arrays.toString(arr));
    }
}
