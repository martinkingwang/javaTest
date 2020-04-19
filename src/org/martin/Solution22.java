package org.martin;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        List<Integer> stack = new ArrayList<>();
        for(int i = 0; i < n * 2; i ++){
            for(int j = 0; j < results.size(); j ++){
                
            }
            if(results.size() == 0){
                results.add("(");
            }
        }
        return results;
    }
}