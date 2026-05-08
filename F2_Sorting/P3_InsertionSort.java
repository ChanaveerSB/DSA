package F2_Sorting;

import java.util.Arrays;

//takes an element and places in its correct order 
public class P3_InsertionSort {
    static void insertionSort(int[] arr,int n){
        for(int i=0;i<n;i++){
            int j=i;    //to place i pos element in its correct order in selected stack ie from (j>0) 1-ind pos to (j=i) j-ind

            //j>0 so swap till the i element comes at 1-index position. we dont need to swap at 0 index as its swapped correct from 1-index position
            while(j>0 && arr[j-1]>arr[j])   //j>0 because when element arr[j] comes till 1st pos (becoz j--) then it will check with arr[j-1] to swap. So no need to go in 0-ind pos when its swapped from 1-ind pos
            {
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;

                j--;    //main ***** to bring i pos element in right position (backwards by swapping ie pushing elements by 1 pos forward)
            }
        }

        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int[] arr={9,8,6,5,3,1};
        int n=arr.length;
        insertionSort(arr,n);
    }
}

//Time Complexity
//Worst case = O(n^2)
//Avg case = O(n^2)
//Best case = 0(n)
