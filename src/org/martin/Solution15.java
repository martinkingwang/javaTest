package org.martin;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i ++){
            for(int j = nums.length - 1; j >= 0; j --){
                for(int k = i + 1; k < j; k ++){
                    int num = nums[i] + nums[j] + nums[k];
                    if(num == 0 && !contains(results, nums[i], nums[j], nums[k])){
                        List<Integer> result = new ArrayList<>();
                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(nums[k]);
                        results.add(result);
                        break;
                    }
                    else{
                        if(num > 0){
                            break;
                        }
                    }
                }
                if(Math.abs(nums[i] + nums[j]) > nums[nums.length - 1]){
                    break;
                }
            }
        }
        return results;
    }

    private boolean contains(List<List<Integer>> list, int num1, int num2, int num3) {
        List<Integer> temp = new ArrayList<>();
        temp.add(num1);
        temp.add(num2);
        temp.add(num3);
        for (List<Integer> list2 : list) {
            List<Integer> toAdd = new ArrayList<>(temp);
            for (int i : list2) {
                for (int j = 0; j < toAdd.size(); j++) {
                    if (i == toAdd.get(j)) {
                        toAdd.remove(j);
                        j--;
                        break;
                    }
                }
            }
            if (toAdd.isEmpty())
                return true;
        }
        return false;
    }
}