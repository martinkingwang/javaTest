package org.martin;

class Solution61{
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null)
            return head;
        ListNode last = head;
        int count = 1;
        while(last.next != null){
            last = last.next;
            count ++;
        }
        last.next = head;
        int offset = count - k % count;
        ListNode node = head;
        for(int i = 0; i < offset; i ++){
            node = node.next;
        }
        ListNode temp = node;
        for(int i = 1; i < count; i ++){
            temp = temp.next;
        }
        temp.next = null;
        return node;
    }
}