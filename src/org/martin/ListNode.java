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
}
