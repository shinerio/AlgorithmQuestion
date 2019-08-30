package leetcode_tree;

/**
 * @author rui.zhang
 * @Date 2019/8/29
 * @Version 1.0
 */

public class ConnectRightBrother {
    /**
     * 层序遍历很直观，但是不是常数空间
     * 这里的关键点是有一个指向兄弟节点的引用以及是完全二叉树，所以只要存头结点就可以了
     * @param
     */
    public void connect(TreeLinkNode root) {
         if (root == null) {
             return;
         }
         TreeLinkNode lastLayer = root;
         while(lastLayer != null && lastLayer.left != null) {
             root = lastLayer;
             TreeLinkNode lastNode = null;
             while (root != null && root.left != null) {
                 if (lastNode != null) {
                     lastNode.next = root.left;
                 }
                 root.left.next = root.right;
                 lastNode = root.right;
                 root = root.next;
             }
             lastLayer = lastLayer.left;
         }
    }
}
