package org.martin;

class Solution4{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        Integer[] middle = null;
        if(totalLength % 2 == 1){
            middle = new Integer[1];
        }
        else{
            middle = new Integer[2];
        }
        boolean continued = true;
        int index1 = 0;
        int index2 = 0;
        if(middle.length == 1){
            index1 = totalLength / 2;
            index2 = -1;
        }
        else{
            index2 = totalLength / 2;
            index1 = index2 - 1;
        }
        if(nums1.length == 0){
            if(index2 == -1){
                return nums2[index1];
            }
            else{
                return ((double)nums2[index1] + (double)nums2[index2]) / 2;
            }
        }
        if(nums2.length == 0){
            if(index2 == -1){
                return nums1[index1];
            }
            else{
                return ((double)nums1[index1] + (double)nums1[index2]) / 2;
            }
        }
        int i = 0, j = 0;
        int last1 = 0;
        int totalIndex = 0;
        while(continued){
            if(nums1[i] <= nums2[j]){
                last1 = nums1[i];
                nums1[i] = Integer.MAX_VALUE;
                i ++;
            }
            else{
                last1 = nums2[j];
                nums2[j] = Integer.MAX_VALUE;
                j ++;
            }
            
            if(totalIndex == index1){
                middle[0] = last1;
            }
            if(totalIndex == index2){
                middle[1] = last1;
            }
            totalIndex ++;
            boolean finished = false;
            for (int k = 0; k < middle.length; k++) {
                if(middle[k] == null){
                    finished = true;
                    break;
                }
            }
            if(!finished){
                continued = false;
            }
            if(i == nums1.length){
                i = nums1.length - 1;
            }
            if(j == nums2.length){
                j = nums2.length - 1;
            }
        }
        double result = 0;
        for(i = 0; i < middle.length; i ++){
            result += middle[i];
        }
        return result / middle.length;
    }
}