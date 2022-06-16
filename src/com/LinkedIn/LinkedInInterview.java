/*
 * 
 *
 * 

Problem 1:

    a     |     a
   / \    |    / \
  b   c   |   c   b
 / \      |      / \
d   e     |     e   d    return true


 
    a     |     a
   / \    |    / \
  b   c   |   c   b
 / \      |      / \
d   e     |     e   x    return false (value doesn't match for last node)
  

    a     |     a
   / \    |    / \
  b   c   |   c   b
 / \      |    \   \
d   e     |     e   d    return false
 
class TreeNode {
  TreeNode left;
  TreeNode right;
  String value;
}
  
// Implement the following
boolean isMirror(TreeNode node1, TreeNode node2){
 * 
 * 
 */

package com.LinkedIn;

public class LinkedInInterview {
	
	public static void main(String[] args) {
		
	}
	
	boolean isMirror(TreeNode node1, TreeNode node2) {
		if(node1 != null && node2 == null)
			return false;
		if(node2 != null && node1 == null)
			return false;
		if(node1 == null && node2 == null)
			return true;
		if(node1.value != node2.value)
			return false;
		
		return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left); 
	}

}

class TreeNode {
	TreeNode left;
	TreeNode right;
	String value;
}
