/**
 * Invert a binary tree.
	
	     4
	   /   \
	  2     7
	 / \   / \
	1   3 6   9

		to

	     4
	   /   \
	  7     2
	 / \   / \
	9   6 3   1
	
 */


package com.LeetCode;

public class InvertedBinaryTree {

	
	public TreeNode invertTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return root;
        }else{
            if(root.left !=null && root.right == null){
                root.left = invertTree(root.left);
                root.right = root.left;
                root.left = null;
                return root;
            }else if(root.right != null && root.left == null){
                root.right = invertTree(root.right);
                root.left = root.right;
                root.right = null;
                return root;
            }else {
                root.left = invertTree(root.left);
                root.right = invertTree(root.right);
                TreeNode temp = root.right;
                root.right = root.left;
                root.left = temp;
                temp = null;
                return root;
            }
        }
    }
	
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
}
