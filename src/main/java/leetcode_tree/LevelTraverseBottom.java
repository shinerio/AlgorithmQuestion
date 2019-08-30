package leetcode_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author rui.zhang
 * @Date 2019/8/29
 * @Version 1.0
 */

public class LevelTraverseBottom {
    /**
     * 从上到下层序遍历，每一行存一个list，对最后的结果reverse一下
     * @param root
     * @return
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int layerSize = queue.size();
            ArrayList<Integer> layer = new ArrayList<>();
            while (layerSize-- > 0) {
                root = queue.poll();
                layer.add(root.val);
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            ret.add(layer);
        }
        Collections.reverse(ret);
        return ret;
    }
}
