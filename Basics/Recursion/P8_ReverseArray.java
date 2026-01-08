package DSA.Basics.Recursion;

import java.util.Arrays;

public class P8_ReverseArray {
    //Method 1
    public static void func(int[] arr,int i,int n){
        if(i>=n) return;

        int t=arr[i];
        arr[i]=arr[n];
        arr[n]=t;

        func(arr,i+1,n-1);
    }
    //Method 2
    public static void func1(int[] arr,int i,int n){
        if(i>=n/2) return;

        int t=arr[i];
        arr[i]=arr[n-i-1];
        arr[n-i-1]=t;

        func1(arr,i+1,n);
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        int n=arr.length-1;
        func(arr,0,n);

        System.out.println(Arrays.toString(arr));
        System.out.println("-----------");

        n=arr.length;
        func1(arr, 0, n);

        for(int k:arr){
            System.out.print(k+" ");
        }
    }
}
