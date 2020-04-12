package org.martin;

class Solution19{
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        int count = 0;
        while(node != null){
            count ++;
            node = node.next;
        }
        node = head;
        ListNode previous = null;
        for(int i = 0; i < count- n; i ++){
            previous = node;
            node = node.next;
        }
        previous.next = node.next;
        return head;
    }
}