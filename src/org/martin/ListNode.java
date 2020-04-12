package org.martin;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int v) {
		this.val = v;
	}

	@Override
	public String toString(){
		return Integer.toString(val);
	}

	public static ListNode build(int[] vals){
		ListNode root = new ListNode(vals[0]);
		ListNode temp = null;
		for(int i = 1; i < vals.length; i ++){
			if(temp == null){
				temp = new ListNode(vals[i]);
				root.next = temp;
			}
			else{
				temp.next = new ListNode(vals[i]);
				temp = temp.next;
			}
		}
		return root;
	}
}
