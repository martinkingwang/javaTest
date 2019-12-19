package org.martin;

class Test15 implements ITest{

    @Override
    public void run() {
        Solution15 solution15 = new Solution15();
        int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        solution15.threeSum(nums);
    }

}