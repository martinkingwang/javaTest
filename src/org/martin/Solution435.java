package org.martin;

public class Solution435 {
	public int eraseOverlapIntervals(int[][] intervals) {
        int result = 0;
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for(int i = 0 ; i < intervals.length; i ++) {
        	if(intervals[i][0] < start) {
        		start = intervals[i][0];
        	}
        	if(intervals[i][1] > end) {
        		end = intervals[i][1];
        	}
        }
        return result;
    }
}
