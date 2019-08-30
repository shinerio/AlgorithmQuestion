import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 树的遍历 {

    public void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    public void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + " ");
    }

    public void preOrderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(!stack.isEmpty() || root != null) {
            if (root != null) {
                System.out.print(root.val + " ");
                stack.push(root.right);
                root = root.left;
            } else {
                root = stack.pop();
            }
        }
    }

    public void inOrderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else{
                root = stack.pop();
                System.out.print(root.val + " ");
                root = root.right;
            }
        }
    }

    public void postOrderTraversal2(TreeNode root) {
        Stack<TreeNode> stackTmp = new Stack<TreeNode>();
        Stack<TreeNode> ret = new Stack<TreeNode>();
        while(!stackTmp.isEmpty() || root != null) {
            if (root != null) {
                ret.add(root);
                stackTmp.add(root.left);
                root = root.right;
            } else {
                root = stackTmp.pop();
            }
        }
        while(!ret.isEmpty()) {
            System.out.print(ret.pop().val + " ");
        }
    }

    public void layerTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while ( !queue.isEmpty()) {
            root = queue.poll();
            System.out.print(root.val + " ");
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }
        }
    }

}
