package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P7_MoveZeroesToEnd {
    //optimal
    public static void moveZeroesToEnd(int[] arr){
        int n=arr.length;
        int i=-1;
        for(int j=0;j<n;j++){
            if(arr[j]==0){
                i=j;
                break;
            }
        }
        if(i==-1) return;
        for(int j=i+1;j<n;j++){
            if(arr[j]!=0){  //arr[i]==0 checking not need because i will always point to zero valued index 
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
            }
        }
    }
    //normal - BruteForce
    public static void moveZerosEnd(int[] arr){
        int n=arr.length;

        List<Integer> temp=new ArrayList<>();
        for(int i : arr){
            if(i!=0){
                temp.add(i);
            }
        }
        int nz=temp.size();
        for(int i=0;i<nz;i++){
            arr[i]=temp.get(i);
        }
        //below start with nz and not nz-1 because we added non zero values till lessthan < nz in above loop so from nz index we have to start adding 0
        for(int i=nz;i<n;i++){
            arr[i]=0;
        }
    }
    public static void main(String[] args) {
        int[] arr={0,1,4,0,0,2,3,0,7,9,5,0,1,0,0};

        System.out.println(Arrays.toString(arr));
        moveZeroesToEnd(arr);
        System.out.println(Arrays.toString(arr));
        // moveZerosEnd(arr);
        // System.out.println(Arrays.toString(arr));
    }
}
