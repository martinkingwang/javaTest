package org.martin;

import java.util.ArrayList;
import java.util.List;

class Solution10 {
    public boolean isMatch(String s, String p) {
        List<Solution10> patterns = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            if (ch == '*') {
                Solution10 solution = patterns.get(patterns.size() - 1);
                solution.setTimes(-1);
            } else {
                Solution10 solution = new Solution10();
                solution.setTimes(1);
                solution.setPattern(ch);
                patterns.add(solution);
            }
        }
        return isMatch(s, patterns, 0, 0);
    }

    private boolean isMatch(String str, List<Solution10> patterns, int patternIndex, int strIndex) {
        if (patternIndex >= patterns.size() && strIndex >= str.length()) {
            return true;
        } else {
            if (strIndex >= str.length()){
                if(patterns.get(patternIndex).getTimes() < 0){
                    return isMatch(str, patterns, patternIndex + 1, strIndex);
                }
                else{
                    return false;
                }
            }
            else{
                if(patternIndex >= patterns.size()){
                    return false;
                }
            }  
        }
        char ch = str.charAt(strIndex);
        if (ch == patterns.get(patternIndex).getPattern() || patterns.get(patternIndex).getPattern() == '.') {
            if (patterns.get(patternIndex).getTimes() < 0) {
                return isMatch(str, patterns, patternIndex, strIndex + 1)
                        || isMatch(str, patterns, patternIndex + 1, strIndex);
            } else
                return isMatch(str, patterns, patternIndex + 1, strIndex + 1);
        } else {
            if (patterns.get(patternIndex).getTimes() < 0) {
                return isMatch(str, patterns, patternIndex + 1, strIndex);
            }
            else{
                return false;
            }
        }
    }


    char pattern;
    int times;

    public char getPattern() {
        return this.pattern;
    }

    public void setPattern(char pattern) {
        this.pattern = pattern;
    }

    public int getTimes() {
        return this.times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    @Override
    public String toString() {
        return "" + pattern + "/" + times;
    }
}