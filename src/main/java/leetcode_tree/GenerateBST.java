package leetcode_tree;

import java.util.ArrayList;

/**
 * @author rui.zhang
 * @Date 2019/8/30
 * @Version 1.0
 */

public class GenerateBST {

    /**
     * 每个节点都可以做根节点，比他小的树在左子树，大的树在右子树，递归
     * @param n
     * @return
     */
    public ArrayList<TreeNode> generateTrees(int n) {
        return createTree(1, n);
    }

    public ArrayList<TreeNode> createTree(int low, int high) {
        ArrayList<TreeNode> result = new ArrayList<>();
        if (low > high) {
            result.add(null);
            return result;
        }
        for (int i = low; i<=high; i++) {
            ArrayList<TreeNode> left = createTree(low, i-1);
            ArrayList<TreeNode> right = createTree(i+1, high);
            // 左右子树组合
            for (int m = 0; m<left.size(); m++) {
                for(int n = 0; n<right.size(); n++) {
                    TreeNode root = new TreeNode(i);
                    root.left = left.get(m);
                    root.right = right.get(n);
                    result.add(root);
                }
            }
        }
        return result;
    }
}
