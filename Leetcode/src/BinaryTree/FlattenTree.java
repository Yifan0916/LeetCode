package BinaryTree;

public class FlattenTree {
/*
 * Given a binary tree, flatten it to a linked list in-place.
 * E.g. 1               1   
 *     / \               \
 *    2   5   -->         2  
 *   /                     \
 *  3                       3
 *                           \
 *                            5 
 */
	TreeNode last=null;   //全局变量！！始终维护上一个结束的点。
    public void flatten(TreeNode root) {
        
        if(root==null) return;
        
        TreeNode left=root.left;
        TreeNode right=root.right;
        if(last!=null) { //Not the original root.
            last.left=null;        //始终清空左子树，定义右子树。
            last.right=root;
            
        }
        last=root; 
        flatten(left);
        flatten(right);
    }
}
