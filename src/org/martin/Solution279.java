package org.martin;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class Solution279 {
	
	private Dictionary<Integer, Integer> resultDictionary = new Hashtable<Integer, Integer>();

	public int numSquares(int n) {
		if (n == 1)
			return 1;
		if (n == 0)
			return 0;
		if(resultDictionary.get(n) != null) {
			return resultDictionary.get(n);
		}
		
		int currentSteps = -1;
		for (int i = n; i > 0; i--) {
			if (i * i <= n) {
				int temp = numSquares(n - i * i);
				if(temp <= 1) {
					resultDictionary.put(n, temp + 1);
					return temp + 1;
				}
				if (currentSteps < 0) {
					currentSteps = temp + 1;
				} else {
					if (temp < currentSteps) {
						currentSteps = temp + 1;
					}
				}
			} else {
				continue;
			}
		}
		resultDictionary.put(n, currentSteps);
		return currentSteps;
	}
}
