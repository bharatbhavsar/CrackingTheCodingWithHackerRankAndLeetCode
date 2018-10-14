package com.amazonOnline;

public class LowestCommonAncestor {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root!=null)
       {
           if(root.value > p.value && root.value >q.value){
               return lowestCommonAncestor(root.left, p, q);
           }else if(root.value < p.value && root.value < q.value){
               return lowestCommonAncestor(root.right, p, q);
           }
       else {
               return root;
           }
       }
       else 
           return null;
   }
}
