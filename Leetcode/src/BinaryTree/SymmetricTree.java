package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
	/*
	 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
	 * Method 1: DFS
	 */
	public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
         if(root.left == null && root.right == null)  //这里一定要先进行判断，否则添加进null后21行会出现NullPointer的exception，而且这样34行就不必要了。
            return true;  
         if(root.left == null || root.right == null)  
            return false;  

        Queue<TreeNode> q1= new LinkedList<TreeNode>();
        Queue<TreeNode> q2= new LinkedList<TreeNode>();
        q1.add(root.left);
        q2.add(root.right);
        while(!q1.isEmpty()&&!q2.isEmpty()) {
            TreeNode t1=q1.poll();
            TreeNode t2=q2.poll();
            if(t1.val!=t2.val) return false;
            //if((t1==null&&t2!=null) ||(t1!=null&&t2==null)) return false;
            if((t1.left==null &&t2.right!=null) ||(t1.left!=null &&t2.right==null)) return false;
            if((t1.right==null &&t2.left!=null) ||(t1.right!=null &&t2.left==null)) return false;
            if(t1.left!=null && t2.right!=null) {
                q1.add(t1.left);
                q2.add(t2.right);
            }
            if(t1.right!=null && t2.left!=null) {
                q1.add(t1.right);
                q2.add(t2.left);
            }
        }
        //if((!q1.isEmpty() && q2.isEmpty()) ||(q1.isEmpty() && !q2.isEmpty())) return false;
        return true;
        
    }
	/*
	 * Method 2: Recursive.
	 */
	public boolean isSymmetric_recurse(TreeNode root) {
        if(root==null) return true;
        return dfs(root.left,root.right);
    }
    public boolean dfs(TreeNode t1, TreeNode t2) {
        if(t1==null&& t2==null) return true;
        if(t1==null&&t2!=null || t1!=null&&t2==null) return false;
        return (t1.val==t2.val)&&dfs(t1.left,t2.right)&&dfs(t1.right,t2.left);
        
    }
}
