package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class PostOrder {
	public List<Integer> postorderRecursive(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
        if (root != null) {
        	list.addAll(postorderRecursive(root.left));
        	list.addAll(postorderRecursive(root.right));
        	list.add(root.val);
        }
        return list;
	}
}
