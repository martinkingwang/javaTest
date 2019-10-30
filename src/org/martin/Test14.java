package org.martin;

class Test14 implements ITest{

    @Override
    public void run() {
        String[] strs = {"flower","flow","flight"};
        Solution14  solution14 = new Solution14();
        System.out.println(solution14.longestCommonPrefix(strs));
    }

}