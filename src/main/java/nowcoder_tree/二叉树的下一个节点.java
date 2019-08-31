package nowcoder_tree;

/**
 * @author rui.zhang
 * @Date 2019/8/31
 * @Version 1.0
 */

public class 二叉树的下一个节点 {
    /**
     * 若给定节点存在右子树，那么下一个节点是右子树的最左节点
     * 否则，如果是父节点的左子节点，那么返回父节点，
     * 否则，将当父节点作为当前节点，重复当前操作
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            pNode = pNode.right;
            while(pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        while (pNode.next != null) {
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }
}
