package leetcode_tree;

import java.util.Stack;

/**
 * @author rui.zhang
 * @Date 2019/8/30
 * @Version 1.0
 */

public class IsSymmetric {

    /**
     * 递归，当前节点的左右节点相同且以左右节点为根节点的子树对称
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        if (root.left == null || root.right == null || root.left.val != root.right.val) {
            return false;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    /**
     * 非递归，对左子树按前序遍历，对右子树按中右左遍历，遍历结果一直则对称
     * @param root
     * @return
     */

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();
        while ((leftNode != null || !left.isEmpty()) && (rightNode !=null || !right.isEmpty())) {
            if (leftNode != null && rightNode != null) {
                if (leftNode.val != rightNode.val) {
                    return false;
                }
                if (leftNode.right != null && rightNode.left != null) {
                    left.push(leftNode.right);
                    right.push(rightNode.left);
                    leftNode = leftNode.left;
                    rightNode = rightNode.right;
                } else if (leftNode.right != null || rightNode.left != null){
                    return false;
                } else {
                    leftNode = leftNode.left;
                    rightNode = rightNode.right;
                }
            } else if (leftNode == null && rightNode == null){
                leftNode = left.pop();
                rightNode = right.pop();
            } else {
                return false;
            }
        }
        if (leftNode == null && rightNode == null && left.isEmpty() && right.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }



}
