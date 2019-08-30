package leetcode_tree;

/**
 * @author rui.zhang
 * @Date 2019/8/30
 * @Version 1.0
 */

public class MaxDepth
{
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left, right);
    }
}
