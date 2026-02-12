package F3_Arrays;

public class P12_MaxLenArrSumK {
    //optimal method

    //normal method
    public static int longestSubarray(int[] nums, int k) {
       int n=nums.length;

       int sum;
       int max=0;   //max lenght of array whose sum is k
       
       //start index subarray always between 0 to n
       for(int i=0;i<n;i++){
        //end index of subarray always between **i** to n
        for(int j=i;j<n;j++){
            sum=0;
            for(int a=i;a<=j;a++){
                sum = sum + nums[a];
            }
            if(sum == k){
                max = Math.max(max , j - i + 1);
            }
        }
       }

       return max;
    }

    public static void main(String[] args) {
        int[] arr={10,5,2,7,1,9};
        int k=15;

        System.out.println(longestSubarray(arr, k));
    }
}
