package leetcode_tree;

/**
 * @author rui.zhang
 * @Date 2019/8/29
 * @Version 1.0
 */

public class 任意二叉树ConnectRightBrother {

    /**
     * 层序遍历很直观，但是不是常数空间
     * 和满二叉树的区别在于需要考虑节点缺失的情况，关键是如何找到第一个节点
     * @param
     */
    public void connect(TreeLinkNode root) {
        TreeLinkNode lastLayer = root;
        while(lastLayer != null) {
            // 找当前层的第一个节点
            while(lastLayer != null && lastLayer.left == null && lastLayer.right == null) {
                lastLayer = lastLayer.next;
            }
            if (lastLayer == null){
                return;
            }
            root = lastLayer;
            TreeLinkNode lastNode = null;
            while (root != null) {
                if (root.left != null && root.right != null) {
                    if (lastNode != null) {
                        lastNode.next = root.left;
                    }
                    root.left.next = root.right;
                    lastNode = root.right;
                } else if (root.left != null) {
                    if (lastNode != null) {
                        lastNode.next = root.left;
                    }
                    lastNode = root.left;
                } else if (root.right != null) {
                    if (lastNode != null) {
                        lastNode.next = root.right;
                        lastNode = root.right;
                    }
                    lastNode = root.right;
                }
                root = root.next;
            }
            // 找下一层的第一个节点
           lastLayer = lastLayer.left == null ? lastLayer.right : lastLayer.left;
        }
    }
}
