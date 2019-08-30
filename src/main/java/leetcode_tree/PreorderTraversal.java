package leetcode_tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author rui.zhang
 * @Date 2019/8/29
 * @Version 1.0
 */

public class PreorderTraversal {

    /**
     * 中左右，先遍历中，将右入栈记录，然后指向左
     * @param root
     * @return
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> ret = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                ret.add(root.val);
                if (root.right != null) {
                    stack.push(root.right);
                }
                root = root.left;
            } else {
                root = stack.pop();
            }
        }
        return ret;
    }
}
