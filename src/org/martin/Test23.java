package org.martin;

class Test23 implements ITest{

    @Override
    public void run() {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(1);
        node2.next.next = new ListNode(2);
        ListNode[] nodes = new ListNode[2];
        nodes[0] = node1;
        nodes[1] = node2;

        Solution23 solution = new Solution23();
        ListNode node = solution.mergeKLists(nodes);
        System.out.println(printListNode(node));
    }

    private String printListNode(ListNode node){
        StringBuilder sb = new StringBuilder();
        ListNode temp = node;
        while(temp.next != null){
            sb.append(node.val + "->");
            temp = temp.next;
        }
        return sb.toString();
    }
}