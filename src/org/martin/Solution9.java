package org.martin;

public class Solution9 {
	public boolean isPalindrome(int x) {
        int count = 0;
        int temp = x;
        if(x < 0)
            return false;
        while(temp != 0){
            temp = temp / 10;
            count  ++;
        }
        temp = x;
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = temp % 10;
            temp /= 10;
        }
        for(int i = 0; i < count; i ++){
            if(array[i] != array[count - i - 1]){
                return false;
            }
        }
        return true;
    }
}
