package org.martin;

class Solution44{
    public boolean isMatch(String s, String p) {
        String np = "";
        char last = 0;
        for(int i = 0; i < p.length(); i ++){
            if(last == 0){
                last = p.charAt(i);
                np += last;
            }
            else{
                if(last != '*' || p.charAt(i) != '*'){
                    np += p.charAt(i);
                    last = p.charAt(i);
                }
            }
        }
        return isMatch(s, np, 0, 0);
    }

    private boolean isMatch(String s, String p, int sIndex, int pIndex){
        if(sIndex >= s.length() && pIndex >= p.length()){
            return true;
        }
        else{
            if(sIndex >= s.length()){
                if(p.charAt(pIndex) == '*'){
                    return isMatch(s, p, sIndex, pIndex + 1);
                }
                else{
                    return false;
                }
            }
            else{
                if(pIndex >= p.length()){
                    return false;
                }
            }
        }
        char pCh = p.charAt(pIndex);
        if(pCh == '*'){
            return isMatch(s, p, sIndex, pIndex + 1) || isMatch(s, p, sIndex + 1, pIndex);
        }
        else{
            if(pCh == '?'){
                return isMatch(s, p, sIndex + 1, pIndex + 1);
            }
            else{
                if(pCh == s.charAt(sIndex)){
                    return isMatch(s, p, sIndex + 1, pIndex + 1);
                }
                else{
                    return false;
                }
            }
        }
    }
}