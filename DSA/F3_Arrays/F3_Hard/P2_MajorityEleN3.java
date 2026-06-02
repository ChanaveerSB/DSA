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

    //Optimal
    

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 3, 3, 2, 2, 2 };

        System.out.println(majorityEle(nums));
        System.out.println(majorityEle1(nums));
    }
}
