package org.martin;

class Test61 implements ITest{

    @Override
    public void run() {
        int[] vals = {1,2,3,4,5};
        ListNode node = ListNode.build(vals);
        Solution61 solution61 = new Solution61();
        solution61.rotateRight(node, 2);
    }

}