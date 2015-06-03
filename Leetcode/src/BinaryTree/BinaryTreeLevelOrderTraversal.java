package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	/*
	 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(root==null) return res;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        List<Integer> list=new ArrayList<Integer>();
        queue.add(root);
        int num=1;
        int cur=0;
        while(!queue.isEmpty()) {
            TreeNode node=queue.poll();
            num--;
            list.add(node.val);
            if(node.left!=null){
                queue.add(node.left);
                cur++;
            }
            if(node.right!=null){
                queue.add(node.right);
                cur++;
            }
            if(num==0) {
                num=cur;
                cur=0;
                res.add(list);
                list=new LinkedList<Integer>();
            }
        }
        return res;
    }
	/*
	 * II：Bottome order. 
	 * Method 1: DFS
	 */
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> res= new ArrayList<ArrayList<Integer>>();
        dfs(res,root,1);
        return res;
    }
    public void dfs(ArrayList<ArrayList<Integer>> res, TreeNode root, int depth) {
        if(root==null) return;
        ArrayList<Integer> list;
        if(res.size()<depth) {
            list=new ArrayList<Integer>();
            list.add(root.val);
            res.add(0, list);
        } else {
            res.get(res.size()-depth).add(root.val); //Why cannto use res.get(0) directly????
        }
       dfs(res,root.left,depth+1);
       dfs(res, root.right,depth+1);
    }
    
    /*
     * Method 2: BFS
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom_BFS(TreeNode root) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        if(root==null) return res;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        ArrayList<Integer> list=new ArrayList<Integer>();
        queue.add(root);
        int total=1;
        int curNum=0;
        
        while(!queue.isEmpty()) {
            TreeNode node=queue.poll();
            total--;
            list.add(node.val);
            if(node.left!=null) {
                queue.add(node.left);
                curNum++;
            }
            if(node.right!=null) {
                queue.add(node.right);
                curNum++;
            }
            if(total==0) {
                total=curNum;
                curNum=0;
                res.add(0,list);  //或者这里直接用res.add(list); 返回前用 Collections.reverse(res)也有一样的效果。
                list=new ArrayList<Integer>();
            }
        }
        return res;
    }
}
