/**
 * Given a binary tree, determine if it is height-balanced.

	For this problem, a height-balanced binary tree is defined as a binary tree 
	in which the depth of the two subtrees of every node never differ by more than 1.
 */

package com.LeetCode;

public class BinaryBalacedTree {

	public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        
        if(height(root)==-1){
            return false;
        }
        
        return true;
    }
    
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        
        int left = height(root.left);
        int right = height(root.right);
        
        //Check if both left and right subTrees are balanced, else send -1
        if(left==-1 || right==-1){
            return -1;
        }
        
        //check the difference between left and right subTree 
        //and if its more than 1 then send -1
        if(Math.abs(left-right)>1){
            return -1;
        }
        
        //if everything is good, send max height of left or right plus 1
        return Math.max(left, right) + 1;
    }
}
