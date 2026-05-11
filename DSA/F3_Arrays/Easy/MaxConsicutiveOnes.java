package Easy;

public class MaxConsicutiveOnes {
    //optimal
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int c=0;
        for(int i : nums){
            if(nums[i]==1){
                c++;
                max = Math.max(max, c); //Important 
            }
            else{
                c=0;
            }
        }
        
        return max;
    }
    
    //Issue for if int[] nums={1,1,1} then else block never executes
    public static int findMaxConsecutiveOnesIssue(int[] nums) {
        int max=0;
        int c=0;
        for(int i : nums){
            if(i == 1){
                c++;
            }
            else{
                if(c > max){
                    max = c;
                }
                c=0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr={0,1,1,0,0,1,1,1,0};
        // int[] arr={0,0,0};
        // int[] arr={1,1,1};
        // System.out.println(findMaxConsecutiveOnesIssue(arr)); 

        System.out.println(findMaxConsecutiveOnes(arr));  


    }
}
//rename this file accordingly in P16_.... form

