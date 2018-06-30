package treesAndGraphs;
/**
 * 
 * @author rima_rohan
 *
 Trees: Is This a Binary Search Tree?
			Link: https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/problem


			Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

			The Node class is defined as follows:
			    class Node {
			        int data;
			        Node left;
			        Node right;
			     }
			
 */
public class IsBST {
	
    boolean checkBST(TreeNode root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean checkBST(TreeNode root, int left, int right){
        if(root == null) return true;
        if(root.data >= right || left >= root.data) return false;
        return checkBST(root.left, left, root.data)
            &&checkBST(root.right, root.data, right);
    }

}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
 }
