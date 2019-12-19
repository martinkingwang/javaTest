package org.martin;

class Test886 implements ITest{

    @Override
    public void run() {
        int num = 10;
        int[][] dislikes = {{4,7},{4,8},{2,8},{8,9},{1,6},{5,8},{1,2},{6,7},{3,10},{8,10},{1,5},{7,10},{1,10},{3,5},{3,6},{1,4},{3,9},{2,3},{1,9},{7,9},{2,7},{6,8},{5,7},{3,4}};
        Solution886 solution886 = new Solution886();
        System.out.println(solution886.possibleBipartition(num, dislikes));
    }

}