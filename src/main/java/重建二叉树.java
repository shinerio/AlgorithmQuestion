import java.util.HashMap;
import java.util.Map;

/**
 * 根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class 重建二叉树 {
    private Map<Integer, Integer> pos = new HashMap<>();

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre ==null || in == null || pre.length == 0 || in.length == 0 || pre.length != in.length) {
            return null;
        }
        for (int i = 0; i <pre.length ; i++) {
            pos.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, in.length-1, 0);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL){
        if(preL > preR){
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]);
        int leftSize = pos.get(pre[preL]) - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftSize + 1, preR, inL + leftSize + 1);
        return root;
    }
}

