package leetcode_tree;

import java.util.ArrayList;
import java.util.Stack;

public class PostorderTraversal {

    /**
     * 左右中， 反过来就是中右左，先按中右左的遍历方式存入栈中，挨个出栈即可
     * @param root
     * @return
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> ret = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                ret.push(root);
                if (root.left != null) {stack.push(root.left);}
                root = root.right;
            } else {
                root = stack.pop();
            }
        }
        ArrayList<Integer> nodes = new ArrayList<>();
        while (!ret.isEmpty()) {
            nodes.add(ret.pop().val);
        }
        return nodes;
    }
}
