package org.martin;

public class Solution853 {
	public int carFleet(int target, int[] position, int[] speed) {
        int result = 0;
        while(position.length > 0) {
        	int[] tempPosition = new int[position.length];
        	for(int i =0; i < position.length; i ++) {
        		tempPosition[i] = position[i]+ speed[i];
        	}
        	if(tempPosition[0] > target) {
                for(int i = 1; i < position.length; i ++) {
                	if(tempPosition[i] > tempPosition[0]) {
                		tempPosition[i] = -1;
                	}
                	
                }
        	}
        		
        }

        return result;
    }
	
	private int fleet(int position1, int speed1, int position2, int speed2) {
		int result = -1;
		if((position2 > position1 || speed1 > speed2)|| position1 > position2 && speed2 == speed1) {
			return result;
		}
		else {
			if(position1 == position2)
				return position1;
			result = position1 + (position1 - position2) / (speed2 - speed1);
			return result;
		}
	}
}
