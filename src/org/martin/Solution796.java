package org.martin;

public class Solution796 {
	public boolean rotateString(String A, String B) {
        if(A.length() != B.length()) {
        	return false;
        }
        if(A.equalsIgnoreCase(B)) {
        	return true;
        }
        for (int i = 0; i < A.length(); i++) {
        	int index = i;
        	int time = 0;
			for(int j = 0; j < B.length(); j ++) {
				if(A.charAt(index) == B.charAt(j)) {
					index ++;
				}
				else {
					break;
				}
				if(index == A.length()) {
					index = 0;
					time = 1;
				}
			}
			if(time == 1 && index == i) {
				return true;
			}
		}
        return false;
    }
}
