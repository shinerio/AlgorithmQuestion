package leetcode_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author rui.zhang
 * @Date 2019/8/30
 * @Version 1.0
 */

public class ZTraverse {

    /**
     * 层序遍历，隔层reverse，双重循环，外重循环遍历层数，内层循环遍历当前层
     * @param root
     * @return
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> tree = new LinkedList<>();
        tree.offer(root);
        boolean leftToRight = true;
        while (!tree.isEmpty()) {
            int layerSize = tree.size();
            ArrayList<Integer> layer = new ArrayList<>();
            while (layerSize-- > 0) {
                root = tree.poll();
                layer.add(root.val);
                if (root.left != null) {
                    tree.offer(root.left);
                }
                if (root.right != null) {
                    tree.offer(root.right);
                }
            }
            if (!leftToRight){
                Collections.reverse(layer);
            }
            leftToRight = !leftToRight;
            ret.add(layer);
        }
        return ret;
    }
}
