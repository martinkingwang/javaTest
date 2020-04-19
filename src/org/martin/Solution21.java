package org.martin;

public class Solution21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode current = null;
        ListNode node1 = l1;
        ListNode node2 = l2;
        while (true) {
            if (node1 == null && node2 == null) {
                break;
            }
            if (node1 != null && node2 != null) {
                if (node1.val > node2.val) {
                    if (head == null) {
                        head = new ListNode(node2.val);
                        current = head;
                    } else {
                        current.next = new ListNode(node2.val);
                        current = current.next;
                    }
                    node2 = node2.next;
                } else {
                    if (head == null) {
                        head = new ListNode(node1.val);
                        current = head;
                    } else {
                        current.next = new ListNode(node1.val);
                        current = current.next;
                    }
                    node1 = node1.next;
                }
            } else {
                if(node1 == null){
                    if(head == null){
                        head = new ListNode(node2.val);
                        current = head;
                    }
                    else{
                        current.next = new ListNode(node2.val);
                        current = current.next;
                    }
                    node2 = node2.next;
                }
                else{
                    if (head == null) {
                        head = new ListNode(node1.val);
                        current = head;
                    } else {
                        current.next = new ListNode(node1.val);
                        current = current.next;
                    }
                    node1 = node1.next;
                }
            }
        }
        return head;
    }
}