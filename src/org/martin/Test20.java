package org.martin;

public class Test20 implements ITest{

    @Override
    public void run() {
        Solution20 solution20 = new Solution20();
        System.out.println(solution20.isValid("([)]"));
    }

}