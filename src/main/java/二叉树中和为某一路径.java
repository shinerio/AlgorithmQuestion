import java.util.ArrayList;
import java.util.Arrays;

public class 二叉树中和为某一路径 {

        public static void main(String[] args) {
            TreeNode tree = new TreeNode(1);
            tree.left = new TreeNode(4);
            tree.right = new TreeNode(2);
            tree.right.left = new TreeNode(2);
            ArrayList<ArrayList<Integer>> all = new 二叉树中和为某一路径().FindPath(tree, 5);
        }

        private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
        private ArrayList<Integer> list = new ArrayList<Integer>();
        public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
            if(root == null) return listAll;
            list.add(root.val);
            target -= root.val;
            if(target == 0 && root.left == null && root.right == null)
                listAll.add(new ArrayList<Integer>(list));
            FindPath(root.left, target);
            FindPath(root.right, target);
            list.remove(list.size()-1);
            return listAll;
        }
}
