package array;

import java.util.HashMap;

import BinaryTree.TreeNode;

public class ConsBinaryTree_InPostorder {
	/*
	 * Given inorder and postorder traversal of a tree, construct the binary tree.
	 */
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length!=postorder.length || inorder.length==0 || postorder.length==0)
            return null;
        HashMap<Integer,Integer> map= new HashMap<Integer,Integer>();
        for (int i=0;i<inorder.length;i++) {
            map.put(inorder[i],i);
        }
        TreeNode tree = build(inorder, 0,inorder.length-1, postorder, 0,postorder.length-1, map);
        return tree;
    }
    public TreeNode build(int[] inorder, int inL, int inR, int[] postorder, int postL, int postR, HashMap<Integer, Integer> map) {
        if (inL>inR || postL>postR)  return null;
        TreeNode root= new TreeNode(postorder[postR]);
        int pos= map.get(postorder[postR]);
        root.left=build(inorder, inL, pos-1,postorder, postL, postR-inR+pos-1, map);
        root.right=build(inorder, pos+1, inR, postorder, postR-inR+pos, postR-1, map);
        return root;
    }
}
