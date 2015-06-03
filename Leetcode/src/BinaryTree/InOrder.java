package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
 * DFS:深度优先。 只要有左节点，就一路向左往下存。
 * 当到达最后一个node，pop此node的parent，找right存，再找right的左节点，重复上面过程。
 * 总体思路是每到一个节点都先找、存左节点，没有pop出parent，找有节点，再向左找。
 */
public class InOrder {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        
        while(!stack.isEmpty() || node !=null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            }
            else {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;
    }
}
