package org.martin;

public class Solution669 {
	public TreeNode trimBST(TreeNode root, int L, int R) {
		if(L > R)
			return null;
		if(root.val > R) {
			if(root.left != null)
				return trimBST(root.left, L, R);
			else {
				return null;
			}
		}
		else if(root.val < L) {
			if(root.right != null)
				return trimBST(root.right, L, R);
			else {
				return null;
			}
		}
		else {
			if(root.left != null)
				root.left = trimBST(root.left, L, root.val);
			if(root.right != null)
				root.right = trimBST(root.right, root.val, R);
		}
		return root;
    }
}
