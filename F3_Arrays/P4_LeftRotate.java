package F3_Arrays;

import java.util.Arrays;

public class P4_LeftRotate {
    public static void leftRotateOnePlace(int[] arr){
        int n=arr.length;

        int temp=arr[0];

        for(int i=1;i<n;i++){
            arr[i-1]=arr[i];
        }

        arr[n-1]=temp;
    }
    //Practice below method logical thinking
    public static void rightRotateOnePlace(int[] arr){
        int n=arr.length;

        int temp=arr[n-1];

        for(int i=n-2;i>=0;i--){
            arr[i+1]=arr[i];
        }

        arr[0]=temp;

    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        System.out.println(Arrays.toString(arr));
        leftRotateOnePlace(arr);
        System.out.println(Arrays.toString(arr));
        rightRotateOnePlace(arr);
        System.out.println(Arrays.toString(arr));

    }
}
