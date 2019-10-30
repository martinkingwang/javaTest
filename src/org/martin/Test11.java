package org.martin;

class Test11 implements ITest{

    @Override
    public void run() {
        int[] height = {1,8,6,2,5,4,8,3,7};
        Solution11 solution11 = new Solution11();
        int max = solution11.maxArea(height);
        System.out.println(max);
    }

}