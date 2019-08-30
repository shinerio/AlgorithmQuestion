package leetcode_tree;

/**
 * @author rui.zhang
 * @Date 2019/8/30
 * @Version 1.0
 */

public class IsValidBST {

    TreeNode pre;
    // 查找树中序遍历有序，记录前节点，比较大小
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isValidBST(root.left)) {
            if (pre != null && pre.val >= root.val) {
                return false;
            }
            pre = root;
            return isValidBST(root.right);
        }else {
            return false;
        }
    }
}
