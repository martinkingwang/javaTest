package org.martin;

class Solution11{
    public int maxArea(int[] height) {
        int max = 0;
        for(int i = 0; i < height.length; i ++){
            for(int j = i + 1; j < height.length; j ++){
                int h = Math.min(height[i], height[j]) * (j - i);
                if(h > max){
                    max = h;
                }
            }
        }
        return max;
    }

    private int maxArea(int[] height, int start, int end){
        return 0;
    }
}
