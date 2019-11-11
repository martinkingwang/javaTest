package org.martin;

class Solution44{
    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
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
            return isMatch(s, p, sIndex + 1, pIndex) || isMatch(s, p, sIndex, pIndex + 1);
        }
        else{
            if(pCh == '?'){
                return isMatch(s, p, sIndex, pIndex + 1);
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