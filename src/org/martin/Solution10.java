package org.martin;

import java.util.ArrayList;
import java.util.List;

class Solution10 {
    public boolean isMatch(String s, String p) {
        List<Solution10> patterns = new ArrayList<>();
        Solution10 lastPattern = new Solution10();
        lastPattern.setPattern("");
        for(int i = 0; i < p.length(); i ++){
            char ch = p.charAt(i);
            if(ch == '*'){
                lastPattern.setTimes(-1);
                Solution10 solution = new Solution10();
                solution.setPattern("");
                patterns.add(lastPattern);
                lastPattern = solution;
            }
            else{
                lastPattern.setTimes(1);
                patterns.add(lastPattern);
                Solution10 solution = new Solution10();
                solution.setPattern("" + ch);
                lastPattern = solution;
            }
        }
        if(patterns.size() == 0 || !lastPattern.getPattern().isEmpty()){
            lastPattern.setTimes(1);
            patterns.add(lastPattern);
        }
        return isMatch(s, patterns, 0, -1);
    }

    private boolean isMatch(String str, List<Solution10> patterns, int patternIndex, int strIndex){
        if(patternIndex >= patterns.size()){
            if(strIndex >= str.length()){
                return true;
            }
            else{
                return false;
            }
        }
        if(strIndex >= str.length()){
            boolean isFinished = true;
            for(int i = patternIndex; i < patterns.size(); i ++){
                if(!isMatch("", patterns, i, -1)){
                    isFinished = false;
                    break;
                }
            }
            if(isFinished){
                return true;
            }
            else{
                return false;
            }
        }
        String pattern = "" + patterns.get(patternIndex).getPattern();
        int patternTimes = patterns.get(patternIndex).getTimes();
        if(patternTimes < 0){
            if(strIndex < 0){
                //0 times
                if(isMatch(str, patterns, patternIndex + 1, 0)){
                    return true;
                }
                else{
                    strIndex = 0;
                }
            }
            int length = pattern.length();
            String toMatch = safeSubstring(str, strIndex, strIndex + length);
            if(toMatch == null)
                return false;
            if(pattern.equals(".")){
                char ch = str.charAt(strIndex);
                if(ch - '!' >= 0){
                    if(isMatch(str, patterns, patternIndex, strIndex + 1)){
                        return true;
                    }
                    else{
                        return isMatch(str, patterns, patternIndex + 1, strIndex + 1);
                    }
                }
                else{
                    return isMatch(str, patterns, patternIndex + 1, strIndex);
                }
            }
            else{
                if(toMatch.equals(pattern)){
                    if(isMatch(str, patterns, patternIndex, strIndex + length)){
                        return true;
                    }
                    else{
                        return isMatch(str, patterns, patternIndex + 1, strIndex + length);
                    }
                }
                else{
                    return isMatch(str, patterns, patternIndex + 1, strIndex);
                }
            }
        }
        else{
            if(strIndex < 0 ){
                strIndex = 0;
            }
            if(pattern.equals(".")){

                if(strIndex == str.length()){
                    return false;
                }
                char ch = str.charAt(strIndex);
                if(ch - '!' >= 0){
                    return isMatch(str, patterns, patternIndex + 1, strIndex + 1);
                }
                else{
                    return false;
                }
            }
            else{
                int length = pattern.length();
                String toMatch = "";
                if(length + strIndex >= str.length())
                    toMatch = str.substring(strIndex);
                else
                    toMatch = str.substring(strIndex, strIndex + length);
                if(toMatch.equals(pattern)){
                    return isMatch(str, patterns, patternIndex + 1, strIndex + length);
                }
                else{
                    return false;
                }
            }
        }
    }

    private String safeSubstring(String str, int begin, int end){
        if(end < str.length()){
            return str.substring(begin, end);
        }
        else{
            if(begin < str.length()){
                return str.substring(begin);
            }
            else{
                return null;
            }
        }
    }

    String pattern;
    int times;

    public String getPattern() {
        return this.pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public int getTimes() {
        return this.times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

}