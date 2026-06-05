package F3_Arrays.F3_Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P2_MajorityEleN3 {
    // Brute
    public static List<Integer> majorityEle(int[] arr) {
        List<Integer> li = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (li.size() == 0 || li.get(0) != arr[i]) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (arr[i] == arr[j])
                        count++;
                }
                if (count == (n / 3) + 1)
                    li.add(arr[i]); // (n/3)+1 because to add only when count is GREATER-THAN n/3
            }
            if (li.size() == 2)
                break;
        }
        return li;
    }

    // Better
    public static List<Integer> majorityEle1(int[] arr) {
        List<Integer> li = new ArrayList<>();
        Map<Integer, Integer> hs = new HashMap<>();
        int n = arr.length;
        int min = (n / 3) + 1;
        for (int i = 0; i < n; i++) {
            hs.put(arr[i], hs.getOrDefault(arr[i], 0) + 1); // 0 because to avoid repeated count of 1st occ by add + 1,
                                                            // as j starts from 0th index
            if (hs.get(arr[i]) == min)
                li.add(arr[i]);
        }
        return li;
    }

    // Optimal  //Boyer–Moore Majority Vote algorithm
    public static List<Integer> majorityEle2(int[] nums) {
        int c1 = 0, ele1 = Integer.MIN_VALUE;
        int c2 = 0, ele2 = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (c1 == 0 && ele2 != nums[i]) {
                ele1 = nums[i];
                c1++;
            } else if (c2 == 0 && ele1 != nums[i]) {
                ele2 = nums[i];
                c2++;
            } else if (ele1 == nums[i])
                c1++;
            else if (ele2 == nums[i])
                c2++;
            else {
                c1--;
                c2--;
            }
        }
        //During the elimination process (c1--, c2--), counts don’t represent the real number of times elements appeared.
        //They’re just “vote balances” used to cancel out non-majority elements.
        //So at the end of the first loop, c1 and c2 are not the actual occurrence counts of ele1 and ele2.
        //So we redo the verification count of both elements only to set correct occurence
        List<Integer> li = new ArrayList<>();
        c1 = 0;
        c2 = 0;
        for (int i : nums) {
            if (ele1 == i)
                c1++;
            if (ele2 == i)
                c2++;
        }
        int min = (n / 3);
        if (c1 > min)
            li.add(ele1);
        if (c2 > min)
            li.add(ele2);

        return li;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 3, 3, 2, 2, 2 };

        System.out.println(majorityEle(nums));
        System.out.println(majorityEle1(nums));
        System.out.println(majorityEle2(nums));
    }
}
