package org.martin;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.List;

public class Solution777 {
	Dictionary<Integer, List<Integer>> keysDictionary;
	public boolean canTransform(String start, String end) {
		int i = 0;
		Enumeration<Integer> keys = keysDictionary.keys();
		while (keys.hasMoreElements()) {
			Integer integer = (Integer) keys.nextElement();
			keysDictionary.get(integer);
		}
        return true;
    }
	
}
