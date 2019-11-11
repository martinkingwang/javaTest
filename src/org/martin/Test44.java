package org.martin;

class Test44 implements ITest{

    @Override
    public void run() {
        Solution44 solution = new Solution44();
        System.out.println(solution.isMatch("aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba",
        "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*"));
    }

}