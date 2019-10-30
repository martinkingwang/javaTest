package org.martin;

class Solution14{
    public String longestCommonPrefix(String[] strs) {
        int index = 0;
        boolean continued = true;
        boolean modified = false;
        while(continued){
            char ch = 0;
            boolean same = true;
            for(int i = 0; i < strs.length; i ++){
                if(index >= strs[i].length()){
                    modified = true;
                    break;
                }
                if(i == 0){
                    ch = strs[i].charAt(index);
                }
                else{
                    if(ch != strs[i].charAt(index)){
                        same = false;
                        break;
                    }
                }
            }
            if(!same){
                continued = false;
                break;
            }
            else{
                index ++;
            }
        }
        return strs[0].substring(0, index);
    }
}