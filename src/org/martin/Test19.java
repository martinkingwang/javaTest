package org.martin;

public class Test19 implements ITest{

    @Override
    public void run() {
        int[] nums = {1,0,-1,0,-2,2};
        ListNode head = ListNode.build(nums);
        Solution19 solution19 = new Solution19();
        solution19.removeNthFromEnd(head, 3);
    }

}