package org.martin;

class Test13 implements ITest{

    @Override
    public void run() {
        Solution13 solution13 = new Solution13();
        int result = solution13.romanToInt("MCMXCIV");
        System.out.println(result);
    }
    
}