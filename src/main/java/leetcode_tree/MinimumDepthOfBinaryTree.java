package leetcode_tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {
    public int run(TreeNode root) {
        //树的遍历分为前序、中序、后序、层序；使用层序遍历找到第一个没有子节点的节点，当前层数即为最小深度
        Queue<TreeNode> nodes = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        int depth = 0;
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            int layerSize = nodes.size();
            depth++;
            while (layerSize-- > 0) {
                root = nodes.poll();
                if (root.left == null && root.right == null) {
                    return depth;
                }
                if (root.left != null) {
                    nodes.offer(root.left);
                }
                if (root.right != null) {
                    nodes.offer(root.right);
                }
            }
        }
        return depth;
    }
}
