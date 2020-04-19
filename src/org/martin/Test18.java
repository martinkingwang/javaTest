package org.martin;

import java.util.Collections;
import java.util.List;

public class Test18 implements ITest {

    @Override
    public void run() {
        Solution18 solution18 = new Solution18();
        int[] nums = {1,0,-1,0,-2,2};
        List<List<Integer>> results = solution18.fourSum(nums, 0);
        print(results);
    }

    private void print(List<List<Integer>> results){
        StringBuilder sb = new StringBuilder();
        for (List<Integer> list : results) {
            sb.append('[');
            for (int i : list) {
                sb.append(i + ",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("],");
        }
        System.out.println(sb.toString());
    }
}