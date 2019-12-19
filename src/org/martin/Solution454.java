package org.martin;

import java.util.HashMap;

class Solution454{
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        HashMap<Integer, Integer> ab = new HashMap<>();
        for(int i = 0; i < A.length; i ++){
            for(int j = 0; j < B.length; j ++){
                if(ab.containsKey(A[i] + B[j])){
                    ab.put(A[i] + B[j], ab.get(A[i] + B[j]) + 1);
                }
                else{
                    ab.put(A[i] + B[j], 1);
                }
            }
        }
        for(int i = 0; i < C.length; i ++){
            for(int j = 0; j < D.length; j ++){
                if(ab.containsKey(0 - (C[i] + D[j]))){
                    count += ab.get(0 - (C[i] + D[j]));
                }
            }
        }
        return count;
    }
}