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
}