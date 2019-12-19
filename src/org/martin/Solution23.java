package org.martin;

class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode root = null;
        
        ListNode current = null;
        int index = -1;
        boolean continued = true;
        while (continued) {
            boolean modified = false;
            ListNode min = null;
            for (int i = 0; i < lists.length; i++) {
                ListNode listNode = lists[i];
                if (min == null) {
                    min = listNode;
                    index = i;
                }
                if(listNode == null){
                    continue;
                }
                else{
                    modified = true;
                }
                if (listNode.val < min.val) {
                    min = listNode;
                    index = i;
                }
            }
            if(!modified){
                continued = false;
                break;
            }
            if(root == null){
                root = new ListNode(min.val);
                current = root;
            }
            else{
                current.next = new ListNode(min.val);
                current = current.next;
            }
            lists[index] = min.next;
        }
        return root;
    }

    public ListNode mergeKLists2(ListNode[] lists){
        ListNode root = null;
        ListNode current = null;
        int min = 2147483647;
        int minIndex = -1;
        ListNode[] currents = new ListNode[lists.length];
        for(int i = 0; i < lists.length; i ++){
            currents[i] = lists[i];
        }
        boolean continued = true;
        while(continued){
            continued = false;
            min = Integer.MAX_VALUE;
            for(int i = 0; i < lists.length; i ++){
                if(currents[i] != null && currents[i].val < min){
                    continued = true;
                    minIndex = i;
                    min = currents[i].val;
                }
            }
            if(!continued){
                break;
            }
            if(root == null){
                root = new ListNode(currents[minIndex].val);
                current = root;
            }
            else{
                current.next = new ListNode(currents[minIndex].val);
                current = current.next;
            }
            currents[minIndex] = currents[minIndex].next;
        }
        return root;
    }
}