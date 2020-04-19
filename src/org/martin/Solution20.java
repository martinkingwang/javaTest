package org.martin;

import java.util.Stack;

public class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if(stack.size() == 0)
                    return false;
                char peek = stack.peek();
                if ((peek == '[' && ch == ']') || (peek == '{' && ch == '}') || (peek == '(' && ch == ')')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}