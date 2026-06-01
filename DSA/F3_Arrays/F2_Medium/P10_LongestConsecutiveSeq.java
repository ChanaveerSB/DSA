package F3_Arrays.F2_Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P10_LongestConsecutiveSeq {
    //Brute
    public static boolean ls(int ele,int[] arr){
        for(int i:arr){
            if(ele == i) return true;
        }
        return false;
    }
    public static int longestConsecutive(int[] nums) {
        int l=1;
        for(int i=0;i<nums.length-1;i++){
            int n=nums[i],c=1;
            while(ls(n+1, nums) == true){
                n=n+1;
                c++;
            }
            if(c>l) l=c;
        }
        return l;
    }

    //better
    public static int longestConsecutiveEle(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);
        int n = nums.length;
        int lastSmaller = Integer.MIN_VALUE;
        int cnt = 0;
        int longest = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 == lastSmaller) {
                cnt += 1;
                lastSmaller = nums[i];
            } else if (lastSmaller != nums[i]) {
                cnt = 1;
                lastSmaller = nums[i];
            }
            longest = Math.max(longest, cnt);
        }
        return longest;
    }

    //optimal
    public static int longestConsecutiveElements(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        //O(N)
        for (int num : nums) {
            set.add(num);
        }

        int longestSequence = 0;

        //N for iterating each element 
        //N for overall inner while for incremental search element
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentNumCount = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentNumCount++;
                }

                if(longestSequence < currentNumCount){
                    longestSequence = currentNumCount;
                }
            }
        }
        return longestSequence;
    }
    //Time complexity : O(N + 2N) = O(3N)
    //Space complexity : O(N)
    public static void main(String[] args) {
        int[] arr={200,1,203,4,202,3,2,7,1,1};

        System.out.println(longestConsecutive(arr));
        System.out.println(longestConsecutiveEle(arr));
        System.out.println(longestConsecutiveElements(arr));

    }
}
