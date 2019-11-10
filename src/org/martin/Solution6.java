package org.martin;

import java.util.ArrayList;
import java.util.List;

class Solution6 {
    public String convert(String s, int numRows) {
        List<char[]> array = new ArrayList<char[]>();
        int currentPos = 0;
        char[] temp = new char[numRows];
        boolean added = false;
        for(int i = 0; i < s.length(); i ++){
            if(currentPos < numRows){
                temp[currentPos] = s.charAt(i);
                currentPos ++;
                added = false;
                if(currentPos == numRows){
                    array.add(temp);
                    temp = new char[numRows];
                    added = true;
                }
            }
            else{
                int row = numRows * 2 - currentPos - 2;
                if(row <= 0){
                    added = false;
                    temp[0] = s.charAt(i);
                    currentPos = 1;
                    if(currentPos == numRows){
                        array.add(temp);
                        temp = new char[numRows];
                        added = true;
                    }
                }
                else{
                    temp[row] = s.charAt(i);
                    array.add(temp);
                    temp = new char[numRows];
                    currentPos ++;
                    added = false;
                }
            }
        }
        if(!added)
            array.add(temp);
        String str = "";
        for(int i = 0; i < numRows; i ++){
            for (char[] var : array) {
                if(var[i] != 0){
                    str += var[i];
                }
            }
        }
        return str;
    }

    public String convert2(String s, int numRows){
        if(numRows <= 1)
            return s;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numRows; i ++){
            for(int j = 0; j * 2 * (numRows - 1) + i< s.length(); j ++){
                int count = j * 2 * (numRows - 1) + i;
                sb.append(s.charAt(count));
                int count2 = (j + 1) * 2 * (numRows - 1) - i;
                if(count2 < s.length() && count2 != count && (count2 - count) % (2 * (numRows - 1)) != 0){
                    sb.append(s.charAt(count2));
                }
            }
        }
        return sb.toString();
    }
}