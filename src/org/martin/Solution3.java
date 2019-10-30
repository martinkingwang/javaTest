package org.martin;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;
import java.util.Map.Entry;

class Solution3{
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int maxLength = 0;
        boolean continued = true;
        Hashtable<Character, Integer> array = new Hashtable<>();
        for(int i = length; i > 0 && continued; i --){
            for(int j = 0; (j <= s.length() - i) && continued; j ++){
                String toMatch = s.substring(j, j + i);
                array.clear();
                boolean isFound = false;
                for(int k = 0; k < i && !isFound; k ++){
                    char chk = toMatch.charAt(k);
                    if(array.containsKey(chk)){
                        isFound = true;
                        break;
                    }
                    else{
                        array.put(chk, k);
                    }
                }
                if(!isFound){
                    maxLength = i;
                    continued = false;
                    break;
                }
            }
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring2(String str){
        int maxLength = 0;
        Hashtable<Character, Integer> array = new Hashtable<>();
        for(int i = 0; i < str.length(); i ++){
            array.clear();
            for(int j = i; j < str.length(); j ++){
                char ch = str.charAt(j);
                if(array.containsKey(ch) && array.get(ch) != j){
                    int length = j - i;
                    if(length > maxLength)
                        maxLength = length;
                    break;
                }
                else{
                    array.put(ch, j);
                }
            }
            if(array.size() == str.length() - i){
                if(array.size() > maxLength)
                    maxLength = array.size();
            }
        }
        if(maxLength == 0 && array.size() > 0)
            maxLength = 1;
        return maxLength;
    }
}