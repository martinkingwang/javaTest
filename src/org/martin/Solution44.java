package org.martin;

import java.util.ArrayList;
import java.util.List;

class Solution44{
    public boolean isMatch(String s, String p) {
        
        return isMatch2(s, p);
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

    private boolean isMatch2(String s, String p){
        int sPos = 0;
        List<String> ps = new ArrayList<>();
        String np = "";
        boolean isAdd = false;
        for(int i = 0; i < p.length(); i ++){
            char ch = p.charAt(i);
            if(ch == '*'){
                if(!np.isEmpty()){
                    ps.add(np);
                    np = "";
                }
                if(!isAdd){
                    ps.add("*");
                    isAdd = true;
                }
            }
            else{
                np += ch;
                isAdd = false;
            }
        }
        if(!np.isEmpty())
            ps.add(np);
        for(int i = 0; i < ps.size(); i ++){
            String pattern = ps.get(i);
            if(i == ps.size() - 1){
                if(!pattern.equalsIgnoreCase("*")){
                    if(pattern.length() > s.length() - sPos){
                        return false;
                    }
                    int skip = match(s, pattern, s.length() - pattern.length(), false);
                    if(skip < 0)
                        return false;
                    else
                        sPos = skip;
                }
                else{
                    sPos = s.length();
                }
            }
            
            else{
                if(i == 0){
                    if(!pattern.equalsIgnoreCase("*")){
                        int skip = match(s, pattern, sPos, false);
                        if(skip < 0)
                            return false;
                        else
                            sPos = skip;
                    }
                }
                else{
                    if(!pattern.equalsIgnoreCase("*")){
                        int skip = match(s, pattern, sPos, true);
                        if(skip < 0)
                            return false;
                        else
                            sPos = skip;
                    }
                }
            }
        }
        return sPos >= s.length();
    }

    private int match(String s, String p, int start, boolean skip){
        if(s.length() - start < p.length())
            return -1;
        if(!skip){
            for(int i = 0; i < p.length(); i ++){
                if(s.charAt(start + i) != p.charAt(i) && p.charAt(i) != '?'){
                    return -1;
                }
            }
            return start + p.length();
        }
        for(int i = start; i < s.length(); i ++){
            boolean found = false;
            for(int j = 0; j < p.length(); j ++){
                if(i + j >= s.length()){
                    return -1;
                }
                if(s.charAt(i + j) != p.charAt(j) && p.charAt(j) != '?'){
                    found = true;
                    break;
                }
            }
            if(!found){
                return i + p.length();
            }
        }
        return -1;
    }
}