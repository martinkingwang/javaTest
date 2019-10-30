package org.martin;

import java.util.HashMap;

class Solution13{
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
        int temp = 0;
        int last = 0;
        for(int i = 0; i < s.length(); i ++){
            char ch = s.charAt(i);
            temp = map.get(ch);
            if(last == 0){
                last = temp;
            }
            else{
                if(last < temp){
                    if(result == 0){
                        result += temp - last;
                    }
                    else{
                        result += temp - last - last;
                    }
                }
                else{
                    if(result == 0)
                        result += last;
                    result += temp;
                }
                last = temp;
            }
        }
        if(result == 0)
            result = temp;
        return result;
    }
}