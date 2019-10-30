package org.martin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution650 {
	public int minSteps(int n) {
        if(n == 1)
            return 0;
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 2; i < n; i ++){
            if(n % i == 0){
                result.add(minSteps(i) + n / i);
            }
        }
        if(result.size() > 0) {
        	Collections.sort(result);
        	return result.get(0);
        }
        else {
        	return n;
        }
    }
}
