package org.martin;

class Test5 implements ITest{

    @Override
    public void run() {
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.longestPalindrome2("aaas"));
    }

}