package F2_Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class P7_QuickSort {
    static int partition(ArrayList<Integer> arr, int low, int high){
        int pivot=arr.get(low);
        int i=low;
        int j=high;

        while(i<j){
    
            while(arr.get(i) <= pivot && i<high)    // while (i <= high - 1 && arr.get(i) <= pivot)
            {
                i++;
            }
            
            while(arr.get(j) > pivot && j>low)    // while (j >= low + 1 && arr.get(j) > pivot)
            {
                j--;
            }
        
            if(i<j){
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }

        int temp = arr.get(j);
        arr.set(j, arr.get(low));
        arr.set(low, temp);

        return j;
    }
    static void quickSort(ArrayList<Integer> arr, int low, int high){
        if(low<high){
            int pIndex=partition(arr, low, high);
            
            quickSort(arr, low, pIndex-1);
            quickSort(arr, pIndex+1, high);
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        arr.addAll(Arrays.asList(9,8,7,6,5,4,3,2,1));
        System.out.println(arr);
        quickSort(arr , 0 , arr.size()-1 );
        System.out.println(arr);

    }
}