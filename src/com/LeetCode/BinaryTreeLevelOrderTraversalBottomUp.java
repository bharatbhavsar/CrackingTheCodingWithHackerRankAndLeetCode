/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' 
 * values. (ie, from left to right, level by level from leaf to root).

	For example:
	Given binary tree [3,9,20,null,null,15,7],
	    3
	   / \
	  9  20
	    /  \
	   15   7

	return its bottom-up level order traversal as:
	[
	  [15,7],
	  [9,20],
	  [3]
	]
 */

package com.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeLevelOrderTraversalBottomUp {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(root == null){
            return result;
        }
        
        
        ArrayList<TreeNode> currentNode = new ArrayList<TreeNode>();
        
        ArrayList<TreeNode> childNode = new ArrayList<TreeNode>();
        
        currentNode.add(root);
        
        while(currentNode.size()!=0){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int i=0; i<currentNode.size(); i++){
                temp.add(currentNode.get(i).val);
                if(currentNode.get(i).left!=null){
                    childNode.add(currentNode.get(i).left);
                }
                if(currentNode.get(i).right!=null){
                    childNode.add(currentNode.get(i).right);
                }
                
            }
            result.add(temp);
            currentNode.clear();
            currentNode.addAll(childNode);
            childNode.clear();
        }
        
        Collections.reverse(result);
        return result;
    }
}
