package nowcoder_tree;

public class 判断后序是否是搜索二叉树 {
    /**
     * 后序遍历最后一个节点是根节点，然后需要保证所有比他小的树在前面，比他大的树在后面
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verifySequenceOfBST(sequence, 0, sequence.length - 1);
    }

    public boolean verifySequenceOfBST(int [] sequence, int start, int end) {
        if (end <= start) {
            return true;
        }
        int rootVal = sequence[end];
        int leftRoot = start;
        while (leftRoot < end && sequence[leftRoot] <= rootVal) {
            leftRoot++;
        }
        for (int i = leftRoot; i < end; i++)
            if (sequence[i] < rootVal)
                return false;
        return verifySequenceOfBST(sequence, start, leftRoot-1) && verifySequenceOfBST(sequence, leftRoot, end-1);
    }
}
