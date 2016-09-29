/**
 * Given a binary tree, check whether it is a mirror of itself 
 * (i.e., symmetric around its center).

	For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
	
	    1
	   / \
	  2   2
	 / \ / \
	3  4 4  3

	But the following [1,2,2,null,3,null,3] is not:
	    1
	   / \
	  2   2
	   \   \
	   3    3

 */

package LeetCode;

public class SymmetricBinaryTree {

	public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode left, TreeNode right){
        if(left==null && right==null){
            return true;
        }
        if(left==null || right==null){
            return false;
        }
        
        if(left.val != right.val){
            return false;
        }
        
        if(!isSymmetric(left.left, right.right)){
            return false;
        }
        
        if(!isSymmetric(left.right, right.left)){
            return false;
        }
        
        return true;
    }
}
