package org.martin;

class Test3 implements ITest{

    @Override
    public void run() {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.lengthOfLongestSubstring2("aab"));
    }
    
}