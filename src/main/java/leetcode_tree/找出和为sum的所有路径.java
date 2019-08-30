package leetcode_tree;

import java.util.ArrayList;

/**
 * @author rui.zhang
 * @Date 2019/8/29
 * @Version 1.0
 */

public class 找出和为sum的所有路径 {

    /**
     * 先序遍历，累加路径值
     */
    ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null){
            return ret;
        }
        pathSum(root, new ArrayList<>(), sum);
        return ret;
    }

    public void pathSum(TreeNode root, ArrayList<Integer> path, int sum) {
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                path.add(root.val);
                ret.add(path);
                return;
            }
        }
        path.add(root.val);

        if (root.left != null) {
            pathSum(root.left, new ArrayList<>(path), sum - root.val);
        }
        if (root.right != null) {
            pathSum(root.right, path, sum - root.val);
        }
    }

}
