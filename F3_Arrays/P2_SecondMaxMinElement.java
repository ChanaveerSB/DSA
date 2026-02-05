package F3_Arrays;

public class P2_SecondMaxMinElement {
    public static int secondLargestElement(int[] nums) {
        int n = nums.length;

        if(nums== null || n < 2) //(n==0 || n==1)
            return -1;

        int max=Integer.MIN_VALUE , secMax=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                secMax=max;
                max=nums[i];
            } 
            else if(nums[i] > secMax && nums[i] != max) {
                secMax=nums[i];
            }
        }

        if(secMax == Integer.MIN_VALUE) return -1;

        return secMax;

    }
    public static int secondSmallestElement(int[] nums) {
        int n = nums.length;

        if(nums== null || n < 2) //(n==0 || n==1)
            return -1;

        int min=Integer.MAX_VALUE , secMin=Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            if(nums[i]<min){
                secMin=min;
                min=nums[i];
            } 
            else if(nums[i] < secMin && nums[i] != min) {
                secMin=nums[i];
            }
        }

        if(secMin == Integer.MAX_VALUE) return -1;

        return secMin;

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6, 7, 5};
        // int[] nums = {5, 5, 5, 5, 5, 5};

        int smax = P2_SecondMaxMinElement.secondLargestElement(nums);
        int smin = P2_SecondMaxMinElement.secondSmallestElement(nums);

        System.out.println("The second largest element is: " + smax);
        System.out.println("The second largest element is: " + smin);
    }
}
