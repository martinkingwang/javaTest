package org.martin;

class Test12 implements ITest{

    @Override
    public void run() {
        Solution12 solution12 = new Solution12();
        String str = solution12.intToRoman(1994);
        System.out.println(str);
    }
    
}