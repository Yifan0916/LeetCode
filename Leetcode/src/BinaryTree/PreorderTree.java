package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTree {
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null ) return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {  //stack只要不为空，就要继续往下循环并添加左右子树。
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return list;
    }
}
