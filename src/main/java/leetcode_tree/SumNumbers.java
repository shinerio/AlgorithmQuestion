package leetcode_tree;

import java.util.ArrayList;

/**
 * @author rui.zhang
 * @Date 2019/8/29
 * @Version 1.0
 */

public class SumNumbers {

    /**
     * 本质就是个前序遍历
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        ArrayList<Integer> all = new ArrayList<>();
        if (root == null) {
            return 0;
        }
        sumNumbers(root, 0, all);
        return all.stream().reduce((a, b)->a+b).get();
    }

    public void sumNumbers(TreeNode root, int value, ArrayList<Integer> all) {
        value = value*10 + root.val;
        if (root.left == null && root.right == null) {
            all.add(value);
            return;
        }
        if (root.left != null) {
            sumNumbers(root.left, value, all);
        }
        if (root.right != null) {
            sumNumbers(root.right, value, all);
        }
    }
}
