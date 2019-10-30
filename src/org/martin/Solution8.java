package org.martin;

import java.util.Arrays;

class Solution8 {
    public int myAtoi(String str) {
        long result = 0;
        int pos = 1;
        str = str.trim();
        int maxValue = Integer.MAX_VALUE;
        int minValue = Integer.MIN_VALUE;
        for(int i = 0; i < str.length(); i ++){
            char ch = str.charAt(i);
            if(ch == '-'){
                if(i == 0){
                    pos = -1;
                    continue;
                }
                else{
                    break;
                }
            }
            if(ch == '+'){
                if(i == 0){
                    pos = 1;
                    continue;
                }
                else{
                    break;
                }
            }
            int index = ch - '0';
            if(index > 9 || index < 0){
                break;
            }
            else{
                result *= 10;
                result += index;
            }
            long temp = result * pos;
            if(temp > maxValue){
                return maxValue;
            }
            if(temp < minValue){
                return minValue;
            }
        
        }
        result = result * pos;
        return (int)result;
    }
}