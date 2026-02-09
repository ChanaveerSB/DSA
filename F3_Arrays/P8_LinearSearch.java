package F3_Arrays;

public class P8_LinearSearch {
    public static int linearSearch(int[] arr, int v){
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]==v)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,0,6,7,8,9};
        int v=0;
    
        int ind=linearSearch(arr,v);
        System.out.println(v+" is at index number : "+ind);
    }
}
