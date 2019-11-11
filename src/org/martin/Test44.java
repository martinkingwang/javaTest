package org.martin;

import java.util.Date;

class Test44 implements ITest{

    @Override
    public void run() {
        Solution44 solution = new Solution44();
        long start = System.currentTimeMillis();
        System.out.println(solution.isMatch("bbbbbbbabbaabbabbbbaaabbabbabaaabbababbbabbbabaaabaab",
        "b*b*ab**ba*b**b***bba"));
        System.out.println(System.currentTimeMillis() - start);
    }

}