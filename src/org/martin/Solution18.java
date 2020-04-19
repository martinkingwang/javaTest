package org.martin;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length < 4) {
            return results;
        }
        Arrays.sort(nums);
        four1(nums, target, results);
        return results;
    }

    private void four1(int[] nums, int target, List<List<Integer>> results) {
        for (int a = 0; a < nums.length; a++) {
            for (int d = nums.length - 1; d > a; d--) {
                int add = target - nums[a] - nums[d];
                int b = a + 1;
                int c = d - 1;
                if(add > nums[d] * 2 || add < nums[a] * 2){
                    continue;
                }
                while (b < c) {
                    int num = nums[b] + nums[c];
                    if (num == add) {
                        if (!contains(results, nums[a], nums[b], nums[c], nums[d])) {
                            List<Integer> result = new ArrayList<>();
                            result.add(nums[a]);
                            result.add(nums[b]);
                            result.add(nums[c]);
                            result.add(nums[d]);
                            results.add(result);
                        }
                        b++;
                        c--;
                    } else if (num > add) {
                        c--;
                    } else {
                        b++;
                    }
                }
            }
        }
    }

    private boolean contains(List<List<Integer>> results, int a, int b, int c, int d) {
        for (List<Integer> list : results) {
            if (list.get(0) == a && list.get(1) == b && list.get(2) == c && list.get(3) == d)
                return true;
        }
        return false;
    }
}