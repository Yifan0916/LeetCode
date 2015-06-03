package BinaryTree;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
        //if(root==null) return true;
        //dfs(root);
        return dfs(root)!=-1;
    }
    public int dfs(TreeNode root){
        if(root==null) return 0;
        int left=dfs(root.left);
        int right=dfs(root.right);
        if(Math.abs(left-right)>1||left<0 ||right<0) return -1;
        return 1+Math.max(left,right);
    }
}
