package BinaryTree;

public class MinDepth {
	 public int minDepth(TreeNode root) {
	        if (root == null) return 0;
	        //No child tree.
	        if (root.left == null && root.right ==null) return 1;
	        else if (root.left == null) {      //In case of     A 
	            return minDepth(root.right)+1;       //    B         C
	        }                                       //                  E
	         else if (root.right == null) {         //    Since C.left=null, so will return the minDepth(E.right).
	            return minDepth(root.left)+1;       //Note: find the FINAL node!
	        }
	        else return Math.min(minDepth(root.left),minDepth(root.right))+1;
	    }
}
