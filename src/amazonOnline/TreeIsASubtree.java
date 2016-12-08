package amazonOnline;
public class TreeIsASubtree {
	TreeNode root;

	TreeIsASubtree() {
		root = null;
	}

	int getSize(TreeNode root) {
		if (root == null)
			return 0;
		else
			return (getSize(root.left) + getSize(root.right) + 1);
	}

	/*
	 * TreeNode largestSubTreeBST(TreeNode root){ TreeIsASubtree t = new
	 * TreeIsASubtree(); int lsize = 0; int rsize = 0; if(root == null) return
	 * root; if(t.isValidBST(root.left)) lsize = t.getSize(root.left);
	 * if(t.isValidBST(root.right)) int rsize = t.getSize(root.right); if() }
	 */
	private TreeNode createBigTree() {
		TreeNode n0 = new TreeNode('0');
		TreeNode n1 = new TreeNode('1');
		TreeNode n2 = new TreeNode('2');
		TreeNode n3 = new TreeNode('3');
		TreeNode n4 = new TreeNode('4');
		TreeNode n5 = new TreeNode('5');
		TreeNode n6 = new TreeNode('6');
		TreeNode n7 = new TreeNode('7');
		TreeNode n8 = new TreeNode('8');

		n0.left = n1;
		n0.right = n2;

		n1.left = n3;
		n1.right = n4;

		n2.left = n5;

		n3.right = n6;

		n5.right = n7;

		n6.right = n8;

		root = n0;
		return n0;
	}

	private TreeNode createSmallTree() {
		TreeNode n1 = new TreeNode('1');
		TreeNode n3 = new TreeNode('3');
		TreeNode n4 = new TreeNode('4');
		TreeNode n6 = new TreeNode('6');
		TreeNode n8 = new TreeNode('8');

		n1.left = n3;
		n1.right = n4;

		n3.right = n6;

		n6.right = n8;

		root = n1;
		return n1;
	}

	private boolean completeMatch(TreeNode bigTreeRoot, TreeNode smallTreeRoot) {
		if ((bigTreeRoot == null) && (smallTreeRoot == null)) {
			return true;
		}

		if ((bigTreeRoot == null) || (smallTreeRoot == null)) {
			return false;
		}

		if (bigTreeRoot.value == smallTreeRoot.value) {
			return completeMatch(bigTreeRoot.left, smallTreeRoot.left)
					&& completeMatch(bigTreeRoot.right, smallTreeRoot.right);
		}

		return false;
	}

	public boolean checkIfSubtree(TreeNode bigTreeRoot, TreeNode smallTreeRoot) {
		if (smallTreeRoot == null) {
			return true;
		}
		if (bigTreeRoot == null) {
			return false;
		}

		if (bigTreeRoot.value == smallTreeRoot.value) {
			if (completeMatch(bigTreeRoot, smallTreeRoot)) {
				return true;
			}
		}

		return checkIfSubtree(bigTreeRoot.left, smallTreeRoot)
				|| checkIfSubtree(bigTreeRoot.right, smallTreeRoot);
	}

	public static void main(String[] args) {
		TreeIsASubtree t = new TreeIsASubtree();
		TreeNode big = t.createBigTree();
		TreeNode small = t.createSmallTree();
		System.out.println(t.checkIfSubtree(big, small));
		int height = big.height(big);
		int size = t.getSize(big);
		System.out.println("Size of the tree " + size);
		System.out.println(height);
	}
}
