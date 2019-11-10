package org.martin;

class Test10 implements ITest{

    @Override
    public void run() {
        Solution10 solution10 = new Solution10();
        //System.out.println(solution10.isMatch("bbbbbb", ".*.a*aab*b"));
        System.out.println(solution10.isMatch("aab","c*a*b"));
    }
    
}