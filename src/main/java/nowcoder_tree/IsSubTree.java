package nowcoder_tree;

/**
 * @author rui.zhang
 * @Date 2019/8/30
 * @Version 1.0
 */

public class IsSubTree {

    // 分三种情况考虑，以根节点为根的子树，或者是左子树的子树，或者是右子树的子树
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null||root2==null){
            return false;
        }
        return isSubtree(root1, root2)||HasSubtree(root1.left, root2)||HasSubtree(root1.right, root2);
    }

    public boolean isSubtree(TreeNode root1, TreeNode root2){
        if(root2==null){
            return true;
        }else if(root1==null){
            return false;
        }else if(root1.val!=root2.val){
            return false;
        }
        return isSubtree(root1.left, root2.left)&&isSubtree(root1.right, root2.right);
    }
}
