package leetcode_tree;

/**
 * @author rui.zhang
 * @Date 2019/8/29
 * @Version 1.0
 */

public class MaxPathSum {

    /**
     * 本质是个后序遍历，化简子问题，更新节点值为从叶子节点到这个节点的和
     * @param root
     * @return
     */

    int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(-2);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.left = new TreeNode(-1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right = new TreeNode(-3);
        treeNode.right.left = new TreeNode(-2);
        new MaxPathSum().maxPathSum(treeNode);
    }

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int subLeft = root.left == null ? Integer.MIN_VALUE : helper(root.left);
        int subRight = root.right == null ? Integer.MIN_VALUE : helper(root.right);
        int sub = root.val +  Math.max(0, subLeft) + Math.max(0, subRight);
        if (sub > max) {
            max = sub;
        }
        sub = root.val + Math.max(0, Math.max(subLeft, subRight));
        if (sub > max) {
            max = sub;
        }
        return sub;
    }
}
