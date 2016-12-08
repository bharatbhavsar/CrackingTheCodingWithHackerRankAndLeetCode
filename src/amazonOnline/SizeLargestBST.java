package amazonOnline;
	public class SizeLargestBST 
	{
	    class TreeNode
	    {
	        TreeNode left;
	        TreeNode right;
	        int data;
	    
        public TreeNode(int x)
	        {
	            this.data = x;
	        }
	    }
	
	    TreeNode root;
	
	    private int minimum(int a, int b)
	    {
	        if (a < b) return a;
	        return b;
	    }
	
	    private int maximum(int a, int b)
	    {
	        if (a > b) return a;
	        return b;
	    }
	
	
	     
	    private TreeNode createTree()
	    {
	        this.root = new TreeNode(10);
	        TreeNode n1   = new TreeNode(6);
	        TreeNode n2   = new TreeNode(12);
	        TreeNode n3   = new TreeNode(7);
	        TreeNode n4   = new TreeNode(4);
	        TreeNode n5   = new TreeNode(9);
	        TreeNode n6   = new TreeNode(14);
	        TreeNode n7   = new TreeNode(13);
	        TreeNode n8   = new TreeNode(16);
	        
	        root.left  = n1;
	        root.right = n2;
	        
	        n1.left  = n3;
	        n1.right = n4;
	        
	        n2.left  = n5;
	        n2.right = n6;
	        
	        n6.left = n7;
	        n6.right = n8;
	        
	        return root;
	    }
	     
	    private int findSizeOfLargestBST(TreeNode currentNode, int[] min, int[] max, boolean[] isBST, int[] maxBSTSize)
	    {
	        min[0] = Integer.MAX_VALUE;
	        max[0] = Integer.MIN_VALUE;
	        
	        if (currentNode == null)
	        {
	            isBST[0] = true;
	            return 0;
	        }
	        
	         
	         
	        int leftTreeSize = findSizeOfLargestBST(currentNode.left, min, max, isBST, maxBSTSize);
	        
	         
	        boolean isLeftValid = isBST[0] && (max[0] < currentNode.data);
	
	         
	        int tempMin = minimum(currentNode.data, min[0]);
	        int tempMax = maximum(currentNode.data, max[0]);
	        
	         
	         
	        int rightTreeSize = findSizeOfLargestBST(currentNode.right, min, max, isBST, maxBSTSize);
	        
	         
	        boolean isRightValid = isBST[0] && (currentNode.data < min[0]);
	
	         
	         
	        min[0] = minimum(tempMin, min[0]);
	        max[0] = maximum(tempMax, max[0]);
	        
	         
	        if (isLeftValid && isRightValid)
	        {
	             
	            isBST[0] = true;
	            
	             
	            if ((1 + leftTreeSize + rightTreeSize) > maxBSTSize[0]) 
	            {
	                maxBSTSize[0] = (1 + leftTreeSize + rightTreeSize);
	            }
	            
	            return (1 + leftTreeSize + rightTreeSize);
	        }
	        
	         
	        isBST[0] = false;
	        return -1;
	    }
	    
	    public void findLargestBST(int[] maxBSTSize)
	    {
	        int[] min = new int[1];
	        int[] max = new int[1];
	        
	        boolean[] isBST = new boolean[1];
	        
	        findSizeOfLargestBST(root, min, max, isBST, maxBSTSize);
	    }
	    
	    
	    public static void main(String[] args)
	    {
	        SizeLargestBST solution = new SizeLargestBST();
	
	         
	        solution.createTree();
	
	        int[] maxBSTSize = new int[1];
	
	        solution.findLargestBST(maxBSTSize);
	
	        System.out.println(maxBSTSize[0]);
	    }
	}
