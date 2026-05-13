package F3_Arrays.Easy;

import java.util.Arrays;

public class P5_LeftRotateDPlaces {
    public static void leftRotateDPlace(int[] arr,int d){
        int n=arr.length;

        int[] temp=new int[d];

        for(int i=0;i<d;i++){
            temp[i]=arr[i];
        }
        for(int i=d;i<n;i++){
            arr[i-d]=arr[i];
        }
        for(int i=n-d;i<n;i++){
            arr[i]=temp[i-(n-d)];   //if i=4 in arr then in temp i= i-(n-d) =4-4=0 then 5-4=1 then 6-4=2
        }
    }

    public static void rightRotateDPlace(int[] arr,int d){
        int n=arr.length;

        int[] temp=new int[d];

        // for(int i=n-1;i>=n-d;i--){
        //     temp[(n-1)-i]=arr[i];
        // }
        for(int i=0;i<d;i++){
            temp[i]=arr[n-d+i];
        }
        for(int i=n-d-1;i>=0;i--){
            arr[i+d]=arr[i];
        }
        for(int i=0;i<d;i++){
            arr[i]=temp[i];
        }
    } 

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        int d=3;
        System.out.println(Arrays.toString(arr));
        leftRotateDPlace(arr,d);    //{4,5,6,7,1,2,3}
        System.out.println(Arrays.toString(arr));
        rightRotateDPlace(arr,d);
        System.out.println(Arrays.toString(arr));

    }
}
