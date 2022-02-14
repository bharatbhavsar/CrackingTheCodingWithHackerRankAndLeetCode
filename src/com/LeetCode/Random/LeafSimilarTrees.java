package com.LeetCode.Random;

/*
 * 
 Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.



For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

 

Example 1:


Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
Output: true
Example 2:


Input: root1 = [1,2,3], root2 = [1,3,2]
Output: false
 

Constraints:

The number of nodes in each tree will be in the range [1, 200].
Both of the given trees will have values in the range [0, 200]
 * 
 */

import java.util.*;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class LeafSimilarTrees {
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> t1 = new ArrayList<Integer>();
        ArrayList<Integer> t2 = new ArrayList<Integer>();
        t1 = getLeafListSeq(t1, root1);
        t2 = getLeafListSeq(t2, root2);
        if(t1.size() != t2.size())
            return false;
        System.out.println(t1.size());
        System.out.println(t2.size());
        System.out.println(t1);
        System.out.println(t2);
        for(int i = 0; i < t1.size(); i++){
            if(t1.get(i) != t2.get(i))
                return false;
        }
        return true;
    }
    
    ArrayList<Integer> getLeafListSeq(ArrayList<Integer> t, TreeNode root){
        if(root == null)
            return t;
        if(root.left == null && root.right == null){
            t.add(root.val);
        }
        if(root.left != null)
            t = getLeafListSeq(t, root.left);
        if(root.right != null)
            t = getLeafListSeq(t, root.right);
        return t;
    }
}
