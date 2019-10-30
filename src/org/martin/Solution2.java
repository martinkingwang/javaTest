package org.martin;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode last = null;
        boolean isContinue1 = true;
        boolean isContinue2 = true;
        int bigger = 0;
        while(isContinue1 || isContinue2) {
        	int val = bigger;
        	bigger = 0;
        	if(l1 != null) {
        		val += l1.val;
        		l1 = l1.next;
        	}
        	else {
        		isContinue1 = false;
        	}
        	if(l2 != null) {
        		val += l2.val;
        		l2 = l2.next;
        	}
        	else {
        		isContinue2 = false;
        	}
        	if(val > 9) {
        		val -= 10;
        		bigger = 1;
        	}
        	if(result == null) {
        		result = new ListNode(val);
        		last = result;
        	}
        	else {
        		if(isContinue1 || isContinue2) {
        			last.next = new ListNode(val);
        			last = last.next;
        		}
        	}
        }
        return result;
    }
    
    public ListNode toList(long i){
        List<Long> integers = new ArrayList<Long>();
        long pow = 10;
        while(true){
            long j = i % pow;
            integers.add(j);
            i = i / pow;
            if(i == 0)
                break;
        }
        ListNode node = new ListNode(integers.get(0).intValue());
        ListNode last = node;
        boolean isFirst = true;
        for(Long j : integers){
            if(isFirst){
                isFirst = false;
                continue;
            }
            ListNode now = new ListNode(j.intValue());
            last.next = now;
            last = now;
        }
        return node;
    }
}
