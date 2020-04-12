package org.martin;

import java.util.List;
import java.util.ArrayList;

class Solution498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return new int[0];
        int[] result = new int[matrix.length * matrix[0].length];
        int count = 0;
        int maxLength = matrix.length > matrix[0].length ? matrix.length : matrix[0].length;
        for(int i = 0; i <= maxLength + maxLength - 1; i ++){
            List<List<Integer>> coridinate = getNextCoridinate(i, matrix.length, matrix[0].length);
            for(List<Integer> cord : coridinate){
                int x = cord.get(0);
                int y = cord.get(1);
                if(x < matrix.length && y < matrix[x].length){
                    result[count] = matrix[x][y];
                    count ++;
                }
            }
        }
        return result;
    }

    private List<List<Integer>> getNextCoridinate(int n, int xLength, int yLength){
        int min = n;
        if(xLength < n){
            n = xLength;
        }
        if(yLength < n){
            n = yLength;
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i <= n; i ++){
            List<Integer> array = new ArrayList<>();
            int x = 0;
            int y = 0;
            if(n % 2 == 0){
                x = n - i;
                y = i;
            }
            else{
                x = i;
                y = n - i;
            }
            array.add(x);
            array.add(y);
            result.add(array);
        }
        return result;
    }
}