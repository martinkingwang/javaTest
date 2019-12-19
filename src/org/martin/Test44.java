package org.martin;

import java.util.Date;

class Test44 implements ITest{

    @Override
    public void run() {
        Solution44 solution = new Solution44();
        long start = System.currentTimeMillis();
        System.out.println(solution.isMatch("aa",
        "a"));
        System.out.println(System.currentTimeMillis() - start);
    }

}