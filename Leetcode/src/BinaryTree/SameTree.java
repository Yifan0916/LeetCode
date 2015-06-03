package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
/*
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if((p==null&& q!=null)||p!=null&& q==null) return false;
        Queue<TreeNode> q1=new LinkedList<TreeNode>();
        Queue<TreeNode> q2=new LinkedList<TreeNode>();
        q1.add(p);
        q2.add(q);
        while(!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode n1=q1.poll();
            TreeNode n2=q2.poll();
            if(n1.val!=n2.val) return false;
            if((n1.left==null && n2.left!=null) || (n1.left!=null&&n2.left==null)) return false;
            if((n1.right==null && n2.right!=null) || (n1.right!=null&&n2.right==null)) return false;
            if(n1.left!=null && n1.left!=null) {
                q1.add(n1.left);
                q2.add(n2.left);
            }
            if(n1.right!=null && n1.right!=null) {
                q1.add(n1.right);
                q2.add(n2.right);
            }
            
        }
        return true;
    }
}
