/**
 * Link: https://leetcode.com/problems/sum-of-left-leaves/
 * 
 * Find the sum of all left leaves in a given binary tree.

	Example:
	
	    3
	   / \
	  9  20
	    /  \
	   15   7
	
	There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */

package LeetCode;

public class OnlyLeftLeafSum {

	public static void main(String[] args){
		
	}
	
	static int sumOfLeftLeaves(TreeNode root) {
        int res=0;
        if(root==null || (root.left==null && root.right==null)){
            return res;
        }
        if(root.left!=null && (root.left.left==null && root.left.right==null)){
            res+=root.left.val+sumOfLeftLeaves(root.right);
        }else{
            res+=sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
        }
        return res;
    }
}
