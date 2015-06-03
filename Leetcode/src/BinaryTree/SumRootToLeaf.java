package BinaryTree;

public class SumRootToLeaf {
	/*
	 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
	 * The root-to-leaf path 1->2 represents the number 12. The root-to-leaf path 1->3 represents the number 13.
	 * Return the sum = 12 + 13 = 25.
	 */
	/*
	 * 目标是把从根到叶子节点的所有路径得到的整数都累加起来，递归条件即是把当前的sum乘以10并且加上当前节点传入下一函数，进行递归，最终把左右子树的总和相加。
	 */
	public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    public int dfs(TreeNode root, int sum) {
        if(root==null) return 0;
        sum=sum*10+root.val;
        if(root.left==null && root.right==null) 
            return sum;
        return dfs(root.left,sum)+dfs(root.right,sum); //每一个子节点的sum是其左右子树之和。 
    }
}
