package org.martin;

class Solution7 {
    public int reverse(int x) {
        long xl = x;
        int maxValue = Integer.MAX_VALUE;
        int minValue = Integer.MIN_VALUE;
        int count = 0;
        while(true){
            x /= 10;
            count ++;
            if(x == 0){
                break;
            }
        }
        long temp = 0;
        for(int i = 0; i < count / 2; i ++){
            int max = (int)(xl / Math.pow(10, count - i * 2 - 1));
            int min = (int)(xl % 10);
            temp += (long)(min * Math.pow(10, count - i - 1));
            temp += max * Math.pow(10, i);
            if(temp > maxValue || temp < minValue){
                temp = 0;
                xl = 0;
                break;
            }
            xl -= max * (int)Math.pow(10, count - i * 2 - 1);
            xl -= min;
            xl /= 10;
        }
        temp += xl * Math.pow(10, count / 2);
        return (int)temp;
    }
}