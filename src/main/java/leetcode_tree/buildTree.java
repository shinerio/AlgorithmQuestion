package leetcode_tree;

/**
 * @author rui.zhang
 * @Date 2019/8/29
 * @Version 1.0
 */

public class buildTree {

    public static void main(String[] args) {
        new buildTree().buildTree(new int[] {-1},new int[] {-1});
    }

    /**
     * 从后续遍历入手，后续遍历的最后一个元素是根节点，然后用根节点去中序遍历中将树切分为左右子树，化简子问题，递归
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
       if(inorder == null || postorder == null || inorder.length ==0 || inorder.length != postorder.length) {
           return null;
       }
       return buildTree(inorder, postorder, 0, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int inL, int postL, int postR) {
        if (postL>postR) {
            return null;
        }
        // 根节点
        TreeNode root = new TreeNode(postorder[postR]);
        int leftSize = 0;
        while(inorder[inL + leftSize] != root.val) {
            leftSize++;
        }
        root.left = buildTree(inorder, postorder, inL, postL, postL + leftSize - 1);
        root.right = buildTree(inorder, postorder, inL + leftSize + 1, postL + leftSize, postR-1);
        return root;
    }

    /**
     * 从前序遍历入手，前序遍历第一个是根节点，然后用根节点去中序遍历中切分左右子树
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if(inorder == null || preorder == null || inorder.length ==0 || inorder.length != preorder.length) {
            return null;
        }
        return buildTree2(preorder, inorder, 0, 0, preorder.length - 1);
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder, int inL, int preL, int preR) {
        if (preL > preR) {
            return null;
        }
        // 根节点
        TreeNode root = new TreeNode(preorder[preL]);
        int leftSize = 0;
        while(inorder[inL + leftSize] != root.val) {
            leftSize++;
        }
        root.left = buildTree2(preorder, inorder, inL, preL+1, preL+leftSize);
        root.right = buildTree2(preorder, inorder, inL + leftSize + 1, preL + leftSize + 1, preR);
        return root;
    }

}
