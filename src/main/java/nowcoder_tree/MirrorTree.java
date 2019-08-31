package nowcoder_tree;

/**
 * @author rui.zhang
 * @Date 2019/8/30
 * @Version 1.0
 */

public class MirrorTree {
    // 前序遍历，交换当前节点左右子树，递归镜像左右子树
    public void Mirror(TreeNode root) {
        if(root!=null){
            switchTree(root);
            Mirror(root.left);
            Mirror(root.right);
        }
    }

    public void switchTree(TreeNode root){
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
    }
}
