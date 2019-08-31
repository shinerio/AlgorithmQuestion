package nowcoder_tree;

import java.util.Stack;

/**
 * @author rui.zhang
 * @Date 2019/8/31
 * @Version 1.0
 */

public class 二叉搜索树的第k小节点 {
    // 中序遍历有序，中序遍历就行，计数，返回第k个
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        while(pRoot!=null || !stack.isEmpty()){
            if(pRoot!=null){
                stack.push(pRoot);
                pRoot = pRoot.left;
            } else{
                pRoot = stack.pop();
                count++;
                if(count == k){
                    return pRoot;
                }
                pRoot = pRoot.right;
            }
        }
        return null;
    }
}
