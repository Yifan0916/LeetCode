package array;

import java.util.HashMap;

import BinaryTree.TreeNode;

public class ConsBinaryTree_PreInorder {
	/*
	 * Given preorder and inorder traversal of a tree, construct the binary tree.
	 * No duplicate in the tree.
	 * 方法： 假设树的先序遍历是12453687，中序遍历是42516837。这里最重要的一点就是先序遍历可以提供根的所在，
	 * 而根据中序遍历的性质知道根的所在就可以将序列分为左右子树。比如上述例子，我们知道1是根，
	 * 所以根据中序遍历的结果425是左子树，而6837就是右子树。
	 * 接下来根据切出来的左右子树的长度又可以在先序便利中确定左右子树对应的子序列（先序遍历也是先左子树后右子树）。
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length)
            return null;
        TreeNode tree = build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        return tree;
    }
    public TreeNode build(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR) {
        if (preL>preR || inL> inR) return null;
        TreeNode root = new TreeNode(preorder[preL]); //先序排列的第一个元素为root.
        int pos=findPos(inorder, preorder[preL], inL, inR);
        
        root.left=build(preorder, preL+1, pos-inL+preL, inorder, inL, pos-1);
        root.right=build(preorder, pos-inL+preL+1, preR, inorder, pos+1, inR);
        return root;
    }
    public int findPos(int[] inorder, int target, int start, int end) {
        //if (start>end) return -1;
        int pos=-1;
        for (int i=start;i<=end;i++) {
            if (inorder[i]==target) {
            	 pos=i;
                 break;
            }
        }
        return pos;
    }
    
    /*
     * http://blog.csdn.net/linhuanmars/article/details/24389549
     * 上一中做法no extra space,但是遍历很多次inorder.
     * CSDN上做法用Map解决，但是只遍历一次。
     */
    public TreeNode buildTree_Map(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length)
            return null;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();  
        for(int i=0;i<inorder.length;i++)  
        {  
            map.put(inorder[i],i);  
        }
        
        TreeNode tree = build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        return tree;
        //然后 build中POS用： int index = map.get(root.val);  代替。

    }
}
