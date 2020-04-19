package org.martin;

class Solution19{
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        ListNode toDel = null;
        ListNode previous = null;
        int count = 1;
        while(node != null){
            if(count >= n){
                if(toDel == null){
                    toDel = head;
                }
                else{
                    previous = toDel;
                    toDel = toDel.next;
                }
            }
            node = node.next;
            count ++;
        }
        if(previous == null){
            return head.next;
        }
        else{
            previous.next = toDel.next;
            return head;
        }
    }
}