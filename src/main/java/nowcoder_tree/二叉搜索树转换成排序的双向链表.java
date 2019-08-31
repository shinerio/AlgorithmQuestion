package nowcoder_tree;

/**
 * @author rui.zhang
 * @Date 2019/8/30
 * @Version 1.0
 */

public class 二叉搜索树转换成排序的双向链表 {
    TreeNode tail = null;
    TreeNode head = null;

    /*
     搜索树的中序遍历有序，所以很自然想到需要中序遍历
     问题化简，左右子树转化为双向链表，左子树的尾连接根，根连接右子树的头
     */
    public TreeNode Convert(TreeNode pRootOfTree){
        rotate(pRootOfTree);
        return head;
    }

    public void rotate(TreeNode root) {
        if (root == null) {
            return;
        }
        rotate(root.left);
        root.left = tail;
        if (tail != null) {
            tail.right = root;
        }
        tail = root;
        if (head == null) {
            head = root;
        }
        rotate(root.right);
    }
}
