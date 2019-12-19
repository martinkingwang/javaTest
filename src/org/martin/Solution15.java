package org.martin;

import java.util.ArrayList;
import java.util.List;

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        for(int i = 0; i < nums.length; i ++){
            for(int j = i + 1; j < nums.length; j ++){
                for(int k = j + 1; k < nums.length; k ++){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == 0){
                        if(!contains(results, nums[i], nums[j], nums[k])){
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            results.add(list);
                        }
                    }
                }
            }
        }
        return results;
    }

    private boolean contains(List<List<Integer>> list, int num1, int num2, int num3){
        List<Integer> temp = new ArrayList<>();
        temp.add(num1);
        temp.add(num2);
        temp.add(num3);
        for (List<Integer> list2 : list) {
            List<Integer> toAdd = new ArrayList<>(temp);
            for(int i : list2){
                for(int j = 0; j < toAdd.size(); j ++){
                    if(i == toAdd.get(j)){
                        toAdd.remove(j);
                        j --;
                        break;
                    }
                }
            }
            if(toAdd.isEmpty())
                return true;
        }
        return false;
    }
}