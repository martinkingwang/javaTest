package org.martin;

class Solution5{
    public String longestPalindrome(String s) {
        int maxLength = 0;
        String result = "";
        for(int i = 0; i < s.length(); i ++){
            for(int j = s.length() - i; j > 0; j --){
                String substring = s.substring(i, j + i);
                if(isPalindrome(substring)){
                    if(substring.length() > maxLength){
                        maxLength = substring.length();
                        result = substring;
                        if(maxLength == s.length() - i){
                            return result;
                        }
                    }
                }
            }
        }
        return result;
    }

    public String longestPalindrome2(String s){
        char[] array = s.toCharArray();
        int left = 0;
        int maxLength = 0;
        for(int i = array.length; i > 0; i --){
            for(int j = 0; j < array.length - i + 1; j ++){
                if(isPalindrome(array, j, i)){
                    if(i > maxLength){
                        maxLength = i;
                        left = j;
                    }
                }
            }
        }
        return new String(array, left, maxLength);
    }

    private boolean isPalindrome(char[] array, int start, int length){
        int left = start;
        int right = start + length  - 1;
        while(left <= right){
            if(array[left] == array[right]){
                left ++;
                right --;
            }
            else{
                return false;
            }
        }
        return true;
    }

    private boolean isPalindrome(String str){
        int left = 0;
        int right = str.length() - 1;
        while(left <= right){
            if(str.charAt(left) == str.charAt(right)){
                left ++;
                right --;
            }
            else{
                return false;
            }
        }
        return true;
    }
}