package org.martin;

public class Solution174 {
	public int calculateMinimumHP(int[][] dungeon) {
		int result = calculateMin(dungeon, 0, 0, 0, 0);
		return Math.abs(result) + 1;
    }
	private int currentMax = Integer.MIN_VALUE;
	public int calculateMin(int [][] dungeon, int x, int y, int minHealth, int current) {
		int currentHealth = current + dungeon[x][y];
		if(currentHealth < minHealth)
			minHealth = currentHealth;
		if(minHealth < currentMax)
			return Integer.MIN_VALUE;
		int down = minHealth;
		int right = minHealth;
		if(x < dungeon.length - 1)
			down = calculateMin(dungeon, x + 1, y, minHealth, currentHealth); 
		else {
			if(y < dungeon[0].length - 1)
				down = Integer.MIN_VALUE;
		}
		if(y < dungeon[0].length - 1)
			right = calculateMin(dungeon, x, y + 1, minHealth, currentHealth);
		else {
			if(x < dungeon.length - 1)
				right = Integer.MIN_VALUE;
		}
		int min = Math.max(down, right);
		if(min > currentMax)
			currentMax = min;
		return min;
	}
}
