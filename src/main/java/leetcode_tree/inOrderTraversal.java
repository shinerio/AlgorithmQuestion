package leetcode_tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author rui.zhang
 * @Date 2019/8/30
 * @Version 1.0
 */

public class inOrderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> tree = new Stack<>();
        ArrayList<Integer> ret = new ArrayList<>();
        while (root != null || !tree.isEmpty()) {
            if (root != null) {
                tree.push(root);
                root = root.left;
            } else {
                root = tree.pop();
                ret.add(root.val);
                root = root.right;
            }
        }
        return ret;
    }
}
