package org.martin;

import java.sql.Date;

public class Solution393 {
	public boolean validUtf8(int[] data) {
		boolean result = true;
		boolean isContinue = true;
		int count = 0;
		while(count < data.length && result) {
			int byteCount = 0;
			int prefix = 0;
			int y = data[count] ^ 128;
			if((y&128) == 128) {
				count ++;
				continue;
			}
			while(((data[count] & 128>>byteCount) == (128>>byteCount)) && byteCount < 7) {
				prefix += 128>>byteCount;
				byteCount ++;
			}
			if(byteCount == 1 || byteCount > 4) {
				result = false;
				break;
			}
			int prefix1 = prefix + (128 >> (byteCount));
			if(((data[count] ^ prefix1) &  (128 >> byteCount)) == (128 >> byteCount)) {
				count ++;
				for(int i = 0; i < byteCount - 1; i ++) {
					if(count + i >= data.length || ((data[count + i] & 128) != 128)) {
						result = false;
						break;
					}
					int x = data[count + i] ^ 64;
					if((x & 64) != 64) {
						result = false;
						break;
					}
				}
				count += byteCount - 1;
			}
			else {
				result = false;
				break;
			}
		}
		return result;
    } 
}
