package org.martin;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

class Solution12{
    public String intToRoman(int num) {
        // HashMap<Integer, String> dict = new HashMap<>();
        // dict.put(1, "I");
        // dict.put(5, "V");
        // dict.put(10, "X");
        // dict.put(50, "L");
        // dict.put(100, "C");
        // dict.put(500, "D");
        // dict.put(1000, "M");
        // dict.put(4, "IV");
        // dict.put(9, "IX");
        // dict.put(40, "XL");
        // dict.put(90, "XC");
        // dict.put(400, "CD");
        // dict.put(900, "CM");
        // Set<Integer> intes = dict.keySet();
        // Integer[] ints = new Integer[intes.size()];
        // intes.toArray(ints);
        // Arrays.sort(ints, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        // while(num > 0){
        //     for(int i = 0; i < ints.length; i ++){
        //         if(num >= ints[i]){
        //             num -= ints[i];
        //             sb.append(dict.get(ints[i]));
        //             break;
        //         }
        //     }
        // }
        int count = 1;
        while(num > 0){
            int digit = num % 10;
            if(count == 1){
                switch(digit){
                    case 1:
                    sb.insert(0, "I");
                    break;
                    case 2:
                    sb.insert(0, "II");
                    break;
                    case 3:
                    sb.insert(0, "III");
                    break;
                    case 4:
                    sb.insert(0, "IV");
                    break;
                    case 5:
                    sb.insert(0, "V");
                    break;
                    case 6:
                    sb.insert(0, "VI");
                    break;
                    case 7:
                    sb.insert(0, "VII");
                    break;
                    case 8:
                    sb.insert(0, "VIII");
                    break;
                    case 9:
                    sb.insert(0, "IX");
                    break;
                    default:
                    break;
                }
            }
            if(count == 2){
                switch(digit){
                    case 1:
                    sb.insert(0, "X");
                    break;
                    case 2:
                    sb.insert(0, "XX");
                    break;
                    case 3:
                    sb.insert(0, "XX");
                    break;
                    case 4:
                    sb.insert(0, "XXX");
                    break;
                    case 5:
                    sb.insert(0, "L");
                    break;
                    case 6:
                    sb.insert(0, "LX");
                    break;
                    case 7:
                    sb.insert(0, "LXX");
                    break;
                    case 8:
                    sb.insert(0, "LXX");
                    break;
                    case 9:
                    sb.insert(0, "XC");
                    break;
                    default:
                    break;
                }
            }
            if(count == 3){
                switch(digit){
                    case 1:
                    sb.insert(0, "C");
                    break;
                    case 2:
                    sb.insert(0, "CC");
                    break;
                    case 3:
                    sb.insert(0, "CCC");
                    break;
                    case 4:
                    sb.insert(0, "CD");
                    break;
                    case 5:
                    sb.insert(0, "D");
                    break;
                    case 6:
                    sb.insert(0, "DC");
                    break;
                    case 7:
                    sb.insert(0, "DCC");
                    break;
                    case 8:
                    sb.insert(0, "DCCC");
                    break;
                    case 9:
                    sb.insert(0, "CM");
                    break;
                    default:
                    break;
                }

            }
            if(count == 4){
                for(int i = 0; i < digit; i ++){
                    sb.insert(0, "M");
                }
            }
            num = (num - digit) / 10;
            count ++;
        }
        return sb.toString();
    }
}