package F3_Arrays;

import java.util.Arrays;

public class P5_LeftRotateDPlaces {
    public static void leftRotateDPlace(int[] arr,int d){
        int n=arr.length;

        int[] narr=new int[d];

        for(int i=0;i<n;i++){
            if(i<d){
                narr[i]=arr[i];
            }
            else if(i>=n-d){
                arr[i-d]=arr[i];
                arr[i]=narr[i-d-1];
            }
            else{
                arr[i-d]=arr[i]; 
            }    
        }

    }

    public static void rightRotateDPlace(int[] arr,int d){
        int n=arr.length;

        int[] narr=new int[d];

        for(int i=n-1;i>=0;i--){
            if(i>=n-d){
                narr[n-i-1]=arr[i];
            }
            else if(i<d){
                arr[i+d]=arr[i];
                arr[i]=narr[i];
            }
            else{
                arr[i+d]=arr[i];
            }
        }
    } 

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        int d=3;
        System.out.println(Arrays.toString(arr));
        leftRotateDPlace(arr,d);
        System.out.println(Arrays.toString(arr));
        rightRotateDPlace(arr,d);
        System.out.println(Arrays.toString(arr));

    }
}
