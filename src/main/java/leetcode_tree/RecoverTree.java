package leetcode_tree;

/**
 * @author rui.zhang
 * @Date 2019/8/30
 * @Version 1.0
 */

public class RecoverTree {

    /**
     * 有两个节点，按中序遍历应该是有序
     * 第一个出错的节点是换成了一个比较大的值，所以在他和他之前的节点满足性质，他之后的不满足，第一个不满足性质的前驱节点即为第一个出错的点
     * 第二个出错的节点换成了一个比较小的值，所以在他之前的没问题，但是到他的时候，比前驱节点小，因此第二个不满足性质的当前节点即为第二个出错的点
     * @param root
     */
    TreeNode pre,wrong1,wrong2 = null;
    public void recoverTree(TreeNode root) {
        notAdjacent(root);
        wrong1.val=wrong2.val^wrong1.val^(wrong2.val=wrong1.val);
    }

    public void notAdjacent(TreeNode t){
        if(t!=null){
            notAdjacent(t.left);
            if (pre != null && t.val <= pre.val){
                if(wrong1==null){
                    wrong1 = pre;
                    wrong2 = t;
                }else{
                    wrong2 = t;
                    return;
                }
            }
            pre = t;
            notAdjacent(t.right);
        }
        return;
    }
}
