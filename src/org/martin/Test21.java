package org.martin;

public class Test21 implements ITest{

    @Override
    public void run() {
        int[] nums1 = {1,2,3, 5, 8, 30};
        int[] nums2 = {};
        ListNode head1 = ListNode.build(nums1);
        ListNode head2 = ListNode.build(nums2);
        Solution21 solution21 = new Solution21();
        ListNode node = solution21.mergeTwoLists(head1, head2);
        System.out.println(ListNode.print(node));
    }

}