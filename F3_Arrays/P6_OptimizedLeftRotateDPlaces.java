package F3_Arrays;

import java.util.Arrays;

public class P6_OptimizedLeftRotateDPlaces {
    public static void reverse(int[] arr,int s,int e){
        //Check how s and e are used inside a part of the array
        while(s<e){
            int temp=arr[s];
            arr[s]=arr[e];
            arr[e]=temp;
            s++;
            e--;
        }
    }

    public static void leftRotateDPlace(int[] arr,int d){
        int n=arr.length;

        // int[] temp=new int[d];

        reverse(arr,0,d-1);
        reverse(arr,d,n-1);
        reverse(arr,0,n-1);
    }

    public static void rightRotateDPlace(int[] arr,int d){
        int n=arr.length;

        // int[] temp=new int[d];

        reverse(arr,n-d,n-1);
        reverse(arr,0,n-d-1);
        reverse(arr,0,n-1);
    } 
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        int d=3;
        // reverse(arr, 3, 7-1);
        
        System.out.println(Arrays.toString(arr));
        leftRotateDPlace(arr,d);
        System.out.println(Arrays.toString(arr));
        rightRotateDPlace(arr,d);
        System.out.println(Arrays.toString(arr));

    }
}
