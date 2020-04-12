package org.martin;

class Solution28{
    public int strStr(String haystack, String needle) {
        for(int i = 0; i < haystack.length(); i ++){
            boolean found = true;
            for(int j = 0; j < needle.length(); j ++){
                if(haystack.length() <= i + j || haystack.charAt(i + j) != needle.charAt(j)){
                    found = false;
                    break;
                }
            }
            if(found){
                return i;
            }
        }
        return -1;
    }
}