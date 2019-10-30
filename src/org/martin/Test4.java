package org.martin;

class Test4 implements ITest{

    @Override
    public void run() {
        int[] nums1 = {};
        int[] nums2 = {2, 3};
        Solution4 solution4 = new Solution4();
        System.out.println(solution4.findMedianSortedArrays(nums1, nums2));
    }
    
}