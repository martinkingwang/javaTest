package org.martin;

import java.util.ArrayList;
import java.util.List;

public class Solution89 {
	public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        if(n == 0){
            result.add(0);
            return result;
        }
        if(n == 1){
            result.add(0);
            result.add(1);
            return result;
        }
        List<Integer> g = grayCode(n - 1);
        List<Integer> h = new ArrayList<Integer>();
        for(int i = 0; i < g.size(); i ++){
            int j = g.get(i);
            j = generate(j, 0, n);
            h.add(j);
        }
        for(int k = 0; k < g.size(); k ++){
            int j = g.get(g.size() - k - 1);
            j = generate(j, 1, n);
            h.add(j);
        }
        return h;
    }
	
    public int generate(int origin, int prefix, int n){
        return origin + (prefix << (n - 1));
    }
}
