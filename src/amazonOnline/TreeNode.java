package amazonOnline;

public class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	public TreeNode(){
		left = null;
		right = null;
		value =0;
	}
	public TreeNode(int value){
		this.value = value;
		this.left = null;
		this.right = null;
	}
	public int height(TreeNode root){
		if(root == null)
			return 0;
		else
			return (Math.max(height(root.left),  height(root.right)) + 1);
	}
}
